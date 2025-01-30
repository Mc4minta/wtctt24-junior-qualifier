package com.coinbase.wallet.routing.models;

import com.coinbase.wallet.swap.models.SwapAsset;
import kotlin.Metadata;

/* compiled from: DeeplinkDestination.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/routing/models/SwapDeepLinkDestination;", "Lcom/coinbase/wallet/routing/models/DeeplinkDestination;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "targetAsset", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "getTargetAsset", "()Lcom/coinbase/wallet/swap/models/SwapAsset;", "<init>", "(Lcom/coinbase/wallet/swap/models/SwapAsset;)V", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapDeepLinkDestination extends DeeplinkDestination {
    private final SwapAsset targetAsset;

    public SwapDeepLinkDestination(SwapAsset swapAsset) {
        super(null);
        this.targetAsset = swapAsset;
    }

    public final SwapAsset getTargetAsset() {
        return this.targetAsset;
    }
}