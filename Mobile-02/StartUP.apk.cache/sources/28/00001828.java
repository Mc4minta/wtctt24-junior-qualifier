package com.coinbase.wallet.consumer.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.z;
import androidx.lifecycle.i;
import androidx.recyclerview.widget.RecyclerView;
import c.h.k.d0;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.common.annotations.ScreenshotProtection;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.models.UserProperties;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.utilities.ActionSheetDialogHelper;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAccountsViewModel;
import com.coinbase.wallet.consumer.views.adapter.ConsumerAccountsAdapter;
import h.c.a0;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.e0;

/* compiled from: ConsumerFragment.kt */
@ScreenshotProtection(behavior = ScreenshotProtection.Behavior.BLOCK)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b@\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0006J-\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\"\u0010+\u001a\u00020*8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00103\u001a\n 2*\u0004\u0018\u000101018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002058B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\"\u0010>\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u00040<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "initView", "()V", "switchToLoadingView", "showSplashScreen", "switchToAccountsView", "setupOnClickListeners", "settingsBottomSheet", "handleDisconnect", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "onBackPressed", "()Z", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAccountsViewModel;", "accountsViewModel$delegate", "Lkotlin/h;", "getAccountsViewModel", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAccountsViewModel;", "accountsViewModel", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAccountsViewModel$Factory;", "accountsViewModelFactory", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAccountsViewModel$Factory;", "getAccountsViewModelFactory$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAccountsViewModel$Factory;", "setAccountsViewModelFactory$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAccountsViewModel$Factory;)V", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler", "Lh/c/a0;", "Lcom/uber/autodispose/y;", "getScopeProvider", "()Lcom/uber/autodispose/y;", "scopeProvider", "Lcom/coinbase/wallet/consumer/views/adapter/ConsumerAccountsAdapter;", "accountsAdapter", "Lcom/coinbase/wallet/consumer/views/adapter/ConsumerAccountsAdapter;", "Lkotlin/Function1;", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "supportedAccountClickListener", "Lkotlin/e0/c/l;", "<init>", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerFragment extends LockedFragment implements StyledFragment, BackableFragment {
    private final ConsumerAccountsAdapter accountsAdapter;
    private final kotlin.h accountsViewModel$delegate;
    public ConsumerAccountsViewModel.Factory accountsViewModelFactory;
    private final a0 mainScheduler = h.c.j0.c.a.b();
    private final kotlin.e0.c.l<ConsumerAccount, kotlin.x> supportedAccountClickListener;

    public ConsumerFragment() {
        ConsumerFragment$supportedAccountClickListener$1 consumerFragment$supportedAccountClickListener$1 = new ConsumerFragment$supportedAccountClickListener$1(this);
        this.supportedAccountClickListener = consumerFragment$supportedAccountClickListener$1;
        this.accountsAdapter = new ConsumerAccountsAdapter(consumerFragment$supportedAccountClickListener$1);
        this.accountsViewModel$delegate = z.a(this, e0.b(ConsumerAccountsViewModel.class), new ConsumerFragment$special$$inlined$viewModel$3(new ConsumerFragment$special$$inlined$viewModel$2(this)), new ConsumerFragment$special$$inlined$viewModel$1(this, this));
    }

    public static /* synthetic */ void d(ConsumerFragment consumerFragment, Throwable th) {
        m1033handleDisconnect$lambda3(consumerFragment, th);
    }

    public static /* synthetic */ void e(ConsumerFragment consumerFragment, kotlin.x xVar) {
        m1032handleDisconnect$lambda2(consumerFragment, xVar);
    }

    public final ConsumerAccountsViewModel getAccountsViewModel() {
        return (ConsumerAccountsViewModel) this.accountsViewModel$delegate.getValue();
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final com.uber.autodispose.y getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    public final void handleDisconnect() {
        ((com.uber.autodispose.a0) getAccountsViewModel().revokeToken().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.views.d
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ConsumerFragment.e(ConsumerFragment.this, (kotlin.x) obj);
            }
        }, new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.views.c
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ConsumerFragment.d(ConsumerFragment.this, (Throwable) obj);
            }
        });
    }

    /* renamed from: handleDisconnect$lambda-2 */
    public static final void m1032handleDisconnect$lambda2(ConsumerFragment this$0, kotlin.x xVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Analytics analytics = Analytics.INSTANCE;
        analytics.log(AnalyticsEvent_ConsumerKt.consumerConnectDisconnected(AnalyticsEvent.Companion));
        analytics.setUserProperties(UserProperties.INSTANCE.getConsumerConnectDeactivated());
        Fragment_CommonKt.navigateUp(this$0);
    }

    /* renamed from: handleDisconnect$lambda-3 */
    public static final void m1033handleDisconnect$lambda3(ConsumerFragment this$0, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Fragment_CommonKt.navigateUp(this$0);
    }

    private final void initView() {
        View view = getView();
        ((RecyclerView) (view == null ? null : view.findViewById(R.id.accountList))).setAdapter(this.accountsAdapter);
    }

    public final void settingsBottomSheet() {
        ArrayList arrayList = new ArrayList();
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        ActionSheetDialogHelper.Action action = new ActionSheetDialogHelper.Action(localizedStrings.get(R.string.add_payment_method), ActionStyle.NEUTRAL, new ConsumerFragment$settingsBottomSheet$addPaymentMethodOption$1(this));
        ActionSheetDialogHelper.Action action2 = new ActionSheetDialogHelper.Action(localizedStrings.get(R.string.disconnect_account), ActionStyle.NEGATIVE, new ConsumerFragment$settingsBottomSheet$disconnectAccountOption$1(this));
        if (getAccountsViewModel().getOnrampEnabled()) {
            arrayList.add(action);
        }
        arrayList.add(action2);
        ActionSheetDialogHelper.INSTANCE.show(this, new ActionSheetDialogHelper.Properties(localizedStrings.get(R.string.consumer_settings_title), arrayList, false, null, null, 28, null));
    }

    private final void setupOnClickListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(R.id.closeButton);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new ConsumerFragment$setupOnClickListeners$1(this), 1, null);
        View view2 = getView();
        View settingsButton = view2 == null ? null : view2.findViewById(R.id.settingsButton);
        kotlin.jvm.internal.m.f(settingsButton, "settingsButton");
        View_CommonKt.setOnSingleClickListener$default(settingsButton, 0L, new ConsumerFragment$setupOnClickListeners$2(this), 1, null);
        View view3 = getView();
        View startTransferBtn = view3 == null ? null : view3.findViewById(R.id.startTransferBtn);
        kotlin.jvm.internal.m.f(startTransferBtn, "startTransferBtn");
        View_CommonKt.setOnSingleClickListener$default(startTransferBtn, 0L, new ConsumerFragment$setupOnClickListeners$3(this), 1, null);
        View view4 = getView();
        View transferLaterBtn = view4 != null ? view4.findViewById(R.id.transferLaterBtn) : null;
        kotlin.jvm.internal.m.f(transferLaterBtn, "transferLaterBtn");
        View_CommonKt.setOnSingleClickListener$default(transferLaterBtn, 0L, new ConsumerFragment$setupOnClickListeners$4(this), 1, null);
    }

    public final void showSplashScreen() {
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerSplashScreenViewed(AnalyticsEvent.Companion));
        View view = getView();
        ((ProgressBar) (view == null ? null : view.findViewById(R.id.progress))).setVisibility(4);
        View view2 = getView();
        ((ConstraintLayout) (view2 == null ? null : view2.findViewById(R.id.accountsContainer))).setVisibility(8);
        View view3 = getView();
        ((ConstraintLayout) (view3 != null ? view3.findViewById(R.id.splashScreen) : null)).setVisibility(0);
    }

    public final void switchToAccountsView() {
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerAccountsViewed(AnalyticsEvent.Companion, getAccountsViewModel().getOnrampEnabled()));
        View view = getView();
        ((ProgressBar) (view == null ? null : view.findViewById(R.id.progress))).setVisibility(4);
        View view2 = getView();
        ((ConstraintLayout) (view2 == null ? null : view2.findViewById(R.id.accountsContainer))).setVisibility(0);
        View view3 = getView();
        ((ConstraintLayout) (view3 != null ? view3.findViewById(R.id.splashScreen) : null)).setVisibility(8);
    }

    public final void switchToLoadingView() {
        View view = getView();
        ((ProgressBar) (view == null ? null : view.findViewById(R.id.progress))).setVisibility(0);
        View view2 = getView();
        ((ConstraintLayout) (view2 == null ? null : view2.findViewById(R.id.accountsContainer))).setVisibility(8);
        View view3 = getView();
        ((ConstraintLayout) (view3 != null ? view3.findViewById(R.id.splashScreen) : null)).setVisibility(8);
    }

    @Override // com.coinbase.wallet.commonui.views.LockedFragment, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    public final ConsumerAccountsViewModel.Factory getAccountsViewModelFactory$consumer_productionRelease() {
        ConsumerAccountsViewModel.Factory factory = this.accountsViewModelFactory;
        if (factory != null) {
            return factory;
        }
        kotlin.jvm.internal.m.w("accountsViewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 6, null);
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_consumer, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        setupOnClickListeners();
        initView();
        Object as = getAccountsViewModel().getStateObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as, "accountsViewModel.stateObservable\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new ConsumerFragment$onViewCreated$1(this), 3, null);
        Object as2 = getAccountsViewModel().getEventsObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as2, "accountsViewModel.eventsObservable\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new ConsumerFragment$onViewCreated$2(this), 3, null);
        Object as3 = getAccountsViewModel().getNavigationObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as3, "accountsViewModel.navigationObservable\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new ConsumerFragment$onViewCreated$3(this), 3, null);
        Object as4 = getAccountsViewModel().getDismissObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as4, "accountsViewModel.dismissObservable\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as4, null, null, new ConsumerFragment$onViewCreated$4(this), 3, null);
        ConsumerAccountsViewModel accountsViewModel = getAccountsViewModel();
        androidx.navigation.e h2 = androidx.navigation.fragment.a.a(this).h();
        accountsViewModel.setup(h2 == null ? null : h2.d());
    }

    public final void setAccountsViewModelFactory$consumer_productionRelease(ConsumerAccountsViewModel.Factory factory) {
        kotlin.jvm.internal.m.g(factory, "<set-?>");
        this.accountsViewModelFactory = factory;
    }
}