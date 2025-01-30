package com.coinbase.wallet.consumer.views;

import android.animation.ValueAnimator;
import android.view.View;
import com.coinbase.wallet.consumer.R;
import kotlin.Metadata;

/* compiled from: ConsumerSendTwoFactorFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/x;", "<anonymous>", "()V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerSendTwoFactorFragment$doErrorAnimation$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<kotlin.x> {
    final /* synthetic */ ValueAnimator $colorSwitch;
    final /* synthetic */ ConsumerSendTwoFactorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerSendTwoFactorFragment$doErrorAnimation$1(ConsumerSendTwoFactorFragment consumerSendTwoFactorFragment, ValueAnimator valueAnimator) {
        super(0);
        this.this$0 = consumerSendTwoFactorFragment;
        this.$colorSwitch = valueAnimator;
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ kotlin.x invoke() {
        invoke2();
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.this$0.getActivity() != null) {
            View view = this.this$0.getView();
            if ((view == null ? null : view.findViewById(R.id.twoFaDisplay)) != null) {
                this.$colorSwitch.start();
            }
        }
    }
}