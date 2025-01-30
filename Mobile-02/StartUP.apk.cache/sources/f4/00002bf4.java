package com.coinbase.walletlink.repositories;

import android.content.Context;
import android.net.Uri;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.crypto.extensions.String_CryptoKt;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.wallet.http.extensions.URL_HTTPKt;
import com.coinbase.wallet.store.Store;
import com.coinbase.walletlink.apis.WalletLinkAPI;
import com.coinbase.walletlink.daos.DappDAO;
import com.coinbase.walletlink.daos.SessionDAO;
import com.coinbase.walletlink.dtos.ChildRequestEthereumAccountsParams;
import com.coinbase.walletlink.dtos.RequestEthereumAccountsParams;
import com.coinbase.walletlink.dtos.ServerRequestDTO;
import com.coinbase.walletlink.dtos.SignEthereumMessageParams;
import com.coinbase.walletlink.dtos.SignEthereumTransactionParams;
import com.coinbase.walletlink.dtos.SubmitEthereumTransactionParams;
import com.coinbase.walletlink.dtos.SwitchEthereumChainParams;
import com.coinbase.walletlink.dtos.Web3RequestCanceledDTO;
import com.coinbase.walletlink.dtos.Web3RequestDTO;
import com.coinbase.walletlink.models.Dapp;
import com.coinbase.walletlink.models.EventType;
import com.coinbase.walletlink.models.HostRequest;
import com.coinbase.walletlink.models.HostRequestId;
import com.coinbase.walletlink.models.RequestMethod;
import com.coinbase.walletlink.models.Session;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.security.auth.Destroyable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.x;
import org.apache.http.cookie.ClientCookie;

/* compiled from: LinkRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010W\u001a\u00020V¢\u0006\u0004\bX\u0010YJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJC\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100 2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100 0#¢\u0006\u0004\b$\u0010%J!\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100 0#2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b$\u0010&J\u001d\u0010)\u001a\u00020(2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0017¢\u0006\u0004\b)\u0010*Jg\u00104\u001a\u00020(2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\u00172\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010\u00172\b\u00101\u001a\u0004\u0018\u00010\u00172\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b4\u00105J\u0015\u00106\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b6\u00107J\u001b\u0010:\u001a\b\u0012\u0004\u0012\u00020(0\u00122\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J#\u0010<\u001a\b\u0012\u0004\u0012\u00020(0\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b<\u0010=J!\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140 0\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b>\u0010?J)\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010@\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\bA\u0010BJN\u0010F\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000E\u0012\u0004\u0012\u00020\u00020D0\u00130\u0012\"\u0006\b\u0000\u0010C\u0018\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\b¢\u0006\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0019\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00100 8F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010NR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010U¨\u0006Z"}, d2 = {"Lcom/coinbase/walletlink/repositories/LinkRepository;", "Ljavax/security/auth/Destroyable;", "Lcom/coinbase/walletlink/models/HostRequestId;", "requestId", "cancelationRequestId", "Ljava/net/URL;", "url", "Lh/c/k0/b;", "markCancelledEventAsSeen", "(Lcom/coinbase/walletlink/models/HostRequestId;Lcom/coinbase/walletlink/models/HostRequestId;Ljava/net/URL;)Lh/c/k0/b;", "Lcom/coinbase/walletlink/dtos/ServerRequestDTO;", "serverRequest", "Lcom/coinbase/walletlink/models/RequestMethod;", "method", "", "decrypted", "Lcom/coinbase/walletlink/models/Session;", "session", "Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/walletlink/models/HostRequest;", "parseWeb3Request", "(Lcom/coinbase/walletlink/dtos/ServerRequestDTO;Lcom/coinbase/walletlink/models/RequestMethod;[BLjava/net/URL;Lcom/coinbase/walletlink/models/Session;)Lh/c/b0;", "", "appLogoUrl", "Landroid/net/Uri;", "originUrl", "getAppLogoUrl", "(Ljava/lang/String;Landroid/net/Uri;)Ljava/net/URL;", "id", "getSession", "(Ljava/lang/String;Ljava/net/URL;)Lcom/coinbase/walletlink/models/Session;", "", "getSessions", "(Ljava/net/URL;)Ljava/util/List;", "Lh/c/s;", "observeSessions", "()Lh/c/s;", "(Ljava/net/URL;)Lh/c/s;", WalletLinkPushNotification.sessionIdKey, "Lkotlin/x;", "delete", "(Ljava/net/URL;Ljava/lang/String;)V", "secret", ClientCookie.VERSION_ATTR, "", "isParent", "isApproved", "parentSessionId", WalletLinkCompleteArgs.DAPP_NAME, "dappImageURL", "dappURL", "saveSession", "(Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/net/URL;Landroid/net/Uri;)V", "updateSession", "(Lcom/coinbase/walletlink/models/Session;)V", "Lcom/coinbase/walletlink/models/Dapp;", "dapp", "saveDapp", "(Lcom/coinbase/walletlink/models/Dapp;)Lh/c/b0;", "markAsSeen", "(Lcom/coinbase/walletlink/models/HostRequestId;Ljava/net/URL;)Lh/c/b0;", "getPendingRequests", "(Lcom/coinbase/walletlink/models/Session;)Lh/c/b0;", "dto", "getHostRequest", "(Lcom/coinbase/walletlink/dtos/ServerRequestDTO;Ljava/net/URL;)Lh/c/b0;", "T", "Lkotlin/o;", "Lcom/coinbase/walletlink/dtos/Web3RequestDTO;", "hostRequestId", "(Lcom/coinbase/walletlink/dtos/ServerRequestDTO;[BLjava/net/URL;)Lh/c/b0;", "Lcom/coinbase/walletlink/apis/WalletLinkAPI;", "api", "Lcom/coinbase/walletlink/apis/WalletLinkAPI;", "Lcom/coinbase/walletlink/daos/DappDAO;", "dappDAO", "Lcom/coinbase/walletlink/daos/DappDAO;", "()Ljava/util/List;", "sessions", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/walletlink/daos/SessionDAO;", "sessionDAO", "Lcom/coinbase/walletlink/daos/SessionDAO;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class LinkRepository implements Destroyable {
    private final WalletLinkAPI api;
    private final DappDAO dappDAO;
    private final h.c.k0.a disposeBag;
    private final SessionDAO sessionDAO;

    /* compiled from: LinkRepository.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[EventType.values().length];
            iArr[EventType.Web3Request.ordinal()] = 1;
            iArr[EventType.Web3Response.ordinal()] = 2;
            iArr[EventType.Web3RequestCanceled.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[RequestMethod.values().length];
            iArr2[RequestMethod.ChildRequestEthereumAccounts.ordinal()] = 1;
            iArr2[RequestMethod.RequestEthereumAccounts.ordinal()] = 2;
            iArr2[RequestMethod.SwitchEthereumChain.ordinal()] = 3;
            iArr2[RequestMethod.SignEthereumMessage.ordinal()] = 4;
            iArr2[RequestMethod.SignEthereumTransaction.ordinal()] = 5;
            iArr2[RequestMethod.SubmitEthereumTransaction.ordinal()] = 6;
            iArr2[RequestMethod.RequestCanceled.ordinal()] = 7;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public LinkRepository(Context context) {
        m.g(context, "context");
        this.disposeBag = new h.c.k0.a();
        this.sessionDAO = new SessionDAO(new Store(context));
        this.api = new WalletLinkAPI();
        this.dappDAO = (DappDAO) new LinkRepository$dappDAO$1(context).invoke();
    }

    public static /* synthetic */ h0 a(LinkRepository linkRepository, Session session, List list) {
        return m2185getPendingRequests$lambda3(linkRepository, session, list);
    }

    public static /* synthetic */ h0 b(LinkRepository linkRepository, HostRequestId hostRequestId, URL url, x xVar) {
        return m2189markCancelledEventAsSeen$lambda9(linkRepository, hostRequestId, url, xVar);
    }

    public static /* synthetic */ List c(LinkRepository linkRepository, Session session, List list) {
        return m2187getPendingRequests$lambda7(linkRepository, session, list);
    }

    public static /* synthetic */ Optional d(Web3RequestCanceledDTO web3RequestCanceledDTO, ServerRequestDTO serverRequestDTO, URL url, Optional optional) {
        return m2196parseWeb3Request$lambda16(web3RequestCanceledDTO, serverRequestDTO, url, optional);
    }

    public static /* synthetic */ Optional e(Session session, Optional optional) {
        return m2191parseWeb3Request$lambda11(session, optional);
    }

    public static /* synthetic */ Optional f(Optional optional) {
        return m2194parseWeb3Request$lambda14(optional);
    }

    public static /* synthetic */ Optional g(Optional optional) {
        return m2195parseWeb3Request$lambda15(optional);
    }

    public final URL getAppLogoUrl(String str, Uri uri) {
        if (str == null) {
            return null;
        }
        URL asURL = String_CoreKt.getAsURL(str);
        if (asURL == null) {
            String uri2 = uri.toString();
            m.f(uri2, "originUrl.toString()");
            URL asURL2 = String_CoreKt.getAsURL(uri2);
            if (asURL2 == null) {
                return null;
            }
            return URL_HTTPKt.appendingPathComponent(asURL2, str);
        }
        return asURL;
    }

    /* renamed from: getPendingRequests$lambda-3 */
    public static final h0 m2185getPendingRequests$lambda3(LinkRepository this$0, Session session, List requests) {
        int r;
        b0 zip;
        List g2;
        m.g(this$0, "this$0");
        m.g(session, "$session");
        m.g(requests, "requests");
        r = s.r(requests, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = requests.iterator();
        while (it.hasNext()) {
            arrayList.add(this$0.getHostRequest((ServerRequestDTO) it.next(), session.getUrl()));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = r.g();
            zip = b0.just(g2);
            m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList, new n() { // from class: com.coinbase.walletlink.repositories.LinkRepository$getPendingRequests$lambda-3$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it2) {
                    List<T> g3;
                    m.g(it2, "it");
                    if (it2.length == 0) {
                        g3 = r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : it2) {
                        if (obj instanceof Optional) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return zip.map(new n() { // from class: com.coinbase.walletlink.repositories.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LinkRepository.h((List) obj);
            }
        });
    }

    /* renamed from: getPendingRequests$lambda-3$lambda-2 */
    public static final List m2186getPendingRequests$lambda3$lambda2(List hostRequests) {
        m.g(hostRequests, "hostRequests");
        ArrayList arrayList = new ArrayList();
        Iterator it = hostRequests.iterator();
        while (it.hasNext()) {
            HostRequest hostRequest = (HostRequest) ((Optional) it.next()).toNullable();
            if (hostRequest != null) {
                arrayList.add(hostRequest);
            }
        }
        return arrayList;
    }

    /* renamed from: getPendingRequests$lambda-7 */
    public static final List m2187getPendingRequests$lambda7(LinkRepository this$0, Session session, List requests) {
        Object obj;
        boolean z;
        m.g(this$0, "this$0");
        m.g(session, "$session");
        m.g(requests, "requests");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : requests) {
            if (((HostRequest) obj2).getHostRequestId().isCancelation()) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : requests) {
            HostRequest hostRequest = (HostRequest) obj3;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((HostRequest) obj).getHostRequestId().canCancel(hostRequest.getHostRequestId())) {
                    break;
                }
            }
            HostRequest hostRequest2 = (HostRequest) obj;
            if (hostRequest2 == null) {
                z = true;
            } else {
                this$0.markCancelledEventAsSeen(hostRequest.getHostRequestId(), hostRequest2.getHostRequestId(), session.getUrl());
                z = false;
            }
            if (z) {
                arrayList2.add(obj3);
            }
        }
        return arrayList2;
    }

    /* renamed from: getPendingRequests$lambda-8 */
    public static final List m2188getPendingRequests$lambda8(Throwable it) {
        List g2;
        m.g(it, "it");
        g2 = r.g();
        return g2;
    }

    public static /* synthetic */ List h(List list) {
        return m2186getPendingRequests$lambda3$lambda2(list);
    }

    public static /* synthetic */ Optional i(Optional optional) {
        return m2193parseWeb3Request$lambda13(optional);
    }

    public static /* synthetic */ Optional j(Optional optional) {
        return m2192parseWeb3Request$lambda12(optional);
    }

    public static /* synthetic */ Optional k(Session session, Optional optional) {
        return m2190parseWeb3Request$lambda10(session, optional);
    }

    public static /* synthetic */ List l(Throwable th) {
        return m2188getPendingRequests$lambda8(th);
    }

    private final h.c.k0.b markCancelledEventAsSeen(HostRequestId hostRequestId, final HostRequestId hostRequestId2, final URL url) {
        h.c.k0.b subscribe = markAsSeen(hostRequestId, url).flatMap(new n() { // from class: com.coinbase.walletlink.repositories.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LinkRepository.b(LinkRepository.this, hostRequestId2, url, (x) obj);
            }
        }).subscribe();
        m.f(subscribe, "markAsSeen(requestId, url)\n        .flatMap { markAsSeen(cancelationRequestId, url) }\n        .subscribe()");
        return h.c.t0.a.a(subscribe, this.disposeBag);
    }

    /* renamed from: markCancelledEventAsSeen$lambda-9 */
    public static final h0 m2189markCancelledEventAsSeen$lambda9(LinkRepository this$0, HostRequestId cancelationRequestId, URL url, x it) {
        m.g(this$0, "this$0");
        m.g(cancelationRequestId, "$cancelationRequestId");
        m.g(url, "$url");
        m.g(it, "it");
        return this$0.markAsSeen(cancelationRequestId, url);
    }

    private final b0<Optional<HostRequest>> parseWeb3Request(final ServerRequestDTO serverRequestDTO, RequestMethod requestMethod, byte[] bArr, final URL url, final Session session) {
        b0 map;
        b0 map2;
        b0 map3;
        b0 map4;
        b0 map5;
        b0 map6;
        switch (WhenMappings.$EnumSwitchMapping$1[requestMethod.ordinal()]) {
            case 1:
                Web3RequestDTO.Companion companion = Web3RequestDTO.Companion;
                Web3RequestDTO web3RequestDTO = (Web3RequestDTO) JSON.INSTANCE.parameterizedAdapter(Web3RequestDTO.class, ChildRequestEthereumAccountsParams.class).fromJson(new String(bArr, kotlin.l0.d.a));
                if (web3RequestDTO == null) {
                    map = b0.just(new Optional(null));
                    m.f(map, "just(Optional(null))");
                } else {
                    Object params = web3RequestDTO.getRequest().getParams();
                    ChildRequestEthereumAccountsParams childRequestEthereumAccountsParams = params instanceof ChildRequestEthereumAccountsParams ? (ChildRequestEthereumAccountsParams) params : null;
                    if (childRequestEthereumAccountsParams != null) {
                        Uri appURL = childRequestEthereumAccountsParams.getAppURL();
                        String appName = childRequestEthereumAccountsParams.getAppName();
                        String appLogoURL = childRequestEthereumAccountsParams.getAppLogoURL();
                        map = b0.just(new Optional(new o(web3RequestDTO, new HostRequestId(web3RequestDTO.getId(), serverRequestDTO.getSessionId(), serverRequestDTO.getEventId(), url, appURL, appLogoURL == null ? null : String_CoreKt.getAsURL(appLogoURL), appName, web3RequestDTO.getRequest().getMethod()))));
                        m.f(map, "just(Optional(Pair(web3Request, requestId)))");
                    } else {
                        map = this.dappDAO.getDapp(web3RequestDTO.getOrigin()).map(new LinkRepository$hostRequestId$1(web3RequestDTO, this, serverRequestDTO, url));
                        m.f(map, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T> hostRequestId(\n        serverRequest: ServerRequestDTO,\n        decrypted: ByteArray,\n        url: URL\n    ): Single<Optional<Pair<Web3RequestDTO<T>, HostRequestId>>> {\n        val web3Request = Web3RequestDTO.fromJson<T>(decrypted) ?: return Single.just(Optional(null))\n\n        val childRequestAccountParams = web3Request.request.params as? ChildRequestEthereumAccountsParams\n        if (childRequestAccountParams != null) {\n            val dappURL = childRequestAccountParams.appURL\n            val dappName = childRequestAccountParams.appName\n            val dappImageURL = childRequestAccountParams.appLogoURL?.asURL\n            val requestId = HostRequestId(\n                id = web3Request.id,\n                sessionId = serverRequest.sessionId,\n                eventId = serverRequest.eventId,\n                url = url,\n                dappURL = dappURL,\n                dappImageURL = dappImageURL,\n                dappName = dappName,\n                method = web3Request.request.method\n            )\n\n            return Single.just(Optional(Pair(web3Request, requestId)))\n        }\n\n        return dappDAO.getDapp(web3Request.origin)\n            .map { dapp ->\n                var dappImageURL = dapp.toNullable()?.logoURL\n                var dappName = dapp.toNullable()?.name\n                val requestAccountParams = web3Request.request.params as? RequestEthereumAccountsParams\n\n                if (requestAccountParams != null) {\n                    dappName = requestAccountParams.appName\n                    dappImageURL = getAppLogoUrl(requestAccountParams.appLogoUrl, web3Request.origin)\n                }\n\n                val requestId = HostRequestId(\n                    id = web3Request.id,\n                    sessionId = serverRequest.sessionId,\n                    eventId = serverRequest.eventId,\n                    url = url,\n                    dappURL = web3Request.origin,\n                    dappImageURL = dappImageURL,\n                    dappName = dappName,\n                    method = web3Request.request.method\n                )\n\n                Optional(Pair(web3Request, requestId))\n            }\n    }");
                    }
                }
                b0<Optional<HostRequest>> map7 = map.map(new n() { // from class: com.coinbase.walletlink.repositories.k
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return LinkRepository.k(Session.this, (Optional) obj);
                    }
                });
                m.f(map7, "hostRequestId<ChildRequestEthereumAccountsParams>(serverRequest, decrypted, url)\n                    .map {\n                        val web3Request = it.toNullable()?.first ?: return@map Optional(null)\n                        val hostRequestId = it.toNullable()?.second ?: return@map Optional(null)\n                        Optional(\n                            HostRequest.ChildRequestEthereumAccounts(\n                                hostRequestId,\n                                web3Request.request.params.sessionId,\n                                web3Request.request.params.sessionSecret,\n                                session.version\n                            )\n                        )\n                    }");
                return map7;
            case 2:
                Web3RequestDTO.Companion companion2 = Web3RequestDTO.Companion;
                Web3RequestDTO web3RequestDTO2 = (Web3RequestDTO) JSON.INSTANCE.parameterizedAdapter(Web3RequestDTO.class, RequestEthereumAccountsParams.class).fromJson(new String(bArr, kotlin.l0.d.a));
                if (web3RequestDTO2 == null) {
                    map2 = b0.just(new Optional(null));
                    m.f(map2, "just(Optional(null))");
                } else {
                    Object params2 = web3RequestDTO2.getRequest().getParams();
                    ChildRequestEthereumAccountsParams childRequestEthereumAccountsParams2 = params2 instanceof ChildRequestEthereumAccountsParams ? (ChildRequestEthereumAccountsParams) params2 : null;
                    if (childRequestEthereumAccountsParams2 != null) {
                        Uri appURL2 = childRequestEthereumAccountsParams2.getAppURL();
                        String appName2 = childRequestEthereumAccountsParams2.getAppName();
                        String appLogoURL2 = childRequestEthereumAccountsParams2.getAppLogoURL();
                        map2 = b0.just(new Optional(new o(web3RequestDTO2, new HostRequestId(web3RequestDTO2.getId(), serverRequestDTO.getSessionId(), serverRequestDTO.getEventId(), url, appURL2, appLogoURL2 == null ? null : String_CoreKt.getAsURL(appLogoURL2), appName2, web3RequestDTO2.getRequest().getMethod()))));
                        m.f(map2, "just(Optional(Pair(web3Request, requestId)))");
                    } else {
                        map2 = this.dappDAO.getDapp(web3RequestDTO2.getOrigin()).map(new LinkRepository$hostRequestId$1(web3RequestDTO2, this, serverRequestDTO, url));
                        m.f(map2, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T> hostRequestId(\n        serverRequest: ServerRequestDTO,\n        decrypted: ByteArray,\n        url: URL\n    ): Single<Optional<Pair<Web3RequestDTO<T>, HostRequestId>>> {\n        val web3Request = Web3RequestDTO.fromJson<T>(decrypted) ?: return Single.just(Optional(null))\n\n        val childRequestAccountParams = web3Request.request.params as? ChildRequestEthereumAccountsParams\n        if (childRequestAccountParams != null) {\n            val dappURL = childRequestAccountParams.appURL\n            val dappName = childRequestAccountParams.appName\n            val dappImageURL = childRequestAccountParams.appLogoURL?.asURL\n            val requestId = HostRequestId(\n                id = web3Request.id,\n                sessionId = serverRequest.sessionId,\n                eventId = serverRequest.eventId,\n                url = url,\n                dappURL = dappURL,\n                dappImageURL = dappImageURL,\n                dappName = dappName,\n                method = web3Request.request.method\n            )\n\n            return Single.just(Optional(Pair(web3Request, requestId)))\n        }\n\n        return dappDAO.getDapp(web3Request.origin)\n            .map { dapp ->\n                var dappImageURL = dapp.toNullable()?.logoURL\n                var dappName = dapp.toNullable()?.name\n                val requestAccountParams = web3Request.request.params as? RequestEthereumAccountsParams\n\n                if (requestAccountParams != null) {\n                    dappName = requestAccountParams.appName\n                    dappImageURL = getAppLogoUrl(requestAccountParams.appLogoUrl, web3Request.origin)\n                }\n\n                val requestId = HostRequestId(\n                    id = web3Request.id,\n                    sessionId = serverRequest.sessionId,\n                    eventId = serverRequest.eventId,\n                    url = url,\n                    dappURL = web3Request.origin,\n                    dappImageURL = dappImageURL,\n                    dappName = dappName,\n                    method = web3Request.request.method\n                )\n\n                Optional(Pair(web3Request, requestId))\n            }\n    }");
                    }
                }
                b0<Optional<HostRequest>> map8 = map2.map(new n() { // from class: com.coinbase.walletlink.repositories.e
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return LinkRepository.e(Session.this, (Optional) obj);
                    }
                });
                m.f(map8, "hostRequestId<RequestEthereumAccountsParams>(serverRequest, decrypted, url)\n                    .map {\n                        val hostRequestId = it.toNullable()?.second ?: return@map Optional(null)\n                        Optional(HostRequest.RequestEthereumAccounts(hostRequestId, session.isParent == true))\n                    }");
                return map8;
            case 3:
                Web3RequestDTO.Companion companion3 = Web3RequestDTO.Companion;
                Web3RequestDTO web3RequestDTO3 = (Web3RequestDTO) JSON.INSTANCE.parameterizedAdapter(Web3RequestDTO.class, SwitchEthereumChainParams.class).fromJson(new String(bArr, kotlin.l0.d.a));
                if (web3RequestDTO3 == null) {
                    map3 = b0.just(new Optional(null));
                    m.f(map3, "just(Optional(null))");
                } else {
                    Object params3 = web3RequestDTO3.getRequest().getParams();
                    ChildRequestEthereumAccountsParams childRequestEthereumAccountsParams3 = params3 instanceof ChildRequestEthereumAccountsParams ? (ChildRequestEthereumAccountsParams) params3 : null;
                    if (childRequestEthereumAccountsParams3 != null) {
                        Uri appURL3 = childRequestEthereumAccountsParams3.getAppURL();
                        String appName3 = childRequestEthereumAccountsParams3.getAppName();
                        String appLogoURL3 = childRequestEthereumAccountsParams3.getAppLogoURL();
                        map3 = b0.just(new Optional(new o(web3RequestDTO3, new HostRequestId(web3RequestDTO3.getId(), serverRequestDTO.getSessionId(), serverRequestDTO.getEventId(), url, appURL3, appLogoURL3 == null ? null : String_CoreKt.getAsURL(appLogoURL3), appName3, web3RequestDTO3.getRequest().getMethod()))));
                        m.f(map3, "just(Optional(Pair(web3Request, requestId)))");
                    } else {
                        map3 = this.dappDAO.getDapp(web3RequestDTO3.getOrigin()).map(new LinkRepository$hostRequestId$1(web3RequestDTO3, this, serverRequestDTO, url));
                        m.f(map3, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T> hostRequestId(\n        serverRequest: ServerRequestDTO,\n        decrypted: ByteArray,\n        url: URL\n    ): Single<Optional<Pair<Web3RequestDTO<T>, HostRequestId>>> {\n        val web3Request = Web3RequestDTO.fromJson<T>(decrypted) ?: return Single.just(Optional(null))\n\n        val childRequestAccountParams = web3Request.request.params as? ChildRequestEthereumAccountsParams\n        if (childRequestAccountParams != null) {\n            val dappURL = childRequestAccountParams.appURL\n            val dappName = childRequestAccountParams.appName\n            val dappImageURL = childRequestAccountParams.appLogoURL?.asURL\n            val requestId = HostRequestId(\n                id = web3Request.id,\n                sessionId = serverRequest.sessionId,\n                eventId = serverRequest.eventId,\n                url = url,\n                dappURL = dappURL,\n                dappImageURL = dappImageURL,\n                dappName = dappName,\n                method = web3Request.request.method\n            )\n\n            return Single.just(Optional(Pair(web3Request, requestId)))\n        }\n\n        return dappDAO.getDapp(web3Request.origin)\n            .map { dapp ->\n                var dappImageURL = dapp.toNullable()?.logoURL\n                var dappName = dapp.toNullable()?.name\n                val requestAccountParams = web3Request.request.params as? RequestEthereumAccountsParams\n\n                if (requestAccountParams != null) {\n                    dappName = requestAccountParams.appName\n                    dappImageURL = getAppLogoUrl(requestAccountParams.appLogoUrl, web3Request.origin)\n                }\n\n                val requestId = HostRequestId(\n                    id = web3Request.id,\n                    sessionId = serverRequest.sessionId,\n                    eventId = serverRequest.eventId,\n                    url = url,\n                    dappURL = web3Request.origin,\n                    dappImageURL = dappImageURL,\n                    dappName = dappName,\n                    method = web3Request.request.method\n                )\n\n                Optional(Pair(web3Request, requestId))\n            }\n    }");
                    }
                }
                b0<Optional<HostRequest>> map9 = map3.map(new n() { // from class: com.coinbase.walletlink.repositories.j
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return LinkRepository.j((Optional) obj);
                    }
                });
                m.f(map9, "hostRequestId<SwitchEthereumChainParams>(serverRequest, decrypted, url)\n                    .map {\n                        val web3Request = it.toNullable()?.first ?: return@map Optional(null)\n                        val hostRequestId = it.toNullable()?.second ?: return@map Optional(null)\n                        Optional(\n                            HostRequest.SwitchEthereumChain(\n                                hostRequestId,\n                                web3Request.request.params.chainId\n                            )\n                        )\n                    }");
                return map9;
            case 4:
                Web3RequestDTO.Companion companion4 = Web3RequestDTO.Companion;
                Web3RequestDTO web3RequestDTO4 = (Web3RequestDTO) JSON.INSTANCE.parameterizedAdapter(Web3RequestDTO.class, SignEthereumMessageParams.class).fromJson(new String(bArr, kotlin.l0.d.a));
                if (web3RequestDTO4 == null) {
                    map4 = b0.just(new Optional(null));
                    m.f(map4, "just(Optional(null))");
                } else {
                    Object params4 = web3RequestDTO4.getRequest().getParams();
                    ChildRequestEthereumAccountsParams childRequestEthereumAccountsParams4 = params4 instanceof ChildRequestEthereumAccountsParams ? (ChildRequestEthereumAccountsParams) params4 : null;
                    if (childRequestEthereumAccountsParams4 != null) {
                        Uri appURL4 = childRequestEthereumAccountsParams4.getAppURL();
                        String appName4 = childRequestEthereumAccountsParams4.getAppName();
                        String appLogoURL4 = childRequestEthereumAccountsParams4.getAppLogoURL();
                        map4 = b0.just(new Optional(new o(web3RequestDTO4, new HostRequestId(web3RequestDTO4.getId(), serverRequestDTO.getSessionId(), serverRequestDTO.getEventId(), url, appURL4, appLogoURL4 == null ? null : String_CoreKt.getAsURL(appLogoURL4), appName4, web3RequestDTO4.getRequest().getMethod()))));
                        m.f(map4, "just(Optional(Pair(web3Request, requestId)))");
                    } else {
                        map4 = this.dappDAO.getDapp(web3RequestDTO4.getOrigin()).map(new LinkRepository$hostRequestId$1(web3RequestDTO4, this, serverRequestDTO, url));
                        m.f(map4, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T> hostRequestId(\n        serverRequest: ServerRequestDTO,\n        decrypted: ByteArray,\n        url: URL\n    ): Single<Optional<Pair<Web3RequestDTO<T>, HostRequestId>>> {\n        val web3Request = Web3RequestDTO.fromJson<T>(decrypted) ?: return Single.just(Optional(null))\n\n        val childRequestAccountParams = web3Request.request.params as? ChildRequestEthereumAccountsParams\n        if (childRequestAccountParams != null) {\n            val dappURL = childRequestAccountParams.appURL\n            val dappName = childRequestAccountParams.appName\n            val dappImageURL = childRequestAccountParams.appLogoURL?.asURL\n            val requestId = HostRequestId(\n                id = web3Request.id,\n                sessionId = serverRequest.sessionId,\n                eventId = serverRequest.eventId,\n                url = url,\n                dappURL = dappURL,\n                dappImageURL = dappImageURL,\n                dappName = dappName,\n                method = web3Request.request.method\n            )\n\n            return Single.just(Optional(Pair(web3Request, requestId)))\n        }\n\n        return dappDAO.getDapp(web3Request.origin)\n            .map { dapp ->\n                var dappImageURL = dapp.toNullable()?.logoURL\n                var dappName = dapp.toNullable()?.name\n                val requestAccountParams = web3Request.request.params as? RequestEthereumAccountsParams\n\n                if (requestAccountParams != null) {\n                    dappName = requestAccountParams.appName\n                    dappImageURL = getAppLogoUrl(requestAccountParams.appLogoUrl, web3Request.origin)\n                }\n\n                val requestId = HostRequestId(\n                    id = web3Request.id,\n                    sessionId = serverRequest.sessionId,\n                    eventId = serverRequest.eventId,\n                    url = url,\n                    dappURL = web3Request.origin,\n                    dappImageURL = dappImageURL,\n                    dappName = dappName,\n                    method = web3Request.request.method\n                )\n\n                Optional(Pair(web3Request, requestId))\n            }\n    }");
                    }
                }
                b0<Optional<HostRequest>> map10 = map4.map(new n() { // from class: com.coinbase.walletlink.repositories.i
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return LinkRepository.i((Optional) obj);
                    }
                });
                m.f(map10, "hostRequestId<SignEthereumMessageParams>(serverRequest, decrypted, url)\n                    .map {\n                        val web3Request = it.toNullable()?.first ?: return@map Optional(null)\n                        val hostRequestId = it.toNullable()?.second ?: return@map Optional(null)\n\n                        Optional(\n                            HostRequest.SignMessage(\n                                hostRequestId = hostRequestId,\n                                address = web3Request.request.params.address,\n                                message = web3Request.request.params.message,\n                                isPrefixed = web3Request.request.params.addPrefix,\n                                typedDataJson = web3Request.request.params.typedDataJson\n                            )\n                        )\n                    }");
                return map10;
            case 5:
                Web3RequestDTO.Companion companion5 = Web3RequestDTO.Companion;
                Web3RequestDTO web3RequestDTO5 = (Web3RequestDTO) JSON.INSTANCE.parameterizedAdapter(Web3RequestDTO.class, SignEthereumTransactionParams.class).fromJson(new String(bArr, kotlin.l0.d.a));
                if (web3RequestDTO5 == null) {
                    map5 = b0.just(new Optional(null));
                    m.f(map5, "just(Optional(null))");
                } else {
                    Object params5 = web3RequestDTO5.getRequest().getParams();
                    ChildRequestEthereumAccountsParams childRequestEthereumAccountsParams5 = params5 instanceof ChildRequestEthereumAccountsParams ? (ChildRequestEthereumAccountsParams) params5 : null;
                    if (childRequestEthereumAccountsParams5 != null) {
                        Uri appURL5 = childRequestEthereumAccountsParams5.getAppURL();
                        String appName5 = childRequestEthereumAccountsParams5.getAppName();
                        String appLogoURL5 = childRequestEthereumAccountsParams5.getAppLogoURL();
                        map5 = b0.just(new Optional(new o(web3RequestDTO5, new HostRequestId(web3RequestDTO5.getId(), serverRequestDTO.getSessionId(), serverRequestDTO.getEventId(), url, appURL5, appLogoURL5 == null ? null : String_CoreKt.getAsURL(appLogoURL5), appName5, web3RequestDTO5.getRequest().getMethod()))));
                        m.f(map5, "just(Optional(Pair(web3Request, requestId)))");
                    } else {
                        map5 = this.dappDAO.getDapp(web3RequestDTO5.getOrigin()).map(new LinkRepository$hostRequestId$1(web3RequestDTO5, this, serverRequestDTO, url));
                        m.f(map5, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T> hostRequestId(\n        serverRequest: ServerRequestDTO,\n        decrypted: ByteArray,\n        url: URL\n    ): Single<Optional<Pair<Web3RequestDTO<T>, HostRequestId>>> {\n        val web3Request = Web3RequestDTO.fromJson<T>(decrypted) ?: return Single.just(Optional(null))\n\n        val childRequestAccountParams = web3Request.request.params as? ChildRequestEthereumAccountsParams\n        if (childRequestAccountParams != null) {\n            val dappURL = childRequestAccountParams.appURL\n            val dappName = childRequestAccountParams.appName\n            val dappImageURL = childRequestAccountParams.appLogoURL?.asURL\n            val requestId = HostRequestId(\n                id = web3Request.id,\n                sessionId = serverRequest.sessionId,\n                eventId = serverRequest.eventId,\n                url = url,\n                dappURL = dappURL,\n                dappImageURL = dappImageURL,\n                dappName = dappName,\n                method = web3Request.request.method\n            )\n\n            return Single.just(Optional(Pair(web3Request, requestId)))\n        }\n\n        return dappDAO.getDapp(web3Request.origin)\n            .map { dapp ->\n                var dappImageURL = dapp.toNullable()?.logoURL\n                var dappName = dapp.toNullable()?.name\n                val requestAccountParams = web3Request.request.params as? RequestEthereumAccountsParams\n\n                if (requestAccountParams != null) {\n                    dappName = requestAccountParams.appName\n                    dappImageURL = getAppLogoUrl(requestAccountParams.appLogoUrl, web3Request.origin)\n                }\n\n                val requestId = HostRequestId(\n                    id = web3Request.id,\n                    sessionId = serverRequest.sessionId,\n                    eventId = serverRequest.eventId,\n                    url = url,\n                    dappURL = web3Request.origin,\n                    dappImageURL = dappImageURL,\n                    dappName = dappName,\n                    method = web3Request.request.method\n                )\n\n                Optional(Pair(web3Request, requestId))\n            }\n    }");
                    }
                }
                b0<Optional<HostRequest>> map11 = map5.map(new n() { // from class: com.coinbase.walletlink.repositories.f
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return LinkRepository.f((Optional) obj);
                    }
                });
                m.f(map11, "hostRequestId<SignEthereumTransactionParams>(serverRequest, decrypted, url)\n                    .map {\n                        val web3Request = it.toNullable()?.first ?: return@map Optional(null)\n                        val hostRequestId = it.toNullable()?.second ?: return@map Optional(null)\n                        val weiValue = BigInteger(web3Request.request.params.weiValue)\n\n                        Optional(\n                            HostRequest.SignAndSubmitTx(\n                                hostRequestId = hostRequestId,\n                                fromAddress = web3Request.request.params.fromAddress,\n                                toAddress = web3Request.request.params.toAddress,\n                                weiValue = weiValue,\n                                data = web3Request.request.params.data.asHexEncodedData() ?: ByteArray(size = 0),\n                                nonce = web3Request.request.params.nonce,\n                                gasPrice = web3Request.request.params.gasPriceInWei.asBigInteger,\n                                maxFeePerGas = web3Request.request.params.maxFeePerGas.asBigInteger,\n                                maxPriorityFeePerGas = web3Request.request.params.maxPriorityFeePerGas.asBigInteger,\n                                gasLimit = web3Request.request.params.gasLimit.asBigInteger,\n                                chainId = web3Request.request.params.chainId,\n                                shouldSubmit = web3Request.request.params.shouldSubmit\n                            )\n                        )\n                    }");
                return map11;
            case 6:
                Web3RequestDTO.Companion companion6 = Web3RequestDTO.Companion;
                Web3RequestDTO web3RequestDTO6 = (Web3RequestDTO) JSON.INSTANCE.parameterizedAdapter(Web3RequestDTO.class, SubmitEthereumTransactionParams.class).fromJson(new String(bArr, kotlin.l0.d.a));
                if (web3RequestDTO6 == null) {
                    map6 = b0.just(new Optional(null));
                    m.f(map6, "just(Optional(null))");
                } else {
                    Object params6 = web3RequestDTO6.getRequest().getParams();
                    ChildRequestEthereumAccountsParams childRequestEthereumAccountsParams6 = params6 instanceof ChildRequestEthereumAccountsParams ? (ChildRequestEthereumAccountsParams) params6 : null;
                    if (childRequestEthereumAccountsParams6 != null) {
                        Uri appURL6 = childRequestEthereumAccountsParams6.getAppURL();
                        String appName6 = childRequestEthereumAccountsParams6.getAppName();
                        String appLogoURL6 = childRequestEthereumAccountsParams6.getAppLogoURL();
                        map6 = b0.just(new Optional(new o(web3RequestDTO6, new HostRequestId(web3RequestDTO6.getId(), serverRequestDTO.getSessionId(), serverRequestDTO.getEventId(), url, appURL6, appLogoURL6 == null ? null : String_CoreKt.getAsURL(appLogoURL6), appName6, web3RequestDTO6.getRequest().getMethod()))));
                        m.f(map6, "just(Optional(Pair(web3Request, requestId)))");
                    } else {
                        map6 = this.dappDAO.getDapp(web3RequestDTO6.getOrigin()).map(new LinkRepository$hostRequestId$1(web3RequestDTO6, this, serverRequestDTO, url));
                        m.f(map6, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T> hostRequestId(\n        serverRequest: ServerRequestDTO,\n        decrypted: ByteArray,\n        url: URL\n    ): Single<Optional<Pair<Web3RequestDTO<T>, HostRequestId>>> {\n        val web3Request = Web3RequestDTO.fromJson<T>(decrypted) ?: return Single.just(Optional(null))\n\n        val childRequestAccountParams = web3Request.request.params as? ChildRequestEthereumAccountsParams\n        if (childRequestAccountParams != null) {\n            val dappURL = childRequestAccountParams.appURL\n            val dappName = childRequestAccountParams.appName\n            val dappImageURL = childRequestAccountParams.appLogoURL?.asURL\n            val requestId = HostRequestId(\n                id = web3Request.id,\n                sessionId = serverRequest.sessionId,\n                eventId = serverRequest.eventId,\n                url = url,\n                dappURL = dappURL,\n                dappImageURL = dappImageURL,\n                dappName = dappName,\n                method = web3Request.request.method\n            )\n\n            return Single.just(Optional(Pair(web3Request, requestId)))\n        }\n\n        return dappDAO.getDapp(web3Request.origin)\n            .map { dapp ->\n                var dappImageURL = dapp.toNullable()?.logoURL\n                var dappName = dapp.toNullable()?.name\n                val requestAccountParams = web3Request.request.params as? RequestEthereumAccountsParams\n\n                if (requestAccountParams != null) {\n                    dappName = requestAccountParams.appName\n                    dappImageURL = getAppLogoUrl(requestAccountParams.appLogoUrl, web3Request.origin)\n                }\n\n                val requestId = HostRequestId(\n                    id = web3Request.id,\n                    sessionId = serverRequest.sessionId,\n                    eventId = serverRequest.eventId,\n                    url = url,\n                    dappURL = web3Request.origin,\n                    dappImageURL = dappImageURL,\n                    dappName = dappName,\n                    method = web3Request.request.method\n                )\n\n                Optional(Pair(web3Request, requestId))\n            }\n    }");
                    }
                }
                b0<Optional<HostRequest>> map12 = map6.map(new n() { // from class: com.coinbase.walletlink.repositories.g
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return LinkRepository.g((Optional) obj);
                    }
                });
                m.f(map12, "hostRequestId<SubmitEthereumTransactionParams>(serverRequest, decrypted, url)\n                    .map {\n                        val web3Request = it.toNullable()?.first ?: return@map Optional(null)\n                        val hostRequestId = it.toNullable()?.second ?: return@map Optional(null)\n                        val signedTx = web3Request.request.params.signedTransaction.asHexEncodedData()\n                            ?: return@map Optional(null)\n\n                        Optional(\n                            HostRequest.SubmitSignedTx(\n                                hostRequestId = hostRequestId,\n                                signedTx = signedTx,\n                                chainId = web3Request.request.params.chainId\n                            )\n                        )\n                    }");
                return map12;
            case 7:
                final Web3RequestCanceledDTO fromJson = Web3RequestCanceledDTO.Companion.fromJson(bArr);
                if (fromJson == null) {
                    b0<Optional<HostRequest>> just = b0.just(new Optional(null));
                    m.f(just, "just(Optional(null))");
                    return just;
                }
                b0 map13 = this.dappDAO.getDapp(fromJson.getOrigin()).map(new n() { // from class: com.coinbase.walletlink.repositories.d
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return LinkRepository.d(Web3RequestCanceledDTO.this, serverRequestDTO, url, (Optional) obj);
                    }
                });
                m.f(map13, "dappDAO.getDapp(web3Request.origin)\n                    .map { dapp ->\n                        val requestId = HostRequestId(\n                            id = web3Request.id,\n                            sessionId = serverRequest.sessionId,\n                            eventId = serverRequest.eventId,\n                            url = url,\n                            dappURL = web3Request.origin,\n                            dappImageURL = dapp.toNullable()?.logoURL,\n                            dappName = dapp.toNullable()?.name,\n                            method = RequestMethod.RequestCanceled\n                        )\n\n                        Optional(HostRequest.RequestCanceled(requestId))\n                    }");
                return map13;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: parseWeb3Request$lambda-10 */
    public static final Optional m2190parseWeb3Request$lambda10(Session session, Optional it) {
        m.g(session, "$session");
        m.g(it, "it");
        o oVar = (o) it.toNullable();
        Web3RequestDTO web3RequestDTO = oVar == null ? null : (Web3RequestDTO) oVar.c();
        if (web3RequestDTO == null) {
            return new Optional(null);
        }
        o oVar2 = (o) it.toNullable();
        HostRequestId hostRequestId = oVar2 == null ? null : (HostRequestId) oVar2.d();
        return hostRequestId == null ? new Optional(null) : new Optional(new HostRequest.ChildRequestEthereumAccounts(hostRequestId, ((ChildRequestEthereumAccountsParams) web3RequestDTO.getRequest().getParams()).getSessionId(), ((ChildRequestEthereumAccountsParams) web3RequestDTO.getRequest().getParams()).getSessionSecret(), session.getVersion()));
    }

    /* renamed from: parseWeb3Request$lambda-11 */
    public static final Optional m2191parseWeb3Request$lambda11(Session session, Optional it) {
        m.g(session, "$session");
        m.g(it, "it");
        o oVar = (o) it.toNullable();
        HostRequestId hostRequestId = oVar == null ? null : (HostRequestId) oVar.d();
        return hostRequestId == null ? new Optional(null) : new Optional(new HostRequest.RequestEthereumAccounts(hostRequestId, m.c(session.isParent(), Boolean.TRUE)));
    }

    /* renamed from: parseWeb3Request$lambda-12 */
    public static final Optional m2192parseWeb3Request$lambda12(Optional it) {
        m.g(it, "it");
        o oVar = (o) it.toNullable();
        Web3RequestDTO web3RequestDTO = oVar == null ? null : (Web3RequestDTO) oVar.c();
        if (web3RequestDTO == null) {
            return new Optional(null);
        }
        o oVar2 = (o) it.toNullable();
        HostRequestId hostRequestId = oVar2 == null ? null : (HostRequestId) oVar2.d();
        return hostRequestId == null ? new Optional(null) : new Optional(new HostRequest.SwitchEthereumChain(hostRequestId, ((SwitchEthereumChainParams) web3RequestDTO.getRequest().getParams()).getChainId()));
    }

    /* renamed from: parseWeb3Request$lambda-13 */
    public static final Optional m2193parseWeb3Request$lambda13(Optional it) {
        m.g(it, "it");
        o oVar = (o) it.toNullable();
        Web3RequestDTO web3RequestDTO = oVar == null ? null : (Web3RequestDTO) oVar.c();
        if (web3RequestDTO == null) {
            return new Optional(null);
        }
        o oVar2 = (o) it.toNullable();
        HostRequestId hostRequestId = oVar2 == null ? null : (HostRequestId) oVar2.d();
        return hostRequestId == null ? new Optional(null) : new Optional(new HostRequest.SignMessage(hostRequestId, ((SignEthereumMessageParams) web3RequestDTO.getRequest().getParams()).getAddress(), ((SignEthereumMessageParams) web3RequestDTO.getRequest().getParams()).getMessage(), ((SignEthereumMessageParams) web3RequestDTO.getRequest().getParams()).getAddPrefix(), ((SignEthereumMessageParams) web3RequestDTO.getRequest().getParams()).getTypedDataJson()));
    }

    /* renamed from: parseWeb3Request$lambda-14 */
    public static final Optional m2194parseWeb3Request$lambda14(Optional it) {
        m.g(it, "it");
        o oVar = (o) it.toNullable();
        Web3RequestDTO web3RequestDTO = oVar == null ? null : (Web3RequestDTO) oVar.c();
        if (web3RequestDTO == null) {
            return new Optional(null);
        }
        o oVar2 = (o) it.toNullable();
        HostRequestId hostRequestId = oVar2 == null ? null : (HostRequestId) oVar2.d();
        if (hostRequestId == null) {
            return new Optional(null);
        }
        BigInteger bigInteger = new BigInteger(((SignEthereumTransactionParams) web3RequestDTO.getRequest().getParams()).getWeiValue());
        String fromAddress = ((SignEthereumTransactionParams) web3RequestDTO.getRequest().getParams()).getFromAddress();
        String toAddress = ((SignEthereumTransactionParams) web3RequestDTO.getRequest().getParams()).getToAddress();
        byte[] asHexEncodedData = String_CoreKt.asHexEncodedData(((SignEthereumTransactionParams) web3RequestDTO.getRequest().getParams()).getData());
        if (asHexEncodedData == null) {
            asHexEncodedData = new byte[0];
        }
        return new Optional(new HostRequest.SignAndSubmitTx(hostRequestId, fromAddress, toAddress, bigInteger, asHexEncodedData, ((SignEthereumTransactionParams) web3RequestDTO.getRequest().getParams()).getNonce(), String_CoreKt.getAsBigInteger(((SignEthereumTransactionParams) web3RequestDTO.getRequest().getParams()).getGasPriceInWei()), String_CoreKt.getAsBigInteger(((SignEthereumTransactionParams) web3RequestDTO.getRequest().getParams()).getMaxFeePerGas()), String_CoreKt.getAsBigInteger(((SignEthereumTransactionParams) web3RequestDTO.getRequest().getParams()).getMaxPriorityFeePerGas()), String_CoreKt.getAsBigInteger(((SignEthereumTransactionParams) web3RequestDTO.getRequest().getParams()).getGasLimit()), ((SignEthereumTransactionParams) web3RequestDTO.getRequest().getParams()).getChainId(), ((SignEthereumTransactionParams) web3RequestDTO.getRequest().getParams()).getShouldSubmit()));
    }

    /* renamed from: parseWeb3Request$lambda-15 */
    public static final Optional m2195parseWeb3Request$lambda15(Optional it) {
        m.g(it, "it");
        o oVar = (o) it.toNullable();
        Web3RequestDTO web3RequestDTO = oVar == null ? null : (Web3RequestDTO) oVar.c();
        if (web3RequestDTO == null) {
            return new Optional(null);
        }
        o oVar2 = (o) it.toNullable();
        HostRequestId hostRequestId = oVar2 == null ? null : (HostRequestId) oVar2.d();
        if (hostRequestId == null) {
            return new Optional(null);
        }
        byte[] asHexEncodedData = String_CoreKt.asHexEncodedData(((SubmitEthereumTransactionParams) web3RequestDTO.getRequest().getParams()).getSignedTransaction());
        if (asHexEncodedData == null) {
            return new Optional(null);
        }
        return new Optional(new HostRequest.SubmitSignedTx(hostRequestId, asHexEncodedData, ((SubmitEthereumTransactionParams) web3RequestDTO.getRequest().getParams()).getChainId()));
    }

    /* renamed from: parseWeb3Request$lambda-16 */
    public static final Optional m2196parseWeb3Request$lambda16(Web3RequestCanceledDTO web3Request, ServerRequestDTO serverRequest, URL url, Optional dapp) {
        m.g(web3Request, "$web3Request");
        m.g(serverRequest, "$serverRequest");
        m.g(url, "$url");
        m.g(dapp, "dapp");
        String id = web3Request.getId();
        String sessionId = serverRequest.getSessionId();
        String eventId = serverRequest.getEventId();
        Uri origin = web3Request.getOrigin();
        Dapp dapp2 = (Dapp) dapp.toNullable();
        URL logoURL = dapp2 == null ? null : dapp2.getLogoURL();
        Dapp dapp3 = (Dapp) dapp.toNullable();
        return new Optional(new HostRequest.RequestCanceled(new HostRequestId(id, sessionId, eventId, url, origin, logoURL, dapp3 == null ? null : dapp3.getName(), RequestMethod.RequestCanceled)));
    }

    public final void delete(URL url, String sessionId) {
        m.g(url, "url");
        m.g(sessionId, "sessionId");
        this.sessionDAO.delete(url, sessionId);
    }

    public final b0<Optional<HostRequest>> getHostRequest(ServerRequestDTO dto, URL url) {
        m.g(dto, "dto");
        m.g(url, "url");
        Session session = getSession(dto.getSessionId(), url);
        if (session == null) {
            h.c.t0.e eVar = h.c.t0.e.a;
            b0<Optional<HostRequest>> just = b0.just(new Optional(null));
            m.f(just, "just(Optional(null))");
            return just;
        }
        try {
            byte[] decryptUsingAES256GCM = String_CryptoKt.decryptUsingAES256GCM(dto.getData(), session.getSecret());
            Map<String, Object> asJsonMap = String_CoreKt.asJsonMap(new String(decryptUsingAES256GCM, kotlin.l0.d.a));
            if (asJsonMap == null) {
                h.c.t0.e eVar2 = h.c.t0.e.a;
                b0<Optional<HostRequest>> just2 = b0.just(new Optional(null));
                m.f(just2, "just(Optional(null))");
                return just2;
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[dto.getEvent().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return parseWeb3Request(dto, RequestMethod.RequestCanceled, decryptUsingAES256GCM, url, session);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                h.c.t0.e eVar3 = h.c.t0.e.a;
                b0<Optional<HostRequest>> just3 = b0.just(new Optional(null));
                m.f(just3, "just(Optional(null))");
                return just3;
            }
            Object obj = asJsonMap.get("request");
            Map map = obj instanceof Map ? (Map) obj : null;
            if (map == null) {
                h.c.t0.e eVar4 = h.c.t0.e.a;
                b0<Optional<HostRequest>> just4 = b0.just(new Optional(null));
                m.f(just4, "just(Optional(null))");
                return just4;
            }
            Object obj2 = map.get("method");
            String str = obj2 instanceof String ? (String) obj2 : null;
            if (str == null) {
                h.c.t0.e eVar5 = h.c.t0.e.a;
                b0<Optional<HostRequest>> just5 = b0.just(new Optional(null));
                m.f(just5, "just(Optional(null))");
                return just5;
            }
            RequestMethod fromRawValue = RequestMethod.Companion.fromRawValue(str);
            if (fromRawValue == null) {
                h.c.t0.e eVar6 = h.c.t0.e.a;
                b0<Optional<HostRequest>> just6 = b0.just(new Optional(null));
                m.f(just6, "just(Optional(null))");
                return just6;
            }
            return parseWeb3Request(dto, fromRawValue, decryptUsingAES256GCM, url, session);
        } catch (Exception e2) {
            l.a.a.e(e2);
            h.c.t0.e eVar7 = h.c.t0.e.a;
            b0<Optional<HostRequest>> just7 = b0.just(new Optional(null));
            m.f(just7, "just(Optional(null))");
            return just7;
        }
    }

    public final b0<List<HostRequest>> getPendingRequests(final Session session) {
        m.g(session, "session");
        b0<List<HostRequest>> onErrorReturn = this.api.getUnseenEvents(session).flatMap(new n() { // from class: com.coinbase.walletlink.repositories.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LinkRepository.a(LinkRepository.this, session, (List) obj);
            }
        }).map(new n() { // from class: com.coinbase.walletlink.repositories.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LinkRepository.c(LinkRepository.this, session, (List) obj);
            }
        }).onErrorReturn(new n() { // from class: com.coinbase.walletlink.repositories.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LinkRepository.l((Throwable) obj);
            }
        });
        m.f(onErrorReturn, "api.getUnseenEvents(session)\n        .flatMap { requests ->\n            requests\n                .map { getHostRequest(it, session.url) }\n                .zipOrEmpty()\n                .map { hostRequests -> hostRequests.mapNotNull { it.toNullable() } }\n        }\n        .map { requests ->\n            // build list of cancelation requests\n            val cancelationRequests = requests.filter { it.hostRequestId.isCancelation }\n\n            // build list of pending requests by filtering out canceled requests\n            val pendingRequests = requests.filter { request ->\n                val cancelationRequest = cancelationRequests.firstOrNull {\n                    it.hostRequestId.canCancel(request.hostRequestId)\n                } ?: return@filter true\n\n                markCancelledEventAsSeen(request.hostRequestId, cancelationRequest.hostRequestId, session.url)\n\n                return@filter false\n            }\n\n            pendingRequests\n        }\n        .onErrorReturn { emptyList() }");
        return onErrorReturn;
    }

    public final Session getSession(String id, URL url) {
        m.g(id, "id");
        m.g(url, "url");
        return this.sessionDAO.getSession(id, url);
    }

    public final List<Session> getSessions() {
        return this.sessionDAO.getSessions();
    }

    public final /* synthetic */ <T> b0<Optional<o<Web3RequestDTO<T>, HostRequestId>>> hostRequestId(ServerRequestDTO serverRequest, byte[] decrypted, URL url) {
        m.g(serverRequest, "serverRequest");
        m.g(decrypted, "decrypted");
        m.g(url, "url");
        Web3RequestDTO.Companion companion = Web3RequestDTO.Companion;
        String str = new String(decrypted, kotlin.l0.d.a);
        JSON json = JSON.INSTANCE;
        m.l(4, "T");
        Web3RequestDTO web3RequestDTO = (Web3RequestDTO) json.parameterizedAdapter(Web3RequestDTO.class, Object.class).fromJson(str);
        if (web3RequestDTO == null) {
            b0<Optional<o<Web3RequestDTO<T>, HostRequestId>>> just = b0.just(new Optional(null));
            m.f(just, "just(Optional(null))");
            return just;
        }
        T params = web3RequestDTO.getRequest().getParams();
        ChildRequestEthereumAccountsParams childRequestEthereumAccountsParams = params instanceof ChildRequestEthereumAccountsParams ? (ChildRequestEthereumAccountsParams) params : null;
        if (childRequestEthereumAccountsParams != null) {
            Uri appURL = childRequestEthereumAccountsParams.getAppURL();
            String appName = childRequestEthereumAccountsParams.getAppName();
            String appLogoURL = childRequestEthereumAccountsParams.getAppLogoURL();
            b0<Optional<o<Web3RequestDTO<T>, HostRequestId>>> just2 = b0.just(new Optional(new o(web3RequestDTO, new HostRequestId(web3RequestDTO.getId(), serverRequest.getSessionId(), serverRequest.getEventId(), url, appURL, appLogoURL != null ? String_CoreKt.getAsURL(appLogoURL) : null, appName, web3RequestDTO.getRequest().getMethod()))));
            m.f(just2, "just(Optional(Pair(web3Request, requestId)))");
            return just2;
        }
        b0<Optional<o<Web3RequestDTO<T>, HostRequestId>>> b0Var = (b0<Optional<o<Web3RequestDTO<T>, HostRequestId>>>) this.dappDAO.getDapp(web3RequestDTO.getOrigin()).map(new LinkRepository$hostRequestId$1(web3RequestDTO, this, serverRequest, url));
        m.f(b0Var, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T> hostRequestId(\n        serverRequest: ServerRequestDTO,\n        decrypted: ByteArray,\n        url: URL\n    ): Single<Optional<Pair<Web3RequestDTO<T>, HostRequestId>>> {\n        val web3Request = Web3RequestDTO.fromJson<T>(decrypted) ?: return Single.just(Optional(null))\n\n        val childRequestAccountParams = web3Request.request.params as? ChildRequestEthereumAccountsParams\n        if (childRequestAccountParams != null) {\n            val dappURL = childRequestAccountParams.appURL\n            val dappName = childRequestAccountParams.appName\n            val dappImageURL = childRequestAccountParams.appLogoURL?.asURL\n            val requestId = HostRequestId(\n                id = web3Request.id,\n                sessionId = serverRequest.sessionId,\n                eventId = serverRequest.eventId,\n                url = url,\n                dappURL = dappURL,\n                dappImageURL = dappImageURL,\n                dappName = dappName,\n                method = web3Request.request.method\n            )\n\n            return Single.just(Optional(Pair(web3Request, requestId)))\n        }\n\n        return dappDAO.getDapp(web3Request.origin)\n            .map { dapp ->\n                var dappImageURL = dapp.toNullable()?.logoURL\n                var dappName = dapp.toNullable()?.name\n                val requestAccountParams = web3Request.request.params as? RequestEthereumAccountsParams\n\n                if (requestAccountParams != null) {\n                    dappName = requestAccountParams.appName\n                    dappImageURL = getAppLogoUrl(requestAccountParams.appLogoUrl, web3Request.origin)\n                }\n\n                val requestId = HostRequestId(\n                    id = web3Request.id,\n                    sessionId = serverRequest.sessionId,\n                    eventId = serverRequest.eventId,\n                    url = url,\n                    dappURL = web3Request.origin,\n                    dappImageURL = dappImageURL,\n                    dappName = dappName,\n                    method = web3Request.request.method\n                )\n\n                Optional(Pair(web3Request, requestId))\n            }\n    }");
        return b0Var;
    }

    public final b0<x> markAsSeen(HostRequestId requestId, URL url) {
        m.g(requestId, "requestId");
        m.g(url, "url");
        Session session = this.sessionDAO.getSession(requestId.getSessionId(), url);
        if (session == null) {
            b0<x> just = b0.just(x.a);
            m.f(just, "just(Unit)");
            return just;
        }
        return this.api.markEventAsSeen(requestId.getEventId(), session.getId(), session.getSecret(), url);
    }

    public final h.c.s<List<Session>> observeSessions() {
        return this.sessionDAO.observeSessions();
    }

    public final b0<x> saveDapp(Dapp dapp) {
        m.g(dapp, "dapp");
        return this.dappDAO.save(dapp);
    }

    public final void saveSession(URL url, String sessionId, String secret, String str, boolean z, boolean z2, String str2, String str3, URL url2, Uri uri) {
        m.g(url, "url");
        m.g(sessionId, "sessionId");
        m.g(secret, "secret");
        this.sessionDAO.save(url, sessionId, secret, str, z, z2, str2, str3, url2, uri);
    }

    public final void updateSession(Session session) {
        m.g(session, "session");
        this.sessionDAO.update(session);
    }

    public final List<Session> getSessions(URL url) {
        m.g(url, "url");
        return this.sessionDAO.getSessions(url);
    }

    public final h.c.s<List<Session>> observeSessions(URL url) {
        m.g(url, "url");
        return this.sessionDAO.observeSessions(url);
    }
}