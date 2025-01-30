package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class s8 implements Runnable {
    private final /* synthetic */ j9 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Runnable f7859b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s8(r8 r8Var, j9 j9Var, Runnable runnable) {
        this.a = j9Var;
        this.f7859b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d0();
        this.a.z(this.f7859b);
        this.a.c0();
    }
}