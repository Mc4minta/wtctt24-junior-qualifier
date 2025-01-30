package com.coinbase.wallet.features.signer.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import com.coinbase.wallet.features.signer.viewmodel.SwitchEthereumChainViewModel;
import java.net.URL;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: SwitchEthereumChainFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u000fJ-\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00038\u0014@\u0014X\u0094.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00178\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/features/signer/views/SwitchEthereumChainFragment;", "Lcom/coinbase/wallet/features/signer/views/RequestSigningDialog;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SwitchEthereumChainViewState;", "Lcom/coinbase/wallet/features/signer/viewmodel/SwitchEthereumChainViewModel;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lkotlin/x;", "setUpViewModel", "()V", "setup", "viewModel", "Lcom/coinbase/wallet/features/signer/viewmodel/SwitchEthereumChainViewModel;", "getViewModel", "()Lcom/coinbase/wallet/features/signer/viewmodel/SwitchEthereumChainViewModel;", "setViewModel", "(Lcom/coinbase/wallet/features/signer/viewmodel/SwitchEthereumChainViewModel;)V", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwitchEthereumChainFragment extends RequestSigningDialog<SignatureRequestViewState.SwitchEthereumChainViewState, SwitchEthereumChainViewModel> {
    protected SwitchEthereumChainViewModel viewModel;
    public GenericViewModelFactory<SwitchEthereumChainViewModel> viewModelFactory;

    public static /* synthetic */ void h(SwitchEthereumChainFragment switchEthereumChainFragment, View view) {
        m1459setup$lambda2(switchEthereumChainFragment, view);
    }

    public static /* synthetic */ void i(SwitchEthereumChainFragment switchEthereumChainFragment, View view) {
        m1458setup$lambda1(switchEthereumChainFragment, view);
    }

    /* renamed from: setup$lambda-1 */
    public static final void m1458setup$lambda1(SwitchEthereumChainFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.getViewModel().reject();
    }

    /* renamed from: setup$lambda-2 */
    public static final void m1459setup$lambda2(SwitchEthereumChainFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.getViewModel().approve();
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void _$_clearFindViewByIdCache() {
    }

    public final GenericViewModelFactory<SwitchEthereumChainViewModel> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<SwitchEthereumChainViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.view_message_approval, viewGroup, false);
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setUpViewModel() {
        b0 a = new d0(this, getViewModelFactory$app_productionRelease()).a(SwitchEthereumChainViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        setViewModel((SwitchEthereumChainViewModel) a);
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<SwitchEthereumChainViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setup() {
        String displayName;
        String baseAssetImageUrl;
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(getViewModel().getViewState().getChainId());
        if (fromChainId != null && (baseAssetImageUrl = fromChainId.getBaseAssetImageUrl()) != null) {
            URL url = new URL(baseAssetImageUrl);
            View view = getView();
            View dappIcon = view == null ? null : view.findViewById(e.j.a.dappIcon);
            kotlin.jvm.internal.m.f(dappIcon, "dappIcon");
            loadImageInto$app_productionRelease(url, (ImageView) dappIcon);
        }
        View view2 = getView();
        TextView textView = (TextView) (view2 == null ? null : view2.findViewById(e.j.a.messageDescriptionText));
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        Object[] objArr = new Object[1];
        String str = "";
        if (fromChainId != null && (displayName = fromChainId.getDisplayName()) != null) {
            str = displayName;
        }
        objArr[0] = str;
        textView.setText(localizedStrings.get(R.string.message_switch_body, objArr));
        View view3 = getView();
        ((Button) (view3 == null ? null : view3.findViewById(e.j.a.cancelButton))).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.signer.views.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                SwitchEthereumChainFragment.i(SwitchEthereumChainFragment.this, view4);
            }
        });
        View view4 = getView();
        ((Button) (view4 != null ? view4.findViewById(e.j.a.approveButton) : null)).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.signer.views.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                SwitchEthereumChainFragment.h(SwitchEthereumChainFragment.this, view5);
            }
        });
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public SwitchEthereumChainViewModel getViewModel() {
        SwitchEthereumChainViewModel switchEthereumChainViewModel = this.viewModel;
        if (switchEthereumChainViewModel != null) {
            return switchEthereumChainViewModel;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setViewModel(SwitchEthereumChainViewModel switchEthereumChainViewModel) {
        kotlin.jvm.internal.m.g(switchEthereumChainViewModel, "<set-?>");
        this.viewModel = switchEthereumChainViewModel;
    }
}