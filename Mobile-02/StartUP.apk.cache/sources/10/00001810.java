package com.coinbase.wallet.consumer.views;

import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ConsumerAuthenticatedWebViewClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0017¢\u0006\u0004\b\t\u0010\rJ#\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0013\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerAuthenticateWebViewClient;", "Landroid/webkit/WebViewClient;", "", "url", "", "validUrl", "(Ljava/lang/String;)Z", "Landroid/webkit/WebView;", "view", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Landroid/webkit/WebResourceRequest;", "request", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z", "Lkotlin/x;", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "Landroid/webkit/WebResourceError;", "error", "onReceivedError", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V", "Lcom/coinbase/wallet/consumer/views/ConsumerWebViewNavigationDelegate;", "consumerNavigationDelegate", "Lcom/coinbase/wallet/consumer/views/ConsumerWebViewNavigationDelegate;", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "coinbaseWebViewConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "<init>", "(Lcom/coinbase/wallet/consumer/views/ConsumerWebViewNavigationDelegate;Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;)V", "Companion", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAuthenticateWebViewClient extends WebViewClient {
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final Companion Companion = new Companion(null);
    private final ConsumerWebViewConfig coinbaseWebViewConfig;
    private final ConsumerWebViewNavigationDelegate consumerNavigationDelegate;

    /* compiled from: ConsumerAuthenticatedWebViewClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00062\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerAuthenticateWebViewClient$Companion;", "", "", "", "additionalHttpHeaders", "accessToken", "Ljava/util/HashMap;", "appendAuthHeaders", "(Ljava/util/Map;Ljava/lang/String;)Ljava/util/HashMap;", "AUTHORIZATION", "Ljava/lang/String;", "BEARER", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HashMap<String, String> appendAuthHeaders(Map<String, String> map, String accessToken) {
            kotlin.jvm.internal.m.g(accessToken, "accessToken");
            HashMap<String, String> hashMap = new HashMap<>();
            if (map != null) {
                hashMap.putAll(map);
            }
            hashMap.put("Authorization", kotlin.jvm.internal.m.o(ConsumerAuthenticateWebViewClient.BEARER, accessToken));
            return hashMap;
        }
    }

    public ConsumerAuthenticateWebViewClient(ConsumerWebViewNavigationDelegate consumerNavigationDelegate, ConsumerWebViewConfig coinbaseWebViewConfig) {
        kotlin.jvm.internal.m.g(consumerNavigationDelegate, "consumerNavigationDelegate");
        kotlin.jvm.internal.m.g(coinbaseWebViewConfig, "coinbaseWebViewConfig");
        this.consumerNavigationDelegate = consumerNavigationDelegate;
        this.coinbaseWebViewConfig = coinbaseWebViewConfig;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.consumerNavigationDelegate.pageLoaded();
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.consumerNavigationDelegate.pageLoaded();
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        if (str == null) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        if (!this.consumerNavigationDelegate.urlNavigated(str) && validUrl(str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }

    public final boolean validUrl(String str) {
        String host;
        boolean z;
        if (str == null || (host = Uri.parse(str).getHost()) == null) {
            return false;
        }
        if (!kotlin.jvm.internal.m.c(host, this.coinbaseWebViewConfig.getHost())) {
            z = kotlin.l0.x.z(host, kotlin.jvm.internal.m.o(".", this.coinbaseWebViewConfig.getHost()), false, 2, null);
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        String uri = webResourceRequest.getUrl().toString();
        kotlin.jvm.internal.m.f(uri, "request.url.toString()");
        if (!this.consumerNavigationDelegate.urlNavigated(uri) && validUrl(uri)) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        return true;
    }
}