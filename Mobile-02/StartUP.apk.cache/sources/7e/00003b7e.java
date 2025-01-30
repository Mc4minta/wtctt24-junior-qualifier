package com.google.firebase.perf.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class k implements Runnable {
    private final /* synthetic */ boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ d f9331b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar, boolean z) {
        this.f9331b = dVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9331b.r(this.a);
    }
}