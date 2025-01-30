package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class q4 {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7809b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7810c;

    /* renamed from: d  reason: collision with root package name */
    private String f7811d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ k4 f7812e;

    public q4(k4 k4Var, String str, String str2) {
        this.f7812e = k4Var;
        com.google.android.gms.common.internal.t.g(str);
        this.a = str;
        this.f7809b = null;
    }

    public final String a() {
        if (!this.f7810c) {
            this.f7810c = true;
            this.f7811d = this.f7812e.D().getString(this.a, null);
        }
        return this.f7811d;
    }

    public final void b(String str) {
        if (this.f7812e.o().u(r.A0) || !v9.z0(str, this.f7811d)) {
            SharedPreferences.Editor edit = this.f7812e.D().edit();
            edit.putString(this.a, str);
            edit.apply();
            this.f7811d = str;
        }
    }
}