package com.facebook.imagepipeline.memory;

/* compiled from: PoolFactory.java */
/* loaded from: classes2.dex */
public class d0 {
    private final c0 a;

    /* renamed from: b  reason: collision with root package name */
    private c f4590b;

    /* renamed from: c  reason: collision with root package name */
    private i f4591c;

    /* renamed from: d  reason: collision with root package name */
    private p f4592d;

    /* renamed from: e  reason: collision with root package name */
    private y f4593e;

    /* renamed from: f  reason: collision with root package name */
    private com.facebook.common.memory.g f4594f;

    /* renamed from: g  reason: collision with root package name */
    private com.facebook.common.memory.j f4595g;

    /* renamed from: h  reason: collision with root package name */
    private com.facebook.common.memory.a f4596h;

    public d0(c0 c0Var) {
        this.a = (c0) e.f.d.c.i.g(c0Var);
    }

    private u e(int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return b();
            }
            throw new IllegalArgumentException("Invalid MemoryChunkType");
        }
        return f();
    }

    public c a() {
        if (this.f4590b == null) {
            String e2 = this.a.e();
            char c2 = 65535;
            switch (e2.hashCode()) {
                case -1868884870:
                    if (e2.equals("legacy_default_params")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1106578487:
                    if (e2.equals("legacy")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -404562712:
                    if (e2.equals("experimental")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -402149703:
                    if (e2.equals("dummy_with_tracking")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 95945896:
                    if (e2.equals("dummy")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                this.f4590b = new n();
            } else if (c2 == 1) {
                this.f4590b = new o();
            } else if (c2 == 2) {
                this.f4590b = new r(this.a.b(), this.a.a(), z.h(), this.a.l() ? this.a.i() : null);
            } else if (c2 != 3) {
                this.f4590b = new g(this.a.i(), this.a.c(), this.a.d());
            } else {
                this.f4590b = new g(this.a.i(), j.a(), this.a.d());
            }
        }
        return this.f4590b;
    }

    public i b() {
        if (this.f4591c == null) {
            this.f4591c = new i(this.a.i(), this.a.g(), this.a.h());
        }
        return this.f4591c;
    }

    public p c() {
        if (this.f4592d == null) {
            this.f4592d = new p(this.a.i(), this.a.f());
        }
        return this.f4592d;
    }

    public int d() {
        return this.a.f().f4606g;
    }

    public y f() {
        if (this.f4593e == null) {
            this.f4593e = new y(this.a.i(), this.a.g(), this.a.h());
        }
        return this.f4593e;
    }

    public com.facebook.common.memory.g g() {
        return h(0);
    }

    public com.facebook.common.memory.g h(int i2) {
        if (this.f4594f == null) {
            this.f4594f = new x(e(i2), i());
        }
        return this.f4594f;
    }

    public com.facebook.common.memory.j i() {
        if (this.f4595g == null) {
            this.f4595g = new com.facebook.common.memory.j(j());
        }
        return this.f4595g;
    }

    public com.facebook.common.memory.a j() {
        if (this.f4596h == null) {
            this.f4596h = new q(this.a.i(), this.a.j(), this.a.k());
        }
        return this.f4596h;
    }
}