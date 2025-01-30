package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new e();
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final long f6294b;

    /* renamed from: c  reason: collision with root package name */
    private int f6295c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6296d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6297e;

    /* renamed from: f  reason: collision with root package name */
    private final String f6298f;

    /* renamed from: g  reason: collision with root package name */
    private final int f6299g;

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f6300h;

    /* renamed from: j  reason: collision with root package name */
    private final String f6301j;

    /* renamed from: k  reason: collision with root package name */
    private final long f6302k;

    /* renamed from: l  reason: collision with root package name */
    private int f6303l;
    private final String m;
    private final float n;
    private final long p;
    private final boolean q;
    private long t;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WakeLockEvent(int i2, long j2, int i3, String str, int i4, List<String> list, String str2, long j3, int i5, String str3, String str4, float f2, long j4, String str5, boolean z) {
        this.a = i2;
        this.f6294b = j2;
        this.f6295c = i3;
        this.f6296d = str;
        this.f6297e = str3;
        this.f6298f = str5;
        this.f6299g = i4;
        this.t = -1L;
        this.f6300h = list;
        this.f6301j = str2;
        this.f6302k = j3;
        this.f6303l = i5;
        this.m = str4;
        this.n = f2;
        this.p = j4;
        this.q = z;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int i1() {
        return this.f6295c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long j1() {
        return this.f6294b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long k1() {
        return this.t;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String l1() {
        String str = this.f6296d;
        int i2 = this.f6299g;
        List<String> list = this.f6300h;
        String join = list == null ? "" : TextUtils.join(",", list);
        int i3 = this.f6303l;
        String str2 = this.f6297e;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.m;
        if (str3 == null) {
            str3 = "";
        }
        float f2 = this.n;
        String str4 = this.f6298f;
        String str5 = str4 != null ? str4 : "";
        boolean z = this.q;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(join).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str5).length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i3);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f2);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, this.a);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 2, j1());
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 4, this.f6296d, false);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 5, this.f6299g);
        com.google.android.gms.common.internal.safeparcel.b.s(parcel, 6, this.f6300h, false);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 8, this.f6302k);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 10, this.f6297e, false);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 11, i1());
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 12, this.f6301j, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 13, this.m, false);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 14, this.f6303l);
        com.google.android.gms.common.internal.safeparcel.b.i(parcel, 15, this.n);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 16, this.p);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 17, this.f6298f, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 18, this.q);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    public WakeLockEvent(long j2, int i2, String str, int i3, List<String> list, String str2, long j3, int i4, String str3, String str4, float f2, long j4, String str5, boolean z) {
        this(2, j2, i2, str, i3, list, str2, j3, i4, str3, str4, f2, j4, str5, z);
    }
}