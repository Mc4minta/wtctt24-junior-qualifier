package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
final class v extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Activity f7367e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ Bundle f7368f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ bd.b f7369g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(bd.b bVar, Activity activity, Bundle bundle) {
        super(bd.this);
        this.f7369g = bVar;
        this.f7367e = activity;
        this.f7368f = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = bd.this.q;
        h9Var.onActivityCreated(com.google.android.gms.dynamic.b.Y0(this.f7367e), this.f7368f, this.f7055b);
    }
}