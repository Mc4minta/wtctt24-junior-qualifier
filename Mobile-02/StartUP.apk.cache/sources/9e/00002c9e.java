package com.facebook.imagepipeline.memory;

/* compiled from: PoolConfig.java */
/* loaded from: classes2.dex */
public class c0 {
    private final e0 a;

    /* renamed from: b  reason: collision with root package name */
    private final f0 f4568b;

    /* renamed from: c  reason: collision with root package name */
    private final e0 f4569c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.common.memory.c f4570d;

    /* renamed from: e  reason: collision with root package name */
    private final e0 f4571e;

    /* renamed from: f  reason: collision with root package name */
    private final f0 f4572f;

    /* renamed from: g  reason: collision with root package name */
    private final e0 f4573g;

    /* renamed from: h  reason: collision with root package name */
    private final f0 f4574h;

    /* renamed from: i  reason: collision with root package name */
    private final String f4575i;

    /* renamed from: j  reason: collision with root package name */
    private final int f4576j;

    /* renamed from: k  reason: collision with root package name */
    private final int f4577k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f4578l;

    /* compiled from: PoolConfig.java */
    /* loaded from: classes2.dex */
    public static class b {
        private e0 a;

        /* renamed from: b  reason: collision with root package name */
        private f0 f4579b;

        /* renamed from: c  reason: collision with root package name */
        private e0 f4580c;

        /* renamed from: d  reason: collision with root package name */
        private com.facebook.common.memory.c f4581d;

        /* renamed from: e  reason: collision with root package name */
        private e0 f4582e;

        /* renamed from: f  reason: collision with root package name */
        private f0 f4583f;

        /* renamed from: g  reason: collision with root package name */
        private e0 f4584g;

        /* renamed from: h  reason: collision with root package name */
        private f0 f4585h;

        /* renamed from: i  reason: collision with root package name */
        private String f4586i;

        /* renamed from: j  reason: collision with root package name */
        private int f4587j;

        /* renamed from: k  reason: collision with root package name */
        private int f4588k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f4589l;

        public c0 m() {
            return new c0(this);
        }

        private b() {
        }
    }

    public static b m() {
        return new b();
    }

    public int a() {
        return this.f4577k;
    }

    public int b() {
        return this.f4576j;
    }

    public e0 c() {
        return this.a;
    }

    public f0 d() {
        return this.f4568b;
    }

    public String e() {
        return this.f4575i;
    }

    public e0 f() {
        return this.f4569c;
    }

    public e0 g() {
        return this.f4571e;
    }

    public f0 h() {
        return this.f4572f;
    }

    public com.facebook.common.memory.c i() {
        return this.f4570d;
    }

    public e0 j() {
        return this.f4573g;
    }

    public f0 k() {
        return this.f4574h;
    }

    public boolean l() {
        return this.f4578l;
    }

    private c0(b bVar) {
        e0 e0Var;
        f0 f0Var;
        e0 e0Var2;
        com.facebook.common.memory.c cVar;
        e0 e0Var3;
        f0 f0Var2;
        e0 e0Var4;
        f0 f0Var3;
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("PoolConfig()");
        }
        if (bVar.a != null) {
            e0Var = bVar.a;
        } else {
            e0Var = j.a();
        }
        this.a = e0Var;
        if (bVar.f4579b != null) {
            f0Var = bVar.f4579b;
        } else {
            f0Var = z.h();
        }
        this.f4568b = f0Var;
        if (bVar.f4580c != null) {
            e0Var2 = bVar.f4580c;
        } else {
            e0Var2 = l.b();
        }
        this.f4569c = e0Var2;
        if (bVar.f4581d != null) {
            cVar = bVar.f4581d;
        } else {
            cVar = com.facebook.common.memory.d.b();
        }
        this.f4570d = cVar;
        if (bVar.f4582e != null) {
            e0Var3 = bVar.f4582e;
        } else {
            e0Var3 = m.a();
        }
        this.f4571e = e0Var3;
        if (bVar.f4583f != null) {
            f0Var2 = bVar.f4583f;
        } else {
            f0Var2 = z.h();
        }
        this.f4572f = f0Var2;
        if (bVar.f4584g != null) {
            e0Var4 = bVar.f4584g;
        } else {
            e0Var4 = k.a();
        }
        this.f4573g = e0Var4;
        if (bVar.f4585h != null) {
            f0Var3 = bVar.f4585h;
        } else {
            f0Var3 = z.h();
        }
        this.f4574h = f0Var3;
        this.f4575i = bVar.f4586i == null ? "legacy" : bVar.f4586i;
        this.f4576j = bVar.f4587j;
        this.f4577k = bVar.f4588k > 0 ? bVar.f4588k : 4194304;
        this.f4578l = bVar.f4589l;
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }
}