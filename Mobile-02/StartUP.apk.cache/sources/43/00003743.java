package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class s<TResult> implements y<TResult> {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f8008b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private d f8009c;

    public s(Executor executor, d dVar) {
        this.a = executor;
        this.f8009c = dVar;
    }

    @Override // com.google.android.gms.tasks.y
    public final void a(g<TResult> gVar) {
        if (gVar.q() || gVar.o()) {
            return;
        }
        synchronized (this.f8008b) {
            if (this.f8009c == null) {
                return;
            }
            this.a.execute(new t(this, gVar));
        }
    }
}