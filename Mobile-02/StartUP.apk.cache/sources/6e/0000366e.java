package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class j5 implements Runnable {
    private final /* synthetic */ ia a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ h5 f7674b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j5(h5 h5Var, ia iaVar) {
        this.f7674b = h5Var;
        this.a = iaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j9 j9Var;
        j9 j9Var2;
        j9 j9Var3;
        j9Var = this.f7674b.a;
        j9Var.d0();
        if (this.a.f7654c.i1() == null) {
            j9Var3 = this.f7674b.a;
            j9Var3.O(this.a);
            return;
        }
        j9Var2 = this.f7674b.a;
        j9Var2.x(this.a);
    }
}