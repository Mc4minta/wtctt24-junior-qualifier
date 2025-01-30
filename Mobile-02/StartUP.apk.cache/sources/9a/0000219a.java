package com.coinbase.wallet.features.signer.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.signer.viewmodel.ParentRequestEthereumAccountsViewModel;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import h.c.s;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: ParentRequestEthereumAccountsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b&\u0010\u000fJ-\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u000fR(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00038\u0014@\u0014X\u0094.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/features/signer/views/ParentRequestEthereumAccountsFragment;", "Lcom/coinbase/wallet/features/signer/views/RequestSigningDialog;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$RequestEthereumAccountsViewState;", "Lcom/coinbase/wallet/features/signer/viewmodel/ParentRequestEthereumAccountsViewModel;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lkotlin/x;", "setUpViewModel", "()V", "setup", "onDestroy", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "viewModel", "Lcom/coinbase/wallet/features/signer/viewmodel/ParentRequestEthereumAccountsViewModel;", "getViewModel", "()Lcom/coinbase/wallet/features/signer/viewmodel/ParentRequestEthereumAccountsViewModel;", "setViewModel", "(Lcom/coinbase/wallet/features/signer/viewmodel/ParentRequestEthereumAccountsViewModel;)V", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ParentRequestEthereumAccountsFragment extends RequestSigningDialog<SignatureRequestViewState.RequestEthereumAccountsViewState, ParentRequestEthereumAccountsViewModel> {
    private final h.c.k0.a disposeBag = new h.c.k0.a();
    protected ParentRequestEthereumAccountsViewModel viewModel;
    public GenericViewModelFactory<ParentRequestEthereumAccountsViewModel> viewModelFactory;

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog, com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(super.getAttributes(), true, false, false, 4, null);
    }

    public final GenericViewModelFactory<ParentRequestEthereumAccountsViewModel> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<ParentRequestEthereumAccountsViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_fullscreen_dapp_permission, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.disposeBag.d();
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setUpViewModel() {
        b0 a = new d0(this, getViewModelFactory$app_productionRelease()).a(ParentRequestEthereumAccountsViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        setViewModel((ParentRequestEthereumAccountsViewModel) a);
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<ParentRequestEthereumAccountsViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setup() {
        s<kotlin.o<Fragment, String>> observeOn = getViewModel().getNavigationObservable().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "viewModel.navigationObservable\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(observeOn, null, null, new ParentRequestEthereumAccountsFragment$setup$1(this), 3, null), this.disposeBag);
        View view = getView();
        View allowButton = view == null ? null : view.findViewById(e.j.a.allowButton);
        kotlin.jvm.internal.m.f(allowButton, "allowButton");
        View_CommonKt.setOnSingleClickListener$default(allowButton, 0L, new ParentRequestEthereumAccountsFragment$setup$2(this), 1, null);
        View view2 = getView();
        View cancel = view2 != null ? view2.findViewById(e.j.a.cancel) : null;
        kotlin.jvm.internal.m.f(cancel, "cancel");
        View_CommonKt.setOnSingleClickListener$default(cancel, 0L, new ParentRequestEthereumAccountsFragment$setup$3(this), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public ParentRequestEthereumAccountsViewModel getViewModel() {
        ParentRequestEthereumAccountsViewModel parentRequestEthereumAccountsViewModel = this.viewModel;
        if (parentRequestEthereumAccountsViewModel != null) {
            return parentRequestEthereumAccountsViewModel;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setViewModel(ParentRequestEthereumAccountsViewModel parentRequestEthereumAccountsViewModel) {
        kotlin.jvm.internal.m.g(parentRequestEthereumAccountsViewModel, "<set-?>");
        this.viewModel = parentRequestEthereumAccountsViewModel;
    }
}