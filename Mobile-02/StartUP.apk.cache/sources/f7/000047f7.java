package e.g.a.e.d.c;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public abstract class j extends g implements i {
    public static i n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.auth.IAuthManagerService");
        if (queryLocalInterface instanceof i) {
            return (i) queryLocalInterface;
        }
        return new k(iBinder);
    }
}