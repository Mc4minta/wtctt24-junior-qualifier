package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.commonui.extensions.Bundle_CommonKt;
import com.coinbase.wallet.consumer.models.ConsumerAddCardArgs;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerAddCardViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAddCardViewModel$cardType$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<String> {
    final /* synthetic */ ConsumerAddCardViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAddCardViewModel$cardType$2(ConsumerAddCardViewModel consumerAddCardViewModel) {
        super(0);
        this.this$0 = consumerAddCardViewModel;
    }

    @Override // kotlin.e0.c.a
    public final String invoke() {
        String requireString = Bundle_CommonKt.requireString(this.this$0.getArgs(), ConsumerAddCardArgs.PAYMENT_METHOD_TYPE);
        Locale US = Locale.US;
        kotlin.jvm.internal.m.f(US, "US");
        Objects.requireNonNull(requireString, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = requireString.toLowerCase(US);
        kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }
}