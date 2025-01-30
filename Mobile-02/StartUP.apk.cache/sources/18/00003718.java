package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class y6 implements Runnable {
    private final /* synthetic */ boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i6 f7956b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y6(i6 i6Var, boolean z) {
        this.f7956b = i6Var;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7956b.C0(this.a);
    }
}