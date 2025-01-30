package com.coinbase.wallet.features.send.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.CurrencyDecimal;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.dtos.AdjustableMinerFee1559Result;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyDecimal_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.models.AdjustableMinerFeeResponse;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import com.coinbase.wallet.features.send.models.AdjustableMinerFee1559Info;
import com.coinbase.wallet.features.send.models.AdjustableMinerFee1559Infos;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeInfo;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeInfos;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.wallets.extensions.StoreKeys_WalletsKt;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import h.c.b0;
import h.c.h0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.z;

/* compiled from: AdjustableMinerFeeRepository.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b,\u0010-J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00108B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/coinbase/wallet/features/send/repositories/AdjustableMinerFeeRepository;", "", "Ljava/math/BigInteger;", "minerFeeLimit", "overridingGasPrice", "Lh/c/b0;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeInfos;", "getMinerFeesLegacy", "(Ljava/math/BigInteger;Ljava/math/BigInteger;)Lh/c/b0;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559Infos;", "getMinerFees1559", "(Ljava/math/BigInteger;)Lh/c/b0;", "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "ethereumChain", "", "fromAddress", "", "calculateNonce", "(Lcom/coinbase/ciphercore/ethereum/EthereumChain;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "minerFeesAPI", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getBaseCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "baseCurrencyCode", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "getChainId", "()I", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "ethereumSignedTxDao", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeRepository {
    private final CipherCoreInterface cipherCore;
    private final CurrencyFormatter currencyFormatter;
    private final EthereumSignedTxDao ethereumSignedTxDao;
    private final IExchangeRateRepository exchangeRateRepository;
    private final MinerFeeAPI minerFeesAPI;
    private final StoreInterface store;

    public AdjustableMinerFeeRepository(IExchangeRateRepository exchangeRateRepository, CurrencyFormatter currencyFormatter, CipherCoreInterface cipherCore, MinerFeeAPI minerFeesAPI, EthereumSignedTxDao ethereumSignedTxDao, StoreInterface store) {
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(minerFeesAPI, "minerFeesAPI");
        kotlin.jvm.internal.m.g(ethereumSignedTxDao, "ethereumSignedTxDao");
        kotlin.jvm.internal.m.g(store, "store");
        this.exchangeRateRepository = exchangeRateRepository;
        this.currencyFormatter = currencyFormatter;
        this.cipherCore = cipherCore;
        this.minerFeesAPI = minerFeesAPI;
        this.ethereumSignedTxDao = ethereumSignedTxDao;
        this.store = store;
    }

    public static /* synthetic */ AdjustableMinerFee1559Infos a(BigInteger bigInteger, AdjustableMinerFeeRepository adjustableMinerFeeRepository, AdjustableMinerFee1559Result adjustableMinerFee1559Result) {
        return m1334getMinerFees1559$lambda7(bigInteger, adjustableMinerFeeRepository, adjustableMinerFee1559Result);
    }

    public static /* synthetic */ AdjustableMinerFeeInfos b(BigInteger bigInteger, BigInteger bigInteger2, AdjustableMinerFeeRepository adjustableMinerFeeRepository, kotlin.o oVar) {
        return m1335getMinerFeesLegacy$lambda4(bigInteger, bigInteger2, adjustableMinerFeeRepository, oVar);
    }

    public static /* synthetic */ h0 c(AdjustableMinerFeeRepository adjustableMinerFeeRepository, EthereumChain ethereumChain, String str, Integer num) {
        return m1333calculateNonce$lambda8(adjustableMinerFeeRepository, ethereumChain, str, num);
    }

    /* renamed from: calculateNonce$lambda-10 */
    public static final Integer m1332calculateNonce$lambda10(kotlin.o dstr$confirmedTxCount$pendingSignedTxs) {
        int r;
        kotlin.jvm.internal.m.g(dstr$confirmedTxCount$pendingSignedTxs, "$dstr$confirmedTxCount$pendingSignedTxs");
        Integer confirmedTxCount = (Integer) dstr$confirmedTxCount$pendingSignedTxs.a();
        List<EthereumSignedTx> pendingSignedTxs = (List) dstr$confirmedTxCount$pendingSignedTxs.b();
        kotlin.jvm.internal.m.f(pendingSignedTxs, "pendingSignedTxs");
        r = kotlin.a0.s.r(pendingSignedTxs, 10);
        ArrayList arrayList = new ArrayList(r);
        for (EthereumSignedTx ethereumSignedTx : pendingSignedTxs) {
            arrayList.add(Integer.valueOf(ethereumSignedTx.getNonce()));
        }
        Integer num = (Integer) kotlin.a0.p.n0(arrayList);
        if (num == null) {
            return confirmedTxCount;
        }
        int intValue = num.intValue();
        kotlin.jvm.internal.m.f(confirmedTxCount, "confirmedTxCount");
        return confirmedTxCount.intValue() > intValue ? confirmedTxCount : Integer.valueOf(intValue + 1);
    }

    /* renamed from: calculateNonce$lambda-8 */
    public static final h0 m1333calculateNonce$lambda8(AdjustableMinerFeeRepository this$0, EthereumChain ethereumChain, String fromAddress, Integer confirmedTxCount) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(ethereumChain, "$ethereumChain");
        kotlin.jvm.internal.m.g(fromAddress, "$fromAddress");
        kotlin.jvm.internal.m.g(confirmedTxCount, "confirmedTxCount");
        b0<List<EthereumSignedTx>> unminedSignedTxsAfterNonce = this$0.ethereumSignedTxDao.getUnminedSignedTxsAfterNonce(confirmedTxCount.intValue(), ethereumChain.getChainId(), fromAddress);
        h.c.t0.e eVar = h.c.t0.e.a;
        b0 just = b0.just(confirmedTxCount);
        kotlin.jvm.internal.m.f(just, "just(confirmedTxCount)");
        return eVar.a(just, unminedSignedTxsAfterNonce);
    }

    public static /* synthetic */ Integer d(kotlin.o oVar) {
        return m1332calculateNonce$lambda10(oVar);
    }

    private final CurrencyCode getBaseCurrencyCode() {
        EthereumChain asEthereumChain;
        String baseAssetCurrencyCode;
        Network network = (Network) this.store.get(StoreKeys_WalletsKt.activeNetwork(StoreKeys.INSTANCE, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)));
        String str = "ETH";
        if (network != null && (asEthereumChain = Network_EthereumKt.getAsEthereumChain(network)) != null && (baseAssetCurrencyCode = asEthereumChain.getBaseAssetCurrencyCode()) != null) {
            str = baseAssetCurrencyCode;
        }
        return new CurrencyCode(str);
    }

    private final int getChainId() {
        EthereumChain asEthereumChain;
        Network network = (Network) this.store.get(StoreKeys_WalletsKt.activeNetwork(StoreKeys.INSTANCE, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)));
        Integer num = null;
        if (network != null && (asEthereumChain = Network_EthereumKt.getAsEthereumChain(network)) != null) {
            num = Integer.valueOf(asEthereumChain.getChainId());
        }
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    /* renamed from: getMinerFees1559$lambda-7 */
    public static final AdjustableMinerFee1559Infos m1334getMinerFees1559$lambda7(BigInteger minerFeeLimit, AdjustableMinerFeeRepository this$0, AdjustableMinerFee1559Result feeData) {
        List j2;
        List j3;
        List<kotlin.o> Q0;
        int r;
        int r2;
        String formatToCryptoRange;
        String formatToFiatRange;
        kotlin.jvm.internal.m.g(minerFeeLimit, "$minerFeeLimit");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(feeData, "feeData");
        BigInteger add = feeData.getBaseFee().add(feeData.getSlowPriorityFee());
        kotlin.jvm.internal.m.f(add, "this.add(other)");
        BigInteger multiply = add.multiply(minerFeeLimit);
        kotlin.jvm.internal.m.f(multiply, "this.multiply(other)");
        BigInteger add2 = feeData.getBaseFee().add(feeData.getNormalPriorityFee());
        kotlin.jvm.internal.m.f(add2, "this.add(other)");
        BigInteger multiply2 = add2.multiply(minerFeeLimit);
        kotlin.jvm.internal.m.f(multiply2, "this.multiply(other)");
        BigInteger add3 = feeData.getBaseFee().add(feeData.getFastPriorityFee());
        kotlin.jvm.internal.m.f(add3, "this.add(other)");
        BigInteger multiply3 = add3.multiply(minerFeeLimit);
        kotlin.jvm.internal.m.f(multiply3, "this.multiply(other)");
        j2 = kotlin.a0.r.j(multiply, multiply2, multiply3);
        BigInteger multiply4 = feeData.getSlowMaxFeePerGas().multiply(minerFeeLimit);
        kotlin.jvm.internal.m.f(multiply4, "this.multiply(other)");
        BigInteger multiply5 = feeData.getNormalMaxFeePerGas().multiply(minerFeeLimit);
        kotlin.jvm.internal.m.f(multiply5, "this.multiply(other)");
        BigInteger multiply6 = feeData.getFastMaxFeePerGas().multiply(minerFeeLimit);
        kotlin.jvm.internal.m.f(multiply6, "this.multiply(other)");
        j3 = kotlin.a0.r.j(multiply4, multiply5, multiply6);
        Q0 = z.Q0(j2, j3);
        r = kotlin.a0.s.r(Q0, 10);
        ArrayList arrayList = new ArrayList(r);
        for (kotlin.o oVar : Q0) {
            formatToFiatRange = this$0.currencyFormatter.formatToFiatRange(this$0.getBaseCurrencyCode(), null, 18, (BigInteger) oVar.a(), (BigInteger) oVar.b(), (r20 & 32) != 0 ? false : false, (r20 & 64) != 0 ? null : null, (r20 & 128) != 0 ? null : Integer.valueOf(this$0.getChainId()));
            if (formatToFiatRange == null) {
                formatToFiatRange = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
            }
            arrayList.add(formatToFiatRange);
        }
        r2 = kotlin.a0.s.r(Q0, 10);
        ArrayList arrayList2 = new ArrayList(r2);
        for (kotlin.o oVar2 : Q0) {
            formatToCryptoRange = this$0.currencyFormatter.formatToCryptoRange(this$0.getBaseCurrencyCode(), 18, (BigInteger) oVar2.a(), (BigInteger) oVar2.b(), (r17 & 16) != 0, (r17 & 32) != 0 ? 4 : 0, (r17 & 64) != 0 ? 0 : 0);
            arrayList2.add(formatToCryptoRange);
        }
        return new AdjustableMinerFee1559Infos(new AdjustableMinerFee1559Info(feeData.getSlowMaxFeePerGas(), feeData.getSlowPriorityFee(), feeData.getBaseFee(), (String) arrayList.get(0), (String) arrayList2.get(0)), new AdjustableMinerFee1559Info(feeData.getNormalMaxFeePerGas(), feeData.getNormalPriorityFee(), feeData.getBaseFee(), (String) arrayList.get(1), (String) arrayList2.get(1)), new AdjustableMinerFee1559Info(feeData.getFastMaxFeePerGas(), feeData.getFastPriorityFee(), feeData.getBaseFee(), (String) arrayList.get(2), (String) arrayList2.get(2)));
    }

    /* renamed from: getMinerFeesLegacy$lambda-4 */
    public static final AdjustableMinerFeeInfos m1335getMinerFeesLegacy$lambda4(BigInteger bigInteger, BigInteger minerFeeLimit, AdjustableMinerFeeRepository this$0, kotlin.o dstr$response$rate) {
        List<BigInteger> m;
        int r;
        int r2;
        int r3;
        int r4;
        kotlin.jvm.internal.m.g(minerFeeLimit, "$minerFeeLimit");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$response$rate, "$dstr$response$rate");
        AdjustableMinerFeeResponse adjustableMinerFeeResponse = (AdjustableMinerFeeResponse) dstr$response$rate.a();
        BigDecimal rate = (BigDecimal) dstr$response$rate.b();
        m = kotlin.a0.r.m(adjustableMinerFeeResponse.getSlow(), adjustableMinerFeeResponse.getNormal(), adjustableMinerFeeResponse.getFast());
        if (bigInteger != null) {
            if (bigInteger.compareTo((BigInteger) m.get(2)) > 0) {
                m.set(2, bigInteger);
            } else if (bigInteger.compareTo((BigInteger) m.get(0)) < 0) {
                m.set(0, bigInteger);
            } else {
                m.set(1, bigInteger);
            }
        }
        r = kotlin.a0.s.r(m, 10);
        ArrayList<BigInteger> arrayList = new ArrayList(r);
        for (BigInteger bigInteger2 : m) {
            BigInteger multiply = bigInteger2.multiply(minerFeeLimit);
            kotlin.jvm.internal.m.f(multiply, "this.multiply(other)");
            arrayList.add(multiply);
        }
        r2 = kotlin.a0.s.r(arrayList, 10);
        ArrayList<BigDecimal> arrayList2 = new ArrayList(r2);
        for (BigInteger bigInteger3 : arrayList) {
            arrayList2.add(new BigDecimal(bigInteger3).movePointLeft(CurrencyDecimal_EthereumKt.getETH(CurrencyDecimal.INSTANCE)));
        }
        r3 = kotlin.a0.s.r(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(r3);
        for (BigDecimal it : arrayList2) {
            CurrencyFormatter currencyFormatter = this$0.currencyFormatter;
            kotlin.jvm.internal.m.f(rate, "rate");
            kotlin.jvm.internal.m.f(it, "it");
            BigDecimal multiply2 = rate.multiply(it);
            kotlin.jvm.internal.m.f(multiply2, "this.multiply(other)");
            arrayList3.add(CurrencyFormatter.fiatValueString$default(currencyFormatter, multiply2, false, 2, null));
        }
        r4 = kotlin.a0.s.r(arrayList, 10);
        ArrayList arrayList4 = new ArrayList(r4);
        for (BigInteger bigInteger4 : arrayList) {
            arrayList4.add(CurrencyFormatter.formatToCrypto$default(this$0.currencyFormatter, this$0.getBaseCurrencyCode(), 18, bigInteger4, false, 0, 0, 56, (Object) null));
        }
        return new AdjustableMinerFeeInfos(new AdjustableMinerFeeInfo((BigInteger) m.get(0), (String) arrayList3.get(0), (String) arrayList4.get(0)), new AdjustableMinerFeeInfo((BigInteger) m.get(1), (String) arrayList3.get(1), (String) arrayList4.get(1)), new AdjustableMinerFeeInfo((BigInteger) m.get(2), (String) arrayList3.get(2), (String) arrayList4.get(2)), adjustableMinerFeeResponse.getWaitTimes());
    }

    public final b0<Integer> calculateNonce(final EthereumChain ethereumChain, final String fromAddress) {
        kotlin.jvm.internal.m.g(ethereumChain, "ethereumChain");
        kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
        b0<Integer> map = CipherCoreInterface.DefaultImpls.getConfirmedEthereumTransactionCount$default(this.cipherCore, fromAddress, ethereumChain.getChainId(), null, 4, null).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AdjustableMinerFeeRepository.c(AdjustableMinerFeeRepository.this, ethereumChain, fromAddress, (Integer) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AdjustableMinerFeeRepository.d((kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "cipherCore.getConfirmedEthereumTransactionCount(\n            address = fromAddress,\n            chainId = ethereumChain.chainId\n        ).flatMap { confirmedTxCount ->\n            val pendingSignedTxs = ethereumSignedTxDao.getUnminedSignedTxsAfterNonce(\n                nonce = confirmedTxCount,\n                chainId = ethereumChain.chainId,\n                fromAddress = fromAddress\n            )\n\n            Singles.zip(Single.just(confirmedTxCount), pendingSignedTxs)\n        }.map { (confirmedTxCount, pendingSignedTxs) ->\n\n            // Find the signed transaction which has the maximum nonce\n            // If none exists, just return the confirmed tx count as the nonce\n            val maxPendingSignedTxNonce = pendingSignedTxs.map { it.nonce }.maxOrNull() ?: return@map confirmedTxCount\n\n            // Choose the greater between the number of confirmed transactions\n            // and the maximum nonce found in unconfirmed transactions\n            // If confirmedTxCount is greater, do no increment by one,\n            // because nonce is 0 based while tx count is 1 based\n            // If maxUnconfirmedTxNonce is greater, increment by one\n            val nonce = if (confirmedTxCount > maxPendingSignedTxNonce) {\n                confirmedTxCount\n            } else {\n                maxPendingSignedTxNonce + 1\n            }\n\n            nonce\n        }");
        return map;
    }

    public final b0<AdjustableMinerFee1559Infos> getMinerFees1559(final BigInteger minerFeeLimit) {
        kotlin.jvm.internal.m.g(minerFeeLimit, "minerFeeLimit");
        b0 map = this.minerFeesAPI.get1559MinerFeeEstimates(getChainId()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AdjustableMinerFeeRepository.a(minerFeeLimit, this, (AdjustableMinerFee1559Result) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "minerFeesAPI.get1559MinerFeeEstimates(chainId)\n            .map { feeData ->\n                val feeRanges = listOf(\n                    (feeData.baseFee + feeData.slowPriorityFee) * minerFeeLimit,\n                    (feeData.baseFee + feeData.normalPriorityFee) * minerFeeLimit,\n                    (feeData.baseFee + feeData.fastPriorityFee) * minerFeeLimit\n                )\n                    .zip(\n                        listOf(\n                            feeData.slowMaxFeePerGas * minerFeeLimit,\n                            feeData.normalMaxFeePerGas * minerFeeLimit,\n                            feeData.fastMaxFeePerGas * minerFeeLimit\n                        )\n                    )\n\n                val fiatRangeStrings = feeRanges.map { (lowerBoundFee, maxFee) ->\n\n                    currencyFormatter.formatToFiatRange(\n                        fromCurrencyCode = baseCurrencyCode,\n                        contractAddress = null,\n                        decimals = 18,\n                        lowerBoundValue = lowerBoundFee,\n                        upperBoundValue = maxFee,\n                        chainId = chainId\n                    ) ?: Strings.ellipsis\n                }\n\n                val cryptoRangeStrings = feeRanges.map { (lowerBoundFee, maxFee) ->\n                    currencyFormatter.formatToCryptoRange(\n                        currencyCode = baseCurrencyCode,\n                        decimals = 18,\n                        lowerBoundValue = lowerBoundFee,\n                        upperBoundValue = maxFee\n                    )\n                }\n\n                AdjustableMinerFee1559Infos(\n                    slow = AdjustableMinerFee1559Info(\n                        maxFeePerGas = feeData.slowMaxFeePerGas,\n                        baseFeePerGas = feeData.baseFee,\n                        maxPriorityFeePerGas = feeData.slowPriorityFee,\n                        fiatRangeString = fiatRangeStrings[0],\n                        cryptoRangeString = cryptoRangeStrings[0]\n                    ),\n                    normal = AdjustableMinerFee1559Info(\n                        maxFeePerGas = feeData.normalMaxFeePerGas,\n                        baseFeePerGas = feeData.baseFee,\n                        maxPriorityFeePerGas = feeData.normalPriorityFee,\n                        fiatRangeString = fiatRangeStrings[1],\n                        cryptoRangeString = cryptoRangeStrings[1]\n                    ),\n                    fast = AdjustableMinerFee1559Info(\n                        maxFeePerGas = feeData.fastMaxFeePerGas,\n                        baseFeePerGas = feeData.baseFee,\n                        maxPriorityFeePerGas = feeData.fastPriorityFee,\n                        fiatRangeString = fiatRangeStrings[2],\n                        cryptoRangeString = cryptoRangeStrings[2]\n                    )\n                )\n            }");
        return map;
    }

    public final b0<AdjustableMinerFeeInfos> getMinerFeesLegacy(final BigInteger minerFeeLimit, final BigInteger bigInteger) {
        kotlin.jvm.internal.m.g(minerFeeLimit, "minerFeeLimit");
        b0<AdjustableMinerFeeInfos> map = h.c.t0.f.a(this.minerFeesAPI.getMinerFeeEstimates(getChainId()), IExchangeRateRepository.DefaultImpls.getCryptoExchangeRate$default(this.exchangeRateRepository, getBaseCurrencyCode(), null, getChainId(), 2, null)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.repositories.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return AdjustableMinerFeeRepository.b(bigInteger, minerFeeLimit, this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "minerFeesAPI.getMinerFeeEstimates(chainId)\n            .zipWith(exchangeRateRepository.getCryptoExchangeRate(baseCurrencyCode, chainId = chainId))\n            .map { (response, rate) ->\n                val minerFeePresets = mutableListOf(\n                    response.slow,\n                    response.normal,\n                    response.fast\n                )\n                if (overridingGasPrice != null) {\n                    when {\n                        overridingGasPrice > minerFeePresets[2] -> {\n                            minerFeePresets[2] = overridingGasPrice\n                        }\n                        overridingGasPrice < minerFeePresets[0] -> {\n                            minerFeePresets[0] = overridingGasPrice\n                        }\n                        else -> {\n                            minerFeePresets[1] = overridingGasPrice\n                        }\n                    }\n                }\n\n                val weiFees = minerFeePresets.map { it.times(minerFeeLimit) }\n                val ethBasedFees = weiFees.map { it.toBigDecimal().movePointLeft(CurrencyDecimal.ETH) }\n                val fiatStrings = ethBasedFees.map { currencyFormatter.fiatValueString(rate * it) }\n                val cryptoStrings = weiFees.map { fee ->\n                    currencyFormatter.formatToCrypto(currencyCode = baseCurrencyCode, decimals = 18, value = fee)\n                }\n                AdjustableMinerFeeInfos(\n                    slow = AdjustableMinerFeeInfo(\n                        gasPrice = minerFeePresets[0],\n                        fiatFee = fiatStrings[0],\n                        cryptoFee = cryptoStrings[0]\n                    ),\n                    normal = AdjustableMinerFeeInfo(\n                        gasPrice = minerFeePresets[1],\n                        fiatFee = fiatStrings[1],\n                        cryptoFee = cryptoStrings[1]\n                    ),\n                    fast = AdjustableMinerFeeInfo(\n                        gasPrice = minerFeePresets[2],\n                        fiatFee = fiatStrings[2],\n                        cryptoFee = cryptoStrings[2]\n                    ),\n                    waitTimes = response.waitTimes\n                )\n            }");
        return map;
    }
}