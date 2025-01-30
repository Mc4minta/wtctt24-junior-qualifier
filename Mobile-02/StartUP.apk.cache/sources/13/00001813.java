package com.coinbase.wallet.consumer.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.b0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.h.k.d0;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.RecyclerView_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAvailablePaymentMethodsViewModel;
import com.coinbase.wallet.consumer.views.adapter.ConsumerAvailablePaymentMethodsAdapter;
import com.uber.autodispose.a0;
import kotlin.Metadata;

/* compiled from: ConsumerAvailablePaymentMethodsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b(\u0010)J-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerAvailablePaymentMethodsFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lkotlin/x;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAvailablePaymentMethodsViewModel;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$consumer_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$consumer_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/consumer/views/adapter/ConsumerAvailablePaymentMethodsAdapter;", "adapter$delegate", "Lkotlin/h;", "getAdapter", "()Lcom/coinbase/wallet/consumer/views/adapter/ConsumerAvailablePaymentMethodsAdapter;", "adapter", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "viewModel", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAvailablePaymentMethodsViewModel;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAvailablePaymentMethodsFragment extends LockedFragment implements StyledFragment {
    private final kotlin.h adapter$delegate;
    private ConsumerAvailablePaymentMethodsViewModel viewModel;
    public GenericViewModelFactory<ConsumerAvailablePaymentMethodsViewModel> viewModelFactory;

    public ConsumerAvailablePaymentMethodsFragment() {
        kotlin.h b2;
        b2 = kotlin.k.b(new ConsumerAvailablePaymentMethodsFragment$adapter$2(this));
        this.adapter$delegate = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConsumerAvailablePaymentMethodsAdapter getAdapter() {
        return (ConsumerAvailablePaymentMethodsAdapter) this.adapter$delegate.getValue();
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
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

    public final GenericViewModelFactory<ConsumerAvailablePaymentMethodsViewModel> getViewModelFactory$consumer_productionRelease() {
        GenericViewModelFactory<ConsumerAvailablePaymentMethodsViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_consumer_available_payment_methods, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerPaymentMethodsViewed(AnalyticsEvent.Companion));
        b0 a = new androidx.lifecycle.d0(this, getViewModelFactory$consumer_productionRelease()).a(ConsumerAvailablePaymentMethodsViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (ConsumerAvailablePaymentMethodsViewModel) a;
        View view2 = getView();
        ((RecyclerView) (view2 == null ? null : view2.findViewById(R.id.availablePaymentMethods))).setAdapter(getAdapter());
        View view3 = getView();
        View availablePaymentMethods = view3 == null ? null : view3.findViewById(R.id.availablePaymentMethods);
        kotlin.jvm.internal.m.f(availablePaymentMethods, "availablePaymentMethods");
        RecyclerView_CommonKt.addHorizontalLineDivider$default((RecyclerView) availablePaymentMethods, 0, 0, 0, 0, 0, 0, 57, null);
        View view4 = getView();
        ((RecyclerView) (view4 == null ? null : view4.findViewById(R.id.availablePaymentMethods))).setLayoutManager(new LinearLayoutManager(requireContext()));
        View view5 = getView();
        View closeButton = view5 == null ? null : view5.findViewById(R.id.closeButton);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new ConsumerAvailablePaymentMethodsFragment$onViewCreated$1(this), 1, null);
        ConsumerAvailablePaymentMethodsViewModel consumerAvailablePaymentMethodsViewModel = this.viewModel;
        if (consumerAvailablePaymentMethodsViewModel != null) {
            Object as = consumerAvailablePaymentMethodsViewModel.getStateObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.stateObservable\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new ConsumerAvailablePaymentMethodsFragment$onViewCreated$2(this), 3, null);
            ConsumerAvailablePaymentMethodsViewModel consumerAvailablePaymentMethodsViewModel2 = this.viewModel;
            if (consumerAvailablePaymentMethodsViewModel2 != null) {
                Object as2 = consumerAvailablePaymentMethodsViewModel2.setup().as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as2, "viewModel.setup()\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as2, null, ConsumerAvailablePaymentMethodsFragment$onViewCreated$3.INSTANCE, 1, null);
                ConsumerAvailablePaymentMethodsViewModel consumerAvailablePaymentMethodsViewModel3 = this.viewModel;
                if (consumerAvailablePaymentMethodsViewModel3 != null) {
                    Object as3 = consumerAvailablePaymentMethodsViewModel3.getNavigationObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
                    kotlin.jvm.internal.m.f(as3, "viewModel.navigationObservable\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new ConsumerAvailablePaymentMethodsFragment$onViewCreated$4(this), 3, null);
                    return;
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public final void setViewModelFactory$consumer_productionRelease(GenericViewModelFactory<ConsumerAvailablePaymentMethodsViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}