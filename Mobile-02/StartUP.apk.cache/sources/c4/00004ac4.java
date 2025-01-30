package e.j.n;

import android.app.Activity;
import android.net.Uri;
import com.coinbase.ciphercore.ByteArray_CipherCoreKt;
import com.coinbase.ciphercore.CipherCoreBridgeException;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.EthereumJSONRPCRequestResult;
import com.coinbase.ciphercore.ParsedEthereumTransaction;
import com.coinbase.cipherwebview.models.web3.call.EthereumAddressFromSignedMessageCall;
import com.coinbase.cipherwebview.models.web3.call.MakeEthereumJSONRPCRequestCall;
import com.coinbase.cipherwebview.models.web3.call.ScanQRCodeCall;
import com.coinbase.cipherwebview.models.web3.call.SignEthereumMessageCall;
import com.coinbase.cipherwebview.models.web3.call.SignEthereumTransactionCall;
import com.coinbase.cipherwebview.models.web3.call.SubmitEthereumTransactionCall;
import com.coinbase.cipherwebview.models.web3.call.SwitchEthereumChainCall;
import com.coinbase.cipherwebview.models.web3.call.Web3Call;
import com.coinbase.cipherwebview.models.web3.json.Web3CallResponse;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import com.coinbase.wallet.features.dapps.DappsException;
import com.coinbase.wallet.features.signer.models.SignatureRequest;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.signer.viewmodel.SignerViewModel;
import com.coinbase.wallet.features.wallets.extensions.legacy.Network_ApplicationKt;
import com.coinbase.wallet.routing.repositories.DeepLinkRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.toshi.model.local.room.Bookmark;
import e.j.n.c2;
import e.j.n.h2;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: DappsViewModel.kt */
/* loaded from: classes2.dex */
public final class h2 extends androidx.lifecycle.b0 {
    private final e.j.i.u1 a;

    /* renamed from: b */
    private final CipherCoreInterface f13846b;

    /* renamed from: c */
    private final DeepLinkRepository f13847c;

    /* renamed from: d */
    private final IWalletRepository f13848d;

    /* renamed from: e */
    private final IETHTxRepository f13849e;

    /* renamed from: f */
    private final SignerViewModel f13850f;

    /* renamed from: g */
    private final IETHWalletRepository f13851g;

    /* renamed from: h */
    private final h.c.k0.a f13852h;

    /* renamed from: i */
    private final h.c.v0.b<Web3CallResponse> f13853i;

    /* renamed from: j */
    private final h.c.s<List<Address>> f13854j;

    /* renamed from: k */
    private final h.c.s<String> f13855k;

    /* renamed from: l */
    private final kotlin.h f13856l;
    private final h.c.s<List<Bookmark>> m;
    private final h.c.s<Web3CallResponse> n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.s<Wallet>> {

        /* compiled from: Observable+Core.kt */
        /* renamed from: e.j.n.h2$a$a */
        /* loaded from: classes2.dex */
        public static final class C0334a<T> implements h.c.m0.p {
            public static final C0334a<T> a = new C0334a<>();

            @Override // h.c.m0.p
            /* renamed from: a */
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }
        }

        /* compiled from: Observable+Core.kt */
        /* loaded from: classes2.dex */
        public static final class b<T, R> implements h.c.m0.n {
            public static final b<T, R> a = new b<>();

            @Override // h.c.m0.n
            /* renamed from: a */
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a() {
            super(0);
            h2.this = r1;
        }

        public static final h.c.x a(h2 this$0, Network it) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(it, "it");
            h.c.s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(this$0.f13848d, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(it));
            kotlin.jvm.internal.m.f(observeWallet, "walletRepository\n                    .observeWallet(Blockchain.ETHEREUM, EthereumBasedConfiguration.ETH.currencyCodeForNetwork(it))");
            h.c.x map = observeWallet.filter(C0334a.a).map(b.a);
            kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
            return map;
        }

        public static /* synthetic */ h.c.x b(h2 h2Var, Network network) {
            return a(h2Var, network);
        }

        @Override // kotlin.e0.c.a
        public final h.c.s<Wallet> invoke() {
            h.c.s<Network> observeNetwork = h2.this.f13848d.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion));
            final h2 h2Var = h2.this;
            return observeNetwork.flatMap(new h.c.m0.n() { // from class: e.j.n.v
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return h2.a.b(h2.this, (Network) obj);
                }
            });
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {

        /* renamed from: b */
        final /* synthetic */ EthereumAddressFromSignedMessageCall f13857b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(EthereumAddressFromSignedMessageCall ethereumAddressFromSignedMessageCall) {
            super(1);
            h2.this = r1;
            this.f13857b = ethereumAddressFromSignedMessageCall;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            h2.this.f13853i.onNext(this.f13857b.createErrorResponse("Unable to get address"));
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {

        /* renamed from: b */
        final /* synthetic */ EthereumAddressFromSignedMessageCall f13858b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(EthereumAddressFromSignedMessageCall ethereumAddressFromSignedMessageCall) {
            super(1);
            h2.this = r1;
            this.f13858b = ethereumAddressFromSignedMessageCall;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
            invoke2(str);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            h2.this.f13853i.onNext(this.f13858b.createResponse(it));
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {

        /* renamed from: b */
        final /* synthetic */ SignEthereumTransactionCall f13859b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(SignEthereumTransactionCall signEthereumTransactionCall) {
            super(1);
            h2.this = r1;
            this.f13859b = signEthereumTransactionCall;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            h2.this.h0(this.f13859b, it);
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SigningSessionEvent, kotlin.x> {

        /* renamed from: b */
        final /* synthetic */ SignEthereumTransactionCall f13860b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(SignEthereumTransactionCall signEthereumTransactionCall) {
            super(1);
            h2.this = r1;
            this.f13860b = signEthereumTransactionCall;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(SigningSessionEvent signingSessionEvent) {
            invoke2(signingSessionEvent);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(SigningSessionEvent signingSessionEvent) {
            if (signingSessionEvent instanceof SigningSessionEvent.SignedAndSubmittedTx) {
                h2.this.g0(((SigningSessionEvent.SignedAndSubmittedTx) signingSessionEvent).getTx(), this.f13860b);
            } else if (signingSessionEvent instanceof SigningSessionEvent.SignedTx) {
                h2.this.g0(((SigningSessionEvent.SignedTx) signingSessionEvent).getTx(), this.f13860b);
            } else if (signingSessionEvent instanceof SigningSessionEvent.Cancelled) {
                h2.this.f0(this.f13860b);
            } else if (signingSessionEvent instanceof SigningSessionEvent.Failure) {
                h2.this.h0(this.f13860b, ((SigningSessionEvent.Failure) signingSessionEvent).getError());
            }
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
        final /* synthetic */ MakeEthereumJSONRPCRequestCall a;

        /* renamed from: b */
        final /* synthetic */ h2 f13861b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(MakeEthereumJSONRPCRequestCall makeEthereumJSONRPCRequestCall, h2 h2Var) {
            super(1);
            this.a = makeEthereumJSONRPCRequestCall;
            this.f13861b = h2Var;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable error) {
            kotlin.jvm.internal.m.g(error, "error");
            this.f13861b.f13853i.onNext(this.a.createErrorResponse(error instanceof CipherCoreBridgeException ? ((CipherCoreBridgeException) error).getMessage() : kotlin.jvm.internal.m.o("Unable to make JSON RPC request: ", error)));
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.l<EthereumJSONRPCRequestResult, kotlin.x> {

        /* renamed from: b */
        final /* synthetic */ MakeEthereumJSONRPCRequestCall f13862b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(MakeEthereumJSONRPCRequestCall makeEthereumJSONRPCRequestCall) {
            super(1);
            h2.this = r1;
            this.f13862b = makeEthereumJSONRPCRequestCall;
        }

        public final void a(EthereumJSONRPCRequestResult ethereumJSONRPCRequestResult) {
            h2.this.f13853i.onNext(this.f13862b.createResponse(ethereumJSONRPCRequestResult.getValue()));
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(EthereumJSONRPCRequestResult ethereumJSONRPCRequestResult) {
            a(ethereumJSONRPCRequestResult);
            return kotlin.x.a;
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class h extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {

        /* renamed from: b */
        final /* synthetic */ SignEthereumMessageCall f13863b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(SignEthereumMessageCall signEthereumMessageCall) {
            super(1);
            h2.this = r1;
            this.f13863b = signEthereumMessageCall;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            h2.this.e0(this.f13863b, it);
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class i extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SigningSessionEvent, kotlin.x> {

        /* renamed from: b */
        final /* synthetic */ SignEthereumMessageCall f13864b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(SignEthereumMessageCall signEthereumMessageCall) {
            super(1);
            h2.this = r1;
            this.f13864b = signEthereumMessageCall;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(SigningSessionEvent signingSessionEvent) {
            invoke2(signingSessionEvent);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(SigningSessionEvent signingSessionEvent) {
            if (signingSessionEvent instanceof SigningSessionEvent.SignedMessage) {
                h2.this.d0(this.f13864b, ((SigningSessionEvent.SignedMessage) signingSessionEvent).getSignature());
            } else if (signingSessionEvent instanceof SigningSessionEvent.Cancelled) {
                h2.this.c0(this.f13864b);
            } else if (signingSessionEvent instanceof SigningSessionEvent.Failure) {
                h2.this.e0(this.f13864b, ((SigningSessionEvent.Failure) signingSessionEvent).getError());
            }
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class j extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {

        /* renamed from: b */
        final /* synthetic */ SignEthereumTransactionCall f13865b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(SignEthereumTransactionCall signEthereumTransactionCall) {
            super(1);
            h2.this = r1;
            this.f13865b = signEthereumTransactionCall;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            h2.this.h0(this.f13865b, it);
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class k extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Optional<? extends Wallet>, kotlin.x> {

        /* renamed from: b */
        final /* synthetic */ SignEthereumTransactionCall f13866b;

        /* renamed from: c */
        final /* synthetic */ String f13867c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(SignEthereumTransactionCall signEthereumTransactionCall, String str) {
            super(1);
            h2.this = r1;
            this.f13866b = signEthereumTransactionCall;
            this.f13867c = str;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Optional<? extends Wallet> optional) {
            invoke2((Optional<Wallet>) optional);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Optional<Wallet> optional) {
            Wallet nullable = optional.toNullable();
            if (nullable == null) {
                return;
            }
            h2.this.u(this.f13866b, nullable, this.f13867c);
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class l extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {

        /* renamed from: b */
        final /* synthetic */ SubmitEthereumTransactionCall f13868b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(SubmitEthereumTransactionCall submitEthereumTransactionCall) {
            super(1);
            h2.this = r1;
            this.f13868b = submitEthereumTransactionCall;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            h2.this.f13853i.onNext(this.f13868b.createErrorResponse(kotlin.jvm.internal.m.o("Unable to submit transaction: ", it)));
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class m extends kotlin.jvm.internal.o implements kotlin.e0.c.l<byte[], kotlin.x> {

        /* renamed from: b */
        final /* synthetic */ SubmitEthereumTransactionCall f13869b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(SubmitEthereumTransactionCall submitEthereumTransactionCall) {
            super(1);
            h2.this = r1;
            this.f13869b = submitEthereumTransactionCall;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(byte[] bArr) {
            invoke2(bArr);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(byte[] it) {
            h.c.v0.b bVar = h2.this.f13853i;
            SubmitEthereumTransactionCall submitEthereumTransactionCall = this.f13869b;
            kotlin.jvm.internal.m.f(it, "it");
            bVar.onNext(submitEthereumTransactionCall.createResponse(it));
        }
    }

    /* compiled from: DappsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class n extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SigningSessionEvent, kotlin.x> {

        /* renamed from: b */
        final /* synthetic */ SwitchEthereumChainCall f13870b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(SwitchEthereumChainCall switchEthereumChainCall) {
            super(1);
            h2.this = r1;
            this.f13870b = switchEthereumChainCall;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(SigningSessionEvent signingSessionEvent) {
            invoke2(signingSessionEvent);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(SigningSessionEvent signingSessionEvent) {
            if (signingSessionEvent instanceof SigningSessionEvent.SwitchEthereumChainApproved) {
                h2.this.f13853i.onNext(this.f13870b.createResponse());
            }
        }
    }

    public h2(e.j.i.u1 bookmarkRepository, CipherCoreInterface cipherCore, DeepLinkRepository deepLinkRepository, IWalletRepository walletRepository, IETHTxRepository ethTxRepository, SignerViewModel signerViewModel, IETHWalletRepository ethWalletRepository) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(bookmarkRepository, "bookmarkRepository");
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(deepLinkRepository, "deepLinkRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(ethTxRepository, "ethTxRepository");
        kotlin.jvm.internal.m.g(signerViewModel, "signerViewModel");
        kotlin.jvm.internal.m.g(ethWalletRepository, "ethWalletRepository");
        this.a = bookmarkRepository;
        this.f13846b = cipherCore;
        this.f13847c = deepLinkRepository;
        this.f13848d = walletRepository;
        this.f13849e = ethTxRepository;
        this.f13850f = signerViewModel;
        this.f13851g = ethWalletRepository;
        this.f13852h = new h.c.k0.a();
        h.c.v0.b<Web3CallResponse> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<Web3CallResponse>()");
        this.f13853i = d2;
        this.f13854j = walletRepository.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)).flatMapSingle(new h.c.m0.n() { // from class: e.j.n.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return h2.I(h2.this, (Network) obj);
            }
        });
        this.f13855k = deepLinkRepository.getDappDeepLinkObservable();
        b2 = kotlin.k.b(new a());
        this.f13856l = b2;
        this.m = bookmarkRepository.g();
        this.n = d2.hide();
    }

    public static /* synthetic */ Integer A(Network network) {
        return b0(network);
    }

    public static /* synthetic */ h.c.h0 B(SignEthereumTransactionCall signEthereumTransactionCall, h2 h2Var, Integer num) {
        return Z(signEthereumTransactionCall, h2Var, num);
    }

    public static /* synthetic */ boolean C(String str, SigningSessionEvent signingSessionEvent) {
        return X(str, signingSessionEvent);
    }

    public static /* synthetic */ c2 D(Bookmark bookmark) {
        return l(bookmark);
    }

    public static /* synthetic */ boolean E(String str, SigningSessionEvent signingSessionEvent) {
        return m0(str, signingSessionEvent);
    }

    public static /* synthetic */ Boolean F(String str, List list) {
        return y(str, list);
    }

    public static /* synthetic */ Boolean G(Throwable th) {
        return z(th);
    }

    public static /* synthetic */ Optional H(Wallet wallet) {
        return a0(wallet);
    }

    public static /* synthetic */ h.c.h0 I(h2 h2Var, Network network) {
        return n(h2Var, network);
    }

    public static /* synthetic */ void J(h2 h2Var, Bookmark bookmark) {
        k(h2Var, bookmark);
    }

    public static /* synthetic */ void K(h2 h2Var, Bookmark bookmark) {
        T(h2Var, bookmark);
    }

    public static /* synthetic */ boolean L(String str, SigningSessionEvent signingSessionEvent) {
        return v(str, signingSessionEvent);
    }

    public static /* synthetic */ c2 M(Bookmark bookmark) {
        return U(bookmark);
    }

    public static /* synthetic */ byte[] N(EthereumSignedTx ethereumSignedTx) {
        return k0(ethereumSignedTx);
    }

    public static /* synthetic */ h.c.h0 O(SubmitEthereumTransactionCall submitEthereumTransactionCall, h2 h2Var, kotlin.o oVar) {
        return j0(submitEthereumTransactionCall, h2Var, oVar);
    }

    public static /* synthetic */ h.c.h0 P(h2 h2Var, MakeEthereumJSONRPCRequestCall makeEthereumJSONRPCRequestCall, Wallet wallet) {
        return R(h2Var, makeEthereumJSONRPCRequestCall, wallet);
    }

    private final h.c.k0.b Q(final MakeEthereumJSONRPCRequestCall makeEthereumJSONRPCRequestCall) {
        h.c.b0 flatMap = Observable_CoreKt.takeSingle(p()).flatMap(new h.c.m0.n() { // from class: e.j.n.c0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return h2.P(h2.this, makeEthereumJSONRPCRequestCall, (Wallet) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "activeWalletObservable\n        .takeSingle()\n        .flatMap { wallet ->\n            val chainId = wallet.network.asChainId()\n            cipherCore.makeEthereumJSONRPCRequest(\n                method = call.rpcMethod,\n                params = call.rpcParams.filterNotNull(),\n                chainId = chainId\n            )\n        }");
        return h.c.t0.a.a(h.c.t0.g.f(flatMap, new f(makeEthereumJSONRPCRequestCall, this), new g(makeEthereumJSONRPCRequestCall)), this.f13852h);
    }

    public static final h.c.h0 R(h2 this$0, MakeEthereumJSONRPCRequestCall call, Wallet wallet) {
        List<? extends Object> V;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(call, "$call");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        int asChainId = Network_ApplicationKt.asChainId(wallet.getNetwork());
        CipherCoreInterface cipherCoreInterface = this$0.f13846b;
        String rpcMethod = call.getRpcMethod();
        V = kotlin.a0.z.V(call.getRpcParams());
        return cipherCoreInterface.makeEthereumJSONRPCRequest(rpcMethod, V, asChainId);
    }

    public static final void T(h2 this$0, Bookmark bookmark) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.q();
    }

    public static final c2 U(Bookmark it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new c2.b(it, c2.c.BOOKMARK_REMOVED);
    }

    private final void V(ScanQRCodeCall scanQRCodeCall) {
    }

    private final void W(SignEthereumMessageCall signEthereumMessageCall) {
        final String uuid = UUID.randomUUID().toString();
        kotlin.jvm.internal.m.f(uuid, "randomUUID().toString()");
        SignatureRequest.SignMessage signMessage = new SignatureRequest.SignMessage(uuid, null, signEthereumMessageCall.getAddress(), ByteArray_CipherCoreKt.toHexEncodedString(signEthereumMessageCall.getMessage(), true), signEthereumMessageCall.getAddPrefix(), signEthereumMessageCall.getTypedDataJson());
        h.c.s<SigningSessionEvent> filter = this.f13850f.getSignatureRequestEvents().filter(new h.c.m0.p() { // from class: e.j.n.o
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return h2.C(uuid, (SigningSessionEvent) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "signerViewModel.signatureRequestEvents\n            .filter { it.uuid == uuid }");
        h.c.t0.a.a(h.c.t0.g.h(filter, new h(signEthereumMessageCall), null, new i(signEthereumMessageCall), 2, null), this.f13852h);
        this.f13850f.appendSignatureRequest(signMessage);
    }

    public static final boolean X(String uuid, SigningSessionEvent it) {
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.jvm.internal.m.c(it.getUuid(), uuid);
    }

    private final void Y(final SignEthereumTransactionCall signEthereumTransactionCall, String str) {
        h.c.s<R> map = this.f13848d.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)).map(new h.c.m0.n() { // from class: e.j.n.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return h2.A((Network) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletRepository.observeNetwork(Blockchain.ETHEREUM)\n            .map { it.asChainId() }");
        h.c.b0 flatMap = Observable_CoreKt.takeSingle(map).flatMap(new h.c.m0.n() { // from class: e.j.n.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return h2.B(SignEthereumTransactionCall.this, this, (Integer) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "walletRepository.observeNetwork(Blockchain.ETHEREUM)\n            .map { it.asChainId() }\n            .takeSingle()\n            .flatMap { chainId ->\n                if (chainId != call.chainId) {\n                    val response = call.createErrorResponse(\"Cannot sign a transaction for a different chain ID\")\n                    respondToWeb3CallSubject.onNext(response)\n                    return@flatMap Singles.justNull<Wallet>()\n                }\n\n                activeWalletObservable.takeSingle().map { it.toOptional() }\n            }");
        h.c.t0.a.a(h.c.t0.g.f(flatMap, new j(signEthereumTransactionCall), new k(signEthereumTransactionCall, str)), this.f13852h);
    }

    public static final h.c.h0 Z(SignEthereumTransactionCall call, h2 this$0, Integer chainId) {
        kotlin.jvm.internal.m.g(call, "$call");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(chainId, "chainId");
        if (chainId.intValue() != call.getChainId()) {
            this$0.f13853i.onNext(call.createErrorResponse("Cannot sign a transaction for a different chain ID"));
            h.c.t0.e eVar = h.c.t0.e.a;
            h.c.b0 just = h.c.b0.just(new Optional(null));
            kotlin.jvm.internal.m.f(just, "just(Optional(null))");
            return just;
        }
        return Observable_CoreKt.takeSingle(this$0.p()).map(new h.c.m0.n() { // from class: e.j.n.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return h2.H((Wallet) obj);
            }
        });
    }

    public static final Optional a0(Wallet it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(it);
    }

    public static final Integer b0(Network it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Integer.valueOf(Network_ApplicationKt.asChainId(it));
    }

    public final void c0(SignEthereumMessageCall signEthereumMessageCall) {
        this.f13853i.onNext(signEthereumMessageCall.createErrorResponse("Sign message cancelled"));
    }

    public final void d0(SignEthereumMessageCall signEthereumMessageCall, byte[] bArr) {
        this.f13853i.onNext(signEthereumMessageCall.createResponse(bArr));
    }

    public final void e0(SignEthereumMessageCall signEthereumMessageCall, Throwable th) {
        this.f13853i.onNext(signEthereumMessageCall.createErrorResponse(kotlin.jvm.internal.m.o("Error signing message: ", th)));
    }

    public final void f0(SignEthereumTransactionCall signEthereumTransactionCall) {
        this.f13853i.onNext(signEthereumTransactionCall.createErrorResponse("User denied transaction signature"));
    }

    public final void g0(SignedTx signedTx, SignEthereumTransactionCall signEthereumTransactionCall) {
        Web3CallResponse createErrorResponse;
        String txHash;
        boolean z = signedTx instanceof EthereumSignedTx;
        byte[] bArr = null;
        EthereumSignedTx ethereumSignedTx = z ? (EthereumSignedTx) signedTx : null;
        byte[] signedTxData = ethereumSignedTx == null ? null : ethereumSignedTx.getSignedTxData();
        EthereumSignedTx ethereumSignedTx2 = z ? (EthereumSignedTx) signedTx : null;
        if (ethereumSignedTx2 != null && (txHash = ethereumSignedTx2.getTxHash()) != null) {
            bArr = String_CoreKt.asHexEncodedData(txHash);
        }
        if (signedTxData != null && bArr != null) {
            createErrorResponse = signEthereumTransactionCall.createResponse(signedTxData, bArr);
        } else {
            createErrorResponse = signEthereumTransactionCall.createErrorResponse("Unable to sign transaction");
        }
        this.f13853i.onNext(createErrorResponse);
    }

    public final void h0(SignEthereumTransactionCall signEthereumTransactionCall, Throwable th) {
        this.f13853i.onNext(signEthereumTransactionCall.createErrorResponse(kotlin.jvm.internal.m.o("Unable to sign transaction: ", th)));
    }

    private final h.c.k0.b i0(final SubmitEthereumTransactionCall submitEthereumTransactionCall) {
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0<ParsedEthereumTransaction> parseSignedEthereumTransaction = this.f13846b.parseSignedEthereumTransaction(submitEthereumTransactionCall.getSignedTransaction());
        h.c.s<List<Address>> ethAddressesObservable = this.f13854j;
        kotlin.jvm.internal.m.f(ethAddressesObservable, "ethAddressesObservable");
        h.c.b0 map = eVar.a(parseSignedEthereumTransaction, Observable_CoreKt.takeSingle(ethAddressesObservable)).flatMap(new h.c.m0.n() { // from class: e.j.n.b0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return h2.O(SubmitEthereumTransactionCall.this, this, (kotlin.o) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.n.a0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return h2.N((EthereumSignedTx) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles\n        .zip(\n            cipherCore.parseSignedEthereumTransaction(call.signedTransaction),\n            ethAddressesObservable.takeSingle()\n        )\n        .flatMap { (parsedTx, addresses) ->\n            val activeChainId = addresses.firstOrNull()?.network?.asChainId()\n                ?: throw DappsException.ChainIdMismatch\n            if (parsedTx.chainId == 0 || activeChainId != parsedTx.chainId || activeChainId != call.chainId) {\n                throw DappsException.ChainIdMismatch\n            }\n\n            val shouldResubmit = (addresses.firstOrNull { it.address == parsedTx.fromAddress } != null)\n\n            val tx = EthereumSignedTx(\n                id = UUID.randomUUID().toString(),\n                fromAddress = parsedTx.fromAddress,\n                toAddress = parsedTx.toAddress,\n                nonce = parsedTx.nonce,\n                chainId = parsedTx.chainId,\n                signedTxData = call.signedTransaction,\n                txHash = parsedTx.hash.toHexEncodedString(),\n                weiValue = parsedTx.weiValue,\n                state = TxState.PENDING,\n                blockchain = Blockchain.ETHEREUM,\n                currencyCode = CurrencyCode.ETH,\n                erc20Value = null,\n                notFoundCount = 0\n            )\n\n            ethTxRepository.submitTx(tx = tx, shouldResubmit = shouldResubmit)\n        }\n        .map { it.txHash.asHexEncodedData() ?: throw DappsException.UnableToDecodeTxHash }");
        return h.c.t0.a.a(h.c.t0.g.f(map, new l(submitEthereumTransactionCall), new m(submitEthereumTransactionCall)), this.f13852h);
    }

    public static final h.c.h0 j0(SubmitEthereumTransactionCall call, h2 this$0, kotlin.o dstr$parsedTx$addresses) {
        Network network;
        Object obj;
        kotlin.jvm.internal.m.g(call, "$call");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$parsedTx$addresses, "$dstr$parsedTx$addresses");
        ParsedEthereumTransaction parsedEthereumTransaction = (ParsedEthereumTransaction) dstr$parsedTx$addresses.a();
        List addresses = (List) dstr$parsedTx$addresses.b();
        kotlin.jvm.internal.m.f(addresses, "addresses");
        Address address = (Address) kotlin.a0.p.a0(addresses);
        Integer valueOf = (address == null || (network = address.getNetwork()) == null) ? null : Integer.valueOf(Network_ApplicationKt.asChainId(network));
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            if (parsedEthereumTransaction.getChainId() != 0 && intValue == parsedEthereumTransaction.getChainId() && intValue == call.getChainId()) {
                Iterator it = addresses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (kotlin.jvm.internal.m.c(((Address) obj).getAddress(), parsedEthereumTransaction.getFromAddress())) {
                        break;
                    }
                }
                boolean z = obj != null;
                String uuid = UUID.randomUUID().toString();
                String fromAddress = parsedEthereumTransaction.getFromAddress();
                String toAddress = parsedEthereumTransaction.getToAddress();
                int nonce = parsedEthereumTransaction.getNonce();
                int chainId = parsedEthereumTransaction.getChainId();
                byte[] signedTransaction = call.getSignedTransaction();
                String hexEncodedString$default = ByteArray_CipherCoreKt.toHexEncodedString$default(parsedEthereumTransaction.getHash(), false, 1, null);
                BigInteger weiValue = parsedEthereumTransaction.getWeiValue();
                TxState txState = TxState.PENDING;
                Blockchain ethereum = Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion);
                CurrencyCode eth = CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion);
                kotlin.jvm.internal.m.f(uuid, "toString()");
                return IETHTxRepository.DefaultImpls.submitTx$default(this$0.f13849e, new EthereumSignedTx(uuid, fromAddress, toAddress, nonce, chainId, signedTransaction, hexEncodedString$default, weiValue, null, ethereum, eth, txState, 0), null, z, 2, null);
            }
            throw DappsException.ChainIdMismatch.INSTANCE;
        }
        throw DappsException.ChainIdMismatch.INSTANCE;
    }

    public static final void k(h2 this$0, Bookmark bookmark) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.q();
    }

    public static final byte[] k0(EthereumSignedTx it) {
        kotlin.jvm.internal.m.g(it, "it");
        byte[] asHexEncodedData = String_CoreKt.asHexEncodedData(it.getTxHash());
        if (asHexEncodedData != null) {
            return asHexEncodedData;
        }
        throw DappsException.UnableToDecodeTxHash.INSTANCE;
    }

    public static final c2 l(Bookmark it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new c2.b(it, c2.c.BOOKMARK_ADDED);
    }

    private final void l0(SwitchEthereumChainCall switchEthereumChainCall) {
        final String uuid = UUID.randomUUID().toString();
        kotlin.jvm.internal.m.f(uuid, "randomUUID().toString()");
        String uuid2 = UUID.randomUUID().toString();
        kotlin.jvm.internal.m.f(uuid2, "randomUUID().toString()");
        SignatureRequest.SwitchEthereumChain switchEthereumChain = new SignatureRequest.SwitchEthereumChain(uuid2, null, switchEthereumChainCall.getChainId());
        h.c.s<SigningSessionEvent> filter = this.f13850f.getSignatureRequestEvents().filter(new h.c.m0.p() { // from class: e.j.n.q
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return h2.E(uuid, (SigningSessionEvent) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "signerViewModel.signatureRequestEvents\n            .filter { it.uuid == uuid }");
        h.c.t0.a.a(h.c.t0.g.h(filter, null, null, new n(switchEthereumChainCall), 3, null), this.f13852h);
        this.f13850f.appendSignatureRequest(switchEthereumChain);
    }

    public static final boolean m0(String uuid, SigningSessionEvent it) {
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.jvm.internal.m.c(it.getUuid(), uuid);
    }

    public static final h.c.h0 n(h2 this$0, Network it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.f13851g.getAddresses(it);
    }

    private final h.c.k0.b o(EthereumAddressFromSignedMessageCall ethereumAddressFromSignedMessageCall) {
        return h.c.t0.a.a(h.c.t0.g.f(this.f13846b.ethereumAddressFromSignedMessage(ethereumAddressFromSignedMessageCall.getMessage(), ethereumAddressFromSignedMessageCall.getSignature(), ethereumAddressFromSignedMessageCall.getAddPrefix()), new b(ethereumAddressFromSignedMessageCall), new c(ethereumAddressFromSignedMessageCall)), this.f13852h);
    }

    public final void u(SignEthereumTransactionCall signEthereumTransactionCall, Wallet wallet, String str) {
        final String uuid = UUID.randomUUID().toString();
        kotlin.jvm.internal.m.f(uuid, "randomUUID().toString()");
        SignatureRequest.SignAndSubmitTx signAndSubmitTx = new SignatureRequest.SignAndSubmitTx(uuid, null, wallet.getPrimaryAddress(), signEthereumTransactionCall.getToAddress(), signEthereumTransactionCall.getWeiValue(), signEthereumTransactionCall.getData(), signEthereumTransactionCall.getNonce(), signEthereumTransactionCall.getGasPriceInWei(), signEthereumTransactionCall.getMaxFeePerGas(), signEthereumTransactionCall.getMaxPriorityFeePerGas(), signEthereumTransactionCall.getGasLimit(), signEthereumTransactionCall.getChainId(), signEthereumTransactionCall.getShouldSubmit(), Uri.parse(str));
        h.c.s<SigningSessionEvent> filter = this.f13850f.getSignatureRequestEvents().filter(new h.c.m0.p() { // from class: e.j.n.y
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return h2.L(uuid, (SigningSessionEvent) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "signerViewModel.signatureRequestEvents\n            .filter { it.uuid == uuid }");
        h.c.t0.a.a(h.c.t0.g.h(filter, new d(signEthereumTransactionCall), null, new e(signEthereumTransactionCall), 2, null), this.f13852h);
        this.f13850f.appendSignatureRequest(signAndSubmitTx);
    }

    public static final boolean v(String uuid, SigningSessionEvent it) {
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.jvm.internal.m.c(it.getUuid(), uuid);
    }

    public static final Boolean y(String url, List bookmarks) {
        kotlin.jvm.internal.m.g(url, "$url");
        kotlin.jvm.internal.m.g(bookmarks, "bookmarks");
        boolean z = false;
        if (!(bookmarks instanceof Collection) || !bookmarks.isEmpty()) {
            Iterator it = bookmarks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (kotlin.jvm.internal.m.c(((Bookmark) it.next()).getUrl(), url)) {
                    z = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z);
    }

    public static final Boolean z(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.FALSE;
    }

    public final h.c.b0<c2> S(String url) {
        kotlin.jvm.internal.m.g(url, "url");
        h.c.b0 map = this.a.e(url).doOnSuccess(new h.c.m0.f() { // from class: e.j.n.x
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                h2.K(h2.this, (Bookmark) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.n.z
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return h2.M((Bookmark) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bookmarkRepository.deleteBookmark(url)\n            .doOnSuccess { getBookmarks() }\n            .map { BookmarkBanner.BookmarkBannerVisible(it, BookmarkBanner.Status.BOOKMARK_REMOVED) }");
        return map;
    }

    public final h.c.b0<c2> j(String title, String url) {
        kotlin.jvm.internal.m.g(title, "title");
        kotlin.jvm.internal.m.g(url, "url");
        h.c.b0 map = this.a.c(url, title).doOnSuccess(new h.c.m0.f() { // from class: e.j.n.w
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                h2.J(h2.this, (Bookmark) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.n.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return h2.D((Bookmark) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bookmarkRepository.addBookmark(url, title)\n            .doOnSuccess { getBookmarks() }\n            .map { BookmarkBanner.BookmarkBannerVisible(it, BookmarkBanner.Status.BOOKMARK_ADDED) }");
        return map;
    }

    public final h.c.b0<String> m(String url, Activity activity) {
        kotlin.jvm.internal.m.g(url, "url");
        kotlin.jvm.internal.m.g(activity, "activity");
        return this.f13847c.createDappDeepLink(url, activity);
    }

    public final h.c.s<Wallet> p() {
        Object value = this.f13856l.getValue();
        kotlin.jvm.internal.m.f(value, "<get-activeWalletObservable>(...)");
        return (h.c.s) value;
    }

    public final void q() {
        this.a.n();
    }

    public final h.c.s<List<Bookmark>> r() {
        return this.m;
    }

    public final h.c.s<String> s() {
        return this.f13855k;
    }

    public final h.c.s<Web3CallResponse> t() {
        return this.n;
    }

    public final void w(Web3Call call, String url) {
        kotlin.jvm.internal.m.g(call, "call");
        kotlin.jvm.internal.m.g(url, "url");
        if (call instanceof SignEthereumTransactionCall) {
            Y((SignEthereumTransactionCall) call, url);
        } else if (call instanceof SignEthereumMessageCall) {
            W((SignEthereumMessageCall) call);
        } else if (call instanceof EthereumAddressFromSignedMessageCall) {
            o((EthereumAddressFromSignedMessageCall) call);
        } else if (call instanceof MakeEthereumJSONRPCRequestCall) {
            Q((MakeEthereumJSONRPCRequestCall) call);
        } else if (call instanceof SubmitEthereumTransactionCall) {
            i0((SubmitEthereumTransactionCall) call);
        } else if (call instanceof ScanQRCodeCall) {
            V((ScanQRCodeCall) call);
        } else if (call instanceof SwitchEthereumChainCall) {
            l0((SwitchEthereumChainCall) call);
        }
    }

    public final h.c.s<Boolean> x(final String url) {
        kotlin.jvm.internal.m.g(url, "url");
        h.c.s<Boolean> onErrorReturn = this.a.g().map(new h.c.m0.n() { // from class: e.j.n.r
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return h2.F(url, (List) obj);
            }
        }).onErrorReturn(new h.c.m0.n() { // from class: e.j.n.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return h2.G((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "bookmarkRepository.bookmarksObservable\n            .map { bookmarks -> bookmarks.any { it.url == url } }\n            .onErrorReturn { false }");
        return onErrorReturn;
    }
}