package com.coinbase.wallet.wallets.di;

import com.coinbase.Coinbase;
import com.coinbase.wallet.compoundfinance.apis.CompoundFinanceAPI;
import com.coinbase.wallet.ethereum.apis.ERC20ContractAPI;
import com.coinbase.wallet.stellar.api.TimeAPI;
import com.coinbase.wallet.stellar.api.TimeHTTP;
import com.coinbase.wallet.wallets.apis.BlockchainAddressHTTP;
import com.coinbase.wallet.wallets.apis.CryptoCurrencyAPI;
import com.coinbase.wallet.wallets.apis.CryptoCurrencyHTTP;
import com.coinbase.wallet.wallets.apis.ExchangeRateAPI;
import com.coinbase.wallet.wallets.apis.ExchangeRateHTTP;
import com.coinbase.wallet.wallets.apis.FiatCurrencyAPI;
import com.coinbase.wallet.wallets.apis.FiatCurrencyHTTP;
import com.coinbase.wallet.wallets.apis.WatchAddressAPI;
import com.coinbase.wallet.wallets.di.qualifier.WalletApiUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import retrofit2.t;

/* compiled from: APIModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/wallets/di/APIModule;", "", "<init>", "()V", "Companion", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class APIModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: APIModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/wallets/di/APIModule$Companion;", "", "Lretrofit2/t;", "retrofit", "Lcom/coinbase/wallet/wallets/apis/CryptoCurrencyAPI;", "cryptoCurrencyAPI$wallets_release", "(Lretrofit2/t;)Lcom/coinbase/wallet/wallets/apis/CryptoCurrencyAPI;", "cryptoCurrencyAPI", "Lcom/coinbase/wallet/wallets/apis/FiatCurrencyAPI;", "fiatCurrencyAPI$wallets_release", "(Lretrofit2/t;)Lcom/coinbase/wallet/wallets/apis/FiatCurrencyAPI;", "fiatCurrencyAPI", "", "walletApiUrlString", "Lcom/coinbase/wallet/compoundfinance/apis/CompoundFinanceAPI;", "compoundFinanceAPI", "(Ljava/lang/String;)Lcom/coinbase/wallet/compoundfinance/apis/CompoundFinanceAPI;", "Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "erc20ContractAPI", "()Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "Lcom/coinbase/Coinbase;", "coinbase", "Lcom/coinbase/wallet/wallets/apis/ExchangeRateAPI;", "exchangeRateAPI$wallets_release", "(Lretrofit2/t;Lcom/coinbase/Coinbase;)Lcom/coinbase/wallet/wallets/apis/ExchangeRateAPI;", "exchangeRateAPI", "Lcom/coinbase/wallet/stellar/api/TimeAPI;", "timeApi", "(Lretrofit2/t;)Lcom/coinbase/wallet/stellar/api/TimeAPI;", "Lcom/coinbase/wallet/wallets/apis/WatchAddressAPI;", "watchAddressAPI$wallets_release", "(Lretrofit2/t;)Lcom/coinbase/wallet/wallets/apis/WatchAddressAPI;", "watchAddressAPI", "<init>", "()V", "wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CompoundFinanceAPI compoundFinanceAPI(@WalletApiUrl String walletApiUrlString) {
            m.g(walletApiUrlString, "walletApiUrlString");
            return new CompoundFinanceAPI(walletApiUrlString);
        }

        public final CryptoCurrencyAPI cryptoCurrencyAPI$wallets_release(t retrofit) {
            m.g(retrofit, "retrofit");
            Object c2 = retrofit.c(CryptoCurrencyHTTP.class);
            m.f(c2, "retrofit.create(CryptoCurrencyHTTP::class.java)");
            return new CryptoCurrencyAPI((CryptoCurrencyHTTP) c2);
        }

        public final ERC20ContractAPI erc20ContractAPI() {
            return new ERC20ContractAPI();
        }

        public final ExchangeRateAPI exchangeRateAPI$wallets_release(t retrofit, Coinbase coinbase) {
            m.g(retrofit, "retrofit");
            m.g(coinbase, "coinbase");
            Object c2 = retrofit.c(ExchangeRateHTTP.class);
            m.f(c2, "retrofit.create(ExchangeRateHTTP::class.java)");
            return new ExchangeRateAPI((ExchangeRateHTTP) c2, coinbase);
        }

        public final FiatCurrencyAPI fiatCurrencyAPI$wallets_release(t retrofit) {
            m.g(retrofit, "retrofit");
            Object c2 = retrofit.c(FiatCurrencyHTTP.class);
            m.f(c2, "retrofit.create(FiatCurrencyHTTP::class.java)");
            return new FiatCurrencyAPI((FiatCurrencyHTTP) c2);
        }

        public final TimeAPI timeApi(t retrofit) {
            m.g(retrofit, "retrofit");
            Object c2 = retrofit.c(TimeHTTP.class);
            m.f(c2, "retrofit.create(TimeHTTP::class.java)");
            return new TimeAPI((TimeHTTP) c2);
        }

        public final WatchAddressAPI watchAddressAPI$wallets_release(t retrofit) {
            m.g(retrofit, "retrofit");
            Object c2 = retrofit.c(BlockchainAddressHTTP.class);
            m.f(c2, "retrofit.create(BlockchainAddressHTTP::class.java)");
            return new WatchAddressAPI((BlockchainAddressHTTP) c2);
        }
    }

    public static final CompoundFinanceAPI compoundFinanceAPI(@WalletApiUrl String str) {
        return Companion.compoundFinanceAPI(str);
    }

    public static final ERC20ContractAPI erc20ContractAPI() {
        return Companion.erc20ContractAPI();
    }

    public static final TimeAPI timeApi(t tVar) {
        return Companion.timeApi(tVar);
    }
}