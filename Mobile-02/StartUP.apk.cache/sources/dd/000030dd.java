package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class l implements f.c.d<k> {
    private final Provider<Context> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<i> f5828b;

    public l(Provider<Context> provider, Provider<i> provider2) {
        this.a = provider;
        this.f5828b = provider2;
    }

    public static l a(Provider<Context> provider, Provider<i> provider2) {
        return new l(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public k get() {
        return new k(this.a.get(), this.f5828b.get());
    }
}