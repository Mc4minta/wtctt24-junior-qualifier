package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class f extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f7117e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ bd f7118f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(bd bdVar, String str) {
        super(bdVar);
        this.f7118f = bdVar;
        this.f7117e = str;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = this.f7118f.q;
        h9Var.beginAdUnitExposure(this.f7117e, this.f7055b);
    }
}