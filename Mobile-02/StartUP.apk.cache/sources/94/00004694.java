package e.f.j.l;

import e.f.j.l.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: ResizeAndRotateProducer.java */
/* loaded from: classes2.dex */
public class o0 implements j0<e.f.j.i.d> {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.common.memory.g f12700b;

    /* renamed from: c  reason: collision with root package name */
    private final j0<e.f.j.i.d> f12701c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f12702d;

    /* renamed from: e  reason: collision with root package name */
    private final e.f.j.n.d f12703e;

    /* compiled from: ResizeAndRotateProducer.java */
    /* loaded from: classes2.dex */
    private class a extends n<e.f.j.i.d, e.f.j.i.d> {

        /* renamed from: c  reason: collision with root package name */
        private final boolean f12704c;

        /* renamed from: d  reason: collision with root package name */
        private final e.f.j.n.d f12705d;

        /* renamed from: e  reason: collision with root package name */
        private final k0 f12706e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f12707f;

        /* renamed from: g  reason: collision with root package name */
        private final u f12708g;

        /* compiled from: ResizeAndRotateProducer.java */
        /* renamed from: e.f.j.l.o0$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0280a implements u.d {
            final /* synthetic */ o0 a;

            C0280a(o0 o0Var) {
                this.a = o0Var;
            }

            @Override // e.f.j.l.u.d
            public void a(e.f.j.i.d dVar, int i2) {
                a aVar = a.this;
                aVar.v(dVar, i2, (e.f.j.n.c) e.f.d.c.i.g(aVar.f12705d.createImageTranscoder(dVar.v(), a.this.f12704c)));
            }
        }

        /* compiled from: ResizeAndRotateProducer.java */
        /* loaded from: classes2.dex */
        class b extends e {
            final /* synthetic */ o0 a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ k f12711b;

            b(o0 o0Var, k kVar) {
                this.a = o0Var;
                this.f12711b = kVar;
            }

            @Override // e.f.j.l.l0
            public void a() {
                a.this.f12708g.c();
                a.this.f12707f = true;
                this.f12711b.a();
            }

            @Override // e.f.j.l.e, e.f.j.l.l0
            public void b() {
                if (a.this.f12706e.g()) {
                    a.this.f12708g.h();
                }
            }
        }

        a(k<e.f.j.i.d> kVar, k0 k0Var, boolean z, e.f.j.n.d dVar) {
            super(kVar);
            this.f12707f = false;
            this.f12706e = k0Var;
            Boolean n = k0Var.c().n();
            this.f12704c = n != null ? n.booleanValue() : z;
            this.f12705d = dVar;
            this.f12708g = new u(o0.this.a, new C0280a(o0.this), 100);
            k0Var.d(new b(o0.this, kVar));
        }

        private e.f.j.i.d A(e.f.j.i.d dVar) {
            return (this.f12706e.c().o().c() || dVar.A() == 0 || dVar.A() == -1) ? dVar : x(dVar, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(e.f.j.i.d dVar, int i2, e.f.j.n.c cVar) {
            this.f12706e.f().b(this.f12706e.getId(), "ResizeAndRotateProducer");
            com.facebook.imagepipeline.request.b c2 = this.f12706e.c();
            com.facebook.common.memory.i a = o0.this.f12700b.a();
            try {
                e.f.j.n.b c3 = cVar.c(dVar, a, c2.o(), c2.m(), null, 85);
                if (c3.a() != 2) {
                    Map<String, String> y = y(dVar, c2.m(), c3, cVar.a());
                    com.facebook.common.references.a K = com.facebook.common.references.a.K(a.a());
                    try {
                        e.f.j.i.d dVar2 = new e.f.j.i.d(K);
                        dVar2.w0(e.f.i.b.a);
                        dVar2.e0();
                        this.f12706e.f().i(this.f12706e.getId(), "ResizeAndRotateProducer", y);
                        if (c3.a() != 1) {
                            i2 |= 16;
                        }
                        o().c(dVar2, i2);
                        e.f.j.i.d.c(dVar2);
                        return;
                    } finally {
                        com.facebook.common.references.a.f(K);
                    }
                }
                throw new RuntimeException("Error while transcoding the image");
            } catch (Exception e2) {
                this.f12706e.f().j(this.f12706e.getId(), "ResizeAndRotateProducer", e2, null);
                if (e.f.j.l.b.d(i2)) {
                    o().onFailure(e2);
                }
            } finally {
                a.close();
            }
        }

        private void w(e.f.j.i.d dVar, int i2, e.f.i.c cVar) {
            e.f.j.i.d A;
            if (cVar != e.f.i.b.a && cVar != e.f.i.b.f12397k) {
                A = z(dVar);
            } else {
                A = A(dVar);
            }
            o().c(A, i2);
        }

        private e.f.j.i.d x(e.f.j.i.d dVar, int i2) {
            e.f.j.i.d b2 = e.f.j.i.d.b(dVar);
            dVar.close();
            if (b2 != null) {
                b2.x0(i2);
            }
            return b2;
        }

        private Map<String, String> y(e.f.j.i.d dVar, com.facebook.imagepipeline.common.e eVar, e.f.j.n.b bVar, String str) {
            String str2;
            if (this.f12706e.f().f(this.f12706e.getId())) {
                String str3 = dVar.N() + "x" + dVar.n();
                if (eVar != null) {
                    str2 = eVar.a + "x" + eVar.f4529b;
                } else {
                    str2 = "Unspecified";
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Image format", String.valueOf(dVar.v()));
                hashMap.put("Original size", str3);
                hashMap.put("Requested size", str2);
                hashMap.put("queueTime", String.valueOf(this.f12708g.f()));
                hashMap.put("Transcoder id", str);
                hashMap.put("Transcoding result", String.valueOf(bVar));
                return e.f.d.c.f.b(hashMap);
            }
            return null;
        }

        private e.f.j.i.d z(e.f.j.i.d dVar) {
            com.facebook.imagepipeline.common.f o = this.f12706e.c().o();
            return (o.g() || !o.f()) ? dVar : x(dVar, o.e());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.b
        /* renamed from: B */
        public void h(e.f.j.i.d dVar, int i2) {
            if (this.f12707f) {
                return;
            }
            boolean d2 = e.f.j.l.b.d(i2);
            if (dVar == null) {
                if (d2) {
                    o().c(null, 1);
                    return;
                }
                return;
            }
            e.f.i.c v = dVar.v();
            com.facebook.common.util.d h2 = o0.h(this.f12706e.c(), dVar, (e.f.j.n.c) e.f.d.c.i.g(this.f12705d.createImageTranscoder(v, this.f12704c)));
            if (d2 || h2 != com.facebook.common.util.d.UNSET) {
                if (h2 != com.facebook.common.util.d.YES) {
                    w(dVar, i2, v);
                } else if (this.f12708g.k(dVar, i2)) {
                    if (d2 || this.f12706e.g()) {
                        this.f12708g.h();
                    }
                }
            }
        }
    }

    public o0(Executor executor, com.facebook.common.memory.g gVar, j0<e.f.j.i.d> j0Var, boolean z, e.f.j.n.d dVar) {
        this.a = (Executor) e.f.d.c.i.g(executor);
        this.f12700b = (com.facebook.common.memory.g) e.f.d.c.i.g(gVar);
        this.f12701c = (j0) e.f.d.c.i.g(j0Var);
        this.f12703e = (e.f.j.n.d) e.f.d.c.i.g(dVar);
        this.f12702d = z;
    }

    private static boolean f(com.facebook.imagepipeline.common.f fVar, e.f.j.i.d dVar) {
        return !fVar.c() && (e.f.j.n.e.e(fVar, dVar) != 0 || g(fVar, dVar));
    }

    private static boolean g(com.facebook.imagepipeline.common.f fVar, e.f.j.i.d dVar) {
        if (fVar.f() && !fVar.c()) {
            return e.f.j.n.e.a.contains(Integer.valueOf(dVar.j()));
        }
        dVar.r0(0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.facebook.common.util.d h(com.facebook.imagepipeline.request.b bVar, e.f.j.i.d dVar, e.f.j.n.c cVar) {
        if (dVar != null && dVar.v() != e.f.i.c.a) {
            if (!cVar.d(dVar.v())) {
                return com.facebook.common.util.d.NO;
            }
            return com.facebook.common.util.d.h(f(bVar.o(), dVar) || cVar.b(dVar, bVar.o(), bVar.m()));
        }
        return com.facebook.common.util.d.UNSET;
    }

    @Override // e.f.j.l.j0
    public void b(k<e.f.j.i.d> kVar, k0 k0Var) {
        this.f12701c.b(new a(kVar, k0Var, this.f12702d, this.f12703e), k0Var);
    }
}