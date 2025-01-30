package com.coinbase.wallet.ripple.extensions;

import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.m;

/* compiled from: StoreKeys+Ripple.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKeys;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "Lkotlin/UInt;", "xrpLedgerVersion", "(Lcom/coinbase/wallet/store/models/StoreKeys;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "ripple_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StoreKeys_RippleKt {
    public static final SharedPrefsStoreKey<UInt> xrpLedgerVersion(StoreKeys storeKeys, Network network) {
        m.g(storeKeys, "<this>");
        m.g(network, "network");
        return new SharedPrefsStoreKey<>("xrpLedgerVersion", network.getRawValue(), false, UInt.class, 4, null);
    }
}