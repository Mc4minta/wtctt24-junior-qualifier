package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class u6 implements Runnable {
    private final /* synthetic */ AtomicReference a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7885b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f7886c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f7887d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ boolean f7888e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ i6 f7889f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u6(i6 i6Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f7889f = i6Var;
        this.a = atomicReference;
        this.f7885b = str;
        this.f7886c = str2;
        this.f7887d = str3;
        this.f7888e = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7889f.a.Q().U(this.a, this.f7885b, this.f7886c, this.f7887d, this.f7888e);
    }
}