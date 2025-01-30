package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
final class o implements p {
    private final IBinder a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // com.google.android.gms.common.internal.p
    public final void H(n nVar, g gVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(nVar != null ? nVar.asBinder() : null);
            if (gVar != null) {
                obtain.writeInt(1);
                gVar.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}