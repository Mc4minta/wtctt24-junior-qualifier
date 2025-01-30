package com.google.zxing.v.d;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.m;
import com.google.zxing.n;
import com.google.zxing.q.g;
import com.google.zxing.q.i;
import com.google.zxing.q.k;
import com.google.zxing.v.c.j;
import java.util.Map;

/* compiled from: Detector.java */
/* loaded from: classes2.dex */
public class c {
    private final com.google.zxing.q.b a;

    /* renamed from: b  reason: collision with root package name */
    private n f10161b;

    public c(com.google.zxing.q.b bVar) {
        this.a = bVar;
    }

    private float b(m mVar, m mVar2) {
        float j2 = j((int) mVar.c(), (int) mVar.d(), (int) mVar2.c(), (int) mVar2.d());
        float j3 = j((int) mVar2.c(), (int) mVar2.d(), (int) mVar.c(), (int) mVar.d());
        return Float.isNaN(j2) ? j3 / 7.0f : Float.isNaN(j3) ? j2 / 7.0f : (j2 + j3) / 14.0f;
    }

    private static int c(m mVar, m mVar2, m mVar3, float f2) throws NotFoundException {
        int c2 = ((com.google.zxing.q.m.a.c(m.b(mVar, mVar2) / f2) + com.google.zxing.q.m.a.c(m.b(mVar, mVar3) / f2)) / 2) + 7;
        int i2 = c2 & 3;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return c2;
                }
                throw NotFoundException.a();
            }
            return c2 - 1;
        }
        return c2 + 1;
    }

    private static k d(m mVar, m mVar2, m mVar3, m mVar4, int i2) {
        float c2;
        float d2;
        float f2;
        float f3 = i2 - 3.5f;
        if (mVar4 != null) {
            c2 = mVar4.c();
            d2 = mVar4.d();
            f2 = f3 - 3.0f;
        } else {
            c2 = (mVar2.c() - mVar.c()) + mVar3.c();
            d2 = (mVar2.d() - mVar.d()) + mVar3.d();
            f2 = f3;
        }
        return k.b(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, mVar.c(), mVar.d(), mVar2.c(), mVar2.d(), c2, d2, mVar3.c(), mVar3.d());
    }

    private static com.google.zxing.q.b h(com.google.zxing.q.b bVar, k kVar, int i2) throws NotFoundException {
        return i.b().d(bVar, i2, i2, kVar);
    }

    private float i(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        c cVar;
        boolean z;
        boolean z2;
        boolean z3 = true;
        boolean z4 = Math.abs(i5 - i3) > Math.abs(i4 - i2);
        if (z4) {
            i7 = i2;
            i6 = i3;
            i9 = i4;
            i8 = i5;
        } else {
            i6 = i2;
            i7 = i3;
            i8 = i4;
            i9 = i5;
        }
        int abs = Math.abs(i8 - i6);
        int abs2 = Math.abs(i9 - i7);
        int i12 = 2;
        int i13 = (-abs) / 2;
        int i14 = i6 < i8 ? 1 : -1;
        int i15 = i7 < i9 ? 1 : -1;
        int i16 = i8 + i14;
        int i17 = i6;
        int i18 = i7;
        int i19 = 0;
        while (true) {
            if (i17 == i16) {
                i10 = i16;
                i11 = i12;
                break;
            }
            int i20 = z4 ? i18 : i17;
            int i21 = z4 ? i17 : i18;
            if (i19 == z3) {
                z = z4;
                z2 = z3;
                i10 = i16;
                cVar = this;
            } else {
                cVar = this;
                z = z4;
                i10 = i16;
                z2 = false;
            }
            if (z2 == cVar.a.e(i20, i21)) {
                if (i19 == 2) {
                    return com.google.zxing.q.m.a.b(i17, i18, i6, i7);
                }
                i19++;
            }
            i13 += abs2;
            if (i13 > 0) {
                if (i18 == i9) {
                    i11 = 2;
                    break;
                }
                i18 += i15;
                i13 -= abs;
            }
            i17 += i14;
            i16 = i10;
            z4 = z;
            z3 = true;
            i12 = 2;
        }
        if (i19 == i11) {
            return com.google.zxing.q.m.a.b(i10, i9, i6, i7);
        }
        return Float.NaN;
    }

    private float j(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float i6 = i(i2, i3, i4, i5);
        int i7 = i2 - (i4 - i2);
        int i8 = 0;
        if (i7 < 0) {
            f2 = i2 / (i2 - i7);
            i7 = 0;
        } else if (i7 >= this.a.n()) {
            f2 = ((this.a.n() - 1) - i2) / (i7 - i2);
            i7 = this.a.n() - 1;
        } else {
            f2 = 1.0f;
        }
        float f4 = i3;
        int i9 = (int) (f4 - ((i5 - i3) * f2));
        if (i9 < 0) {
            f3 = f4 / (i3 - i9);
        } else if (i9 >= this.a.i()) {
            f3 = ((this.a.i() - 1) - i3) / (i9 - i3);
            i8 = this.a.i() - 1;
        } else {
            i8 = i9;
            f3 = 1.0f;
        }
        return (i6 + i(i2, i3, (int) (i2 + ((i7 - i2) * f3)), i8)) - 1.0f;
    }

    protected final float a(m mVar, m mVar2, m mVar3) {
        return (b(mVar, mVar2) + b(mVar, mVar3)) / 2.0f;
    }

    public final g e(Map<com.google.zxing.d, ?> map) throws NotFoundException, FormatException {
        n nVar = map == null ? null : (n) map.get(com.google.zxing.d.NEED_RESULT_POINT_CALLBACK);
        this.f10161b = nVar;
        return g(new e(this.a, nVar).f(map));
    }

    protected final a f(float f2, int i2, int i3, float f3) throws NotFoundException {
        int i4 = (int) (f3 * f2);
        int max = Math.max(0, i2 - i4);
        int min = Math.min(this.a.n() - 1, i2 + i4) - max;
        float f4 = 3.0f * f2;
        if (min >= f4) {
            int max2 = Math.max(0, i3 - i4);
            int min2 = Math.min(this.a.i() - 1, i3 + i4) - max2;
            if (min2 >= f4) {
                return new b(this.a, max, max2, min, min2, f2, this.f10161b).c();
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    protected final g g(f fVar) throws NotFoundException, FormatException {
        d b2 = fVar.b();
        d c2 = fVar.c();
        d a = fVar.a();
        float a2 = a(b2, c2, a);
        if (a2 >= 1.0f) {
            int c3 = c(b2, c2, a, a2);
            j g2 = j.g(c3);
            int e2 = g2.e() - 7;
            a aVar = null;
            if (g2.d().length > 0) {
                float c4 = (c2.c() - b2.c()) + a.c();
                float d2 = (c2.d() - b2.d()) + a.d();
                float f2 = 1.0f - (3.0f / e2);
                int c5 = (int) (b2.c() + ((c4 - b2.c()) * f2));
                int d3 = (int) (b2.d() + (f2 * (d2 - b2.d())));
                for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                    try {
                        aVar = f(a2, c5, d3, i2);
                        break;
                    } catch (NotFoundException unused) {
                    }
                }
            }
            return new g(h(this.a, d(b2, c2, a, aVar, c3), c3), aVar == null ? new m[]{a, b2, c2} : new m[]{a, b2, c2, aVar});
        }
        throw NotFoundException.a();
    }
}