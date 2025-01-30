package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState;
import com.coinbase.wallet.features.swap.models.SwapCurrencyType;
import com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel;
import com.coinbase.wallet.swap.models.Aggregator;
import com.coinbase.wallet.swap.models.SwapAsset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/coinbase/wallet/swap/models/Aggregator;", "kotlin.jvm.PlatformType", "aggregatorList", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel$onAssetChanged$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends Aggregator>, kotlin.x> {
    final /* synthetic */ SwapAsset $source;
    final /* synthetic */ SwapAsset $target;
    final /* synthetic */ SwapAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerViewModel$onAssetChanged$1(SwapAmountPickerViewModel swapAmountPickerViewModel, SwapAsset swapAsset, SwapAsset swapAsset2) {
        super(1);
        this.this$0 = swapAmountPickerViewModel;
        this.$source = swapAsset;
        this.$target = swapAsset2;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(List<? extends Aggregator> list) {
        invoke2((List<Aggregator>) list);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<Aggregator> aggregatorList) {
        SwapAmountPickerViewState swapAmountPickerViewState;
        SwapAmountPickerViewState copy;
        SwapAmountPickerViewState swapAmountPickerViewState2;
        SwapAmountPickerViewState copy2;
        SwapAmountPickerViewModel.InputField inputField;
        SwapAmountPickerViewState swapAmountPickerViewState3;
        SwapAmountPickerViewModel.InputField inputField2;
        kotlin.jvm.internal.m.f(aggregatorList, "aggregatorList");
        boolean z = true;
        if (!(aggregatorList instanceof Collection) || !aggregatorList.isEmpty()) {
            Iterator<T> it = aggregatorList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((Aggregator) it.next()).getToSwapEnabled()) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            SwapAmountPickerViewModel swapAmountPickerViewModel = this.this$0;
            SwapAmountPickerViewState.CryptoField cryptoField = SwapAmountPickerViewState.CryptoField.SOURCE;
            swapAmountPickerViewState2 = swapAmountPickerViewModel.state;
            copy2 = swapAmountPickerViewState2.copy((r32 & 1) != 0 ? swapAmountPickerViewState2.isInitialized : false, (r32 & 2) != 0 ? swapAmountPickerViewState2.pickerItems : null, (r32 & 4) != 0 ? swapAmountPickerViewState2.activeCurrencyCard : null, (r32 & 8) != 0 ? swapAmountPickerViewState2.sourceSwapAsset : null, (r32 & 16) != 0 ? swapAmountPickerViewState2.targetSwapAsset : null, (r32 & 32) != 0 ? swapAmountPickerViewState2.error : null, (r32 & 64) != 0 ? swapAmountPickerViewState2.isLoading : false, (r32 & 128) != 0 ? swapAmountPickerViewState2.nextButtonTitle : null, (r32 & 256) != 0 ? swapAmountPickerViewState2.fiatAmountText : null, (r32 & 512) != 0 ? swapAmountPickerViewState2.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? swapAmountPickerViewState2.focusedCryptoInputField : cryptoField, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? swapAmountPickerViewState2.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? swapAmountPickerViewState2.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? swapAmountPickerViewState2.cryptoTargetAmount : null, (r32 & 16384) != 0 ? swapAmountPickerViewState2.isTargetFieldDisabled : true);
            swapAmountPickerViewModel.setState(copy2);
            inputField = this.this$0.lastEditedInput;
            if (inputField == SwapAmountPickerViewModel.InputField.TARGET) {
                SwapAmountPickerViewModel swapAmountPickerViewModel2 = this.this$0;
                swapAmountPickerViewState3 = swapAmountPickerViewModel2.state;
                if (swapAmountPickerViewState3.getActiveCurrencyCard() == SwapCurrencyType.FIAT) {
                    inputField2 = SwapAmountPickerViewModel.InputField.FIAT;
                } else {
                    inputField2 = SwapAmountPickerViewModel.InputField.SOURCE;
                }
                swapAmountPickerViewModel2.lastEditedInput = inputField2;
            }
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.swapAmountPickerToDisabled(AnalyticsEvent.Companion, this.$source.getCurrencyCode().getCode(), this.$target.getCurrencyCode().getCode()));
            return;
        }
        SwapAmountPickerViewModel swapAmountPickerViewModel3 = this.this$0;
        swapAmountPickerViewState = swapAmountPickerViewModel3.state;
        copy = swapAmountPickerViewState.copy((r32 & 1) != 0 ? swapAmountPickerViewState.isInitialized : false, (r32 & 2) != 0 ? swapAmountPickerViewState.pickerItems : null, (r32 & 4) != 0 ? swapAmountPickerViewState.activeCurrencyCard : null, (r32 & 8) != 0 ? swapAmountPickerViewState.sourceSwapAsset : null, (r32 & 16) != 0 ? swapAmountPickerViewState.targetSwapAsset : null, (r32 & 32) != 0 ? swapAmountPickerViewState.error : null, (r32 & 64) != 0 ? swapAmountPickerViewState.isLoading : false, (r32 & 128) != 0 ? swapAmountPickerViewState.nextButtonTitle : null, (r32 & 256) != 0 ? swapAmountPickerViewState.fiatAmountText : null, (r32 & 512) != 0 ? swapAmountPickerViewState.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? swapAmountPickerViewState.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? swapAmountPickerViewState.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? swapAmountPickerViewState.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? swapAmountPickerViewState.cryptoTargetAmount : null, (r32 & 16384) != 0 ? swapAmountPickerViewState.isTargetFieldDisabled : false);
        swapAmountPickerViewModel3.setState(copy);
    }
}