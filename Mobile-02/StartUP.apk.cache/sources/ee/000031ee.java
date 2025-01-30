package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class j0 implements Parcelable.Creator<i0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i0 createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        Bundle bundle = null;
        int i2 = 0;
        com.google.android.gms.common.d[] dVarArr = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 1) {
                bundle = SafeParcelReader.a(parcel, r);
            } else if (l2 == 2) {
                dVarArr = (com.google.android.gms.common.d[]) SafeParcelReader.i(parcel, r, com.google.android.gms.common.d.CREATOR);
            } else if (l2 != 3) {
                SafeParcelReader.x(parcel, r);
            } else {
                i2 = SafeParcelReader.t(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new i0(bundle, dVarArr, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i0[] newArray(int i2) {
        return new i0[i2];
    }
}