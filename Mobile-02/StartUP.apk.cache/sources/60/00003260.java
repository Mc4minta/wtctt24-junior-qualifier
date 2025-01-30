package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.a;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class i extends e.g.a.e.d.e.b implements j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.j
    public final int J0() throws RemoteException {
        Parcel p = p(6, n());
        int readInt = p.readInt();
        p.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.j
    public final com.google.android.gms.dynamic.a O(com.google.android.gms.dynamic.a aVar, String str, int i2) throws RemoteException {
        Parcel n = n();
        e.g.a.e.d.e.c.c(n, aVar);
        n.writeString(str);
        n.writeInt(i2);
        Parcel p = p(2, n);
        com.google.android.gms.dynamic.a p2 = a.AbstractBinderC0144a.p(p.readStrongBinder());
        p.recycle();
        return p2;
    }

    @Override // com.google.android.gms.dynamite.j
    public final int c0(com.google.android.gms.dynamic.a aVar, String str, boolean z) throws RemoteException {
        Parcel n = n();
        e.g.a.e.d.e.c.c(n, aVar);
        n.writeString(str);
        e.g.a.e.d.e.c.a(n, z);
        Parcel p = p(5, n);
        int readInt = p.readInt();
        p.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.j
    public final int s0(com.google.android.gms.dynamic.a aVar, String str, boolean z) throws RemoteException {
        Parcel n = n();
        e.g.a.e.d.e.c.c(n, aVar);
        n.writeString(str);
        e.g.a.e.d.e.c.a(n, z);
        Parcel p = p(3, n);
        int readInt = p.readInt();
        p.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.j
    public final com.google.android.gms.dynamic.a u0(com.google.android.gms.dynamic.a aVar, String str, int i2) throws RemoteException {
        Parcel n = n();
        e.g.a.e.d.e.c.c(n, aVar);
        n.writeString(str);
        n.writeInt(i2);
        Parcel p = p(4, n);
        com.google.android.gms.dynamic.a p2 = a.AbstractBinderC0144a.p(p.readStrongBinder());
        p.recycle();
        return p2;
    }
}