package e.g.a.e.d.a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class f extends a implements d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // e.g.a.e.d.a.d
    public final String getId() throws RemoteException {
        Parcel p = p(1, n());
        String readString = p.readString();
        p.recycle();
        return readString;
    }

    @Override // e.g.a.e.d.a.d
    public final boolean j(boolean z) throws RemoteException {
        Parcel n = n();
        c.a(n, true);
        Parcel p = p(2, n);
        boolean b2 = c.b(p);
        p.recycle();
        return b2;
    }
}