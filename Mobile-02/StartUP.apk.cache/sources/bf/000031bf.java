package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import org.apache.http.cookie.ClientCookie;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class d extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<d> CREATOR = new p();
    private final String a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private final int f6158b;

    /* renamed from: c  reason: collision with root package name */
    private final long f6159c;

    public d(String str, int i2, long j2) {
        this.a = str;
        this.f6158b = i2;
        this.f6159c = j2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (((i1() != null && i1().equals(dVar.i1())) || (i1() == null && dVar.i1() == null)) && j1() == dVar.j1()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.r.b(i1(), Long.valueOf(j1()));
    }

    public String i1() {
        return this.a;
    }

    public long j1() {
        long j2 = this.f6159c;
        return j2 == -1 ? this.f6158b : j2;
    }

    public String toString() {
        return com.google.android.gms.common.internal.r.c(this).a(ApiConstants.NAME, i1()).a(ClientCookie.VERSION_ATTR, Long.valueOf(j1())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 1, i1(), false);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 2, this.f6158b);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 3, j1());
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}