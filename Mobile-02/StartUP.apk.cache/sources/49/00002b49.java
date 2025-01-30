package com.coinbase.walletlink.apis;

import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.wallet.http.CallEnqueueSingle;
import com.coinbase.wallet.http.HTTP;
import com.coinbase.wallet.http.models.HTTPResponse;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.walletlink.dtos.EventDTO;
import com.coinbase.walletlink.dtos.GetEventsDTO;
import com.coinbase.walletlink.dtos.ServerRequestDTO;
import com.coinbase.walletlink.extensions.Single_WalletLinkKt;
import com.coinbase.walletlink.models.Credentials;
import com.coinbase.walletlink.models.ServerMessageType;
import com.coinbase.walletlink.models.Session;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: WalletLinkAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/coinbase/walletlink/apis/WalletLinkAPI;", "", "", WalletLinkPushNotification.eventIdKey, WalletLinkPushNotification.sessionIdKey, "secret", "Ljava/net/URL;", "url", "Lh/c/b0;", "Lkotlin/x;", "markEventAsSeen", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;)Lh/c/b0;", "Lcom/coinbase/walletlink/models/Session;", "session", "", "Lcom/coinbase/walletlink/dtos/ServerRequestDTO;", "getUnseenEvents", "(Lcom/coinbase/walletlink/models/Session;)Lh/c/b0;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletLinkAPI {
    public static /* synthetic */ List a(Session session, HTTPResponse hTTPResponse) {
        return m2135getUnseenEvents$lambda2(session, hTTPResponse);
    }

    public static /* synthetic */ kotlin.x b(Throwable th) {
        return m2136markEventAsSeen$lambda0(th);
    }

    /* renamed from: getUnseenEvents$lambda-2 */
    public static final List m2135getUnseenEvents$lambda2(Session session, HTTPResponse response) {
        int r;
        kotlin.jvm.internal.m.g(session, "$session");
        kotlin.jvm.internal.m.g(response, "response");
        List<EventDTO> events = ((GetEventsDTO) response.getBody()).getEvents();
        if (events == null) {
            events = kotlin.a0.r.g();
        }
        r = kotlin.a0.s.r(events, 10);
        ArrayList arrayList = new ArrayList(r);
        for (EventDTO eventDTO : events) {
            arrayList.add(new ServerRequestDTO(session.getId(), ServerMessageType.Event, eventDTO.getEvent(), eventDTO.getId(), eventDTO.getData()));
        }
        return arrayList;
    }

    /* renamed from: markEventAsSeen$lambda-0 */
    public static final kotlin.x m2136markEventAsSeen$lambda0(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    public final h.c.b0<List<ServerRequestDTO>> getUnseenEvents(final Session session) {
        Map<String, String> e2;
        kotlin.jvm.internal.m.g(session, "session");
        Credentials credentials = new Credentials(session.getId(), session.getSecret());
        HTTPService hTTPService = new HTTPService(session.getUrl());
        Map<String, String> basicAuthHeaders = credentials.getBasicAuthHeaders();
        e2 = kotlin.a0.l0.e(kotlin.u.a("unseen", "true"));
        HTTP http = HTTP.INSTANCE;
        h.c.b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(hTTPService, "/events", e2, basicAuthHeaders)).map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.WalletLinkAPI$getUnseenEvents$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.walletlink.dtos.GetEventsDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.walletlink.dtos.GetEventsDTO> r0 = com.coinbase.walletlink.dtos.GetEventsDTO.class
                    java.lang.String r1 = "it"
                    kotlin.jvm.internal.m.g(r9, r1)
                    com.squareup.moshi.JsonAdapter r1 = com.squareup.moshi.JsonAdapter.this
                    java.lang.Class<byte[]> r2 = byte[].class
                    boolean r2 = kotlin.jvm.internal.m.c(r0, r2)
                    r3 = 0
                    r4 = 0
                    if (r2 == 0) goto L26
                    okhttp3.ResponseBody r0 = r9.body()
                    if (r0 != 0) goto L1a
                    goto L1e
                L1a:
                    byte[] r4 = r0.bytes()
                L1e:
                    if (r4 != 0) goto L22
                    byte[] r4 = new byte[r3]
                L22:
                    com.coinbase.walletlink.dtos.GetEventsDTO r4 = (com.coinbase.walletlink.dtos.GetEventsDTO) r4
                    goto Lac
                L26:
                    boolean r2 = r9.isSuccessful()
                    if (r2 != 0) goto L3d
                    com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed r0 = new com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed
                    okhttp3.ResponseBody r9 = r9.body()
                    if (r9 != 0) goto L35
                    goto L39
                L35:
                    java.lang.String r4 = r9.string()
                L39:
                    r0.<init>(r4)
                    throw r0
                L3d:
                    okhttp3.ResponseBody r2 = r9.body()
                    if (r2 != 0) goto L44
                    goto L48
                L44:
                    java.lang.String r4 = r2.string()
                L48:
                    if (r4 == 0) goto Lf6
                    com.coinbase.wallet.core.util.JSON r2 = com.coinbase.wallet.core.util.JSON.INSTANCE
                    java.util.concurrent.locks.ReentrantReadWriteLock r5 = r2.getMultiReadSingleWriteLock()
                    java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r5 = r5.readLock()
                    r5.lock()
                    kotlin.j0.d r6 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.util.List r6 = r6.getTypeParameters()     // Catch: java.lang.Throwable -> Lf1
                    boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Lf1
                    r7 = 1
                    r6 = r6 ^ r7
                    if (r6 == 0) goto L6b
                    if (r1 == 0) goto L6a
                    goto L6b
                L6a:
                    r7 = r3
                L6b:
                    if (r7 != 0) goto L93
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf1
                    r6.<init>()     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = "Since "
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    kotlin.j0.d r7 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = r7.getSimpleName()     // Catch: java.lang.Throwable -> Lf1
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = " is parameterized please pass an adapter to `parameterizedAdapter`"
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lf1
                    com.coinbase.wallet.core.util.AssertionException r7 = new com.coinbase.wallet.core.util.AssertionException     // Catch: java.lang.Throwable -> Lf1
                    r7.<init>(r6)     // Catch: java.lang.Throwable -> Lf1
                    l.a.a.e(r7)     // Catch: java.lang.Throwable -> Lf1
                L93:
                    if (r1 != 0) goto La2
                    com.squareup.moshi.Moshi r1 = r2.getMoshi()     // Catch: java.lang.Throwable -> Lf1
                    com.squareup.moshi.JsonAdapter r0 = r1.adapter(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.Object r0 = r0.fromJson(r4)     // Catch: java.lang.Throwable -> Lf1
                    goto La6
                La2:
                    java.lang.Object r0 = r1.fromJson(r4)     // Catch: java.lang.Throwable -> Lf1
                La6:
                    r4 = r0
                    r5.unlock()
                    if (r4 == 0) goto Lee
                Lac:
                    okhttp3.Headers r9 = r9.headers()
                    int r0 = r9.size()
                    kotlin.i0.c r0 = kotlin.i0.d.j(r3, r0)
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r2 = 10
                    int r2 = kotlin.a0.p.r(r0, r2)
                    r1.<init>(r2)
                    java.util.Iterator r0 = r0.iterator()
                Lc7:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto Le4
                    r2 = r0
                    kotlin.a0.h0 r2 = (kotlin.a0.h0) r2
                    int r2 = r2.c()
                    java.lang.String r3 = r9.name(r2)
                    java.lang.String r2 = r9.value(r2)
                    kotlin.o r2 = kotlin.u.a(r3, r2)
                    r1.add(r2)
                    goto Lc7
                Le4:
                    java.util.Map r9 = kotlin.a0.j0.r(r1)
                    com.coinbase.wallet.http.models.HTTPResponse r0 = new com.coinbase.wallet.http.models.HTTPResponse
                    r0.<init>(r4, r9)
                    return r0
                Lee:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                Lf1:
                    r9 = move-exception
                    r5.unlock()
                    throw r9
                Lf6:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.walletlink.apis.WalletLinkAPI$getUnseenEvents$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        kotlin.jvm.internal.m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        h.c.b0<List<ServerRequestDTO>> map = subscribeOn.map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkAPI.a(Session.this, (HTTPResponse) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "HTTP\n            .get<GetEventsDTO>(\n                service = HTTPService(session.url),\n                path = \"/events\",\n                headers = credentials.basicAuthHeaders,\n                parameters = mapOf(\"unseen\" to \"true\")\n            )\n            .map { response ->\n                val events = response.body.events ?: emptyList()\n                events.map { event ->\n                    ServerRequestDTO(\n                        sessionId = session.id,\n                        type = ServerMessageType.Event,\n                        event = event.event,\n                        eventId = event.id,\n                        data = event.data\n                    )\n                }\n            }");
        return map;
    }

    public final h.c.b0<kotlin.x> markEventAsSeen(String eventId, String sessionId, String secret, URL url) {
        kotlin.jvm.internal.m.g(eventId, "eventId");
        kotlin.jvm.internal.m.g(sessionId, "sessionId");
        kotlin.jvm.internal.m.g(secret, "secret");
        kotlin.jvm.internal.m.g(url, "url");
        Credentials credentials = new Credentials(sessionId, secret);
        HTTP http = HTTP.INSTANCE;
        HTTPService hTTPService = new HTTPService(url);
        h.c.b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildPostRequest(hTTPService, "/events/" + eventId + "/seen", null, credentials.getBasicAuthHeaders())).map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.WalletLinkAPI$markEventAsSeen$$inlined$post$default$1
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(byte[].class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<byte[]> r0 = byte[].class
                    java.lang.String r1 = "it"
                    kotlin.jvm.internal.m.g(r9, r1)
                    com.squareup.moshi.JsonAdapter r1 = com.squareup.moshi.JsonAdapter.this
                    boolean r2 = kotlin.jvm.internal.m.c(r0, r0)
                    r3 = 0
                    r4 = 0
                    if (r2 == 0) goto L22
                    okhttp3.ResponseBody r0 = r9.body()
                    if (r0 != 0) goto L18
                    goto L1c
                L18:
                    byte[] r4 = r0.bytes()
                L1c:
                    if (r4 != 0) goto La8
                    byte[] r4 = new byte[r3]
                    goto La8
                L22:
                    boolean r2 = r9.isSuccessful()
                    if (r2 != 0) goto L39
                    com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed r0 = new com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed
                    okhttp3.ResponseBody r9 = r9.body()
                    if (r9 != 0) goto L31
                    goto L35
                L31:
                    java.lang.String r4 = r9.string()
                L35:
                    r0.<init>(r4)
                    throw r0
                L39:
                    okhttp3.ResponseBody r2 = r9.body()
                    if (r2 != 0) goto L40
                    goto L44
                L40:
                    java.lang.String r4 = r2.string()
                L44:
                    if (r4 == 0) goto Lf2
                    com.coinbase.wallet.core.util.JSON r2 = com.coinbase.wallet.core.util.JSON.INSTANCE
                    java.util.concurrent.locks.ReentrantReadWriteLock r5 = r2.getMultiReadSingleWriteLock()
                    java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r5 = r5.readLock()
                    r5.lock()
                    kotlin.j0.d r6 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Led
                    java.util.List r6 = r6.getTypeParameters()     // Catch: java.lang.Throwable -> Led
                    boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Led
                    r7 = 1
                    r6 = r6 ^ r7
                    if (r6 == 0) goto L67
                    if (r1 == 0) goto L66
                    goto L67
                L66:
                    r7 = r3
                L67:
                    if (r7 != 0) goto L8f
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Led
                    r6.<init>()     // Catch: java.lang.Throwable -> Led
                    java.lang.String r7 = "Since "
                    r6.append(r7)     // Catch: java.lang.Throwable -> Led
                    kotlin.j0.d r7 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Led
                    java.lang.String r7 = r7.getSimpleName()     // Catch: java.lang.Throwable -> Led
                    r6.append(r7)     // Catch: java.lang.Throwable -> Led
                    java.lang.String r7 = " is parameterized please pass an adapter to `parameterizedAdapter`"
                    r6.append(r7)     // Catch: java.lang.Throwable -> Led
                    java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Led
                    com.coinbase.wallet.core.util.AssertionException r7 = new com.coinbase.wallet.core.util.AssertionException     // Catch: java.lang.Throwable -> Led
                    r7.<init>(r6)     // Catch: java.lang.Throwable -> Led
                    l.a.a.e(r7)     // Catch: java.lang.Throwable -> Led
                L8f:
                    if (r1 != 0) goto L9e
                    com.squareup.moshi.Moshi r1 = r2.getMoshi()     // Catch: java.lang.Throwable -> Led
                    com.squareup.moshi.JsonAdapter r0 = r1.adapter(r0)     // Catch: java.lang.Throwable -> Led
                    java.lang.Object r0 = r0.fromJson(r4)     // Catch: java.lang.Throwable -> Led
                    goto La2
                L9e:
                    java.lang.Object r0 = r1.fromJson(r4)     // Catch: java.lang.Throwable -> Led
                La2:
                    r4 = r0
                    r5.unlock()
                    if (r4 == 0) goto Lea
                La8:
                    okhttp3.Headers r9 = r9.headers()
                    int r0 = r9.size()
                    kotlin.i0.c r0 = kotlin.i0.d.j(r3, r0)
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r2 = 10
                    int r2 = kotlin.a0.p.r(r0, r2)
                    r1.<init>(r2)
                    java.util.Iterator r0 = r0.iterator()
                Lc3:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto Le0
                    r2 = r0
                    kotlin.a0.h0 r2 = (kotlin.a0.h0) r2
                    int r2 = r2.c()
                    java.lang.String r3 = r9.name(r2)
                    java.lang.String r2 = r9.value(r2)
                    kotlin.o r2 = kotlin.u.a(r3, r2)
                    r1.add(r2)
                    goto Lc3
                Le0:
                    java.util.Map r9 = kotlin.a0.j0.r(r1)
                    com.coinbase.wallet.http.models.HTTPResponse r0 = new com.coinbase.wallet.http.models.HTTPResponse
                    r0.<init>(r4, r9)
                    return r0
                Lea:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                Led:
                    r9 = move-exception
                    r5.unlock()
                    throw r9
                Lf2:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.walletlink.apis.WalletLinkAPI$markEventAsSeen$$inlined$post$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        kotlin.jvm.internal.m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildPostRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        h.c.b0<kotlin.x> onErrorReturn = Single_WalletLinkKt.logError$default(Single_CoreKt.asUnit(subscribeOn), null, 1, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkAPI.b((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "HTTP\n            .post<ByteArray>(\n                service = HTTPService(url),\n                path = \"/events/$eventId/seen\",\n                headers = credentials.basicAuthHeaders\n            )\n            .asUnit()\n            .logError()\n            .onErrorReturn { Unit }");
        return onErrorReturn;
    }
}