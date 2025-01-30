package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class uc extends a implements sc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public uc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.sc
    public final int a() throws RemoteException {
        Parcel p = p(2, n());
        int readInt = p.readInt();
        p.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.measurement.sc
    public final void l0(String str, String str2, Bundle bundle, long j2) throws RemoteException {
        Parcel n = n();
        n.writeString(str);
        n.writeString(str2);
        r.c(n, bundle);
        n.writeLong(j2);
        q(1, n);
    }
}