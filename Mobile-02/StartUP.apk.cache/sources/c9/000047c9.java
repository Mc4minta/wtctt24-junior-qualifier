package e.g.a.d.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import e.g.a.a.b;
import e.g.a.a.c;

/* compiled from: IGetInstallReferrerService.java */
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* compiled from: IGetInstallReferrerService.java */
    /* renamed from: e.g.a.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0297a extends b implements a {

        /* compiled from: IGetInstallReferrerService.java */
        /* renamed from: e.g.a.d.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0298a extends e.g.a.a.a implements a {
            C0298a(IBinder iBinder) {
                super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            }

            @Override // e.g.a.d.a.a
            public final Bundle z(Bundle bundle) throws RemoteException {
                Parcel n = n();
                c.b(n, bundle);
                Parcel p = p(n);
                Bundle bundle2 = (Bundle) c.a(p, Bundle.CREATOR);
                p.recycle();
                return bundle2;
            }
        }

        public static a n(IBinder iBinder) {
            if (iBinder != null) {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                if (queryLocalInterface instanceof a) {
                    return (a) queryLocalInterface;
                }
                return new C0298a(iBinder);
            }
            return null;
        }
    }

    Bundle z(Bundle bundle) throws RemoteException;
}