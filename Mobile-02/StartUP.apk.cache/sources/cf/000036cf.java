package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class s implements Parcelable.Creator<p> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        String str = null;
        o oVar = null;
        String str2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 2) {
                str = SafeParcelReader.f(parcel, r);
            } else if (l2 == 3) {
                oVar = (o) SafeParcelReader.e(parcel, r, o.CREATOR);
            } else if (l2 == 4) {
                str2 = SafeParcelReader.f(parcel, r);
            } else if (l2 != 5) {
                SafeParcelReader.x(parcel, r);
            } else {
                j2 = SafeParcelReader.u(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new p(str, oVar, str2, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p[] newArray(int i2) {
        return new p[i2];
    }
}