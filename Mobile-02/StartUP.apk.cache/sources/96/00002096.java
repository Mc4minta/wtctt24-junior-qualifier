package com.coinbase.wallet.features.send.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.utilities.ViewModelFactoryWithMap;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.send.viewmodels.CompleteViewModel;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: CompleteFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0007¢\u0006\u0004\b&\u0010\u0011J-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00168\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u00020 8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/coinbase/wallet/features/send/views/CompleteFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lkotlin/x;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/commonui/utilities/ViewModelFactoryWithMap;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/utilities/ViewModelFactoryWithMap;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/utilities/ViewModelFactoryWithMap;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/utilities/ViewModelFactoryWithMap;)V", "Lcom/coinbase/wallet/features/send/viewmodels/CompleteViewModel;", "viewModel", "Lcom/coinbase/wallet/features/send/viewmodels/CompleteViewModel;", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes$delegate", "Lkotlin/h;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CompleteFragment extends BaseFragment implements StyledFragment {
    public static final Companion Companion = new Companion(null);
    private static final String TAG;
    private final kotlin.h attributes$delegate;
    private CompleteViewModel viewModel;
    public ViewModelFactoryWithMap viewModelFactory;

    /* compiled from: CompleteFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/send/views/CompleteFragment$Companion;", "", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return CompleteFragment.TAG;
        }
    }

    static {
        String simpleName = CompleteFragment.class.getSimpleName();
        kotlin.jvm.internal.m.f(simpleName, "CompleteFragment::class.java.simpleName");
        TAG = simpleName;
    }

    public CompleteFragment() {
        kotlin.h b2;
        b2 = kotlin.k.b(new CompleteFragment$attributes$2(this));
        this.attributes$delegate = b2;
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return (StyledFragment.Attributes) this.attributes$delegate.getValue();
    }

    public final ViewModelFactoryWithMap getViewModelFactory$app_productionRelease() {
        ViewModelFactoryWithMap viewModelFactoryWithMap = this.viewModelFactory;
        if (viewModelFactoryWithMap != null) {
            return viewModelFactoryWithMap;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_complete, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Object as = h.c.b0.just(kotlin.x.a).delay(2000L, TimeUnit.MILLISECONDS).observeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as, "just(Unit)\n            .delay(2000, TimeUnit.MILLISECONDS)\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(scopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new CompleteFragment$onResume$1(this), 1, null);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String name = CompleteViewModel.class.getName();
        kotlin.jvm.internal.m.f(name, "CompleteViewModel::class.java.name");
        Serializable c2 = e.j.f.e.c(arguments, name);
        if (c2 != null) {
            if (c2 instanceof Class) {
                Class cls = (Class) c2;
                if (CompleteViewModel.class.isAssignableFrom(cls)) {
                    androidx.lifecycle.b0 a = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(cls);
                    kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory)\n            .get(clazz)");
                    CompleteViewModel completeViewModel = (CompleteViewModel) a;
                    Bundle requireArguments = requireArguments();
                    kotlin.jvm.internal.m.f(requireArguments, "requireArguments()");
                    completeViewModel.setArgs(requireArguments);
                    kotlin.x xVar = kotlin.x.a;
                    this.viewModel = completeViewModel;
                    View view2 = getView();
                    TextView textView = (TextView) (view2 == null ? null : view2.findViewById(e.j.a.messageLabel));
                    CompleteViewModel completeViewModel2 = this.viewModel;
                    if (completeViewModel2 != null) {
                        textView.setText(completeViewModel2.getMessage());
                        return;
                    } else {
                        kotlin.jvm.internal.m.w("viewModel");
                        throw null;
                    }
                }
            }
            throw new IllegalStateException("Class " + c2 + " is not assignable from " + CompleteViewModel.class);
        }
        throw new IllegalStateException("Class this is null");
    }

    public final void setViewModelFactory$app_productionRelease(ViewModelFactoryWithMap viewModelFactoryWithMap) {
        kotlin.jvm.internal.m.g(viewModelFactoryWithMap, "<set-?>");
        this.viewModelFactory = viewModelFactoryWithMap;
    }
}