package com.coinbase.wallet.features.send.extensions;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.store.models.MemoryStoreKey;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: StoreKeys+Send.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\"'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"'\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\f\"'\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"'\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKeys;", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "blockchainForSend$delegate", "Lkotlin/h;", "getBlockchainForSend", "(Lcom/coinbase/wallet/store/models/StoreKeys;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "blockchainForSend", "Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "", "cachedCryptoAmount$delegate", "getCachedCryptoAmount", "(Lcom/coinbase/wallet/store/models/StoreKeys;)Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "cachedCryptoAmount", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "currencyCodeForSend$delegate", "getCurrencyCodeForSend", "currencyCodeForSend", "", "shouldShowAutoMinerFeePrompt$delegate", "getShouldShowAutoMinerFeePrompt", "shouldShowAutoMinerFeePrompt", "isFiatSelectedForSend$delegate", "isFiatSelectedForSend", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class StoreKeys_SendKt {
    private static final h blockchainForSend$delegate;
    private static final h cachedCryptoAmount$delegate;
    private static final h currencyCodeForSend$delegate;
    private static final h isFiatSelectedForSend$delegate;
    private static final h shouldShowAutoMinerFeePrompt$delegate;

    static {
        h b2;
        h b3;
        h b4;
        h b5;
        h b6;
        b2 = k.b(StoreKeys_SendKt$isFiatSelectedForSend$2.INSTANCE);
        isFiatSelectedForSend$delegate = b2;
        b3 = k.b(StoreKeys_SendKt$currencyCodeForSend$2.INSTANCE);
        currencyCodeForSend$delegate = b3;
        b4 = k.b(StoreKeys_SendKt$blockchainForSend$2.INSTANCE);
        blockchainForSend$delegate = b4;
        b5 = k.b(StoreKeys_SendKt$cachedCryptoAmount$2.INSTANCE);
        cachedCryptoAmount$delegate = b5;
        b6 = k.b(StoreKeys_SendKt$shouldShowAutoMinerFeePrompt$2.INSTANCE);
        shouldShowAutoMinerFeePrompt$delegate = b6;
    }

    public static final SharedPrefsStoreKey<Blockchain> getBlockchainForSend(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (SharedPrefsStoreKey) blockchainForSend$delegate.getValue();
    }

    public static final MemoryStoreKey<String> getCachedCryptoAmount(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (MemoryStoreKey) cachedCryptoAmount$delegate.getValue();
    }

    public static final SharedPrefsStoreKey<CurrencyCode> getCurrencyCodeForSend(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (SharedPrefsStoreKey) currencyCodeForSend$delegate.getValue();
    }

    public static final SharedPrefsStoreKey<Boolean> getShouldShowAutoMinerFeePrompt(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (SharedPrefsStoreKey) shouldShowAutoMinerFeePrompt$delegate.getValue();
    }

    public static final SharedPrefsStoreKey<Boolean> isFiatSelectedForSend(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (SharedPrefsStoreKey) isFiatSelectedForSend$delegate.getValue();
    }
}