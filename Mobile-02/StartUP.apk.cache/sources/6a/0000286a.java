package com.coinbase.wallet.wallets.apis;

import com.coinbase.wallet.wallets.dtos.GetCryptoExchangeRatesResultDTO;
import com.coinbase.wallet.wallets.dtos.GetFiatExchangeRatesResultDTO;
import com.coinbase.wallet.wallets.dtos.GetL2CryptoExchangeRatesResultDTO;
import h.c.b0;
import java.util.Map;
import kotlin.Metadata;
import retrofit2.z.t;
import retrofit2.z.u;

/* compiled from: ExchangeRateAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bH'¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bH'¢\u0006\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/wallets/apis/ExchangeRateHTTP;", "", "", "encodedSymbols", "Lh/c/b0;", "Lcom/coinbase/wallet/wallets/dtos/GetFiatExchangeRatesResultDTO;", "getExchangeRates", "(Ljava/lang/String;)Lh/c/b0;", "", "params", "Lcom/coinbase/wallet/wallets/dtos/GetCryptoExchangeRatesResultDTO;", "getCryptoExchangeRates", "(Ljava/util/Map;)Lh/c/b0;", "Lcom/coinbase/wallet/wallets/dtos/GetL2CryptoExchangeRatesResultDTO;", "getL2CryptoExchangeRates", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface ExchangeRateHTTP {
    @retrofit2.z.f("/rpc/v2/getAssetPrices")
    b0<GetCryptoExchangeRatesResultDTO> getCryptoExchangeRates(@u Map<String, String> map);

    @retrofit2.z.f("/rpc/v2/getExchangeRates")
    b0<GetFiatExchangeRatesResultDTO> getExchangeRates(@t("symbols") String str);

    @retrofit2.z.f("/rpc/v2/getL2AssetPrices")
    b0<GetL2CryptoExchangeRatesResultDTO> getL2CryptoExchangeRates(@u Map<String, String> map);
}