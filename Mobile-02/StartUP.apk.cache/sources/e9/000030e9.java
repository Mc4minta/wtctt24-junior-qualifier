package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.d;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public abstract class g {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    public static class a {
        private e.g.a.c.i.w.a a;

        /* renamed from: b  reason: collision with root package name */
        private Map<e.g.a.c.d, b> f5841b = new HashMap();

        public a a(e.g.a.c.d dVar, b bVar) {
            this.f5841b.put(dVar, bVar);
            return this;
        }

        public g b() {
            Objects.requireNonNull(this.a, "missing required property: clock");
            if (this.f5841b.keySet().size() >= e.g.a.c.d.values().length) {
                Map<e.g.a.c.d, b> map = this.f5841b;
                this.f5841b = new HashMap();
                return g.c(this.a, map);
            }
            throw new IllegalStateException("Not all priorities have been configured");
        }

        public a c(e.g.a.c.i.w.a aVar) {
            this.a = aVar;
            return this;
        }
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    public static abstract class b {

        /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
        /* loaded from: classes2.dex */
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j2);

            public abstract a c(Set<c> set);

            public abstract a d(long j2);
        }

        public static a a() {
            return new d.b().c(Collections.emptySet());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long b();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Set<c> c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long d();
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public static a a() {
        return new a();
    }

    static g c(e.g.a.c.i.w.a aVar, Map<e.g.a.c.d, b> map) {
        return new com.google.android.datatransport.runtime.scheduling.jobscheduling.c(aVar, map);
    }

    public static g e(e.g.a.c.i.w.a aVar) {
        return a().a(e.g.a.c.d.DEFAULT, b.a().b(30000L).d(86400000L).a()).a(e.g.a.c.d.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(e.g.a.c.d.VERY_LOW, b.a().b(86400000L).d(86400000L).c(h(c.NETWORK_UNMETERED, c.DEVICE_IDLE)).a()).c(aVar).b();
    }

    private static <T> Set<T> h(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    private void i(JobInfo.Builder builder, Set<c> set) {
        if (set.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public JobInfo.Builder b(JobInfo.Builder builder, e.g.a.c.d dVar, long j2, int i2) {
        builder.setMinimumLatency(f(dVar, j2, i2));
        i(builder, g().get(dVar).c());
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract e.g.a.c.i.w.a d();

    public long f(e.g.a.c.d dVar, long j2, int i2) {
        long a2 = j2 - d().a();
        b bVar = g().get(dVar);
        return Math.min(Math.max(((long) Math.pow(2.0d, i2 - 1)) * bVar.b(), a2), bVar.d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Map<e.g.a.c.d, b> g();
}