package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class k implements Runnable {
    private final /* synthetic */ z5 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ h f7701b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, z5 z5Var) {
        this.f7701b = hVar;
        this.a = z5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.g();
        if (ja.a()) {
            this.a.l().A(this);
            return;
        }
        boolean d2 = this.f7701b.d();
        h.a(this.f7701b, 0L);
        if (d2) {
            this.f7701b.b();
        }
    }
}