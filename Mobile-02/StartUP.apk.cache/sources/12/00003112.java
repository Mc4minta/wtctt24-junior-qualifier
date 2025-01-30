package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.t;
import java.util.List;

/* loaded from: classes2.dex */
public class TokenData extends com.google.android.gms.common.internal.safeparcel.a implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new f();
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5945b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f5946c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f5947d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f5948e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f5949f;

    /* renamed from: g  reason: collision with root package name */
    private final String f5950g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TokenData(int i2, String str, Long l2, boolean z, boolean z2, List<String> list, String str2) {
        this.a = i2;
        this.f5945b = t.g(str);
        this.f5946c = l2;
        this.f5947d = z;
        this.f5948e = z2;
        this.f5949f = list;
        this.f5950g = str2;
    }

    public static TokenData i1(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle2.getParcelable("TokenData");
    }

    public boolean equals(Object obj) {
        if (obj instanceof TokenData) {
            TokenData tokenData = (TokenData) obj;
            return TextUtils.equals(this.f5945b, tokenData.f5945b) && r.a(this.f5946c, tokenData.f5946c) && this.f5947d == tokenData.f5947d && this.f5948e == tokenData.f5948e && r.a(this.f5949f, tokenData.f5949f) && r.a(this.f5950g, tokenData.f5950g);
        }
        return false;
    }

    public int hashCode() {
        return r.b(this.f5945b, this.f5946c, Boolean.valueOf(this.f5947d), Boolean.valueOf(this.f5948e), this.f5949f, this.f5950g);
    }

    public final String j1() {
        return this.f5945b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = b.a(parcel);
        b.l(parcel, 1, this.a);
        b.q(parcel, 2, this.f5945b, false);
        b.o(parcel, 3, this.f5946c, false);
        b.c(parcel, 4, this.f5947d);
        b.c(parcel, 5, this.f5948e);
        b.s(parcel, 6, this.f5949f, false);
        b.q(parcel, 7, this.f5950g, false);
        b.b(parcel, a);
    }
}