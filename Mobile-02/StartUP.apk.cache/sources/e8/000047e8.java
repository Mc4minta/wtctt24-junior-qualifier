package e.g.a.e.d.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public class d implements IInterface {
    private final IBinder a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13131b;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(IBinder iBinder, String str) {
        this.a = iBinder;
        this.f13131b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel n() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f13131b);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.a.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}