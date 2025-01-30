package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
final class r6 implements Runnable {
    private final /* synthetic */ c6 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i6 f7847b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r6(i6 i6Var, c6 c6Var) {
        this.f7847b = i6Var;
        this.a = c6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7847b.J(this.a);
    }
}