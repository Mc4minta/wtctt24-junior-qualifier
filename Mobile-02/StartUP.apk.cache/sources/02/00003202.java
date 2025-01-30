package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public abstract class r0 extends e.g.a.e.d.e.a implements p0 {
    public r0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static p0 p(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof p0) {
            return (p0) queryLocalInterface;
        }
        return new q0(iBinder);
    }

    @Override // e.g.a.e.d.e.a
    protected final boolean n(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            com.google.android.gms.dynamic.a b2 = b();
            parcel2.writeNoException();
            e.g.a.e.d.e.c.c(parcel2, b2);
        } else if (i2 != 2) {
            return false;
        } else {
            int c2 = c();
            parcel2.writeNoException();
            parcel2.writeInt(c2);
        }
        return true;
    }
}