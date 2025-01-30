package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class n implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 1) {
                i3 = SafeParcelReader.t(parcel, r);
            } else if (l2 == 2) {
                str = SafeParcelReader.f(parcel, r);
            } else if (l2 == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.e(parcel, r, PendingIntent.CREATOR);
            } else if (l2 != 1000) {
                SafeParcelReader.x(parcel, r);
            } else {
                i2 = SafeParcelReader.t(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new Status(i2, i3, str, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i2) {
        return new Status[i2];
    }
}