package com.coinbase.wallet.features.swap.views;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.fragment.app.z;
import androidx.recyclerview.widget.RecyclerView;
import c.h.k.d0;
import c.h.k.s;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.features.swap.viewmodels.SwapAssetPickerViewModel;
import com.coinbase.wallet.features.swap.views.adapters.SwapAssetPickerAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.uber.autodispose.d;
import com.uber.autodispose.x;
import com.uber.autodispose.y;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.k;
import org.toshi.R;

/* compiled from: SwapAssetPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001$\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b;\u0010\u0011J-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001d\u00105\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b3\u00104R\u001d\u0010:\u001a\u0002068B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010)\u001a\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/coinbase/wallet/features/swap/views/SwapAssetPickerFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lkotlin/x;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "Lc/h/k/d0;", "insets", "applyWindowInsets", "(Landroid/view/View;Lc/h/k/d0;)Lc/h/k/d0;", "Lcom/uber/autodispose/y;", "getScopeProvider", "()Lcom/uber/autodispose/y;", "scopeProvider", "Landroid/text/TextWatcher;", "searchFieldWatcher", "Landroid/text/TextWatcher;", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapAssetPickerViewModel$Factory;", "viewModelFactory", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapAssetPickerViewModel$Factory;", "getViewModelFactory", "()Lcom/coinbase/wallet/features/swap/viewmodels/SwapAssetPickerViewModel$Factory;", "setViewModelFactory", "(Lcom/coinbase/wallet/features/swap/viewmodels/SwapAssetPickerViewModel$Factory;)V", "com/coinbase/wallet/features/swap/views/SwapAssetPickerFragment$scrollListener$1", "scrollListener", "Lcom/coinbase/wallet/features/swap/views/SwapAssetPickerFragment$scrollListener$1;", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapAssetPickerViewModel;", "viewModel$delegate", "Lkotlin/h;", "getViewModel", "()Lcom/coinbase/wallet/features/swap/viewmodels/SwapAssetPickerViewModel;", "viewModel", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/features/swap/views/adapters/SwapAssetPickerAdapter;", "assetPickerAdapter$delegate", "getAssetPickerAdapter", "()Lcom/coinbase/wallet/features/swap/views/adapters/SwapAssetPickerAdapter;", "assetPickerAdapter", "", "headerElevation$delegate", "getHeaderElevation", "()F", "headerElevation", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAssetPickerFragment extends BaseFragment implements StyledFragment {
    private final h assetPickerAdapter$delegate;
    private final h headerElevation$delegate;
    private final SwapAssetPickerFragment$scrollListener$1 scrollListener;
    private TextWatcher searchFieldWatcher;
    private final h viewModel$delegate;
    public SwapAssetPickerViewModel.Factory viewModelFactory;

    /* JADX WARN: Type inference failed for: r0v4, types: [com.coinbase.wallet.features.swap.views.SwapAssetPickerFragment$scrollListener$1] */
    public SwapAssetPickerFragment() {
        h b2;
        h b3;
        b2 = k.b(new SwapAssetPickerFragment$headerElevation$2(this));
        this.headerElevation$delegate = b2;
        b3 = k.b(new SwapAssetPickerFragment$assetPickerAdapter$2(this));
        this.assetPickerAdapter$delegate = b3;
        this.scrollListener = new RecyclerView.t() { // from class: com.coinbase.wallet.features.swap.views.SwapAssetPickerFragment$scrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.t
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                float headerElevation;
                m.g(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i2, i3);
                if (!recyclerView.canScrollVertically(-1)) {
                    View view = SwapAssetPickerFragment.this.getView();
                    ((AppBarLayout) (view != null ? view.findViewById(e.j.a.appBarLayout) : null)).setElevation(0.0f);
                    return;
                }
                View view2 = SwapAssetPickerFragment.this.getView();
                View findViewById = view2 != null ? view2.findViewById(e.j.a.appBarLayout) : null;
                headerElevation = SwapAssetPickerFragment.this.getHeaderElevation();
                ((AppBarLayout) findViewById).setElevation(headerElevation);
            }
        };
        this.viewModel$delegate = z.a(this, e0.b(SwapAssetPickerViewModel.class), new SwapAssetPickerFragment$special$$inlined$viewModel$3(new SwapAssetPickerFragment$special$$inlined$viewModel$2(this)), new SwapAssetPickerFragment$special$$inlined$viewModel$1(this, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SwapAssetPickerAdapter getAssetPickerAdapter() {
        return (SwapAssetPickerAdapter) this.assetPickerAdapter$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getHeaderElevation() {
        return ((Number) this.headerElevation$delegate.getValue()).floatValue();
    }

    private final y getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SwapAssetPickerViewModel getViewModel() {
        return (SwapAssetPickerViewModel) this.viewModel$delegate.getValue();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 insets) {
        m.g(view, "view");
        m.g(insets, "insets");
        View view2 = getView();
        View currenciesRecyclerView = view2 == null ? null : view2.findViewById(e.j.a.currenciesRecyclerView);
        m.f(currenciesRecyclerView, "currenciesRecyclerView");
        currenciesRecyclerView.setPadding(currenciesRecyclerView.getPaddingLeft(), currenciesRecyclerView.getPaddingTop(), currenciesRecyclerView.getPaddingRight(), insets.i());
        return insets;
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 4, null);
    }

    public final SwapAssetPickerViewModel.Factory getViewModelFactory() {
        SwapAssetPickerViewModel.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_swap_asset_picker, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = getView();
        ((RecyclerView) (view == null ? null : view.findViewById(e.j.a.currenciesRecyclerView))).removeOnScrollListener(this.scrollListener);
        TextWatcher textWatcher = this.searchFieldWatcher;
        if (textWatcher == null) {
            return;
        }
        View view2 = getView();
        ((TextInputEditText) (view2 != null ? view2.findViewById(e.j.a.searchField) : null)).removeTextChangedListener(textWatcher);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        postponeEnterTransition();
        ViewParent parent = view.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup viewGroup = (ViewGroup) parent;
        m.f(s.a(viewGroup, new Runnable() { // from class: com.coinbase.wallet.features.swap.views.SwapAssetPickerFragment$onViewCreated$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                this.startPostponedEnterTransition();
            }
        }), "OneShotPreDrawListener.add(this) { action(this) }");
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(e.j.a.t0);
        m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new SwapAssetPickerFragment$onViewCreated$2(this), 1, null);
        View view3 = getView();
        ((RecyclerView) (view3 == null ? null : view3.findViewById(e.j.a.currenciesRecyclerView))).setAdapter(getAssetPickerAdapter());
        View view4 = getView();
        ((RecyclerView) (view4 == null ? null : view4.findViewById(e.j.a.currenciesRecyclerView))).addOnScrollListener(this.scrollListener);
        Object as = getViewModel().setup().as(d.a(getScopeProvider()));
        m.f(as, "viewModel.setup()\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as, null, null, null, 7, null);
        SwapAssetPickerViewModel viewModel = getViewModel();
        View view5 = getView();
        Editable text = ((TextInputEditText) (view5 == null ? null : view5.findViewById(e.j.a.searchField))).getText();
        String obj = text == null ? null : text.toString();
        if (obj == null) {
            obj = Strings_CoreKt.getEmpty(Strings.INSTANCE);
        }
        viewModel.setQuery(obj);
        View view6 = getView();
        View searchField = view6 != null ? view6.findViewById(e.j.a.searchField) : null;
        m.f(searchField, "searchField");
        TextWatcher textWatcher = new TextWatcher() { // from class: com.coinbase.wallet.features.swap.views.SwapAssetPickerFragment$onViewCreated$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                SwapAssetPickerViewModel viewModel2;
                String obj2 = editable == null ? null : editable.toString();
                if (obj2 == null) {
                    obj2 = Strings_CoreKt.getEmpty(Strings.INSTANCE);
                }
                viewModel2 = SwapAssetPickerFragment.this.getViewModel();
                viewModel2.setQuery(obj2);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        };
        ((TextView) searchField).addTextChangedListener(textWatcher);
        this.searchFieldWatcher = textWatcher;
        Object as2 = getViewModel().getDataObservable().as(d.a(getScopeProvider()));
        m.f(as2, "viewModel.dataObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as2, null, null, new SwapAssetPickerFragment$onViewCreated$4(this), 3, null);
        Object as3 = getViewModel().getStateObservable().as(d.a(getScopeProvider()));
        m.f(as3, "viewModel.stateObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as3, null, null, new SwapAssetPickerFragment$onViewCreated$5(this), 3, null);
        Object as4 = getViewModel().getSelectedAssetObservable().as(d.a(getScopeProvider()));
        m.f(as4, "viewModel.selectedAssetObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as4, null, null, new SwapAssetPickerFragment$onViewCreated$6(this), 3, null);
        Object as5 = getViewModel().getEventObservable().as(d.a(getScopeProvider()));
        m.f(as5, "viewModel.eventObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as5, null, null, new SwapAssetPickerFragment$onViewCreated$7(this), 3, null);
        Object as6 = getViewModel().getDismissObservable().as(d.a(getScopeProvider()));
        m.f(as6, "viewModel.dismissObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as6, null, null, new SwapAssetPickerFragment$onViewCreated$8(this), 3, null);
    }

    public final void setViewModelFactory(SwapAssetPickerViewModel.Factory factory) {
        m.g(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}