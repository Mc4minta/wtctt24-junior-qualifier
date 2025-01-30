package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AutoDisposableHelper.java */
/* loaded from: classes2.dex */
enum c implements h.c.k0.b {
    DISPOSED;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(AtomicReference<h.c.k0.b> atomicReference) {
        h.c.k0.b andSet;
        h.c.k0.b bVar = atomicReference.get();
        c cVar = DISPOSED;
        if (bVar == cVar || (andSet = atomicReference.getAndSet(cVar)) == cVar) {
            return false;
        }
        if (andSet != null) {
            andSet.dispose();
            return true;
        }
        return true;
    }

    @Override // h.c.k0.b
    public void dispose() {
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return true;
    }
}