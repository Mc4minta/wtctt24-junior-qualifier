package com.coinbase.wallet.wallets.repositories;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.compoundfinance.models.CompoundExchangeRateResult;
import com.coinbase.wallet.compoundfinance.models.CompoundToken;
import com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.apis.ExchangeRateAPI;
import com.coinbase.wallet.wallets.daos.FiatExchangeRateDAO;
import com.coinbase.wallet.wallets.exceptions.ExchangeRateException;
import com.coinbase.wallet.wallets.extensions.TraceKey_WalletsKt;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: ExchangeRateRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B=\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\bI\u0010JJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0016¢\u0006\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R$\u0010/\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010\u000b0\u000b0-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109RR\u0010:\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 .*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00050\u0005 .*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 .*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00050\u0005\u0018\u00010)0)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010,R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R(\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050)8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b>\u0010,\u001a\u0004\b?\u0010@R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00180\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER0\u0010G\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 .*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00050F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006K"}, d2 = {"Lcom/coinbase/wallet/wallets/repositories/ExchangeRateRepository;", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "Lh/c/k0/b;", "reloadExchangeRatesFromDatabase", "()Lh/c/k0/b;", "", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "erc20ExchangeRates", "Lh/c/b0;", "calculateExchangeRate", "(Ljava/util/List;)Lh/c/b0;", "", "isForced", "Lkotlin/x;", "refresh", "(Z)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "fiatCurrencyCode", "Ljava/math/BigDecimal;", "getFiatExchangeRate", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;)Lh/c/b0;", "cryptoCurrencyCode", "", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "", RouteActionKey.RouteActionKeys.CHAIN_ID, "getCryptoExchangeRate", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;I)Lh/c/b0;", "chainIds", "getL2CryptoExchangeRate", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/util/List;)Lh/c/b0;", "start", "()V", "destroy", "()Lh/c/b0;", "Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "compoundFinanceRepository", "Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "Lh/c/s;", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "activeFiatCurrencyObservable", "Lh/c/s;", "Lh/c/v0/c;", "kotlin.jvm.PlatformType", "isReadySubject", "Lh/c/v0/c;", "Lcom/coinbase/wallet/wallets/daos/FiatExchangeRateDAO;", "exchangeRateDAO", "Lcom/coinbase/wallet/wallets/daos/FiatExchangeRateDAO;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lh/c/a0;", "ioScheduler", "Lh/c/a0;", "cryptoCurrencyCodesObservable", "Lcom/coinbase/wallet/wallets/apis/ExchangeRateAPI;", "exchangeRateApi", "Lcom/coinbase/wallet/wallets/apis/ExchangeRateAPI;", "exchangeRateObservable", "getExchangeRateObservable", "()Lh/c/s;", "fetchedL2ChainIds", "Ljava/util/List;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lh/c/v0/a;", "exchangeRateSubject", "Lh/c/v0/a;", "<init>", "(Lh/c/s;Lcom/coinbase/wallet/wallets/apis/ExchangeRateAPI;Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;Lcom/coinbase/wallet/wallets/daos/FiatExchangeRateDAO;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/core/interfaces/Tracing;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ExchangeRateRepository implements IExchangeRateRepository {
    private final h.c.s<FiatCurrency> activeFiatCurrencyObservable;
    private final CompoundFinanceRepository compoundFinanceRepository;
    private final h.c.s<List<CurrencyCode>> cryptoCurrencyCodesObservable;
    private final h.c.k0.a disposeBag;
    private final ExchangeRateAPI exchangeRateApi;
    private final FiatExchangeRateDAO exchangeRateDAO;
    private final h.c.s<List<ExchangeRate>> exchangeRateObservable;
    private final h.c.v0.a<List<ExchangeRate>> exchangeRateSubject;
    private final List<Integer> fetchedL2ChainIds;
    private final h.c.a0 ioScheduler;
    private final h.c.v0.c<Boolean> isReadySubject;
    private final Tracing tracer;
    private final IWalletRepository walletRepository;

    public ExchangeRateRepository(h.c.s<FiatCurrency> activeFiatCurrencyObservable, ExchangeRateAPI exchangeRateApi, CompoundFinanceRepository compoundFinanceRepository, FiatExchangeRateDAO exchangeRateDAO, IWalletRepository walletRepository, Tracing tracer) {
        List g2;
        List<Integer> b2;
        kotlin.jvm.internal.m.g(activeFiatCurrencyObservable, "activeFiatCurrencyObservable");
        kotlin.jvm.internal.m.g(exchangeRateApi, "exchangeRateApi");
        kotlin.jvm.internal.m.g(compoundFinanceRepository, "compoundFinanceRepository");
        kotlin.jvm.internal.m.g(exchangeRateDAO, "exchangeRateDAO");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(tracer, "tracer");
        this.activeFiatCurrencyObservable = activeFiatCurrencyObservable;
        this.exchangeRateApi = exchangeRateApi;
        this.compoundFinanceRepository = compoundFinanceRepository;
        this.exchangeRateDAO = exchangeRateDAO;
        this.walletRepository = walletRepository;
        this.tracer = tracer;
        h.c.v0.c<Boolean> d2 = h.c.v0.c.d(1);
        kotlin.jvm.internal.m.f(d2, "createWithSize<Boolean>(1)");
        this.isReadySubject = d2;
        g2 = kotlin.a0.r.g();
        h.c.v0.a<List<ExchangeRate>> e2 = h.c.v0.a.e(g2);
        kotlin.jvm.internal.m.f(e2, "createDefault<List<ExchangeRate>>(emptyList())");
        this.exchangeRateSubject = e2;
        h.c.a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.ioScheduler = c2;
        this.disposeBag = new h.c.k0.a();
        this.cryptoCurrencyCodesObservable = IWalletRepository.DefaultImpls.observeWallets$default(walletRepository, false, 1, null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.o((List) obj);
            }
        });
        b2 = kotlin.a0.q.b(Integer.valueOf(EthereumChain.POLYGON_MAINNET.getChainId()));
        this.fetchedL2ChainIds = b2;
        reloadExchangeRatesFromDatabase();
        h.c.s<List<ExchangeRate>> distinctUntilChanged = e2.hide().distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged, "exchangeRateSubject\n        .hide()\n        .distinctUntilChanged()");
        this.exchangeRateObservable = distinctUntilChanged;
    }

    public static /* synthetic */ h.c.x b(ExchangeRateRepository exchangeRateRepository, kotlin.o oVar) {
        return m1867start$lambda30(exchangeRateRepository, oVar);
    }

    public static /* synthetic */ boolean c(Boolean bool) {
        return m1864reloadExchangeRatesFromDatabase$lambda32(bool);
    }

    private final h.c.b0<List<ExchangeRate>> calculateExchangeRate(final List<ExchangeRate> list) {
        h.c.b0<List<ExchangeRate>> map = this.compoundFinanceRepository.supportedTokens().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.e(ExchangeRateRepository.this, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.d(list, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "compoundFinanceRepository.supportedTokens()\n            .flatMap { supportedTokens ->\n                compoundFinanceRepository.getExchangeRates(supportedTokens.map { it.contractAddress })\n            }\n            .map { cTokenExchangeRates ->\n                cTokenExchangeRates.mapNotNull { rateResult ->\n                    val rate = rateResult.rate\n                    val underlyingDecimals = rateResult.token.underlyingDecimals\n                    val erc20BackingRate: ExchangeRate\n                    try {\n                        erc20BackingRate = if (rateResult.token.underlyingContractAddress == null) {\n                            erc20ExchangeRates.first { exchangeRate ->\n                                exchangeRate.currencyCode.rawValue == \"ETH\" && exchangeRate.contractAddress == null\n                            }\n                        } else {\n                            erc20ExchangeRates.first { exchangeRate ->\n                                exchangeRate.contractAddress == rateResult.token.underlyingContractAddress\n                            }\n                        }\n                    } catch (err: NoSuchElementException) {\n                        return@mapNotNull null\n                    }\n\n                    val ten = BigDecimal(10)\n                    val denom = ten.pow(underlyingDecimals) * ten.pow(rateResult.token.decimals) * BigDecimal(100)\n                    val compoundExchangeRate = (rate.toBigDecimal() * erc20BackingRate.rate).divide(denom)\n\n                    ExchangeRate(\n                        currencyCode = rateResult.token.code,\n                        contractAddress = rateResult.token.contractAddress,\n                        rate = compoundExchangeRate,\n                        name = rateResult.token.name\n                    )\n                }\n            }");
        return map;
    }

    /* renamed from: calculateExchangeRate$lambda-37 */
    public static final h.c.h0 m1851calculateExchangeRate$lambda37(ExchangeRateRepository this$0, List supportedTokens) {
        int r;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(supportedTokens, "supportedTokens");
        CompoundFinanceRepository compoundFinanceRepository = this$0.compoundFinanceRepository;
        r = kotlin.a0.s.r(supportedTokens, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = supportedTokens.iterator();
        while (it.hasNext()) {
            arrayList.add(((CompoundToken) it.next()).getContractAddress());
        }
        return compoundFinanceRepository.getExchangeRates(arrayList);
    }

    /* renamed from: calculateExchangeRate$lambda-41 */
    public static final List m1852calculateExchangeRate$lambda41(List erc20ExchangeRates, List cTokenExchangeRates) {
        ExchangeRate exchangeRate;
        ExchangeRate exchangeRate2;
        boolean z;
        kotlin.jvm.internal.m.g(erc20ExchangeRates, "$erc20ExchangeRates");
        kotlin.jvm.internal.m.g(cTokenExchangeRates, "cTokenExchangeRates");
        ArrayList arrayList = new ArrayList();
        Iterator it = cTokenExchangeRates.iterator();
        while (it.hasNext()) {
            CompoundExchangeRateResult compoundExchangeRateResult = (CompoundExchangeRateResult) it.next();
            BigInteger rate = compoundExchangeRateResult.getRate();
            int underlyingDecimals = compoundExchangeRateResult.getToken().getUnderlyingDecimals();
            try {
                if (compoundExchangeRateResult.getToken().getUnderlyingContractAddress() == null) {
                    for (Object obj : erc20ExchangeRates) {
                        ExchangeRate exchangeRate3 = (ExchangeRate) obj;
                        if (kotlin.jvm.internal.m.c(exchangeRate3.getCurrencyCode().getRawValue(), "ETH") && exchangeRate3.getContractAddress() == null) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            exchangeRate2 = (ExchangeRate) obj;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                for (Object obj2 : erc20ExchangeRates) {
                    if (kotlin.jvm.internal.m.c(((ExchangeRate) obj2).getContractAddress(), compoundExchangeRateResult.getToken().getUnderlyingContractAddress())) {
                        exchangeRate2 = (ExchangeRate) obj2;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                BigDecimal bigDecimal = new BigDecimal(10);
                BigDecimal pow = bigDecimal.pow(underlyingDecimals);
                kotlin.jvm.internal.m.f(pow, "ten.pow(underlyingDecimals)");
                BigDecimal pow2 = bigDecimal.pow(compoundExchangeRateResult.getToken().getDecimals());
                kotlin.jvm.internal.m.f(pow2, "ten.pow(rateResult.token.decimals)");
                BigDecimal multiply = pow.multiply(pow2);
                kotlin.jvm.internal.m.f(multiply, "this.multiply(other)");
                BigDecimal multiply2 = multiply.multiply(new BigDecimal(100));
                kotlin.jvm.internal.m.f(multiply2, "this.multiply(other)");
                BigDecimal multiply3 = new BigDecimal(rate).multiply(exchangeRate2.getRate());
                kotlin.jvm.internal.m.f(multiply3, "this.multiply(other)");
                BigDecimal compoundExchangeRate = multiply3.divide(multiply2);
                CurrencyCode code = compoundExchangeRateResult.getToken().getCode();
                String contractAddress = compoundExchangeRateResult.getToken().getContractAddress();
                String name = compoundExchangeRateResult.getToken().getName();
                kotlin.jvm.internal.m.f(compoundExchangeRate, "compoundExchangeRate");
                exchangeRate = new ExchangeRate(code, compoundExchangeRate, contractAddress, null, name, 8, null);
            } catch (NoSuchElementException unused) {
                exchangeRate = null;
            }
            if (exchangeRate != null) {
                arrayList.add(exchangeRate);
            }
        }
        return arrayList;
    }

    /* renamed from: cryptoCurrencyCodesObservable$lambda-1 */
    public static final List m1853cryptoCurrencyCodesObservable$lambda1(List wallets) {
        int r;
        kotlin.jvm.internal.m.g(wallets, "wallets");
        r = kotlin.a0.s.r(wallets, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = wallets.iterator();
        while (it.hasNext()) {
            arrayList.add(((Wallet) it.next()).getCurrencyCode());
        }
        return arrayList;
    }

    public static /* synthetic */ List d(List list, List list2) {
        return m1852calculateExchangeRate$lambda41(list, list2);
    }

    public static /* synthetic */ h.c.h0 e(ExchangeRateRepository exchangeRateRepository, List list) {
        return m1851calculateExchangeRate$lambda37(exchangeRateRepository, list);
    }

    public static /* synthetic */ h.c.h0 f(ExchangeRateRepository exchangeRateRepository, kotlin.t tVar) {
        return m1858refresh$lambda18(exchangeRateRepository, tVar);
    }

    public static /* synthetic */ kotlin.x g(ExchangeRateRepository exchangeRateRepository, kotlin.t tVar) {
        return m1865reloadExchangeRatesFromDatabase$lambda35(exchangeRateRepository, tVar);
    }

    /* renamed from: getCryptoExchangeRate$lambda-25 */
    public static final BigDecimal m1854getCryptoExchangeRate$lambda25(String str, CurrencyCode cryptoCurrencyCode, List rates) {
        Object obj;
        ExchangeRate exchangeRate;
        Object obj2;
        kotlin.jvm.internal.m.g(cryptoCurrencyCode, "$cryptoCurrencyCode");
        kotlin.jvm.internal.m.g(rates, "rates");
        if (str != null) {
            Iterator it = rates.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (kotlin.jvm.internal.m.c(((ExchangeRate) obj2).getContractAddress(), str)) {
                    break;
                }
            }
            exchangeRate = (ExchangeRate) obj2;
        } else {
            Iterator it2 = rates.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (kotlin.jvm.internal.m.c(((ExchangeRate) obj).getCurrencyCode(), cryptoCurrencyCode)) {
                    break;
                }
            }
            exchangeRate = (ExchangeRate) obj;
        }
        BigDecimal rate = exchangeRate != null ? exchangeRate.getRate() : null;
        if (rate != null) {
            return rate;
        }
        throw ExchangeRateException.UnableToGetExchangeRate.INSTANCE;
    }

    /* renamed from: getFiatExchangeRate$lambda-22 */
    public static final BigDecimal m1855getFiatExchangeRate$lambda22(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        try {
            return ((ExchangeRate) kotlin.a0.p.Y(it)).getRate();
        } catch (NoSuchElementException unused) {
            throw ExchangeRateException.UnableToGetExchangeRate.INSTANCE;
        }
    }

    /* renamed from: getL2CryptoExchangeRate$lambda-28 */
    public static final BigDecimal m1856getL2CryptoExchangeRate$lambda28(String str, CurrencyCode cryptoCurrencyCode, List rates) {
        Object obj;
        ExchangeRate exchangeRate;
        Object obj2;
        kotlin.jvm.internal.m.g(cryptoCurrencyCode, "$cryptoCurrencyCode");
        kotlin.jvm.internal.m.g(rates, "rates");
        if (str != null) {
            Iterator it = rates.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (kotlin.jvm.internal.m.c(((ExchangeRate) obj2).getContractAddress(), str)) {
                    break;
                }
            }
            exchangeRate = (ExchangeRate) obj2;
        } else {
            Iterator it2 = rates.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (kotlin.jvm.internal.m.c(((ExchangeRate) obj).getCurrencyCode(), cryptoCurrencyCode)) {
                    break;
                }
            }
            exchangeRate = (ExchangeRate) obj;
        }
        BigDecimal rate = exchangeRate != null ? exchangeRate.getRate() : null;
        if (rate != null) {
            return rate;
        }
        throw ExchangeRateException.UnableToGetExchangeRate.INSTANCE;
    }

    public static /* synthetic */ kotlin.x h(Throwable th) {
        return m1863refresh$lambda21(th);
    }

    public static /* synthetic */ BigDecimal i(String str, CurrencyCode currencyCode, List list) {
        return m1856getL2CryptoExchangeRate$lambda28(str, currencyCode, list);
    }

    public static /* synthetic */ kotlin.x j(Throwable th) {
        return m1868start$lambda31(th);
    }

    public static /* synthetic */ BigDecimal k(List list) {
        return m1855getFiatExchangeRate$lambda22(list);
    }

    public static /* synthetic */ boolean l(kotlin.o oVar, kotlin.o oVar2) {
        return m1866start$lambda29(oVar, oVar2);
    }

    public static /* synthetic */ List m(List list, List list2) {
        return m1859refresh$lambda18$lambda17(list, list2);
    }

    public static /* synthetic */ h.c.h0 n(ExchangeRateRepository exchangeRateRepository, kotlin.o oVar) {
        return m1857refresh$lambda11(exchangeRateRepository, oVar);
    }

    public static /* synthetic */ List o(List list) {
        return m1853cryptoCurrencyCodesObservable$lambda1(list);
    }

    public static /* synthetic */ h.c.h0 p(ExchangeRateRepository exchangeRateRepository, FiatCurrency fiatCurrency) {
        return m1861refresh$lambda2(exchangeRateRepository, fiatCurrency);
    }

    public static /* synthetic */ h.c.h0 q(ExchangeRateRepository exchangeRateRepository, kotlin.o oVar) {
        return m1860refresh$lambda19(exchangeRateRepository, oVar);
    }

    public static /* synthetic */ h.c.k0.b r(ExchangeRateRepository exchangeRateRepository, Optional optional) {
        return m1862refresh$lambda20(exchangeRateRepository, optional);
    }

    /* renamed from: refresh$lambda-11 */
    public static final h.c.h0 m1857refresh$lambda11(ExchangeRateRepository this$0, kotlin.o dstr$wallets$consumerExchangeRates) {
        int r;
        int r2;
        List t0;
        List t02;
        List<String> P;
        int r3;
        List P2;
        int r4;
        List g2;
        List<CurrencyCode> g3;
        boolean O;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$wallets$consumerExchangeRates, "$dstr$wallets$consumerExchangeRates");
        List<Wallet> wallets = (List) dstr$wallets$consumerExchangeRates.a();
        List<ExchangeRate> consumerExchangeRates = (List) dstr$wallets$consumerExchangeRates.b();
        kotlin.jvm.internal.m.f(wallets, "wallets");
        ArrayList arrayList = new ArrayList();
        for (Wallet wallet : wallets) {
            String contractAddress = wallet.getContractAddress();
            if (contractAddress != null) {
                arrayList.add(contractAddress);
            }
        }
        r = kotlin.a0.s.r(wallets, 10);
        ArrayList arrayList2 = new ArrayList(r);
        for (Wallet wallet2 : wallets) {
            arrayList2.add(wallet2.getCurrencyCode());
        }
        kotlin.jvm.internal.m.f(consumerExchangeRates, "consumerExchangeRates");
        r2 = kotlin.a0.s.r(consumerExchangeRates, 10);
        ArrayList arrayList3 = new ArrayList(r2);
        for (ExchangeRate exchangeRate : consumerExchangeRates) {
            arrayList3.add(exchangeRate.getCurrencyCode());
        }
        t0 = kotlin.a0.z.t0(arrayList2, arrayList3);
        List<CompoundToken> tokens = this$0.compoundFinanceRepository.getTokens(arrayList);
        ArrayList arrayList4 = new ArrayList();
        for (CompoundToken compoundToken : tokens) {
            String underlyingContractAddress = compoundToken.getUnderlyingContractAddress();
            if (underlyingContractAddress != null) {
                arrayList4.add(underlyingContractAddress);
            }
        }
        t02 = kotlin.a0.z.t0(arrayList, arrayList4);
        P = kotlin.a0.z.P(t02);
        r3 = kotlin.a0.s.r(P, 10);
        ArrayList arrayList5 = new ArrayList(r3);
        for (String str : P) {
            arrayList5.add(new ContractAddress(str));
        }
        ExchangeRateAPI exchangeRateAPI = this$0.exchangeRateApi;
        P2 = kotlin.a0.z.P(t0);
        h.c.b0 cryptoExchangeRates$default = ExchangeRateAPI.getCryptoExchangeRates$default(exchangeRateAPI, P2, arrayList5, 0, 4, null);
        ArrayList<Wallet> arrayList6 = new ArrayList();
        for (Object obj : wallets) {
            List<Integer> list = this$0.fetchedL2ChainIds;
            EthereumChain fromNetworkRawValue = EthereumChain_EthereumKt.fromNetworkRawValue(EthereumChain.Companion, ((Wallet) obj).getNetwork().getRawValue());
            O = kotlin.a0.z.O(list, fromNetworkRawValue == null ? null : Integer.valueOf(fromNetworkRawValue.getChainId()));
            if (O) {
                arrayList6.add(obj);
            }
        }
        ArrayList<String> arrayList7 = new ArrayList();
        for (Wallet wallet3 : arrayList6) {
            String contractAddress2 = wallet3.getContractAddress();
            if (contractAddress2 != null) {
                arrayList7.add(contractAddress2);
            }
        }
        r4 = kotlin.a0.s.r(arrayList7, 10);
        ArrayList arrayList8 = new ArrayList(r4);
        for (String str2 : arrayList7) {
            arrayList8.add(new ContractAddress(str2));
        }
        g2 = kotlin.a0.r.g();
        h.c.b0<List<ExchangeRate>> just = h.c.b0.just(g2);
        kotlin.jvm.internal.m.f(just, "just(emptyList())");
        if (!arrayList8.isEmpty()) {
            ExchangeRateAPI exchangeRateAPI2 = this$0.exchangeRateApi;
            g3 = kotlin.a0.r.g();
            just = exchangeRateAPI2.getL2CryptoExchangeRates(g3, arrayList8, this$0.fetchedL2ChainIds);
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 just2 = h.c.b0.just(consumerExchangeRates);
        kotlin.jvm.internal.m.f(just2, "just(consumerExchangeRates)");
        return eVar.b(cryptoExchangeRates$default, just, just2);
    }

    /* renamed from: refresh$lambda-18 */
    public static final h.c.h0 m1858refresh$lambda18(ExchangeRateRepository this$0, kotlin.t dstr$exchangeRates$l2ExchangeRates$consumerExchangeRates) {
        final List<ExchangeRate> K0;
        String lowerCase;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$exchangeRates$l2ExchangeRates$consumerExchangeRates, "$dstr$exchangeRates$l2ExchangeRates$consumerExchangeRates");
        List exchangeRates = (List) dstr$exchangeRates$l2ExchangeRates$consumerExchangeRates.a();
        List<ExchangeRate> l2ExchangeRates = (List) dstr$exchangeRates$l2ExchangeRates$consumerExchangeRates.b();
        List<ExchangeRate> consumerExchangeRates = (List) dstr$exchangeRates$l2ExchangeRates$consumerExchangeRates.c();
        kotlin.jvm.internal.m.f(exchangeRates, "exchangeRates");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : exchangeRates) {
            ExchangeRate exchangeRate = (ExchangeRate) obj;
            CurrencyCode currencyCode = exchangeRate.getCurrencyCode();
            String contractAddress = exchangeRate.getContractAddress();
            if (contractAddress == null) {
                lowerCase = null;
            } else {
                Locale US = Locale.US;
                kotlin.jvm.internal.m.f(US, "US");
                lowerCase = contractAddress.toLowerCase(US);
                kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            }
            if (hashSet.add(new kotlin.o(currencyCode, lowerCase))) {
                arrayList.add(obj);
            }
        }
        K0 = kotlin.a0.z.K0(arrayList);
        kotlin.jvm.internal.m.f(l2ExchangeRates, "l2ExchangeRates");
        for (ExchangeRate exchangeRate2 : l2ExchangeRates) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : exchangeRates) {
                ExchangeRate exchangeRate3 = (ExchangeRate) obj2;
                if (kotlin.jvm.internal.m.c(exchangeRate3.getCurrencyCode(), exchangeRate2.getCurrencyCode()) && kotlin.jvm.internal.m.c(exchangeRate3.getContractAddress(), exchangeRate2.getContractAddress())) {
                    arrayList2.add(obj2);
                }
            }
            if (arrayList2.isEmpty()) {
                K0.add(exchangeRate2);
            }
        }
        kotlin.jvm.internal.m.f(consumerExchangeRates, "consumerExchangeRates");
        for (ExchangeRate exchangeRate4 : consumerExchangeRates) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : K0) {
                if (kotlin.jvm.internal.m.c(((ExchangeRate) obj3).getCurrencyCode(), exchangeRate4.getCurrencyCode())) {
                    arrayList3.add(obj3);
                }
            }
            if (arrayList3.size() == 1) {
                ExchangeRate exchangeRate5 = (ExchangeRate) kotlin.a0.p.Y(arrayList3);
                K0.set(K0.indexOf(exchangeRate5), ExchangeRate.copy$default(exchangeRate5, null, null, exchangeRate4.getRate(), null, null, null, 59, null));
            }
        }
        return this$0.calculateExchangeRate(K0).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.l
            @Override // h.c.m0.n
            public final Object apply(Object obj4) {
                return ExchangeRateRepository.m(K0, (List) obj4);
            }
        });
    }

    /* renamed from: refresh$lambda-18$lambda-17 */
    public static final List m1859refresh$lambda18$lambda17(List mutableExchangeRates, List it) {
        List t0;
        kotlin.jvm.internal.m.g(mutableExchangeRates, "$mutableExchangeRates");
        kotlin.jvm.internal.m.g(it, "it");
        t0 = kotlin.a0.z.t0(mutableExchangeRates, it);
        return t0;
    }

    /* renamed from: refresh$lambda-19 */
    public static final h.c.h0 m1860refresh$lambda19(ExchangeRateRepository this$0, kotlin.o it) {
        List<ExchangeRate> t0;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        FiatExchangeRateDAO fiatExchangeRateDAO = this$0.exchangeRateDAO;
        Object c2 = it.c();
        kotlin.jvm.internal.m.f(c2, "it.first");
        Object d2 = it.d();
        kotlin.jvm.internal.m.f(d2, "it.second");
        t0 = kotlin.a0.z.t0((Collection) c2, (Iterable) d2);
        return fiatExchangeRateDAO.save(t0);
    }

    /* renamed from: refresh$lambda-2 */
    public static final h.c.h0 m1861refresh$lambda2(ExchangeRateRepository this$0, FiatCurrency it) {
        List j2;
        List<CurrencyCode> P;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        j2 = kotlin.a0.r.j(it.getCode(), CurrencyCode.Companion.getUSD());
        P = kotlin.a0.z.P(j2);
        return this$0.exchangeRateApi.getFiatExchangeRates(P);
    }

    /* renamed from: refresh$lambda-20 */
    public static final h.c.k0.b m1862refresh$lambda20(ExchangeRateRepository this$0, Optional it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.reloadExchangeRatesFromDatabase();
    }

    /* renamed from: refresh$lambda-21 */
    public static final kotlin.x m1863refresh$lambda21(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    private final h.c.k0.b reloadExchangeRatesFromDatabase() {
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0<List<ExchangeRate>> exchangeRates = this.exchangeRateDAO.getExchangeRates();
        h.c.b0 takeSingle = Observable_CoreKt.takeSingle(this.activeFiatCurrencyObservable);
        h.c.s<Boolean> hide = this.isReadySubject.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.wallets.repositories.b
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return ExchangeRateRepository.c((Boolean) obj);
            }
        }).hide();
        kotlin.jvm.internal.m.f(hide, "isReadySubject.filter { it }.hide()");
        h.c.b0 map = eVar.b(exchangeRates, takeSingle, Observable_CoreKt.takeSingle(hide)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.g(ExchangeRateRepository.this, (kotlin.t) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles\n        .zip(\n            exchangeRateDAO.getExchangeRates(),\n            activeFiatCurrencyObservable.takeSingle(),\n            isReadySubject.filter { it }.hide().takeSingle()\n        )\n        .map { (exchangeRates, activateFiatCurrency, _) ->\n            // find the quote currency, we express everything in terms of this currency since it is what the user\n            // selected. e.g if the user selects $CAD, we convert all other currencies in reference to $CAD\n            val quoteCurrency = exchangeRates.find { it.currencyCode == activateFiatCurrency.code } ?: return@map\n\n            if (quoteCurrency.rate == BigDecimal.ONE) {\n                exchangeRateSubject.onNext(exchangeRates)\n            } else {\n                // go through each base currency and convert them against our quote currency\n                // e.g if our current base currency is USD at the rate of 1 USD/USD\n                // and our currency quote currency is CAD at the rate of 0.77 CAD/USD\n                // map[USD] = 1/0.77 = 1.298 USD/CAD\n                val correctedExchangeRates = emptyList<ExchangeRate>().toMutableList()\n                exchangeRates.forEach { baseRate ->\n                    val correctedRate = baseRate.copy(rate = baseRate.rate / quoteCurrency.rate)\n                    correctedExchangeRates.add(correctedRate)\n                }\n                exchangeRateSubject.onNext(correctedExchangeRates)\n            }\n        }");
        h.c.k0.b subscribe = Single_AnalyticsKt.logError$default(map, null, null, 3, null).subscribeOn(this.ioScheduler).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "Singles\n        .zip(\n            exchangeRateDAO.getExchangeRates(),\n            activeFiatCurrencyObservable.takeSingle(),\n            isReadySubject.filter { it }.hide().takeSingle()\n        )\n        .map { (exchangeRates, activateFiatCurrency, _) ->\n            // find the quote currency, we express everything in terms of this currency since it is what the user\n            // selected. e.g if the user selects $CAD, we convert all other currencies in reference to $CAD\n            val quoteCurrency = exchangeRates.find { it.currencyCode == activateFiatCurrency.code } ?: return@map\n\n            if (quoteCurrency.rate == BigDecimal.ONE) {\n                exchangeRateSubject.onNext(exchangeRates)\n            } else {\n                // go through each base currency and convert them against our quote currency\n                // e.g if our current base currency is USD at the rate of 1 USD/USD\n                // and our currency quote currency is CAD at the rate of 0.77 CAD/USD\n                // map[USD] = 1/0.77 = 1.298 USD/CAD\n                val correctedExchangeRates = emptyList<ExchangeRate>().toMutableList()\n                exchangeRates.forEach { baseRate ->\n                    val correctedRate = baseRate.copy(rate = baseRate.rate / quoteCurrency.rate)\n                    correctedExchangeRates.add(correctedRate)\n                }\n                exchangeRateSubject.onNext(correctedExchangeRates)\n            }\n        }\n        .logError()\n        .subscribeOn(ioScheduler)\n        .subscribe()");
        return h.c.t0.a.a(subscribe, this.disposeBag);
    }

    /* renamed from: reloadExchangeRatesFromDatabase$lambda-32 */
    public static final boolean m1864reloadExchangeRatesFromDatabase$lambda32(Boolean it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.booleanValue();
    }

    /* renamed from: reloadExchangeRatesFromDatabase$lambda-35 */
    public static final kotlin.x m1865reloadExchangeRatesFromDatabase$lambda35(ExchangeRateRepository this$0, kotlin.t dstr$exchangeRates$activateFiatCurrency$_u24__u24) {
        Object obj;
        List g2;
        List<ExchangeRate> K0;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$exchangeRates$activateFiatCurrency$_u24__u24, "$dstr$exchangeRates$activateFiatCurrency$_u24__u24");
        List<ExchangeRate> exchangeRates = (List) dstr$exchangeRates$activateFiatCurrency$_u24__u24.a();
        FiatCurrency fiatCurrency = (FiatCurrency) dstr$exchangeRates$activateFiatCurrency$_u24__u24.b();
        kotlin.jvm.internal.m.f(exchangeRates, "exchangeRates");
        Iterator it = exchangeRates.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.jvm.internal.m.c(((ExchangeRate) obj).getCurrencyCode(), fiatCurrency.getCode())) {
                break;
            }
        }
        ExchangeRate exchangeRate = (ExchangeRate) obj;
        if (exchangeRate == null) {
            return kotlin.x.a;
        }
        if (kotlin.jvm.internal.m.c(exchangeRate.getRate(), BigDecimal.ONE)) {
            this$0.exchangeRateSubject.onNext(exchangeRates);
        } else {
            g2 = kotlin.a0.r.g();
            K0 = kotlin.a0.z.K0(g2);
            for (ExchangeRate exchangeRate2 : exchangeRates) {
                BigDecimal divide = exchangeRate2.getRate().divide(exchangeRate.getRate(), RoundingMode.HALF_EVEN);
                kotlin.jvm.internal.m.f(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
                K0.add(ExchangeRate.copy$default(exchangeRate2, null, null, divide, null, null, null, 59, null));
            }
            this$0.exchangeRateSubject.onNext(K0);
        }
        return kotlin.x.a;
    }

    public static /* synthetic */ BigDecimal s(String str, CurrencyCode currencyCode, List list) {
        return m1854getCryptoExchangeRate$lambda25(str, currencyCode, list);
    }

    /* renamed from: start$lambda-29 */
    public static final boolean m1866start$lambda29(kotlin.o lhs, kotlin.o rhs) {
        kotlin.jvm.internal.m.g(lhs, "lhs");
        kotlin.jvm.internal.m.g(rhs, "rhs");
        return kotlin.jvm.internal.m.c((List) lhs.a(), (List) rhs.a()) && kotlin.jvm.internal.m.c((FiatCurrency) lhs.b(), (FiatCurrency) rhs.b());
    }

    /* renamed from: start$lambda-30 */
    public static final h.c.x m1867start$lambda30(ExchangeRateRepository this$0, kotlin.o it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.refresh(false).toObservable();
    }

    /* renamed from: start$lambda-31 */
    public static final kotlin.x m1868start$lambda31(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public h.c.b0<Boolean> destroy() {
        List<ExchangeRate> g2;
        this.disposeBag.d();
        this.isReadySubject.onNext(Boolean.FALSE);
        h.c.v0.a<List<ExchangeRate>> aVar = this.exchangeRateSubject;
        g2 = kotlin.a0.r.g();
        aVar.onNext(g2);
        h.c.b0<Boolean> just = h.c.b0.just(Boolean.TRUE);
        kotlin.jvm.internal.m.f(just, "just(true)");
        return just;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository
    public h.c.b0<BigDecimal> getCryptoExchangeRate(final CurrencyCode cryptoCurrencyCode, final String str, int i2) {
        List<ContractAddress> g2;
        List<CurrencyCode> b2;
        kotlin.jvm.internal.m.g(cryptoCurrencyCode, "cryptoCurrencyCode");
        if (str != null) {
            g2 = kotlin.a0.q.b(new ContractAddress(str));
        } else {
            g2 = kotlin.a0.r.g();
        }
        ExchangeRateAPI exchangeRateAPI = this.exchangeRateApi;
        b2 = kotlin.a0.q.b(cryptoCurrencyCode);
        h.c.b0 map = exchangeRateAPI.getCryptoExchangeRates(b2, g2, i2).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.r
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.s(str, cryptoCurrencyCode, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "exchangeRateApi.getCryptoExchangeRates(\n            currencyCodes = listOf(cryptoCurrencyCode),\n            contractAddresses = contractAddresses,\n            chainId = chainId\n        )\n            .map { rates ->\n                val rateValue = if (contractAddress != null) {\n                    rates.firstOrNull { it.contractAddress == contractAddress }\n                } else {\n                    rates.firstOrNull { it.currencyCode == cryptoCurrencyCode }\n                }\n\n                rateValue?.rate ?: throw ExchangeRateException.UnableToGetExchangeRate\n            }");
        return map;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository
    public h.c.s<List<ExchangeRate>> getExchangeRateObservable() {
        return this.exchangeRateObservable;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository
    public h.c.b0<BigDecimal> getFiatExchangeRate(CurrencyCode fiatCurrencyCode) {
        List<CurrencyCode> b2;
        kotlin.jvm.internal.m.g(fiatCurrencyCode, "fiatCurrencyCode");
        ExchangeRateAPI exchangeRateAPI = this.exchangeRateApi;
        b2 = kotlin.a0.q.b(fiatCurrencyCode);
        h.c.b0 map = exchangeRateAPI.getFiatExchangeRates(b2).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.k((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "exchangeRateApi.getFiatExchangeRates(listOf(fiatCurrencyCode))\n        .map {\n            try {\n                it.first().rate\n            } catch (err: NoSuchElementException) {\n                throw ExchangeRateException.UnableToGetExchangeRate\n            }\n        }");
        return map;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository
    public h.c.b0<BigDecimal> getL2CryptoExchangeRate(final CurrencyCode cryptoCurrencyCode, final String str, List<Integer> chainIds) {
        List<ContractAddress> g2;
        List<CurrencyCode> b2;
        kotlin.jvm.internal.m.g(cryptoCurrencyCode, "cryptoCurrencyCode");
        kotlin.jvm.internal.m.g(chainIds, "chainIds");
        if (str != null) {
            g2 = kotlin.a0.q.b(new ContractAddress(str));
        } else {
            g2 = kotlin.a0.r.g();
        }
        ExchangeRateAPI exchangeRateAPI = this.exchangeRateApi;
        b2 = kotlin.a0.q.b(cryptoCurrencyCode);
        h.c.b0 map = exchangeRateAPI.getL2CryptoExchangeRates(b2, g2, chainIds).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.i(str, cryptoCurrencyCode, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "exchangeRateApi.getL2CryptoExchangeRates(\n            currencyCodes = listOf(cryptoCurrencyCode),\n            contractAddresses = contractAddresses,\n            chainIds = chainIds\n        )\n            .map { rates ->\n                val rateValue = if (contractAddress != null) {\n                    rates.firstOrNull { it.contractAddress == contractAddress }\n                } else {\n                    rates.firstOrNull { it.currencyCode == cryptoCurrencyCode }\n                }\n\n                rateValue?.rate ?: throw ExchangeRateException.UnableToGetExchangeRate\n            }");
        return map;
    }

    @Override // com.coinbase.wallet.core.interfaces.Refreshable
    public h.c.b0<kotlin.x> refresh(boolean z) {
        h.c.b0 flatMap = Observable_CoreKt.takeSingle(this.activeFiatCurrencyObservable).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.p(ExchangeRateRepository.this, (FiatCurrency) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "activeFiatCurrencyObservable\n            .takeSingle()\n            .flatMap {\n                val currencyCodes = listOf(it.code, CurrencyCode.USD).distinct()\n\n                exchangeRateApi.getFiatExchangeRates(currencyCodes)\n            }");
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 flatMap2 = eVar.a(Observable_CoreKt.takeSingle(IWalletRepository.DefaultImpls.observeWallets$default(this.walletRepository, false, 1, null)), this.exchangeRateApi.getConsumerSpotPrices()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.n(ExchangeRateRepository.this, (kotlin.o) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.f(ExchangeRateRepository.this, (kotlin.t) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap2, "Singles.zip(\n            walletRepository.observeWallets().takeSingle(),\n            exchangeRateApi.getConsumerSpotPrices()\n        )\n            .flatMap { (wallets, consumerExchangeRates) ->\n                val addresses = wallets.mapNotNull { it.contractAddress }\n                val codes = wallets.map { it.currencyCode } + consumerExchangeRates.map { it.currencyCode }\n\n                // get all underlying erc20 codes for the user's compound finance tokens\n                val underlyingContractAddresses = compoundFinanceRepository\n                    .getTokens(addresses)\n                    .mapNotNull { it.underlyingContractAddress }\n\n                val allContractAddresses = (addresses + underlyingContractAddresses)\n                    .distinct()\n                    .map { ContractAddress(it) }\n                val getCryptoExchangeRates = exchangeRateApi.getCryptoExchangeRates(\n                    currencyCodes = codes.distinct(),\n                    contractAddresses = allContractAddresses\n                )\n\n                val l2Wallets = wallets.filter {\n                    fetchedL2ChainIds.contains(EthereumChain.fromNetworkRawValue(it.network.rawValue)?.chainId)\n                }\n                val l2Addresses = l2Wallets\n                    .mapNotNull { it.contractAddress }\n                    .map { ContractAddress(it) }\n\n                // Only fetch the L2AssetPrices if there are contract addresses to fetch data for\n                // Most people will have no L2 wallets and this just spams the backend.\n                var getL2CryptoExchangeRates: Single<List<ExchangeRate>> = Single.just(emptyList())\n                if (l2Addresses.isNotEmpty()) {\n                    getL2CryptoExchangeRates = exchangeRateApi.getL2CryptoExchangeRates(\n                        currencyCodes = emptyList(),\n                        contractAddresses = l2Addresses,\n                        chainIds = fetchedL2ChainIds\n                    )\n                }\n\n                Singles.zip(getCryptoExchangeRates, getL2CryptoExchangeRates, Single.just(consumerExchangeRates))\n            }\n            .flatMap { (exchangeRates, l2ExchangeRates, consumerExchangeRates) ->\n                val mutableExchangeRates = exchangeRates\n                    .distinctBy { Pair(it.currencyCode, it.contractAddress?.toLowerCase(Locale.US)) }\n                    .toMutableList()\n\n                // Get and add all the supported L2 exchange rates that aren't already contained in the first list\n                l2ExchangeRates.forEach { l2ExchangeRate ->\n                    val foundItems = exchangeRates.filter { exchangeRate ->\n                        exchangeRate.currencyCode == l2ExchangeRate.currencyCode &&\n                        exchangeRate.contractAddress == l2ExchangeRate.contractAddress\n                    }\n\n                    if (foundItems.isEmpty()) {\n                        mutableExchangeRates.add(l2ExchangeRate)\n                    }\n                }\n\n                // we take consumer exchange rate over crypto exchange rate where possible\n                // if there are 2 tokens with same currency code - because consumer doesn't have contract address\n                // we do nothing, to avoid replacing the wrong one\n                consumerExchangeRates.forEach { consumerRate ->\n                    val matchingExchangeRates = mutableExchangeRates.filter { exchangeRate ->\n                        exchangeRate.currencyCode == consumerRate.currencyCode\n                    }\n                    if (matchingExchangeRates.count() == 1) {\n                        val matchingRate = matchingExchangeRates.first()\n                        val index = mutableExchangeRates.indexOf(matchingRate)\n                        val newRate = matchingRate.copy(rate = consumerRate.rate)\n                        mutableExchangeRates[index] = newRate\n                    }\n                }\n\n                calculateExchangeRate(mutableExchangeRates).map { mutableExchangeRates + it }\n            }");
        h.c.b0 map = eVar.a(flatMap2, flatMap).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.q(ExchangeRateRepository.this, (kotlin.o) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.r(ExchangeRateRepository.this, (Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zip(cryptoExchangeRatesSingles, fiatExchangeRatesSingles)\n            .flatMap { exchangeRateDAO.save(it.first + it.second) }\n            .map { reloadExchangeRatesFromDatabase() }");
        h.c.b0 trace = Single_CoreKt.trace(map, TraceKey_WalletsKt.exchangeRateRefreshTrace(TraceKey.Companion), this.tracer);
        kotlin.jvm.internal.m.f(trace, "Singles.zip(cryptoExchangeRatesSingles, fiatExchangeRatesSingles)\n            .flatMap { exchangeRateDAO.save(it.first + it.second) }\n            .map { reloadExchangeRatesFromDatabase() }\n            .trace(TraceKey.exchangeRateRefreshTrace(), tracer)");
        h.c.b0<kotlin.x> onErrorReturn = Single_CoreKt.asUnit(Single_AnalyticsKt.logError$default(trace, null, null, 3, null)).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.h((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "Singles.zip(cryptoExchangeRatesSingles, fiatExchangeRatesSingles)\n            .flatMap { exchangeRateDAO.save(it.first + it.second) }\n            .map { reloadExchangeRatesFromDatabase() }\n            .trace(TraceKey.exchangeRateRefreshTrace(), tracer)\n            .logError()\n            .asUnit()\n            .onErrorReturn { Unit }");
        return onErrorReturn;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        h.c.t0.c cVar = h.c.t0.c.a;
        h.c.s<List<CurrencyCode>> cryptoCurrencyCodesObservable = this.cryptoCurrencyCodesObservable;
        kotlin.jvm.internal.m.f(cryptoCurrencyCodesObservable, "cryptoCurrencyCodesObservable");
        h.c.s concatMap = cVar.a(cryptoCurrencyCodesObservable, this.activeFiatCurrencyObservable).throttleLatest(500L, TimeUnit.MILLISECONDS, this.ioScheduler, true).distinctUntilChanged(new h.c.m0.d() { // from class: com.coinbase.wallet.wallets.repositories.k
            @Override // h.c.m0.d
            public final boolean a(Object obj, Object obj2) {
                return ExchangeRateRepository.l((kotlin.o) obj, (kotlin.o) obj2);
            }
        }).concatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.b(ExchangeRateRepository.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(concatMap, "Observables.combineLatest(cryptoCurrencyCodesObservable, activeFiatCurrencyObservable)\n            .throttleLatest(500, TimeUnit.MILLISECONDS, ioScheduler, true)\n            .distinctUntilChanged { lhs, rhs ->\n                val (lhsCurrencies, lhsActiveCurrency) = lhs\n                val (rhsCurrencies, rhsActiveCurrency) = rhs\n\n                lhsCurrencies == rhsCurrencies && lhsActiveCurrency == rhsActiveCurrency\n            }\n            .concatMap { refresh(false).toObservable() }");
        h.c.k0.b subscribe = Observable_AnalyticsKt.logError$default(concatMap, null, null, 3, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExchangeRateRepository.j((Throwable) obj);
            }
        }).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "Observables.combineLatest(cryptoCurrencyCodesObservable, activeFiatCurrencyObservable)\n            .throttleLatest(500, TimeUnit.MILLISECONDS, ioScheduler, true)\n            .distinctUntilChanged { lhs, rhs ->\n                val (lhsCurrencies, lhsActiveCurrency) = lhs\n                val (rhsCurrencies, rhsActiveCurrency) = rhs\n\n                lhsCurrencies == rhsCurrencies && lhsActiveCurrency == rhsActiveCurrency\n            }\n            .concatMap { refresh(false).toObservable() }\n            .logError()\n            .onErrorReturn { Unit }\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
        this.isReadySubject.onNext(Boolean.TRUE);
    }
}