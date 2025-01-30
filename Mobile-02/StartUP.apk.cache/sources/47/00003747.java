package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class w<TResult, TContinuationResult> implements b, d, e<TContinuationResult>, y<TResult> {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final f<TResult, TContinuationResult> f8014b;

    /* renamed from: c  reason: collision with root package name */
    private final b0<TContinuationResult> f8015c;

    public w(Executor executor, f<TResult, TContinuationResult> fVar, b0<TContinuationResult> b0Var) {
        this.a = executor;
        this.f8014b = fVar;
        this.f8015c = b0Var;
    }

    @Override // com.google.android.gms.tasks.y
    public final void a(g<TResult> gVar) {
        this.a.execute(new x(this, gVar));
    }

    @Override // com.google.android.gms.tasks.b
    public final void b() {
        this.f8015c.x();
    }

    @Override // com.google.android.gms.tasks.d
    public final void c(Exception exc) {
        this.f8015c.t(exc);
    }

    @Override // com.google.android.gms.tasks.e
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f8015c.u(tcontinuationresult);
    }
}