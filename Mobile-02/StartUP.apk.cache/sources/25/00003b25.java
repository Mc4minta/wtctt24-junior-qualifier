package com.google.firebase.installations;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
final /* synthetic */ class d implements Runnable {
    private final h a;

    private d(h hVar) {
        this.a = hVar;
    }

    public static Runnable a(h hVar) {
        return new d(hVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.j();
    }
}