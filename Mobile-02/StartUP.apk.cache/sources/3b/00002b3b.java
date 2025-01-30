package com.coinbase.walletlink;

import android.content.Context;
import android.net.Uri;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.util.BoundedSet;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.core.util.RxSchedulers;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.apis.WalletLinkConnection;
import com.coinbase.walletlink.exceptions.WalletLinkException;
import com.coinbase.walletlink.models.ClientMetadataKey;
import com.coinbase.walletlink.models.HostRequest;
import com.coinbase.walletlink.models.HostRequestId;
import com.coinbase.walletlink.models.Session;
import com.coinbase.walletlink.repositories.LinkRepository;
import h.c.a0;
import h.c.b0;
import h.c.m0.n;
import h.c.m0.p;
import h.c.s;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.protocol.HttpRequestExecutor;

/* compiled from: WalletLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010I\u001a\u00020\u001e\u0012\u0006\u0010U\u001a\u00020T¢\u0006\u0004\bV\u0010WJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0083\u0001\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040$2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0#H\u0016¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040$2\u0006\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010)J%\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040$2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u000eH\u0016¢\u0006\u0004\b,\u0010-J%\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040$2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040$2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b4\u00105J#\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040$2\f\u00106\u001a\b\u0012\u0004\u0012\u00020.0\u0007H\u0016¢\u0006\u0004\b7\u00108J-\u0010;\u001a\b\u0012\u0004\u0012\u00020:0$2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u001eH\u0016¢\u0006\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010C\u001a\b\u0012\u0004\u0012\u00020:0\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\rR\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020.0K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\"\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR$\u0010R\u001a\u0010\u0012\f\u0012\n Q*\u0004\u0018\u00010:0:0P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010S¨\u0006X"}, d2 = {"Lcom/coinbase/walletlink/WalletLink;", "Lcom/coinbase/walletlink/WalletLinkInterface;", "Lcom/coinbase/walletlink/apis/WalletLinkConnection;", "conn", "Lkotlin/x;", "observeConnection", "(Lcom/coinbase/walletlink/apis/WalletLinkConnection;)V", "", "Lcom/coinbase/walletlink/models/Session;", "sessions", "()Ljava/util/List;", "Lh/c/s;", "observeSessions", "()Lh/c/s;", "", "userId", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/coinbase/walletlink/models/ClientMetadataKey;", SendConfirmationArgs.metadataKey, "connect", "(Ljava/lang/String;Ljava/util/concurrent/ConcurrentHashMap;)V", "disconnect", "()V", WalletLinkPushNotification.sessionIdKey, "secret", ClientCookie.VERSION_ATTR, "", "isParent", "parentSessionId", WalletLinkCompleteArgs.DAPP_NAME, "Ljava/net/URL;", "dappImageURL", "Landroid/net/Uri;", "dappURL", "url", "", "Lh/c/b0;", "link", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/net/URL;Landroid/net/Uri;Ljava/net/URL;Ljava/lang/String;Ljava/util/Map;)Lh/c/b0;", "session", "unlink", "(Lcom/coinbase/walletlink/models/Session;)Lh/c/b0;", "key", "value", "setMetadata", "(Lcom/coinbase/walletlink/models/ClientMetadataKey;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/walletlink/models/HostRequestId;", "requestId", "", "signedData", "approve", "(Lcom/coinbase/walletlink/models/HostRequestId;[B)Lh/c/b0;", "reject", "(Lcom/coinbase/walletlink/models/HostRequestId;)Lh/c/b0;", "requestIds", "markAsSeen", "(Ljava/util/List;)Lh/c/b0;", WalletLinkPushNotification.eventIdKey, "Lcom/coinbase/walletlink/models/HostRequest;", "getRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;)Lh/c/b0;", "Lh/c/a0;", "requestsScheduler", "Lh/c/a0;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "requestsObservable", "Lh/c/s;", "getRequestsObservable", "Lcom/coinbase/walletlink/repositories/LinkRepository;", "linkRepository", "Lcom/coinbase/walletlink/repositories/LinkRepository;", "notificationUrl", "Ljava/net/URL;", "Lcom/coinbase/wallet/core/util/BoundedSet;", "processedRequestIds", "Lcom/coinbase/wallet/core/util/BoundedSet;", "connections", "Ljava/util/concurrent/ConcurrentHashMap;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "requestsSubject", "Lh/c/v0/b;", "Landroid/content/Context;", "context", "<init>", "(Ljava/net/URL;Landroid/content/Context;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletLink implements WalletLinkInterface {
    private ConcurrentHashMap<URL, WalletLinkConnection> connections;
    private final h.c.k0.a disposeBag;
    private final LinkRepository linkRepository;
    private final URL notificationUrl;
    private final BoundedSet<HostRequestId> processedRequestIds;
    private final s<HostRequest> requestsObservable;
    private final a0 requestsScheduler;
    private final h.c.v0.b<HostRequest> requestsSubject;

    public WalletLink(URL notificationUrl, Context context) {
        m.g(notificationUrl, "notificationUrl");
        m.g(context, "context");
        this.notificationUrl = notificationUrl;
        h.c.v0.b<HostRequest> d2 = h.c.v0.b.d();
        m.f(d2, "create<HostRequest>()");
        this.requestsSubject = d2;
        this.requestsScheduler = RxSchedulers.INSTANCE.newSerialScheduler();
        this.processedRequestIds = new BoundedSet<>(HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE);
        this.linkRepository = new LinkRepository(context);
        this.disposeBag = new h.c.k0.a();
        this.connections = new ConcurrentHashMap<>();
        s<HostRequest> hide = d2.hide();
        m.f(hide, "requestsSubject.hide()");
        this.requestsObservable = hide;
    }

    public static /* synthetic */ Optional a(HostRequest hostRequest) {
        return m2128observeConnection$lambda14(hostRequest);
    }

    public static /* synthetic */ Optional b(Throwable th) {
        return m2129observeConnection$lambda15(th);
    }

    public static /* synthetic */ void c(WalletLink walletLink, URL url, Throwable th) {
        m2126link$lambda6(walletLink, url, th);
    }

    public static /* synthetic */ void e(WalletLink walletLink, HostRequest hostRequest) {
        m2130observeConnection$lambda16(walletLink, hostRequest);
    }

    public static /* synthetic */ x f(WalletLink walletLink, Session session, Boolean bool) {
        return m2134unlink$lambda7(walletLink, session, bool);
    }

    public static /* synthetic */ Optional g(Throwable th) {
        return m2132observeConnection$lambda18(th);
    }

    /* renamed from: getRequest$lambda-13 */
    public static final HostRequest m2124getRequest$lambda13(String eventId, List requests) {
        Object obj;
        m.g(eventId, "$eventId");
        m.g(requests, "requests");
        Iterator it = requests.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (m.c(eventId, ((HostRequest) obj).getHostRequestId().getEventId())) {
                break;
            }
        }
        HostRequest hostRequest = (HostRequest) obj;
        if (hostRequest != null) {
            return hostRequest;
        }
        throw WalletLinkException.EventNotFound.INSTANCE;
    }

    public static /* synthetic */ Optional h(String str) {
        return m2131observeConnection$lambda17(str);
    }

    public static /* synthetic */ x i(Throwable th) {
        return m2133setMetadata$lambda9$lambda8(th);
    }

    public static /* synthetic */ x j(Throwable th) {
        return m2127markAsSeen$lambda11$lambda10(th);
    }

    public static /* synthetic */ HostRequest k(String str, List list) {
        return m2124getRequest$lambda13(str, list);
    }

    /* renamed from: link$lambda-5 */
    public static final x m2125link$lambda5(WalletLink this$0, WalletLinkConnection connection, x it) {
        m.g(this$0, "this$0");
        m.g(connection, "$connection");
        m.g(it, "it");
        this$0.observeConnection(connection);
        return x.a;
    }

    /* renamed from: link$lambda-6 */
    public static final void m2126link$lambda6(WalletLink this$0, URL url, Throwable th) {
        m.g(this$0, "this$0");
        m.g(url, "$url");
        this$0.connections.remove(url);
    }

    /* renamed from: markAsSeen$lambda-11$lambda-10 */
    public static final x m2127markAsSeen$lambda11$lambda10(Throwable it) {
        m.g(it, "it");
        return x.a;
    }

    private final void observeConnection(WalletLinkConnection walletLinkConnection) {
        s onErrorReturn = walletLinkConnection.getRequestsObservable().observeOn(this.requestsScheduler).map(new n() { // from class: com.coinbase.walletlink.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLink.a((HostRequest) obj);
            }
        }).onErrorReturn(new n() { // from class: com.coinbase.walletlink.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLink.b((Throwable) obj);
            }
        });
        m.f(onErrorReturn, "conn.requestsObservable\n            .observeOn(requestsScheduler)\n            .map { Optional(it) }\n            .onErrorReturn { Optional(null) }");
        s map = onErrorReturn.filter(new p() { // from class: com.coinbase.walletlink.WalletLink$observeConnection$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new n() { // from class: com.coinbase.walletlink.WalletLink$observeConnection$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        h.c.k0.b subscribe = map.subscribe(new h.c.m0.f() { // from class: com.coinbase.walletlink.e
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                WalletLink.e(WalletLink.this, (HostRequest) obj);
            }
        });
        m.f(subscribe, "conn.requestsObservable\n            .observeOn(requestsScheduler)\n            .map { Optional(it) }\n            .onErrorReturn { Optional(null) }\n            .unwrap()\n            .subscribe { request ->\n                val hostRequestId = request.hostRequestId\n\n                if (processedRequestIds.has(hostRequestId)) {\n                    return@subscribe\n                }\n\n                processedRequestIds.add(hostRequestId)\n                requestsSubject.onNext(request)\n            }");
        h.c.t0.a.a(subscribe, this.disposeBag);
        s onErrorReturn2 = walletLinkConnection.getDisconnectSessionObservable().observeOn(this.requestsScheduler).map(new n() { // from class: com.coinbase.walletlink.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLink.h((String) obj);
            }
        }).onErrorReturn(new n() { // from class: com.coinbase.walletlink.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLink.g((Throwable) obj);
            }
        });
        m.f(onErrorReturn2, "conn.disconnectSessionObservable\n            .observeOn(requestsScheduler)\n            .map { request -> request.toOptional() }\n            .onErrorReturn { null }");
        s map2 = onErrorReturn2.filter(new p() { // from class: com.coinbase.walletlink.WalletLink$observeConnection$$inlined$unwrap$3
            public final boolean test(Optional<? extends T> it) {
                m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new n() { // from class: com.coinbase.walletlink.WalletLink$observeConnection$$inlined$unwrap$4
            public final T apply(Optional<? extends T> it) {
                m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        m.f(map2, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        h.c.t0.a.a(h.c.t0.g.h(map2, null, null, new WalletLink$observeConnection$6(this, walletLinkConnection), 3, null), this.disposeBag);
    }

    /* renamed from: observeConnection$lambda-14 */
    public static final Optional m2128observeConnection$lambda14(HostRequest it) {
        m.g(it, "it");
        return new Optional(it);
    }

    /* renamed from: observeConnection$lambda-15 */
    public static final Optional m2129observeConnection$lambda15(Throwable it) {
        m.g(it, "it");
        return new Optional(null);
    }

    /* renamed from: observeConnection$lambda-16 */
    public static final void m2130observeConnection$lambda16(WalletLink this$0, HostRequest hostRequest) {
        m.g(this$0, "this$0");
        HostRequestId hostRequestId = hostRequest.getHostRequestId();
        if (this$0.processedRequestIds.has(hostRequestId)) {
            return;
        }
        this$0.processedRequestIds.add(hostRequestId);
        this$0.requestsSubject.onNext(hostRequest);
    }

    /* renamed from: observeConnection$lambda-17 */
    public static final Optional m2131observeConnection$lambda17(String request) {
        m.g(request, "request");
        return OptionalKt.toOptional(request);
    }

    /* renamed from: observeConnection$lambda-18 */
    public static final Optional m2132observeConnection$lambda18(Throwable it) {
        m.g(it, "it");
        return null;
    }

    /* renamed from: setMetadata$lambda-9$lambda-8 */
    public static final x m2133setMetadata$lambda9$lambda8(Throwable it) {
        m.g(it, "it");
        x xVar = x.a;
        b0.just(xVar);
        return xVar;
    }

    /* renamed from: unlink$lambda-7 */
    public static final x m2134unlink$lambda7(WalletLink this$0, Session session, Boolean it) {
        m.g(this$0, "this$0");
        m.g(session, "$session");
        m.g(it, "it");
        this$0.linkRepository.delete(session.getUrl(), session.getId());
        return x.a;
    }

    @Override // com.coinbase.walletlink.WalletLinkInterface
    public b0<x> approve(HostRequestId requestId, byte[] signedData) {
        m.g(requestId, "requestId");
        m.g(signedData, "signedData");
        WalletLinkConnection walletLinkConnection = this.connections.get(requestId.getUrl());
        if (walletLinkConnection == null) {
            b0<x> error = b0.error(new WalletLinkException.NoConnectionFound(requestId.getUrl()));
            m.f(error, "error(\n            WalletLinkException.NoConnectionFound(requestId.url)\n        )");
            return error;
        }
        return walletLinkConnection.approve(requestId, signedData);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0039, code lost:
        r4 = kotlin.a0.z.K0(r4);
     */
    @Override // com.coinbase.walletlink.WalletLinkInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void connect(java.lang.String r11, java.util.concurrent.ConcurrentHashMap<com.coinbase.walletlink.models.ClientMetadataKey, java.lang.String> r12) {
        /*
            r10 = this;
            java.lang.String r0 = "userId"
            kotlin.jvm.internal.m.g(r11, r0)
            java.lang.String r0 = "metadata"
            kotlin.jvm.internal.m.g(r12, r0)
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            com.coinbase.walletlink.repositories.LinkRepository r1 = r10.linkRepository
            java.util.List r1 = r1.getSessions()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L1e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L5e
            java.lang.Object r3 = r1.next()
            com.coinbase.walletlink.models.Session r3 = (com.coinbase.walletlink.models.Session) r3
            java.net.URL r4 = r3.getUrl()
            java.lang.Object r4 = r2.get(r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            if (r4 != 0) goto L39
        L37:
            r4 = r5
            goto L43
        L39:
            java.util.List r4 = kotlin.a0.p.K0(r4)
            if (r4 != 0) goto L40
            goto L37
        L40:
            r4.add(r3)
        L43:
            java.net.URL r6 = r3.getUrl()
            if (r4 != 0) goto L4a
            goto L4e
        L4a:
            java.util.List r5 = kotlin.a0.p.I0(r4)
        L4e:
            if (r5 != 0) goto L5a
            r4 = 1
            com.coinbase.walletlink.models.Session[] r4 = new com.coinbase.walletlink.models.Session[r4]
            r5 = 0
            r4[r5] = r3
            java.util.List r5 = kotlin.a0.p.m(r4)
        L5a:
            r2.put(r6, r5)
            goto L1e
        L5e:
            java.util.Set r1 = r2.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L66:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto La6
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            r5 = r3
            java.net.URL r5 = (java.net.URL) r5
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            com.coinbase.walletlink.apis.WalletLinkConnection r3 = new com.coinbase.walletlink.apis.WalletLinkConnection
            java.net.URL r7 = r10.notificationUrl
            com.coinbase.walletlink.repositories.LinkRepository r8 = r10.linkRepository
            r4 = r3
            r6 = r11
            r9 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            r10.observeConnection(r3)
            java.util.Iterator r2 = r2.iterator()
        L92:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L66
            java.lang.Object r4 = r2.next()
            com.coinbase.walletlink.models.Session r4 = (com.coinbase.walletlink.models.Session) r4
            java.net.URL r4 = r4.getUrl()
            r0.put(r4, r3)
            goto L92
        La6:
            r10.connections = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.walletlink.WalletLink.connect(java.lang.String, java.util.concurrent.ConcurrentHashMap):void");
    }

    @Override // com.coinbase.walletlink.WalletLinkInterface
    public void disconnect() {
        this.disposeBag.d();
        Collection<WalletLinkConnection> values = this.connections.values();
        m.f(values, "connections.values");
        for (WalletLinkConnection walletLinkConnection : values) {
            walletLinkConnection.disconnect();
        }
        this.connections.clear();
    }

    @Override // com.coinbase.walletlink.WalletLinkInterface
    public b0<HostRequest> getRequest(final String eventId, String sessionId, URL url) {
        m.g(eventId, "eventId");
        m.g(sessionId, "sessionId");
        m.g(url, "url");
        Session session = this.linkRepository.getSession(sessionId, url);
        if (session == null) {
            b0<HostRequest> error = b0.error(WalletLinkException.SessionNotFound.INSTANCE);
            m.f(error, "error(WalletLinkException.SessionNotFound)");
            return error;
        }
        b0 map = this.linkRepository.getPendingRequests(session).map(new n() { // from class: com.coinbase.walletlink.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLink.k(eventId, (List) obj);
            }
        });
        m.f(map, "linkRepository.getPendingRequests(session)\n            .map { requests ->\n                requests.firstOrNull { eventId == it.hostRequestId.eventId } ?: throw WalletLinkException.EventNotFound\n            }");
        return map;
    }

    @Override // com.coinbase.walletlink.WalletLinkInterface
    public s<HostRequest> getRequestsObservable() {
        return this.requestsObservable;
    }

    @Override // com.coinbase.walletlink.WalletLinkInterface
    public b0<x> link(String sessionId, String secret, String str, boolean z, String str2, String str3, URL url, Uri uri, final URL url2, String userId, Map<ClientMetadataKey, String> metadata) {
        m.g(sessionId, "sessionId");
        m.g(secret, "secret");
        m.g(url2, "url");
        m.g(userId, "userId");
        m.g(metadata, "metadata");
        WalletLinkConnection walletLinkConnection = this.connections.get(url2);
        if (walletLinkConnection == null) {
            final WalletLinkConnection walletLinkConnection2 = new WalletLinkConnection(url2, userId, this.notificationUrl, this.linkRepository, metadata);
            this.connections.put(url2, walletLinkConnection2);
            b0<x> doOnError = walletLinkConnection2.link(sessionId, secret, str, z, str2, str3, url, uri).map(new n() { // from class: com.coinbase.walletlink.d
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    x m2125link$lambda5;
                    m2125link$lambda5 = WalletLink.m2125link$lambda5(WalletLink.this, walletLinkConnection2, (x) obj);
                    return m2125link$lambda5;
                }
            }).doOnError(new h.c.m0.f() { // from class: com.coinbase.walletlink.c
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    WalletLink.c(WalletLink.this, url2, (Throwable) obj);
                }
            });
            m.f(doOnError, "connection.link(\n            sessionId = sessionId,\n            secret = secret,\n            version = version,\n            isParent = isParent,\n            parentSessionId = parentSessionId,\n            dappName = dappName,\n            dappImageURL = dappImageURL,\n            dappURL = dappURL\n        )\n            .map { observeConnection(connection) }\n            .doOnError { connections.remove(url) }");
            return doOnError;
        }
        return walletLinkConnection.link(sessionId, secret, str, z, str2, str3, url, uri);
    }

    @Override // com.coinbase.walletlink.WalletLinkInterface
    public b0<x> markAsSeen(List<HostRequestId> requestIds) {
        int r;
        b0 zip;
        List g2;
        m.g(requestIds, "requestIds");
        r = kotlin.a0.s.r(requestIds, 10);
        ArrayList arrayList = new ArrayList(r);
        for (HostRequestId hostRequestId : requestIds) {
            arrayList.add(this.linkRepository.markAsSeen(hostRequestId, hostRequestId.getUrl()).onErrorReturn(new n() { // from class: com.coinbase.walletlink.j
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return WalletLink.j((Throwable) obj);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = r.g();
            zip = b0.just(g2);
            m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList, new n() { // from class: com.coinbase.walletlink.WalletLink$markAsSeen$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    m.g(it, "it");
                    if (it.length == 0) {
                        g3 = r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int length = it.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = it[i2];
                        if (obj != null ? obj instanceof x : true) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return Single_CoreKt.asUnit(zip);
    }

    @Override // com.coinbase.walletlink.WalletLinkInterface
    public s<List<Session>> observeSessions() {
        return this.linkRepository.observeSessions();
    }

    @Override // com.coinbase.walletlink.WalletLinkInterface
    public b0<x> reject(HostRequestId requestId) {
        m.g(requestId, "requestId");
        WalletLinkConnection walletLinkConnection = this.connections.get(requestId.getUrl());
        if (walletLinkConnection == null) {
            b0<x> error = b0.error(new WalletLinkException.NoConnectionFound(requestId.getUrl()));
            m.f(error, "error(\n            WalletLinkException.NoConnectionFound(requestId.url)\n        )");
            return error;
        }
        return walletLinkConnection.reject(requestId);
    }

    @Override // com.coinbase.walletlink.WalletLinkInterface
    public List<Session> sessions() {
        return this.linkRepository.getSessions();
    }

    @Override // com.coinbase.walletlink.WalletLinkInterface
    public b0<x> setMetadata(ClientMetadataKey key, String value) {
        int r;
        b0 zip;
        List g2;
        m.g(key, "key");
        m.g(value, "value");
        Collection<WalletLinkConnection> values = this.connections.values();
        m.f(values, "connections.values");
        r = kotlin.a0.s.r(values, 10);
        ArrayList arrayList = new ArrayList(r);
        for (WalletLinkConnection walletLinkConnection : values) {
            arrayList.add(Single_CoreKt.asUnit(walletLinkConnection.setMetadata(key, value)).onErrorReturn(new n() { // from class: com.coinbase.walletlink.i
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return WalletLink.i((Throwable) obj);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = r.g();
            zip = b0.just(g2);
            m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList, new n() { // from class: com.coinbase.walletlink.WalletLink$setMetadata$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    m.g(it, "it");
                    if (it.length == 0) {
                        g3 = r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int length = it.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = it[i2];
                        if (obj != null ? obj instanceof x : true) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return Single_CoreKt.asUnit(zip);
    }

    @Override // com.coinbase.walletlink.WalletLinkInterface
    public b0<x> unlink(final Session session) {
        m.g(session, "session");
        WalletLinkConnection walletLinkConnection = this.connections.get(session.getUrl());
        if (walletLinkConnection == null) {
            b0<x> error = b0.error(new WalletLinkException.NoConnectionFound(session.getUrl()));
            m.f(error, "error(WalletLinkException.NoConnectionFound(session.url))");
            return error;
        }
        b0 map = walletLinkConnection.destroySession(session.getId()).map(new n() { // from class: com.coinbase.walletlink.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLink.f(WalletLink.this, session, (Boolean) obj);
            }
        });
        m.f(map, "connection.destroySession(sessionId = session.id)\n            .map { linkRepository.delete(url = session.url, sessionId = session.id) }");
        return map;
    }
}