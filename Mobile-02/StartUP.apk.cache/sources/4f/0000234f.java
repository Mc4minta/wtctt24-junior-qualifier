package com.coinbase.wallet.features.walletlink.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.b0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.h.k.d0;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.walletlink.viewmodels.WalletLinkSettingsViewModel;
import com.uber.autodispose.d;
import com.uber.autodispose.x;
import e.j.a;
import e.j.f.r;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import org.toshi.R;

/* compiled from: WalletLinkSettingsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b+\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00168\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/views/WalletLinkSettingsFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "showActivityIndicator", "()V", "hideActivityIndicator", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/coinbase/wallet/features/walletlink/viewmodels/WalletLinkSettingsViewModel;", "viewModel", "Lcom/coinbase/wallet/features/walletlink/viewmodels/WalletLinkSettingsViewModel;", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/features/walletlink/views/WalletLinkSettingsAdapter;", "adapter$delegate", "Lkotlin/h;", "getAdapter", "()Lcom/coinbase/wallet/features/walletlink/views/WalletLinkSettingsAdapter;", "adapter", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkSettingsFragment extends BaseFragment implements StyledFragment {
    private final h adapter$delegate;
    private WalletLinkSettingsViewModel viewModel;
    public GenericViewModelFactory<WalletLinkSettingsViewModel> viewModelFactory;

    public WalletLinkSettingsFragment() {
        h b2;
        b2 = k.b(new WalletLinkSettingsFragment$adapter$2(this));
        this.adapter$delegate = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WalletLinkSettingsAdapter getAdapter() {
        return (WalletLinkSettingsAdapter) this.adapter$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideActivityIndicator() {
        View view = getView();
        View progressBar = view == null ? null : view.findViewById(a.d5);
        m.f(progressBar, "progressBar");
        progressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showActivityIndicator() {
        View view = getView();
        View progressBar = view == null ? null : view.findViewById(a.d5);
        m.f(progressBar, "progressBar");
        progressBar.setVisibility(0);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, true, false, 4, null);
    }

    public final GenericViewModelFactory<WalletLinkSettingsViewModel> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<WalletLinkSettingsViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_wallet_link_settings, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        b0 a = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(WalletLinkSettingsViewModel.class);
        m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (WalletLinkSettingsViewModel) a;
        View view2 = getView();
        ((RecyclerView) (view2 == null ? null : view2.findViewById(a.rvWalletLinkItems))).setAdapter(getAdapter());
        View view3 = getView();
        ((RecyclerView) (view3 == null ? null : view3.findViewById(a.rvWalletLinkItems))).setLayoutManager(new LinearLayoutManager(requireContext()));
        View view4 = getView();
        View rvWalletLinkItems = view4 == null ? null : view4.findViewById(a.rvWalletLinkItems);
        m.f(rvWalletLinkItems, "rvWalletLinkItems");
        r.b((RecyclerView) rvWalletLinkItems, 0, 0, 0, 0, 0, 0, 61, null);
        WalletLinkSettingsViewModel walletLinkSettingsViewModel = this.viewModel;
        if (walletLinkSettingsViewModel != null) {
            Object as = walletLinkSettingsViewModel.getRefreshObservable().observeOn(h.c.j0.c.a.b()).as(d.a(getScopeProvider()));
            m.f(as, "viewModel.refreshObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as, null, null, new WalletLinkSettingsFragment$onViewCreated$1(this), 3, null);
            WalletLinkSettingsViewModel walletLinkSettingsViewModel2 = this.viewModel;
            if (walletLinkSettingsViewModel2 != null) {
                Object as2 = walletLinkSettingsViewModel2.init().observeOn(h.c.j0.c.a.b()).as(d.a(getScopeProvider()));
                m.f(as2, "viewModel.init()\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as2, null, null, WalletLinkSettingsFragment$onViewCreated$2.INSTANCE, 3, null);
                View view5 = getView();
                View closeButton = view5 == null ? null : view5.findViewById(a.t0);
                m.f(closeButton, "closeButton");
                View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new WalletLinkSettingsFragment$onViewCreated$3(this), 1, null);
                View view6 = getView();
                View addButton = view6 != null ? view6.findViewById(a.addButton) : null;
                m.f(addButton, "addButton");
                View_CommonKt.setOnSingleClickListener$default(addButton, 0L, new WalletLinkSettingsFragment$onViewCreated$4(this), 1, null);
                return;
            }
            m.w("viewModel");
            throw null;
        }
        m.w("viewModel");
        throw null;
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<WalletLinkSettingsViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}