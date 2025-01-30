package com.coinbase.wallet.consumer.viewmodels;

import android.net.Uri;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerAddCardViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAddCardViewModel$url$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<String> {
    final /* synthetic */ ConsumerAddCardViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAddCardViewModel$url$2(ConsumerAddCardViewModel consumerAddCardViewModel) {
        super(0);
        this.this$0 = consumerAddCardViewModel;
    }

    @Override // kotlin.e0.c.a
    public final String invoke() {
        ConsumerWebViewConfig consumerWebViewConfig;
        ConsumerWebViewConfig consumerWebViewConfig2;
        String sb;
        ConsumerWebViewConfig consumerWebViewConfig3;
        String cardType;
        ConsumerWebViewConfig consumerWebViewConfig4;
        consumerWebViewConfig = this.this$0.consumerWebViewConfig;
        Integer port = consumerWebViewConfig.getPort();
        if (port == null) {
            sb = null;
        } else {
            ConsumerAddCardViewModel consumerAddCardViewModel = this.this$0;
            int intValue = port.intValue();
            StringBuilder sb2 = new StringBuilder();
            consumerWebViewConfig2 = consumerAddCardViewModel.consumerWebViewConfig;
            sb2.append(consumerWebViewConfig2.getBaseUrl());
            sb2.append(':');
            sb2.append(intValue);
            sb = sb2.toString();
        }
        if (sb == null) {
            consumerWebViewConfig4 = this.this$0.consumerWebViewConfig;
            sb = consumerWebViewConfig4.getBaseUrl();
        }
        Uri.Builder builder = new Uri.Builder();
        consumerWebViewConfig3 = this.this$0.consumerWebViewConfig;
        Uri.Builder appendQueryParameter = builder.scheme(consumerWebViewConfig3.getProto()).encodedAuthority(sb).appendPath("authed_redirect").appendQueryParameter(ApiConstants.TO, "link-card").appendQueryParameter("webview", "true");
        cardType = this.this$0.getCardType();
        String uri = appendQueryParameter.appendQueryParameter("cardType", cardType).build().toString();
        kotlin.jvm.internal.m.f(uri, "Builder()\n            .scheme(consumerWebViewConfig.proto)\n            .encodedAuthority(baseUrl)\n            .appendPath(\"authed_redirect\")\n            .appendQueryParameter(\"to\", \"link-card\")\n            .appendQueryParameter(\"webview\", \"true\")\n            .appendQueryParameter(\"cardType\", cardType)\n            .build()\n            .toString()");
        return uri;
    }
}