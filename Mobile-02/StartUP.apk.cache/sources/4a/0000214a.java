package com.coinbase.wallet.features.signer.viewmodel;

import androidx.fragment.app.Fragment;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.features.signer.interfaces.StackedRequestItem;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.walletlink.models.Session;
import h.c.b0;
import h.c.h0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: ParentRequestEthereumAccountsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b \u0010!J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\u0005R\"\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R<\u0010\u0018\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011 \u0017*\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f0\u000f0\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/features/signer/viewmodel/ParentRequestEthereumAccountsViewModel;", "Lcom/coinbase/wallet/features/signer/interfaces/StackedRequestItem;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$RequestEthereumAccountsViewState;", "Lkotlin/x;", "approve", "()V", "reject", "onCleared", "viewState", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$RequestEthereumAccountsViewState;", "getViewState", "()Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$RequestEthereumAccountsViewState;", "setViewState", "(Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$RequestEthereumAccountsViewState;)V", "Lh/c/s;", "Lkotlin/o;", "Landroidx/fragment/app/Fragment;", "", "navigationObservable", "Lh/c/s;", "getNavigationObservable", "()Lh/c/s;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "navigationSubject", "Lh/c/v0/b;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "walletLinkRepository", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "<init>", "(Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ParentRequestEthereumAccountsViewModel extends StackedRequestItem<SignatureRequestViewState.RequestEthereumAccountsViewState> {
    private final h.c.k0.a disposeBag;
    private final h.c.s<kotlin.o<Fragment, String>> navigationObservable;
    private final h.c.v0.b<kotlin.o<Fragment, String>> navigationSubject;
    public SignatureRequestViewState.RequestEthereumAccountsViewState viewState;
    private final WalletLinkRepository walletLinkRepository;

    public ParentRequestEthereumAccountsViewModel(WalletLinkRepository walletLinkRepository) {
        kotlin.jvm.internal.m.g(walletLinkRepository, "walletLinkRepository");
        this.walletLinkRepository = walletLinkRepository;
        h.c.v0.b<kotlin.o<Fragment, String>> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<Pair<Fragment, String>>()");
        this.navigationSubject = d2;
        this.disposeBag = new h.c.k0.a();
        h.c.s<kotlin.o<Fragment, String>> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "navigationSubject.hide()");
        this.navigationObservable = hide;
    }

    public static /* synthetic */ h0 a(ParentRequestEthereumAccountsViewModel parentRequestEthereumAccountsViewModel, x xVar) {
        return m1430reject$lambda1(parentRequestEthereumAccountsViewModel, xVar);
    }

    /* renamed from: reject$lambda-1 */
    public static final h0 m1430reject$lambda1(ParentRequestEthereumAccountsViewModel this$0, x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        List<Session> sessions = this$0.walletLinkRepository.getSessions();
        ArrayList arrayList = new ArrayList();
        for (Object obj : sessions) {
            if (kotlin.jvm.internal.m.c(((Session) obj).getId(), this$0.getViewState().getHostRequestId().getSessionId())) {
                arrayList.add(obj);
            }
        }
        return this$0.walletLinkRepository.disconnect(arrayList);
    }

    public final void approve() {
        getSignatureRequestEventSubject().onNext(new SigningSessionEvent.Signing(getViewState().getUuid()));
        b0 observeOn = Single_AnalyticsKt.logError$default(this.walletLinkRepository.approveDappPermission(getViewState().getHostRequestId()), null, null, 3, null).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "walletLinkRepository.approveDappPermission(viewState.hostRequestId)\n            .logError()\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.f(observeOn, new ParentRequestEthereumAccountsViewModel$approve$1(this), new ParentRequestEthereumAccountsViewModel$approve$2(this)), this.disposeBag);
    }

    public final h.c.s<kotlin.o<Fragment, String>> getNavigationObservable() {
        return this.navigationObservable;
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void reject() {
        getSignatureRequestEventSubject().onNext(new SigningSessionEvent.Signing(getViewState().getUuid()));
        b0<R> flatMap = this.walletLinkRepository.reject(getViewState().getHostRequestId()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.viewmodel.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ParentRequestEthereumAccountsViewModel.a(ParentRequestEthereumAccountsViewModel.this, (x) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "walletLinkRepository.reject(viewState.hostRequestId)\n            .flatMap {\n                val sessions = walletLinkRepository.sessions\n                    .filter { it.id == viewState.hostRequestId.sessionId }\n\n                return@flatMap walletLinkRepository.disconnect(sessions)\n            }");
        h.c.t0.a.a(h.c.t0.g.f(Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null), new ParentRequestEthereumAccountsViewModel$reject$2(this), new ParentRequestEthereumAccountsViewModel$reject$3(this)), this.disposeBag);
    }

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