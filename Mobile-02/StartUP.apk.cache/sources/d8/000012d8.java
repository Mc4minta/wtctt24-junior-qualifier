package com.coinbase.wallet.bip44wallets.extensions;

import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.core.models.TraceKey;
import kotlin.Metadata;
import kotlin.h0.c;
import kotlin.jvm.internal.m;
import org.apache.http.message.TokenParser;

/* compiled from: TraceKey+BIP44Wallets.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/core/models/TraceKey$Companion;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext;", "context", "Lcom/coinbase/wallet/core/models/TraceKey;", "refreshBalancesTrace", "(Lcom/coinbase/wallet/core/models/TraceKey$Companion;Lcom/coinbase/wallet/blockchains/models/RefreshContext;)Lcom/coinbase/wallet/core/models/TraceKey;", "fetchAddressChangesTrace", "(Lcom/coinbase/wallet/core/models/TraceKey$Companion;)Lcom/coinbase/wallet/core/models/TraceKey;", "bip44wallets_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TraceKey_BIP44WalletsKt {
    public static final TraceKey fetchAddressChangesTrace(TraceKey.Companion companion) {
        m.g(companion, "<this>");
        return new TraceKey("Bip44BalanceManaging#fetchAddressChanges", c.f17279b.c(), false, false, 12, null);
    }

    public static final TraceKey refreshBalancesTrace(TraceKey.Companion companion, RefreshContext context) {
        m.g(companion, "<this>");
        m.g(context, "context");
        return new TraceKey("Bip44BalanceManaging#refreshBalances " + context.getMode() + TokenParser.SP + context.getNetwork(), c.f17279b.c(), false, false, 12, null);
    }
}