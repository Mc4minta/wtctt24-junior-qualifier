package com.coinbase.wallet.features.signer.viewmodel;

import android.net.Uri;
import androidx.lifecycle.b0;
import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.signer.exceptions.SignerViewException;
import com.coinbase.wallet.features.signer.models.SignatureRequest;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import com.coinbase.wallet.features.walletlink.extensions.HostRequest_WalletLinkKt;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotificationCreator;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.walletlink.models.HostRequest;
import com.coinbase.walletlink.models.HostRequestId;
import h.c.x;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: SignerViewModel.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010R\u001a\u00020Q¢\u0006\u0004\bg\u0010hJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004JO\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J5\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J5\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u009b\u0001\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u001d2\b\u0010#\u001a\u0004\u0018\u00010\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u001d2\b\u0010%\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+H\u0007¢\u0006\u0004\b-\u0010.J\u0015\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u001b\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH\u0007¢\u0006\u0004\b3\u00104R$\u00107\u001a\u0010\u0012\f\u0012\n 6*\u0004\u0018\u00010\f0\f058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR=\u0010C\u001a&\u0012\f\u0012\n 6*\u0004\u0018\u00010/0/ 6*\u0012\u0012\f\u0012\n 6*\u0004\u0018\u00010/0/\u0018\u00010B0B8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR=\u0010G\u001a&\u0012\f\u0012\n 6*\u0004\u0018\u00010\f0\f 6*\u0012\u0012\f\u0012\n 6*\u0004\u0018\u00010\f0\f\u0018\u00010B0B8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010D\u001a\u0004\bH\u0010FR(\u0010J\u001a\u0004\u0018\u00010+2\b\u0010I\u001a\u0004\u0018\u00010+8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR$\u0010T\u001a\u0010\u0012\f\u0012\n 6*\u0004\u0018\u00010/0/058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u00108R$\u0010V\u001a\u0010\u0012\f\u0012\n 6*\u0004\u0018\u00010\f0\f0U8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020+0X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010\\\u001a\u00020[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0013\u0010`\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010d\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR=\u0010f\u001a&\u0012\f\u0012\n 6*\u0004\u0018\u00010\f0\f 6*\u0012\u0012\f\u0012\n 6*\u0004\u0018\u00010\f0\f\u0018\u00010B0B8\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010D\u001a\u0004\bf\u0010F¨\u0006i"}, d2 = {"Lcom/coinbase/wallet/features/signer/viewmodel/SignerViewModel;", "Landroidx/lifecycle/b0;", "Lkotlin/x;", "observeWalletLinkRequests", "()V", "observePushNotifications", "", "uuid", "Lcom/coinbase/walletlink/models/HostRequestId;", "requestId", "address", ApiConstants.MESSAGE, "", "isPrefixed", "typedDataJson", "Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "processSignMessageRequest", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lh/c/b0;", "isParent", "processDappPermissionRequest", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;Z)Lh/c/b0;", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "processSwitchEthereumChainRequest", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;I)Lh/c/b0;", "fromAddress", "toAddress", "Ljava/math/BigInteger;", "weiValue", "", "data", AdjustableMinerFeeArgs.NONCE, "gasPrice", "maxFeePerGas", "maxPriorityFeePerGas", "gasLimit", "shouldSubmit", "Landroid/net/Uri;", "requesterURL", "processTxSignatureRequest", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;[BLjava/lang/Integer;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;IZLandroid/net/Uri;)Lh/c/b0;", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest;", "request", "appendSignatureRequest", "(Lcom/coinbase/wallet/features/signer/models/SignatureRequest;)V", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "event", "publishEvent", "(Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;)V", "getNextSignatureRequest", "()Lh/c/b0;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "isWalletLinkRequestSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;", "pushNotificationRepository", "Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;", "Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "ethWalletRepository", "Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification;", "pushNotificationRequest", "Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification;", "Lh/c/s;", "signatureRequestEvents", "Lh/c/s;", "getSignatureRequestEvents", "()Lh/c/s;", "presentNextRequestObservable", "getPresentNextRequestObservable", "<set-?>", "currentRequest", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest;", "getCurrentRequest", "()Lcom/coinbase/wallet/features/signer/models/SignatureRequest;", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "walletLinkRepository", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "appLockRepository", "Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "signatureRequestEventsSubject", "Lh/c/v0/c;", "presentNextRequestSubject", "Lh/c/v0/c;", "", "signatureRequests", "Ljava/util/List;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "getHasPendingRequests", "()Z", "hasPendingRequests", "Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotificationCreator;", "walletLinkPushNotificationCreator", "Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotificationCreator;", "currentRequestUUID", "Ljava/lang/String;", "isWalletLinkRequestObservable", "<init>", "(Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotificationCreator;Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignerViewModel extends b0 {
    private final AppLockRepositoryInterface appLockRepository;
    private SignatureRequest currentRequest;
    private String currentRequestUUID;
    private final h.c.k0.a disposeBag;
    private final IETHWalletRepository ethWalletRepository;
    private final h.c.s<Boolean> isWalletLinkRequestObservable;
    private final h.c.v0.b<Boolean> isWalletLinkRequestSubject;
    private final h.c.s<Boolean> presentNextRequestObservable;
    private final h.c.v0.c<Boolean> presentNextRequestSubject;
    private final PushNotificationRepository pushNotificationRepository;
    private WalletLinkPushNotification pushNotificationRequest;
    private final h.c.s<SigningSessionEvent> signatureRequestEvents;
    private final h.c.v0.b<SigningSessionEvent> signatureRequestEventsSubject;
    private List<SignatureRequest> signatureRequests;
    private final WalletLinkPushNotificationCreator walletLinkPushNotificationCreator;
    private final WalletLinkRepository walletLinkRepository;

    public SignerViewModel(IETHWalletRepository ethWalletRepository, WalletLinkRepository walletLinkRepository, PushNotificationRepository pushNotificationRepository, WalletLinkPushNotificationCreator walletLinkPushNotificationCreator, AppLockRepositoryInterface appLockRepository) {
        kotlin.jvm.internal.m.g(ethWalletRepository, "ethWalletRepository");
        kotlin.jvm.internal.m.g(walletLinkRepository, "walletLinkRepository");
        kotlin.jvm.internal.m.g(pushNotificationRepository, "pushNotificationRepository");
        kotlin.jvm.internal.m.g(walletLinkPushNotificationCreator, "walletLinkPushNotificationCreator");
        kotlin.jvm.internal.m.g(appLockRepository, "appLockRepository");
        this.ethWalletRepository = ethWalletRepository;
        this.walletLinkRepository = walletLinkRepository;
        this.pushNotificationRepository = pushNotificationRepository;
        this.walletLinkPushNotificationCreator = walletLinkPushNotificationCreator;
        this.appLockRepository = appLockRepository;
        this.disposeBag = new h.c.k0.a();
        h.c.v0.c<Boolean> d2 = h.c.v0.c.d(1);
        kotlin.jvm.internal.m.f(d2, "createWithSize<Boolean>(1)");
        this.presentNextRequestSubject = d2;
        h.c.v0.b<SigningSessionEvent> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<SigningSessionEvent>()");
        this.signatureRequestEventsSubject = d3;
        h.c.v0.b<Boolean> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<Boolean>()");
        this.isWalletLinkRequestSubject = d4;
        this.signatureRequests = new ArrayList();
        this.signatureRequestEvents = d3.hide();
        this.presentNextRequestObservable = d2.hide().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SignerViewModel.d(SignerViewModel.this, (Boolean) obj);
            }
        });
        this.isWalletLinkRequestObservable = d4.hide();
        observePushNotifications();
        observeWalletLinkRequests();
    }

    public static /* synthetic */ Boolean a(Boolean bool, Boolean bool2) {
        return m1435presentNextRequestObservable$lambda2$lambda1(bool, bool2);
    }

    public static /* synthetic */ Optional b(Throwable th) {
        return m1432observeWalletLinkRequests$lambda11(th);
    }

    public static /* synthetic */ Optional c(int i2, String str, HostRequestId hostRequestId, String str2, String str3, BigInteger bigInteger, byte[] bArr, Integer num, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, boolean z, Uri uri, Optional optional) {
        return m1437processTxSignatureRequest$lambda13(i2, str, hostRequestId, str2, str3, bigInteger, bArr, num, bigInteger2, bigInteger3, bigInteger4, bigInteger5, z, uri, optional);
    }

    public static /* synthetic */ x d(SignerViewModel signerViewModel, Boolean bool) {
        return m1433presentNextRequestObservable$lambda2(signerViewModel, bool);
    }

    public static /* synthetic */ Optional e(String str, HostRequestId hostRequestId, String str2, String str3, boolean z, String str4, Optional optional) {
        return m1436processSignMessageRequest$lambda12(str, hostRequestId, str2, str3, z, str4, optional);
    }

    public static /* synthetic */ boolean f(Boolean bool) {
        return m1434presentNextRequestObservable$lambda2$lambda0(bool);
    }

    public static /* synthetic */ Optional g(HostRequest hostRequest) {
        return m1431observeWalletLinkRequests$lambda10(hostRequest);
    }

    private final void observePushNotifications() {
        h.c.s observeOn = this.pushNotificationRepository.observeSelectedNotificationsWith(this.walletLinkPushNotificationCreator).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "pushNotificationRepository\n            .observeSelectedNotificationsWith(walletLinkPushNotificationCreator)\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(observeOn, null, null, new SignerViewModel$observePushNotifications$1(this), 3, null), this.disposeBag);
    }

    private final void observeWalletLinkRequests() {
        h.c.s onErrorReturn = this.walletLinkRepository.getRequestsObservable().observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SignerViewModel.g((HostRequest) obj);
            }
        }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SignerViewModel.b((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "walletLinkRepository.requestsObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { Optional(it.asSignatureRequest()) }\n            .onErrorReturn { Optional(null) }");
        h.c.s map = onErrorReturn.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.signer.viewmodel.SignerViewModel$observeWalletLinkRequests$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.SignerViewModel$observeWalletLinkRequests$$inlined$unwrap$2
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
        h.c.t0.a.a(h.c.t0.g.h(Observable_AnalyticsKt.logError$default(map, "Error getting requests", null, 2, null), null, null, new SignerViewModel$observeWalletLinkRequests$3(this), 3, null), this.disposeBag);
    }

    /* renamed from: observeWalletLinkRequests$lambda-10 */
    public static final Optional m1431observeWalletLinkRequests$lambda10(HostRequest it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(HostRequest_WalletLinkKt.asSignatureRequest(it));
    }

    /* renamed from: observeWalletLinkRequests$lambda-11 */
    public static final Optional m1432observeWalletLinkRequests$lambda11(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(null);
    }

    /* renamed from: presentNextRequestObservable$lambda-2 */
    public static final x m1433presentNextRequestObservable$lambda2(SignerViewModel this$0, final Boolean isForced) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(isForced, "isForced");
        return this$0.appLockRepository.isAppLockedObservable().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.signer.viewmodel.l
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return SignerViewModel.f((Boolean) obj);
            }
        }).take(1L).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SignerViewModel.a(isForced, (Boolean) obj);
            }
        });
    }

    /* renamed from: presentNextRequestObservable$lambda-2$lambda-0 */
    public static final boolean m1434presentNextRequestObservable$lambda2$lambda0(Boolean it) {
        kotlin.jvm.internal.m.g(it, "it");
        return !it.booleanValue();
    }

    /* renamed from: presentNextRequestObservable$lambda-2$lambda-1 */
    public static final Boolean m1435presentNextRequestObservable$lambda2$lambda1(Boolean isForced, Boolean it) {
        kotlin.jvm.internal.m.g(isForced, "$isForced");
        kotlin.jvm.internal.m.g(it, "it");
        return isForced;
    }

    private final h.c.b0<Optional<SignatureRequestViewState>> processDappPermissionRequest(String str, HostRequestId hostRequestId, boolean z) {
        if (hostRequestId == null) {
            h.c.b0<Optional<SignatureRequestViewState>> just = h.c.b0.just(new Optional(null));
            kotlin.jvm.internal.m.f(just, "just(Optional(null))");
            return just;
        }
        h.c.b0<Optional<SignatureRequestViewState>> just2 = h.c.b0.just(new Optional(new SignatureRequestViewState.RequestEthereumAccountsViewState(str, hostRequestId, z)));
        kotlin.jvm.internal.m.f(just2, "just(\n            Optional(SignatureRequestViewState.RequestEthereumAccountsViewState(uuid, localRequestId, isParent))\n        )");
        return just2;
    }

    private final h.c.b0<Optional<SignatureRequestViewState>> processSignMessageRequest(final String str, final HostRequestId hostRequestId, final String str2, final String str3, final boolean z, final String str4) {
        h.c.b0 map = this.ethWalletRepository.getWallet(str2, EthereumChain.ETHEREUM_MAINNET.getChainId()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SignerViewModel.e(str, hostRequestId, str2, str3, z, str4, (Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "ethWalletRepository\n        .getWallet(address, EthereumChain.ETHEREUM_MAINNET.chainId)\n        .map { wallet ->\n            if (wallet.toNullable() == null) {\n                Optional(null)\n            } else {\n                Optional(\n                    SignatureRequestViewState.SignMessageViewState(\n                        uuid = uuid,\n                        hostRequestId = requestId,\n                        address = address,\n                        message = message,\n                        isPrefixed = isPrefixed,\n                        typedDataJson = typedDataJson\n                    )\n                )\n            }\n        }");
        return map;
    }

    /* renamed from: processSignMessageRequest$lambda-12 */
    public static final Optional m1436processSignMessageRequest$lambda12(String uuid, HostRequestId hostRequestId, String address, String message, boolean z, String str, Optional wallet) {
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(message, "$message");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        if (wallet.toNullable() == null) {
            return new Optional(null);
        }
        return new Optional(new SignatureRequestViewState.SignMessageViewState(uuid, hostRequestId, address, message, z, str));
    }

    private final h.c.b0<Optional<SignatureRequestViewState>> processSwitchEthereumChainRequest(String str, HostRequestId hostRequestId, int i2) {
        h.c.b0<Optional<SignatureRequestViewState>> just = h.c.b0.just(new Optional(new SignatureRequestViewState.SwitchEthereumChainViewState(str, hostRequestId, i2)));
        kotlin.jvm.internal.m.f(just, "just(\n            Optional(SignatureRequestViewState.SwitchEthereumChainViewState(uuid, requestId, chainId))\n        )");
        return just;
    }

    private final h.c.b0<Optional<SignatureRequestViewState>> processTxSignatureRequest(final String str, final HostRequestId hostRequestId, final String str2, final String str3, final BigInteger bigInteger, final byte[] bArr, final Integer num, final BigInteger bigInteger2, final BigInteger bigInteger3, final BigInteger bigInteger4, final BigInteger bigInteger5, final int i2, final boolean z, final Uri uri) {
        h.c.b0 map = this.ethWalletRepository.getWallet(str2, i2).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SignerViewModel.c(i2, str, hostRequestId, str2, str3, bigInteger, bArr, num, bigInteger2, bigInteger3, bigInteger4, bigInteger5, z, uri, (Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "ethWalletRepository.getWallet(fromAddress, chainId)\n        .map { walletOptional ->\n            val wallet = walletOptional.toNullable() ?: return@map Optional(null)\n\n            val network = EthereumChain.fromChainId(chainId)?.asNetwork ?: throw SignerViewException.UnknownChainId\n\n            Optional(\n                SignatureRequestViewState.SignAndSubmitTxViewState(\n                    uuid = uuid,\n                    hostRequestId = requestId,\n                    wallet = wallet,\n                    fromAddress = fromAddress,\n                    toAddress = toAddress,\n                    weiValue = weiValue,\n                    data = data,\n                    nonce = nonce,\n                    gasPrice = gasPrice,\n                    maxFeePerGas = maxFeePerGas,\n                    maxPriorityFeePerGas = maxPriorityFeePerGas,\n                    gasLimit = gasLimit,\n                    network = network,\n                    shouldSubmit = shouldSubmit,\n                    requesterURL = requesterURL\n                )\n            )\n        }");
        return map;
    }

    /* renamed from: processTxSignatureRequest$lambda-13 */
    public static final Optional m1437processTxSignatureRequest$lambda13(int i2, String uuid, HostRequestId hostRequestId, String fromAddress, String str, BigInteger weiValue, byte[] data, Integer num, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, boolean z, Uri uri, Optional walletOptional) {
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        kotlin.jvm.internal.m.g(fromAddress, "$fromAddress");
        kotlin.jvm.internal.m.g(weiValue, "$weiValue");
        kotlin.jvm.internal.m.g(data, "$data");
        kotlin.jvm.internal.m.g(walletOptional, "walletOptional");
        Wallet wallet = (Wallet) walletOptional.toNullable();
        if (wallet == null) {
            return new Optional(null);
        }
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(i2);
        Network asNetwork = fromChainId != null ? EthereumChain_EthereumKt.getAsNetwork(fromChainId) : null;
        if (asNetwork != null) {
            return new Optional(new SignatureRequestViewState.SignAndSubmitTxViewState(uuid, hostRequestId, wallet, fromAddress, str, weiValue, data, num, bigInteger, bigInteger2, bigInteger3, bigInteger4, asNetwork, z, uri));
        }
        throw SignerViewException.UnknownChainId.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void appendSignatureRequest(com.coinbase.wallet.features.signer.models.SignatureRequest r11) {
        /*
            r10 = this;
            java.lang.String r0 = "request"
            kotlin.jvm.internal.m.g(r11, r0)
            h.c.v0.b<java.lang.Boolean> r0 = r10.isWalletLinkRequestSubject
            com.coinbase.walletlink.models.HostRequestId r1 = r11.getHostRequestId()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L11
            r1 = r3
            goto L12
        L11:
            r1 = r2
        L12:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r0.onNext(r1)
            com.coinbase.walletlink.models.HostRequestId r0 = r11.getHostRequestId()
            if (r0 != 0) goto L20
            goto L2b
        L20:
            boolean r1 = r0.isCancelation()
            r4 = 0
            if (r1 == 0) goto L28
            goto L29
        L28:
            r0 = r4
        L29:
            if (r0 != 0) goto L38
        L2b:
            java.util.List<com.coinbase.wallet.features.signer.models.SignatureRequest> r0 = r10.signatureRequests
            r0.add(r11)
            h.c.v0.c<java.lang.Boolean> r11 = r10.presentNextRequestSubject
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r11.onNext(r0)
            return
        L38:
            java.util.List<com.coinbase.wallet.features.signer.models.SignatureRequest> r11 = r10.signatureRequests
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r11 = r11.iterator()
            r5 = r2
        L44:
            boolean r6 = r11.hasNext()
            r7 = 2
            if (r6 == 0) goto L86
            java.lang.Object r6 = r11.next()
            r8 = r6
            com.coinbase.wallet.features.signer.models.SignatureRequest r8 = (com.coinbase.wallet.features.signer.models.SignatureRequest) r8
            com.coinbase.walletlink.models.HostRequestId r8 = r8.getHostRequestId()
            if (r8 != 0) goto L5a
        L58:
            r7 = r3
            goto L80
        L5a:
            boolean r9 = r0.canCancel(r8)
            if (r9 == 0) goto L58
            com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository r5 = r10.walletLinkRepository
            com.coinbase.walletlink.models.HostRequestId[] r7 = new com.coinbase.walletlink.models.HostRequestId[r7]
            r7[r2] = r0
            r7[r3] = r8
            java.util.List r7 = kotlin.a0.p.j(r7)
            h.c.b0 r5 = r5.markAsSeen(r7)
            h.c.k0.b r5 = r5.subscribe()
            java.lang.String r7 = "walletLinkRepository.markAsSeen(listOf(newRequestId, pendingRequestId))\n                        .subscribe()"
            kotlin.jvm.internal.m.f(r5, r7)
            h.c.k0.a r7 = r10.disposeBag
            h.c.t0.a.a(r5, r7)
            r7 = r2
            r5 = r3
        L80:
            if (r7 == 0) goto L44
            r1.add(r6)
            goto L44
        L86:
            r10.signatureRequests = r1
            com.coinbase.wallet.features.signer.models.SignatureRequest r11 = r10.getCurrentRequest()
            if (r11 != 0) goto L8f
            goto L9f
        L8f:
            com.coinbase.walletlink.models.HostRequestId r11 = r11.getHostRequestId()
            if (r11 != 0) goto L96
            goto L9f
        L96:
            boolean r1 = r0.canCancel(r11)
            if (r1 == 0) goto L9d
            r4 = r11
        L9d:
            if (r4 != 0) goto La1
        L9f:
            r3 = r5
            goto Lc6
        La1:
            com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository r11 = r10.walletLinkRepository
            com.coinbase.walletlink.models.HostRequestId[] r1 = new com.coinbase.walletlink.models.HostRequestId[r7]
            r1[r2] = r0
            r1[r3] = r4
            java.util.List r1 = kotlin.a0.p.j(r1)
            h.c.b0 r11 = r11.markAsSeen(r1)
            h.c.k0.b r11 = r11.subscribe()
            java.lang.String r1 = "walletLinkRepository.markAsSeen(listOf(newRequestId, currentId))\n                        .subscribe()"
            kotlin.jvm.internal.m.f(r11, r1)
            h.c.k0.a r1 = r10.disposeBag
            h.c.t0.a.a(r11, r1)
            h.c.v0.c<java.lang.Boolean> r11 = r10.presentNextRequestSubject
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r11.onNext(r1)
        Lc6:
            if (r3 != 0) goto Le0
            com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository r11 = r10.walletLinkRepository
            java.util.List r0 = kotlin.a0.p.b(r0)
            h.c.b0 r11 = r11.markAsSeen(r0)
            h.c.k0.b r11 = r11.subscribe()
            java.lang.String r0 = "walletLinkRepository.markAsSeen(listOf(newRequestId))\n                    .subscribe()"
            kotlin.jvm.internal.m.f(r11, r0)
            h.c.k0.a r0 = r10.disposeBag
            h.c.t0.a.a(r11, r0)
        Le0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.signer.viewmodel.SignerViewModel.appendSignatureRequest(com.coinbase.wallet.features.signer.models.SignatureRequest):void");
    }

    public final SignatureRequest getCurrentRequest() {
        return this.currentRequest;
    }

    public final boolean getHasPendingRequests() {
        return !this.signatureRequests.isEmpty();
    }

    public final h.c.b0<Optional<SignatureRequestViewState>> getNextSignatureRequest() {
        if (this.signatureRequests.isEmpty()) {
            this.currentRequest = null;
            h.c.b0<Optional<SignatureRequestViewState>> just = h.c.b0.just(new Optional(null));
            kotlin.jvm.internal.m.f(just, "just(Optional(null))");
            return just;
        }
        WalletLinkPushNotification walletLinkPushNotification = this.pushNotificationRequest;
        Integer firstIndex = walletLinkPushNotification == null ? null : SignerViewModelKt.firstIndex(this.signatureRequests, walletLinkPushNotification);
        SignatureRequest signatureRequest = firstIndex == null ? null : (SignatureRequest) kotlin.a0.p.b0(this.signatureRequests, firstIndex.intValue());
        if (signatureRequest != null) {
            this.signatureRequests.remove(firstIndex.intValue());
        } else {
            signatureRequest = this.signatureRequests.remove(0);
        }
        this.currentRequest = signatureRequest;
        if (signatureRequest instanceof SignatureRequest.RequestEthereumAccounts) {
            this.currentRequestUUID = signatureRequest.getUuid();
            return processDappPermissionRequest(signatureRequest.getUuid(), signatureRequest.getHostRequestId(), ((SignatureRequest.RequestEthereumAccounts) signatureRequest).isParent());
        } else if (signatureRequest instanceof SignatureRequest.SwitchEthereumChain) {
            this.currentRequestUUID = signatureRequest.getUuid();
            return processSwitchEthereumChainRequest(signatureRequest.getUuid(), signatureRequest.getHostRequestId(), ((SignatureRequest.SwitchEthereumChain) signatureRequest).getChainId());
        } else if (signatureRequest instanceof SignatureRequest.SignMessage) {
            this.currentRequestUUID = signatureRequest.getUuid();
            String uuid = signatureRequest.getUuid();
            HostRequestId hostRequestId = signatureRequest.getHostRequestId();
            SignatureRequest.SignMessage signMessage = (SignatureRequest.SignMessage) signatureRequest;
            return processSignMessageRequest(uuid, hostRequestId, signMessage.getAddress(), signMessage.getMessage(), signMessage.isPrefixed(), signMessage.getTypedDataJson());
        } else if (signatureRequest instanceof SignatureRequest.SignAndSubmitTx) {
            this.currentRequestUUID = signatureRequest.getUuid();
            String uuid2 = signatureRequest.getUuid();
            HostRequestId hostRequestId2 = signatureRequest.getHostRequestId();
            SignatureRequest.SignAndSubmitTx signAndSubmitTx = (SignatureRequest.SignAndSubmitTx) signatureRequest;
            return processTxSignatureRequest(uuid2, hostRequestId2, signAndSubmitTx.getFromAddress(), signAndSubmitTx.getToAddress(), signAndSubmitTx.getWeiValue(), signAndSubmitTx.getData(), signAndSubmitTx.getNonce(), signAndSubmitTx.getGasPriceInWei(), signAndSubmitTx.getMaxFeePerGas(), signAndSubmitTx.getMaxPriorityFeePerGas(), signAndSubmitTx.getGasLimit(), signAndSubmitTx.getChainId(), signAndSubmitTx.getShouldSubmit(), signAndSubmitTx.getRequesterUrl());
        } else if (signatureRequest instanceof SignatureRequest.RequestCanceled) {
            l.a.a.d("Invalid request type. Request cancelation is not a presentable request", new Object[0]);
            h.c.t0.e eVar = h.c.t0.e.a;
            h.c.b0<Optional<SignatureRequestViewState>> just2 = h.c.b0.just(new Optional(null));
            kotlin.jvm.internal.m.f(just2, "just(Optional(null))");
            return just2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final h.c.s<Boolean> getPresentNextRequestObservable() {
        return this.presentNextRequestObservable;
    }

    public final h.c.s<SigningSessionEvent> getSignatureRequestEvents() {
        return this.signatureRequestEvents;
    }

    public final h.c.s<Boolean> isWalletLinkRequestObservable() {
        return this.isWalletLinkRequestObservable;
    }

    public final void publishEvent(SigningSessionEvent event) {
        kotlin.jvm.internal.m.g(event, "event");
        this.signatureRequestEventsSubject.onNext(event);
    }
}