package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.utilities.AmountPickerFormatter;
import com.coinbase.wallet.commonui.utilities.AmountText;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.features.swap.extensions.Currency_SwapKt;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState;
import com.coinbase.wallet.features.swap.models.SwapCurrencyType;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import java.util.List;
import kotlin.Metadata;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "kotlin.jvm.PlatformType", "fiat", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/wallets/models/FiatCurrency;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel$setup$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<FiatCurrency, kotlin.x> {
    final /* synthetic */ SwapAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerViewModel$setup$1(SwapAmountPickerViewModel swapAmountPickerViewModel) {
        super(1);
        this.this$0 = swapAmountPickerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(FiatCurrency fiatCurrency) {
        invoke2(fiatCurrency);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(FiatCurrency fiat) {
        AmountPickerFormatter amountPickerFormatter;
        SwapAmountPickerViewState swapAmountPickerViewState;
        List j2;
        SwapAmountPickerViewState copy;
        SwapAmountPickerViewState swapAmountPickerViewState2;
        SwapAmountPickerViewModel swapAmountPickerViewModel = this.this$0;
        amountPickerFormatter = this.this$0.amountPickerFormatter;
        swapAmountPickerViewModel.fiatZeroAmountText = new AmountText(amountPickerFormatter.formatFiatAmount(Strings.zero), Strings.zero);
        SwapAmountPickerViewModel swapAmountPickerViewModel2 = this.this$0;
        swapAmountPickerViewState = swapAmountPickerViewModel2.state;
        kotlin.jvm.internal.m.f(fiat, "fiat");
        j2 = kotlin.a0.r.j(Currency_SwapKt.getShortName(fiat), LocalizedStrings.INSTANCE.get(SwapCurrencyType.CRYPTO.getDescription()));
        copy = swapAmountPickerViewState.copy((r32 & 1) != 0 ? swapAmountPickerViewState.isInitialized : false, (r32 & 2) != 0 ? swapAmountPickerViewState.pickerItems : j2, (r32 & 4) != 0 ? swapAmountPickerViewState.activeCurrencyCard : null, (r32 & 8) != 0 ? swapAmountPickerViewState.sourceSwapAsset : null, (r32 & 16) != 0 ? swapAmountPickerViewState.targetSwapAsset : null, (r32 & 32) != 0 ? swapAmountPickerViewState.error : null, (r32 & 64) != 0 ? swapAmountPickerViewState.isLoading : false, (r32 & 128) != 0 ? swapAmountPickerViewState.nextButtonTitle : null, (r32 & 256) != 0 ? swapAmountPickerViewState.fiatAmountText : null, (r32 & 512) != 0 ? swapAmountPickerViewState.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? swapAmountPickerViewState.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? swapAmountPickerViewState.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? swapAmountPickerViewState.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? swapAmountPickerViewState.cryptoTargetAmount : null, (r32 & 16384) != 0 ? swapAmountPickerViewState.isTargetFieldDisabled : false);
        swapAmountPickerViewModel2.setState(copy);
        SwapAmountPickerViewModel swapAmountPickerViewModel3 = this.this$0;
        swapAmountPickerViewState2 = swapAmountPickerViewModel3.state;
        SwapAmountPickerViewModel.updateInputs$default(swapAmountPickerViewModel3, swapAmountPickerViewState2.getFiatAmountText().getRawString(), null, null, 6, null);
    }
}