package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class la implements Parcelable.Creator<ia> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ia createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = null;
        String str2 = null;
        q9 q9Var = null;
        String str3 = null;
        p pVar = null;
        p pVar2 = null;
        p pVar3 = null;
        boolean z = false;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            switch (SafeParcelReader.l(r)) {
                case 2:
                    str = SafeParcelReader.f(parcel, r);
                    break;
                case 3:
                    str2 = SafeParcelReader.f(parcel, r);
                    break;
                case 4:
                    q9Var = (q9) SafeParcelReader.e(parcel, r, q9.CREATOR);
                    break;
                case 5:
                    j2 = SafeParcelReader.u(parcel, r);
                    break;
                case 6:
                    z = SafeParcelReader.m(parcel, r);
                    break;
                case 7:
                    str3 = SafeParcelReader.f(parcel, r);
                    break;
                case 8:
                    pVar = (p) SafeParcelReader.e(parcel, r, p.CREATOR);
                    break;
                case 9:
                    j3 = SafeParcelReader.u(parcel, r);
                    break;
                case 10:
                    pVar2 = (p) SafeParcelReader.e(parcel, r, p.CREATOR);
                    break;
                case 11:
                    j4 = SafeParcelReader.u(parcel, r);
                    break;
                case 12:
                    pVar3 = (p) SafeParcelReader.e(parcel, r, p.CREATOR);
                    break;
                default:
                    SafeParcelReader.x(parcel, r);
                    break;
            }
        }
        SafeParcelReader.k(parcel, y);
        return new ia(str, str2, q9Var, j2, z, str3, pVar, j3, pVar2, j4, pVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ia[] newArray(int i2) {
        return new ia[i2];
    }
}