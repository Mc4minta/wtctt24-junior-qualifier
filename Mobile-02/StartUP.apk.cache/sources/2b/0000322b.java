package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class e implements Parcelable.Creator<WakeLockEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        float f2 = 0.0f;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            switch (SafeParcelReader.l(r)) {
                case 1:
                    i2 = SafeParcelReader.t(parcel, r);
                    break;
                case 2:
                    j2 = SafeParcelReader.u(parcel, r);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    SafeParcelReader.x(parcel, r);
                    break;
                case 4:
                    str = SafeParcelReader.f(parcel, r);
                    break;
                case 5:
                    i4 = SafeParcelReader.t(parcel, r);
                    break;
                case 6:
                    arrayList = SafeParcelReader.h(parcel, r);
                    break;
                case 8:
                    j3 = SafeParcelReader.u(parcel, r);
                    break;
                case 10:
                    str3 = SafeParcelReader.f(parcel, r);
                    break;
                case 11:
                    i3 = SafeParcelReader.t(parcel, r);
                    break;
                case 12:
                    str2 = SafeParcelReader.f(parcel, r);
                    break;
                case 13:
                    str4 = SafeParcelReader.f(parcel, r);
                    break;
                case 14:
                    i5 = SafeParcelReader.t(parcel, r);
                    break;
                case 15:
                    f2 = SafeParcelReader.p(parcel, r);
                    break;
                case 16:
                    j4 = SafeParcelReader.u(parcel, r);
                    break;
                case 17:
                    str5 = SafeParcelReader.f(parcel, r);
                    break;
                case 18:
                    z = SafeParcelReader.m(parcel, r);
                    break;
            }
        }
        SafeParcelReader.k(parcel, y);
        return new WakeLockEvent(i2, j2, i3, str, i4, arrayList, str2, j3, i5, str3, str4, f2, j4, str5, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i2) {
        return new WakeLockEvent[i2];
    }
}