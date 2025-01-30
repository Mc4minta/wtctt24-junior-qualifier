package e.f.j.l;

import android.os.SystemClock;
import e.f.j.l.f0;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* compiled from: NetworkFetchProducer.java */
/* loaded from: classes2.dex */
public class e0 implements j0<e.f.j.i.d> {
    private final com.facebook.common.memory.g a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.common.memory.a f12610b;

    /* renamed from: c  reason: collision with root package name */
    private final f0 f12611c;

    /* compiled from: NetworkFetchProducer.java */
    /* loaded from: classes2.dex */
    class a implements f0.a {
        final /* synthetic */ s a;

        a(s sVar) {
            this.a = sVar;
        }

        @Override // e.f.j.l.f0.a
        public void a() {
            e0.this.j(this.a);
        }

        @Override // e.f.j.l.f0.a
        public void b(InputStream inputStream, int i2) throws IOException {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("NetworkFetcher->onResponse");
            }
            e0.this.l(this.a, inputStream, i2);
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }

        @Override // e.f.j.l.f0.a
        public void onFailure(Throwable th) {
            e0.this.k(this.a, th);
        }
    }

    public e0(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, f0 f0Var) {
        this.a = gVar;
        this.f12610b = aVar;
        this.f12611c = f0Var;
    }

    protected static float e(int i2, int i3) {
        return i3 > 0 ? i2 / i3 : 1.0f - ((float) Math.exp((-i2) / 50000.0d));
    }

    private Map<String, String> f(s sVar, int i2) {
        if (sVar.e().f(sVar.c())) {
            return this.f12611c.c(sVar, i2);
        }
        return null;
    }

    protected static void i(com.facebook.common.memory.i iVar, int i2, com.facebook.imagepipeline.common.a aVar, k<e.f.j.i.d> kVar) {
        com.facebook.common.references.a K = com.facebook.common.references.a.K(iVar.a());
        e.f.j.i.d dVar = null;
        try {
            e.f.j.i.d dVar2 = new e.f.j.i.d(K);
            try {
                dVar2.o0(aVar);
                dVar2.e0();
                kVar.c(dVar2, i2);
                e.f.j.i.d.c(dVar2);
                com.facebook.common.references.a.f(K);
            } catch (Throwable th) {
                th = th;
                dVar = dVar2;
                e.f.j.i.d.c(dVar);
                com.facebook.common.references.a.f(K);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(s sVar) {
        sVar.e().d(sVar.c(), "NetworkFetchProducer", null);
        sVar.a().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(s sVar, Throwable th) {
        sVar.e().j(sVar.c(), "NetworkFetchProducer", th, null);
        sVar.e().e(sVar.c(), "NetworkFetchProducer", false);
        sVar.a().onFailure(th);
    }

    private boolean m(s sVar) {
        if (sVar.b().g()) {
            return this.f12611c.b(sVar);
        }
        return false;
    }

    @Override // e.f.j.l.j0
    public void b(k<e.f.j.i.d> kVar, k0 k0Var) {
        k0Var.f().b(k0Var.getId(), "NetworkFetchProducer");
        s e2 = this.f12611c.e(kVar, k0Var);
        this.f12611c.d(e2, new a(e2));
    }

    protected void g(com.facebook.common.memory.i iVar, s sVar) {
        Map<String, String> f2 = f(sVar, iVar.size());
        m0 e2 = sVar.e();
        e2.i(sVar.c(), "NetworkFetchProducer", f2);
        e2.e(sVar.c(), "NetworkFetchProducer", true);
        i(iVar, sVar.f() | 1, sVar.g(), sVar.a());
    }

    protected void h(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (!m(sVar) || uptimeMillis - sVar.d() < 100) {
            return;
        }
        sVar.i(uptimeMillis);
        sVar.e().h(sVar.c(), "NetworkFetchProducer", "intermediate_result");
        i(iVar, sVar.f(), sVar.g(), sVar.a());
    }

    protected void l(s sVar, InputStream inputStream, int i2) throws IOException {
        com.facebook.common.memory.i a2;
        if (i2 > 0) {
            a2 = this.a.e(i2);
        } else {
            a2 = this.a.a();
        }
        byte[] bArr = this.f12610b.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    this.f12611c.a(sVar, a2.size());
                    g(a2, sVar);
                    return;
                } else if (read > 0) {
                    a2.write(bArr, 0, read);
                    h(a2, sVar);
                    sVar.a().b(e(a2.size(), i2));
                }
            } finally {
                this.f12610b.release(bArr);
                a2.close();
            }
        }
    }
}