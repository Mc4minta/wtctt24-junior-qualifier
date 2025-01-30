package com.coinbase.wallet.wallets.interfaces;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import h.c.b0;
import h.c.s;
import java.math.BigDecimal;
import java.util.List;
import kotlin.Metadata;

/* compiled from: IExchangeRateRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ3\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00110\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "fiatCurrencyCode", "Lh/c/b0;", "Ljava/math/BigDecimal;", "getFiatExchangeRate", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;)Lh/c/b0;", "cryptoCurrencyCode", "", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "", RouteActionKey.RouteActionKeys.CHAIN_ID, "getCryptoExchangeRate", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;I)Lh/c/b0;", "", "chainIds", "getL2CryptoExchangeRate", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/util/List;)Lh/c/b0;", "Lh/c/s;", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "getExchangeRateObservable", "()Lh/c/s;", "exchangeRateObservable", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IExchangeRateRepository extends Refreshable, Startable, Destroyable {

    /* compiled from: IExchangeRateRepository.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ b0 getCryptoExchangeRate$default(IExchangeRateRepository iExchangeRateRepository, CurrencyCode currencyCode, String str, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = null;
                }
                if ((i3 & 4) != 0) {
                    i2 = 1;
                }
                return iExchangeRateRepository.getCryptoExchangeRate(currencyCode, str, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCryptoExchangeRate");
        }

        public static /* synthetic */ b0 getL2CryptoExchangeRate$default(IExchangeRateRepository iExchangeRateRepository, CurrencyCode currencyCode, String str, List list, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = null;
                }
                return iExchangeRateRepository.getL2CryptoExchangeRate(currencyCode, str, list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getL2CryptoExchangeRate");
        }
    }

    b0<BigDecimal> getCryptoExchangeRate(CurrencyCode currencyCode, String str, int i2);

    s<List<ExchangeRate>> getExchangeRateObservable();

    b0<BigDecimal> getFiatExchangeRate(CurrencyCode currencyCode);

    b0<BigDecimal> getL2CryptoExchangeRate(CurrencyCode currencyCode, String str, List<Integer> list);
}