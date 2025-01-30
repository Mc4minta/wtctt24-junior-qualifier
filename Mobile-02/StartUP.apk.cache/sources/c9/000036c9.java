package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class r4 {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7841b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7842c;

    /* renamed from: d  reason: collision with root package name */
    private final long f7843d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ k4 f7844e;

    private r4(k4 k4Var, String str, long j2) {
        this.f7844e = k4Var;
        com.google.android.gms.common.internal.t.g(str);
        com.google.android.gms.common.internal.t.a(j2 > 0);
        this.a = String.valueOf(str).concat(":start");
        this.f7841b = String.valueOf(str).concat(":count");
        this.f7842c = String.valueOf(str).concat(":value");
        this.f7843d = j2;
    }

    private final void c() {
        this.f7844e.d();
        long a = this.f7844e.i().a();
        SharedPreferences.Editor edit = this.f7844e.D().edit();
        edit.remove(this.f7841b);
        edit.remove(this.f7842c);
        edit.putLong(this.a, a);
        edit.apply();
    }

    private final long d() {
        return this.f7844e.D().getLong(this.a, 0L);
    }

    public final Pair<String, Long> a() {
        long abs;
        this.f7844e.d();
        this.f7844e.d();
        long d2 = d();
        if (d2 == 0) {
            c();
            abs = 0;
        } else {
            abs = Math.abs(d2 - this.f7844e.i().a());
        }
        long j2 = this.f7843d;
        if (abs < j2) {
            return null;
        }
        if (abs > (j2 << 1)) {
            c();
            return null;
        }
        String string = this.f7844e.D().getString(this.f7842c, null);
        long j3 = this.f7844e.D().getLong(this.f7841b, 0L);
        c();
        if (string != null && j3 > 0) {
            return new Pair<>(string, Long.valueOf(j3));
        }
        return k4.f7702c;
    }

    public final void b(String str, long j2) {
        this.f7844e.d();
        if (d() == 0) {
            c();
        }
        if (str == null) {
            str = "";
        }
        long j3 = this.f7844e.D().getLong(this.f7841b, 0L);
        if (j3 <= 0) {
            SharedPreferences.Editor edit = this.f7844e.D().edit();
            edit.putString(this.f7842c, str);
            edit.putLong(this.f7841b, 1L);
            edit.apply();
            return;
        }
        long j4 = j3 + 1;
        boolean z = (this.f7844e.m().G0().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j4;
        SharedPreferences.Editor edit2 = this.f7844e.D().edit();
        if (z) {
            edit2.putString(this.f7842c, str);
        }
        edit2.putLong(this.f7841b, j4);
        edit2.apply();
    }
}