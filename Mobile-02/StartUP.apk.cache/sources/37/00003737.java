package com.google.android.gms.tasks;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public final class j {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b extends com.google.android.gms.tasks.b, d, e<Object> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c implements b {
        private final Object a = new Object();

        /* renamed from: b  reason: collision with root package name */
        private final int f7990b;

        /* renamed from: c  reason: collision with root package name */
        private final b0<Void> f7991c;

        /* renamed from: d  reason: collision with root package name */
        private int f7992d;

        /* renamed from: e  reason: collision with root package name */
        private int f7993e;

        /* renamed from: f  reason: collision with root package name */
        private int f7994f;

        /* renamed from: g  reason: collision with root package name */
        private Exception f7995g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f7996h;

        public c(int i2, b0<Void> b0Var) {
            this.f7990b = i2;
            this.f7991c = b0Var;
        }

        private final void a() {
            if (this.f7992d + this.f7993e + this.f7994f == this.f7990b) {
                if (this.f7995g != null) {
                    b0<Void> b0Var = this.f7991c;
                    int i2 = this.f7993e;
                    int i3 = this.f7990b;
                    StringBuilder sb = new StringBuilder(54);
                    sb.append(i2);
                    sb.append(" out of ");
                    sb.append(i3);
                    sb.append(" underlying tasks failed");
                    b0Var.t(new ExecutionException(sb.toString(), this.f7995g));
                } else if (this.f7996h) {
                    this.f7991c.x();
                } else {
                    this.f7991c.u(null);
                }
            }
        }

        @Override // com.google.android.gms.tasks.b
        public final void b() {
            synchronized (this.a) {
                this.f7994f++;
                this.f7996h = true;
                a();
            }
        }

        @Override // com.google.android.gms.tasks.d
        public final void c(Exception exc) {
            synchronized (this.a) {
                this.f7993e++;
                this.f7995g = exc;
                a();
            }
        }

        @Override // com.google.android.gms.tasks.e
        public final void onSuccess(Object obj) {
            synchronized (this.a) {
                this.f7992d++;
                a();
            }
        }
    }

    public static <TResult> TResult a(g<TResult> gVar) throws ExecutionException, InterruptedException {
        com.google.android.gms.common.internal.t.i();
        com.google.android.gms.common.internal.t.l(gVar, "Task must not be null");
        if (gVar.p()) {
            return (TResult) j(gVar);
        }
        a aVar = new a(null);
        i(gVar, aVar);
        aVar.a();
        return (TResult) j(gVar);
    }

    public static <TResult> TResult b(g<TResult> gVar, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        com.google.android.gms.common.internal.t.i();
        com.google.android.gms.common.internal.t.l(gVar, "Task must not be null");
        com.google.android.gms.common.internal.t.l(timeUnit, "TimeUnit must not be null");
        if (gVar.p()) {
            return (TResult) j(gVar);
        }
        a aVar = new a(null);
        i(gVar, aVar);
        if (aVar.d(j2, timeUnit)) {
            return (TResult) j(gVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static <TResult> g<TResult> c(Executor executor, Callable<TResult> callable) {
        com.google.android.gms.common.internal.t.l(executor, "Executor must not be null");
        com.google.android.gms.common.internal.t.l(callable, "Callback must not be null");
        b0 b0Var = new b0();
        executor.execute(new c0(b0Var, callable));
        return b0Var;
    }

    public static <TResult> g<TResult> d(Exception exc) {
        b0 b0Var = new b0();
        b0Var.t(exc);
        return b0Var;
    }

    public static <TResult> g<TResult> e(TResult tresult) {
        b0 b0Var = new b0();
        b0Var.u(tresult);
        return b0Var;
    }

    public static g<Void> f(Collection<? extends g<?>> collection) {
        if (collection.isEmpty()) {
            return e(null);
        }
        for (g<?> gVar : collection) {
            Objects.requireNonNull(gVar, "null tasks are not accepted");
        }
        b0 b0Var = new b0();
        c cVar = new c(collection.size(), b0Var);
        for (g<?> gVar2 : collection) {
            i(gVar2, cVar);
        }
        return b0Var;
    }

    public static g<List<g<?>>> g(Collection<? extends g<?>> collection) {
        return f(collection).j(new d0(collection));
    }

    public static g<List<g<?>>> h(g<?>... gVarArr) {
        return g(Arrays.asList(gVarArr));
    }

    private static void i(g<?> gVar, b bVar) {
        Executor executor = i.f7989b;
        gVar.g(executor, bVar);
        gVar.e(executor, bVar);
        gVar.a(executor, bVar);
    }

    private static <TResult> TResult j(g<TResult> gVar) throws ExecutionException {
        if (gVar.q()) {
            return gVar.m();
        }
        if (gVar.o()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(gVar.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a implements b {
        private final CountDownLatch a;

        private a() {
            this.a = new CountDownLatch(1);
        }

        public final void a() throws InterruptedException {
            this.a.await();
        }

        @Override // com.google.android.gms.tasks.b
        public final void b() {
            this.a.countDown();
        }

        @Override // com.google.android.gms.tasks.d
        public final void c(Exception exc) {
            this.a.countDown();
        }

        public final boolean d(long j2, TimeUnit timeUnit) throws InterruptedException {
            return this.a.await(j2, timeUnit);
        }

        @Override // com.google.android.gms.tasks.e
        public final void onSuccess(Object obj) {
            this.a.countDown();
        }

        /* synthetic */ a(c0 c0Var) {
            this();
        }
    }
}