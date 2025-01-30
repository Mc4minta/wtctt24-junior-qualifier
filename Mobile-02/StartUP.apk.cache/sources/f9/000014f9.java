package com.coinbase.wallet.commonui.views;

import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NumberKeyboardInputView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()F"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NumberKeyboardInputView$ViewHolder$deleteTextSize$2 extends o implements kotlin.e0.c.a<Float> {
    final /* synthetic */ NumberKeyboardInputView.ViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumberKeyboardInputView$ViewHolder$deleteTextSize$2(NumberKeyboardInputView.ViewHolder viewHolder) {
        super(0);
        this.this$0 = viewHolder;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final float invoke2() {
        float regularTextSize;
        float deleteTextSizeMultiplier;
        regularTextSize = this.this$0.getRegularTextSize();
        deleteTextSizeMultiplier = this.this$0.getDeleteTextSizeMultiplier();
        return regularTextSize * deleteTextSizeMultiplier;
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ Float invoke() {
        return Float.valueOf(invoke2());
    }
}