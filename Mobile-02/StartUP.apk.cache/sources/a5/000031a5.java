package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.AvailabilityException;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class r0 {
    private final c.e.a<b<?>, com.google.android.gms.common.b> a;

    /* renamed from: b  reason: collision with root package name */
    private final c.e.a<b<?>, String> f6133b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.gms.tasks.h<Map<b<?>, String>> f6134c;

    /* renamed from: d  reason: collision with root package name */
    private int f6135d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6136e;

    public final void a(b<?> bVar, com.google.android.gms.common.b bVar2, String str) {
        this.a.put(bVar, bVar2);
        this.f6133b.put(bVar, str);
        this.f6135d--;
        if (!bVar2.m1()) {
            this.f6136e = true;
        }
        if (this.f6135d == 0) {
            if (this.f6136e) {
                this.f6134c.b(new AvailabilityException(this.a));
                return;
            }
            this.f6134c.c(this.f6133b);
        }
    }

    public final Set<b<?>> b() {
        return this.a.keySet();
    }
}