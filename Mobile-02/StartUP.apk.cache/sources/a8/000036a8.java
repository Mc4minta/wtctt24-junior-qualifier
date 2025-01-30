package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class o4 {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7777b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7778c;

    /* renamed from: d  reason: collision with root package name */
    private long f7779d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ k4 f7780e;

    public o4(k4 k4Var, String str, long j2) {
        this.f7780e = k4Var;
        com.google.android.gms.common.internal.t.g(str);
        this.a = str;
        this.f7777b = j2;
    }

    public final long a() {
        if (!this.f7778c) {
            this.f7778c = true;
            this.f7779d = this.f7780e.D().getLong(this.a, this.f7777b);
        }
        return this.f7779d;
    }

    public final void b(long j2) {
        SharedPreferences.Editor edit = this.f7780e.D().edit();
        edit.putLong(this.a, j2);
        edit.apply();
        this.f7779d = j2;
    }
}