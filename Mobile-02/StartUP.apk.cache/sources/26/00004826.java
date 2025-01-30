package e.g.a.e.d.h;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class i extends a implements h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.safetynet.internal.ISafetyNetService");
    }

    @Override // e.g.a.e.d.h.h
    public final void E0(f fVar) throws RemoteException {
        Parcel n = n();
        c.b(n, fVar);
        p(4, n);
    }

    @Override // e.g.a.e.d.h.h
    public final void N0(f fVar) throws RemoteException {
        Parcel n = n();
        c.b(n, fVar);
        p(14, n);
    }
}