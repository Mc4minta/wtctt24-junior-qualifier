package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class k<TResult, TContinuationResult> implements y<TResult> {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final a<TResult, TContinuationResult> f7997b;

    /* renamed from: c  reason: collision with root package name */
    private final b0<TContinuationResult> f7998c;

    public k(Executor executor, a<TResult, TContinuationResult> aVar, b0<TContinuationResult> b0Var) {
        this.a = executor;
        this.f7997b = aVar;
        this.f7998c = b0Var;
    }

    @Override // com.google.android.gms.tasks.y
    public final void a(g<TResult> gVar) {
        this.a.execute(new l(this, gVar));
    }
}