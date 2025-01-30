package e.f.j.d;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: BufferedDiskCache.java */
/* loaded from: classes2.dex */
public class e {
    private static final Class<?> a = e.class;

    /* renamed from: b  reason: collision with root package name */
    private final e.f.b.b.i f12428b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.common.memory.g f12429c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.common.memory.j f12430d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f12431e;

    /* renamed from: f  reason: collision with root package name */
    private final Executor f12432f;

    /* renamed from: g  reason: collision with root package name */
    private final u f12433g = u.d();

    /* renamed from: h  reason: collision with root package name */
    private final n f12434h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BufferedDiskCache.java */
    /* loaded from: classes2.dex */
    public class a implements Callable<e.f.j.i.d> {
        final /* synthetic */ AtomicBoolean a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e.f.b.a.d f12435b;

        a(AtomicBoolean atomicBoolean, e.f.b.a.d dVar) {
            this.a = atomicBoolean;
            this.f12435b = dVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public e.f.j.i.d call() throws Exception {
            try {
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.a("BufferedDiskCache#getAsync");
                }
                if (!this.a.get()) {
                    e.f.j.i.d c2 = e.this.f12433g.c(this.f12435b);
                    if (c2 != null) {
                        e.f.d.d.a.q(e.a, "Found image for %s in staging area", this.f12435b.b());
                        e.this.f12434h.m(this.f12435b);
                    } else {
                        e.f.d.d.a.q(e.a, "Did not find image for %s in staging area", this.f12435b.b());
                        e.this.f12434h.j();
                        try {
                            PooledByteBuffer p = e.this.p(this.f12435b);
                            if (p == null) {
                                return null;
                            }
                            com.facebook.common.references.a K = com.facebook.common.references.a.K(p);
                            try {
                                c2 = new e.f.j.i.d(K);
                            } finally {
                                com.facebook.common.references.a.f(K);
                            }
                        } catch (Exception unused) {
                            if (e.f.j.m.b.d()) {
                                e.f.j.m.b.b();
                            }
                            return null;
                        }
                    }
                    if (Thread.interrupted()) {
                        e.f.d.d.a.p(e.a, "Host thread was interrupted, decreasing reference count");
                        c2.close();
                        throw new InterruptedException();
                    }
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.b();
                    }
                    return c2;
                }
                throw new CancellationException();
            } finally {
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
            }
        }
    }

    /* compiled from: BufferedDiskCache.java */
    /* loaded from: classes2.dex */
    class b implements Runnable {
        final /* synthetic */ e.f.b.a.d a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e.f.j.i.d f12437b;

        b(e.f.b.a.d dVar, e.f.j.i.d dVar2) {
            this.a = dVar;
            this.f12437b = dVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.a("BufferedDiskCache#putAsync");
                }
                e.this.r(this.a, this.f12437b);
            } finally {
                e.this.f12433g.h(this.a, this.f12437b);
                e.f.j.i.d.c(this.f12437b);
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
            }
        }
    }

    /* compiled from: BufferedDiskCache.java */
    /* loaded from: classes2.dex */
    class c implements Callable<Void> {
        final /* synthetic */ e.f.b.a.d a;

        c(e.f.b.a.d dVar) {
            this.a = dVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            try {
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.a("BufferedDiskCache#remove");
                }
                e.this.f12433g.g(this.a);
                e.this.f12428b.d(this.a);
            } finally {
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
            }
        }
    }

    /* compiled from: BufferedDiskCache.java */
    /* loaded from: classes2.dex */
    class d implements Callable<Void> {
        d() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            e.this.f12433g.a();
            e.this.f12428b.a();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BufferedDiskCache.java */
    /* renamed from: e.f.j.d.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0274e implements e.f.b.a.j {
        final /* synthetic */ e.f.j.i.d a;

        C0274e(e.f.j.i.d dVar) {
            this.a = dVar;
        }

        @Override // e.f.b.a.j
        public void a(OutputStream outputStream) throws IOException {
            e.this.f12430d.a(this.a.z(), outputStream);
        }
    }

    public e(e.f.b.b.i iVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.f12428b = iVar;
        this.f12429c = gVar;
        this.f12430d = jVar;
        this.f12431e = executor;
        this.f12432f = executor2;
        this.f12434h = nVar;
    }

    private boolean h(e.f.b.a.d dVar) {
        e.f.j.i.d c2 = this.f12433g.c(dVar);
        if (c2 != null) {
            c2.close();
            e.f.d.d.a.q(a, "Found image for %s in staging area", dVar.b());
            this.f12434h.m(dVar);
            return true;
        }
        e.f.d.d.a.q(a, "Did not find image for %s in staging area", dVar.b());
        this.f12434h.j();
        try {
            return this.f12428b.e(dVar);
        } catch (Exception unused) {
            return false;
        }
    }

    private bolts.e<e.f.j.i.d> l(e.f.b.a.d dVar, e.f.j.i.d dVar2) {
        e.f.d.d.a.q(a, "Found image for %s in staging area", dVar.b());
        this.f12434h.m(dVar);
        return bolts.e.h(dVar2);
    }

    private bolts.e<e.f.j.i.d> n(e.f.b.a.d dVar, AtomicBoolean atomicBoolean) {
        try {
            return bolts.e.b(new a(atomicBoolean, dVar), this.f12431e);
        } catch (Exception e2) {
            e.f.d.d.a.z(a, e2, "Failed to schedule disk-cache read for %s", dVar.b());
            return bolts.e.g(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer p(e.f.b.a.d dVar) throws IOException {
        try {
            Class<?> cls = a;
            e.f.d.d.a.q(cls, "Disk cache read for %s", dVar.b());
            e.f.a.a b2 = this.f12428b.b(dVar);
            if (b2 == null) {
                e.f.d.d.a.q(cls, "Disk cache miss for %s", dVar.b());
                this.f12434h.h();
                return null;
            }
            e.f.d.d.a.q(cls, "Found entry in disk cache for %s", dVar.b());
            this.f12434h.d(dVar);
            InputStream a2 = b2.a();
            PooledByteBuffer d2 = this.f12429c.d(a2, (int) b2.size());
            a2.close();
            e.f.d.d.a.q(cls, "Successful read from disk cache for %s", dVar.b());
            return d2;
        } catch (IOException e2) {
            e.f.d.d.a.z(a, e2, "Exception reading from cache for %s", dVar.b());
            this.f12434h.f();
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(e.f.b.a.d dVar, e.f.j.i.d dVar2) {
        Class<?> cls = a;
        e.f.d.d.a.q(cls, "About to write to disk-cache for key %s", dVar.b());
        try {
            this.f12428b.f(dVar, new C0274e(dVar2));
            e.f.d.d.a.q(cls, "Successful disk-cache write for key %s", dVar.b());
        } catch (IOException e2) {
            e.f.d.d.a.z(a, e2, "Failed to write to disk-cache for key %s", dVar.b());
        }
    }

    public bolts.e<Void> i() {
        this.f12433g.a();
        try {
            return bolts.e.b(new d(), this.f12432f);
        } catch (Exception e2) {
            e.f.d.d.a.z(a, e2, "Failed to schedule disk-cache clear", new Object[0]);
            return bolts.e.g(e2);
        }
    }

    public boolean j(e.f.b.a.d dVar) {
        return this.f12433g.b(dVar) || this.f12428b.c(dVar);
    }

    public boolean k(e.f.b.a.d dVar) {
        if (j(dVar)) {
            return true;
        }
        return h(dVar);
    }

    public bolts.e<e.f.j.i.d> m(e.f.b.a.d dVar, AtomicBoolean atomicBoolean) {
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("BufferedDiskCache#get");
            }
            e.f.j.i.d c2 = this.f12433g.c(dVar);
            if (c2 != null) {
                return l(dVar, c2);
            }
            bolts.e<e.f.j.i.d> n = n(dVar, atomicBoolean);
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
            return n;
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }

    public void o(e.f.b.a.d dVar, e.f.j.i.d dVar2) {
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("BufferedDiskCache#put");
            }
            e.f.d.c.i.g(dVar);
            e.f.d.c.i.b(e.f.j.i.d.d0(dVar2));
            this.f12433g.f(dVar, dVar2);
            e.f.j.i.d b2 = e.f.j.i.d.b(dVar2);
            try {
                this.f12432f.execute(new b(dVar, b2));
            } catch (Exception e2) {
                e.f.d.d.a.z(a, e2, "Failed to schedule disk-cache write for %s", dVar.b());
                this.f12433g.h(dVar, dVar2);
                e.f.j.i.d.c(b2);
            }
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }

    public bolts.e<Void> q(e.f.b.a.d dVar) {
        e.f.d.c.i.g(dVar);
        this.f12433g.g(dVar);
        try {
            return bolts.e.b(new c(dVar), this.f12432f);
        } catch (Exception e2) {
            e.f.d.d.a.z(a, e2, "Failed to schedule disk-cache remove for %s", dVar.b());
            return bolts.e.g(e2);
        }
    }
}