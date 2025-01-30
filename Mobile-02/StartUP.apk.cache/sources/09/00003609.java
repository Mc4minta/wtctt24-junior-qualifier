package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class b0 implements Runnable {
    private final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f7498b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ a f7499c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(a aVar, String str, long j2) {
        this.f7499c = aVar;
        this.a = str;
        this.f7498b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7499c.G(this.a, this.f7498b);
    }
}