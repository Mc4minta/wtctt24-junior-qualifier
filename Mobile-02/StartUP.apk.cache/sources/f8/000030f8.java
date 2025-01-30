package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.concurrent.Executor;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class r implements f.c.d<q> {
    private final Provider<Executor> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<e.g.a.c.i.v.j.c> f5870b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<s> f5871c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.synchronization.a> f5872d;

    public r(Provider<Executor> provider, Provider<e.g.a.c.i.v.j.c> provider2, Provider<s> provider3, Provider<com.google.android.datatransport.runtime.synchronization.a> provider4) {
        this.a = provider;
        this.f5870b = provider2;
        this.f5871c = provider3;
        this.f5872d = provider4;
    }

    public static r a(Provider<Executor> provider, Provider<e.g.a.c.i.v.j.c> provider2, Provider<s> provider3, Provider<com.google.android.datatransport.runtime.synchronization.a> provider4) {
        return new r(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public q get() {
        return new q(this.a.get(), this.f5870b.get(), this.f5871c.get(), this.f5872d.get());
    }
}