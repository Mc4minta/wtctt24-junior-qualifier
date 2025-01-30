package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class s3 extends com.google.android.gms.internal.measurement.j1 implements p3 {
    public s3() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.j1
    protected final boolean n(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                n0((p) com.google.android.gms.internal.measurement.r.a(parcel, p.CREATOR), (z9) com.google.android.gms.internal.measurement.r.a(parcel, z9.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                v0((q9) com.google.android.gms.internal.measurement.r.a(parcel, q9.CREATOR), (z9) com.google.android.gms.internal.measurement.r.a(parcel, z9.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                g0((z9) com.google.android.gms.internal.measurement.r.a(parcel, z9.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                r0((p) com.google.android.gms.internal.measurement.r.a(parcel, p.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                t0((z9) com.google.android.gms.internal.measurement.r.a(parcel, z9.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<q9> f0 = f0((z9) com.google.android.gms.internal.measurement.r.a(parcel, z9.CREATOR), com.google.android.gms.internal.measurement.r.e(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(f0);
                return true;
            case 9:
                byte[] G0 = G0((p) com.google.android.gms.internal.measurement.r.a(parcel, p.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(G0);
                return true;
            case 10:
                R(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String M = M((z9) com.google.android.gms.internal.measurement.r.a(parcel, z9.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(M);
                return true;
            case 12:
                r((ia) com.google.android.gms.internal.measurement.r.a(parcel, ia.CREATOR), (z9) com.google.android.gms.internal.measurement.r.a(parcel, z9.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                m0((ia) com.google.android.gms.internal.measurement.r.a(parcel, ia.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<q9> e0 = e0(parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.r.e(parcel), (z9) com.google.android.gms.internal.measurement.r.a(parcel, z9.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(e0);
                return true;
            case 15:
                List<q9> E = E(parcel.readString(), parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.r.e(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(E);
                return true;
            case 16:
                List<ia> W = W(parcel.readString(), parcel.readString(), (z9) com.google.android.gms.internal.measurement.r.a(parcel, z9.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(W);
                return true;
            case 17:
                List<ia> V = V(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(V);
                return true;
            case 18:
                U((z9) com.google.android.gms.internal.measurement.r.a(parcel, z9.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}