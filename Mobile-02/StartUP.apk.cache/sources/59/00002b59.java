package com.coinbase.walletlink.apis;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.JsonSerializable;
import com.coinbase.wallet.core.util.ConcurrentLruCache;
import com.coinbase.wallet.core.util.RxSchedulers;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.coinbase.wallet.http.connectivity.Internet;
import com.coinbase.wallet.http.models.WebConnectionState;
import com.coinbase.wallet.http.models.WebIncomingDataType;
import com.coinbase.wallet.http.websocket.WebSocket;
import com.coinbase.walletlink.dtos.ClientResponseDTO;
import com.coinbase.walletlink.dtos.JoinSessionMessageDTO;
import com.coinbase.walletlink.dtos.PublishEventDTO;
import com.coinbase.walletlink.dtos.ServerRequestDTO;
import com.coinbase.walletlink.dtos.SetMetadataMessageDTO;
import com.coinbase.walletlink.dtos.SetSessionConfigMessageDTO;
import com.coinbase.walletlink.extensions.Single_WalletLinkKt;
import com.coinbase.walletlink.models.ClientMetadataKey;
import com.coinbase.walletlink.models.EventType;
import com.coinbase.walletlink.models.ServerMessageType;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.apache.http.HttpStatus;

/* compiled from: WalletLinkWebSocket.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010D\u001a\u00020)¢\u0006\u0004\bX\u0010YJ1\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\b¢\u0006\u0004\b\u001d\u0010\u001cJ#\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J+\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e¢\u0006\u0004\b&\u0010'JO\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010(\u001a\u0004\u0018\u00010\u001e2\b\u0010*\u001a\u0004\u0018\u00010)2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0+2\u0006\u0010 \u001a\u00020\u001e2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b-\u0010.J+\u00102\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e¢\u0006\u0004\b2\u00103R\u001f\u00106\u001a\b\u0012\u0004\u0012\u000205048\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R(\u0010=\u001a\u0014\u0012\u0004\u0012\u00020;\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0<0:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u0013048\u0006@\u0006¢\u0006\f\n\u0004\b?\u00107\u001a\u0004\b@\u00109R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0019\u0010D\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR$\u0010J\u001a\u0010\u0012\f\u0012\n I*\u0004\u0018\u00010\u001e0\u001e0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR$\u0010O\u001a\u0010\u0012\f\u0012\n I*\u0004\u0018\u00010\u00130\u00130H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010KR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u001e048\u0006@\u0006¢\u0006\f\n\u0004\bV\u00107\u001a\u0004\bW\u00109¨\u0006Z"}, d2 = {"Lcom/coinbase/walletlink/apis/WalletLinkWebSocket;", "", "Lcom/coinbase/wallet/core/interfaces/JsonSerializable;", ApiConstants.MESSAGE, "Lcom/coinbase/walletlink/apis/WalletLinkCallback;", "callback", "", "timeout", "Lh/c/b0;", "", "send", "(Lcom/coinbase/wallet/core/interfaces/JsonSerializable;Lcom/coinbase/walletlink/apis/WalletLinkCallback;Ljava/lang/Long;)Lh/c/b0;", "createCallback", "()Lcom/coinbase/walletlink/apis/WalletLinkCallback;", "Lcom/coinbase/walletlink/dtos/ClientResponseDTO;", Payload.RESPONSE, "Lkotlin/x;", "receivedClientResponse", "(Lcom/coinbase/walletlink/dtos/ClientResponseDTO;)V", "Lcom/coinbase/walletlink/dtos/ServerRequestDTO;", "request", "receivedServerRequest", "(Lcom/coinbase/walletlink/dtos/ServerRequestDTO;)V", "Lcom/coinbase/wallet/http/models/WebIncomingDataType;", "incoming", "processIncomingData", "(Lcom/coinbase/wallet/http/models/WebIncomingDataType;)V", "connect", "()Lh/c/b0;", "disconnect", "", "sessionKey", WalletLinkPushNotification.sessionIdKey, "joinSession", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/walletlink/models/ClientMetadataKey;", "key", "value", "setMetadata", "(Lcom/coinbase/walletlink/models/ClientMetadataKey;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "webhookId", "Ljava/net/URL;", "webhookUrl", "", SendConfirmationArgs.metadataKey, "setSessionConfig", "(Ljava/lang/String;Ljava/net/URL;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Long;)Lh/c/b0;", "Lcom/coinbase/walletlink/models/EventType;", "event", "data", "publishEvent", "(Lcom/coinbase/walletlink/models/EventType;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "Lh/c/s;", "Lcom/coinbase/wallet/http/models/WebConnectionState;", "connectionStateObservable", "Lh/c/s;", "getConnectionStateObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/core/util/ConcurrentLruCache;", "", "Lh/c/v0/c;", "pendingCallbacks", "Lcom/coinbase/wallet/core/util/ConcurrentLruCache;", "incomingRequestsObservable", "getIncomingRequestsObservable", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "url", "Ljava/net/URL;", "getUrl", "()Ljava/net/URL;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "disconnectSessionSubject", "Lh/c/v0/b;", "Ljava/util/concurrent/atomic/AtomicInteger;", "callbackSequence", "Ljava/util/concurrent/atomic/AtomicInteger;", "incomingRequestsSubject", "Lh/c/a0;", "serialScheduler", "Lh/c/a0;", "Lcom/coinbase/wallet/http/websocket/WebSocket;", "connection", "Lcom/coinbase/wallet/http/websocket/WebSocket;", "disconnectSessionObservable", "getDisconnectSessionObservable", "<init>", "(Ljava/net/URL;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletLinkWebSocket {
    private final AtomicInteger callbackSequence;
    private final WebSocket connection;
    private final h.c.s<WebConnectionState> connectionStateObservable;
    private final h.c.s<String> disconnectSessionObservable;
    private final h.c.v0.b<String> disconnectSessionSubject;
    private final h.c.k0.a disposeBag;
    private final h.c.s<ServerRequestDTO> incomingRequestsObservable;
    private final h.c.v0.b<ServerRequestDTO> incomingRequestsSubject;
    private final ConcurrentLruCache<Integer, h.c.v0.c<ClientResponseDTO>> pendingCallbacks;
    private final h.c.a0 serialScheduler;
    private final URL url;

    /* compiled from: WalletLinkWebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ServerMessageType.values().length];
            iArr[ServerMessageType.OK.ordinal()] = 1;
            iArr[ServerMessageType.Fail.ordinal()] = 2;
            iArr[ServerMessageType.PublishEventOK.ordinal()] = 3;
            iArr[ServerMessageType.Event.ordinal()] = 4;
            iArr[ServerMessageType.GetSessionConfigOK.ordinal()] = 5;
            iArr[ServerMessageType.SessionConfigUpdated.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public WalletLinkWebSocket(URL url) {
        kotlin.jvm.internal.m.g(url, "url");
        this.url = url;
        this.serialScheduler = RxSchedulers.INSTANCE.newSerialScheduler();
        this.disposeBag = new h.c.k0.a();
        WebSocket webSocket = new WebSocket(url, 0L, 0L, 0L, 14, null);
        this.connection = webSocket;
        this.callbackSequence = new AtomicInteger();
        h.c.v0.b<ServerRequestDTO> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<ServerRequestDTO>()");
        this.incomingRequestsSubject = d2;
        h.c.v0.b<String> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<String>()");
        this.disconnectSessionSubject = d3;
        this.pendingCallbacks = new ConcurrentLruCache<>(HttpStatus.SC_MULTIPLE_CHOICES);
        h.c.s<ServerRequestDTO> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "incomingRequestsSubject.hide()");
        this.incomingRequestsObservable = hide;
        h.c.s<String> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "disconnectSessionSubject.hide()");
        this.disconnectSessionObservable = hide2;
        this.connectionStateObservable = webSocket.getConnectionStateObservable();
    }

    public static /* synthetic */ h.c.h0 a(WalletLinkCallback walletLinkCallback, kotlin.x xVar) {
        return m2176send$lambda3(walletLinkCallback, xVar);
    }

    public static /* synthetic */ Boolean b(WalletLinkWebSocket walletLinkWebSocket, WalletLinkCallback walletLinkCallback, Boolean bool) {
        return m2178send$lambda5(walletLinkWebSocket, walletLinkCallback, bool);
    }

    public static /* synthetic */ void c(WalletLinkWebSocket walletLinkWebSocket, WebIncomingDataType webIncomingDataType) {
        m2173connect$lambda0(walletLinkWebSocket, webIncomingDataType);
    }

    /* renamed from: connect$lambda-0 */
    public static final void m2173connect$lambda0(WalletLinkWebSocket this$0, WebIncomingDataType it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.f(it, "it");
        this$0.processIncomingData(it);
    }

    private final WalletLinkCallback createCallback() {
        int incrementAndGet = this.callbackSequence.incrementAndGet();
        h.c.v0.c<ClientResponseDTO> d2 = h.c.v0.c.d(1);
        kotlin.jvm.internal.m.f(d2, "createWithSize<ClientResponseDTO>(1)");
        this.pendingCallbacks.set(Integer.valueOf(incrementAndGet), d2);
        return new WalletLinkCallback(incrementAndGet, d2);
    }

    public static /* synthetic */ Boolean d(ClientResponseDTO clientResponseDTO) {
        return m2177send$lambda4(clientResponseDTO);
    }

    public static /* synthetic */ h.c.h0 e(WalletLinkWebSocket walletLinkWebSocket, WalletLinkCallback walletLinkCallback, Throwable th) {
        return m2179send$lambda6(walletLinkWebSocket, walletLinkCallback, th);
    }

    public static /* synthetic */ boolean f(ConnectionStatus connectionStatus) {
        return m2174send$lambda1(connectionStatus);
    }

    public static /* synthetic */ h.c.h0 g(WalletLinkWebSocket walletLinkWebSocket, String str, ConnectionStatus connectionStatus) {
        return m2175send$lambda2(walletLinkWebSocket, str, connectionStatus);
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x0094, code lost:
        if (r4 != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void processIncomingData(com.coinbase.wallet.http.models.WebIncomingDataType r8) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.walletlink.apis.WalletLinkWebSocket.processIncomingData(com.coinbase.wallet.http.models.WebIncomingDataType):void");
    }

    private final void receivedClientResponse(ClientResponseDTO clientResponseDTO) {
        Integer id = clientResponseDTO.getId();
        if (id == null) {
            return;
        }
        int intValue = id.intValue();
        h.c.v0.c<ClientResponseDTO> cVar = this.pendingCallbacks.get(Integer.valueOf(intValue));
        this.pendingCallbacks.remove(Integer.valueOf(intValue));
        if (cVar == null) {
            return;
        }
        cVar.onNext(clientResponseDTO);
    }

    private final void receivedServerRequest(ServerRequestDTO serverRequestDTO) {
        this.incomingRequestsSubject.onNext(serverRequestDTO);
    }

    private final h.c.b0<Boolean> send(JsonSerializable jsonSerializable, final WalletLinkCallback walletLinkCallback, Long l2) {
        final String asJsonString = jsonSerializable.asJsonString();
        h.c.s<ConnectionStatus> filter = Internet.INSTANCE.getStatusChanges().filter(new h.c.m0.p() { // from class: com.coinbase.walletlink.apis.r0
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return WalletLinkWebSocket.f((ConnectionStatus) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "Internet.statusChanges\n            .filter { it.isOnline }");
        h.c.b0 map = Observable_CoreKt.takeSingle(filter).flatMap(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.s0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkWebSocket.g(WalletLinkWebSocket.this, asJsonString, (ConnectionStatus) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.m0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkWebSocket.a(WalletLinkCallback.this, (kotlin.x) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.p0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkWebSocket.d((ClientResponseDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Internet.statusChanges\n            .filter { it.isOnline }\n            .takeSingle()\n            .flatMap { connection.sendString(jsonString) }\n            .flatMap { callback.subject.takeSingle() }\n            .map { it.type.isOK }");
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h.c.b0 timeout = Single_CoreKt.retryWithDelay(map, 3L, 1L, timeUnit).timeout(l2 == null ? 15L : l2.longValue(), timeUnit);
        kotlin.jvm.internal.m.f(timeout, "Internet.statusChanges\n            .filter { it.isOnline }\n            .takeSingle()\n            .flatMap { connection.sendString(jsonString) }\n            .flatMap { callback.subject.takeSingle() }\n            .map { it.type.isOK }\n            .retryWithDelay(3, 1, TimeUnit.SECONDS)\n            .timeout(timeout ?: 15, TimeUnit.SECONDS)");
        h.c.b0<Boolean> onErrorResumeNext = Single_WalletLinkKt.logError$default(timeout, null, 1, null).map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.n0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkWebSocket.b(WalletLinkWebSocket.this, walletLinkCallback, (Boolean) obj);
            }
        }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.q0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkWebSocket.e(WalletLinkWebSocket.this, walletLinkCallback, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "Internet.statusChanges\n            .filter { it.isOnline }\n            .takeSingle()\n            .flatMap { connection.sendString(jsonString) }\n            .flatMap { callback.subject.takeSingle() }\n            .map { it.type.isOK }\n            .retryWithDelay(3, 1, TimeUnit.SECONDS)\n            .timeout(timeout ?: 15, TimeUnit.SECONDS)\n            .logError()\n            .map { success ->\n                pendingCallbacks.remove(callback.requestId)\n                success\n            }\n            .onErrorResumeNext { err ->\n                pendingCallbacks.remove(callback.requestId)\n                throw err\n            }");
        return onErrorResumeNext;
    }

    static /* synthetic */ h.c.b0 send$default(WalletLinkWebSocket walletLinkWebSocket, JsonSerializable jsonSerializable, WalletLinkCallback walletLinkCallback, Long l2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            l2 = null;
        }
        return walletLinkWebSocket.send(jsonSerializable, walletLinkCallback, l2);
    }

    /* renamed from: send$lambda-1 */
    public static final boolean m2174send$lambda1(ConnectionStatus it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.isOnline();
    }

    /* renamed from: send$lambda-2 */
    public static final h.c.h0 m2175send$lambda2(WalletLinkWebSocket this$0, String jsonString, ConnectionStatus it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(jsonString, "$jsonString");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.connection.sendString(jsonString);
    }

    /* renamed from: send$lambda-3 */
    public static final h.c.h0 m2176send$lambda3(WalletLinkCallback callback, kotlin.x it) {
        kotlin.jvm.internal.m.g(callback, "$callback");
        kotlin.jvm.internal.m.g(it, "it");
        return Observable_CoreKt.takeSingle(callback.getSubject());
    }

    /* renamed from: send$lambda-4 */
    public static final Boolean m2177send$lambda4(ClientResponseDTO it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.getType().isOK());
    }

    /* renamed from: send$lambda-5 */
    public static final Boolean m2178send$lambda5(WalletLinkWebSocket this$0, WalletLinkCallback callback, Boolean success) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(callback, "$callback");
        kotlin.jvm.internal.m.g(success, "success");
        this$0.pendingCallbacks.remove(Integer.valueOf(callback.getRequestId()));
        return success;
    }

    /* renamed from: send$lambda-6 */
    public static final h.c.h0 m2179send$lambda6(WalletLinkWebSocket this$0, WalletLinkCallback callback, Throwable err) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(callback, "$callback");
        kotlin.jvm.internal.m.g(err, "err");
        this$0.pendingCallbacks.remove(Integer.valueOf(callback.getRequestId()));
        throw err;
    }

    public static /* synthetic */ h.c.b0 setSessionConfig$default(WalletLinkWebSocket walletLinkWebSocket, String str, URL url, Map map, String str2, Long l2, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            l2 = null;
        }
        return walletLinkWebSocket.setSessionConfig(str, url, map, str2, l2);
    }

    public final h.c.b0<kotlin.x> connect() {
        this.disposeBag.d();
        h.c.k0.b subscribe = this.connection.getIncomingObservable().observeOn(this.serialScheduler).subscribe(new h.c.m0.f() { // from class: com.coinbase.walletlink.apis.o0
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                WalletLinkWebSocket.c(WalletLinkWebSocket.this, (WebIncomingDataType) obj);
            }
        });
        kotlin.jvm.internal.m.f(subscribe, "connection.incomingObservable\n            .observeOn(serialScheduler)\n            .subscribe { processIncomingData(it) }");
        h.c.t0.a.a(subscribe, this.disposeBag);
        return this.connection.connect();
    }

    public final h.c.b0<kotlin.x> disconnect() {
        this.disposeBag.d();
        return this.connection.disconnect();
    }

    public final h.c.s<WebConnectionState> getConnectionStateObservable() {
        return this.connectionStateObservable;
    }

    public final h.c.s<String> getDisconnectSessionObservable() {
        return this.disconnectSessionObservable;
    }

    public final h.c.s<ServerRequestDTO> getIncomingRequestsObservable() {
        return this.incomingRequestsObservable;
    }

    public final URL getUrl() {
        return this.url;
    }

    public final h.c.b0<Boolean> joinSession(String sessionKey, String sessionId) {
        kotlin.jvm.internal.m.g(sessionKey, "sessionKey");
        kotlin.jvm.internal.m.g(sessionId, "sessionId");
        WalletLinkCallback createCallback = createCallback();
        return send$default(this, new JoinSessionMessageDTO(null, createCallback.getRequestId(), sessionId, sessionKey, 1, null), createCallback, null, 4, null);
    }

    public final h.c.b0<Boolean> publishEvent(EventType event, String data, String sessionId) {
        kotlin.jvm.internal.m.g(event, "event");
        kotlin.jvm.internal.m.g(data, "data");
        kotlin.jvm.internal.m.g(sessionId, "sessionId");
        WalletLinkCallback createCallback = createCallback();
        return send$default(this, new PublishEventDTO(null, createCallback.getRequestId(), sessionId, event, data, 1, null), createCallback, null, 4, null);
    }

    public final h.c.b0<Boolean> setMetadata(ClientMetadataKey key, String value, String sessionId) {
        kotlin.jvm.internal.m.g(key, "key");
        kotlin.jvm.internal.m.g(value, "value");
        kotlin.jvm.internal.m.g(sessionId, "sessionId");
        WalletLinkCallback createCallback = createCallback();
        return send$default(this, new SetMetadataMessageDTO(null, createCallback.getRequestId(), sessionId, key.getRawValue(), value, 1, null), createCallback, null, 4, null);
    }

    public final h.c.b0<Boolean> setSessionConfig(String str, URL url, Map<String, String> metadata, String sessionId, Long l2) {
        kotlin.jvm.internal.m.g(metadata, "metadata");
        kotlin.jvm.internal.m.g(sessionId, "sessionId");
        WalletLinkCallback createCallback = createCallback();
        return send(new SetSessionConfigMessageDTO(null, createCallback.getRequestId(), sessionId, str, url == null ? null : url.toString(), metadata, 1, null), createCallback, l2);
    }
}