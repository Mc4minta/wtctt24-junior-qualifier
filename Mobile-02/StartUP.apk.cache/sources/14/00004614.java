package e.f.j.d;

import android.graphics.Bitmap;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: CountingMemoryCache.java */
/* loaded from: classes2.dex */
public class h<K, V> implements p<K, V>, com.facebook.common.memory.b {
    final g<K, d<K, V>> a;

    /* renamed from: b  reason: collision with root package name */
    final g<K, d<K, V>> f12443b;

    /* renamed from: d  reason: collision with root package name */
    private final v<V> f12445d;

    /* renamed from: e  reason: collision with root package name */
    private final c f12446e;

    /* renamed from: f  reason: collision with root package name */
    private final e.f.d.c.l<q> f12447f;

    /* renamed from: g  reason: collision with root package name */
    protected q f12448g;

    /* renamed from: c  reason: collision with root package name */
    final Map<Bitmap, Object> f12444c = new WeakHashMap();

    /* renamed from: h  reason: collision with root package name */
    private long f12449h = SystemClock.uptimeMillis();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CountingMemoryCache.java */
    /* loaded from: classes2.dex */
    public class a implements v<d<K, V>> {
        final /* synthetic */ v a;

        a(v vVar) {
            this.a = vVar;
        }

        @Override // e.f.j.d.v
        /* renamed from: b */
        public int a(d<K, V> dVar) {
            return this.a.a(dVar.f12452b.n());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CountingMemoryCache.java */
    /* loaded from: classes2.dex */
    public class b implements com.facebook.common.references.c<V> {
        final /* synthetic */ d a;

        b(d dVar) {
            this.a = dVar;
        }

        @Override // com.facebook.common.references.c
        public void release(V v) {
            h.this.v(this.a);
        }
    }

    /* compiled from: CountingMemoryCache.java */
    /* loaded from: classes2.dex */
    public interface c {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CountingMemoryCache.java */
    /* loaded from: classes2.dex */
    public static class d<K, V> {
        public final K a;

        /* renamed from: b  reason: collision with root package name */
        public final com.facebook.common.references.a<V> f12452b;

        /* renamed from: c  reason: collision with root package name */
        public int f12453c = 0;

        /* renamed from: d  reason: collision with root package name */
        public boolean f12454d = false;

        /* renamed from: e  reason: collision with root package name */
        public final e<K> f12455e;

        private d(K k2, com.facebook.common.references.a<V> aVar, e<K> eVar) {
            this.a = (K) e.f.d.c.i.g(k2);
            this.f12452b = (com.facebook.common.references.a) e.f.d.c.i.g(com.facebook.common.references.a.e(aVar));
            this.f12455e = eVar;
        }

        static <K, V> d<K, V> a(K k2, com.facebook.common.references.a<V> aVar, e<K> eVar) {
            return new d<>(k2, aVar, eVar);
        }
    }

    /* compiled from: CountingMemoryCache.java */
    /* loaded from: classes2.dex */
    public interface e<K> {
        void a(K k2, boolean z);
    }

    public h(v<V> vVar, c cVar, e.f.d.c.l<q> lVar) {
        this.f12445d = vVar;
        this.a = new g<>(x(vVar));
        this.f12443b = new g<>(x(vVar));
        this.f12446e = cVar;
        this.f12447f = lVar;
        this.f12448g = lVar.get();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (i() <= (r3.f12448g.a - r4)) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean f(V r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            e.f.j.d.v<V> r0 = r3.f12445d     // Catch: java.lang.Throwable -> L28
            int r4 = r0.a(r4)     // Catch: java.lang.Throwable -> L28
            e.f.j.d.q r0 = r3.f12448g     // Catch: java.lang.Throwable -> L28
            int r0 = r0.f12461e     // Catch: java.lang.Throwable -> L28
            r1 = 1
            if (r4 > r0) goto L25
            int r0 = r3.h()     // Catch: java.lang.Throwable -> L28
            e.f.j.d.q r2 = r3.f12448g     // Catch: java.lang.Throwable -> L28
            int r2 = r2.f12458b     // Catch: java.lang.Throwable -> L28
            int r2 = r2 - r1
            if (r0 > r2) goto L25
            int r0 = r3.i()     // Catch: java.lang.Throwable -> L28
            e.f.j.d.q r2 = r3.f12448g     // Catch: java.lang.Throwable -> L28
            int r2 = r2.a     // Catch: java.lang.Throwable -> L28
            int r2 = r2 - r4
            if (r0 > r2) goto L25
            goto L26
        L25:
            r1 = 0
        L26:
            monitor-exit(r3)
            return r1
        L28:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.j.d.h.f(java.lang.Object):boolean");
    }

    private synchronized void g(d<K, V> dVar) {
        e.f.d.c.i.g(dVar);
        e.f.d.c.i.i(dVar.f12453c > 0);
        dVar.f12453c--;
    }

    private synchronized void j(d<K, V> dVar) {
        e.f.d.c.i.g(dVar);
        e.f.d.c.i.i(!dVar.f12454d);
        dVar.f12453c++;
    }

    private synchronized void k(d<K, V> dVar) {
        e.f.d.c.i.g(dVar);
        e.f.d.c.i.i(!dVar.f12454d);
        dVar.f12454d = true;
    }

    private synchronized void l(ArrayList<d<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<d<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                k(it.next());
            }
        }
    }

    private synchronized boolean m(d<K, V> dVar) {
        if (dVar.f12454d || dVar.f12453c != 0) {
            return false;
        }
        this.a.g(dVar.a, dVar);
        return true;
    }

    private void n(ArrayList<d<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<d<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.f(u(it.next()));
            }
        }
    }

    private void o() {
        ArrayList<d<K, V>> w;
        synchronized (this) {
            q qVar = this.f12448g;
            int min = Math.min(qVar.f12460d, qVar.f12458b - h());
            q qVar2 = this.f12448g;
            w = w(min, Math.min(qVar2.f12459c, qVar2.a - i()));
            l(w);
        }
        n(w);
        r(w);
    }

    private static <K, V> void p(d<K, V> dVar) {
        e<K> eVar;
        if (dVar == null || (eVar = dVar.f12455e) == null) {
            return;
        }
        eVar.a(dVar.a, true);
    }

    private static <K, V> void q(d<K, V> dVar) {
        e<K> eVar;
        if (dVar == null || (eVar = dVar.f12455e) == null) {
            return;
        }
        eVar.a(dVar.a, false);
    }

    private void r(ArrayList<d<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<d<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                q(it.next());
            }
        }
    }

    private synchronized void s() {
        if (this.f12449h + this.f12448g.f12462f > SystemClock.uptimeMillis()) {
            return;
        }
        this.f12449h = SystemClock.uptimeMillis();
        this.f12448g = this.f12447f.get();
    }

    private synchronized com.facebook.common.references.a<V> t(d<K, V> dVar) {
        j(dVar);
        return com.facebook.common.references.a.e0(dVar.f12452b.n(), new b(dVar));
    }

    private synchronized com.facebook.common.references.a<V> u(d<K, V> dVar) {
        e.f.d.c.i.g(dVar);
        return (dVar.f12454d && dVar.f12453c == 0) ? dVar.f12452b : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(d<K, V> dVar) {
        boolean m;
        com.facebook.common.references.a<V> u;
        e.f.d.c.i.g(dVar);
        synchronized (this) {
            g(dVar);
            m = m(dVar);
            u = u(dVar);
        }
        com.facebook.common.references.a.f(u);
        if (!m) {
            dVar = null;
        }
        p(dVar);
        s();
        o();
    }

    private synchronized ArrayList<d<K, V>> w(int i2, int i3) {
        int max = Math.max(i2, 0);
        int max2 = Math.max(i3, 0);
        if (this.a.b() <= max && this.a.e() <= max2) {
            return null;
        }
        ArrayList<d<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (this.a.b() <= max && this.a.e() <= max2) {
                return arrayList;
            }
            K c2 = this.a.c();
            this.a.h(c2);
            arrayList.add(this.f12443b.h(c2));
        }
    }

    private v<d<K, V>> x(v<V> vVar) {
        return new a(vVar);
    }

    @Override // e.f.j.d.p
    public com.facebook.common.references.a<V> a(K k2, com.facebook.common.references.a<V> aVar) {
        return e(k2, aVar, null);
    }

    @Override // e.f.j.d.p
    public int b(e.f.d.c.j<K> jVar) {
        ArrayList<d<K, V>> i2;
        ArrayList<d<K, V>> i3;
        synchronized (this) {
            i2 = this.a.i(jVar);
            i3 = this.f12443b.i(jVar);
            l(i3);
        }
        n(i3);
        r(i2);
        s();
        o();
        return i3.size();
    }

    @Override // e.f.j.d.p
    public synchronized boolean c(e.f.d.c.j<K> jVar) {
        return !this.f12443b.d(jVar).isEmpty();
    }

    public com.facebook.common.references.a<V> e(K k2, com.facebook.common.references.a<V> aVar, e<K> eVar) {
        d<K, V> h2;
        com.facebook.common.references.a<V> aVar2;
        com.facebook.common.references.a<V> aVar3;
        e.f.d.c.i.g(k2);
        e.f.d.c.i.g(aVar);
        s();
        synchronized (this) {
            h2 = this.a.h(k2);
            d<K, V> h3 = this.f12443b.h(k2);
            aVar2 = null;
            if (h3 != null) {
                k(h3);
                aVar3 = u(h3);
            } else {
                aVar3 = null;
            }
            if (f(aVar.n())) {
                d<K, V> a2 = d.a(k2, aVar, eVar);
                this.f12443b.g(k2, a2);
                aVar2 = t(a2);
            }
        }
        com.facebook.common.references.a.f(aVar3);
        q(h2);
        o();
        return aVar2;
    }

    @Override // e.f.j.d.p
    public com.facebook.common.references.a<V> get(K k2) {
        d<K, V> h2;
        com.facebook.common.references.a<V> t;
        e.f.d.c.i.g(k2);
        synchronized (this) {
            h2 = this.a.h(k2);
            d<K, V> a2 = this.f12443b.a(k2);
            t = a2 != null ? t(a2) : null;
        }
        q(h2);
        s();
        o();
        return t;
    }

    public synchronized int h() {
        return this.f12443b.b() - this.a.b();
    }

    public synchronized int i() {
        return this.f12443b.e() - this.a.e();
    }
}