package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class d implements Parcelable.Creator<a> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        int i2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 1) {
                i2 = SafeParcelReader.t(parcel, r);
            } else if (l2 == 2) {
                i3 = SafeParcelReader.t(parcel, r);
            } else if (l2 != 3) {
                SafeParcelReader.x(parcel, r);
            } else {
                bundle = SafeParcelReader.a(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new a(i2, i3, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i2) {
        return new a[i2];
    }
}