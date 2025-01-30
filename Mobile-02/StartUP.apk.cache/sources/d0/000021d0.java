package com.coinbase.wallet.features.swap.extensions;

import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: StoreKeys+Swap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\"'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKeys;", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "", "swapUserAgreementViewed$delegate", "Lkotlin/h;", "getSwapUserAgreementViewed", "(Lcom/coinbase/wallet/store/models/StoreKeys;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "swapUserAgreementViewed", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class StoreKeys_SwapKt {
    private static final h swapUserAgreementViewed$delegate;

    static {
        h b2;
        b2 = k.b(StoreKeys_SwapKt$swapUserAgreementViewed$2.INSTANCE);
        swapUserAgreementViewed$delegate = b2;
    }

    public static final SharedPrefsStoreKey<Boolean> getSwapUserAgreementViewed(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (SharedPrefsStoreKey) swapUserAgreementViewed$delegate.getValue();
    }
}