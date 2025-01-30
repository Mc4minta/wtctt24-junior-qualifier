package com.google.zxing.q.m;

import com.google.zxing.NotFoundException;
import com.google.zxing.m;

/* compiled from: WhiteRectangleDetector.java */
/* loaded from: classes2.dex */
public final class b {
    private final com.google.zxing.q.b a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9951b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9952c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9953d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9954e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9955f;

    /* renamed from: g  reason: collision with root package name */
    private final int f9956g;

    public b(com.google.zxing.q.b bVar) throws NotFoundException {
        this(bVar, 10, bVar.n() / 2, bVar.i() / 2);
    }

    private m[] a(m mVar, m mVar2, m mVar3, m mVar4) {
        float c2 = mVar.c();
        float d2 = mVar.d();
        float c3 = mVar2.c();
        float d3 = mVar2.d();
        float c4 = mVar3.c();
        float d4 = mVar3.d();
        float c5 = mVar4.c();
        float d5 = mVar4.d();
        return c2 < ((float) this.f9952c) / 2.0f ? new m[]{new m(c5 - 1.0f, d5 + 1.0f), new m(c3 + 1.0f, d3 + 1.0f), new m(c4 - 1.0f, d4 - 1.0f), new m(c2 + 1.0f, d2 - 1.0f)} : new m[]{new m(c5 + 1.0f, d5 + 1.0f), new m(c3 + 1.0f, d3 - 1.0f), new m(c4 - 1.0f, d4 + 1.0f), new m(c2 - 1.0f, d2 - 1.0f)};
    }

    private boolean b(int i2, int i3, int i4, boolean z) {
        if (z) {
            while (i2 <= i3) {
                if (this.a.e(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.a.e(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }

    private m d(float f2, float f3, float f4, float f5) {
        int c2 = a.c(a.a(f2, f3, f4, f5));
        float f6 = c2;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i2 = 0; i2 < c2; i2++) {
            float f9 = i2;
            int c3 = a.c((f9 * f7) + f2);
            int c4 = a.c((f9 * f8) + f3);
            if (this.a.e(c3, c4)) {
                return new m(c3, c4);
            }
        }
        return null;
    }

    public m[] c() throws NotFoundException {
        int i2 = this.f9953d;
        int i3 = this.f9954e;
        int i4 = this.f9956g;
        int i5 = this.f9955f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = true;
        while (z7) {
            boolean z8 = false;
            boolean z9 = true;
            while (true) {
                if ((z9 || !z2) && i3 < this.f9952c) {
                    z9 = b(i4, i5, i3, false);
                    if (z9) {
                        i3++;
                        z2 = true;
                        z8 = true;
                    } else if (!z2) {
                        i3++;
                    }
                }
            }
            if (i3 < this.f9952c) {
                boolean z10 = true;
                while (true) {
                    if ((z10 || !z3) && i5 < this.f9951b) {
                        z10 = b(i2, i3, i5, true);
                        if (z10) {
                            i5++;
                            z3 = true;
                            z8 = true;
                        } else if (!z3) {
                            i5++;
                        }
                    }
                }
                if (i5 < this.f9951b) {
                    boolean z11 = true;
                    while (true) {
                        if ((z11 || !z4) && i2 >= 0) {
                            z11 = b(i4, i5, i2, false);
                            if (z11) {
                                i2--;
                                z4 = true;
                                z8 = true;
                            } else if (!z4) {
                                i2--;
                            }
                        }
                    }
                    if (i2 >= 0) {
                        z7 = z8;
                        boolean z12 = true;
                        while (true) {
                            if ((z12 || !z6) && i4 >= 0) {
                                z12 = b(i2, i3, i4, true);
                                if (z12) {
                                    i4--;
                                    z7 = true;
                                    z6 = true;
                                } else if (!z6) {
                                    i4--;
                                }
                            }
                        }
                        if (i4 >= 0) {
                            if (z7) {
                                z5 = true;
                            }
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z || !z5) {
            throw NotFoundException.a();
        }
        int i6 = i3 - i2;
        m mVar = null;
        m mVar2 = null;
        for (int i7 = 1; mVar2 == null && i7 < i6; i7++) {
            mVar2 = d(i2, i5 - i7, i2 + i7, i5);
        }
        if (mVar2 != null) {
            m mVar3 = null;
            for (int i8 = 1; mVar3 == null && i8 < i6; i8++) {
                mVar3 = d(i2, i4 + i8, i2 + i8, i4);
            }
            if (mVar3 != null) {
                m mVar4 = null;
                for (int i9 = 1; mVar4 == null && i9 < i6; i9++) {
                    mVar4 = d(i3, i4 + i9, i3 - i9, i4);
                }
                if (mVar4 != null) {
                    for (int i10 = 1; mVar == null && i10 < i6; i10++) {
                        mVar = d(i3, i5 - i10, i3 - i10, i5);
                    }
                    if (mVar != null) {
                        return a(mVar, mVar2, mVar4, mVar3);
                    }
                    throw NotFoundException.a();
                }
                throw NotFoundException.a();
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    public b(com.google.zxing.q.b bVar, int i2, int i3, int i4) throws NotFoundException {
        this.a = bVar;
        int i5 = bVar.i();
        this.f9951b = i5;
        int n = bVar.n();
        this.f9952c = n;
        int i6 = i2 / 2;
        int i7 = i3 - i6;
        this.f9953d = i7;
        int i8 = i3 + i6;
        this.f9954e = i8;
        int i9 = i4 - i6;
        this.f9956g = i9;
        int i10 = i4 + i6;
        this.f9955f = i10;
        if (i9 < 0 || i7 < 0 || i10 >= i5 || i8 >= n) {
            throw NotFoundException.a();
        }
    }
}