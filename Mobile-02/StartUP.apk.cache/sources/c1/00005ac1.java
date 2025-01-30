package okhttp3.internal;

import com.coinbase.ApiConstants;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: internal.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012\u001a%\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0015\u001a\u001f\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001c\u001a%\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\n¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"", "currentTimeMillis", "Lokhttp3/HttpUrl;", "url", "", "setCookie", "Lokhttp3/Cookie;", "parseCookie", "(JLokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/Cookie;", "cookie", "", "forObsoleteRfc2965", "cookieToString", "(Lokhttp3/Cookie;Z)Ljava/lang/String;", "Lokhttp3/Headers$Builder;", "builder", "line", "addHeaderLenient", "(Lokhttp3/Headers$Builder;Ljava/lang/String;)Lokhttp3/Headers$Builder;", ApiConstants.NAME, "value", "(Lokhttp3/Headers$Builder;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers$Builder;", "Lokhttp3/Cache;", "cache", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", "cacheGet", "(Lokhttp3/Cache;Lokhttp3/Request;)Lokhttp3/Response;", "Lokhttp3/ConnectionSpec;", "connectionSpec", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "isFallback", "Lkotlin/x;", "applyConnectionSpec", "(Lokhttp3/ConnectionSpec;Ljavax/net/ssl/SSLSocket;Z)V", "okhttp"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String line) {
        m.h(builder, "builder");
        m.h(line, "line");
        return builder.addLenient$okhttp(line);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sslSocket, boolean z) {
        m.h(connectionSpec, "connectionSpec");
        m.h(sslSocket, "sslSocket");
        connectionSpec.apply$okhttp(sslSocket, z);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        m.h(cache, "cache");
        m.h(request, "request");
        return cache.get$okhttp(request);
    }

    public static final String cookieToString(Cookie cookie, boolean z) {
        m.h(cookie, "cookie");
        return cookie.toString$okhttp(z);
    }

    public static final Cookie parseCookie(long j2, HttpUrl url, String setCookie) {
        m.h(url, "url");
        m.h(setCookie, "setCookie");
        return Cookie.Companion.parse$okhttp(j2, url, setCookie);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String name, String value) {
        m.h(builder, "builder");
        m.h(name, "name");
        m.h(value, "value");
        return builder.addLenient$okhttp(name, value);
    }
}