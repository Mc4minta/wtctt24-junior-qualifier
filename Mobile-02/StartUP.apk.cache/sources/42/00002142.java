package com.coinbase.wallet.features.signer.viewmodel;

import android.net.Uri;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.KeyPair;
import com.coinbase.ciphercore.String_CipherCoreKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.authentication.AppLockType;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.core.extensions.ByteArray_CoreKt;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.networking.extensions.CipherCore_EthereumExtensionsKt;
import com.coinbase.wallet.features.signer.interfaces.StackedRequestItem;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletlink.models.HostRequestId;
import h.c.b0;
import h.c.h0;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: MessageSignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b8\u00109J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\u0011\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u00038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fRR\u0010$\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\" #*\n\u0012\u0004\u0012\u00020\"\u0018\u00010!0! #*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\" #*\n\u0012\u0004\u0012\u00020\"\u0018\u00010!0!\u0018\u00010 0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0015\u0010)\u001a\u0004\u0018\u00010&8F@\u0006¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00028\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u0006:"}, d2 = {"Lcom/coinbase/wallet/features/signer/viewmodel/MessageSignerViewModel;", "Lcom/coinbase/wallet/features/signer/interfaces/StackedRequestItem;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignMessageViewState;", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lkotlin/x;", "sign", "(Ljava/lang/String;)V", "approve", "()V", "reject", "onCleared", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "getReadableMessage", "()Ljava/lang/String;", "readableMessage", "Landroid/net/Uri;", "getRequestUrl", "()Landroid/net/Uri;", "requestUrl", "typedDataMessage$delegate", "Lkotlin/h;", "getTypedDataMessage", "typedDataMessage", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "walletLinkRepository", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "ethWalletRepository", "Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "Lh/c/s;", "", "Lcom/coinbase/wallet/blockchains/models/Address;", "kotlin.jvm.PlatformType", "ethAddressesObservable", "Lh/c/s;", "Ljava/net/URL;", "getDappImageUrl", "()Ljava/net/URL;", "dappImageUrl", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "viewState", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignMessageViewState;", "getViewState", "()Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignMessageViewState;", "setViewState", "(Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignMessageViewState;)V", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "authenticationHelper", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "<init>", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MessageSignerViewModel extends StackedRequestItem<SignatureRequestViewState.SignMessageViewState> {
    private final AuthenticationHelper authenticationHelper;
    private final CipherCoreInterface cipherCore;
    private final h.c.k0.a disposeBag;
    private final h.c.s<List<Address>> ethAddressesObservable;
    private final IETHWalletRepository ethWalletRepository;
    private final kotlin.h typedDataMessage$delegate;
    public SignatureRequestViewState.SignMessageViewState viewState;
    private final WalletLinkRepository walletLinkRepository;

    public MessageSignerViewModel(CipherCoreInterface cipherCore, IETHWalletRepository ethWalletRepository, IWalletRepository walletRepository, WalletLinkRepository walletLinkRepository, AuthenticationHelper authenticationHelper) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(ethWalletRepository, "ethWalletRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(walletLinkRepository, "walletLinkRepository");
        kotlin.jvm.internal.m.g(authenticationHelper, "authenticationHelper");
        this.cipherCore = cipherCore;
        this.ethWalletRepository = ethWalletRepository;
        this.walletLinkRepository = walletLinkRepository;
        this.authenticationHelper = authenticationHelper;
        this.disposeBag = new h.c.k0.a();
        b2 = kotlin.k.b(new MessageSignerViewModel$typedDataMessage$2(this));
        this.typedDataMessage$delegate = b2;
        this.ethAddressesObservable = walletRepository.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return MessageSignerViewModel.b(MessageSignerViewModel.this, (Network) obj);
            }
        });
    }

    public static /* synthetic */ h0 a(MessageSignerViewModel messageSignerViewModel, byte[] bArr) {
        return m1428sign$lambda5(messageSignerViewModel, bArr);
    }

    public static /* synthetic */ h0 b(MessageSignerViewModel messageSignerViewModel, Network network) {
        return m1425ethAddressesObservable$lambda0(messageSignerViewModel, network);
    }

    public static /* synthetic */ h0 c(MessageSignerViewModel messageSignerViewModel, String str, List list) {
        return m1426sign$lambda2(messageSignerViewModel, str, list);
    }

    public static /* synthetic */ h0 d(MessageSignerViewModel messageSignerViewModel, KeyPair keyPair) {
        return m1427sign$lambda3(messageSignerViewModel, keyPair);
    }

    public static /* synthetic */ byte[] e(byte[] bArr, x xVar) {
        return m1429sign$lambda5$lambda4(bArr, xVar);
    }

    /* renamed from: ethAddressesObservable$lambda-0 */
    public static final h0 m1425ethAddressesObservable$lambda0(MessageSignerViewModel this$0, Network it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.ethWalletRepository.getAddresses(it);
    }

    private final String getTypedDataMessage() {
        return (String) this.typedDataMessage$delegate.getValue();
    }

    public final void sign(final String str) {
        getSignatureRequestEventSubject().onNext(new SigningSessionEvent.Signing(getViewState().getUuid()));
        h.c.s<List<Address>> ethAddressesObservable = this.ethAddressesObservable;
        kotlin.jvm.internal.m.f(ethAddressesObservable, "ethAddressesObservable");
        b0 flatMap = Observable_CoreKt.takeSingle(ethAddressesObservable).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return MessageSignerViewModel.c(MessageSignerViewModel.this, str, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return MessageSignerViewModel.d(MessageSignerViewModel.this, (KeyPair) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return MessageSignerViewModel.a(MessageSignerViewModel.this, (byte[]) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "ethAddressesObservable\n            .takeSingle()\n            .flatMap { addresses ->\n                val address = addresses.first { it.address.toLowerCase() == viewState.address.toLowerCase() }\n\n                cipherCore.getEthereumWalletKeyPair(address.index, mnemonic)\n            }\n\n            // Get specified address keyPair and signature request from server\n            .flatMap { keyPair ->\n                val message = viewState.message.toByteArrayUsingHexEncoding()\n                    ?: throw IllegalStateException(\"Unable to sign message\")\n\n                cipherCore.signEthereumMessage(message, keyPair.privateKey, viewState.isPrefixed)\n            }\n\n            // Sign data and send to WalletLink server if needed\n            .flatMap { signedData ->\n                val requestId = viewState.hostRequestId ?: return@flatMap Single.just(signedData)\n                walletLinkRepository.approve(requestId, signedData).map { signedData }\n            }");
        h.c.t0.a.a(h.c.t0.g.f(Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null), new MessageSignerViewModel$sign$4(this), new MessageSignerViewModel$sign$5(this)), this.disposeBag);
    }

    /* renamed from: sign$lambda-2 */
    public static final h0 m1426sign$lambda2(MessageSignerViewModel this$0, String mnemonic, List addresses) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(mnemonic, "$mnemonic");
        kotlin.jvm.internal.m.g(addresses, "addresses");
        Iterator it = addresses.iterator();
        while (it.hasNext()) {
            Address address = (Address) it.next();
            String address2 = address.getAddress();
            Objects.requireNonNull(address2, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = address2.toLowerCase();
            kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase()");
            String address3 = this$0.getViewState().getAddress();
            Objects.requireNonNull(address3, "null cannot be cast to non-null type java.lang.String");
            String lowerCase2 = address3.toLowerCase();
            kotlin.jvm.internal.m.f(lowerCase2, "(this as java.lang.String).toLowerCase()");
            if (kotlin.jvm.internal.m.c(lowerCase, lowerCase2)) {
                return CipherCore_EthereumExtensionsKt.getEthereumWalletKeyPair(this$0.cipherCore, address.getIndex(), mnemonic);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* renamed from: sign$lambda-3 */
    public static final h0 m1427sign$lambda3(MessageSignerViewModel this$0, KeyPair keyPair) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(keyPair, "keyPair");
        byte[] byteArrayUsingHexEncoding = String_CipherCoreKt.toByteArrayUsingHexEncoding(this$0.getViewState().getMessage());
        if (byteArrayUsingHexEncoding != null) {
            return this$0.cipherCore.signEthereumMessage(byteArrayUsingHexEncoding, keyPair.getPrivateKey(), this$0.getViewState().isPrefixed());
        }
        throw new IllegalStateException("Unable to sign message");
    }

    /* renamed from: sign$lambda-5 */
    public static final h0 m1428sign$lambda5(MessageSignerViewModel this$0, final byte[] signedData) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(signedData, "signedData");
        HostRequestId hostRequestId = this$0.getViewState().getHostRequestId();
        return hostRequestId == null ? b0.just(signedData) : this$0.walletLinkRepository.approve(hostRequestId, signedData).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return MessageSignerViewModel.e(signedData, (x) obj);
            }
        });
    }

    /* renamed from: sign$lambda-5$lambda-4 */
    public static final byte[] m1429sign$lambda5$lambda4(byte[] signedData, x it) {
        kotlin.jvm.internal.m.g(signedData, "$signedData");
        kotlin.jvm.internal.m.g(it, "it");
        return signedData;
    }

    public final void approve() {
        h.c.t0.a.a(h.c.t0.g.i(Single_AnalyticsKt.logError$default(this.authenticationHelper.unlock(AppLockType.Transactions.INSTANCE), null, null, 3, null), null, new MessageSignerViewModel$approve$1(this), 1, null), this.disposeBag);
    }

    public final URL getDappImageUrl() {
        HostRequestId hostRequestId = getViewState().getHostRequestId();
        if (hostRequestId == null) {
            return null;
        }
        return hostRequestId.getDappImageURL();
    }

    public final String getReadableMessage() {
        String typedDataMessage = getTypedDataMessage();
        if (typedDataMessage == null) {
            byte[] asHexEncodedData = String_CoreKt.asHexEncodedData(getViewState().getMessage());
            String asUTF8String = asHexEncodedData == null ? null : ByteArray_CoreKt.getAsUTF8String(asHexEncodedData);
            return asUTF8String == null ? getViewState().getMessage() : asUTF8String;
        }
        return typedDataMessage;
    }

    public final Uri getRequestUrl() {
        HostRequestId hostRequestId = getViewState().getHostRequestId();
        if (hostRequestId == null) {
            return null;
        }
        return hostRequestId.getDappURL();
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void reject() {
        HostRequestId hostRequestId = getViewState().getHostRequestId();
        if (hostRequestId == null) {
            getSignatureRequestEventSubject().onNext(new SigningSessionEvent.Cancelled(getViewState().getUuid()));
            return;
        }
        getSignatureRequestEventSubject().onNext(new SigningSessionEvent.Signing(getViewState().getUuid()));
        h.c.t0.a.a(h.c.t0.g.f(Single_AnalyticsKt.logError$default(this.walletLinkRepository.reject(hostRequestId), null, null, 3, null), new MessageSignerViewModel$reject$1(this), new MessageSignerViewModel$reject$2(this)), this.disposeBag);
    }

    @Override // com.coinbase.wallet.features.signer.interfaces.StackedRequestItem
    public SignatureRequestViewState.SignMessageViewState getViewState() {
        SignatureRequestViewState.SignMessageViewState signMessageViewState = this.viewState;
        if (signMessageViewState != null) {
            return signMessageViewState;
        }
        kotlin.jvm.internal.m.w("viewState");
        throw null;
    }

    @Override // com.coinbase.wallet.features.signer.interfaces.StackedRequestItem
    public void setViewState(SignatureRequestViewState.SignMessageViewState signMessageViewState) {
        kotlin.jvm.internal.m.g(signMessageViewState, "<set-?>");
        this.viewState = signMessageViewState;
    }
}