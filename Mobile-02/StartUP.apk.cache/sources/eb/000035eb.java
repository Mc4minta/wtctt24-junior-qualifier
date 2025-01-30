package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class zc extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<zc> CREATOR = new yc();
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public final long f7458b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f7459c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7460d;

    /* renamed from: e  reason: collision with root package name */
    public final String f7461e;

    /* renamed from: f  reason: collision with root package name */
    public final String f7462f;

    /* renamed from: g  reason: collision with root package name */
    public final Bundle f7463g;

    public zc(long j2, long j3, boolean z, String str, String str2, String str3, Bundle bundle) {
        this.a = j2;
        this.f7458b = j3;
        this.f7459c = z;
        this.f7460d = str;
        this.f7461e = str2;
        this.f7462f = str3;
        this.f7463g = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 1, this.a);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 2, this.f7458b);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 3, this.f7459c);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 4, this.f7460d, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 5, this.f7461e, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 6, this.f7462f, false);
        com.google.android.gms.common.internal.safeparcel.b.e(parcel, 7, this.f7463g, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}