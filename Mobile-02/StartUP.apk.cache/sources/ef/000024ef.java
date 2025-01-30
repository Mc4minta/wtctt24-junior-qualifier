package com.coinbase.wallet.performance;

import android.os.Build;
import c.e.e;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.core.util.RxSchedulers;
import com.google.firebase.perf.metrics.Trace;
import h.c.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Tracer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ/\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R&\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0015j\u0002`\u00160\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/performance/Tracer;", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "Lcom/coinbase/wallet/core/models/TraceKey;", "", "methodName", "(Lcom/coinbase/wallet/core/models/TraceKey;)Ljava/lang/String;", "traceKey", "Lkotlin/x;", "start", "(Lcom/coinbase/wallet/core/models/TraceKey;)V", "stop", "T", ApiConstants.NAME, "Lkotlin/Function0;", "block", "trace", "(Ljava/lang/String;Lkotlin/e0/c/a;)Ljava/lang/Object;", "Lh/c/a0;", "performanceMonitoringScheduler", "Lh/c/a0;", "Lc/e/e;", "Lcom/google/firebase/perf/metrics/Trace;", "Lcom/coinbase/wallet/performance/FirebaseTrace;", "firebaseMap", "Lc/e/e;", "descriptorMap", "<init>", "()V", "performance_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Tracer implements Tracing {
    public static final Tracer INSTANCE = new Tracer();
    private static final e<TraceKey, Trace> firebaseMap = new e<>(5000);
    private static final e<TraceKey, String> descriptorMap = new e<>(5000);
    private static final a0 performanceMonitoringScheduler = RxSchedulers.INSTANCE.newSerialScheduler();

    private Tracer() {
    }

    public static /* synthetic */ void a(TraceKey traceKey) {
        m1618start$lambda1(traceKey);
    }

    public static /* synthetic */ void b(TraceKey traceKey) {
        m1620stop$lambda4(traceKey);
    }

    private final String methodName(TraceKey traceKey) {
        String str = traceKey.isNoisy() ? "ctz " : "ct ";
        String o = traceKey.getDescriptor() == null ? "" : m.o(" ", traceKey.getDescriptor());
        return str + traceKey.getName() + o;
    }

    /* renamed from: start$lambda-1 */
    public static final void m1618start$lambda1(TraceKey traceKey) {
        m.g(traceKey, "$traceKey");
        Trace d2 = com.google.firebase.perf.a.b().d(traceKey.getName());
        d2.start();
        m.f(d2, "getInstance()\n                    .newTrace(traceKey.name)\n                    .also { it.start() }");
        firebaseMap.d(traceKey, d2);
    }

    /* renamed from: start$lambda-3 */
    private static final void m1619start$lambda3(TraceKey traceKey) {
        m.g(traceKey, "$traceKey");
        String descriptor = traceKey.getDescriptor();
        if (descriptor != null) {
            descriptorMap.d(traceKey, descriptor);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            android.os.Trace.beginAsyncSection(INSTANCE.methodName(traceKey), traceKey.getUuid());
        } else {
            android.os.Trace.beginSection(INSTANCE.methodName(traceKey));
        }
    }

    /* renamed from: stop$lambda-4 */
    public static final void m1620stop$lambda4(TraceKey traceKey) {
        m.g(traceKey, "$traceKey");
        e<TraceKey, Trace> eVar = firebaseMap;
        Trace c2 = eVar.c(traceKey);
        if (c2 != null) {
            c2.stop();
        }
        eVar.e(traceKey);
    }

    /* renamed from: stop$lambda-6 */
    private static final void m1621stop$lambda6(TraceKey traceKey) {
        m.g(traceKey, "$traceKey");
        e<TraceKey, String> eVar = descriptorMap;
        String c2 = eVar.c(traceKey);
        if (c2 != null) {
            traceKey.setDescriptor(c2);
        }
        eVar.e(traceKey);
        if (Build.VERSION.SDK_INT >= 29) {
            android.os.Trace.endAsyncSection(INSTANCE.methodName(traceKey), traceKey.getUuid());
        } else {
            android.os.Trace.endSection();
        }
    }

    @Override // com.coinbase.wallet.core.interfaces.Tracing
    public void start(final TraceKey traceKey) {
        m.g(traceKey, "traceKey");
        if (traceKey.isRemoteTrace()) {
            performanceMonitoringScheduler.c(new Runnable() { // from class: com.coinbase.wallet.performance.a
                @Override // java.lang.Runnable
                public final void run() {
                    Tracer.a(TraceKey.this);
                }
            });
        }
    }

    @Override // com.coinbase.wallet.core.interfaces.Tracing
    public void stop(final TraceKey traceKey) {
        m.g(traceKey, "traceKey");
        if (traceKey.isRemoteTrace()) {
            performanceMonitoringScheduler.c(new Runnable() { // from class: com.coinbase.wallet.performance.b
                @Override // java.lang.Runnable
                public final void run() {
                    Tracer.b(TraceKey.this);
                }
            });
        }
    }

    public final <T> T trace(String name, kotlin.e0.c.a<? extends T> block) {
        m.g(name, "name");
        m.g(block, "block");
        android.os.Trace.beginSection(name);
        T invoke = block.invoke();
        android.os.Trace.endSection();
        return invoke;
    }
}