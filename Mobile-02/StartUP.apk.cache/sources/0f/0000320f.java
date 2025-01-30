package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class v extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<v> CREATOR = new h0();
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private IBinder f6272b;

    /* renamed from: c  reason: collision with root package name */
    private com.google.android.gms.common.b f6273c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6274d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6275e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(int i2, IBinder iBinder, com.google.android.gms.common.b bVar, boolean z, boolean z2) {
        this.a = i2;
        this.f6272b = iBinder;
        this.f6273c = bVar;
        this.f6274d = z;
        this.f6275e = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            return this.f6273c.equals(vVar.f6273c) && i1().equals(vVar.i1());
        }
        return false;
    }

    public l i1() {
        return l.a.p(this.f6272b);
    }

    public com.google.android.gms.common.b j1() {
        return this.f6273c;
    }

    public boolean k1() {
        return this.f6274d;
    }

    public boolean l1() {
        return this.f6275e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, this.a);
        com.google.android.gms.common.internal.safeparcel.b.k(parcel, 2, this.f6272b, false);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 3, j1(), i2, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, k1());
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 5, l1());
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}