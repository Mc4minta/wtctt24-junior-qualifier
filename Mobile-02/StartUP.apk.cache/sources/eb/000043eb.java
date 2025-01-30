package com.uber.autodispose.b0.b;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: MainThreadDisposable.java */
/* loaded from: classes2.dex */
public abstract class d implements h.c.k0.b {
    private final AtomicBoolean a = new AtomicBoolean();

    @Override // h.c.k0.b
    public final void dispose() {
        if (this.a.compareAndSet(false, true)) {
            if (c.a()) {
                h();
            } else {
                h.c.j0.c.a.b().c(new Runnable() { // from class: com.uber.autodispose.b0.b.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.h();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void h();

    @Override // h.c.k0.b
    public final boolean isDisposed() {
        return this.a.get();
    }
}