package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class o8 implements l8 {
    private static final x1<Long> A;
    private static final x1<Long> B;
    private static final x1<Long> C;
    private static final x1<Long> D;
    private static final x1<Long> E;
    private static final x1<Long> F;
    private static final x1<Long> G;
    private static final x1<Long> H;
    private static final x1<String> I;
    private static final x1<Long> J;
    private static final x1<Long> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Long> f7286b;

    /* renamed from: c  reason: collision with root package name */
    private static final x1<String> f7287c;

    /* renamed from: d  reason: collision with root package name */
    private static final x1<String> f7288d;

    /* renamed from: e  reason: collision with root package name */
    private static final x1<String> f7289e;

    /* renamed from: f  reason: collision with root package name */
    private static final x1<Long> f7290f;

    /* renamed from: g  reason: collision with root package name */
    private static final x1<Long> f7291g;

    /* renamed from: h  reason: collision with root package name */
    private static final x1<Long> f7292h;

    /* renamed from: i  reason: collision with root package name */
    private static final x1<Long> f7293i;

    /* renamed from: j  reason: collision with root package name */
    private static final x1<Long> f7294j;

    /* renamed from: k  reason: collision with root package name */
    private static final x1<Long> f7295k;

    /* renamed from: l  reason: collision with root package name */
    private static final x1<Long> f7296l;
    private static final x1<Long> m;
    private static final x1<Long> n;
    private static final x1<Long> o;
    private static final x1<Long> p;
    private static final x1<Long> q;
    private static final x1<String> r;
    private static final x1<Long> s;
    private static final x1<Long> t;
    private static final x1<Long> u;
    private static final x1<Long> v;
    private static final x1<Long> w;
    private static final x1<Long> x;
    private static final x1<Long> y;
    private static final x1<Long> z;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.b("measurement.ad_id_cache_time", 10000L);
        f7286b = d2Var.b("measurement.config.cache_time", 86400000L);
        f7287c = d2Var.c("measurement.log_tag", "FA");
        f7288d = d2Var.c("measurement.config.url_authority", "app-measurement.com");
        f7289e = d2Var.c("measurement.config.url_scheme", "https");
        f7290f = d2Var.b("measurement.upload.debug_upload_interval", 1000L);
        f7291g = d2Var.b("measurement.lifetimevalue.max_currency_tracked", 4L);
        f7292h = d2Var.b("measurement.store.max_stored_events_per_app", 100000L);
        f7293i = d2Var.b("measurement.experiment.max_ids", 50L);
        f7294j = d2Var.b("measurement.audience.filter_result_max_count", 200L);
        f7295k = d2Var.b("measurement.alarm_manager.minimum_interval", 60000L);
        f7296l = d2Var.b("measurement.upload.minimum_delay", 500L);
        m = d2Var.b("measurement.monitoring.sample_period_millis", 86400000L);
        n = d2Var.b("measurement.upload.realtime_upload_interval", 10000L);
        o = d2Var.b("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        p = d2Var.b("measurement.config.cache_time.service", 3600000L);
        q = d2Var.b("measurement.service_client.idle_disconnect_millis", 5000L);
        r = d2Var.c("measurement.log_tag.service", "FA-SVC");
        s = d2Var.b("measurement.upload.stale_data_deletion_interval", 86400000L);
        t = d2Var.b("measurement.upload.backoff_period", 43200000L);
        u = d2Var.b("measurement.upload.initial_upload_delay_time", 15000L);
        v = d2Var.b("measurement.upload.interval", 3600000L);
        w = d2Var.b("measurement.upload.max_bundle_size", 65536L);
        x = d2Var.b("measurement.upload.max_bundles", 100L);
        y = d2Var.b("measurement.upload.max_conversions_per_day", 500L);
        z = d2Var.b("measurement.upload.max_error_events_per_day", 1000L);
        A = d2Var.b("measurement.upload.max_events_per_bundle", 1000L);
        B = d2Var.b("measurement.upload.max_events_per_day", 100000L);
        C = d2Var.b("measurement.upload.max_public_events_per_day", 50000L);
        D = d2Var.b("measurement.upload.max_queue_time", 2419200000L);
        E = d2Var.b("measurement.upload.max_realtime_events_per_day", 10L);
        F = d2Var.b("measurement.upload.max_batch_size", 65536L);
        G = d2Var.b("measurement.upload.retry_count", 6L);
        H = d2Var.b("measurement.upload.retry_time", 1800000L);
        I = d2Var.c("measurement.upload.url", "https://app-measurement.com/a");
        J = d2Var.b("measurement.upload.window_interval", 3600000L);
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long A() {
        return F.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long B() {
        return G.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long C() {
        return f7295k.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long D() {
        return D.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long E() {
        return v.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long F() {
        return E.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long G() {
        return w.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long a() {
        return a.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long b() {
        return f7286b.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final String c() {
        return f7288d.n();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final String d() {
        return f7289e.n();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long e() {
        return f7290f.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long f() {
        return u.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long g() {
        return x.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long h() {
        return o.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long i() {
        return n.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long j() {
        return y.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long k() {
        return s.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long l() {
        return t.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long m() {
        return f7291g.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long n() {
        return f7292h.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long o() {
        return f7296l.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long p() {
        return B.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long q() {
        return f7293i.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long r() {
        return J.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long s() {
        return C.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long t() {
        return f7294j.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long u() {
        return z.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long v() {
        return H.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long w() {
        return q.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long x() {
        return A.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final String y() {
        return I.n();
    }

    @Override // com.google.android.gms.internal.measurement.l8
    public final long z() {
        return m.n().longValue();
    }
}