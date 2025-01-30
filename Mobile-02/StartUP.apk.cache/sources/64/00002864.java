package com.coinbase.wallet.wallets.apis;

import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.dtos.CryptoCurrenciesResultDTO;
import com.coinbase.wallet.wallets.dtos.CryptoCurrencyElementDTO;
import com.coinbase.wallet.wallets.models.CryptoCurrency;
import h.c.b0;
import h.c.m0.n;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import org.apache.http.HttpHost;

/* compiled from: CryptoCurrencyAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/wallets/apis/CryptoCurrencyAPI;", "", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lh/c/b0;", "", "Lcom/coinbase/wallet/wallets/models/CryptoCurrency;", "getCryptoCurrencies", "(I)Lh/c/b0;", "Lcom/coinbase/wallet/wallets/apis/CryptoCurrencyHTTP;", HttpHost.DEFAULT_SCHEME_NAME, "Lcom/coinbase/wallet/wallets/apis/CryptoCurrencyHTTP;", "<init>", "(Lcom/coinbase/wallet/wallets/apis/CryptoCurrencyHTTP;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CryptoCurrencyAPI {
    private final CryptoCurrencyHTTP http;

    public CryptoCurrencyAPI(CryptoCurrencyHTTP http) {
        m.g(http, "http");
        this.http = http;
    }

    public static /* synthetic */ List a(CryptoCurrenciesResultDTO cryptoCurrenciesResultDTO) {
        return m1839getCryptoCurrencies$lambda2(cryptoCurrenciesResultDTO);
    }

    public static /* synthetic */ int b(Locale locale, CryptoCurrencyElementDTO cryptoCurrencyElementDTO, CryptoCurrencyElementDTO cryptoCurrencyElementDTO2) {
        return m1840getCryptoCurrencies$lambda2$lambda0(locale, cryptoCurrencyElementDTO, cryptoCurrencyElementDTO2);
    }

    /* renamed from: getCryptoCurrencies$lambda-2 */
    public static final List m1839getCryptoCurrencies$lambda2(CryptoCurrenciesResultDTO it) {
        List B0;
        m.g(it, "it");
        final Locale locale = Locale.US;
        B0 = z.B0(it.getResult().getCryptoCurrencies(), new Comparator() { // from class: com.coinbase.wallet.wallets.apis.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return CryptoCurrencyAPI.b(locale, (CryptoCurrencyElementDTO) obj, (CryptoCurrencyElementDTO) obj2);
            }
        });
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : B0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                r.q();
            }
            CryptoCurrency asCryptoCurrency = ((CryptoCurrencyElementDTO) obj).asCryptoCurrency(i2);
            if (asCryptoCurrency != null) {
                arrayList.add(asCryptoCurrency);
            }
            i2 = i3;
        }
        return arrayList;
    }

    /* renamed from: getCryptoCurrencies$lambda-2$lambda-0 */
    public static final int m1840getCryptoCurrencies$lambda2$lambda0(Locale locale, CryptoCurrencyElementDTO cryptoCurrencyElementDTO, CryptoCurrencyElementDTO cryptoCurrencyElementDTO2) {
        if (cryptoCurrencyElementDTO.getMarketCap() == cryptoCurrencyElementDTO2.getMarketCap()) {
            String name = cryptoCurrencyElementDTO.getName();
            m.f(locale, "locale");
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase(locale);
            m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String name2 = cryptoCurrencyElementDTO2.getName();
            Objects.requireNonNull(name2, "null cannot be cast to non-null type java.lang.String");
            String lowerCase2 = name2.toLowerCase(locale);
            m.f(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase.compareTo(lowerCase2);
        }
        return Double.compare(cryptoCurrencyElementDTO2.getMarketCap(), cryptoCurrencyElementDTO.getMarketCap());
    }

    public final b0<List<CryptoCurrency>> getCryptoCurrencies(int i2) {
        b0<R> map = this.http.getCryptoCurrencies(i2).map(new n() { // from class: com.coinbase.wallet.wallets.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CryptoCurrencyAPI.a((CryptoCurrenciesResultDTO) obj);
            }
        });
        m.f(map, "http.getCryptoCurrencies(chainId)\n        .map {\n            val locale = Locale.US\n            it.result.cryptoCurrencies\n                .sortedWith(Comparator { a, b ->\n                    if (a.marketCap == b.marketCap) a.name.toLowerCase(locale).compareTo(b.name.toLowerCase(locale))\n                    else b.marketCap.compareTo(a.marketCap)\n                })\n                .mapIndexedNotNull { i, c -> c.asCryptoCurrency(i) }\n        }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }
}