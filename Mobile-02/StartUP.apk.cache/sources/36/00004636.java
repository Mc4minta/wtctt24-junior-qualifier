package e.f.j.e;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.memory.c0;
import com.facebook.imagepipeline.memory.d0;
import e.f.d.h.b;
import e.f.j.d.h;
import e.f.j.d.q;
import e.f.j.d.t;
import e.f.j.e.j;
import e.f.j.l.f0;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ImagePipelineConfig.java */
/* loaded from: classes2.dex */
public class i {
    private static c a = new c(null);
    private final com.facebook.imagepipeline.decoder.c A;
    private final j B;
    private final boolean C;
    private final e.f.c.a D;
    private final e.f.j.g.a E;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap.Config f12480b;

    /* renamed from: c  reason: collision with root package name */
    private final e.f.d.c.l<q> f12481c;

    /* renamed from: d  reason: collision with root package name */
    private final h.c f12482d;

    /* renamed from: e  reason: collision with root package name */
    private final e.f.j.d.f f12483e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f12484f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f12485g;

    /* renamed from: h  reason: collision with root package name */
    private final g f12486h;

    /* renamed from: i  reason: collision with root package name */
    private final e.f.d.c.l<q> f12487i;

    /* renamed from: j  reason: collision with root package name */
    private final f f12488j;

    /* renamed from: k  reason: collision with root package name */
    private final e.f.j.d.n f12489k;

    /* renamed from: l  reason: collision with root package name */
    private final com.facebook.imagepipeline.decoder.b f12490l;
    private final e.f.j.n.d m;
    private final Integer n;
    private final e.f.d.c.l<Boolean> o;
    private final e.f.b.b.c p;
    private final com.facebook.common.memory.c q;
    private final int r;
    private final f0 s;
    private final int t;
    private final e.f.j.c.f u;
    private final d0 v;
    private final com.facebook.imagepipeline.decoder.d w;
    private final Set<e.f.j.j.c> x;
    private final boolean y;
    private final e.f.b.b.c z;

    /* compiled from: ImagePipelineConfig.java */
    /* loaded from: classes2.dex */
    class a implements e.f.d.c.l<Boolean> {
        a() {
        }

        @Override // e.f.d.c.l
        /* renamed from: a */
        public Boolean get() {
            return Boolean.TRUE;
        }
    }

    /* compiled from: ImagePipelineConfig.java */
    /* loaded from: classes2.dex */
    public static class b {
        private final j.b A;
        private boolean B;
        private e.f.c.a C;
        private e.f.j.g.a D;
        private Bitmap.Config a;

        /* renamed from: b  reason: collision with root package name */
        private e.f.d.c.l<q> f12491b;

        /* renamed from: c  reason: collision with root package name */
        private h.c f12492c;

        /* renamed from: d  reason: collision with root package name */
        private e.f.j.d.f f12493d;

        /* renamed from: e  reason: collision with root package name */
        private final Context f12494e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f12495f;

        /* renamed from: g  reason: collision with root package name */
        private e.f.d.c.l<q> f12496g;

        /* renamed from: h  reason: collision with root package name */
        private f f12497h;

        /* renamed from: i  reason: collision with root package name */
        private e.f.j.d.n f12498i;

        /* renamed from: j  reason: collision with root package name */
        private com.facebook.imagepipeline.decoder.b f12499j;

        /* renamed from: k  reason: collision with root package name */
        private e.f.j.n.d f12500k;

        /* renamed from: l  reason: collision with root package name */
        private Integer f12501l;
        private e.f.d.c.l<Boolean> m;
        private e.f.b.b.c n;
        private com.facebook.common.memory.c o;
        private Integer p;
        private f0 q;
        private e.f.j.c.f r;
        private d0 s;
        private com.facebook.imagepipeline.decoder.d t;
        private Set<e.f.j.j.c> u;
        private boolean v;
        private e.f.b.b.c w;
        private g x;
        private com.facebook.imagepipeline.decoder.c y;
        private int z;

        /* synthetic */ b(Context context, a aVar) {
            this(context);
        }

        public i E() {
            return new i(this, null);
        }

        public b F(boolean z) {
            this.f12495f = z;
            return this;
        }

        public b G(f0 f0Var) {
            this.q = f0Var;
            return this;
        }

        public b H(Set<e.f.j.j.c> set) {
            this.u = set;
            return this;
        }

        private b(Context context) {
            this.f12495f = false;
            this.f12501l = null;
            this.p = null;
            this.v = true;
            this.z = -1;
            this.A = new j.b(this);
            this.B = true;
            this.D = new e.f.j.g.b();
            this.f12494e = (Context) e.f.d.c.i.g(context);
        }
    }

    /* compiled from: ImagePipelineConfig.java */
    /* loaded from: classes2.dex */
    public static class c {
        private boolean a;

        /* synthetic */ c(a aVar) {
            this();
        }

        public boolean a() {
            return this.a;
        }

        private c() {
            this.a = false;
        }
    }

    /* synthetic */ i(b bVar, a aVar) {
        this(bVar);
    }

    public static b G(Context context) {
        return new b(context, null);
    }

    private static void H(e.f.d.h.b bVar, j jVar, e.f.d.h.a aVar) {
        e.f.d.h.c.f12093d = bVar;
        b.a i2 = jVar.i();
        if (i2 != null) {
            bVar.b(i2);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    public static c h() {
        return a;
    }

    private static e.f.b.b.c i(Context context) {
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("DiskCacheConfig.getDefaultMainDiskCacheConfig");
            }
            return e.f.b.b.c.m(context).m();
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }

    private static e.f.j.n.d r(b bVar) {
        if (bVar.f12500k == null || bVar.f12501l == null) {
            if (bVar.f12500k != null) {
                return bVar.f12500k;
            }
            return null;
        }
        throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType");
    }

    private static int w(b bVar, j jVar) {
        if (bVar.p != null) {
            return bVar.p.intValue();
        }
        return jVar.m() ? 1 : 0;
    }

    public com.facebook.imagepipeline.decoder.d A() {
        return this.w;
    }

    public Set<e.f.j.j.c> B() {
        return Collections.unmodifiableSet(this.x);
    }

    public e.f.b.b.c C() {
        return this.z;
    }

    public boolean D() {
        return this.C;
    }

    public boolean E() {
        return this.f12485g;
    }

    public boolean F() {
        return this.y;
    }

    public Bitmap.Config a() {
        return this.f12480b;
    }

    public e.f.d.c.l<q> b() {
        return this.f12481c;
    }

    public h.c c() {
        return this.f12482d;
    }

    public e.f.j.d.f d() {
        return this.f12483e;
    }

    public e.f.c.a e() {
        return this.D;
    }

    public e.f.j.g.a f() {
        return this.E;
    }

    public Context g() {
        return this.f12484f;
    }

    public e.f.d.c.l<q> j() {
        return this.f12487i;
    }

    public f k() {
        return this.f12488j;
    }

    public j l() {
        return this.B;
    }

    public g m() {
        return this.f12486h;
    }

    public e.f.j.d.n n() {
        return this.f12489k;
    }

    public com.facebook.imagepipeline.decoder.b o() {
        return this.f12490l;
    }

    public com.facebook.imagepipeline.decoder.c p() {
        return this.A;
    }

    public e.f.j.n.d q() {
        return this.m;
    }

    public Integer s() {
        return this.n;
    }

    public e.f.d.c.l<Boolean> t() {
        return this.o;
    }

    public e.f.b.b.c u() {
        return this.p;
    }

    public int v() {
        return this.r;
    }

    public com.facebook.common.memory.c x() {
        return this.q;
    }

    public f0 y() {
        return this.s;
    }

    public d0 z() {
        return this.v;
    }

    private i(b bVar) {
        e.f.j.d.f fVar;
        e.f.j.d.n nVar;
        com.facebook.common.memory.c cVar;
        d0 d0Var;
        e.f.d.h.b i2;
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("ImagePipelineConfig()");
        }
        j m = bVar.A.m();
        this.B = m;
        this.f12481c = bVar.f12491b == null ? new e.f.j.d.i((ActivityManager) bVar.f12494e.getSystemService("activity")) : bVar.f12491b;
        this.f12482d = bVar.f12492c == null ? new e.f.j.d.d() : bVar.f12492c;
        this.f12480b = bVar.a == null ? Bitmap.Config.ARGB_8888 : bVar.a;
        if (bVar.f12493d != null) {
            fVar = bVar.f12493d;
        } else {
            fVar = e.f.j.d.j.f();
        }
        this.f12483e = fVar;
        this.f12484f = (Context) e.f.d.c.i.g(bVar.f12494e);
        this.f12486h = bVar.x == null ? new e.f.j.e.c(new e()) : bVar.x;
        this.f12485g = bVar.f12495f;
        this.f12487i = bVar.f12496g == null ? new e.f.j.d.k() : bVar.f12496g;
        if (bVar.f12498i != null) {
            nVar = bVar.f12498i;
        } else {
            nVar = t.n();
        }
        this.f12489k = nVar;
        this.f12490l = bVar.f12499j;
        this.m = r(bVar);
        this.n = bVar.f12501l;
        this.o = bVar.m == null ? new a() : bVar.m;
        e.f.b.b.c i3 = bVar.n == null ? i(bVar.f12494e) : bVar.n;
        this.p = i3;
        if (bVar.o != null) {
            cVar = bVar.o;
        } else {
            cVar = com.facebook.common.memory.d.b();
        }
        this.q = cVar;
        this.r = w(bVar, m);
        int i4 = bVar.z < 0 ? 30000 : bVar.z;
        this.t = i4;
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("ImagePipelineConfig->mNetworkFetcher");
        }
        this.s = bVar.q == null ? new e.f.j.l.t(i4) : bVar.q;
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        this.u = bVar.r;
        if (bVar.s != null) {
            d0Var = bVar.s;
        } else {
            d0Var = new d0(c0.m().m());
        }
        this.v = d0Var;
        this.w = bVar.t == null ? new com.facebook.imagepipeline.decoder.f() : bVar.t;
        this.x = bVar.u == null ? new HashSet<>() : bVar.u;
        this.y = bVar.v;
        this.z = bVar.w != null ? bVar.w : i3;
        com.facebook.imagepipeline.decoder.c unused = bVar.y;
        this.f12488j = bVar.f12497h == null ? new e.f.j.e.b(d0Var.d()) : bVar.f12497h;
        this.C = bVar.B;
        this.D = bVar.C;
        this.E = bVar.D;
        e.f.d.h.b h2 = m.h();
        if (h2 != null) {
            H(h2, m, new e.f.j.c.d(z()));
        } else if (m.o() && e.f.d.h.c.a && (i2 = e.f.d.h.c.i()) != null) {
            H(i2, m, new e.f.j.c.d(z()));
        }
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }
}