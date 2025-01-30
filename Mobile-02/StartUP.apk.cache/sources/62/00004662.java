package e.f.j.l;

import android.util.Pair;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: MultiplexProducer.java */
/* loaded from: classes2.dex */
public abstract class d0<K, T extends Closeable> implements j0<T> {
    final Map<K, d0<K, T>.b> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final j0<T> f12600b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiplexProducer.java */
    /* loaded from: classes2.dex */
    public class b {
        private final K a;

        /* renamed from: b  reason: collision with root package name */
        private final CopyOnWriteArraySet<Pair<k<T>, k0>> f12601b = e.f.d.c.k.a();

        /* renamed from: c  reason: collision with root package name */
        private T f12602c;

        /* renamed from: d  reason: collision with root package name */
        private float f12603d;

        /* renamed from: e  reason: collision with root package name */
        private int f12604e;

        /* renamed from: f  reason: collision with root package name */
        private d f12605f;

        /* renamed from: g  reason: collision with root package name */
        private d0<K, T>.b.C0278b f12606g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MultiplexProducer.java */
        /* loaded from: classes2.dex */
        public class a extends e {
            final /* synthetic */ Pair a;

            a(Pair pair) {
                this.a = pair;
            }

            @Override // e.f.j.l.l0
            public void a() {
                boolean remove;
                List list;
                d dVar;
                List list2;
                List list3;
                synchronized (b.this) {
                    remove = b.this.f12601b.remove(this.a);
                    list = null;
                    if (!remove) {
                        dVar = null;
                        list2 = null;
                    } else if (b.this.f12601b.isEmpty()) {
                        dVar = b.this.f12605f;
                        list2 = null;
                    } else {
                        List s = b.this.s();
                        list2 = b.this.t();
                        list3 = b.this.r();
                        dVar = null;
                        list = s;
                    }
                    list3 = list2;
                }
                d.k(list);
                d.l(list2);
                d.j(list3);
                if (dVar != null) {
                    dVar.m();
                }
                if (remove) {
                    ((k) this.a.first).a();
                }
            }

            @Override // e.f.j.l.e, e.f.j.l.l0
            public void b() {
                d.j(b.this.r());
            }

            @Override // e.f.j.l.e, e.f.j.l.l0
            public void c() {
                d.l(b.this.t());
            }

            @Override // e.f.j.l.e, e.f.j.l.l0
            public void d() {
                d.k(b.this.s());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: MultiplexProducer.java */
        /* renamed from: e.f.j.l.d0$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0278b extends e.f.j.l.b<T> {
            private C0278b() {
            }

            @Override // e.f.j.l.b
            protected void f() {
                try {
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.a("MultiplexProducer#onCancellation");
                    }
                    b.this.m(this);
                } finally {
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.b();
                    }
                }
            }

            @Override // e.f.j.l.b
            protected void g(Throwable th) {
                try {
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.a("MultiplexProducer#onFailure");
                    }
                    b.this.n(this, th);
                } finally {
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.b();
                    }
                }
            }

            @Override // e.f.j.l.b
            protected void i(float f2) {
                try {
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.a("MultiplexProducer#onProgressUpdate");
                    }
                    b.this.p(this, f2);
                } finally {
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.b();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // e.f.j.l.b
            /* renamed from: o */
            public void h(T t, int i2) {
                try {
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.a("MultiplexProducer#onNewResult");
                    }
                    b.this.o(this, t, i2);
                } finally {
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.b();
                    }
                }
            }
        }

        public b(K k2) {
            this.a = k2;
        }

        private void g(Pair<k<T>, k0> pair, k0 k0Var) {
            k0Var.d(new a(pair));
        }

        private void i(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }

        private synchronized boolean j() {
            Iterator<Pair<k<T>, k0>> it = this.f12601b.iterator();
            while (it.hasNext()) {
                if (((k0) it.next().second).g()) {
                    return true;
                }
            }
            return false;
        }

        private synchronized boolean k() {
            Iterator<Pair<k<T>, k0>> it = this.f12601b.iterator();
            while (it.hasNext()) {
                if (!((k0) it.next().second).e()) {
                    return false;
                }
            }
            return true;
        }

        private synchronized com.facebook.imagepipeline.common.d l() {
            com.facebook.imagepipeline.common.d dVar;
            dVar = com.facebook.imagepipeline.common.d.LOW;
            Iterator<Pair<k<T>, k0>> it = this.f12601b.iterator();
            while (it.hasNext()) {
                dVar = com.facebook.imagepipeline.common.d.h(dVar, ((k0) it.next().second).b());
            }
            return dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q() {
            synchronized (this) {
                boolean z = true;
                e.f.d.c.i.b(this.f12605f == null);
                if (this.f12606g != null) {
                    z = false;
                }
                e.f.d.c.i.b(z);
                if (this.f12601b.isEmpty()) {
                    d0.this.j(this.a, this);
                    return;
                }
                k0 k0Var = (k0) this.f12601b.iterator().next().second;
                this.f12605f = new d(k0Var.c(), k0Var.getId(), k0Var.f(), k0Var.a(), k0Var.h(), k(), j(), l());
                d0<K, T>.b.C0278b c0278b = new C0278b();
                this.f12606g = c0278b;
                d0.this.f12600b.b(c0278b, this.f12605f);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized List<l0> r() {
            d dVar = this.f12605f;
            if (dVar == null) {
                return null;
            }
            return dVar.o(j());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized List<l0> s() {
            d dVar = this.f12605f;
            if (dVar == null) {
                return null;
            }
            return dVar.p(k());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized List<l0> t() {
            d dVar = this.f12605f;
            if (dVar == null) {
                return null;
            }
            return dVar.q(l());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean h(k<T> kVar, k0 k0Var) {
            Pair<k<T>, k0> create = Pair.create(kVar, k0Var);
            synchronized (this) {
                if (d0.this.h(this.a) != this) {
                    return false;
                }
                this.f12601b.add(create);
                List<l0> s = s();
                List<l0> t = t();
                List<l0> r = r();
                Closeable closeable = this.f12602c;
                float f2 = this.f12603d;
                int i2 = this.f12604e;
                d.k(s);
                d.l(t);
                d.j(r);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.f12602c) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = d0.this.f(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f2 > 0.0f) {
                            kVar.b(f2);
                        }
                        kVar.c(closeable, i2);
                        i(closeable);
                    }
                }
                g(create, k0Var);
                return true;
            }
        }

        public void m(d0<K, T>.b.C0278b c0278b) {
            synchronized (this) {
                if (this.f12606g != c0278b) {
                    return;
                }
                this.f12606g = null;
                this.f12605f = null;
                i(this.f12602c);
                this.f12602c = null;
                q();
            }
        }

        public void n(d0<K, T>.b.C0278b c0278b, Throwable th) {
            synchronized (this) {
                if (this.f12606g != c0278b) {
                    return;
                }
                Iterator<Pair<k<T>, k0>> it = this.f12601b.iterator();
                this.f12601b.clear();
                d0.this.j(this.a, this);
                i(this.f12602c);
                this.f12602c = null;
                while (it.hasNext()) {
                    Pair<k<T>, k0> next = it.next();
                    synchronized (next) {
                        ((k) next.first).onFailure(th);
                    }
                }
            }
        }

        public void o(d0<K, T>.b.C0278b c0278b, T t, int i2) {
            synchronized (this) {
                if (this.f12606g != c0278b) {
                    return;
                }
                i(this.f12602c);
                this.f12602c = null;
                Iterator<Pair<k<T>, k0>> it = this.f12601b.iterator();
                if (e.f.j.l.b.e(i2)) {
                    this.f12602c = (T) d0.this.f(t);
                    this.f12604e = i2;
                } else {
                    this.f12601b.clear();
                    d0.this.j(this.a, this);
                }
                while (it.hasNext()) {
                    Pair<k<T>, k0> next = it.next();
                    synchronized (next) {
                        ((k) next.first).c(t, i2);
                    }
                }
            }
        }

        public void p(d0<K, T>.b.C0278b c0278b, float f2) {
            synchronized (this) {
                if (this.f12606g != c0278b) {
                    return;
                }
                this.f12603d = f2;
                Iterator<Pair<k<T>, k0>> it = this.f12601b.iterator();
                while (it.hasNext()) {
                    Pair<k<T>, k0> next = it.next();
                    synchronized (next) {
                        ((k) next.first).b(f2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d0(j0<T> j0Var) {
        this.f12600b = j0Var;
    }

    private synchronized d0<K, T>.b g(K k2) {
        d0<K, T>.b bVar;
        bVar = new b(k2);
        this.a.put(k2, bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized d0<K, T>.b h(K k2) {
        return this.a.get(k2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(K k2, d0<K, T>.b bVar) {
        if (this.a.get(k2) == bVar) {
            this.a.remove(k2);
        }
    }

    @Override // e.f.j.l.j0
    public void b(k<T> kVar, k0 k0Var) {
        boolean z;
        d0<K, T>.b h2;
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("MultiplexProducer#produceResults");
            }
            K i2 = i(k0Var);
            do {
                z = false;
                synchronized (this) {
                    h2 = h(i2);
                    if (h2 == null) {
                        h2 = g(i2);
                        z = true;
                    }
                }
            } while (!h2.h(kVar, k0Var));
            if (z) {
                h2.q();
            }
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }

    protected abstract T f(T t);

    protected abstract K i(k0 k0Var);
}