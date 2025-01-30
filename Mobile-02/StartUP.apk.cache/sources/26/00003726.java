package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class z9 extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<z9> CREATOR = new y9();
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7972b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7973c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7974d;

    /* renamed from: e  reason: collision with root package name */
    public final long f7975e;

    /* renamed from: f  reason: collision with root package name */
    public final long f7976f;

    /* renamed from: g  reason: collision with root package name */
    public final String f7977g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f7978h;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f7979j;

    /* renamed from: k  reason: collision with root package name */
    public final long f7980k;

    /* renamed from: l  reason: collision with root package name */
    public final String f7981l;
    public final long m;
    public final long n;
    public final int p;
    public final boolean q;
    public final boolean t;
    public final boolean u;
    public final String v;
    public final Boolean w;
    public final long x;
    public final List<String> y;
    public final String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z9(String str, String str2, String str3, long j2, String str4, long j3, long j4, String str5, boolean z, boolean z2, String str6, long j5, long j6, int i2, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j7, List<String> list, String str8) {
        com.google.android.gms.common.internal.t.g(str);
        this.a = str;
        this.f7972b = TextUtils.isEmpty(str2) ? null : str2;
        this.f7973c = str3;
        this.f7980k = j2;
        this.f7974d = str4;
        this.f7975e = j3;
        this.f7976f = j4;
        this.f7977g = str5;
        this.f7978h = z;
        this.f7979j = z2;
        this.f7981l = str6;
        this.m = j5;
        this.n = j6;
        this.p = i2;
        this.q = z3;
        this.t = z4;
        this.u = z5;
        this.v = str7;
        this.w = bool;
        this.x = j7;
        this.y = list;
        this.z = str8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 2, this.a, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 3, this.f7972b, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 4, this.f7973c, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 5, this.f7974d, false);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 6, this.f7975e);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 7, this.f7976f);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 8, this.f7977g, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 9, this.f7978h);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 10, this.f7979j);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 11, this.f7980k);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 12, this.f7981l, false);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 13, this.m);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 14, this.n);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 15, this.p);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 16, this.q);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 17, this.t);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 18, this.u);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 19, this.v, false);
        com.google.android.gms.common.internal.safeparcel.b.d(parcel, 21, this.w, false);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 22, this.x);
        com.google.android.gms.common.internal.safeparcel.b.s(parcel, 23, this.y, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 24, this.z, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z9(String str, String str2, String str3, String str4, long j2, long j3, String str5, boolean z, boolean z2, long j4, String str6, long j5, long j6, int i2, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j7, List<String> list, String str8) {
        this.a = str;
        this.f7972b = str2;
        this.f7973c = str3;
        this.f7980k = j4;
        this.f7974d = str4;
        this.f7975e = j2;
        this.f7976f = j3;
        this.f7977g = str5;
        this.f7978h = z;
        this.f7979j = z2;
        this.f7981l = str6;
        this.m = j5;
        this.n = j6;
        this.p = i2;
        this.q = z3;
        this.t = z4;
        this.u = z5;
        this.v = str7;
        this.w = bool;
        this.x = j7;
        this.y = list;
        this.z = str8;
    }
}