package com.coinbase.wallet.analytics.extensions;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.exceptions.PreserveStackTraceException;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.EventProperty;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import h.c.b0;
import h.c.m0.f;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.l0.y;

/* compiled from: Single+Analytics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u001aE\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001aI\u0010\f\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00018\u00008\u0000 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001aI\u0010\u000e\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00018\u00008\u0000 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\r\u001aI\u0010\u000f\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00018\u00008\u0000 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\r\u001aQ\u0010\u0012\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00018\u00008\u0000 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013\u001aY\u0010\u0015\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00018\u00008\u0000 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"T", "Lh/c/b0;", "", "msg", "", "Lcom/coinbase/wallet/analytics/models/EventProperty;", "properties", "logError", "(Lh/c/b0;Ljava/lang/String;Ljava/util/Map;)Lh/c/b0;", "Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "event", "kotlin.jvm.PlatformType", "onSubscribeTrack", "(Lh/c/b0;Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;)Lh/c/b0;", "onSuccessTrack", "onErrorTrack", "success", "error", "onCompleteTrack", "(Lh/c/b0;Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;)Lh/c/b0;", "subscribe", "onEventTrack", "(Lh/c/b0;Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;)Lh/c/b0;", "analytics_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Single_AnalyticsKt {
    public static /* synthetic */ void a(AnalyticsEvent analyticsEvent, Object obj) {
        m630onSuccessTrack$lambda2(analyticsEvent, obj);
    }

    public static /* synthetic */ void b(AnalyticsEvent analyticsEvent, Throwable th) {
        m628onErrorTrack$lambda3(analyticsEvent, th);
    }

    public static /* synthetic */ void c(String str, Map map, StackTraceElement[] stackTraceElementArr, Throwable th) {
        m627logError$lambda0(str, map, stackTraceElementArr, th);
    }

    public static /* synthetic */ void d(AnalyticsEvent analyticsEvent, h.c.k0.b bVar) {
        m629onSubscribeTrack$lambda1(analyticsEvent, bVar);
    }

    public static final <T> b0<T> logError(b0<T> b0Var, final String str, final Map<EventProperty, String> properties) {
        m.g(b0Var, "<this>");
        m.g(properties, "properties");
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        b0<T> doOnError = b0Var.doOnError(new f() { // from class: com.coinbase.wallet.analytics.extensions.d
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                Single_AnalyticsKt.c(str, properties, stackTrace, (Throwable) obj);
            }
        });
        m.f(doOnError, "doOnError {\n        val errorMessage = listOfNotNull(msg, it.localizedMessage).joinToString(Strings.space)\n        val errorEvent = AnalyticsEvent.generalError(errorMessage, properties)\n\n        Timber.e(PreserveStackTraceException(it, originalStackTrace), \"Caught exception $errorMessage\".trim())\n        Analytics.log(errorEvent)\n    }");
        return doOnError;
    }

    public static /* synthetic */ b0 logError$default(b0 b0Var, String str, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            map = m0.i();
        }
        return logError(b0Var, str, map);
    }

    /* renamed from: logError$lambda-0 */
    public static final void m627logError$lambda0(String str, Map properties, StackTraceElement[] originalStackTrace, Throwable it) {
        List l2;
        String h0;
        CharSequence h1;
        m.g(properties, "$properties");
        l2 = r.l(str, it.getLocalizedMessage());
        h0 = z.h0(l2, Strings_CoreKt.getSpace(Strings.INSTANCE), null, null, 0, null, null, 62, null);
        AnalyticsEvent generalError = AnalyticsEvent_AnalyticsKt.generalError(AnalyticsEvent.Companion, h0, properties);
        m.f(it, "it");
        m.f(originalStackTrace, "originalStackTrace");
        PreserveStackTraceException preserveStackTraceException = new PreserveStackTraceException(it, originalStackTrace);
        String o = m.o("Caught exception ", h0);
        Objects.requireNonNull(o, "null cannot be cast to non-null type kotlin.CharSequence");
        h1 = y.h1(o);
        l.a.a.f(preserveStackTraceException, h1.toString(), new Object[0]);
        Analytics.INSTANCE.log(generalError);
    }

    public static final <T> b0<T> onCompleteTrack(b0<T> b0Var, AnalyticsEvent success, AnalyticsEvent error) {
        m.g(b0Var, "<this>");
        m.g(success, "success");
        m.g(error, "error");
        b0 onSuccessTrack = onSuccessTrack(b0Var, success);
        m.f(onSuccessTrack, "onSuccessTrack(success)");
        return onErrorTrack(onSuccessTrack, error);
    }

    public static final <T> b0<T> onErrorTrack(b0<T> b0Var, final AnalyticsEvent event) {
        m.g(b0Var, "<this>");
        m.g(event, "event");
        return b0Var.doOnError(new f() { // from class: com.coinbase.wallet.analytics.extensions.c
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                Single_AnalyticsKt.b(AnalyticsEvent.this, (Throwable) obj);
            }
        });
    }

    /* renamed from: onErrorTrack$lambda-3 */
    public static final void m628onErrorTrack$lambda3(AnalyticsEvent event, Throwable th) {
        m.g(event, "$event");
        Analytics.INSTANCE.log(event);
    }

    public static final <T> b0<T> onEventTrack(b0<T> b0Var, AnalyticsEvent subscribe, AnalyticsEvent success, AnalyticsEvent error) {
        m.g(b0Var, "<this>");
        m.g(subscribe, "subscribe");
        m.g(success, "success");
        m.g(error, "error");
        b0 onSubscribeTrack = onSubscribeTrack(b0Var, subscribe);
        m.f(onSubscribeTrack, "onSubscribeTrack(subscribe)");
        b0 onSuccessTrack = onSuccessTrack(onSubscribeTrack, success);
        m.f(onSuccessTrack, "onSubscribeTrack(subscribe)\n    .onSuccessTrack(success)");
        return onErrorTrack(onSuccessTrack, error);
    }

    public static final <T> b0<T> onSubscribeTrack(b0<T> b0Var, final AnalyticsEvent event) {
        m.g(b0Var, "<this>");
        m.g(event, "event");
        return b0Var.doOnSubscribe(new f() { // from class: com.coinbase.wallet.analytics.extensions.e
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                Single_AnalyticsKt.d(AnalyticsEvent.this, (h.c.k0.b) obj);
            }
        });
    }

    /* renamed from: onSubscribeTrack$lambda-1 */
    public static final void m629onSubscribeTrack$lambda1(AnalyticsEvent event, h.c.k0.b bVar) {
        m.g(event, "$event");
        Analytics.INSTANCE.log(event);
    }

    public static final <T> b0<T> onSuccessTrack(b0<T> b0Var, final AnalyticsEvent event) {
        m.g(b0Var, "<this>");
        m.g(event, "event");
        return b0Var.doOnSuccess(new f() { // from class: com.coinbase.wallet.analytics.extensions.b
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                Single_AnalyticsKt.a(AnalyticsEvent.this, obj);
            }
        });
    }

    /* renamed from: onSuccessTrack$lambda-2 */
    public static final void m630onSuccessTrack$lambda2(AnalyticsEvent event, Object obj) {
        m.g(event, "$event");
        Analytics.INSTANCE.log(event);
    }
}