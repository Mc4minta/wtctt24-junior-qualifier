package com.coinbase.ciphercore;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.coinbase.ciphercore.extensions.SafeTrace_CipherCoreKt;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import h.c.b0;
import h.c.d0;
import h.c.f0;
import h.c.h0;
import j.e0;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;

/* compiled from: CipherCoreBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001:\u00019B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b7\u00108J\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0011\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R>\u0010\u001d\u001a*\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001b0\u0019j\u0014\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001b`\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010\u000b\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010$R$\u0010'\u001a\u0010\u0012\f\u0012\n &*\u0004\u0018\u00010\u00000\u00000%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00101\u001a\n &*\u0004\u0018\u000100008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002050)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010,¨\u0006:"}, d2 = {"Lcom/coinbase/ciphercore/CipherCoreBridge;", "", "Lh/c/b0;", "onReady", "()Lh/c/b0;", "Landroid/content/Context;", "context", "", "buildBundleHTML", "(Landroid/content/Context;)Ljava/lang/String;", "Lcom/coinbase/ciphercore/CipherCoreConfig;", "config", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lkotlin/x;", "initialize", "(Landroid/content/Context;Lcom/coinbase/ciphercore/CipherCoreConfig;Lcom/coinbase/wallet/core/interfaces/Tracing;)V", "method", "", "params", "call", "(Ljava/lang/String;Ljava/util/List;)Lh/c/b0;", "Landroid/webkit/WebView;", "webView", "Landroid/webkit/WebView;", "Ljava/util/HashMap;", "", "Lh/c/d0;", "Lkotlin/collections/HashMap;", "callMap", "Ljava/util/HashMap;", "Lcom/coinbase/ciphercore/CipherCoreConfig;", "getConfig$cipher_core_release", "()Lcom/coinbase/ciphercore/CipherCoreConfig;", "setConfig$cipher_core_release", "(Lcom/coinbase/ciphercore/CipherCoreConfig;)V", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "Lh/c/v0/a;", "kotlin.jvm.PlatformType", "readySubject", "Lh/c/v0/a;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/ciphercore/ResultMessage;", "resultMessageAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lh/c/a0;", "callbackScheduler", "Lh/c/a0;", "Lcom/squareup/moshi/Moshi;", "moshi", "Lcom/squareup/moshi/Moshi;", "nextCallId", "I", "Lcom/coinbase/ciphercore/CallMessage;", "callMessageAdapter", "<init>", "(Lcom/coinbase/wallet/core/interfaces/Tracing;)V", "CipherCoreJSInterface", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class CipherCoreBridge {
    private final HashMap<Integer, d0<String>> callMap;
    private final JsonAdapter<CallMessage> callMessageAdapter;
    private final h.c.a0 callbackScheduler;
    private CipherCoreConfig config;
    private final Moshi moshi;
    private int nextCallId;
    private final h.c.v0.a<CipherCoreBridge> readySubject;
    private final JsonAdapter<ResultMessage> resultMessageAdapter;
    private final Tracing tracer;
    private WebView webView;

    /* compiled from: CipherCoreBridge.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/coinbase/ciphercore/CipherCoreBridge$CipherCoreJSInterface;", "", "", "json", "Lkotlin/x;", "postMessage", "(Ljava/lang/String;)V", "Lcom/coinbase/ciphercore/CipherCoreBridge;", "bridge", "Lcom/coinbase/ciphercore/CipherCoreBridge;", "getBridge", "()Lcom/coinbase/ciphercore/CipherCoreBridge;", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "<init>", "(Lcom/coinbase/ciphercore/CipherCoreBridge;Lcom/coinbase/wallet/core/interfaces/Tracing;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class CipherCoreJSInterface {
        private final CipherCoreBridge bridge;
        private final Tracing tracer;

        public CipherCoreJSInterface(CipherCoreBridge bridge, Tracing tracer) {
            kotlin.jvm.internal.m.g(bridge, "bridge");
            kotlin.jvm.internal.m.g(tracer, "tracer");
            this.bridge = bridge;
            this.tracer = tracer;
        }

        public final CipherCoreBridge getBridge() {
            return this.bridge;
        }

        @JavascriptInterface
        public final void postMessage(String json) {
            kotlin.jvm.internal.m.g(json, "json");
            try {
                ResultMessage resultMessage = (ResultMessage) this.bridge.resultMessageAdapter.fromJson(json);
                if (resultMessage == null) {
                    return;
                }
                this.tracer.stop(SafeTrace_CipherCoreKt.cipherCoreBridgeCallTrace$default(Tracing.Companion, resultMessage.getId(), null, 2, null));
                d0 d0Var = (d0) getBridge().callMap.remove(Integer.valueOf(resultMessage.getId()));
                if (d0Var == null || d0Var.isDisposed()) {
                    return;
                }
                String error = resultMessage.getError();
                if (error != null) {
                    d0Var.onError(new CipherCoreBridgeException(error));
                }
                d0Var.onSuccess(resultMessage.getValue());
            } catch (Throwable unused) {
            }
        }
    }

    public CipherCoreBridge(Tracing tracer) {
        kotlin.jvm.internal.m.g(tracer, "tracer");
        this.tracer = tracer;
        h.c.a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.callbackScheduler = c2;
        this.callMap = new HashMap<>();
        h.c.v0.a<CipherCoreBridge> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create<CipherCoreBridge>()");
        this.readySubject = d2;
        this.config = new CipherCoreConfig(new EthereumConfig(new LinkedHashMap()));
        Moshi moshi = new Moshi.Builder().add(Date.class, new Rfc3339DateJsonAdapter()).build();
        this.moshi = moshi;
        kotlin.jvm.internal.m.f(moshi, "moshi");
        this.callMessageAdapter = new CallMessageJsonAdapter(moshi);
        kotlin.jvm.internal.m.f(moshi, "moshi");
        this.resultMessageAdapter = new ResultMessageJsonAdapter(moshi);
    }

    public static /* synthetic */ void a(CipherCoreBridge cipherCoreBridge, Context context, Tracing tracing, String str) {
        m602initialize$lambda2(cipherCoreBridge, context, tracing, str);
    }

    public static final /* synthetic */ h.c.v0.a access$getReadySubject$p(CipherCoreBridge cipherCoreBridge) {
        return cipherCoreBridge.readySubject;
    }

    public static /* synthetic */ h0 b(CipherCoreBridge cipherCoreBridge, String str, List list, CipherCoreBridge cipherCoreBridge2) {
        return m600call$lambda5(cipherCoreBridge, str, list, cipherCoreBridge2);
    }

    private final String buildBundleHTML(Context context) {
        String K;
        InputStream openRawResource = context.getResources().openRawResource(R.raw.ciphercore);
        kotlin.jvm.internal.m.f(openRawResource, "context.resources.openRawResource(R.raw.ciphercore)");
        e0 k2 = j.q.k(openRawResource);
        try {
            String G0 = j.q.d(k2).G0();
            kotlin.io.a.a(k2, null);
            Moshi moshi = this.moshi;
            kotlin.jvm.internal.m.f(moshi, "moshi");
            String json = new CipherCoreConfigJsonAdapter(moshi).toJson(this.config);
            kotlin.jvm.internal.m.f(json, "CipherCoreConfigJsonAdapter(moshi)\n            .toJson(config)");
            K = kotlin.l0.x.K(json, "//]]>", "", false, 4, null);
            return "\n        <!DOCTYPE html>\n        <html lang='en'>\n          <head>\n            <meta charset='utf-8'>\n            <title>CipherCore</title>\n          </head>\n          <body>\n            <script>\n              //<![CDATA[\n              " + G0 + "\n              //]]>\n            </script>\n            <script>\n              //<![CDATA[\n              window.bridge = new CipherCoreBridge(" + K + ")\n              //]]>\n            </script>\n          </body>\n        </html>\n        ";
        } finally {
        }
    }

    public static /* synthetic */ void c(CipherCoreBridge cipherCoreBridge, String str, List list, d0 d0Var) {
        m601call$lambda5$lambda4(cipherCoreBridge, str, list, d0Var);
    }

    /* renamed from: call$lambda-5 */
    public static final h0 m600call$lambda5(CipherCoreBridge this$0, final String method, final List params, CipherCoreBridge it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(method, "$method");
        kotlin.jvm.internal.m.g(params, "$params");
        kotlin.jvm.internal.m.g(it, "it");
        return b0.create(new f0() { // from class: com.coinbase.ciphercore.a0
            @Override // h.c.f0
            public final void subscribe(d0 d0Var) {
                CipherCoreBridge.c(CipherCoreBridge.this, method, params, d0Var);
            }
        }).subscribeOn(h.c.j0.c.a.b()).observeOn(this$0.callbackScheduler);
    }

    /* renamed from: call$lambda-5$lambda-4 */
    public static final void m601call$lambda5$lambda4(CipherCoreBridge this$0, String method, List params, d0 emitter) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(method, "$method");
        kotlin.jvm.internal.m.g(params, "$params");
        kotlin.jvm.internal.m.g(emitter, "emitter");
        int i2 = this$0.nextCallId;
        this$0.nextCallId = i2 + 1;
        this$0.tracer.start(SafeTrace_CipherCoreKt.cipherCoreBridgeCallTrace(Tracing.Companion, i2, method));
        this$0.callMap.put(Integer.valueOf(i2), emitter);
        String json = this$0.callMessageAdapter.toJson(new CallMessage(i2, method, params));
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                WebView webView = this$0.webView;
                kotlin.jvm.internal.m.e(webView);
                webView.evaluateJavascript("window.bridge.call(" + ((Object) json) + ')', null);
            } else {
                WebView webView2 = this$0.webView;
                kotlin.jvm.internal.m.e(webView2);
                webView2.loadUrl("javascript:window.bridge.call(" + ((Object) json) + ')');
            }
        } catch (Throwable th) {
            this$0.callMap.remove(Integer.valueOf(i2));
            this$0.tracer.stop(SafeTrace_CipherCoreKt.cipherCoreBridgeCallTrace(Tracing.Companion, i2, method));
            emitter.onError(th);
        }
    }

    /* renamed from: initialize$lambda-2 */
    public static final void m602initialize$lambda2(CipherCoreBridge this$0, Context context, Tracing tracer, String bundleHtml) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(context, "$context");
        kotlin.jvm.internal.m.g(tracer, "$tracer");
        kotlin.jvm.internal.m.g(bundleHtml, "$bundleHtml");
        WebView webView = new WebView(context);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setAllowFileAccess(false);
        webView.setWebViewClient(new WebViewClient() { // from class: com.coinbase.ciphercore.CipherCoreBridge$initialize$1$1$2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                CipherCoreBridge.access$getReadySubject$p(CipherCoreBridge.this).onNext(CipherCoreBridge.this);
            }
        });
        webView.addJavascriptInterface(new CipherCoreJSInterface(this$0, tracer), "cipherCore");
        webView.loadDataWithBaseURL("about:cipherCore", bundleHtml, "text/html", "UTF-8", "about:cipherCore");
        kotlin.x xVar = kotlin.x.a;
        this$0.webView = webView;
    }

    private final b0<CipherCoreBridge> onReady() {
        b0<CipherCoreBridge> firstOrError = this.readySubject.firstOrError();
        kotlin.jvm.internal.m.f(firstOrError, "readySubject.firstOrError()");
        return firstOrError;
    }

    public b0<String> call(final String method, final List<String> params) {
        kotlin.jvm.internal.m.g(method, "method");
        kotlin.jvm.internal.m.g(params, "params");
        b0 flatMap = onReady().flatMap(new h.c.m0.n() { // from class: com.coinbase.ciphercore.z
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCoreBridge.b(CipherCoreBridge.this, method, params, (CipherCoreBridge) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "onReady()\n        .flatMap {\n            Single\n                .create<String> { emitter ->\n                    val id = nextCallId++\n                    tracer.start(Tracing.cipherCoreBridgeCallTrace(id, method))\n                    callMap[id] = emitter\n\n                    val json = callMessageAdapter.toJson(CallMessage(id, method, params))\n\n                    try {\n                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {\n                            webView!!.evaluateJavascript(\"window.bridge.call($json)\", null)\n                        } else {\n                            webView!!.loadUrl(\"javascript:window.bridge.call($json)\")\n                        }\n                    } catch (t: Throwable) {\n                        callMap.remove(id)\n                        tracer.stop(Tracing.cipherCoreBridgeCallTrace(id, method))\n                        emitter.onError(t)\n                    }\n                }\n                .subscribeOn(AndroidSchedulers.mainThread())\n                .observeOn(callbackScheduler)\n        }");
        return flatMap;
    }

    public final CipherCoreConfig getConfig$cipher_core_release() {
        return this.config;
    }

    public final synchronized void initialize(final Context context, CipherCoreConfig config, final Tracing tracer) {
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(config, "config");
        kotlin.jvm.internal.m.g(tracer, "tracer");
        if (this.webView != null) {
            return;
        }
        this.config = config;
        final String buildBundleHTML = buildBundleHTML(context);
        new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.coinbase.ciphercore.y
            @Override // java.lang.Runnable
            public final void run() {
                CipherCoreBridge.a(CipherCoreBridge.this, context, tracer, buildBundleHTML);
            }
        });
    }

    public final void setConfig$cipher_core_release(CipherCoreConfig cipherCoreConfig) {
        kotlin.jvm.internal.m.g(cipherCoreConfig, "<set-?>");
        this.config = cipherCoreConfig;
    }
}