package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class p7 implements Runnable {
    private final /* synthetic */ o7 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f7800b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ n7 f7801c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p7(n7 n7Var, o7 o7Var, long j2) {
        this.f7801c = n7Var;
        this.a = o7Var;
        this.f7800b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7801c.J(this.a, false, this.f7800b);
        n7 n7Var = this.f7801c;
        n7Var.f7769c = null;
        n7Var.s().N(null);
    }
}