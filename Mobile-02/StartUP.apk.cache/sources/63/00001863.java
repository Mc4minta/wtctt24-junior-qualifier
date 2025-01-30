package com.coinbase.wallet.consumer.views;

import android.view.View;
import android.webkit.WebView;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerSecure3DEvent;
import kotlin.Metadata;

/* compiled from: ConsumerSecure3DVerificationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DEvent;", "kotlin.jvm.PlatformType", "event", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DEvent;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerSecure3DVerificationFragment$onViewCreated$4 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerSecure3DEvent, kotlin.x> {
    final /* synthetic */ ConsumerSecure3DVerificationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerSecure3DVerificationFragment$onViewCreated$4(ConsumerSecure3DVerificationFragment consumerSecure3DVerificationFragment) {
        super(1);
        this.this$0 = consumerSecure3DVerificationFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerSecure3DEvent consumerSecure3DEvent) {
        invoke2(consumerSecure3DEvent);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerSecure3DEvent consumerSecure3DEvent) {
        if (consumerSecure3DEvent instanceof ConsumerSecure3DEvent.UrlEvent) {
            View view = this.this$0.getView();
            ConsumerSecure3DEvent.UrlEvent urlEvent = (ConsumerSecure3DEvent.UrlEvent) consumerSecure3DEvent;
            ((WebView) (view == null ? null : view.findViewById(R.id.webView))).postUrl(urlEvent.getUrl(), urlEvent.getPostBody());
        }
    }
}