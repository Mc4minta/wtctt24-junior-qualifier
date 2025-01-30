package okhttp3.internal.cache;

import com.appsflyer.internal.referrer.Payload;
import j.c0;
import j.e0;
import j.f;
import j.f0;
import j.g;
import j.h;
import j.q;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

/* compiled from: CacheInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/internal/cache/CacheRequest;", "cacheRequest", "Lokhttp3/Response;", Payload.RESPONSE, "cacheWritingResponse", "(Lokhttp3/internal/cache/CacheRequest;Lokhttp3/Response;)Lokhttp3/Response;", "Lokhttp3/Interceptor$Chain;", "chain", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/Cache;", "cache", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "<init>", "(Lokhttp3/Cache;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private final Cache cache;

    /* compiled from: CacheInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "Lokhttp3/Response;", Payload.RESPONSE, "stripBody", "(Lokhttp3/Response;)Lokhttp3/Response;", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "combine", "(Lokhttp3/Headers;Lokhttp3/Headers;)Lokhttp3/Headers;", "", "fieldName", "", "isEndToEnd", "(Ljava/lang/String;)Z", "isContentSpecificHeader", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            int i2;
            boolean A;
            boolean Q;
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (i2 = 0; i2 < size; i2 = i2 + 1) {
                String name = headers.name(i2);
                String value = headers.value(i2);
                A = x.A(HttpHeaders.WARNING, name, true);
                if (A) {
                    Q = x.Q(value, DiskLruCache.VERSION_1, false, 2, null);
                    i2 = Q ? i2 + 1 : 0;
                }
                if (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            int size2 = headers2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String name2 = headers2.name(i3);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    builder.addLenient$okhttp(name2, headers2.value(i3));
                }
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String str) {
            boolean A;
            boolean A2;
            boolean A3;
            A = x.A("Content-Length", str, true);
            if (A) {
                return true;
            }
            A2 = x.A("Content-Encoding", str, true);
            if (A2) {
                return true;
            }
            A3 = x.A("Content-Type", str, true);
            return A3;
        }

        private final boolean isEndToEnd(String str) {
            boolean A;
            boolean A2;
            boolean A3;
            boolean A4;
            boolean A5;
            boolean A6;
            boolean A7;
            boolean A8;
            A = x.A("Connection", str, true);
            if (!A) {
                A2 = x.A(HTTP.CONN_KEEP_ALIVE, str, true);
                if (!A2) {
                    A3 = x.A("Proxy-Authenticate", str, true);
                    if (!A3) {
                        A4 = x.A("Proxy-Authorization", str, true);
                        if (!A4) {
                            A5 = x.A(HttpHeaders.TE, str, true);
                            if (!A5) {
                                A6 = x.A("Trailers", str, true);
                                if (!A6) {
                                    A7 = x.A("Transfer-Encoding", str, true);
                                    if (!A7) {
                                        A8 = x.A(HttpHeaders.UPGRADE, str, true);
                                        if (!A8) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Response stripBody(Response response) {
            return (response != null ? response.body() : null) != null ? response.newBuilder().body(null).build() : response;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CacheInterceptor(Cache cache) {
        this.cache = cache;
    }

    private final Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        c0 body = cacheRequest.body();
        ResponseBody body2 = response.body();
        if (body2 == null) {
            m.q();
        }
        final h source = body2.source();
        final g c2 = q.c(body);
        e0 e0Var = new e0() { // from class: okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1
            private boolean cacheRequestClosed;

            @Override // j.e0, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                h.this.close();
            }

            public final boolean getCacheRequestClosed() {
                return this.cacheRequestClosed;
            }

            @Override // j.e0
            public long read(f sink, long j2) throws IOException {
                m.h(sink, "sink");
                try {
                    long read = h.this.read(sink, j2);
                    if (read == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            c2.close();
                        }
                        return -1L;
                    }
                    sink.f(c2.getBuffer(), sink.O0() - read, read);
                    c2.X();
                    return read;
                } catch (IOException e2) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e2;
                }
            }

            public final void setCacheRequestClosed(boolean z) {
                this.cacheRequestClosed = z;
            }

            @Override // j.e0
            public f0 timeout() {
                return h.this.timeout();
            }
        };
        return response.newBuilder().body(new RealResponseBody(Response.header$default(response, "Content-Type", null, 2, null), response.body().contentLength(), q.d(e0Var))).build();
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody body;
        ResponseBody body2;
        m.h(chain, "chain");
        Cache cache = this.cache;
        Response response = cache != null ? cache.get$okhttp(chain.request()) : null;
        CacheStrategy compute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse = compute.getCacheResponse();
        Cache cache2 = this.cache;
        if (cache2 != null) {
            cache2.trackResponse$okhttp(compute);
        }
        if (response != null && cacheResponse == null && (body2 = response.body()) != null) {
            Util.closeQuietly(body2);
        }
        if (networkRequest == null && cacheResponse == null) {
            return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(HttpStatus.SC_GATEWAY_TIMEOUT).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        if (networkRequest == null) {
            if (cacheResponse == null) {
                m.q();
            }
            return cacheResponse.newBuilder().cacheResponse(Companion.stripBody(cacheResponse)).build();
        }
        try {
            Response proceed = chain.proceed(networkRequest);
            if (proceed == null && response != null && body != null) {
            }
            if (cacheResponse != null) {
                if (proceed != null && proceed.code() == 304) {
                    Response.Builder newBuilder = cacheResponse.newBuilder();
                    Companion companion = Companion;
                    Response build = newBuilder.headers(companion.combine(cacheResponse.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(companion.stripBody(cacheResponse)).networkResponse(companion.stripBody(proceed)).build();
                    ResponseBody body3 = proceed.body();
                    if (body3 == null) {
                        m.q();
                    }
                    body3.close();
                    Cache cache3 = this.cache;
                    if (cache3 == null) {
                        m.q();
                    }
                    cache3.trackConditionalCacheHit$okhttp();
                    this.cache.update$okhttp(cacheResponse, build);
                    return build;
                }
                ResponseBody body4 = cacheResponse.body();
                if (body4 != null) {
                    Util.closeQuietly(body4);
                }
            }
            if (proceed == null) {
                m.q();
            }
            Response.Builder newBuilder2 = proceed.newBuilder();
            Companion companion2 = Companion;
            Response build2 = newBuilder2.cacheResponse(companion2.stripBody(cacheResponse)).networkResponse(companion2.stripBody(proceed)).build();
            if (this.cache != null) {
                if (okhttp3.internal.http.HttpHeaders.promisesBody(build2) && CacheStrategy.Companion.isCacheable(build2, networkRequest)) {
                    return cacheWritingResponse(this.cache.put$okhttp(build2), build2);
                }
                if (HttpMethod.INSTANCE.invalidatesCache(networkRequest.method())) {
                    try {
                        this.cache.remove$okhttp(networkRequest);
                    } catch (IOException unused) {
                    }
                }
            }
            return build2;
        } finally {
            if (response != null && (body = response.body()) != null) {
                Util.closeQuietly(body);
            }
        }
    }
}