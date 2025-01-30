package com.coinbase.wallet.wallets.apis;

import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.dtos.CryptoCurrenciesResultDTO;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.t;

/* compiled from: CryptoCurrencyAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/wallets/apis/CryptoCurrencyHTTP;", "", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lh/c/b0;", "Lcom/coinbase/wallet/wallets/dtos/CryptoCurrenciesResultDTO;", "getCryptoCurrencies", "(I)Lh/c/b0;", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface CryptoCurrencyHTTP {
    @retrofit2.z.f("/rpc/v2/getCryptoCurrencies")
    b0<CryptoCurrenciesResultDTO> getCryptoCurrencies(@t("chainId") int i2);
}