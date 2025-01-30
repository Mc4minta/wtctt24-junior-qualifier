package androidx.lifecycle;

import androidx.lifecycle.i;

/* loaded from: classes.dex */
public abstract class LiveData<T> {
    static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    final Object f1752b;

    /* renamed from: c  reason: collision with root package name */
    private c.b.a.b.b<v<? super T>, LiveData<T>.b> f1753c;

    /* renamed from: d  reason: collision with root package name */
    int f1754d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f1755e;

    /* renamed from: f  reason: collision with root package name */
    volatile Object f1756f;

    /* renamed from: g  reason: collision with root package name */
    private int f1757g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1758h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1759i;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f1760j;

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.b implements m {

        /* renamed from: e  reason: collision with root package name */
        final o f1761e;

        LifecycleBoundObserver(o oVar, v<? super T> vVar) {
            super(vVar);
            this.f1761e = oVar;
        }

        @Override // androidx.lifecycle.m
        public void c(o oVar, i.a aVar) {
            if (this.f1761e.getLifecycle().b() == i.b.DESTROYED) {
                LiveData.this.k(this.a);
            } else {
                h(k());
            }
        }

        @Override // androidx.lifecycle.LiveData.b
        void i() {
            this.f1761e.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean j(o oVar) {
            return this.f1761e == oVar;
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean k() {
            return this.f1761e.getLifecycle().b().h(i.b.STARTED);
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f1752b) {
                obj = LiveData.this.f1756f;
                LiveData.this.f1756f = LiveData.a;
            }
            LiveData.this.l(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class b {
        final v<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1763b;

        /* renamed from: c  reason: collision with root package name */
        int f1764c = -1;

        b(v<? super T> vVar) {
            this.a = vVar;
        }

        void h(boolean z) {
            if (z == this.f1763b) {
                return;
            }
            this.f1763b = z;
            LiveData liveData = LiveData.this;
            int i2 = liveData.f1754d;
            boolean z2 = i2 == 0;
            liveData.f1754d = i2 + (z ? 1 : -1);
            if (z2 && z) {
                liveData.h();
            }
            LiveData liveData2 = LiveData.this;
            if (liveData2.f1754d == 0 && !this.f1763b) {
                liveData2.i();
            }
            if (this.f1763b) {
                LiveData.this.d(this);
            }
        }

        void i() {
        }

        boolean j(o oVar) {
            return false;
        }

        abstract boolean k();
    }

    public LiveData(T t) {
        this.f1752b = new Object();
        this.f1753c = new c.b.a.b.b<>();
        this.f1754d = 0;
        this.f1756f = a;
        this.f1760j = new a();
        this.f1755e = t;
        this.f1757g = 0;
    }

    static void b(String str) {
        if (c.b.a.a.a.f().c()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void c(LiveData<T>.b bVar) {
        if (bVar.f1763b) {
            if (!bVar.k()) {
                bVar.h(false);
                return;
            }
            int i2 = bVar.f1764c;
            int i3 = this.f1757g;
            if (i2 >= i3) {
                return;
            }
            bVar.f1764c = i3;
            bVar.a.a((Object) this.f1755e);
        }
    }

    void d(LiveData<T>.b bVar) {
        if (this.f1758h) {
            this.f1759i = true;
            return;
        }
        this.f1758h = true;
        do {
            this.f1759i = false;
            if (bVar != null) {
                c(bVar);
                bVar = null;
            } else {
                c.b.a.b.b<v<? super T>, LiveData<T>.b>.d k2 = this.f1753c.k();
                while (k2.hasNext()) {
                    c((b) k2.next().getValue());
                    if (this.f1759i) {
                        break;
                    }
                }
            }
        } while (this.f1759i);
        this.f1758h = false;
    }

    public T e() {
        T t = (T) this.f1755e;
        if (t != a) {
            return t;
        }
        return null;
    }

    public boolean f() {
        return this.f1754d > 0;
    }

    public void g(o oVar, v<? super T> vVar) {
        b("observe");
        if (oVar.getLifecycle().b() == i.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(oVar, vVar);
        LiveData<T>.b o = this.f1753c.o(vVar, lifecycleBoundObserver);
        if (o != null && !o.j(oVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (o != null) {
            return;
        }
        oVar.getLifecycle().a(lifecycleBoundObserver);
    }

    protected void h() {
    }

    protected void i() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(T t) {
        boolean z;
        synchronized (this.f1752b) {
            z = this.f1756f == a;
            this.f1756f = t;
        }
        if (z) {
            c.b.a.a.a.f().d(this.f1760j);
        }
    }

    public void k(v<? super T> vVar) {
        b("removeObserver");
        LiveData<T>.b p = this.f1753c.p(vVar);
        if (p == null) {
            return;
        }
        p.i();
        p.h(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(T t) {
        b("setValue");
        this.f1757g++;
        this.f1755e = t;
        d(null);
    }

    public LiveData() {
        this.f1752b = new Object();
        this.f1753c = new c.b.a.b.b<>();
        this.f1754d = 0;
        Object obj = a;
        this.f1756f = obj;
        this.f1760j = new a();
        this.f1755e = obj;
        this.f1757g = -1;
    }
}