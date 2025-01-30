package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class i extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ ia f7172e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ bd f7173f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(bd bdVar, ia iaVar) {
        super(bdVar);
        this.f7173f = bdVar;
        this.f7172e = iaVar;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = this.f7173f.q;
        h9Var.getCachedAppInstanceId(this.f7172e);
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    protected final void b() {
        this.f7172e.g(null);
    }
}