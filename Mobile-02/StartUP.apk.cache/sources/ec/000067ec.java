package org.spongycastle.math.ec;

import java.math.BigInteger;

/* loaded from: classes3.dex */
public abstract class WNafUtil {
    private static final int[] DEFAULT_WINDOW_SIZE_CUTOFFS = {13, 41, 121, 337, 897, 2305};
    private static final byte[] EMPTY_BYTES = new byte[0];
    private static final int[] EMPTY_INTS = new int[0];
    private static final ECPoint[] EMPTY_POINTS = new ECPoint[0];
    public static final String PRECOMP_NAME = "bc_wnaf";

    public static int[] generateCompactNaf(BigInteger bigInteger) {
        if ((bigInteger.bitLength() >>> 16) == 0) {
            if (bigInteger.signum() == 0) {
                return EMPTY_INTS;
            }
            BigInteger add = bigInteger.shiftLeft(1).add(bigInteger);
            int bitLength = add.bitLength();
            int i2 = bitLength >> 1;
            int[] iArr = new int[i2];
            BigInteger xor = add.xor(bigInteger);
            int i3 = bitLength - 1;
            int i4 = 0;
            int i5 = 1;
            int i6 = 0;
            while (i5 < i3) {
                if (xor.testBit(i5)) {
                    iArr[i4] = i6 | ((bigInteger.testBit(i5) ? -1 : 1) << 16);
                    i5++;
                    i6 = 1;
                    i4++;
                } else {
                    i6++;
                }
                i5++;
            }
            int i7 = i4 + 1;
            iArr[i4] = 65536 | i6;
            return i2 > i7 ? trim(iArr, i7) : iArr;
        }
        throw new IllegalArgumentException("'k' must have bitlength < 2^16");
    }

    public static int[] generateCompactWindowNaf(int i2, BigInteger bigInteger) {
        if (i2 == 2) {
            return generateCompactNaf(bigInteger);
        }
        if (i2 >= 2 && i2 <= 16) {
            if ((bigInteger.bitLength() >>> 16) == 0) {
                if (bigInteger.signum() == 0) {
                    return EMPTY_INTS;
                }
                int bitLength = (bigInteger.bitLength() / i2) + 1;
                int[] iArr = new int[bitLength];
                int i3 = 1 << i2;
                int i4 = i3 - 1;
                int i5 = i3 >>> 1;
                int i6 = 0;
                int i7 = 0;
                boolean z = false;
                while (i6 <= bigInteger.bitLength()) {
                    if (bigInteger.testBit(i6) == z) {
                        i6++;
                    } else {
                        bigInteger = bigInteger.shiftRight(i6);
                        int intValue = bigInteger.intValue() & i4;
                        if (z) {
                            intValue++;
                        }
                        z = (intValue & i5) != 0;
                        if (z) {
                            intValue -= i3;
                        }
                        if (i7 > 0) {
                            i6--;
                        }
                        iArr[i7] = i6 | (intValue << 16);
                        i6 = i2;
                        i7++;
                    }
                }
                return bitLength > i7 ? trim(iArr, i7) : iArr;
            }
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        }
        throw new IllegalArgumentException("'width' must be in the range [2, 16]");
    }

    public static byte[] generateJSF(BigInteger bigInteger, BigInteger bigInteger2) {
        int max = Math.max(bigInteger.bitLength(), bigInteger2.bitLength()) + 1;
        byte[] bArr = new byte[max];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if ((i2 | i3) == 0 && bigInteger.bitLength() <= i4 && bigInteger2.bitLength() <= i4) {
                break;
            }
            int intValue = ((bigInteger.intValue() >>> i4) + i2) & 7;
            int intValue2 = ((bigInteger2.intValue() >>> i4) + i3) & 7;
            int i6 = intValue & 1;
            if (i6 != 0) {
                i6 -= intValue & 2;
                if (intValue + i6 == 4 && (intValue2 & 3) == 2) {
                    i6 = -i6;
                }
            }
            int i7 = intValue2 & 1;
            if (i7 != 0) {
                i7 -= intValue2 & 2;
                if (intValue2 + i7 == 4 && (intValue & 3) == 2) {
                    i7 = -i7;
                }
            }
            if ((i2 << 1) == i6 + 1) {
                i2 ^= 1;
            }
            if ((i3 << 1) == i7 + 1) {
                i3 ^= 1;
            }
            i4++;
            if (i4 == 30) {
                bigInteger = bigInteger.shiftRight(30);
                bigInteger2 = bigInteger2.shiftRight(30);
                i4 = 0;
            }
            bArr[i5] = (byte) ((i6 << 4) | (i7 & 15));
            i5++;
        }
        return max > i5 ? trim(bArr, i5) : bArr;
    }

    public static byte[] generateNaf(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return EMPTY_BYTES;
        }
        BigInteger add = bigInteger.shiftLeft(1).add(bigInteger);
        int bitLength = add.bitLength() - 1;
        byte[] bArr = new byte[bitLength];
        BigInteger xor = add.xor(bigInteger);
        int i2 = 1;
        while (i2 < bitLength) {
            if (xor.testBit(i2)) {
                bArr[i2 - 1] = (byte) (bigInteger.testBit(i2) ? -1 : 1);
                i2++;
            }
            i2++;
        }
        bArr[bitLength - 1] = 1;
        return bArr;
    }

    public static byte[] generateWindowNaf(int i2, BigInteger bigInteger) {
        if (i2 == 2) {
            return generateNaf(bigInteger);
        }
        if (i2 >= 2 && i2 <= 8) {
            if (bigInteger.signum() == 0) {
                return EMPTY_BYTES;
            }
            int bitLength = bigInteger.bitLength() + 1;
            byte[] bArr = new byte[bitLength];
            int i3 = 1 << i2;
            int i4 = i3 - 1;
            int i5 = i3 >>> 1;
            int i6 = 0;
            int i7 = 0;
            boolean z = false;
            while (i6 <= bigInteger.bitLength()) {
                if (bigInteger.testBit(i6) == z) {
                    i6++;
                } else {
                    bigInteger = bigInteger.shiftRight(i6);
                    int intValue = bigInteger.intValue() & i4;
                    if (z) {
                        intValue++;
                    }
                    z = (intValue & i5) != 0;
                    if (z) {
                        intValue -= i3;
                    }
                    if (i7 > 0) {
                        i6--;
                    }
                    int i8 = i7 + i6;
                    bArr[i8] = (byte) intValue;
                    i7 = i8 + 1;
                    i6 = i2;
                }
            }
            return bitLength > i7 ? trim(bArr, i7) : bArr;
        }
        throw new IllegalArgumentException("'width' must be in the range [2, 8]");
    }

    public static int getNafWeight(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return 0;
        }
        return bigInteger.shiftLeft(1).add(bigInteger).xor(bigInteger).bitCount();
    }

    public static WNafPreCompInfo getWNafPreCompInfo(ECPoint eCPoint) {
        return getWNafPreCompInfo(eCPoint.getCurve().getPreCompInfo(eCPoint, PRECOMP_NAME));
    }

    public static int getWindowSize(int i2) {
        return getWindowSize(i2, DEFAULT_WINDOW_SIZE_CUTOFFS);
    }

    public static ECPoint mapPointWithPrecomp(ECPoint eCPoint, int i2, boolean z, ECPointMap eCPointMap) {
        ECCurve curve = eCPoint.getCurve();
        WNafPreCompInfo precompute = precompute(eCPoint, i2, z);
        ECPoint map = eCPointMap.map(eCPoint);
        WNafPreCompInfo wNafPreCompInfo = getWNafPreCompInfo(curve.getPreCompInfo(map, PRECOMP_NAME));
        ECPoint twice = precompute.getTwice();
        if (twice != null) {
            wNafPreCompInfo.setTwice(eCPointMap.map(twice));
        }
        ECPoint[] preComp = precompute.getPreComp();
        int length = preComp.length;
        ECPoint[] eCPointArr = new ECPoint[length];
        for (int i3 = 0; i3 < preComp.length; i3++) {
            eCPointArr[i3] = eCPointMap.map(preComp[i3]);
        }
        wNafPreCompInfo.setPreComp(eCPointArr);
        if (z) {
            ECPoint[] eCPointArr2 = new ECPoint[length];
            for (int i4 = 0; i4 < length; i4++) {
                eCPointArr2[i4] = eCPointArr[i4].negate();
            }
            wNafPreCompInfo.setPreCompNeg(eCPointArr2);
        }
        curve.setPreCompInfo(map, PRECOMP_NAME, wNafPreCompInfo);
        return map;
    }

    public static WNafPreCompInfo precompute(ECPoint eCPoint, int i2, boolean z) {
        int length;
        int i3;
        int coordinateSystem;
        ECCurve curve = eCPoint.getCurve();
        WNafPreCompInfo wNafPreCompInfo = getWNafPreCompInfo(curve.getPreCompInfo(eCPoint, PRECOMP_NAME));
        int i4 = 0;
        int max = 1 << Math.max(0, i2 - 2);
        ECPoint[] preComp = wNafPreCompInfo.getPreComp();
        if (preComp == null) {
            preComp = EMPTY_POINTS;
            length = 0;
        } else {
            length = preComp.length;
        }
        if (length < max) {
            preComp = resizeTable(preComp, max);
            if (max == 1) {
                preComp[0] = eCPoint.normalize();
            } else {
                if (length == 0) {
                    preComp[0] = eCPoint;
                    i3 = 1;
                } else {
                    i3 = length;
                }
                ECFieldElement eCFieldElement = null;
                if (max == 2) {
                    preComp[1] = eCPoint.threeTimes();
                } else {
                    ECPoint twice = wNafPreCompInfo.getTwice();
                    ECPoint eCPoint2 = preComp[i3 - 1];
                    if (twice == null) {
                        twice = preComp[0].twice();
                        wNafPreCompInfo.setTwice(twice);
                        if (ECAlgorithms.isFpCurve(curve) && curve.getFieldSize() >= 64 && ((coordinateSystem = curve.getCoordinateSystem()) == 2 || coordinateSystem == 3 || coordinateSystem == 4)) {
                            ECFieldElement zCoord = twice.getZCoord(0);
                            twice = curve.createPoint(twice.getXCoord().toBigInteger(), twice.getYCoord().toBigInteger());
                            ECFieldElement square = zCoord.square();
                            eCPoint2 = eCPoint2.scaleX(square).scaleY(square.multiply(zCoord));
                            if (length == 0) {
                                preComp[0] = eCPoint2;
                            }
                            eCFieldElement = zCoord;
                        }
                    }
                    while (i3 < max) {
                        eCPoint2 = eCPoint2.add(twice);
                        preComp[i3] = eCPoint2;
                        i3++;
                    }
                }
                curve.normalizeAll(preComp, length, max - length, eCFieldElement);
            }
        }
        wNafPreCompInfo.setPreComp(preComp);
        if (z) {
            ECPoint[] preCompNeg = wNafPreCompInfo.getPreCompNeg();
            if (preCompNeg == null) {
                preCompNeg = new ECPoint[max];
            } else {
                i4 = preCompNeg.length;
                if (i4 < max) {
                    preCompNeg = resizeTable(preCompNeg, max);
                }
            }
            while (i4 < max) {
                preCompNeg[i4] = preComp[i4].negate();
                i4++;
            }
            wNafPreCompInfo.setPreCompNeg(preCompNeg);
        }
        curve.setPreCompInfo(eCPoint, PRECOMP_NAME, wNafPreCompInfo);
        return wNafPreCompInfo;
    }

    private static ECPoint[] resizeTable(ECPoint[] eCPointArr, int i2) {
        ECPoint[] eCPointArr2 = new ECPoint[i2];
        System.arraycopy(eCPointArr, 0, eCPointArr2, 0, eCPointArr.length);
        return eCPointArr2;
    }

    private static byte[] trim(byte[] bArr, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }

    public static WNafPreCompInfo getWNafPreCompInfo(PreCompInfo preCompInfo) {
        if (preCompInfo != null && (preCompInfo instanceof WNafPreCompInfo)) {
            return (WNafPreCompInfo) preCompInfo;
        }
        return new WNafPreCompInfo();
    }

    public static int getWindowSize(int i2, int[] iArr) {
        int i3 = 0;
        while (i3 < iArr.length && i2 >= iArr[i3]) {
            i3++;
        }
        return i3 + 2;
    }

    private static int[] trim(int[] iArr, int i2) {
        int[] iArr2 = new int[i2];
        System.arraycopy(iArr, 0, iArr2, 0, i2);
        return iArr2;
    }
}