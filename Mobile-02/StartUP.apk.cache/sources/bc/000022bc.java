package com.coinbase.wallet.features.swap.views;

import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.features.swap.models.SwapAssetPickerEvent;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: SwapAssetPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerEvent;", "kotlin.jvm.PlatformType", "event", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerEvent;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SwapAssetPickerFragment$onViewCreated$7 extends o implements l<SwapAssetPickerEvent, x> {
    final /* synthetic */ SwapAssetPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAssetPickerFragment$onViewCreated$7(SwapAssetPickerFragment swapAssetPickerFragment) {
        super(1);
        this.this$0 = swapAssetPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(SwapAssetPickerEvent swapAssetPickerEvent) {
        invoke2(swapAssetPickerEvent);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SwapAssetPickerEvent swapAssetPickerEvent) {
        if (swapAssetPickerEvent instanceof SwapAssetPickerEvent.LaunchPrompt) {
            PromptDialogHelper.INSTANCE.show(this.this$0, ((SwapAssetPickerEvent.LaunchPrompt) swapAssetPickerEvent).getProperties());
        }
    }
}