package com.google.firebase.perf.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class g implements Runnable {
    private final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.l();
    }
}