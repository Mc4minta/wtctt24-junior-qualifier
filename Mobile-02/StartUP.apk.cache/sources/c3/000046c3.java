package e.f.j.l;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* compiled from: LocalFetchProducer.java */
/* loaded from: classes2.dex */
public abstract class z implements j0<e.f.j.i.d> {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.common.memory.g f12797b;

    /* compiled from: LocalFetchProducer.java */
    /* loaded from: classes2.dex */
    class a extends q0<e.f.j.i.d> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ com.facebook.imagepipeline.request.b f12798f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ m0 f12799g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f12800h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(k kVar, m0 m0Var, String str, String str2, com.facebook.imagepipeline.request.b bVar, m0 m0Var2, String str3) {
            super(kVar, m0Var, str, str2);
            this.f12798f = bVar;
            this.f12799g = m0Var2;
            this.f12800h = str3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.d.b.d
        /* renamed from: j */
        public void b(e.f.j.i.d dVar) {
            e.f.j.i.d.c(dVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.d.b.d
        /* renamed from: k */
        public e.f.j.i.d c() throws Exception {
            e.f.j.i.d d2 = z.this.d(this.f12798f);
            if (d2 == null) {
                this.f12799g.e(this.f12800h, z.this.f(), false);
                return null;
            }
            d2.e0();
            this.f12799g.e(this.f12800h, z.this.f(), true);
            return d2;
        }
    }

    /* compiled from: LocalFetchProducer.java */
    /* loaded from: classes2.dex */
    class b extends e {
        final /* synthetic */ q0 a;

        b(q0 q0Var) {
            this.a = q0Var;
        }

        @Override // e.f.j.l.l0
        public void a() {
            this.a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public z(Executor executor, com.facebook.common.memory.g gVar) {
        this.a = executor;
        this.f12797b = gVar;
    }

    @Override // e.f.j.l.j0
    public void b(k<e.f.j.i.d> kVar, k0 k0Var) {
        m0 f2 = k0Var.f();
        String id = k0Var.getId();
        a aVar = new a(kVar, f2, f(), id, k0Var.c(), f2, id);
        k0Var.d(new b(aVar));
        this.a.execute(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e.f.j.i.d c(InputStream inputStream, int i2) throws IOException {
        com.facebook.common.references.a K;
        com.facebook.common.references.a aVar = null;
        try {
            if (i2 <= 0) {
                K = com.facebook.common.references.a.K(this.f12797b.c(inputStream));
            } else {
                K = com.facebook.common.references.a.K(this.f12797b.d(inputStream, i2));
            }
            aVar = K;
            return new e.f.j.i.d(aVar);
        } finally {
            e.f.d.c.b.b(inputStream);
            com.facebook.common.references.a.f(aVar);
        }
    }

    protected abstract e.f.j.i.d d(com.facebook.imagepipeline.request.b bVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public e.f.j.i.d e(InputStream inputStream, int i2) throws IOException {
        return c(inputStream, i2);
    }

    protected abstract String f();
}