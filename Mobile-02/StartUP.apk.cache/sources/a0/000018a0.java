package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.common.utilities.Locales;
import java.text.DecimalFormatSymbols;
import kotlin.Metadata;

/* compiled from: SimpleAmountInputView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/text/DecimalFormatSymbols;", "<anonymous>", "()Ljava/text/DecimalFormatSymbols;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SimpleAmountInputView$decimalFormatSymbols$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<DecimalFormatSymbols> {
    public static final SimpleAmountInputView$decimalFormatSymbols$2 INSTANCE = new SimpleAmountInputView$decimalFormatSymbols$2();

    SimpleAmountInputView$decimalFormatSymbols$2() {
        super(0);
    }

    @Override // kotlin.e0.c.a
    public final DecimalFormatSymbols invoke() {
        return new DecimalFormatSymbols(Locales.INSTANCE.getCurrent());
    }
}