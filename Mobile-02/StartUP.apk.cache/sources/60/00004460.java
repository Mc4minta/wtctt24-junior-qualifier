package e.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: LottieTask.java */
/* loaded from: classes.dex */
public class n<T> {
    public static Executor a = Executors.newCachedThreadPool();

    /* renamed from: b  reason: collision with root package name */
    private final Set<i<T>> f11576b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<i<Throwable>> f11577c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f11578d;

    /* renamed from: e  reason: collision with root package name */
    private volatile m<T> f11579e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieTask.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f11579e == null) {
                return;
            }
            m mVar = n.this.f11579e;
            if (mVar.b() != null) {
                n.this.i(mVar.b());
            } else {
                n.this.g(mVar.a());
            }
        }
    }

    /* compiled from: LottieTask.java */
    /* loaded from: classes.dex */
    private class b extends FutureTask<m<T>> {
        b(Callable<m<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                n.this.l(get());
            } catch (InterruptedException | ExecutionException e2) {
                n.this.l(new m(e2));
            }
        }
    }

    public n(Callable<m<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(Throwable th) {
        ArrayList<i> arrayList = new ArrayList(this.f11577c);
        if (arrayList.isEmpty()) {
            e.a.a.z.d.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (i iVar : arrayList) {
            iVar.a(th);
        }
    }

    private void h() {
        this.f11578d.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(T t) {
        for (i iVar : new ArrayList(this.f11576b)) {
            iVar.a(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(m<T> mVar) {
        if (this.f11579e == null) {
            this.f11579e = mVar;
            h();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized n<T> e(i<Throwable> iVar) {
        if (this.f11579e != null && this.f11579e.a() != null) {
            iVar.a(this.f11579e.a());
        }
        this.f11577c.add(iVar);
        return this;
    }

    public synchronized n<T> f(i<T> iVar) {
        if (this.f11579e != null && this.f11579e.b() != null) {
            iVar.a(this.f11579e.b());
        }
        this.f11576b.add(iVar);
        return this;
    }

    public synchronized n<T> j(i<Throwable> iVar) {
        this.f11577c.remove(iVar);
        return this;
    }

    public synchronized n<T> k(i<T> iVar) {
        this.f11576b.remove(iVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Callable<m<T>> callable, boolean z) {
        this.f11576b = new LinkedHashSet(1);
        this.f11577c = new LinkedHashSet(1);
        this.f11578d = new Handler(Looper.getMainLooper());
        this.f11579e = null;
        if (z) {
            try {
                l(callable.call());
                return;
            } catch (Throwable th) {
                l(new m<>(th));
                return;
            }
        }
        a.execute(new b(callable));
    }
}