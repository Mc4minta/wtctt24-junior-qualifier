package com.coinbase.wallet.consumer.views;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.coinbase.Coinbase;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.consumer.views.ConsumerWebViewClient;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ConsumerOnboardingWebView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u0004R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00061"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerOnboardingWebView;", "Landroid/webkit/WebView;", "Lkotlin/x;", "clearCookies", "()V", "Landroid/webkit/ValueCallback;", "", "callback", "setCBVersionCookie", "(Landroid/webkit/ValueCallback;)V", "Lh/c/s;", "Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient$ConnectionStatus;", "start", "()Lh/c/s;", "onDetachedFromWindow", "Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient;", "consumerWebViewClient", "Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient;", "getConsumerWebViewClient", "()Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient;", "setConsumerWebViewClient", "(Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient;)V", "Lcom/coinbase/Coinbase;", "coinbaseApi", "Lcom/coinbase/Coinbase;", "getCoinbaseApi", "()Lcom/coinbase/Coinbase;", "setCoinbaseApi", "(Lcom/coinbase/Coinbase;)V", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "consumerWebviewConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "getConsumerWebviewConfig", "()Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "setConsumerWebviewConfig", "(Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;)V", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "consumerUserRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "getConsumerUserRepository", "()Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "setConsumerUserRepository", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerOnboardingWebView extends WebView {
    public Coinbase coinbaseApi;
    public ConsumerUserRepository consumerUserRepository;
    public ConsumerWebViewClient consumerWebViewClient;
    public ConsumerWebViewConfig consumerWebviewConfig;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConsumerOnboardingWebView(Context context) {
        this(context, null, 2, null);
        kotlin.jvm.internal.m.g(context, "context");
    }

    public /* synthetic */ ConsumerOnboardingWebView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static /* synthetic */ h.c.x a(ConsumerOnboardingWebView consumerOnboardingWebView, kotlin.x xVar) {
        return m1038start$lambda2(consumerOnboardingWebView, xVar);
    }

    public static /* synthetic */ void b(ConsumerOnboardingWebView consumerOnboardingWebView, String str, Boolean bool) {
        m1037start$lambda1$lambda0(consumerOnboardingWebView, str, bool);
    }

    public static /* synthetic */ kotlin.x c(ConsumerOnboardingWebView consumerOnboardingWebView, String str) {
        return m1036start$lambda1(consumerOnboardingWebView, str);
    }

    private final void clearCookies() {
        List<String> K0;
        List K02;
        String str = getConsumerWebviewConfig().getProto() + "://" + getConsumerWebviewConfig().getBaseUrl() + (getConsumerWebviewConfig().getPort() != null ? kotlin.jvm.internal.m.o(":", getConsumerWebviewConfig().getPort()) : "");
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie == null) {
            return;
        }
        K0 = kotlin.l0.y.K0(cookie, new String[]{";"}, false, 0, 6, null);
        for (String str2 : K0) {
            K02 = kotlin.l0.y.K0(str2, new String[]{"="}, false, 0, 6, null);
            cookieManager.setCookie(str, kotlin.jvm.internal.m.o((String) K02.get(0), "=;"));
        }
        cookieManager.flush();
    }

    public static /* synthetic */ void d(ConsumerOnboardingWebView consumerOnboardingWebView, Throwable th) {
        m1039start$lambda3(consumerOnboardingWebView, th);
    }

    private final void setCBVersionCookie(ValueCallback<Boolean> valueCallback) {
        CookieManager.getInstance().setCookie(getConsumerWebviewConfig().getProto() + "://" + getConsumerWebviewConfig().getBaseUrl(), "CB-CLIENT=" + ((Object) getCoinbaseApi().getPackageVersionName()) + "; path=/", valueCallback);
    }

    /* renamed from: start$lambda-1 */
    public static final kotlin.x m1036start$lambda1(ConsumerOnboardingWebView this$0, final String url) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(url, "url");
        this$0.setCBVersionCookie(new ValueCallback() { // from class: com.coinbase.wallet.consumer.views.h
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                ConsumerOnboardingWebView.b(ConsumerOnboardingWebView.this, url, (Boolean) obj);
            }
        });
        return kotlin.x.a;
    }

    /* renamed from: start$lambda-1$lambda-0 */
    public static final void m1037start$lambda1$lambda0(ConsumerOnboardingWebView this$0, String url, Boolean bool) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(url, "$url");
        this$0.loadUrl(url);
    }

    /* renamed from: start$lambda-2 */
    public static final h.c.x m1038start$lambda2(ConsumerOnboardingWebView this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.getConsumerWebViewClient().getConnectionStatus();
    }

    /* renamed from: start$lambda-3 */
    public static final void m1039start$lambda3(ConsumerOnboardingWebView this$0, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.clearCookies();
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final Coinbase getCoinbaseApi() {
        Coinbase coinbase = this.coinbaseApi;
        if (coinbase != null) {
            return coinbase;
        }
        kotlin.jvm.internal.m.w("coinbaseApi");
        throw null;
    }

    public final ConsumerUserRepository getConsumerUserRepository() {
        ConsumerUserRepository consumerUserRepository = this.consumerUserRepository;
        if (consumerUserRepository != null) {
            return consumerUserRepository;
        }
        kotlin.jvm.internal.m.w("consumerUserRepository");
        throw null;
    }

    public final ConsumerWebViewClient getConsumerWebViewClient() {
        ConsumerWebViewClient consumerWebViewClient = this.consumerWebViewClient;
        if (consumerWebViewClient != null) {
            return consumerWebViewClient;
        }
        kotlin.jvm.internal.m.w("consumerWebViewClient");
        throw null;
    }

    public final ConsumerWebViewConfig getConsumerWebviewConfig() {
        ConsumerWebViewConfig consumerWebViewConfig = this.consumerWebviewConfig;
        if (consumerWebViewConfig != null) {
            return consumerWebViewConfig;
        }
        kotlin.jvm.internal.m.w("consumerWebviewConfig");
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearCookies();
        getConsumerWebViewClient().onHide();
    }

    public final void setCoinbaseApi(Coinbase coinbase) {
        kotlin.jvm.internal.m.g(coinbase, "<set-?>");
        this.coinbaseApi = coinbase;
    }

    public final void setConsumerUserRepository(ConsumerUserRepository consumerUserRepository) {
        kotlin.jvm.internal.m.g(consumerUserRepository, "<set-?>");
        this.consumerUserRepository = consumerUserRepository;
    }

    public final void setConsumerWebViewClient(ConsumerWebViewClient consumerWebViewClient) {
        kotlin.jvm.internal.m.g(consumerWebViewClient, "<set-?>");
        this.consumerWebViewClient = consumerWebViewClient;
    }

    public final void setConsumerWebviewConfig(ConsumerWebViewConfig consumerWebViewConfig) {
        kotlin.jvm.internal.m.g(consumerWebViewConfig, "<set-?>");
        this.consumerWebviewConfig = consumerWebViewConfig;
    }

    public final h.c.s<ConsumerWebViewClient.ConnectionStatus> start() {
        setWebViewClient(getConsumerWebViewClient());
        h.c.s<ConsumerWebViewClient.ConnectionStatus> doOnError = getConsumerUserRepository().generateAuthRequest().map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.views.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerOnboardingWebView.c(ConsumerOnboardingWebView.this, (String) obj);
            }
        }).flatMapObservable(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.views.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerOnboardingWebView.a(ConsumerOnboardingWebView.this, (kotlin.x) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.views.j
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ConsumerOnboardingWebView.d(ConsumerOnboardingWebView.this, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnError, "consumerUserRepository.generateAuthRequest()\n            .map { url ->\n                setCBVersionCookie { loadUrl(url) }\n            }\n            .flatMapObservable { consumerWebViewClient.connectionStatus }\n            .doOnError { clearCookies() }");
        return doOnError;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerOnboardingWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.g(context, "context");
        getSettings().setJavaScriptEnabled(true);
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setDomStorageEnabled(false);
        clearCache(true);
        getSettings().setAppCacheEnabled(false);
        getSettings().setCacheMode(2);
    }
}