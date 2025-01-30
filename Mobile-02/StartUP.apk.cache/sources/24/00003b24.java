package com.google.firebase.installations;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
final /* synthetic */ class c implements Runnable {
    private final h a;

    private c(h hVar) {
        this.a = hVar;
    }

    public static Runnable a(h hVar) {
        return new c(hVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.l();
    }
}