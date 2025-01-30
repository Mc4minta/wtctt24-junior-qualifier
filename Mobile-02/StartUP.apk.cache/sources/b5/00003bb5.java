package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
final /* synthetic */ class c implements Callable {
    private final m a;

    private c(m mVar) {
        this.a = mVar;
    }

    public static Callable a(m mVar) {
        return new c(mVar);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.a.d();
    }
}