package com.google.firebase.installations;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {
    private final h a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9208b;

    private g(h hVar, boolean z) {
        this.a = hVar;
        this.f9208b = z;
    }

    public static Runnable a(h hVar, boolean z) {
        return new g(hVar, z);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.m(this.f9208b);
    }
}