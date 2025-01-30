package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class l extends p<Status> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public l(com.google.android.gms.common.api.d dVar) {
        super(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ com.google.android.gms.common.api.i c(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.d
    protected final /* synthetic */ void n(j jVar) throws RemoteException {
        j jVar2 = jVar;
        ((v) jVar2.B()).B0(new k(this), jVar2.m0());
    }
}