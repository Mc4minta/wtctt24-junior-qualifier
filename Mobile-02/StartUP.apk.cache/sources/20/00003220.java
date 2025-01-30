package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class p implements Parcelable.Creator<d> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        String str = null;
        int i2 = 0;
        long j2 = -1;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 1) {
                str = SafeParcelReader.f(parcel, r);
            } else if (l2 == 2) {
                i2 = SafeParcelReader.t(parcel, r);
            } else if (l2 != 3) {
                SafeParcelReader.x(parcel, r);
            } else {
                j2 = SafeParcelReader.u(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new d(str, i2, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d[] newArray(int i2) {
        return new d[i2];
    }
}