package e.g.a.e.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class n implements Parcelable.Creator<m> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ m createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        int i2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 2) {
                i2 = SafeParcelReader.t(parcel, r);
            } else if (l2 != 3) {
                SafeParcelReader.x(parcel, r);
            } else {
                z = SafeParcelReader.m(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new m(i2, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ m[] newArray(int i2) {
        return new m[i2];
    }
}