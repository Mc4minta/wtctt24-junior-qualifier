package e.g.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class e implements Parcelable.Creator<d> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        long j2 = 0;
        long j3 = 0;
        boolean z = false;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 1) {
                z = SafeParcelReader.m(parcel, r);
            } else if (l2 == 2) {
                j3 = SafeParcelReader.u(parcel, r);
            } else if (l2 != 3) {
                SafeParcelReader.x(parcel, r);
            } else {
                j2 = SafeParcelReader.u(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new d(z, j2, j3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d[] newArray(int i2) {
        return new d[i2];
    }
}