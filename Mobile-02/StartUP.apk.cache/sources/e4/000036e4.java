package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class t9 implements Parcelable.Creator<q9> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q9 createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        String str = null;
        Long l2 = null;
        Float f2 = null;
        String str2 = null;
        String str3 = null;
        Double d2 = null;
        int i2 = 0;
        long j2 = 0;
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
                    j2 = SafeParcelReader.u(parcel, r);
                    break;
                case 4:
                    l2 = SafeParcelReader.v(parcel, r);
                    break;
                case 5:
                    f2 = SafeParcelReader.q(parcel, r);
                    break;
                case 6:
                    str2 = SafeParcelReader.f(parcel, r);
                    break;
                case 7:
                    str3 = SafeParcelReader.f(parcel, r);
                    break;
                case 8:
                    d2 = SafeParcelReader.o(parcel, r);
                    break;
                default:
                    SafeParcelReader.x(parcel, r);
                    break;
            }
        }
        SafeParcelReader.k(parcel, y);
        return new q9(i2, str, j2, l2, f2, str2, str3, d2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q9[] newArray(int i2) {
        return new q9[i2];
    }
}