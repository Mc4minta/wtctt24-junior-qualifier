package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.common.utilities.Locales;
import java.text.NumberFormat;
import kotlin.Metadata;

/* compiled from: SimpleAmountInputView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/text/NumberFormat;", "kotlin.jvm.PlatformType", "<anonymous>", "()Ljava/text/NumberFormat;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SimpleAmountInputView$numberFormat$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<NumberFormat> {
    public static final SimpleAmountInputView$numberFormat$2 INSTANCE = new SimpleAmountInputView$numberFormat$2();

    SimpleAmountInputView$numberFormat$2() {
        super(0);
    }

    @Override // kotlin.e0.c.a
    public final NumberFormat invoke() {
        return NumberFormat.getInstance(Locales.INSTANCE.getCurrent());
    }
}