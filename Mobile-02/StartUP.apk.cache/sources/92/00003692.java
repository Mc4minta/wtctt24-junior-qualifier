package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class m4 {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f7755b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7756c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7757d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ k4 f7758e;

    public m4(k4 k4Var, String str, boolean z) {
        this.f7758e = k4Var;
        com.google.android.gms.common.internal.t.g(str);
        this.a = str;
        this.f7755b = z;
    }

    public final void a(boolean z) {
        SharedPreferences.Editor edit = this.f7758e.D().edit();
        edit.putBoolean(this.a, z);
        edit.apply();
        this.f7757d = z;
    }

    public final boolean b() {
        if (!this.f7756c) {
            this.f7756c = true;
            this.f7757d = this.f7758e.D().getBoolean(this.a, this.f7755b);
        }
        return this.f7757d;
    }
}