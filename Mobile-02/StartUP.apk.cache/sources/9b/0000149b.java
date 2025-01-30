package com.coinbase.wallet.commonui.extensions;

import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;

/* compiled from: NumberKeyboardInputView+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "<anonymous>", "(C)Z"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class NumberKeyboardInputView_CommonKt$getUpdatedAmount$1 extends o implements l<Character, Boolean> {
    final /* synthetic */ char $separator;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumberKeyboardInputView_CommonKt$getUpdatedAmount$1(char c2) {
        super(1);
        this.$separator = c2;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
        return Boolean.valueOf(invoke(ch.charValue()));
    }

    public final boolean invoke(char c2) {
        return (Character.isDigit(c2) || c2 == this.$separator) ? false : true;
    }
}