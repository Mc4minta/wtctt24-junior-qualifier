package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
final class m extends f {
    private final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(n nVar) {
        this.a = nVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.f, com.google.android.gms.auth.api.signin.internal.t
    public final void G(Status status) throws RemoteException {
        this.a.f(status);
    }
}