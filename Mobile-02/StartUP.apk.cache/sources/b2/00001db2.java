package com.coinbase.wallet.features.cloudbackup.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.constraintlayout.helper.widget.Layer;
import com.coinbase.wallet.application.MainActivity;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.utilities.Colors;
import com.coinbase.wallet.commonui.utilities.ColorsKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.cloudbackup.viewModel.OnboardingBackupRecoveryPhraseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.e0;
import org.toshi.R;

/* compiled from: OnboardingBackupRecoveryPhraseFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b(\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/OnboardingBackupRecoveryPhraseFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setupObservables", "()V", "setupViews", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "onBackPressed", "()Z", "Lcom/coinbase/wallet/features/cloudbackup/viewModel/OnboardingBackupRecoveryPhraseViewModel;", "viewModel$delegate", "Lkotlin/h;", "getViewModel", "()Lcom/coinbase/wallet/features/cloudbackup/viewModel/OnboardingBackupRecoveryPhraseViewModel;", "viewModel", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/features/cloudbackup/viewModel/OnboardingBackupRecoveryPhraseViewModel$Factory;", "viewModelFactory", "Lcom/coinbase/wallet/features/cloudbackup/viewModel/OnboardingBackupRecoveryPhraseViewModel$Factory;", "getViewModelFactory", "()Lcom/coinbase/wallet/features/cloudbackup/viewModel/OnboardingBackupRecoveryPhraseViewModel$Factory;", "setViewModelFactory", "(Lcom/coinbase/wallet/features/cloudbackup/viewModel/OnboardingBackupRecoveryPhraseViewModel$Factory;)V", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class OnboardingBackupRecoveryPhraseFragment extends BaseFragment implements BackableFragment, StyledFragment {
    private final kotlin.h viewModel$delegate = androidx.fragment.app.z.a(this, e0.b(OnboardingBackupRecoveryPhraseViewModel.class), new OnboardingBackupRecoveryPhraseFragment$special$$inlined$viewModel$3(new OnboardingBackupRecoveryPhraseFragment$special$$inlined$viewModel$2(this)), new OnboardingBackupRecoveryPhraseFragment$special$$inlined$viewModel$1(this, this));
    public OnboardingBackupRecoveryPhraseViewModel.Factory viewModelFactory;

    public static /* synthetic */ void d(OnboardingBackupRecoveryPhraseFragment onboardingBackupRecoveryPhraseFragment, View view) {
        m1246setupViews$lambda1(onboardingBackupRecoveryPhraseFragment, view);
    }

    public static /* synthetic */ void e(OnboardingBackupRecoveryPhraseFragment onboardingBackupRecoveryPhraseFragment, View view) {
        m1247setupViews$lambda2(onboardingBackupRecoveryPhraseFragment, view);
    }

    public static /* synthetic */ void f(OnboardingBackupRecoveryPhraseFragment onboardingBackupRecoveryPhraseFragment, CompoundButton compoundButton, boolean z) {
        m1249setupViews$lambda4(onboardingBackupRecoveryPhraseFragment, compoundButton, z);
    }

    public static /* synthetic */ void g(OnboardingBackupRecoveryPhraseFragment onboardingBackupRecoveryPhraseFragment, View view) {
        m1248setupViews$lambda3(onboardingBackupRecoveryPhraseFragment, view);
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final OnboardingBackupRecoveryPhraseViewModel getViewModel() {
        return (OnboardingBackupRecoveryPhraseViewModel) this.viewModel$delegate.getValue();
    }

    private final void setupObservables() {
        Object as = getViewModel().getNavigationObservable().subscribeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as, "viewModel.navigationObservable\n            .subscribeOn(AndroidSchedulers.mainThread())\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new OnboardingBackupRecoveryPhraseFragment$setupObservables$1(this), 3, null);
    }

    private final void setupViews() {
        View view = getView();
        ((Button) (view == null ? null : view.findViewById(e.j.a.backupNowButton))).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.cloudbackup.view.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnboardingBackupRecoveryPhraseFragment.d(OnboardingBackupRecoveryPhraseFragment.this, view2);
            }
        });
        View view2 = getView();
        ((Button) (view2 == null ? null : view2.findViewById(e.j.a.backupLaterButton))).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.cloudbackup.view.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                OnboardingBackupRecoveryPhraseFragment.e(OnboardingBackupRecoveryPhraseFragment.this, view3);
            }
        });
        View view3 = getView();
        ((Layer) (view3 == null ? null : view3.findViewById(e.j.a.checkboxLayer))).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.cloudbackup.view.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                OnboardingBackupRecoveryPhraseFragment.g(OnboardingBackupRecoveryPhraseFragment.this, view4);
            }
        });
        View view4 = getView();
        ((CheckBox) (view4 != null ? view4.findViewById(e.j.a.backupCheckbox) : null)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.coinbase.wallet.features.cloudbackup.view.b0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                OnboardingBackupRecoveryPhraseFragment.f(OnboardingBackupRecoveryPhraseFragment.this, compoundButton, z);
            }
        });
    }

    /* renamed from: setupViews$lambda-1 */
    public static final void m1246setupViews$lambda1(OnboardingBackupRecoveryPhraseFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.getViewModel().backupMnemonic();
    }

    /* renamed from: setupViews$lambda-2 */
    public static final void m1247setupViews$lambda2(OnboardingBackupRecoveryPhraseFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getActivity(), MainActivity.class));
        androidx.fragment.app.d activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* renamed from: setupViews$lambda-3 */
    public static final void m1248setupViews$lambda3(OnboardingBackupRecoveryPhraseFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view2 = this$0.getView();
        ((CheckBox) (view2 == null ? null : view2.findViewById(e.j.a.backupCheckbox))).performClick();
    }

    /* renamed from: setupViews$lambda-4 */
    public static final void m1249setupViews$lambda4(OnboardingBackupRecoveryPhraseFragment this$0, CompoundButton compoundButton, boolean z) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((Button) (view == null ? null : view.findViewById(e.j.a.backupNowButton))).setEnabled(z);
        View view2 = this$0.getView();
        ((Button) (view2 == null ? null : view2.findViewById(e.j.a.backupLaterButton))).setEnabled(z);
        View view3 = this$0.getView();
        ((Button) (view3 != null ? view3.findViewById(e.j.a.backupLaterButton) : null)).setTextColor(ColorsKt.get(Colors.INSTANCE, z ? R.color.primary_blue : R.color.disabled_blue));
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
        return StyledFragment.DefaultImpls.getAttributes(this);
    }

    public final OnboardingBackupRecoveryPhraseViewModel.Factory getViewModelFactory() {
        OnboardingBackupRecoveryPhraseViewModel.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_onboarding_backup_recovery_phrase, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        setupViews();
        setupObservables();
    }

    public final void setViewModelFactory(OnboardingBackupRecoveryPhraseViewModel.Factory factory) {
        kotlin.jvm.internal.m.g(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}