package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.endo.ECEndomorphism;
import org.spongycastle.math.ec.endo.GLVEndomorphism;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.PolynomialExtensionField;

/* loaded from: classes3.dex */
public class ECAlgorithms {
    static ECPoint implShamirsTrickJsf(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECCurve curve = eCPoint.getCurve();
        ECPoint infinity = curve.getInfinity();
        ECPoint[] eCPointArr = {eCPoint2, eCPoint.subtract(eCPoint2), eCPoint, eCPoint.add(eCPoint2)};
        curve.normalizeAll(eCPointArr);
        ECPoint[] eCPointArr2 = {eCPointArr[3].negate(), eCPointArr[2].negate(), eCPointArr[1].negate(), eCPointArr[0].negate(), infinity, eCPointArr[0], eCPointArr[1], eCPointArr[2], eCPointArr[3]};
        byte[] generateJSF = WNafUtil.generateJSF(bigInteger, bigInteger2);
        int length = generateJSF.length;
        while (true) {
            length--;
            if (length < 0) {
                return infinity;
            }
            byte b2 = generateJSF[length];
            infinity = infinity.twicePlus(eCPointArr2[(((b2 << 24) >> 28) * 3) + 4 + ((b2 << 28) >> 28)]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ECPoint implShamirsTrickWNaf(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        boolean z = bigInteger.signum() < 0;
        boolean z2 = bigInteger2.signum() < 0;
        BigInteger abs = bigInteger.abs();
        BigInteger abs2 = bigInteger2.abs();
        int max = Math.max(2, Math.min(16, WNafUtil.getWindowSize(abs.bitLength())));
        int max2 = Math.max(2, Math.min(16, WNafUtil.getWindowSize(abs2.bitLength())));
        WNafPreCompInfo precompute = WNafUtil.precompute(eCPoint, max, true);
        WNafPreCompInfo precompute2 = WNafUtil.precompute(eCPoint2, max2, true);
        return implShamirsTrickWNaf(z ? precompute.getPreCompNeg() : precompute.getPreComp(), z ? precompute.getPreComp() : precompute.getPreCompNeg(), WNafUtil.generateWindowNaf(max, abs), z2 ? precompute2.getPreCompNeg() : precompute2.getPreComp(), z2 ? precompute2.getPreComp() : precompute2.getPreCompNeg(), WNafUtil.generateWindowNaf(max2, abs2));
    }

    static ECPoint implSumOfMultiplies(ECPoint[] eCPointArr, BigInteger[] bigIntegerArr) {
        int length = eCPointArr.length;
        boolean[] zArr = new boolean[length];
        WNafPreCompInfo[] wNafPreCompInfoArr = new WNafPreCompInfo[length];
        byte[][] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            BigInteger bigInteger = bigIntegerArr[i2];
            zArr[i2] = bigInteger.signum() < 0;
            BigInteger abs = bigInteger.abs();
            int max = Math.max(2, Math.min(16, WNafUtil.getWindowSize(abs.bitLength())));
            wNafPreCompInfoArr[i2] = WNafUtil.precompute(eCPointArr[i2], max, true);
            bArr[i2] = WNafUtil.generateWindowNaf(max, abs);
        }
        return implSumOfMultiplies(zArr, wNafPreCompInfoArr, bArr);
    }

    static ECPoint implSumOfMultipliesGLV(ECPoint[] eCPointArr, BigInteger[] bigIntegerArr, GLVEndomorphism gLVEndomorphism) {
        BigInteger order = eCPointArr[0].getCurve().getOrder();
        int length = eCPointArr.length;
        int i2 = length << 1;
        BigInteger[] bigIntegerArr2 = new BigInteger[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            BigInteger[] decomposeScalar = gLVEndomorphism.decomposeScalar(bigIntegerArr[i4].mod(order));
            int i5 = i3 + 1;
            bigIntegerArr2[i3] = decomposeScalar[0];
            i3 = i5 + 1;
            bigIntegerArr2[i5] = decomposeScalar[1];
        }
        ECPointMap pointMap = gLVEndomorphism.getPointMap();
        if (gLVEndomorphism.hasEfficientPointMap()) {
            return implSumOfMultiplies(eCPointArr, pointMap, bigIntegerArr2);
        }
        ECPoint[] eCPointArr2 = new ECPoint[i2];
        int i6 = 0;
        for (ECPoint eCPoint : eCPointArr) {
            ECPoint map = pointMap.map(eCPoint);
            int i7 = i6 + 1;
            eCPointArr2[i6] = eCPoint;
            i6 = i7 + 1;
            eCPointArr2[i7] = map;
        }
        return implSumOfMultiplies(eCPointArr2, bigIntegerArr2);
    }

    public static ECPoint importPoint(ECCurve eCCurve, ECPoint eCPoint) {
        if (eCCurve.equals(eCPoint.getCurve())) {
            return eCCurve.importPoint(eCPoint);
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static boolean isF2mCurve(ECCurve eCCurve) {
        return isF2mField(eCCurve.getField());
    }

    public static boolean isF2mField(FiniteField finiteField) {
        return finiteField.getDimension() > 1 && finiteField.getCharacteristic().equals(ECConstants.TWO) && (finiteField instanceof PolynomialExtensionField);
    }

    public static boolean isFpCurve(ECCurve eCCurve) {
        return isFpField(eCCurve.getField());
    }

    public static boolean isFpField(FiniteField finiteField) {
        return finiteField.getDimension() == 1;
    }

    public static void montgomeryTrick(ECFieldElement[] eCFieldElementArr, int i2, int i3) {
        montgomeryTrick(eCFieldElementArr, i2, i3, null);
    }

    public static ECPoint referenceMultiply(ECPoint eCPoint, BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int bitLength = abs.bitLength();
        if (bitLength > 0) {
            if (abs.testBit(0)) {
                infinity = eCPoint;
            }
            for (int i2 = 1; i2 < bitLength; i2++) {
                eCPoint = eCPoint.twice();
                if (abs.testBit(i2)) {
                    infinity = infinity.add(eCPoint);
                }
            }
        }
        return bigInteger.signum() < 0 ? infinity.negate() : infinity;
    }

    public static ECPoint shamirsTrick(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        return validatePoint(implShamirsTrickJsf(eCPoint, bigInteger, importPoint(eCPoint.getCurve(), eCPoint2), bigInteger2));
    }

    public static ECPoint sumOfMultiplies(ECPoint[] eCPointArr, BigInteger[] bigIntegerArr) {
        if (eCPointArr != null && bigIntegerArr != null && eCPointArr.length == bigIntegerArr.length) {
            if (eCPointArr.length >= 1) {
                int length = eCPointArr.length;
                if (length != 1) {
                    if (length != 2) {
                        ECPoint eCPoint = eCPointArr[0];
                        ECCurve curve = eCPoint.getCurve();
                        ECPoint[] eCPointArr2 = new ECPoint[length];
                        eCPointArr2[0] = eCPoint;
                        for (int i2 = 1; i2 < length; i2++) {
                            eCPointArr2[i2] = importPoint(curve, eCPointArr[i2]);
                        }
                        ECEndomorphism endomorphism = curve.getEndomorphism();
                        if (endomorphism instanceof GLVEndomorphism) {
                            return validatePoint(implSumOfMultipliesGLV(eCPointArr2, bigIntegerArr, (GLVEndomorphism) endomorphism));
                        }
                        return validatePoint(implSumOfMultiplies(eCPointArr2, bigIntegerArr));
                    }
                    return sumOfTwoMultiplies(eCPointArr[0], bigIntegerArr[0], eCPointArr[1], bigIntegerArr[1]);
                }
                return eCPointArr[0].multiply(bigIntegerArr[0]);
            }
        }
        throw new IllegalArgumentException("point and scalar arrays should be non-null, and of equal, non-zero, length");
    }

    public static ECPoint sumOfTwoMultiplies(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECCurve curve = eCPoint.getCurve();
        ECPoint importPoint = importPoint(curve, eCPoint2);
        if ((curve instanceof ECCurve.AbstractF2m) && ((ECCurve.AbstractF2m) curve).isKoblitz()) {
            return validatePoint(eCPoint.multiply(bigInteger).add(importPoint.multiply(bigInteger2)));
        }
        ECEndomorphism endomorphism = curve.getEndomorphism();
        if (endomorphism instanceof GLVEndomorphism) {
            return validatePoint(implSumOfMultipliesGLV(new ECPoint[]{eCPoint, importPoint}, new BigInteger[]{bigInteger, bigInteger2}, (GLVEndomorphism) endomorphism));
        }
        return validatePoint(implShamirsTrickWNaf(eCPoint, bigInteger, importPoint, bigInteger2));
    }

    public static ECPoint validatePoint(ECPoint eCPoint) {
        if (eCPoint.isValid()) {
            return eCPoint;
        }
        throw new IllegalArgumentException("Invalid point");
    }

    public static void montgomeryTrick(ECFieldElement[] eCFieldElementArr, int i2, int i3, ECFieldElement eCFieldElement) {
        ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[i3];
        int i4 = 0;
        eCFieldElementArr2[0] = eCFieldElementArr[i2];
        while (true) {
            i4++;
            if (i4 >= i3) {
                break;
            }
            eCFieldElementArr2[i4] = eCFieldElementArr2[i4 - 1].multiply(eCFieldElementArr[i2 + i4]);
        }
        int i5 = i4 - 1;
        if (eCFieldElement != null) {
            eCFieldElementArr2[i5] = eCFieldElementArr2[i5].multiply(eCFieldElement);
        }
        ECFieldElement invert = eCFieldElementArr2[i5].invert();
        while (i5 > 0) {
            int i6 = i5 - 1;
            int i7 = i5 + i2;
            ECFieldElement eCFieldElement2 = eCFieldElementArr[i7];
            eCFieldElementArr[i7] = eCFieldElementArr2[i6].multiply(invert);
            invert = invert.multiply(eCFieldElement2);
            i5 = i6;
        }
        eCFieldElementArr[i2] = invert;
    }

    static ECPoint implSumOfMultiplies(ECPoint[] eCPointArr, ECPointMap eCPointMap, BigInteger[] bigIntegerArr) {
        int length = eCPointArr.length;
        int i2 = length << 1;
        boolean[] zArr = new boolean[i2];
        WNafPreCompInfo[] wNafPreCompInfoArr = new WNafPreCompInfo[i2];
        byte[][] bArr = new byte[i2];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 << 1;
            int i5 = i4 + 1;
            BigInteger bigInteger = bigIntegerArr[i4];
            zArr[i4] = bigInteger.signum() < 0;
            BigInteger abs = bigInteger.abs();
            BigInteger bigInteger2 = bigIntegerArr[i5];
            zArr[i5] = bigInteger2.signum() < 0;
            BigInteger abs2 = bigInteger2.abs();
            int max = Math.max(2, Math.min(16, WNafUtil.getWindowSize(Math.max(abs.bitLength(), abs2.bitLength()))));
            ECPoint eCPoint = eCPointArr[i3];
            ECPoint mapPointWithPrecomp = WNafUtil.mapPointWithPrecomp(eCPoint, max, true, eCPointMap);
            wNafPreCompInfoArr[i4] = WNafUtil.getWNafPreCompInfo(eCPoint);
            wNafPreCompInfoArr[i5] = WNafUtil.getWNafPreCompInfo(mapPointWithPrecomp);
            bArr[i4] = WNafUtil.generateWindowNaf(max, abs);
            bArr[i5] = WNafUtil.generateWindowNaf(max, abs2);
        }
        return implSumOfMultiplies(zArr, wNafPreCompInfoArr, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ECPoint implShamirsTrickWNaf(ECPoint eCPoint, BigInteger bigInteger, ECPointMap eCPointMap, BigInteger bigInteger2) {
        boolean z = bigInteger.signum() < 0;
        boolean z2 = bigInteger2.signum() < 0;
        BigInteger abs = bigInteger.abs();
        BigInteger abs2 = bigInteger2.abs();
        int max = Math.max(2, Math.min(16, WNafUtil.getWindowSize(Math.max(abs.bitLength(), abs2.bitLength()))));
        ECPoint mapPointWithPrecomp = WNafUtil.mapPointWithPrecomp(eCPoint, max, true, eCPointMap);
        WNafPreCompInfo wNafPreCompInfo = WNafUtil.getWNafPreCompInfo(eCPoint);
        WNafPreCompInfo wNafPreCompInfo2 = WNafUtil.getWNafPreCompInfo(mapPointWithPrecomp);
        return implShamirsTrickWNaf(z ? wNafPreCompInfo.getPreCompNeg() : wNafPreCompInfo.getPreComp(), z ? wNafPreCompInfo.getPreComp() : wNafPreCompInfo.getPreCompNeg(), WNafUtil.generateWindowNaf(max, abs), z2 ? wNafPreCompInfo2.getPreCompNeg() : wNafPreCompInfo2.getPreComp(), z2 ? wNafPreCompInfo2.getPreComp() : wNafPreCompInfo2.getPreCompNeg(), WNafUtil.generateWindowNaf(max, abs2));
    }

    private static ECPoint implSumOfMultiplies(boolean[] zArr, WNafPreCompInfo[] wNafPreCompInfoArr, byte[][] bArr) {
        int length = bArr.length;
        int i2 = 0;
        for (byte[] bArr2 : bArr) {
            i2 = Math.max(i2, bArr2.length);
        }
        ECPoint infinity = wNafPreCompInfoArr[0].getPreComp()[0].getCurve().getInfinity();
        int i3 = i2 - 1;
        int i4 = 0;
        ECPoint eCPoint = infinity;
        while (i3 >= 0) {
            ECPoint eCPoint2 = infinity;
            for (int i5 = 0; i5 < length; i5++) {
                byte[] bArr3 = bArr[i5];
                byte b2 = i3 < bArr3.length ? bArr3[i3] : (byte) 0;
                if (b2 != 0) {
                    int abs = Math.abs((int) b2);
                    WNafPreCompInfo wNafPreCompInfo = wNafPreCompInfoArr[i5];
                    eCPoint2 = eCPoint2.add(((b2 < 0) == zArr[i5] ? wNafPreCompInfo.getPreComp() : wNafPreCompInfo.getPreCompNeg())[abs >>> 1]);
                }
            }
            if (eCPoint2 == infinity) {
                i4++;
            } else {
                if (i4 > 0) {
                    eCPoint = eCPoint.timesPow2(i4);
                    i4 = 0;
                }
                eCPoint = eCPoint.twicePlus(eCPoint2);
            }
            i3--;
        }
        return i4 > 0 ? eCPoint.timesPow2(i4) : eCPoint;
    }

    private static ECPoint implShamirsTrickWNaf(ECPoint[] eCPointArr, ECPoint[] eCPointArr2, byte[] bArr, ECPoint[] eCPointArr3, ECPoint[] eCPointArr4, byte[] bArr2) {
        ECPoint eCPoint;
        int max = Math.max(bArr.length, bArr2.length);
        ECPoint infinity = eCPointArr[0].getCurve().getInfinity();
        int i2 = max - 1;
        int i3 = 0;
        ECPoint eCPoint2 = infinity;
        while (i2 >= 0) {
            byte b2 = i2 < bArr.length ? bArr[i2] : (byte) 0;
            byte b3 = i2 < bArr2.length ? bArr2[i2] : (byte) 0;
            if ((b2 | b3) == 0) {
                i3++;
            } else {
                if (b2 != 0) {
                    eCPoint = infinity.add((b2 < 0 ? eCPointArr2 : eCPointArr)[Math.abs((int) b2) >>> 1]);
                } else {
                    eCPoint = infinity;
                }
                if (b3 != 0) {
                    eCPoint = eCPoint.add((b3 < 0 ? eCPointArr4 : eCPointArr3)[Math.abs((int) b3) >>> 1]);
                }
                if (i3 > 0) {
                    eCPoint2 = eCPoint2.timesPow2(i3);
                    i3 = 0;
                }
                eCPoint2 = eCPoint2.twicePlus(eCPoint);
            }
            i2--;
        }
        return i3 > 0 ? eCPoint2.timesPow2(i3) : eCPoint2;
    }
}