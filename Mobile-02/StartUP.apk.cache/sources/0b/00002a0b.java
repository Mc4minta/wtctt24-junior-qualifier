package com.coinbase.walletengine;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.walletengine.extensions.TraceKey_WalletEngineKt;
import com.coinbase.walletengine.models.CallMessage;
import com.coinbase.walletengine.models.WalletEngineConfig;
import h.c.a0;
import h.c.b0;
import h.c.d0;
import h.c.f0;
import h.c.h0;
import h.c.m0.n;
import j.e0;
import j.q;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.apache.http.message.TokenParser;
import org.apache.http.protocol.HTTP;

/* compiled from: WalletEngine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u0010\u0018J\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+RD\u0010/\u001a*\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070-0,j\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070-`.8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/coinbase/walletengine/WalletEngine;", "", "Lh/c/b0;", "onReady", "()Lh/c/b0;", "Landroid/content/Context;", "context", "", "bundleHtml", "Lkotlin/x;", "initializeWebView", "(Landroid/content/Context;Ljava/lang/String;)V", "bundleJs", "configJson", "buildBundleHTML", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "applicationContext", "Lcom/coinbase/walletengine/models/WalletEngineConfig;", "config", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "initialize", "(Landroid/content/Context;Lcom/coinbase/walletengine/models/WalletEngineConfig;Lcom/coinbase/wallet/core/interfaces/Tracing;)V", "destroy", "()V", "service", "method", "paramsJSON", "call", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/walletengine/models/WalletEngineConfig;", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "", "nextCallId", "I", "Lh/c/a0;", "callbackScheduler", "Lh/c/a0;", "Landroid/webkit/WebView;", "webView", "Landroid/webkit/WebView;", "Lh/c/v0/a;", "readySubject", "Lh/c/v0/a;", "Ljava/util/HashMap;", "Lh/c/d0;", "Lkotlin/collections/HashMap;", "callMap", "Ljava/util/HashMap;", "getCallMap$wallet_engine_release", "()Ljava/util/HashMap;", "<init>", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class WalletEngine {
    private final HashMap<Integer, d0<String>> callMap;
    private final a0 callbackScheduler;
    private WalletEngineConfig config;
    private int nextCallId;
    private h.c.v0.a<WalletEngine> readySubject;
    private Tracing tracer;
    private WebView webView;

    public WalletEngine() {
        a0 c2 = h.c.u0.a.c();
        m.f(c2, "io()");
        this.callbackScheduler = c2;
        this.readySubject = h.c.v0.a.d();
        this.callMap = new HashMap<>();
    }

    public static /* synthetic */ void a(WalletEngine walletEngine, Context context, String str) {
        m1922initialize$lambda1(walletEngine, context, str);
    }

    public static final /* synthetic */ h.c.v0.a access$getReadySubject$p(WalletEngine walletEngine) {
        return walletEngine.readySubject;
    }

    public static /* synthetic */ void b(WalletEngine walletEngine, String str, String str2, String str3, d0 d0Var) {
        m1921call$lambda3$lambda2(walletEngine, str, str2, str3, d0Var);
    }

    private final String buildBundleHTML(String str, String str2) {
        if (this.config != null) {
            return "\n        <!DOCTYPE html>\n        <html lang='en'>\n          <head>\n            <meta charset='utf-8'>\n            <title>WalletEngine</title>\n          </head>\n          <body>\n            <script>\n              //<![CDATA[\n              " + str + "\n              //]]>\n            </script>\n            <script>window.walletEngine = new WalletEngine(" + str2 + ")</script>\n          </body>\n        </html>\n        ";
        }
        throw new RuntimeException("config should not be null");
    }

    public static /* synthetic */ h0 c(WalletEngine walletEngine, String str, String str2, String str3, WalletEngine walletEngine2) {
        return m1920call$lambda3(walletEngine, str, str2, str3, walletEngine2);
    }

    /* renamed from: call$lambda-3 */
    public static final h0 m1920call$lambda3(WalletEngine this$0, final String service, final String method, final String paramsJSON, WalletEngine it) {
        m.g(this$0, "this$0");
        m.g(service, "$service");
        m.g(method, "$method");
        m.g(paramsJSON, "$paramsJSON");
        m.g(it, "it");
        return b0.create(new f0() { // from class: com.coinbase.walletengine.b
            @Override // h.c.f0
            public final void subscribe(d0 d0Var) {
                WalletEngine.b(WalletEngine.this, service, method, paramsJSON, d0Var);
            }
        });
    }

    /* renamed from: call$lambda-3$lambda-2 */
    public static final void m1921call$lambda3$lambda2(WalletEngine this$0, String service, String method, String paramsJSON, d0 emitter) {
        m.g(this$0, "this$0");
        m.g(service, "$service");
        m.g(method, "$method");
        m.g(paramsJSON, "$paramsJSON");
        m.g(emitter, "emitter");
        int i2 = this$0.nextCallId;
        this$0.nextCallId = i2 + 1;
        this$0.getCallMap$wallet_engine_release().put(Integer.valueOf(i2), emitter);
        Tracing tracing = this$0.tracer;
        if (tracing != null) {
            TraceKey.Companion companion = TraceKey.Companion;
            tracing.start(TraceKey_WalletEngineKt.callTrace(companion, i2, service + TokenParser.SP + method));
            String json = CallMessage.Companion.getJsonAdapter$wallet_engine_release().toJson(new CallMessage(i2, service, method, paramsJSON));
            try {
                WebView webView = this$0.webView;
                m.e(webView);
                webView.evaluateJavascript("window.walletEngine.call(" + ((Object) json) + ')', null);
                return;
            } catch (Throwable th) {
                this$0.getCallMap$wallet_engine_release().remove(Integer.valueOf(i2));
                emitter.onError(th);
                return;
            }
        }
        m.w("tracer");
        throw null;
    }

    /* renamed from: initialize$lambda-1 */
    public static final void m1922initialize$lambda1(WalletEngine this$0, Context applicationContext, String bundleHtml) {
        m.g(this$0, "this$0");
        m.g(applicationContext, "$applicationContext");
        m.g(bundleHtml, "$bundleHtml");
        this$0.initializeWebView(applicationContext, bundleHtml);
    }

    private final void initializeWebView(Context context, String str) {
        WebView webView = new WebView(context);
        WebSettings settings = webView.getSettings();
        settings.setDatabaseEnabled(false);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(2);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        webView.setWebViewClient(new WebViewClient() { // from class: com.coinbase.walletengine.WalletEngine$initializeWebView$1$2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str2) {
                h.c.v0.a access$getReadySubject$p = WalletEngine.access$getReadySubject$p(WalletEngine.this);
                if (access$getReadySubject$p == null) {
                    return;
                }
                access$getReadySubject$p.onNext(WalletEngine.this);
            }
        });
        Tracing tracing = this.tracer;
        if (tracing != null) {
            webView.addJavascriptInterface(new WalletEngineJavaScriptInterface(this, tracing), "__BRIDGE__");
            webView.loadDataWithBaseURL("about:walletEngine", str, "text/html", "UTF-8", "about:walletEngine");
            x xVar = x.a;
            this.webView = webView;
            return;
        }
        m.w("tracer");
        throw null;
    }

    private final b0<WalletEngine> onReady() {
        h.c.v0.a<WalletEngine> aVar = this.readySubject;
        b0<WalletEngine> firstOrError = aVar == null ? null : aVar.firstOrError();
        if (firstOrError == null) {
            b0<WalletEngine> error = b0.error(new WalletEngineException("bridge destroyed"));
            m.f(error, "error(WalletEngineException(\"bridge destroyed\"))");
            return error;
        }
        return firstOrError;
    }

    public b0<String> call(final String service, final String method, final String paramsJSON) {
        m.g(service, "service");
        m.g(method, "method");
        m.g(paramsJSON, "paramsJSON");
        b0<String> observeOn = onReady().flatMap(new n() { // from class: com.coinbase.walletengine.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletEngine.c(WalletEngine.this, service, method, paramsJSON, (WalletEngine) obj);
            }
        }).subscribeOn(h.c.j0.c.a.b()).observeOn(this.callbackScheduler);
        m.f(observeOn, "onReady()\n        .flatMap {\n            Single.create<String> { emitter ->\n                val id = nextCallId++\n                callMap[id] = emitter\n                tracer.start(TraceKey.callTrace(id, \"$service $method\"))\n\n                val json = CallMessage.jsonAdapter.toJson(CallMessage(id, service, method, paramsJSON))\n\n                try {\n                    webView!!.evaluateJavascript(\"window.walletEngine.call($json)\", null)\n                } catch (t: Throwable) {\n                    callMap.remove(id)\n                    emitter.onError(t)\n                }\n            }\n        }\n        .subscribeOn(AndroidSchedulers.mainThread())\n        .observeOn(callbackScheduler)");
        return observeOn;
    }

    public void destroy() {
        this.readySubject = null;
        this.callMap.clear();
        WebView webView = this.webView;
        if (webView != null) {
            webView.loadDataWithBaseURL("about:blank", "", HTTP.PLAIN_TEXT_TYPE, "UTF-8", "about:blank");
        }
        this.webView = null;
    }

    public final HashMap<Integer, d0<String>> getCallMap$wallet_engine_release() {
        return this.callMap;
    }

    public synchronized void initialize(final Context applicationContext, WalletEngineConfig config, Tracing tracer) {
        m.g(applicationContext, "applicationContext");
        m.g(config, "config");
        m.g(tracer, "tracer");
        if (this.webView == null && this.readySubject != null) {
            this.config = config;
            this.tracer = tracer;
            InputStream openRawResource = applicationContext.getResources().openRawResource(R.raw.walletengine);
            m.f(openRawResource, "applicationContext.resources.openRawResource(R.raw.walletengine)");
            e0 k2 = q.k(openRawResource);
            String G0 = q.d(k2).G0();
            kotlin.io.a.a(k2, null);
            String configJson = WalletEngineConfig.Companion.getJsonAdapter$wallet_engine_release().toJson(config);
            m.f(configJson, "configJson");
            final String buildBundleHTML = buildBundleHTML(G0, configJson);
            new Handler(applicationContext.getMainLooper()).post(new Runnable() { // from class: com.coinbase.walletengine.a
                @Override // java.lang.Runnable
                public final void run() {
                    WalletEngine.a(WalletEngine.this, applicationContext, buildBundleHTML);
                }
            });
        }
    }
}