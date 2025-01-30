package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.internal.p;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class j implements Callable {
    private final p a;

    private j(p pVar) {
        this.a = pVar;
    }

    public static Callable a(p pVar) {
        return new j(pVar);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return Boolean.valueOf(this.a.j());
    }
}