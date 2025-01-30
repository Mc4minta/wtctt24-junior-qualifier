package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.R;
import kotlin.Metadata;

/* compiled from: ConsumerAmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()F"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerAmountPickerFragment$buttonElevation$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Float> {
    final /* synthetic */ ConsumerAmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAmountPickerFragment$buttonElevation$2(ConsumerAmountPickerFragment consumerAmountPickerFragment) {
        super(0);
        this.this$0 = consumerAmountPickerFragment;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final float invoke2() {
        return this.this$0.requireContext().getResources().getDimension(R.dimen.view_size_16);
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ Float invoke() {
        return Float.valueOf(invoke2());
    }
}