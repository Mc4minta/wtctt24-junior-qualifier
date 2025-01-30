package e.g.a.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: BaseProxy.java */
/* loaded from: classes2.dex */
public class a implements IInterface {
    private final IBinder a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12912b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder, String str) {
        this.a = iBinder;
        this.f12912b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel n() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f12912b);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel p(Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.a.transact(1, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e2) {
                obtain.recycle();
                throw e2;
            }
        } finally {
            parcel.recycle();
        }
    }
}