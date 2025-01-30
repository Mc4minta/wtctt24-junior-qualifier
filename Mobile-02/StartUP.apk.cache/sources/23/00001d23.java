package com.coinbase.wallet.featureflags.extensions;

import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.store.models.EncryptedSharedPrefsStoreKey;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: StoreKeys+FeatureFlags.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0005\"'\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKeys;", "Lcom/coinbase/wallet/featureflags/models/FeatureFlag;", "featureFlag", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "", "(Lcom/coinbase/wallet/store/models/StoreKeys;Lcom/coinbase/wallet/featureflags/models/FeatureFlag;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "isFeatureFlagOverridden", "Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;", "", "accessToken$delegate", "Lkotlin/h;", "getAccessToken", "(Lcom/coinbase/wallet/store/models/StoreKeys;)Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;", "accessToken", "featureflags_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class StoreKeys_FeatureFlagsKt {
    private static final h accessToken$delegate;

    static {
        h b2;
        b2 = k.b(StoreKeys_FeatureFlagsKt$accessToken$2.INSTANCE);
        accessToken$delegate = b2;
    }

    public static final SharedPrefsStoreKey<Boolean> featureFlag(StoreKeys storeKeys, FeatureFlag featureFlag) {
        m.g(storeKeys, "<this>");
        m.g(featureFlag, "featureFlag");
        return new SharedPrefsStoreKey<>("featureFlags", featureFlag.getValue(), false, Boolean.TYPE, 4, null);
    }

    public static final EncryptedSharedPrefsStoreKey<String> getAccessToken(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (EncryptedSharedPrefsStoreKey) accessToken$delegate.getValue();
    }

    public static final SharedPrefsStoreKey<Boolean> isFeatureFlagOverridden(StoreKeys storeKeys, FeatureFlag featureFlag) {
        m.g(storeKeys, "<this>");
        m.g(featureFlag, "featureFlag");
        return new SharedPrefsStoreKey<>("isFeatureFlagOverridden", featureFlag.getValue(), false, Boolean.TYPE, 4, null);
    }
}