package com.coinbase.wallet.features.send.viewmodels;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.application.extensions.BigInteger_ApplicationKt;
import com.coinbase.wallet.bitcoin.extensions.Blockchain_BitcoinKt;
import com.coinbase.wallet.bitcoin.extensions.CurrencyCode_BitcoinKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.BigDecimal_CommonKt;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.features.send.extensions.StoreKeys_SendKt;
import com.coinbase.wallet.features.send.models.SendBalances;
import com.coinbase.wallet.features.wallets.extensions.Wallet_ApplicationKt;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import h.c.h0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* compiled from: SendViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\bE\u0010FJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0013J\r\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0013R$\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\f0\f0\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010 R$\u0010!\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u000e0\u000e0\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001cR$\u0010#\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\"0\"0\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001cR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010$R\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0%8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*R$\u0010-\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u000e0\u000e0\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\u001cR$\u0010/\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e0%8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010(\u001a\u0004\b3\u0010*R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0013\u00108\u001a\u00020\u000e8F@\u0006¢\u0006\u0006\u001a\u0004\b7\u00100R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0%8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010(\u001a\u0004\b<\u0010*R$\u0010=\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\f0\f0\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010\u001cR\u001f\u0010>\u001a\b\u0012\u0004\u0012\u00020\"0%8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010(\u001a\u0004\b?\u0010*R\u001f\u0010@\u001a\b\u0012\u0004\u0012\u00020\f0%8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010(\u001a\u0004\bA\u0010*R\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/SendViewModel;", "Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lkotlin/x;", "setWallet", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V", "getWallet", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "Lh/c/b0;", "getCachedWallet", "()Lh/c/b0;", "", "rawCryptoAmount", "", "isSendingEntireBalance", "updateSendAmount", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "updateMaxSendAmount", "()V", "amountString", "nextAction", "(Ljava/lang/String;)V", "clearCachedCryptoAmount", "restoreCachedCryptoAmount", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "maxSendAmountSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "isNextButtonVisibleSubject", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "navigateSubject", "Z", "Lh/c/s;", "Lcom/coinbase/wallet/features/send/models/SendBalances;", "balancesObservable", "Lh/c/s;", "getBalancesObservable", "()Lh/c/s;", "maxSendAmountObservable", "getMaxSendAmountObservable", "isBalanceSufficientSubject", "value", "isFiatSelected", "()Z", "setFiatSelected", "(Z)V", "isNextButtonVisibleObservable", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "getHasFiatRepresentation", "hasFiatRepresentation", "Lh/c/v0/a;", "selectedWalletSubject", "Lh/c/v0/a;", "isBalanceSufficientObservable", "restoredAmountSubject", "navigateObservable", "getNavigateObservable", "restoredAmountObservable", "getRestoredAmountObservable", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendViewModel extends androidx.lifecycle.b0 {
    private final h.c.s<SendBalances> balancesObservable;
    private final CurrencyFormatter currencyFormatter;
    private final h.c.s<Boolean> isBalanceSufficientObservable;
    private final h.c.v0.b<Boolean> isBalanceSufficientSubject;
    private final h.c.s<Boolean> isNextButtonVisibleObservable;
    private final h.c.v0.b<Boolean> isNextButtonVisibleSubject;
    private boolean isSendingEntireBalance;
    private final h.c.s<String> maxSendAmountObservable;
    private final h.c.v0.b<String> maxSendAmountSubject;
    private final h.c.s<TransferValue> navigateObservable;
    private final h.c.v0.b<TransferValue> navigateSubject;
    private final h.c.s<String> restoredAmountObservable;
    private final h.c.v0.b<String> restoredAmountSubject;
    private final h.c.v0.a<Wallet> selectedWalletSubject;
    private final StoreInterface store;
    private Wallet wallet;
    private final IWalletRepository walletRepository;

    public SendViewModel(IWalletRepository walletRepository, CurrencyFormatter currencyFormatter, StoreInterface store) {
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(store, "store");
        this.walletRepository = walletRepository;
        this.currencyFormatter = currencyFormatter;
        this.store = store;
        h.c.v0.a<Wallet> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.selectedWalletSubject = d2;
        h.c.v0.b<String> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<String>()");
        this.maxSendAmountSubject = d3;
        h.c.v0.b<Boolean> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<Boolean>()");
        this.isBalanceSufficientSubject = d4;
        h.c.v0.b<Boolean> d5 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d5, "create<Boolean>()");
        this.isNextButtonVisibleSubject = d5;
        h.c.v0.b<TransferValue> d6 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d6, "create<TransferValue>()");
        this.navigateSubject = d6;
        h.c.v0.b<String> d7 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d7, "create<String>()");
        this.restoredAmountSubject = d7;
        h.c.s map = d2.hide().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.a0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SendViewModel.a(SendViewModel.this, (Wallet) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "selectedWalletSubject\n        .hide()\n        .map { wallet ->\n            val cryptoBalance = currencyFormatter.formatToCrypto(\n                currencyCode = wallet.currencyCode,\n                decimals = wallet.decimals,\n                value = wallet.balance,\n                includeCode = true\n            )\n\n            val fiatBalance = currencyFormatter.formatToFiat(\n                wallet.currencyCode,\n                wallet.contractAddress,\n                wallet.decimals,\n                wallet.balance\n            )\n\n            SendBalances(fiatBalance = fiatBalance, cryptoBalance = cryptoBalance)\n        }");
        this.balancesObservable = map;
        h.c.s<String> hide = d3.hide();
        kotlin.jvm.internal.m.f(hide, "maxSendAmountSubject.hide()");
        this.maxSendAmountObservable = hide;
        h.c.s<Boolean> hide2 = d4.hide();
        kotlin.jvm.internal.m.f(hide2, "isBalanceSufficientSubject.hide()");
        this.isBalanceSufficientObservable = hide2;
        h.c.s<Boolean> hide3 = d5.hide();
        kotlin.jvm.internal.m.f(hide3, "isNextButtonVisibleSubject.hide()");
        this.isNextButtonVisibleObservable = hide3;
        h.c.s<TransferValue> hide4 = d6.hide();
        kotlin.jvm.internal.m.f(hide4, "navigateSubject.hide()");
        this.navigateObservable = hide4;
        h.c.s<String> hide5 = d7.hide();
        kotlin.jvm.internal.m.f(hide5, "restoredAmountSubject.hide()");
        this.restoredAmountObservable = hide5;
    }

    public static /* synthetic */ SendBalances a(SendViewModel sendViewModel, Wallet wallet) {
        return m1380balancesObservable$lambda0(sendViewModel, wallet);
    }

    public static /* synthetic */ h0 b(SendViewModel sendViewModel, Optional optional) {
        return m1381getCachedWallet$lambda3(sendViewModel, optional);
    }

    /* renamed from: balancesObservable$lambda-0 */
    public static final SendBalances m1380balancesObservable$lambda0(SendViewModel this$0, Wallet wallet) {
        String formatToFiat;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        String formatToCrypto$default = CurrencyFormatter.formatToCrypto$default(this$0.currencyFormatter, wallet.getCurrencyCode(), wallet.getDecimals(), wallet.getBalance(), true, 0, 0, 48, (Object) null);
        formatToFiat = this$0.currencyFormatter.formatToFiat(wallet.getCurrencyCode(), wallet.getContractAddress(), wallet.getDecimals(), wallet.getBalance(), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
        return new SendBalances(formatToFiat, formatToCrypto$default);
    }

    public static /* synthetic */ Wallet c(List list) {
        return m1382getCachedWallet$lambda3$lambda2(list);
    }

    /* renamed from: getCachedWallet$lambda-3 */
    public static final h0 m1381getCachedWallet$lambda3(SendViewModel this$0, Optional it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        Wallet wallet = (Wallet) it.getValue();
        if (wallet != null && BigInteger_ApplicationKt.isMoreThanZero(wallet.getBalance())) {
            return h.c.b0.just(wallet);
        }
        return Observable_CoreKt.takeSingle(this$0.walletRepository.observeWallets(true)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.c0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SendViewModel.c((List) obj);
            }
        });
    }

    /* renamed from: getCachedWallet$lambda-3$lambda-2 */
    public static final Wallet m1382getCachedWallet$lambda3$lambda2(List wallets) {
        kotlin.jvm.internal.m.g(wallets, "wallets");
        Iterator it = wallets.iterator();
        while (it.hasNext()) {
            Wallet wallet = (Wallet) it.next();
            if (BigInteger_ApplicationKt.isMoreThanZero(wallet.getBalance())) {
                return wallet;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static /* synthetic */ void updateSendAmount$default(SendViewModel sendViewModel, String str, Boolean bool, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bool = null;
        }
        sendViewModel.updateSendAmount(str, bool);
    }

    public final void clearCachedCryptoAmount() {
        this.store.set(StoreKeys_SendKt.getCachedCryptoAmount(StoreKeys.INSTANCE), null);
    }

    public final h.c.s<SendBalances> getBalancesObservable() {
        return this.balancesObservable;
    }

    public final h.c.b0<Wallet> getCachedWallet() {
        StoreInterface storeInterface = this.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        CurrencyCode currencyCode = (CurrencyCode) storeInterface.get(StoreKeys_SendKt.getCurrencyCodeForSend(storeKeys));
        if (currencyCode == null) {
            currencyCode = CurrencyCode_BitcoinKt.getBTC(CurrencyCode.Companion);
        }
        Blockchain blockchain = (Blockchain) this.store.get(StoreKeys_SendKt.getBlockchainForSend(storeKeys));
        if (blockchain == null) {
            blockchain = Blockchain_BitcoinKt.getBITCOIN(Blockchain.Companion);
        }
        h.c.s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(this.walletRepository, blockchain, currencyCode);
        kotlin.jvm.internal.m.f(observeWallet, "walletRepository.observeWallet(blockchain = blockchain, currencyCode = currencyCode)");
        h.c.b0<Wallet> flatMap = Observable_CoreKt.takeSingle(observeWallet).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.b0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SendViewModel.b(SendViewModel.this, (Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "walletRepository.observeWallet(blockchain = blockchain, currencyCode = currencyCode)\n            .takeSingle()\n            .flatMap {\n                val wallet = it.value\n                if (wallet == null || !wallet.balance.isMoreThanZero()) {\n                    walletRepository.observeWallets(true)\n                        .takeSingle()\n                        .map { wallets -> wallets.first { wallet -> wallet.balance.isMoreThanZero() } }\n                } else {\n                    Single.just(wallet)\n                }\n            }");
        return flatMap;
    }

    public final boolean getHasFiatRepresentation() {
        CurrencyFormatter currencyFormatter = this.currencyFormatter;
        Wallet wallet = this.wallet;
        if (wallet != null) {
            CurrencyCode currencyCode = wallet.getCurrencyCode();
            Wallet wallet2 = this.wallet;
            if (wallet2 != null) {
                String contractAddress = wallet2.getContractAddress();
                Wallet wallet3 = this.wallet;
                if (wallet3 != null) {
                    EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(wallet3.getNetwork());
                    return currencyFormatter.hasFiatRepresentation(currencyCode, contractAddress, asEthereumChain != null ? Integer.valueOf(asEthereumChain.getChainId()) : null);
                }
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    public final h.c.s<String> getMaxSendAmountObservable() {
        return this.maxSendAmountObservable;
    }

    public final h.c.s<TransferValue> getNavigateObservable() {
        return this.navigateObservable;
    }

    public final h.c.s<String> getRestoredAmountObservable() {
        return this.restoredAmountObservable;
    }

    public final Wallet getWallet() {
        Wallet wallet = this.wallet;
        if (wallet != null) {
            return wallet;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    public final h.c.s<Boolean> isBalanceSufficientObservable() {
        return this.isBalanceSufficientObservable;
    }

    public final boolean isFiatSelected() {
        Boolean bool = (Boolean) this.store.get(StoreKeys_SendKt.isFiatSelectedForSend(StoreKeys.INSTANCE));
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final h.c.s<Boolean> isNextButtonVisibleObservable() {
        return this.isNextButtonVisibleObservable;
    }

    public final void nextAction(String amountString) {
        TransferValue amount;
        kotlin.jvm.internal.m.g(amountString, "amountString");
        if (this.isSendingEntireBalance) {
            amount = TransferValue.EntireBalance.INSTANCE;
        } else {
            BigDecimal bigDecimal = new BigDecimal(amountString);
            BigDecimal bigDecimal2 = BigDecimal.TEN;
            Wallet wallet = this.wallet;
            if (wallet != null) {
                BigInteger bigInteger = bigDecimal.multiply(bigDecimal2.pow(wallet.getDecimals())).toBigInteger();
                kotlin.jvm.internal.m.f(bigInteger, "BigDecimal(amountString).multiply(BigDecimal.TEN.pow(wallet.decimals)).toBigInteger()");
                amount = new TransferValue.Amount(bigInteger);
            } else {
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
        }
        this.navigateSubject.onNext(amount);
    }

    public final void restoreCachedCryptoAmount() {
        String str = (String) this.store.get(StoreKeys_SendKt.getCachedCryptoAmount(StoreKeys.INSTANCE));
        if (str != null) {
            this.restoredAmountSubject.onNext(str);
        }
    }

    public final void setFiatSelected(boolean z) {
        this.store.set(StoreKeys_SendKt.isFiatSelectedForSend(StoreKeys.INSTANCE), Boolean.valueOf(z));
    }

    public final void setWallet(Wallet wallet) {
        kotlin.jvm.internal.m.g(wallet, "wallet");
        this.wallet = wallet;
        this.selectedWalletSubject.onNext(wallet);
        StoreInterface storeInterface = this.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        storeInterface.set(StoreKeys_SendKt.getCurrencyCodeForSend(storeKeys), wallet.getCurrencyCode());
        this.store.set(StoreKeys_SendKt.getBlockchainForSend(storeKeys), wallet.getBlockchain());
    }

    public final void updateMaxSendAmount() {
        this.isSendingEntireBalance = true;
        Wallet wallet = this.wallet;
        if (wallet == null) {
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        }
        BigInteger maximumAvailableBalance = Wallet_ApplicationKt.maximumAvailableBalance(wallet);
        Wallet wallet2 = this.wallet;
        if (wallet2 != null) {
            String rawCryptoAmount = BigInteger_ApplicationKt.asBigDecimal(maximumAvailableBalance, wallet2.getDecimals()).toPlainString();
            this.maxSendAmountSubject.onNext(rawCryptoAmount);
            kotlin.jvm.internal.m.f(rawCryptoAmount, "rawCryptoAmount");
            updateSendAmount(rawCryptoAmount, Boolean.TRUE);
            return;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    public final void updateSendAmount(String rawCryptoAmount, Boolean bool) {
        kotlin.jvm.internal.m.g(rawCryptoAmount, "rawCryptoAmount");
        boolean z = true;
        if (rawCryptoAmount.length() == 0) {
            rawCryptoAmount = Strings.zero;
        }
        this.isSendingEntireBalance = bool == null ? this.isSendingEntireBalance : bool.booleanValue();
        BigDecimal bigDecimal = new BigDecimal(rawCryptoAmount);
        Wallet wallet = this.wallet;
        if (wallet != null) {
            BigInteger asBigInteger = BigDecimal_CommonKt.asBigInteger(bigDecimal, wallet.getDecimals());
            boolean c2 = kotlin.jvm.internal.m.c(asBigInteger, BigInteger.ZERO);
            Wallet wallet2 = this.wallet;
            if (wallet2 != null) {
                boolean z2 = Wallet_ApplicationKt.maximumAvailableBalance(wallet2).compareTo(asBigInteger) >= 0;
                this.isBalanceSufficientSubject.onNext(Boolean.valueOf(z2 || c2));
                h.c.v0.b<Boolean> bVar = this.isNextButtonVisibleSubject;
                if (!z2 || c2) {
                    z = false;
                }
                bVar.onNext(Boolean.valueOf(z));
                return;
            }
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }
}