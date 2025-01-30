package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class tc extends a implements rc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public tc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.rc
    public final void g(Bundle bundle) throws RemoteException {
        Parcel n = n();
        r.c(n, bundle);
        q(1, n);
    }
}