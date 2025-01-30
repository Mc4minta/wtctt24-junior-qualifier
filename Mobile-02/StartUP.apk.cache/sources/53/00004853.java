package e.g.a.e.h.b;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public interface d extends IInterface {
    void F0(com.google.android.gms.common.b bVar, c cVar) throws RemoteException;

    void I(l lVar) throws RemoteException;

    void Y(Status status) throws RemoteException;

    void h0(Status status) throws RemoteException;

    void s(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;
}