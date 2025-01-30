package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class p5 implements Runnable {
    private final /* synthetic */ p a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ z9 f7797b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ h5 f7798c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p5(h5 h5Var, p pVar, z9 z9Var) {
        this.f7798c = h5Var;
        this.a = pVar;
        this.f7797b = z9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j9 j9Var;
        j9 j9Var2;
        p Z0 = this.f7798c.Z0(this.a, this.f7797b);
        j9Var = this.f7798c.a;
        j9Var.d0();
        j9Var2 = this.f7798c.a;
        j9Var2.p(Z0, this.f7797b);
    }
}