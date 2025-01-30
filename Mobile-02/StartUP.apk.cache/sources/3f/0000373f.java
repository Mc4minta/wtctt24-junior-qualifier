package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class o<TResult> implements y<TResult> {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f8003b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private b f8004c;

    public o(Executor executor, b bVar) {
        this.a = executor;
        this.f8004c = bVar;
    }

    @Override // com.google.android.gms.tasks.y
    public final void a(g gVar) {
        if (gVar.o()) {
            synchronized (this.f8003b) {
                if (this.f8004c == null) {
                    return;
                }
                this.a.execute(new p(this));
            }
        }
    }
}