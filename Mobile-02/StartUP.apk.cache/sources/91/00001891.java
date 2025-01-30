package com.coinbase.wallet.consumer.views;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import kotlin.Metadata;

/* compiled from: ConsumerWebView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000fB!\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0012B)\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerWebView;", "Landroid/webkit/WebView;", "Lcom/coinbase/wallet/consumer/views/ConsumerAuthenticateWebViewClient;", "consumerWebViewClient", "Lcom/coinbase/wallet/consumer/views/ConsumerAuthenticateWebViewClient;", "getConsumerWebViewClient", "()Lcom/coinbase/wallet/consumer/views/ConsumerAuthenticateWebViewClient;", "setConsumerWebViewClient", "(Lcom/coinbase/wallet/consumer/views/ConsumerAuthenticateWebViewClient;)V", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class ConsumerWebView extends WebView {
    public ConsumerAuthenticateWebViewClient consumerWebViewClient;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerWebView(Context ctx) {
        super(ctx);
        kotlin.jvm.internal.m.g(ctx, "ctx");
        getSettings().setAllowContentAccess(false);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setCacheMode(2);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final ConsumerAuthenticateWebViewClient getConsumerWebViewClient() {
        ConsumerAuthenticateWebViewClient consumerAuthenticateWebViewClient = this.consumerWebViewClient;
        if (consumerAuthenticateWebViewClient != null) {
            return consumerAuthenticateWebViewClient;
        }
        kotlin.jvm.internal.m.w("consumerWebViewClient");
        throw null;
    }

    public final void setConsumerWebViewClient(ConsumerAuthenticateWebViewClient consumerAuthenticateWebViewClient) {
        kotlin.jvm.internal.m.g(consumerAuthenticateWebViewClient, "<set-?>");
        this.consumerWebViewClient = consumerAuthenticateWebViewClient;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerWebView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        kotlin.jvm.internal.m.g(ctx, "ctx");
        kotlin.jvm.internal.m.g(attrs, "attrs");
        getSettings().setAllowContentAccess(false);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setCacheMode(2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerWebView(Context ctx, AttributeSet attrs, int i2) {
        super(ctx, attrs, i2);
        kotlin.jvm.internal.m.g(ctx, "ctx");
        kotlin.jvm.internal.m.g(attrs, "attrs");
        getSettings().setAllowContentAccess(false);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setCacheMode(2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerWebView(Context ctx, AttributeSet attrs, int i2, int i3) {
        super(ctx, attrs, i2, i3);
        kotlin.jvm.internal.m.g(ctx, "ctx");
        kotlin.jvm.internal.m.g(attrs, "attrs");
        getSettings().setAllowContentAccess(false);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setCacheMode(2);
    }
}