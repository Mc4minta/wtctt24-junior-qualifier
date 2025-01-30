package com.reactnativecommunity.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Environment;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.i0;
import com.facebook.react.views.scroll.h;
import com.facebook.react.views.scroll.i;
import com.reactnativecommunity.webview.RNCWebViewModule;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.cookie.SM;
import org.json.JSONException;
import org.json.JSONObject;
import org.spongycastle.i18n.MessageBundle;

@e.f.m.x.a.a(name = "RNCWebView")
/* loaded from: classes2.dex */
public class RNCWebViewManager extends SimpleViewManager<WebView> {
    protected static final String BLANK_URL = "about:blank";
    public static final int COMMAND_CLEAR_CACHE = 1001;
    public static final int COMMAND_CLEAR_FORM_DATA = 1000;
    public static final int COMMAND_CLEAR_HISTORY = 1002;
    public static final int COMMAND_FOCUS = 8;
    public static final int COMMAND_GO_BACK = 1;
    public static final int COMMAND_GO_FORWARD = 2;
    public static final int COMMAND_INJECT_JAVASCRIPT = 6;
    public static final int COMMAND_LOAD_URL = 7;
    public static final int COMMAND_POST_MESSAGE = 5;
    public static final int COMMAND_RELOAD = 3;
    public static final int COMMAND_STOP_LOADING = 4;
    protected static final String HTML_ENCODING = "UTF-8";
    protected static final String HTML_MIME_TYPE = "text/html";
    protected static final String HTTP_METHOD_POST = "POST";
    protected static final String JAVASCRIPT_INTERFACE = "ReactNativeWebView";
    protected static final String REACT_CLASS = "RNCWebView";
    protected static final int SHOULD_OVERRIDE_URL_LOADING_TIMEOUT = 250;
    private static final String TAG = "RNCWebViewManager";
    protected boolean mAllowsFullscreenVideo;
    protected String mUserAgent;
    protected String mUserAgentWithApplicationName;
    protected e mWebChromeClient;
    protected com.reactnativecommunity.webview.b mWebViewConfig;

    /* loaded from: classes2.dex */
    class a implements com.reactnativecommunity.webview.b {
        a() {
        }

        @Override // com.reactnativecommunity.webview.b
        public void a(WebView webView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements DownloadListener {
        final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i0 f10747b;

        b(f fVar, i0 i0Var) {
            this.a = fVar;
            this.f10747b = i0Var;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            this.a.setIgnoreErrFailedForThisURL(str);
            RNCWebViewModule module = RNCWebViewManager.getModule(this.f10747b);
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            String guessFileName = URLUtil.guessFileName(str, str3, str4);
            String str5 = "Downloading " + guessFileName;
            try {
                URL url = new URL(str);
                request.addRequestHeader(SM.COOKIE, CookieManager.getInstance().getCookie(url.getProtocol() + "://" + url.getHost()));
            } catch (MalformedURLException e2) {
                System.out.println("Error getting cookie for DownloadManager: " + e2.toString());
                e2.printStackTrace();
            }
            request.addRequestHeader("User-Agent", str2);
            request.setTitle(guessFileName);
            request.setDescription(str5);
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, guessFileName);
            module.setDownloadRequest(request);
            if (module.grantFileDownloaderPermissions()) {
                module.downloadFile();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends e {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f10749g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ReactContext reactContext, WebView webView, int i2) {
            super(reactContext, webView);
            this.f10749g = i2;
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            View view = this.f10754d;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            a().removeView(this.f10754d);
            this.f10755e.onCustomViewHidden();
            this.f10754d = null;
            this.f10755e = null;
            this.f10753c.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 19) {
                this.f10752b.getCurrentActivity().getWindow().clearFlags(512);
            }
            this.f10752b.getCurrentActivity().setRequestedOrientation(this.f10749g);
            this.f10752b.removeLifecycleEventListener(this);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (this.f10754d != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            this.f10754d = view;
            this.f10755e = customViewCallback;
            this.f10752b.getCurrentActivity().setRequestedOrientation(-1);
            if (Build.VERSION.SDK_INT >= 19) {
                this.f10754d.setSystemUiVisibility(7942);
                this.f10752b.getCurrentActivity().getWindow().setFlags(512, 512);
            }
            this.f10754d.setBackgroundColor(-16777216);
            a().addView(this.f10754d, e.a);
            this.f10753c.setVisibility(8);
            this.f10752b.addLifecycleEventListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends e {
        d(ReactContext reactContext, WebView webView) {
            super(reactContext, webView);
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class e extends WebChromeClient implements LifecycleEventListener {
        protected static final FrameLayout.LayoutParams a = new FrameLayout.LayoutParams(-1, -1, 17);

        /* renamed from: b  reason: collision with root package name */
        protected ReactContext f10752b;

        /* renamed from: c  reason: collision with root package name */
        protected View f10753c;

        /* renamed from: d  reason: collision with root package name */
        protected View f10754d;

        /* renamed from: e  reason: collision with root package name */
        protected WebChromeClient.CustomViewCallback f10755e;

        /* renamed from: f  reason: collision with root package name */
        protected f.b f10756f = null;

        public e(ReactContext reactContext, WebView webView) {
            this.f10752b = reactContext;
            this.f10753c = webView;
        }

        protected ViewGroup a() {
            return (ViewGroup) this.f10752b.getCurrentActivity().findViewById(16908290);
        }

        public void b(f.b bVar) {
            this.f10756f = bVar;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            ((WebView.WebViewTransport) message.obj).setWebView(new WebView(webView.getContext()));
            message.sendToTarget();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostDestroy() {
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostPause() {
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostResume() {
            View view;
            if (Build.VERSION.SDK_INT < 19 || (view = this.f10754d) == null || view.getSystemUiVisibility() == 7942) {
                return;
            }
            this.f10754d.setSystemUiVisibility(7942);
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            String[] resources = permissionRequest.getResources();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < resources.length; i2++) {
                if (resources[i2].equals("android.webkit.resource.AUDIO_CAPTURE")) {
                    arrayList.add("android.permission.RECORD_AUDIO");
                } else if (resources[i2].equals("android.webkit.resource.VIDEO_CAPTURE")) {
                    arrayList.add("android.permission.CAMERA");
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (androidx.core.content.a.a(this.f10752b, (String) arrayList.get(i3)) == 0) {
                    if (((String) arrayList.get(i3)).equals("android.permission.RECORD_AUDIO")) {
                        arrayList2.add("android.webkit.resource.AUDIO_CAPTURE");
                    } else if (((String) arrayList.get(i3)).equals("android.permission.CAMERA")) {
                        arrayList2.add("android.webkit.resource.VIDEO_CAPTURE");
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                permissionRequest.deny();
            } else {
                permissionRequest.grant((String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            String url = webView.getUrl();
            if (this.f10756f.a()) {
                return;
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("target", webView.getId());
            createMap.putString(MessageBundle.TITLE_ENTRY, webView.getTitle());
            createMap.putString("url", url);
            createMap.putBoolean("canGoBack", webView.canGoBack());
            createMap.putBoolean("canGoForward", webView.canGoForward());
            createMap.putDouble("progress", i2 / 100.0f);
            RNCWebViewManager.dispatchEvent(webView, new com.reactnativecommunity.webview.c.d(webView.getId(), createMap));
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return RNCWebViewManager.getModule(this.f10752b).startPhotoPickerIntent(valueCallback, fileChooserParams.getAcceptTypes(), fileChooserParams.getMode() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class f extends WebView implements LifecycleEventListener {
        protected String a;

        /* renamed from: b  reason: collision with root package name */
        protected String f10757b;

        /* renamed from: c  reason: collision with root package name */
        protected boolean f10758c;

        /* renamed from: d  reason: collision with root package name */
        protected boolean f10759d;

        /* renamed from: e  reason: collision with root package name */
        protected boolean f10760e;

        /* renamed from: f  reason: collision with root package name */
        protected String f10761f;

        /* renamed from: g  reason: collision with root package name */
        protected g f10762g;

        /* renamed from: h  reason: collision with root package name */
        protected CatalystInstance f10763h;

        /* renamed from: j  reason: collision with root package name */
        protected boolean f10764j;

        /* renamed from: k  reason: collision with root package name */
        private com.facebook.react.views.scroll.b f10765k;

        /* renamed from: l  reason: collision with root package name */
        protected boolean f10766l;
        protected b m;
        WebChromeClient n;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements Runnable {
            final /* synthetic */ WebView a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f10767b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ f f10768c;

            a(WebView webView, String str, f fVar) {
                this.a = webView;
                this.f10767b = str;
                this.f10768c = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = f.this.f10762g;
                if (gVar == null) {
                    return;
                }
                WebView webView = this.a;
                WritableMap a = gVar.a(webView, webView.getUrl());
                a.putString("data", this.f10767b);
                if (f.this.f10763h != null) {
                    this.f10768c.h("onMessage", a);
                } else {
                    RNCWebViewManager.dispatchEvent(this.a, new com.reactnativecommunity.webview.c.f(this.a.getId(), a));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes2.dex */
        public static class b {
            private boolean a = false;

            protected b() {
            }

            public boolean a() {
                return this.a;
            }

            public void b(boolean z) {
                this.a = z;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes2.dex */
        public class c {
            f a;

            c(f fVar) {
                this.a = fVar;
            }

            @JavascriptInterface
            public void postMessage(String str) {
                this.a.g(str);
            }
        }

        public f(i0 i0Var) {
            super(i0Var);
            this.f10758c = true;
            this.f10759d = true;
            this.f10760e = false;
            this.f10764j = false;
            this.f10766l = false;
            d();
            this.m = new b();
        }

        public void a() {
            String str;
            if (!getSettings().getJavaScriptEnabled() || (str = this.a) == null || TextUtils.isEmpty(str)) {
                return;
            }
            f("(function() {\n" + this.a + ";\n})();");
        }

        public void b() {
            String str;
            if (!getSettings().getJavaScriptEnabled() || (str = this.f10757b) == null || TextUtils.isEmpty(str)) {
                return;
            }
            f("(function() {\n" + this.f10757b + ";\n})();");
        }

        protected void c() {
            setWebViewClient(null);
            destroy();
        }

        protected void d() {
            ReactContext reactContext = (ReactContext) getContext();
            if (reactContext != null) {
                this.f10763h = reactContext.getCatalystInstance();
            }
        }

        @Override // android.webkit.WebView
        public void destroy() {
            WebChromeClient webChromeClient = this.n;
            if (webChromeClient != null) {
                webChromeClient.onHideCustomView();
            }
            super.destroy();
        }

        protected c e(f fVar) {
            return new c(fVar);
        }

        protected void f(String str) {
            if (Build.VERSION.SDK_INT >= 19) {
                evaluateJavascript(str, null);
                return;
            }
            try {
                loadUrl("javascript:" + URLEncoder.encode(str, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException(e2);
            }
        }

        public void g(String str) {
            ReactContext reactContext = (ReactContext) getContext();
            if (this.f10762g != null) {
                post(new a(this, str, this));
                return;
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putString("data", str);
            if (this.f10763h != null) {
                h("onMessage", createMap);
            } else {
                RNCWebViewManager.dispatchEvent(this, new com.reactnativecommunity.webview.c.f(getId(), createMap));
            }
        }

        public g getRNCWebViewClient() {
            return this.f10762g;
        }

        protected void h(String str, WritableMap writableMap) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putMap("nativeEvent", writableMap);
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            writableNativeArray.pushMap(writableNativeMap);
            this.f10763h.callFunction(this.f10761f, str, writableNativeArray);
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostDestroy() {
            c();
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostPause() {
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostResume() {
        }

        @Override // android.webkit.WebView, android.view.View
        protected void onScrollChanged(int i2, int i3, int i4, int i5) {
            super.onScrollChanged(i2, i3, i4, i5);
            if (this.f10766l) {
                if (this.f10765k == null) {
                    this.f10765k = new com.facebook.react.views.scroll.b();
                }
                if (this.f10765k.c(i2, i3)) {
                    RNCWebViewManager.dispatchEvent(this, h.n(getId(), i.SCROLL, i2, i3, this.f10765k.a(), this.f10765k.b(), computeHorizontalScrollRange(), computeVerticalScrollRange(), getWidth(), getHeight()));
                }
            }
        }

        @Override // android.webkit.WebView, android.view.View
        protected void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (this.f10764j) {
                RNCWebViewManager.dispatchEvent(this, new com.facebook.react.uimanager.events.b(getId(), i2, i3));
            }
        }

        public void setHasScrollEvent(boolean z) {
            this.f10766l = z;
        }

        public void setIgnoreErrFailedForThisURL(String str) {
            this.f10762g.c(str);
        }

        public void setInjectedJavaScript(String str) {
            this.a = str;
        }

        public void setInjectedJavaScriptBeforeContentLoaded(String str) {
            this.f10757b = str;
        }

        public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(boolean z) {
            this.f10759d = z;
        }

        public void setInjectedJavaScriptForMainFrameOnly(boolean z) {
            this.f10758c = z;
        }

        @SuppressLint({"AddJavascriptInterface"})
        public void setMessagingEnabled(boolean z) {
            if (this.f10760e == z) {
                return;
            }
            this.f10760e = z;
            if (z) {
                addJavascriptInterface(e(this), RNCWebViewManager.JAVASCRIPT_INTERFACE);
            } else {
                removeJavascriptInterface(RNCWebViewManager.JAVASCRIPT_INTERFACE);
            }
        }

        public void setMessagingModuleName(String str) {
            this.f10761f = str;
        }

        public void setSendContentSizeChangeEvents(boolean z) {
            this.f10764j = z;
        }

        @Override // android.webkit.WebView
        public void setWebChromeClient(WebChromeClient webChromeClient) {
            this.n = webChromeClient;
            super.setWebChromeClient(webChromeClient);
            if (webChromeClient instanceof e) {
                ((e) webChromeClient).b(this.m);
            }
        }

        @Override // android.webkit.WebView
        public void setWebViewClient(WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
            if (webViewClient instanceof g) {
                g gVar = (g) webViewClient;
                this.f10762g = gVar;
                gVar.d(this.m);
            }
        }
    }

    public RNCWebViewManager() {
        this.mWebChromeClient = null;
        this.mAllowsFullscreenVideo = false;
        this.mUserAgent = null;
        this.mUserAgentWithApplicationName = null;
        this.mWebViewConfig = new a();
    }

    protected static void dispatchEvent(WebView webView, com.facebook.react.uimanager.events.c cVar) {
        ((UIManagerModule) ((ReactContext) webView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().v(cVar);
    }

    public static RNCWebViewModule getModule(ReactContext reactContext) {
        return (RNCWebViewModule) reactContext.getNativeModule(RNCWebViewModule.class);
    }

    protected f createRNCWebViewInstance(i0 i0Var) {
        return new f(i0Var);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return com.facebook.react.common.c.a().b("goBack", 1).b("goForward", 2).b("reload", 3).b("stopLoading", 4).b("postMessage", 5).b("injectJavaScript", 6).b("loadUrl", 7).b("requestFocus", 8).b("clearFormData", Integer.valueOf((int) COMMAND_CLEAR_FORM_DATA)).b("clearCache", 1001).b("clearHistory", Integer.valueOf((int) COMMAND_CLEAR_HISTORY)).a();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = com.facebook.react.common.c.b();
        }
        exportedCustomDirectEventTypeConstants.put("topLoadingProgress", com.facebook.react.common.c.d("registrationName", "onLoadingProgress"));
        exportedCustomDirectEventTypeConstants.put("topShouldStartLoadWithRequest", com.facebook.react.common.c.d("registrationName", "onShouldStartLoadWithRequest"));
        exportedCustomDirectEventTypeConstants.put(i.h(i.SCROLL), com.facebook.react.common.c.d("registrationName", "onScroll"));
        exportedCustomDirectEventTypeConstants.put("topHttpError", com.facebook.react.common.c.d("registrationName", "onHttpError"));
        exportedCustomDirectEventTypeConstants.put("topRenderProcessGone", com.facebook.react.common.c.d("registrationName", "onRenderProcessGone"));
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNCWebView";
    }

    @com.facebook.react.uimanager.c1.a(name = "allowFileAccess")
    public void setAllowFileAccess(WebView webView, Boolean bool) {
        webView.getSettings().setAllowFileAccess(bool != null && bool.booleanValue());
    }

    @com.facebook.react.uimanager.c1.a(name = "allowFileAccessFromFileURLs")
    public void setAllowFileAccessFromFileURLs(WebView webView, boolean z) {
        webView.getSettings().setAllowFileAccessFromFileURLs(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "allowUniversalAccessFromFileURLs")
    public void setAllowUniversalAccessFromFileURLs(WebView webView, boolean z) {
        webView.getSettings().setAllowUniversalAccessFromFileURLs(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "allowsFullscreenVideo")
    public void setAllowsFullscreenVideo(WebView webView, Boolean bool) {
        this.mAllowsFullscreenVideo = bool != null && bool.booleanValue();
        setupWebChromeClient((ReactContext) webView.getContext(), webView);
    }

    @com.facebook.react.uimanager.c1.a(name = "applicationNameForUserAgent")
    public void setApplicationNameForUserAgent(WebView webView, String str) {
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                String defaultUserAgent = WebSettings.getDefaultUserAgent(webView.getContext());
                this.mUserAgentWithApplicationName = defaultUserAgent + " " + str;
            }
        } else {
            this.mUserAgentWithApplicationName = null;
        }
        setUserAgentString(webView);
    }

    @com.facebook.react.uimanager.c1.a(name = "cacheEnabled")
    public void setCacheEnabled(WebView webView, boolean z) {
        if (z) {
            Context context = webView.getContext();
            if (context != null) {
                webView.getSettings().setAppCachePath(context.getCacheDir().getAbsolutePath());
                webView.getSettings().setCacheMode(-1);
                webView.getSettings().setAppCacheEnabled(true);
                return;
            }
            return;
        }
        webView.getSettings().setCacheMode(2);
        webView.getSettings().setAppCacheEnabled(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @com.facebook.react.uimanager.c1.a(name = "cacheMode")
    public void setCacheMode(WebView webView, String str) {
        boolean z;
        Integer num;
        switch (str.hashCode()) {
            case -2059164003:
                if (str.equals("LOAD_NO_CACHE")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1215135800:
                if (str.equals("LOAD_DEFAULT")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -873877826:
                if (str.equals("LOAD_CACHE_ELSE_NETWORK")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1548620642:
                if (str.equals("LOAD_CACHE_ONLY")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z) {
            num = 3;
        } else if (z) {
            num = 1;
        } else if (!z) {
            num = -1;
        } else {
            num = 2;
        }
        webView.getSettings().setCacheMode(num.intValue());
    }

    @com.facebook.react.uimanager.c1.a(name = "domStorageEnabled")
    public void setDomStorageEnabled(WebView webView, boolean z) {
        webView.getSettings().setDomStorageEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "geolocationEnabled")
    public void setGeolocationEnabled(WebView webView, Boolean bool) {
        webView.getSettings().setGeolocationEnabled(bool != null && bool.booleanValue());
    }

    @com.facebook.react.uimanager.c1.a(name = "androidHardwareAccelerationDisabled")
    public void setHardwareAccelerationDisabled(WebView webView, boolean z) {
        if (z) {
            webView.setLayerType(1, null);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "incognito")
    public void setIncognito(WebView webView, boolean z) {
        if (z) {
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().removeAllCookies(null);
            } else {
                CookieManager.getInstance().removeAllCookie();
            }
            webView.getSettings().setCacheMode(2);
            webView.getSettings().setAppCacheEnabled(false);
            webView.clearHistory();
            webView.clearCache(true);
            webView.clearFormData();
            webView.getSettings().setSavePassword(false);
            webView.getSettings().setSaveFormData(false);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "injectedJavaScript")
    public void setInjectedJavaScript(WebView webView, String str) {
        ((f) webView).setInjectedJavaScript(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "injectedJavaScriptBeforeContentLoaded")
    public void setInjectedJavaScriptBeforeContentLoaded(WebView webView, String str) {
        ((f) webView).setInjectedJavaScriptBeforeContentLoaded(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "injectedJavaScriptBeforeContentLoadedForMainFrameOnly")
    public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(WebView webView, boolean z) {
        ((f) webView).setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "injectedJavaScriptForMainFrameOnly")
    public void setInjectedJavaScriptForMainFrameOnly(WebView webView, boolean z) {
        ((f) webView).setInjectedJavaScriptForMainFrameOnly(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "javaScriptCanOpenWindowsAutomatically")
    public void setJavaScriptCanOpenWindowsAutomatically(WebView webView, boolean z) {
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "javaScriptEnabled")
    public void setJavaScriptEnabled(WebView webView, boolean z) {
        webView.getSettings().setJavaScriptEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "androidLayerType")
    public void setLayerType(WebView webView, String str) {
        str.hashCode();
        webView.setLayerType(!str.equals("hardware") ? !str.equals("software") ? 0 : 1 : 2, null);
    }

    @TargetApi(17)
    @com.facebook.react.uimanager.c1.a(name = "mediaPlaybackRequiresUserAction")
    public void setMediaPlaybackRequiresUserAction(WebView webView, boolean z) {
        webView.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "messagingEnabled")
    public void setMessagingEnabled(WebView webView, boolean z) {
        ((f) webView).setMessagingEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "messagingModuleName")
    public void setMessagingModuleName(WebView webView, String str) {
        ((f) webView).setMessagingModuleName(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "mixedContentMode")
    public void setMixedContentMode(WebView webView, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (str != null && !"never".equals(str)) {
                if ("always".equals(str)) {
                    webView.getSettings().setMixedContentMode(0);
                    return;
                } else if ("compatibility".equals(str)) {
                    webView.getSettings().setMixedContentMode(2);
                    return;
                } else {
                    return;
                }
            }
            webView.getSettings().setMixedContentMode(1);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "onContentSizeChange")
    public void setOnContentSizeChange(WebView webView, boolean z) {
        ((f) webView).setSendContentSizeChangeEvents(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "onScroll")
    public void setOnScroll(WebView webView, boolean z) {
        ((f) webView).setHasScrollEvent(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "overScrollMode")
    public void setOverScrollMode(WebView webView, String str) {
        char c2;
        Integer num;
        int hashCode = str.hashCode();
        if (hashCode == -1414557169) {
            if (str.equals("always")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 104712844) {
            if (hashCode == 951530617 && str.equals("content")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals("never")) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            num = 2;
        } else if (c2 != 1) {
            num = 0;
        } else {
            num = 1;
        }
        webView.setOverScrollMode(num.intValue());
    }

    @com.facebook.react.uimanager.c1.a(name = "saveFormDataDisabled")
    public void setSaveFormDataDisabled(WebView webView, boolean z) {
        webView.getSettings().setSaveFormData(!z);
    }

    @com.facebook.react.uimanager.c1.a(name = "scalesPageToFit")
    public void setScalesPageToFit(WebView webView, boolean z) {
        webView.getSettings().setLoadWithOverviewMode(z);
        webView.getSettings().setUseWideViewPort(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(WebView webView, boolean z) {
        webView.setHorizontalScrollBarEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(WebView webView, boolean z) {
        webView.setVerticalScrollBarEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = Payload.SOURCE)
    public void setSource(WebView webView, ReadableMap readableMap) {
        if (readableMap != null) {
            if (readableMap.hasKey("html")) {
                webView.loadDataWithBaseURL(readableMap.hasKey("baseUrl") ? readableMap.getString("baseUrl") : "", readableMap.getString("html"), HTML_MIME_TYPE, "UTF-8", null);
                return;
            } else if (readableMap.hasKey("uri")) {
                String string = readableMap.getString("uri");
                String url = webView.getUrl();
                if (url == null || !url.equals(string)) {
                    if (readableMap.hasKey("method") && readableMap.getString("method").equalsIgnoreCase("POST")) {
                        byte[] bArr = null;
                        if (readableMap.hasKey("body")) {
                            String string2 = readableMap.getString("body");
                            try {
                                bArr = string2.getBytes("UTF-8");
                            } catch (UnsupportedEncodingException unused) {
                                bArr = string2.getBytes();
                            }
                        }
                        if (bArr == null) {
                            bArr = new byte[0];
                        }
                        webView.postUrl(string, bArr);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    if (readableMap.hasKey("headers")) {
                        ReadableMap map = readableMap.getMap("headers");
                        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
                        while (keySetIterator.hasNextKey()) {
                            String nextKey = keySetIterator.nextKey();
                            if ("user-agent".equals(nextKey.toLowerCase(Locale.ENGLISH))) {
                                if (webView.getSettings() != null) {
                                    webView.getSettings().setUserAgentString(map.getString(nextKey));
                                }
                            } else {
                                hashMap.put(nextKey, map.getString(nextKey));
                            }
                        }
                    }
                    webView.loadUrl(string, hashMap);
                    return;
                }
                return;
            }
        }
        webView.loadUrl(BLANK_URL);
    }

    @com.facebook.react.uimanager.c1.a(name = "setSupportMultipleWindows")
    public void setSupportMultipleWindows(WebView webView, boolean z) {
        webView.getSettings().setSupportMultipleWindows(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "textZoom")
    public void setTextZoom(WebView webView, int i2) {
        webView.getSettings().setTextZoom(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "thirdPartyCookiesEnabled")
    public void setThirdPartyCookiesEnabled(WebView webView, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, z);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "urlPrefixesForDefaultIntent")
    public void setUrlPrefixesForDefaultIntent(WebView webView, ReadableArray readableArray) {
        g rNCWebViewClient = ((f) webView).getRNCWebViewClient();
        if (rNCWebViewClient == null || readableArray == null) {
            return;
        }
        rNCWebViewClient.e(readableArray);
    }

    @com.facebook.react.uimanager.c1.a(name = "userAgent")
    public void setUserAgent(WebView webView, String str) {
        if (str != null) {
            this.mUserAgent = str;
        } else {
            this.mUserAgent = null;
        }
        setUserAgentString(webView);
    }

    protected void setUserAgentString(WebView webView) {
        if (this.mUserAgent != null) {
            webView.getSettings().setUserAgentString(this.mUserAgent);
        } else if (this.mUserAgentWithApplicationName != null) {
            webView.getSettings().setUserAgentString(this.mUserAgentWithApplicationName);
        } else if (Build.VERSION.SDK_INT >= 17) {
            webView.getSettings().setUserAgentString(WebSettings.getDefaultUserAgent(webView.getContext()));
        }
    }

    protected void setupWebChromeClient(ReactContext reactContext, WebView webView) {
        if (this.mAllowsFullscreenVideo) {
            c cVar = new c(reactContext, webView, reactContext.getCurrentActivity().getRequestedOrientation());
            this.mWebChromeClient = cVar;
            webView.setWebChromeClient(cVar);
            return;
        }
        e eVar = this.mWebChromeClient;
        if (eVar != null) {
            eVar.onHideCustomView();
        }
        d dVar = new d(reactContext, webView);
        this.mWebChromeClient = dVar;
        webView.setWebChromeClient(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(i0 i0Var, WebView webView) {
        webView.setWebViewClient(new g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    @TargetApi(21)
    public WebView createViewInstance(i0 i0Var) {
        f createRNCWebViewInstance = createRNCWebViewInstance(i0Var);
        setupWebChromeClient(i0Var, createRNCWebViewInstance);
        i0Var.addLifecycleEventListener(createRNCWebViewInstance);
        this.mWebViewConfig.a(createRNCWebViewInstance);
        WebSettings settings = createRNCWebViewInstance.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            setAllowUniversalAccessFromFileURLs(createRNCWebViewInstance, false);
        }
        setMixedContentMode(createRNCWebViewInstance, "never");
        createRNCWebViewInstance.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        createRNCWebViewInstance.setDownloadListener(new b(createRNCWebViewInstance, i0Var));
        return createRNCWebViewInstance;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(WebView webView) {
        super.onDropViewInstance((RNCWebViewManager) webView);
        f fVar = (f) webView;
        ((i0) webView.getContext()).removeLifecycleEventListener(fVar);
        fVar.c();
        this.mWebChromeClient = null;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(WebView webView, int i2, ReadableArray readableArray) {
        boolean z = false;
        switch (i2) {
            case 1:
                webView.goBack();
                return;
            case 2:
                webView.goForward();
                return;
            case 3:
                webView.reload();
                return;
            case 4:
                webView.stopLoading();
                return;
            case 5:
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", readableArray.getString(0));
                    ((f) webView).f("(function () {var event;var data = " + jSONObject.toString() + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();");
                    return;
                } catch (JSONException e2) {
                    throw new RuntimeException(e2);
                }
            case 6:
                ((f) webView).f(readableArray.getString(0));
                return;
            case 7:
                if (readableArray != null) {
                    ((f) webView).m.b(false);
                    webView.loadUrl(readableArray.getString(0));
                    return;
                }
                throw new RuntimeException("Arguments for loading an url are null!");
            case 8:
                webView.requestFocus();
                return;
            default:
                switch (i2) {
                    case COMMAND_CLEAR_FORM_DATA /* 1000 */:
                        webView.clearFormData();
                        return;
                    case 1001:
                        if (readableArray != null && readableArray.getBoolean(0)) {
                            z = true;
                        }
                        webView.clearCache(z);
                        return;
                    case COMMAND_CLEAR_HISTORY /* 1002 */:
                        webView.clearHistory();
                        return;
                    default:
                        return;
                }
        }
    }

    public RNCWebViewManager(com.reactnativecommunity.webview.b bVar) {
        this.mWebChromeClient = null;
        this.mAllowsFullscreenVideo = false;
        this.mUserAgent = null;
        this.mUserAgentWithApplicationName = null;
        this.mWebViewConfig = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class g extends WebViewClient {

        /* renamed from: b  reason: collision with root package name */
        protected ReadableArray f10771b;
        protected boolean a = false;

        /* renamed from: c  reason: collision with root package name */
        protected f.b f10772c = null;

        /* renamed from: d  reason: collision with root package name */
        protected String f10773d = null;

        protected g() {
        }

        protected WritableMap a(WebView webView, String str) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("target", webView.getId());
            createMap.putString("url", str);
            createMap.putBoolean("loading", (this.a || webView.getProgress() == 100) ? false : true);
            createMap.putString(MessageBundle.TITLE_ENTRY, webView.getTitle());
            createMap.putBoolean("canGoBack", webView.canGoBack());
            createMap.putBoolean("canGoForward", webView.canGoForward());
            return createMap;
        }

        protected void b(WebView webView, String str) {
            RNCWebViewManager.dispatchEvent(webView, new com.reactnativecommunity.webview.c.c(webView.getId(), a(webView, str)));
        }

        public void c(String str) {
            this.f10773d = str;
        }

        public void d(f.b bVar) {
            this.f10772c = bVar;
        }

        public void e(ReadableArray readableArray) {
            this.f10771b = readableArray;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.a) {
                return;
            }
            ((f) webView).a();
            b(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.a = false;
            ((f) webView).b();
            RNCWebViewManager.dispatchEvent(webView, new com.reactnativecommunity.webview.c.e(webView.getId(), a(webView, str)));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            String str3 = this.f10773d;
            if (str3 != null && str2.equals(str3) && i2 == -1 && str.equals("net::ERR_FAILED")) {
                c(null);
                return;
            }
            super.onReceivedError(webView, i2, str, str2);
            this.a = true;
            b(webView, str2);
            WritableMap a = a(webView, str2);
            a.putDouble("code", i2);
            a.putString(ApiConstants.DESCRIPTION, str);
            RNCWebViewManager.dispatchEvent(webView, new com.reactnativecommunity.webview.c.b(webView.getId(), a));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest.isForMainFrame()) {
                WritableMap a = a(webView, webResourceRequest.getUrl().toString());
                a.putInt("statusCode", webResourceResponse.getStatusCode());
                a.putString(ApiConstants.DESCRIPTION, webResourceResponse.getReasonPhrase());
                RNCWebViewManager.dispatchEvent(webView, new com.reactnativecommunity.webview.c.a(webView.getId(), a));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String url = webView.getUrl();
            String url2 = sslError.getUrl();
            sslErrorHandler.cancel();
            if (!url.equalsIgnoreCase(url2)) {
                Log.w(RNCWebViewManager.TAG, "Resource blocked from loading due to SSL error. Blocked URL: " + url2);
                return;
            }
            int primaryError = sslError.getPrimaryError();
            String str = primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? primaryError != 5 ? "Unknown SSL Error" : "A generic error occurred" : "The date of the certificate is invalid" : "The certificate authority is not trusted" : "Hostname mismatch" : "The certificate has expired" : "The certificate is not yet valid";
            onReceivedError(webView, primaryError, "SSL error: " + str, url2);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            super.onRenderProcessGone(webView, renderProcessGoneDetail);
            if (renderProcessGoneDetail.didCrash()) {
                Log.e(RNCWebViewManager.TAG, "The WebView rendering process crashed.");
            } else {
                Log.w(RNCWebViewManager.TAG, "The WebView rendering process was killed by the system.");
            }
            if (webView == null) {
                return true;
            }
            WritableMap a = a(webView, webView.getUrl());
            a.putBoolean("didCrash", renderProcessGoneDetail.didCrash());
            RNCWebViewManager.dispatchEvent(webView, new com.reactnativecommunity.webview.c.g(webView.getId(), a));
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            f fVar = (f) webView;
            if (!(((ReactContext) webView.getContext()).getJavaScriptContextHolder().get() == 0) && fVar.f10763h != null) {
                androidx.core.util.e<Integer, AtomicReference<RNCWebViewModule.d.a>> b2 = RNCWebViewModule.shouldOverrideUrlLoadingLock.b();
                int intValue = b2.a.intValue();
                AtomicReference<RNCWebViewModule.d.a> atomicReference = b2.f1541b;
                WritableMap a = a(webView, str);
                a.putInt("lockIdentifier", intValue);
                fVar.h("onShouldStartLoadWithRequest", a);
                try {
                    synchronized (atomicReference) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        while (atomicReference.get() == RNCWebViewModule.d.a.UNDECIDED) {
                            if (SystemClock.elapsedRealtime() - elapsedRealtime > 250) {
                                e.f.d.d.a.A(RNCWebViewManager.TAG, "Did not receive response to shouldOverrideUrlLoading in time, defaulting to allow loading.");
                                RNCWebViewModule.shouldOverrideUrlLoadingLock.c(Integer.valueOf(intValue));
                                return false;
                            }
                            atomicReference.wait(250L);
                        }
                        boolean z = atomicReference.get() == RNCWebViewModule.d.a.SHOULD_OVERRIDE;
                        RNCWebViewModule.shouldOverrideUrlLoadingLock.c(Integer.valueOf(intValue));
                        return z;
                    }
                } catch (InterruptedException e2) {
                    e.f.d.d.a.j(RNCWebViewManager.TAG, "shouldOverrideUrlLoading was interrupted while waiting for result.", e2);
                    RNCWebViewModule.shouldOverrideUrlLoadingLock.c(Integer.valueOf(intValue));
                    return false;
                }
            }
            e.f.d.d.a.A(RNCWebViewManager.TAG, "Couldn't use blocking synchronous call for onShouldStartLoadWithRequest due to debugging or missing Catalyst instance, falling back to old event-and-load.");
            this.f10772c.b(true);
            RNCWebViewManager.dispatchEvent(webView, new com.reactnativecommunity.webview.c.h(webView.getId(), a(webView, str)));
            return true;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
        }
    }
}