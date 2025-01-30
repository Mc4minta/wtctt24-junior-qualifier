package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class h implements Parcelable.Creator<GoogleSignInOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        ArrayList arrayList = null;
        Account account = null;
        String str = null;
        String str2 = null;
        ArrayList arrayList2 = null;
        String str3 = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            switch (SafeParcelReader.l(r)) {
                case 1:
                    i2 = SafeParcelReader.t(parcel, r);
                    break;
                case 2:
                    arrayList = SafeParcelReader.j(parcel, r, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.e(parcel, r, Account.CREATOR);
                    break;
                case 4:
                    z = SafeParcelReader.m(parcel, r);
                    break;
                case 5:
                    z2 = SafeParcelReader.m(parcel, r);
                    break;
                case 6:
                    z3 = SafeParcelReader.m(parcel, r);
                    break;
                case 7:
                    str = SafeParcelReader.f(parcel, r);
                    break;
                case 8:
                    str2 = SafeParcelReader.f(parcel, r);
                    break;
                case 9:
                    arrayList2 = SafeParcelReader.j(parcel, r, com.google.android.gms.auth.api.signin.internal.a.CREATOR);
                    break;
                case 10:
                    str3 = SafeParcelReader.f(parcel, r);
                    break;
                default:
                    SafeParcelReader.x(parcel, r);
                    break;
            }
        }
        SafeParcelReader.k(parcel, y);
        return new GoogleSignInOptions(i2, arrayList, account, z, z2, z3, str, str2, arrayList2, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i2) {
        return new GoogleSignInOptions[i2];
    }
}