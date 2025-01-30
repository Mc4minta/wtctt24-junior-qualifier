package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class p extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<p> CREATOR = new s();
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final o f7790b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7791c;

    /* renamed from: d  reason: collision with root package name */
    public final long f7792d;

    public p(String str, o oVar, String str2, long j2) {
        this.a = str;
        this.f7790b = oVar;
        this.f7791c = str2;
        this.f7792d = j2;
    }

    public final String toString() {
        String str = this.f7791c;
        String str2 = this.a;
        String valueOf = String.valueOf(this.f7790b);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + valueOf.length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 2, this.a, false);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 3, this.f7790b, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 4, this.f7791c, false);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 5, this.f7792d);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(p pVar, long j2) {
        com.google.android.gms.common.internal.t.k(pVar);
        this.a = pVar.a;
        this.f7790b = pVar.f7790b;
        this.f7791c = pVar.f7791c;
        this.f7792d = j2;
    }
}