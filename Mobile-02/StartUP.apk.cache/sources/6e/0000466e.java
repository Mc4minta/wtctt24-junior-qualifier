package e.f.j.l;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PartialDiskCacheProducer.java */
/* loaded from: classes2.dex */
public class g0 implements j0<e.f.j.i.d> {
    private final e.f.j.d.e a;

    /* renamed from: b  reason: collision with root package name */
    private final e.f.j.d.f f12614b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.common.memory.g f12615c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.common.memory.a f12616d;

    /* renamed from: e  reason: collision with root package name */
    private final j0<e.f.j.i.d> f12617e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PartialDiskCacheProducer.java */
    /* loaded from: classes2.dex */
    public class a implements bolts.d<e.f.j.i.d, Void> {
        final /* synthetic */ m0 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12618b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f12619c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ k0 f12620d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ e.f.b.a.d f12621e;

        a(m0 m0Var, String str, k kVar, k0 k0Var, e.f.b.a.d dVar) {
            this.a = m0Var;
            this.f12618b = str;
            this.f12619c = kVar;
            this.f12620d = k0Var;
            this.f12621e = dVar;
        }

        @Override // bolts.d
        /* renamed from: b */
        public Void a(bolts.e<e.f.j.i.d> eVar) throws Exception {
            if (g0.g(eVar)) {
                this.a.d(this.f12618b, "PartialDiskCacheProducer", null);
                this.f12619c.a();
            } else if (eVar.n()) {
                this.a.j(this.f12618b, "PartialDiskCacheProducer", eVar.i(), null);
                g0.this.i(this.f12619c, this.f12620d, this.f12621e, null);
            } else {
                e.f.j.i.d j2 = eVar.j();
                if (j2 != null) {
                    m0 m0Var = this.a;
                    String str = this.f12618b;
                    m0Var.i(str, "PartialDiskCacheProducer", g0.f(m0Var, str, true, j2.K()));
                    com.facebook.imagepipeline.common.a e2 = com.facebook.imagepipeline.common.a.e(j2.K() - 1);
                    j2.o0(e2);
                    int K = j2.K();
                    com.facebook.imagepipeline.request.b c2 = this.f12620d.c();
                    if (e2.a(c2.b())) {
                        this.a.e(this.f12618b, "PartialDiskCacheProducer", true);
                        this.f12619c.c(j2, 9);
                    } else {
                        this.f12619c.c(j2, 8);
                        g0.this.i(this.f12619c, new p0(ImageRequestBuilder.b(c2).t(com.facebook.imagepipeline.common.a.b(K - 1)).a(), this.f12620d), this.f12621e, j2);
                    }
                } else {
                    m0 m0Var2 = this.a;
                    String str2 = this.f12618b;
                    m0Var2.i(str2, "PartialDiskCacheProducer", g0.f(m0Var2, str2, false, 0));
                    g0.this.i(this.f12619c, this.f12620d, this.f12621e, j2);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PartialDiskCacheProducer.java */
    /* loaded from: classes2.dex */
    public class b extends e {
        final /* synthetic */ AtomicBoolean a;

        b(AtomicBoolean atomicBoolean) {
            this.a = atomicBoolean;
        }

        @Override // e.f.j.l.l0
        public void a() {
            this.a.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PartialDiskCacheProducer.java */
    /* loaded from: classes2.dex */
    public static class c extends n<e.f.j.i.d, e.f.j.i.d> {

        /* renamed from: c  reason: collision with root package name */
        private final e.f.j.d.e f12624c;

        /* renamed from: d  reason: collision with root package name */
        private final e.f.b.a.d f12625d;

        /* renamed from: e  reason: collision with root package name */
        private final com.facebook.common.memory.g f12626e;

        /* renamed from: f  reason: collision with root package name */
        private final com.facebook.common.memory.a f12627f;

        /* renamed from: g  reason: collision with root package name */
        private final e.f.j.i.d f12628g;

        /* synthetic */ c(k kVar, e.f.j.d.e eVar, e.f.b.a.d dVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, e.f.j.i.d dVar2, a aVar2) {
            this(kVar, eVar, dVar, gVar, aVar, dVar2);
        }

        private void p(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
            byte[] bArr = this.f12627f.get(16384);
            int i3 = i2;
            while (i3 > 0) {
                try {
                    int read = inputStream.read(bArr, 0, Math.min(16384, i3));
                    if (read < 0) {
                        break;
                    } else if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        i3 -= read;
                    }
                } finally {
                    this.f12627f.release(bArr);
                }
            }
            if (i3 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i2), Integer.valueOf(i3)));
            }
        }

        private com.facebook.common.memory.i q(e.f.j.i.d dVar, e.f.j.i.d dVar2) throws IOException {
            com.facebook.common.memory.i e2 = this.f12626e.e(dVar2.K() + dVar2.f().f4507b);
            p(dVar.z(), e2, dVar2.f().f4507b);
            p(dVar2.z(), e2, dVar2.K());
            return e2;
        }

        private void s(com.facebook.common.memory.i iVar) {
            e.f.j.i.d dVar;
            Throwable th;
            com.facebook.common.references.a K = com.facebook.common.references.a.K(iVar.a());
            try {
                dVar = new e.f.j.i.d(K);
            } catch (Throwable th2) {
                dVar = null;
                th = th2;
            }
            try {
                dVar.e0();
                o().c(dVar, 1);
                e.f.j.i.d.c(dVar);
                com.facebook.common.references.a.f(K);
            } catch (Throwable th3) {
                th = th3;
                e.f.j.i.d.c(dVar);
                com.facebook.common.references.a.f(K);
                throw th;
            }
        }

        @Override // e.f.j.l.b
        /* renamed from: r */
        public void h(e.f.j.i.d dVar, int i2) {
            if (e.f.j.l.b.e(i2)) {
                return;
            }
            if (this.f12628g != null) {
                try {
                    if (dVar.f() != null) {
                        try {
                            s(q(this.f12628g, dVar));
                        } catch (IOException e2) {
                            e.f.d.d.a.j("PartialDiskCacheProducer", "Error while merging image data", e2);
                            o().onFailure(e2);
                        }
                        this.f12624c.q(this.f12625d);
                        return;
                    }
                } finally {
                    dVar.close();
                    this.f12628g.close();
                }
            }
            if (e.f.j.l.b.m(i2, 8) && e.f.j.l.b.d(i2) && dVar.v() != e.f.i.c.a) {
                this.f12624c.o(this.f12625d, dVar);
                o().c(dVar, i2);
                return;
            }
            o().c(dVar, i2);
        }

        private c(k<e.f.j.i.d> kVar, e.f.j.d.e eVar, e.f.b.a.d dVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, e.f.j.i.d dVar2) {
            super(kVar);
            this.f12624c = eVar;
            this.f12625d = dVar;
            this.f12626e = gVar;
            this.f12627f = aVar;
            this.f12628g = dVar2;
        }
    }

    public g0(e.f.j.d.e eVar, e.f.j.d.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, j0<e.f.j.i.d> j0Var) {
        this.a = eVar;
        this.f12614b = fVar;
        this.f12615c = gVar;
        this.f12616d = aVar;
        this.f12617e = j0Var;
    }

    private static Uri e(com.facebook.imagepipeline.request.b bVar) {
        return bVar.q().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    static Map<String, String> f(m0 m0Var, String str, boolean z, int i2) {
        if (m0Var.f(str)) {
            if (z) {
                return e.f.d.c.f.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i2));
            }
            return e.f.d.c.f.of("cached_value_found", String.valueOf(z));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(bolts.e<?> eVar) {
        return eVar.l() || (eVar.n() && (eVar.i() instanceof CancellationException));
    }

    private bolts.d<e.f.j.i.d, Void> h(k<e.f.j.i.d> kVar, k0 k0Var, e.f.b.a.d dVar) {
        return new a(k0Var.f(), k0Var.getId(), kVar, k0Var, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(k<e.f.j.i.d> kVar, k0 k0Var, e.f.b.a.d dVar, e.f.j.i.d dVar2) {
        this.f12617e.b(new c(kVar, this.a, dVar, this.f12615c, this.f12616d, dVar2, null), k0Var);
    }

    private void j(AtomicBoolean atomicBoolean, k0 k0Var) {
        k0Var.d(new b(atomicBoolean));
    }

    @Override // e.f.j.l.j0
    public void b(k<e.f.j.i.d> kVar, k0 k0Var) {
        com.facebook.imagepipeline.request.b c2 = k0Var.c();
        if (!c2.t()) {
            this.f12617e.b(kVar, k0Var);
            return;
        }
        k0Var.f().b(k0Var.getId(), "PartialDiskCacheProducer");
        e.f.b.a.d b2 = this.f12614b.b(c2, e(c2), k0Var.a());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.a.m(b2, atomicBoolean).e(h(kVar, k0Var, b2));
        j(atomicBoolean, k0Var);
    }
}