package e.f.j.l;

import android.graphics.Bitmap;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import e.f.j.l.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: DecodeProducer.java */
/* loaded from: classes2.dex */
public class m implements j0<com.facebook.common.references.a<e.f.j.i.b>> {
    private final com.facebook.common.memory.a a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f12665b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.imagepipeline.decoder.b f12666c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.imagepipeline.decoder.d f12667d;

    /* renamed from: e  reason: collision with root package name */
    private final j0<e.f.j.i.d> f12668e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f12669f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f12670g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f12671h;

    /* renamed from: i  reason: collision with root package name */
    private final int f12672i;

    /* renamed from: j  reason: collision with root package name */
    private final e.f.j.e.a f12673j;

    /* compiled from: DecodeProducer.java */
    /* loaded from: classes2.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<e.f.j.i.b>> kVar, k0 k0Var, boolean z, int i2) {
            super(kVar, k0Var, z, i2);
        }

        @Override // e.f.j.l.m.c
        protected synchronized boolean D(e.f.j.i.d dVar, int i2) {
            if (e.f.j.l.b.e(i2)) {
                return false;
            }
            return super.D(dVar, i2);
        }

        @Override // e.f.j.l.m.c
        protected int v(e.f.j.i.d dVar) {
            return dVar.K();
        }

        @Override // e.f.j.l.m.c
        protected e.f.j.i.g w() {
            return e.f.j.i.f.d(0, false, false);
        }
    }

    /* compiled from: DecodeProducer.java */
    /* loaded from: classes2.dex */
    private class b extends c {

        /* renamed from: j  reason: collision with root package name */
        private final com.facebook.imagepipeline.decoder.e f12675j;

        /* renamed from: k  reason: collision with root package name */
        private final com.facebook.imagepipeline.decoder.d f12676k;

        /* renamed from: l  reason: collision with root package name */
        private int f12677l;

        public b(k<com.facebook.common.references.a<e.f.j.i.b>> kVar, k0 k0Var, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, int i2) {
            super(kVar, k0Var, z, i2);
            this.f12675j = (com.facebook.imagepipeline.decoder.e) e.f.d.c.i.g(eVar);
            this.f12676k = (com.facebook.imagepipeline.decoder.d) e.f.d.c.i.g(dVar);
            this.f12677l = 0;
        }

        @Override // e.f.j.l.m.c
        protected synchronized boolean D(e.f.j.i.d dVar, int i2) {
            boolean D = super.D(dVar, i2);
            if ((e.f.j.l.b.e(i2) || e.f.j.l.b.m(i2, 8)) && !e.f.j.l.b.m(i2, 4) && e.f.j.i.d.d0(dVar) && dVar.v() == e.f.i.b.a) {
                if (!this.f12675j.g(dVar)) {
                    return false;
                }
                int d2 = this.f12675j.d();
                int i3 = this.f12677l;
                if (d2 <= i3) {
                    return false;
                }
                if (d2 < this.f12676k.b(i3) && !this.f12675j.e()) {
                    return false;
                }
                this.f12677l = d2;
            }
            return D;
        }

        @Override // e.f.j.l.m.c
        protected int v(e.f.j.i.d dVar) {
            return this.f12675j.c();
        }

        @Override // e.f.j.l.m.c
        protected e.f.j.i.g w() {
            return this.f12676k.a(this.f12675j.d());
        }
    }

    /* compiled from: DecodeProducer.java */
    /* loaded from: classes2.dex */
    private abstract class c extends n<e.f.j.i.d, com.facebook.common.references.a<e.f.j.i.b>> {

        /* renamed from: c  reason: collision with root package name */
        private final String f12678c;

        /* renamed from: d  reason: collision with root package name */
        private final k0 f12679d;

        /* renamed from: e  reason: collision with root package name */
        private final m0 f12680e;

        /* renamed from: f  reason: collision with root package name */
        private final com.facebook.imagepipeline.common.b f12681f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f12682g;

        /* renamed from: h  reason: collision with root package name */
        private final u f12683h;

        /* compiled from: DecodeProducer.java */
        /* loaded from: classes2.dex */
        class a implements u.d {
            final /* synthetic */ m a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ k0 f12685b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f12686c;

            a(m mVar, k0 k0Var, int i2) {
                this.a = mVar;
                this.f12685b = k0Var;
                this.f12686c = i2;
            }

            @Override // e.f.j.l.u.d
            public void a(e.f.j.i.d dVar, int i2) {
                if (dVar != null) {
                    if (m.this.f12669f || !e.f.j.l.b.m(i2, 16)) {
                        com.facebook.imagepipeline.request.b c2 = this.f12685b.c();
                        if (m.this.f12670g || !com.facebook.common.util.e.k(c2.q())) {
                            dVar.y0(e.f.j.n.a.b(c2.o(), c2.m(), dVar, this.f12686c));
                        }
                    }
                    c.this.t(dVar, i2);
                }
            }
        }

        /* compiled from: DecodeProducer.java */
        /* loaded from: classes2.dex */
        class b extends e {
            final /* synthetic */ m a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f12688b;

            b(m mVar, boolean z) {
                this.a = mVar;
                this.f12688b = z;
            }

            @Override // e.f.j.l.l0
            public void a() {
                if (this.f12688b) {
                    c.this.x();
                }
            }

            @Override // e.f.j.l.e, e.f.j.l.l0
            public void b() {
                if (c.this.f12679d.g()) {
                    c.this.f12683h.h();
                }
            }
        }

        public c(k<com.facebook.common.references.a<e.f.j.i.b>> kVar, k0 k0Var, boolean z, int i2) {
            super(kVar);
            this.f12678c = "ProgressiveDecoder";
            this.f12679d = k0Var;
            this.f12680e = k0Var.f();
            com.facebook.imagepipeline.common.b d2 = k0Var.c().d();
            this.f12681f = d2;
            this.f12682g = false;
            this.f12683h = new u(m.this.f12665b, new a(m.this, k0Var, i2), d2.f4509b);
            k0Var.d(new b(m.this, z));
        }

        private synchronized boolean A() {
            return this.f12682g;
        }

        private void B(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.f12682g) {
                        o().b(1.0f);
                        this.f12682g = true;
                        this.f12683h.c();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void t(e.f.j.i.d r19, int r20) {
            /*
                Method dump skipped, instructions count: 334
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: e.f.j.l.m.c.t(e.f.j.i.d, int):void");
        }

        private Map<String, String> u(e.f.j.i.b bVar, long j2, e.f.j.i.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (this.f12680e.f(this.f12679d.getId())) {
                String valueOf = String.valueOf(j2);
                String valueOf2 = String.valueOf(gVar.b());
                String valueOf3 = String.valueOf(z);
                if (bVar instanceof e.f.j.i.c) {
                    Bitmap d2 = ((e.f.j.i.c) bVar).d();
                    HashMap hashMap = new HashMap(8);
                    hashMap.put("bitmapSize", d2.getWidth() + "x" + d2.getHeight());
                    hashMap.put("queueTime", valueOf);
                    hashMap.put("hasGoodQuality", valueOf2);
                    hashMap.put("isFinal", valueOf3);
                    hashMap.put("encodedImageSize", str2);
                    hashMap.put("imageFormat", str);
                    hashMap.put("requestedImageSize", str3);
                    hashMap.put("sampleSize", str4);
                    return e.f.d.c.f.b(hashMap);
                }
                HashMap hashMap2 = new HashMap(7);
                hashMap2.put("queueTime", valueOf);
                hashMap2.put("hasGoodQuality", valueOf2);
                hashMap2.put("isFinal", valueOf3);
                hashMap2.put("encodedImageSize", str2);
                hashMap2.put("imageFormat", str);
                hashMap2.put("requestedImageSize", str3);
                hashMap2.put("sampleSize", str4);
                return e.f.d.c.f.b(hashMap2);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x() {
            B(true);
            o().a();
        }

        private void y(Throwable th) {
            B(true);
            o().onFailure(th);
        }

        private void z(e.f.j.i.b bVar, int i2) {
            com.facebook.common.references.a<e.f.j.i.b> b2 = m.this.f12673j.b(bVar);
            try {
                B(e.f.j.l.b.d(i2));
                o().c(b2, i2);
            } finally {
                com.facebook.common.references.a.f(b2);
            }
        }

        @Override // e.f.j.l.b
        /* renamed from: C */
        public void h(e.f.j.i.d dVar, int i2) {
            try {
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.a("DecodeProducer#onNewResultImpl");
                }
                boolean d2 = e.f.j.l.b.d(i2);
                if (d2 && !e.f.j.i.d.d0(dVar)) {
                    y(new ExceptionWithNoStacktrace("Encoded image is not valid."));
                } else if (!D(dVar, i2)) {
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.b();
                    }
                } else {
                    boolean m = e.f.j.l.b.m(i2, 4);
                    if (d2 || m || this.f12679d.g()) {
                        this.f12683h.h();
                    }
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.b();
                    }
                }
            } finally {
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
            }
        }

        protected boolean D(e.f.j.i.d dVar, int i2) {
            return this.f12683h.k(dVar, i2);
        }

        @Override // e.f.j.l.n, e.f.j.l.b
        public void f() {
            x();
        }

        @Override // e.f.j.l.n, e.f.j.l.b
        public void g(Throwable th) {
            y(th);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.n, e.f.j.l.b
        public void i(float f2) {
            super.i(f2 * 0.99f);
        }

        protected abstract int v(e.f.j.i.d dVar);

        protected abstract e.f.j.i.g w();
    }

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, j0<e.f.j.i.d> j0Var, int i2, e.f.j.e.a aVar2) {
        this.a = (com.facebook.common.memory.a) e.f.d.c.i.g(aVar);
        this.f12665b = (Executor) e.f.d.c.i.g(executor);
        this.f12666c = (com.facebook.imagepipeline.decoder.b) e.f.d.c.i.g(bVar);
        this.f12667d = (com.facebook.imagepipeline.decoder.d) e.f.d.c.i.g(dVar);
        this.f12669f = z;
        this.f12670g = z2;
        this.f12668e = (j0) e.f.d.c.i.g(j0Var);
        this.f12671h = z3;
        this.f12672i = i2;
        this.f12673j = aVar2;
    }

    @Override // e.f.j.l.j0
    public void b(k<com.facebook.common.references.a<e.f.j.i.b>> kVar, k0 k0Var) {
        k<e.f.j.i.d> bVar;
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("DecodeProducer#produceResults");
            }
            if (!com.facebook.common.util.e.k(k0Var.c().q())) {
                bVar = new a(kVar, k0Var, this.f12671h, this.f12672i);
            } else {
                bVar = new b(kVar, k0Var, new com.facebook.imagepipeline.decoder.e(this.a), this.f12667d, this.f12671h, this.f12672i);
            }
            this.f12668e.b(bVar, k0Var);
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }
}