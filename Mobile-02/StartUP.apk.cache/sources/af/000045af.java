package e.f.h.c;

import android.content.Context;
import android.graphics.drawable.Animatable;
import e.f.d.c.h;
import e.f.d.c.i;
import e.f.d.c.l;
import e.f.e.g;
import e.f.h.c.b;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: AbstractDraweeControllerBuilder.java */
/* loaded from: classes2.dex */
public abstract class b<BUILDER extends b<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements e.f.h.h.d {
    private static final d<Object> a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final NullPointerException f12214b = new NullPointerException("No image request was specified!");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicLong f12215c = new AtomicLong();

    /* renamed from: d  reason: collision with root package name */
    private final Context f12216d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<d> f12217e;

    /* renamed from: f  reason: collision with root package name */
    private Object f12218f;

    /* renamed from: g  reason: collision with root package name */
    private REQUEST f12219g;

    /* renamed from: h  reason: collision with root package name */
    private REQUEST f12220h;

    /* renamed from: i  reason: collision with root package name */
    private REQUEST[] f12221i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12222j;

    /* renamed from: k  reason: collision with root package name */
    private l<e.f.e.c<IMAGE>> f12223k;

    /* renamed from: l  reason: collision with root package name */
    private d<? super INFO> f12224l;
    private e m;
    private boolean n;
    private boolean o;
    private boolean p;
    private String q;
    private e.f.h.h.a r;

    /* compiled from: AbstractDraweeControllerBuilder.java */
    /* loaded from: classes2.dex */
    static class a extends e.f.h.c.c<Object> {
        a() {
        }

        @Override // e.f.h.c.c, e.f.h.c.d
        public void b(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractDraweeControllerBuilder.java */
    /* renamed from: e.f.h.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0267b implements l<e.f.e.c<IMAGE>> {
        final /* synthetic */ e.f.h.h.a a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12225b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f12226c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f12227d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f12228e;

        C0267b(e.f.h.h.a aVar, String str, Object obj, Object obj2, c cVar) {
            this.a = aVar;
            this.f12225b = str;
            this.f12226c = obj;
            this.f12227d = obj2;
            this.f12228e = cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e.f.d.c.l
        /* renamed from: a */
        public e.f.e.c<IMAGE> get() {
            return b.this.i(this.a, this.f12225b, this.f12226c, this.f12227d, this.f12228e);
        }

        public String toString() {
            return h.d(this).b("request", this.f12226c.toString()).toString();
        }
    }

    /* compiled from: AbstractDraweeControllerBuilder.java */
    /* loaded from: classes2.dex */
    public enum c {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, Set<d> set) {
        this.f12216d = context;
        this.f12217e = set;
        q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String e() {
        return String.valueOf(f12215c.getAndIncrement());
    }

    private void q() {
        this.f12218f = null;
        this.f12219g = null;
        this.f12220h = null;
        this.f12221i = null;
        this.f12222j = true;
        this.f12224l = null;
        this.m = null;
        this.n = false;
        this.o = false;
        this.r = null;
        this.q = null;
    }

    public BUILDER A(REQUEST request) {
        this.f12219g = request;
        return p();
    }

    public BUILDER B(REQUEST request) {
        this.f12220h = request;
        return p();
    }

    @Override // e.f.h.h.d
    /* renamed from: C */
    public BUILDER b(e.f.h.h.a aVar) {
        this.r = aVar;
        return p();
    }

    protected void D() {
        boolean z = false;
        i.j(this.f12221i == null || this.f12219g == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.f12223k == null || (this.f12221i == null && this.f12219g == null && this.f12220h == null)) {
            z = true;
        }
        i.j(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    @Override // e.f.h.h.d
    /* renamed from: c */
    public e.f.h.c.a build() {
        REQUEST request;
        D();
        if (this.f12219g == null && this.f12221i == null && (request = this.f12220h) != null) {
            this.f12219g = request;
            this.f12220h = null;
        }
        return d();
    }

    protected e.f.h.c.a d() {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("AbstractDraweeControllerBuilder#buildController");
        }
        e.f.h.c.a u = u();
        u.O(o());
        u.K(g());
        u.M(h());
        t(u);
        r(u);
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        return u;
    }

    public Object f() {
        return this.f12218f;
    }

    public String g() {
        return this.q;
    }

    public e h() {
        return this.m;
    }

    protected abstract e.f.e.c<IMAGE> i(e.f.h.h.a aVar, String str, REQUEST request, Object obj, c cVar);

    protected l<e.f.e.c<IMAGE>> j(e.f.h.h.a aVar, String str, REQUEST request) {
        return k(aVar, str, request, c.FULL_FETCH);
    }

    protected l<e.f.e.c<IMAGE>> k(e.f.h.h.a aVar, String str, REQUEST request, c cVar) {
        return new C0267b(aVar, str, request, f(), cVar);
    }

    protected l<e.f.e.c<IMAGE>> l(e.f.h.h.a aVar, String str, REQUEST[] requestArr, boolean z) {
        ArrayList arrayList = new ArrayList(requestArr.length * 2);
        if (z) {
            for (REQUEST request : requestArr) {
                arrayList.add(k(aVar, str, request, c.BITMAP_MEMORY_CACHE));
            }
        }
        for (REQUEST request2 : requestArr) {
            arrayList.add(j(aVar, str, request2));
        }
        return e.f.e.f.b(arrayList);
    }

    public REQUEST m() {
        return this.f12219g;
    }

    public e.f.h.h.a n() {
        return this.r;
    }

    public boolean o() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BUILDER p() {
        return this;
    }

    protected void r(e.f.h.c.a aVar) {
        Set<d> set = this.f12217e;
        if (set != null) {
            for (d dVar : set) {
                aVar.k(dVar);
            }
        }
        d<? super INFO> dVar2 = this.f12224l;
        if (dVar2 != null) {
            aVar.k(dVar2);
        }
        if (this.o) {
            aVar.k(a);
        }
    }

    protected void s(e.f.h.c.a aVar) {
        if (aVar.r() == null) {
            aVar.N(e.f.h.g.a.c(this.f12216d));
        }
    }

    protected void t(e.f.h.c.a aVar) {
        if (this.n) {
            aVar.w().d(this.n);
            s(aVar);
        }
    }

    protected abstract e.f.h.c.a u();

    /* JADX INFO: Access modifiers changed from: protected */
    public l<e.f.e.c<IMAGE>> v(e.f.h.h.a aVar, String str) {
        l<e.f.e.c<IMAGE>> lVar = this.f12223k;
        if (lVar != null) {
            return lVar;
        }
        l<e.f.e.c<IMAGE>> lVar2 = null;
        REQUEST request = this.f12219g;
        if (request != null) {
            lVar2 = j(aVar, str, request);
        } else {
            REQUEST[] requestArr = this.f12221i;
            if (requestArr != null) {
                lVar2 = l(aVar, str, requestArr, this.f12222j);
            }
        }
        if (lVar2 != null && this.f12220h != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(lVar2);
            arrayList.add(j(aVar, str, this.f12220h));
            lVar2 = g.c(arrayList, false);
        }
        return lVar2 == null ? e.f.e.d.a(f12214b) : lVar2;
    }

    public BUILDER w() {
        q();
        return p();
    }

    public BUILDER x(boolean z) {
        this.o = z;
        return p();
    }

    public BUILDER y(Object obj) {
        this.f12218f = obj;
        return p();
    }

    public BUILDER z(d<? super INFO> dVar) {
        this.f12224l = dVar;
        return p();
    }
}