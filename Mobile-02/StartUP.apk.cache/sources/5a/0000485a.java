package e.g.a.e.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.v;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class k implements Parcelable.Creator<l> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        com.google.android.gms.common.b bVar = null;
        int i2 = 0;
        v vVar = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 1) {
                i2 = SafeParcelReader.t(parcel, r);
            } else if (l2 == 2) {
                bVar = (com.google.android.gms.common.b) SafeParcelReader.e(parcel, r, com.google.android.gms.common.b.CREATOR);
            } else if (l2 != 3) {
                SafeParcelReader.x(parcel, r);
            } else {
                vVar = (v) SafeParcelReader.e(parcel, r, v.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new l(i2, bVar, vVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l[] newArray(int i2) {
        return new l[i2];
    }
}