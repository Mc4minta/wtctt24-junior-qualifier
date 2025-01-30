package com.coinbase.wallet.user.extensions;

import com.coinbase.wallet.store.models.EncryptedSharedPrefsStoreKey;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.user.models.User;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: StoreKeys+User.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKeys;", "Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;", "", "refreshToken$delegate", "Lkotlin/h;", "getRefreshToken", "(Lcom/coinbase/wallet/store/models/StoreKeys;)Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;", "refreshToken", "accessToken$delegate", "getAccessToken", "accessToken", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "Lcom/coinbase/wallet/user/models/User;", "activeUser$delegate", "getActiveUser", "(Lcom/coinbase/wallet/store/models/StoreKeys;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "activeUser", "user_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StoreKeys_UserKt {
    private static final h accessToken$delegate;
    private static final h activeUser$delegate;
    private static final h refreshToken$delegate;

    static {
        h b2;
        h b3;
        h b4;
        b2 = k.b(StoreKeys_UserKt$activeUser$2.INSTANCE);
        activeUser$delegate = b2;
        b3 = k.b(StoreKeys_UserKt$accessToken$2.INSTANCE);
        accessToken$delegate = b3;
        b4 = k.b(StoreKeys_UserKt$refreshToken$2.INSTANCE);
        refreshToken$delegate = b4;
    }

    public static final EncryptedSharedPrefsStoreKey<String> getAccessToken(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (EncryptedSharedPrefsStoreKey) accessToken$delegate.getValue();
    }

    public static final SharedPrefsStoreKey<User> getActiveUser(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (SharedPrefsStoreKey) activeUser$delegate.getValue();
    }

    public static final EncryptedSharedPrefsStoreKey<String> getRefreshToken(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (EncryptedSharedPrefsStoreKey) refreshToken$delegate.getValue();
    }
}