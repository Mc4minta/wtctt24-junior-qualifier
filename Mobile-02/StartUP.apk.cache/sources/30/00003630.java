package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class e3 implements Runnable {
    private final /* synthetic */ long a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ a f7554b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e3(a aVar, long j2) {
        this.f7554b = aVar;
        this.a = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7554b.C(this.a);
    }
}