package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class t5 extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<t5> CREATOR = new u5();
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6561b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6562c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6563d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6564e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6565f;

    /* renamed from: g  reason: collision with root package name */
    public final String f6566g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f6567h;

    /* renamed from: j  reason: collision with root package name */
    private final int f6568j;

    public t5(String str, int i2, int i3, String str2, String str3, String str4, boolean z, y4 y4Var) {
        this.a = (String) com.google.android.gms.common.internal.t.k(str);
        this.f6561b = i2;
        this.f6562c = i3;
        this.f6566g = str2;
        this.f6563d = str3;
        this.f6564e = str4;
        this.f6565f = !z;
        this.f6567h = z;
        this.f6568j = y4Var.c();
    }

    public t5(String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.a = str;
        this.f6561b = i2;
        this.f6562c = i3;
        this.f6563d = str2;
        this.f6564e = str3;
        this.f6565f = z;
        this.f6566g = str4;
        this.f6567h = z2;
        this.f6568j = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof t5) {
            t5 t5Var = (t5) obj;
            if (com.google.android.gms.common.internal.r.a(this.a, t5Var.a) && this.f6561b == t5Var.f6561b && this.f6562c == t5Var.f6562c && com.google.android.gms.common.internal.r.a(this.f6566g, t5Var.f6566g) && com.google.android.gms.common.internal.r.a(this.f6563d, t5Var.f6563d) && com.google.android.gms.common.internal.r.a(this.f6564e, t5Var.f6564e) && this.f6565f == t5Var.f6565f && this.f6567h == t5Var.f6567h && this.f6568j == t5Var.f6568j) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.r.b(this.a, Integer.valueOf(this.f6561b), Integer.valueOf(this.f6562c), this.f6566g, this.f6563d, this.f6564e, Boolean.valueOf(this.f6565f), Boolean.valueOf(this.f6567h), Integer.valueOf(this.f6568j));
    }

    public final String toString() {
        return "PlayLoggerContext[package=" + this.a + ",packageVersionCode=" + this.f6561b + ",logSource=" + this.f6562c + ",logSourceName=" + this.f6566g + ",uploadAccount=" + this.f6563d + ",loggingId=" + this.f6564e + ",logAndroidId=" + this.f6565f + ",isAnonymous=" + this.f6567h + ",qosTier=" + this.f6568j + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 2, this.a, false);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 3, this.f6561b);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 4, this.f6562c);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 5, this.f6563d, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 6, this.f6564e, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 7, this.f6565f);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 8, this.f6566g, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 9, this.f6567h);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 10, this.f6568j);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}