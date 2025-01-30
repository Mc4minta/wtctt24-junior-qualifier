package com.coinbase.wallet.features.signer.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.features.signer.viewmodel.RequestEthereumAccountsViewModel;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import java.net.URL;
import kotlin.Metadata;
import kotlin.x;
import org.toshi.R;

/* compiled from: RequestEthereumAccountsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b \u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0006R\"\u0010\u0013\u001a\u00020\u00038\u0014@\u0014X\u0094.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/coinbase/wallet/features/signer/views/RequestEthereumAccountsFragment;", "Lcom/coinbase/wallet/features/signer/views/RequestSigningDialog;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$RequestEthereumAccountsViewState;", "Lcom/coinbase/wallet/features/signer/viewmodel/RequestEthereumAccountsViewModel;", "Lkotlin/x;", "onDeny", "()V", "onAuthorize", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "setUpViewModel", "setup", "viewModel", "Lcom/coinbase/wallet/features/signer/viewmodel/RequestEthereumAccountsViewModel;", "getViewModel", "()Lcom/coinbase/wallet/features/signer/viewmodel/RequestEthereumAccountsViewModel;", "setViewModel", "(Lcom/coinbase/wallet/features/signer/viewmodel/RequestEthereumAccountsViewModel;)V", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RequestEthereumAccountsFragment extends RequestSigningDialog<SignatureRequestViewState.RequestEthereumAccountsViewState, RequestEthereumAccountsViewModel> {
    protected RequestEthereumAccountsViewModel viewModel;
    public GenericViewModelFactory<RequestEthereumAccountsViewModel> viewModelFactory;

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAuthorize() {
        getViewModel().approve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDeny() {
        getViewModel().reject();
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void _$_clearFindViewByIdCache() {
    }

    public final GenericViewModelFactory<RequestEthereumAccountsViewModel> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<RequestEthereumAccountsViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.view_dapp_permission, viewGroup, false);
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setUpViewModel() {
        b0 a = new d0(this, getViewModelFactory$app_productionRelease()).a(RequestEthereumAccountsViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        setViewModel((RequestEthereumAccountsViewModel) a);
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<RequestEthereumAccountsViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setup() {
        x xVar;
        URL dappImageUrl = getViewModel().getDappImageUrl();
        if (dappImageUrl == null) {
            xVar = null;
        } else {
            View view = getView();
            View dappIcon = view == null ? null : view.findViewById(e.j.a.dappIcon);
            kotlin.jvm.internal.m.f(dappIcon, "dappIcon");
            loadImageInto$app_productionRelease(dappImageUrl, (ImageView) dappIcon);
            xVar = x.a;
        }
        if (xVar == null) {
            View view2 = getView();
            View dappIcon2 = view2 == null ? null : view2.findViewById(e.j.a.dappIcon);
            kotlin.jvm.internal.m.f(dappIcon2, "dappIcon");
            dappIcon2.setVisibility(8);
        }
        View view3 = getView();
        ((TextView) (view3 == null ? null : view3.findViewById(e.j.a.L6))).setText(getString(R.string.dapp_permission_title, getViewModel().getDappName()));
        View view4 = getView();
        ((TextView) (view4 == null ? null : view4.findViewById(e.j.a.hostLabel))).setText(getViewModel().getDappUrl().getHost());
        View view5 = getView();
        ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.infoLabel))).setText(getString(R.string.dapp_permission_info, getViewModel().getDappName()));
        View view6 = getView();
        View denyButton = view6 == null ? null : view6.findViewById(e.j.a.denyButton);
        kotlin.jvm.internal.m.f(denyButton, "denyButton");
        View_CommonKt.setOnSingleClickListener$default(denyButton, 0L, new RequestEthereumAccountsFragment$setup$3(this), 1, null);
        View view7 = getView();
        View authorizeButton = view7 != null ? view7.findViewById(e.j.a.authorizeButton) : null;
        kotlin.jvm.internal.m.f(authorizeButton, "authorizeButton");
        View_CommonKt.setOnSingleClickListener$default(authorizeButton, 0L, new RequestEthereumAccountsFragment$setup$4(this), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public RequestEthereumAccountsViewModel getViewModel() {
        RequestEthereumAccountsViewModel requestEthereumAccountsViewModel = this.viewModel;
        if (requestEthereumAccountsViewModel != null) {
            return requestEthereumAccountsViewModel;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setViewModel(RequestEthereumAccountsViewModel requestEthereumAccountsViewModel) {
        kotlin.jvm.internal.m.g(requestEthereumAccountsViewModel, "<set-?>");
        this.viewModel = requestEthereumAccountsViewModel;
    }
}