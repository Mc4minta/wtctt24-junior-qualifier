package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class q<TResult> implements y<TResult> {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f8005b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private c<TResult> f8006c;

    public q(Executor executor, c<TResult> cVar) {
        this.a = executor;
        this.f8006c = cVar;
    }

    @Override // com.google.android.gms.tasks.y
    public final void a(g<TResult> gVar) {
        synchronized (this.f8005b) {
            if (this.f8006c == null) {
                return;
            }
            this.a.execute(new r(this, gVar));
        }
    }
}