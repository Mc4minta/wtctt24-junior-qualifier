package com.google.firebase.crashlytics.c.g;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class i {
    private final ExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    private com.google.android.gms.tasks.g<Void> f8697b = com.google.android.gms.tasks.j.e(null);

    /* renamed from: c  reason: collision with root package name */
    private final Object f8698c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private ThreadLocal<Boolean> f8699d = new ThreadLocal<>();

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f8699d.set(Boolean.TRUE);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class b implements Callable<Void> {
        final /* synthetic */ Runnable a;

        b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            this.a.run();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class c<T> implements com.google.android.gms.tasks.a<Void, T> {
        final /* synthetic */ Callable a;

        c(Callable callable) {
            this.a = callable;
        }

        @Override // com.google.android.gms.tasks.a
        public T a(com.google.android.gms.tasks.g<Void> gVar) throws Exception {
            return (T) this.a.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class d<T> implements com.google.android.gms.tasks.a<T, Void> {
        d() {
        }

        @Override // com.google.android.gms.tasks.a
        /* renamed from: b */
        public Void a(com.google.android.gms.tasks.g<T> gVar) throws Exception {
            return null;
        }
    }

    public i(ExecutorService executorService) {
        this.a = executorService;
        executorService.submit(new a());
    }

    private <T> com.google.android.gms.tasks.g<Void> d(com.google.android.gms.tasks.g<T> gVar) {
        return gVar.i(this.a, new d());
    }

    private boolean e() {
        return Boolean.TRUE.equals(this.f8699d.get());
    }

    private <T> com.google.android.gms.tasks.a<Void, T> f(Callable<T> callable) {
        return new c(callable);
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public Executor c() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.gms.tasks.g<Void> g(Runnable runnable) {
        return h(new b(runnable));
    }

    public <T> com.google.android.gms.tasks.g<T> h(Callable<T> callable) {
        com.google.android.gms.tasks.g<T> i2;
        synchronized (this.f8698c) {
            i2 = this.f8697b.i(this.a, f(callable));
            this.f8697b = d(i2);
        }
        return i2;
    }

    public <T> com.google.android.gms.tasks.g<T> i(Callable<com.google.android.gms.tasks.g<T>> callable) {
        com.google.android.gms.tasks.g<T> k2;
        synchronized (this.f8698c) {
            k2 = this.f8697b.k(this.a, f(callable));
            this.f8697b = d(k2);
        }
        return k2;
    }
}