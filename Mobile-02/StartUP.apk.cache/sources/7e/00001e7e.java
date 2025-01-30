package com.coinbase.wallet.features.lend.viewmodels;

import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.application.extensions.BigInteger_ApplicationKt;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.BigDecimal_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.extensions.Bundle_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.models.ContractAction;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.features.cloudbackup.prompts.CloudBackupPrompt;
import com.coinbase.wallet.features.lend.models.LendAmountPickerArgs;
import com.coinbase.wallet.features.lend.models.LendConfirmationArgs;
import com.coinbase.wallet.features.send.extensions.StoreKeys_SendKt;
import com.coinbase.wallet.features.send.models.AmountPickerSettings;
import com.coinbase.wallet.features.send.models.AmountPickerTitle;
import com.coinbase.wallet.features.send.models.SendBalances;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel;
import com.coinbase.wallet.features.send.viewmodels.LendConfirmationViewModel;
import com.coinbase.wallet.features.wallets.extensions.Wallet_ApplicationKt;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import e.j.i.a2;
import h.c.b0;
import h.c.s;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.l0.v;
import org.toshi.R;

/* compiled from: LendAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010h\u001a\u00020g\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010U\u001a\u00020T\u0012\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bu\u0010vJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\u000bJ\u001f\u0010%\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u001b\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0\u0012H\u0016¢\u0006\u0004\b)\u0010\u0014J\u000f\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\u000bJ\u000f\u0010+\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010\u000bR$\u0010.\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u00060\u00060,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00101\u001a\b\u0012\u0004\u0012\u00020\u0006008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R$\u00105\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u00060\u00060,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010/R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u00106R\"\u00107\u001a\b\u0012\u0004\u0012\u00020\u0006008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u00102\u001a\u0004\b8\u00104R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001d\u0010A\u001a\u00020<8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\"\u0010C\u001a\b\u0012\u0004\u0012\u00020B008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bC\u00102\u001a\u0004\bD\u00104R\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001d\u0010L\u001a\u00020H8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010>\u001a\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010P\u001a\b\u0012\u0004\u0012\u00020\u0006008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bP\u00102\u001a\u0004\bQ\u00104R$\u0010R\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u00040\u00040,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010/R$\u0010S\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u00040\u00040,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010/R\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u00106R\"\u0010[\u001a\b\u0012\u0004\u0012\u00020\u0004008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b[\u00102\u001a\u0004\b[\u00104R\"\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u0004008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\\\u00102\u001a\u0004\b]\u00104R\"\u0010^\u001a\b\u0012\u0004\u0012\u00020\u0004008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b^\u00102\u001a\u0004\b^\u00104R$\u0010_\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u00040\u00040,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010/R\u0016\u0010b\u001a\u00020\u00048B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR$\u0010c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bc\u0010a\"\u0004\bd\u0010eR\u0016\u0010f\u001a\u00020\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010aR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010jR\"\u0010k\u001a\b\u0012\u0004\u0012\u000209008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bk\u00102\u001a\u0004\bl\u00104R\u0016\u0010p\u001a\u00020m8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bq\u0010aR$\u0010s\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u000109090,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010/R$\u0010t\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u00060\u00060,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010/¨\u0006w"}, d2 = {"Lcom/coinbase/wallet/features/lend/viewmodels/LendAmountPickerViewModel;", "Lcom/coinbase/wallet/features/send/viewmodels/AmountPickerViewModel;", "Ljava/math/BigInteger;", "value", "", "abbreviated", "", "annualInterestText", "(Ljava/math/BigInteger;Z)Ljava/lang/String;", "Lkotlin/x;", "onResume", "()V", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "setWallet", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V", "getWallet", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "Lh/c/b0;", "loadWallet", "()Lh/c/b0;", "rawCryptoAmount", "isSendingEntireBalance", "updateSendAmount", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "onSliderToggled", "", "percentage", "formatCryptoAmount", "(F)Ljava/lang/String;", "cryptoAmount", "getCryptoPercentage", "(Ljava/lang/String;)F", "updateMaxSendAmount", "amountString", "Landroid/os/Bundle;", "arguments", "nextAction", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/features/send/models/AmountPickerTitle;", "generateTitle", "clearCachedCryptoAmount", "restoreCachedCryptoAmount", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "maxSendAmountSubject", "Lh/c/v0/b;", "Lh/c/s;", "interestInfoObservable", "Lh/c/s;", "getInterestInfoObservable", "()Lh/c/s;", "restoredAmountSubject", "Z", "maxSendAmountObservable", "getMaxSendAmountObservable", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "pendingNavRoute", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "Lcom/coinbase/wallet/lending/models/LendToken;", "lendToken$delegate", "Lkotlin/h;", "getLendToken", "()Lcom/coinbase/wallet/lending/models/LendToken;", LendConfirmationArgs.lendTokenKey, "Lcom/coinbase/wallet/features/send/models/SendBalances;", "balancesObservable", "getBalancesObservable", "Lh/c/v0/a;", "selectedWalletSubject", "Lh/c/v0/a;", "Lcom/coinbase/wallet/ethereum/models/ContractAction;", "contractAction$delegate", "getContractAction", "()Lcom/coinbase/wallet/ethereum/models/ContractAction;", "contractAction", "Le/j/i/a2;", "mnemonicBackupRepository", "Le/j/i/a2;", "restoredAmountObservable", "getRestoredAmountObservable", "isBalanceSufficientSubject", "sliderStateSubject", "Lcom/coinbase/wallet/features/cloudbackup/prompts/CloudBackupPrompt;", "cloudBackupPrompt", "Lcom/coinbase/wallet/features/cloudbackup/prompts/CloudBackupPrompt;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "hasLaunchedCloudBackupModal", "isNextButtonHiddenObservable", "sliderStateObservable", "getSliderStateObservable", "isBalanceSufficientObservable", "isNextButtonHiddenSubject", "getSliderVisible", "()Z", "sliderVisible", "isFiatSelected", "setFiatSelected", "(Z)V", "isInterestDescriptionVisible", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "navigateObservable", "getNavigateObservable", "Lcom/coinbase/wallet/features/send/models/AmountPickerSettings;", "getSettings", "()Lcom/coinbase/wallet/features/send/models/AmountPickerSettings;", "settings", "getHasFiatRepresentation", "hasFiatRepresentation", "navigateSubject", "interestInfoSubject", "<init>", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/features/cloudbackup/prompts/CloudBackupPrompt;Le/j/i/a2;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendAmountPickerViewModel extends AmountPickerViewModel {
    private final s<SendBalances> balancesObservable;
    private final CloudBackupPrompt cloudBackupPrompt;
    private final kotlin.h contractAction$delegate;
    private final CurrencyFormatter currencyFormatter;
    private boolean hasLaunchedCloudBackupModal;
    private final s<String> interestInfoObservable;
    private final h.c.v0.b<String> interestInfoSubject;
    private final s<Boolean> isBalanceSufficientObservable;
    private final h.c.v0.b<Boolean> isBalanceSufficientSubject;
    private final s<Boolean> isNextButtonHiddenObservable;
    private final h.c.v0.b<Boolean> isNextButtonHiddenSubject;
    private boolean isSendingEntireBalance;
    private final kotlin.h lendToken$delegate;
    private final s<String> maxSendAmountObservable;
    private final h.c.v0.b<String> maxSendAmountSubject;
    private final a2 mnemonicBackupRepository;
    private final s<ViewModelNavRoute> navigateObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigateSubject;
    private ViewModelNavRoute pendingNavRoute;
    private final s<String> restoredAmountObservable;
    private final h.c.v0.b<String> restoredAmountSubject;
    private final h.c.v0.a<Wallet> selectedWalletSubject;
    private final s<Boolean> sliderStateObservable;
    private final h.c.v0.b<Boolean> sliderStateSubject;
    private final StoreInterface store;
    private Wallet wallet;

    /* compiled from: LendAmountPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ContractAction.values().length];
            iArr[ContractAction.SUPPLY.ordinal()] = 1;
            iArr[ContractAction.WITHDRAW.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendAmountPickerViewModel(CurrencyFormatter currencyFormatter, StoreInterface store, CloudBackupPrompt cloudBackupPrompt, a2 mnemonicBackupRepository) {
        super(store);
        kotlin.h b2;
        kotlin.h b3;
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(cloudBackupPrompt, "cloudBackupPrompt");
        kotlin.jvm.internal.m.g(mnemonicBackupRepository, "mnemonicBackupRepository");
        this.currencyFormatter = currencyFormatter;
        this.store = store;
        this.cloudBackupPrompt = cloudBackupPrompt;
        this.mnemonicBackupRepository = mnemonicBackupRepository;
        h.c.v0.a<Wallet> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.selectedWalletSubject = d2;
        h.c.v0.b<String> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<String>()");
        this.maxSendAmountSubject = d3;
        h.c.v0.b<String> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<String>()");
        this.interestInfoSubject = d4;
        h.c.v0.b<Boolean> d5 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d5, "create<Boolean>()");
        this.isBalanceSufficientSubject = d5;
        h.c.v0.b<Boolean> d6 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d6, "create<Boolean>()");
        this.isNextButtonHiddenSubject = d6;
        h.c.v0.b<ViewModelNavRoute> d7 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d7, "create<ViewModelNavRoute>()");
        this.navigateSubject = d7;
        h.c.v0.b<String> d8 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d8, "create<String>()");
        this.restoredAmountSubject = d8;
        h.c.v0.b<Boolean> d9 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d9, "create<Boolean>()");
        this.sliderStateSubject = d9;
        b2 = kotlin.k.b(new LendAmountPickerViewModel$lendToken$2(this));
        this.lendToken$delegate = b2;
        b3 = kotlin.k.b(new LendAmountPickerViewModel$contractAction$2(this));
        this.contractAction$delegate = b3;
        s map = d2.hide().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.lend.viewmodels.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendAmountPickerViewModel.a(LendAmountPickerViewModel.this, (Wallet) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "selectedWalletSubject\n        .hide()\n        .map { wallet ->\n            when (contractAction) {\n                ContractAction.SUPPLY -> {\n                    val cryptoBalance = currencyFormatter.formatToCrypto(\n                        currencyCode = wallet.currencyCode,\n                        decimals = wallet.decimals,\n                        value = wallet.balance,\n                        includeCode = true\n                    )\n\n                    val fiatBalance = currencyFormatter.formatToFiat(\n                        wallet.currencyCode,\n                        wallet.contractAddress,\n                        wallet.decimals,\n                        wallet.balance\n                    )\n\n                    SendBalances(fiatBalance = fiatBalance, cryptoBalance = cryptoBalance)\n                }\n                ContractAction.WITHDRAW -> {\n                    val cryptoBalance = currencyFormatter.formatToCrypto(\n                        currencyCode = lendToken.currencyCode,\n                        decimals = lendToken.decimals,\n                        value = lendToken.supplyBalance,\n                        includeCode = true\n                    )\n\n                    val fiatBalance = currencyFormatter.formatToFiat(\n                        lendToken.currencyCode,\n                        lendToken.contractAddress?.rawValue,\n                        lendToken.decimals,\n                        lendToken.supplyBalance\n                    )\n\n                    SendBalances(fiatBalance = fiatBalance, cryptoBalance = cryptoBalance)\n                }\n            }\n        }");
        this.balancesObservable = map;
        s<String> hide = d4.hide();
        kotlin.jvm.internal.m.f(hide, "interestInfoSubject.hide()");
        this.interestInfoObservable = hide;
        s<String> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "maxSendAmountSubject.hide()");
        this.maxSendAmountObservable = hide2;
        s<Boolean> hide3 = d5.hide();
        kotlin.jvm.internal.m.f(hide3, "isBalanceSufficientSubject.hide()");
        this.isBalanceSufficientObservable = hide3;
        s<Boolean> hide4 = d6.hide();
        kotlin.jvm.internal.m.f(hide4, "isNextButtonHiddenSubject.hide()");
        this.isNextButtonHiddenObservable = hide4;
        s<ViewModelNavRoute> hide5 = d7.hide();
        kotlin.jvm.internal.m.f(hide5, "navigateSubject.hide()");
        this.navigateObservable = hide5;
        s<String> hide6 = d8.hide();
        kotlin.jvm.internal.m.f(hide6, "restoredAmountSubject.hide()");
        this.restoredAmountObservable = hide6;
        s<Boolean> hide7 = d9.hide();
        kotlin.jvm.internal.m.f(hide7, "sliderStateSubject.hide()");
        this.sliderStateObservable = hide7;
    }

    public static /* synthetic */ SendBalances a(LendAmountPickerViewModel lendAmountPickerViewModel, Wallet wallet) {
        return m1273balancesObservable$lambda0(lendAmountPickerViewModel, wallet);
    }

    private final String annualInterestText(BigInteger bigInteger, boolean z) {
        String formatToFiat;
        BigDecimal bigDecimal = BigDecimal.TEN;
        BigDecimal bigDecimal2 = new BigDecimal(bigInteger);
        Wallet wallet = this.wallet;
        if (wallet != null) {
            BigDecimal amountValue = bigDecimal2.divide(bigDecimal.pow(wallet.getDecimals()));
            BigDecimal supplyRateValue = new BigDecimal(getLendToken().getSupplyInterestRate()).divide(bigDecimal.pow(getLendToken().getRateDecimals()));
            kotlin.jvm.internal.m.f(amountValue, "amountValue");
            kotlin.jvm.internal.m.f(supplyRateValue, "supplyRateValue");
            BigDecimal multiply = amountValue.multiply(supplyRateValue);
            kotlin.jvm.internal.m.f(multiply, "this.multiply(other)");
            CurrencyFormatter currencyFormatter = this.currencyFormatter;
            Wallet wallet2 = this.wallet;
            if (wallet2 != null) {
                CurrencyCode currencyCode = wallet2.getCurrencyCode();
                Wallet wallet3 = this.wallet;
                if (wallet3 != null) {
                    String contractAddress = wallet3.getContractAddress();
                    Wallet wallet4 = this.wallet;
                    if (wallet4 != null) {
                        int decimals = wallet4.getDecimals();
                        Wallet wallet5 = this.wallet;
                        if (wallet5 != null) {
                            BigDecimal pow = bigDecimal.pow(wallet5.getDecimals());
                            kotlin.jvm.internal.m.f(pow, "ten.pow(wallet.decimals)");
                            BigDecimal multiply2 = multiply.multiply(pow);
                            kotlin.jvm.internal.m.f(multiply2, "this.multiply(other)");
                            formatToFiat = currencyFormatter.formatToFiat(currencyCode, contractAddress, decimals, BigDecimal_CommonKt.asBigInteger(multiply2, 0), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
                            if (formatToFiat == null) {
                                return Strings_CoreKt.getEllipsis(Strings.INSTANCE);
                            }
                            return LocalizedStrings.INSTANCE.get(z ? R.string.lend_send_apr_abbreviated : R.string.lend_send_apr, formatToFiat, BigDecimal_CommonKt.asRoundedPercentage(supplyRateValue, getLendToken().getRateDecimals()));
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
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    /* renamed from: balancesObservable$lambda-0 */
    public static final SendBalances m1273balancesObservable$lambda0(LendAmountPickerViewModel this$0, Wallet wallet) {
        String formatToFiat;
        String formatToFiat2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        int i2 = WhenMappings.$EnumSwitchMapping$0[this$0.getContractAction().ordinal()];
        if (i2 == 1) {
            String formatToCrypto$default = CurrencyFormatter.formatToCrypto$default(this$0.currencyFormatter, wallet.getCurrencyCode(), wallet.getDecimals(), wallet.getBalance(), true, 0, 0, 48, (Object) null);
            formatToFiat = this$0.currencyFormatter.formatToFiat(wallet.getCurrencyCode(), wallet.getContractAddress(), wallet.getDecimals(), wallet.getBalance(), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
            return new SendBalances(formatToFiat, formatToCrypto$default);
        } else if (i2 == 2) {
            String formatToCrypto$default2 = CurrencyFormatter.formatToCrypto$default(this$0.currencyFormatter, this$0.getLendToken().getCurrencyCode(), this$0.getLendToken().getDecimals(), this$0.getLendToken().getSupplyBalance(), true, 0, 0, 48, (Object) null);
            CurrencyFormatter currencyFormatter = this$0.currencyFormatter;
            CurrencyCode currencyCode = this$0.getLendToken().getCurrencyCode();
            ContractAddress contractAddress = this$0.getLendToken().getContractAddress();
            formatToFiat2 = currencyFormatter.formatToFiat(currencyCode, contractAddress == null ? null : contractAddress.getRawValue(), this$0.getLendToken().getDecimals(), this$0.getLendToken().getSupplyBalance(), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
            return new SendBalances(formatToFiat2, formatToCrypto$default2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final ContractAction getContractAction() {
        return (ContractAction) this.contractAction$delegate.getValue();
    }

    private final LendToken getLendToken() {
        return (LendToken) this.lendToken$delegate.getValue();
    }

    private final boolean getSliderVisible() {
        return getArgs().getBoolean(LendAmountPickerArgs.sliderVisibleKey, getSettings().isSliderEnabled());
    }

    private static final void updateSendAmount$validateBalance(BigInteger bigInteger, LendAmountPickerViewModel lendAmountPickerViewModel, boolean z, BigInteger bigInteger2) {
        int compareTo = bigInteger2.compareTo(bigInteger);
        boolean z2 = true;
        boolean z3 = compareTo >= 0;
        lendAmountPickerViewModel.isBalanceSufficientSubject.onNext(Boolean.valueOf(z3 || z));
        h.c.v0.b<Boolean> bVar = lendAmountPickerViewModel.isNextButtonHiddenSubject;
        if (z3 && !z) {
            z2 = false;
        }
        bVar.onNext(Boolean.valueOf(z2));
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void clearCachedCryptoAmount() {
        this.store.set(StoreKeys_SendKt.getCachedCryptoAmount(StoreKeys.INSTANCE), null);
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public String formatCryptoAmount(float f2) {
        BigDecimal scale;
        if (f2 == 0.0f) {
            return BigDecimal.ZERO.toPlainString();
        }
        BigDecimal bigDecimal = new BigDecimal(f2);
        int i2 = WhenMappings.$EnumSwitchMapping$0[getContractAction().ordinal()];
        if (i2 == 1) {
            Wallet wallet = this.wallet;
            if (wallet == null) {
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
            BigInteger maximumAvailableBalance = Wallet_ApplicationKt.maximumAvailableBalance(wallet);
            Wallet wallet2 = this.wallet;
            if (wallet2 != null) {
                scale = BigInteger_ApplicationKt.asBigDecimal(maximumAvailableBalance, wallet2.getDecimals()).multiply(bigDecimal).setScale(getLendToken().getDecimals(), RoundingMode.FLOOR);
            } else {
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
        } else if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            scale = BigInteger_ApplicationKt.asBigDecimal(getLendToken().getSupplyBalance(), getLendToken().getDecimals()).multiply(bigDecimal).setScale(getLendToken().getDecimals(), RoundingMode.FLOOR);
        }
        return scale.toPlainString();
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public b0<Optional<AmountPickerTitle>> generateTitle() {
        String formatToFiat;
        AmountPickerTitle amountPickerTitle;
        String formatToFiat2;
        int i2 = WhenMappings.$EnumSwitchMapping$0[getContractAction().ordinal()];
        if (i2 == 1) {
            CurrencyFormatter currencyFormatter = this.currencyFormatter;
            Wallet wallet = this.wallet;
            if (wallet != null) {
                CurrencyCode currencyCode = wallet.getCurrencyCode();
                Wallet wallet2 = this.wallet;
                if (wallet2 != null) {
                    String contractAddress = wallet2.getContractAddress();
                    Wallet wallet3 = this.wallet;
                    if (wallet3 != null) {
                        int decimals = wallet3.getDecimals();
                        Wallet wallet4 = this.wallet;
                        if (wallet4 != null) {
                            formatToFiat = currencyFormatter.formatToFiat(currencyCode, contractAddress, decimals, wallet4.getBalance(), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
                            if (formatToFiat == null) {
                                formatToFiat = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
                            }
                            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
                            amountPickerTitle = new AmountPickerTitle(localizedStrings.get(R.string.lend_send_choose_amount), localizedStrings.get(R.string.lend_send_available_balance, formatToFiat));
                        } else {
                            kotlin.jvm.internal.m.w("wallet");
                            throw null;
                        }
                    } else {
                        kotlin.jvm.internal.m.w("wallet");
                        throw null;
                    }
                } else {
                    kotlin.jvm.internal.m.w("wallet");
                    throw null;
                }
            } else {
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
        } else if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            CurrencyFormatter currencyFormatter2 = this.currencyFormatter;
            CurrencyCode currencyCode2 = getLendToken().getCurrencyCode();
            ContractAddress contractAddress2 = getLendToken().getContractAddress();
            formatToFiat2 = currencyFormatter2.formatToFiat(currencyCode2, contractAddress2 != null ? contractAddress2.getRawValue() : null, getLendToken().getDecimals(), getLendToken().getSupplyBalance(), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
            if (formatToFiat2 == null) {
                formatToFiat2 = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
            }
            LocalizedStrings localizedStrings2 = LocalizedStrings.INSTANCE;
            amountPickerTitle = new AmountPickerTitle(localizedStrings2.get(R.string.lend_send_withdraw_amount), localizedStrings2.get(R.string.lend_send_lending_balance, formatToFiat2));
        }
        b0<Optional<AmountPickerTitle>> just = b0.just(new Optional(amountPickerTitle));
        kotlin.jvm.internal.m.f(just, "just(Optional(title))");
        return just;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public s<SendBalances> getBalancesObservable() {
        return this.balancesObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public float getCryptoPercentage(String cryptoAmount) {
        BigDecimal j2;
        BigDecimal asBigDecimal;
        kotlin.jvm.internal.m.g(cryptoAmount, "cryptoAmount");
        j2 = v.j(cryptoAmount);
        if (j2 == null) {
            return 0.0f;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[getContractAction().ordinal()];
        if (i2 == 1) {
            Wallet wallet = this.wallet;
            if (wallet == null) {
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
            BigInteger maximumAvailableBalance = Wallet_ApplicationKt.maximumAvailableBalance(wallet);
            Wallet wallet2 = this.wallet;
            if (wallet2 == null) {
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
            asBigDecimal = BigInteger_ApplicationKt.asBigDecimal(maximumAvailableBalance, wallet2.getDecimals());
        } else if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            asBigDecimal = BigInteger_ApplicationKt.asBigDecimal(getLendToken().getSupplyBalance(), getLendToken().getDecimals());
        }
        return j2.divide(asBigDecimal, new MathContext(3)).floatValue();
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public boolean getHasFiatRepresentation() {
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

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public s<String> getInterestInfoObservable() {
        return this.interestInfoObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public s<String> getMaxSendAmountObservable() {
        return this.maxSendAmountObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public s<ViewModelNavRoute> getNavigateObservable() {
        return this.navigateObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public s<String> getRestoredAmountObservable() {
        return this.restoredAmountObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public AmountPickerSettings getSettings() {
        return new AmountPickerSettings(false, true, true, R.color.primary_black, R.color.grey_50, R.color.primary_blue, R.color.grey_80, R.color.white, R.color.white, R.color.white, LocalizedStrings.INSTANCE.get(R.string.lend_continue_button), R.drawable.ic_arrow_back);
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public s<Boolean> getSliderStateObservable() {
        return this.sliderStateObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public Wallet getWallet() {
        Wallet wallet = this.wallet;
        if (wallet != null) {
            return wallet;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public s<Boolean> isBalanceSufficientObservable() {
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
        return getContractAction() == ContractAction.SUPPLY;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public s<Boolean> isNextButtonHiddenObservable() {
        return this.isNextButtonHiddenObservable;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public b0<Wallet> loadWallet() {
        this.sliderStateSubject.onNext(Boolean.valueOf(getSliderVisible()));
        Wallet wallet = (Wallet) Bundle_CommonKt.requireParcelable(getArgs(), LendAmountPickerArgs.lendWalletKey);
        setWallet(wallet);
        b0<Wallet> just = b0.just(wallet);
        kotlin.jvm.internal.m.f(just, "just(wallet)");
        return just;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void nextAction(String amountString, Bundle arguments) {
        TransferValue amount;
        kotlin.jvm.internal.m.g(amountString, "amountString");
        kotlin.jvm.internal.m.g(arguments, "arguments");
        BigDecimal bigDecimal = new BigDecimal(amountString);
        Wallet wallet = this.wallet;
        if (wallet != null) {
            BigInteger asBigInteger = BigDecimal_CommonKt.asBigInteger(bigDecimal, wallet.getDecimals());
            if (this.isSendingEntireBalance) {
                amount = TransferValue.EntireBalance.INSTANCE;
            } else {
                amount = new TransferValue.Amount(asBigInteger);
            }
            TransferValue transferValue = amount;
            LendConfirmationArgs lendConfirmationArgs = LendConfirmationArgs.INSTANCE;
            Wallet wallet2 = this.wallet;
            if (wallet2 != null) {
                Bundle createArguments = lendConfirmationArgs.createArguments(wallet2, transferValue, getLendToken(), getContractAction(), annualInterestText(asBigInteger, true));
                createArguments.putSerializable(ConfirmationViewModel.class.getName(), LendConfirmationViewModel.class);
                ViewModelNavRoute viewModelNavRoute = new ViewModelNavRoute(R.id.action_sendAmountPickerFragment_to_confirmationFragment, createArguments, null, 4, null);
                int i2 = WhenMappings.$EnumSwitchMapping$0[getContractAction().ordinal()];
                if (i2 == 1) {
                    this.navigateSubject.onNext(viewModelNavRoute);
                    return;
                } else if (i2 != 2) {
                    return;
                } else {
                    this.pendingNavRoute = viewModelNavRoute;
                    h.c.t0.g.i(this.cloudBackupPrompt.backupIfNeeded(arguments, new LendAmountPickerViewModel$nextAction$1(this, viewModelNavRoute), new LendAmountPickerViewModel$nextAction$2(this)), null, new LendAmountPickerViewModel$nextAction$3(this, viewModelNavRoute), 1, null);
                    return;
                }
            }
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void onResume() {
        if (this.hasLaunchedCloudBackupModal && this.mnemonicBackupRepository.d()) {
            ViewModelNavRoute viewModelNavRoute = this.pendingNavRoute;
            if (viewModelNavRoute != null) {
                this.navigateSubject.onNext(viewModelNavRoute);
            }
            this.hasLaunchedCloudBackupModal = false;
        }
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void onSliderToggled() {
        boolean z = !getSliderVisible();
        getArgs().putBoolean(LendAmountPickerArgs.sliderVisibleKey, z);
        this.sliderStateSubject.onNext(Boolean.valueOf(z));
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
        this.wallet = wallet;
        this.selectedWalletSubject.onNext(wallet);
        StoreInterface storeInterface = this.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        storeInterface.set(StoreKeys_SendKt.getCurrencyCodeForSend(storeKeys), wallet.getCurrencyCode());
        this.store.set(StoreKeys_SendKt.getBlockchainForSend(storeKeys), wallet.getBlockchain());
        BigInteger ZERO = BigInteger.ZERO;
        kotlin.jvm.internal.m.f(ZERO, "ZERO");
        this.interestInfoSubject.onNext(annualInterestText(ZERO, false));
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void updateMaxSendAmount() {
        int i2 = WhenMappings.$EnumSwitchMapping$0[getContractAction().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            String rawCryptoAmount = BigInteger_ApplicationKt.asBigDecimal(getLendToken().getSupplyBalance(), getLendToken().getDecimals()).toPlainString();
            this.maxSendAmountSubject.onNext(rawCryptoAmount);
            kotlin.jvm.internal.m.f(rawCryptoAmount, "rawCryptoAmount");
            updateSendAmount(rawCryptoAmount, Boolean.TRUE);
            return;
        }
        Wallet wallet = this.wallet;
        if (wallet == null) {
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        }
        BigInteger maximumAvailableBalance = Wallet_ApplicationKt.maximumAvailableBalance(wallet);
        Wallet wallet2 = this.wallet;
        if (wallet2 != null) {
            String rawCryptoAmount2 = BigInteger_ApplicationKt.asBigDecimal(maximumAvailableBalance, wallet2.getDecimals()).toPlainString();
            this.maxSendAmountSubject.onNext(rawCryptoAmount2);
            kotlin.jvm.internal.m.f(rawCryptoAmount2, "rawCryptoAmount");
            updateSendAmount(rawCryptoAmount2, Boolean.TRUE);
            return;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel
    public void updateSendAmount(String rawCryptoAmount, Boolean bool) {
        kotlin.jvm.internal.m.g(rawCryptoAmount, "rawCryptoAmount");
        super.updateSendAmount(rawCryptoAmount, bool);
        if (bool != null) {
            this.isSendingEntireBalance = bool.booleanValue();
        }
        if (rawCryptoAmount.length() == 0) {
            rawCryptoAmount = Strings.zero;
        }
        BigDecimal bigDecimal = new BigDecimal(rawCryptoAmount);
        Wallet wallet = this.wallet;
        if (wallet != null) {
            BigInteger asBigInteger = BigDecimal_CommonKt.asBigInteger(bigDecimal, wallet.getDecimals());
            boolean c2 = kotlin.jvm.internal.m.c(asBigInteger, BigInteger.ZERO);
            int i2 = WhenMappings.$EnumSwitchMapping$0[getContractAction().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                updateSendAmount$validateBalance(asBigInteger, this, c2, getLendToken().getSupplyBalance());
                return;
            }
            if (BigInteger_ApplicationKt.isMoreThanZero(asBigInteger)) {
                this.interestInfoSubject.onNext(annualInterestText(asBigInteger, false));
            } else {
                this.interestInfoSubject.onNext(Strings_CoreKt.getEmpty(Strings.INSTANCE));
            }
            Wallet wallet2 = this.wallet;
            if (wallet2 != null) {
                updateSendAmount$validateBalance(asBigInteger, this, c2, Wallet_ApplicationKt.maximumAvailableBalance(wallet2));
                return;
            } else {
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }
}