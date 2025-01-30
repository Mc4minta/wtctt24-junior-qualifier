package e.f.e;

import e.f.d.c.i;
import e.f.d.c.l;
import java.util.List;

/* compiled from: FirstAvailableDataSourceSupplier.java */
/* loaded from: classes2.dex */
public class f<T> implements l<c<T>> {
    private final List<l<c<T>>> a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FirstAvailableDataSourceSupplier.java */
    /* loaded from: classes2.dex */
    public class b extends e.f.e.a<T> {

        /* renamed from: g  reason: collision with root package name */
        private int f12112g = 0;

        /* renamed from: h  reason: collision with root package name */
        private c<T> f12113h = null;

        /* renamed from: i  reason: collision with root package name */
        private c<T> f12114i = null;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: FirstAvailableDataSourceSupplier.java */
        /* loaded from: classes2.dex */
        public class a implements e<T> {
            private a() {
            }

            @Override // e.f.e.e
            public void a(c<T> cVar) {
            }

            @Override // e.f.e.e
            public void b(c<T> cVar) {
                b.this.B(cVar);
            }

            @Override // e.f.e.e
            public void c(c<T> cVar) {
                if (cVar.a()) {
                    b.this.C(cVar);
                } else if (cVar.b()) {
                    b.this.B(cVar);
                }
            }

            @Override // e.f.e.e
            public void d(c<T> cVar) {
                b.this.p(Math.max(b.this.d(), cVar.d()));
            }
        }

        public b() {
            if (E()) {
                return;
            }
            n(new RuntimeException("No data source supplier or supplier returned null."));
        }

        private void A(c<T> cVar, boolean z) {
            c<T> cVar2;
            synchronized (this) {
                if (cVar == this.f12113h && cVar != (cVar2 = this.f12114i)) {
                    if (cVar2 != null && !z) {
                        cVar2 = null;
                        x(cVar2);
                    }
                    this.f12114i = cVar;
                    x(cVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B(c<T> cVar) {
            if (w(cVar)) {
                if (cVar != y()) {
                    x(cVar);
                }
                if (E()) {
                    return;
                }
                n(cVar.c());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(c<T> cVar) {
            A(cVar, cVar.b());
            if (cVar == y()) {
                r(null, cVar.b());
            }
        }

        private synchronized boolean D(c<T> cVar) {
            if (j()) {
                return false;
            }
            this.f12113h = cVar;
            return true;
        }

        private boolean E() {
            l<c<T>> z = z();
            c<T> cVar = z != null ? z.get() : null;
            if (D(cVar) && cVar != null) {
                cVar.g(new a(), e.f.d.b.a.a());
                return true;
            }
            x(cVar);
            return false;
        }

        private synchronized boolean w(c<T> cVar) {
            if (!j() && cVar == this.f12113h) {
                this.f12113h = null;
                return true;
            }
            return false;
        }

        private void x(c<T> cVar) {
            if (cVar != null) {
                cVar.close();
            }
        }

        private synchronized c<T> y() {
            return this.f12114i;
        }

        private synchronized l<c<T>> z() {
            if (j() || this.f12112g >= f.this.a.size()) {
                return null;
            }
            List list = f.this.a;
            int i2 = this.f12112g;
            this.f12112g = i2 + 1;
            return (l) list.get(i2);
        }

        @Override // e.f.e.a, e.f.e.c
        public synchronized boolean a() {
            boolean z;
            c<T> y = y();
            if (y != null) {
                z = y.a();
            }
            return z;
        }

        @Override // e.f.e.a, e.f.e.c
        public boolean close() {
            synchronized (this) {
                if (super.close()) {
                    c<T> cVar = this.f12113h;
                    this.f12113h = null;
                    c<T> cVar2 = this.f12114i;
                    this.f12114i = null;
                    x(cVar2);
                    x(cVar);
                    return true;
                }
                return false;
            }
        }

        @Override // e.f.e.a, e.f.e.c
        public synchronized T f() {
            c<T> y;
            y = y();
            return y != null ? y.f() : null;
        }
    }

    private f(List<l<c<T>>> list) {
        i.c(!list.isEmpty(), "List of suppliers is empty!");
        this.a = list;
    }

    public static <T> f<T> b(List<l<c<T>>> list) {
        return new f<>(list);
    }

    @Override // e.f.d.c.l
    /* renamed from: c */
    public c<T> get() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return e.f.d.c.h.a(this.a, ((f) obj).a);
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