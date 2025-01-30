package com.coinbase.wallet.wallets.extensions;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: StoreKeys+Wallets.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\b\u0010\u0006\u001a)\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\f\"'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0003*\u00020\u00008@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKeys;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "Lcom/coinbase/wallet/blockchains/models/Network;", "activeNetwork", "(Lcom/coinbase/wallet/store/models/StoreKeys;Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "", "activeIndex", "network", "", "isWalletSynced", "(Lcom/coinbase/wallet/store/models/StoreKeys;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "activeCurrency$delegate", "Lkotlin/h;", "getActiveCurrency", "(Lcom/coinbase/wallet/store/models/StoreKeys;)Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "activeCurrency", "wallets_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StoreKeys_WalletsKt {
    private static final h activeCurrency$delegate;

    static {
        h b2;
        b2 = k.b(StoreKeys_WalletsKt$activeCurrency$2.INSTANCE);
        activeCurrency$delegate = b2;
    }

    public static final SharedPrefsStoreKey<Integer> activeIndex(StoreKeys storeKeys, Blockchain blockchain) {
        m.g(storeKeys, "<this>");
        m.g(blockchain, "blockchain");
        return new SharedPrefsStoreKey<>("activeAddressIndex", blockchain.getRawValue(), false, Integer.TYPE, 4, null);
    }

    public static final SharedPrefsStoreKey<Network> activeNetwork(StoreKeys storeKeys, Blockchain blockchain) {
        m.g(storeKeys, "<this>");
        m.g(blockchain, "blockchain");
        return new SharedPrefsStoreKey<>("activeNetwork", blockchain.getRawValue(), false, Network.class, 4, null);
    }

    public static final SharedPrefsStoreKey<FiatCurrency> getActiveCurrency(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return (SharedPrefsStoreKey) activeCurrency$delegate.getValue();
    }

    public static final SharedPrefsStoreKey<Boolean> isWalletSynced(StoreKeys storeKeys, Blockchain blockchain, Network network) {
        List j2;
        String h0;
        m.g(storeKeys, "<this>");
        m.g(blockchain, "blockchain");
        m.g(network, "network");
        j2 = r.j(blockchain.getRawValue(), network.getRawValue());
        h0 = z.h0(j2, "/", null, null, 0, null, null, 62, null);
        Locale US = Locale.US;
        m.f(US, "US");
        Objects.requireNonNull(h0, "null cannot be cast to non-null type java.lang.String");
        String upperCase = h0.toUpperCase(US);
        m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return new SharedPrefsStoreKey<>("isWalletSynced", upperCase, false, Boolean.TYPE, 4, null);
    }
}