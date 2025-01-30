package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.models.ConsumerAmountPickerViewState;
import kotlin.Metadata;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAmountPickerViewModel$observeAmountUpdates$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
    final /* synthetic */ ConsumerAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAmountPickerViewModel$observeAmountUpdates$1(ConsumerAmountPickerViewModel consumerAmountPickerViewModel) {
        super(1);
        this.this$0 = consumerAmountPickerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
        invoke2(str);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String it) {
        ConsumerAmountPickerViewState consumerAmountPickerViewState;
        ConsumerAmountPickerViewState copy;
        ConsumerAmountPickerViewModel consumerAmountPickerViewModel = this.this$0;
        consumerAmountPickerViewState = consumerAmountPickerViewModel.state;
        kotlin.jvm.internal.m.f(it, "it");
        copy = consumerAmountPickerViewState.copy((r32 & 1) != 0 ? consumerAmountPickerViewState.maxAmount : null, (r32 & 2) != 0 ? consumerAmountPickerViewState.isMaxButtonLoading : false, (r32 & 4) != 0 ? consumerAmountPickerViewState.isNextButtonVisible : false, (r32 & 8) != 0 ? consumerAmountPickerViewState.isNextButtonLoading : false, (r32 & 16) != 0 ? consumerAmountPickerViewState.isFiatSelected : false, (r32 & 32) != 0 ? consumerAmountPickerViewState.primaryText : it, (r32 & 64) != 0 ? consumerAmountPickerViewState.secondaryText : null, (r32 & 128) != 0 ? consumerAmountPickerViewState.swapButtonEnabled : false, (r32 & 256) != 0 ? consumerAmountPickerViewState.currencyCode : null, (r32 & 512) != 0 ? consumerAmountPickerViewState.keyboardLocale : null, (r32 & 1024) != 0 ? consumerAmountPickerViewState.isOnrampEnabled : false, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? consumerAmountPickerViewState.cryptoBalance : null, (r32 & 4096) != 0 ? consumerAmountPickerViewState.fiatBalance : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? consumerAmountPickerViewState.isInsufficientBalance : false, (r32 & 16384) != 0 ? consumerAmountPickerViewState.wallet : null);
        consumerAmountPickerViewModel.setState(copy);
    }
}