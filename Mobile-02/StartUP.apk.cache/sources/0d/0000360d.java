package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class b4 {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f7500b;

    /* renamed from: c  reason: collision with root package name */
    public long f7501c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f7502d;

    public b4(String str, String str2, Bundle bundle, long j2) {
        this.a = str;
        this.f7500b = str2;
        this.f7502d = bundle == null ? new Bundle() : bundle;
        this.f7501c = j2;
    }

    public final String toString() {
        String str = this.f7500b;
        String str2 = this.a;
        String valueOf = String.valueOf(this.f7502d);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + valueOf.length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }
}