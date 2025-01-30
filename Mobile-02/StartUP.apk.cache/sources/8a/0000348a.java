package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class d extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Activity f7084e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f7085f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ String f7086g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ bd f7087h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(bd bdVar, Activity activity, String str, String str2) {
        super(bdVar);
        this.f7087h = bdVar;
        this.f7084e = activity;
        this.f7085f = str;
        this.f7086g = str2;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = this.f7087h.q;
        h9Var.setCurrentScreen(com.google.android.gms.dynamic.b.Y0(this.f7084e), this.f7085f, this.f7086g, this.a);
    }
}