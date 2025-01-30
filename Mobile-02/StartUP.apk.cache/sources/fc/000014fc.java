package com.coinbase.wallet.commonui.views;

import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import kotlin.Metadata;
import kotlin.e0.c.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NumberKeyboardInputView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$NumberKeyboardInputAdapter;", "<anonymous>", "()Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$NumberKeyboardInputAdapter;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NumberKeyboardInputView$digitAdapter$2 extends o implements kotlin.e0.c.a<NumberKeyboardInputView.NumberKeyboardInputAdapter> {
    final /* synthetic */ NumberKeyboardInputView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NumberKeyboardInputView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.commonui.views.NumberKeyboardInputView$digitAdapter$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass1 extends k implements p<NumberKeyboardDigit, Boolean, x> {
        AnonymousClass1(NumberKeyboardInputView numberKeyboardInputView) {
            super(2, numberKeyboardInputView, NumberKeyboardInputView.class, "handleDigitClicked", "handleDigitClicked(Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;Z)V", 0);
        }

        @Override // kotlin.e0.c.p
        public /* bridge */ /* synthetic */ x invoke(NumberKeyboardDigit numberKeyboardDigit, Boolean bool) {
            invoke(numberKeyboardDigit, bool.booleanValue());
            return x.a;
        }

        public final void invoke(NumberKeyboardDigit p0, boolean z) {
            m.g(p0, "p0");
            ((NumberKeyboardInputView) this.receiver).handleDigitClicked(p0, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumberKeyboardInputView$digitAdapter$2(NumberKeyboardInputView numberKeyboardInputView) {
        super(0);
        this.this$0 = numberKeyboardInputView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final NumberKeyboardInputView.NumberKeyboardInputAdapter invoke() {
        return new NumberKeyboardInputView.NumberKeyboardInputAdapter(new AnonymousClass1(this.this$0));
    }
}