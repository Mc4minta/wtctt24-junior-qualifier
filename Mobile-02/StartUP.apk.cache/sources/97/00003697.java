package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class m9 implements Runnable {
    private final /* synthetic */ p9 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ j9 f7762b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m9(j9 j9Var, p9 p9Var) {
        this.f7762b = j9Var;
        this.a = p9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7762b.u(this.a);
        this.f7762b.e();
    }
}