package com.coinbase.wallet.features.walletlink.repositories;

import android.net.Uri;
import com.coinbase.ciphercore.ByteArray_CipherCoreKt;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.ParsedEthereumTransaction;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.core.util.BoundedSet;
import com.coinbase.wallet.core.util.ConcurrentLruCache;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.core.util.RxSchedulers;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import com.coinbase.wallet.features.walletlink.exceptions.WalletLinkException;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotificationCreator;
import com.coinbase.wallet.features.walletlink.models.WalletLinkSessionKey;
import com.coinbase.wallet.features.wallets.extensions.legacy.Network_ApplicationKt;
import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.coinbase.wallet.http.connectivity.Internet;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletlink.WalletLinkInterface;
import com.coinbase.walletlink.models.ClientMetadataKey;
import com.coinbase.walletlink.models.HostRequest;
import com.coinbase.walletlink.models.HostRequestId;
import com.coinbase.walletlink.models.Session;
import h.c.h0;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.protocol.HttpRequestExecutor;
import org.toshi.R;

/* compiled from: WalletLinkRepository.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BC\b\u0007\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010~\u001a\u00020}\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010r\u001a\u00020q\u0012\u0006\u0010l\u001a\u00020k\u0012\u0006\u0010i\u001a\u00020h\u0012\u0006\u0010F\u001a\u00020E¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001e0\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0!H\u0002¢\u0006\u0004\b\"\u0010#Js\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d0/2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010'\u001a\u00020&2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010)\u001a\u00020(2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b0\u00101J\u0013\u00102\u001a\b\u0012\u0004\u0012\u00020\u00100/¢\u0006\u0004\b2\u00103J!\u00102\u001a\b\u0012\u0004\u0012\u00020\u00100/2\f\u00106\u001a\b\u0012\u0004\u0012\u00020504¢\u0006\u0004\b2\u00107J\u001b\u00108\u001a\b\u0012\u0004\u0012\u00020\u00100/2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b8\u00109J#\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00100/2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0005¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00100/2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b=\u00109J!\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00100/2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000304¢\u0006\u0004\b?\u00107J\u000f\u0010@\u001a\u00020\u0010H\u0016¢\u0006\u0004\b@\u0010\u0014J\u0015\u0010A\u001a\b\u0012\u0004\u0012\u00020(0/H\u0016¢\u0006\u0004\bA\u00103R\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR=\u0010O\u001a&\u0012\f\u0012\n N*\u0004\u0018\u00010\u00030\u0003 N*\u0012\u0012\f\u0012\n N*\u0004\u0018\u00010\u00030\u0003\u0018\u00010!0!8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010#R#\u0010V\u001a\b\u0012\u0004\u0012\u00020R0!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010#R\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R(\u0010`\u001a\u0014\u0012\u0004\u0012\u00020^\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030_0]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR#\u0010e\u001a\b\u0012\u0004\u0012\u00020b0!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010T\u001a\u0004\bd\u0010#R\u0019\u00106\u001a\b\u0012\u0004\u0012\u000205048F@\u0006¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0016\u0010i\u001a\u00020h8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010l\u001a\u00020k8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010o\u001a\u00020n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010r\u001a\u00020q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sRR\u0010u\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020t N*\n\u0012\u0004\u0012\u00020t\u0018\u00010404 N*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020t N*\n\u0012\u0004\u0012\u00020t\u0018\u00010404\u0018\u00010!0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010PR\u001c\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00030v8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR%\u0010y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000205040!8\u0006@\u0006¢\u0006\f\n\u0004\by\u0010P\u001a\u0004\bz\u0010#R\u001f\u0010{\u001a\b\u0012\u0004\u0012\u00020\u001b0!8\u0006@\u0006¢\u0006\f\n\u0004\b{\u0010P\u001a\u0004\b|\u0010#R\u0016\u0010~\u001a\u00020}8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001e\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170!8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010P¨\u0006\u0083\u0001"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/walletlink/models/HostRequestId;", "requestId", "", "signedTx", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lh/c/k0/b;", "submitEthereumTx", "(Lcom/coinbase/walletlink/models/HostRequestId;[BI)Lh/c/k0/b;", "", "childSessionId", "childSessionSecret", ClientCookie.VERSION_ATTR, "Lkotlin/x;", "connectChild", "(Lcom/coinbase/walletlink/models/HostRequestId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "observeEthereumAddressChanges", "()V", "observeNetworkChanges", "observeNonUIRequests", "Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification;", "notification", "handlePushNotification", "(Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification;)Lh/c/k0/b;", "Lcom/coinbase/walletlink/models/HostRequest;", "request", "Lcom/coinbase/wallet/core/util/Optional;", "Lkotlin/o;", "titleAndBodyFor", "(Lcom/coinbase/walletlink/models/HostRequest;)Lcom/coinbase/wallet/core/util/Optional;", "Lh/c/s;", "createRequestsObservable", "()Lh/c/s;", WalletLinkPushNotification.sessionIdKey, "secret", "Ljava/net/URL;", WalletLinkPushNotification.serverUrlKey, "", "isParent", "parentSessionId", WalletLinkCompleteArgs.DAPP_NAME, "dappImageURL", "Landroid/net/Uri;", "dappURL", "Lh/c/b0;", "connect", "(Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/net/URL;Landroid/net/Uri;)Lh/c/b0;", "disconnect", "()Lh/c/b0;", "", "Lcom/coinbase/walletlink/models/Session;", "sessions", "(Ljava/util/List;)Lh/c/b0;", "approveDappPermission", "(Lcom/coinbase/walletlink/models/HostRequestId;)Lh/c/b0;", "signedData", "approve", "(Lcom/coinbase/walletlink/models/HostRequestId;[B)Lh/c/b0;", "reject", "requestIds", "markAsSeen", "start", "destroy", "Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotificationCreator;", "notificationCreator", "Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotificationCreator;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lcom/coinbase/wallet/user/repositories/UserRepository;", "userRepository", "Lcom/coinbase/wallet/user/repositories/UserRepository;", "Lcom/coinbase/wallet/core/util/BoundedSet;", "processedRequestIds", "Lcom/coinbase/wallet/core/util/BoundedSet;", "kotlin.jvm.PlatformType", "childConnectedObservable", "Lh/c/s;", "getChildConnectedObservable", "Lcom/coinbase/wallet/user/models/User;", "activeUserObservable$delegate", "Lkotlin/h;", "getActiveUserObservable", "activeUserObservable", "Lcom/coinbase/walletlink/WalletLinkInterface;", "walletLink", "Lcom/coinbase/walletlink/WalletLinkInterface;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/core/util/ConcurrentLruCache;", "Lcom/coinbase/wallet/features/walletlink/models/WalletLinkSessionKey;", "Lh/c/v0/a;", "newConnectionCallbacks", "Lcom/coinbase/wallet/core/util/ConcurrentLruCache;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "activeWalletObservable$delegate", "getActiveWalletObservable", "activeWalletObservable", "getSessions", "()Ljava/util/List;", "Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "ethTxRepository", "Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "ethWalletRepository", "Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "Lh/c/a0;", "serialRequestsScheduler", "Lh/c/a0;", "Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;", "pushNotificationRepository", "Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;", "Lcom/coinbase/wallet/blockchains/models/Address;", "ethAddressesObservable", "Lh/c/v0/b;", "childConnectedSubject", "Lh/c/v0/b;", "sessionsObservable", "getSessionsObservable", "requestsObservable", "getRequestsObservable", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "pushNotificationObservable", "<init>", "(Lcom/coinbase/walletlink/WalletLinkInterface;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/user/repositories/UserRepository;Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkRepository implements Startable, Destroyable {
    private final kotlin.h activeUserObservable$delegate;
    private final kotlin.h activeWalletObservable$delegate;
    private final h.c.s<HostRequestId> childConnectedObservable;
    private final h.c.v0.b<HostRequestId> childConnectedSubject;
    private final CipherCoreInterface cipherCore;
    private final h.c.k0.a disposeBag;
    private final h.c.s<List<Address>> ethAddressesObservable;
    private final IETHTxRepository ethTxRepository;
    private final IETHWalletRepository ethWalletRepository;
    private final ConcurrentLruCache<WalletLinkSessionKey, h.c.v0.a<HostRequestId>> newConnectionCallbacks;
    private final WalletLinkPushNotificationCreator notificationCreator;
    private final BoundedSet<HostRequestId> processedRequestIds;
    private final h.c.s<WalletLinkPushNotification> pushNotificationObservable;
    private final PushNotificationRepository pushNotificationRepository;
    private final h.c.s<HostRequest> requestsObservable;
    private final h.c.a0 serialRequestsScheduler;
    private final h.c.s<List<Session>> sessionsObservable;
    private final UserRepository userRepository;
    private final WalletLinkInterface walletLink;
    private final IWalletRepository walletRepository;

    public WalletLinkRepository(WalletLinkInterface walletLink, CipherCoreInterface cipherCore, UserRepository userRepository, PushNotificationRepository pushNotificationRepository, IETHWalletRepository ethWalletRepository, IETHTxRepository ethTxRepository, IWalletRepository walletRepository) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.jvm.internal.m.g(walletLink, "walletLink");
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(userRepository, "userRepository");
        kotlin.jvm.internal.m.g(pushNotificationRepository, "pushNotificationRepository");
        kotlin.jvm.internal.m.g(ethWalletRepository, "ethWalletRepository");
        kotlin.jvm.internal.m.g(ethTxRepository, "ethTxRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        this.walletLink = walletLink;
        this.cipherCore = cipherCore;
        this.userRepository = userRepository;
        this.pushNotificationRepository = pushNotificationRepository;
        this.ethWalletRepository = ethWalletRepository;
        this.ethTxRepository = ethTxRepository;
        this.walletRepository = walletRepository;
        WalletLinkPushNotificationCreator walletLinkPushNotificationCreator = new WalletLinkPushNotificationCreator();
        this.notificationCreator = walletLinkPushNotificationCreator;
        this.disposeBag = new h.c.k0.a();
        b2 = kotlin.k.b(new WalletLinkRepository$activeUserObservable$2(this));
        this.activeUserObservable$delegate = b2;
        this.processedRequestIds = new BoundedSet<>(HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE);
        this.serialRequestsScheduler = RxSchedulers.INSTANCE.newSerialScheduler();
        this.newConnectionCallbacks = new ConcurrentLruCache<>(30);
        this.pushNotificationObservable = pushNotificationRepository.observeSelectedNotificationsWith(walletLinkPushNotificationCreator);
        b3 = kotlin.k.b(new WalletLinkRepository$activeWalletObservable$2(this));
        this.activeWalletObservable$delegate = b3;
        this.ethAddressesObservable = walletRepository.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.k(WalletLinkRepository.this, (Network) obj);
            }
        });
        h.c.v0.b<HostRequestId> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.childConnectedSubject = d2;
        this.requestsObservable = createRequestsObservable();
        this.sessionsObservable = walletLink.observeSessions();
        this.childConnectedObservable = d2.hide();
    }

    public static /* synthetic */ void A(WalletLinkRepository walletLinkRepository, HostRequest hostRequest) {
        m1531observeNonUIRequests$lambda28(walletLinkRepository, hostRequest);
    }

    public static /* synthetic */ Optional B(HostRequest hostRequest) {
        return m1529observeNonUIRequests$lambda26(hostRequest);
    }

    /* renamed from: approveDappPermission$lambda-9 */
    public static final h0 m1511approveDappPermission$lambda9(WalletLinkRepository this$0, HostRequestId requestId, Wallet it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(requestId, "$requestId");
        kotlin.jvm.internal.m.g(it, "it");
        WalletLinkInterface walletLinkInterface = this$0.walletLink;
        String primaryAddress = it.getPrimaryAddress();
        Charset charset = kotlin.l0.d.a;
        Objects.requireNonNull(primaryAddress, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = primaryAddress.getBytes(charset);
        kotlin.jvm.internal.m.f(bytes, "(this as java.lang.String).getBytes(charset)");
        return walletLinkInterface.approve(requestId, bytes);
    }

    public static /* synthetic */ h.c.x b(WalletLinkRepository walletLinkRepository, WalletLinkPushNotification walletLinkPushNotification) {
        return m1518createRequestsObservable$lambda30(walletLinkRepository, walletLinkPushNotification);
    }

    public static /* synthetic */ boolean c(kotlin.o oVar, kotlin.o oVar2) {
        return m1524observeEthereumAddressChanges$lambda20(oVar, oVar2);
    }

    /* renamed from: connect$lambda-1 */
    public static final h0 m1512connect$lambda1(WalletLinkRepository this$0, String sessionId, String secret, String str, boolean z, String str2, String str3, URL url, Uri uri, URL serverUrl, kotlin.o dstr$user$wallet) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(sessionId, "$sessionId");
        kotlin.jvm.internal.m.g(secret, "$secret");
        kotlin.jvm.internal.m.g(serverUrl, "$serverUrl");
        kotlin.jvm.internal.m.g(dstr$user$wallet, "$dstr$user$wallet");
        User user = (User) dstr$user$wallet.a();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(ClientMetadataKey.EthereumAddress, ((Wallet) dstr$user$wallet.b()).getPrimaryAddress());
        concurrentHashMap.put(ClientMetadataKey.WalletUsername, user.getUsername());
        return this$0.walletLink.link(sessionId, secret, str, z, str2, str3, url, uri, serverUrl, String.valueOf(user.getId()), concurrentHashMap);
    }

    /* renamed from: connect$lambda-4 */
    public static final h0 m1513connect$lambda4(h.c.v0.a aVar, WalletLinkRepository this$0, final WalletLinkSessionKey key, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(key, "$key");
        kotlin.jvm.internal.m.g(it, "it");
        if (aVar == null) {
            return h.c.b0.just(OptionalKt.toOptional(null));
        }
        return Observable_CoreKt.takeSingle(aVar).timeout(15L, TimeUnit.SECONDS).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.w
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.w(WalletLinkRepository.this, key, (Throwable) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.r
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.r((HostRequestId) obj);
            }
        });
    }

    /* renamed from: connect$lambda-4$lambda-2 */
    public static final h0 m1514connect$lambda4$lambda2(WalletLinkRepository this$0, WalletLinkSessionKey key, Throwable it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(key, "$key");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.newConnectionCallbacks.remove(key);
        return h.c.b0.error(it);
    }

    /* renamed from: connect$lambda-4$lambda-3 */
    public static final Optional m1515connect$lambda4$lambda3(HostRequestId it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(it);
    }

    /* renamed from: connect$lambda-5 */
    public static final h0 m1516connect$lambda5(WalletLinkRepository this$0, WalletLinkSessionKey key, Throwable it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(key, "$key");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.newConnectionCallbacks.remove(key);
        return h.c.b0.error(it);
    }

    private final void connectChild(final HostRequestId hostRequestId, String str, String str2, String str3) {
        Object obj;
        boolean z;
        String sessionId = hostRequestId.getSessionId();
        Iterator<T> it = getSessions().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Session session = (Session) obj;
            if (kotlin.jvm.internal.m.c(session.getId(), sessionId) && kotlin.jvm.internal.m.c(session.getUrl(), hostRequestId.getUrl())) {
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
        if (session2 != null ? kotlin.jvm.internal.m.c(session2.isParent(), Boolean.TRUE) : false) {
            this.childConnectedSubject.onNext(hostRequestId);
            h.c.b0<R> flatMap = connect(str, str2, hostRequestId.getUrl(), str3, false, sessionId, hostRequestId.getDappName(), hostRequestId.getDappImageURL(), hostRequestId.getDappURL()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.m
                @Override // h.c.m0.n
                public final Object apply(Object obj2) {
                    return WalletLinkRepository.n(WalletLinkRepository.this, hostRequestId, (Optional) obj2);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "connect(\n                childSessionId,\n                childSessionSecret,\n                requestId.url,\n                version,\n                isParent = false,\n                parentSessionId = parentSessionId,\n                dappName = requestId.dappName,\n                dappImageURL = requestId.dappImageURL,\n                dappURL = requestId.dappURL\n            )\n                .flatMap { approveDappPermission(requestId) }");
            Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null).subscribe();
            return;
        }
        Single_AnalyticsKt.logError$default(reject(hostRequestId), null, null, 3, null).subscribe();
    }

    /* renamed from: connectChild$lambda-18 */
    public static final h0 m1517connectChild$lambda18(WalletLinkRepository this$0, HostRequestId requestId, Optional it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(requestId, "$requestId");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.approveDappPermission(requestId);
    }

    private final h.c.s<HostRequest> createRequestsObservable() {
        h.c.s onErrorReturn = this.pushNotificationObservable.flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.b(WalletLinkRepository.this, (WalletLinkPushNotification) obj);
            }
        }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.v((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "pushNotificationObservable\n            .flatMap { notification ->\n                walletLink.getRequest(notification.eventId, notification.sessionId, notification.serverUrl)\n                    .map { Optional(it) }\n                    .toObservable()\n            }\n            .onErrorReturn { Optional(null) }");
        h.c.s map = onErrorReturn.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository$createRequestsObservable$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository$createRequestsObservable$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        h.c.s map2 = h.c.s.merge(this.walletLink.getRequestsObservable(), map).observeOn(this.serialRequestsScheduler).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.l(WalletLinkRepository.this, (HostRequest) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "merge(walletLink.requestsObservable, hostRequestNotificationObservable)\n            .observeOn(serialRequestsScheduler)\n            .map { request ->\n                val hostRequestId = request.hostRequestId\n\n                if (processedRequestIds.has(hostRequestId)) {\n                    return@map Optional(null)\n                }\n\n                // WalletLink version > 0 should auto approve dapps. (note: v0 has version = null)\n                val session = sessions.firstOrNull {\n                    it.url == hostRequestId.url && it.id == hostRequestId.sessionId\n                }\n\n                if (session?.version == null) {\n                    processedRequestIds.add(request.hostRequestId)\n\n                    return@map Optional(request)\n                }\n\n                if (request.isAutoApproveDappPermission) {\n                    // TODO - Alex - add to dispose bag?\n                    approveDappPermission(requestId = request.hostRequestId).subscribeBy { }\n\n                    val key = WalletLinkSessionKey(sessionId = session.id, url = session.url)\n                    val callback = newConnectionCallbacks[key]\n\n                    newConnectionCallbacks.remove(key)\n                    callback?.onNext(hostRequestId)\n\n                    // TODO - Alex - double check we don't need to add it to processedRequestIds\n                    return@map Optional(null)\n                }\n\n                processedRequestIds.add(request.hostRequestId)\n\n                Optional(request)\n            }");
        h.c.s<HostRequest> map3 = map2.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository$createRequestsObservable$$inlined$unwrap$3
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository$createRequestsObservable$$inlined$unwrap$4
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map3, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        return map3;
    }

    /* renamed from: createRequestsObservable$lambda-30 */
    public static final h.c.x m1518createRequestsObservable$lambda30(WalletLinkRepository this$0, WalletLinkPushNotification notification) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(notification, "notification");
        return this$0.walletLink.getRequest(notification.getEventId(), notification.getSessionId(), notification.getServerUrl()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.z
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.z((HostRequest) obj);
            }
        }).toObservable();
    }

    /* renamed from: createRequestsObservable$lambda-30$lambda-29 */
    public static final Optional m1519createRequestsObservable$lambda30$lambda29(HostRequest it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(it);
    }

    /* renamed from: createRequestsObservable$lambda-31 */
    public static final Optional m1520createRequestsObservable$lambda31(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(null);
    }

    /* renamed from: createRequestsObservable$lambda-33 */
    public static final Optional m1521createRequestsObservable$lambda33(WalletLinkRepository this$0, HostRequest request) {
        Object obj;
        boolean z;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(request, "request");
        HostRequestId hostRequestId = request.getHostRequestId();
        if (this$0.processedRequestIds.has(hostRequestId)) {
            return new Optional(null);
        }
        Iterator<T> it = this$0.getSessions().iterator();
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
        if ((session2 == null ? null : session2.getVersion()) == null) {
            this$0.processedRequestIds.add(request.getHostRequestId());
            return new Optional(request);
        } else if (request.isAutoApproveDappPermission()) {
            h.c.t0.g.i(this$0.approveDappPermission(request.getHostRequestId()), null, WalletLinkRepository$createRequestsObservable$1$1.INSTANCE, 1, null);
            WalletLinkSessionKey walletLinkSessionKey = new WalletLinkSessionKey(session2.getId(), session2.getUrl());
            h.c.v0.a<HostRequestId> aVar = this$0.newConnectionCallbacks.get(walletLinkSessionKey);
            this$0.newConnectionCallbacks.remove(walletLinkSessionKey);
            if (aVar != null) {
                aVar.onNext(hostRequestId);
            }
            return new Optional(null);
        } else {
            this$0.processedRequestIds.add(request.getHostRequestId());
            return new Optional(request);
        }
    }

    public static /* synthetic */ byte[] d(ParsedEthereumTransaction parsedEthereumTransaction, EthereumSignedTx ethereumSignedTx) {
        return m1535submitEthereumTx$lambda14$lambda13(parsedEthereumTransaction, ethereumSignedTx);
    }

    public static /* synthetic */ h0 e(WalletLinkRepository walletLinkRepository, HostRequestId hostRequestId, Wallet wallet) {
        return m1511approveDappPermission$lambda9(walletLinkRepository, hostRequestId, wallet);
    }

    /* renamed from: ethAddressesObservable$lambda-0 */
    public static final h0 m1522ethAddressesObservable$lambda0(WalletLinkRepository this$0, Network it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.ethWalletRepository.getAddresses(it);
    }

    public static /* synthetic */ h0 f(WalletLinkRepository walletLinkRepository, WalletLinkSessionKey walletLinkSessionKey, Throwable th) {
        return m1516connect$lambda5(walletLinkRepository, walletLinkSessionKey, th);
    }

    public static /* synthetic */ h0 g(WalletLinkRepository walletLinkRepository, Network network) {
        return m1528observeNetworkChanges$lambda25(walletLinkRepository, network);
    }

    private final h.c.s<User> getActiveUserObservable() {
        return (h.c.s) this.activeUserObservable$delegate.getValue();
    }

    private final h.c.s<Wallet> getActiveWalletObservable() {
        Object value = this.activeWalletObservable$delegate.getValue();
        kotlin.jvm.internal.m.f(value, "<get-activeWalletObservable>(...)");
        return (h.c.s) value;
    }

    public static /* synthetic */ h0 h(h.c.v0.a aVar, WalletLinkRepository walletLinkRepository, WalletLinkSessionKey walletLinkSessionKey, kotlin.x xVar) {
        return m1513connect$lambda4(aVar, walletLinkRepository, walletLinkSessionKey, xVar);
    }

    private final h.c.k0.b handlePushNotification(WalletLinkPushNotification walletLinkPushNotification) {
        return h.c.t0.a.a(h.c.t0.g.i(this.walletLink.getRequest(walletLinkPushNotification.getEventId(), walletLinkPushNotification.getSessionId(), walletLinkPushNotification.getServerUrl()), null, new WalletLinkRepository$handlePushNotification$1(this, walletLinkPushNotification), 1, null), this.disposeBag);
    }

    public static /* synthetic */ h.c.x i(WalletLinkRepository walletLinkRepository, Wallet wallet) {
        return m1526observeEthereumAddressChanges$lambda22(walletLinkRepository, wallet);
    }

    public static /* synthetic */ h0 j(WalletLinkRepository walletLinkRepository, String str, String str2, String str3, boolean z, String str4, String str5, URL url, Uri uri, URL url2, kotlin.o oVar) {
        return m1512connect$lambda1(walletLinkRepository, str, str2, str3, z, str4, str5, url, uri, url2, oVar);
    }

    public static /* synthetic */ h0 k(WalletLinkRepository walletLinkRepository, Network network) {
        return m1522ethAddressesObservable$lambda0(walletLinkRepository, network);
    }

    public static /* synthetic */ Optional l(WalletLinkRepository walletLinkRepository, HostRequest hostRequest) {
        return m1521createRequestsObservable$lambda33(walletLinkRepository, hostRequest);
    }

    public static /* synthetic */ boolean m(kotlin.o oVar) {
        return m1523observeEthereumAddressChanges$lambda19(oVar);
    }

    public static /* synthetic */ h0 n(WalletLinkRepository walletLinkRepository, HostRequestId hostRequestId, Optional optional) {
        return m1517connectChild$lambda18(walletLinkRepository, hostRequestId, optional);
    }

    public static /* synthetic */ kotlin.x o(Throwable th) {
        return m1527observeEthereumAddressChanges$lambda23(th);
    }

    private final void observeEthereumAddressChanges() {
        h.c.t0.c cVar = h.c.t0.c.a;
        h.c.s<Wallet> activeWalletObservable = getActiveWalletObservable();
        h.c.s<ConnectionStatus> statusChanges = Internet.INSTANCE.getStatusChanges();
        kotlin.jvm.internal.m.f(statusChanges, "Internet.statusChanges");
        h.c.s flatMap = cVar.a(activeWalletObservable, statusChanges).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.walletlink.repositories.l
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return WalletLinkRepository.m((kotlin.o) obj);
            }
        }).distinctUntilChanged(new h.c.m0.d() { // from class: com.coinbase.wallet.features.walletlink.repositories.b
            @Override // h.c.m0.d
            public final boolean a(Object obj, Object obj2) {
                return WalletLinkRepository.c((kotlin.o) obj, (kotlin.o) obj2);
            }
        }).skip(1L).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.u((kotlin.o) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.i(WalletLinkRepository.this, (Wallet) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "Observables.combineLatest(activeWalletObservable, Internet.statusChanges)\n            .filter { it.second.isOnline }\n            .distinctUntilChanged { lhs, rhs ->\n                lhs.first.primaryAddress == rhs.first.primaryAddress && lhs.first.network == rhs.first.network\n            }\n            .skip(1)\n            .map { it.first }\n            .flatMap { walletLink.setMetadata(ClientMetadataKey.EthereumAddress, it.primaryAddress).toObservable() }");
        h.c.k0.b subscribe = Observable_AnalyticsKt.logError$default(flatMap, null, null, 3, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.o((Throwable) obj);
            }
        }).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "Observables.combineLatest(activeWalletObservable, Internet.statusChanges)\n            .filter { it.second.isOnline }\n            .distinctUntilChanged { lhs, rhs ->\n                lhs.first.primaryAddress == rhs.first.primaryAddress && lhs.first.network == rhs.first.network\n            }\n            .skip(1)\n            .map { it.first }\n            .flatMap { walletLink.setMetadata(ClientMetadataKey.EthereumAddress, it.primaryAddress).toObservable() }\n            .logError()\n            .onErrorReturn { Unit }\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
    }

    /* renamed from: observeEthereumAddressChanges$lambda-19 */
    public static final boolean m1523observeEthereumAddressChanges$lambda19(kotlin.o it) {
        kotlin.jvm.internal.m.g(it, "it");
        return ((ConnectionStatus) it.d()).isOnline();
    }

    /* renamed from: observeEthereumAddressChanges$lambda-20 */
    public static final boolean m1524observeEthereumAddressChanges$lambda20(kotlin.o lhs, kotlin.o rhs) {
        kotlin.jvm.internal.m.g(lhs, "lhs");
        kotlin.jvm.internal.m.g(rhs, "rhs");
        return kotlin.jvm.internal.m.c(((Wallet) lhs.c()).getPrimaryAddress(), ((Wallet) rhs.c()).getPrimaryAddress()) && kotlin.jvm.internal.m.c(((Wallet) lhs.c()).getNetwork(), ((Wallet) rhs.c()).getNetwork());
    }

    /* renamed from: observeEthereumAddressChanges$lambda-21 */
    public static final Wallet m1525observeEthereumAddressChanges$lambda21(kotlin.o it) {
        kotlin.jvm.internal.m.g(it, "it");
        return (Wallet) it.c();
    }

    /* renamed from: observeEthereumAddressChanges$lambda-22 */
    public static final h.c.x m1526observeEthereumAddressChanges$lambda22(WalletLinkRepository this$0, Wallet it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.walletLink.setMetadata(ClientMetadataKey.EthereumAddress, it.getPrimaryAddress()).toObservable();
    }

    /* renamed from: observeEthereumAddressChanges$lambda-23 */
    public static final kotlin.x m1527observeEthereumAddressChanges$lambda23(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    private final void observeNetworkChanges() {
        h.c.k0.b subscribe = this.walletRepository.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)).distinctUntilChanged().flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.g(WalletLinkRepository.this, (Network) obj);
            }
        }).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "walletRepository.observeNetwork(Blockchain.ETHEREUM)\n            .distinctUntilChanged()\n            .flatMapSingle { network ->\n                network.asEthereumChain?.let { ethereumChain ->\n                    val setChainIdSingle = walletLink.setMetadata(\n                        ClientMetadataKey.ChainId,\n                        ethereumChain.chainId.toString()\n                    )\n\n                    val jsonRpcUrlSingle = walletLink.setMetadata(\n                        ClientMetadataKey.JsonRpcUrl,\n                        ethereumChain.rpcUrl\n                    )\n\n                    return@flatMapSingle setChainIdSingle.zipWith(jsonRpcUrlSingle).asUnit()\n                }\n\n                Single.just(Unit)\n            }\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
    }

    /* renamed from: observeNetworkChanges$lambda-25 */
    public static final h0 m1528observeNetworkChanges$lambda25(WalletLinkRepository this$0, Network network) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(network, "network");
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
        if (asEthereumChain == null) {
            return h.c.b0.just(kotlin.x.a);
        }
        return Single_CoreKt.asUnit(h.c.t0.f.a(this$0.walletLink.setMetadata(ClientMetadataKey.ChainId, String.valueOf(asEthereumChain.getChainId())), this$0.walletLink.setMetadata(ClientMetadataKey.JsonRpcUrl, asEthereumChain.getRpcUrl())));
    }

    private final void observeNonUIRequests() {
        h.c.s<R> map = this.walletLink.getRequestsObservable().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.b0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.B((HostRequest) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletLink.requestsObservable\n            .map { Optional(it) }");
        h.c.s onErrorReturn = Observable_AnalyticsKt.logError$default(map, null, null, 3, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.q((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "walletLink.requestsObservable\n            .map { Optional(it) }\n            .logError()\n            .onErrorReturn { Optional(null) }");
        h.c.s map2 = onErrorReturn.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository$observeNonUIRequests$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository$observeNonUIRequests$$inlined$unwrap$2
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
        h.c.k0.b subscribe = map2.subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.walletlink.repositories.a0
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                WalletLinkRepository.A(WalletLinkRepository.this, (HostRequest) obj);
            }
        });
        kotlin.jvm.internal.m.f(subscribe, "walletLink.requestsObservable\n            .map { Optional(it) }\n            .logError()\n            .onErrorReturn { Optional(null) }\n            .unwrap()\n            .subscribe { request ->\n                when (request) {\n                    is HostRequest.SubmitSignedTx -> submitEthereumTx(\n                        requestId = request.hostRequestId,\n                        signedTx = request.signedTx,\n                        chainId = request.chainId\n                    )\n                    is HostRequest.ChildRequestEthereumAccounts -> {\n                        connectChild(\n                            requestId = request.hostRequestId,\n                            childSessionId = request.childSessionId,\n                            childSessionSecret = request.childSessionSecret,\n                            version = request.version\n                        )\n                    }\n                }\n            }");
        h.c.t0.a.a(subscribe, this.disposeBag);
    }

    /* renamed from: observeNonUIRequests$lambda-26 */
    public static final Optional m1529observeNonUIRequests$lambda26(HostRequest it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(it);
    }

    /* renamed from: observeNonUIRequests$lambda-27 */
    public static final Optional m1530observeNonUIRequests$lambda27(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(null);
    }

    /* renamed from: observeNonUIRequests$lambda-28 */
    public static final void m1531observeNonUIRequests$lambda28(WalletLinkRepository this$0, HostRequest hostRequest) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        if (hostRequest instanceof HostRequest.SubmitSignedTx) {
            HostRequestId hostRequestId = hostRequest.getHostRequestId();
            HostRequest.SubmitSignedTx submitSignedTx = (HostRequest.SubmitSignedTx) hostRequest;
            this$0.submitEthereumTx(hostRequestId, submitSignedTx.getSignedTx(), submitSignedTx.getChainId());
        } else if (hostRequest instanceof HostRequest.ChildRequestEthereumAccounts) {
            HostRequestId hostRequestId2 = hostRequest.getHostRequestId();
            HostRequest.ChildRequestEthereumAccounts childRequestEthereumAccounts = (HostRequest.ChildRequestEthereumAccounts) hostRequest;
            this$0.connectChild(hostRequestId2, childRequestEthereumAccounts.getChildSessionId(), childRequestEthereumAccounts.getChildSessionSecret(), childRequestEthereumAccounts.getVersion());
        }
    }

    public static /* synthetic */ void p(WalletLinkRepository walletLinkRepository, WalletLinkPushNotification walletLinkPushNotification) {
        m1533start$lambda11(walletLinkRepository, walletLinkPushNotification);
    }

    public static /* synthetic */ Optional q(Throwable th) {
        return m1530observeNonUIRequests$lambda27(th);
    }

    public static /* synthetic */ Optional r(HostRequestId hostRequestId) {
        return m1515connect$lambda4$lambda3(hostRequestId);
    }

    public static /* synthetic */ h0 s(WalletLinkRepository walletLinkRepository, HostRequestId hostRequestId, byte[] bArr) {
        return m1536submitEthereumTx$lambda15(walletLinkRepository, hostRequestId, bArr);
    }

    /* renamed from: start$lambda-10 */
    public static final void m1532start$lambda10(WalletLinkRepository this$0, kotlin.o oVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        User user = (User) oVar.a();
        ConcurrentHashMap<ClientMetadataKey, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(ClientMetadataKey.EthereumAddress, ((Wallet) oVar.b()).getPrimaryAddress());
        concurrentHashMap.put(ClientMetadataKey.WalletUsername, user.getUsername());
        this$0.walletLink.connect(String.valueOf(user.getId()), concurrentHashMap);
        this$0.observeEthereumAddressChanges();
        this$0.observeNonUIRequests();
        this$0.observeNetworkChanges();
    }

    /* renamed from: start$lambda-11 */
    public static final void m1533start$lambda11(WalletLinkRepository this$0, WalletLinkPushNotification it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.f(it, "it");
        this$0.handlePushNotification(it);
    }

    private final h.c.k0.b submitEthereumTx(final HostRequestId hostRequestId, final byte[] bArr, final int i2) {
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0<ParsedEthereumTransaction> parseSignedEthereumTransaction = this.cipherCore.parseSignedEthereumTransaction(bArr);
        h.c.s<List<Address>> ethAddressesObservable = this.ethAddressesObservable;
        kotlin.jvm.internal.m.f(ethAddressesObservable, "ethAddressesObservable");
        h.c.k0.b subscribe = eVar.b(parseSignedEthereumTransaction, Observable_CoreKt.takeSingle(ethAddressesObservable), Observable_CoreKt.takeSingle(this.walletRepository.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)))).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.x
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.x(i2, bArr, this, (kotlin.t) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.s(WalletLinkRepository.this, hostRequestId, (byte[]) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.walletlink.repositories.t
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                WalletLinkRepository.t(WalletLinkRepository.this, hostRequestId, (Throwable) obj);
            }
        }).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "Singles\n        .zip(\n            cipherCore.parseSignedEthereumTransaction(signedTx),\n            ethAddressesObservable.takeSingle(),\n            walletRepository.observeNetwork(Blockchain.ETHEREUM).takeSingle()\n        )\n        .flatMap { (parsedTx, addresses, currentNetwork) ->\n            val currentChainId = currentNetwork.asChainId()\n            if (parsedTx.chainId == 0 || currentChainId != parsedTx.chainId || chainId != currentChainId) {\n                throw WalletLinkException.ChainIdMismatch\n            }\n\n            val shouldResubmit = addresses.any { it.address == parsedTx.fromAddress }\n\n            val tx = EthereumSignedTx(\n                id = UUID.randomUUID().toString(),\n                fromAddress = parsedTx.fromAddress,\n                toAddress = parsedTx.toAddress,\n                nonce = parsedTx.nonce,\n                chainId = parsedTx.chainId,\n                signedTxData = signedTx,\n                txHash = parsedTx.hash.toHexEncodedString(),\n                weiValue = parsedTx.weiValue,\n                state = TxState.PENDING,\n                blockchain = Blockchain.ETHEREUM,\n                currencyCode = CurrencyCode.ETH,\n                erc20Value = null,\n                notFoundCount = 0\n            )\n\n            ethTxRepository.submitTx(tx = tx, shouldResubmit = shouldResubmit)\n                .map { parsedTx.hash }\n        }\n        .flatMap { approve(requestId, it) }\n        .doOnError { reject(requestId) }\n        .subscribe()");
        return h.c.t0.a.a(subscribe, this.disposeBag);
    }

    /* renamed from: submitEthereumTx$lambda-14 */
    public static final h0 m1534submitEthereumTx$lambda14(int i2, byte[] signedTx, WalletLinkRepository this$0, kotlin.t dstr$parsedTx$addresses$currentNetwork) {
        boolean z;
        kotlin.jvm.internal.m.g(signedTx, "$signedTx");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$parsedTx$addresses$currentNetwork, "$dstr$parsedTx$addresses$currentNetwork");
        final ParsedEthereumTransaction parsedEthereumTransaction = (ParsedEthereumTransaction) dstr$parsedTx$addresses$currentNetwork.a();
        List<Address> addresses = (List) dstr$parsedTx$addresses$currentNetwork.b();
        Network currentNetwork = (Network) dstr$parsedTx$addresses$currentNetwork.c();
        kotlin.jvm.internal.m.f(currentNetwork, "currentNetwork");
        int asChainId = Network_ApplicationKt.asChainId(currentNetwork);
        if (parsedEthereumTransaction.getChainId() != 0 && asChainId == parsedEthereumTransaction.getChainId() && i2 == asChainId) {
            kotlin.jvm.internal.m.f(addresses, "addresses");
            if (!(addresses instanceof Collection) || !addresses.isEmpty()) {
                for (Address address : addresses) {
                    if (kotlin.jvm.internal.m.c(address.getAddress(), parsedEthereumTransaction.getFromAddress())) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            String uuid = UUID.randomUUID().toString();
            String fromAddress = parsedEthereumTransaction.getFromAddress();
            String toAddress = parsedEthereumTransaction.getToAddress();
            int nonce = parsedEthereumTransaction.getNonce();
            int chainId = parsedEthereumTransaction.getChainId();
            String hexEncodedString$default = ByteArray_CipherCoreKt.toHexEncodedString$default(parsedEthereumTransaction.getHash(), false, 1, null);
            BigInteger weiValue = parsedEthereumTransaction.getWeiValue();
            TxState txState = TxState.PENDING;
            Blockchain ethereum = Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion);
            CurrencyCode eth = CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion);
            kotlin.jvm.internal.m.f(uuid, "toString()");
            return IETHTxRepository.DefaultImpls.submitTx$default(this$0.ethTxRepository, new EthereumSignedTx(uuid, fromAddress, toAddress, nonce, chainId, signedTx, hexEncodedString$default, weiValue, null, ethereum, eth, txState, 0), null, z, 2, null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.c
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return WalletLinkRepository.d(ParsedEthereumTransaction.this, (EthereumSignedTx) obj);
                }
            });
        }
        throw WalletLinkException.ChainIdMismatch.INSTANCE;
    }

    /* renamed from: submitEthereumTx$lambda-14$lambda-13 */
    public static final byte[] m1535submitEthereumTx$lambda14$lambda13(ParsedEthereumTransaction parsedEthereumTransaction, EthereumSignedTx it) {
        kotlin.jvm.internal.m.g(it, "it");
        return parsedEthereumTransaction.getHash();
    }

    /* renamed from: submitEthereumTx$lambda-15 */
    public static final h0 m1536submitEthereumTx$lambda15(WalletLinkRepository this$0, HostRequestId requestId, byte[] it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(requestId, "$requestId");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.approve(requestId, it);
    }

    /* renamed from: submitEthereumTx$lambda-16 */
    public static final void m1537submitEthereumTx$lambda16(WalletLinkRepository this$0, HostRequestId requestId, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(requestId, "$requestId");
        this$0.reject(requestId);
    }

    public static /* synthetic */ void t(WalletLinkRepository walletLinkRepository, HostRequestId hostRequestId, Throwable th) {
        m1537submitEthereumTx$lambda16(walletLinkRepository, hostRequestId, th);
    }

    public final Optional<kotlin.o<String, String>> titleAndBodyFor(HostRequest hostRequest) {
        String displayName;
        Object dappName = hostRequest.getDappName();
        if (dappName == null && (dappName = hostRequest.getDappUrl().getHost()) == null) {
            dappName = hostRequest.getDappUrl();
        }
        kotlin.o oVar = null;
        if (hostRequest instanceof HostRequest.SwitchEthereumChain) {
            EthereumChain fromChainId = EthereumChain.Companion.fromChainId(((HostRequest.SwitchEthereumChain) hostRequest).getChainId());
            String str = "";
            if (fromChainId != null && (displayName = fromChainId.getDisplayName()) != null) {
                str = displayName;
            }
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            oVar = kotlin.u.a(localizedStrings.get(R.string.message_switch_title), localizedStrings.get(R.string.message_switch_body, str));
        } else if (hostRequest instanceof HostRequest.SignMessage) {
            LocalizedStrings localizedStrings2 = LocalizedStrings.INSTANCE;
            oVar = kotlin.u.a(localizedStrings2.get(R.string.notification_title_sign_message), localizedStrings2.get(R.string.notification_body_sign_message, dappName));
        } else if (hostRequest instanceof HostRequest.SignAndSubmitTx) {
            LocalizedStrings localizedStrings3 = LocalizedStrings.INSTANCE;
            oVar = kotlin.u.a(localizedStrings3.get(R.string.notification_title_sign_and_submit_tx), localizedStrings3.get(R.string.notification_body_sign_and_submit_tx, dappName));
        } else if (hostRequest instanceof HostRequest.SubmitSignedTx) {
            LocalizedStrings localizedStrings4 = LocalizedStrings.INSTANCE;
            oVar = kotlin.u.a(localizedStrings4.get(R.string.notification_title_submit_tx), localizedStrings4.get(R.string.notification_body_submit_tx, dappName));
        } else if (hostRequest instanceof HostRequest.RequestEthereumAccounts) {
            LocalizedStrings localizedStrings5 = LocalizedStrings.INSTANCE;
            oVar = kotlin.u.a(localizedStrings5.get(R.string.notification_title_dapp_permission), localizedStrings5.get(R.string.notification_body_dapp_permission, dappName));
        } else if (!(hostRequest instanceof HostRequest.RequestCanceled) && !(hostRequest instanceof HostRequest.ChildRequestEthereumAccounts)) {
            throw new NoWhenBranchMatchedException();
        }
        return OptionalKt.toOptional(oVar);
    }

    public static /* synthetic */ Wallet u(kotlin.o oVar) {
        return m1525observeEthereumAddressChanges$lambda21(oVar);
    }

    public static /* synthetic */ Optional v(Throwable th) {
        return m1520createRequestsObservable$lambda31(th);
    }

    public static /* synthetic */ h0 w(WalletLinkRepository walletLinkRepository, WalletLinkSessionKey walletLinkSessionKey, Throwable th) {
        return m1514connect$lambda4$lambda2(walletLinkRepository, walletLinkSessionKey, th);
    }

    public static /* synthetic */ h0 x(int i2, byte[] bArr, WalletLinkRepository walletLinkRepository, kotlin.t tVar) {
        return m1534submitEthereumTx$lambda14(i2, bArr, walletLinkRepository, tVar);
    }

    public static /* synthetic */ void y(WalletLinkRepository walletLinkRepository, kotlin.o oVar) {
        m1532start$lambda10(walletLinkRepository, oVar);
    }

    public static /* synthetic */ Optional z(HostRequest hostRequest) {
        return m1519createRequestsObservable$lambda30$lambda29(hostRequest);
    }

    public final h.c.b0<kotlin.x> approve(HostRequestId requestId, byte[] signedData) {
        kotlin.jvm.internal.m.g(requestId, "requestId");
        kotlin.jvm.internal.m.g(signedData, "signedData");
        return this.walletLink.approve(requestId, signedData);
    }

    public final h.c.b0<kotlin.x> approveDappPermission(final HostRequestId requestId) {
        kotlin.jvm.internal.m.g(requestId, "requestId");
        h.c.b0<kotlin.x> flatMap = Observable_CoreKt.takeSingle(getActiveWalletObservable()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.e(WalletLinkRepository.this, requestId, (Wallet) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "activeWalletObservable.takeSingle()\n        .flatMap { walletLink.approve(requestId, it.primaryAddress.toByteArray(Charsets.UTF_8)) }");
        return flatMap;
    }

    public final h.c.b0<Optional<HostRequestId>> connect(final String sessionId, final String secret, final URL serverUrl, final String str, final boolean z, final String str2, final String str3, final URL url, final Uri uri) {
        kotlin.jvm.internal.m.g(sessionId, "sessionId");
        kotlin.jvm.internal.m.g(secret, "secret");
        kotlin.jvm.internal.m.g(serverUrl, "serverUrl");
        final WalletLinkSessionKey walletLinkSessionKey = new WalletLinkSessionKey(sessionId, serverUrl);
        final h.c.v0.a<HostRequestId> d2 = (str == null || z) ? null : h.c.v0.a.d();
        if (d2 != null) {
            this.newConnectionCallbacks.set(walletLinkSessionKey, d2);
        } else {
            this.newConnectionCallbacks.remove(walletLinkSessionKey);
        }
        h.c.b0<Optional<HostRequestId>> onErrorResumeNext = h.c.t0.e.a.a(Observable_CoreKt.takeSingle(getActiveUserObservable()), Observable_CoreKt.takeSingle(getActiveWalletObservable())).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.j(WalletLinkRepository.this, sessionId, secret, str, z, str2, str3, url, uri, serverUrl, (kotlin.o) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.h(h.c.v0.a.this, this, walletLinkSessionKey, (kotlin.x) obj);
            }
        }).observeOn(h.c.j0.c.a.b()).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository.f(WalletLinkRepository.this, walletLinkSessionKey, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "Singles\n            .zip(\n                activeUserObservable.takeSingle(),\n                activeWalletObservable.takeSingle()\n            )\n            .flatMap { (user, wallet) ->\n                val metadata = ConcurrentHashMap<ClientMetadataKey, String>()\n                metadata[ClientMetadataKey.EthereumAddress] = wallet.primaryAddress\n                metadata[ClientMetadataKey.WalletUsername] = user.username\n\n                walletLink.link(\n                    sessionId = sessionId,\n                    secret = secret,\n                    url = serverUrl,\n                    isParent = isParent,\n                    parentSessionId = parentSessionId,\n                    dappName = dappName,\n                    dappImageURL = dappImageURL,\n                    dappURL = dappURL,\n                    userId = user.id.toString(),\n                    metadata = metadata,\n                    version = version\n                )\n            }\n            .flatMap {\n                if (callback == null) return@flatMap Single.just(null.toOptional())\n\n                callback.takeSingle()\n                    .timeout(15, TimeUnit.SECONDS)\n                    .onErrorResumeNext {\n                        newConnectionCallbacks.remove(key)\n                        Single.error(it)\n                    }\n                    .map { it.toOptional() }\n            }\n            .observeOn(AndroidSchedulers.mainThread())\n            .onErrorResumeNext {\n                newConnectionCallbacks.remove(key)\n                Single.error(it)\n            }");
        return onErrorResumeNext;
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public h.c.b0<Boolean> destroy() {
        this.walletLink.disconnect();
        this.disposeBag.d();
        h.c.b0<Boolean> just = h.c.b0.just(Boolean.TRUE);
        kotlin.jvm.internal.m.f(just, "just(true)");
        return just;
    }

    public final h.c.b0<kotlin.x> disconnect() {
        return disconnect(this.walletLink.sessions());
    }

    public final h.c.s<HostRequestId> getChildConnectedObservable() {
        return this.childConnectedObservable;
    }

    public final h.c.s<HostRequest> getRequestsObservable() {
        return this.requestsObservable;
    }

    public final List<Session> getSessions() {
        return this.walletLink.sessions();
    }

    public final h.c.s<List<Session>> getSessionsObservable() {
        return this.sessionsObservable;
    }

    public final h.c.b0<kotlin.x> markAsSeen(List<HostRequestId> requestIds) {
        kotlin.jvm.internal.m.g(requestIds, "requestIds");
        return this.walletLink.markAsSeen(requestIds);
    }

    public final h.c.b0<kotlin.x> reject(HostRequestId requestId) {
        kotlin.jvm.internal.m.g(requestId, "requestId");
        return this.walletLink.reject(requestId);
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        h.c.k0.b subscribe = h.c.t0.e.a.a(Observable_CoreKt.takeSingle(getActiveUserObservable()), Observable_CoreKt.takeSingle(getActiveWalletObservable())).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.walletlink.repositories.y
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                WalletLinkRepository.y(WalletLinkRepository.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(subscribe, "Singles.zip(activeUserObservable.takeSingle(), activeWalletObservable.takeSingle())\n            .subscribe { (user, wallet) ->\n                val metadata = ConcurrentHashMap<ClientMetadataKey, String>()\n                metadata[ClientMetadataKey.EthereumAddress] = wallet.primaryAddress\n                metadata[ClientMetadataKey.WalletUsername] = user.username\n                walletLink.connect(user.id.toString(), metadata)\n\n                observeEthereumAddressChanges()\n                observeNonUIRequests()\n                observeNetworkChanges()\n            }");
        h.c.t0.a.a(subscribe, this.disposeBag);
        h.c.k0.b subscribe2 = this.pushNotificationRepository.observeNotificationsWith(this.notificationCreator).subscribeOn(h.c.u0.a.c()).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.walletlink.repositories.o
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                WalletLinkRepository.p(WalletLinkRepository.this, (WalletLinkPushNotification) obj);
            }
        });
        kotlin.jvm.internal.m.f(subscribe2, "pushNotificationRepository.observeNotificationsWith(notificationCreator)\n            .subscribeOn(Schedulers.io())\n            .subscribe { handlePushNotification(it) }");
        h.c.t0.a.a(subscribe2, this.disposeBag);
    }

    public final h.c.b0<kotlin.x> disconnect(List<Session> sessions) {
        int r;
        List u;
        Set<Session> N0;
        int r2;
        h.c.b0 zip;
        List g2;
        Collection g3;
        kotlin.jvm.internal.m.g(sessions, "sessions");
        r = kotlin.a0.s.r(sessions, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Session session : sessions) {
            if (kotlin.jvm.internal.m.c(session.isParent(), Boolean.TRUE)) {
                List<Session> sessions2 = getSessions();
                g3 = new ArrayList();
                for (Object obj : sessions2) {
                    if (kotlin.jvm.internal.m.c(((Session) obj).getParentSessionId(), session.getId())) {
                        g3.add(obj);
                    }
                }
            } else {
                g3 = kotlin.a0.r.g();
            }
            arrayList.add(g3);
        }
        u = kotlin.a0.s.u(arrayList);
        N0 = kotlin.a0.z.N0(sessions, u);
        r2 = kotlin.a0.s.r(N0, 10);
        ArrayList arrayList2 = new ArrayList(r2);
        for (Session session2 : N0) {
            arrayList2.add(Single_CoreKt.retryIfNeeded(this.walletLink.unlink(session2), 2, WalletLinkRepository$disconnect$1$1.INSTANCE));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList2.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList2, new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository$disconnect$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g4;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g4 = kotlin.a0.r.g();
                        return g4;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj2 : it) {
                        if (obj2 instanceof kotlin.x) {
                            arrayList3.add(obj2);
                        }
                    }
                    return arrayList3;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return Single_CoreKt.asUnit(Single_AnalyticsKt.logError$default(zip, null, null, 3, null));
    }
}