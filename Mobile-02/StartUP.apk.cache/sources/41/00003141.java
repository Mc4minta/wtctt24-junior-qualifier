package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class x implements Parcelable.Creator<SignInConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        String str = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 2) {
                str = SafeParcelReader.f(parcel, r);
            } else if (l2 != 5) {
                SafeParcelReader.x(parcel, r);
            } else {
                googleSignInOptions = (GoogleSignInOptions) SafeParcelReader.e(parcel, r, GoogleSignInOptions.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new SignInConfiguration(str, googleSignInOptions);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration[] newArray(int i2) {
        return new SignInConfiguration[i2];
    }
}