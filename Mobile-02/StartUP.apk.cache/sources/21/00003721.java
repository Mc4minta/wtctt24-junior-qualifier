package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class z4<V> extends FutureTask<V> implements Comparable<z4<V>> {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f7964b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7965c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ y4 f7966d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z4(y4 y4Var, Callable<V> callable, boolean z, String str) {
        super(callable);
        AtomicLong atomicLong;
        this.f7966d = y4Var;
        com.google.android.gms.common.internal.t.k(str);
        atomicLong = y4.f7946c;
        long andIncrement = atomicLong.getAndIncrement();
        this.a = andIncrement;
        this.f7965c = str;
        this.f7964b = z;
        if (andIncrement == Long.MAX_VALUE) {
            y4Var.f().H().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        z4 z4Var = (z4) obj;
        boolean z = this.f7964b;
        if (z != z4Var.f7964b) {
            return z ? -1 : 1;
        }
        long j2 = this.a;
        long j3 = z4Var.a;
        if (j2 < j3) {
            return -1;
        }
        if (j2 > j3) {
            return 1;
        }
        this.f7966d.f().I().b("Two tasks share the same index. index", Long.valueOf(this.a));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.f7966d.f().H().b(this.f7965c, th);
        super.setException(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z4(y4 y4Var, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        AtomicLong atomicLong;
        this.f7966d = y4Var;
        com.google.android.gms.common.internal.t.k(str);
        atomicLong = y4.f7946c;
        long andIncrement = atomicLong.getAndIncrement();
        this.a = andIncrement;
        this.f7965c = str;
        this.f7964b = false;
        if (andIncrement == Long.MAX_VALUE) {
            y4Var.f().H().a("Tasks index overflow");
        }
    }
}