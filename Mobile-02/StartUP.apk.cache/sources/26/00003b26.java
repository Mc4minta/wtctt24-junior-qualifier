package com.google.firebase.installations;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
final /* synthetic */ class e implements Runnable {
    private final h a;

    private e(h hVar) {
        this.a = hVar;
    }

    public static Runnable a(h hVar) {
        return new e(hVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.k();
    }
}