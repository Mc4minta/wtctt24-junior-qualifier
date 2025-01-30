package com.coinbase.walletlink.apis;

import android.net.Uri;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.core.extensions.ByteArray_CoreKt;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.RxSchedulers;
import com.coinbase.wallet.crypto.extensions.String_CryptoKt;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.coinbase.wallet.http.connectivity.Internet;
import com.coinbase.wallet.http.extensions.URL_HTTPKt;
import com.coinbase.wallet.http.models.WebConnectionState;
import com.coinbase.walletlink.dtos.ServerRequestDTO;
import com.coinbase.walletlink.dtos.Web3ResponseDTO;
import com.coinbase.walletlink.exceptions.WalletLinkException;
import com.coinbase.walletlink.extensions.Single_WalletLinkKt;
import com.coinbase.walletlink.extensions.Strings_WalletLinkKt;
import com.coinbase.walletlink.models.ClientMetadataKey;
import com.coinbase.walletlink.models.Credentials;
import com.coinbase.walletlink.models.Dapp;
import com.coinbase.walletlink.models.HostRequest;
import com.coinbase.walletlink.models.HostRequestId;
import com.coinbase.walletlink.models.RequestMethod;
import com.coinbase.walletlink.models.Session;
import com.coinbase.walletlink.repositories.LinkRepository;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.apache.http.cookie.ClientCookie;

/* compiled from: WalletLinkConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B=\b\u0002\u0012\u0006\u0010Q\u001a\u00020\u001f\u0012\u0006\u0010;\u001a\u00020&\u0012\u0006\u0010O\u001a\u00020N\u0012\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u001f0D\u0012\u0006\u0010J\u001a\u00020&¢\u0006\u0004\b]\u0010^B=\b\u0016\u0012\u0006\u0010J\u001a\u00020&\u0012\u0006\u0010Q\u001a\u00020\u001f\u0012\u0006\u0010;\u001a\u00020&\u0012\u0006\u0010O\u001a\u00020N\u0012\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u001f0_¢\u0006\u0004\b]\u0010`J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\nJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\f\u0010\bJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J4\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\"\u0006\b\u0000\u0010\u0014\u0018\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\r\u001a\u00020\u0003H\u0082\b¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u001f\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u0013J]\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u001f2\u0006\u0010#\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J#\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u001f¢\u0006\u0004\b/\u00100J\u001b\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b1\u00102J#\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u00104\u001a\u000203¢\u0006\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<RR\u0010?\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 >*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 >*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 >*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010=0=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R$\u0010B\u001a\u0010\u0012\f\u0012\n >*\u0004\u0018\u00010\u001a0\u001a0A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\"\u0010E\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u001f0D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u001f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001f0=8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010@\u001a\u0004\bH\u0010IR\u0019\u0010J\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010<\u001a\u0004\bK\u0010LR\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000e0=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010@R\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001a0=8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010@\u001a\u0004\bZ\u0010IR$\u0010\\\u001a\u0010\u0012\f\u0012\n >*\u0004\u0018\u00010[0[0A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010C¨\u0006a"}, d2 = {"Lcom/coinbase/walletlink/apis/WalletLinkConnection;", "", "", "Lcom/coinbase/walletlink/models/Session;", "sessions", "Lh/c/b0;", "Lkotlin/x;", "syncMetadata", "(Ljava/util/List;)Lh/c/b0;", "startConnection", "()Lh/c/b0;", "stopConnection", "joinSessions", "session", "", "joinSession", "(Lcom/coinbase/walletlink/models/Session;)Lh/c/b0;", "setSessionConfig", "fetchPendingRequests", "()V", "T", "Lcom/coinbase/walletlink/dtos/Web3ResponseDTO;", Payload.RESPONSE, "submitWeb3Response", "(Lcom/coinbase/walletlink/dtos/Web3ResponseDTO;Lcom/coinbase/walletlink/models/Session;)Lh/c/b0;", "observeConnection", "Lcom/coinbase/walletlink/models/HostRequest;", "request", "isRequestAuthorizedForSession", "(Lcom/coinbase/walletlink/models/HostRequest;Lcom/coinbase/walletlink/models/Session;)Z", "disconnect", "", WalletLinkPushNotification.sessionIdKey, "secret", ClientCookie.VERSION_ATTR, "isParent", "parentSessionId", WalletLinkCompleteArgs.DAPP_NAME, "Ljava/net/URL;", "dappImageURL", "Landroid/net/Uri;", "dappURL", "link", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/net/URL;Landroid/net/Uri;)Lh/c/b0;", "Lcom/coinbase/walletlink/models/ClientMetadataKey;", "key", "value", "setMetadata", "(Lcom/coinbase/walletlink/models/ClientMetadataKey;Ljava/lang/String;)Lh/c/b0;", "destroySession", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/walletlink/models/HostRequestId;", "requestId", "", "responseData", "approve", "(Lcom/coinbase/walletlink/models/HostRequestId;[B)Lh/c/b0;", "reject", "(Lcom/coinbase/walletlink/models/HostRequestId;)Lh/c/b0;", "notificationUrl", "Ljava/net/URL;", "Lh/c/s;", "kotlin.jvm.PlatformType", "authorizedSessionsObservable", "Lh/c/s;", "Lh/c/v0/b;", "requestsSubject", "Lh/c/v0/b;", "Ljava/util/concurrent/ConcurrentHashMap;", SendConfirmationArgs.metadataKey, "Ljava/util/concurrent/ConcurrentHashMap;", "disconnectSessionObservable", "getDisconnectSessionObservable", "()Lh/c/s;", "url", "getUrl", "()Ljava/net/URL;", "isConnectedObservable", "Lcom/coinbase/walletlink/repositories/LinkRepository;", "linkRepository", "Lcom/coinbase/walletlink/repositories/LinkRepository;", "userId", "Ljava/lang/String;", "Lcom/coinbase/walletlink/apis/WalletLinkWebSocket;", "socket", "Lcom/coinbase/walletlink/apis/WalletLinkWebSocket;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "requestsObservable", "getRequestsObservable", "Lcom/coinbase/walletlink/apis/JoinSessionEvent;", "joinSessionEventsSubject", "<init>", "(Ljava/lang/String;Ljava/net/URL;Lcom/coinbase/walletlink/repositories/LinkRepository;Ljava/util/concurrent/ConcurrentHashMap;Ljava/net/URL;)V", "", "(Ljava/net/URL;Ljava/lang/String;Ljava/net/URL;Lcom/coinbase/walletlink/repositories/LinkRepository;Ljava/util/Map;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletLinkConnection {
    private final h.c.s<List<Session>> authorizedSessionsObservable;
    private final h.c.s<String> disconnectSessionObservable;
    private final h.c.k0.a disposeBag;
    private final h.c.s<Boolean> isConnectedObservable;
    private final h.c.v0.b<JoinSessionEvent> joinSessionEventsSubject;
    private final LinkRepository linkRepository;
    private final ConcurrentHashMap<ClientMetadataKey, String> metadata;
    private final URL notificationUrl;
    private final h.c.s<HostRequest> requestsObservable;
    private final h.c.v0.b<HostRequest> requestsSubject;
    private final WalletLinkWebSocket socket;
    private final URL url;
    private final String userId;

    /* compiled from: WalletLinkConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestMethod.values().length];
            iArr[RequestMethod.RequestEthereumAccounts.ordinal()] = 1;
            iArr[RequestMethod.ChildRequestEthereumAccounts.ordinal()] = 2;
            iArr[RequestMethod.SwitchEthereumChain.ordinal()] = 3;
            iArr[RequestMethod.SignEthereumMessage.ordinal()] = 4;
            iArr[RequestMethod.SubmitEthereumTransaction.ordinal()] = 5;
            iArr[RequestMethod.SignEthereumTransaction.ordinal()] = 6;
            iArr[RequestMethod.RequestCanceled.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private WalletLinkConnection(String str, URL url, LinkRepository linkRepository, ConcurrentHashMap<ClientMetadataKey, String> concurrentHashMap, URL url2) {
        this.userId = str;
        this.notificationUrl = url;
        this.linkRepository = linkRepository;
        this.metadata = concurrentHashMap;
        this.url = url2;
        h.c.v0.b<HostRequest> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<HostRequest>()");
        this.requestsSubject = d2;
        h.c.v0.b<JoinSessionEvent> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<JoinSessionEvent>()");
        this.joinSessionEventsSubject = d3;
        WalletLinkWebSocket walletLinkWebSocket = new WalletLinkWebSocket(URL_HTTPKt.appendingPathComponent(url2, "rpc"));
        this.socket = walletLinkWebSocket;
        h.c.k0.a aVar = new h.c.k0.a();
        this.disposeBag = aVar;
        h.c.s map = walletLinkWebSocket.getConnectionStateObservable().map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.a0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.y((WebConnectionState) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "socket.connectionStateObservable.map { it.isConnected }");
        this.isConnectedObservable = map;
        this.authorizedSessionsObservable = h.c.s.just(linkRepository.getSessions(url2)).concatMap(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.z
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.x(WalletLinkConnection.this, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.i0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.G((List) obj);
            }
        }).scan(new h.c.m0.c() { // from class: com.coinbase.walletlink.apis.h0
            @Override // h.c.m0.c
            public final Object apply(Object obj, Object obj2) {
                return WalletLinkConnection.F((List) obj, (List) obj2);
            }
        }).distinctUntilChanged();
        this.disconnectSessionObservable = walletLinkWebSocket.getDisconnectSessionObservable();
        h.c.s<HostRequest> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "requestsSubject.hide()");
        this.requestsObservable = hide;
        h.c.s<R> flatMap = walletLinkWebSocket.getIncomingRequestsObservable().flatMap(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.e(WalletLinkConnection.this, (ServerRequestDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "socket.incomingRequestsObservable\n            .flatMap { linkRepository.getHostRequest(it, url).toObservable() }");
        h.c.s map2 = flatMap.filter(new h.c.m0.p() { // from class: com.coinbase.walletlink.apis.WalletLinkConnection$special$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.WalletLinkConnection$special$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map2, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        h.c.k0.b subscribe = map2.map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.o(WalletLinkConnection.this, (HostRequest) obj);
            }
        }).subscribe(new h.c.m0.f() { // from class: com.coinbase.walletlink.apis.h
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                WalletLinkConnection.f(WalletLinkConnection.this, (HostRequest) obj);
            }
        });
        kotlin.jvm.internal.m.f(subscribe, "socket.incomingRequestsObservable\n            .flatMap { linkRepository.getHostRequest(it, url).toObservable() }\n            .unwrap()\n            .map { request ->\n                val hostRequestId = request.hostRequestId\n                val session = linkRepository.sessions\n                    .firstOrNull { it.url == hostRequestId.url && it.id == hostRequestId.sessionId }\n                    ?: return@map request\n\n                if (!isRequestAuthorizedForSession(request, session)) {\n                    throw WalletLinkException.SessionNotAuthorizedException\n                }\n\n                if (request is HostRequest.ChildRequestEthereumAccounts) {\n                    if (session.isParent != true) {\n                        throw WalletLinkException.ChildSecurityException\n                    }\n\n                    /**\n                     * Store the child session here.  We will connect the\n                     * websocket and send the approve response in the WalletLinkRepository **/\n                    linkRepository.saveSession(\n                        url = session.url,\n                        sessionId = request.childSessionId,\n                        secret = request.childSessionSecret,\n                        version = request.version,\n                        isParent = false,\n                        isApproved = true,\n                        parentSessionId = session.id,\n                        dappName = hostRequestId.dappName,\n                        dappImageURL = hostRequestId.dappImageURL,\n                        dappURL = hostRequestId.dappURL\n                    )\n\n                    return@map request\n                }\n\n                if (session.version == null || request !is HostRequest.RequestEthereumAccounts) {\n                    return@map request\n                }\n\n                // for WalletLink v > 1, grab dapp details from EIP1102 request\n                linkRepository.saveSession(\n                    url = session.url,\n                    sessionId = session.id,\n                    secret = session.secret,\n                    version = session.version,\n                    isParent = session.isParent == true,\n                    isApproved = session.isParent != true,\n                    parentSessionId = session.parentSessionId,\n                    dappName = hostRequestId.dappName,\n                    dappImageURL = hostRequestId.dappImageURL,\n                    dappURL = hostRequestId.dappURL\n                )\n\n                request\n            }\n            .subscribe { requestsSubject.onNext(it) }");
        h.c.t0.a.a(subscribe, aVar);
        observeConnection();
    }

    public static /* synthetic */ h.c.x B(kotlin.jvm.internal.d0 d0Var, WalletLinkConnection walletLinkConnection, kotlin.o oVar) {
        return m2166observeConnection$lambda45(d0Var, walletLinkConnection, oVar);
    }

    public static /* synthetic */ List C(List list, kotlin.x xVar) {
        return m2162observeConnection$lambda40$lambda36(list, xVar);
    }

    public static /* synthetic */ kotlin.x D(JoinSessionEvent joinSessionEvent) {
        return m2158link$lambda13(joinSessionEvent);
    }

    public static /* synthetic */ h.c.h0 E(WalletLinkConnection walletLinkConnection, Web3ResponseDTO web3ResponseDTO, Session session, kotlin.x xVar) {
        return m2169reject$lambda23(walletLinkConnection, web3ResponseDTO, session, xVar);
    }

    public static /* synthetic */ List F(List list, List list2) {
        return m2147authorizedSessionsObservable$lambda4(list, list2);
    }

    public static /* synthetic */ List G(List list) {
        return m2146authorizedSessionsObservable$lambda3(list);
    }

    public static /* synthetic */ void H(WalletLinkConnection walletLinkConnection, String str, Throwable th) {
        m2159link$lambda14(walletLinkConnection, str, th);
    }

    public static /* synthetic */ h.c.h0 I(WalletLinkConnection walletLinkConnection, Web3ResponseDTO web3ResponseDTO, Session session, kotlin.x xVar) {
        return m2142approve$lambda20$lambda19(walletLinkConnection, web3ResponseDTO, session, xVar);
    }

    public static /* synthetic */ h.c.h0 J(WalletLinkConnection walletLinkConnection, Web3ResponseDTO web3ResponseDTO, Session session, kotlin.x xVar) {
        return m2144approve$lambda22(walletLinkConnection, web3ResponseDTO, session, xVar);
    }

    /* renamed from: _init_$lambda-5 */
    public static final h.c.x m2137_init_$lambda5(WalletLinkConnection this$0, ServerRequestDTO it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.linkRepository.getHostRequest(it, this$0.getUrl()).toObservable();
    }

    /* renamed from: _init_$lambda-7 */
    public static final HostRequest m2138_init_$lambda7(WalletLinkConnection this$0, HostRequest request) {
        Object obj;
        Boolean bool;
        boolean z;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(request, "request");
        HostRequestId hostRequestId = request.getHostRequestId();
        Iterator<T> it = this$0.linkRepository.getSessions().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Session session = (Session) obj;
            if (kotlin.jvm.internal.m.c(session.getUrl(), hostRequestId.getUrl()) && kotlin.jvm.internal.m.c(session.getId(), hostRequestId.getSessionId())) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Session session2 = (Session) obj;
        if (session2 == null) {
            return request;
        }
        if (this$0.isRequestAuthorizedForSession(request, session2)) {
            if (request instanceof HostRequest.ChildRequestEthereumAccounts) {
                if (kotlin.jvm.internal.m.c(session2.isParent(), Boolean.TRUE)) {
                    HostRequest.ChildRequestEthereumAccounts childRequestEthereumAccounts = (HostRequest.ChildRequestEthereumAccounts) request;
                    this$0.linkRepository.saveSession(session2.getUrl(), childRequestEthereumAccounts.getChildSessionId(), childRequestEthereumAccounts.getChildSessionSecret(), childRequestEthereumAccounts.getVersion(), false, true, session2.getId(), hostRequestId.getDappName(), hostRequestId.getDappImageURL(), hostRequestId.getDappURL());
                    return request;
                }
                throw WalletLinkException.ChildSecurityException.INSTANCE;
            }
            if (session2.getVersion() != null && (request instanceof HostRequest.RequestEthereumAccounts)) {
                this$0.linkRepository.saveSession(session2.getUrl(), session2.getId(), session2.getSecret(), session2.getVersion(), kotlin.jvm.internal.m.c(session2.isParent(), Boolean.TRUE), !kotlin.jvm.internal.m.c(session2.isParent(), bool), session2.getParentSessionId(), hostRequestId.getDappName(), hostRequestId.getDappImageURL(), hostRequestId.getDappURL());
            }
            return request;
        }
        throw WalletLinkException.SessionNotAuthorizedException.INSTANCE;
    }

    /* renamed from: _init_$lambda-8 */
    public static final void m2139_init_$lambda8(WalletLinkConnection this$0, HostRequest hostRequest) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.requestsSubject.onNext(hostRequest);
    }

    public static /* synthetic */ kotlin.x a(Throwable th) {
        return m2172stopConnection$lambda26(th);
    }

    /* renamed from: approve$lambda-18 */
    public static final kotlin.x m2140approve$lambda18(WalletLinkConnection this$0, Session session, kotlin.x it) {
        Session copy;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(session, "$session");
        kotlin.jvm.internal.m.g(it, "it");
        LinkRepository linkRepository = this$0.linkRepository;
        copy = session.copy((r22 & 1) != 0 ? session.id : null, (r22 & 2) != 0 ? session.secret : null, (r22 & 4) != 0 ? session.url : null, (r22 & 8) != 0 ? session.version : null, (r22 & 16) != 0 ? session.isParent : null, (r22 & 32) != 0 ? session.parentSessionId : null, (r22 & 64) != 0 ? session.dappName : null, (r22 & 128) != 0 ? session.dappImageURL : null, (r22 & 256) != 0 ? session.dappURL : null, (r22 & 512) != 0 ? session.isApproved : Boolean.TRUE);
        linkRepository.updateSession(copy);
        return kotlin.x.a;
    }

    /* renamed from: approve$lambda-20 */
    public static final void m2141approve$lambda20(h.c.b0 markEventAsSeen, WalletLinkConnection this$0, final Web3ResponseDTO response, final Session session, kotlin.x xVar) {
        kotlin.jvm.internal.m.g(markEventAsSeen, "$markEventAsSeen");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(response, "$response");
        kotlin.jvm.internal.m.g(session, "$session");
        markEventAsSeen.flatMap(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.k0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.I(WalletLinkConnection.this, response, session, (kotlin.x) obj);
            }
        }).subscribe();
    }

    /* renamed from: approve$lambda-20$lambda-19 */
    public static final h.c.h0 m2142approve$lambda20$lambda19(WalletLinkConnection this$0, Web3ResponseDTO response, Session session, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(response, "$response");
        kotlin.jvm.internal.m.g(session, "$session");
        kotlin.jvm.internal.m.g(it, "it");
        String json = JSON.INSTANCE.parameterizedAdapter(Web3ResponseDTO.class, List.class).toJson(response);
        kotlin.jvm.internal.m.f(json, "adapter.toJson(this)");
        try {
            String encryptUsingAES256GCM = String_CryptoKt.encryptUsingAES256GCM(json, session.getSecret());
            h.c.s filter = this$0.isConnectedObservable.filter(WalletLinkConnection$submitWeb3Response$1.INSTANCE);
            kotlin.jvm.internal.m.f(filter, "isConnectedObservable\n            .filter { it }");
            h.c.b0 map = Observable_CoreKt.takeSingle(filter).flatMap(new WalletLinkConnection$submitWeb3Response$2(this$0, encryptUsingAES256GCM, session)).map(WalletLinkConnection$submitWeb3Response$3.INSTANCE);
            kotlin.jvm.internal.m.f(map, "private inline fun <reified T> submitWeb3Response(response: Web3ResponseDTO<T>, session: Session): Single<Unit> {\n        val json = response.asJsonString()\n        val encryptedString: String\n\n        try {\n            encryptedString = json.encryptUsingAES256GCM(secret = session.secret)\n        } catch (exception: Exception) {\n            return Single.error(WalletLinkException.UnableToEncryptData)\n        }\n\n        return isConnectedObservable\n            .filter { it }\n            .takeSingle()\n            .flatMap { socket.publishEvent(EventType.Web3Response, encryptedString, session.id) }\n            .map { if (!it) throw WalletLinkException.UnableToSendSignatureRequestConfirmation }\n    }");
            return map;
        } catch (Exception unused) {
            h.c.b0 error = h.c.b0.error(WalletLinkException.UnableToEncryptData.INSTANCE);
            kotlin.jvm.internal.m.f(error, "error(WalletLinkException.UnableToEncryptData)");
            return error;
        }
    }

    /* renamed from: approve$lambda-21 */
    public static final h.c.h0 m2143approve$lambda21(WalletLinkConnection this$0, Web3ResponseDTO response, Session session, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(response, "$response");
        kotlin.jvm.internal.m.g(session, "$session");
        kotlin.jvm.internal.m.g(it, "it");
        String json = JSON.INSTANCE.parameterizedAdapter(Web3ResponseDTO.class, Boolean.class).toJson(response);
        kotlin.jvm.internal.m.f(json, "adapter.toJson(this)");
        try {
            String encryptUsingAES256GCM = String_CryptoKt.encryptUsingAES256GCM(json, session.getSecret());
            h.c.s filter = this$0.isConnectedObservable.filter(WalletLinkConnection$submitWeb3Response$1.INSTANCE);
            kotlin.jvm.internal.m.f(filter, "isConnectedObservable\n            .filter { it }");
            h.c.b0 map = Observable_CoreKt.takeSingle(filter).flatMap(new WalletLinkConnection$submitWeb3Response$2(this$0, encryptUsingAES256GCM, session)).map(WalletLinkConnection$submitWeb3Response$3.INSTANCE);
            kotlin.jvm.internal.m.f(map, "private inline fun <reified T> submitWeb3Response(response: Web3ResponseDTO<T>, session: Session): Single<Unit> {\n        val json = response.asJsonString()\n        val encryptedString: String\n\n        try {\n            encryptedString = json.encryptUsingAES256GCM(secret = session.secret)\n        } catch (exception: Exception) {\n            return Single.error(WalletLinkException.UnableToEncryptData)\n        }\n\n        return isConnectedObservable\n            .filter { it }\n            .takeSingle()\n            .flatMap { socket.publishEvent(EventType.Web3Response, encryptedString, session.id) }\n            .map { if (!it) throw WalletLinkException.UnableToSendSignatureRequestConfirmation }\n    }");
            return map;
        } catch (Exception unused) {
            h.c.b0 error = h.c.b0.error(WalletLinkException.UnableToEncryptData.INSTANCE);
            kotlin.jvm.internal.m.f(error, "error(WalletLinkException.UnableToEncryptData)");
            return error;
        }
    }

    /* renamed from: approve$lambda-22 */
    public static final h.c.h0 m2144approve$lambda22(WalletLinkConnection this$0, Web3ResponseDTO response, Session session, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(response, "$response");
        kotlin.jvm.internal.m.g(session, "$session");
        kotlin.jvm.internal.m.g(it, "it");
        String json = JSON.INSTANCE.parameterizedAdapter(Web3ResponseDTO.class, String.class).toJson(response);
        kotlin.jvm.internal.m.f(json, "adapter.toJson(this)");
        try {
            String encryptUsingAES256GCM = String_CryptoKt.encryptUsingAES256GCM(json, session.getSecret());
            h.c.s filter = this$0.isConnectedObservable.filter(WalletLinkConnection$submitWeb3Response$1.INSTANCE);
            kotlin.jvm.internal.m.f(filter, "isConnectedObservable\n            .filter { it }");
            h.c.b0 map = Observable_CoreKt.takeSingle(filter).flatMap(new WalletLinkConnection$submitWeb3Response$2(this$0, encryptUsingAES256GCM, session)).map(WalletLinkConnection$submitWeb3Response$3.INSTANCE);
            kotlin.jvm.internal.m.f(map, "private inline fun <reified T> submitWeb3Response(response: Web3ResponseDTO<T>, session: Session): Single<Unit> {\n        val json = response.asJsonString()\n        val encryptedString: String\n\n        try {\n            encryptedString = json.encryptUsingAES256GCM(secret = session.secret)\n        } catch (exception: Exception) {\n            return Single.error(WalletLinkException.UnableToEncryptData)\n        }\n\n        return isConnectedObservable\n            .filter { it }\n            .takeSingle()\n            .flatMap { socket.publishEvent(EventType.Web3Response, encryptedString, session.id) }\n            .map { if (!it) throw WalletLinkException.UnableToSendSignatureRequestConfirmation }\n    }");
            return map;
        } catch (Exception unused) {
            h.c.b0 error = h.c.b0.error(WalletLinkException.UnableToEncryptData.INSTANCE);
            kotlin.jvm.internal.m.f(error, "error(WalletLinkException.UnableToEncryptData)");
            return error;
        }
    }

    /* renamed from: authorizedSessionsObservable$lambda-1 */
    public static final h.c.x m2145authorizedSessionsObservable$lambda1(WalletLinkConnection this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.linkRepository.observeSessions(this$0.getUrl());
    }

    /* renamed from: authorizedSessionsObservable$lambda-3 */
    public static final List m2146authorizedSessionsObservable$lambda3(List sessions) {
        kotlin.jvm.internal.m.g(sessions, "sessions");
        ArrayList arrayList = new ArrayList();
        for (Object obj : sessions) {
            if (((Session) obj).isAuthorized()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: authorizedSessionsObservable$lambda-4 */
    public static final List m2147authorizedSessionsObservable$lambda4(List previousSessions, List sessions) {
        Set C0;
        List I0;
        kotlin.jvm.internal.m.g(previousSessions, "previousSessions");
        kotlin.jvm.internal.m.g(sessions, "sessions");
        C0 = kotlin.a0.z.C0(sessions, previousSessions);
        I0 = kotlin.a0.z.I0(C0);
        return I0;
    }

    public static /* synthetic */ void b(WalletLinkConnection walletLinkConnection, boolean z, String str, String str2, String str3, String str4, String str5, URL url, Uri uri, h.c.k0.b bVar) {
        m2160link$lambda9(walletLinkConnection, z, str, str2, str3, str4, str5, url, uri, bVar);
    }

    public static /* synthetic */ List c(List list, Throwable th) {
        return m2165observeConnection$lambda40$lambda39(list, th);
    }

    public static /* synthetic */ h.c.x d(WalletLinkConnection walletLinkConnection, List list) {
        return m2161observeConnection$lambda40(walletLinkConnection, list);
    }

    public static /* synthetic */ h.c.x e(WalletLinkConnection walletLinkConnection, ServerRequestDTO serverRequestDTO) {
        return m2137_init_$lambda5(walletLinkConnection, serverRequestDTO);
    }

    public static /* synthetic */ void f(WalletLinkConnection walletLinkConnection, HostRequest hostRequest) {
        m2139_init_$lambda8(walletLinkConnection, hostRequest);
    }

    private final void fetchPendingRequests() {
        int r;
        h.c.b0 zip;
        List g2;
        List<Session> sessions = this.linkRepository.getSessions(this.url);
        r = kotlin.a0.s.r(sessions, 10);
        ArrayList arrayList = new ArrayList(r);
        for (final Session session : sessions) {
            arrayList.add(this.linkRepository.getPendingRequests(session).map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.b0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return WalletLinkConnection.z(WalletLinkConnection.this, session, (List) obj);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.WalletLinkConnection$fetchPendingRequests$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int length = it.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = it[i2];
                        if (obj != null ? obj instanceof List : true) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        h.c.b0 map = zip.map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.l((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "linkRepository.getSessions(url)\n            .map { session ->\n                linkRepository\n                    .getPendingRequests(session)\n                    .map { requests ->\n                        requests.filter { request ->\n                            isRequestAuthorizedForSession(request, session)\n                        }\n                    }\n            }\n            .zipOrEmpty()\n            .map { requests -> requests.flatten() }");
        h.c.t0.a.a(h.c.t0.g.i(Single_WalletLinkKt.logError$default(map, null, 1, null), null, new WalletLinkConnection$fetchPendingRequests$3(this), 1, null), this.disposeBag);
    }

    /* renamed from: fetchPendingRequests$lambda-34$lambda-33 */
    public static final List m2148fetchPendingRequests$lambda34$lambda33(WalletLinkConnection this$0, Session session, List requests) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(session, "$session");
        kotlin.jvm.internal.m.g(requests, "requests");
        ArrayList arrayList = new ArrayList();
        for (Object obj : requests) {
            if (this$0.isRequestAuthorizedForSession((HostRequest) obj, session)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: fetchPendingRequests$lambda-35 */
    public static final List m2149fetchPendingRequests$lambda35(List requests) {
        List u;
        kotlin.jvm.internal.m.g(requests, "requests");
        u = kotlin.a0.s.u(requests);
        return u;
    }

    public static /* synthetic */ boolean g(ConnectionStatus connectionStatus) {
        return m2170startConnection$lambda24(connectionStatus);
    }

    public static /* synthetic */ kotlin.x h(Throwable th) {
        return m2153joinSessions$lambda28$lambda27(th);
    }

    public static /* synthetic */ h.c.h0 i(WalletLinkConnection walletLinkConnection, Web3ResponseDTO web3ResponseDTO, Session session, kotlin.x xVar) {
        return m2143approve$lambda21(walletLinkConnection, web3ResponseDTO, session, xVar);
    }

    /* renamed from: isConnectedObservable$lambda-0 */
    public static final Boolean m2150isConnectedObservable$lambda0(WebConnectionState it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.isConnected());
    }

    private final boolean isRequestAuthorizedForSession(HostRequest hostRequest, Session session) {
        if (session.isAuthorized()) {
            return true;
        }
        if (hostRequest instanceof HostRequest.SwitchEthereumChain ? true : hostRequest instanceof HostRequest.RequestEthereumAccounts ? true : hostRequest instanceof HostRequest.RequestCanceled) {
            return true;
        }
        if (hostRequest instanceof HostRequest.ChildRequestEthereumAccounts ? true : hostRequest instanceof HostRequest.SignAndSubmitTx ? true : hostRequest instanceof HostRequest.SignMessage ? true : hostRequest instanceof HostRequest.SubmitSignedTx) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ h.c.h0 j(WalletLinkConnection walletLinkConnection, String str, Boolean bool) {
        return m2156link$lambda12(walletLinkConnection, str, bool);
    }

    private final h.c.b0<Boolean> joinSession(final Session session) {
        h.c.b0 map = this.socket.joinSession(new Credentials(session.getId(), session.getSecret()).getPassword(), session.getId()).flatMap(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.r(WalletLinkConnection.this, session, (Boolean) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.w
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.u(Session.this, this, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "socket.joinSession(credentials.password, session.id)\n            .flatMap { success ->\n                if (!success) {\n                    joinSessionEventsSubject.onNext(JoinSessionEvent(sessionId = session.id, joined = false))\n                    return@flatMap Single.just(false)\n                }\n\n                return@flatMap setSessionConfig(session = session)\n            }\n            .map { success ->\n                if (success) {\n                    Timber.d(\"[walletlink] successfully joined session ${session.id}\")\n\n                    joinSessionEventsSubject.onNext(JoinSessionEvent(sessionId = session.id, joined = true))\n\n                    return@map true\n                } else {\n                    Timber.d(\"[walletlink] Invalid session ${session.id}. Removing...\")\n\n                    linkRepository.delete(url = url, sessionId = session.id)\n                    joinSessionEventsSubject.onNext(JoinSessionEvent(sessionId = session.id, joined = false))\n\n                    return@map false\n                }\n            }");
        return Single_WalletLinkKt.logError$default(map, null, 1, null);
    }

    /* renamed from: joinSession$lambda-30 */
    public static final h.c.h0 m2151joinSession$lambda30(WalletLinkConnection this$0, Session session, Boolean success) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(session, "$session");
        kotlin.jvm.internal.m.g(success, "success");
        if (!success.booleanValue()) {
            this$0.joinSessionEventsSubject.onNext(new JoinSessionEvent(session.getId(), false));
            return h.c.b0.just(Boolean.FALSE);
        }
        return this$0.setSessionConfig(session);
    }

    /* renamed from: joinSession$lambda-31 */
    public static final Boolean m2152joinSession$lambda31(Session session, WalletLinkConnection this$0, Boolean success) {
        kotlin.jvm.internal.m.g(session, "$session");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(success, "success");
        if (success.booleanValue()) {
            l.a.a.a(kotlin.jvm.internal.m.o("[walletlink] successfully joined session ", session.getId()), new Object[0]);
            this$0.joinSessionEventsSubject.onNext(new JoinSessionEvent(session.getId(), true));
            return Boolean.TRUE;
        }
        l.a.a.a("[walletlink] Invalid session " + session.getId() + ". Removing...", new Object[0]);
        this$0.linkRepository.delete(this$0.getUrl(), session.getId());
        this$0.joinSessionEventsSubject.onNext(new JoinSessionEvent(session.getId(), false));
        return Boolean.FALSE;
    }

    private final h.c.b0<kotlin.x> joinSessions(List<Session> list) {
        int r;
        h.c.b0 zip;
        List g2;
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Session session : list) {
            arrayList.add(Single_CoreKt.asUnit(joinSession(session)).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.j
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return WalletLinkConnection.h((Throwable) obj);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.WalletLinkConnection$joinSessions$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int length = it.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = it[i2];
                        if (obj != null ? obj instanceof kotlin.x : true) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        h.c.b0<kotlin.x> map = zip.map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.s(WalletLinkConnection.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "sessions\n        .map { joinSession(it).asUnit().onErrorReturn { Unit } }\n        .zipOrEmpty()\n        .map { fetchPendingRequests() }");
        return map;
    }

    /* renamed from: joinSessions$lambda-28$lambda-27 */
    public static final kotlin.x m2153joinSessions$lambda28$lambda27(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    /* renamed from: joinSessions$lambda-29 */
    public static final kotlin.x m2154joinSessions$lambda29(WalletLinkConnection this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.fetchPendingRequests();
        return kotlin.x.a;
    }

    public static /* synthetic */ h.c.h0 k(WalletLinkConnection walletLinkConnection, ConnectionStatus connectionStatus) {
        return m2171startConnection$lambda25(walletLinkConnection, connectionStatus);
    }

    public static /* synthetic */ List l(List list) {
        return m2149fetchPendingRequests$lambda35(list);
    }

    /* renamed from: link$lambda-10 */
    public static final boolean m2155link$lambda10(Boolean it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.booleanValue();
    }

    /* renamed from: link$lambda-12 */
    public static final h.c.h0 m2156link$lambda12(WalletLinkConnection this$0, final String sessionId, Boolean it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(sessionId, "$sessionId");
        kotlin.jvm.internal.m.g(it, "it");
        h.c.s<JoinSessionEvent> filter = this$0.joinSessionEventsSubject.filter(new h.c.m0.p() { // from class: com.coinbase.walletlink.apis.s
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return WalletLinkConnection.q(sessionId, (JoinSessionEvent) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "joinSessionEventsSubject.filter { it.sessionId == sessionId }");
        return Observable_CoreKt.takeSingle(filter);
    }

    /* renamed from: link$lambda-12$lambda-11 */
    public static final boolean m2157link$lambda12$lambda11(String sessionId, JoinSessionEvent it) {
        kotlin.jvm.internal.m.g(sessionId, "$sessionId");
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.jvm.internal.m.c(it.getSessionId(), sessionId);
    }

    /* renamed from: link$lambda-13 */
    public static final kotlin.x m2158link$lambda13(JoinSessionEvent it) {
        kotlin.jvm.internal.m.g(it, "it");
        if (it.getJoined()) {
            return kotlin.x.a;
        }
        throw WalletLinkException.InvalidSession.INSTANCE;
    }

    /* renamed from: link$lambda-14 */
    public static final void m2159link$lambda14(WalletLinkConnection this$0, String sessionId, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(sessionId, "$sessionId");
        this$0.linkRepository.delete(this$0.getUrl(), sessionId);
    }

    /* renamed from: link$lambda-9 */
    public static final void m2160link$lambda9(WalletLinkConnection this$0, boolean z, String sessionId, String secret, String str, String str2, String str3, URL url, Uri uri, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(sessionId, "$sessionId");
        kotlin.jvm.internal.m.g(secret, "$secret");
        this$0.linkRepository.saveSession(this$0.getUrl(), sessionId, secret, str, z, !z, str2, str3, url, uri);
    }

    public static /* synthetic */ boolean m(Boolean bool) {
        return m2155link$lambda10(bool);
    }

    public static /* synthetic */ kotlin.x n(Throwable th) {
        return m2167observeConnection$lambda46(th);
    }

    public static /* synthetic */ HostRequest o(WalletLinkConnection walletLinkConnection, HostRequest hostRequest) {
        return m2138_init_$lambda7(walletLinkConnection, hostRequest);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashSet, T] */
    private final void observeConnection() {
        final kotlin.jvm.internal.d0 d0Var = new kotlin.jvm.internal.d0();
        d0Var.a = new HashSet();
        RxSchedulers rxSchedulers = RxSchedulers.INSTANCE;
        h.c.a0 newSerialScheduler = rxSchedulers.newSerialScheduler();
        h.c.x sessionChangesObservable = this.linkRepository.observeSessions(this.url).distinctUntilChanged().observeOn(rxSchedulers.newSerialScheduler()).concatMap(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.d(WalletLinkConnection.this, (List) obj);
            }
        });
        h.c.t0.c cVar = h.c.t0.c.a;
        h.c.s<Boolean> sVar = this.isConnectedObservable;
        kotlin.jvm.internal.m.f(sessionChangesObservable, "sessionChangesObservable");
        h.c.k0.b subscribe = cVar.a(sVar, sessionChangesObservable).observeOn(newSerialScheduler).debounce(300L, TimeUnit.MILLISECONDS).concatMap(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.d0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.B(kotlin.jvm.internal.d0.this, this, (kotlin.o) obj);
            }
        }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.n((Throwable) obj);
            }
        }).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "Observables.combineLatest(isConnectedObservable, sessionChangesObservable)\n            .observeOn(sessionSerialScheduler)\n            .debounce(300, TimeUnit.MILLISECONDS)\n            .concatMap { (isConnected, sessions) ->\n                if (!isConnected) {\n                    joinedSessionIds.clear()\n                    return@concatMap Observable.just(Unit)\n                }\n\n                val currentSessionIds = HashSet(sessions.map { it.id })\n\n                // remove unlinked sessions\n                joinedSessionIds = joinedSessionIds.filterTo(HashSet()) { currentSessionIds.contains(it) }\n\n                val newSessions = sessions.filter { !joinedSessionIds.contains(it.id) }\n                newSessions.forEach { joinedSessionIds.add(it.id) }\n\n                joinSessions(sessions = newSessions).toObservable()\n            }\n            .onErrorReturn { Unit }\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
        h.c.s<R> flatMapSingle = this.authorizedSessionsObservable.flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.y
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.w(WalletLinkConnection.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMapSingle, "authorizedSessionsObservable\n            .flatMapSingle { sessions -> syncMetadata(sessions) }");
        h.c.t0.a.a(h.c.t0.g.h(flatMapSingle, null, null, null, 7, null), this.disposeBag);
    }

    /* renamed from: observeConnection$lambda-40 */
    public static final h.c.x m2161observeConnection$lambda40(WalletLinkConnection this$0, final List sessions) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(sessions, "sessions");
        if (!sessions.isEmpty()) {
            return this$0.startConnection().map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.e0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return WalletLinkConnection.C(sessions, (kotlin.x) obj);
                }
            }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.r
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return WalletLinkConnection.p(sessions, (Throwable) obj);
                }
            }).toObservable();
        }
        return this$0.stopConnection().map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.x
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.v(sessions, (kotlin.x) obj);
            }
        }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.c(sessions, (Throwable) obj);
            }
        }).toObservable();
    }

    /* renamed from: observeConnection$lambda-40$lambda-36 */
    public static final List m2162observeConnection$lambda40$lambda36(List sessions, kotlin.x it) {
        kotlin.jvm.internal.m.g(sessions, "$sessions");
        kotlin.jvm.internal.m.g(it, "it");
        return sessions;
    }

    /* renamed from: observeConnection$lambda-40$lambda-37 */
    public static final List m2163observeConnection$lambda40$lambda37(List sessions, Throwable it) {
        kotlin.jvm.internal.m.g(sessions, "$sessions");
        kotlin.jvm.internal.m.g(it, "it");
        return sessions;
    }

    /* renamed from: observeConnection$lambda-40$lambda-38 */
    public static final List m2164observeConnection$lambda40$lambda38(List sessions, kotlin.x it) {
        kotlin.jvm.internal.m.g(sessions, "$sessions");
        kotlin.jvm.internal.m.g(it, "it");
        return sessions;
    }

    /* renamed from: observeConnection$lambda-40$lambda-39 */
    public static final List m2165observeConnection$lambda40$lambda39(List sessions, Throwable it) {
        kotlin.jvm.internal.m.g(sessions, "$sessions");
        kotlin.jvm.internal.m.g(it, "it");
        return sessions;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.HashSet, T, java.util.Collection] */
    /* renamed from: observeConnection$lambda-45 */
    public static final h.c.x m2166observeConnection$lambda45(kotlin.jvm.internal.d0 joinedSessionIds, WalletLinkConnection this$0, kotlin.o dstr$isConnected$sessions) {
        int r;
        kotlin.jvm.internal.m.g(joinedSessionIds, "$joinedSessionIds");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$isConnected$sessions, "$dstr$isConnected$sessions");
        boolean booleanValue = ((Boolean) dstr$isConnected$sessions.a()).booleanValue();
        List<Session> sessions = (List) dstr$isConnected$sessions.b();
        if (!booleanValue) {
            ((HashSet) joinedSessionIds.a).clear();
            return h.c.s.just(kotlin.x.a);
        }
        kotlin.jvm.internal.m.f(sessions, "sessions");
        r = kotlin.a0.s.r(sessions, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Session session : sessions) {
            arrayList.add(session.getId());
        }
        HashSet hashSet = new HashSet(arrayList);
        ?? hashSet2 = new HashSet();
        for (Object obj : (Iterable) joinedSessionIds.a) {
            if (hashSet.contains((String) obj)) {
                hashSet2.add(obj);
            }
        }
        joinedSessionIds.a = hashSet2;
        List<Session> arrayList2 = new ArrayList<>();
        for (Object obj2 : sessions) {
            if (!((HashSet) joinedSessionIds.a).contains(((Session) obj2).getId())) {
                arrayList2.add(obj2);
            }
        }
        for (Session session2 : arrayList2) {
            ((HashSet) joinedSessionIds.a).add(session2.getId());
        }
        return this$0.joinSessions(arrayList2).toObservable();
    }

    /* renamed from: observeConnection$lambda-46 */
    public static final kotlin.x m2167observeConnection$lambda46(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    /* renamed from: observeConnection$lambda-47 */
    public static final h.c.h0 m2168observeConnection$lambda47(WalletLinkConnection this$0, List sessions) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(sessions, "sessions");
        return this$0.syncMetadata(sessions);
    }

    public static /* synthetic */ List p(List list, Throwable th) {
        return m2163observeConnection$lambda40$lambda37(list, th);
    }

    public static /* synthetic */ boolean q(String str, JoinSessionEvent joinSessionEvent) {
        return m2157link$lambda12$lambda11(str, joinSessionEvent);
    }

    public static /* synthetic */ h.c.h0 r(WalletLinkConnection walletLinkConnection, Session session, Boolean bool) {
        return m2151joinSession$lambda30(walletLinkConnection, session, bool);
    }

    /* renamed from: reject$lambda-23 */
    public static final h.c.h0 m2169reject$lambda23(WalletLinkConnection this$0, Web3ResponseDTO response, Session session, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(response, "$response");
        kotlin.jvm.internal.m.g(session, "$session");
        kotlin.jvm.internal.m.g(it, "it");
        String json = JSON.INSTANCE.parameterizedAdapter(Web3ResponseDTO.class, String.class).toJson(response);
        kotlin.jvm.internal.m.f(json, "adapter.toJson(this)");
        try {
            String encryptUsingAES256GCM = String_CryptoKt.encryptUsingAES256GCM(json, session.getSecret());
            h.c.s filter = this$0.isConnectedObservable.filter(WalletLinkConnection$submitWeb3Response$1.INSTANCE);
            kotlin.jvm.internal.m.f(filter, "isConnectedObservable\n            .filter { it }");
            h.c.b0 map = Observable_CoreKt.takeSingle(filter).flatMap(new WalletLinkConnection$submitWeb3Response$2(this$0, encryptUsingAES256GCM, session)).map(WalletLinkConnection$submitWeb3Response$3.INSTANCE);
            kotlin.jvm.internal.m.f(map, "private inline fun <reified T> submitWeb3Response(response: Web3ResponseDTO<T>, session: Session): Single<Unit> {\n        val json = response.asJsonString()\n        val encryptedString: String\n\n        try {\n            encryptedString = json.encryptUsingAES256GCM(secret = session.secret)\n        } catch (exception: Exception) {\n            return Single.error(WalletLinkException.UnableToEncryptData)\n        }\n\n        return isConnectedObservable\n            .filter { it }\n            .takeSingle()\n            .flatMap { socket.publishEvent(EventType.Web3Response, encryptedString, session.id) }\n            .map { if (!it) throw WalletLinkException.UnableToSendSignatureRequestConfirmation }\n    }");
            return map;
        } catch (Exception unused) {
            h.c.b0 error = h.c.b0.error(WalletLinkException.UnableToEncryptData.INSTANCE);
            kotlin.jvm.internal.m.f(error, "error(WalletLinkException.UnableToEncryptData)");
            return error;
        }
    }

    public static /* synthetic */ kotlin.x s(WalletLinkConnection walletLinkConnection, List list) {
        return m2154joinSessions$lambda29(walletLinkConnection, list);
    }

    private final h.c.b0<Boolean> setSessionConfig(Session session) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<ClientMetadataKey, String> entry : this.metadata.entrySet()) {
            ClientMetadataKey key = entry.getKey();
            String value = entry.getValue();
            if (session.isAuthorized() || key == ClientMetadataKey.WalletUsername) {
                try {
                    hashMap.put(key.getRawValue(), String_CryptoKt.encryptUsingAES256GCM(value, session.getSecret()));
                } catch (Exception unused) {
                    h.c.b0<Boolean> error = h.c.b0.error(WalletLinkException.UnableToEncryptData.INSTANCE);
                    kotlin.jvm.internal.m.f(error, "error(WalletLinkException.UnableToEncryptData)");
                    return error;
                }
            }
        }
        return WalletLinkWebSocket.setSessionConfig$default(this.socket, this.userId, this.notificationUrl, hashMap, session.getId(), null, 16, null);
    }

    private final h.c.b0<kotlin.x> startConnection() {
        h.c.s<ConnectionStatus> filter = Internet.INSTANCE.getStatusChanges().filter(new h.c.m0.p() { // from class: com.coinbase.walletlink.apis.i
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return WalletLinkConnection.g((ConnectionStatus) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "Internet.statusChanges\n            .filter { it.isOnline }");
        h.c.b0 flatMap = Observable_CoreKt.takeSingle(filter).flatMap(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.k(WalletLinkConnection.this, (ConnectionStatus) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "Internet.statusChanges\n            .filter { it.isOnline }\n            .takeSingle()\n            .flatMap { socket.connect() }");
        return Single_WalletLinkKt.logError$default(flatMap, null, 1, null);
    }

    /* renamed from: startConnection$lambda-24 */
    public static final boolean m2170startConnection$lambda24(ConnectionStatus it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.isOnline();
    }

    /* renamed from: startConnection$lambda-25 */
    public static final h.c.h0 m2171startConnection$lambda25(WalletLinkConnection this$0, ConnectionStatus it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.socket.connect();
    }

    private final h.c.b0<kotlin.x> stopConnection() {
        h.c.b0<kotlin.x> onErrorReturn = Single_WalletLinkKt.logError$default(this.socket.disconnect(), null, 1, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.a((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "socket.disconnect()\n            .logError()\n            .onErrorReturn { Single.just(Unit) }");
        return onErrorReturn;
    }

    /* renamed from: stopConnection$lambda-26 */
    public static final kotlin.x m2172stopConnection$lambda26(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        kotlin.x xVar = kotlin.x.a;
        h.c.b0.just(xVar);
        return xVar;
    }

    private final /* synthetic */ <T> h.c.b0<kotlin.x> submitWeb3Response(Web3ResponseDTO<T> web3ResponseDTO, Session session) {
        JSON json = JSON.INSTANCE;
        kotlin.jvm.internal.m.l(4, "T");
        String json2 = json.parameterizedAdapter(Web3ResponseDTO.class, Object.class).toJson(web3ResponseDTO);
        kotlin.jvm.internal.m.f(json2, "adapter.toJson(this)");
        try {
            String encryptUsingAES256GCM = String_CryptoKt.encryptUsingAES256GCM(json2, session.getSecret());
            h.c.s<T> filter = this.isConnectedObservable.filter(WalletLinkConnection$submitWeb3Response$1.INSTANCE);
            kotlin.jvm.internal.m.f(filter, "isConnectedObservable\n            .filter { it }");
            h.c.b0<kotlin.x> map = Observable_CoreKt.takeSingle(filter).flatMap(new WalletLinkConnection$submitWeb3Response$2(this, encryptUsingAES256GCM, session)).map(WalletLinkConnection$submitWeb3Response$3.INSTANCE);
            kotlin.jvm.internal.m.f(map, "private inline fun <reified T> submitWeb3Response(response: Web3ResponseDTO<T>, session: Session): Single<Unit> {\n        val json = response.asJsonString()\n        val encryptedString: String\n\n        try {\n            encryptedString = json.encryptUsingAES256GCM(secret = session.secret)\n        } catch (exception: Exception) {\n            return Single.error(WalletLinkException.UnableToEncryptData)\n        }\n\n        return isConnectedObservable\n            .filter { it }\n            .takeSingle()\n            .flatMap { socket.publishEvent(EventType.Web3Response, encryptedString, session.id) }\n            .map { if (!it) throw WalletLinkException.UnableToSendSignatureRequestConfirmation }\n    }");
            return map;
        } catch (Exception unused) {
            h.c.b0<kotlin.x> error = h.c.b0.error(WalletLinkException.UnableToEncryptData.INSTANCE);
            kotlin.jvm.internal.m.f(error, "error(WalletLinkException.UnableToEncryptData)");
            return error;
        }
    }

    private final h.c.b0<kotlin.x> syncMetadata(List<Session> list) {
        List u;
        h.c.b0 zip;
        List g2;
        ArrayList arrayList = new ArrayList();
        for (Session session : list) {
            Set<Map.Entry<ClientMetadataKey, String>> entrySet = this.metadata.entrySet();
            kotlin.jvm.internal.m.f(entrySet, "metadata.entries");
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = entrySet.iterator();
            while (true) {
                h.c.b0 b0Var = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                kotlin.jvm.internal.m.f(entry, "(key, value)");
                ClientMetadataKey key = (ClientMetadataKey) entry.getKey();
                String value = (String) entry.getValue();
                try {
                    kotlin.jvm.internal.m.f(value, "value");
                    String encryptUsingAES256GCM = String_CryptoKt.encryptUsingAES256GCM(value, session.getSecret());
                    WalletLinkWebSocket walletLinkWebSocket = this.socket;
                    kotlin.jvm.internal.m.f(key, "key");
                    b0Var = Single_WalletLinkKt.logError$default(walletLinkWebSocket.setMetadata(key, encryptUsingAES256GCM, session.getId()), null, 1, null);
                } catch (WalletLinkException.UnableToEncryptData unused) {
                }
                if (b0Var != null) {
                    arrayList2.add(b0Var);
                }
            }
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            if (arrayList2 != null) {
                arrayList.add(arrayList2);
            }
        }
        u = kotlin.a0.s.u(arrayList);
        h.c.t0.e eVar = h.c.t0.e.a;
        if (u.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(u, new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.WalletLinkConnection$syncMetadata$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it2) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it2, "it");
                    if (it2.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : it2) {
                        if (obj instanceof Boolean) {
                            arrayList3.add(obj);
                        }
                    }
                    return arrayList3;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return Single_CoreKt.asUnit(zip);
    }

    public static /* synthetic */ kotlin.x t(WalletLinkConnection walletLinkConnection, Session session, kotlin.x xVar) {
        return m2140approve$lambda18(walletLinkConnection, session, xVar);
    }

    public static /* synthetic */ Boolean u(Session session, WalletLinkConnection walletLinkConnection, Boolean bool) {
        return m2152joinSession$lambda31(session, walletLinkConnection, bool);
    }

    public static /* synthetic */ List v(List list, kotlin.x xVar) {
        return m2164observeConnection$lambda40$lambda38(list, xVar);
    }

    public static /* synthetic */ h.c.h0 w(WalletLinkConnection walletLinkConnection, List list) {
        return m2168observeConnection$lambda47(walletLinkConnection, list);
    }

    public static /* synthetic */ h.c.x x(WalletLinkConnection walletLinkConnection, List list) {
        return m2145authorizedSessionsObservable$lambda1(walletLinkConnection, list);
    }

    public static /* synthetic */ Boolean y(WebConnectionState webConnectionState) {
        return m2150isConnectedObservable$lambda0(webConnectionState);
    }

    public static /* synthetic */ List z(WalletLinkConnection walletLinkConnection, Session session, List list) {
        return m2148fetchPendingRequests$lambda34$lambda33(walletLinkConnection, session, list);
    }

    public final h.c.b0<kotlin.x> approve(HostRequestId requestId, byte[] responseData) {
        List b2;
        kotlin.jvm.internal.m.g(requestId, "requestId");
        kotlin.jvm.internal.m.g(responseData, "responseData");
        final Session session = this.linkRepository.getSession(requestId.getSessionId(), this.url);
        if (session == null) {
            h.c.b0<kotlin.x> error = h.c.b0.error(WalletLinkException.SessionNotFound.INSTANCE);
            kotlin.jvm.internal.m.f(error, "error(WalletLinkException.SessionNotFound)");
            return error;
        }
        final h.c.b0<kotlin.x> markAsSeen = this.linkRepository.markAsSeen(requestId, this.url);
        switch (WhenMappings.$EnumSwitchMapping$0[requestId.getMethod$walletlink_release().ordinal()]) {
            case 1:
            case 2:
                String str = new String(responseData, kotlin.l0.d.a);
                String id = requestId.getId();
                RequestMethod method$walletlink_release = requestId.getMethod$walletlink_release();
                String lowerCase = str.toLowerCase();
                kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase()");
                b2 = kotlin.a0.q.b(lowerCase);
                final Web3ResponseDTO web3ResponseDTO = new Web3ResponseDTO(id, method$walletlink_release, b2);
                h.c.b0<kotlin.x> doOnSuccess = this.linkRepository.saveDapp(new Dapp(requestId.getDappURL(), requestId.getDappName(), requestId.getDappImageURL())).map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.v
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return WalletLinkConnection.t(WalletLinkConnection.this, session, (kotlin.x) obj);
                    }
                }).doOnSuccess(new h.c.m0.f() { // from class: com.coinbase.walletlink.apis.c0
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        WalletLinkConnection.m2141approve$lambda20(h.c.b0.this, this, web3ResponseDTO, session, (kotlin.x) obj);
                    }
                });
                kotlin.jvm.internal.m.f(doOnSuccess, "linkRepository.saveDapp(dapp)\n                    .map { linkRepository.updateSession(session.copy(isApproved = true)) }\n                    .doOnSuccess {\n                        markEventAsSeen\n                            .flatMap { submitWeb3Response(response, session) }\n                            .subscribe()\n                    }");
                return doOnSuccess;
            case 3:
                final Web3ResponseDTO web3ResponseDTO2 = new Web3ResponseDTO(requestId.getId(), requestId.getMethod$walletlink_release(), Boolean.TRUE);
                h.c.b0 flatMap = markAsSeen.flatMap(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.k
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return WalletLinkConnection.i(WalletLinkConnection.this, web3ResponseDTO2, session, (kotlin.x) obj);
                    }
                });
                kotlin.jvm.internal.m.f(flatMap, "markEventAsSeen.flatMap { submitWeb3Response(response, session) }");
                return flatMap;
            case 4:
            case 5:
            case 6:
                final Web3ResponseDTO web3ResponseDTO3 = new Web3ResponseDTO(requestId.getId(), requestId.getMethod$walletlink_release(), ByteArray_CoreKt.toPrefixedHexString(responseData));
                h.c.b0 flatMap2 = markAsSeen.flatMap(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.l0
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return WalletLinkConnection.J(WalletLinkConnection.this, web3ResponseDTO3, session, (kotlin.x) obj);
                    }
                });
                kotlin.jvm.internal.m.f(flatMap2, "markEventAsSeen.flatMap { submitWeb3Response(response, session) }");
                return flatMap2;
            case 7:
                h.c.b0<kotlin.x> error2 = h.c.b0.error(WalletLinkException.UnsupportedRequestMethodApproval.INSTANCE);
                kotlin.jvm.internal.m.f(error2, "{\n                Single.error(WalletLinkException.UnsupportedRequestMethodApproval)\n            }");
                return error2;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final h.c.b0<Boolean> destroySession(String sessionId) {
        Map<String, String> e2;
        kotlin.jvm.internal.m.g(sessionId, "sessionId");
        WalletLinkWebSocket walletLinkWebSocket = this.socket;
        e2 = kotlin.a0.l0.e(kotlin.u.a(ClientMetadataKey.Destroyed.getRawValue(), Strings_WalletLinkKt.getDestroySession(Strings.INSTANCE)));
        return walletLinkWebSocket.setSessionConfig(null, null, e2, sessionId, 5L);
    }

    public final void disconnect() {
        this.disposeBag.d();
        stopConnection().subscribe();
    }

    public final h.c.s<String> getDisconnectSessionObservable() {
        return this.disconnectSessionObservable;
    }

    public final h.c.s<HostRequest> getRequestsObservable() {
        return this.requestsObservable;
    }

    public final URL getUrl() {
        return this.url;
    }

    public final h.c.b0<kotlin.x> link(final String sessionId, final String secret, final String str, final boolean z, final String str2, final String str3, final URL url, final Uri uri) {
        kotlin.jvm.internal.m.g(sessionId, "sessionId");
        kotlin.jvm.internal.m.g(secret, "secret");
        Session session = this.linkRepository.getSession(sessionId, this.url);
        if (session != null && kotlin.jvm.internal.m.c(session.getSecret(), secret)) {
            h.c.b0<kotlin.x> just = h.c.b0.just(kotlin.x.a);
            kotlin.jvm.internal.m.f(just, "just(Unit)");
            return just;
        }
        h.c.s<Boolean> filter = this.isConnectedObservable.doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.walletlink.apis.d
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                WalletLinkConnection.b(WalletLinkConnection.this, z, sessionId, secret, str, str2, str3, url, uri, (h.c.k0.b) obj);
            }
        }).filter(new h.c.m0.p() { // from class: com.coinbase.walletlink.apis.o
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return WalletLinkConnection.m((Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "isConnectedObservable\n            .doOnSubscribe {\n                linkRepository.saveSession(\n                    url = url,\n                    sessionId = sessionId,\n                    secret = secret,\n                    version = version,\n                    isParent = isParent,\n                    parentSessionId = parentSessionId,\n                    dappName = dappName,\n                    dappImageURL = dappImageURL,\n                    dappURL = dappURL,\n                    isApproved = !isParent\n                )\n            }\n            .filter { it }");
        h.c.b0 timeout = Observable_CoreKt.takeSingle(filter).flatMap(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.j(WalletLinkConnection.this, sessionId, (Boolean) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.f0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.D((JoinSessionEvent) obj);
            }
        }).timeout(15L, TimeUnit.SECONDS);
        kotlin.jvm.internal.m.f(timeout, "isConnectedObservable\n            .doOnSubscribe {\n                linkRepository.saveSession(\n                    url = url,\n                    sessionId = sessionId,\n                    secret = secret,\n                    version = version,\n                    isParent = isParent,\n                    parentSessionId = parentSessionId,\n                    dappName = dappName,\n                    dappImageURL = dappImageURL,\n                    dappURL = dappURL,\n                    isApproved = !isParent\n                )\n            }\n            .filter { it }\n            .takeSingle()\n            .flatMap { joinSessionEventsSubject.filter { it.sessionId == sessionId }.takeSingle() }\n            .map { if (!it.joined) throw WalletLinkException.InvalidSession }\n            .timeout(15, TimeUnit.SECONDS)");
        h.c.b0<kotlin.x> doOnError = Single_WalletLinkKt.logError$default(timeout, null, 1, null).doOnError(new h.c.m0.f() { // from class: com.coinbase.walletlink.apis.j0
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                WalletLinkConnection.H(WalletLinkConnection.this, sessionId, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnError, "isConnectedObservable\n            .doOnSubscribe {\n                linkRepository.saveSession(\n                    url = url,\n                    sessionId = sessionId,\n                    secret = secret,\n                    version = version,\n                    isParent = isParent,\n                    parentSessionId = parentSessionId,\n                    dappName = dappName,\n                    dappImageURL = dappImageURL,\n                    dappURL = dappURL,\n                    isApproved = !isParent\n                )\n            }\n            .filter { it }\n            .takeSingle()\n            .flatMap { joinSessionEventsSubject.filter { it.sessionId == sessionId }.takeSingle() }\n            .map { if (!it.joined) throw WalletLinkException.InvalidSession }\n            .timeout(15, TimeUnit.SECONDS)\n            .logError()\n            .doOnError { linkRepository.delete(url, sessionId) }");
        return doOnError;
    }

    public final h.c.b0<kotlin.x> reject(HostRequestId requestId) {
        kotlin.jvm.internal.m.g(requestId, "requestId");
        final Session session = this.linkRepository.getSession(requestId.getSessionId(), this.url);
        if (session == null) {
            h.c.b0<kotlin.x> error = h.c.b0.error(WalletLinkException.SessionNotFound.INSTANCE);
            kotlin.jvm.internal.m.f(error, "error(WalletLinkException.SessionNotFound)");
            return error;
        }
        final Web3ResponseDTO web3ResponseDTO = new Web3ResponseDTO(requestId.getId(), requestId.getMethod$walletlink_release(), "User rejected signature request");
        h.c.b0 flatMap = this.linkRepository.markAsSeen(requestId, this.url).flatMap(new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.g0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkConnection.E(WalletLinkConnection.this, web3ResponseDTO, session, (kotlin.x) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "linkRepository.markAsSeen(requestId, url)\n            .flatMap { submitWeb3Response(response, session = session) }");
        return flatMap;
    }

    public final h.c.b0<kotlin.x> setMetadata(ClientMetadataKey key, String value) {
        h.c.b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(key, "key");
        kotlin.jvm.internal.m.g(value, "value");
        this.metadata.put(key, value);
        List<Session> sessions = this.linkRepository.getSessions(this.url);
        ArrayList arrayList = new ArrayList();
        for (Session session : sessions) {
            h.c.b0 b0Var = null;
            if (session.isAuthorized() || key == ClientMetadataKey.WalletUsername) {
                try {
                    b0Var = Single_WalletLinkKt.logError$default(this.socket.setMetadata(key, String_CryptoKt.encryptUsingAES256GCM(value, session.getSecret()), session.getId()), null, 1, null);
                } catch (WalletLinkException.UnableToEncryptData unused) {
                }
            }
            if (b0Var != null) {
                arrayList.add(b0Var);
            }
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.walletlink.apis.WalletLinkConnection$setMetadata$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : it) {
                        if (obj instanceof Boolean) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return Single_CoreKt.asUnit(zip);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WalletLinkConnection(URL url, String userId, URL notificationUrl, LinkRepository linkRepository, Map<ClientMetadataKey, String> metadata) {
        this(userId, notificationUrl, linkRepository, new ConcurrentHashMap(metadata), url);
        kotlin.jvm.internal.m.g(url, "url");
        kotlin.jvm.internal.m.g(userId, "userId");
        kotlin.jvm.internal.m.g(notificationUrl, "notificationUrl");
        kotlin.jvm.internal.m.g(linkRepository, "linkRepository");
        kotlin.jvm.internal.m.g(metadata, "metadata");
    }
}