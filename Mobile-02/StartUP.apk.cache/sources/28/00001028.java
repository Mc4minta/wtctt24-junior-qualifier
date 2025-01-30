package com.coinbase.cipherwebview.httpclient;

import android.webkit.CookieManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.l0.y;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/* compiled from: WebViewCookieJar.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR%\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\f0\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/coinbase/cipherwebview/httpclient/WebViewCookieJar;", "Lokhttp3/CookieJar;", "Lokhttp3/HttpUrl;", "url", "", "Lokhttp3/Cookie;", "cookies", "Lkotlin/x;", "saveFromResponse", "(Lokhttp3/HttpUrl;Ljava/util/List;)V", "loadForRequest", "(Lokhttp3/HttpUrl;)Ljava/util/List;", "Landroid/webkit/CookieManager;", "kotlin.jvm.PlatformType", "webViewCookieManager$delegate", "Lkotlin/h;", "getWebViewCookieManager", "()Landroid/webkit/CookieManager;", "webViewCookieManager", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WebViewCookieJar implements CookieJar {
    private final h webViewCookieManager$delegate;

    public WebViewCookieJar() {
        h b2;
        b2 = k.b(WebViewCookieJar$webViewCookieManager$2.INSTANCE);
        this.webViewCookieManager$delegate = b2;
    }

    private final CookieManager getWebViewCookieManager() {
        return (CookieManager) this.webViewCookieManager$delegate.getValue();
    }

    @Override // okhttp3.CookieJar
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> g2;
        List<String> K0;
        m.g(url, "url");
        String cookie = getWebViewCookieManager().getCookie(url.toString());
        if (cookie != null) {
            if (cookie.length() > 0) {
                K0 = y.K0(cookie, new String[]{";"}, false, 0, 6, null);
                ArrayList arrayList = new ArrayList();
                for (String str : K0) {
                    Cookie parse = Cookie.Companion.parse(url, str);
                    if (parse != null) {
                        arrayList.add(parse);
                    }
                }
                return arrayList;
            }
        }
        g2 = r.g();
        return g2;
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        m.g(url, "url");
        m.g(cookies, "cookies");
        String httpUrl = url.toString();
        for (Cookie cookie : cookies) {
            getWebViewCookieManager().setCookie(httpUrl, cookie.toString());
        }
    }
}