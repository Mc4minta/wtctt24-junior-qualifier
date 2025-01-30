package e.g.a.e.d.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class b implements IInterface {
    private final IBinder a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13144b;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(IBinder iBinder, String str) {
        this.a = iBinder;
        this.f13144b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel n() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f13144b);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel p(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.a.transact(i2, parcel, obtain, 0);
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