package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class o implements Parcelable.Creator<b> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        int i3 = 0;
        String str = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 1) {
                i2 = SafeParcelReader.t(parcel, r);
            } else if (l2 == 2) {
                i3 = SafeParcelReader.t(parcel, r);
            } else if (l2 == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.e(parcel, r, PendingIntent.CREATOR);
            } else if (l2 != 4) {
                SafeParcelReader.x(parcel, r);
            } else {
                str = SafeParcelReader.f(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new b(i2, i3, pendingIntent, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b[] newArray(int i2) {
        return new b[i2];
    }
}