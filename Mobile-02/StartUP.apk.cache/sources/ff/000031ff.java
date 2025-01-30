package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.a;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class q0 extends e.g.a.e.d.e.b implements p0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.p0
    public final com.google.android.gms.dynamic.a b() throws RemoteException {
        Parcel p = p(1, n());
        com.google.android.gms.dynamic.a p2 = a.AbstractBinderC0144a.p(p.readStrongBinder());
        p.recycle();
        return p2;
    }

    @Override // com.google.android.gms.common.internal.p0
    public final int c() throws RemoteException {
        Parcel p = p(2, n());
        int readInt = p.readInt();
        p.recycle();
        return readInt;
    }
}