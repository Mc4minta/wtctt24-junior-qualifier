package com.coinbase.wallet.core.interfaces;

import com.coinbase.wallet.core.models.TraceKey;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Tracing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/core/interfaces/Tracing;", "", "Lcom/coinbase/wallet/core/models/TraceKey;", "traceKey", "Lkotlin/x;", "start", "(Lcom/coinbase/wallet/core/models/TraceKey;)V", "stop", "Companion", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface Tracing {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Tracing.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/core/interfaces/Tracing$Companion;", "", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "noOpTraceLogger", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "getNoOpTraceLogger", "()Lcom/coinbase/wallet/core/interfaces/Tracing;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Tracing noOpTraceLogger = new Tracing() { // from class: com.coinbase.wallet.core.interfaces.Tracing$Companion$noOpTraceLogger$1
            @Override // com.coinbase.wallet.core.interfaces.Tracing
            public void start(TraceKey traceKey) {
                m.g(traceKey, "traceKey");
            }

            @Override // com.coinbase.wallet.core.interfaces.Tracing
            public void stop(TraceKey traceKey) {
                m.g(traceKey, "traceKey");
            }
        };

        private Companion() {
        }

        public final Tracing getNoOpTraceLogger() {
            return noOpTraceLogger;
        }
    }

    void start(TraceKey traceKey);

    void stop(TraceKey traceKey);
}