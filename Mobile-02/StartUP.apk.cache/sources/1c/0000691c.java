package org.spongycastle.pqc.math.linearalgebra;

import com.coinbase.wallet.core.extensions.Strings;
import java.math.BigInteger;
import java.security.SecureRandom;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes3.dex */
public class GF2nONBElement extends GF2nElement {
    private static final int MAXLONG = 64;
    private int mBit;
    private int mLength;
    private long[] mPol;
    private static final long[] mBitmask = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE, 2048, 4096, 8192, Http2Stream.EMIT_BUFFER_SIZE, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, 2147483648L, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, 1099511627776L, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L, 35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L, 2251799813685248L, 4503599627370496L, 9007199254740992L, 18014398509481984L, 36028797018963968L, 72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, 1152921504606846976L, 2305843009213693952L, 4611686018427387904L, Long.MIN_VALUE};
    private static final long[] mMaxmask = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, WebSocketProtocol.PAYLOAD_SHORT_MAX, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, 2147483647L, 4294967295L, 8589934591L, 17179869183L, 34359738367L, 68719476735L, 137438953471L, 274877906943L, 549755813887L, 1099511627775L, 2199023255551L, 4398046511103L, 8796093022207L, 17592186044415L, 35184372088831L, 70368744177663L, 140737488355327L, 281474976710655L, 562949953421311L, 1125899906842623L, 2251799813685247L, 4503599627370495L, 9007199254740991L, 18014398509481983L, 36028797018963967L, 72057594037927935L, 144115188075855871L, 288230376151711743L, 576460752303423487L, 1152921504606846975L, 2305843009213693951L, 4611686018427387903L, Long.MAX_VALUE, -1};
    private static final int[] mIBY64 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};

    public GF2nONBElement(GF2nONBField gF2nONBField, SecureRandom secureRandom) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        int i2 = this.mLength;
        long[] jArr = new long[i2];
        this.mPol = jArr;
        if (i2 > 1) {
            for (int i3 = 0; i3 < this.mLength - 1; i3++) {
                this.mPol[i3] = secureRandom.nextLong();
            }
            this.mPol[this.mLength - 1] = secureRandom.nextLong() >>> (64 - this.mBit);
            return;
        }
        jArr[0] = secureRandom.nextLong();
        long[] jArr2 = this.mPol;
        jArr2[0] = jArr2[0] >>> (64 - this.mBit);
    }

    public static GF2nONBElement ONE(GF2nONBField gF2nONBField) {
        int oNBLength = gF2nONBField.getONBLength();
        long[] jArr = new long[oNBLength];
        int i2 = 0;
        while (true) {
            int i3 = oNBLength - 1;
            if (i2 < i3) {
                jArr[i2] = -1;
                i2++;
            } else {
                jArr[i3] = mMaxmask[gF2nONBField.getONBBit() - 1];
                return new GF2nONBElement(gF2nONBField, jArr);
            }
        }
    }

    public static GF2nONBElement ZERO(GF2nONBField gF2nONBField) {
        return new GF2nONBElement(gF2nONBField, new long[gF2nONBField.getONBLength()]);
    }

    private void assign(BigInteger bigInteger) {
        assign(bigInteger.toByteArray());
    }

    private long[] getElement() {
        long[] jArr = this.mPol;
        long[] jArr2 = new long[jArr.length];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        return jArr2;
    }

    private long[] getElementReverseOrder() {
        long[] jArr = new long[this.mPol.length];
        int i2 = 0;
        while (true) {
            int i3 = this.mDegree;
            if (i2 >= i3) {
                return jArr;
            }
            if (testBit((i3 - i2) - 1)) {
                int i4 = i2 >>> 6;
                jArr[i4] = jArr[i4] | mBitmask[i2 & 63];
            }
            i2++;
        }
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public GFElement add(GFElement gFElement) throws RuntimeException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.addToThis(gFElement);
        return gF2nONBElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public void addToThis(GFElement gFElement) throws RuntimeException {
        if (gFElement instanceof GF2nONBElement) {
            GF2nONBElement gF2nONBElement = (GF2nONBElement) gFElement;
            if (this.mField.equals(gF2nONBElement.mField)) {
                for (int i2 = 0; i2 < this.mLength; i2++) {
                    long[] jArr = this.mPol;
                    jArr[i2] = jArr[i2] ^ gF2nONBElement.mPol[i2];
                }
                return;
            }
            throw new RuntimeException();
        }
        throw new RuntimeException();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    void assignOne() {
        int i2 = 0;
        while (true) {
            int i3 = this.mLength;
            if (i2 < i3 - 1) {
                this.mPol[i2] = -1;
                i2++;
            } else {
                this.mPol[i3 - 1] = mMaxmask[this.mBit - 1];
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public void assignZero() {
        this.mPol = new long[this.mLength];
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement, org.spongycastle.pqc.math.linearalgebra.GFElement
    public Object clone() {
        return new GF2nONBElement(this);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2nONBElement)) {
            return false;
        }
        GF2nONBElement gF2nONBElement = (GF2nONBElement) obj;
        for (int i2 = 0; i2 < this.mLength; i2++) {
            if (this.mPol[i2] != gF2nONBElement.mPol[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public int hashCode() {
        return this.mPol.hashCode();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement increase() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.increaseThis();
        return gF2nONBElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public void increaseThis() {
        addToThis(ONE((GF2nONBField) this.mField));
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public GFElement invert() throws ArithmeticException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.invertThis();
        return gF2nONBElement;
    }

    public void invertThis() throws ArithmeticException {
        if (!isZero()) {
            int i2 = 31;
            boolean z = false;
            while (!z && i2 >= 0) {
                if (((this.mDegree - 1) & mBitmask[i2]) != 0) {
                    z = true;
                }
                i2--;
            }
            ZERO((GF2nONBField) this.mField);
            GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
            int i3 = 1;
            for (int i4 = (i2 + 1) - 1; i4 >= 0; i4--) {
                GF2nElement gF2nElement = (GF2nElement) gF2nONBElement.clone();
                for (int i5 = 1; i5 <= i3; i5++) {
                    gF2nElement.squareThis();
                }
                gF2nONBElement.multiplyThisBy(gF2nElement);
                i3 <<= 1;
                if (((this.mDegree - 1) & mBitmask[i4]) != 0) {
                    gF2nONBElement.squareThis();
                    gF2nONBElement.multiplyThisBy(this);
                    i3++;
                }
            }
            gF2nONBElement.squareThis();
            return;
        }
        throw new ArithmeticException();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public boolean isOne() {
        int i2;
        boolean z = false;
        int i3 = 0;
        boolean z2 = true;
        while (true) {
            i2 = this.mLength;
            if (i3 >= i2 - 1 || !z2) {
                break;
            }
            z2 = z2 && (this.mPol[i3] & (-1)) == -1;
            i3++;
        }
        if (z2) {
            if (z2) {
                long j2 = this.mPol[i2 - 1];
                long[] jArr = mMaxmask;
                int i4 = this.mBit;
                if ((j2 & jArr[i4 - 1]) == jArr[i4 - 1]) {
                    z = true;
                }
            }
            return z;
        }
        return z2;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public boolean isZero() {
        boolean z = true;
        for (int i2 = 0; i2 < this.mLength && z; i2++) {
            z = z && (this.mPol[i2] & (-1)) == 0;
        }
        return z;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public GFElement multiply(GFElement gFElement) throws RuntimeException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.multiplyThisBy(gFElement);
        return gF2nONBElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public void multiplyThisBy(GFElement gFElement) throws RuntimeException {
        int i2;
        boolean z;
        char c2;
        if (gFElement instanceof GF2nONBElement) {
            GF2nONBElement gF2nONBElement = (GF2nONBElement) gFElement;
            if (this.mField.equals(gF2nONBElement.mField)) {
                if (equals(gFElement)) {
                    squareThis();
                    return;
                }
                long[] jArr = this.mPol;
                long[] jArr2 = gF2nONBElement.mPol;
                int i3 = this.mLength;
                long[] jArr3 = new long[i3];
                int[][] iArr = ((GF2nONBField) this.mField).mMult;
                int i4 = i3 - 1;
                long[] jArr4 = mBitmask;
                char c3 = '?';
                long j2 = jArr4[63];
                long j3 = jArr4[this.mBit - 1];
                int i5 = 0;
                int i6 = 0;
                while (i6 < this.mDegree) {
                    int i7 = i5;
                    int i8 = i7;
                    while (i7 < this.mDegree) {
                        int[] iArr2 = mIBY64;
                        int i9 = iArr2[i7];
                        int i10 = iArr2[iArr[i7][i5]];
                        int i11 = iArr[i7][i5] & 63;
                        long j4 = jArr[i9];
                        long[] jArr5 = mBitmask;
                        if ((j4 & jArr5[i7 & 63]) != 0) {
                            if ((jArr2[i10] & jArr5[i11]) != 0) {
                                i8 ^= 1;
                            }
                            if (iArr[i7][1] != -1) {
                                c2 = '?';
                                if ((jArr2[iArr2[iArr[i7][1]]] & jArr5[iArr[i7][1] & 63]) != 0) {
                                    i8 ^= 1;
                                }
                            } else {
                                c2 = '?';
                            }
                        } else {
                            c2 = c3;
                        }
                        i7++;
                        c3 = c2;
                        i5 = 0;
                    }
                    char c4 = c3;
                    int i12 = mIBY64[i6];
                    int i13 = i6 & 63;
                    if (i8 != 0) {
                        jArr3[i12] = jArr3[i12] ^ mBitmask[i13];
                    }
                    if (this.mLength > 1) {
                        boolean z2 = (jArr[i4] & 1) == 1;
                        int i14 = i4 - 1;
                        int i15 = i14;
                        while (i15 >= 0) {
                            boolean z3 = (jArr[i15] & 1) != 0;
                            jArr[i15] = jArr[i15] >>> 1;
                            if (z2) {
                                jArr[i15] = jArr[i15] ^ j2;
                            }
                            i15--;
                            z2 = z3;
                        }
                        jArr[i4] = jArr[i4] >>> 1;
                        if (z2) {
                            jArr[i4] = jArr[i4] ^ j3;
                        }
                        boolean z4 = (jArr2[i4] & 1) == 1;
                        while (i14 >= 0) {
                            boolean z5 = (jArr2[i14] & 1) != 0;
                            jArr2[i14] = jArr2[i14] >>> 1;
                            if (z4) {
                                jArr2[i14] = jArr2[i14] ^ j2;
                            }
                            i14--;
                            z4 = z5;
                        }
                        jArr2[i4] = jArr2[i4] >>> 1;
                        if (z4) {
                            jArr2[i4] = jArr2[i4] ^ j3;
                        }
                        i2 = 0;
                        z = true;
                    } else {
                        i2 = 0;
                        boolean z6 = (jArr[0] & 1) == 1;
                        jArr[0] = jArr[0] >>> 1;
                        if (z6) {
                            jArr[0] = jArr[0] ^ j3;
                        }
                        boolean z7 = (jArr2[0] & 1) == 1;
                        z = true;
                        jArr2[0] = jArr2[0] >>> 1;
                        if (z7) {
                            jArr2[0] = jArr2[0] ^ j3;
                        }
                    }
                    i6++;
                    i5 = i2;
                    c3 = c4;
                }
                assign(jArr3);
                return;
            }
            throw new RuntimeException();
        }
        throw new RuntimeException("The elements have different representation: not yet implemented");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reverseOrder() {
        this.mPol = getElementReverseOrder();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement solveQuadraticEquation() throws RuntimeException {
        int i2;
        int i3 = 1;
        if (trace() != 1) {
            long j2 = mBitmask[63];
            long[] jArr = new long[this.mLength];
            int i4 = 0;
            long j3 = 0;
            while (true) {
                i2 = this.mLength;
                if (i4 >= i2 - 1) {
                    break;
                }
                for (int i5 = i3; i5 < 64; i5++) {
                    long[] jArr2 = mBitmask;
                    long j4 = jArr2[i5];
                    long[] jArr3 = this.mPol;
                    if (((j4 & jArr3[i4]) == 0 || (jArr2[i5 - 1] & j3) == 0) && ((jArr3[i4] & jArr2[i5]) != 0 || (jArr2[i5 - 1] & j3) != 0)) {
                        j3 ^= jArr2[i5];
                    }
                }
                jArr[i4] = j3;
                int i6 = ((j3 & j2) > 0L ? 1 : ((j3 & j2) == 0L ? 0 : -1));
                j3 = ((i6 == 0 || (1 & this.mPol[i4 + 1]) != 1) && !(i6 == 0 && (this.mPol[i4 + 1] & 1) == 0)) ? 1L : 0L;
                i4++;
                i3 = 1;
            }
            int i7 = this.mDegree & 63;
            long j5 = this.mPol[i2 - 1];
            for (int i8 = 1; i8 < i7; i8++) {
                long[] jArr4 = mBitmask;
                if (((jArr4[i8] & j5) == 0 || (jArr4[i8 - 1] & j3) == 0) && ((jArr4[i8] & j5) != 0 || (jArr4[i8 - 1] & j3) != 0)) {
                    j3 ^= jArr4[i8];
                }
            }
            jArr[this.mLength - 1] = j3;
            return new GF2nONBElement((GF2nONBField) this.mField, jArr);
        }
        throw new RuntimeException();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement square() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.squareThis();
        return gF2nONBElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement squareRoot() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.squareRootThis();
        return gF2nONBElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public void squareRootThis() {
        long[] element = getElement();
        int i2 = this.mLength - 1;
        int i3 = this.mBit - 1;
        long j2 = mBitmask[63];
        boolean z = (element[0] & 1) != 0;
        int i4 = i2;
        while (i4 >= 0) {
            boolean z2 = (element[i4] & 1) != 0;
            element[i4] = element[i4] >>> 1;
            if (z) {
                if (i4 == i2) {
                    element[i4] = element[i4] ^ mBitmask[i3];
                } else {
                    element[i4] = element[i4] ^ j2;
                }
            }
            i4--;
            z = z2;
        }
        assign(element);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public void squareThis() {
        long[] element = getElement();
        int i2 = this.mLength - 1;
        int i3 = this.mBit - 1;
        long[] jArr = mBitmask;
        long j2 = jArr[63];
        boolean z = (element[i2] & jArr[i3]) != 0;
        int i4 = 0;
        while (i4 < i2) {
            boolean z2 = (element[i4] & j2) != 0;
            element[i4] = element[i4] << 1;
            if (z) {
                element[i4] = 1 ^ element[i4];
            }
            i4++;
            z = z2;
        }
        long j3 = element[i2];
        long[] jArr2 = mBitmask;
        boolean z3 = (j3 & jArr2[i3]) != 0;
        element[i2] = element[i2] << 1;
        if (z) {
            element[i2] = element[i2] ^ 1;
        }
        if (z3) {
            element[i2] = jArr2[i3 + 1] ^ element[i2];
        }
        assign(element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public boolean testBit(int i2) {
        return i2 >= 0 && i2 <= this.mDegree && (this.mPol[i2 >>> 6] & mBitmask[i2 & 63]) != 0;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public boolean testRightmostBit() {
        return (this.mPol[this.mLength - 1] & mBitmask[this.mBit - 1]) != 0;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public byte[] toByteArray() {
        int i2 = ((this.mDegree - 1) >> 3) + 1;
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (i3 & 7) << 3;
            bArr[(i2 - i3) - 1] = (byte) ((this.mPol[i3 >>> 3] & (255 << i4)) >>> i4);
        }
        return bArr;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public BigInteger toFlexiBigInt() {
        return new BigInteger(1, toByteArray());
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public String toString() {
        return toString(16);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public int trace() {
        int i2 = this.mLength - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < 64; i5++) {
                if ((this.mPol[i4] & mBitmask[i5]) != 0) {
                    i3 ^= 1;
                }
            }
        }
        int i6 = this.mBit;
        for (int i7 = 0; i7 < i6; i7++) {
            if ((this.mPol[i2] & mBitmask[i7]) != 0) {
                i3 ^= 1;
            }
        }
        return i3;
    }

    private void assign(long[] jArr) {
        System.arraycopy(jArr, 0, this.mPol, 0, this.mLength);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public String toString(int i2) {
        long[] element = getElement();
        int i3 = this.mBit;
        String str = "";
        if (i2 == 2) {
            while (true) {
                i3--;
                if (i3 < 0) {
                    break;
                }
                str = (element[element.length - 1] & (1 << i3)) == 0 ? str + Strings.zero : str + DiskLruCache.VERSION_1;
            }
            for (int length = element.length - 2; length >= 0; length--) {
                for (int i4 = 63; i4 >= 0; i4--) {
                    str = (element[length] & mBitmask[i4]) == 0 ? str + Strings.zero : str + DiskLruCache.VERSION_1;
                }
            }
        } else if (i2 == 16) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            for (int length2 = element.length - 1; length2 >= 0; length2--) {
                str = ((((((((((((((((str + cArr[((int) (element[length2] >>> 60)) & 15]) + cArr[((int) (element[length2] >>> 56)) & 15]) + cArr[((int) (element[length2] >>> 52)) & 15]) + cArr[((int) (element[length2] >>> 48)) & 15]) + cArr[((int) (element[length2] >>> 44)) & 15]) + cArr[((int) (element[length2] >>> 40)) & 15]) + cArr[((int) (element[length2] >>> 36)) & 15]) + cArr[((int) (element[length2] >>> 32)) & 15]) + cArr[((int) (element[length2] >>> 28)) & 15]) + cArr[((int) (element[length2] >>> 24)) & 15]) + cArr[((int) (element[length2] >>> 20)) & 15]) + cArr[((int) (element[length2] >>> 16)) & 15]) + cArr[((int) (element[length2] >>> 12)) & 15]) + cArr[((int) (element[length2] >>> 8)) & 15]) + cArr[((int) (element[length2] >>> 4)) & 15]) + cArr[((int) element[length2]) & 15]) + " ";
            }
        }
        return str;
    }

    private void assign(byte[] bArr) {
        this.mPol = new long[this.mLength];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            long[] jArr = this.mPol;
            int i3 = i2 >>> 3;
            jArr[i3] = jArr[i3] | ((bArr[(bArr.length - 1) - i2] & 255) << ((i2 & 7) << 3));
        }
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, byte[] bArr) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        this.mPol = new long[this.mLength];
        assign(bArr);
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, BigInteger bigInteger) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        this.mPol = new long[this.mLength];
        assign(bigInteger);
    }

    private GF2nONBElement(GF2nONBField gF2nONBField, long[] jArr) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        this.mPol = jArr;
    }

    public GF2nONBElement(GF2nONBElement gF2nONBElement) {
        GF2nField gF2nField = gF2nONBElement.mField;
        this.mField = gF2nField;
        this.mDegree = gF2nField.getDegree();
        this.mLength = ((GF2nONBField) this.mField).getONBLength();
        this.mBit = ((GF2nONBField) this.mField).getONBBit();
        this.mPol = new long[this.mLength];
        assign(gF2nONBElement.getElement());
    }
}