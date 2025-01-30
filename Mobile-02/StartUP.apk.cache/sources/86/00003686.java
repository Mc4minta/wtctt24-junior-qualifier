package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class l4 implements Runnable {
    private final /* synthetic */ boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i4 f7735b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l4(i4 i4Var, boolean z) {
        this.f7735b = i4Var;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j9 j9Var;
        j9Var = this.f7735b.f7633b;
        j9Var.B(this.a);
    }
}