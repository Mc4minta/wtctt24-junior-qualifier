package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class n implements f.c.d<m> {
    private final Provider<Context> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.backends.e> f5861b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<e.g.a.c.i.v.j.c> f5862c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<s> f5863d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Executor> f5864e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.synchronization.a> f5865f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<e.g.a.c.i.w.a> f5866g;

    public n(Provider<Context> provider, Provider<com.google.android.datatransport.runtime.backends.e> provider2, Provider<e.g.a.c.i.v.j.c> provider3, Provider<s> provider4, Provider<Executor> provider5, Provider<com.google.android.datatransport.runtime.synchronization.a> provider6, Provider<e.g.a.c.i.w.a> provider7) {
        this.a = provider;
        this.f5861b = provider2;
        this.f5862c = provider3;
        this.f5863d = provider4;
        this.f5864e = provider5;
        this.f5865f = provider6;
        this.f5866g = provider7;
    }

    public static n a(Provider<Context> provider, Provider<com.google.android.datatransport.runtime.backends.e> provider2, Provider<e.g.a.c.i.v.j.c> provider3, Provider<s> provider4, Provider<Executor> provider5, Provider<com.google.android.datatransport.runtime.synchronization.a> provider6, Provider<e.g.a.c.i.w.a> provider7) {
        return new n(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public m get() {
        return new m(this.a.get(), this.f5861b.get(), this.f5862c.get(), this.f5863d.get(), this.f5864e.get(), this.f5865f.get(), this.f5866g.get());
    }
}