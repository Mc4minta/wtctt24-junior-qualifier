package com.coinbase.wallet.http;

import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.http.extensions.URL_HTTPKt;
import com.coinbase.wallet.http.models.HTTPResponse;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.http.models.QueryString;
import com.squareup.moshi.JsonAdapter;
import h.c.a0;
import h.c.b0;
import h.c.u0.a;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.http.cookie.ClientCookie;

/* compiled from: HTTP.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b(\u0010\u001bJz\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nH\u0086\b¢\u0006\u0004\b\u000e\u0010\u000fJz\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nH\u0086\b¢\u0006\u0004\b\u0010\u0010\u000fJK\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u0012\u0010\u0013JK\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u0014\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0000@\u0001X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0000@\u0001X\u0081\u0004¢\u0006\u0012\n\u0004\b#\u0010$\u0012\u0004\b'\u0010\u001b\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/coinbase/wallet/http/HTTP;", "", "T", "Lcom/coinbase/wallet/http/models/HTTPService;", "service", "", ClientCookie.PATH_ATTR, "", "parameters", "headers", "Lcom/squareup/moshi/JsonAdapter;", "parameterizedAdapter", "Lh/c/b0;", "Lcom/coinbase/wallet/http/models/HTTPResponse;", "get", "(Lcom/coinbase/wallet/http/models/HTTPService;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/squareup/moshi/JsonAdapter;)Lh/c/b0;", "post", "Lokhttp3/Request;", "buildGetRequest", "(Lcom/coinbase/wallet/http/models/HTTPService;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lokhttp3/Request;", "buildPostRequest", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "getClient$annotations", "()V", "", "kDefaultTimeout", "J", "Lokhttp3/MediaType;", "kJSONContentType", "Lokhttp3/MediaType;", "Lh/c/a0;", "schedulers", "Lh/c/a0;", "getSchedulers", "()Lh/c/a0;", "getSchedulers$annotations", "<init>", "http_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HTTP {
    private static final OkHttpClient client;
    public static final long kDefaultTimeout = 15;
    private static final a0 schedulers;
    public static final HTTP INSTANCE = new HTTP();
    private static final MediaType kJSONContentType = MediaType.Companion.get("application/json; charset=utf-8");

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        x xVar = x.a;
        client = builder.addNetworkInterceptor(httpLoggingInterceptor).connectTimeout(15L, TimeUnit.SECONDS).build();
        a0 c2 = a.c();
        m.f(c2, "io()");
        schedulers = c2;
    }

    private HTTP() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ b0 get$default(HTTP http, HTTPService service, String path, Map map, Map map2, JsonAdapter jsonAdapter, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            map = null;
        }
        if ((i2 & 8) != 0) {
            map2 = null;
        }
        if ((i2 & 16) != 0) {
            jsonAdapter = null;
        }
        m.g(service, "service");
        m.g(path, "path");
        CallEnqueueSingle callEnqueueSingle = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(service, path, map, map2));
        m.k();
        b0 subscribeOn = callEnqueueSingle.map(new HTTP$get$1(jsonAdapter)).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        return subscribeOn;
    }

    public static /* synthetic */ void getClient$annotations() {
    }

    public static /* synthetic */ void getSchedulers$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ b0 post$default(HTTP http, HTTPService service, String path, Map map, Map map2, JsonAdapter jsonAdapter, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            map = null;
        }
        if ((i2 & 8) != 0) {
            map2 = null;
        }
        if ((i2 & 16) != 0) {
            jsonAdapter = null;
        }
        m.g(service, "service");
        m.g(path, "path");
        CallEnqueueSingle callEnqueueSingle = new CallEnqueueSingle(http.getClient(), http.buildPostRequest(service, path, map, map2));
        m.k();
        b0 subscribeOn = callEnqueueSingle.map(new HTTP$post$1(jsonAdapter)).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildPostRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        return subscribeOn;
    }

    public final Request buildGetRequest(HTTPService service, String path, Map<String, String> map, Map<String, String> map2) {
        m.g(service, "service");
        m.g(path, "path");
        Request.Builder builder = new Request.Builder();
        URL appendingPathComponent = URL_HTTPKt.appendingPathComponent(service.getUrl(), path);
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                builder = builder.header(entry.getKey(), entry.getValue());
            }
        }
        if (map != null) {
            QueryString queryString = new QueryString();
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                queryString.add(entry2.getKey(), entry2.getValue());
            }
            StringBuilder sb = new StringBuilder();
            sb.append(appendingPathComponent);
            sb.append('?');
            sb.append(queryString);
            appendingPathComponent = new URL(sb.toString());
        }
        return builder.url(appendingPathComponent).build();
    }

    public final Request buildPostRequest(HTTPService service, String path, Map<String, ? extends Object> map, Map<String, String> map2) {
        RequestBody create;
        m.g(service, "service");
        m.g(path, "path");
        Request.Builder builder = new Request.Builder();
        URL appendingPathComponent = URL_HTTPKt.appendingPathComponent(service.getUrl(), path);
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                builder = builder.header(entry.getKey(), entry.getValue());
            }
        }
        if (map != null) {
            JSON json = JSON.INSTANCE;
            ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
            readLock.lock();
            try {
                String json2 = json.getMoshi().adapter(Map.class).toJson(map);
                m.f(json2, "adapter.toJson(instance)");
                readLock.unlock();
                create = RequestBody.Companion.create(kJSONContentType, json2);
            } catch (Throwable th) {
                readLock.unlock();
                throw th;
            }
        } else {
            create = RequestBody.Companion.create((MediaType) null, Strings_CoreKt.getEmpty(Strings.INSTANCE));
        }
        return builder.post(create).url(appendingPathComponent).build();
    }

    public final /* synthetic */ <T> b0<HTTPResponse<T>> get(HTTPService service, String path, Map<String, String> map, Map<String, String> map2, JsonAdapter<T> jsonAdapter) {
        m.g(service, "service");
        m.g(path, "path");
        CallEnqueueSingle callEnqueueSingle = new CallEnqueueSingle(getClient(), buildGetRequest(service, path, map, map2));
        m.k();
        b0<HTTPResponse<T>> subscribeOn = callEnqueueSingle.map(new HTTP$get$1(jsonAdapter)).subscribeOn(getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        return subscribeOn;
    }

    public final OkHttpClient getClient() {
        return client;
    }

    public final a0 getSchedulers() {
        return schedulers;
    }

    public final /* synthetic */ <T> b0<HTTPResponse<T>> post(HTTPService service, String path, Map<String, ? extends Object> map, Map<String, String> map2, JsonAdapter<T> jsonAdapter) {
        m.g(service, "service");
        m.g(path, "path");
        CallEnqueueSingle callEnqueueSingle = new CallEnqueueSingle(getClient(), buildPostRequest(service, path, map, map2));
        m.k();
        b0<HTTPResponse<T>> subscribeOn = callEnqueueSingle.map(new HTTP$post$1(jsonAdapter)).subscribeOn(getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildPostRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        return subscribeOn;
    }
}