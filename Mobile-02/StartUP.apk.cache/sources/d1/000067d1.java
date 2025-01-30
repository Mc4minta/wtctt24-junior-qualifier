package org.spongycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

/* loaded from: classes3.dex */
public abstract class ECFieldElement implements ECConstants {

    /* loaded from: classes3.dex */
    public static class Fp extends ECFieldElement {
        BigInteger q;
        BigInteger r;
        BigInteger x;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2) {
            this(bigInteger, calculateResidue(bigInteger), bigInteger2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static BigInteger calculateResidue(BigInteger bigInteger) {
            int bitLength = bigInteger.bitLength();
            if (bitLength < 96 || bigInteger.shiftRight(bitLength - 64).longValue() != -1) {
                return null;
            }
            return ECConstants.ONE.shiftLeft(bitLength).subtract(bigInteger);
        }

        private ECFieldElement checkSqrt(ECFieldElement eCFieldElement) {
            if (eCFieldElement.square().equals(this)) {
                return eCFieldElement;
            }
            return null;
        }

        private BigInteger[] lucasSequence(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int bitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigInteger4 = ECConstants.ONE;
            BigInteger bigInteger5 = bigInteger;
            BigInteger bigInteger6 = bigInteger4;
            BigInteger bigInteger7 = ECConstants.TWO;
            BigInteger bigInteger8 = bigInteger6;
            for (int i2 = bitLength - 1; i2 >= lowestSetBit + 1; i2--) {
                bigInteger4 = modMult(bigInteger4, bigInteger8);
                if (bigInteger3.testBit(i2)) {
                    bigInteger8 = modMult(bigInteger4, bigInteger2);
                    bigInteger6 = modMult(bigInteger6, bigInteger5);
                    bigInteger7 = modReduce(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(bigInteger4)));
                    bigInteger5 = modReduce(bigInteger5.multiply(bigInteger5).subtract(bigInteger8.shiftLeft(1)));
                } else {
                    BigInteger modReduce = modReduce(bigInteger6.multiply(bigInteger7).subtract(bigInteger4));
                    BigInteger modReduce2 = modReduce(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(bigInteger4)));
                    bigInteger7 = modReduce(bigInteger7.multiply(bigInteger7).subtract(bigInteger4.shiftLeft(1)));
                    bigInteger5 = modReduce2;
                    bigInteger6 = modReduce;
                    bigInteger8 = bigInteger4;
                }
            }
            BigInteger modMult = modMult(bigInteger4, bigInteger8);
            BigInteger modMult2 = modMult(modMult, bigInteger2);
            BigInteger modReduce3 = modReduce(bigInteger6.multiply(bigInteger7).subtract(modMult));
            BigInteger modReduce4 = modReduce(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(modMult)));
            BigInteger modMult3 = modMult(modMult, modMult2);
            for (int i3 = 1; i3 <= lowestSetBit; i3++) {
                modReduce3 = modMult(modReduce3, modReduce4);
                modReduce4 = modReduce(modReduce4.multiply(modReduce4).subtract(modMult3.shiftLeft(1)));
                modMult3 = modMult(modMult3, modMult3);
            }
            return new BigInteger[]{modReduce3, modReduce4};
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.r, modAdd(this.x, eCFieldElement.toBigInteger()));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            BigInteger add = this.x.add(ECConstants.ONE);
            if (add.compareTo(this.q) == 0) {
                add = ECConstants.ZERO;
            }
            return new Fp(this.q, this.r, add);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.r, modMult(this.x, modInverse(eCFieldElement.toBigInteger())));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Fp) {
                Fp fp = (Fp) obj;
                return this.q.equals(fp.q) && this.x.equals(fp.x);
            }
            return false;
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public String getFieldName() {
            return "Fp";
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.q.bitLength();
        }

        public BigInteger getQ() {
            return this.q;
        }

        public int hashCode() {
            return this.q.hashCode() ^ this.x.hashCode();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            return new Fp(this.q, this.r, modInverse(this.x));
        }

        protected BigInteger modAdd(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger add = bigInteger.add(bigInteger2);
            return add.compareTo(this.q) >= 0 ? add.subtract(this.q) : add;
        }

        protected BigInteger modDouble(BigInteger bigInteger) {
            BigInteger shiftLeft = bigInteger.shiftLeft(1);
            return shiftLeft.compareTo(this.q) >= 0 ? shiftLeft.subtract(this.q) : shiftLeft;
        }

        protected BigInteger modHalf(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.q.add(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        protected BigInteger modHalfAbs(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.q.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        protected BigInteger modInverse(BigInteger bigInteger) {
            int fieldSize = getFieldSize();
            int i2 = (fieldSize + 31) >> 5;
            int[] fromBigInteger = Nat.fromBigInteger(fieldSize, this.q);
            int[] fromBigInteger2 = Nat.fromBigInteger(fieldSize, bigInteger);
            int[] create = Nat.create(i2);
            Mod.invert(fromBigInteger, fromBigInteger2, create);
            return Nat.toBigInteger(i2, create);
        }

        protected BigInteger modMult(BigInteger bigInteger, BigInteger bigInteger2) {
            return modReduce(bigInteger.multiply(bigInteger2));
        }

        protected BigInteger modReduce(BigInteger bigInteger) {
            if (this.r != null) {
                boolean z = bigInteger.signum() < 0;
                if (z) {
                    bigInteger = bigInteger.abs();
                }
                int bitLength = this.q.bitLength();
                boolean equals = this.r.equals(ECConstants.ONE);
                while (bigInteger.bitLength() > bitLength + 1) {
                    BigInteger shiftRight = bigInteger.shiftRight(bitLength);
                    BigInteger subtract = bigInteger.subtract(shiftRight.shiftLeft(bitLength));
                    if (!equals) {
                        shiftRight = shiftRight.multiply(this.r);
                    }
                    bigInteger = shiftRight.add(subtract);
                }
                while (bigInteger.compareTo(this.q) >= 0) {
                    bigInteger = bigInteger.subtract(this.q);
                }
                return (!z || bigInteger.signum() == 0) ? bigInteger : this.q.subtract(bigInteger);
            }
            return bigInteger.mod(this.q);
        }

        protected BigInteger modSubtract(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger subtract = bigInteger.subtract(bigInteger2);
            return subtract.signum() < 0 ? subtract.add(this.q) : subtract;
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.r, modMult(this.x, eCFieldElement.toBigInteger()));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new Fp(this.q, this.r, modReduce(bigInteger.multiply(bigInteger2).subtract(bigInteger3.multiply(bigInteger4))));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new Fp(this.q, this.r, modReduce(bigInteger.multiply(bigInteger2).add(bigInteger3.multiply(bigInteger4))));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            if (this.x.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.q;
            return new Fp(bigInteger, this.r, bigInteger.subtract(this.x));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            if (isZero() || isOne()) {
                return this;
            }
            if (this.q.testBit(0)) {
                if (this.q.testBit(1)) {
                    BigInteger add = this.q.shiftRight(2).add(ECConstants.ONE);
                    BigInteger bigInteger = this.q;
                    return checkSqrt(new Fp(bigInteger, this.r, this.x.modPow(add, bigInteger)));
                } else if (this.q.testBit(2)) {
                    BigInteger modPow = this.x.modPow(this.q.shiftRight(3), this.q);
                    BigInteger modMult = modMult(modPow, this.x);
                    if (modMult(modMult, modPow).equals(ECConstants.ONE)) {
                        return checkSqrt(new Fp(this.q, this.r, modMult));
                    }
                    return checkSqrt(new Fp(this.q, this.r, modMult(modMult, ECConstants.TWO.modPow(this.q.shiftRight(2), this.q))));
                } else {
                    BigInteger shiftRight = this.q.shiftRight(1);
                    BigInteger modPow2 = this.x.modPow(shiftRight, this.q);
                    BigInteger bigInteger2 = ECConstants.ONE;
                    if (!modPow2.equals(bigInteger2)) {
                        return null;
                    }
                    BigInteger bigInteger3 = this.x;
                    BigInteger modDouble = modDouble(modDouble(bigInteger3));
                    BigInteger add2 = shiftRight.add(bigInteger2);
                    BigInteger subtract = this.q.subtract(bigInteger2);
                    Random random = new Random();
                    while (true) {
                        BigInteger bigInteger4 = new BigInteger(this.q.bitLength(), random);
                        if (bigInteger4.compareTo(this.q) < 0 && modReduce(bigInteger4.multiply(bigInteger4).subtract(modDouble)).modPow(shiftRight, this.q).equals(subtract)) {
                            BigInteger[] lucasSequence = lucasSequence(bigInteger4, bigInteger3, add2);
                            BigInteger bigInteger5 = lucasSequence[0];
                            BigInteger bigInteger6 = lucasSequence[1];
                            if (modMult(bigInteger6, bigInteger6).equals(modDouble)) {
                                return new Fp(this.q, this.r, modHalfAbs(bigInteger6));
                            }
                            if (!bigInteger5.equals(ECConstants.ONE) && !bigInteger5.equals(subtract)) {
                                return null;
                            }
                        }
                    }
                }
            } else {
                throw new RuntimeException("not done yet");
            }
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            BigInteger bigInteger = this.q;
            BigInteger bigInteger2 = this.r;
            BigInteger bigInteger3 = this.x;
            return new Fp(bigInteger, bigInteger2, modMult(bigInteger3, bigInteger3));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new Fp(this.q, this.r, modReduce(bigInteger.multiply(bigInteger).subtract(bigInteger2.multiply(bigInteger3))));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new Fp(this.q, this.r, modReduce(bigInteger.multiply(bigInteger).add(bigInteger2.multiply(bigInteger3))));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.r, modSubtract(this.x, eCFieldElement.toBigInteger()));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.x;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 != null && bigInteger3.signum() >= 0 && bigInteger3.compareTo(bigInteger) < 0) {
                this.q = bigInteger;
                this.r = bigInteger2;
                this.x = bigInteger3;
                return;
            }
            throw new IllegalArgumentException("x value invalid in Fp field element");
        }
    }

    public abstract ECFieldElement add(ECFieldElement eCFieldElement);

    public abstract ECFieldElement addOne();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    public abstract ECFieldElement divide(ECFieldElement eCFieldElement);

    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
    }

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public boolean isOne() {
        return bitLength() == 1;
    }

    public boolean isZero() {
        return toBigInteger().signum() == 0;
    }

    public abstract ECFieldElement multiply(ECFieldElement eCFieldElement);

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).subtract(eCFieldElement2.multiply(eCFieldElement3));
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).add(eCFieldElement2.multiply(eCFieldElement3));
    }

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return square().subtract(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return square().add(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePow(int i2) {
        ECFieldElement eCFieldElement = this;
        for (int i3 = 0; i3 < i2; i3++) {
            eCFieldElement = eCFieldElement.square();
        }
        return eCFieldElement;
    }

    public abstract ECFieldElement subtract(ECFieldElement eCFieldElement);

    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(16);
    }

    /* loaded from: classes3.dex */
    public static class F2m extends ECFieldElement {
        public static final int GNB = 1;
        public static final int PPB = 3;
        public static final int TPB = 2;
        private int[] ks;
        private int m;
        private int representation;
        private LongArray x;

        public F2m(int i2, int i3, int i4, int i5, BigInteger bigInteger) {
            if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= i2) {
                if (i4 == 0 && i5 == 0) {
                    this.representation = 2;
                    this.ks = new int[]{i3};
                } else if (i4 >= i5) {
                    throw new IllegalArgumentException("k2 must be smaller than k3");
                } else {
                    if (i4 > 0) {
                        this.representation = 3;
                        this.ks = new int[]{i3, i4, i5};
                    } else {
                        throw new IllegalArgumentException("k2 must be larger than 0");
                    }
                }
                this.m = i2;
                this.x = new LongArray(bigInteger);
                return;
            }
            throw new IllegalArgumentException("x value invalid in F2m field element");
        }

        public static void checkFieldElements(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            if ((eCFieldElement instanceof F2m) && (eCFieldElement2 instanceof F2m)) {
                F2m f2m = (F2m) eCFieldElement;
                F2m f2m2 = (F2m) eCFieldElement2;
                if (f2m.representation == f2m2.representation) {
                    if (f2m.m != f2m2.m || !Arrays.areEqual(f2m.ks, f2m2.ks)) {
                        throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
                    }
                    return;
                }
                throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
            }
            throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            LongArray longArray = (LongArray) this.x.clone();
            longArray.addShiftedByWords(((F2m) eCFieldElement).x, 0);
            return new F2m(this.m, this.ks, longArray);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            return new F2m(this.m, this.ks, this.x.addOne());
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public int bitLength() {
            return this.x.degree();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return multiply(eCFieldElement.invert());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof F2m) {
                F2m f2m = (F2m) obj;
                return this.m == f2m.m && this.representation == f2m.representation && Arrays.areEqual(this.ks, f2m.ks) && this.x.equals(f2m.x);
            }
            return false;
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public String getFieldName() {
            return "F2m";
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.m;
        }

        public int getK1() {
            return this.ks[0];
        }

        public int getK2() {
            int[] iArr = this.ks;
            if (iArr.length >= 2) {
                return iArr[1];
            }
            return 0;
        }

        public int getK3() {
            int[] iArr = this.ks;
            if (iArr.length >= 3) {
                return iArr[2];
            }
            return 0;
        }

        public int getM() {
            return this.m;
        }

        public int getRepresentation() {
            return this.representation;
        }

        public int hashCode() {
            return (this.x.hashCode() ^ this.m) ^ Arrays.hashCode(this.ks);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            int i2 = this.m;
            int[] iArr = this.ks;
            return new F2m(i2, iArr, this.x.modInverse(i2, iArr));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public boolean isOne() {
            return this.x.isOne();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public boolean isZero() {
            return this.x.isZero();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            int i2 = this.m;
            int[] iArr = this.ks;
            return new F2m(i2, iArr, this.x.modMultiply(((F2m) eCFieldElement).x, i2, iArr));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            LongArray longArray = this.x;
            LongArray longArray2 = ((F2m) eCFieldElement).x;
            LongArray longArray3 = ((F2m) eCFieldElement2).x;
            LongArray longArray4 = ((F2m) eCFieldElement3).x;
            LongArray multiply = longArray.multiply(longArray2, this.m, this.ks);
            LongArray multiply2 = longArray3.multiply(longArray4, this.m, this.ks);
            if (multiply == longArray || multiply == longArray2) {
                multiply = (LongArray) multiply.clone();
            }
            multiply.addShiftedByWords(multiply2, 0);
            multiply.reduce(this.m, this.ks);
            return new F2m(this.m, this.ks, multiply);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            return this;
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            return (this.x.isZero() || this.x.isOne()) ? this : squarePow(this.m - 1);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            int i2 = this.m;
            int[] iArr = this.ks;
            return new F2m(i2, iArr, this.x.modSquare(i2, iArr));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            return squarePlusProduct(eCFieldElement, eCFieldElement2);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            LongArray longArray = this.x;
            LongArray longArray2 = ((F2m) eCFieldElement).x;
            LongArray longArray3 = ((F2m) eCFieldElement2).x;
            LongArray square = longArray.square(this.m, this.ks);
            LongArray multiply = longArray2.multiply(longArray3, this.m, this.ks);
            if (square == longArray) {
                square = (LongArray) square.clone();
            }
            square.addShiftedByWords(multiply, 0);
            square.reduce(this.m, this.ks);
            return new F2m(this.m, this.ks, square);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement squarePow(int i2) {
            if (i2 < 1) {
                return this;
            }
            int i3 = this.m;
            int[] iArr = this.ks;
            return new F2m(i3, iArr, this.x.modSquareN(i2, i3, iArr));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return add(eCFieldElement);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public boolean testBitZero() {
            return this.x.testBitZero();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.x.toBigInteger();
        }

        public F2m(int i2, int i3, BigInteger bigInteger) {
            this(i2, i3, 0, 0, bigInteger);
        }

        private F2m(int i2, int[] iArr, LongArray longArray) {
            this.m = i2;
            this.representation = iArr.length == 1 ? 2 : 3;
            this.ks = iArr;
            this.x = longArray;
        }
    }
}