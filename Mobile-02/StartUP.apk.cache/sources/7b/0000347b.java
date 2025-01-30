package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class c extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f7058e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f7059f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ Bundle f7060g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ bd f7061h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(bd bdVar, String str, String str2, Bundle bundle) {
        super(bdVar);
        this.f7061h = bdVar;
        this.f7058e = str;
        this.f7059f = str2;
        this.f7060g = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = this.f7061h.q;
        h9Var.clearConditionalUserProperty(this.f7058e, this.f7059f, this.f7060g);
    }
}