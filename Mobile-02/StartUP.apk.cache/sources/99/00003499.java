package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class e extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f7101e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ bd f7102f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(bd bdVar, String str) {
        super(bdVar);
        this.f7102f = bdVar;
        this.f7101e = str;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = this.f7102f.q;
        h9Var.endAdUnitExposure(this.f7101e, this.f7055b);
    }
}