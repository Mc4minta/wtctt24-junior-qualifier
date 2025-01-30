package com.coinbase.wallet.consumer.views;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import androidx.fragment.app.z;
import c.h.k.d0;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.viewmodels.ConsumerInterstitialViewModel;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.uber.autodispose.a0;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.e0;

/* compiled from: ConsumerInterstitialFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b-\u0010\u0013J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R$\u0010+\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00050\u00050)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerInterstitialFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/x;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onPause", "()V", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerInterstitialViewModel;", "viewModel$delegate", "Lkotlin/h;", "getViewModel", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerInterstitialViewModel;", "viewModel", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerInterstitialViewModel$Factory;", "consumerInterstitialViewModelFactory", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerInterstitialViewModel$Factory;", "getConsumerInterstitialViewModelFactory", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerInterstitialViewModel$Factory;", "setConsumerInterstitialViewModelFactory", "(Lcom/coinbase/wallet/consumer/viewmodels/ConsumerInterstitialViewModel$Factory;)V", "Lcom/uber/autodispose/y;", "getScopeProvider", "()Lcom/uber/autodispose/y;", "scopeProvider", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lh/c/v0/a;", "kotlin.jvm.PlatformType", "animationEndedSubject", "Lh/c/v0/a;", "<init>", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerInterstitialFragment extends BaseFragment implements StyledFragment {
    private final h.c.v0.a<kotlin.x> animationEndedSubject;
    public ConsumerInterstitialViewModel.Factory consumerInterstitialViewModelFactory;
    private final kotlin.h viewModel$delegate;

    public ConsumerInterstitialFragment() {
        h.c.v0.a<kotlin.x> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create<Unit>()");
        this.animationEndedSubject = d2;
        this.viewModel$delegate = z.a(this, e0.b(ConsumerInterstitialViewModel.class), new ConsumerInterstitialFragment$special$$inlined$viewModel$3(new ConsumerInterstitialFragment$special$$inlined$viewModel$2(this)), new ConsumerInterstitialFragment$special$$inlined$viewModel$1(this, this));
    }

    public static final /* synthetic */ h.c.v0.a access$getAnimationEndedSubject$p(ConsumerInterstitialFragment consumerInterstitialFragment) {
        return consumerInterstitialFragment.animationEndedSubject;
    }

    private final com.uber.autodispose.y getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    public final ConsumerInterstitialViewModel getViewModel() {
        return (ConsumerInterstitialViewModel) this.viewModel$delegate.getValue();
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
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 4, null);
    }

    public final ConsumerInterstitialViewModel.Factory getConsumerInterstitialViewModelFactory() {
        ConsumerInterstitialViewModel.Factory factory = this.consumerInterstitialViewModelFactory;
        if (factory != null) {
            return factory;
        }
        kotlin.jvm.internal.m.w("consumerInterstitialViewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getViewModel().getHasSharedElementTransition()) {
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setDuration(300L);
            changeBounds.addListener(new Transition.TransitionListener() { // from class: com.coinbase.wallet.consumer.views.ConsumerInterstitialFragment$onCreate$$inlined$doOnEnd$1
                @Override // android.transition.Transition.TransitionListener
                public void onTransitionCancel(Transition transition) {
                    kotlin.jvm.internal.m.g(transition, "transition");
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition) {
                    kotlin.jvm.internal.m.g(transition, "transition");
                    ConsumerInterstitialFragment.access$getAnimationEndedSubject$p(ConsumerInterstitialFragment.this).onNext(kotlin.x.a);
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionPause(Transition transition) {
                    kotlin.jvm.internal.m.g(transition, "transition");
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionResume(Transition transition) {
                    kotlin.jvm.internal.m.g(transition, "transition");
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionStart(Transition transition) {
                    kotlin.jvm.internal.m.g(transition, "transition");
                }
            });
            setSharedElementEnterTransition(changeBounds);
            return;
        }
        this.animationEndedSubject.onNext(kotlin.x.a);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        if (getViewModel().getHasSharedElementTransition()) {
            return inflater.inflate(R.layout.fragment_consumer_interstitial, viewGroup, false);
        }
        return new ViewStub(requireContext());
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getViewModel().onPause();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        postponeEnterTransition();
        Object as = h.c.t0.e.a.a(Observable_CoreKt.takeSingle(getViewModel().getNavigationObservable()), Observable_CoreKt.takeSingle(this.animationEndedSubject)).as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as, "Singles\n            .zip(\n                viewModel.navigationObservable.takeSingle(),\n                animationEndedSubject.takeSingle()\n            )\n            .`as`(autoDisposable(scopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as, null, new ConsumerInterstitialFragment$onViewCreated$1(this), 1, null);
        Object as2 = getViewModel().getDismissObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as2, "viewModel.dismissObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new ConsumerInterstitialFragment$onViewCreated$2(this), 3, null);
        ViewParent parent = view.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup viewGroup = (ViewGroup) parent;
        kotlin.jvm.internal.m.f(c.h.k.s.a(viewGroup, new Runnable() { // from class: com.coinbase.wallet.consumer.views.ConsumerInterstitialFragment$onViewCreated$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                ConsumerInterstitialViewModel viewModel;
                viewModel = this.getViewModel();
                viewModel.setup();
                this.startPostponedEnterTransition();
            }
        }), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    public final void setConsumerInterstitialViewModelFactory(ConsumerInterstitialViewModel.Factory factory) {
        kotlin.jvm.internal.m.g(factory, "<set-?>");
        this.consumerInterstitialViewModelFactory = factory;
    }
}