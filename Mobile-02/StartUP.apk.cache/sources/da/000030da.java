package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class j implements f.c.d<i> {
    private final Provider<Context> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.g.a.c.i.w.a> f5823b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<e.g.a.c.i.w.a> f5824c;

    public j(Provider<Context> provider, Provider<e.g.a.c.i.w.a> provider2, Provider<e.g.a.c.i.w.a> provider3) {
        this.a = provider;
        this.f5823b = provider2;
        this.f5824c = provider3;
    }

    public static j a(Provider<Context> provider, Provider<e.g.a.c.i.w.a> provider2, Provider<e.g.a.c.i.w.a> provider3) {
        return new j(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public i get() {
        return new i(this.a.get(), this.f5823b.get(), this.f5824c.get());
    }
}