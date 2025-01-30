package com.coinbase.wallet.features.send.viewmodels;

import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.application.extensions.BigInteger_ApplicationKt;
import com.coinbase.wallet.bitcoin.extensions.Blockchain_BitcoinKt;
import com.coinbase.wallet.bitcoin.extensions.CurrencyCode_BitcoinKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.BigDecimal_CommonKt;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.features.send.extensions.StoreKeys_SendKt;
import com.coinbase.wallet.features.send.models.AmountPickerSettings;
import com.coinbase.wallet.features.send.models.AmountPickerTitle;
import com.coinbase.wallet.features.send.models.SendBalances;
import com.coinbase.wallet.features.wallets.extensions.Wallet_ApplicationKt;
import com.coinbase.wallet.routing.models.SendArgs;
import com.coinbase.wallet.routing.models.SendDestinationPickerArgs;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import h.c.h0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: SendAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010N\u001a\u00020M\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b`\u0010aJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\bJ\u001f\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u001b\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\u0002H\u0016¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010\bJ\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010\bR\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110+8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R$\u00102\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u000f0\u000f008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R$\u00105\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010404008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00103R$\u00107\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000f0+8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b;\u0010-\u001a\u0004\b<\u0010/R\"\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000f0+8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b=\u0010-\u001a\u0004\b>\u0010/R$\u0010?\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u00110\u0011008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00103R\"\u0010\n\u001a\u00020\u00038\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\n\u0010@\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\fR\u0016\u0010F\u001a\u00020C8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR$\u0010J\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u000f0\u000f008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u00103R$\u0010K\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u00110\u0011008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u00103R$\u0010L\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u000f0\u000f008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u00103R\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\u00118V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u00108R\u0016\u0010R\u001a\u00020\u00118V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u00108R\"\u0010T\u001a\b\u0012\u0004\u0012\u00020S0+8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bT\u0010-\u001a\u0004\bU\u0010/R\"\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00110+8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bV\u0010-\u001a\u0004\bV\u0010/R\"\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00110+8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bW\u0010-\u001a\u0004\bW\u0010/R\"\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000f0+8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bX\u0010-\u001a\u0004\bY\u0010/R\"\u0010Z\u001a\b\u0012\u0004\u0012\u0002040+8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bZ\u0010-\u001a\u0004\b[\u0010/R\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00030\\8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010_¨\u0006b"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/SendAmountPickerViewModel;", "Lcom/coinbase/wallet/features/send/viewmodels/AmountPickerViewModel;", "Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "getCachedWallet", "()Lh/c/b0;", "Lkotlin/x;", "clearPendingRecipient", "()V", "loadWallet", "wallet", "setWallet", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V", "getWallet", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "", "rawCryptoAmount", "", "isSendingEntireBalance", "updateSendAmount", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "", "percentage", "formatCryptoAmount", "(F)Ljava/lang/String;", "cryptoAmount", "getCryptoPercentage", "(Ljava/lang/String;)F", "onSliderToggled", "updateMaxSendAmount", "amountString", "Landroid/os/Bundle;", "arguments", "nextAction", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/features/send/models/AmountPickerTitle;", "generateTitle", "clearCachedCryptoAmount", "restoreCachedCryptoAmount", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lh/c/s;", "sliderStateObservable", "Lh/c/s;", "getSliderStateObservable", "()Lh/c/s;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "restoredAmountSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigateSubject", "value", "isFiatSelected", "()Z", "setFiatSelected", "(Z)V", "maxSendAmountObservable", "getMaxSendAmountObservable", "interestInfoObservable", "getInterestInfoObservable", "isBalanceSufficientSubject", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "getWallet$app_productionRelease", "setWallet$app_productionRelease", "Lcom/coinbase/wallet/features/send/models/AmountPickerSettings;", "getSettings", "()Lcom/coinbase/wallet/features/send/models/AmountPickerSettings;", "settings", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "maxSendAmountSubject", "isNextButtonHiddenSubject", "interestInfoSubject", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "isInterestDescriptionVisible", "getHasFiatRepresentation", "hasFiatRepresentation", "Lcom/coinbase/wallet/features/send/models/SendBalances;", "balancesObservable", "getBalancesObservable", "isNextButtonHiddenObservable", "isBalanceSufficientObservable", "restoredAmountObservable", "getRestoredAmountObservable", "navigateObservable", "getNavigateObservable", "Lh/c/v0/a;", "selectedWalletSubject", "Lh/c/v0/a;", "Z", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendAmountPickerViewModel extends AmountPickerViewModel {
    private final h.c.s<SendBalances> balancesObservable;
    private final CurrencyFormatter currencyFormatter;
    private final h.c.s<String> interestInfoObservable;
    private final h.c.v0.b<String> interestInfoSubject;
    private final h.c.s<Boolean> isBalanceSufficientObservable;
    private final h.c.v0.b<Boolean> isBalanceSufficientSubject;
    private final h.c.s<Boolean> isNextButtonHiddenObservable;
    private final h.c.v0.b<Boolean> isNextButtonHiddenSubject;
    private boolean isSendingEntireBalance;
    private final h.c.s<String> maxSendAmountObservable;
    private final h.c.v0.b<String> maxSendAmountSubject;
    private final h.c.s<ViewModelNavRoute> navigateObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigateSubject;
    private final h.c.s<String> restoredAmountObservable;
    private final h.c.v0.b<String> restoredAmountSubject;
    private final h.c.v0.a<Wallet> selectedWalletSubject;
    private final h.c.s<Boolean> sliderStateObservable;
    private final StoreInterface store;
    public Wallet wallet;
    private final IWalletRepository walletRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendAmountPickerViewModel(IWalletRepository walletRepository, CurrencyFormatter currencyFormatter, StoreInterface store) {
        super(store);
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
        this.isNextButtonHiddenSubject = d5;
        h.c.v0.b<String> d6 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d6, "create<String>()");
        this.interestInfoSubject = d6;
        h.c.v0.b<ViewModelNavRoute> d7 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d7, "create<ViewModelNavRoute>()");
        this.navigateSubject = d7;
        h.c.v0.b<String> d8 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d8, "create<String>()");
        this.restoredAmountSubject = d8;
        h.c.s map = d2.hide().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SendAmountPickerViewModel.a(SendAmountPickerViewModel.this, (Wallet) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "selectedWalletSubject\n        .hide()\n        .map { wallet ->\n            val cryptoBalance = currencyFormatter.formatToCrypto(\n                currencyCode = wallet.currencyCode,\n                decimals = wallet.decimals,\n                value = wallet.balance,\n                includeCode = true\n            )\n\n            val fiatBalance = currencyFormatter.formatToFiat(\n                wallet.currencyCode,\n                wallet.contractAddress,\n                wallet.decimals,\n                wallet.balance\n            )\n\n            SendBalances(fiatBalance = fiatBalance, cryptoBalance = cryptoBalance)\n        }");
        this.balancesObservable = map;
        h.c.s<String> hide = d6.hide();
        kotlin.jvm.internal.m.f(hide, "interestInfoSubject.hide()");
        this.interestInfoObservable = hide;
        h.c.s<String> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "maxSendAmountSubject.hide()");
        this.maxSendAmountObservable = hide2;
        h.c.s<Boolean> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "isBalanceSufficientSubject.hide()");
        this.isBalanceSufficientObservable = hide3;
        h.c.s<Boolean> hide4 = d5.hide();
        kotlin.jvm.internal.m.f(hide4, "isNextButtonHiddenSubject.hide()");
        this.isNextButtonHiddenObservable = hide4;
        h.c.s<ViewModelNavRoute> hide5 = d7.hide();
        kotlin.jvm.internal.m.f(hide5, "navigateSubject.hide()");
        this.navigateObservable = hide5;
        h.c.s<String> hide6 = d8.hide();
        kotlin.jvm.internal.m.f(hide6, "restoredAmountSubject.hide()");
        this.restoredAmountObservable = hide6;
        h.c.s<Boolean> just = h.c.s.just(Boolean.FALSE);
        kotlin.jvm.internal.m.f(just, "just(false)");
        this.sliderStateObservable = just;
    }

    public static /* synthetic */ SendBalances a(SendAmountPickerViewModel sendAmountPickerViewModel, Wallet wallet) {
        return m1363balancesObservable$lambda0(sendAmountPickerViewModel, wallet);
    }

    public static /* synthetic */ Wallet b(Optional optional, List list) {
        return m1365getCachedWallet$lambda3$lambda2(optional, list);
    }

    /* renamed from: balancesObservable$lambda-0 */
    public static final SendBalances m1363balancesObservable$lambda0(SendAmountPickerViewModel this$0, Wallet wallet) {
        String formatToFiat;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        String formatToCrypto$default = CurrencyFormatter.formatToCrypto$default(this$0.currencyFormatter, wallet.getCurrencyCode(), wallet.getDecimals(), wallet.getBalance(), true, 0, 0, 48, (Object) null);
        formatToFiat = this$0.currencyFormatter.formatToFiat(wallet.getCurrencyCode(), wallet.getContractAddress(), wallet.getDecimals(), wallet.getBalance(), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
        return new SendBalances(formatToFiat, formatToCrypto$default);
    }

    public static /* synthetic */ h0 c(SendAmountPickerViewModel sendAmountPickerViewModel, kotlin.o oVar) {
        return m1364getCachedWallet$lambda3(sendAmountPickerViewModel, oVar);
    }

    private final void clearPendingRecipient() {
        getArgs().remove("recipient");
        getArgs().remove(SendArgs.METADATA_VALUE);
        getArgs().remove(SendArgs.STELLAR_MEMO_TYPE);
    }

    public static /* synthetic */ Wallet d(SendAmountPickerViewModel sendAmountPickerViewModel, Wallet wallet) {
        return m1366loadWallet$lambda1(sendAmountPickerViewModel, wallet);
    }

    private final h.c.b0<Wallet> getCachedWallet() {
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
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(this.walletRepository, blockchain, currencyCode);
        kotlin.jvm.internal.m.f(observeWallet, "walletRepository.observeWallet(blockchain = blockchain, currencyCode = currencyCode)");
        h.c.b0 takeSingle = Observable_CoreKt.takeSingle(observeWallet);
        h.c.s<Optional<Wallet>> observeWallet2 = WalletRepository_CommonKt.observeWallet(this.walletRepository, Blockchain_BitcoinKt.getBITCOIN(Blockchain.Companion), CurrencyCode_BitcoinKt.getBTC(CurrencyCode.Companion));
        kotlin.jvm.internal.m.f(observeWallet2, "walletRepository\n                    .observeWallet(blockchain = Blockchain.BITCOIN, currencyCode = CurrencyCode.BTC)");
        h.c.b0<Wallet> flatMap = eVar.a(takeSingle, Observable_CoreKt.takeSingle(observeWallet2)).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SendAmountPickerViewModel.c(SendAmountPickerViewModel.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "Singles\n            .zip(\n                walletRepository.observeWallet(blockchain = blockchain, currencyCode = currencyCode).takeSingle(),\n                walletRepository\n                    .observeWallet(blockchain = Blockchain.BITCOIN, currencyCode = CurrencyCode.BTC).takeSingle()\n            )\n            .flatMap { (selectedWallet, defaultWallet) ->\n                val wallet = selectedWallet.value\n                if (wallet == null || !wallet.balance.isMoreThanZero()) {\n                    walletRepository.observeWallets(true)\n                        .takeSingle()\n                        .map { wallets -> wallets.firstOrNull() ?: defaultWallet.value }\n                } else {\n                    Single.just(wallet)\n                }\n            }");
        return flatMap;
    }

    /* renamed from: getCachedWallet$lambda-3 */
    public static final h0 m1364getCachedWallet$lambda3(SendAmountPickerViewModel this$0, kotlin.o dstr$selectedWallet$defaultWallet) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$selectedWallet$defaultWallet, "$dstr$selectedWallet$defaultWallet");
        final Optional optional = (Optional) dstr$selectedWallet$defaultWallet.b();
        Wallet wallet = (Wallet) ((Optional) dstr$selectedWallet$defaultWallet.a()).getValue();
        if (wallet != null && BigInteger_ApplicationKt.isMoreThanZero(wallet.getBalance())) {
            h.c.b0 just = h.c.b0.just(wallet);
            kotlin.jvm.internal.m.f(just, "{\n                    Single.just(wallet)\n                }");
            return just;
        }
        h.c.b0 map = Observable_CoreKt.takeSingle(this$0.walletRepository.observeWallets(true)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SendAmountPickerViewModel.b(Optional.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "{\n                    walletRepository.observeWallets(true)\n                        .takeSingle()\n                        .map { wallets -> wallets.firstOrNull() ?: defaultWallet.value }\n                }");
        return map;
    }

    /* renamed from: getCachedWallet$lambda-3$lambda-2 */
    public static final Wallet m1365getCachedWallet$lambda3$lambda2(Optional optional, List wallets) {
        kotlin.jvm.internal.m.g(wallets, "wallets");
        Wallet wallet = (Wallet) kotlin.a0.p.a0(wallets);
        return wallet == null ? (Wallet) optional.getValue() : wallet;
    }

    /* renamed from: loadWallet$lambda-1 */
    public static final Wallet m1366loadWallet$lambda1(SendAmountPickerViewModel this$0, Wallet it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.setWallet(it);
        return it;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void clearCachedCryptoAmount() {
        this.store.set(StoreKeys_SendKt.getCachedCryptoAmount(StoreKeys.INSTANCE), null);
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public String formatCryptoAmount(float f2) {
        return null;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public h.c.b0<Optional<AmountPickerTitle>> generateTitle() {
        h.c.b0<Optional<AmountPickerTitle>> just = h.c.b0.just(new Optional(null));
        kotlin.jvm.internal.m.f(just, "just(Optional(null))");
        return just;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public h.c.s<SendBalances> getBalancesObservable() {
        return this.balancesObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public float getCryptoPercentage(String cryptoAmount) {
        kotlin.jvm.internal.m.g(cryptoAmount, "cryptoAmount");
        return 0.0f;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public boolean getHasFiatRepresentation() {
        CurrencyFormatter currencyFormatter = this.currencyFormatter;
        CurrencyCode currencyCode = getWallet$app_productionRelease().getCurrencyCode();
        String contractAddress = getWallet$app_productionRelease().getContractAddress();
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(getWallet$app_productionRelease().getNetwork());
        return currencyFormatter.hasFiatRepresentation(currencyCode, contractAddress, asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()));
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public h.c.s<String> getInterestInfoObservable() {
        return this.interestInfoObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public h.c.s<String> getMaxSendAmountObservable() {
        return this.maxSendAmountObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public h.c.s<ViewModelNavRoute> getNavigateObservable() {
        return this.navigateObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public h.c.s<String> getRestoredAmountObservable() {
        return this.restoredAmountObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public AmountPickerSettings getSettings() {
        return new AmountPickerSettings(true, false, false, R.color.white, R.color.grey_50, R.color.white, R.color.white, R.color.primary_blue, R.color.hover_blue, R.color.white, LocalizedStrings.INSTANCE.get(R.string.next), R.drawable.ic_close_black_24dp);
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public h.c.s<Boolean> getSliderStateObservable() {
        return this.sliderStateObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public Wallet getWallet() {
        return getWallet$app_productionRelease();
    }

    public final Wallet getWallet$app_productionRelease() {
        Wallet wallet = this.wallet;
        if (wallet != null) {
            return wallet;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public h.c.s<Boolean> isBalanceSufficientObservable() {
        return this.isBalanceSufficientObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public boolean isFiatSelected() {
        Boolean bool = (Boolean) this.store.get(StoreKeys_SendKt.isFiatSelectedForSend(StoreKeys.INSTANCE));
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public boolean isInterestDescriptionVisible() {
        return false;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public h.c.s<Boolean> isNextButtonHiddenObservable() {
        return this.isNextButtonHiddenObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public h.c.b0<Wallet> loadWallet() {
        Wallet wallet = (Wallet) getArgs().getParcelable("wallet");
        if (wallet != null) {
            setWallet(wallet);
            h.c.b0<Wallet> just = h.c.b0.just(wallet);
            kotlin.jvm.internal.m.f(just, "{\n            setWallet(wallet)\n            Single.just(wallet)\n        }");
            return just;
        }
        h.c.b0 map = getCachedWallet().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.viewmodels.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SendAmountPickerViewModel.d(SendAmountPickerViewModel.this, (Wallet) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "{\n            getCachedWallet()\n                .map {\n                    setWallet(it)\n                    it\n                }\n        }");
        return map;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void nextAction(String amountString, Bundle arguments) {
        TransferValue amount;
        kotlin.jvm.internal.m.g(amountString, "amountString");
        kotlin.jvm.internal.m.g(arguments, "arguments");
        if (this.isSendingEntireBalance) {
            amount = TransferValue.EntireBalance.INSTANCE;
        } else {
            amount = new TransferValue.Amount(BigDecimal_CommonKt.asBigInteger(new BigDecimal(amountString), getWallet$app_productionRelease().getDecimals()));
        }
        ViewModelNavRoute viewModelNavRoute = new ViewModelNavRoute(R.id.action_sendAmountPickerFragment_to_sendDestinationPickerFragment, SendDestinationPickerArgs.INSTANCE.createArguments(amount, getWallet$app_productionRelease(), getArgs().getString("recipient"), getArgs().getString(SendArgs.METADATA_VALUE), (TxMetadataKey) getArgs().getParcelable(SendArgs.STELLAR_MEMO_TYPE)), null, 4, null);
        clearPendingRecipient();
        this.navigateSubject.onNext(viewModelNavRoute);
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void onSliderToggled() {
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void restoreCachedCryptoAmount() {
        String str = (String) this.store.get(StoreKeys_SendKt.getCachedCryptoAmount(StoreKeys.INSTANCE));
        if (str != null) {
            this.restoredAmountSubject.onNext(str);
        }
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void setFiatSelected(boolean z) {
        this.store.set(StoreKeys_SendKt.isFiatSelectedForSend(StoreKeys.INSTANCE), Boolean.valueOf(z));
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void setWallet(Wallet wallet) {
        kotlin.jvm.internal.m.g(wallet, "wallet");
        if (this.wallet != null && !kotlin.jvm.internal.m.c(getWallet$app_productionRelease().getCurrencyCode(), wallet.getCurrencyCode()) && !kotlin.jvm.internal.m.c(getWallet$app_productionRelease().getBlockchain(), wallet.getBlockchain())) {
            clearPendingRecipient();
        }
        setWallet$app_productionRelease(wallet);
        getArgs().putParcelable("wallet", wallet);
        this.selectedWalletSubject.onNext(wallet);
        StoreInterface storeInterface = this.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        storeInterface.set(StoreKeys_SendKt.getCurrencyCodeForSend(storeKeys), wallet.getCurrencyCode());
        this.store.set(StoreKeys_SendKt.getBlockchainForSend(storeKeys), wallet.getBlockchain());
    }

    public final void setWallet$app_productionRelease(Wallet wallet) {
        kotlin.jvm.internal.m.g(wallet, "<set-?>");
        this.wallet = wallet;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void updateMaxSendAmount() {
        String rawCryptoAmount = BigInteger_ApplicationKt.asBigDecimal(Wallet_ApplicationKt.maximumAvailableBalance(getWallet$app_productionRelease()), getWallet$app_productionRelease().getDecimals()).toPlainString();
        this.maxSendAmountSubject.onNext(rawCryptoAmount);
        kotlin.jvm.internal.m.f(rawCryptoAmount, "rawCryptoAmount");
        updateSendAmount(rawCryptoAmount, Boolean.TRUE);
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void updateSendAmount(String rawCryptoAmount, Boolean bool) {
        kotlin.jvm.internal.m.g(rawCryptoAmount, "rawCryptoAmount");
        super.updateSendAmount(rawCryptoAmount, bool);
        boolean z = true;
        if (rawCryptoAmount.length() == 0) {
            rawCryptoAmount = Strings.zero;
        }
        this.isSendingEntireBalance = bool == null ? this.isSendingEntireBalance : bool.booleanValue();
        BigInteger asBigInteger = BigDecimal_CommonKt.asBigInteger(new BigDecimal(rawCryptoAmount), getWallet$app_productionRelease().getDecimals());
        boolean c2 = kotlin.jvm.internal.m.c(asBigInteger, BigInteger.ZERO);
        boolean z2 = Wallet_ApplicationKt.maximumAvailableBalance(getWallet$app_productionRelease()).compareTo(asBigInteger) >= 0;
        this.isBalanceSufficientSubject.onNext(Boolean.valueOf(z2 || c2));
        h.c.v0.b<Boolean> bVar = this.isNextButtonHiddenSubject;
        if (z2 && !c2) {
            z = false;
        }
        bVar.onNext(Boolean.valueOf(z));
    }
}