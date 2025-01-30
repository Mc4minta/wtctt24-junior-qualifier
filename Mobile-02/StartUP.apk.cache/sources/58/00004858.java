package e.g.a.e.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.u;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class i implements Parcelable.Creator<j> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        int i2 = 0;
        u uVar = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 1) {
                i2 = SafeParcelReader.t(parcel, r);
            } else if (l2 != 2) {
                SafeParcelReader.x(parcel, r);
            } else {
                uVar = (u) SafeParcelReader.e(parcel, r, u.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new j(i2, uVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j[] newArray(int i2) {
        return new j[i2];
    }
}