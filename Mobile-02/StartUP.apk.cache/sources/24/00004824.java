package e.g.a.e.d.h;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public abstract class g extends b implements f {
    public g() {
        super("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
    }

    @Override // e.g.a.e.d.h.b
    protected final boolean n(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            x((Status) c.a(parcel, Status.CREATOR), (e.g.a.e.f.f) c.a(parcel, e.g.a.e.f.f.CREATOR));
        } else if (i2 == 2) {
            f(parcel.readString());
        } else if (i2 == 3) {
            Q((Status) c.a(parcel, Status.CREATOR), (e.g.a.e.f.b) c.a(parcel, e.g.a.e.f.b.CREATOR));
        } else if (i2 == 4) {
            L0((Status) c.a(parcel, Status.CREATOR), c.c(parcel));
        } else if (i2 == 6) {
            b0((Status) c.a(parcel, Status.CREATOR), (e.g.a.e.f.k) c.a(parcel, e.g.a.e.f.k.CREATOR));
        } else if (i2 == 8) {
            y0((Status) c.a(parcel, Status.CREATOR), (e.g.a.e.f.i) c.a(parcel, e.g.a.e.f.i.CREATOR));
        } else if (i2 == 15) {
            A0((Status) c.a(parcel, Status.CREATOR), (e.g.a.e.f.m) c.a(parcel, e.g.a.e.f.m.CREATOR));
        } else if (i2 == 10) {
            z0((Status) c.a(parcel, Status.CREATOR), c.c(parcel));
        } else if (i2 != 11) {
            return false;
        } else {
            o((Status) c.a(parcel, Status.CREATOR));
        }
        return true;
    }
}