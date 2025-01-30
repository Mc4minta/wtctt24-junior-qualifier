package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.features.signer.interfaces.StackedRequestItem;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletlink.models.HostRequestId;
import h.c.b0;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: SwitchEthereumChainViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\u0005R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/features/signer/viewmodel/SwitchEthereumChainViewModel;", "Lcom/coinbase/wallet/features/signer/interfaces/StackedRequestItem;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SwitchEthereumChainViewState;", "Lkotlin/x;", "approve", "()V", "reject", "onCleared", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "walletLinkRepository", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "viewState", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SwitchEthereumChainViewState;", "getViewState", "()Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SwitchEthereumChainViewState;", "setViewState", "(Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SwitchEthereumChainViewState;)V", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwitchEthereumChainViewModel extends StackedRequestItem<SignatureRequestViewState.SwitchEthereumChainViewState> {
    private final h.c.k0.a disposeBag;
    public SignatureRequestViewState.SwitchEthereumChainViewState viewState;
    private final WalletLinkRepository walletLinkRepository;
    private final IWalletRepository walletRepository;

    public SwitchEthereumChainViewModel(IWalletRepository walletRepository, WalletLinkRepository walletLinkRepository) {
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(walletLinkRepository, "walletLinkRepository");
        this.walletRepository = walletRepository;
        this.walletLinkRepository = walletLinkRepository;
        this.disposeBag = new h.c.k0.a();
    }

    public final void approve() {
        if (getViewState().getHostRequestId() == null) {
            EthereumChain fromChainId = EthereumChain.Companion.fromChainId(getViewState().getChainId());
            if (fromChainId == null) {
                return;
            }
            this.walletRepository.switchNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), EthereumChain_EthereumKt.getAsNetwork(fromChainId));
            getSignatureRequestEventSubject().onNext(new SigningSessionEvent.SwitchEthereumChainApproved(getViewState().getUuid()));
            return;
        }
        HostRequestId hostRequestId = getViewState().getHostRequestId();
        if (hostRequestId == null) {
            return;
        }
        b0<x> subscribeOn = this.walletLinkRepository.approve(hostRequestId, new byte[0]).subscribeOn(h.c.u0.a.c());
        kotlin.jvm.internal.m.f(subscribeOn, "walletLinkRepository.approve(requestId, ByteArray(0))\n                    .subscribeOn(Schedulers.io())");
        h.c.t0.a.a(h.c.t0.g.i(subscribeOn, null, new SwitchEthereumChainViewModel$approve$2$1(this), 1, null), this.disposeBag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void reject() {
        HostRequestId hostRequestId = getViewState().getHostRequestId();
        if (hostRequestId != null) {
            h.c.t0.a.a(h.c.t0.g.f(Single_AnalyticsKt.logError$default(this.walletLinkRepository.reject(hostRequestId), null, null, 3, null), new SwitchEthereumChainViewModel$reject$1$1(this), new SwitchEthereumChainViewModel$reject$1$2(this)), this.disposeBag);
        }
        if (getViewState().getHostRequestId() == null) {
            getSignatureRequestEventSubject().onNext(new SigningSessionEvent.Cancelled(getViewState().getUuid()));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.coinbase.wallet.features.signer.interfaces.StackedRequestItem
    public SignatureRequestViewState.SwitchEthereumChainViewState getViewState() {
        SignatureRequestViewState.SwitchEthereumChainViewState switchEthereumChainViewState = this.viewState;
        if (switchEthereumChainViewState != null) {
            return switchEthereumChainViewState;
        }
        kotlin.jvm.internal.m.w("viewState");
        throw null;
    }

    @Override // com.coinbase.wallet.features.signer.interfaces.StackedRequestItem
    public void setViewState(SignatureRequestViewState.SwitchEthereumChainViewState switchEthereumChainViewState) {
        kotlin.jvm.internal.m.g(switchEthereumChainViewState, "<set-?>");
        this.viewState = switchEthereumChainViewState;
    }
}