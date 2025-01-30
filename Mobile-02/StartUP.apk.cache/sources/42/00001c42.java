package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: StoreKeys+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKeys;", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "Ljava/math/BigInteger;", "ethereumBlockHeight", "(Lcom/coinbase/wallet/store/models/StoreKeys;I)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class StoreKeys_EthereumKt {
    public static final SharedPrefsStoreKey<BigInteger> ethereumBlockHeight(StoreKeys storeKeys, int i2) {
        m.g(storeKeys, "<this>");
        return new SharedPrefsStoreKey<>("ethereum_block_height", String.valueOf(i2), false, BigInteger.class, 4, null);
    }
}