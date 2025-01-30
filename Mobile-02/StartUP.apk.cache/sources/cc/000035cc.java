package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
final class y extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Activity f7419e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ ia f7420f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ bd.b f7421g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(bd.b bVar, Activity activity, ia iaVar) {
        super(bd.this);
        this.f7421g = bVar;
        this.f7419e = activity;
        this.f7420f = iaVar;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = bd.this.q;
        h9Var.onActivitySaveInstanceState(com.google.android.gms.dynamic.b.Y0(this.f7419e), this.f7420f, this.f7055b);
    }
}