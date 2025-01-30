package e.g.a.e.d.a;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public abstract class e extends b implements d {
    public static d n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return queryLocalInterface instanceof d ? (d) queryLocalInterface : new f(iBinder);
    }
}