package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class q5 implements Runnable {
    private final /* synthetic */ q9 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ z9 f7813b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ h5 f7814c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q5(h5 h5Var, q9 q9Var, z9 z9Var) {
        this.f7814c = h5Var;
        this.a = q9Var;
        this.f7813b = z9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j9 j9Var;
        j9 j9Var2;
        j9 j9Var3;
        j9Var = this.f7814c.a;
        j9Var.d0();
        if (this.a.i1() == null) {
            j9Var3 = this.f7814c.a;
            j9Var3.M(this.a, this.f7813b);
            return;
        }
        j9Var2 = this.f7814c.a;
        j9Var2.v(this.a, this.f7813b);
    }
}