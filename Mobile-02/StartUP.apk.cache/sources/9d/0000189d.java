package com.coinbase.wallet.consumer.views;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* compiled from: Secure3DWebViewClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/consumer/views/Secure3DWebViewClient;", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Lkotlin/x;", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "Lcom/coinbase/wallet/consumer/views/ConsumerSecure3DWebViewNavigationDelegate;", "consumerNavigationDelegate", "Lcom/coinbase/wallet/consumer/views/ConsumerSecure3DWebViewNavigationDelegate;", "<init>", "(Lcom/coinbase/wallet/consumer/views/ConsumerSecure3DWebViewNavigationDelegate;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Secure3DWebViewClient extends WebViewClient {
    private final ConsumerSecure3DWebViewNavigationDelegate consumerNavigationDelegate;

    public Secure3DWebViewClient(ConsumerSecure3DWebViewNavigationDelegate consumerNavigationDelegate) {
        kotlin.jvm.internal.m.g(consumerNavigationDelegate, "consumerNavigationDelegate");
        this.consumerNavigationDelegate = consumerNavigationDelegate;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.consumerNavigationDelegate.pageLoaded();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        kotlin.jvm.internal.m.g(view, "view");
        kotlin.jvm.internal.m.g(url, "url");
        HttpUrl parse = HttpUrl.Companion.parse(url);
        if (parse == null) {
            return super.shouldOverrideUrlLoading(view, url);
        }
        if (this.consumerNavigationDelegate.urlNavigated(url, parse.queryParameter("PaRes"))) {
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }
}