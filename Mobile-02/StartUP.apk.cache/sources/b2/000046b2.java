package e.f.j.l;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* compiled from: ThrottlingProducer.java */
/* loaded from: classes2.dex */
public class u0<T> implements j0<T> {
    private final j0<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12766b;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f12769e;

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentLinkedQueue<Pair<k<T>, k0>> f12768d = new ConcurrentLinkedQueue<>();

    /* renamed from: c  reason: collision with root package name */
    private int f12767c = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ThrottlingProducer.java */
    /* loaded from: classes2.dex */
    public class b extends n<T, T> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ThrottlingProducer.java */
        /* loaded from: classes2.dex */
        public class a implements Runnable {
            final /* synthetic */ Pair a;

            a(Pair pair) {
                this.a = pair;
            }

            @Override // java.lang.Runnable
            public void run() {
                u0 u0Var = u0.this;
                Pair pair = this.a;
                u0Var.f((k) pair.first, (k0) pair.second);
            }
        }

        private void p() {
            Pair pair;
            synchronized (u0.this) {
                pair = (Pair) u0.this.f12768d.poll();
                if (pair == null) {
                    u0.d(u0.this);
                }
            }
            if (pair != null) {
                u0.this.f12769e.execute(new a(pair));
            }
        }

        @Override // e.f.j.l.n, e.f.j.l.b
        protected void f() {
            o().a();
            p();
        }

        @Override // e.f.j.l.n, e.f.j.l.b
        protected void g(Throwable th) {
            o().onFailure(th);
            p();
        }

        @Override // e.f.j.l.b
        protected void h(T t, int i2) {
            o().c(t, i2);
            if (e.f.j.l.b.d(i2)) {
                p();
            }
        }

        private b(k<T> kVar) {
            super(kVar);
        }
    }

    public u0(int i2, Executor executor, j0<T> j0Var) {
        this.f12766b = i2;
        this.f12769e = (Executor) e.f.d.c.i.g(executor);
        this.a = (j0) e.f.d.c.i.g(j0Var);
    }

    static /* synthetic */ int d(u0 u0Var) {
        int i2 = u0Var.f12767c;
        u0Var.f12767c = i2 - 1;
        return i2;
    }

    @Override // e.f.j.l.j0
    public void b(k<T> kVar, k0 k0Var) {
        boolean z;
        k0Var.f().b(k0Var.getId(), "ThrottlingProducer");
        synchronized (this) {
            int i2 = this.f12767c;
            z = true;
            if (i2 >= this.f12766b) {
                this.f12768d.add(Pair.create(kVar, k0Var));
            } else {
                this.f12767c = i2 + 1;
                z = false;
            }
        }
        if (z) {
            return;
        }
        f(kVar, k0Var);
    }

    void f(k<T> kVar, k0 k0Var) {
        k0Var.f().i(k0Var.getId(), "ThrottlingProducer", null);
        this.a.b(new b(kVar), k0Var);
    }
}