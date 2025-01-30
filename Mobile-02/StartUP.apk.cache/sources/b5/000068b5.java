package org.spongycastle.pqc.crypto.ntru;

import java.nio.ByteBuffer;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;

/* loaded from: classes3.dex */
public class NTRUSigner {
    private Digest hashAlg;
    private NTRUSigningParameters params;
    private NTRUSigningPrivateKeyParameters signingKeyPair;
    private NTRUSigningPublicKeyParameters verificationKey;

    public NTRUSigner(NTRUSigningParameters nTRUSigningParameters) {
        this.params = nTRUSigningParameters;
    }

    private IntegerPolynomial sign(IntegerPolynomial integerPolynomial, NTRUSigningPrivateKeyParameters nTRUSigningPrivateKeyParameters) {
        NTRUSigningParameters nTRUSigningParameters = this.params;
        int i2 = nTRUSigningParameters.N;
        int i3 = nTRUSigningParameters.q;
        NTRUSigningPublicKeyParameters publicKey = nTRUSigningPrivateKeyParameters.getPublicKey();
        IntegerPolynomial integerPolynomial2 = new IntegerPolynomial(i2);
        for (int i4 = nTRUSigningParameters.B; i4 >= 1; i4--) {
            Polynomial polynomial = nTRUSigningPrivateKeyParameters.getBasis(i4).f17864f;
            Polynomial polynomial2 = nTRUSigningPrivateKeyParameters.getBasis(i4).fPrime;
            IntegerPolynomial mult = polynomial.mult(integerPolynomial);
            mult.div(i3);
            IntegerPolynomial mult2 = polynomial2.mult(mult);
            IntegerPolynomial mult3 = polynomial2.mult(integerPolynomial);
            mult3.div(i3);
            mult2.sub(polynomial.mult(mult3));
            integerPolynomial2.add(mult2);
            IntegerPolynomial integerPolynomial3 = (IntegerPolynomial) nTRUSigningPrivateKeyParameters.getBasis(i4).f17865h.clone();
            if (i4 > 1) {
                integerPolynomial3.sub(nTRUSigningPrivateKeyParameters.getBasis(i4 - 1).f17865h);
            } else {
                integerPolynomial3.sub(publicKey.f17866h);
            }
            integerPolynomial = mult2.mult(integerPolynomial3, i3);
        }
        Polynomial polynomial3 = nTRUSigningPrivateKeyParameters.getBasis(0).f17864f;
        Polynomial polynomial4 = nTRUSigningPrivateKeyParameters.getBasis(0).fPrime;
        IntegerPolynomial mult4 = polynomial3.mult(integerPolynomial);
        mult4.div(i3);
        IntegerPolynomial mult5 = polynomial4.mult(mult4);
        IntegerPolynomial mult6 = polynomial4.mult(integerPolynomial);
        mult6.div(i3);
        mult5.sub(polynomial3.mult(mult6));
        integerPolynomial2.add(mult5);
        integerPolynomial2.modPositive(i3);
        return integerPolynomial2;
    }

    private byte[] signHash(byte[] bArr, NTRUSigningPrivateKeyParameters nTRUSigningPrivateKeyParameters) {
        IntegerPolynomial createMsgRep;
        IntegerPolynomial sign;
        NTRUSigningPublicKeyParameters publicKey = nTRUSigningPrivateKeyParameters.getPublicKey();
        int i2 = 0;
        do {
            i2++;
            if (i2 <= this.params.signFailTolerance) {
                createMsgRep = createMsgRep(bArr, i2);
                sign = sign(createMsgRep, nTRUSigningPrivateKeyParameters);
            } else {
                throw new IllegalStateException("Signing failed: too many retries (max=" + this.params.signFailTolerance + ")");
            }
        } while (!verify(createMsgRep, sign, publicKey.f17866h));
        byte[] binary = sign.toBinary(this.params.q);
        ByteBuffer allocate = ByteBuffer.allocate(binary.length + 4);
        allocate.put(binary);
        allocate.putInt(i2);
        return allocate.array();
    }

    private boolean verify(IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3) {
        NTRUSigningParameters nTRUSigningParameters = this.params;
        int i2 = nTRUSigningParameters.q;
        double d2 = nTRUSigningParameters.normBoundSq;
        double d3 = nTRUSigningParameters.betaSq;
        IntegerPolynomial mult = integerPolynomial3.mult(integerPolynomial2, i2);
        mult.sub(integerPolynomial);
        return ((double) ((long) (((double) integerPolynomial2.centeredNormSq(i2)) + (d3 * ((double) mult.centeredNormSq(i2)))))) <= d2;
    }

    private boolean verifyHash(byte[] bArr, byte[] bArr2, NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr2);
        byte[] bArr3 = new byte[bArr2.length - 4];
        wrap.get(bArr3);
        NTRUSigningParameters nTRUSigningParameters = this.params;
        return verify(createMsgRep(bArr, wrap.getInt()), IntegerPolynomial.fromBinary(bArr3, nTRUSigningParameters.N, nTRUSigningParameters.q), nTRUSigningPublicKeyParameters.f17866h);
    }

    protected IntegerPolynomial createMsgRep(byte[] bArr, int i2) {
        NTRUSigningParameters nTRUSigningParameters = this.params;
        int i3 = nTRUSigningParameters.N;
        int numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(nTRUSigningParameters.q);
        int i4 = (numberOfLeadingZeros + 7) / 8;
        IntegerPolynomial integerPolynomial = new IntegerPolynomial(i3);
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 4);
        allocate.put(bArr);
        allocate.putInt(i2);
        NTRUSignerPrng nTRUSignerPrng = new NTRUSignerPrng(allocate.array(), this.params.hashAlg);
        for (int i5 = 0; i5 < i3; i5++) {
            byte[] nextBytes = nTRUSignerPrng.nextBytes(i4);
            int i6 = (i4 * 8) - numberOfLeadingZeros;
            nextBytes[nextBytes.length - 1] = (byte) ((nextBytes[nextBytes.length - 1] >> i6) << i6);
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.put(nextBytes);
            allocate2.rewind();
            integerPolynomial.coeffs[i5] = Integer.reverseBytes(allocate2.getInt());
        }
        return integerPolynomial;
    }

    public byte[] generateSignature() {
        Digest digest = this.hashAlg;
        if (digest != null && this.signingKeyPair != null) {
            byte[] bArr = new byte[digest.getDigestSize()];
            this.hashAlg.doFinal(bArr, 0);
            return signHash(bArr, this.signingKeyPair);
        }
        throw new IllegalStateException("Call initSign first!");
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            this.signingKeyPair = (NTRUSigningPrivateKeyParameters) cipherParameters;
        } else {
            this.verificationKey = (NTRUSigningPublicKeyParameters) cipherParameters;
        }
        Digest digest = this.params.hashAlg;
        this.hashAlg = digest;
        digest.reset();
    }

    public void update(byte b2) {
        Digest digest = this.hashAlg;
        if (digest != null) {
            digest.update(b2);
            return;
        }
        throw new IllegalStateException("Call initSign or initVerify first!");
    }

    public boolean verifySignature(byte[] bArr) {
        Digest digest = this.hashAlg;
        if (digest != null && this.verificationKey != null) {
            byte[] bArr2 = new byte[digest.getDigestSize()];
            this.hashAlg.doFinal(bArr2, 0);
            return verifyHash(bArr2, bArr, this.verificationKey);
        }
        throw new IllegalStateException("Call initVerify first!");
    }

    public void update(byte[] bArr, int i2, int i3) {
        Digest digest = this.hashAlg;
        if (digest != null) {
            digest.update(bArr, i2, i3);
            return;
        }
        throw new IllegalStateException("Call initSign or initVerify first!");
    }
}