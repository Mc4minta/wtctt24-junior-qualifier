package com.coinbase.wallet.wallets.apis;

import com.coinbase.wallet.wallets.dtos.FiatCurrenciesResultDTO;
import h.c.b0;
import kotlin.Metadata;

/* compiled from: FiatCurrencyAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/wallets/apis/FiatCurrencyHTTP;", "", "Lh/c/b0;", "Lcom/coinbase/wallet/wallets/dtos/FiatCurrenciesResultDTO;", "getCurrencies", "()Lh/c/b0;", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface FiatCurrencyHTTP {
    @retrofit2.z.f("/rpc/v2/getCurrencies")
    b0<FiatCurrenciesResultDTO> getCurrencies();
}