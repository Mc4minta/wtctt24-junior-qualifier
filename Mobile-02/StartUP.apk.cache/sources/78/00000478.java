package b.a.a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import b.a.a.a;
import java.util.List;

/* compiled from: ICustomTabsService.java */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: ICustomTabsService.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "android.support.customtabs.ICustomTabsService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1598968902) {
                switch (i2) {
                    case 2:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        boolean T = T(parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(T ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        boolean p0 = p0(a.AbstractBinderC0046a.n(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(p0 ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        boolean w = w(a.AbstractBinderC0046a.n(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.createTypedArrayList(Bundle.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(w ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        Bundle N = N(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        if (N != null) {
                            parcel2.writeInt(1);
                            N.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        boolean x0 = x0(a.AbstractBinderC0046a.n(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(x0 ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        boolean C0 = C0(a.AbstractBinderC0046a.n(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(C0 ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        int j0 = j0(a.AbstractBinderC0046a.n(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(j0);
                        return true;
                    case 9:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        boolean y = y(a.AbstractBinderC0046a.n(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(y ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            }
            parcel2.writeString("android.support.customtabs.ICustomTabsService");
            return true;
        }
    }

    boolean C0(b.a.a.a aVar, Uri uri) throws RemoteException;

    Bundle N(String str, Bundle bundle) throws RemoteException;

    boolean T(long j2) throws RemoteException;

    int j0(b.a.a.a aVar, String str, Bundle bundle) throws RemoteException;

    boolean p0(b.a.a.a aVar) throws RemoteException;

    boolean w(b.a.a.a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException;

    boolean x0(b.a.a.a aVar, Bundle bundle) throws RemoteException;

    boolean y(b.a.a.a aVar, int i2, Uri uri, Bundle bundle) throws RemoteException;
}