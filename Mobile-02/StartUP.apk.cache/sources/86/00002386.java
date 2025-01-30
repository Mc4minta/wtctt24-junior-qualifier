package com.coinbase.wallet.features.wallets.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.i;
import androidx.navigation.fragment.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.view.custom.TopAwareRecyclerView;
import com.coinbase.wallet.application.viewmodel.LoadingPillViewModel;
import com.coinbase.wallet.application.viewmodel.ScrolledToTopViewModel;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.features.wallets.models.ListItem;
import com.coinbase.wallet.features.wallets.models.WalletsEmptyState;
import com.coinbase.wallet.features.wallets.viewmodels.ActionItemsViewModel;
import com.coinbase.wallet.features.wallets.viewmodels.WalletsTabViewModel;
import com.coinbase.wallet.features.wallets.views.adapters.WalletAdapter;
import com.toshi.view.fragment.coin.WalletDetailFragment;
import h.c.a0;
import h.c.m0.n;
import h.c.s;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.x;
import org.toshi.R;

/* compiled from: WalletsTabFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bR\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0004J-\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u0015\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u0002068B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0016\u0010;\u001a\u0002068B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u00108R(\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR(\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001f0<8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bD\u0010?\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020=8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bJ\u0010KR(\u0010L\u001a\b\u0012\u0004\u0012\u00020+0<8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bL\u0010?\u001a\u0004\bM\u0010A\"\u0004\bN\u0010CR(\u0010O\u001a\b\u0012\u0004\u0012\u00020\"0<8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bO\u0010?\u001a\u0004\bP\u0010A\"\u0004\bQ\u0010C¨\u0006S"}, d2 = {"Lcom/coinbase/wallet/features/wallets/views/WalletsTabFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lkotlin/x;", "setupViewModel", "()V", "setupAdapter", "setupClickListeners", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "navigateToWalletDetailFragment", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V", "setupObservers", "resumeObservables", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "Landroidx/navigation/fragment/b$b;", "extras", "setNavigatorExtras", "(Landroidx/navigation/fragment/b$b;)V", "Lcom/coinbase/wallet/application/viewmodel/ScrolledToTopViewModel;", "scrolledToTopViewModel", "Lcom/coinbase/wallet/application/viewmodel/ScrolledToTopViewModel;", "Lcom/coinbase/wallet/features/wallets/viewmodels/ActionItemsViewModel;", "actionItemsViewModel", "Lcom/coinbase/wallet/features/wallets/viewmodels/ActionItemsViewModel;", "Lh/c/a0;", "mainScheduler$delegate", "Lkotlin/h;", "getMainScheduler", "()Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/features/wallets/viewmodels/WalletsTabViewModel;", "walletsTabViewModel", "Lcom/coinbase/wallet/features/wallets/viewmodels/WalletsTabViewModel;", "Lh/c/k0/b;", "scrolledToTopDisposable", "Lh/c/k0/b;", "Lcom/coinbase/wallet/features/wallets/views/adapters/WalletAdapter;", "walletAdapter", "Lcom/coinbase/wallet/features/wallets/views/adapters/WalletAdapter;", "fragmentNavigatorExtras", "Landroidx/navigation/fragment/b$b;", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "getOnPauseScopeProvider", "onPauseScopeProvider", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/application/viewmodel/LoadingPillViewModel;", "loadingPillViewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getLoadingPillViewModelFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setLoadingPillViewModelFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "scrolledToTopViewModelFactory", "getScrolledToTopViewModelFactory", "setScrolledToTopViewModelFactory", "Ljava/util/TimerTask;", "blankWalletListTimer", "Ljava/util/TimerTask;", "loadingPillViewModel", "Lcom/coinbase/wallet/application/viewmodel/LoadingPillViewModel;", "walletsTabViewModelFactory", "getWalletsTabViewModelFactory", "setWalletsTabViewModelFactory", "actionItemsViewModelFactory", "getActionItemsViewModelFactory", "setActionItemsViewModelFactory", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletsTabFragment extends BaseFragment {
    private ActionItemsViewModel actionItemsViewModel;
    public GenericViewModelFactory<ActionItemsViewModel> actionItemsViewModelFactory;
    private TimerTask blankWalletListTimer;
    private b.C0036b fragmentNavigatorExtras;
    private LoadingPillViewModel loadingPillViewModel;
    public GenericViewModelFactory<LoadingPillViewModel> loadingPillViewModelFactory;
    private final h mainScheduler$delegate;
    private h.c.k0.b scrolledToTopDisposable;
    private ScrolledToTopViewModel scrolledToTopViewModel;
    public GenericViewModelFactory<ScrolledToTopViewModel> scrolledToTopViewModelFactory;
    private WalletAdapter walletAdapter;
    private WalletsTabViewModel walletsTabViewModel;
    public GenericViewModelFactory<WalletsTabViewModel> walletsTabViewModelFactory;

    public WalletsTabFragment() {
        h b2;
        b2 = k.b(WalletsTabFragment$mainScheduler$2.INSTANCE);
        this.mainScheduler$delegate = b2;
    }

    public static /* synthetic */ x d(WalletsTabFragment walletsTabFragment, WalletsEmptyState walletsEmptyState) {
        return m1558setupObservers$lambda2(walletsTabFragment, walletsEmptyState);
    }

    public static /* synthetic */ x e(WalletsTabFragment walletsTabFragment, Boolean bool) {
        return m1557resumeObservables$lambda4(walletsTabFragment, bool);
    }

    public final a0 getMainScheduler() {
        Object value = this.mainScheduler$delegate.getValue();
        m.f(value, "<get-mainScheduler>(...)");
        return (a0) value;
    }

    private final FragmentLifecycleScopeProvider getOnPauseScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_PAUSE);
    }

    public final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    public final void navigateToWalletDetailFragment(Wallet wallet) {
        Fragment_CommonKt.navigate$default(this, R.id.action_walletFragment_to_walletDetailFragment, WalletDetailFragment.a.a(wallet), null, null, 12, null);
    }

    private final void resumeObservables() {
        View view = getView();
        TopAwareRecyclerView topAwareRecyclerView = (TopAwareRecyclerView) (view == null ? null : view.findViewById(e.j.a.tokensRecyclerView));
        ScrolledToTopViewModel scrolledToTopViewModel = this.scrolledToTopViewModel;
        if (scrolledToTopViewModel != null) {
            h.c.k0.b subscribe = ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(topAwareRecyclerView.startScrollToTopListener(scrolledToTopViewModel), "Couldn't load scrolled to top status", null, 2, null).as(com.uber.autodispose.d.a(getOnPauseScopeProvider()))).subscribe();
            m.f(subscribe, "tokensRecyclerView.startScrollToTopListener(scrolledToTopViewModel)\n            .logError(\"Couldn't load scrolled to top status\")\n            .`as`(autoDisposable(onPauseScopeProvider))\n            .subscribe()");
            this.scrolledToTopDisposable = subscribe;
            WalletsTabViewModel walletsTabViewModel = this.walletsTabViewModel;
            if (walletsTabViewModel != null) {
                s<R> map = walletsTabViewModel.isScanningObservable().observeOn(getMainScheduler()).map(new n() { // from class: com.coinbase.wallet.features.wallets.views.d
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return WalletsTabFragment.e(WalletsTabFragment.this, (Boolean) obj);
                    }
                });
                m.f(map, "walletsTabViewModel.isScanningObservable\n            .observeOn(mainScheduler)\n            .map { if (it) loadingPillViewModel.showLoadingPill() else loadingPillViewModel.hideLoadingPill() }");
                ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(map, "Couldn't load tokens into adapter.", null, 2, null).as(com.uber.autodispose.d.a(getOnPauseScopeProvider()))).subscribe();
                return;
            }
            m.w("walletsTabViewModel");
            throw null;
        }
        m.w("scrolledToTopViewModel");
        throw null;
    }

    /* renamed from: resumeObservables$lambda-4 */
    public static final x m1557resumeObservables$lambda4(WalletsTabFragment this$0, Boolean it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        boolean booleanValue = it.booleanValue();
        LoadingPillViewModel loadingPillViewModel = this$0.loadingPillViewModel;
        if (booleanValue) {
            if (loadingPillViewModel == null) {
                m.w("loadingPillViewModel");
                throw null;
            }
            loadingPillViewModel.showLoadingPill();
        } else if (loadingPillViewModel == null) {
            m.w("loadingPillViewModel");
            throw null;
        } else {
            loadingPillViewModel.hideLoadingPill();
        }
        return x.a;
    }

    private final void setupAdapter() {
        WalletAdapter walletAdapter = new WalletAdapter(null, new WalletsTabFragment$setupAdapter$1(this), new WalletsTabFragment$setupAdapter$2(this), new WalletsTabFragment$setupAdapter$3(this), 1, null);
        walletAdapter.registerAdapterDataObserver(new RecyclerView.i() { // from class: com.coinbase.wallet.features.wallets.views.WalletsTabFragment$setupAdapter$4$1
            @Override // androidx.recyclerview.widget.RecyclerView.i
            public void onItemRangeInserted(int i2, int i3) {
                super.onItemRangeInserted(i2, i3);
                View view = WalletsTabFragment.this.getView();
                RecyclerView.o layoutManager = ((TopAwareRecyclerView) (view == null ? null : view.findViewById(e.j.a.tokensRecyclerView))).getLayoutManager();
                Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                if (((LinearLayoutManager) layoutManager).c2() == 0) {
                    View view2 = WalletsTabFragment.this.getView();
                    ((TopAwareRecyclerView) (view2 != null ? view2.findViewById(e.j.a.tokensRecyclerView) : null)).smoothScrollToPosition(0);
                }
            }
        });
        x xVar = x.a;
        this.walletAdapter = walletAdapter;
        View view = getView();
        TopAwareRecyclerView topAwareRecyclerView = (TopAwareRecyclerView) (view == null ? null : view.findViewById(e.j.a.tokensRecyclerView));
        WalletAdapter walletAdapter2 = this.walletAdapter;
        if (walletAdapter2 != null) {
            topAwareRecyclerView.setAdapter(walletAdapter2);
        } else {
            m.w("walletAdapter");
            throw null;
        }
    }

    private final void setupClickListeners() {
        View view = getView();
        View getCoinsButton = view == null ? null : view.findViewById(e.j.a.getCoinsButton);
        m.f(getCoinsButton, "getCoinsButton");
        View_CommonKt.setOnSingleClickListener$default(getCoinsButton, 0L, new WalletsTabFragment$setupClickListeners$1(this), 1, null);
    }

    private final void setupObservers() {
        View view = getView();
        View emptyTransferView = view == null ? null : view.findViewById(e.j.a.emptyTransferView);
        m.f(emptyTransferView, "emptyTransferView");
        emptyTransferView.setVisibility(8);
        WalletsTabViewModel walletsTabViewModel = this.walletsTabViewModel;
        if (walletsTabViewModel != null) {
            s distinctUntilChanged = walletsTabViewModel.getUpdateEmptyStateViewObservable().observeOn(getMainScheduler()).map(new n() { // from class: com.coinbase.wallet.features.wallets.views.c
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return WalletsTabFragment.d(WalletsTabFragment.this, (WalletsEmptyState) obj);
                }
            }).distinctUntilChanged();
            m.f(distinctUntilChanged, "walletsTabViewModel.updateEmptyStateViewObservable\n            .observeOn(mainScheduler)\n            .map { walletsEmptyState ->\n                getCoinsButton.isVisible = walletsEmptyState.transferButtonVisible\n                emptyTransferStateTitle.setText(walletsEmptyState.title)\n                emptyTransferStateSubtitle.setText(walletsEmptyState.subtitle)\n            }\n            .distinctUntilChanged()");
            ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(distinctUntilChanged, "Couldn't check if we should show empty transfer view", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() { // from class: com.coinbase.wallet.features.wallets.views.WalletsTabFragment$setupObservers$$inlined$schedule$1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.getBlankWalletList(AnalyticsEvent.Companion));
                }
            };
            timer.schedule(timerTask, 40000L);
            this.blankWalletListTimer = timerTask;
            h.c.t0.c cVar = h.c.t0.c.a;
            WalletsTabViewModel walletsTabViewModel2 = this.walletsTabViewModel;
            if (walletsTabViewModel2 == null) {
                m.w("walletsTabViewModel");
                throw null;
            }
            s<List<ListItem.WalletListItem>> walletsObservable = walletsTabViewModel2.getWalletsObservable();
            ActionItemsViewModel actionItemsViewModel = this.actionItemsViewModel;
            if (actionItemsViewModel != null) {
                s observeOn = cVar.a(walletsObservable, actionItemsViewModel.getActionItemsObservable()).observeOn(getMainScheduler());
                m.f(observeOn, "Observables.combineLatest(walletsTabViewModel.walletsObservable, actionItemsViewModel.actionItemsObservable)\n            .observeOn(mainScheduler)");
                Object as = Observable_AnalyticsKt.logError$default(observeOn, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                m.f(as, "Observables.combineLatest(walletsTabViewModel.walletsObservable, actionItemsViewModel.actionItemsObservable)\n            .observeOn(mainScheduler)\n            .logError()\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new WalletsTabFragment$setupObservers$3(this), 3, null);
                ActionItemsViewModel actionItemsViewModel2 = this.actionItemsViewModel;
                if (actionItemsViewModel2 != null) {
                    s<ViewModelNavRoute> observeOn2 = actionItemsViewModel2.getNavigationObservable().observeOn(getMainScheduler());
                    m.f(observeOn2, "actionItemsViewModel.navigationObservable\n            .observeOn(mainScheduler)");
                    Object as2 = Observable_AnalyticsKt.logError$default(observeOn2, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                    m.f(as2, "actionItemsViewModel.navigationObservable\n            .observeOn(mainScheduler)\n            .logError()\n            .`as`(autoDisposable(scopeProvider))");
                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new WalletsTabFragment$setupObservers$4(this), 3, null);
                    ActionItemsViewModel actionItemsViewModel3 = this.actionItemsViewModel;
                    if (actionItemsViewModel3 != null) {
                        Object as3 = actionItemsViewModel3.getTestNetDialogObservable().observeOn(getMainScheduler()).as(com.uber.autodispose.d.a(getScopeProvider()));
                        m.f(as3, "actionItemsViewModel.testNetDialogObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new WalletsTabFragment$setupObservers$5(this), 3, null);
                        View view2 = getView();
                        TopAwareRecyclerView topAwareRecyclerView = (TopAwareRecyclerView) (view2 == null ? null : view2.findViewById(e.j.a.tokensRecyclerView));
                        ScrolledToTopViewModel scrolledToTopViewModel = this.scrolledToTopViewModel;
                        if (scrolledToTopViewModel != null) {
                            ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(topAwareRecyclerView.startTouchedObservable(scrolledToTopViewModel), "Couldn't update touched state of motion layout", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
                            return;
                        } else {
                            m.w("scrolledToTopViewModel");
                            throw null;
                        }
                    }
                    m.w("actionItemsViewModel");
                    throw null;
                }
                m.w("actionItemsViewModel");
                throw null;
            }
            m.w("actionItemsViewModel");
            throw null;
        }
        m.w("walletsTabViewModel");
        throw null;
    }

    /* renamed from: setupObservers$lambda-2 */
    public static final x m1558setupObservers$lambda2(WalletsTabFragment this$0, WalletsEmptyState walletsEmptyState) {
        m.g(this$0, "this$0");
        m.g(walletsEmptyState, "walletsEmptyState");
        View view = this$0.getView();
        View getCoinsButton = view == null ? null : view.findViewById(e.j.a.getCoinsButton);
        m.f(getCoinsButton, "getCoinsButton");
        getCoinsButton.setVisibility(walletsEmptyState.getTransferButtonVisible() ? 0 : 8);
        View view2 = this$0.getView();
        ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.emptyTransferStateTitle))).setText(walletsEmptyState.getTitle());
        View view3 = this$0.getView();
        ((TextView) (view3 != null ? view3.findViewById(e.j.a.emptyTransferStateSubtitle) : null)).setText(walletsEmptyState.getSubtitle());
        return x.a;
    }

    private final void setupViewModel() {
        b0 a = new d0(this, getWalletsTabViewModelFactory()).a(WalletsTabViewModel.class);
        m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.walletsTabViewModel = (WalletsTabViewModel) a;
        b0 a2 = new d0(this, getActionItemsViewModelFactory()).a(ActionItemsViewModel.class);
        m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.actionItemsViewModel = (ActionItemsViewModel) a2;
        b0 a3 = new d0(requireActivity(), getLoadingPillViewModelFactory()).a(LoadingPillViewModel.class);
        m.f(a3, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(T::class.java)\n}");
        this.loadingPillViewModel = (LoadingPillViewModel) a3;
        b0 a4 = new d0(requireActivity(), getScrolledToTopViewModelFactory()).a(ScrolledToTopViewModel.class);
        m.f(a4, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(T::class.java)\n}");
        this.scrolledToTopViewModel = (ScrolledToTopViewModel) a4;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    public final GenericViewModelFactory<ActionItemsViewModel> getActionItemsViewModelFactory() {
        GenericViewModelFactory<ActionItemsViewModel> genericViewModelFactory = this.actionItemsViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("actionItemsViewModelFactory");
        throw null;
    }

    public final GenericViewModelFactory<LoadingPillViewModel> getLoadingPillViewModelFactory() {
        GenericViewModelFactory<LoadingPillViewModel> genericViewModelFactory = this.loadingPillViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("loadingPillViewModelFactory");
        throw null;
    }

    public final GenericViewModelFactory<ScrolledToTopViewModel> getScrolledToTopViewModelFactory() {
        GenericViewModelFactory<ScrolledToTopViewModel> genericViewModelFactory = this.scrolledToTopViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("scrolledToTopViewModelFactory");
        throw null;
    }

    public final GenericViewModelFactory<WalletsTabViewModel> getWalletsTabViewModelFactory() {
        GenericViewModelFactory<WalletsTabViewModel> genericViewModelFactory = this.walletsTabViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("walletsTabViewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_coins, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        View view = getView();
        ((TopAwareRecyclerView) (view == null ? null : view.findViewById(e.j.a.tokensRecyclerView))).setNestedScrollingEnabled(false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        resumeObservables();
        View view = getView();
        ((TopAwareRecyclerView) (view == null ? null : view.findViewById(e.j.a.tokensRecyclerView))).setNestedScrollingEnabled(true);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        setupViewModel();
        setupAdapter();
        setupObservers();
        setupClickListeners();
    }

    public final void setActionItemsViewModelFactory(GenericViewModelFactory<ActionItemsViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.actionItemsViewModelFactory = genericViewModelFactory;
    }

    public final void setLoadingPillViewModelFactory(GenericViewModelFactory<LoadingPillViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.loadingPillViewModelFactory = genericViewModelFactory;
    }

    public final void setNavigatorExtras(b.C0036b extras) {
        m.g(extras, "extras");
        this.fragmentNavigatorExtras = extras;
    }

    public final void setScrolledToTopViewModelFactory(GenericViewModelFactory<ScrolledToTopViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.scrolledToTopViewModelFactory = genericViewModelFactory;
    }

    public final void setWalletsTabViewModelFactory(GenericViewModelFactory<WalletsTabViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.walletsTabViewModelFactory = genericViewModelFactory;
    }
}