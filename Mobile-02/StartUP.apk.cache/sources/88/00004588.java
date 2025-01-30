package e.f.e;

import e.f.d.c.i;
import e.f.d.c.l;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IncreasingQualityDataSourceSupplier.java */
/* loaded from: classes2.dex */
public class g<T> implements l<c<T>> {
    private final List<l<c<T>>> a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f12116b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IncreasingQualityDataSourceSupplier.java */
    /* loaded from: classes2.dex */
    public class a extends e.f.e.a<T> {

        /* renamed from: g  reason: collision with root package name */
        private ArrayList<c<T>> f12117g;

        /* renamed from: h  reason: collision with root package name */
        private int f12118h;

        /* renamed from: i  reason: collision with root package name */
        private int f12119i;

        /* renamed from: j  reason: collision with root package name */
        private AtomicInteger f12120j;

        /* renamed from: k  reason: collision with root package name */
        private Throwable f12121k;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IncreasingQualityDataSourceSupplier.java */
        /* renamed from: e.f.e.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0264a implements e<T> {
            private int a;

            public C0264a(int i2) {
                this.a = i2;
            }

            @Override // e.f.e.e
            public void a(c<T> cVar) {
            }

            @Override // e.f.e.e
            public void b(c<T> cVar) {
                a.this.D(this.a, cVar);
            }

            @Override // e.f.e.e
            public void c(c<T> cVar) {
                if (cVar.a()) {
                    a.this.E(this.a, cVar);
                } else if (cVar.b()) {
                    a.this.D(this.a, cVar);
                }
            }

            @Override // e.f.e.e
            public void d(c<T> cVar) {
                if (this.a == 0) {
                    a.this.p(cVar.d());
                }
            }
        }

        public a() {
            if (g.this.f12116b) {
                return;
            }
            x();
        }

        private synchronized c<T> A() {
            return z(this.f12118h);
        }

        private void B() {
            Throwable th;
            if (this.f12120j.incrementAndGet() != this.f12119i || (th = this.f12121k) == null) {
                return;
            }
            n(th);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0022 A[LOOP:0: B:17:0x0020->B:18:0x0022, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void C(int r3, e.f.e.c<T> r4, boolean r5) {
            /*
                r2 = this;
                monitor-enter(r2)
                int r0 = r2.f12118h     // Catch: java.lang.Throwable -> L2f
                e.f.e.c r1 = r2.z(r3)     // Catch: java.lang.Throwable -> L2f
                if (r4 != r1) goto L2d
                int r4 = r2.f12118h     // Catch: java.lang.Throwable -> L2f
                if (r3 != r4) goto Le
                goto L2d
            Le:
                e.f.e.c r4 = r2.A()     // Catch: java.lang.Throwable -> L2f
                if (r4 == 0) goto L1d
                if (r5 == 0) goto L1b
                int r4 = r2.f12118h     // Catch: java.lang.Throwable -> L2f
                if (r3 >= r4) goto L1b
                goto L1d
            L1b:
                r3 = r0
                goto L1f
            L1d:
                r2.f12118h = r3     // Catch: java.lang.Throwable -> L2f
            L1f:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
            L20:
                if (r0 <= r3) goto L2c
                e.f.e.c r4 = r2.y(r0)
                r2.w(r4)
                int r0 = r0 + (-1)
                goto L20
            L2c:
                return
            L2d:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
                return
            L2f:
                r3 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: e.f.e.g.a.C(int, e.f.e.c, boolean):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D(int i2, c<T> cVar) {
            w(F(i2, cVar));
            if (i2 == 0) {
                this.f12121k = cVar.c();
            }
            B();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E(int i2, c<T> cVar) {
            C(i2, cVar, cVar.b());
            if (cVar == A()) {
                r(null, i2 == 0 && cVar.b());
            }
            B();
        }

        private synchronized c<T> F(int i2, c<T> cVar) {
            if (cVar == A()) {
                return null;
            }
            if (cVar == z(i2)) {
                return y(i2);
            }
            return cVar;
        }

        private void w(c<T> cVar) {
            if (cVar != null) {
                cVar.close();
            }
        }

        private void x() {
            if (this.f12120j != null) {
                return;
            }
            synchronized (this) {
                if (this.f12120j == null) {
                    this.f12120j = new AtomicInteger(0);
                    int size = g.this.a.size();
                    this.f12119i = size;
                    this.f12118h = size;
                    this.f12117g = new ArrayList<>(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        c<T> cVar = (c) ((l) g.this.a.get(i2)).get();
                        this.f12117g.add(cVar);
                        cVar.g(new C0264a(i2), e.f.d.b.a.a());
                        if (cVar.a()) {
                            break;
                        }
                    }
                }
            }
        }

        private synchronized c<T> y(int i2) {
            c<T> cVar;
            ArrayList<c<T>> arrayList = this.f12117g;
            cVar = null;
            if (arrayList != null && i2 < arrayList.size()) {
                cVar = this.f12117g.set(i2, null);
            }
            return cVar;
        }

        private synchronized c<T> z(int i2) {
            ArrayList<c<T>> arrayList;
            arrayList = this.f12117g;
            return (arrayList == null || i2 >= arrayList.size()) ? null : this.f12117g.get(i2);
        }

        @Override // e.f.e.a, e.f.e.c
        public synchronized boolean a() {
            boolean z;
            if (g.this.f12116b) {
                x();
            }
            c<T> A = A();
            if (A != null) {
                z = A.a();
            }
            return z;
        }

        @Override // e.f.e.a, e.f.e.c
        public boolean close() {
            if (g.this.f12116b) {
                x();
            }
            synchronized (this) {
                if (super.close()) {
                    ArrayList<c<T>> arrayList = this.f12117g;
                    this.f12117g = null;
                    if (arrayList != null) {
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            w(arrayList.get(i2));
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            }
        }

        @Override // e.f.e.a, e.f.e.c
        public synchronized T f() {
            c<T> A;
            if (g.this.f12116b) {
                x();
            }
            A = A();
            return A != null ? A.f() : null;
        }
    }

    private g(List<l<c<T>>> list, boolean z) {
        i.c(!list.isEmpty(), "List of suppliers is empty!");
        this.a = list;
        this.f12116b = z;
    }

    public static <T> g<T> c(List<l<c<T>>> list, boolean z) {
        return new g<>(list, z);
    }

    @Override // e.f.d.c.l
    /* renamed from: d */
    public c<T> get() {
        return new a();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            return e.f.d.c.h.a(this.a, ((g) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return e.f.d.c.h.d(this).b("list", this.a).toString();
    }
}