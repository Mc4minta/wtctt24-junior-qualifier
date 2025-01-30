package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public abstract class s extends e.g.a.e.d.b.c implements t {
    public s() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // e.g.a.e.d.b.c
    protected final boolean n(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 101:
                P((GoogleSignInAccount) e.g.a.e.d.b.e.a(parcel, GoogleSignInAccount.CREATOR), (Status) e.g.a.e.d.b.e.a(parcel, Status.CREATOR));
                break;
            case 102:
                u((Status) e.g.a.e.d.b.e.a(parcel, Status.CREATOR));
                break;
            case 103:
                G((Status) e.g.a.e.d.b.e.a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}