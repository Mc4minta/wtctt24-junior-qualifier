package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class t6 implements Runnable {
    private final /* synthetic */ Bundle a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i6 f7867b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t6(i6 i6Var, Bundle bundle) {
        this.f7867b = i6Var;
        this.a = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7867b.B0(this.a);
    }
}