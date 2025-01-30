package e.g.a.e.h.b;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class h extends e.g.a.e.d.d.b implements f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // e.g.a.e.h.b.f
    public final void P0(j jVar, d dVar) throws RemoteException {
        Parcel n = n();
        e.g.a.e.d.d.c.c(n, jVar);
        e.g.a.e.d.d.c.b(n, dVar);
        p(12, n);
    }
}