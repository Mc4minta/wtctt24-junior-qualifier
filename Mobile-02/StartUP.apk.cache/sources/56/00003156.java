package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class a0 implements Parcelable.Creator<x> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        boolean z = false;
        String str = null;
        IBinder iBinder = null;
        boolean z2 = false;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 1) {
                str = SafeParcelReader.f(parcel, r);
            } else if (l2 == 2) {
                iBinder = SafeParcelReader.s(parcel, r);
            } else if (l2 == 3) {
                z = SafeParcelReader.m(parcel, r);
            } else if (l2 != 4) {
                SafeParcelReader.x(parcel, r);
            } else {
                z2 = SafeParcelReader.m(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new x(str, iBinder, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x[] newArray(int i2) {
        return new x[i2];
    }
}