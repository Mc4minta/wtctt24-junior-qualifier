package com.coinbase.wallet.blockchains.interfaces;

import com.coinbase.wallet.blockchains.models.RefreshContext;
import h.c.b0;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: BalanceManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/blockchains/interfaces/BalanceManaging;", "", "Lcom/coinbase/wallet/blockchains/models/RefreshContext;", "context", "Lh/c/b0;", "Lkotlin/x;", "refreshBalances", "(Lcom/coinbase/wallet/blockchains/models/RefreshContext;)Lh/c/b0;", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface BalanceManaging {
    b0<x> refreshBalances(RefreshContext refreshContext);
}