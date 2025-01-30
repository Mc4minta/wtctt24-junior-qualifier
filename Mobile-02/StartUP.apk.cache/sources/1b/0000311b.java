package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.t;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public class SignInAccount extends com.google.android.gms.common.internal.safeparcel.a implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new j();
    @Deprecated
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private GoogleSignInAccount f5981b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private String f5982c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f5981b = googleSignInAccount;
        this.a = t.h(str, "8.3 and 8.4 SDKs require non-null email");
        this.f5982c = t.h(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount k0() {
        return this.f5981b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 4, this.a, false);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 7, this.f5981b, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 8, this.f5982c, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}