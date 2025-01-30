package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class vc extends j1 implements sc {
    public vc() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.j1
    protected final boolean n(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            l0(parcel.readString(), parcel.readString(), (Bundle) r.a(parcel, Bundle.CREATOR), parcel.readLong());
            parcel2.writeNoException();
        } else if (i2 != 2) {
            return false;
        } else {
            int a = a();
            parcel2.writeNoException();
            parcel2.writeInt(a);
        }
        return true;
    }
}