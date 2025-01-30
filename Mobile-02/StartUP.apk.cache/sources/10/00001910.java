package com.coinbase.wallet.core.interfaces;

import kotlin.Metadata;

/* compiled from: Refreshable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/core/interfaces/RefreshIntervalCustomizable;", "", "Lcom/coinbase/wallet/core/interfaces/RefreshInterval;", "interval", "Lkotlin/x;", "updateRefreshInterval", "(Lcom/coinbase/wallet/core/interfaces/RefreshInterval;)V", "getRefreshInterval", "()Lcom/coinbase/wallet/core/interfaces/RefreshInterval;", "refreshInterval", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface RefreshIntervalCustomizable {
    RefreshInterval getRefreshInterval();

    void updateRefreshInterval(RefreshInterval refreshInterval);
}