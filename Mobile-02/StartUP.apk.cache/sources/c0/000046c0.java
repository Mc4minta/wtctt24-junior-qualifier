package e.f.j.l;

import java.io.InputStream;
import java.util.concurrent.Executor;

/* compiled from: WebpTranscodeProducer.java */
/* loaded from: classes2.dex */
public class y0 implements j0<e.f.j.i.d> {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.common.memory.g f12790b;

    /* renamed from: c  reason: collision with root package name */
    private final j0<e.f.j.i.d> f12791c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebpTranscodeProducer.java */
    /* loaded from: classes2.dex */
    public class a extends q0<e.f.j.i.d> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ e.f.j.i.d f12792f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(k kVar, m0 m0Var, String str, String str2, e.f.j.i.d dVar) {
            super(kVar, m0Var, str, str2);
            this.f12792f = dVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.q0, e.f.d.b.d
        public void d() {
            e.f.j.i.d.c(this.f12792f);
            super.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.q0, e.f.d.b.d
        public void e(Exception exc) {
            e.f.j.i.d.c(this.f12792f);
            super.e(exc);
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
            com.facebook.common.memory.i a = y0.this.f12790b.a();
            try {
                y0.g(this.f12792f, a);
                com.facebook.common.references.a K = com.facebook.common.references.a.K(a.a());
                e.f.j.i.d dVar = new e.f.j.i.d(K);
                dVar.d(this.f12792f);
                com.facebook.common.references.a.f(K);
                return dVar;
            } finally {
                a.close();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.q0, e.f.d.b.d
        /* renamed from: l */
        public void f(e.f.j.i.d dVar) {
            e.f.j.i.d.c(this.f12792f);
            super.f(dVar);
        }
    }

    /* compiled from: WebpTranscodeProducer.java */
    /* loaded from: classes2.dex */
    private class b extends n<e.f.j.i.d, e.f.j.i.d> {

        /* renamed from: c  reason: collision with root package name */
        private final k0 f12794c;

        /* renamed from: d  reason: collision with root package name */
        private com.facebook.common.util.d f12795d;

        public b(k<e.f.j.i.d> kVar, k0 k0Var) {
            super(kVar);
            this.f12794c = k0Var;
            this.f12795d = com.facebook.common.util.d.UNSET;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.b
        /* renamed from: p */
        public void h(e.f.j.i.d dVar, int i2) {
            if (this.f12795d == com.facebook.common.util.d.UNSET && dVar != null) {
                this.f12795d = y0.h(dVar);
            }
            if (this.f12795d == com.facebook.common.util.d.NO) {
                o().c(dVar, i2);
            } else if (e.f.j.l.b.d(i2)) {
                if (this.f12795d == com.facebook.common.util.d.YES && dVar != null) {
                    y0.this.i(dVar, o(), this.f12794c);
                } else {
                    o().c(dVar, i2);
                }
            }
        }
    }

    public y0(Executor executor, com.facebook.common.memory.g gVar, j0<e.f.j.i.d> j0Var) {
        this.a = (Executor) e.f.d.c.i.g(executor);
        this.f12790b = (com.facebook.common.memory.g) e.f.d.c.i.g(gVar);
        this.f12791c = (j0) e.f.d.c.i.g(j0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(e.f.j.i.d dVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream z = dVar.z();
        e.f.i.c c2 = e.f.i.d.c(z);
        if (c2 != e.f.i.b.f12392f && c2 != e.f.i.b.f12394h) {
            if (c2 != e.f.i.b.f12393g && c2 != e.f.i.b.f12395i) {
                throw new IllegalArgumentException("Wrong image format");
            }
            com.facebook.imagepipeline.nativecode.f.a().b(z, iVar);
            dVar.w0(e.f.i.b.f12388b);
            return;
        }
        com.facebook.imagepipeline.nativecode.f.a().a(z, iVar, 80);
        dVar.w0(e.f.i.b.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.facebook.common.util.d h(e.f.j.i.d dVar) {
        e.f.d.c.i.g(dVar);
        e.f.i.c c2 = e.f.i.d.c(dVar.z());
        if (e.f.i.b.a(c2)) {
            com.facebook.imagepipeline.nativecode.e a2 = com.facebook.imagepipeline.nativecode.f.a();
            if (a2 == null) {
                return com.facebook.common.util.d.NO;
            }
            return com.facebook.common.util.d.h(!a2.c(c2));
        } else if (c2 == e.f.i.c.a) {
            return com.facebook.common.util.d.UNSET;
        } else {
            return com.facebook.common.util.d.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(e.f.j.i.d dVar, k<e.f.j.i.d> kVar, k0 k0Var) {
        e.f.d.c.i.g(dVar);
        this.a.execute(new a(kVar, k0Var.f(), "WebpTranscodeProducer", k0Var.getId(), e.f.j.i.d.b(dVar)));
    }

    @Override // e.f.j.l.j0
    public void b(k<e.f.j.i.d> kVar, k0 k0Var) {
        this.f12791c.b(new b(kVar, k0Var), k0Var);
    }
}