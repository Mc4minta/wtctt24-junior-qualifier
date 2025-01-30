package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class g extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ ia f7136e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ bd f7137f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(bd bdVar, ia iaVar) {
        super(bdVar);
        this.f7137f = bdVar;
        this.f7136e = iaVar;
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    final void a() throws RemoteException {
        h9 h9Var;
        h9Var = this.f7137f.q;
        h9Var.getGmpAppId(this.f7136e);
    }

    @Override // com.google.android.gms.internal.measurement.bd.a
    protected final void b() {
        this.f7136e.g(null);
    }
}