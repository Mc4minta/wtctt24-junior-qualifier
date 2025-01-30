package e.f.j.l;

/* compiled from: ThreadHandoffProducer.java */
/* loaded from: classes2.dex */
public class s0<T> implements j0<T> {
    private final j0<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final t0 f12735b;

    /* compiled from: ThreadHandoffProducer.java */
    /* loaded from: classes2.dex */
    class a extends q0<T> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ m0 f12736f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f12737g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ k f12738h;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ k0 f12739j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(k kVar, m0 m0Var, String str, String str2, m0 m0Var2, String str3, k kVar2, k0 k0Var) {
            super(kVar, m0Var, str, str2);
            this.f12736f = m0Var2;
            this.f12737g = str3;
            this.f12738h = kVar2;
            this.f12739j = k0Var;
        }

        @Override // e.f.d.b.d
        protected void b(T t) {
        }

        @Override // e.f.d.b.d
        protected T c() throws Exception {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.q0, e.f.d.b.d
        public void f(T t) {
            this.f12736f.i(this.f12737g, "BackgroundThreadHandoffProducer", null);
            s0.this.a.b(this.f12738h, this.f12739j);
        }
    }

    /* compiled from: ThreadHandoffProducer.java */
    /* loaded from: classes2.dex */
    class b extends e {
        final /* synthetic */ q0 a;

        b(q0 q0Var) {
            this.a = q0Var;
        }

        @Override // e.f.j.l.l0
        public void a() {
            this.a.a();
            s0.this.f12735b.b(this.a);
        }
    }

    public s0(j0<T> j0Var, t0 t0Var) {
        this.a = (j0) e.f.d.c.i.g(j0Var);
        this.f12735b = t0Var;
    }

    @Override // e.f.j.l.j0
    public void b(k<T> kVar, k0 k0Var) {
        m0 f2 = k0Var.f();
        String id = k0Var.getId();
        a aVar = new a(kVar, f2, "BackgroundThreadHandoffProducer", id, f2, id, kVar, k0Var);
        k0Var.d(new b(aVar));
        this.f12735b.a(aVar);
    }
}