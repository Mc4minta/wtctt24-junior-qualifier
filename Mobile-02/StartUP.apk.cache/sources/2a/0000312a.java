package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class a extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<a> CREATOR = new d();
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private int f5996b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f5997c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i2, int i3, Bundle bundle) {
        this.a = i2;
        this.f5996b = i3;
        this.f5997c = bundle;
    }

    public int i1() {
        return this.f5996b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, this.a);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 2, i1());
        com.google.android.gms.common.internal.safeparcel.b.e(parcel, 3, this.f5997c, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}