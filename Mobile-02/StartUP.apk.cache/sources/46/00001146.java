package com.coinbase.wallet.analytics.extensions;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.exceptions.PreserveStackTraceException;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.EventProperty;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import h.c.m0.f;
import h.c.s;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.l0.y;

/* compiled from: Observable+Analytics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aE\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"T", "Lh/c/s;", "", "msg", "", "Lcom/coinbase/wallet/analytics/models/EventProperty;", "properties", "logError", "(Lh/c/s;Ljava/lang/String;Ljava/util/Map;)Lh/c/s;", "analytics_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Observable_AnalyticsKt {
    public static /* synthetic */ void a(String str, Map map, StackTraceElement[] stackTraceElementArr, Throwable th) {
        m626logError$lambda0(str, map, stackTraceElementArr, th);
    }

    public static final <T> s<T> logError(s<T> sVar, final String str, final Map<EventProperty, String> properties) {
        m.g(sVar, "<this>");
        m.g(properties, "properties");
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        s<T> doOnError = sVar.doOnError(new f() { // from class: com.coinbase.wallet.analytics.extensions.a
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                Observable_AnalyticsKt.a(str, properties, stackTrace, (Throwable) obj);
            }
        });
        m.f(doOnError, "doOnError {\n        val errorMessage = listOfNotNull(msg, it.localizedMessage).joinToString(Strings.space)\n        val errorEvent = AnalyticsEvent.generalError(errorMessage, properties)\n\n        Timber.e(PreserveStackTraceException(it, originalStackTrace), \"Caught exception $errorMessage\".trim())\n        Analytics.log(errorEvent)\n    }");
        return doOnError;
    }

    public static /* synthetic */ s logError$default(s sVar, String str, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            map = m0.i();
        }
        return logError(sVar, str, map);
    }

    /* renamed from: logError$lambda-0 */
    public static final void m626logError$lambda0(String str, Map properties, StackTraceElement[] originalStackTrace, Throwable it) {
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
}