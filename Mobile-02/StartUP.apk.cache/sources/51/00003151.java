package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class f implements Parcelable.Creator<TokenData> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TokenData createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        String str = null;
        Long l2 = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            switch (SafeParcelReader.l(r)) {
                case 1:
                    i2 = SafeParcelReader.t(parcel, r);
                    break;
                case 2:
                    str = SafeParcelReader.f(parcel, r);
                    break;
                case 3:
                    l2 = SafeParcelReader.v(parcel, r);
                    break;
                case 4:
                    z = SafeParcelReader.m(parcel, r);
                    break;
                case 5:
                    z2 = SafeParcelReader.m(parcel, r);
                    break;
                case 6:
                    arrayList = SafeParcelReader.h(parcel, r);
                    break;
                case 7:
                    str2 = SafeParcelReader.f(parcel, r);
                    break;
                default:
                    SafeParcelReader.x(parcel, r);
                    break;
            }
        }
        SafeParcelReader.k(parcel, y);
        return new TokenData(i2, str, l2, z, z2, arrayList, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TokenData[] newArray(int i2) {
        return new TokenData[i2];
    }
}