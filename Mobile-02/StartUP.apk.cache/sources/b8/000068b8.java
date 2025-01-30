package org.spongycastle.pqc.crypto.ntru;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.ntru.NTRUSigningPrivateKeyParameters;
import org.spongycastle.pqc.math.ntru.euclid.BigIntEuclidean;
import org.spongycastle.pqc.math.ntru.polynomial.BigDecimalPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.BigIntPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Resultant;

/* loaded from: classes3.dex */
public class NTRUSigningKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private NTRUSigningKeyGenerationParameters params;

    /* loaded from: classes3.dex */
    private class BasisGenerationTask implements Callable<NTRUSigningPrivateKeyParameters.Basis> {
        private BasisGenerationTask() {
        }

        @Override // java.util.concurrent.Callable
        public NTRUSigningPrivateKeyParameters.Basis call() throws Exception {
            return NTRUSigningKeyPairGenerator.this.generateBoundedBasis();
        }
    }

    /* loaded from: classes3.dex */
    public class FGBasis extends NTRUSigningPrivateKeyParameters.Basis {
        public IntegerPolynomial F;
        public IntegerPolynomial G;

        FGBasis(Polynomial polynomial, Polynomial polynomial2, IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
            super(polynomial, polynomial2, integerPolynomial, nTRUSigningKeyGenerationParameters);
            this.F = integerPolynomial2;
            this.G = integerPolynomial3;
        }

        boolean isNormOk() {
            NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.params;
            double d2 = nTRUSigningKeyGenerationParameters.keyNormBoundSq;
            int i2 = nTRUSigningKeyGenerationParameters.q;
            return ((double) this.F.centeredNormSq(i2)) < d2 && ((double) this.G.centeredNormSq(i2)) < d2;
        }
    }

    private FGBasis generateBasis() {
        int i2;
        Polynomial generateRandom;
        Polynomial polynomial;
        IntegerPolynomial integerPolynomial;
        IntegerPolynomial invertFq;
        int i3;
        Resultant resultant;
        int i4;
        IntegerPolynomial integerPolynomial2;
        int i5;
        IntegerPolynomial integerPolynomial3;
        int i6;
        Polynomial polynomial2;
        Polynomial generateRandom2;
        Polynomial polynomial3;
        IntegerPolynomial integerPolynomial4;
        Resultant resultant2;
        BigIntEuclidean calculate;
        BigIntPolynomial round;
        IntegerPolynomial mult;
        Polynomial polynomial4;
        NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.params;
        int i7 = nTRUSigningKeyGenerationParameters.N;
        int i8 = nTRUSigningKeyGenerationParameters.q;
        int i9 = nTRUSigningKeyGenerationParameters.f17862d;
        int i10 = nTRUSigningKeyGenerationParameters.d1;
        int i11 = nTRUSigningKeyGenerationParameters.d2;
        int i12 = nTRUSigningKeyGenerationParameters.d3;
        int i13 = nTRUSigningKeyGenerationParameters.basisType;
        int i14 = (i7 * 2) + 1;
        boolean z = nTRUSigningKeyGenerationParameters.primeCheck;
        while (true) {
            if (this.params.polyType == 0) {
                generateRandom = DenseTernaryPolynomial.generateRandom(i7, i9 + 1, i9, new SecureRandom());
                i2 = i14;
            } else {
                i2 = i14;
                generateRandom = ProductFormPolynomial.generateRandom(i7, i10, i11, i12 + 1, i12, new SecureRandom());
            }
            polynomial = generateRandom;
            integerPolynomial = polynomial.toIntegerPolynomial();
            if (z && integerPolynomial.resultant(i2).res.equals(BigInteger.ZERO)) {
                i14 = i2;
            } else {
                invertFq = integerPolynomial.invertFq(i8);
                if (invertFq != null) {
                    break;
                }
                i14 = i2;
            }
        }
        Resultant resultant3 = integerPolynomial.resultant();
        while (true) {
            if (this.params.polyType == 0) {
                generateRandom2 = DenseTernaryPolynomial.generateRandom(i7, i9 + 1, i9, new SecureRandom());
                i3 = i9;
                i4 = i10;
                i5 = i11;
                i6 = i12;
                resultant = resultant3;
                integerPolynomial2 = invertFq;
                integerPolynomial3 = integerPolynomial;
                polynomial2 = polynomial;
            } else {
                int i15 = i10;
                i3 = i9;
                resultant = resultant3;
                int i16 = i11;
                i4 = i10;
                integerPolynomial2 = invertFq;
                i5 = i11;
                integerPolynomial3 = integerPolynomial;
                int i17 = i12;
                i6 = i12;
                polynomial2 = polynomial;
                generateRandom2 = ProductFormPolynomial.generateRandom(i7, i15, i16, i12 + 1, i17, new SecureRandom());
            }
            polynomial3 = generateRandom2;
            integerPolynomial4 = polynomial3.toIntegerPolynomial();
            if (!z || !integerPolynomial4.resultant(i2).res.equals(BigInteger.ZERO)) {
                if (integerPolynomial4.invertFq(i8) != null) {
                    resultant2 = integerPolynomial4.resultant();
                    calculate = BigIntEuclidean.calculate(resultant.res, resultant2.res);
                    if (calculate.gcd.equals(BigInteger.ONE)) {
                        break;
                    }
                }
            }
            resultant3 = resultant;
            invertFq = integerPolynomial2;
            integerPolynomial = integerPolynomial3;
            polynomial = polynomial2;
            i11 = i5;
            i9 = i3;
            i10 = i4;
            i12 = i6;
        }
        BigIntPolynomial bigIntPolynomial = (BigIntPolynomial) resultant.rho.clone();
        bigIntPolynomial.mult(calculate.x.multiply(BigInteger.valueOf(i8)));
        BigIntPolynomial bigIntPolynomial2 = (BigIntPolynomial) resultant2.rho.clone();
        bigIntPolynomial2.mult(calculate.y.multiply(BigInteger.valueOf(-i8)));
        int i18 = 0;
        if (this.params.keyGenAlg == 0) {
            int[] iArr = new int[i7];
            int[] iArr2 = new int[i7];
            iArr[0] = integerPolynomial3.coeffs[0];
            iArr2[0] = integerPolynomial4.coeffs[0];
            for (int i19 = 1; i19 < i7; i19++) {
                int i20 = i7 - i19;
                iArr[i19] = integerPolynomial3.coeffs[i20];
                iArr2[i19] = integerPolynomial4.coeffs[i20];
            }
            IntegerPolynomial integerPolynomial5 = new IntegerPolynomial(iArr);
            IntegerPolynomial integerPolynomial6 = new IntegerPolynomial(iArr2);
            IntegerPolynomial mult2 = polynomial2.mult(integerPolynomial5);
            mult2.add(polynomial3.mult(integerPolynomial6));
            Resultant resultant4 = mult2.resultant();
            BigIntPolynomial mult3 = integerPolynomial5.mult(bigIntPolynomial2);
            mult3.add(integerPolynomial6.mult(bigIntPolynomial));
            round = mult3.mult(resultant4.rho);
            round.div(resultant4.res);
        } else {
            for (int i21 = 1; i21 < i7; i21 *= 10) {
                i18++;
            }
            BigDecimalPolynomial div = resultant.rho.div(new BigDecimal(resultant.res), bigIntPolynomial2.getMaxCoeffLength() + 1 + i18);
            BigDecimalPolynomial div2 = resultant2.rho.div(new BigDecimal(resultant2.res), bigIntPolynomial.getMaxCoeffLength() + 1 + i18);
            BigDecimalPolynomial mult4 = div.mult(bigIntPolynomial2);
            mult4.add(div2.mult(bigIntPolynomial));
            mult4.halve();
            round = mult4.round();
        }
        BigIntPolynomial bigIntPolynomial3 = (BigIntPolynomial) bigIntPolynomial2.clone();
        bigIntPolynomial3.sub(polynomial2.mult(round));
        BigIntPolynomial bigIntPolynomial4 = (BigIntPolynomial) bigIntPolynomial.clone();
        bigIntPolynomial4.sub(polynomial3.mult(round));
        IntegerPolynomial integerPolynomial7 = new IntegerPolynomial(bigIntPolynomial3);
        IntegerPolynomial integerPolynomial8 = new IntegerPolynomial(bigIntPolynomial4);
        minimizeFG(integerPolynomial3, integerPolynomial4, integerPolynomial7, integerPolynomial8, i7);
        if (i13 == 0) {
            mult = polynomial3.mult(integerPolynomial2, i8);
            polynomial4 = integerPolynomial7;
        } else {
            mult = integerPolynomial7.mult(integerPolynomial2, i8);
            polynomial4 = polynomial3;
        }
        mult.modPositive(i8);
        return new FGBasis(polynomial2, polynomial4, mult, integerPolynomial7, integerPolynomial8, this.params);
    }

    private void minimizeFG(IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3, IntegerPolynomial integerPolynomial4, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int[] iArr = integerPolynomial.coeffs;
            int i5 = iArr[i4] * iArr[i4];
            int[] iArr2 = integerPolynomial2.coeffs;
            i3 += i2 * 2 * (i5 + (iArr2[i4] * iArr2[i4]));
        }
        int i6 = i3 - 4;
        IntegerPolynomial integerPolynomial5 = (IntegerPolynomial) integerPolynomial.clone();
        IntegerPolynomial integerPolynomial6 = (IntegerPolynomial) integerPolynomial2.clone();
        int i7 = 0;
        int i8 = 0;
        while (i7 < i2 && i8 < i2) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                i9 += i2 * 4 * ((integerPolynomial3.coeffs[i10] * integerPolynomial.coeffs[i10]) + (integerPolynomial4.coeffs[i10] * integerPolynomial2.coeffs[i10]));
            }
            int sumCoeffs = i9 - ((integerPolynomial3.sumCoeffs() + integerPolynomial4.sumCoeffs()) * 4);
            if (sumCoeffs > i6) {
                integerPolynomial3.sub(integerPolynomial5);
                integerPolynomial4.sub(integerPolynomial6);
            } else if (sumCoeffs < (-i6)) {
                integerPolynomial3.add(integerPolynomial5);
                integerPolynomial4.add(integerPolynomial6);
            } else {
                i8++;
                integerPolynomial5.rotate1();
                integerPolynomial6.rotate1();
            }
            i7++;
            i8 = 0;
            i8++;
            integerPolynomial5.rotate1();
            integerPolynomial6.rotate1();
        }
    }

    public NTRUSigningPrivateKeyParameters.Basis generateBoundedBasis() {
        FGBasis generateBasis;
        do {
            generateBasis = generateBasis();
        } while (!generateBasis.isNormOk());
        return generateBasis;
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
        int i2 = this.params.B;
        while (true) {
            nTRUSigningPublicKeyParameters = null;
            if (i2 < 0) {
                break;
            }
            arrayList.add(newCachedThreadPool.submit(new BasisGenerationTask()));
            i2--;
        }
        newCachedThreadPool.shutdown();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = this.params.B; i3 >= 0; i3--) {
            Future future = (Future) arrayList.get(i3);
            try {
                arrayList2.add(future.get());
                if (i3 == this.params.B) {
                    nTRUSigningPublicKeyParameters = new NTRUSigningPublicKeyParameters(((NTRUSigningPrivateKeyParameters.Basis) future.get()).f17865h, this.params.getSigningParameters());
                }
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) nTRUSigningPublicKeyParameters, (AsymmetricKeyParameter) new NTRUSigningPrivateKeyParameters(arrayList2, nTRUSigningPublicKeyParameters));
    }

    public AsymmetricCipherKeyPair generateKeyPairSingleThread() {
        ArrayList arrayList = new ArrayList();
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters = null;
        for (int i2 = this.params.B; i2 >= 0; i2--) {
            NTRUSigningPrivateKeyParameters.Basis generateBoundedBasis = generateBoundedBasis();
            arrayList.add(generateBoundedBasis);
            if (i2 == 0) {
                nTRUSigningPublicKeyParameters = new NTRUSigningPublicKeyParameters(generateBoundedBasis.f17865h, this.params.getSigningParameters());
            }
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) nTRUSigningPublicKeyParameters, (AsymmetricKeyParameter) new NTRUSigningPrivateKeyParameters(arrayList, nTRUSigningPublicKeyParameters));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.params = (NTRUSigningKeyGenerationParameters) keyGenerationParameters;
    }
}