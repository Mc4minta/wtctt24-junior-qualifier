package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class i0 extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<i0> CREATOR = new j0();
    Bundle a;

    /* renamed from: b  reason: collision with root package name */
    com.google.android.gms.common.d[] f6245b;

    /* renamed from: c  reason: collision with root package name */
    private int f6246c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(Bundle bundle, com.google.android.gms.common.d[] dVarArr, int i2) {
        this.a = bundle;
        this.f6245b = dVarArr;
        this.f6246c = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.e(parcel, 1, this.a, false);
        com.google.android.gms.common.internal.safeparcel.b.t(parcel, 2, this.f6245b, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 3, this.f6246c);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    public i0() {
    }
}