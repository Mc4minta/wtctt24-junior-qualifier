package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class u7 implements Runnable {
    private final /* synthetic */ boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ q9 f7890b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ z9 f7891c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ s7 f7892d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u7(s7 s7Var, boolean z, q9 q9Var, z9 z9Var) {
        this.f7892d = s7Var;
        this.a = z;
        this.f7890b = q9Var;
        this.f7891c = z9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        p3Var = this.f7892d.f7853d;
        if (p3Var == null) {
            this.f7892d.f().H().a("Discarding data. Failed to set user property");
            return;
        }
        this.f7892d.M(p3Var, this.a ? null : this.f7890b, this.f7891c);
        this.f7892d.f0();
    }
}