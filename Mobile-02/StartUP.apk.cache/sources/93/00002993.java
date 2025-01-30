package com.coinbase.wallet.wallets.interfaces;

import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import h.c.b0;
import h.c.s;
import java.util.List;
import kotlin.Metadata;

/* compiled from: IFiatCurrencyRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u001b\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lh/c/b0;", "", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "getCurrencies", "()Lh/c/b0;", "fiatCurrency", "Lkotlin/x;", "saveActiveCurrency", "(Lcom/coinbase/wallet/wallets/models/FiatCurrency;)V", "Lh/c/s;", "getActiveCurrencyObservable", "()Lh/c/s;", "activeCurrencyObservable", "getActiveCurrency", "()Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "activeCurrency", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IFiatCurrencyRepository extends Startable, Destroyable {
    FiatCurrency getActiveCurrency();

    s<FiatCurrency> getActiveCurrencyObservable();

    b0<List<FiatCurrency>> getCurrencies();

    void saveActiveCurrency(FiatCurrency fiatCurrency);
}