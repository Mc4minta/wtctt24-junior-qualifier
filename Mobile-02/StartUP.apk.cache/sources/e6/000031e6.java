package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.l;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class g extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<g> CREATOR = new k0();
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6229b;

    /* renamed from: c  reason: collision with root package name */
    private int f6230c;

    /* renamed from: d  reason: collision with root package name */
    String f6231d;

    /* renamed from: e  reason: collision with root package name */
    IBinder f6232e;

    /* renamed from: f  reason: collision with root package name */
    Scope[] f6233f;

    /* renamed from: g  reason: collision with root package name */
    Bundle f6234g;

    /* renamed from: h  reason: collision with root package name */
    Account f6235h;

    /* renamed from: j  reason: collision with root package name */
    com.google.android.gms.common.d[] f6236j;

    /* renamed from: k  reason: collision with root package name */
    com.google.android.gms.common.d[] f6237k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f6238l;
    private int m;

    public g(int i2) {
        this.a = 4;
        this.f6230c = com.google.android.gms.common.f.a;
        this.f6229b = i2;
        this.f6238l = true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, this.a);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 2, this.f6229b);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 3, this.f6230c);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 4, this.f6231d, false);
        com.google.android.gms.common.internal.safeparcel.b.k(parcel, 5, this.f6232e, false);
        com.google.android.gms.common.internal.safeparcel.b.t(parcel, 6, this.f6233f, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.e(parcel, 7, this.f6234g, false);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 8, this.f6235h, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.t(parcel, 10, this.f6236j, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.t(parcel, 11, this.f6237k, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 12, this.f6238l);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 13, this.m);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, com.google.android.gms.common.d[] dVarArr, com.google.android.gms.common.d[] dVarArr2, boolean z, int i5) {
        this.a = i2;
        this.f6229b = i3;
        this.f6230c = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f6231d = "com.google.android.gms";
        } else {
            this.f6231d = str;
        }
        if (i2 < 2) {
            this.f6235h = iBinder != null ? a.q(l.a.p(iBinder)) : null;
        } else {
            this.f6232e = iBinder;
            this.f6235h = account;
        }
        this.f6233f = scopeArr;
        this.f6234g = bundle;
        this.f6236j = dVarArr;
        this.f6237k = dVarArr2;
        this.f6238l = z;
        this.m = i5;
    }
}