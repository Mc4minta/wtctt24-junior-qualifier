package com.coinbase.wallet.consumer.views;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferInitiatedViewModel;
import kotlin.Metadata;

/* compiled from: ConsumerTransferInitiatedFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b&\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerTransferInitiatedFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "init", "()V", "initViewModel", "initAnimations", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "onBackPressed", "()Z", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferInitiatedViewModel;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$consumer_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$consumer_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModel", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferInitiatedViewModel;", "<init>", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferInitiatedFragment extends LockedFragment implements BackableFragment, StyledFragment {
    private ConsumerTransferInitiatedViewModel viewModel;
    public GenericViewModelFactory<ConsumerTransferInitiatedViewModel> viewModelFactory;

    private final void init() {
        initAnimations();
        initViewModel();
        View view = getView();
        View doneBtn = view == null ? null : view.findViewById(R.id.doneBtn);
        kotlin.jvm.internal.m.f(doneBtn, "doneBtn");
        View_CommonKt.setOnSingleClickListener$default(doneBtn, 0L, new ConsumerTransferInitiatedFragment$init$1(this), 1, null);
        ConsumerTransferInitiatedViewModel consumerTransferInitiatedViewModel = this.viewModel;
        if (consumerTransferInitiatedViewModel != null) {
            consumerTransferInitiatedViewModel.requestAppReview();
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    private final void initAnimations() {
        View view = getView();
        if ((view == null ? null : view.findViewById(R.id.illustration)) != null) {
            View view2 = getView();
            ((ImageView) (view2 == null ? null : view2.findViewById(R.id.illustration))).setTranslationY(25.0f);
            View view3 = getView();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view3 == null ? null : view3.findViewById(R.id.illustration), "scaleY", 0.8f, 1.0f);
            ofFloat.setDuration(700L);
            ofFloat.start();
            View view4 = getView();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view4 == null ? null : view4.findViewById(R.id.illustration), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(700L);
            ofFloat2.start();
            View view5 = getView();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view5 == null ? null : view5.findViewById(R.id.illustration), "translationY", -75.0f);
            ofFloat3.setDuration(600L);
            ofFloat3.start();
        }
        View view6 = getView();
        if ((view6 == null ? null : view6.findViewById(R.id.transferInitiatedInfoContainer)) != null) {
            View view7 = getView();
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view7 == null ? null : view7.findViewById(R.id.transferInitiatedInfoContainer), "alpha", 0.0f, 1.0f);
            ofFloat4.setDuration(600L);
            ofFloat4.start();
            View view8 = getView();
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view8 == null ? null : view8.findViewById(R.id.transferInitiatedInfoContainer), "translationY", -100.0f);
            ofFloat5.setDuration(600L);
            ofFloat5.start();
        }
        View view9 = getView();
        if ((view9 == null ? null : view9.findViewById(R.id.doneBtn)) != null) {
            View view10 = getView();
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view10 != null ? view10.findViewById(R.id.doneBtn) : null, "alpha", 0.0f, 1.0f);
            ofFloat6.setDuration(250L);
            ofFloat6.start();
        }
    }

    private final void initViewModel() {
        b0 a = new d0(this, getViewModelFactory$consumer_productionRelease()).a(ConsumerTransferInitiatedViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (ConsumerTransferInitiatedViewModel) a;
    }

    @Override // com.coinbase.wallet.commonui.views.LockedFragment, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 6, null);
    }

    public final GenericViewModelFactory<ConsumerTransferInitiatedViewModel> getViewModelFactory$consumer_productionRelease() {
        GenericViewModelFactory<ConsumerTransferInitiatedViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        Fragment_CommonKt.navigateUpToRoot(this);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_consumer_transfer_initiated, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        init();
    }

    public final void setViewModelFactory$consumer_productionRelease(GenericViewModelFactory<ConsumerTransferInitiatedViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}