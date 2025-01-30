package com.coinbase.walletlink.extensions;

import com.coinbase.wallet.store.models.EncryptedSharedPrefsStoreKey;
import com.coinbase.walletlink.models.Session;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* compiled from: StoreKeys+WalletLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;", "", "Lcom/coinbase/walletlink/models/Session;", "<anonymous>", "()Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class StoreKeys_WalletLinkKt$sessions$2 extends o implements kotlin.e0.c.a<EncryptedSharedPrefsStoreKey<Session[]>> {
    public static final StoreKeys_WalletLinkKt$sessions$2 INSTANCE = new StoreKeys_WalletLinkKt$sessions$2();

    StoreKeys_WalletLinkKt$sessions$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final EncryptedSharedPrefsStoreKey<Session[]> invoke() {
        return new EncryptedSharedPrefsStoreKey<>("walletlink_session_list", null, Session[].class, 2, null);
    }
}