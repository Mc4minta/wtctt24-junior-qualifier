package com.coinbase.wallet.consumer.views;

import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import com.coinbase.wallet.common.extensions.SafeWhen_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerAmountPickerEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: ConsumerAmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent;", "kotlin.jvm.PlatformType", "event", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerAmountPickerFragment$setupObservers$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerAmountPickerEvent, kotlin.x> {
    final /* synthetic */ ConsumerAmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAmountPickerFragment$setupObservers$1(ConsumerAmountPickerFragment consumerAmountPickerFragment) {
        super(1);
        this.this$0 = consumerAmountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerAmountPickerEvent consumerAmountPickerEvent) {
        invoke2(consumerAmountPickerEvent);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerAmountPickerEvent consumerAmountPickerEvent) {
        if (consumerAmountPickerEvent instanceof ConsumerAmountPickerEvent.KeyboardInputError) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 20.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setInterpolator(new CycleInterpolator(3.0f));
            View view = this.this$0.getView();
            ((AppCompatTextView) (view == null ? null : view.findViewById(R.id.primaryTextView))).startAnimation(translateAnimation);
        } else if (consumerAmountPickerEvent instanceof ConsumerAmountPickerEvent.FetchMaxAmountError) {
            Toast.makeText(this.this$0.requireContext(), ((ConsumerAmountPickerEvent.FetchMaxAmountError) consumerAmountPickerEvent).getMessage(), 1).show();
        } else if (consumerAmountPickerEvent instanceof ConsumerAmountPickerEvent.FetchNextActionError) {
            Toast.makeText(this.this$0.requireContext(), ((ConsumerAmountPickerEvent.FetchNextActionError) consumerAmountPickerEvent).getMessage(), 1).show();
        } else if (consumerAmountPickerEvent instanceof ConsumerAmountPickerEvent.ConsumerAmountPickerPrompt) {
            PromptDialogHelper.INSTANCE.show(this.this$0, ((ConsumerAmountPickerEvent.ConsumerAmountPickerPrompt) consumerAmountPickerEvent).getProperties());
        } else if (consumerAmountPickerEvent instanceof ConsumerAmountPickerEvent.HideKeyboard) {
            Fragment_CommonKt.hideKeyboard(this.this$0);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        SafeWhen_CommonKt.getSafe(kotlin.x.a);
    }
}