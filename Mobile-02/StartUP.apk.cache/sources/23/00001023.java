package com.coinbase.cipherwebview.httpclient;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.cipherwebview.util.InjectCSPNonceKt;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.a0.q;
import kotlin.a0.s0;
import kotlin.a0.z;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.i;
import kotlin.l0.k;
import kotlin.l0.y;
import kotlin.o;
import kotlin.x;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: HttpClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u000b\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001.B-\u0012\u0006\u0010\"\u001a\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0$¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\n\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010#\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/coinbase/cipherwebview/httpclient/HttpClient;", "", "Landroid/webkit/WebResourceRequest;", "webRequest", "", "isUrlKnownResourceExtension", "(Landroid/webkit/WebResourceRequest;)Z", "Lokhttp3/Request;", "buildRequestFromWebResourceRequest", "(Landroid/webkit/WebResourceRequest;)Lokhttp3/Request;", "Lokhttp3/Response;", Payload.RESPONSE, "Landroid/webkit/WebResourceResponse;", "processResponse", "(Lokhttp3/Response;)Landroid/webkit/WebResourceResponse;", "", "contentType", "Lkotlin/o;", "determineMimeTypeAndCharset", "(Ljava/lang/String;)Lkotlin/o;", "makeWebRequest", "(Landroid/webkit/WebResourceRequest;)Lkotlin/o;", "Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/h;", "getClient", "()Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient$Builder;", "httpClientBuilder", "Lokhttp3/OkHttpClient$Builder;", "Lcom/coinbase/cipherwebview/httpclient/WebViewCookieJar;", "cookieJar", "Lcom/coinbase/cipherwebview/httpclient/WebViewCookieJar;", "userAgentString", "Ljava/lang/String;", "", "additionalHeaders", "Ljava/util/Map;", "injectionJs", "getInjectionJs$cipher_webview_release", "()Ljava/lang/String;", "setInjectionJs$cipher_webview_release", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;Lokhttp3/OkHttpClient$Builder;Ljava/util/Map;)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HttpClient {
    private static final k CONTENT_TYPE_REGEX;
    public static final Companion Companion = new Companion(null);
    private static final String DEFAULT_CHARSET = "utf-8";
    private static final String DEFAULT_MIME_TYPE = "text/html";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_USER_AGENT = "User-Agent";
    private static final Set<String> RESOURCE_EXTENSIONS;
    private final Map<String, String> additionalHeaders;
    private final h client$delegate;
    private final WebViewCookieJar cookieJar;
    private final OkHttpClient.Builder httpClientBuilder;
    private String injectionJs;
    private final String userAgentString;

    /* compiled from: HttpClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/coinbase/cipherwebview/httpclient/HttpClient$Companion;", "", "Lkotlin/l0/k;", "CONTENT_TYPE_REGEX", "Lkotlin/l0/k;", "", "DEFAULT_CHARSET", "Ljava/lang/String;", "DEFAULT_MIME_TYPE", "HEADER_CONTENT_TYPE", "HEADER_USER_AGENT", "", "RESOURCE_EXTENSIONS", "Ljava/util/Set;", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Set<String> e2;
        e2 = s0.e(".jpg", ".jpeg", ".gif", ".png", ".js", ".css", ".svg", ".ico", ".webp", ".ttf", ".woff", ".woff2", ".eot", ".mov", ".mpg", ".mpeg", ".avi", ".webm", ".mp3", ".aac", ".wav", ".flac", ".ogg", ".txt", ".text", ".xml", ".json", ".yaml", ".bmp");
        RESOURCE_EXTENSIONS = e2;
        CONTENT_TYPE_REGEX = new k("^\\s*([^\\s;]*)(\\s*;\\s*charset\\s*=\\s*([^\\s;]*))?");
    }

    public HttpClient(String userAgentString, OkHttpClient.Builder httpClientBuilder, Map<String, String> additionalHeaders) {
        h b2;
        m.g(userAgentString, "userAgentString");
        m.g(httpClientBuilder, "httpClientBuilder");
        m.g(additionalHeaders, "additionalHeaders");
        this.userAgentString = userAgentString;
        this.httpClientBuilder = httpClientBuilder;
        this.additionalHeaders = additionalHeaders;
        this.injectionJs = "";
        this.cookieJar = new WebViewCookieJar();
        b2 = kotlin.k.b(new HttpClient$client$2(this));
        this.client$delegate = b2;
    }

    private final Request buildRequestFromWebResourceRequest(WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        m.f(uri, "webRequest.url.toString()");
        Map<String, String> headers = webResourceRequest.getRequestHeaders();
        m.f(headers, "headers");
        String str = headers.get("User-Agent");
        if (str == null) {
            str = this.userAgentString;
        }
        headers.put("User-Agent", str);
        Map<String, String> map = this.additionalHeaders;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            headers.put(entry.getKey(), entry.getValue());
            arrayList.add(x.a);
        }
        return new Request.Builder().headers(Headers.Companion.of(headers)).get().url(uri).build();
    }

    private final o<String, String> determineMimeTypeAndCharset(String str) {
        List<String> b2;
        i b3 = k.b(CONTENT_TYPE_REGEX, str, 0, 2, null);
        String str2 = DEFAULT_MIME_TYPE;
        String str3 = DEFAULT_CHARSET;
        if (b3 != null && (b2 = b3.b()) != null && b2.size() > 1) {
            str2 = b2.get(1);
            if (b2.size() > 3) {
                str3 = b2.get(3);
            }
        }
        return new o<>(str2, str3);
    }

    private final OkHttpClient getClient() {
        return (OkHttpClient) this.client$delegate.getValue();
    }

    private final boolean isUrlKnownResourceExtension(WebResourceRequest webResourceRequest) {
        boolean T;
        String uri = webResourceRequest.getUrl().toString();
        m.f(uri, "webRequest.url.toString()");
        for (String str : RESOURCE_EXTENSIONS) {
            T = y.T(uri, str, true);
            if (T) {
                return true;
            }
        }
        return false;
    }

    private final WebResourceResponse processResponse(Response response) {
        boolean V;
        String str;
        String str2;
        Map v;
        int d2;
        String h0;
        List b2;
        String header$default = Response.header$default(response, "Content-Type", null, 2, null);
        if (header$default != null) {
            V = y.V(header$default, "html", false, 2, null);
            if (V) {
                o<String, String> determineMimeTypeAndCharset = determineMimeTypeAndCharset(header$default);
                String a = determineMimeTypeAndCharset.a();
                String b3 = determineMimeTypeAndCharset.b();
                String header$default2 = Response.header$default(response, "content-security-policy", null, 2, null);
                if (header$default2 != null) {
                    o<String, String> injectCSPNonce = InjectCSPNonceKt.injectCSPNonce(header$default2);
                    str = injectCSPNonce.a();
                    str2 = injectCSPNonce.b();
                } else {
                    str = header$default2;
                    str2 = null;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                ResponseBody body2 = response.body();
                InputStream byteStream = body2 == null ? null : body2.byteStream();
                if (byteStream == null) {
                    body.close();
                    return null;
                }
                JavaScriptInjectedInputStream javaScriptInjectedInputStream = new JavaScriptInjectedInputStream(byteStream, this.injectionJs, str2);
                v = m0.v(response.headers().toMultimap());
                if (str != null) {
                    b2 = q.b(str);
                    v.put("content-security-policy", b2);
                }
                d2 = l0.d(v.size());
                LinkedHashMap linkedHashMap = new LinkedHashMap(d2);
                for (Map.Entry entry : v.entrySet()) {
                    Object key = entry.getKey();
                    h0 = z.h0((Iterable) entry.getValue(), ",", null, null, 0, null, null, 62, null);
                    linkedHashMap.put(key, h0);
                }
                WebResourceResponse webResourceResponse = new WebResourceResponse(a, b3, javaScriptInjectedInputStream);
                webResourceResponse.setResponseHeaders(linkedHashMap);
                return webResourceResponse;
            }
        }
        return null;
    }

    public final String getInjectionJs$cipher_webview_release() {
        return this.injectionJs;
    }

    public final o<WebResourceResponse, Response> makeWebRequest(WebResourceRequest webRequest) {
        m.g(webRequest, "webRequest");
        if (isUrlKnownResourceExtension(webRequest)) {
            return null;
        }
        Response execute = FirebasePerfOkHttpClient.execute(getClient().newCall(buildRequestFromWebResourceRequest(webRequest)));
        return new o<>(processResponse(execute), execute);
    }

    public final void setInjectionJs$cipher_webview_release(String str) {
        m.g(str, "<set-?>");
        this.injectionJs = str;
    }

    public /* synthetic */ HttpClient(String str, OkHttpClient.Builder builder, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, builder, (i2 & 4) != 0 ? m0.i() : map);
    }
}