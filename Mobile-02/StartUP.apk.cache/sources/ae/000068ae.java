package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.util.Util;

/* loaded from: classes3.dex */
public class NTRUEncryptionKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private NTRUEncryptionKeyGenerationParameters params;

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        Polynomial generateRandomTernary;
        IntegerPolynomial integerPolynomial;
        IntegerPolynomial invertFq;
        IntegerPolynomial integerPolynomial2;
        DenseTernaryPolynomial generateRandom;
        NTRUEncryptionKeyGenerationParameters nTRUEncryptionKeyGenerationParameters = this.params;
        int i2 = nTRUEncryptionKeyGenerationParameters.N;
        int i3 = nTRUEncryptionKeyGenerationParameters.q;
        int i4 = nTRUEncryptionKeyGenerationParameters.df;
        int i5 = nTRUEncryptionKeyGenerationParameters.df1;
        int i6 = nTRUEncryptionKeyGenerationParameters.df2;
        int i7 = nTRUEncryptionKeyGenerationParameters.df3;
        int i8 = nTRUEncryptionKeyGenerationParameters.dg;
        boolean z = nTRUEncryptionKeyGenerationParameters.fastFp;
        boolean z2 = nTRUEncryptionKeyGenerationParameters.sparse;
        IntegerPolynomial integerPolynomial3 = null;
        while (true) {
            if (z) {
                NTRUEncryptionKeyGenerationParameters nTRUEncryptionKeyGenerationParameters2 = this.params;
                generateRandomTernary = nTRUEncryptionKeyGenerationParameters2.polyType == 0 ? Util.generateRandomTernary(i2, i4, i4, z2, nTRUEncryptionKeyGenerationParameters2.getRandom()) : ProductFormPolynomial.generateRandom(i2, i5, i6, i7, i7, nTRUEncryptionKeyGenerationParameters2.getRandom());
                integerPolynomial = generateRandomTernary.toIntegerPolynomial();
                integerPolynomial.mult(3);
                int[] iArr = integerPolynomial.coeffs;
                iArr[0] = iArr[0] + 1;
            } else {
                NTRUEncryptionKeyGenerationParameters nTRUEncryptionKeyGenerationParameters3 = this.params;
                generateRandomTernary = nTRUEncryptionKeyGenerationParameters3.polyType == 0 ? Util.generateRandomTernary(i2, i4, i4 - 1, z2, nTRUEncryptionKeyGenerationParameters3.getRandom()) : ProductFormPolynomial.generateRandom(i2, i5, i6, i7, i7 - 1, nTRUEncryptionKeyGenerationParameters3.getRandom());
                integerPolynomial = generateRandomTernary.toIntegerPolynomial();
                integerPolynomial3 = integerPolynomial.invertF3();
                if (integerPolynomial3 == null) {
                    continue;
                }
            }
            invertFq = integerPolynomial.invertFq(i3);
            if (invertFq != null) {
                break;
            }
        }
        if (z) {
            integerPolynomial2 = new IntegerPolynomial(i2);
            integerPolynomial2.coeffs[0] = 1;
        } else {
            integerPolynomial2 = integerPolynomial3;
        }
        do {
            generateRandom = DenseTernaryPolynomial.generateRandom(i2, i8, i8 - 1, this.params.getRandom());
        } while (generateRandom.invertFq(i3) == null);
        IntegerPolynomial mult = generateRandom.mult(invertFq, i3);
        mult.mult3(i3);
        mult.ensurePositive(i3);
        generateRandom.clear();
        invertFq.clear();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new NTRUEncryptionPublicKeyParameters(mult, this.params.getEncryptionParameters()), (AsymmetricKeyParameter) new NTRUEncryptionPrivateKeyParameters(mult, generateRandomTernary, integerPolynomial2, this.params.getEncryptionParameters()));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.params = (NTRUEncryptionKeyGenerationParameters) keyGenerationParameters;
    }
}