package com.coinbase.wallet.features.cloudbackup.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.i;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.annotations.ScreenshotProtection;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.models.UserProperties;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.cloudbackup.models.PasswordMatchState;
import com.coinbase.wallet.features.cloudbackup.viewModel.CreatePasswordViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.toshi.view.custom.ProgressBarButton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: CreatePasswordFragment.kt */
@ScreenshotProtection(behavior = ScreenshotProtection.Behavior.BLOCK)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EB\u0007¢\u0006\u0004\bD\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0006J!\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b!\u0010\"J)\u0010'\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001e\u00102\u001a\n 1*\u0004\u0018\u000100008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u0002078B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R(\u0010<\u001a\b\u0012\u0004\u0012\u0002040;8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010C\u001a\u0002078B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u00109¨\u0006F"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/CreatePasswordFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "init", "()V", "initViewModel", "initSoftInputMode", "initTextWatchers", "initClickListeners", "initObservers", "handleCreatePassword", "", "throwable", "", "recoveryRequestCode", "handleFetchBackupStatusException", "(Ljava/lang/Throwable;I)V", "Lcom/coinbase/wallet/features/cloudbackup/models/PasswordMatchState;", "passwordMatchState", "handlePasswordMatchStateChange", "(Lcom/coinbase/wallet/features/cloudbackup/models/PasswordMatchState;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "onBackPressed", "()Z", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler", "Lh/c/a0;", "Lcom/coinbase/wallet/features/cloudbackup/viewModel/CreatePasswordViewModel;", "viewModel", "Lcom/coinbase/wallet/features/cloudbackup/viewModel/CreatePasswordViewModel;", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "getOnDestroyScopeProvider", "onDestroyScopeProvider", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CreatePasswordFragment extends BaseFragment implements StyledFragment, BackableFragment {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_MNEMONIC = "extra_mnemonic";
    private static final int RETRY_BACKUP_REQUEST_CODE = 1;
    private static final int RETRY_BACKUP_STATUS_REQUEST_CODE = 2;
    private final h.c.a0 mainScheduler = h.c.j0.c.a.b();
    private CreatePasswordViewModel viewModel;
    public GenericViewModelFactory<CreatePasswordViewModel> viewModelFactory;

    /* compiled from: CreatePasswordFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/CreatePasswordFragment$Companion;", "", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Landroid/os/Bundle;", "createArguments", "(Ljava/lang/String;)Landroid/os/Bundle;", "EXTRA_MNEMONIC", "Ljava/lang/String;", "", "RETRY_BACKUP_REQUEST_CODE", "I", "RETRY_BACKUP_STATUS_REQUEST_CODE", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle createArguments(String mnemonic) {
            kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
            Bundle bundle = new Bundle();
            bundle.putString(CreatePasswordFragment.EXTRA_MNEMONIC, mnemonic);
            return bundle;
        }
    }

    /* compiled from: CreatePasswordFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PasswordMatchState.values().length];
            iArr[PasswordMatchState.DONT_MATCH.ordinal()] = 1;
            iArr[PasswordMatchState.MATCH.ordinal()] = 2;
            iArr[PasswordMatchState.NO_MESSAGE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void d(CreatePasswordFragment createPasswordFragment, PasswordMatchState passwordMatchState) {
        m1229initObservers$lambda11(createPasswordFragment, passwordMatchState);
    }

    public static /* synthetic */ void e(CreatePasswordFragment createPasswordFragment, CharSequence charSequence) {
        m1230initTextWatchers$lambda0(createPasswordFragment, charSequence);
    }

    public static /* synthetic */ void f(Throwable th) {
        m1231initTextWatchers$lambda1(th);
    }

    public static /* synthetic */ void g(Throwable th) {
        m1234initTextWatchers$lambda3(th);
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    public static /* synthetic */ void h(CreatePasswordFragment createPasswordFragment, Boolean bool) {
        m1227handleCreatePassword$lambda12(createPasswordFragment, bool);
    }

    public final void handleCreatePassword() {
        View view = getView();
        ((ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.createPasswordBtn))).setProgressBarIsVisible(true);
        InputMethodManager c2 = e.j.f.m.c(this);
        if (c2 != null) {
            View view2 = getView();
            c2.hideSoftInputFromWindow(((ImageButton) (view2 == null ? null : view2.findViewById(e.j.a.t0))).getWindowToken(), 0);
        }
        CreatePasswordViewModel createPasswordViewModel = this.viewModel;
        if (createPasswordViewModel != null) {
            View view3 = getView();
            ((com.uber.autodispose.a0) createPasswordViewModel.backupMnemonic(String.valueOf(((TextInputEditText) (view3 != null ? view3.findViewById(e.j.a.verifyPasswordInput) : null)).getText()), e.j.f.e.d(getArguments(), EXTRA_MNEMONIC)).observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.k
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    CreatePasswordFragment.h(CreatePasswordFragment.this, (Boolean) obj);
                }
            }, new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.n
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    CreatePasswordFragment.k(CreatePasswordFragment.this, (Throwable) obj);
                }
            });
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: handleCreatePassword$lambda-12 */
    public static final void m1227handleCreatePassword$lambda12(CreatePasswordFragment this$0, Boolean success) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.f(success, "success");
        if (success.booleanValue()) {
            Analytics analytics = Analytics.INSTANCE;
            analytics.log(AnalyticsEvent_ApplicationKt.backupCloudSuccess$default(AnalyticsEvent.Companion, null, 1, null));
            analytics.setUserProperties(UserProperties.INSTANCE.getCloudBackupActivated());
            e.j.f.m.k(this$0, R.id.backupRecoveryPhraseFragment, false, 2, null);
            return;
        }
        View view = this$0.getView();
        ((ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.createPasswordBtn))).setProgressBarIsVisible(false);
        e.j.f.m.u(this$0, R.string.error__mnemonic_cloud_backup, 0, 2, null);
    }

    /* renamed from: handleCreatePassword$lambda-13 */
    public static final void m1228handleCreatePassword$lambda13(CreatePasswordFragment this$0, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.createPasswordBtn))).setProgressBarIsVisible(false);
        this$0.handleFetchBackupStatusException(th, 1);
    }

    public final void handleFetchBackupStatusException(Throwable th, int i2) {
        l.a.a.f(th, "Error while fetching backup status", new Object[0]);
        Intent a = e.j.f.w.a(th);
        if (a == null) {
            e.j.f.m.p(this, new CreatePasswordFragment$handleFetchBackupStatusException$1(this));
            return;
        }
        l.a.a.c(th, "Error contains an Intent, will try to recover...", new Object[0]);
        startActivityForResult(a, i2);
    }

    private final void handlePasswordMatchStateChange(PasswordMatchState passwordMatchState) {
        View verifyPasswordInputStatusLabel;
        int i2 = WhenMappings.$EnumSwitchMapping$0[passwordMatchState.ordinal()];
        if (i2 == 1) {
            View view = getView();
            ((TextView) (view == null ? null : view.findViewById(e.j.a.verifyPasswordInputStatusLabel))).setTextColor(e.j.f.m.m(this, R.color.primary_red));
            View view2 = getView();
            verifyPasswordInputStatusLabel = view2 != null ? view2.findViewById(e.j.a.verifyPasswordInputStatusLabel) : null;
            ((TextView) verifyPasswordInputStatusLabel).setText(R.string.error_invalid_passwords_do_not_match);
        } else if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            View view3 = getView();
            verifyPasswordInputStatusLabel = view3 != null ? view3.findViewById(e.j.a.verifyPasswordInputStatusLabel) : null;
            kotlin.jvm.internal.m.f(verifyPasswordInputStatusLabel, "verifyPasswordInputStatusLabel");
            e.j.f.v.a((TextView) verifyPasswordInputStatusLabel);
        } else {
            View view4 = getView();
            ((TextView) (view4 == null ? null : view4.findViewById(e.j.a.verifyPasswordInputStatusLabel))).setTextColor(e.j.f.m.m(this, R.color.primary_green));
            View view5 = getView();
            ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.verifyPasswordInputStatusLabel))).setText(R.string.label__valid_passwords_match);
            View view6 = getView();
            verifyPasswordInputStatusLabel = view6 != null ? view6.findViewById(e.j.a.userAgreementHolder) : null;
            ((LinearLayout) verifyPasswordInputStatusLabel).setVisibility(0);
        }
    }

    public static /* synthetic */ void i(CreatePasswordFragment createPasswordFragment, Boolean bool) {
        m1239initTextWatchers$lambda8(createPasswordFragment, bool);
    }

    private final void init() {
        initViewModel();
        initSoftInputMode();
        initClickListeners();
        initTextWatchers();
        initObservers();
    }

    private final void initClickListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new CreatePasswordFragment$initClickListeners$1(this), 1, null);
        View view2 = getView();
        View userAgreementHolder = view2 == null ? null : view2.findViewById(e.j.a.userAgreementHolder);
        kotlin.jvm.internal.m.f(userAgreementHolder, "userAgreementHolder");
        View_CommonKt.setOnSingleClickListener$default(userAgreementHolder, 0L, new CreatePasswordFragment$initClickListeners$2(this), 1, null);
        View view3 = getView();
        View createPasswordBtn = view3 != null ? view3.findViewById(e.j.a.createPasswordBtn) : null;
        kotlin.jvm.internal.m.f(createPasswordBtn, "createPasswordBtn");
        View_CommonKt.setOnSingleClickListener$default(createPasswordBtn, 0L, new CreatePasswordFragment$initClickListeners$3(this), 1, null);
    }

    private final void initObservers() {
        CreatePasswordViewModel createPasswordViewModel = this.viewModel;
        if (createPasswordViewModel != null) {
            Object as = createPasswordViewModel.getValidPasswordObservable().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.validPasswordObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, new CreatePasswordFragment$initObservers$1(this), null, new CreatePasswordFragment$initObservers$2(this), 2, null);
            CreatePasswordViewModel createPasswordViewModel2 = this.viewModel;
            if (createPasswordViewModel2 != null) {
                Object as2 = createPasswordViewModel2.getCreatePasswordButtonState().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as2, "viewModel.createPasswordButtonState\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, new CreatePasswordFragment$initObservers$3(this), null, new CreatePasswordFragment$initObservers$4(this), 2, null);
                CreatePasswordViewModel createPasswordViewModel3 = this.viewModel;
                if (createPasswordViewModel3 != null) {
                    h.c.s<PasswordMatchState> observeOn = createPasswordViewModel3.getPasswordsMatchObservable().observeOn(this.mainScheduler);
                    kotlin.jvm.internal.m.f(observeOn, "viewModel.passwordsMatchObservable\n            .observeOn(mainScheduler)");
                    ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(observeOn, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.g
                        @Override // h.c.m0.f
                        public final void accept(Object obj) {
                            CreatePasswordFragment.d(CreatePasswordFragment.this, (PasswordMatchState) obj);
                        }
                    });
                    CreatePasswordViewModel createPasswordViewModel4 = this.viewModel;
                    if (createPasswordViewModel4 != null) {
                        Object as3 = createPasswordViewModel4.getBackupStatusObservable().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                        kotlin.jvm.internal.m.f(as3, "viewModel.backupStatusObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, new CreatePasswordFragment$initObservers$6(this), null, CreatePasswordFragment$initObservers$7.INSTANCE, 2, null);
                        return;
                    }
                    kotlin.jvm.internal.m.w("viewModel");
                    throw null;
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: initObservers$lambda-11 */
    public static final void m1229initObservers$lambda11(CreatePasswordFragment this$0, PasswordMatchState it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.f(it, "it");
        this$0.handlePasswordMatchStateChange(it);
    }

    private final void initSoftInputMode() {
        requireActivity().getWindow().setSoftInputMode(16);
    }

    private final void initTextWatchers() {
        View view = getView();
        ((com.uber.autodispose.x) e.h.a.d.c.a((TextView) (view == null ? null : view.findViewById(e.j.a.passwordInput))).c().doOnNext(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.h
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                CreatePasswordFragment.e(CreatePasswordFragment.this, (CharSequence) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.i
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                CreatePasswordFragment.f((Throwable) obj);
            }
        }).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
        View view2 = getView();
        ((com.uber.autodispose.x) e.h.a.d.c.a((TextView) (view2 == null ? null : view2.findViewById(e.j.a.verifyPasswordInput))).c().doOnNext(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.p
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                CreatePasswordFragment.m(CreatePasswordFragment.this, (CharSequence) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.j
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                CreatePasswordFragment.g((Throwable) obj);
            }
        }).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
        View view3 = getView();
        ((com.uber.autodispose.x) e.h.a.c.a.a(view3 == null ? null : view3.findViewById(e.j.a.passwordInput)).doOnNext(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.q
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                CreatePasswordFragment.n(CreatePasswordFragment.this, (Boolean) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.r
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                CreatePasswordFragment.o((Throwable) obj);
            }
        }).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
        View view4 = getView();
        ((com.uber.autodispose.x) e.h.a.c.a.a(view4 == null ? null : view4.findViewById(e.j.a.verifyPasswordInput)).doOnNext(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.u
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                CreatePasswordFragment.q(CreatePasswordFragment.this, (Boolean) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.t
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                CreatePasswordFragment.p((Throwable) obj);
            }
        }).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
        View view5 = getView();
        ((com.uber.autodispose.x) e.h.a.d.b.a((CompoundButton) (view5 != null ? view5.findViewById(e.j.a.n0) : null)).doOnNext(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.l
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                CreatePasswordFragment.i(CreatePasswordFragment.this, (Boolean) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.o
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                CreatePasswordFragment.l((Throwable) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.features.cloudbackup.view.m
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                CreatePasswordFragment.j(CreatePasswordFragment.this, (Throwable) obj);
            }
        }).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
    }

    /* renamed from: initTextWatchers$lambda-0 */
    public static final void m1230initTextWatchers$lambda0(CreatePasswordFragment this$0, CharSequence charSequence) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        CreatePasswordViewModel createPasswordViewModel = this$0.viewModel;
        if (createPasswordViewModel == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        View view = this$0.getView();
        createPasswordViewModel.verifyPasswords(charSequence, ((TextInputEditText) (view != null ? view.findViewById(e.j.a.verifyPasswordInput) : null)).getText());
    }

    /* renamed from: initTextWatchers$lambda-1 */
    public static final void m1231initTextWatchers$lambda1(Throwable th) {
        l.a.a.f(th, "Error while streaming password input", new Object[0]);
    }

    /* renamed from: initTextWatchers$lambda-10 */
    public static final void m1232initTextWatchers$lambda10(CreatePasswordFragment this$0, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.createPasswordBtn))).setEnabled(false);
    }

    /* renamed from: initTextWatchers$lambda-2 */
    public static final void m1233initTextWatchers$lambda2(CreatePasswordFragment this$0, CharSequence charSequence) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        CreatePasswordViewModel createPasswordViewModel = this$0.viewModel;
        if (createPasswordViewModel == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        View view = this$0.getView();
        createPasswordViewModel.verifyPasswords(((TextInputEditText) (view != null ? view.findViewById(e.j.a.passwordInput) : null)).getText(), charSequence);
    }

    /* renamed from: initTextWatchers$lambda-3 */
    public static final void m1234initTextWatchers$lambda3(Throwable th) {
        l.a.a.f(th, "Error while streaming password input", new Object[0]);
    }

    /* renamed from: initTextWatchers$lambda-4 */
    public static final void m1235initTextWatchers$lambda4(CreatePasswordFragment this$0, Boolean it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        View findViewById = view == null ? null : view.findViewById(e.j.a.passwordInputLayout);
        kotlin.jvm.internal.m.f(it, "it");
        ((TextInputLayout) findViewById).setPasswordVisibilityToggleEnabled(it.booleanValue());
    }

    /* renamed from: initTextWatchers$lambda-5 */
    public static final void m1236initTextWatchers$lambda5(Throwable th) {
        l.a.a.f(th, "Error while observing focus changes", new Object[0]);
    }

    /* renamed from: initTextWatchers$lambda-6 */
    public static final void m1237initTextWatchers$lambda6(CreatePasswordFragment this$0, Boolean it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        View findViewById = view == null ? null : view.findViewById(e.j.a.verifyPasswordInputLayout);
        kotlin.jvm.internal.m.f(it, "it");
        ((TextInputLayout) findViewById).setPasswordVisibilityToggleEnabled(it.booleanValue());
    }

    /* renamed from: initTextWatchers$lambda-7 */
    public static final void m1238initTextWatchers$lambda7(Throwable th) {
        l.a.a.f(th, "Error while observing focus changes", new Object[0]);
    }

    /* renamed from: initTextWatchers$lambda-8 */
    public static final void m1239initTextWatchers$lambda8(CreatePasswordFragment this$0, Boolean it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        CreatePasswordViewModel createPasswordViewModel = this$0.viewModel;
        if (createPasswordViewModel == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.f(it, "it");
        createPasswordViewModel.setIsAgreementChecked(it.booleanValue());
    }

    private final void initViewModel() {
        androidx.lifecycle.b0 a = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(CreatePasswordViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (CreatePasswordViewModel) a;
    }

    public static /* synthetic */ void j(CreatePasswordFragment createPasswordFragment, Throwable th) {
        m1232initTextWatchers$lambda10(createPasswordFragment, th);
    }

    public static /* synthetic */ void k(CreatePasswordFragment createPasswordFragment, Throwable th) {
        m1228handleCreatePassword$lambda13(createPasswordFragment, th);
    }

    public static /* synthetic */ void l(Throwable th) {
        l.a.a.e(th);
    }

    public static /* synthetic */ void m(CreatePasswordFragment createPasswordFragment, CharSequence charSequence) {
        m1233initTextWatchers$lambda2(createPasswordFragment, charSequence);
    }

    public static /* synthetic */ void n(CreatePasswordFragment createPasswordFragment, Boolean bool) {
        m1235initTextWatchers$lambda4(createPasswordFragment, bool);
    }

    public static /* synthetic */ void o(Throwable th) {
        m1236initTextWatchers$lambda5(th);
    }

    public static /* synthetic */ void p(Throwable th) {
        m1238initTextWatchers$lambda7(th);
    }

    public static /* synthetic */ void q(CreatePasswordFragment createPasswordFragment, Boolean bool) {
        m1237initTextWatchers$lambda6(createPasswordFragment, bool);
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
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 6, null);
    }

    public final GenericViewModelFactory<CreatePasswordViewModel> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<CreatePasswordViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            l.a.a.a("User finished backup status error recovery flow", new Object[0]);
        } else if (i3 == -1) {
            l.a.a.a("User finished error recovery flow, retrying backup request...", new Object[0]);
            handleCreatePassword();
        } else {
            l.a.a.a("User canceled out of error recovery flow", new Object[0]);
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_create_password, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        init();
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<CreatePasswordViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}