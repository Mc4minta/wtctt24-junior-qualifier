package com.coinbase.wallet.wallets.extensions;

import com.coinbase.wallet.core.models.TraceKey;
import kotlin.Metadata;
import kotlin.h0.c;
import kotlin.jvm.internal.m;

/* compiled from: TraceKey+Wallets.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0007\u001a\u00020\u0004*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\u0004*\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/core/models/TraceKey$Companion;", "", "repoName", "requestId", "Lcom/coinbase/wallet/core/models/TraceKey;", "walletRepositoryRefreshTrace", "(Lcom/coinbase/wallet/core/models/TraceKey$Companion;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/core/models/TraceKey;", "txRepositoryRefreshTrace", "(Lcom/coinbase/wallet/core/models/TraceKey$Companion;)Lcom/coinbase/wallet/core/models/TraceKey;", "exchangeRateRefreshTrace", "wallets_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TraceKey_WalletsKt {
    public static final TraceKey exchangeRateRefreshTrace(TraceKey.Companion companion) {
        m.g(companion, "<this>");
        return new TraceKey("ExchangeRateRepository#refresh", c.f17279b.c(), false, false, 12, null);
    }

    public static final TraceKey txRepositoryRefreshTrace(TraceKey.Companion companion) {
        m.g(companion, "<this>");
        return new TraceKey("TxRepository#refresh", c.f17279b.c(), false, false, 12, null);
    }

    public static final TraceKey walletRepositoryRefreshTrace(TraceKey.Companion companion, String repoName, String requestId) {
        m.g(companion, "<this>");
        m.g(repoName, "repoName");
        m.g(requestId, "requestId");
        return new TraceKey(m.o("WalletRepository#refreshRepository ", repoName), requestId.hashCode(), false, false, 12, null);
    }
}