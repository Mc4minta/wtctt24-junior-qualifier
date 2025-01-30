package com.coinbase.wallet.consumer.views;

import android.view.View;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerAddCardEvent;
import com.coinbase.wallet.consumer.models.LoadUrlEvent;
import kotlin.Metadata;

/* compiled from: ConsumerAddCardFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAddCardEvent;", "kotlin.jvm.PlatformType", "event", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerAddCardEvent;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerAddCardFragment$onViewCreated$7 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerAddCardEvent, kotlin.x> {
    final /* synthetic */ ConsumerAddCardFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAddCardFragment$onViewCreated$7(ConsumerAddCardFragment consumerAddCardFragment) {
        super(1);
        this.this$0 = consumerAddCardFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerAddCardEvent consumerAddCardEvent) {
        invoke2(consumerAddCardEvent);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerAddCardEvent consumerAddCardEvent) {
        if (consumerAddCardEvent instanceof LoadUrlEvent) {
            View view = this.this$0.getView();
            ((ConsumerAuthenticatedWebView) (view == null ? null : view.findViewById(R.id.webView))).loadUrl(((LoadUrlEvent) consumerAddCardEvent).getUrl());
        }
    }
}