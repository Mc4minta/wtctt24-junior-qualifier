package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class SignInConfiguration extends com.google.android.gms.common.internal.safeparcel.a implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new x();
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private GoogleSignInOptions f5990b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.a = com.google.android.gms.common.internal.t.g(str);
        this.f5990b = googleSignInOptions;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SignInConfiguration) {
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (this.a.equals(signInConfiguration.a)) {
                GoogleSignInOptions googleSignInOptions = this.f5990b;
                if (googleSignInOptions == null) {
                    if (signInConfiguration.f5990b == null) {
                        return true;
                    }
                } else if (googleSignInOptions.equals(signInConfiguration.f5990b)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return new b().a(this.a).a(this.f5990b).b();
    }

    public final GoogleSignInOptions i1() {
        return this.f5990b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 2, this.a, false);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 5, this.f5990b, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}