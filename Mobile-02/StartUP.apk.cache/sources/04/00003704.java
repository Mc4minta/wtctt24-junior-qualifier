package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
final class w8 implements Runnable {
    private final /* synthetic */ long a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ u8 f7929b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w8(u8 u8Var, long j2) {
        this.f7929b = u8Var;
        this.a = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7929b.I(this.a);
    }
}