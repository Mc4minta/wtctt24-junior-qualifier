package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class q9 extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<q9> CREATOR = new t9();
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7823b;

    /* renamed from: c  reason: collision with root package name */
    public final long f7824c;

    /* renamed from: d  reason: collision with root package name */
    public final Long f7825d;

    /* renamed from: e  reason: collision with root package name */
    private final Float f7826e;

    /* renamed from: f  reason: collision with root package name */
    public final String f7827f;

    /* renamed from: g  reason: collision with root package name */
    public final String f7828g;

    /* renamed from: h  reason: collision with root package name */
    public final Double f7829h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q9(s9 s9Var) {
        this(s9Var.f7861c, s9Var.f7862d, s9Var.f7863e, s9Var.f7860b);
    }

    public final Object i1() {
        Long l2 = this.f7825d;
        if (l2 != null) {
            return l2;
        }
        Double d2 = this.f7829h;
        if (d2 != null) {
            return d2;
        }
        String str = this.f7827f;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, this.a);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 2, this.f7823b, false);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 3, this.f7824c);
        com.google.android.gms.common.internal.safeparcel.b.o(parcel, 4, this.f7825d, false);
        com.google.android.gms.common.internal.safeparcel.b.j(parcel, 5, null, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 6, this.f7827f, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 7, this.f7828g, false);
        com.google.android.gms.common.internal.safeparcel.b.h(parcel, 8, this.f7829h, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q9(String str, long j2, Object obj, String str2) {
        com.google.android.gms.common.internal.t.g(str);
        this.a = 2;
        this.f7823b = str;
        this.f7824c = j2;
        this.f7828g = str2;
        if (obj == null) {
            this.f7825d = null;
            this.f7826e = null;
            this.f7829h = null;
            this.f7827f = null;
        } else if (obj instanceof Long) {
            this.f7825d = (Long) obj;
            this.f7826e = null;
            this.f7829h = null;
            this.f7827f = null;
        } else if (obj instanceof String) {
            this.f7825d = null;
            this.f7826e = null;
            this.f7829h = null;
            this.f7827f = (String) obj;
        } else if (obj instanceof Double) {
            this.f7825d = null;
            this.f7826e = null;
            this.f7829h = (Double) obj;
            this.f7827f = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q9(int i2, String str, long j2, Long l2, Float f2, String str2, String str3, Double d2) {
        this.a = i2;
        this.f7823b = str;
        this.f7824c = j2;
        this.f7825d = l2;
        this.f7826e = null;
        if (i2 == 1) {
            this.f7829h = f2 != null ? Double.valueOf(f2.doubleValue()) : null;
        } else {
            this.f7829h = d2;
        }
        this.f7827f = str2;
        this.f7828g = str3;
    }
}