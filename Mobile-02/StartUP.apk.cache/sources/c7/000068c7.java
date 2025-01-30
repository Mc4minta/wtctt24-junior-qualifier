package org.spongycastle.pqc.crypto.rainbow;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageSigner;
import org.spongycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;

/* loaded from: classes3.dex */
public class RainbowSigner implements MessageSigner {
    private ComputeInField cf = new ComputeInField();
    RainbowKeyParameters key;
    private SecureRandom random;
    int signableDocumentLength;
    private short[] x;

    private short[] initSign(Layer[] layerArr, short[] sArr) {
        short[] sArr2 = new short[sArr.length];
        short[] multiplyMatrix = this.cf.multiplyMatrix(((RainbowPrivateKeyParameters) this.key).getInvA1(), this.cf.addVect(((RainbowPrivateKeyParameters) this.key).getB1(), sArr));
        for (int i2 = 0; i2 < layerArr[0].getVi(); i2++) {
            this.x[i2] = (short) this.random.nextInt();
            short[] sArr3 = this.x;
            sArr3[i2] = (short) (sArr3[i2] & 255);
        }
        return multiplyMatrix;
    }

    private short[] makeMessageRepresentative(byte[] bArr) {
        int i2 = this.signableDocumentLength;
        short[] sArr = new short[i2];
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            sArr[i3] = bArr[i4];
            sArr[i3] = (short) (sArr[i3] & 255);
            i4++;
            i3++;
            if (i3 >= i2) {
                break;
            }
        }
        return sArr;
    }

    private short[] verifySignatureIntern(short[] sArr) {
        short[][] coeffQuadratic = ((RainbowPublicKeyParameters) this.key).getCoeffQuadratic();
        short[][] coeffSingular = ((RainbowPublicKeyParameters) this.key).getCoeffSingular();
        short[] coeffScalar = ((RainbowPublicKeyParameters) this.key).getCoeffScalar();
        short[] sArr2 = new short[coeffQuadratic.length];
        int length = coeffSingular[0].length;
        for (int i2 = 0; i2 < coeffQuadratic.length; i2++) {
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                for (int i5 = i4; i5 < length; i5++) {
                    sArr2[i2] = GF2Field.addElem(sArr2[i2], GF2Field.multElem(coeffQuadratic[i2][i3], GF2Field.multElem(sArr[i4], sArr[i5])));
                    i3++;
                }
                sArr2[i2] = GF2Field.addElem(sArr2[i2], GF2Field.multElem(coeffSingular[i2][i4], sArr[i4]));
            }
            sArr2[i2] = GF2Field.addElem(sArr2[i2], coeffScalar[i2]);
        }
        return sArr2;
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        boolean z;
        Layer[] layers = ((RainbowPrivateKeyParameters) this.key).getLayers();
        int length = layers.length;
        this.x = new short[((RainbowPrivateKeyParameters) this.key).getInvA2().length];
        int viNext = layers[length - 1].getViNext();
        byte[] bArr2 = new byte[viNext];
        short[] makeMessageRepresentative = makeMessageRepresentative(bArr);
        do {
            z = false;
            try {
                short[] initSign = initSign(layers, makeMessageRepresentative);
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    short[] sArr = new short[layers[i3].getOi()];
                    short[] sArr2 = new short[layers[i3].getOi()];
                    for (int i4 = 0; i4 < layers[i3].getOi(); i4++) {
                        sArr[i4] = initSign[i2];
                        i2++;
                    }
                    short[] solveEquation = this.cf.solveEquation(layers[i3].plugInVinegars(this.x), sArr);
                    if (solveEquation != null) {
                        for (int i5 = 0; i5 < solveEquation.length; i5++) {
                            this.x[layers[i3].getVi() + i5] = solveEquation[i5];
                        }
                    } else {
                        throw new Exception("LES is not solveable!");
                        break;
                    }
                }
                short[] multiplyMatrix = this.cf.multiplyMatrix(((RainbowPrivateKeyParameters) this.key).getInvA2(), this.cf.addVect(((RainbowPrivateKeyParameters) this.key).getB2(), this.x));
                for (int i6 = 0; i6 < viNext; i6++) {
                    bArr2[i6] = (byte) multiplyMatrix[i6];
                }
                z = true;
                continue;
            } catch (Exception unused) {
            }
        } while (!z);
        return bArr2;
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.random = parametersWithRandom.getRandom();
                this.key = (RainbowPrivateKeyParameters) parametersWithRandom.getParameters();
            } else {
                this.random = new SecureRandom();
                this.key = (RainbowPrivateKeyParameters) cipherParameters;
            }
        } else {
            this.key = (RainbowPublicKeyParameters) cipherParameters;
        }
        this.signableDocumentLength = this.key.getDocLength();
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        short[] sArr = new short[bArr2.length];
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            sArr[i2] = (short) (bArr2[i2] & 255);
        }
        short[] makeMessageRepresentative = makeMessageRepresentative(bArr);
        short[] verifySignatureIntern = verifySignatureIntern(sArr);
        if (makeMessageRepresentative.length != verifySignatureIntern.length) {
            return false;
        }
        boolean z = true;
        for (int i3 = 0; i3 < makeMessageRepresentative.length; i3++) {
            z = z && makeMessageRepresentative[i3] == verifySignatureIntern[i3];
        }
        return z;
    }
}