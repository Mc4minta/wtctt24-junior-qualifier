package com.coinbase.wallet.wallets.apis;

import com.coinbase.wallet.wallets.dtos.FiatCurrenciesResultDTO;
import com.coinbase.wallet.wallets.dtos.FiatCurrencyDTO;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import h.c.b0;
import h.c.m0.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import org.apache.http.HttpHost;

/* compiled from: FiatCurrencyAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/wallets/apis/FiatCurrencyAPI;", "", "Lh/c/b0;", "", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "getCurrencies", "()Lh/c/b0;", "Lcom/coinbase/wallet/wallets/apis/FiatCurrencyHTTP;", HttpHost.DEFAULT_SCHEME_NAME, "Lcom/coinbase/wallet/wallets/apis/FiatCurrencyHTTP;", "<init>", "(Lcom/coinbase/wallet/wallets/apis/FiatCurrencyHTTP;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class FiatCurrencyAPI {
    private final FiatCurrencyHTTP http;

    public FiatCurrencyAPI(FiatCurrencyHTTP http) {
        m.g(http, "http");
        this.http = http;
    }

    public static /* synthetic */ List a(FiatCurrenciesResultDTO fiatCurrenciesResultDTO) {
        return m1846getCurrencies$lambda1(fiatCurrenciesResultDTO);
    }

    /* renamed from: getCurrencies$lambda-1 */
    public static final List m1846getCurrencies$lambda1(FiatCurrenciesResultDTO dto) {
        int r;
        m.g(dto, "dto");
        List<FiatCurrencyDTO> currencies = dto.getResult().getCurrencies();
        r = s.r(currencies, 10);
        ArrayList arrayList = new ArrayList(r);
        for (FiatCurrencyDTO fiatCurrencyDTO : currencies) {
            arrayList.add(fiatCurrencyDTO.asFiatCurrency());
        }
        return arrayList;
    }

    public final b0<List<FiatCurrency>> getCurrencies() {
        b0 map = this.http.getCurrencies().map(new n() { // from class: com.coinbase.wallet.wallets.apis.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return FiatCurrencyAPI.a((FiatCurrenciesResultDTO) obj);
            }
        });
        m.f(map, "http.getCurrencies()\n        .map { dto -> dto.result.currencies.map { it.asFiatCurrency() } }");
        return map;
    }
}