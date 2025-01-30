package com.coinbase.wallet.features.swap.views;

import e.j.f.m;
import kotlin.Metadata;
import kotlin.jvm.internal.o;
import org.toshi.R;

/* compiled from: SwapAssetPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()F"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SwapAssetPickerFragment$headerElevation$2 extends o implements kotlin.e0.c.a<Float> {
    final /* synthetic */ SwapAssetPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAssetPickerFragment$headerElevation$2(SwapAssetPickerFragment swapAssetPickerFragment) {
        super(0);
        this.this$0 = swapAssetPickerFragment;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final float invoke2() {
        return m.d(this.this$0, R.dimen.view_size_2);
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ Float invoke() {
        return Float.valueOf(invoke2());
    }
}