package e.g.a.e.h.b;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public abstract class g extends e.g.a.e.d.d.a implements d {
    public g() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // e.g.a.e.d.d.a
    protected boolean Y0(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 3) {
            F0((com.google.android.gms.common.b) e.g.a.e.d.d.c.a(parcel, com.google.android.gms.common.b.CREATOR), (c) e.g.a.e.d.d.c.a(parcel, c.CREATOR));
        } else if (i2 == 4) {
            Y((Status) e.g.a.e.d.d.c.a(parcel, Status.CREATOR));
        } else if (i2 == 6) {
            h0((Status) e.g.a.e.d.d.c.a(parcel, Status.CREATOR));
        } else if (i2 == 7) {
            s((Status) e.g.a.e.d.d.c.a(parcel, Status.CREATOR), (GoogleSignInAccount) e.g.a.e.d.d.c.a(parcel, GoogleSignInAccount.CREATOR));
        } else if (i2 != 8) {
            return false;
        } else {
            I((l) e.g.a.e.d.d.c.a(parcel, l.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}