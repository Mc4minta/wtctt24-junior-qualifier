package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class jb extends a implements h9 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public jb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void beginAdUnitExposure(String str, long j2) throws RemoteException {
        Parcel n = n();
        n.writeString(str);
        n.writeLong(j2);
        q(23, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel n = n();
        n.writeString(str);
        n.writeString(str2);
        r.c(n, bundle);
        q(9, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void endAdUnitExposure(String str, long j2) throws RemoteException {
        Parcel n = n();
        n.writeString(str);
        n.writeLong(j2);
        q(24, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void generateEventId(rc rcVar) throws RemoteException {
        Parcel n = n();
        r.b(n, rcVar);
        q(22, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void getCachedAppInstanceId(rc rcVar) throws RemoteException {
        Parcel n = n();
        r.b(n, rcVar);
        q(19, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void getConditionalUserProperties(String str, String str2, rc rcVar) throws RemoteException {
        Parcel n = n();
        n.writeString(str);
        n.writeString(str2);
        r.b(n, rcVar);
        q(10, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void getCurrentScreenClass(rc rcVar) throws RemoteException {
        Parcel n = n();
        r.b(n, rcVar);
        q(17, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void getCurrentScreenName(rc rcVar) throws RemoteException {
        Parcel n = n();
        r.b(n, rcVar);
        q(16, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void getGmpAppId(rc rcVar) throws RemoteException {
        Parcel n = n();
        r.b(n, rcVar);
        q(21, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void getMaxUserProperties(String str, rc rcVar) throws RemoteException {
        Parcel n = n();
        n.writeString(str);
        r.b(n, rcVar);
        q(6, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void getUserProperties(String str, String str2, boolean z, rc rcVar) throws RemoteException {
        Parcel n = n();
        n.writeString(str);
        n.writeString(str2);
        r.d(n, z);
        r.b(n, rcVar);
        q(5, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void initialize(com.google.android.gms.dynamic.a aVar, zc zcVar, long j2) throws RemoteException {
        Parcel n = n();
        r.b(n, aVar);
        r.c(n, zcVar);
        n.writeLong(j2);
        q(1, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) throws RemoteException {
        Parcel n = n();
        n.writeString(str);
        n.writeString(str2);
        r.c(n, bundle);
        r.d(n, z);
        r.d(n, z2);
        n.writeLong(j2);
        q(2, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void logHealthData(int i2, String str, com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2, com.google.android.gms.dynamic.a aVar3) throws RemoteException {
        Parcel n = n();
        n.writeInt(i2);
        n.writeString(str);
        r.b(n, aVar);
        r.b(n, aVar2);
        r.b(n, aVar3);
        q(33, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void onActivityCreated(com.google.android.gms.dynamic.a aVar, Bundle bundle, long j2) throws RemoteException {
        Parcel n = n();
        r.b(n, aVar);
        r.c(n, bundle);
        n.writeLong(j2);
        q(27, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void onActivityDestroyed(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        Parcel n = n();
        r.b(n, aVar);
        n.writeLong(j2);
        q(28, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void onActivityPaused(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        Parcel n = n();
        r.b(n, aVar);
        n.writeLong(j2);
        q(29, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void onActivityResumed(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        Parcel n = n();
        r.b(n, aVar);
        n.writeLong(j2);
        q(30, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void onActivitySaveInstanceState(com.google.android.gms.dynamic.a aVar, rc rcVar, long j2) throws RemoteException {
        Parcel n = n();
        r.b(n, aVar);
        r.b(n, rcVar);
        n.writeLong(j2);
        q(31, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void onActivityStarted(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        Parcel n = n();
        r.b(n, aVar);
        n.writeLong(j2);
        q(25, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void onActivityStopped(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        Parcel n = n();
        r.b(n, aVar);
        n.writeLong(j2);
        q(26, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void registerOnMeasurementEventListener(sc scVar) throws RemoteException {
        Parcel n = n();
        r.b(n, scVar);
        q(35, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void setConditionalUserProperty(Bundle bundle, long j2) throws RemoteException {
        Parcel n = n();
        r.c(n, bundle);
        n.writeLong(j2);
        q(8, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void setCurrentScreen(com.google.android.gms.dynamic.a aVar, String str, String str2, long j2) throws RemoteException {
        Parcel n = n();
        r.b(n, aVar);
        n.writeString(str);
        n.writeString(str2);
        n.writeLong(j2);
        q(15, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel n = n();
        r.d(n, z);
        q(39, n);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public final void setUserProperty(String str, String str2, com.google.android.gms.dynamic.a aVar, boolean z, long j2) throws RemoteException {
        Parcel n = n();
        n.writeString(str);
        n.writeString(str2);
        r.b(n, aVar);
        r.d(n, z);
        n.writeLong(j2);
        q(4, n);
    }
}