package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class v6 implements Runnable {
    private final /* synthetic */ AtomicReference a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7906b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f7907c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f7908d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ i6 f7909e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v6(i6 i6Var, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f7909e = i6Var;
        this.a = atomicReference;
        this.f7906b = str;
        this.f7907c = str2;
        this.f7908d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7909e.a.Q().T(this.a, this.f7906b, this.f7907c, this.f7908d);
    }
}