package com.coinbase.wallet.commonui.viewmodels;

import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;

/* compiled from: AmountViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "<anonymous>", "(C)Z"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AmountViewModel$updateAmount$1 extends o implements l<Character, Boolean> {
    public static final AmountViewModel$updateAmount$1 INSTANCE = new AmountViewModel$updateAmount$1();

    AmountViewModel$updateAmount$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
        return Boolean.valueOf(invoke(ch.charValue()));
    }

    public final boolean invoke(char c2) {
        boolean c3;
        c3 = kotlin.l0.b.c(c2);
        return c3;
    }
}