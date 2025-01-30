package e.g.a.e.d.d;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class b implements IInterface {
    private final IBinder a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13143b;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(IBinder iBinder, String str) {
        this.a = iBinder;
        this.f13143b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel n() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f13143b);
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