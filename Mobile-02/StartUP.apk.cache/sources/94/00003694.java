package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class m6 implements Runnable {
    private final /* synthetic */ long a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i6 f7760b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m6(i6 i6Var, long j2) {
        this.f7760b = i6Var;
        this.a = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7760b.n().r.b(this.a);
        this.f7760b.f().O().b("Session timeout duration set", Long.valueOf(this.a));
    }
}