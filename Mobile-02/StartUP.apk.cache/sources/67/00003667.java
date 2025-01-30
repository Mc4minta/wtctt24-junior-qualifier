package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class ia extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<ia> CREATOR = new la();
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f7653b;

    /* renamed from: c  reason: collision with root package name */
    public q9 f7654c;

    /* renamed from: d  reason: collision with root package name */
    public long f7655d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7656e;

    /* renamed from: f  reason: collision with root package name */
    public String f7657f;

    /* renamed from: g  reason: collision with root package name */
    public p f7658g;

    /* renamed from: h  reason: collision with root package name */
    public long f7659h;

    /* renamed from: j  reason: collision with root package name */
    public p f7660j;

    /* renamed from: k  reason: collision with root package name */
    public long f7661k;

    /* renamed from: l  reason: collision with root package name */
    public p f7662l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ia(ia iaVar) {
        com.google.android.gms.common.internal.t.k(iaVar);
        this.a = iaVar.a;
        this.f7653b = iaVar.f7653b;
        this.f7654c = iaVar.f7654c;
        this.f7655d = iaVar.f7655d;
        this.f7656e = iaVar.f7656e;
        this.f7657f = iaVar.f7657f;
        this.f7658g = iaVar.f7658g;
        this.f7659h = iaVar.f7659h;
        this.f7660j = iaVar.f7660j;
        this.f7661k = iaVar.f7661k;
        this.f7662l = iaVar.f7662l;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 2, this.a, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 3, this.f7653b, false);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 4, this.f7654c, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 5, this.f7655d);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 6, this.f7656e);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 7, this.f7657f, false);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 8, this.f7658g, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 9, this.f7659h);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 10, this.f7660j, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 11, this.f7661k);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 12, this.f7662l, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ia(String str, String str2, q9 q9Var, long j2, boolean z, String str3, p pVar, long j3, p pVar2, long j4, p pVar3) {
        this.a = str;
        this.f7653b = str2;
        this.f7654c = q9Var;
        this.f7655d = j2;
        this.f7656e = z;
        this.f7657f = str3;
        this.f7658g = pVar;
        this.f7659h = j3;
        this.f7660j = pVar2;
        this.f7661k = j4;
        this.f7662l = pVar3;
    }
}