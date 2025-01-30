package com.coinbase.wallet.features.cloudbackup.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.features.cloudbackup.models.BackupPayload;
import com.coinbase.wallet.features.cloudbackup.viewModel.EnterPasswordViewModel;
import com.coinbase.wallet.user.models.User;
import com.google.android.material.textfield.TextInputEditText;
import com.toshi.model.local.OnboardingState;
import com.toshi.view.custom.ProgressBarButton;
import com.toshi.view.fragment.onboarding.authMethod.SignInWalletAuthenticationOnboardingFragment;
import javax.crypto.AEADBadTagException;
import kotlin.Metadata;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EnterPasswordFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EnterPasswordFragment$initOnClicks$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
    final /* synthetic */ EnterPasswordFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EnterPasswordFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "error", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.cloudbackup.view.EnterPasswordFragment$initOnClicks$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
        final /* synthetic */ EnterPasswordFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EnterPasswordFragment enterPasswordFragment) {
            super(1);
            this.this$0 = enterPasswordFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable error) {
            kotlin.jvm.internal.m.g(error, "error");
            View view = this.this$0.getView();
            ((ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.continueButton))).setProgressBarIsVisible(false);
            if (error instanceof AEADBadTagException) {
                View view2 = this.this$0.getView();
                ((TextInputEditText) (view2 == null ? null : view2.findViewById(e.j.a.passwordInput))).setText((CharSequence) null);
                View view3 = this.this$0.getView();
                ((TextInputEditText) (view3 == null ? null : view3.findViewById(e.j.a.passwordInput))).setError(this.this$0.getString(R.string.error_incorrect_password));
                View view4 = this.this$0.getView();
                ((ProgressBarButton) (view4 == null ? null : view4.findViewById(e.j.a.continueButton))).setBackground(e.j.f.m.n(this.this$0, R.drawable.button_error_rounded_disabled));
                View view5 = this.this$0.getView();
                ((ProgressBarButton) (view5 != null ? view5.findViewById(e.j.a.continueButton) : null)).setProgressBarText(this.this$0.getString(R.string.error_incorrect_password));
                return;
            }
            EnterPasswordFragment enterPasswordFragment = this.this$0;
            String string = enterPasswordFragment.getString(R.string.error_wallet_recovery_generic);
            kotlin.jvm.internal.m.f(string, "getString(R.string.error_wallet_recovery_generic)");
            e.j.f.m.v(enterPasswordFragment, string, 0, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EnterPasswordFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/o;", "", "Lcom/coinbase/wallet/user/models/User;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.cloudbackup.view.EnterPasswordFragment$initOnClicks$2$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends String, ? extends User>, kotlin.x> {
        final /* synthetic */ EnterPasswordFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(EnterPasswordFragment enterPasswordFragment) {
            super(1);
            this.this$0 = enterPasswordFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends String, ? extends User> oVar) {
            invoke2((kotlin.o<String, User>) oVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(kotlin.o<String, User> oVar) {
            Analytics analytics = Analytics.INSTANCE;
            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
            analytics.log(AnalyticsEvent_ApplicationKt.restoreWithCloudSuccess(companion));
            analytics.log(AnalyticsEvent_ApplicationKt.restoreWalletSuccess(companion));
            Fragment_CommonKt.navigate$default(this.this$0, R.id.action_enterPasswordFragment_to_signInWalletAuthenticationOnboardingFragment, SignInWalletAuthenticationOnboardingFragment.f11359f.a(oVar.a(), OnboardingState.EXISTING_USER, true), null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterPasswordFragment$initOnClicks$2(EnterPasswordFragment enterPasswordFragment) {
        super(1);
        this.this$0 = enterPasswordFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
        invoke2(view);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        EnterPasswordViewModel enterPasswordViewModel;
        BackupPayload backup;
        h.c.a0 a0Var;
        FragmentLifecycleScopeProvider onDestroyScopeProvider;
        kotlin.jvm.internal.m.g(it, "it");
        View view = this.this$0.getView();
        ((ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.continueButton))).setProgressBarIsVisible(true);
        InputMethodManager c2 = e.j.f.m.c(this.this$0);
        if (c2 != null) {
            View view2 = this.this$0.getView();
            c2.hideSoftInputFromWindow(((TextInputEditText) (view2 == null ? null : view2.findViewById(e.j.a.passwordInput))).getWindowToken(), 0);
        }
        enterPasswordViewModel = this.this$0.viewModel;
        if (enterPasswordViewModel != null) {
            View view3 = this.this$0.getView();
            String valueOf = String.valueOf(((TextInputEditText) (view3 == null ? null : view3.findViewById(e.j.a.passwordInput))).getText());
            backup = this.this$0.getBackup();
            h.c.b0<kotlin.o<String, User>> recoverMnemonic = enterPasswordViewModel.recoverMnemonic(valueOf, backup);
            a0Var = this.this$0.mainScheduler;
            h.c.b0<kotlin.o<String, User>> observeOn = recoverMnemonic.observeOn(a0Var);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.recoverMnemonic(passwordInput.text.toString(), backup)\n                .observeOn(mainScheduler)");
            h.c.b0 logError$default = Single_AnalyticsKt.logError$default(observeOn, "Error while recovering wallet", null, 2, null);
            onDestroyScopeProvider = this.this$0.getOnDestroyScopeProvider();
            Object as = logError$default.as(com.uber.autodispose.d.a(onDestroyScopeProvider));
            kotlin.jvm.internal.m.f(as, "viewModel.recoverMnemonic(passwordInput.text.toString(), backup)\n                .observeOn(mainScheduler)\n                .logError(\"Error while recovering wallet\")\n                .`as`(autoDisposable(onDestroyScopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy((com.uber.autodispose.a0) as, new AnonymousClass1(this.this$0), new AnonymousClass2(this.this$0));
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }
}