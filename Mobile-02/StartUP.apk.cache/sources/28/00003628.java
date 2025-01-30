package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class d7 implements Runnable {
    private final /* synthetic */ long a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i6 f7537b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d7(i6 i6Var, long j2) {
        this.f7537b = i6Var;
        this.a = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7537b.n().q.b(this.a);
        this.f7537b.f().O().b("Minimum session duration set", Long.valueOf(this.a));
    }
}