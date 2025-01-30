package com.google.firebase.analytics.a;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class c implements Executor {
    static final Executor a = new c();

    private c() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}