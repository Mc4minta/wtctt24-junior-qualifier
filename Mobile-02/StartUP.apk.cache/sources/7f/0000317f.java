package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class b<O extends a.d> {
    private final boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private final int f6070b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.gms.common.api.a<O> f6071c;

    /* renamed from: d  reason: collision with root package name */
    private final O f6072d;

    private b(com.google.android.gms.common.api.a<O> aVar, O o) {
        this.f6071c = aVar;
        this.f6072d = o;
        this.f6070b = com.google.android.gms.common.internal.r.b(aVar, o);
    }

    public static <O extends a.d> b<O> b(com.google.android.gms.common.api.a<O> aVar, O o) {
        return new b<>(aVar, o);
    }

    public final String a() {
        return this.f6071c.b();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return !this.a && !bVar.a && com.google.android.gms.common.internal.r.a(this.f6071c, bVar.f6071c) && com.google.android.gms.common.internal.r.a(this.f6072d, bVar.f6072d);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6070b;
    }
}