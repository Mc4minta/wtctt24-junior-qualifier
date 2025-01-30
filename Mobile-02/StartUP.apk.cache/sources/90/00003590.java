package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
final class u extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Activity f7355e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ bd.b f7356f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(bd.b bVar, Activity activity) {
        super(bd.this);
        this.f7356f = bVar;
        this.f7355e = activity;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = bd.this.q;
        h9Var.onActivityStarted(com.google.android.gms.dynamic.b.Y0(this.f7355e), this.f7055b);
    }
}