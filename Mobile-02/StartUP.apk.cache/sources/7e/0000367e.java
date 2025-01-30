package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
final class k8 implements Runnable {
    private final /* synthetic */ p3 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ l8 f7720b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k8(l8 l8Var, p3 p3Var) {
        this.f7720b = l8Var;
        this.a = p3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f7720b) {
            l8.c(this.f7720b, false);
            if (!this.f7720b.f7748c.W()) {
                this.f7720b.f7748c.f().P().a("Connected to service");
                this.f7720b.f7748c.L(this.a);
            }
        }
    }
}