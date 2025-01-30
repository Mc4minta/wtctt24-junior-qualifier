package e.f.b.b;

import android.content.Context;
import e.f.b.a.a;
import e.f.b.a.c;
import e.f.b.b.d;
import e.f.d.f.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskStorageCache.java */
/* loaded from: classes2.dex */
public class e implements i, e.f.d.a.a {
    private static final Class<?> a = e.class;

    /* renamed from: b  reason: collision with root package name */
    private static final long f12035b = TimeUnit.HOURS.toMillis(2);

    /* renamed from: c  reason: collision with root package name */
    private static final long f12036c = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: d  reason: collision with root package name */
    private final long f12037d;

    /* renamed from: e  reason: collision with root package name */
    private final long f12038e;

    /* renamed from: f  reason: collision with root package name */
    private final CountDownLatch f12039f;

    /* renamed from: g  reason: collision with root package name */
    private long f12040g;

    /* renamed from: h  reason: collision with root package name */
    private final e.f.b.a.c f12041h;

    /* renamed from: i  reason: collision with root package name */
    final Set<String> f12042i;

    /* renamed from: j  reason: collision with root package name */
    private long f12043j;

    /* renamed from: k  reason: collision with root package name */
    private final long f12044k;

    /* renamed from: l  reason: collision with root package name */
    private final e.f.d.f.a f12045l;
    private final d m;
    private final h n;
    private final e.f.b.a.a o;
    private final boolean p;
    private final b q;
    private final com.facebook.common.time.a r;
    private final Object s = new Object();
    private boolean t;

    /* compiled from: DiskStorageCache.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (e.this.s) {
                e.this.o();
            }
            e.this.t = true;
            e.this.f12039f.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskStorageCache.java */
    /* loaded from: classes2.dex */
    public static class b {
        private boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        private long f12046b = -1;

        /* renamed from: c  reason: collision with root package name */
        private long f12047c = -1;

        b() {
        }

        public synchronized long a() {
            return this.f12047c;
        }

        public synchronized long b() {
            return this.f12046b;
        }

        public synchronized void c(long j2, long j3) {
            if (this.a) {
                this.f12046b += j2;
                this.f12047c += j3;
            }
        }

        public synchronized boolean d() {
            return this.a;
        }

        public synchronized void e() {
            this.a = false;
            this.f12047c = -1L;
            this.f12046b = -1L;
        }

        public synchronized void f(long j2, long j3) {
            this.f12047c = j3;
            this.f12046b = j2;
            this.a = true;
        }
    }

    /* compiled from: DiskStorageCache.java */
    /* loaded from: classes2.dex */
    public static class c {
        public final long a;

        /* renamed from: b  reason: collision with root package name */
        public final long f12048b;

        /* renamed from: c  reason: collision with root package name */
        public final long f12049c;

        public c(long j2, long j3, long j4) {
            this.a = j2;
            this.f12048b = j3;
            this.f12049c = j4;
        }
    }

    public e(d dVar, h hVar, c cVar, e.f.b.a.c cVar2, e.f.b.a.a aVar, e.f.d.a.b bVar, Context context, Executor executor, boolean z) {
        this.f12037d = cVar.f12048b;
        long j2 = cVar.f12049c;
        this.f12038e = j2;
        this.f12040g = j2;
        this.f12045l = e.f.d.f.a.d();
        this.m = dVar;
        this.n = hVar;
        this.f12043j = -1L;
        this.f12041h = cVar2;
        this.f12044k = cVar.a;
        this.o = aVar;
        this.q = new b();
        this.r = com.facebook.common.time.c.a();
        this.p = z;
        this.f12042i = new HashSet();
        if (bVar != null) {
            bVar.a(this);
        }
        if (z) {
            this.f12039f = new CountDownLatch(1);
            executor.execute(new a());
            return;
        }
        this.f12039f = new CountDownLatch(0);
    }

    private e.f.a.a k(d.b bVar, e.f.b.a.d dVar, String str) throws IOException {
        e.f.a.a j2;
        synchronized (this.s) {
            j2 = bVar.j(dVar);
            this.f12042i.add(str);
            this.q.c(j2.size(), 1L);
        }
        return j2;
    }

    private void l(long j2, c.a aVar) throws IOException {
        try {
            Collection<d.a> m = m(this.m.f());
            long b2 = this.q.b();
            long j3 = b2 - j2;
            int i2 = 0;
            long j4 = 0;
            for (d.a aVar2 : m) {
                if (j4 > j3) {
                    break;
                }
                long h2 = this.m.h(aVar2);
                this.f12042i.remove(aVar2.getId());
                if (h2 > 0) {
                    i2++;
                    j4 += h2;
                    j e2 = j.a().j(aVar2.getId()).g(aVar).i(h2).f(b2 - j4).e(j2);
                    this.f12041h.b(e2);
                    e2.b();
                }
            }
            this.q.c(-j4, -i2);
            this.m.b();
        } catch (IOException e3) {
            e.f.b.a.a aVar3 = this.o;
            a.EnumC0260a enumC0260a = a.EnumC0260a.EVICTION;
            Class<?> cls = a;
            aVar3.a(enumC0260a, cls, "evictAboveSize: " + e3.getMessage(), e3);
            throw e3;
        }
    }

    private Collection<d.a> m(Collection<d.a> collection) {
        long now = this.r.now() + f12035b;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (d.a aVar : collection) {
            if (aVar.a() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.n.get());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private void n() throws IOException {
        synchronized (this.s) {
            boolean o = o();
            r();
            long b2 = this.q.b();
            if (b2 > this.f12040g && !o) {
                this.q.e();
                o();
            }
            long j2 = this.f12040g;
            if (b2 > j2) {
                l((j2 * 9) / 10, c.a.CACHE_FULL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        long now = this.r.now();
        if (this.q.d()) {
            long j2 = this.f12043j;
            if (j2 != -1 && now - j2 <= f12036c) {
                return false;
            }
        }
        return p();
    }

    private boolean p() {
        Set<String> hashSet;
        Set<String> set;
        long j2;
        long now = this.r.now();
        long j3 = f12035b + now;
        if (this.p && this.f12042i.isEmpty()) {
            hashSet = this.f12042i;
        } else {
            hashSet = this.p ? new HashSet<>() : null;
        }
        try {
            long j4 = 0;
            long j5 = -1;
            int i2 = 0;
            boolean z = false;
            int i3 = 0;
            int i4 = 0;
            for (d.a aVar : this.m.f()) {
                i3++;
                j4 += aVar.getSize();
                if (aVar.a() > j3) {
                    i4++;
                    i2 = (int) (i2 + aVar.getSize());
                    j2 = j3;
                    j5 = Math.max(aVar.a() - now, j5);
                    z = true;
                } else {
                    j2 = j3;
                    if (this.p) {
                        hashSet.add(aVar.getId());
                    }
                }
                j3 = j2;
            }
            if (z) {
                this.o.a(a.EnumC0260a.READ_INVALID_ENTRY, a, "Future timestamp found in " + i4 + " files , with a total size of " + i2 + " bytes, and a maximum time delta of " + j5 + "ms", null);
            }
            long j6 = i3;
            if (this.q.a() != j6 || this.q.b() != j4) {
                if (this.p && (set = this.f12042i) != hashSet) {
                    set.clear();
                    this.f12042i.addAll(hashSet);
                }
                this.q.f(j4, j6);
            }
            this.f12043j = now;
            return true;
        } catch (IOException e2) {
            this.o.a(a.EnumC0260a.GENERIC_IO, a, "calcFileCacheSize: " + e2.getMessage(), e2);
            return false;
        }
    }

    private d.b q(String str, e.f.b.a.d dVar) throws IOException {
        n();
        return this.m.c(str, dVar);
    }

    private void r() {
        if (this.f12045l.f(this.m.isExternal() ? a.EnumC0262a.EXTERNAL : a.EnumC0262a.INTERNAL, this.f12038e - this.q.b())) {
            this.f12040g = this.f12037d;
        } else {
            this.f12040g = this.f12038e;
        }
    }

    @Override // e.f.b.b.i
    public void a() {
        synchronized (this.s) {
            try {
                this.m.a();
                this.f12042i.clear();
                this.f12041h.c();
            } catch (IOException | NullPointerException e2) {
                e.f.b.a.a aVar = this.o;
                a.EnumC0260a enumC0260a = a.EnumC0260a.EVICTION;
                Class<?> cls = a;
                aVar.a(enumC0260a, cls, "clearAll: " + e2.getMessage(), e2);
            }
            this.q.e();
        }
    }

    @Override // e.f.b.b.i
    public e.f.a.a b(e.f.b.a.d dVar) {
        e.f.a.a aVar;
        j d2 = j.a().d(dVar);
        try {
            synchronized (this.s) {
                List<String> b2 = e.f.b.a.e.b(dVar);
                String str = null;
                aVar = null;
                for (int i2 = 0; i2 < b2.size(); i2++) {
                    str = b2.get(i2);
                    d2.j(str);
                    aVar = this.m.e(str, dVar);
                    if (aVar != null) {
                        break;
                    }
                }
                if (aVar == null) {
                    this.f12041h.a(d2);
                    this.f12042i.remove(str);
                } else {
                    this.f12041h.e(d2);
                    this.f12042i.add(str);
                }
            }
            return aVar;
        } catch (IOException e2) {
            this.o.a(a.EnumC0260a.GENERIC_IO, a, "getResource", e2);
            d2.h(e2);
            this.f12041h.g(d2);
            return null;
        } finally {
            d2.b();
        }
    }

    @Override // e.f.b.b.i
    public boolean c(e.f.b.a.d dVar) {
        synchronized (this.s) {
            List<String> b2 = e.f.b.a.e.b(dVar);
            for (int i2 = 0; i2 < b2.size(); i2++) {
                if (this.f12042i.contains(b2.get(i2))) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // e.f.b.b.i
    public void d(e.f.b.a.d dVar) {
        synchronized (this.s) {
            try {
                List<String> b2 = e.f.b.a.e.b(dVar);
                for (int i2 = 0; i2 < b2.size(); i2++) {
                    String str = b2.get(i2);
                    this.m.g(str);
                    this.f12042i.remove(str);
                }
            } catch (IOException e2) {
                e.f.b.a.a aVar = this.o;
                a.EnumC0260a enumC0260a = a.EnumC0260a.DELETE_FILE;
                Class<?> cls = a;
                aVar.a(enumC0260a, cls, "delete: " + e2.getMessage(), e2);
            }
        }
    }

    @Override // e.f.b.b.i
    public boolean e(e.f.b.a.d dVar) {
        synchronized (this.s) {
            if (c(dVar)) {
                return true;
            }
            try {
                List<String> b2 = e.f.b.a.e.b(dVar);
                for (int i2 = 0; i2 < b2.size(); i2++) {
                    String str = b2.get(i2);
                    if (this.m.d(str, dVar)) {
                        this.f12042i.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // e.f.b.b.i
    public e.f.a.a f(e.f.b.a.d dVar, e.f.b.a.j jVar) throws IOException {
        String a2;
        j d2 = j.a().d(dVar);
        this.f12041h.h(d2);
        synchronized (this.s) {
            a2 = e.f.b.a.e.a(dVar);
        }
        d2.j(a2);
        try {
            try {
                d.b q = q(a2, dVar);
                try {
                    q.i(jVar, dVar);
                    e.f.a.a k2 = k(q, dVar, a2);
                    d2.i(k2.size()).f(this.q.b());
                    this.f12041h.f(d2);
                    return k2;
                } finally {
                    if (!q.h()) {
                        e.f.d.d.a.e(a, "Failed to delete temp file");
                    }
                }
            } catch (IOException e2) {
                d2.h(e2);
                this.f12041h.d(d2);
                e.f.d.d.a.f(a, "Failed inserting a file into the cache", e2);
                throw e2;
            }
        } finally {
            d2.b();
        }
    }
}