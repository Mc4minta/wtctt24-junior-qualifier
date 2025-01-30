package com.coinbase.wallet.features.lend.views;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.b0;
import c.h.k.d0;
import c.h.k.s;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.features.lend.viewmodels.LendViewModel;
import com.uber.autodispose.y;
import h.c.a0;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: LendInterstitialFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b2\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J!\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R%\u0010*\u001a\n %*\u0004\u0018\u00010$0$8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R$\u0010,\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010\u00030\u00030+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/LendInterstitialFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setupObservers", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onResume", "onPause", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/coinbase/wallet/features/lend/viewmodels/LendViewModel;", "lendViewModel", "Lcom/coinbase/wallet/features/lend/viewmodels/LendViewModel;", "Lcom/uber/autodispose/y;", "getScopeProvider", "()Lcom/uber/autodispose/y;", "scopeProvider", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "lendViewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getLendViewModelFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setLendViewModelFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler$delegate", "Lkotlin/h;", "getMainScheduler", "()Lh/c/a0;", "mainScheduler", "Lh/c/v0/a;", "animationEndedSubject", "Lh/c/v0/a;", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendInterstitialFragment extends BaseFragment implements StyledFragment {
    public static final Companion Companion = new Companion(null);
    private static final String SHOULD_FINISH = "shouldFinish";
    private final h.c.v0.a<x> animationEndedSubject;
    private LendViewModel lendViewModel;
    public GenericViewModelFactory<LendViewModel> lendViewModelFactory;
    private final h mainScheduler$delegate;

    /* compiled from: LendInterstitialFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/LendInterstitialFragment$Companion;", "", "", "SHOULD_FINISH", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LendInterstitialFragment() {
        h b2;
        h.c.v0.a<x> d2 = h.c.v0.a.d();
        m.f(d2, "create<Unit>()");
        this.animationEndedSubject = d2;
        b2 = k.b(LendInterstitialFragment$mainScheduler$2.INSTANCE);
        this.mainScheduler$delegate = b2;
    }

    public static final /* synthetic */ h.c.v0.a access$getAnimationEndedSubject$p(LendInterstitialFragment lendInterstitialFragment) {
        return lendInterstitialFragment.animationEndedSubject;
    }

    private final a0 getMainScheduler() {
        return (a0) this.mainScheduler$delegate.getValue();
    }

    private final y getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    public final void setupObservers() {
        Object as = Observable_CoreKt.takeSingle(this.animationEndedSubject).observeOn(getMainScheduler()).as(com.uber.autodispose.d.a(getScopeProvider()));
        m.f(as, "animationEndedSubject.takeSingle()\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new LendInterstitialFragment$setupObservers$1(this), 1, null);
        h.c.t0.e eVar = h.c.t0.e.a;
        LendViewModel lendViewModel = this.lendViewModel;
        if (lendViewModel != null) {
            Object as2 = eVar.a(lendViewModel.getLendNavRoute(), Observable_CoreKt.takeSingle(this.animationEndedSubject)).observeOn(getMainScheduler()).as(com.uber.autodispose.d.a(getScopeProvider()));
            m.f(as2, "Singles\n            .zip(lendViewModel.getLendNavRoute(), animationEndedSubject.takeSingle())\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as2, null, new LendInterstitialFragment$setupObservers$2(this), 1, null);
            return;
        }
        m.w("lendViewModel");
        throw null;
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

    public final GenericViewModelFactory<LendViewModel> getLendViewModelFactory() {
        GenericViewModelFactory<LendViewModel> genericViewModelFactory = this.lendViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("lendViewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(300L);
        changeBounds.addListener(new Transition.TransitionListener() { // from class: com.coinbase.wallet.features.lend.views.LendInterstitialFragment$onCreate$$inlined$doOnEnd$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                m.g(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                m.g(transition, "transition");
                LendInterstitialFragment.access$getAnimationEndedSubject$p(LendInterstitialFragment.this).onNext(x.a);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                m.g(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                m.g(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                m.g(transition, "transition");
            }
        });
        setSharedElementEnterTransition(changeBounds);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_interstitial, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = androidx.core.os.b.a(new o[0]);
        }
        setArguments(arguments);
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            return;
        }
        arguments2.putBoolean(SHOULD_FINISH, true);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Bundle arguments = getArguments();
        boolean z = false;
        if (arguments != null && arguments.getBoolean(SHOULD_FINISH)) {
            z = true;
        }
        if (z) {
            e.j.f.m.l(this);
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        postponeEnterTransition();
        Bundle arguments = getArguments();
        final boolean z = false;
        if (arguments != null && arguments.getBoolean(SHOULD_FINISH)) {
            z = true;
        }
        ViewParent parent = view.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup viewGroup = (ViewGroup) parent;
        m.f(s.a(viewGroup, new Runnable() { // from class: com.coinbase.wallet.features.lend.views.LendInterstitialFragment$onViewCreated$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                if (z) {
                    e.j.f.m.l(this);
                } else {
                    LendInterstitialFragment lendInterstitialFragment = this;
                    b0 a = new androidx.lifecycle.d0(lendInterstitialFragment, lendInterstitialFragment.getLendViewModelFactory()).a(LendViewModel.class);
                    m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
                    lendInterstitialFragment.lendViewModel = (LendViewModel) a;
                    this.setupObservers();
                }
                this.startPostponedEnterTransition();
            }
        }), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    public final void setLendViewModelFactory(GenericViewModelFactory<LendViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.lendViewModelFactory = genericViewModelFactory;
    }
}