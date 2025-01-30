package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes2.dex */
public abstract class o5 extends y implements n5 {
    public o5() {
        super("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
    }

    @Override // com.google.android.gms.internal.clearcut.y
    protected final boolean n(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                o((Status) x0.a(parcel, Status.CREATOR));
                return true;
            case 2:
                D0((Status) x0.a(parcel, Status.CREATOR));
                return true;
            case 3:
                v((Status) x0.a(parcel, Status.CREATOR), parcel.readLong());
                return true;
            case 4:
                Q0((Status) x0.a(parcel, Status.CREATOR));
                return true;
            case 5:
                T0((Status) x0.a(parcel, Status.CREATOR), parcel.readLong());
                return true;
            case 6:
                k0((Status) x0.a(parcel, Status.CREATOR), (e.g.a.e.c.f[]) parcel.createTypedArray(e.g.a.e.c.f.CREATOR));
                return true;
            case 7:
                C((DataHolder) x0.a(parcel, DataHolder.CREATOR));
                return true;
            case 8:
                o0((Status) x0.a(parcel, Status.CREATOR), (e.g.a.e.c.d) x0.a(parcel, e.g.a.e.c.d.CREATOR));
                return true;
            case 9:
                R0((Status) x0.a(parcel, Status.CREATOR), (e.g.a.e.c.d) x0.a(parcel, e.g.a.e.c.d.CREATOR));
                return true;
            default:
                return false;
        }
    }
}