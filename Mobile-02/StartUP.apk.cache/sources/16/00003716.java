package com.google.android.gms.measurement.internal;

import android.content.Context;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class y4 extends w5 {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicLong f7946c = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: d  reason: collision with root package name */
    private c5 f7947d;

    /* renamed from: e  reason: collision with root package name */
    private c5 f7948e;

    /* renamed from: f  reason: collision with root package name */
    private final PriorityBlockingQueue<z4<?>> f7949f;

    /* renamed from: g  reason: collision with root package name */
    private final BlockingQueue<z4<?>> f7950g;

    /* renamed from: h  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f7951h;

    /* renamed from: i  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f7952i;

    /* renamed from: j  reason: collision with root package name */
    private final Object f7953j;

    /* renamed from: k  reason: collision with root package name */
    private final Semaphore f7954k;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f7955l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y4(b5 b5Var) {
        super(b5Var);
        this.f7953j = new Object();
        this.f7954k = new Semaphore(2);
        this.f7949f = new PriorityBlockingQueue<>();
        this.f7950g = new LinkedBlockingQueue();
        this.f7951h = new a5(this, "Thread death: Uncaught exception on worker thread");
        this.f7952i = new a5(this, "Thread death: Uncaught exception on network thread");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ c5 B(y4 y4Var, c5 c5Var) {
        y4Var.f7948e = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ c5 v(y4 y4Var, c5 c5Var) {
        y4Var.f7947d = null;
        return null;
    }

    private final void z(z4<?> z4Var) {
        synchronized (this.f7953j) {
            this.f7949f.add(z4Var);
            c5 c5Var = this.f7947d;
            if (c5Var == null) {
                c5 c5Var2 = new c5(this, "Measurement Worker", this.f7949f);
                this.f7947d = c5Var2;
                c5Var2.setUncaughtExceptionHandler(this.f7951h);
                this.f7947d.start();
            } else {
                c5Var.a();
            }
        }
    }

    public final void A(Runnable runnable) throws IllegalStateException {
        q();
        com.google.android.gms.common.internal.t.k(runnable);
        z(new z4<>(this, runnable, false, "Task exception on worker thread"));
    }

    public final <V> Future<V> C(Callable<V> callable) throws IllegalStateException {
        q();
        com.google.android.gms.common.internal.t.k(callable);
        z4<?> z4Var = new z4<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f7947d) {
            z4Var.run();
        } else {
            z(z4Var);
        }
        return z4Var;
    }

    public final void D(Runnable runnable) throws IllegalStateException {
        q();
        com.google.android.gms.common.internal.t.k(runnable);
        z4<?> z4Var = new z4<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.f7953j) {
            this.f7950g.add(z4Var);
            c5 c5Var = this.f7948e;
            if (c5Var == null) {
                c5 c5Var2 = new c5(this, "Measurement Network", this.f7950g);
                this.f7948e = c5Var2;
                c5Var2.setUncaughtExceptionHandler(this.f7952i);
                this.f7948e.start();
            } else {
                c5Var.a();
            }
        }
    }

    public final boolean I() {
        return Thread.currentThread() == this.f7947d;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final void c() {
        if (Thread.currentThread() != this.f7948e) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final void d() {
        if (Thread.currentThread() != this.f7947d) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ x3 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ ja g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ Context h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.e i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v3 j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ y4 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v9 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ k4 n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ ka o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final boolean t() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> T w(AtomicReference<T> atomicReference, long j2, String str, Runnable runnable) {
        synchronized (atomicReference) {
            l().A(runnable);
            try {
                atomicReference.wait(j2);
            } catch (InterruptedException unused) {
                z3 K = f().K();
                String valueOf = String.valueOf(str);
                K.a(valueOf.length() != 0 ? "Interrupted waiting for ".concat(valueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            z3 K2 = f().K();
            String valueOf2 = String.valueOf(str);
            K2.a(valueOf2.length() != 0 ? "Timed out waiting for ".concat(valueOf2) : new String("Timed out waiting for "));
        }
        return t;
    }

    public final <V> Future<V> x(Callable<V> callable) throws IllegalStateException {
        q();
        com.google.android.gms.common.internal.t.k(callable);
        z4<?> z4Var = new z4<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f7947d) {
            if (!this.f7949f.isEmpty()) {
                f().K().a("Callable skipped the worker queue.");
            }
            z4Var.run();
        } else {
            z(z4Var);
        }
        return z4Var;
    }
}