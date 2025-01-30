package com.coinbase.wallet.features.swap.views;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.coinbase.wallet.common.extensions.SafeWhen_CommonKt;
import com.coinbase.wallet.commonui.utilities.animation.ShakeAnimationKt;
import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: SwapAmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent;", "kotlin.jvm.PlatformType", "event", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SwapAmountPickerFragment$setupObservers$2 extends o implements l<SwapAmountPickerEvent, x> {
    final /* synthetic */ SwapAmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerFragment$setupObservers$2(SwapAmountPickerFragment swapAmountPickerFragment) {
        super(1);
        this.this$0 = swapAmountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(SwapAmountPickerEvent swapAmountPickerEvent) {
        invoke2(swapAmountPickerEvent);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SwapAmountPickerEvent swapAmountPickerEvent) {
        Object valueOf;
        if (m.c(swapAmountPickerEvent, SwapAmountPickerEvent.InvalidCryptoSourceInput.INSTANCE)) {
            View view = this.this$0.getView();
            ((AppCompatTextView) (view != null ? view.findViewById(e.j.a.topAmount) : null)).startAnimation(ShakeAnimationKt.shakeAnimation());
            valueOf = x.a;
        } else if (m.c(swapAmountPickerEvent, SwapAmountPickerEvent.InvalidFiatInput.INSTANCE)) {
            View view2 = this.this$0.getView();
            ((AppCompatTextView) (view2 != null ? view2.findViewById(e.j.a.amount) : null)).startAnimation(ShakeAnimationKt.shakeAnimation());
            valueOf = x.a;
        } else if (m.c(swapAmountPickerEvent, SwapAmountPickerEvent.InvalidCryptoTargetInput.INSTANCE)) {
            View view3 = this.this$0.getView();
            ((AppCompatTextView) (view3 != null ? view3.findViewById(e.j.a.bottomAmount) : null)).startAnimation(ShakeAnimationKt.shakeAnimation());
            valueOf = x.a;
        } else if (m.c(swapAmountPickerEvent, SwapAmountPickerEvent.NoSourceSelected.INSTANCE)) {
            View view4 = this.this$0.getView();
            View findViewById = view4 == null ? null : view4.findViewById(e.j.a.leftAsset);
            int i2 = e.j.a.placeholder;
            ((AppCompatTextView) findViewById.findViewById(i2)).startAnimation(ShakeAnimationKt.shakeAnimation());
            View view5 = this.this$0.getView();
            ((AppCompatTextView) (view5 == null ? null : view5.findViewById(e.j.a.topAsset)).findViewById(i2)).startAnimation(ShakeAnimationKt.shakeAnimation());
            View view6 = this.this$0.getView();
            valueOf = Boolean.valueOf(((NumberKeyboardInputView) (view6 != null ? view6.findViewById(e.j.a.h3) : null)).performHapticFeedback(1, 2));
        } else if (m.c(swapAmountPickerEvent, SwapAmountPickerEvent.NoTargetSelected.INSTANCE)) {
            View view7 = this.this$0.getView();
            View findViewById2 = view7 == null ? null : view7.findViewById(e.j.a.bottomAsset);
            int i3 = e.j.a.placeholder;
            ((AppCompatTextView) findViewById2.findViewById(i3)).startAnimation(ShakeAnimationKt.shakeAnimation());
            View view8 = this.this$0.getView();
            ((AppCompatTextView) (view8 == null ? null : view8.findViewById(e.j.a.rightAsset)).findViewById(i3)).startAnimation(ShakeAnimationKt.shakeAnimation());
            View view9 = this.this$0.getView();
            valueOf = Boolean.valueOf(((NumberKeyboardInputView) (view9 != null ? view9.findViewById(e.j.a.h3) : null)).performHapticFeedback(1, 2));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        SafeWhen_CommonKt.getSafe(valueOf);
    }
}