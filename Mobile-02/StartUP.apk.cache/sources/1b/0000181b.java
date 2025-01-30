package com.coinbase.wallet.consumer.views;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.z;
import c.h.k.d0;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.viewmodels.ConsumerCardCDVViewModel;
import com.uber.autodispose.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.e0;

/* compiled from: ConsumerCardCDVFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001)\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b,\u0010-J-\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerCardCDVFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lkotlin/x;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "onBackPressed", "()Z", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerCardCDVViewModel$Factory;", "viewModelFactory", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerCardCDVViewModel$Factory;", "getViewModelFactory$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerCardCDVViewModel$Factory;", "setViewModelFactory$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/viewmodels/ConsumerCardCDVViewModel$Factory;)V", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerCardCDVViewModel;", "viewModel$delegate", "Lkotlin/h;", "getViewModel", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerCardCDVViewModel;", "viewModel", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "com/coinbase/wallet/consumer/views/ConsumerCardCDVFragment$amountListener$1", "amountListener", "Lcom/coinbase/wallet/consumer/views/ConsumerCardCDVFragment$amountListener$1;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerCardCDVFragment extends LockedFragment implements StyledFragment, BackableFragment {
    private final ConsumerCardCDVFragment$amountListener$1 amountListener = new TextWatcher() { // from class: com.coinbase.wallet.consumer.views.ConsumerCardCDVFragment$amountListener$1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ConsumerCardCDVViewModel viewModel;
            viewModel = ConsumerCardCDVFragment.this.getViewModel();
            View view = ConsumerCardCDVFragment.this.getView();
            String obj = ((EditText) (view == null ? null : view.findViewById(R.id.amount1))).getText().toString();
            View view2 = ConsumerCardCDVFragment.this.getView();
            viewModel.onAmountsEntered(obj, ((EditText) (view2 != null ? view2.findViewById(R.id.amount2) : null)).getText().toString());
        }
    };
    private final kotlin.h viewModel$delegate = z.a(this, e0.b(ConsumerCardCDVViewModel.class), new ConsumerCardCDVFragment$special$$inlined$viewModel$3(new ConsumerCardCDVFragment$special$$inlined$viewModel$2(this)), new ConsumerCardCDVFragment$special$$inlined$viewModel$1(this, this));
    public ConsumerCardCDVViewModel.Factory viewModelFactory;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConsumerCardCDVViewModel getViewModel() {
        return (ConsumerCardCDVViewModel) this.viewModel$delegate.getValue();
    }

    @Override // com.coinbase.wallet.commonui.views.LockedFragment, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 4, null);
    }

    public final ConsumerCardCDVViewModel.Factory getViewModelFactory$consumer_productionRelease() {
        ConsumerCardCDVViewModel.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_consumer_card_cdv, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(R.id.closeButton);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new ConsumerCardCDVFragment$onViewCreated$1(this), 1, null);
        Object as = getViewModel().getDismissObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as, "viewModel.dismissObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new ConsumerCardCDVFragment$onViewCreated$2(this), 3, null);
        Object as2 = getViewModel().getStateObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as2, "viewModel.stateObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new ConsumerCardCDVFragment$onViewCreated$3(this), 3, null);
        Object as3 = getViewModel().setup().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as3, "viewModel.setup()\n            .`as`(autoDisposable(scopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as3, null, ConsumerCardCDVFragment$onViewCreated$4.INSTANCE, 1, null);
        View view3 = getView();
        ((EditText) (view3 == null ? null : view3.findViewById(R.id.amount1))).addTextChangedListener(this.amountListener);
        View view4 = getView();
        ((EditText) (view4 == null ? null : view4.findViewById(R.id.amount2))).addTextChangedListener(this.amountListener);
        View view5 = getView();
        View confirmButton = view5 != null ? view5.findViewById(R.id.confirmButton) : null;
        kotlin.jvm.internal.m.f(confirmButton, "confirmButton");
        View_CommonKt.setOnSingleClickListener$default(confirmButton, 0L, new ConsumerCardCDVFragment$onViewCreated$5(this), 1, null);
    }

    public final void setViewModelFactory$consumer_productionRelease(ConsumerCardCDVViewModel.Factory factory) {
        kotlin.jvm.internal.m.g(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}