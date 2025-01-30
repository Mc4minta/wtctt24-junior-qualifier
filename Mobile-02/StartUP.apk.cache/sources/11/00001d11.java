package com.coinbase.wallet.featureflags.apis;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.featureflags.extensions.StoreKeys_FeatureFlagsKt;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.apache.http.cookie.ClientCookie;

/* compiled from: RPC.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJp\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0086\b¢\u0006\u0004\b\r\u0010\u000eJp\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0086\b¢\u0006\u0004\b\u000f\u0010\u000eJd\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0081\b¢\u0006\u0004\b\u0010\u0010\u0011Jd\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0081\b¢\u0006\u0004\b\u0012\u0010\u0011R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/featureflags/apis/RPC;", "", "T", "Lcom/coinbase/wallet/http/models/HTTPService;", "service", "", ClientCookie.PATH_ATTR, "", "isAuthRequired", "", "parameters", "headers", "Lh/c/b0;", "get", "(Lcom/coinbase/wallet/http/models/HTTPService;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;)Lh/c/b0;", "post", "getProtected", "(Lcom/coinbase/wallet/http/models/HTTPService;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lh/c/b0;", "postProtected", ApiConstants.TOKEN, "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "featureflags_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RPC {
    private final String token;

    public RPC(StoreInterface store) {
        m.g(store, "store");
        this.token = (String) store.get(StoreKeys_FeatureFlagsKt.getAccessToken(StoreKeys.INSTANCE));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        r6 = kotlin.a0.m0.o(r6, r1);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ h.c.b0 get$default(com.coinbase.wallet.featureflags.apis.RPC r1, com.coinbase.wallet.http.models.HTTPService r2, java.lang.String r3, java.lang.Boolean r4, java.util.Map r5, java.util.Map r6, int r7, java.lang.Object r8) {
        /*
            r8 = r7 & 4
            if (r8 == 0) goto L6
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
        L6:
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto Lc
            r5 = r0
        Lc:
            r7 = r7 & 16
            if (r7 == 0) goto L11
            r6 = r0
        L11:
            java.lang.String r7 = "service"
            kotlin.jvm.internal.m.g(r2, r7)
            java.lang.String r7 = "path"
            kotlin.jvm.internal.m.g(r3, r7)
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.jvm.internal.m.c(r4, r7)
            java.lang.String r7 = "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)"
            if (r4 == 0) goto L7d
            java.lang.String r1 = r1.getToken()
            java.lang.String r4 = "Bearer "
            java.lang.String r1 = kotlin.jvm.internal.m.o(r4, r1)
            java.lang.String r4 = "Authorization"
            kotlin.o r1 = kotlin.u.a(r4, r1)
            java.util.Map r1 = kotlin.a0.j0.e(r1)
            com.coinbase.wallet.http.HTTP r4 = com.coinbase.wallet.http.HTTP.INSTANCE
            if (r6 != 0) goto L3e
            goto L46
        L3e:
            java.util.Map r6 = kotlin.a0.j0.o(r6, r1)
            if (r6 != 0) goto L45
            goto L46
        L45:
            r1 = r6
        L46:
            okhttp3.Request r1 = r4.buildGetRequest(r2, r3, r5, r1)
            com.coinbase.wallet.http.CallEnqueueSingle r2 = new com.coinbase.wallet.http.CallEnqueueSingle
            okhttp3.OkHttpClient r3 = r4.getClient()
            r2.<init>(r3, r1)
            kotlin.jvm.internal.m.k()
            com.coinbase.wallet.featureflags.apis.RPC$get$$inlined$getProtected$1 r1 = new com.coinbase.wallet.featureflags.apis.RPC$get$$inlined$getProtected$1
            r1.<init>(r0)
            h.c.b0 r1 = r2.map(r1)
            h.c.a0 r2 = r4.getSchedulers()
            h.c.b0 r1 = r1.subscribeOn(r2)
            kotlin.jvm.internal.m.f(r1, r7)
            com.coinbase.wallet.featureflags.apis.RPC$getProtected$1<T, R> r2 = com.coinbase.wallet.featureflags.apis.RPC$getProtected$1.INSTANCE
            h.c.b0 r1 = r1.map(r2)
            java.lang.String r2 = "HTTP.get<T>(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers?.plus(authHeader) ?: authHeader\n        ).map { response ->\n            response.body\n        }"
            kotlin.jvm.internal.m.f(r1, r2)
            r2 = 3
            com.coinbase.wallet.featureflags.apis.RPC$getProtected$2 r3 = com.coinbase.wallet.featureflags.apis.RPC$getProtected$2.INSTANCE
            h.c.b0 r1 = com.coinbase.wallet.core.extensions.Single_CoreKt.retryIfNeeded(r1, r2, r3)
            return r1
        L7d:
            com.coinbase.wallet.http.HTTP r1 = com.coinbase.wallet.http.HTTP.INSTANCE
            okhttp3.Request r2 = r1.buildGetRequest(r2, r3, r5, r6)
            com.coinbase.wallet.http.CallEnqueueSingle r3 = new com.coinbase.wallet.http.CallEnqueueSingle
            okhttp3.OkHttpClient r4 = r1.getClient()
            r3.<init>(r4, r2)
            kotlin.jvm.internal.m.k()
            com.coinbase.wallet.featureflags.apis.RPC$get$$inlined$get$default$1 r2 = new com.coinbase.wallet.featureflags.apis.RPC$get$$inlined$get$default$1
            r2.<init>(r0)
            h.c.b0 r2 = r3.map(r2)
            h.c.a0 r1 = r1.getSchedulers()
            h.c.b0 r1 = r2.subscribeOn(r1)
            kotlin.jvm.internal.m.f(r1, r7)
            com.coinbase.wallet.featureflags.apis.RPC$get$1<T, R> r2 = com.coinbase.wallet.featureflags.apis.RPC$get$1.INSTANCE
            h.c.b0 r1 = r1.map(r2)
            java.lang.String r2 = "HTTP\n            .get<T>(\n                service = service,\n                path = path,\n                parameters = parameters,\n                headers = headers\n            ).map { it.body }"
            kotlin.jvm.internal.m.f(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.featureflags.apis.RPC.get$default(com.coinbase.wallet.featureflags.apis.RPC, com.coinbase.wallet.http.models.HTTPService, java.lang.String, java.lang.Boolean, java.util.Map, java.util.Map, int, java.lang.Object):h.c.b0");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
        r5 = kotlin.a0.m0.o(r5, r1);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ h.c.b0 getProtected$default(com.coinbase.wallet.featureflags.apis.RPC r1, com.coinbase.wallet.http.models.HTTPService r2, java.lang.String r3, java.util.Map r4, java.util.Map r5, int r6, java.lang.Object r7) {
        /*
            r7 = r6 & 4
            r0 = 0
            if (r7 == 0) goto L6
            r4 = r0
        L6:
            r6 = r6 & 8
            if (r6 == 0) goto Lb
            r5 = r0
        Lb:
            java.lang.String r6 = "service"
            kotlin.jvm.internal.m.g(r2, r6)
            java.lang.String r6 = "path"
            kotlin.jvm.internal.m.g(r3, r6)
            java.lang.String r1 = r1.getToken()
            java.lang.String r6 = "Bearer "
            java.lang.String r1 = kotlin.jvm.internal.m.o(r6, r1)
            java.lang.String r6 = "Authorization"
            kotlin.o r1 = kotlin.u.a(r6, r1)
            java.util.Map r1 = kotlin.a0.j0.e(r1)
            com.coinbase.wallet.http.HTTP r6 = com.coinbase.wallet.http.HTTP.INSTANCE
            if (r5 != 0) goto L2e
            goto L36
        L2e:
            java.util.Map r5 = kotlin.a0.j0.o(r5, r1)
            if (r5 != 0) goto L35
            goto L36
        L35:
            r1 = r5
        L36:
            okhttp3.Request r1 = r6.buildGetRequest(r2, r3, r4, r1)
            com.coinbase.wallet.http.CallEnqueueSingle r2 = new com.coinbase.wallet.http.CallEnqueueSingle
            okhttp3.OkHttpClient r3 = r6.getClient()
            r2.<init>(r3, r1)
            kotlin.jvm.internal.m.k()
            com.coinbase.wallet.featureflags.apis.RPC$getProtected$$inlined$get$default$1 r1 = new com.coinbase.wallet.featureflags.apis.RPC$getProtected$$inlined$get$default$1
            r1.<init>(r0)
            h.c.b0 r1 = r2.map(r1)
            h.c.a0 r2 = r6.getSchedulers()
            h.c.b0 r1 = r1.subscribeOn(r2)
            java.lang.String r2 = "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)"
            kotlin.jvm.internal.m.f(r1, r2)
            com.coinbase.wallet.featureflags.apis.RPC$getProtected$1<T, R> r2 = com.coinbase.wallet.featureflags.apis.RPC$getProtected$1.INSTANCE
            h.c.b0 r1 = r1.map(r2)
            java.lang.String r2 = "HTTP.get<T>(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers?.plus(authHeader) ?: authHeader\n        ).map { response ->\n            response.body\n        }"
            kotlin.jvm.internal.m.f(r1, r2)
            r2 = 3
            com.coinbase.wallet.featureflags.apis.RPC$getProtected$2 r3 = com.coinbase.wallet.featureflags.apis.RPC$getProtected$2.INSTANCE
            h.c.b0 r1 = com.coinbase.wallet.core.extensions.Single_CoreKt.retryIfNeeded(r1, r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.featureflags.apis.RPC.getProtected$default(com.coinbase.wallet.featureflags.apis.RPC, com.coinbase.wallet.http.models.HTTPService, java.lang.String, java.util.Map, java.util.Map, int, java.lang.Object):h.c.b0");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        r6 = kotlin.a0.m0.o(r6, r1);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ h.c.b0 post$default(com.coinbase.wallet.featureflags.apis.RPC r1, com.coinbase.wallet.http.models.HTTPService r2, java.lang.String r3, java.lang.Boolean r4, java.util.Map r5, java.util.Map r6, int r7, java.lang.Object r8) {
        /*
            r8 = r7 & 4
            if (r8 == 0) goto L6
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
        L6:
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto Lc
            r5 = r0
        Lc:
            r7 = r7 & 16
            if (r7 == 0) goto L11
            r6 = r0
        L11:
            java.lang.String r7 = "service"
            kotlin.jvm.internal.m.g(r2, r7)
            java.lang.String r7 = "path"
            kotlin.jvm.internal.m.g(r3, r7)
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.jvm.internal.m.c(r4, r7)
            java.lang.String r7 = "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildPostRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)"
            if (r4 == 0) goto L7d
            java.lang.String r1 = r1.getToken()
            java.lang.String r4 = "Bearer "
            java.lang.String r1 = kotlin.jvm.internal.m.o(r4, r1)
            java.lang.String r4 = "Authorization"
            kotlin.o r1 = kotlin.u.a(r4, r1)
            java.util.Map r1 = kotlin.a0.j0.e(r1)
            com.coinbase.wallet.http.HTTP r4 = com.coinbase.wallet.http.HTTP.INSTANCE
            if (r6 != 0) goto L3e
            goto L46
        L3e:
            java.util.Map r6 = kotlin.a0.j0.o(r6, r1)
            if (r6 != 0) goto L45
            goto L46
        L45:
            r1 = r6
        L46:
            okhttp3.Request r1 = r4.buildPostRequest(r2, r3, r5, r1)
            com.coinbase.wallet.http.CallEnqueueSingle r2 = new com.coinbase.wallet.http.CallEnqueueSingle
            okhttp3.OkHttpClient r3 = r4.getClient()
            r2.<init>(r3, r1)
            kotlin.jvm.internal.m.k()
            com.coinbase.wallet.featureflags.apis.RPC$post$$inlined$postProtected$1 r1 = new com.coinbase.wallet.featureflags.apis.RPC$post$$inlined$postProtected$1
            r1.<init>(r0)
            h.c.b0 r1 = r2.map(r1)
            h.c.a0 r2 = r4.getSchedulers()
            h.c.b0 r1 = r1.subscribeOn(r2)
            kotlin.jvm.internal.m.f(r1, r7)
            com.coinbase.wallet.featureflags.apis.RPC$postProtected$1<T, R> r2 = com.coinbase.wallet.featureflags.apis.RPC$postProtected$1.INSTANCE
            h.c.b0 r1 = r1.map(r2)
            java.lang.String r2 = "HTTP.post<T>(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers?.plus(authHeader) ?: authHeader\n        ).map { response ->\n            response.body\n        }"
            kotlin.jvm.internal.m.f(r1, r2)
            r2 = 3
            com.coinbase.wallet.featureflags.apis.RPC$postProtected$2 r3 = com.coinbase.wallet.featureflags.apis.RPC$postProtected$2.INSTANCE
            h.c.b0 r1 = com.coinbase.wallet.core.extensions.Single_CoreKt.retryIfNeeded(r1, r2, r3)
            return r1
        L7d:
            com.coinbase.wallet.http.HTTP r1 = com.coinbase.wallet.http.HTTP.INSTANCE
            okhttp3.Request r2 = r1.buildPostRequest(r2, r3, r5, r6)
            com.coinbase.wallet.http.CallEnqueueSingle r3 = new com.coinbase.wallet.http.CallEnqueueSingle
            okhttp3.OkHttpClient r4 = r1.getClient()
            r3.<init>(r4, r2)
            kotlin.jvm.internal.m.k()
            com.coinbase.wallet.featureflags.apis.RPC$post$$inlined$post$default$1 r2 = new com.coinbase.wallet.featureflags.apis.RPC$post$$inlined$post$default$1
            r2.<init>(r0)
            h.c.b0 r2 = r3.map(r2)
            h.c.a0 r1 = r1.getSchedulers()
            h.c.b0 r1 = r2.subscribeOn(r1)
            kotlin.jvm.internal.m.f(r1, r7)
            com.coinbase.wallet.featureflags.apis.RPC$post$1<T, R> r2 = com.coinbase.wallet.featureflags.apis.RPC$post$1.INSTANCE
            h.c.b0 r1 = r1.map(r2)
            java.lang.String r2 = "HTTP.post<T>(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        ).map { response ->\n            response.body\n        }"
            kotlin.jvm.internal.m.f(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.featureflags.apis.RPC.post$default(com.coinbase.wallet.featureflags.apis.RPC, com.coinbase.wallet.http.models.HTTPService, java.lang.String, java.lang.Boolean, java.util.Map, java.util.Map, int, java.lang.Object):h.c.b0");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
        r5 = kotlin.a0.m0.o(r5, r1);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ h.c.b0 postProtected$default(com.coinbase.wallet.featureflags.apis.RPC r1, com.coinbase.wallet.http.models.HTTPService r2, java.lang.String r3, java.util.Map r4, java.util.Map r5, int r6, java.lang.Object r7) {
        /*
            r7 = r6 & 4
            r0 = 0
            if (r7 == 0) goto L6
            r4 = r0
        L6:
            r6 = r6 & 8
            if (r6 == 0) goto Lb
            r5 = r0
        Lb:
            java.lang.String r6 = "service"
            kotlin.jvm.internal.m.g(r2, r6)
            java.lang.String r6 = "path"
            kotlin.jvm.internal.m.g(r3, r6)
            java.lang.String r1 = r1.getToken()
            java.lang.String r6 = "Bearer "
            java.lang.String r1 = kotlin.jvm.internal.m.o(r6, r1)
            java.lang.String r6 = "Authorization"
            kotlin.o r1 = kotlin.u.a(r6, r1)
            java.util.Map r1 = kotlin.a0.j0.e(r1)
            com.coinbase.wallet.http.HTTP r6 = com.coinbase.wallet.http.HTTP.INSTANCE
            if (r5 != 0) goto L2e
            goto L36
        L2e:
            java.util.Map r5 = kotlin.a0.j0.o(r5, r1)
            if (r5 != 0) goto L35
            goto L36
        L35:
            r1 = r5
        L36:
            okhttp3.Request r1 = r6.buildPostRequest(r2, r3, r4, r1)
            com.coinbase.wallet.http.CallEnqueueSingle r2 = new com.coinbase.wallet.http.CallEnqueueSingle
            okhttp3.OkHttpClient r3 = r6.getClient()
            r2.<init>(r3, r1)
            kotlin.jvm.internal.m.k()
            com.coinbase.wallet.featureflags.apis.RPC$postProtected$$inlined$post$default$1 r1 = new com.coinbase.wallet.featureflags.apis.RPC$postProtected$$inlined$post$default$1
            r1.<init>(r0)
            h.c.b0 r1 = r2.map(r1)
            h.c.a0 r2 = r6.getSchedulers()
            h.c.b0 r1 = r1.subscribeOn(r2)
            java.lang.String r2 = "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildPostRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)"
            kotlin.jvm.internal.m.f(r1, r2)
            com.coinbase.wallet.featureflags.apis.RPC$postProtected$1<T, R> r2 = com.coinbase.wallet.featureflags.apis.RPC$postProtected$1.INSTANCE
            h.c.b0 r1 = r1.map(r2)
            java.lang.String r2 = "HTTP.post<T>(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers?.plus(authHeader) ?: authHeader\n        ).map { response ->\n            response.body\n        }"
            kotlin.jvm.internal.m.f(r1, r2)
            r2 = 3
            com.coinbase.wallet.featureflags.apis.RPC$postProtected$2 r3 = com.coinbase.wallet.featureflags.apis.RPC$postProtected$2.INSTANCE
            h.c.b0 r1 = com.coinbase.wallet.core.extensions.Single_CoreKt.retryIfNeeded(r1, r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.featureflags.apis.RPC.postProtected$default(com.coinbase.wallet.featureflags.apis.RPC, com.coinbase.wallet.http.models.HTTPService, java.lang.String, java.util.Map, java.util.Map, int, java.lang.Object):h.c.b0");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
        r8 = kotlin.a0.m0.o(r8, r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ <T> h.c.b0<T> get(com.coinbase.wallet.http.models.HTTPService r4, java.lang.String r5, java.lang.Boolean r6, java.util.Map<java.lang.String, java.lang.String> r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            r3 = this;
            java.lang.String r0 = "service"
            kotlin.jvm.internal.m.g(r4, r0)
            java.lang.String r0 = "path"
            kotlin.jvm.internal.m.g(r5, r0)
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.jvm.internal.m.c(r6, r0)
            java.lang.String r0 = "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)"
            r1 = 0
            if (r6 == 0) goto L6d
            java.lang.String r6 = r3.getToken()
            java.lang.String r2 = "Bearer "
            java.lang.String r6 = kotlin.jvm.internal.m.o(r2, r6)
            java.lang.String r2 = "Authorization"
            kotlin.o r6 = kotlin.u.a(r2, r6)
            java.util.Map r6 = kotlin.a0.j0.e(r6)
            com.coinbase.wallet.http.HTTP r2 = com.coinbase.wallet.http.HTTP.INSTANCE
            if (r8 != 0) goto L2e
            goto L36
        L2e:
            java.util.Map r8 = kotlin.a0.j0.o(r8, r6)
            if (r8 != 0) goto L35
            goto L36
        L35:
            r6 = r8
        L36:
            okhttp3.Request r4 = r2.buildGetRequest(r4, r5, r7, r6)
            com.coinbase.wallet.http.CallEnqueueSingle r5 = new com.coinbase.wallet.http.CallEnqueueSingle
            okhttp3.OkHttpClient r6 = r2.getClient()
            r5.<init>(r6, r4)
            kotlin.jvm.internal.m.k()
            com.coinbase.wallet.featureflags.apis.RPC$get$$inlined$getProtected$1 r4 = new com.coinbase.wallet.featureflags.apis.RPC$get$$inlined$getProtected$1
            r4.<init>(r1)
            h.c.b0 r4 = r5.map(r4)
            h.c.a0 r5 = r2.getSchedulers()
            h.c.b0 r4 = r4.subscribeOn(r5)
            kotlin.jvm.internal.m.f(r4, r0)
            com.coinbase.wallet.featureflags.apis.RPC$getProtected$1<T, R> r5 = com.coinbase.wallet.featureflags.apis.RPC$getProtected$1.INSTANCE
            h.c.b0 r4 = r4.map(r5)
            java.lang.String r5 = "HTTP.get<T>(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers?.plus(authHeader) ?: authHeader\n        ).map { response ->\n            response.body\n        }"
            kotlin.jvm.internal.m.f(r4, r5)
            r5 = 3
            com.coinbase.wallet.featureflags.apis.RPC$getProtected$2 r6 = com.coinbase.wallet.featureflags.apis.RPC$getProtected$2.INSTANCE
            h.c.b0 r4 = com.coinbase.wallet.core.extensions.Single_CoreKt.retryIfNeeded(r4, r5, r6)
            return r4
        L6d:
            com.coinbase.wallet.http.HTTP r6 = com.coinbase.wallet.http.HTTP.INSTANCE
            okhttp3.Request r4 = r6.buildGetRequest(r4, r5, r7, r8)
            com.coinbase.wallet.http.CallEnqueueSingle r5 = new com.coinbase.wallet.http.CallEnqueueSingle
            okhttp3.OkHttpClient r7 = r6.getClient()
            r5.<init>(r7, r4)
            kotlin.jvm.internal.m.k()
            com.coinbase.wallet.featureflags.apis.RPC$get$$inlined$get$default$1 r4 = new com.coinbase.wallet.featureflags.apis.RPC$get$$inlined$get$default$1
            r4.<init>(r1)
            h.c.b0 r4 = r5.map(r4)
            h.c.a0 r5 = r6.getSchedulers()
            h.c.b0 r4 = r4.subscribeOn(r5)
            kotlin.jvm.internal.m.f(r4, r0)
            com.coinbase.wallet.featureflags.apis.RPC$get$1<T, R> r5 = com.coinbase.wallet.featureflags.apis.RPC$get$1.INSTANCE
            h.c.b0 r4 = r4.map(r5)
            java.lang.String r5 = "HTTP\n            .get<T>(\n                service = service,\n                path = path,\n                parameters = parameters,\n                headers = headers\n            ).map { it.body }"
            kotlin.jvm.internal.m.f(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.featureflags.apis.RPC.get(com.coinbase.wallet.http.models.HTTPService, java.lang.String, java.lang.Boolean, java.util.Map, java.util.Map):h.c.b0");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0023, code lost:
        r6 = kotlin.a0.m0.o(r6, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ <T> h.c.b0<T> getProtected(com.coinbase.wallet.http.models.HTTPService r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r2 = this;
            java.lang.String r0 = "service"
            kotlin.jvm.internal.m.g(r3, r0)
            java.lang.String r0 = "path"
            kotlin.jvm.internal.m.g(r4, r0)
            java.lang.String r0 = r2.getToken()
            java.lang.String r1 = "Bearer "
            java.lang.String r0 = kotlin.jvm.internal.m.o(r1, r0)
            java.lang.String r1 = "Authorization"
            kotlin.o r0 = kotlin.u.a(r1, r0)
            java.util.Map r0 = kotlin.a0.j0.e(r0)
            com.coinbase.wallet.http.HTTP r1 = com.coinbase.wallet.http.HTTP.INSTANCE
            if (r6 != 0) goto L23
            goto L2b
        L23:
            java.util.Map r6 = kotlin.a0.j0.o(r6, r0)
            if (r6 != 0) goto L2a
            goto L2b
        L2a:
            r0 = r6
        L2b:
            r6 = 0
            okhttp3.Request r3 = r1.buildGetRequest(r3, r4, r5, r0)
            com.coinbase.wallet.http.CallEnqueueSingle r4 = new com.coinbase.wallet.http.CallEnqueueSingle
            okhttp3.OkHttpClient r5 = r1.getClient()
            r4.<init>(r5, r3)
            kotlin.jvm.internal.m.k()
            com.coinbase.wallet.featureflags.apis.RPC$getProtected$$inlined$get$default$1 r3 = new com.coinbase.wallet.featureflags.apis.RPC$getProtected$$inlined$get$default$1
            r3.<init>(r6)
            h.c.b0 r3 = r4.map(r3)
            h.c.a0 r4 = r1.getSchedulers()
            h.c.b0 r3 = r3.subscribeOn(r4)
            java.lang.String r4 = "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)"
            kotlin.jvm.internal.m.f(r3, r4)
            com.coinbase.wallet.featureflags.apis.RPC$getProtected$1<T, R> r4 = com.coinbase.wallet.featureflags.apis.RPC$getProtected$1.INSTANCE
            h.c.b0 r3 = r3.map(r4)
            java.lang.String r4 = "HTTP.get<T>(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers?.plus(authHeader) ?: authHeader\n        ).map { response ->\n            response.body\n        }"
            kotlin.jvm.internal.m.f(r3, r4)
            r4 = 3
            com.coinbase.wallet.featureflags.apis.RPC$getProtected$2 r5 = com.coinbase.wallet.featureflags.apis.RPC$getProtected$2.INSTANCE
            h.c.b0 r3 = com.coinbase.wallet.core.extensions.Single_CoreKt.retryIfNeeded(r3, r4, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.featureflags.apis.RPC.getProtected(com.coinbase.wallet.http.models.HTTPService, java.lang.String, java.util.Map, java.util.Map):h.c.b0");
    }

    public final String getToken() {
        return this.token;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
        r8 = kotlin.a0.m0.o(r8, r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ <T> h.c.b0<T> post(com.coinbase.wallet.http.models.HTTPService r4, java.lang.String r5, java.lang.Boolean r6, java.util.Map<java.lang.String, java.lang.String> r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            r3 = this;
            java.lang.String r0 = "service"
            kotlin.jvm.internal.m.g(r4, r0)
            java.lang.String r0 = "path"
            kotlin.jvm.internal.m.g(r5, r0)
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.jvm.internal.m.c(r6, r0)
            java.lang.String r0 = "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildPostRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)"
            r1 = 0
            if (r6 == 0) goto L6d
            java.lang.String r6 = r3.getToken()
            java.lang.String r2 = "Bearer "
            java.lang.String r6 = kotlin.jvm.internal.m.o(r2, r6)
            java.lang.String r2 = "Authorization"
            kotlin.o r6 = kotlin.u.a(r2, r6)
            java.util.Map r6 = kotlin.a0.j0.e(r6)
            com.coinbase.wallet.http.HTTP r2 = com.coinbase.wallet.http.HTTP.INSTANCE
            if (r8 != 0) goto L2e
            goto L36
        L2e:
            java.util.Map r8 = kotlin.a0.j0.o(r8, r6)
            if (r8 != 0) goto L35
            goto L36
        L35:
            r6 = r8
        L36:
            okhttp3.Request r4 = r2.buildPostRequest(r4, r5, r7, r6)
            com.coinbase.wallet.http.CallEnqueueSingle r5 = new com.coinbase.wallet.http.CallEnqueueSingle
            okhttp3.OkHttpClient r6 = r2.getClient()
            r5.<init>(r6, r4)
            kotlin.jvm.internal.m.k()
            com.coinbase.wallet.featureflags.apis.RPC$post$$inlined$postProtected$1 r4 = new com.coinbase.wallet.featureflags.apis.RPC$post$$inlined$postProtected$1
            r4.<init>(r1)
            h.c.b0 r4 = r5.map(r4)
            h.c.a0 r5 = r2.getSchedulers()
            h.c.b0 r4 = r4.subscribeOn(r5)
            kotlin.jvm.internal.m.f(r4, r0)
            com.coinbase.wallet.featureflags.apis.RPC$postProtected$1<T, R> r5 = com.coinbase.wallet.featureflags.apis.RPC$postProtected$1.INSTANCE
            h.c.b0 r4 = r4.map(r5)
            java.lang.String r5 = "HTTP.post<T>(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers?.plus(authHeader) ?: authHeader\n        ).map { response ->\n            response.body\n        }"
            kotlin.jvm.internal.m.f(r4, r5)
            r5 = 3
            com.coinbase.wallet.featureflags.apis.RPC$postProtected$2 r6 = com.coinbase.wallet.featureflags.apis.RPC$postProtected$2.INSTANCE
            h.c.b0 r4 = com.coinbase.wallet.core.extensions.Single_CoreKt.retryIfNeeded(r4, r5, r6)
            return r4
        L6d:
            com.coinbase.wallet.http.HTTP r6 = com.coinbase.wallet.http.HTTP.INSTANCE
            okhttp3.Request r4 = r6.buildPostRequest(r4, r5, r7, r8)
            com.coinbase.wallet.http.CallEnqueueSingle r5 = new com.coinbase.wallet.http.CallEnqueueSingle
            okhttp3.OkHttpClient r7 = r6.getClient()
            r5.<init>(r7, r4)
            kotlin.jvm.internal.m.k()
            com.coinbase.wallet.featureflags.apis.RPC$post$$inlined$post$default$1 r4 = new com.coinbase.wallet.featureflags.apis.RPC$post$$inlined$post$default$1
            r4.<init>(r1)
            h.c.b0 r4 = r5.map(r4)
            h.c.a0 r5 = r6.getSchedulers()
            h.c.b0 r4 = r4.subscribeOn(r5)
            kotlin.jvm.internal.m.f(r4, r0)
            com.coinbase.wallet.featureflags.apis.RPC$post$1<T, R> r5 = com.coinbase.wallet.featureflags.apis.RPC$post$1.INSTANCE
            h.c.b0 r4 = r4.map(r5)
            java.lang.String r5 = "HTTP.post<T>(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        ).map { response ->\n            response.body\n        }"
            kotlin.jvm.internal.m.f(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.featureflags.apis.RPC.post(com.coinbase.wallet.http.models.HTTPService, java.lang.String, java.lang.Boolean, java.util.Map, java.util.Map):h.c.b0");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0023, code lost:
        r6 = kotlin.a0.m0.o(r6, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ <T> h.c.b0<T> postProtected(com.coinbase.wallet.http.models.HTTPService r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r2 = this;
            java.lang.String r0 = "service"
            kotlin.jvm.internal.m.g(r3, r0)
            java.lang.String r0 = "path"
            kotlin.jvm.internal.m.g(r4, r0)
            java.lang.String r0 = r2.getToken()
            java.lang.String r1 = "Bearer "
            java.lang.String r0 = kotlin.jvm.internal.m.o(r1, r0)
            java.lang.String r1 = "Authorization"
            kotlin.o r0 = kotlin.u.a(r1, r0)
            java.util.Map r0 = kotlin.a0.j0.e(r0)
            com.coinbase.wallet.http.HTTP r1 = com.coinbase.wallet.http.HTTP.INSTANCE
            if (r6 != 0) goto L23
            goto L2b
        L23:
            java.util.Map r6 = kotlin.a0.j0.o(r6, r0)
            if (r6 != 0) goto L2a
            goto L2b
        L2a:
            r0 = r6
        L2b:
            r6 = 0
            okhttp3.Request r3 = r1.buildPostRequest(r3, r4, r5, r0)
            com.coinbase.wallet.http.CallEnqueueSingle r4 = new com.coinbase.wallet.http.CallEnqueueSingle
            okhttp3.OkHttpClient r5 = r1.getClient()
            r4.<init>(r5, r3)
            kotlin.jvm.internal.m.k()
            com.coinbase.wallet.featureflags.apis.RPC$postProtected$$inlined$post$default$1 r3 = new com.coinbase.wallet.featureflags.apis.RPC$postProtected$$inlined$post$default$1
            r3.<init>(r6)
            h.c.b0 r3 = r4.map(r3)
            h.c.a0 r4 = r1.getSchedulers()
            h.c.b0 r3 = r3.subscribeOn(r4)
            java.lang.String r4 = "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildPostRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)"
            kotlin.jvm.internal.m.f(r3, r4)
            com.coinbase.wallet.featureflags.apis.RPC$postProtected$1<T, R> r4 = com.coinbase.wallet.featureflags.apis.RPC$postProtected$1.INSTANCE
            h.c.b0 r3 = r3.map(r4)
            java.lang.String r4 = "HTTP.post<T>(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers?.plus(authHeader) ?: authHeader\n        ).map { response ->\n            response.body\n        }"
            kotlin.jvm.internal.m.f(r3, r4)
            r4 = 3
            com.coinbase.wallet.featureflags.apis.RPC$postProtected$2 r5 = com.coinbase.wallet.featureflags.apis.RPC$postProtected$2.INSTANCE
            h.c.b0 r3 = com.coinbase.wallet.core.extensions.Single_CoreKt.retryIfNeeded(r3, r4, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.featureflags.apis.RPC.postProtected(com.coinbase.wallet.http.models.HTTPService, java.lang.String, java.util.Map, java.util.Map):h.c.b0");
    }
}