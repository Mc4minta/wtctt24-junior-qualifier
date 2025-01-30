package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class u<TResult> implements y<TResult> {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f8011b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private e<? super TResult> f8012c;

    public u(Executor executor, e<? super TResult> eVar) {
        this.a = executor;
        this.f8012c = eVar;
    }

    @Override // com.google.android.gms.tasks.y
    public final void a(g<TResult> gVar) {
        if (gVar.q()) {
            synchronized (this.f8011b) {
                if (this.f8012c == null) {
                    return;
                }
                this.a.execute(new v(this, gVar));
            }
        }
    }
}