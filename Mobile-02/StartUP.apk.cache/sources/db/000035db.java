package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class yc implements Parcelable.Creator<zc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zc createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        boolean z = false;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            switch (SafeParcelReader.l(r)) {
                case 1:
                    j2 = SafeParcelReader.u(parcel, r);
                    break;
                case 2:
                    j3 = SafeParcelReader.u(parcel, r);
                    break;
                case 3:
                    z = SafeParcelReader.m(parcel, r);
                    break;
                case 4:
                    str = SafeParcelReader.f(parcel, r);
                    break;
                case 5:
                    str2 = SafeParcelReader.f(parcel, r);
                    break;
                case 6:
                    str3 = SafeParcelReader.f(parcel, r);
                    break;
                case 7:
                    bundle = SafeParcelReader.a(parcel, r);
                    break;
                default:
                    SafeParcelReader.x(parcel, r);
                    break;
            }
        }
        SafeParcelReader.k(parcel, y);
        return new zc(j2, j3, z, str, str2, str3, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zc[] newArray(int i2) {
        return new zc[i2];
    }
}