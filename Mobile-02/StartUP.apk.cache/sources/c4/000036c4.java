package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpStatus;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class r {
    public static q3<Long> A;
    public static q3<Boolean> A0;
    public static q3<Long> B;
    public static q3<Boolean> B0;
    public static q3<Long> C;
    public static q3<Boolean> C0;
    public static q3<Integer> D;
    public static q3<Boolean> D0;
    public static q3<Long> E;
    public static q3<Boolean> E0;
    public static q3<Integer> F;
    public static q3<Boolean> F0;
    public static q3<Integer> G;
    public static q3<Boolean> G0;
    public static q3<Integer> H;
    public static q3<Boolean> H0;
    public static q3<Integer> I;
    public static q3<Boolean> I0;
    public static q3<Integer> J;
    public static q3<Boolean> J0;
    public static q3<Long> K;
    public static q3<Boolean> K0;
    public static q3<Boolean> L;
    public static q3<Boolean> L0;
    public static q3<String> M;
    public static q3<Boolean> M0;
    public static q3<Long> N;
    private static q3<Boolean> N0;
    public static q3<Integer> O;
    public static q3<Boolean> O0;
    public static q3<Double> P;
    public static q3<Boolean> P0;
    public static q3<Integer> Q;
    public static q3<Boolean> Q0;
    public static q3<Integer> R;
    public static q3<Boolean> R0;
    public static q3<Boolean> S;
    public static q3<Boolean> S0;
    public static q3<Boolean> T;
    public static q3<Boolean> T0;
    public static q3<Boolean> U;
    public static q3<Long> U0;
    public static q3<Boolean> V;
    public static q3<Boolean> W;
    public static q3<Boolean> X;
    public static q3<Boolean> Y;
    public static q3<Boolean> Z;
    public static q3<Boolean> a0;
    public static q3<Boolean> b0;
    public static q3<Boolean> c0;
    public static q3<Boolean> d0;
    public static q3<Boolean> e0;
    private static q3<Boolean> f0;
    public static q3<Boolean> g0;
    public static q3<Boolean> h0;
    public static q3<Boolean> i0;
    public static q3<Boolean> j0;

    /* renamed from: k */
    public static q3<Integer> f7839k;
    public static q3<Boolean> k0;

    /* renamed from: l */
    public static q3<Integer> f7840l;
    public static q3<Boolean> l0;
    public static q3<Integer> m;
    public static q3<Boolean> m0;
    public static q3<Integer> n;
    public static q3<Boolean> n0;
    public static q3<Integer> o;
    public static q3<Boolean> o0;
    public static q3<Integer> p;
    public static q3<Boolean> p0;
    public static q3<Integer> q;
    public static q3<Boolean> q0;
    public static q3<String> r;
    public static q3<Boolean> r0;
    public static q3<Long> s;
    public static q3<Boolean> s0;
    public static q3<Long> t;
    public static q3<Boolean> t0;
    public static q3<Long> u;
    public static q3<Boolean> u0;
    public static q3<Long> v;
    public static q3<Boolean> v0;
    public static q3<Long> w;
    public static q3<Boolean> w0;
    public static q3<Long> x;
    public static q3<Boolean> x0;
    public static q3<Long> y;
    public static q3<Boolean> y0;
    public static q3<Long> z;
    public static q3<Boolean> z0;
    private static List<q3<?>> a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b */
    private static Set<q3<?>> f7830b = Collections.synchronizedSet(new HashSet());

    /* renamed from: c */
    public static q3<Long> f7831c = a("measurement.ad_id_cache_time", 10000L, 10000L, u.a);

    /* renamed from: d */
    public static q3<Long> f7832d = a("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, t.a);

    /* renamed from: e */
    public static q3<Long> f7833e = a("measurement.config.cache_time", 86400000L, 3600000L, h0.a);

    /* renamed from: f */
    public static q3<String> f7834f = a("measurement.config.url_scheme", "https", "https", q0.a);

    /* renamed from: g */
    public static q3<String> f7835g = a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", e1.a);

    /* renamed from: h */
    public static q3<Integer> f7836h = a("measurement.upload.max_bundles", 100, 100, n1.a);

    /* renamed from: i */
    public static q3<Integer> f7837i = a("measurement.upload.max_batch_size", 65536, 65536, a2.a);

    /* renamed from: j */
    public static q3<Integer> f7838j = a("measurement.upload.max_bundle_size", 65536, 65536, k2.a);

    static {
        Integer valueOf = Integer.valueOf((int) RNCWebViewManager.COMMAND_CLEAR_FORM_DATA);
        f7839k = a("measurement.upload.max_events_per_bundle", valueOf, valueOf, x2.a);
        f7840l = a("measurement.upload.max_events_per_day", 100000, 100000, h3.a);
        m = a("measurement.upload.max_error_events_per_day", valueOf, valueOf, w.a);
        n = a("measurement.upload.max_public_events_per_day", 50000, 50000, v.a);
        o = a("measurement.upload.max_conversions_per_day", 10000, 10000, y.a);
        p = a("measurement.upload.max_realtime_events_per_day", 10, 10, x.a);
        q = a("measurement.store.max_stored_events_per_app", 100000, 100000, a0.a);
        r = a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", z.a);
        s = a("measurement.upload.backoff_period", 43200000L, 43200000L, d0.a);
        t = a("measurement.upload.window_interval", 3600000L, 3600000L, c0.a);
        u = a("measurement.upload.interval", 3600000L, 3600000L, f0.a);
        v = a("measurement.upload.realtime_upload_interval", 10000L, 10000L, e0.a);
        w = a("measurement.upload.debug_upload_interval", 1000L, 1000L, g0.a);
        x = a("measurement.upload.minimum_delay", 500L, 500L, j0.a);
        y = a("measurement.alarm_manager.minimum_interval", 60000L, 60000L, i0.a);
        z = a("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, l0.a);
        A = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, k0.a);
        B = a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, n0.a);
        C = a("measurement.upload.retry_time", 1800000L, 1800000L, m0.a);
        D = a("measurement.upload.retry_count", 6, 6, p0.a);
        E = a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, o0.a);
        F = a("measurement.lifetimevalue.max_currency_tracked", 4, 4, r0.a);
        G = a("measurement.audience.filter_result_max_count", 200, 200, t0.a);
        H = a("measurement.upload.max_public_user_properties", 25, 25, null);
        Integer valueOf2 = Integer.valueOf((int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        I = a("measurement.upload.max_event_name_cardinality", valueOf2, valueOf2, null);
        J = a("measurement.upload.max_public_event_params", 25, 25, null);
        K = a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, s0.a);
        Boolean bool = Boolean.FALSE;
        L = a("measurement.test.boolean_flag", bool, bool, v0.a);
        M = a("measurement.test.string_flag", "---", "---", u0.a);
        N = a("measurement.test.long_flag", -1L, -1L, x0.a);
        O = a("measurement.test.int_flag", -2, -2, w0.a);
        Double valueOf3 = Double.valueOf(-3.0d);
        P = a("measurement.test.double_flag", valueOf3, valueOf3, z0.a);
        Q = a("measurement.experiment.max_ids", 50, 50, y0.a);
        R = a("measurement.max_bundles_per_iteration", 2, 2, b1.a);
        S = a("measurement.validation.internal_limits_internal_event_params", bool, bool, a1.a);
        Boolean bool2 = Boolean.TRUE;
        T = a("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", bool2, bool2, d1.a);
        U = a("measurement.collection.firebase_global_collection_flag_enabled", bool2, bool2, g1.a);
        V = a("measurement.collection.efficient_engagement_reporting_enabled_2", bool2, bool2, f1.a);
        W = a("measurement.collection.redundant_engagement_removal_enabled", bool, bool, i1.a);
        X = a("measurement.client.freeride_engagement_fix", bool2, bool2, h1.a);
        Y = a("measurement.experiment.enable_experiment_reporting", bool2, bool2, k1.a);
        Z = a("measurement.collection.log_event_and_bundle_v2", bool2, bool2, j1.a);
        a0 = a("measurement.quality.checksum", bool, bool, null);
        b0 = a("measurement.sdk.dynamite.use_dynamite3", bool2, bool2, m1.a);
        c0 = a("measurement.sdk.dynamite.allow_remote_dynamite", bool, bool, l1.a);
        d0 = a("measurement.sdk.collection.validate_param_names_alphabetical", bool2, bool2, o1.a);
        e0 = a("measurement.collection.event_safelist", bool2, bool2, q1.a);
        f0 = a("measurement.service.audience.invalidate_config_cache_after_app_unisntall", bool2, bool2, p1.a);
        g0 = a("measurement.service.audience.fix_skip_audience_with_failed_filters", bool2, bool2, s1.a);
        h0 = a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, r1.a);
        i0 = a("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, u1.a);
        j0 = a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, t1.a);
        k0 = a("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, w1.a);
        l0 = a("measurement.sdk.collection.last_deep_link_referrer2", bool2, bool2, v1.a);
        m0 = a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, y1.a);
        n0 = a("measurement.sdk.collection.last_gclid_from_referrer2", bool, bool, x1.a);
        o0 = a("measurement.sdk.collection.enable_extend_user_property_size", bool2, bool2, z1.a);
        p0 = a("measurement.upload.file_lock_state_check", bool, bool, c2.a);
        q0 = a("measurement.sampling.calculate_bundle_timestamp_before_sampling", bool2, bool2, b2.a);
        r0 = a("measurement.ga.ga_app_id", bool, bool, f2.a);
        s0 = a("measurement.lifecycle.app_backgrounded_tracking", bool2, bool2, e2.a);
        t0 = a("measurement.lifecycle.app_in_background_parameter", bool, bool, h2.a);
        u0 = a("measurement.integration.disable_firebase_instance_id", bool, bool, g2.a);
        v0 = a("measurement.lifecycle.app_backgrounded_engagement", bool, bool, j2.a);
        w0 = a("measurement.collection.service.update_with_analytics_fix", bool, bool, i2.a);
        x0 = a("measurement.service.use_appinfo_modified", bool, bool, l2.a);
        y0 = a("measurement.client.firebase_feature_rollout.v1.enable", bool2, bool2, n2.a);
        z0 = a("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, m2.a);
        A0 = a("measurement.config.string.always_update_disk_on_set", bool2, bool2, p2.a);
        B0 = a("measurement.scheduler.task_thread.cleanup_on_exit", bool, bool, o2.a);
        C0 = a("measurement.upload.file_truncate_fix", bool, bool, r2.a);
        D0 = a("measurement.engagement_time_main_thread", bool2, bool2, q2.a);
        E0 = a("measurement.sdk.referrer.delayed_install_referrer_api", bool, bool, t2.a);
        F0 = a("measurement.sdk.screen.disabling_automatic_reporting", bool2, bool2, s2.a);
        G0 = a("measurement.sdk.screen.manual_screen_view_logging", bool2, bool2, v2.a);
        H0 = a("measurement.gold.enhanced_ecommerce.format_logs", bool, bool, u2.a);
        Boolean bool3 = Boolean.FALSE;
        I0 = a("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", bool3, bool3, w2.a);
        J0 = a("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", bool3, bool3, z2.a);
        K0 = a("measurement.gold.enhanced_ecommerce.log_nested_complex_events", bool3, bool3, y2.a);
        L0 = a("measurement.gold.enhanced_ecommerce.updated_schema.client", bool3, bool3, b3.a);
        M0 = a("measurement.gold.enhanced_ecommerce.updated_schema.service", bool3, bool3, a3.a);
        N0 = a("measurement.collection.synthetic_data_mitigation", bool3, bool3, d3.a);
        O0 = a("measurement.service.configurable_service_limits", bool3, bool3, c3.a);
        P0 = a("measurement.client.configurable_service_limits", bool3, bool3, g3.a);
        Boolean bool4 = Boolean.TRUE;
        Q0 = a("measurement.androidId.delete_feature", bool4, bool4, f3.a);
        R0 = a("measurement.client.global_params.dev", bool3, bool3, i3.a);
        S0 = a("measurement.client.string_reader", bool4, bool4, k3.a);
        T0 = a("measurement.sdk.attribution.cache", bool4, bool4, j3.a);
        U0 = a("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, m3.a);
    }

    private static <V> q3<V> a(String str, V v2, V v3, o3<V> o3Var) {
        q3<V> q3Var = new q3<>(str, v2, v3, o3Var);
        a.add(q3Var);
        return q3Var;
    }

    public static Map<String, String> c(Context context) {
        com.google.android.gms.internal.measurement.i1 a2 = com.google.android.gms.internal.measurement.i1.a(context.getContentResolver(), com.google.android.gms.internal.measurement.u1.a("com.google.android.gms.measurement"));
        return a2 == null ? Collections.emptyMap() : a2.b();
    }

    public static final /* synthetic */ Long r0() {
        ja jaVar = n3.a;
        return Long.valueOf(com.google.android.gms.internal.measurement.m8.k());
    }
}