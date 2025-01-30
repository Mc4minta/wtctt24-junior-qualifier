package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public interface v extends IInterface {
    void B0(t tVar, GoogleSignInOptions googleSignInOptions) throws RemoteException;

    void D(t tVar, GoogleSignInOptions googleSignInOptions) throws RemoteException;
}