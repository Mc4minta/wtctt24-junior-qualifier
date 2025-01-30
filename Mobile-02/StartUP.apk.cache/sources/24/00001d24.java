package com.coinbase.wallet.featureflags.extensions;

import com.coinbase.wallet.store.models.EncryptedSharedPrefsStoreKey;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: StoreKeys+FeatureFlags.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;", "", "<anonymous>", "()Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class StoreKeys_FeatureFlagsKt$accessToken$2 extends o implements a<EncryptedSharedPrefsStoreKey<String>> {
    public static final StoreKeys_FeatureFlagsKt$accessToken$2 INSTANCE = new StoreKeys_FeatureFlagsKt$accessToken$2();

    StoreKeys_FeatureFlagsKt$accessToken$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final EncryptedSharedPrefsStoreKey<String> invoke() {
        return new EncryptedSharedPrefsStoreKey<>("accessToken", null, String.class, 2, null);
    }
}