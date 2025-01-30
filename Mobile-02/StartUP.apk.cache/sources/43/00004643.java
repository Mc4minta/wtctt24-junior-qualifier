package e.f.j.e;

import android.content.ContentResolver;
import android.net.Uri;
import com.facebook.imagepipeline.request.b;
import e.f.j.l.f0;
import e.f.j.l.j0;
import e.f.j.l.o;
import e.f.j.l.p;
import e.f.j.l.t0;
import e.f.j.l.w0;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProducerSequenceFactory.java */
/* loaded from: classes2.dex */
public class n {
    private final ContentResolver a;

    /* renamed from: b  reason: collision with root package name */
    private final m f12550b;

    /* renamed from: c  reason: collision with root package name */
    private final f0 f12551c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f12552d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f12553e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f12554f;

    /* renamed from: g  reason: collision with root package name */
    private final t0 f12555g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f12556h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f12557i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f12558j;

    /* renamed from: k  reason: collision with root package name */
    private final e.f.j.n.d f12559k;

    /* renamed from: l  reason: collision with root package name */
    j0<com.facebook.common.references.a<e.f.j.i.b>> f12560l;
    j0<e.f.j.i.d> m;
    j0<e.f.j.i.d> n;
    j0<Void> o;
    j0<Void> p;
    private j0<e.f.j.i.d> q;
    j0<com.facebook.common.references.a<e.f.j.i.b>> r;
    j0<com.facebook.common.references.a<e.f.j.i.b>> s;
    j0<com.facebook.common.references.a<e.f.j.i.b>> t;
    j0<com.facebook.common.references.a<e.f.j.i.b>> u;
    j0<com.facebook.common.references.a<e.f.j.i.b>> v;
    j0<com.facebook.common.references.a<e.f.j.i.b>> w;
    j0<com.facebook.common.references.a<e.f.j.i.b>> x;
    Map<j0<com.facebook.common.references.a<e.f.j.i.b>>, j0<com.facebook.common.references.a<e.f.j.i.b>>> y = new HashMap();
    Map<j0<com.facebook.common.references.a<e.f.j.i.b>>, j0<Void>> z = new HashMap();
    Map<j0<com.facebook.common.references.a<e.f.j.i.b>>, j0<com.facebook.common.references.a<e.f.j.i.b>>> A = new HashMap();

    public n(ContentResolver contentResolver, m mVar, f0 f0Var, boolean z, boolean z2, t0 t0Var, boolean z3, boolean z4, boolean z5, boolean z6, e.f.j.n.d dVar) {
        this.a = contentResolver;
        this.f12550b = mVar;
        this.f12551c = f0Var;
        this.f12552d = z;
        this.f12553e = z2;
        this.f12555g = t0Var;
        this.f12556h = z3;
        this.f12557i = z4;
        this.f12554f = z5;
        this.f12558j = z6;
        this.f12559k = dVar;
    }

    private j0<e.f.j.i.d> A(j0<e.f.j.i.d> j0Var, w0<e.f.j.i.d>[] w0VarArr) {
        return m.g(z(w0VarArr), this.f12550b.B(this.f12550b.z(m.a(j0Var), true, this.f12559k)));
    }

    private static void B(com.facebook.imagepipeline.request.b bVar) {
        e.f.d.c.i.g(bVar);
        e.f.d.c.i.b(bVar.f().n() <= b.EnumC0109b.ENCODED_MEMORY_CACHE.n());
    }

    private synchronized j0<e.f.j.i.d> a() {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence");
        }
        if (this.m == null) {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence:init");
            }
            this.m = this.f12550b.b(y(this.f12550b.r()), this.f12555g);
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        return this.m;
    }

    private synchronized j0<e.f.j.i.d> b() {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence");
        }
        if (this.n == null) {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence:init");
            }
            this.n = this.f12550b.b(e(), this.f12555g);
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        return this.n;
    }

    private j0<com.facebook.common.references.a<e.f.j.i.b>> c(com.facebook.imagepipeline.request.b bVar) {
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("ProducerSequenceFactory#getBasicDecodedImageSequence");
            }
            e.f.d.c.i.g(bVar);
            Uri q = bVar.q();
            e.f.d.c.i.h(q, "Uri is null.");
            int r = bVar.r();
            if (r != 0) {
                switch (r) {
                    case 2:
                        j0<com.facebook.common.references.a<e.f.j.i.b>> n = n();
                        if (e.f.j.m.b.d()) {
                            e.f.j.m.b.b();
                        }
                        return n;
                    case 3:
                        j0<com.facebook.common.references.a<e.f.j.i.b>> l2 = l();
                        if (e.f.j.m.b.d()) {
                            e.f.j.m.b.b();
                        }
                        return l2;
                    case 4:
                        if (e.f.d.e.a.c(this.a.getType(q))) {
                            j0<com.facebook.common.references.a<e.f.j.i.b>> n2 = n();
                            if (e.f.j.m.b.d()) {
                                e.f.j.m.b.b();
                            }
                            return n2;
                        }
                        j0<com.facebook.common.references.a<e.f.j.i.b>> j2 = j();
                        if (e.f.j.m.b.d()) {
                            e.f.j.m.b.b();
                        }
                        return j2;
                    case 5:
                        j0<com.facebook.common.references.a<e.f.j.i.b>> i2 = i();
                        if (e.f.j.m.b.d()) {
                            e.f.j.m.b.b();
                        }
                        return i2;
                    case 6:
                        j0<com.facebook.common.references.a<e.f.j.i.b>> m = m();
                        if (e.f.j.m.b.d()) {
                            e.f.j.m.b.b();
                        }
                        return m;
                    case 7:
                        j0<com.facebook.common.references.a<e.f.j.i.b>> f2 = f();
                        if (e.f.j.m.b.d()) {
                            e.f.j.m.b.b();
                        }
                        return f2;
                    case 8:
                        return r();
                    default:
                        throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + s(q));
                }
            }
            j0<com.facebook.common.references.a<e.f.j.i.b>> o = o();
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
            return o;
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }

    private synchronized j0<com.facebook.common.references.a<e.f.j.i.b>> d(j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var) {
        j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var2;
        j0Var2 = this.A.get(j0Var);
        if (j0Var2 == null) {
            j0Var2 = this.f12550b.f(j0Var);
            this.A.put(j0Var, j0Var2);
        }
        return j0Var2;
    }

    private synchronized j0<e.f.j.i.d> e() {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence");
        }
        if (this.q == null) {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence:init");
            }
            e.f.j.l.a a = m.a(y(this.f12550b.u(this.f12551c)));
            this.q = a;
            this.q = this.f12550b.z(a, this.f12552d && !this.f12556h, this.f12559k);
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        return this.q;
    }

    private synchronized j0<com.facebook.common.references.a<e.f.j.i.b>> f() {
        if (this.w == null) {
            j0<e.f.j.i.d> h2 = this.f12550b.h();
            if (e.f.d.h.c.a && (!this.f12553e || e.f.d.h.c.f12093d == null)) {
                h2 = this.f12550b.D(h2);
            }
            this.w = u(this.f12550b.z(m.a(h2), true, this.f12559k));
        }
        return this.w;
    }

    private synchronized j0<com.facebook.common.references.a<e.f.j.i.b>> i() {
        if (this.v == null) {
            this.v = v(this.f12550b.n());
        }
        return this.v;
    }

    private synchronized j0<com.facebook.common.references.a<e.f.j.i.b>> j() {
        if (this.t == null) {
            this.t = w(this.f12550b.o(), new w0[]{this.f12550b.p(), this.f12550b.q()});
        }
        return this.t;
    }

    private synchronized j0<Void> k() {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence");
        }
        if (this.o == null) {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");
            }
            this.o = m.A(a());
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        return this.o;
    }

    private synchronized j0<com.facebook.common.references.a<e.f.j.i.b>> l() {
        if (this.r == null) {
            this.r = v(this.f12550b.r());
        }
        return this.r;
    }

    private synchronized j0<com.facebook.common.references.a<e.f.j.i.b>> m() {
        if (this.u == null) {
            this.u = v(this.f12550b.s());
        }
        return this.u;
    }

    private synchronized j0<com.facebook.common.references.a<e.f.j.i.b>> n() {
        if (this.s == null) {
            this.s = t(this.f12550b.t());
        }
        return this.s;
    }

    private synchronized j0<com.facebook.common.references.a<e.f.j.i.b>> o() {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("ProducerSequenceFactory#getNetworkFetchSequence");
        }
        if (this.f12560l == null) {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("ProducerSequenceFactory#getNetworkFetchSequence:init");
            }
            this.f12560l = u(e());
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        return this.f12560l;
    }

    private synchronized j0<Void> p() {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence");
        }
        if (this.p == null) {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence:init");
            }
            this.p = m.A(b());
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        return this.p;
    }

    private synchronized j0<com.facebook.common.references.a<e.f.j.i.b>> q(j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var) {
        if (!this.y.containsKey(j0Var)) {
            this.y.put(j0Var, this.f12550b.w(this.f12550b.x(j0Var)));
        }
        return this.y.get(j0Var);
    }

    private synchronized j0<com.facebook.common.references.a<e.f.j.i.b>> r() {
        if (this.x == null) {
            this.x = v(this.f12550b.y());
        }
        return this.x;
    }

    private static String s(Uri uri) {
        String valueOf = String.valueOf(uri);
        if (valueOf.length() > 30) {
            return valueOf.substring(0, 30) + "...";
        }
        return valueOf;
    }

    private j0<com.facebook.common.references.a<e.f.j.i.b>> t(j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var) {
        return this.f12550b.c(this.f12550b.b(this.f12550b.d(this.f12550b.e(j0Var)), this.f12555g));
    }

    private j0<com.facebook.common.references.a<e.f.j.i.b>> u(j0<e.f.j.i.d> j0Var) {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
        }
        j0<com.facebook.common.references.a<e.f.j.i.b>> t = t(this.f12550b.i(j0Var));
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        return t;
    }

    private j0<com.facebook.common.references.a<e.f.j.i.b>> v(j0<e.f.j.i.d> j0Var) {
        return w(j0Var, new w0[]{this.f12550b.q()});
    }

    private j0<com.facebook.common.references.a<e.f.j.i.b>> w(j0<e.f.j.i.d> j0Var, w0<e.f.j.i.d>[] w0VarArr) {
        return u(A(y(j0Var), w0VarArr));
    }

    private j0<e.f.j.i.d> x(j0<e.f.j.i.d> j0Var) {
        p k2;
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("ProducerSequenceFactory#newDiskCacheSequence");
        }
        if (this.f12554f) {
            k2 = this.f12550b.k(this.f12550b.v(j0Var));
        } else {
            k2 = this.f12550b.k(j0Var);
        }
        o j2 = this.f12550b.j(k2);
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        return j2;
    }

    private j0<e.f.j.i.d> y(j0<e.f.j.i.d> j0Var) {
        if (e.f.d.h.c.a && (!this.f12553e || e.f.d.h.c.f12093d == null)) {
            j0Var = this.f12550b.D(j0Var);
        }
        if (this.f12558j) {
            j0Var = x(j0Var);
        }
        return this.f12550b.l(this.f12550b.m(j0Var));
    }

    private j0<e.f.j.i.d> z(w0<e.f.j.i.d>[] w0VarArr) {
        return this.f12550b.z(this.f12550b.C(w0VarArr), true, this.f12559k);
    }

    public j0<com.facebook.common.references.a<e.f.j.i.b>> g(com.facebook.imagepipeline.request.b bVar) {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("ProducerSequenceFactory#getDecodedImageProducerSequence");
        }
        j0<com.facebook.common.references.a<e.f.j.i.b>> c2 = c(bVar);
        if (bVar.g() != null) {
            c2 = q(c2);
        }
        if (this.f12557i) {
            c2 = d(c2);
        }
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        return c2;
    }

    public j0<Void> h(com.facebook.imagepipeline.request.b bVar) {
        B(bVar);
        int r = bVar.r();
        if (r != 0) {
            if (r != 2 && r != 3) {
                Uri q = bVar.q();
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + s(q));
            }
            return k();
        }
        return p();
    }
}