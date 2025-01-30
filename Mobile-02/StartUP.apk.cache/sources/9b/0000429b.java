package com.toshi.view.fragment;

import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.navigation.p;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.toshi.model.local.room.CollectibleType;
import com.toshi.model.local.room.Erc721Token;
import com.toshi.view.fragment.CollectibleDetailFragment;
import e.j.n.k3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: ViewCollectibleTypeFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001>B\u0007¢\u0006\u0004\b=\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u0006J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001e\u0010.\u001a\n +*\u0004\u0018\u00010*0*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R(\u00106\u001a\b\u0012\u0004\u0012\u0002000/8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b#\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001d\u0010\b\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\"\u001a\u0004\b8\u00109R\u0016\u0010<\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/toshi/view/fragment/ViewCollectibleTypeFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "initClickListeners", "()V", "Lcom/toshi/model/local/room/CollectibleType;", "collectibleType", "h", "(Lcom/toshi/model/local/room/CollectibleType;)V", "initViews", "initAdapter", "initObservers", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "onBackPressed", "()Z", "Le/j/m/a/b;", Constants.URL_CAMPAIGN, "Lkotlin/h;", "f", "()Le/j/m/a/b;", "collectibleAdapter", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lh/c/a0;", "kotlin.jvm.PlatformType", "e", "Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Le/j/n/k3;", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "d", "g", "()Lcom/toshi/model/local/room/CollectibleType;", "b", "Le/j/n/k3;", "viewModel", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ViewCollectibleTypeFragment extends LockedFragment implements StyledFragment, BackableFragment {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private k3 f11296b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.h f11297c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.h f11298d;

    /* renamed from: e  reason: collision with root package name */
    private final h.c.a0 f11299e;

    /* renamed from: f  reason: collision with root package name */
    public GenericViewModelFactory<k3> f11300f;

    /* compiled from: ViewCollectibleTypeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(CollectibleType collectibleType) {
            kotlin.jvm.internal.m.g(collectibleType, "collectibleType");
            Bundle bundle = new Bundle();
            bundle.putParcelable("collectibleType", collectibleType);
            return bundle;
        }
    }

    /* compiled from: ViewCollectibleTypeFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.a<e.j.m.a.b> {
        public static final b a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final e.j.m.a.b invoke() {
            return new e.j.m.a.b(null, 1, null);
        }
    }

    /* compiled from: ViewCollectibleTypeFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.a<CollectibleType> {
        c() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final CollectibleType invoke() {
            return (CollectibleType) e.j.f.e.b(ViewCollectibleTypeFragment.this.getArguments(), "collectibleType");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCollectibleTypeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.p<Erc721Token, View, kotlin.x> {
        d() {
            super(2);
        }

        public final void a(Erc721Token collectible, View imageView) {
            kotlin.jvm.internal.m.g(collectible, "collectible");
            kotlin.jvm.internal.m.g(imageView, "imageView");
            ViewCollectibleTypeFragment viewCollectibleTypeFragment = ViewCollectibleTypeFragment.this;
            CollectibleDetailFragment.a aVar = CollectibleDetailFragment.a;
            String name = viewCollectibleTypeFragment.g().getName();
            String transitionName = imageView.getTransitionName();
            kotlin.jvm.internal.m.f(transitionName, "imageView.transitionName");
            Fragment_CommonKt.navigate(viewCollectibleTypeFragment, R.id.action_viewCollectibleTypeFragment_to_collectibleDetailFragment, aVar.a(collectible, name, transitionName), new p.a().b(R.anim.fade_in_short).c(R.anim.fade_out_short).f(R.anim.fade_out_short).e(R.anim.fade_in_short).a(), aVar.b(imageView));
        }

        @Override // kotlin.e0.c.p
        public /* bridge */ /* synthetic */ kotlin.x invoke(Erc721Token erc721Token, View view) {
            a(erc721Token, view);
            return kotlin.x.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCollectibleTypeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        e() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigateUp(ViewCollectibleTypeFragment.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCollectibleTypeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
        f() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            e.j.f.m.v(ViewCollectibleTypeFragment.this, "Error while fetching collectibles", 0, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCollectibleTypeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends Erc721Token>, kotlin.x> {
        g() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(List<? extends Erc721Token> list) {
            invoke2((List<Erc721Token>) list);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<Erc721Token> it) {
            e.j.m.a.b f2 = ViewCollectibleTypeFragment.this.f();
            kotlin.jvm.internal.m.f(it, "it");
            f2.d(it);
        }
    }

    public ViewCollectibleTypeFragment() {
        kotlin.h b2;
        kotlin.h b3;
        b2 = kotlin.k.b(b.a);
        this.f11297c = b2;
        b3 = kotlin.k.b(new c());
        this.f11298d = b3;
        this.f11299e = h.c.j0.c.a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e.j.m.a.b f() {
        return (e.j.m.a.b) this.f11297c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CollectibleType g() {
        return (CollectibleType) this.f11298d.getValue();
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final void h(CollectibleType collectibleType) {
        androidx.lifecycle.b0 a2 = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(k3.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        k3 k3Var = (k3) a2;
        this.f11296b = k3Var;
        if (k3Var != null) {
            k3Var.f(collectibleType);
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    private final void initAdapter() {
        f().e(new d());
        View view = getView();
        ((RecyclerView) (view == null ? null : view.findViewById(e.j.a.recyclerView))).setAdapter(f());
    }

    private final void initClickListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new e(), 1, null);
    }

    private final void initObservers() {
        k3 k3Var = this.f11296b;
        if (k3Var != null) {
            h.c.s<List<Erc721Token>> observeOn = k3Var.d().observeOn(this.f11299e);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.erc721TokensObservable\n            .observeOn(mainScheduler)");
            Object as = Observable_AnalyticsKt.logError$default(observeOn, "Error fetching collectibles", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.erc721TokensObservable\n            .observeOn(mainScheduler)\n            .logError(\"Error fetching collectibles\")\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, new f(), null, new g(), 2, null);
            k3 k3Var2 = this.f11296b;
            if (k3Var2 != null) {
                k3Var2.c();
                return;
            } else {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void initViews() {
        View view = getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.toolbarTitle))).setText(g().getName());
        View view2 = getView();
        RecyclerView recyclerView = (RecyclerView) (view2 == null ? null : view2.findViewById(e.j.a.recyclerView));
        View view3 = getView();
        RecyclerView.o layoutManager = ((RecyclerView) (view3 != null ? view3.findViewById(e.j.a.recyclerView) : null)).getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        recyclerView.addItemDecoration(new e.j.m.b.a(((GridLayoutManager) layoutManager).g3(), getResources().getDimensionPixelSize(R.dimen.view_size_16), getResources().getDimensionPixelSize(R.dimen.view_size_16)));
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
        return StyledFragment.DefaultImpls.getAttributes(this);
    }

    public final GenericViewModelFactory<k3> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<k3> genericViewModelFactory = this.f11300f;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSharedElementReturnTransition(TransitionInflater.from(getContext()).inflateTransition(R.transition.image_shared_element_transition));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_view_erc721_tokens, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.collectibleTypeLanded(AnalyticsEvent.Companion, g().getName()));
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        initClickListeners();
        h(g());
        initViews();
        initAdapter();
        initObservers();
    }
}