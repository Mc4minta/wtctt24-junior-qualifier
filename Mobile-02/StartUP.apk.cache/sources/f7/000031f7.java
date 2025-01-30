package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public interface n extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public static abstract class a extends e.g.a.e.d.e.a implements n {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // e.g.a.e.d.e.a
        protected final boolean n(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                a0(parcel.readInt(), parcel.readStrongBinder(), (Bundle) e.g.a.e.d.e.c.b(parcel, Bundle.CREATOR));
            } else if (i2 == 2) {
                X(parcel.readInt(), (Bundle) e.g.a.e.d.e.c.b(parcel, Bundle.CREATOR));
            } else if (i2 != 3) {
                return false;
            } else {
                Z(parcel.readInt(), parcel.readStrongBinder(), (i0) e.g.a.e.d.e.c.b(parcel, i0.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void X(int i2, Bundle bundle) throws RemoteException;

    void Z(int i2, IBinder iBinder, i0 i0Var) throws RemoteException;

    void a0(int i2, IBinder iBinder, Bundle bundle) throws RemoteException;
}