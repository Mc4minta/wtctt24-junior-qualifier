package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class u5 implements Parcelable.Creator<t5> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ t5 createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z2 = true;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            switch (SafeParcelReader.l(r)) {
                case 2:
                    str = SafeParcelReader.f(parcel, r);
                    break;
                case 3:
                    i2 = SafeParcelReader.t(parcel, r);
                    break;
                case 4:
                    i3 = SafeParcelReader.t(parcel, r);
                    break;
                case 5:
                    str2 = SafeParcelReader.f(parcel, r);
                    break;
                case 6:
                    str3 = SafeParcelReader.f(parcel, r);
                    break;
                case 7:
                    z2 = SafeParcelReader.m(parcel, r);
                    break;
                case 8:
                    str4 = SafeParcelReader.f(parcel, r);
                    break;
                case 9:
                    z = SafeParcelReader.m(parcel, r);
                    break;
                case 10:
                    i4 = SafeParcelReader.t(parcel, r);
                    break;
                default:
                    SafeParcelReader.x(parcel, r);
                    break;
            }
        }
        SafeParcelReader.k(parcel, y);
        return new t5(str, i2, i3, str2, str3, z2, str4, z, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ t5[] newArray(int i2) {
        return new t5[i2];
    }
}