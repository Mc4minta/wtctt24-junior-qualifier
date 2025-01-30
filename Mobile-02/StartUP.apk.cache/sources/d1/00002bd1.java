package com.coinbase.walletlink.extensions;

import com.coinbase.wallet.store.models.EncryptedSharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.walletlink.models.Session;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: StoreKeys+WalletLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\"-\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u00008@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKeys;", "Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;", "", "Lcom/coinbase/walletlink/models/Session;", "sessions$delegate", "Lkotlin/h;", "getSessions", "(Lcom/coinbase/wallet/store/models/StoreKeys;)Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;", "sessions", "walletlink_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StoreKeys_WalletLinkKt {
    private static final h sessions$delegate;

    static {
        h b2;
        b2 = k.b(StoreKeys_WalletLinkKt$sessions$2.INSTANCE);
        sessions$delegate = b2;
    }

    public static final EncryptedSharedPrefsStoreKey<Session[]> getSessions(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (EncryptedSharedPrefsStoreKey) sessions$delegate.getValue();
    }
}