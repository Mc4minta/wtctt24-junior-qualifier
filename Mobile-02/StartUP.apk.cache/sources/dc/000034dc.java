package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class i4 extends a implements k2 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i4(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.k2
    public final Bundle g(Bundle bundle) throws RemoteException {
        Parcel n = n();
        r.c(n, bundle);
        Parcel p = p(1, n);
        Bundle bundle2 = (Bundle) r.a(p, Bundle.CREATOR);
        p.recycle();
        return bundle2;
    }
}