package com.google.android.gms.auth.api.signin.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class b {
    private static int a = 31;

    /* renamed from: b  reason: collision with root package name */
    private int f5998b = 1;

    public b a(Object obj) {
        this.f5998b = (a * this.f5998b) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int b() {
        return this.f5998b;
    }

    public final b c(boolean z) {
        this.f5998b = (a * this.f5998b) + (z ? 1 : 0);
        return this;
    }
}