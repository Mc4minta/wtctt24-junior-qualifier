package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class u5 implements Runnable {
    private final /* synthetic */ ia a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ z9 f7883b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ h5 f7884c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u5(h5 h5Var, ia iaVar, z9 z9Var) {
        this.f7884c = h5Var;
        this.a = iaVar;
        this.f7883b = z9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j9 j9Var;
        j9 j9Var2;
        j9 j9Var3;
        j9Var = this.f7884c.a;
        j9Var.d0();
        if (this.a.f7654c.i1() == null) {
            j9Var3 = this.f7884c.a;
            j9Var3.P(this.a, this.f7883b);
            return;
        }
        j9Var2 = this.f7884c.a;
        j9Var2.y(this.a, this.f7883b);
    }
}