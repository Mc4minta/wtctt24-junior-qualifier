package e.f.j.l;

import com.facebook.imagepipeline.request.b;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DiskCacheReadProducer.java */
/* loaded from: classes2.dex */
public class o implements j0<e.f.j.i.d> {
    private final e.f.j.d.e a;

    /* renamed from: b  reason: collision with root package name */
    private final e.f.j.d.e f12692b;

    /* renamed from: c  reason: collision with root package name */
    private final e.f.j.d.f f12693c;

    /* renamed from: d  reason: collision with root package name */
    private final j0<e.f.j.i.d> f12694d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskCacheReadProducer.java */
    /* loaded from: classes2.dex */
    public class a implements bolts.d<e.f.j.i.d, Void> {
        final /* synthetic */ m0 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12695b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f12696c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ k0 f12697d;

        a(m0 m0Var, String str, k kVar, k0 k0Var) {
            this.a = m0Var;
            this.f12695b = str;
            this.f12696c = kVar;
            this.f12697d = k0Var;
        }

        @Override // bolts.d
        /* renamed from: b */
        public Void a(bolts.e<e.f.j.i.d> eVar) throws Exception {
            if (o.f(eVar)) {
                this.a.d(this.f12695b, "DiskCacheProducer", null);
                this.f12696c.a();
            } else if (eVar.n()) {
                this.a.j(this.f12695b, "DiskCacheProducer", eVar.i(), null);
                o.this.f12694d.b(this.f12696c, this.f12697d);
            } else {
                e.f.j.i.d j2 = eVar.j();
                if (j2 != null) {
                    m0 m0Var = this.a;
                    String str = this.f12695b;
                    m0Var.i(str, "DiskCacheProducer", o.e(m0Var, str, true, j2.K()));
                    this.a.e(this.f12695b, "DiskCacheProducer", true);
                    this.f12696c.b(1.0f);
                    this.f12696c.c(j2, 1);
                    j2.close();
                } else {
                    m0 m0Var2 = this.a;
                    String str2 = this.f12695b;
                    m0Var2.i(str2, "DiskCacheProducer", o.e(m0Var2, str2, false, 0));
                    o.this.f12694d.b(this.f12696c, this.f12697d);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskCacheReadProducer.java */
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

    public o(e.f.j.d.e eVar, e.f.j.d.e eVar2, e.f.j.d.f fVar, j0<e.f.j.i.d> j0Var) {
        this.a = eVar;
        this.f12692b = eVar2;
        this.f12693c = fVar;
        this.f12694d = j0Var;
    }

    static Map<String, String> e(m0 m0Var, String str, boolean z, int i2) {
        if (m0Var.f(str)) {
            if (z) {
                return e.f.d.c.f.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i2));
            }
            return e.f.d.c.f.of("cached_value_found", String.valueOf(z));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(bolts.e<?> eVar) {
        return eVar.l() || (eVar.n() && (eVar.i() instanceof CancellationException));
    }

    private void g(k<e.f.j.i.d> kVar, k0 k0Var) {
        if (k0Var.h().n() >= b.EnumC0109b.DISK_CACHE.n()) {
            kVar.c(null, 1);
        } else {
            this.f12694d.b(kVar, k0Var);
        }
    }

    private bolts.d<e.f.j.i.d, Void> h(k<e.f.j.i.d> kVar, k0 k0Var) {
        return new a(k0Var.f(), k0Var.getId(), kVar, k0Var);
    }

    private void i(AtomicBoolean atomicBoolean, k0 k0Var) {
        k0Var.d(new b(atomicBoolean));
    }

    @Override // e.f.j.l.j0
    public void b(k<e.f.j.i.d> kVar, k0 k0Var) {
        com.facebook.imagepipeline.request.b c2 = k0Var.c();
        if (!c2.t()) {
            g(kVar, k0Var);
            return;
        }
        k0Var.f().b(k0Var.getId(), "DiskCacheProducer");
        e.f.b.a.d d2 = this.f12693c.d(c2, k0Var.a());
        e.f.j.d.e eVar = c2.c() == b.a.SMALL ? this.f12692b : this.a;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.m(d2, atomicBoolean).e(h(kVar, k0Var));
        i(atomicBoolean, k0Var);
    }
}