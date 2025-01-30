package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class j implements Parcelable.Creator<SignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        String str = "";
        GoogleSignInAccount googleSignInAccount = null;
        String str2 = "";
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 4) {
                str = SafeParcelReader.f(parcel, r);
            } else if (l2 == 7) {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.e(parcel, r, GoogleSignInAccount.CREATOR);
            } else if (l2 != 8) {
                SafeParcelReader.x(parcel, r);
            } else {
                str2 = SafeParcelReader.f(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new SignInAccount(str, googleSignInAccount, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount[] newArray(int i2) {
        return new SignInAccount[i2];
    }
}