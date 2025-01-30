package com.coinbase.wallet.bip44wallets.extensions;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.models.EncryptedSharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.m;

/* compiled from: StoreKeys+BIP44Wallets.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a9\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKeys;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/AddressType;", "addressType", "", "isTestnet", "Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;", "", "xpubKey", "(Lcom/coinbase/wallet/store/models/StoreKeys;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/AddressType;Z)Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;", "bip44wallets_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class StoreKeys_BIP44WalletsKt {
    public static final EncryptedSharedPrefsStoreKey<String> xpubKey(StoreKeys storeKeys, Blockchain blockchain, CurrencyCode currencyCode, AddressType addressType, boolean z) {
        List j2;
        String h0;
        m.g(storeKeys, "<this>");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        m.g(addressType, "addressType");
        j2 = r.j(blockchain.getRawValue(), currencyCode.getRawValue(), addressType.getRawValue(), String.valueOf(z));
        h0 = z.h0(j2, "/", null, null, 0, null, null, 62, null);
        Locale US = Locale.US;
        m.f(US, "US");
        Objects.requireNonNull(h0, "null cannot be cast to non-null type java.lang.String");
        String upperCase = h0.toUpperCase(US);
        m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return new EncryptedSharedPrefsStoreKey<>("BIP44XpubKey", upperCase, String.class);
    }
}