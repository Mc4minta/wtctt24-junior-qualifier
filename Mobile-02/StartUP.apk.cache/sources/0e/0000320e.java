package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class u0 extends e.g.a.e.d.e.b implements t0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.t0
    public final boolean I0(com.google.android.gms.common.x xVar, com.google.android.gms.dynamic.a aVar) throws RemoteException {
        Parcel n = n();
        e.g.a.e.d.e.c.d(n, xVar);
        e.g.a.e.d.e.c.c(n, aVar);
        Parcel p = p(5, n);
        boolean e2 = e.g.a.e.d.e.c.e(p);
        p.recycle();
        return e2;
    }
}