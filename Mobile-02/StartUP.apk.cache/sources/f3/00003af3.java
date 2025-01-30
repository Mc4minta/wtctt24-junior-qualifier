package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class h1 implements i1 {
    private final IBinder a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h1(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // com.google.firebase.iid.i1
    public final void H0(Message message) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
        obtain.writeInt(1);
        message.writeToParcel(obtain, 0);
        try {
            this.a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}