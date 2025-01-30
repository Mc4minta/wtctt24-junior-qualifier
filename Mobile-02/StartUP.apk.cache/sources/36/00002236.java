package com.coinbase.wallet.features.swap.viewmodels;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.SavedStateHandle_CommonKt;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.features.swap.models.SwapCompleteFragmentArgs;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.toshi.view.fragment.coin.WalletDetailFragment;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: SwapCompleteViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eB\u001b\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapCompleteViewModel;", "Landroidx/lifecycle/b0;", "Lkotlin/x;", "routeToTxHistory", "()V", "onCleared", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lh/c/s;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationObservable", "Lh/c/s;", "getNavigationObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "getWalletRepository", "()Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lh/c/v0/b;", "navigationSubject", "Lh/c/v0/b;", "Landroidx/lifecycle/z;", "savedStateHandle", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Landroidx/lifecycle/z;)V", "Factory", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapCompleteViewModel extends androidx.lifecycle.b0 {
    private final CurrencyCode currencyCode;
    private final h.c.k0.a disposeBag;
    private final h.c.s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private final IWalletRepository walletRepository;

    /* compiled from: SwapCompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapCompleteViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapCompleteViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/features/swap/viewmodels/SwapCompleteViewModel;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        SwapCompleteViewModel create(androidx.lifecycle.z zVar);
    }

    public SwapCompleteViewModel(IWalletRepository walletRepository, androidx.lifecycle.z savedStateHandle) {
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(savedStateHandle, "savedStateHandle");
        this.walletRepository = walletRepository;
        this.currencyCode = (CurrencyCode) SavedStateHandle_CommonKt.require(savedStateHandle, SwapCompleteFragmentArgs.INSTANCE.getCurrencyCodeKey());
        this.disposeBag = new h.c.k0.a();
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.navigationSubject = d2;
        h.c.s<ViewModelNavRoute> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "navigationSubject.hide()");
        this.navigationObservable = hide;
    }

    public static /* synthetic */ ViewModelNavRoute a(SwapCompleteViewModel swapCompleteViewModel, Wallet wallet) {
        return m1482routeToTxHistory$lambda0(swapCompleteViewModel, wallet);
    }

    /* renamed from: routeToTxHistory$lambda-0 */
    public static final ViewModelNavRoute m1482routeToTxHistory$lambda0(SwapCompleteViewModel this$0, Wallet wallet) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        return new ViewModelNavRoute(R.id.action_swapCompleteFragment_to_coinDetailsFragment, WalletDetailFragment.a.a(wallet), Fragment_CommonKt.getFadeInNavOptionsBuilder(this$0).g(R.id.swapAmountPickerFragment, true).a());
    }

    public final h.c.s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final IWalletRepository getWalletRepository() {
        return this.walletRepository;
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void routeToTxHistory() {
        h.c.s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(this.walletRepository, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), this.currencyCode);
        kotlin.jvm.internal.m.f(observeWallet, "walletRepository.observeWallet(blockchain = Blockchain.ETHEREUM, currencyCode = currencyCode)");
        h.c.s<R> map = observeWallet.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapCompleteViewModel$routeToTxHistory$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.SwapCompleteViewModel$routeToTxHistory$$inlined$unwrap$2
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
        h.c.b0 map2 = Observable_CoreKt.takeSingle(map).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.swap.viewmodels.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapCompleteViewModel.a(SwapCompleteViewModel.this, (Wallet) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "walletRepository.observeWallet(blockchain = Blockchain.ETHEREUM, currencyCode = currencyCode)\n            .unwrap()\n            .takeSingle()\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { wallet ->\n                ViewModelNavRoute(\n                    resourceId = R.id.action_swapCompleteFragment_to_coinDetailsFragment,\n                    args = WalletDetailFragment.createArguments(wallet),\n                    navOptions = fadeInNavOptionsBuilder\n                        .setPopUpTo(R.id.swapAmountPickerFragment, true)\n                        .build()\n                )\n            }");
        h.c.t0.a.a(h.c.t0.g.i(map2, null, new SwapCompleteViewModel$routeToTxHistory$2(this), 1, null), this.disposeBag);
    }
}