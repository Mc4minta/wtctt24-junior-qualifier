package com.coinbase.wallet.features.send.views;

import kotlin.Metadata;
import org.toshi.R;

/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()F"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AmountPickerFragment$buttonElevation$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Float> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$buttonElevation$2(AmountPickerFragment amountPickerFragment) {
        super(0);
        this.this$0 = amountPickerFragment;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final float invoke2() {
        return this.this$0.requireContext().getResources().getDimension(R.dimen.elevation_double);
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ Float invoke() {
        return Float.valueOf(invoke2());
    }
}