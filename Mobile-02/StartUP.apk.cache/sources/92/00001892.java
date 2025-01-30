package com.coinbase.wallet.consumer.views;

import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.consumer.BuildConfig;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ConsumerWebViewClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u000212B\u0007¢\u0006\u0004\b0\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0011\u0010\u0015J#\u0010\u0016\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R$\u0010.\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u001b0\u001b0,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient;", "Landroid/webkit/WebViewClient;", "Landroid/net/Uri;", "uri", "Lkotlin/x;", "emitAnalyticsEvent", "(Landroid/net/Uri;)V", "", "isOauthCompletionUrl", "(Landroid/net/Uri;)Z", "Lh/c/k0/b;", "completeOauth", "(Landroid/net/Uri;)Lh/c/k0/b;", "Landroid/webkit/WebView;", "view", "", "url", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Landroid/webkit/WebResourceRequest;", "request", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "onHide", "()V", "Lh/c/s;", "Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient$ConnectionStatus;", "connectionStatus", "Lh/c/s;", "getConnectionStatus", "()Lh/c/s;", "loaded", "Z", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "consumerUserRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "getConsumerUserRepository", "()Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "setConsumerUserRepository", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;)V", "Lh/c/k0/a;", "disposableBag", "Lh/c/k0/a;", "Lh/c/v0/a;", "kotlin.jvm.PlatformType", "connectionStatusSubject", "Lh/c/v0/a;", "<init>", "ConnectState", "ConnectionStatus", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerWebViewClient extends WebViewClient {
    private final h.c.s<ConnectionStatus> connectionStatus;
    private final h.c.v0.a<ConnectionStatus> connectionStatusSubject;
    public ConsumerUserRepository consumerUserRepository;
    private final h.c.k0.a disposableBag;
    private boolean loaded;

    /* compiled from: ConsumerWebViewClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient$ConnectState;", "", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SignInStep", "TwoFACodeStep", "AuthorizePermissionsStep", "ThreeFAEmailStep", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public enum ConnectState {
        SignInStep("https://www.coinbase.com/oauth/authorize/oauth_signin"),
        TwoFACodeStep("https://www.coinbase.com/signin_step_two"),
        AuthorizePermissionsStep("https://www.coinbase.com/oauth/authorize"),
        ThreeFAEmailStep("https://www.coinbase.com/device_confirmations");
        
        private final String url;

        ConnectState(String str) {
            this.url = str;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: ConsumerWebViewClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient$ConnectionStatus;", "", "<init>", "()V", "Connected", "Loaded", "Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient$ConnectionStatus$Loaded;", "Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient$ConnectionStatus$Connected;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static abstract class ConnectionStatus {

        /* compiled from: ConsumerWebViewClient.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient$ConnectionStatus$Connected;", "Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient$ConnectionStatus;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Connected extends ConnectionStatus {
            public static final Connected INSTANCE = new Connected();

            private Connected() {
                super(null);
            }
        }

        /* compiled from: ConsumerWebViewClient.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient$ConnectionStatus$Loaded;", "Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient$ConnectionStatus;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Loaded extends ConnectionStatus {
            public static final Loaded INSTANCE = new Loaded();

            private Loaded() {
                super(null);
            }
        }

        private ConnectionStatus() {
        }

        public /* synthetic */ ConnectionStatus(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ConsumerWebViewClient() {
        h.c.v0.a<ConnectionStatus> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create<ConnectionStatus>()");
        this.connectionStatusSubject = d2;
        h.c.s<ConnectionStatus> distinctUntilChanged = d2.hide().distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged, "connectionStatusSubject.hide().distinctUntilChanged()");
        this.connectionStatus = distinctUntilChanged;
        this.disposableBag = new h.c.k0.a();
    }

    public static /* synthetic */ void a(ConsumerWebViewClient consumerWebViewClient, h.c.k0.b bVar) {
        m1046completeOauth$lambda0(consumerWebViewClient, bVar);
    }

    public static /* synthetic */ void b(ConsumerWebViewClient consumerWebViewClient, Throwable th) {
        m1047completeOauth$lambda1(consumerWebViewClient, th);
    }

    private final h.c.k0.b completeOauth(Uri uri) {
        h.c.k0.b subscribe = getConsumerUserRepository().getAccessToken(uri).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.views.q
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ConsumerWebViewClient.a(ConsumerWebViewClient.this, (h.c.k0.b) obj);
            }
        }, new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.views.r
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ConsumerWebViewClient.b(ConsumerWebViewClient.this, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(subscribe, "consumerUserRepository.getAccessToken(uri)\n        .subscribe({\n            connectionStatusSubject.onNext(ConnectionStatus.Connected)\n        }, {\n            connectionStatusSubject.onError(it)\n        })");
        return h.c.t0.a.a(subscribe, this.disposableBag);
    }

    /* renamed from: completeOauth$lambda-0 */
    public static final void m1046completeOauth$lambda0(ConsumerWebViewClient this$0, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.connectionStatusSubject.onNext(ConnectionStatus.Connected.INSTANCE);
    }

    /* renamed from: completeOauth$lambda-1 */
    public static final void m1047completeOauth$lambda1(ConsumerWebViewClient this$0, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.connectionStatusSubject.onError(th);
    }

    private final void emitAnalyticsEvent(Uri uri) {
        boolean V;
        boolean V2;
        boolean V3;
        boolean V4;
        String uri2 = uri.toString();
        kotlin.jvm.internal.m.f(uri2, "uri.toString()");
        V = kotlin.l0.y.V(uri2, ConnectState.SignInStep.getUrl(), false, 2, null);
        if (V) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.oauthSignInLanded(AnalyticsEvent.Companion));
            return;
        }
        V2 = kotlin.l0.y.V(uri2, ConnectState.TwoFACodeStep.getUrl(), false, 2, null);
        if (V2) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.oauthTwoFaLanded(AnalyticsEvent.Companion));
            return;
        }
        V3 = kotlin.l0.y.V(uri2, ConnectState.ThreeFAEmailStep.getUrl(), false, 2, null);
        if (V3) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.oauthVerifyEmailLanded(AnalyticsEvent.Companion));
            return;
        }
        V4 = kotlin.l0.y.V(uri2, ConnectState.AuthorizePermissionsStep.getUrl(), false, 2, null);
        if (V4) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.oauthAllowAccessLanded(AnalyticsEvent.Companion));
        }
    }

    private final boolean isOauthCompletionUrl(Uri uri) {
        boolean Q;
        String uri2 = uri.toString();
        kotlin.jvm.internal.m.f(uri2, "uri.toString()");
        Q = kotlin.l0.x.Q(uri2, BuildConfig.REDIRECT_URI, false, 2, null);
        return (!Q || uri.getQueryParameter("code") == null || uri.getQueryParameter(ApiConstants.STATE) == null) ? false : true;
    }

    public final h.c.s<ConnectionStatus> getConnectionStatus() {
        return this.connectionStatus;
    }

    public final ConsumerUserRepository getConsumerUserRepository() {
        ConsumerUserRepository consumerUserRepository = this.consumerUserRepository;
        if (consumerUserRepository != null) {
            return consumerUserRepository;
        }
        kotlin.jvm.internal.m.w("consumerUserRepository");
        throw null;
    }

    public final void onHide() {
        this.disposableBag.d();
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (!this.loaded) {
            this.connectionStatusSubject.onNext(ConnectionStatus.Loaded.INSTANCE);
        }
        this.loaded = true;
    }

    public final void setConsumerUserRepository(ConsumerUserRepository consumerUserRepository) {
        kotlin.jvm.internal.m.g(consumerUserRepository, "<set-?>");
        this.consumerUserRepository = consumerUserRepository;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (Build.VERSION.SDK_INT > 23) {
            return false;
        }
        l.a.a.a(kotlin.jvm.internal.m.o("In shouldOverrideUrlLoading request ", str), new Object[0]);
        Uri uri = Uri.parse(str);
        kotlin.jvm.internal.m.f(uri, "uri");
        emitAnalyticsEvent(uri);
        if (isOauthCompletionUrl(uri)) {
            completeOauth(uri);
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        l.a.a.a(kotlin.jvm.internal.m.o("In shouldOverrideUrlLoading request ", webResourceRequest == null ? null : webResourceRequest.getUrl()), new Object[0]);
        Uri url = webResourceRequest != null ? webResourceRequest.getUrl() : null;
        if (url == null) {
            return false;
        }
        emitAnalyticsEvent(url);
        if (isOauthCompletionUrl(url)) {
            completeOauth(url);
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}