package com.google.firebase.installations;

import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
final /* synthetic */ class f implements Callable {
    private final h a;

    private f(h hVar) {
        this.a = hVar;
    }

    public static Callable a(h hVar) {
        return new f(hVar);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        Void i2;
        i2 = this.a.i();
        return i2;
    }
}