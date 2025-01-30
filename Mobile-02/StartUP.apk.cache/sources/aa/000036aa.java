package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class o6 implements Runnable {
    private final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7783b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Object f7784c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ long f7785d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ i6 f7786e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o6(i6 i6Var, String str, String str2, Object obj, long j2) {
        this.f7786e = i6Var;
        this.a = str;
        this.f7783b = str2;
        this.f7784c = obj;
        this.f7785d = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7786e.V(this.a, this.f7783b, this.f7784c, this.f7785d);
    }
}