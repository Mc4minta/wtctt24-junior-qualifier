package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class y9 implements Parcelable.Creator<z9> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z9 createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = true;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str8 = null;
        long j7 = -2147483648L;
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
                    str3 = SafeParcelReader.f(parcel, r);
                    break;
                case 5:
                    str4 = SafeParcelReader.f(parcel, r);
                    break;
                case 6:
                    j2 = SafeParcelReader.u(parcel, r);
                    break;
                case 7:
                    j3 = SafeParcelReader.u(parcel, r);
                    break;
                case 8:
                    str5 = SafeParcelReader.f(parcel, r);
                    break;
                case 9:
                    z3 = SafeParcelReader.m(parcel, r);
                    break;
                case 10:
                    z = SafeParcelReader.m(parcel, r);
                    break;
                case 11:
                    j7 = SafeParcelReader.u(parcel, r);
                    break;
                case 12:
                    str6 = SafeParcelReader.f(parcel, r);
                    break;
                case 13:
                    j4 = SafeParcelReader.u(parcel, r);
                    break;
                case 14:
                    j5 = SafeParcelReader.u(parcel, r);
                    break;
                case 15:
                    i2 = SafeParcelReader.t(parcel, r);
                    break;
                case 16:
                    z4 = SafeParcelReader.m(parcel, r);
                    break;
                case 17:
                    z5 = SafeParcelReader.m(parcel, r);
                    break;
                case 18:
                    z2 = SafeParcelReader.m(parcel, r);
                    break;
                case 19:
                    str7 = SafeParcelReader.f(parcel, r);
                    break;
                case 20:
                default:
                    SafeParcelReader.x(parcel, r);
                    break;
                case 21:
                    bool = SafeParcelReader.n(parcel, r);
                    break;
                case 22:
                    j6 = SafeParcelReader.u(parcel, r);
                    break;
                case 23:
                    arrayList = SafeParcelReader.h(parcel, r);
                    break;
                case 24:
                    str8 = SafeParcelReader.f(parcel, r);
                    break;
            }
        }
        SafeParcelReader.k(parcel, y);
        return new z9(str, str2, str3, str4, j2, j3, str5, z3, z, j7, str6, j4, j5, i2, z4, z5, z2, str7, bool, j6, arrayList, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z9[] newArray(int i2) {
        return new z9[i2];
    }
}