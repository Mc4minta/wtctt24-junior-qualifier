package com.coinbase.wallet.features.lend.interfaces;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.common.extensions.BigDecimal_CommonKt;
import com.coinbase.wallet.common.extensions.List_WalletsKt;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.features.lend.interfaces.LendBalanceManaging;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import h.c.b0;
import h.c.m0.n;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.t;
import kotlin.u;

/* compiled from: LendBalanceManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/features/lend/interfaces/LendBalanceManaging;", "", "Lh/c/b0;", "", "getTotalFiatBalance", "()Lh/c/b0;", "getAverageWeightedInterest", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "getLendRepository", "()Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "lendRepository", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "getCurrencyFormatter", "()Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lh/c/s;", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "getActiveFiatCurrencyObservable", "()Lh/c/s;", "activeFiatCurrencyObservable", "", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "getExchangeRateObservable", "exchangeRateObservable", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface LendBalanceManaging {

    /* compiled from: LendBalanceManaging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ String a(LendBalanceManaging lendBalanceManaging, t tVar) {
            return m1271getTotalFiatBalance$lambda2(lendBalanceManaging, tVar);
        }

        public static /* synthetic */ String b(o oVar) {
            return m1270getAverageWeightedInterest$lambda9(oVar);
        }

        public static b0<String> getAverageWeightedInterest(LendBalanceManaging lendBalanceManaging) {
            m.g(lendBalanceManaging, "this");
            b0<String> map = h.c.t0.e.a.a(Observable_CoreKt.takeSingle(lendBalanceManaging.getLendRepository().observeTokens()), Observable_CoreKt.takeSingle(lendBalanceManaging.getExchangeRateObservable())).map(new n() { // from class: com.coinbase.wallet.features.lend.interfaces.d
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return LendBalanceManaging.DefaultImpls.b((o) obj);
                }
            });
            m.f(map, "Singles\n        .zip(\n            lendRepository.observeTokens().takeSingle(),\n            exchangeRateObservable.takeSingle()\n        )\n        .map { (tokens, exchangeRates) ->\n            val fiatBalances = tokens\n                .filter { it.supplyBalance > BigInteger.ZERO }\n                .mapNotNull { token ->\n                    val exchangeRate = exchangeRates.rateFor(\n                        currencyCode = token.currencyCode,\n                        contractAddress = token.contractAddress?.rawValue\n                    ) ?: return@mapNotNull null\n                    token to (exchangeRate * BigDecimal(token.supplyBalance)).movePointLeft(token.decimals)\n                }\n\n            val totalFiatBalance = fiatBalances.map { it.second }.fold(BigDecimal.ZERO) { acc, e -> acc + e }\n            val decimals = tokens.firstOrNull()?.rateDecimals ?: return@map BigDecimal.ZERO.asPercentage(decimals = 1)\n\n            if (totalFiatBalance <= BigDecimal.ZERO) {\n                return@map BigDecimal.ZERO.asPercentage(decimals = decimals)\n            }\n\n            val supplyWeight = fiatBalances\n                .map { it.second * BigDecimal(it.first.supplyInterestRate).movePointLeft(decimals) }\n                .fold(BigDecimal.ZERO) { acc, e -> acc + e }\n\n            (supplyWeight / totalFiatBalance).asPercentage(decimals = decimals)\n        }");
            return map;
        }

        /* renamed from: getAverageWeightedInterest$lambda-9 */
        public static String m1270getAverageWeightedInterest$lambda9(o dstr$tokens$exchangeRates) {
            int r;
            int r2;
            m.g(dstr$tokens$exchangeRates, "$dstr$tokens$exchangeRates");
            List tokens = (List) dstr$tokens$exchangeRates.a();
            List exchangeRates = (List) dstr$tokens$exchangeRates.b();
            m.f(tokens, "tokens");
            ArrayList arrayList = new ArrayList();
            Iterator it = tokens.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((LendToken) next).getSupplyBalance().compareTo(BigInteger.ZERO) > 0) {
                    arrayList.add(next);
                }
            }
            ArrayList<o> arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (true) {
                o oVar = null;
                if (!it2.hasNext()) {
                    break;
                }
                LendToken lendToken = (LendToken) it2.next();
                m.f(exchangeRates, "exchangeRates");
                CurrencyCode currencyCode = lendToken.getCurrencyCode();
                ContractAddress contractAddress = lendToken.getContractAddress();
                BigDecimal rateFor$default = List_WalletsKt.rateFor$default(exchangeRates, currencyCode, contractAddress == null ? null : contractAddress.getRawValue(), null, null, 12, null);
                if (rateFor$default != null) {
                    BigDecimal multiply = rateFor$default.multiply(new BigDecimal(lendToken.getSupplyBalance()));
                    m.f(multiply, "this.multiply(other)");
                    oVar = u.a(lendToken, multiply.movePointLeft(lendToken.getDecimals()));
                }
                if (oVar != null) {
                    arrayList2.add(oVar);
                }
            }
            r = s.r(arrayList2, 10);
            ArrayList<BigDecimal> arrayList3 = new ArrayList(r);
            for (o oVar2 : arrayList2) {
                arrayList3.add((BigDecimal) oVar2.d());
            }
            BigDecimal totalFiatBalance = BigDecimal.ZERO;
            for (BigDecimal e2 : arrayList3) {
                m.f(totalFiatBalance, "acc");
                m.f(e2, "e");
                totalFiatBalance = totalFiatBalance.add(e2);
                m.f(totalFiatBalance, "this.add(other)");
            }
            LendToken lendToken2 = (LendToken) p.a0(tokens);
            Integer valueOf = lendToken2 != null ? Integer.valueOf(lendToken2.getRateDecimals()) : null;
            if (valueOf == null) {
                BigDecimal ZERO = BigDecimal.ZERO;
                m.f(ZERO, "ZERO");
                return BigDecimal_CommonKt.asPercentage(ZERO, 1);
            }
            int intValue = valueOf.intValue();
            if (totalFiatBalance.compareTo(BigDecimal.ZERO) <= 0) {
                BigDecimal ZERO2 = BigDecimal.ZERO;
                m.f(ZERO2, "ZERO");
                return BigDecimal_CommonKt.asPercentage(ZERO2, intValue);
            }
            r2 = s.r(arrayList2, 10);
            ArrayList<BigDecimal> arrayList4 = new ArrayList(r2);
            for (o oVar3 : arrayList2) {
                Object d2 = oVar3.d();
                m.f(d2, "it.second");
                BigDecimal movePointLeft = new BigDecimal(((LendToken) oVar3.c()).getSupplyInterestRate()).movePointLeft(intValue);
                m.f(movePointLeft, "BigDecimal(it.first.supplyInterestRate).movePointLeft(decimals)");
                BigDecimal multiply2 = ((BigDecimal) d2).multiply(movePointLeft);
                m.f(multiply2, "this.multiply(other)");
                arrayList4.add(multiply2);
            }
            BigDecimal supplyWeight = BigDecimal.ZERO;
            for (BigDecimal bigDecimal : arrayList4) {
                m.f(supplyWeight, "acc");
                supplyWeight = supplyWeight.add(bigDecimal);
                m.f(supplyWeight, "this.add(other)");
            }
            m.f(supplyWeight, "supplyWeight");
            m.f(totalFiatBalance, "totalFiatBalance");
            BigDecimal divide = supplyWeight.divide(totalFiatBalance, RoundingMode.HALF_EVEN);
            m.f(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
            return BigDecimal_CommonKt.asPercentage(divide, intValue);
        }

        public static b0<String> getTotalFiatBalance(final LendBalanceManaging lendBalanceManaging) {
            m.g(lendBalanceManaging, "this");
            b0<String> map = h.c.t0.e.a.b(Observable_CoreKt.takeSingle(lendBalanceManaging.getLendRepository().observeTokens()), Observable_CoreKt.takeSingle(lendBalanceManaging.getExchangeRateObservable()), Observable_CoreKt.takeSingle(lendBalanceManaging.getActiveFiatCurrencyObservable())).map(new n() { // from class: com.coinbase.wallet.features.lend.interfaces.c
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return LendBalanceManaging.DefaultImpls.a(LendBalanceManaging.this, (t) obj);
                }
            });
            m.f(map, "Singles\n        .zip(\n            lendRepository.observeTokens().takeSingle(),\n            exchangeRateObservable.takeSingle(),\n            activeFiatCurrencyObservable.takeSingle()\n        )\n        .map { (tokens, exchangeRates, _) ->\n            val fiatBalance = tokens\n                .mapNotNull { token ->\n                    val balance = token.supplyBalance\n                    val exchangeRate = exchangeRates.rateFor(\n                        currencyCode = token.currencyCode,\n                        contractAddress = token.contractAddress?.rawValue\n                    ) ?: return@mapNotNull null\n\n                    (exchangeRate * BigDecimal(balance)).movePointLeft(token.decimals)\n                }\n                .fold(BigDecimal.ZERO) { acc, tokenFiatBalance -> acc + tokenFiatBalance }\n\n            currencyFormatter.fiatValueString(fiatBalance)\n        }");
            return map;
        }

        /* renamed from: getTotalFiatBalance$lambda-2 */
        public static String m1271getTotalFiatBalance$lambda2(LendBalanceManaging this$0, t dstr$tokens$exchangeRates$_u24__u24) {
            m.g(this$0, "this$0");
            m.g(dstr$tokens$exchangeRates$_u24__u24, "$dstr$tokens$exchangeRates$_u24__u24");
            List tokens = (List) dstr$tokens$exchangeRates$_u24__u24.a();
            List exchangeRates = (List) dstr$tokens$exchangeRates$_u24__u24.b();
            m.f(tokens, "tokens");
            ArrayList<BigDecimal> arrayList = new ArrayList();
            Iterator it = tokens.iterator();
            while (true) {
                BigDecimal bigDecimal = null;
                if (!it.hasNext()) {
                    break;
                }
                LendToken lendToken = (LendToken) it.next();
                BigInteger supplyBalance = lendToken.getSupplyBalance();
                m.f(exchangeRates, "exchangeRates");
                CurrencyCode currencyCode = lendToken.getCurrencyCode();
                ContractAddress contractAddress = lendToken.getContractAddress();
                BigDecimal rateFor$default = List_WalletsKt.rateFor$default(exchangeRates, currencyCode, contractAddress == null ? null : contractAddress.getRawValue(), null, null, 12, null);
                if (rateFor$default != null) {
                    BigDecimal multiply = rateFor$default.multiply(new BigDecimal(supplyBalance));
                    m.f(multiply, "this.multiply(other)");
                    bigDecimal = multiply.movePointLeft(lendToken.getDecimals());
                }
                if (bigDecimal != null) {
                    arrayList.add(bigDecimal);
                }
            }
            BigDecimal fiatBalance = BigDecimal.ZERO;
            for (BigDecimal bigDecimal2 : arrayList) {
                m.f(fiatBalance, "acc");
                fiatBalance = fiatBalance.add(bigDecimal2);
                m.f(fiatBalance, "this.add(other)");
            }
            CurrencyFormatter currencyFormatter = this$0.getCurrencyFormatter();
            m.f(fiatBalance, "fiatBalance");
            return CurrencyFormatter.fiatValueString$default(currencyFormatter, fiatBalance, false, 2, null);
        }
    }

    h.c.s<FiatCurrency> getActiveFiatCurrencyObservable();

    b0<String> getAverageWeightedInterest();

    CurrencyFormatter getCurrencyFormatter();

    h.c.s<List<ExchangeRate>> getExchangeRateObservable();

    ILendRepository getLendRepository();

    b0<String> getTotalFiatBalance();
}