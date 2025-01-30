package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
public final class u implements Parcelable.Creator<b> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b createFromParcel(Parcel parcel) {
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
        return new b(bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b[] newArray(int i2) {
        return new b[i2];
    }
}