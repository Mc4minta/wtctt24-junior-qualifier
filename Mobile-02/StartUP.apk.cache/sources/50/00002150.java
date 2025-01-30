package com.coinbase.wallet.features.signer.viewmodel;

import android.net.Uri;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.features.signer.interfaces.StackedRequestItem;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import java.net.URL;
import kotlin.Metadata;

/* compiled from: RequestEthereumAccountsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b$\u0010%J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\u0005R\u001d\u0010\r\u001a\u00020\b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0015\u001a\u00020\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u001a\u001a\u0004\u0018\u00010\u00168F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00028\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/coinbase/wallet/features/signer/viewmodel/RequestEthereumAccountsViewModel;", "Lcom/coinbase/wallet/features/signer/interfaces/StackedRequestItem;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$RequestEthereumAccountsViewState;", "Lkotlin/x;", "approve", "()V", "reject", "onCleared", "", "dappName$delegate", "Lkotlin/h;", "getDappName", "()Ljava/lang/String;", WalletLinkCompleteArgs.DAPP_NAME, "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Landroid/net/Uri;", "dappUrl$delegate", "getDappUrl", "()Landroid/net/Uri;", "dappUrl", "Ljava/net/URL;", "dappImageUrl$delegate", "getDappImageUrl", "()Ljava/net/URL;", "dappImageUrl", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "walletLinkRepository", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "viewState", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$RequestEthereumAccountsViewState;", "getViewState", "()Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$RequestEthereumAccountsViewState;", "setViewState", "(Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$RequestEthereumAccountsViewState;)V", "<init>", "(Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RequestEthereumAccountsViewModel extends StackedRequestItem<SignatureRequestViewState.RequestEthereumAccountsViewState> {
    private final kotlin.h dappImageUrl$delegate;
    private final kotlin.h dappName$delegate;
    private final kotlin.h dappUrl$delegate;
    private final h.c.k0.a disposeBag;
    public SignatureRequestViewState.RequestEthereumAccountsViewState viewState;
    private final WalletLinkRepository walletLinkRepository;

    public RequestEthereumAccountsViewModel(WalletLinkRepository walletLinkRepository) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.jvm.internal.m.g(walletLinkRepository, "walletLinkRepository");
        this.walletLinkRepository = walletLinkRepository;
        this.disposeBag = new h.c.k0.a();
        b2 = kotlin.k.b(new RequestEthereumAccountsViewModel$dappUrl$2(this));
        this.dappUrl$delegate = b2;
        b3 = kotlin.k.b(new RequestEthereumAccountsViewModel$dappName$2(this));
        this.dappName$delegate = b3;
        b4 = kotlin.k.b(new RequestEthereumAccountsViewModel$dappImageUrl$2(this));
        this.dappImageUrl$delegate = b4;
    }

    public final void approve() {
        getSignatureRequestEventSubject().onNext(new SigningSessionEvent.Signing(getViewState().getUuid()));
        h.c.t0.a.a(h.c.t0.g.f(Single_AnalyticsKt.logError$default(this.walletLinkRepository.approveDappPermission(getViewState().getHostRequestId()), null, null, 3, null), new RequestEthereumAccountsViewModel$approve$1(this), new RequestEthereumAccountsViewModel$approve$2(this)), this.disposeBag);
    }

    public final URL getDappImageUrl() {
        return (URL) this.dappImageUrl$delegate.getValue();
    }

    public final String getDappName() {
        return (String) this.dappName$delegate.getValue();
    }

    public final Uri getDappUrl() {
        return (Uri) this.dappUrl$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void reject() {
        getSignatureRequestEventSubject().onNext(new SigningSessionEvent.Signing(getViewState().getUuid()));
        h.c.t0.a.a(h.c.t0.g.f(Single_AnalyticsKt.logError$default(this.walletLinkRepository.reject(getViewState().getHostRequestId()), null, null, 3, null), new RequestEthereumAccountsViewModel$reject$1(this), new RequestEthereumAccountsViewModel$reject$2(this)), this.disposeBag);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.coinbase.wallet.features.signer.interfaces.StackedRequestItem
    public SignatureRequestViewState.RequestEthereumAccountsViewState getViewState() {
        SignatureRequestViewState.RequestEthereumAccountsViewState requestEthereumAccountsViewState = this.viewState;
        if (requestEthereumAccountsViewState != null) {
            return requestEthereumAccountsViewState;
        }
        kotlin.jvm.internal.m.w("viewState");
        throw null;
    }

    @Override // com.coinbase.wallet.features.signer.interfaces.StackedRequestItem
    public void setViewState(SignatureRequestViewState.RequestEthereumAccountsViewState requestEthereumAccountsViewState) {
        kotlin.jvm.internal.m.g(requestEthereumAccountsViewState, "<set-?>");
        this.viewState = requestEthereumAccountsViewState;
    }
}