package e.g.a.e.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class j implements Parcelable.Creator<i> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        int i2 = 0;
        boolean z = false;
        long j2 = 0;
        a[] aVarArr = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 2) {
                j2 = SafeParcelReader.u(parcel, r);
            } else if (l2 == 3) {
                aVarArr = (a[]) SafeParcelReader.i(parcel, r, a.CREATOR);
            } else if (l2 == 4) {
                i2 = SafeParcelReader.t(parcel, r);
            } else if (l2 != 5) {
                SafeParcelReader.x(parcel, r);
            } else {
                z = SafeParcelReader.m(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new i(j2, aVarArr, i2, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i[] newArray(int i2) {
        return new i[i2];
    }
}