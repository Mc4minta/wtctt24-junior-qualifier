package com.coinbase.wallet.consumer.views;

import android.view.View;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerAddCardState;
import kotlin.Metadata;

/* compiled from: ConsumerAddCardFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAddCardState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerAddCardState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerAddCardFragment$onViewCreated$6 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerAddCardState, kotlin.x> {
    final /* synthetic */ ConsumerAddCardFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAddCardFragment$onViewCreated$6(ConsumerAddCardFragment consumerAddCardFragment) {
        super(1);
        this.this$0 = consumerAddCardFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerAddCardState consumerAddCardState) {
        invoke2(consumerAddCardState);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerAddCardState consumerAddCardState) {
        View view = this.this$0.getView();
        View webView = view == null ? null : view.findViewById(R.id.webView);
        kotlin.jvm.internal.m.f(webView, "webView");
        webView.setVisibility(consumerAddCardState.getShowWebView() ? 0 : 8);
        View view2 = this.this$0.getView();
        View progress = view2 != null ? view2.findViewById(R.id.progress) : null;
        kotlin.jvm.internal.m.f(progress, "progress");
        progress.setVisibility(consumerAddCardState.getShowLoading() ? 0 : 8);
    }
}