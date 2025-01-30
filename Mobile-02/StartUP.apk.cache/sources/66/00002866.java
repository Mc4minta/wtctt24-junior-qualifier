package com.coinbase.wallet.wallets.apis;

import com.coinbase.Coinbase;
import com.coinbase.CoinbaseResponse;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.resources.prices.Price;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.dtos.GetCryptoExchangeRatesResultDTO;
import com.coinbase.wallet.wallets.dtos.GetFiatExchangeRatesResultDTO;
import com.coinbase.wallet.wallets.dtos.GetL2CryptoExchangeRatesResultDTO;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import h.c.b0;
import h.c.m0.n;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.u;
import org.apache.http.HttpHost;

/* compiled from: ExchangeRateAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b \u0010!J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0007J'\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000f\u0010\u0010J?\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\b\b\u0002\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014JE\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/wallets/apis/ExchangeRateAPI;", "", "", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "input", "", "encodeCurrencyCodes", "(Ljava/util/List;)Ljava/lang/String;", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "encodeContractAddresses", "", "encodeChainIds", "currencyCodes", "Lh/c/b0;", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "getFiatExchangeRates", "(Ljava/util/List;)Lh/c/b0;", "contractAddresses", RouteActionKey.RouteActionKeys.CHAIN_ID, "getCryptoExchangeRates", "(Ljava/util/List;Ljava/util/List;I)Lh/c/b0;", "chainIds", "getL2CryptoExchangeRates", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lh/c/b0;", "getConsumerSpotPrices", "()Lh/c/b0;", "Lcom/coinbase/Coinbase;", "coinbaseService", "Lcom/coinbase/Coinbase;", "Lcom/coinbase/wallet/wallets/apis/ExchangeRateHTTP;", HttpHost.DEFAULT_SCHEME_NAME, "Lcom/coinbase/wallet/wallets/apis/ExchangeRateHTTP;", "<init>", "(Lcom/coinbase/wallet/wallets/apis/ExchangeRateHTTP;Lcom/coinbase/Coinbase;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ExchangeRateAPI {
    private final Coinbase coinbaseService;
    private final ExchangeRateHTTP http;

    public ExchangeRateAPI(ExchangeRateHTTP http, Coinbase coinbaseService) {
        m.g(http, "http");
        m.g(coinbaseService, "coinbaseService");
        this.http = http;
        this.coinbaseService = coinbaseService;
    }

    public static /* synthetic */ List a(Throwable th) {
        return m1845getL2CryptoExchangeRates$lambda4(th);
    }

    public static /* synthetic */ List b(GetL2CryptoExchangeRatesResultDTO getL2CryptoExchangeRatesResultDTO) {
        return m1844getL2CryptoExchangeRates$lambda3(getL2CryptoExchangeRatesResultDTO);
    }

    public static /* synthetic */ List c(GetFiatExchangeRatesResultDTO getFiatExchangeRatesResultDTO) {
        return m1843getFiatExchangeRates$lambda1$lambda0(getFiatExchangeRatesResultDTO);
    }

    public static /* synthetic */ List d(CoinbaseResponse coinbaseResponse) {
        return m1841getConsumerSpotPrices$lambda6(coinbaseResponse);
    }

    public static /* synthetic */ List e(int i2, GetCryptoExchangeRatesResultDTO getCryptoExchangeRatesResultDTO) {
        return m1842getCryptoExchangeRates$lambda2(i2, getCryptoExchangeRatesResultDTO);
    }

    private final String encodeChainIds(List<Integer> list) {
        int r;
        String h0;
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Number number : list) {
            arrayList.add(String.valueOf(number.intValue()));
        }
        h0 = z.h0(arrayList, ",", null, null, 0, null, ExchangeRateAPI$encodeChainIds$2.INSTANCE, 30, null);
        return h0;
    }

    private final String encodeContractAddresses(List<ContractAddress> list) {
        int r;
        String h0;
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ContractAddress contractAddress : list) {
            arrayList.add(contractAddress.getRawValue());
        }
        h0 = z.h0(arrayList, ",", null, null, 0, null, ExchangeRateAPI$encodeContractAddresses$2.INSTANCE, 30, null);
        return h0;
    }

    private final String encodeCurrencyCodes(List<CurrencyCode> list) {
        int r;
        String h0;
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (CurrencyCode currencyCode : list) {
            arrayList.add(currencyCode.getRawValue());
        }
        h0 = z.h0(arrayList, ",", null, null, 0, null, ExchangeRateAPI$encodeCurrencyCodes$2.INSTANCE, 30, null);
        return h0;
    }

    /* renamed from: getConsumerSpotPrices$lambda-6 */
    public static final List m1841getConsumerSpotPrices$lambda6(CoinbaseResponse res) {
        ExchangeRate exchangeRate;
        m.g(res, "res");
        Object data = res.getData();
        m.f(data, "res.data");
        ArrayList arrayList = new ArrayList();
        for (Price price : (Iterable) data) {
            try {
                String base = price.getBase();
                m.f(base, "it.base");
                exchangeRate = new ExchangeRate(new CurrencyCode(base), new BigDecimal(price.getAmount()), null, null, null, 28, null);
            } catch (NumberFormatException unused) {
                exchangeRate = null;
            }
            if (exchangeRate != null) {
                arrayList.add(exchangeRate);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ b0 getCryptoExchangeRates$default(ExchangeRateAPI exchangeRateAPI, List list, List list2, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = EthereumChain.ETHEREUM_MAINNET.getChainId();
        }
        return exchangeRateAPI.getCryptoExchangeRates(list, list2, i2);
    }

    /* renamed from: getCryptoExchangeRates$lambda-2 */
    public static final List m1842getCryptoExchangeRates$lambda2(int i2, GetCryptoExchangeRatesResultDTO it) {
        m.g(it, "it");
        return it.getResult().toExchangeRates(Integer.valueOf(i2));
    }

    /* renamed from: getFiatExchangeRates$lambda-1$lambda-0 */
    public static final List m1843getFiatExchangeRates$lambda1$lambda0(GetFiatExchangeRatesResultDTO it) {
        m.g(it, "it");
        return it.getResult().toExchangeRates();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ b0 getL2CryptoExchangeRates$default(ExchangeRateAPI exchangeRateAPI, List list, List list2, List list3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            list3 = q.b(Integer.valueOf(EthereumChain.ETHEREUM_MAINNET.getChainId()));
        }
        return exchangeRateAPI.getL2CryptoExchangeRates(list, list2, list3);
    }

    /* renamed from: getL2CryptoExchangeRates$lambda-3 */
    public static final List m1844getL2CryptoExchangeRates$lambda3(GetL2CryptoExchangeRatesResultDTO it) {
        m.g(it, "it");
        return it.getResult().toExchangeRates();
    }

    /* renamed from: getL2CryptoExchangeRates$lambda-4 */
    public static final List m1845getL2CryptoExchangeRates$lambda4(Throwable it) {
        List g2;
        m.g(it, "it");
        g2 = r.g();
        return g2;
    }

    public final b0<List<ExchangeRate>> getConsumerSpotPrices() {
        b0 map = this.coinbaseService.getPricesResource().getSpotPricesRx(CurrencyCode.Companion.getUSD().getRawValue()).map(new n() { // from class: com.coinbase.wallet.wallets.apis.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateAPI.d((CoinbaseResponse) obj);
            }
        });
        m.f(map, "coinbaseService.pricesResource\n        .getSpotPricesRx(CurrencyCode.USD.rawValue)\n        .map { res ->\n            res.data.mapNotNull {\n                try {\n                    ExchangeRate(CurrencyCode(it.base), BigDecimal(it.amount))\n                } catch (e: NumberFormatException) {\n                    null\n                }\n            }\n        }");
        return map;
    }

    public final b0<List<ExchangeRate>> getCryptoExchangeRates(List<CurrencyCode> currencyCodes, List<ContractAddress> contractAddresses, final int i2) {
        Map<String, String> m;
        m.g(currencyCodes, "currencyCodes");
        m.g(contractAddresses, "contractAddresses");
        m = m0.m(u.a("symbols", encodeCurrencyCodes(currencyCodes)), u.a("contractAddresses", encodeContractAddresses(contractAddresses)));
        b0 map = Single_CoreKt.retryWithDelay(this.http.getCryptoExchangeRates(m), 3L, 500L, TimeUnit.MILLISECONDS).map(new n() { // from class: com.coinbase.wallet.wallets.apis.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateAPI.e(i2, (GetCryptoExchangeRatesResultDTO) obj);
            }
        });
        m.f(map, "http.getCryptoExchangeRates(params)\n            .retryWithDelay(3, 500, TimeUnit.MILLISECONDS)\n            .map { it.result.toExchangeRates(chainId) }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    public final b0<List<ExchangeRate>> getFiatExchangeRates(List<CurrencyCode> currencyCodes) {
        m.g(currencyCodes, "currencyCodes");
        b0 map = Single_CoreKt.retryWithDelay(this.http.getExchangeRates(encodeCurrencyCodes(currencyCodes)), 3L, 500L, TimeUnit.MILLISECONDS).map(new n() { // from class: com.coinbase.wallet.wallets.apis.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateAPI.c((GetFiatExchangeRatesResultDTO) obj);
            }
        });
        m.f(map, "http.getExchangeRates(encodedSymbols)\n                .retryWithDelay(3, 500, TimeUnit.MILLISECONDS)\n                .map { it.result.toExchangeRates() }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    public final b0<List<ExchangeRate>> getL2CryptoExchangeRates(List<CurrencyCode> currencyCodes, List<ContractAddress> contractAddresses, List<Integer> chainIds) {
        Map<String, String> m;
        m.g(currencyCodes, "currencyCodes");
        m.g(contractAddresses, "contractAddresses");
        m.g(chainIds, "chainIds");
        m = m0.m(u.a("symbols", encodeCurrencyCodes(currencyCodes)), u.a("contractAddresses", encodeContractAddresses(contractAddresses)), u.a("chainIds", encodeChainIds(chainIds)));
        b0 map = Single_CoreKt.retryWithDelay(this.http.getL2CryptoExchangeRates(m), 3L, 500L, TimeUnit.MILLISECONDS).map(new n() { // from class: com.coinbase.wallet.wallets.apis.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateAPI.b((GetL2CryptoExchangeRatesResultDTO) obj);
            }
        });
        m.f(map, "http.getL2CryptoExchangeRates(params)\n            .retryWithDelay(3, 500, TimeUnit.MILLISECONDS)\n            .map { it.result.toExchangeRates() }");
        b0<List<ExchangeRate>> onErrorReturn = Single_AnalyticsKt.logError$default(map, "Error fetching L2 crypto asset prices.", null, 2, null).onErrorReturn(new n() { // from class: com.coinbase.wallet.wallets.apis.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateAPI.a((Throwable) obj);
            }
        });
        m.f(onErrorReturn, "http.getL2CryptoExchangeRates(params)\n            .retryWithDelay(3, 500, TimeUnit.MILLISECONDS)\n            .map { it.result.toExchangeRates() }\n            .logError(\"Error fetching L2 crypto asset prices.\")\n            .onErrorReturn {\n                emptyList()\n            }");
        return onErrorReturn;
    }
}