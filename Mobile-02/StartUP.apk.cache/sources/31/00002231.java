package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.features.swap.models.SwapAssetPickerEvent;
import com.coinbase.wallet.features.swap.prompts.UnsupportedSwapAssetPrompt;
import com.coinbase.wallet.swap.models.Aggregator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAssetPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/coinbase/wallet/swap/models/Aggregator;", "kotlin.jvm.PlatformType", "aggregators", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAssetPickerViewModel$presentUnsupportedPrompt$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends Aggregator>, kotlin.x> {
    final /* synthetic */ SwapAssetPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAssetPickerViewModel$presentUnsupportedPrompt$1(SwapAssetPickerViewModel swapAssetPickerViewModel) {
        super(1);
        this.this$0 = swapAssetPickerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(List<? extends Aggregator> list) {
        invoke2((List<Aggregator>) list);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<Aggregator> aggregators) {
        UnsupportedSwapAssetPrompt unsupportedSwapAssetPrompt;
        h.c.v0.b bVar;
        unsupportedSwapAssetPrompt = this.this$0.unsupportedSwapAssetPrompt;
        kotlin.jvm.internal.m.f(aggregators, "aggregators");
        PromptDialogHelper.Properties promptProperties = unsupportedSwapAssetPrompt.promptProperties(aggregators);
        bVar = this.this$0.eventSubject;
        bVar.onNext(new SwapAssetPickerEvent.LaunchPrompt(promptProperties));
    }
}