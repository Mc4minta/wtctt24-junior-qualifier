package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.a;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class k extends e.g.a.e.d.e.b implements l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.l
    public final com.google.android.gms.dynamic.a A(com.google.android.gms.dynamic.a aVar, String str, int i2, com.google.android.gms.dynamic.a aVar2) throws RemoteException {
        Parcel n = n();
        e.g.a.e.d.e.c.c(n, aVar);
        n.writeString(str);
        n.writeInt(i2);
        e.g.a.e.d.e.c.c(n, aVar2);
        Parcel p = p(2, n);
        com.google.android.gms.dynamic.a p2 = a.AbstractBinderC0144a.p(p.readStrongBinder());
        p.recycle();
        return p2;
    }

    @Override // com.google.android.gms.dynamite.l
    public final com.google.android.gms.dynamic.a B(com.google.android.gms.dynamic.a aVar, String str, int i2, com.google.android.gms.dynamic.a aVar2) throws RemoteException {
        Parcel n = n();
        e.g.a.e.d.e.c.c(n, aVar);
        n.writeString(str);
        n.writeInt(i2);
        e.g.a.e.d.e.c.c(n, aVar2);
        Parcel p = p(3, n);
        com.google.android.gms.dynamic.a p2 = a.AbstractBinderC0144a.p(p.readStrongBinder());
        p.recycle();
        return p2;
    }
}