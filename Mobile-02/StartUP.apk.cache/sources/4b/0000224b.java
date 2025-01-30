package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.features.swap.models.SwapConfirmationError;
import com.coinbase.wallet.features.swap.models.SwapConfirmationEvent;
import com.coinbase.wallet.features.swap.models.SwapConfirmationViewState;
import com.coinbase.wallet.features.wallets.extensions.Wallet_ApplicationKt;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import kotlin.Metadata;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Wallet;", "kotlin.jvm.PlatformType", "feeWallet", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapConfirmationViewModel$handleNotEnoughFundsError$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Wallet, kotlin.x> {
    final /* synthetic */ kotlin.jvm.internal.d0<BigInteger> $totalMinerFee;
    final /* synthetic */ SwapConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapConfirmationViewModel$handleNotEnoughFundsError$2(kotlin.jvm.internal.d0<BigInteger> d0Var, SwapConfirmationViewModel swapConfirmationViewModel) {
        super(1);
        this.$totalMinerFee = d0Var;
        this.this$0 = swapConfirmationViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Wallet wallet) {
        invoke2(wallet);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Wallet feeWallet) {
        String str;
        SwapConfirmationViewState swapConfirmationViewState;
        SwapConfirmationViewState copy;
        h.c.v0.b bVar;
        SwapAsset swapAsset;
        SwapAsset swapAsset2;
        CurrencyFormatter currencyFormatter;
        CurrencyFormatter currencyFormatter2;
        CurrencyFormatter currencyFormatter3;
        if (this.$totalMinerFee.a.compareTo(BigInteger.ZERO) > 0) {
            kotlin.jvm.internal.m.f(feeWallet, "feeWallet");
            BigInteger subtract = this.$totalMinerFee.a.subtract(Wallet_ApplicationKt.maximumAvailableBalance(feeWallet));
            kotlin.jvm.internal.m.f(subtract, "this.subtract(other)");
            currencyFormatter = this.this$0.currencyFormatter;
            String formatToCrypto$default = CurrencyFormatter.formatToCrypto$default(currencyFormatter, feeWallet.getCurrencyCode(), feeWallet.getDecimals(), subtract, false, 0, 0, 56, (Object) null);
            currencyFormatter2 = this.this$0.currencyFormatter;
            CurrencyCode currencyCode = feeWallet.getCurrencyCode();
            String contractAddress = feeWallet.getContractAddress();
            int decimals = feeWallet.getDecimals();
            EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(feeWallet.getNetwork());
            BigDecimal fiatValue$default = CurrencyFormatter.fiatValue$default(currencyFormatter2, currencyCode, contractAddress, decimals, subtract, null, asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()), 16, null);
            if (fiatValue$default == null) {
                fiatValue$default = BigDecimal.ZERO;
            }
            currencyFormatter3 = this.this$0.currencyFormatter;
            BigDecimal scale = fiatValue$default.setScale(0, RoundingMode.UP);
            kotlin.jvm.internal.m.f(scale, "fiatDifference.setScale(0, RoundingMode.UP)");
            str = LocalizedStrings.INSTANCE.get(R.string.insufficient_balance_with_fiat_error, feeWallet.getCurrencyCode().getCode(), formatToCrypto$default, currencyFormatter3.fiatValueString(scale, true));
        } else {
            str = LocalizedStrings.INSTANCE.get(R.string.insufficient_balance_no_fee_error, feeWallet.getCurrencyCode().getCode());
        }
        SwapConfirmationError.InsufficientBalance insufficientBalance = new SwapConfirmationError.InsufficientBalance(str);
        SwapConfirmationViewModel swapConfirmationViewModel = this.this$0;
        swapConfirmationViewState = swapConfirmationViewModel.state;
        copy = swapConfirmationViewState.copy((r34 & 1) != 0 ? swapConfirmationViewState.amountBase : null, (r34 & 2) != 0 ? swapConfirmationViewState.currencyType : null, (r34 & 4) != 0 ? swapConfirmationViewState.cardTitle : null, (r34 & 8) != 0 ? swapConfirmationViewState.isLoading : false, (r34 & 16) != 0 ? swapConfirmationViewState.isConverting : false, (r34 & 32) != 0 ? swapConfirmationViewState.isConvertButtonVisible : false, (r34 & 64) != 0 ? swapConfirmationViewState.targetCurrencyCode : null, (r34 & 128) != 0 ? swapConfirmationViewState.targetImageURL : null, (r34 & 256) != 0 ? swapConfirmationViewState.sourceCryptoAmount : null, (r34 & 512) != 0 ? swapConfirmationViewState.sourceFiatAmount : null, (r34 & 1024) != 0 ? swapConfirmationViewState.targetCryptoAmount : null, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? swapConfirmationViewState.minerFeeFiatAmount : null, (r34 & 4096) != 0 ? swapConfirmationViewState.minerFeeCryptoAmount : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? swapConfirmationViewState.coinbaseFeeFiatAmount : null, (r34 & 16384) != 0 ? swapConfirmationViewState.coinbaseFeeCryptoAmount : null, (r34 & 32768) != 0 ? swapConfirmationViewState.error : insufficientBalance);
        swapConfirmationViewModel.setState(copy);
        bVar = this.this$0.eventSubject;
        bVar.onNext(SwapConfirmationEvent.ExpandDetails.INSTANCE);
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        String description = insufficientBalance.getDescription();
        swapAsset = this.this$0.sourceAsset;
        String code = swapAsset.getCurrencyCode().getCode();
        swapAsset2 = this.this$0.targetAsset;
        analytics.log(AnalyticsEvent_ApplicationKt.swapConfirmErrorReceived(companion, description, code, swapAsset2.getCurrencyCode().getCode()));
    }
}