package com.coinbase.wallet.features.cloudbackup.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.i;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.common.annotations.ScreenshotProtection;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.cloudbackup.models.BackupPayload;
import com.coinbase.wallet.features.cloudbackup.models.PasswordState;
import com.coinbase.wallet.features.cloudbackup.viewModel.EnterPasswordViewModel;
import com.toshi.view.custom.ProgressBarButton;
import com.toshi.view.fragment.o0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: EnterPasswordFragment.kt */
@ScreenshotProtection(behavior = ScreenshotProtection.Behavior.BLOCK)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u0007¢\u0006\u0004\b5\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010 \u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001d\u0010+\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\"8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010$R\u0016\u0010.\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00101\u001a\u0002008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/EnterPasswordFragment;", "Lcom/toshi/view/fragment/o0;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "initAccessibility", "()V", "initViewModel", "initViews", "initOnClicks", "initObservers", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/features/cloudbackup/viewModel/EnterPasswordViewModel;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler", "Lh/c/a0;", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "backup$delegate", "Lkotlin/h;", "getBackup", "()Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "backup", "getOnDestroyScopeProvider", "onDestroyScopeProvider", "viewModel", "Lcom/coinbase/wallet/features/cloudbackup/viewModel/EnterPasswordViewModel;", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EnterPasswordFragment extends o0 implements StyledFragment {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA__BACKUP = "extra__backup";
    private final StyledFragment.Attributes attributes;
    private final kotlin.h backup$delegate;
    private final h.c.a0 mainScheduler = h.c.j0.c.a.b();
    private EnterPasswordViewModel viewModel;
    public GenericViewModelFactory<EnterPasswordViewModel> viewModelFactory;

    /* compiled from: EnterPasswordFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/EnterPasswordFragment$Companion;", "", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "backup", "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;)Landroid/os/Bundle;", "", "EXTRA__BACKUP", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle createArguments(BackupPayload backup) {
            kotlin.jvm.internal.m.g(backup, "backup");
            Bundle bundle = new Bundle();
            bundle.putParcelable(EnterPasswordFragment.EXTRA__BACKUP, backup);
            return bundle;
        }
    }

    public EnterPasswordFragment() {
        kotlin.h b2;
        b2 = kotlin.k.b(new EnterPasswordFragment$backup$2(this));
        this.backup$delegate = b2;
        this.attributes = new StyledFragment.Attributes(true, false, false, 6, null);
    }

    public static /* synthetic */ void d(EnterPasswordFragment enterPasswordFragment, CharSequence charSequence) {
        m1243initViews$lambda0(enterPasswordFragment, charSequence);
    }

    public static /* synthetic */ void e(EnterPasswordFragment enterPasswordFragment, PasswordState passwordState) {
        m1242initObservers$lambda2(enterPasswordFragment, passwordState);
    }

    public static /* synthetic */ void f(EnterPasswordFragment enterPasswordFragment, CharSequence charSequence) {
        m1244initViews$lambda1(enterPasswordFragment, charSequence);
    }

    public final BackupPayload getBackup() {
        return (BackupPayload) this.backup$delegate.getValue();
    }

    public final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final void initAccessibility() {
        View view = getView();
        View passwordInput = view == null ? null : view.findViewById(e.j.a.passwordInput);
        kotlin.jvm.internal.m.f(passwordInput, "passwordInput");
        e.j.f.y.a(passwordInput);
    }

    private final void initObservers() {
        EnterPasswordViewModel enterPasswordViewModel = this.viewModel;
        if (enterPasswordViewModel != null) {
            h.c.s<PasswordState> observeOn = enterPasswordViewModel.getValidPasswordObservable().observeOn(this.mainScheduler);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.validPasswordObservable\n            .observeOn(mainScheduler)");
            ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(observeOn, "Error while observing password state.", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.w
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    EnterPasswordFragment.e(EnterPasswordFragment.this, (PasswordState) obj);
                }
            });
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: initObservers$lambda-2 */
    public static final void m1242initObservers$lambda2(EnterPasswordFragment this$0, PasswordState passwordState) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.continueButton))).setEnabled(passwordState == PasswordState.VALID);
    }

    private final void initOnClicks() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new EnterPasswordFragment$initOnClicks$1(this), 1, null);
        View view2 = getView();
        View continueButton = view2 != null ? view2.findViewById(e.j.a.continueButton) : null;
        kotlin.jvm.internal.m.f(continueButton, "continueButton");
        View_CommonKt.setOnSingleClickListener$default(continueButton, 0L, new EnterPasswordFragment$initOnClicks$2(this), 1, null);
    }

    private final void initViewModel() {
        androidx.lifecycle.b0 a = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(EnterPasswordViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (EnterPasswordViewModel) a;
    }

    private final void initViews() {
        View view = getView();
        h.c.s<CharSequence> doOnNext = e.h.a.d.c.a((TextView) (view == null ? null : view.findViewById(e.j.a.passwordInput))).doOnNext(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.v
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                EnterPasswordFragment.d(EnterPasswordFragment.this, (CharSequence) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnNext, "textChanges(passwordInput)\n            .doOnNext {\n                continueButton.background = requireDrawableById(R.drawable.button_primary)\n                continueButton.progressBarText = getString(R.string.label__continue)\n            }");
        ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(doOnNext, "Error while verifying password input", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.x
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                EnterPasswordFragment.f(EnterPasswordFragment.this, (CharSequence) obj);
            }
        });
    }

    /* renamed from: initViews$lambda-0 */
    public static final void m1243initViews$lambda0(EnterPasswordFragment this$0, CharSequence charSequence) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.continueButton))).setBackground(e.j.f.m.n(this$0, R.drawable.button_primary));
        View view2 = this$0.getView();
        ((ProgressBarButton) (view2 != null ? view2.findViewById(e.j.a.continueButton) : null)).setProgressBarText(this$0.getString(R.string.label__continue));
    }

    /* renamed from: initViews$lambda-1 */
    public static final void m1244initViews$lambda1(EnterPasswordFragment this$0, CharSequence it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        EnterPasswordViewModel enterPasswordViewModel = this$0.viewModel;
        if (enterPasswordViewModel == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.f(it, "it");
        enterPasswordViewModel.validatePassword(it);
    }

    @Override // com.toshi.view.fragment.o0, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return this.attributes;
    }

    public final GenericViewModelFactory<EnterPasswordViewModel> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<EnterPasswordViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_enter_password, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        initAccessibility();
        initViewModel();
        initViews();
        initOnClicks();
        initObservers();
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<EnterPasswordViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}