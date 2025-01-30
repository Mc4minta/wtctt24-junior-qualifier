package e.g.a.e.d.c;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class k extends a implements i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(IBinder iBinder) {
        super(iBinder, "com.google.android.auth.IAuthManagerService");
    }

    @Override // e.g.a.e.d.c.i
    public final Bundle M0(Account account, String str, Bundle bundle) throws RemoteException {
        Parcel n = n();
        h.b(n, account);
        n.writeString(str);
        h.b(n, bundle);
        Parcel p = p(5, n);
        Bundle bundle2 = (Bundle) h.a(p, Bundle.CREATOR);
        p.recycle();
        return bundle2;
    }
}