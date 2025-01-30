package com.coinbase.wallet.wallets.apis;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.exceptions.WalletException;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.dtos.WatchAddressDTO;
import com.coinbase.wallet.wallets.dtos.WatchAddressParamsDTO;
import com.coinbase.wallet.wallets.dtos.WatchAddressResultDTO;
import h.c.b0;
import h.c.m0.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.apache.http.HttpHost;

/* compiled from: WatchAddressAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/wallets/apis/WatchAddressAPI;", "", "", "", ApiConstants.ADDRESSES, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lh/c/b0;", "Lkotlin/x;", "watchAddresses", "(Ljava/util/List;Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lh/c/b0;", "Lcom/coinbase/wallet/wallets/apis/BlockchainAddressHTTP;", HttpHost.DEFAULT_SCHEME_NAME, "Lcom/coinbase/wallet/wallets/apis/BlockchainAddressHTTP;", "<init>", "(Lcom/coinbase/wallet/wallets/apis/BlockchainAddressHTTP;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WatchAddressAPI {
    private final BlockchainAddressHTTP http;

    public WatchAddressAPI(BlockchainAddressHTTP http) {
        m.g(http, "http");
        this.http = http;
    }

    public static /* synthetic */ x a(Blockchain blockchain, WatchAddressDTO watchAddressDTO) {
        return m1847watchAddresses$lambda0(blockchain, watchAddressDTO);
    }

    /* renamed from: watchAddresses$lambda-0 */
    public static final x m1847watchAddresses$lambda0(Blockchain blockchain, WatchAddressDTO it) {
        m.g(blockchain, "$blockchain");
        m.g(it, "it");
        WatchAddressResultDTO result = it.getResult();
        boolean z = false;
        if (result != null && result.getAdded()) {
            z = true;
        }
        if (z) {
            return x.a;
        }
        throw new WalletException.UnableToWatchAddress(blockchain);
    }

    public final b0<x> watchAddresses(List<String> addresses, final Blockchain blockchain) {
        m.g(addresses, "addresses");
        m.g(blockchain, "blockchain");
        b0 map = this.http.watchAddresses(new WatchAddressParamsDTO(addresses, blockchain.getRawValue())).map(new n() { // from class: com.coinbase.wallet.wallets.apis.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WatchAddressAPI.a(Blockchain.this, (WatchAddressDTO) obj);
            }
        });
        m.f(map, "http.watchAddresses(params).map {\n            if (it.result?.added != true) throw WalletException.UnableToWatchAddress(blockchain)\n        }");
        return map;
    }
}