package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState;
import com.coinbase.wallet.features.swap.models.SwapConfirmationArgs;
import com.coinbase.wallet.features.swap.models.SwapCurrencyType;
import com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel;
import com.coinbase.wallet.swap.models.AmountBase;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.coinbase.wallet.swap.models.SwapTrade;
import kotlin.Metadata;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapTrade;", "kotlin.jvm.PlatformType", "trade", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/swap/models/SwapTrade;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel$proceedToConfirmTx$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SwapTrade, kotlin.x> {
    final /* synthetic */ AmountBase $amountBase;
    final /* synthetic */ SwapAsset $source;
    final /* synthetic */ SwapAsset $target;
    final /* synthetic */ TransferValue $transferAmount;
    final /* synthetic */ SwapAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerViewModel$proceedToConfirmTx$3(SwapAmountPickerViewModel swapAmountPickerViewModel, AmountBase amountBase, SwapAsset swapAsset, SwapAsset swapAsset2, TransferValue transferValue) {
        super(1);
        this.this$0 = swapAmountPickerViewModel;
        this.$amountBase = amountBase;
        this.$source = swapAsset;
        this.$target = swapAsset2;
        this.$transferAmount = transferValue;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(SwapTrade swapTrade) {
        invoke2(swapTrade);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SwapTrade trade) {
        SwapAmountPickerViewState swapAmountPickerViewState;
        SwapAmountPickerViewState copy;
        SwapAmountPickerViewState swapAmountPickerViewState2;
        SwapAmountPickerViewModel.InputField inputField;
        AmountBase asAmountBase;
        SwapAmountPickerViewState swapAmountPickerViewState3;
        h.c.v0.b bVar;
        SwapAmountPickerViewModel swapAmountPickerViewModel = this.this$0;
        swapAmountPickerViewState = swapAmountPickerViewModel.state;
        copy = swapAmountPickerViewState.copy((r32 & 1) != 0 ? swapAmountPickerViewState.isInitialized : false, (r32 & 2) != 0 ? swapAmountPickerViewState.pickerItems : null, (r32 & 4) != 0 ? swapAmountPickerViewState.activeCurrencyCard : null, (r32 & 8) != 0 ? swapAmountPickerViewState.sourceSwapAsset : null, (r32 & 16) != 0 ? swapAmountPickerViewState.targetSwapAsset : null, (r32 & 32) != 0 ? swapAmountPickerViewState.error : null, (r32 & 64) != 0 ? swapAmountPickerViewState.isLoading : false, (r32 & 128) != 0 ? swapAmountPickerViewState.nextButtonTitle : null, (r32 & 256) != 0 ? swapAmountPickerViewState.fiatAmountText : null, (r32 & 512) != 0 ? swapAmountPickerViewState.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? swapAmountPickerViewState.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? swapAmountPickerViewState.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? swapAmountPickerViewState.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? swapAmountPickerViewState.cryptoTargetAmount : null, (r32 & 16384) != 0 ? swapAmountPickerViewState.isTargetFieldDisabled : false);
        swapAmountPickerViewModel.setState(copy);
        SwapConfirmationArgs swapConfirmationArgs = SwapConfirmationArgs.INSTANCE;
        swapAmountPickerViewState2 = this.this$0.state;
        SwapCurrencyType activeCurrencyCard = swapAmountPickerViewState2.getActiveCurrencyCard();
        AmountBase amountBase = this.$amountBase;
        SwapAsset swapAsset = this.$source;
        SwapAsset swapAsset2 = this.$target;
        TransferValue transferValue = this.$transferAmount;
        kotlin.jvm.internal.m.f(trade, "trade");
        ViewModelNavRoute viewModelNavRoute = new ViewModelNavRoute(R.id.action_swapAmountPickerFragment_to_swapConfirmationFragment, swapConfirmationArgs.createArguments(activeCurrencyCard, amountBase, swapAsset, swapAsset2, transferValue, trade), Fragment_CommonKt.getFadeInNavOptions(this.this$0));
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        SwapAmountPickerViewModel swapAmountPickerViewModel2 = this.this$0;
        inputField = swapAmountPickerViewModel2.lastEditedInput;
        asAmountBase = swapAmountPickerViewModel2.asAmountBase(inputField);
        String description = asAmountBase.getDescription();
        swapAmountPickerViewState3 = this.this$0.state;
        analytics.log(AnalyticsEvent_ApplicationKt.swapAmountPickerProceed(companion, description, swapAmountPickerViewState3.getActiveCurrencyCard().getAnalyticsName(), this.$source.getCurrencyCode().getCode(), this.$target.getCurrencyCode().getCode()));
        bVar = this.this$0.navigationSubject;
        bVar.onNext(viewModelNavRoute);
    }
}