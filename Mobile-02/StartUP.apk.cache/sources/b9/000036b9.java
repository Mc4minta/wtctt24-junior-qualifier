package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class q implements Parcelable.Creator<o> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            if (SafeParcelReader.l(r) != 2) {
                SafeParcelReader.x(parcel, r);
            } else {
                bundle = SafeParcelReader.a(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new o(bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o[] newArray(int i2) {
        return new o[i2];
    }
}