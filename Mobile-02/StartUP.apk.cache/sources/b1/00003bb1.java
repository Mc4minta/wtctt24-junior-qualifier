package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class i implements Callable {
    private final k a;

    private i(k kVar) {
        this.a = kVar;
    }

    public static Callable a(k kVar) {
        return new i(kVar);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.a.e();
    }
}