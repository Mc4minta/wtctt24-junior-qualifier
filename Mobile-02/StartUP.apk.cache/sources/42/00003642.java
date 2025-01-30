package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class f9 {
    private final com.google.android.gms.common.util.e a;

    /* renamed from: b  reason: collision with root package name */
    private long f7594b;

    public f9(com.google.android.gms.common.util.e eVar) {
        com.google.android.gms.common.internal.t.k(eVar);
        this.a = eVar;
    }

    public final void a() {
        this.f7594b = this.a.b();
    }

    public final boolean b(long j2) {
        return this.f7594b == 0 || this.a.b() - this.f7594b >= 3600000;
    }

    public final void c() {
        this.f7594b = 0L;
    }
}