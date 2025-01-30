package e.f.j.e;

import android.net.Uri;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.b;
import e.f.j.d.p;
import e.f.j.l.j0;
import e.f.j.l.p0;
import e.f.j.l.t0;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ImagePipeline.java */
/* loaded from: classes2.dex */
public class h {
    private static final CancellationException a = new CancellationException("Prefetching is not enabled");

    /* renamed from: b  reason: collision with root package name */
    private final n f12468b;

    /* renamed from: c  reason: collision with root package name */
    private final e.f.j.j.c f12469c;

    /* renamed from: d  reason: collision with root package name */
    private final e.f.d.c.l<Boolean> f12470d;

    /* renamed from: e  reason: collision with root package name */
    private final p<e.f.b.a.d, e.f.j.i.b> f12471e;

    /* renamed from: f  reason: collision with root package name */
    private final p<e.f.b.a.d, PooledByteBuffer> f12472f;

    /* renamed from: g  reason: collision with root package name */
    private final e.f.j.d.e f12473g;

    /* renamed from: h  reason: collision with root package name */
    private final e.f.j.d.e f12474h;

    /* renamed from: i  reason: collision with root package name */
    private final e.f.j.d.f f12475i;

    /* renamed from: j  reason: collision with root package name */
    private final t0 f12476j;

    /* renamed from: k  reason: collision with root package name */
    private final e.f.d.c.l<Boolean> f12477k;

    /* renamed from: l  reason: collision with root package name */
    private AtomicLong f12478l = new AtomicLong();
    private final e.f.d.c.l<Boolean> m;
    private final e.f.c.a n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImagePipeline.java */
    /* loaded from: classes2.dex */
    public class a implements e.f.d.c.j<e.f.b.a.d> {
        a() {
        }

        @Override // e.f.d.c.j
        /* renamed from: a */
        public boolean apply(e.f.b.a.d dVar) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImagePipeline.java */
    /* loaded from: classes2.dex */
    public class b implements e.f.d.c.j<e.f.b.a.d> {
        final /* synthetic */ Uri a;

        b(Uri uri) {
            this.a = uri;
        }

        @Override // e.f.d.c.j
        /* renamed from: a */
        public boolean apply(e.f.b.a.d dVar) {
            return dVar.a(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImagePipeline.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.a.values().length];
            a = iArr;
            try {
                iArr[b.a.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.a.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public h(n nVar, Set<e.f.j.j.c> set, e.f.d.c.l<Boolean> lVar, p<e.f.b.a.d, e.f.j.i.b> pVar, p<e.f.b.a.d, PooledByteBuffer> pVar2, e.f.j.d.e eVar, e.f.j.d.e eVar2, e.f.j.d.f fVar, t0 t0Var, e.f.d.c.l<Boolean> lVar2, e.f.d.c.l<Boolean> lVar3, e.f.c.a aVar) {
        this.f12468b = nVar;
        this.f12469c = new e.f.j.j.b(set);
        this.f12470d = lVar;
        this.f12471e = pVar;
        this.f12472f = pVar2;
        this.f12473g = eVar;
        this.f12474h = eVar2;
        this.f12475i = fVar;
        this.f12476j = t0Var;
        this.f12477k = lVar2;
        this.m = lVar3;
        this.n = aVar;
    }

    private e.f.d.c.j<e.f.b.a.d> q(Uri uri) {
        return new b(uri);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> e.f.e.c<com.facebook.common.references.a<T>> t(e.f.j.l.j0<com.facebook.common.references.a<T>> r11, com.facebook.imagepipeline.request.b r12, com.facebook.imagepipeline.request.b.EnumC0109b r13, java.lang.Object r14, e.f.j.j.c r15) {
        /*
            r10 = this;
            boolean r0 = e.f.j.m.b.d()
            if (r0 == 0) goto Lb
            java.lang.String r0 = "ImagePipeline#submitFetchRequest"
            e.f.j.m.b.a(r0)
        Lb:
            e.f.j.j.c r15 = r10.k(r12, r15)
            e.f.c.a r0 = r10.n
            if (r0 == 0) goto L16
            r0.a(r14)
        L16:
            com.facebook.imagepipeline.request.b$b r0 = r12.f()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            com.facebook.imagepipeline.request.b$b r6 = com.facebook.imagepipeline.request.b.EnumC0109b.h(r0, r13)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            e.f.j.l.p0 r13 = new e.f.j.l.p0     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.lang.String r3 = r10.h()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r7 = 0
            boolean r0 = r12.k()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            if (r0 != 0) goto L38
            android.net.Uri r0 = r12.q()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            boolean r0 = com.facebook.common.util.e.k(r0)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            if (r0 != 0) goto L36
            goto L38
        L36:
            r0 = 0
            goto L39
        L38:
            r0 = 1
        L39:
            r8 = r0
            com.facebook.imagepipeline.common.d r9 = r12.j()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r1 = r13
            r2 = r12
            r4 = r15
            r5 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            e.f.e.c r11 = e.f.j.f.c.C(r11, r13, r15)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            boolean r12 = e.f.j.m.b.d()
            if (r12 == 0) goto L52
            e.f.j.m.b.b()
        L52:
            return r11
        L53:
            r11 = move-exception
            goto L64
        L55:
            r11 = move-exception
            e.f.e.c r11 = e.f.e.d.b(r11)     // Catch: java.lang.Throwable -> L53
            boolean r12 = e.f.j.m.b.d()
            if (r12 == 0) goto L63
            e.f.j.m.b.b()
        L63:
            return r11
        L64:
            boolean r12 = e.f.j.m.b.d()
            if (r12 == 0) goto L6d
            e.f.j.m.b.b()
        L6d:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.j.e.h.t(e.f.j.l.j0, com.facebook.imagepipeline.request.b, com.facebook.imagepipeline.request.b$b, java.lang.Object, e.f.j.j.c):e.f.e.c");
    }

    private e.f.e.c<Void> u(j0<Void> j0Var, com.facebook.imagepipeline.request.b bVar, b.EnumC0109b enumC0109b, Object obj, com.facebook.imagepipeline.common.d dVar) {
        e.f.j.j.c k2 = k(bVar, null);
        e.f.c.a aVar = this.n;
        if (aVar != null) {
            aVar.a(obj);
        }
        try {
            return e.f.j.f.d.B(j0Var, new p0(bVar, h(), k2, obj, b.EnumC0109b.h(bVar.f(), enumC0109b), true, false, dVar), k2);
        } catch (Exception e2) {
            return e.f.e.d.b(e2);
        }
    }

    public void a() {
        c();
        b();
    }

    public void b() {
        this.f12473g.i();
        this.f12474h.i();
    }

    public void c() {
        a aVar = new a();
        this.f12471e.b(aVar);
        this.f12472f.b(aVar);
    }

    public e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> d(com.facebook.imagepipeline.request.b bVar, Object obj) {
        return e(bVar, obj, b.EnumC0109b.FULL_FETCH);
    }

    public e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> e(com.facebook.imagepipeline.request.b bVar, Object obj, b.EnumC0109b enumC0109b) {
        return f(bVar, obj, enumC0109b, null);
    }

    public e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> f(com.facebook.imagepipeline.request.b bVar, Object obj, b.EnumC0109b enumC0109b, e.f.j.j.c cVar) {
        try {
            return t(this.f12468b.g(bVar), bVar, enumC0109b, obj, cVar);
        } catch (Exception e2) {
            return e.f.e.d.b(e2);
        }
    }

    public e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> g(com.facebook.imagepipeline.request.b bVar, Object obj) {
        return e(bVar, obj, b.EnumC0109b.BITMAP_MEMORY_CACHE);
    }

    public String h() {
        return String.valueOf(this.f12478l.getAndIncrement());
    }

    public p<e.f.b.a.d, e.f.j.i.b> i() {
        return this.f12471e;
    }

    public e.f.j.d.f j() {
        return this.f12475i;
    }

    public e.f.j.j.c k(com.facebook.imagepipeline.request.b bVar, e.f.j.j.c cVar) {
        if (cVar == null) {
            if (bVar.l() == null) {
                return this.f12469c;
            }
            return new e.f.j.j.b(this.f12469c, bVar.l());
        } else if (bVar.l() == null) {
            return new e.f.j.j.b(this.f12469c, cVar);
        } else {
            return new e.f.j.j.b(this.f12469c, cVar, bVar.l());
        }
    }

    public boolean l(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.f12471e.c(q(uri));
    }

    public boolean m(com.facebook.imagepipeline.request.b bVar) {
        if (bVar == null) {
            return false;
        }
        com.facebook.common.references.a<e.f.j.i.b> aVar = this.f12471e.get(this.f12475i.a(bVar, null));
        try {
            return com.facebook.common.references.a.G(aVar);
        } finally {
            com.facebook.common.references.a.f(aVar);
        }
    }

    public boolean n(Uri uri) {
        return o(uri, b.a.SMALL) || o(uri, b.a.DEFAULT);
    }

    public boolean o(Uri uri, b.a aVar) {
        return p(ImageRequestBuilder.r(uri).u(aVar).a());
    }

    public boolean p(com.facebook.imagepipeline.request.b bVar) {
        e.f.b.a.d d2 = this.f12475i.d(bVar, null);
        int i2 = c.a[bVar.c().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return false;
            }
            return this.f12474h.k(d2);
        }
        return this.f12473g.k(d2);
    }

    public e.f.e.c<Void> r(com.facebook.imagepipeline.request.b bVar, Object obj) {
        return s(bVar, obj, com.facebook.imagepipeline.common.d.MEDIUM);
    }

    public e.f.e.c<Void> s(com.facebook.imagepipeline.request.b bVar, Object obj, com.facebook.imagepipeline.common.d dVar) {
        if (!this.f12470d.get().booleanValue()) {
            return e.f.e.d.b(a);
        }
        try {
            return u(this.f12468b.h(bVar), bVar, b.EnumC0109b.FULL_FETCH, obj, dVar);
        } catch (Exception e2) {
            return e.f.e.d.b(e2);
        }
    }
}