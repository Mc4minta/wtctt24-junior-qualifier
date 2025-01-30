package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public interface t extends IInterface {
    void G(Status status) throws RemoteException;

    void P(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException;

    void u(Status status) throws RemoteException;
}