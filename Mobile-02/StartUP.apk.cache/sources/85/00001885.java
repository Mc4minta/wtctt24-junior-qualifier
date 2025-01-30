package com.coinbase.wallet.consumer.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.DaggerBottomSheetDialogFragment;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferMethodsViewModel;
import com.coinbase.wallet.consumer.views.adapter.TransferMethodsAdapter;
import com.uber.autodispose.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.e0;

/* compiled from: ConsumerTransferMethodsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerTransferMethodsFragment;", "Lcom/coinbase/wallet/commonui/views/DaggerBottomSheetDialogFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lkotlin/x;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel;", "viewModel$delegate", "Lkotlin/h;", "getViewModel", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel;", "viewModel", "Lcom/coinbase/wallet/consumer/views/adapter/TransferMethodsAdapter;", "transferMethodAdapter", "Lcom/coinbase/wallet/consumer/views/adapter/TransferMethodsAdapter;", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel$Factory;", "viewModelFactory", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel$Factory;", "getViewModelFactory$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel$Factory;", "setViewModelFactory$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel$Factory;)V", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferMethodsFragment extends DaggerBottomSheetDialogFragment {
    private TransferMethodsAdapter transferMethodAdapter;
    private final kotlin.h viewModel$delegate = z.a(this, e0.b(ConsumerTransferMethodsViewModel.class), new ConsumerTransferMethodsFragment$special$$inlined$viewModel$3(new ConsumerTransferMethodsFragment$special$$inlined$viewModel$2(this)), new ConsumerTransferMethodsFragment$special$$inlined$viewModel$1(this, this));
    public ConsumerTransferMethodsViewModel.Factory viewModelFactory;

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConsumerTransferMethodsViewModel getViewModel() {
        return (ConsumerTransferMethodsViewModel) this.viewModel$delegate.getValue();
    }

    @Override // com.coinbase.wallet.commonui.views.DaggerBottomSheetDialogFragment
    public void _$_clearFindViewByIdCache() {
    }

    public final ConsumerTransferMethodsViewModel.Factory getViewModelFactory$consumer_productionRelease() {
        ConsumerTransferMethodsViewModel.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_transfer_methods_dialog, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        this.transferMethodAdapter = new TransferMethodsAdapter(new ConsumerTransferMethodsFragment$onViewCreated$1(this), new ConsumerTransferMethodsFragment$onViewCreated$2(this));
        View view2 = getView();
        RecyclerView recyclerView = (RecyclerView) (view2 == null ? null : view2.findViewById(R.id.transferMethodList));
        TransferMethodsAdapter transferMethodsAdapter = this.transferMethodAdapter;
        if (transferMethodsAdapter != null) {
            recyclerView.setAdapter(transferMethodsAdapter);
            View view3 = getView();
            ((RecyclerView) (view3 == null ? null : view3.findViewById(R.id.transferMethodList))).setLayoutManager(new LinearLayoutManager(getContext()));
            View view4 = getView();
            View closeButton = view4 == null ? null : view4.findViewById(R.id.closeButton);
            kotlin.jvm.internal.m.f(closeButton, "closeButton");
            View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new ConsumerTransferMethodsFragment$onViewCreated$3(this), 1, null);
            Object as = getViewModel().getDismissObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel\n            .dismissObservable\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new ConsumerTransferMethodsFragment$onViewCreated$4(this), 3, null);
            Object as2 = getViewModel().getStateObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as2, "viewModel\n            .stateObservable\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new ConsumerTransferMethodsFragment$onViewCreated$5(this), 3, null);
            Object as3 = getViewModel().getEventsObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as3, "viewModel\n            .eventsObservable\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new ConsumerTransferMethodsFragment$onViewCreated$6(this), 3, null);
            Object as4 = getViewModel().setup().as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as4, "viewModel.setup()\n            .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as4, null, null, 3, null);
            return;
        }
        kotlin.jvm.internal.m.w("transferMethodAdapter");
        throw null;
    }

    public final void setViewModelFactory$consumer_productionRelease(ConsumerTransferMethodsViewModel.Factory factory) {
        kotlin.jvm.internal.m.g(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}