package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class g0 implements Parcelable.Creator<u> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        Account account = null;
        int i2 = 0;
        int i3 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 1) {
                i2 = SafeParcelReader.t(parcel, r);
            } else if (l2 == 2) {
                account = (Account) SafeParcelReader.e(parcel, r, Account.CREATOR);
            } else if (l2 == 3) {
                i3 = SafeParcelReader.t(parcel, r);
            } else if (l2 != 4) {
                SafeParcelReader.x(parcel, r);
            } else {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.e(parcel, r, GoogleSignInAccount.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new u(i2, account, i3, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u[] newArray(int i2) {
        return new u[i2];
    }
}