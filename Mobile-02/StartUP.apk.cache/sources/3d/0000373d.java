package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class m<TResult, TContinuationResult> implements b, d, e<TContinuationResult>, y<TResult> {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final a<TResult, g<TContinuationResult>> f8000b;

    /* renamed from: c  reason: collision with root package name */
    private final b0<TContinuationResult> f8001c;

    public m(Executor executor, a<TResult, g<TContinuationResult>> aVar, b0<TContinuationResult> b0Var) {
        this.a = executor;
        this.f8000b = aVar;
        this.f8001c = b0Var;
    }

    @Override // com.google.android.gms.tasks.y
    public final void a(g<TResult> gVar) {
        this.a.execute(new n(this, gVar));
    }

    @Override // com.google.android.gms.tasks.b
    public final void b() {
        this.f8001c.x();
    }

    @Override // com.google.android.gms.tasks.d
    public final void c(Exception exc) {
        this.f8001c.t(exc);
    }

    @Override // com.google.android.gms.tasks.e
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f8001c.u(tcontinuationresult);
    }
}