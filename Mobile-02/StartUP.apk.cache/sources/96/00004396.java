package com.toshi.view.fragment.toplevel;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.appsflyer.share.Constants;
import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.fragment.SignOutFragment;
import com.coinbase.wallet.application.util.ContactUsLauncher;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SafeWhen_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.NavController_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.Connected;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.models.ConsumerInterstitialArgs;
import com.coinbase.wallet.consumer.models.ConsumerUser;
import com.coinbase.wallet.consumer.models.NotConnected;
import com.coinbase.wallet.consumer.viewmodels.ConsumerSettingViewModel;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.cloudbackup.models.BackupStatus;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.toshi.qr.view.fragment.UniversalQRScannerFragment;
import com.toshi.view.fragment.toplevel.SettingsFragment;
import e.j.n.b3;
import h.c.h0;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.toshi.R;

/* compiled from: SettingsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bS\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b$\u0010%J!\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0003H\u0016¢\u0006\u0004\b)\u0010\u0005R(\u00102\u001a\b\u0012\u0004\u0012\u00020+0*8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u00105R\u001e\u0010;\u001a\n 8*\u0004\u0018\u000107078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010C\u001a\u00020<8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR(\u0010R\u001a\b\u0012\u0004\u0012\u0002030*8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bO\u0010-\u001a\u0004\bP\u0010/\"\u0004\bQ\u00101¨\u0006T"}, d2 = {"Lcom/toshi/view/fragment/toplevel/SettingsFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setup", "()V", "w", "t", "setupViews", "setupClickListeners", "u", "setupObservers", "Lcom/coinbase/wallet/user/models/User;", ApiConstants.USER, "F", "(Lcom/coinbase/wallet/user/models/User;)V", "q", "C", "B", "D", "E", "Lcom/coinbase/wallet/consumer/models/Connected;", "status", "z", "(Lcom/coinbase/wallet/consumer/models/Connected;)V", "y", "Lcom/coinbase/wallet/consumer/models/NotConnected;", "A", "(Lcom/coinbase/wallet/consumer/models/NotConnected;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Le/j/n/b3;", "d", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSettingViewModel;", Constants.URL_CAMPAIGN, "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSettingViewModel;", "consumerViewModel", "Lh/c/a0;", "kotlin.jvm.PlatformType", "a", "Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/application/util/ContactUsLauncher;", "f", "Lcom/coinbase/wallet/application/util/ContactUsLauncher;", "p", "()Lcom/coinbase/wallet/application/util/ContactUsLauncher;", "setContactUsLauncher$app_productionRelease", "(Lcom/coinbase/wallet/application/util/ContactUsLauncher;)V", "contactUsLauncher", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "b", "Le/j/n/b3;", "viewModel", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "e", "o", "setConsumerModelFactory$app_productionRelease", "consumerModelFactory", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SettingsFragment extends LockedFragment implements StyledFragment {
    private final h.c.a0 a = h.c.j0.c.a.b();

    /* renamed from: b */
    private b3 f11405b;

    /* renamed from: c */
    private ConsumerSettingViewModel f11406c;

    /* renamed from: d */
    public GenericViewModelFactory<b3> f11407d;

    /* renamed from: e */
    public GenericViewModelFactory<ConsumerSettingViewModel> f11408e;

    /* renamed from: f */
    public ContactUsLauncher f11409f;

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {

        /* compiled from: SettingsFragment.kt */
        /* renamed from: com.toshi.view.fragment.toplevel.SettingsFragment$a$a */
        /* loaded from: classes2.dex */
        public static final class C0247a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<kotlin.x> {
            final /* synthetic */ SettingsFragment a;

            /* renamed from: b */
            final /* synthetic */ ConsumerConnectionStatus f11410b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0247a(SettingsFragment settingsFragment, ConsumerConnectionStatus consumerConnectionStatus) {
                super(0);
                this.a = settingsFragment;
                this.f11410b = consumerConnectionStatus;
            }

            @Override // kotlin.e0.c.a
            public /* bridge */ /* synthetic */ kotlin.x invoke() {
                invoke2();
                return kotlin.x.a;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                SettingsFragment settingsFragment = this.a;
                ConsumerInterstitialArgs consumerInterstitialArgs = ConsumerInterstitialArgs.INSTANCE;
                ConsumerConnectionStatus status = this.f11410b;
                kotlin.jvm.internal.m.f(status, "status");
                Fragment_CommonKt.navigate$default(settingsFragment, R.id.action_settingsViewFragment_to_consumerAccountsFragment, ConsumerInterstitialArgs.createArguments$default(consumerInterstitialArgs, false, status, null, true, 4, null), null, null, 12, null);
            }
        }

        /* compiled from: SettingsFragment.kt */
        /* loaded from: classes2.dex */
        public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends Boolean, ? extends ConsumerConnectionStatus>, kotlin.x> {
            final /* synthetic */ SettingsFragment a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(SettingsFragment settingsFragment) {
                super(1);
                this.a = settingsFragment;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends Boolean, ? extends ConsumerConnectionStatus> oVar) {
                invoke2((kotlin.o<Boolean, ? extends ConsumerConnectionStatus>) oVar);
                return kotlin.x.a;
            }

            /* renamed from: invoke */
            public final void invoke2(kotlin.o<Boolean, ? extends ConsumerConnectionStatus> oVar) {
                boolean booleanValue = oVar.a().booleanValue();
                ConsumerConnectionStatus status = oVar.b();
                if (booleanValue) {
                    return;
                }
                SettingsFragment settingsFragment = this.a;
                ConsumerInterstitialArgs consumerInterstitialArgs = ConsumerInterstitialArgs.INSTANCE;
                kotlin.jvm.internal.m.f(status, "status");
                Fragment_CommonKt.navigate$default(settingsFragment, R.id.action_settingsViewFragment_to_consumerAccountsFragment, ConsumerInterstitialArgs.createArguments$default(consumerInterstitialArgs, false, status, null, true, 4, null), null, null, 12, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a() {
            super(1);
            SettingsFragment.this = r1;
        }

        public static final h0 a(SettingsFragment this$0, ConsumerConnectionStatus status) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(status, "status");
            b3 b3Var = this$0.f11405b;
            if (b3Var != null) {
                h.c.b0<Boolean> backupIfNeeded = b3Var.backupIfNeeded(ForwardArgs.INSTANCE.create(R.id.settingsViewFragment), new C0247a(this$0, status));
                h.c.b0 just = h.c.b0.just(status);
                kotlin.jvm.internal.m.f(just, "just(status)");
                return h.c.t0.f.a(backupIfNeeded, just);
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }

        public static /* synthetic */ h0 b(SettingsFragment settingsFragment, ConsumerConnectionStatus consumerConnectionStatus) {
            return a(settingsFragment, consumerConnectionStatus);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            ConsumerSettingViewModel consumerSettingViewModel = SettingsFragment.this.f11406c;
            if (consumerSettingViewModel != null) {
                h.c.b0<ConsumerConnectionStatus> connectStatus = consumerSettingViewModel.getConnectStatus();
                final SettingsFragment settingsFragment = SettingsFragment.this;
                Object as = connectStatus.flatMap(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.y
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return SettingsFragment.a.b(SettingsFragment.this, (ConsumerConnectionStatus) obj);
                    }
                }).observeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(SettingsFragment.this.getScopeProvider()));
                kotlin.jvm.internal.m.f(as, "consumerViewModel.getConnectStatus()\n                .flatMap { status ->\n                    viewModel.backupIfNeeded(\n                        args = ForwardArgs.create(R.id.settingsViewFragment),\n                        onPromptDismiss = {\n                            navigate(\n                                R.id.action_settingsViewFragment_to_consumerAccountsFragment,\n                                ConsumerInterstitialArgs.createArguments(\n                                    connectionStatus = status,\n                                    hasSharedElementTransition = false,\n                                    isDefaultTransition = true\n                                )\n                            )\n                        }\n                    ).zipWith(Single.just(status))\n                }\n                .observeOn(AndroidSchedulers.mainThread())\n                .`as`(autoDisposable(scopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new b(SettingsFragment.this), 1, null);
                return;
            }
            kotlin.jvm.internal.m.w("consumerViewModel");
            throw null;
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigate$default(SettingsFragment.this, R.id.action_settingsViewFragment_to_userProfileSettingsFragment, null, null, null, 14, null);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigate$default(SettingsFragment.this, R.id.action_settingsViewFragment_to_backupRecoveryPhraseFragment, null, null, null, 14, null);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigate$default(SettingsFragment.this, R.id.action_settingsViewFragment_to_advancedSettingsFragment, null, null, null, 14, null);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigate$default(SettingsFragment.this, R.id.action_settingsViewFragment_to_debugMenuFragment, null, null, null, 14, null);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigate$default(SettingsFragment.this, R.id.action_settingsViewFragment_to_networkSwitcherFragment, null, null, null, 14, null);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigate$default(SettingsFragment.this, R.id.action_settingsViewFragment_to_appLockSettingsFragment, null, null, null, 14, null);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class h extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigate$default(SettingsFragment.this, R.id.action_settingsViewFragment_to_currencyFragment, null, null, null, 14, null);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class i extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.legalSelected(AnalyticsEvent.Companion));
            Fragment_CommonKt.navigate$default(SettingsFragment.this, R.id.action_settingsViewFragment_to_legalFragment, null, null, null, 14, null);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class j extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            SettingsFragment.this.C();
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class k extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            ContactUsLauncher p = SettingsFragment.this.p();
            androidx.fragment.app.d requireActivity = SettingsFragment.this.requireActivity();
            kotlin.jvm.internal.m.f(requireActivity, "requireActivity()");
            p.launch(requireActivity);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class l extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            SettingsFragment.this.q();
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class m extends kotlin.jvm.internal.o implements kotlin.e0.c.l<User, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(User user) {
            invoke2(user);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(User it) {
            SettingsFragment settingsFragment = SettingsFragment.this;
            kotlin.jvm.internal.m.f(it, "it");
            settingsFragment.F(it);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class n extends kotlin.jvm.internal.o implements kotlin.e0.c.l<EthereumChain, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n() {
            super(1);
            SettingsFragment.this = r1;
        }

        public final void a(EthereumChain ethereumChain) {
            View view = SettingsFragment.this.getView();
            ((TextView) (view == null ? null : view.findViewById(e.j.a.selectedNetwork))).setText(ethereumChain.getDisplayName());
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(EthereumChain ethereumChain) {
            a(ethereumChain);
            return kotlin.x.a;
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class o extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Integer, kotlin.x> {

        /* compiled from: SettingsFragment.kt */
        /* loaded from: classes2.dex */
        public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
            final /* synthetic */ boolean a;

            /* renamed from: b */
            final /* synthetic */ SettingsFragment f11411b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(boolean z, SettingsFragment settingsFragment) {
                super(1);
                this.a = z;
                this.f11411b = settingsFragment;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
                invoke2(view);
                return kotlin.x.a;
            }

            /* renamed from: invoke */
            public final void invoke2(View it) {
                kotlin.jvm.internal.m.g(it, "it");
                if (this.a) {
                    Fragment_CommonKt.navigate$default(this.f11411b, R.id.action_settingsViewFragment_to_walletLinkSettingsFragment, null, null, null, 14, null);
                    return;
                }
                UniversalQRScannerFragment.a aVar = UniversalQRScannerFragment.a;
                String name = SettingsFragment.class.getName();
                kotlin.jvm.internal.m.f(name, "SettingsFragment::class.java.name");
                Fragment_CommonKt.navigate$default(this.f11411b, R.id.action_settingsViewFragment_to_universalQRScannerFragment, aVar.a(false, name), null, null, 12, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o() {
            super(1);
            SettingsFragment.this = r1;
        }

        public final void a(Integer sessions) {
            kotlin.jvm.internal.m.f(sessions, "sessions");
            boolean z = sessions.intValue() > 0;
            View view = SettingsFragment.this.getView();
            ((TextView) (view == null ? null : view.findViewById(e.j.a.walletLinkConnectionCount))).setText(SettingsFragment.this.getResources().getQuantityString(R.plurals.wallet_link_connections, sessions.intValue(), sessions));
            View view2 = SettingsFragment.this.getView();
            View walletLinkSettings = view2 != null ? view2.findViewById(e.j.a.walletLinkSettings) : null;
            kotlin.jvm.internal.m.f(walletLinkSettings, "walletLinkSettings");
            View_CommonKt.setOnSingleClickListener$default(walletLinkSettings, 0L, new a(z, SettingsFragment.this), 1, null);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Integer num) {
            a(num);
            return kotlin.x.a;
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class p extends kotlin.jvm.internal.o implements kotlin.e0.c.l<FiatCurrency, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(FiatCurrency fiatCurrency) {
            invoke2(fiatCurrency);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(FiatCurrency fiatCurrency) {
            View view = SettingsFragment.this.getView();
            ((TextView) (view == null ? null : view.findViewById(e.j.a.g1))).setText(fiatCurrency.getCode().getRawValue());
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class q extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Boolean bool) {
            invoke2(bool);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Boolean it) {
            View view = SettingsFragment.this.getView();
            View debugMenu = view == null ? null : view.findViewById(e.j.a.debugMenu);
            kotlin.jvm.internal.m.f(debugMenu, "debugMenu");
            kotlin.jvm.internal.m.f(it, "it");
            debugMenu.setVisibility(it.booleanValue() ? 0 : 8);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class r extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            View view = SettingsFragment.this.getView();
            ImageView imageView = (ImageView) (view == null ? null : view.findViewById(e.j.a.backupStatusIndicator));
            if (imageView == null) {
                return;
            }
            imageView.setImageResource(R.drawable.ic_warning);
            imageView.setVisibility(0);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class s extends kotlin.jvm.internal.o implements kotlin.e0.c.l<BackupStatus, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(BackupStatus backupStatus) {
            invoke2(backupStatus);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(BackupStatus backupStatus) {
            int i2 = backupStatus instanceof BackupStatus.BackedUpAll ? true : backupStatus instanceof BackupStatus.BackedUpToCloud ? R.drawable.ic_icon_success : R.drawable.ic_warning;
            View view = SettingsFragment.this.getView();
            ImageView imageView = (ImageView) (view == null ? null : view.findViewById(e.j.a.backupStatusIndicator));
            if (imageView == null) {
                return;
            }
            imageView.setImageResource(i2);
            imageView.setVisibility(0);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class t extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {

        /* compiled from: SettingsFragment.kt */
        /* loaded from: classes2.dex */
        public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<kotlin.x> {
            final /* synthetic */ ConsumerConnectionStatus a;

            /* renamed from: b */
            final /* synthetic */ SettingsFragment f11412b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ConsumerConnectionStatus consumerConnectionStatus, SettingsFragment settingsFragment) {
                super(0);
                this.a = consumerConnectionStatus;
                this.f11412b = settingsFragment;
            }

            @Override // kotlin.e0.c.a
            public /* bridge */ /* synthetic */ kotlin.x invoke() {
                invoke2();
                return kotlin.x.a;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerTransferInitiated(AnalyticsEvent.Companion, this.a.getOnrampEnabled()));
                SettingsFragment settingsFragment = this.f11412b;
                ConsumerInterstitialArgs consumerInterstitialArgs = ConsumerInterstitialArgs.INSTANCE;
                ConsumerConnectionStatus status = this.a;
                kotlin.jvm.internal.m.f(status, "status");
                Fragment_CommonKt.navigate$default(settingsFragment, R.id.action_settingsViewFragment_to_consumerAccountsFragment, ConsumerInterstitialArgs.createArguments$default(consumerInterstitialArgs, false, status, null, true, 4, null), NavController_CommonKt.getDefaultNavOptionsBuilder().a(), null, 8, null);
            }
        }

        /* compiled from: SettingsFragment.kt */
        /* loaded from: classes2.dex */
        public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends Boolean, ? extends ConsumerConnectionStatus>, kotlin.x> {
            final /* synthetic */ SettingsFragment a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(SettingsFragment settingsFragment) {
                super(1);
                this.a = settingsFragment;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends Boolean, ? extends ConsumerConnectionStatus> oVar) {
                invoke2((kotlin.o<Boolean, ? extends ConsumerConnectionStatus>) oVar);
                return kotlin.x.a;
            }

            /* renamed from: invoke */
            public final void invoke2(kotlin.o<Boolean, ? extends ConsumerConnectionStatus> oVar) {
                boolean booleanValue = oVar.a().booleanValue();
                ConsumerConnectionStatus status = oVar.b();
                if (booleanValue) {
                    return;
                }
                Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerTransferInitiated(AnalyticsEvent.Companion, status.getOnrampEnabled()));
                SettingsFragment settingsFragment = this.a;
                ConsumerInterstitialArgs consumerInterstitialArgs = ConsumerInterstitialArgs.INSTANCE;
                kotlin.jvm.internal.m.f(status, "status");
                Fragment_CommonKt.navigate$default(settingsFragment, R.id.action_settingsViewFragment_to_consumerAccountsFragment, ConsumerInterstitialArgs.createArguments$default(consumerInterstitialArgs, false, status, null, true, 4, null), null, null, 12, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t() {
            super(1);
            SettingsFragment.this = r1;
        }

        public static final h0 a(SettingsFragment this$0, ConsumerConnectionStatus status) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(status, "status");
            b3 b3Var = this$0.f11405b;
            if (b3Var != null) {
                h.c.b0<Boolean> backupIfNeeded = b3Var.backupIfNeeded(ForwardArgs.INSTANCE.create(R.id.settingsViewFragment), new a(status, this$0));
                h.c.b0 just = h.c.b0.just(status);
                kotlin.jvm.internal.m.f(just, "just(status)");
                return h.c.t0.f.a(backupIfNeeded, just);
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }

        public static /* synthetic */ h0 b(SettingsFragment settingsFragment, ConsumerConnectionStatus consumerConnectionStatus) {
            return a(settingsFragment, consumerConnectionStatus);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            ConsumerSettingViewModel consumerSettingViewModel = SettingsFragment.this.f11406c;
            if (consumerSettingViewModel != null) {
                h.c.b0<ConsumerConnectionStatus> connectStatus = consumerSettingViewModel.getConnectStatus();
                final SettingsFragment settingsFragment = SettingsFragment.this;
                Object as = connectStatus.flatMap(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.z
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return SettingsFragment.t.b(SettingsFragment.this, (ConsumerConnectionStatus) obj);
                    }
                }).observeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(SettingsFragment.this.getScopeProvider()));
                kotlin.jvm.internal.m.f(as, "consumerViewModel.getConnectStatus()\n                .flatMap { status ->\n                    viewModel.backupIfNeeded(\n                        args = ForwardArgs.create(R.id.settingsViewFragment),\n                        onPromptDismiss = {\n                            Analytics.log(AnalyticsEvent.consumerTransferInitiated(status.onrampEnabled))\n                            navigate(\n                                R.id.action_settingsViewFragment_to_consumerAccountsFragment,\n                                ConsumerInterstitialArgs.createArguments(\n                                    connectionStatus = status,\n                                    hasSharedElementTransition = false,\n                                    isDefaultTransition = true\n                                ),\n                                navOptions = defaultNavOptionsBuilder.build()\n                            )\n                        }\n                    ).zipWith(Single.just(status))\n                }\n                .observeOn(AndroidSchedulers.mainThread())\n                .`as`(autoDisposable(scopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new b(SettingsFragment.this), 1, null);
                return;
            }
            kotlin.jvm.internal.m.w("consumerViewModel");
            throw null;
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class u extends kotlin.jvm.internal.o implements kotlin.e0.c.l<c.a, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u() {
            super(1);
            SettingsFragment.this = r1;
        }

        public static final void a(SettingsFragment this$0, DialogInterface dialogInterface, int i2) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            this$0.D();
        }

        public static /* synthetic */ void b(SettingsFragment settingsFragment, DialogInterface dialogInterface, int i2) {
            a(settingsFragment, dialogInterface, i2);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(c.a aVar) {
            invoke2(aVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(c.a showDialog) {
            kotlin.jvm.internal.m.g(showDialog, "$this$showDialog");
            showDialog.n(R.string.sign_out_confirmation_title);
            final SettingsFragment settingsFragment = SettingsFragment.this;
            showDialog.l(R.string.sign_out, new DialogInterface.OnClickListener() { // from class: com.toshi.view.fragment.toplevel.a0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    SettingsFragment.u.b(SettingsFragment.this, dialogInterface, i2);
                }
            });
            e.j.f.k.a(showDialog, R.string.cancel);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class v extends kotlin.jvm.internal.o implements kotlin.e0.c.l<c.a, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v() {
            super(1);
            SettingsFragment.this = r1;
        }

        public static final void a(SettingsFragment this$0, DialogInterface dialogInterface, int i2) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            this$0.B();
        }

        public static /* synthetic */ void b(SettingsFragment settingsFragment, DialogInterface dialogInterface, int i2) {
            a(settingsFragment, dialogInterface, i2);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(c.a aVar) {
            invoke2(aVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(c.a showDialog) {
            kotlin.jvm.internal.m.g(showDialog, "$this$showDialog");
            showDialog.n(R.string.sign_out_warning_title);
            showDialog.f(R.string.sign_out_warning_message);
            final SettingsFragment settingsFragment = SettingsFragment.this;
            showDialog.l(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.toshi.view.fragment.toplevel.b0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    SettingsFragment.v.b(SettingsFragment.this, dialogInterface, i2);
                }
            });
            e.j.f.k.a(showDialog, R.string.no);
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class w extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w() {
            super(1);
            SettingsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            SettingsFragment.this.A(new NotConnected(false));
        }
    }

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class x extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerConnectionStatus, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x() {
            super(1);
            SettingsFragment.this = r1;
        }

        public final void a(ConsumerConnectionStatus status) {
            if (status instanceof Connected) {
                Connected connected = (Connected) status;
                if (!connected.getHasRestrictions()) {
                    SettingsFragment settingsFragment = SettingsFragment.this;
                    kotlin.jvm.internal.m.f(status, "status");
                    settingsFragment.y(connected);
                } else {
                    SettingsFragment settingsFragment2 = SettingsFragment.this;
                    kotlin.jvm.internal.m.f(status, "status");
                    settingsFragment2.z(connected);
                }
            } else if (status instanceof NotConnected) {
                SettingsFragment settingsFragment3 = SettingsFragment.this;
                kotlin.jvm.internal.m.f(status, "status");
                settingsFragment3.A((NotConnected) status);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            SafeWhen_CommonKt.getSafe(kotlin.x.a);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerConnectionStatus consumerConnectionStatus) {
            a(consumerConnectionStatus);
            return kotlin.x.a;
        }
    }

    public final void A(NotConnected notConnected) {
        String string;
        View view = getView();
        ((ConstraintLayout) (view == null ? null : view.findViewById(e.j.a.consumerConnectedContainer))).setVisibility(8);
        View view2 = getView();
        ((ConstraintLayout) (view2 == null ? null : view2.findViewById(e.j.a.consumerUnconnectedContainer))).setVisibility(0);
        View view3 = getView();
        ((TextView) (view3 == null ? null : view3.findViewById(e.j.a.consumerUnconnectedLabel))).setVisibility(0);
        View view4 = getView();
        TextView textView = (TextView) (view4 != null ? view4.findViewById(e.j.a.consumerUnconnectedDescription) : null);
        if (notConnected.getOnrampEnabled()) {
            string = getString(R.string.transfer_buy_coins_from_coinbase);
        } else {
            string = getString(R.string.transfer_coins_from_coinbase);
        }
        textView.setText(string);
    }

    public final void B() {
        e.j.f.m.p(this, new u());
    }

    public final void C() {
        e.j.f.m.p(this, new v());
    }

    public final void D() {
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.signOutSelected(AnalyticsEvent.Companion));
        androidx.fragment.app.m fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        new SignOutFragment().show(fragmentManager, SignOutFragment.tag);
    }

    private final void E() {
        ConsumerSettingViewModel consumerSettingViewModel = this.f11406c;
        if (consumerSettingViewModel != null) {
            h.c.s<ConsumerConnectionStatus> observeOn = consumerSettingViewModel.getConsumerInfo().observeOn(this.a);
            kotlin.jvm.internal.m.f(observeOn, "consumerViewModel.getConsumerInfo()\n            .observeOn(mainScheduler)");
            Object as = Observable_AnalyticsKt.logError$default(observeOn, "Exception getting consumer connect status", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "consumerViewModel.getConsumerInfo()\n            .observeOn(mainScheduler)\n            .logError(\"Exception getting consumer connect status\")\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, new w(), null, new x(), 2, null);
            return;
        }
        kotlin.jvm.internal.m.w("consumerViewModel");
        throw null;
    }

    public final void F(User user) {
        char l1;
        View view = getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.username))).setText(getString(R.string.prefixed_username, user.getUsername()));
        View view2 = getView();
        ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.l4))).setVisibility(0);
        View view3 = getView();
        View findViewById = view3 != null ? view3.findViewById(e.j.a.l4) : null;
        l1 = kotlin.l0.a0.l1(user.getUsername());
        ((TextView) findViewById).setText(String.valueOf(Character.toUpperCase(l1)));
    }

    public final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    public final void q() {
        View view = getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.username))).setText(getString(R.string.profile__unknown_username));
        View view2 = getView();
        ((TextView) (view2 != null ? view2.findViewById(e.j.a.l4) : null)).setVisibility(8);
    }

    public static /* synthetic */ Boolean r(Optional optional) {
        return x(optional);
    }

    public static /* synthetic */ User s(Optional optional) {
        return v(optional);
    }

    private final void setup() {
        w();
        t();
        setupViews();
        setupClickListeners();
        setupObservers();
    }

    private final void setupClickListeners() {
        View view = getView();
        View backupPhrase = view == null ? null : view.findViewById(e.j.a.backupPhrase);
        kotlin.jvm.internal.m.f(backupPhrase, "backupPhrase");
        View_CommonKt.setOnSingleClickListener$default(backupPhrase, 0L, new c(), 1, null);
        View view2 = getView();
        View advanced = view2 == null ? null : view2.findViewById(e.j.a.advanced);
        kotlin.jvm.internal.m.f(advanced, "advanced");
        View_CommonKt.setOnSingleClickListener$default(advanced, 0L, new d(), 1, null);
        View view3 = getView();
        View debugMenu = view3 == null ? null : view3.findViewById(e.j.a.debugMenu);
        kotlin.jvm.internal.m.f(debugMenu, "debugMenu");
        View_CommonKt.setOnSingleClickListener$default(debugMenu, 0L, new e(), 1, null);
        View view4 = getView();
        View activeNetwork = view4 == null ? null : view4.findViewById(e.j.a.activeNetwork);
        kotlin.jvm.internal.m.f(activeNetwork, "activeNetwork");
        View_CommonKt.setOnSingleClickListener$default(activeNetwork, 0L, new f(), 1, null);
        View view5 = getView();
        View authentication = view5 == null ? null : view5.findViewById(e.j.a.authentication);
        kotlin.jvm.internal.m.f(authentication, "authentication");
        View_CommonKt.setOnSingleClickListener$default(authentication, 0L, new g(), 1, null);
        View view6 = getView();
        View localCurrency = view6 == null ? null : view6.findViewById(e.j.a.localCurrency);
        kotlin.jvm.internal.m.f(localCurrency, "localCurrency");
        View_CommonKt.setOnSingleClickListener$default(localCurrency, 0L, new h(), 1, null);
        View view7 = getView();
        View legal = view7 == null ? null : view7.findViewById(e.j.a.legal);
        kotlin.jvm.internal.m.f(legal, "legal");
        View_CommonKt.setOnSingleClickListener$default(legal, 0L, new i(), 1, null);
        View view8 = getView();
        View signOut = view8 == null ? null : view8.findViewById(e.j.a.signOut);
        kotlin.jvm.internal.m.f(signOut, "signOut");
        View_CommonKt.setOnSingleClickListener$default(signOut, 0L, new j(), 1, null);
        View view9 = getView();
        View contactUs = view9 == null ? null : view9.findViewById(e.j.a.contactUs);
        kotlin.jvm.internal.m.f(contactUs, "contactUs");
        View_CommonKt.setOnSingleClickListener$default(contactUs, 0L, new k(), 1, null);
        View view10 = getView();
        View consumerUnconnectedContainer = view10 == null ? null : view10.findViewById(e.j.a.consumerUnconnectedContainer);
        kotlin.jvm.internal.m.f(consumerUnconnectedContainer, "consumerUnconnectedContainer");
        View_CommonKt.setOnSingleClickListener$default(consumerUnconnectedContainer, 0L, new a(), 1, null);
        View view11 = getView();
        View profile = view11 != null ? view11.findViewById(e.j.a.profile) : null;
        kotlin.jvm.internal.m.f(profile, "profile");
        View_CommonKt.setOnSingleClickListener$default(profile, 0L, new b(), 1, null);
    }

    private final void setupObservers() {
        b3 b3Var = this.f11405b;
        if (b3Var != null) {
            h.c.s observeOn = b3Var.d().map(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.x
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SettingsFragment.s((Optional) obj);
                }
            }).observeOn(this.a);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.activeUser\n            .map { it.toNullable() ?: throw IllegalStateException(\"User is null\") }\n            .observeOn(mainScheduler)");
            Object as = Observable_AnalyticsKt.logError$default(observeOn, "Error while observing for active user", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.activeUser\n            .map { it.toNullable() ?: throw IllegalStateException(\"User is null\") }\n            .observeOn(mainScheduler)\n            .logError(\"Error while observing for active user\")\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, new l(), null, new m(), 2, null);
            b3 b3Var2 = this.f11405b;
            if (b3Var2 != null) {
                Object as2 = b3Var2.c().observeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as2, "viewModel.activeEthereumChain\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new n(), 3, null);
                b3 b3Var3 = this.f11405b;
                if (b3Var3 != null) {
                    h.c.s<Integer> observeOn2 = b3Var3.e().observeOn(h.c.j0.c.a.b());
                    kotlin.jvm.internal.m.f(observeOn2, "viewModel.sessionCountObservable\n            .observeOn(AndroidSchedulers.mainThread())");
                    Object as3 = Observable_AnalyticsKt.logError$default(observeOn2, "Error while observing for session count", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                    kotlin.jvm.internal.m.f(as3, "viewModel.sessionCountObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError(\"Error while observing for session count\")\n            .`as`(autoDisposable(scopeProvider))");
                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new o(), 3, null);
                    b3 b3Var4 = this.f11405b;
                    if (b3Var4 != null) {
                        h.c.s<FiatCurrency> observeOn3 = b3Var4.b().observeOn(h.c.j0.c.a.b());
                        kotlin.jvm.internal.m.f(observeOn3, "viewModel.activeCurrencyObservable\n            .observeOn(AndroidSchedulers.mainThread())");
                        Object as4 = Observable_AnalyticsKt.logError$default(observeOn3, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                        kotlin.jvm.internal.m.f(as4, "viewModel.activeCurrencyObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .`as`(autoDisposable(scopeProvider))");
                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as4, null, null, new p(), 3, null);
                        u();
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

    private final void setupViews() {
        ConsumerSettingViewModel consumerSettingViewModel = this.f11406c;
        if (consumerSettingViewModel != null) {
            Object as = consumerSettingViewModel.getConsumerUserObservable().map(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.w
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SettingsFragment.r((Optional) obj);
                }
            }).startWith((h.c.s<R>) Boolean.FALSE).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "consumerViewModel.getConsumerUserObservable()\n            .map { user ->\n                user?.value?.email?.endsWith(\"@coinbase.com\") ?: false\n            }\n            .startWith(false)\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new q(), 3, null);
            b3 b3Var = this.f11405b;
            if (b3Var != null) {
                h.c.s<BackupStatus> observeOn = b3Var.getBackupStatus().observeOn(this.a);
                kotlin.jvm.internal.m.f(observeOn, "viewModel.backupStatus\n            .observeOn(mainScheduler)");
                Object as2 = Observable_AnalyticsKt.logError$default(observeOn, "Error while deducing backup status", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as2, "viewModel.backupStatus\n            .observeOn(mainScheduler)\n            .logError(\"Error while deducing backup status\")\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, new r(), null, new s(), 2, null);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("consumerViewModel");
        throw null;
    }

    private final void t() {
        View view = getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.version))).setText("25.8.398");
    }

    private final void u() {
        List b2;
        GoogleSignInAccount c2 = com.google.android.gms.auth.api.signin.a.c(requireContext());
        if (c2 == null) {
            return;
        }
        Context requireContext = requireContext();
        b2 = kotlin.a0.q.b(DriveScopes.DRIVE_FILE);
        com.google.api.client.googleapis.extensions.android.gms.auth.a d2 = com.google.api.client.googleapis.extensions.android.gms.auth.a.d(requireContext, b2);
        d2.c(c2.m());
        Drive googleDriveService = new Drive.Builder(e.g.b.a.a.a.b.a.a(), new e.g.b.a.c.j.a(), d2).setApplicationName("Coinbase Wallet").build();
        b3 b3Var = this.f11405b;
        if (b3Var == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.f(googleDriveService, "googleDriveService");
        b3Var.setupGoogleDriveClient(googleDriveService);
    }

    public static final User v(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        User user = (User) it.toNullable();
        if (user != null) {
            return user;
        }
        throw new IllegalStateException("User is null");
    }

    private final void w() {
        androidx.lifecycle.b0 a2 = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(b3.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11405b = (b3) a2;
        androidx.lifecycle.b0 a3 = new androidx.lifecycle.d0(this, o()).a(ConsumerSettingViewModel.class);
        kotlin.jvm.internal.m.f(a3, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11406c = (ConsumerSettingViewModel) a3;
    }

    public static final Boolean x(Optional user) {
        String email;
        kotlin.jvm.internal.m.g(user, "user");
        ConsumerUser consumerUser = (ConsumerUser) user.getValue();
        boolean z = false;
        if (consumerUser != null && (email = consumerUser.getEmail()) != null) {
            z = kotlin.l0.x.z(email, "@coinbase.com", false, 2, null);
        }
        return Boolean.valueOf(z);
    }

    public final void y(Connected connected) {
        String string;
        String string2;
        if (connected.getOnrampEnabled()) {
            View view = getView();
            ((TextView) (view == null ? null : view.findViewById(e.j.a.transferLabel))).setText(R.string.buy_transfer);
        } else {
            View view2 = getView();
            ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.transferLabel))).setText(R.string.transfer);
        }
        View view3 = getView();
        ConstraintLayout constraintLayout = (ConstraintLayout) (view3 == null ? null : view3.findViewById(e.j.a.consumerConnectedContainer));
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        View view4 = getView();
        ConstraintLayout constraintLayout2 = (ConstraintLayout) (view4 == null ? null : view4.findViewById(e.j.a.consumerUnconnectedContainer));
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
        if (connected.getEmail() != null) {
            View view5 = getView();
            ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.consumerEmail))).setText(connected.getEmail());
            View view6 = getView();
            ((TextView) (view6 == null ? null : view6.findViewById(e.j.a.consumerEmail))).setVisibility(0);
        } else {
            View view7 = getView();
            ((TextView) (view7 == null ? null : view7.findViewById(e.j.a.consumerEmail))).setVisibility(8);
        }
        if (connected.getLastTransactionDate() != null) {
            Object[] objArr = new Object[1];
            Date lastTransactionDate = connected.getLastTransactionDate();
            objArr[0] = lastTransactionDate == null ? null : e.j.f.j.a(lastTransactionDate);
            String string3 = getString(R.string.transfer_coins_from_coinbase_last_transfer, objArr);
            kotlin.jvm.internal.m.f(string3, "getString(\n                R.string.transfer_coins_from_coinbase_last_transfer,\n                status.lastTransactionDate?.getTimeAgo()\n            )");
            if (connected.getOnrampEnabled()) {
                string2 = getString(R.string.transfer_buy_coins_from_coinbase_with_last_transaction, "<b>" + string3 + "</b>");
            } else {
                string2 = getString(R.string.transfer_coins_from_coinbase_with_last_transaction, "<b>" + string3 + "</b>");
            }
            kotlin.jvm.internal.m.f(string2, "if (status.onrampEnabled) {\n                getString(\n                    R.string.transfer_buy_coins_from_coinbase_with_last_transaction,\n                    \"<b>$timeAgo</b>\"\n                )\n            } else {\n                getString(\n                    R.string.transfer_coins_from_coinbase_with_last_transaction,\n                    \"<b>$timeAgo</b>\"\n                )\n            }");
            View view8 = getView();
            ((TextView) (view8 == null ? null : view8.findViewById(e.j.a.consumerConnectedDescription))).setText(e.j.f.u.b(string2));
        } else {
            View view9 = getView();
            TextView textView = (TextView) (view9 == null ? null : view9.findViewById(e.j.a.consumerConnectedDescription));
            if (connected.getOnrampEnabled()) {
                string = getString(R.string.transfer_buy_coins_from_coinbase);
            } else {
                string = getString(R.string.transfer_coins_from_coinbase);
            }
            textView.setText(string);
        }
        View view10 = getView();
        View consumerConnectedContainer = view10 != null ? view10.findViewById(e.j.a.consumerConnectedContainer) : null;
        kotlin.jvm.internal.m.f(consumerConnectedContainer, "consumerConnectedContainer");
        View_CommonKt.setOnSingleClickListener$default(consumerConnectedContainer, 0L, new t(), 1, null);
    }

    public final void z(Connected connected) {
        y(connected);
        View view = getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.transferLabel))).setText(R.string.complete_connection);
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
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), false, true, false, 5, null);
    }

    public final GenericViewModelFactory<b3> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<b3> genericViewModelFactory = this.f11407d;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    public final GenericViewModelFactory<ConsumerSettingViewModel> o() {
        GenericViewModelFactory<ConsumerSettingViewModel> genericViewModelFactory = this.f11408e;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("consumerModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_settings_view, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        E();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        setup();
    }

    public final ContactUsLauncher p() {
        ContactUsLauncher contactUsLauncher = this.f11409f;
        if (contactUsLauncher != null) {
            return contactUsLauncher;
        }
        kotlin.jvm.internal.m.w("contactUsLauncher");
        throw null;
    }
}