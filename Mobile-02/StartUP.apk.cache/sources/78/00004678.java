package e.f.j.l;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: PostprocessorProducer.java */
/* loaded from: classes2.dex */
public class i0 implements j0<com.facebook.common.references.a<e.f.j.i.b>> {
    private final j0<com.facebook.common.references.a<e.f.j.i.b>> a;

    /* renamed from: b  reason: collision with root package name */
    private final e.f.j.c.f f12645b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f12646c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PostprocessorProducer.java */
    /* loaded from: classes2.dex */
    public class b extends n<com.facebook.common.references.a<e.f.j.i.b>, com.facebook.common.references.a<e.f.j.i.b>> {

        /* renamed from: c  reason: collision with root package name */
        private final m0 f12647c;

        /* renamed from: d  reason: collision with root package name */
        private final String f12648d;

        /* renamed from: e  reason: collision with root package name */
        private final com.facebook.imagepipeline.request.c f12649e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f12650f;

        /* renamed from: g  reason: collision with root package name */
        private com.facebook.common.references.a<e.f.j.i.b> f12651g;

        /* renamed from: h  reason: collision with root package name */
        private int f12652h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f12653i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f12654j;

        /* compiled from: PostprocessorProducer.java */
        /* loaded from: classes2.dex */
        class a extends e {
            final /* synthetic */ i0 a;

            a(i0 i0Var) {
                this.a = i0Var;
            }

            @Override // e.f.j.l.l0
            public void a() {
                b.this.B();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PostprocessorProducer.java */
        /* renamed from: e.f.j.l.i0$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0279b implements Runnable {
            RunnableC0279b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.facebook.common.references.a aVar;
                int i2;
                synchronized (b.this) {
                    aVar = b.this.f12651g;
                    i2 = b.this.f12652h;
                    b.this.f12651g = null;
                    b.this.f12653i = false;
                }
                if (com.facebook.common.references.a.G(aVar)) {
                    try {
                        b.this.y(aVar, i2);
                    } finally {
                        com.facebook.common.references.a.f(aVar);
                    }
                }
                b.this.w();
            }
        }

        public b(k<com.facebook.common.references.a<e.f.j.i.b>> kVar, m0 m0Var, String str, com.facebook.imagepipeline.request.c cVar, k0 k0Var) {
            super(kVar);
            this.f12651g = null;
            this.f12652h = 0;
            this.f12653i = false;
            this.f12654j = false;
            this.f12647c = m0Var;
            this.f12648d = str;
            this.f12649e = cVar;
            k0Var.d(new a(i0.this));
        }

        private synchronized boolean A() {
            return this.f12650f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B() {
            if (x()) {
                o().a();
            }
        }

        private void C(Throwable th) {
            if (x()) {
                o().onFailure(th);
            }
        }

        private void D(com.facebook.common.references.a<e.f.j.i.b> aVar, int i2) {
            boolean d2 = e.f.j.l.b.d(i2);
            if ((d2 || A()) && !(d2 && x())) {
                return;
            }
            o().c(aVar, i2);
        }

        private com.facebook.common.references.a<e.f.j.i.b> F(e.f.j.i.b bVar) {
            e.f.j.i.c cVar = (e.f.j.i.c) bVar;
            com.facebook.common.references.a<Bitmap> b2 = this.f12649e.b(cVar.d(), i0.this.f12645b);
            try {
                return com.facebook.common.references.a.K(new e.f.j.i.c(b2, bVar.a(), cVar.m(), cVar.j()));
            } finally {
                com.facebook.common.references.a.f(b2);
            }
        }

        private synchronized boolean G() {
            if (this.f12650f || !this.f12653i || this.f12654j || !com.facebook.common.references.a.G(this.f12651g)) {
                return false;
            }
            this.f12654j = true;
            return true;
        }

        private boolean H(e.f.j.i.b bVar) {
            return bVar instanceof e.f.j.i.c;
        }

        private void I() {
            i0.this.f12646c.execute(new RunnableC0279b());
        }

        private void J(com.facebook.common.references.a<e.f.j.i.b> aVar, int i2) {
            synchronized (this) {
                if (this.f12650f) {
                    return;
                }
                com.facebook.common.references.a<e.f.j.i.b> aVar2 = this.f12651g;
                this.f12651g = com.facebook.common.references.a.e(aVar);
                this.f12652h = i2;
                this.f12653i = true;
                boolean G = G();
                com.facebook.common.references.a.f(aVar2);
                if (G) {
                    I();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w() {
            boolean G;
            synchronized (this) {
                this.f12654j = false;
                G = G();
            }
            if (G) {
                I();
            }
        }

        private boolean x() {
            synchronized (this) {
                if (this.f12650f) {
                    return false;
                }
                com.facebook.common.references.a<e.f.j.i.b> aVar = this.f12651g;
                this.f12651g = null;
                this.f12650f = true;
                com.facebook.common.references.a.f(aVar);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y(com.facebook.common.references.a<e.f.j.i.b> aVar, int i2) {
            e.f.d.c.i.b(com.facebook.common.references.a.G(aVar));
            if (!H(aVar.n())) {
                D(aVar, i2);
                return;
            }
            this.f12647c.b(this.f12648d, "PostprocessorProducer");
            try {
                try {
                    com.facebook.common.references.a<e.f.j.i.b> F = F(aVar.n());
                    m0 m0Var = this.f12647c;
                    String str = this.f12648d;
                    m0Var.i(str, "PostprocessorProducer", z(m0Var, str, this.f12649e));
                    D(F, i2);
                    com.facebook.common.references.a.f(F);
                } catch (Exception e2) {
                    m0 m0Var2 = this.f12647c;
                    String str2 = this.f12648d;
                    m0Var2.j(str2, "PostprocessorProducer", e2, z(m0Var2, str2, this.f12649e));
                    C(e2);
                    com.facebook.common.references.a.f(null);
                }
            } catch (Throwable th) {
                com.facebook.common.references.a.f(null);
                throw th;
            }
        }

        private Map<String, String> z(m0 m0Var, String str, com.facebook.imagepipeline.request.c cVar) {
            if (m0Var.f(str)) {
                return e.f.d.c.f.of("Postprocessor", cVar.getName());
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.b
        /* renamed from: E */
        public void h(com.facebook.common.references.a<e.f.j.i.b> aVar, int i2) {
            if (!com.facebook.common.references.a.G(aVar)) {
                if (e.f.j.l.b.d(i2)) {
                    D(null, i2);
                    return;
                }
                return;
            }
            J(aVar, i2);
        }

        @Override // e.f.j.l.n, e.f.j.l.b
        protected void f() {
            B();
        }

        @Override // e.f.j.l.n, e.f.j.l.b
        protected void g(Throwable th) {
            C(th);
        }
    }

    /* compiled from: PostprocessorProducer.java */
    /* loaded from: classes2.dex */
    class c extends n<com.facebook.common.references.a<e.f.j.i.b>, com.facebook.common.references.a<e.f.j.i.b>> implements com.facebook.imagepipeline.request.e {

        /* renamed from: c  reason: collision with root package name */
        private boolean f12657c;

        /* renamed from: d  reason: collision with root package name */
        private com.facebook.common.references.a<e.f.j.i.b> f12658d;

        /* compiled from: PostprocessorProducer.java */
        /* loaded from: classes2.dex */
        class a extends e {
            final /* synthetic */ i0 a;

            a(i0 i0Var) {
                this.a = i0Var;
            }

            @Override // e.f.j.l.l0
            public void a() {
                if (c.this.q()) {
                    c.this.o().a();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean q() {
            synchronized (this) {
                if (this.f12657c) {
                    return false;
                }
                com.facebook.common.references.a<e.f.j.i.b> aVar = this.f12658d;
                this.f12658d = null;
                this.f12657c = true;
                com.facebook.common.references.a.f(aVar);
                return true;
            }
        }

        private void s(com.facebook.common.references.a<e.f.j.i.b> aVar) {
            synchronized (this) {
                if (this.f12657c) {
                    return;
                }
                com.facebook.common.references.a<e.f.j.i.b> aVar2 = this.f12658d;
                this.f12658d = com.facebook.common.references.a.e(aVar);
                com.facebook.common.references.a.f(aVar2);
            }
        }

        private void t() {
            synchronized (this) {
                if (this.f12657c) {
                    return;
                }
                com.facebook.common.references.a<e.f.j.i.b> e2 = com.facebook.common.references.a.e(this.f12658d);
                try {
                    o().c(e2, 0);
                } finally {
                    com.facebook.common.references.a.f(e2);
                }
            }
        }

        @Override // e.f.j.l.n, e.f.j.l.b
        protected void f() {
            if (q()) {
                o().a();
            }
        }

        @Override // e.f.j.l.n, e.f.j.l.b
        protected void g(Throwable th) {
            if (q()) {
                o().onFailure(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.b
        /* renamed from: r */
        public void h(com.facebook.common.references.a<e.f.j.i.b> aVar, int i2) {
            if (e.f.j.l.b.e(i2)) {
                return;
            }
            s(aVar);
            t();
        }

        private c(b bVar, com.facebook.imagepipeline.request.d dVar, k0 k0Var) {
            super(bVar);
            this.f12657c = false;
            this.f12658d = null;
            dVar.a(this);
            k0Var.d(new a(i0.this));
        }
    }

    /* compiled from: PostprocessorProducer.java */
    /* loaded from: classes2.dex */
    class d extends n<com.facebook.common.references.a<e.f.j.i.b>, com.facebook.common.references.a<e.f.j.i.b>> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.b
        /* renamed from: p */
        public void h(com.facebook.common.references.a<e.f.j.i.b> aVar, int i2) {
            if (e.f.j.l.b.e(i2)) {
                return;
            }
            o().c(aVar, i2);
        }

        private d(b bVar) {
            super(bVar);
        }
    }

    public i0(j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var, e.f.j.c.f fVar, Executor executor) {
        this.a = (j0) e.f.d.c.i.g(j0Var);
        this.f12645b = fVar;
        this.f12646c = (Executor) e.f.d.c.i.g(executor);
    }

    @Override // e.f.j.l.j0
    public void b(k<com.facebook.common.references.a<e.f.j.i.b>> kVar, k0 k0Var) {
        k<com.facebook.common.references.a<e.f.j.i.b>> dVar;
        m0 f2 = k0Var.f();
        com.facebook.imagepipeline.request.c g2 = k0Var.c().g();
        b bVar = new b(kVar, f2, k0Var.getId(), g2, k0Var);
        if (g2 instanceof com.facebook.imagepipeline.request.d) {
            dVar = new c(bVar, (com.facebook.imagepipeline.request.d) g2, k0Var);
        } else {
            dVar = new d(bVar);
        }
        this.a.b(dVar, k0Var);
    }
}