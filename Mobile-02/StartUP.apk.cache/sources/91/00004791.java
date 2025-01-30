package e.g.a.c.i.v;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class d implements f.c.d<c> {
    private final Provider<Executor> a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.backends.e> f13031b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<s> f13032c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<e.g.a.c.i.v.j.c> f13033d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.synchronization.a> f13034e;

    public d(Provider<Executor> provider, Provider<com.google.android.datatransport.runtime.backends.e> provider2, Provider<s> provider3, Provider<e.g.a.c.i.v.j.c> provider4, Provider<com.google.android.datatransport.runtime.synchronization.a> provider5) {
        this.a = provider;
        this.f13031b = provider2;
        this.f13032c = provider3;
        this.f13033d = provider4;
        this.f13034e = provider5;
    }

    public static d a(Provider<Executor> provider, Provider<com.google.android.datatransport.runtime.backends.e> provider2, Provider<s> provider3, Provider<e.g.a.c.i.v.j.c> provider4, Provider<com.google.android.datatransport.runtime.synchronization.a> provider5) {
        return new d(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public c get() {
        return new c(this.a.get(), this.f13031b.get(), this.f13032c.get(), this.f13033d.get(), this.f13034e.get());
    }
}