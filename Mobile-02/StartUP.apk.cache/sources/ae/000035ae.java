package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
final class w extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Activity f7381e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ bd.b f7382f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(bd.b bVar, Activity activity) {
        super(bd.this);
        this.f7382f = bVar;
        this.f7381e = activity;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = bd.this.q;
        h9Var.onActivityPaused(com.google.android.gms.dynamic.b.Y0(this.f7381e), this.f7055b);
    }
}