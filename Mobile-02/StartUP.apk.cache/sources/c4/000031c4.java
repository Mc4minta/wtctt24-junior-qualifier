package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator<DataHolder> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        int i2 = 0;
        int i3 = 0;
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 1) {
                strArr = SafeParcelReader.g(parcel, r);
            } else if (l2 == 2) {
                cursorWindowArr = (CursorWindow[]) SafeParcelReader.i(parcel, r, CursorWindow.CREATOR);
            } else if (l2 == 3) {
                i3 = SafeParcelReader.t(parcel, r);
            } else if (l2 == 4) {
                bundle = SafeParcelReader.a(parcel, r);
            } else if (l2 != 1000) {
                SafeParcelReader.x(parcel, r);
            } else {
                i2 = SafeParcelReader.t(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i3, bundle);
        dataHolder.k1();
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder[] newArray(int i2) {
        return new DataHolder[i2];
    }
}