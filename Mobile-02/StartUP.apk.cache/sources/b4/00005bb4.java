package org.apache.commons.lang3.b;

import java.util.Comparator;

/* compiled from: CompareToBuilder.java */
/* loaded from: classes3.dex */
public class a {
    private int a = 0;

    private void t(Object obj, Object obj2, Comparator<?> comparator) {
        if (obj instanceof long[]) {
            p((long[]) obj, (long[]) obj2);
        } else if (obj instanceof int[]) {
            o((int[]) obj, (int[]) obj2);
        } else if (obj instanceof short[]) {
            r((short[]) obj, (short[]) obj2);
        } else if (obj instanceof char[]) {
            l((char[]) obj, (char[]) obj2);
        } else if (obj instanceof byte[]) {
            k((byte[]) obj, (byte[]) obj2);
        } else if (obj instanceof double[]) {
            m((double[]) obj, (double[]) obj2);
        } else if (obj instanceof float[]) {
            n((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            s((boolean[]) obj, (boolean[]) obj2);
        } else {
            q((Object[]) obj, (Object[]) obj2, comparator);
        }
    }

    public a a(byte b2, byte b3) {
        if (this.a != 0) {
            return this;
        }
        this.a = b2 < b3 ? -1 : b2 > b3 ? 1 : 0;
        return this;
    }

    public a b(char c2, char c3) {
        if (this.a != 0) {
            return this;
        }
        this.a = c2 < c3 ? -1 : c2 > c3 ? 1 : 0;
        return this;
    }

    public a c(double d2, double d3) {
        if (this.a != 0) {
            return this;
        }
        this.a = Double.compare(d2, d3);
        return this;
    }

    public a d(float f2, float f3) {
        if (this.a != 0) {
            return this;
        }
        this.a = Float.compare(f2, f3);
        return this;
    }

    public a e(int i2, int i3) {
        if (this.a != 0) {
            return this;
        }
        this.a = i2 < i3 ? -1 : i2 > i3 ? 1 : 0;
        return this;
    }

    public a f(long j2, long j3) {
        if (this.a != 0) {
            return this;
        }
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        this.a = i2 < 0 ? -1 : i2 > 0 ? 1 : 0;
        return this;
    }

    public a g(Object obj, Object obj2) {
        return h(obj, obj2, null);
    }

    public a h(Object obj, Object obj2, Comparator<?> comparator) {
        if (this.a == 0 && obj != obj2) {
            if (obj == null) {
                this.a = -1;
                return this;
            } else if (obj2 == null) {
                this.a = 1;
                return this;
            } else {
                if (obj.getClass().isArray()) {
                    t(obj, obj2, comparator);
                } else if (comparator == null) {
                    this.a = ((Comparable) obj).compareTo(obj2);
                } else {
                    this.a = comparator.compare(obj, obj2);
                }
                return this;
            }
        }
        return this;
    }

    public a i(short s, short s2) {
        if (this.a != 0) {
            return this;
        }
        this.a = s < s2 ? -1 : s > s2 ? 1 : 0;
        return this;
    }

    public a j(boolean z, boolean z2) {
        if (this.a == 0 && z != z2) {
            if (!z) {
                this.a = -1;
            } else {
                this.a = 1;
            }
            return this;
        }
        return this;
    }

    public a k(byte[] bArr, byte[] bArr2) {
        if (this.a == 0 && bArr != bArr2) {
            if (bArr == null) {
                this.a = -1;
                return this;
            } else if (bArr2 == null) {
                this.a = 1;
                return this;
            } else if (bArr.length != bArr2.length) {
                this.a = bArr.length >= bArr2.length ? 1 : -1;
                return this;
            } else {
                for (int i2 = 0; i2 < bArr.length && this.a == 0; i2++) {
                    a(bArr[i2], bArr2[i2]);
                }
                return this;
            }
        }
        return this;
    }

    public a l(char[] cArr, char[] cArr2) {
        if (this.a == 0 && cArr != cArr2) {
            if (cArr == null) {
                this.a = -1;
                return this;
            } else if (cArr2 == null) {
                this.a = 1;
                return this;
            } else if (cArr.length != cArr2.length) {
                this.a = cArr.length >= cArr2.length ? 1 : -1;
                return this;
            } else {
                for (int i2 = 0; i2 < cArr.length && this.a == 0; i2++) {
                    b(cArr[i2], cArr2[i2]);
                }
                return this;
            }
        }
        return this;
    }

    public a m(double[] dArr, double[] dArr2) {
        if (this.a == 0 && dArr != dArr2) {
            if (dArr == null) {
                this.a = -1;
                return this;
            } else if (dArr2 == null) {
                this.a = 1;
                return this;
            } else if (dArr.length != dArr2.length) {
                this.a = dArr.length >= dArr2.length ? 1 : -1;
                return this;
            } else {
                for (int i2 = 0; i2 < dArr.length && this.a == 0; i2++) {
                    c(dArr[i2], dArr2[i2]);
                }
                return this;
            }
        }
        return this;
    }

    public a n(float[] fArr, float[] fArr2) {
        if (this.a == 0 && fArr != fArr2) {
            if (fArr == null) {
                this.a = -1;
                return this;
            } else if (fArr2 == null) {
                this.a = 1;
                return this;
            } else if (fArr.length != fArr2.length) {
                this.a = fArr.length >= fArr2.length ? 1 : -1;
                return this;
            } else {
                for (int i2 = 0; i2 < fArr.length && this.a == 0; i2++) {
                    d(fArr[i2], fArr2[i2]);
                }
                return this;
            }
        }
        return this;
    }

    public a o(int[] iArr, int[] iArr2) {
        if (this.a == 0 && iArr != iArr2) {
            if (iArr == null) {
                this.a = -1;
                return this;
            } else if (iArr2 == null) {
                this.a = 1;
                return this;
            } else if (iArr.length != iArr2.length) {
                this.a = iArr.length >= iArr2.length ? 1 : -1;
                return this;
            } else {
                for (int i2 = 0; i2 < iArr.length && this.a == 0; i2++) {
                    e(iArr[i2], iArr2[i2]);
                }
                return this;
            }
        }
        return this;
    }

    public a p(long[] jArr, long[] jArr2) {
        if (this.a == 0 && jArr != jArr2) {
            if (jArr == null) {
                this.a = -1;
                return this;
            } else if (jArr2 == null) {
                this.a = 1;
                return this;
            } else if (jArr.length != jArr2.length) {
                this.a = jArr.length >= jArr2.length ? 1 : -1;
                return this;
            } else {
                for (int i2 = 0; i2 < jArr.length && this.a == 0; i2++) {
                    f(jArr[i2], jArr2[i2]);
                }
                return this;
            }
        }
        return this;
    }

    public a q(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        if (this.a == 0 && objArr != objArr2) {
            if (objArr == null) {
                this.a = -1;
                return this;
            } else if (objArr2 == null) {
                this.a = 1;
                return this;
            } else if (objArr.length != objArr2.length) {
                this.a = objArr.length >= objArr2.length ? 1 : -1;
                return this;
            } else {
                for (int i2 = 0; i2 < objArr.length && this.a == 0; i2++) {
                    h(objArr[i2], objArr2[i2], comparator);
                }
                return this;
            }
        }
        return this;
    }

    public a r(short[] sArr, short[] sArr2) {
        if (this.a == 0 && sArr != sArr2) {
            if (sArr == null) {
                this.a = -1;
                return this;
            } else if (sArr2 == null) {
                this.a = 1;
                return this;
            } else if (sArr.length != sArr2.length) {
                this.a = sArr.length >= sArr2.length ? 1 : -1;
                return this;
            } else {
                for (int i2 = 0; i2 < sArr.length && this.a == 0; i2++) {
                    i(sArr[i2], sArr2[i2]);
                }
                return this;
            }
        }
        return this;
    }

    public a s(boolean[] zArr, boolean[] zArr2) {
        if (this.a == 0 && zArr != zArr2) {
            if (zArr == null) {
                this.a = -1;
                return this;
            } else if (zArr2 == null) {
                this.a = 1;
                return this;
            } else if (zArr.length != zArr2.length) {
                this.a = zArr.length >= zArr2.length ? 1 : -1;
                return this;
            } else {
                for (int i2 = 0; i2 < zArr.length && this.a == 0; i2++) {
                    j(zArr[i2], zArr2[i2]);
                }
                return this;
            }
        }
        return this;
    }

    public int u() {
        return this.a;
    }
}