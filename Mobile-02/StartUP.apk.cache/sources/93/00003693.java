package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class m5 implements Runnable {
    private final /* synthetic */ z9 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ h5 f7759b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m5(h5 h5Var, z9 z9Var) {
        this.f7759b = h5Var;
        this.a = z9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j9 j9Var;
        j9 j9Var2;
        j9Var = this.f7759b.a;
        j9Var.d0();
        j9Var2 = this.f7759b.a;
        j9Var2.w(this.a);
    }
}