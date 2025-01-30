package com.coinbase.wallet.txhistory.extensions;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.store.models.MemoryStoreKey;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: StoreKeys+TxHistory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000f\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\t*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKeys;", "", "address", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "", "hasSyncedEthereumTxHistory", "(Lcom/coinbase/wallet/store/models/StoreKeys;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "isSyncingEthereumTxHistory", "(Lcom/coinbase/wallet/store/models/StoreKeys;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "hasSyncedTxHistory", "(Lcom/coinbase/wallet/store/models/StoreKeys;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "isSyncingTxHistory", "(Lcom/coinbase/wallet/store/models/StoreKeys;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "txhistory_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StoreKeys_TxHistoryKt {
    public static final SharedPrefsStoreKey<Boolean> hasSyncedEthereumTxHistory(StoreKeys storeKeys, String address, Network network) {
        m.g(storeKeys, "<this>");
        m.g(address, "address");
        m.g(network, "network");
        return new SharedPrefsStoreKey<>("hasSyncedEthereumTxHistory", address + '_' + network.getRawValue(), false, Boolean.TYPE, 4, null);
    }

    public static final SharedPrefsStoreKey<Boolean> hasSyncedTxHistory(StoreKeys storeKeys, CurrencyCode currencyCode, Network network) {
        m.g(storeKeys, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        return new SharedPrefsStoreKey<>("hasSyncedTxHistory", currencyCode.getRawValue() + '_' + network.getRawValue(), false, Boolean.TYPE, 4, null);
    }

    public static final MemoryStoreKey<Boolean> isSyncingEthereumTxHistory(StoreKeys storeKeys, String address, Network network) {
        m.g(storeKeys, "<this>");
        m.g(address, "address");
        m.g(network, "network");
        return new MemoryStoreKey<>("isSyncingEthereumTxHistory", address + '_' + network.getRawValue(), false, Boolean.TYPE, 4, null);
    }

    public static final MemoryStoreKey<Boolean> isSyncingTxHistory(StoreKeys storeKeys, CurrencyCode currencyCode, Network network) {
        m.g(storeKeys, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        return new MemoryStoreKey<>("isSyncingTxHistory", currencyCode.getRawValue() + '_' + network.getRawValue(), false, Boolean.TYPE, 4, null);
    }
}