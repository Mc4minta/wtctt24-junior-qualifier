package com.rd.b.b;

import com.rd.b.b.b;
import com.rd.b.d.d;
import com.rd.b.d.k;

/* compiled from: AnimationController.java */
/* loaded from: classes2.dex */
public class a {
    private b a;

    /* renamed from: b  reason: collision with root package name */
    private b.a f10558b;

    /* renamed from: c  reason: collision with root package name */
    private com.rd.b.d.b f10559c;

    /* renamed from: d  reason: collision with root package name */
    private com.rd.c.c.a f10560d;

    /* renamed from: e  reason: collision with root package name */
    private float f10561e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10562f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimationController.java */
    /* renamed from: com.rd.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0224a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.rd.b.d.a.values().length];
            a = iArr;
            try {
                iArr[com.rd.b.d.a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.rd.b.d.a.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.rd.b.d.a.SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.rd.b.d.a.WORM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.rd.b.d.a.FILL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.rd.b.d.a.SLIDE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.rd.b.d.a.THIN_WORM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.rd.b.d.a.DROP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[com.rd.b.d.a.SWAP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[com.rd.b.d.a.SCALE_DOWN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public a(com.rd.c.c.a aVar, b.a aVar2) {
        this.a = new b(aVar2);
        this.f10558b = aVar2;
        this.f10560d = aVar;
    }

    private void a() {
        switch (C0224a.a[this.f10560d.b().ordinal()]) {
            case 1:
                this.f10558b.a(null);
                return;
            case 2:
                c();
                return;
            case 3:
                h();
                return;
            case 4:
                m();
                return;
            case 5:
                f();
                return;
            case 6:
                j();
                return;
            case 7:
                l();
                return;
            case 8:
                d();
                return;
            case 9:
                k();
                return;
            case 10:
                i();
                return;
            default:
                return;
        }
    }

    private void c() {
        int p = this.f10560d.p();
        int t = this.f10560d.t();
        com.rd.b.d.b b2 = this.a.a().l(t, p).b(this.f10560d.a());
        if (this.f10562f) {
            b2.d(this.f10561e);
        } else {
            b2.e();
        }
        this.f10559c = b2;
    }

    private void d() {
        int q = this.f10560d.z() ? this.f10560d.q() : this.f10560d.f();
        int r = this.f10560d.z() ? this.f10560d.r() : this.f10560d.q();
        int a = com.rd.e.a.a(this.f10560d, q);
        int a2 = com.rd.e.a.a(this.f10560d, r);
        int l2 = this.f10560d.l();
        int j2 = this.f10560d.j();
        if (this.f10560d.g() != com.rd.c.c.b.HORIZONTAL) {
            l2 = j2;
        }
        int m = this.f10560d.m();
        d m2 = this.a.b().i(this.f10560d.a()).m(a, a2, (m * 3) + l2, m + l2, m);
        if (this.f10562f) {
            m2.d(this.f10561e);
        } else {
            m2.e();
        }
        this.f10559c = m2;
    }

    private void f() {
        int p = this.f10560d.p();
        int t = this.f10560d.t();
        int m = this.f10560d.m();
        int s = this.f10560d.s();
        com.rd.b.d.b b2 = this.a.c().q(t, p, m, s).b(this.f10560d.a());
        if (this.f10562f) {
            b2.d(this.f10561e);
        } else {
            b2.e();
        }
        this.f10559c = b2;
    }

    private void h() {
        int p = this.f10560d.p();
        int t = this.f10560d.t();
        int m = this.f10560d.m();
        float o = this.f10560d.o();
        com.rd.b.d.b b2 = this.a.d().p(t, p, m, o).b(this.f10560d.a());
        if (this.f10562f) {
            b2.d(this.f10561e);
        } else {
            b2.e();
        }
        this.f10559c = b2;
    }

    private void i() {
        int p = this.f10560d.p();
        int t = this.f10560d.t();
        int m = this.f10560d.m();
        float o = this.f10560d.o();
        com.rd.b.d.b b2 = this.a.e().p(t, p, m, o).b(this.f10560d.a());
        if (this.f10562f) {
            b2.d(this.f10561e);
        } else {
            b2.e();
        }
        this.f10559c = b2;
    }

    private void j() {
        int q = this.f10560d.z() ? this.f10560d.q() : this.f10560d.f();
        int r = this.f10560d.z() ? this.f10560d.r() : this.f10560d.q();
        com.rd.b.d.b b2 = this.a.f().l(com.rd.e.a.a(this.f10560d, q), com.rd.e.a.a(this.f10560d, r)).b(this.f10560d.a());
        if (this.f10562f) {
            b2.d(this.f10561e);
        } else {
            b2.e();
        }
        this.f10559c = b2;
    }

    private void k() {
        int q = this.f10560d.z() ? this.f10560d.q() : this.f10560d.f();
        int r = this.f10560d.z() ? this.f10560d.r() : this.f10560d.q();
        com.rd.b.d.b b2 = this.a.g().l(com.rd.e.a.a(this.f10560d, q), com.rd.e.a.a(this.f10560d, r)).b(this.f10560d.a());
        if (this.f10562f) {
            b2.d(this.f10561e);
        } else {
            b2.e();
        }
        this.f10559c = b2;
    }

    private void l() {
        int q = this.f10560d.z() ? this.f10560d.q() : this.f10560d.f();
        int r = this.f10560d.z() ? this.f10560d.r() : this.f10560d.q();
        int a = com.rd.e.a.a(this.f10560d, q);
        int a2 = com.rd.e.a.a(this.f10560d, r);
        boolean z = r > q;
        k j2 = this.a.h().n(a, a2, this.f10560d.m(), z).j(this.f10560d.a());
        if (this.f10562f) {
            j2.d(this.f10561e);
        } else {
            j2.e();
        }
        this.f10559c = j2;
    }

    private void m() {
        int q = this.f10560d.z() ? this.f10560d.q() : this.f10560d.f();
        int r = this.f10560d.z() ? this.f10560d.r() : this.f10560d.q();
        int a = com.rd.e.a.a(this.f10560d, q);
        int a2 = com.rd.e.a.a(this.f10560d, r);
        boolean z = r > q;
        k j2 = this.a.i().n(a, a2, this.f10560d.m(), z).j(this.f10560d.a());
        if (this.f10562f) {
            j2.d(this.f10561e);
        } else {
            j2.e();
        }
        this.f10559c = j2;
    }

    public void b() {
        this.f10562f = false;
        this.f10561e = 0.0f;
        a();
    }

    public void e() {
        com.rd.b.d.b bVar = this.f10559c;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void g(float f2) {
        this.f10562f = true;
        this.f10561e = f2;
        a();
    }
}