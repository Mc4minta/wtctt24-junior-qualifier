package e.g.a.c.i;

import android.content.Context;
import e.g.a.c.i.r;
import e.g.a.c.i.v.j.b0;
import e.g.a.c.i.v.j.c0;
import e.g.a.c.i.v.j.i0;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final class d extends r {
    private Provider<Executor> a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<Context> f12996b;

    /* renamed from: c  reason: collision with root package name */
    private Provider f12997c;

    /* renamed from: d  reason: collision with root package name */
    private Provider f12998d;

    /* renamed from: e  reason: collision with root package name */
    private Provider f12999e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<b0> f13000f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.g> f13001g;

    /* renamed from: h  reason: collision with root package name */
    private Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.s> f13002h;

    /* renamed from: j  reason: collision with root package name */
    private Provider<e.g.a.c.i.v.c> f13003j;

    /* renamed from: k  reason: collision with root package name */
    private Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.m> f13004k;

    /* renamed from: l  reason: collision with root package name */
    private Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.q> f13005l;
    private Provider<q> m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    public static final class b implements r.a {
        private Context a;

        private b() {
        }

        @Override // e.g.a.c.i.r.a
        /* renamed from: b */
        public b a(Context context) {
            this.a = (Context) f.c.h.b(context);
            return this;
        }

        @Override // e.g.a.c.i.r.a
        public r build() {
            f.c.h.a(this.a, Context.class);
            return new d(this.a);
        }
    }

    public static r.a c() {
        return new b();
    }

    private void d(Context context) {
        this.a = f.c.c.b(j.a());
        f.c.d a2 = f.c.e.a(context);
        this.f12996b = a2;
        com.google.android.datatransport.runtime.backends.j a3 = com.google.android.datatransport.runtime.backends.j.a(a2, e.g.a.c.i.w.c.a(), e.g.a.c.i.w.d.a());
        this.f12997c = a3;
        this.f12998d = f.c.c.b(com.google.android.datatransport.runtime.backends.l.a(this.f12996b, a3));
        this.f12999e = i0.a(this.f12996b, e.g.a.c.i.v.j.f.a(), e.g.a.c.i.v.j.g.a());
        this.f13000f = f.c.c.b(c0.a(e.g.a.c.i.w.c.a(), e.g.a.c.i.w.d.a(), e.g.a.c.i.v.j.h.a(), this.f12999e));
        e.g.a.c.i.v.g b2 = e.g.a.c.i.v.g.b(e.g.a.c.i.w.c.a());
        this.f13001g = b2;
        e.g.a.c.i.v.i a4 = e.g.a.c.i.v.i.a(this.f12996b, this.f13000f, b2, e.g.a.c.i.w.d.a());
        this.f13002h = a4;
        Provider<Executor> provider = this.a;
        Provider provider2 = this.f12998d;
        Provider<b0> provider3 = this.f13000f;
        this.f13003j = e.g.a.c.i.v.d.a(provider, provider2, a4, provider3, provider3);
        Provider<Context> provider4 = this.f12996b;
        Provider provider5 = this.f12998d;
        Provider<b0> provider6 = this.f13000f;
        this.f13004k = com.google.android.datatransport.runtime.scheduling.jobscheduling.n.a(provider4, provider5, provider6, this.f13002h, this.a, provider6, e.g.a.c.i.w.c.a());
        Provider<Executor> provider7 = this.a;
        Provider<b0> provider8 = this.f13000f;
        this.f13005l = com.google.android.datatransport.runtime.scheduling.jobscheduling.r.a(provider7, provider8, this.f13002h, provider8);
        this.m = f.c.c.b(s.a(e.g.a.c.i.w.c.a(), e.g.a.c.i.w.d.a(), this.f13003j, this.f13004k, this.f13005l));
    }

    @Override // e.g.a.c.i.r
    e.g.a.c.i.v.j.c a() {
        return this.f13000f.get();
    }

    @Override // e.g.a.c.i.r
    q b() {
        return this.m.get();
    }

    private d(Context context) {
        d(context);
    }
}