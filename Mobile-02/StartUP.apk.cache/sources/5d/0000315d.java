package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.r;
import com.reactnativecommunity.webview.RNCWebViewManager;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class Status extends com.google.android.gms.common.internal.safeparcel.a implements i, ReflectedParcelable {

    /* renamed from: h  reason: collision with root package name */
    private final int f6039h;

    /* renamed from: j  reason: collision with root package name */
    private final int f6040j;

    /* renamed from: k  reason: collision with root package name */
    private final String f6041k;

    /* renamed from: l  reason: collision with root package name */
    private final PendingIntent f6042l;
    public static final Status a = new Status(0);

    /* renamed from: b  reason: collision with root package name */
    public static final Status f6033b = new Status(14);

    /* renamed from: c  reason: collision with root package name */
    public static final Status f6034c = new Status(8);

    /* renamed from: d  reason: collision with root package name */
    public static final Status f6035d = new Status(15);

    /* renamed from: e  reason: collision with root package name */
    public static final Status f6036e = new Status(16);

    /* renamed from: f  reason: collision with root package name */
    private static final Status f6037f = new Status(17);

    /* renamed from: g  reason: collision with root package name */
    public static final Status f6038g = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Status(int i2, int i3, String str, PendingIntent pendingIntent) {
        this.f6039h = i2;
        this.f6040j = i3;
        this.f6041k = str;
        this.f6042l = pendingIntent;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Status) {
            Status status = (Status) obj;
            return this.f6039h == status.f6039h && this.f6040j == status.f6040j && r.a(this.f6041k, status.f6041k) && r.a(this.f6042l, status.f6042l);
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.i
    public final Status getStatus() {
        return this;
    }

    public final int hashCode() {
        return r.b(Integer.valueOf(this.f6039h), Integer.valueOf(this.f6040j), this.f6041k, this.f6042l);
    }

    public final int i1() {
        return this.f6040j;
    }

    public final String j1() {
        return this.f6041k;
    }

    public final boolean k1() {
        return this.f6042l != null;
    }

    public final boolean l1() {
        return this.f6040j <= 0;
    }

    public final String m1() {
        String str = this.f6041k;
        return str != null ? str : b.a(this.f6040j);
    }

    public final String toString() {
        return r.c(this).a("statusCode", m1()).a("resolution", this.f6042l).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, i1());
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 2, j1(), false);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 3, this.f6042l, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, RNCWebViewManager.COMMAND_CLEAR_FORM_DATA, this.f6039h);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }

    public Status(int i2) {
        this(i2, null);
    }

    public Status(int i2, String str) {
        this(1, i2, str, null);
    }

    public Status(int i2, String str, PendingIntent pendingIntent) {
        this(1, i2, str, pendingIntent);
    }
}