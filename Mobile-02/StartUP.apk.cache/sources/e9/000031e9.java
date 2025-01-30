package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class h0 implements Parcelable.Creator<v> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        IBinder iBinder = null;
        com.google.android.gms.common.b bVar = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 1) {
                i2 = SafeParcelReader.t(parcel, r);
            } else if (l2 == 2) {
                iBinder = SafeParcelReader.s(parcel, r);
            } else if (l2 == 3) {
                bVar = (com.google.android.gms.common.b) SafeParcelReader.e(parcel, r, com.google.android.gms.common.b.CREATOR);
            } else if (l2 == 4) {
                z = SafeParcelReader.m(parcel, r);
            } else if (l2 != 5) {
                SafeParcelReader.x(parcel, r);
            } else {
                z2 = SafeParcelReader.m(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new v(i2, iBinder, bVar, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v[] newArray(int i2) {
        return new v[i2];
    }
}