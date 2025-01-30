package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class u extends e.g.a.e.d.b.d implements v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.v
    public final void B0(t tVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel n = n();
        e.g.a.e.d.b.e.b(n, tVar);
        e.g.a.e.d.b.e.c(n, googleSignInOptions);
        p(102, n);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.v
    public final void D(t tVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel n = n();
        e.g.a.e.d.b.e.b(n, tVar);
        e.g.a.e.d.b.e.c(n, googleSignInOptions);
        p(103, n);
    }
}