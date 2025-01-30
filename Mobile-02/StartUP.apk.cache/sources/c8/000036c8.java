package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class r3 extends com.google.android.gms.internal.measurement.a implements p3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final List<q9> E(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel n = n();
        n.writeString(str);
        n.writeString(str2);
        n.writeString(str3);
        com.google.android.gms.internal.measurement.r.d(n, z);
        Parcel p = p(15, n);
        ArrayList createTypedArrayList = p.createTypedArrayList(q9.CREATOR);
        p.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final byte[] G0(p pVar, String str) throws RemoteException {
        Parcel n = n();
        com.google.android.gms.internal.measurement.r.c(n, pVar);
        n.writeString(str);
        Parcel p = p(9, n);
        byte[] createByteArray = p.createByteArray();
        p.recycle();
        return createByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final String M(z9 z9Var) throws RemoteException {
        Parcel n = n();
        com.google.android.gms.internal.measurement.r.c(n, z9Var);
        Parcel p = p(11, n);
        String readString = p.readString();
        p.recycle();
        return readString;
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void R(long j2, String str, String str2, String str3) throws RemoteException {
        Parcel n = n();
        n.writeLong(j2);
        n.writeString(str);
        n.writeString(str2);
        n.writeString(str3);
        q(10, n);
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void U(z9 z9Var) throws RemoteException {
        Parcel n = n();
        com.google.android.gms.internal.measurement.r.c(n, z9Var);
        q(18, n);
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final List<ia> V(String str, String str2, String str3) throws RemoteException {
        Parcel n = n();
        n.writeString(str);
        n.writeString(str2);
        n.writeString(str3);
        Parcel p = p(17, n);
        ArrayList createTypedArrayList = p.createTypedArrayList(ia.CREATOR);
        p.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final List<ia> W(String str, String str2, z9 z9Var) throws RemoteException {
        Parcel n = n();
        n.writeString(str);
        n.writeString(str2);
        com.google.android.gms.internal.measurement.r.c(n, z9Var);
        Parcel p = p(16, n);
        ArrayList createTypedArrayList = p.createTypedArrayList(ia.CREATOR);
        p.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final List<q9> e0(String str, String str2, boolean z, z9 z9Var) throws RemoteException {
        Parcel n = n();
        n.writeString(str);
        n.writeString(str2);
        com.google.android.gms.internal.measurement.r.d(n, z);
        com.google.android.gms.internal.measurement.r.c(n, z9Var);
        Parcel p = p(14, n);
        ArrayList createTypedArrayList = p.createTypedArrayList(q9.CREATOR);
        p.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final List<q9> f0(z9 z9Var, boolean z) throws RemoteException {
        Parcel n = n();
        com.google.android.gms.internal.measurement.r.c(n, z9Var);
        com.google.android.gms.internal.measurement.r.d(n, z);
        Parcel p = p(7, n);
        ArrayList createTypedArrayList = p.createTypedArrayList(q9.CREATOR);
        p.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void g0(z9 z9Var) throws RemoteException {
        Parcel n = n();
        com.google.android.gms.internal.measurement.r.c(n, z9Var);
        q(4, n);
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void m0(ia iaVar) throws RemoteException {
        Parcel n = n();
        com.google.android.gms.internal.measurement.r.c(n, iaVar);
        q(13, n);
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void n0(p pVar, z9 z9Var) throws RemoteException {
        Parcel n = n();
        com.google.android.gms.internal.measurement.r.c(n, pVar);
        com.google.android.gms.internal.measurement.r.c(n, z9Var);
        q(1, n);
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void r(ia iaVar, z9 z9Var) throws RemoteException {
        Parcel n = n();
        com.google.android.gms.internal.measurement.r.c(n, iaVar);
        com.google.android.gms.internal.measurement.r.c(n, z9Var);
        q(12, n);
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void r0(p pVar, String str, String str2) throws RemoteException {
        Parcel n = n();
        com.google.android.gms.internal.measurement.r.c(n, pVar);
        n.writeString(str);
        n.writeString(str2);
        q(5, n);
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void t0(z9 z9Var) throws RemoteException {
        Parcel n = n();
        com.google.android.gms.internal.measurement.r.c(n, z9Var);
        q(6, n);
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void v0(q9 q9Var, z9 z9Var) throws RemoteException {
        Parcel n = n();
        com.google.android.gms.internal.measurement.r.c(n, q9Var);
        com.google.android.gms.internal.measurement.r.c(n, z9Var);
        q(2, n);
    }
}