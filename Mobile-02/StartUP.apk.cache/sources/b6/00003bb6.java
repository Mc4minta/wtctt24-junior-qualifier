package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
final /* synthetic */ class d implements Executor {
    private static final d a = new d();

    private d() {
    }

    public static Executor a() {
        return a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}