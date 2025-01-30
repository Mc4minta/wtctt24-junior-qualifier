package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class l6 implements Runnable {
    private final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7739b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ long f7740c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Bundle f7741d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ boolean f7742e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ boolean f7743f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ boolean f7744g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ String f7745h;

    /* renamed from: j  reason: collision with root package name */
    private final /* synthetic */ i6 f7746j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l6(i6 i6Var, String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.f7746j = i6Var;
        this.a = str;
        this.f7739b = str2;
        this.f7740c = j2;
        this.f7741d = bundle;
        this.f7742e = z;
        this.f7743f = z2;
        this.f7744g = z3;
        this.f7745h = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7746j.Q(this.a, this.f7739b, this.f7740c, this.f7741d, this.f7742e, this.f7743f, this.f7744g, this.f7745h);
    }
}