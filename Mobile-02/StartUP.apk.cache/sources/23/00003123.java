package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class f implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
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
                    str2 = SafeParcelReader.f(parcel, r);
                    break;
                case 4:
                    str3 = SafeParcelReader.f(parcel, r);
                    break;
                case 5:
                    str4 = SafeParcelReader.f(parcel, r);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.e(parcel, r, Uri.CREATOR);
                    break;
                case 7:
                    str5 = SafeParcelReader.f(parcel, r);
                    break;
                case 8:
                    j2 = SafeParcelReader.u(parcel, r);
                    break;
                case 9:
                    str6 = SafeParcelReader.f(parcel, r);
                    break;
                case 10:
                    arrayList = SafeParcelReader.j(parcel, r, Scope.CREATOR);
                    break;
                case 11:
                    str7 = SafeParcelReader.f(parcel, r);
                    break;
                case 12:
                    str8 = SafeParcelReader.f(parcel, r);
                    break;
                default:
                    SafeParcelReader.x(parcel, r);
                    break;
            }
        }
        SafeParcelReader.k(parcel, y);
        return new GoogleSignInAccount(i2, str, str2, str3, str4, uri, str5, j2, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i2) {
        return new GoogleSignInAccount[i2];
    }
}