package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: Task.java */
/* loaded from: classes.dex */
public class e<TResult> {

    /* renamed from: d  reason: collision with root package name */
    private static volatile d f2402d;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2408j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2409k;

    /* renamed from: l  reason: collision with root package name */
    private TResult f2410l;
    private Exception m;
    private boolean n;
    private g o;
    public static final ExecutorService a = bolts.b.a();

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f2400b = bolts.b.b();

    /* renamed from: c  reason: collision with root package name */
    public static final Executor f2401c = bolts.a.c();

    /* renamed from: e  reason: collision with root package name */
    private static e<?> f2403e = new e<>((Object) null);

    /* renamed from: f  reason: collision with root package name */
    private static e<Boolean> f2404f = new e<>(Boolean.TRUE);

    /* renamed from: g  reason: collision with root package name */
    private static e<Boolean> f2405g = new e<>(Boolean.FALSE);

    /* renamed from: h  reason: collision with root package name */
    private static e<?> f2406h = new e<>(true);

    /* renamed from: i  reason: collision with root package name */
    private final Object f2407i = new Object();
    private List<bolts.d<TResult, Void>> p = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public class a implements bolts.d<TResult, Void> {
        final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ bolts.d f2411b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Executor f2412c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ bolts.c f2413d;

        a(f fVar, bolts.d dVar, Executor executor, bolts.c cVar) {
            this.a = fVar;
            this.f2411b = dVar;
            this.f2412c = executor;
        }

        @Override // bolts.d
        /* renamed from: b */
        public Void a(e<TResult> eVar) {
            e.d(this.a, this.f2411b, eVar, this.f2412c, this.f2413d);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        final /* synthetic */ bolts.c a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f2415b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ bolts.d f2416c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f2417d;

        b(bolts.c cVar, f fVar, bolts.d dVar, e eVar) {
            this.f2415b = fVar;
            this.f2416c = dVar;
            this.f2417d = eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (this.a == null) {
                try {
                    this.f2415b.d(this.f2416c.a(this.f2417d));
                    return;
                } catch (CancellationException unused) {
                    this.f2415b.b();
                    return;
                } catch (Exception e2) {
                    this.f2415b.c(e2);
                    return;
                }
            }
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public static class c implements Runnable {
        final /* synthetic */ bolts.c a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f2418b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Callable f2419c;

        c(bolts.c cVar, f fVar, Callable callable) {
            this.f2418b = fVar;
            this.f2419c = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (this.a == null) {
                try {
                    this.f2418b.d(this.f2419c.call());
                    return;
                } catch (CancellationException unused) {
                    this.f2418b.b();
                    return;
                } catch (Exception e2) {
                    this.f2418b.c(e2);
                    return;
                }
            }
            throw null;
        }
    }

    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(e<?> eVar, UnobservedTaskException unobservedTaskException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
    }

    public static <TResult> e<TResult> b(Callable<TResult> callable, Executor executor) {
        return c(callable, executor, null);
    }

    public static <TResult> e<TResult> c(Callable<TResult> callable, Executor executor, bolts.c cVar) {
        f fVar = new f();
        try {
            executor.execute(new c(cVar, fVar, callable));
        } catch (Exception e2) {
            fVar.c(new ExecutorException(e2));
        }
        return fVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void d(f<TContinuationResult> fVar, bolts.d<TResult, TContinuationResult> dVar, e<TResult> eVar, Executor executor, bolts.c cVar) {
        try {
            executor.execute(new b(cVar, fVar, dVar, eVar));
        } catch (Exception e2) {
            fVar.c(new ExecutorException(e2));
        }
    }

    public static <TResult> e<TResult> g(Exception exc) {
        f fVar = new f();
        fVar.c(exc);
        return fVar.a();
    }

    public static <TResult> e<TResult> h(TResult tresult) {
        if (tresult == null) {
            return (e<TResult>) f2403e;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (e<TResult>) f2404f : (e<TResult>) f2405g;
        }
        f fVar = new f();
        fVar.d(tresult);
        return fVar.a();
    }

    public static d k() {
        return f2402d;
    }

    private void o() {
        synchronized (this.f2407i) {
            for (bolts.d<TResult, Void> dVar : this.p) {
                try {
                    dVar.a(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.p = null;
        }
    }

    public <TContinuationResult> e<TContinuationResult> e(bolts.d<TResult, TContinuationResult> dVar) {
        return f(dVar, f2400b, null);
    }

    public <TContinuationResult> e<TContinuationResult> f(bolts.d<TResult, TContinuationResult> dVar, Executor executor, bolts.c cVar) {
        boolean m;
        f fVar = new f();
        synchronized (this.f2407i) {
            m = m();
            if (!m) {
                this.p.add(new a(fVar, dVar, executor, cVar));
            }
        }
        if (m) {
            d(fVar, dVar, this, executor, cVar);
        }
        return fVar.a();
    }

    public Exception i() {
        Exception exc;
        synchronized (this.f2407i) {
            if (this.m != null) {
                this.n = true;
                g gVar = this.o;
                if (gVar != null) {
                    gVar.a();
                    this.o = null;
                }
            }
            exc = this.m;
        }
        return exc;
    }

    public TResult j() {
        TResult tresult;
        synchronized (this.f2407i) {
            tresult = this.f2410l;
        }
        return tresult;
    }

    public boolean l() {
        boolean z;
        synchronized (this.f2407i) {
            z = this.f2409k;
        }
        return z;
    }

    public boolean m() {
        boolean z;
        synchronized (this.f2407i) {
            z = this.f2408j;
        }
        return z;
    }

    public boolean n() {
        boolean z;
        synchronized (this.f2407i) {
            z = i() != null;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        synchronized (this.f2407i) {
            if (this.f2408j) {
                return false;
            }
            this.f2408j = true;
            this.f2409k = true;
            this.f2407i.notifyAll();
            o();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q(Exception exc) {
        synchronized (this.f2407i) {
            if (this.f2408j) {
                return false;
            }
            this.f2408j = true;
            this.m = exc;
            this.n = false;
            this.f2407i.notifyAll();
            o();
            if (!this.n && k() != null) {
                this.o = new g(this);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(TResult tresult) {
        synchronized (this.f2407i) {
            if (this.f2408j) {
                return false;
            }
            this.f2408j = true;
            this.f2410l = tresult;
            this.f2407i.notifyAll();
            o();
            return true;
        }
    }

    private e(TResult tresult) {
        r(tresult);
    }

    private e(boolean z) {
        if (z) {
            p();
        } else {
            r(null);
        }
    }
}