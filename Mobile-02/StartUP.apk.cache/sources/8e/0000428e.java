package com.toshi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.lifecycle.i;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.annotations.ScreenshotProtection;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.util.Optional;
import com.toshi.model.local.OnboardingState;
import com.toshi.view.custom.ProgressBarButton;
import com.toshi.view.custom.recoveryPhrase.RecoveryPhraseInputView;
import com.toshi.view.custom.recoveryPhrase.SuggestionsView;
import com.toshi.view.custom.recoveryPhrase.keyboard.RecoveryPhraseKeyboard;
import com.toshi.view.fragment.onboarding.LegalAgreementFragment;
import com.toshi.view.fragment.onboarding.authMethod.SignInWalletAuthenticationOnboardingFragment;
import e.j.n.d3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.spongycastle.i18n.TextBundle;
import org.toshi.R;

/* compiled from: SignInFragment.kt */
@ScreenshotProtection(behavior = ScreenshotProtection.Behavior.BLOCK)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001GB\u0007¢\u0006\u0004\bF\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0006J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0006J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0006J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\rJ\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\rJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0006J-\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b#\u0010$J!\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020+8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001c\u00104\u001a\u00020/8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001e\u00109\u001a\n 6*\u0004\u0018\u000105058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R(\u0010B\u001a\b\u0012\u0004\u0012\u00020;0:8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lcom/toshi/view/fragment/SignInFragment;", "Lcom/toshi/view/fragment/o0;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "initAccessibility", "()V", "initViewModel", "F", "initClickListeners", "", "suggestion", "m", "(Ljava/lang/String;)V", "u", "l", "w", "s", TextBundle.TEXT_ENTRY, "p", "G", "o", "n", "r", "masterSeed", "E", "D", "q", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "onBackPressed", "()Z", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "d", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lh/c/a0;", "kotlin.jvm.PlatformType", Constants.URL_CAMPAIGN, "Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Le/j/n/d3;", "e", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "b", "Le/j/n/d3;", "viewModel", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SignInFragment extends o0 implements BackableFragment, StyledFragment {
    public static final a a = new a(null);

    /* renamed from: b */
    private d3 f11291b;

    /* renamed from: c */
    private final h.c.a0 f11292c = h.c.j0.c.a.b();

    /* renamed from: d */
    private final StyledFragment.Attributes f11293d = new StyledFragment.Attributes(true, false, false, 6, null);

    /* renamed from: e */
    public GenericViewModelFactory<d3> f11294e;

    /* compiled from: SignInFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SignInFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b() {
            super(1);
            SignInFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            SignInFragment.this.G();
        }
    }

    /* compiled from: SignInFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends OnboardingState, ? extends Optional<? extends String>>, kotlin.x> {

        /* renamed from: b */
        final /* synthetic */ String f11295b;

        /* compiled from: SignInFragment.kt */
        /* loaded from: classes2.dex */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[OnboardingState.values().length];
                iArr[OnboardingState.NEW_USER.ordinal()] = 1;
                iArr[OnboardingState.EXISTING_USER.ordinal()] = 2;
                iArr[OnboardingState.INVALID_MNEMONIC.ordinal()] = 3;
                iArr[OnboardingState.GENERAL_ERROR.ordinal()] = 4;
                iArr[OnboardingState.NETWORK_ERROR.ordinal()] = 5;
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(1);
            SignInFragment.this = r1;
            this.f11295b = str;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends OnboardingState, ? extends Optional<? extends String>> oVar) {
            invoke2((kotlin.o<? extends OnboardingState, Optional<String>>) oVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(kotlin.o<? extends OnboardingState, Optional<String>> oVar) {
            OnboardingState a2 = oVar.a();
            View view = SignInFragment.this.getView();
            ProgressBarButton progressBarButton = (ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.next));
            if (progressBarButton != null) {
                progressBarButton.setProgressBarIsVisible(false);
            }
            int i2 = a.a[a2.ordinal()];
            if (i2 == 1) {
                SignInFragment.this.E(this.f11295b);
            } else if (i2 == 2) {
                SignInFragment.this.D(this.f11295b);
            } else if (i2 == 3) {
                SignInFragment.this.q();
            } else if (i2 == 4) {
                e.j.f.m.u(SignInFragment.this, R.string.unable_to_import_existing_wallet, 0, 2, null);
            } else if (i2 != 5) {
            } else {
                e.j.f.m.s(SignInFragment.this, R.string.unable_to_import_existing_wallet_check_network_connection, 1);
            }
        }
    }

    /* compiled from: SignInFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends String>, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d() {
            super(1);
            SignInFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(List<String> it) {
            View view = SignInFragment.this.getView();
            View findViewById = view == null ? null : view.findViewById(e.j.a.suggestionView);
            kotlin.jvm.internal.m.f(it, "it");
            ((SuggestionsView) findViewById).setSuggestions(it);
        }
    }

    /* compiled from: SignInFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(1);
            SignInFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigateUp(SignInFragment.this);
        }
    }

    /* compiled from: SignInFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f() {
            super(1);
            SignInFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigate$default(SignInFragment.this, R.id.action_signInFragment_to_readMoreRecoveryPhraseFragment, null, null, null, 14, null);
        }
    }

    /* compiled from: SignInFragment.kt */
    /* loaded from: classes2.dex */
    public static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g() {
            super(1);
            SignInFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
            invoke2(str);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            SignInFragment.this.m(it);
        }
    }

    /* compiled from: SignInFragment.kt */
    /* loaded from: classes2.dex */
    public static final class h extends kotlin.jvm.internal.o implements kotlin.e0.c.a<kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h() {
            super(0);
            SignInFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ kotlin.x invoke() {
            invoke2();
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2() {
            SignInFragment.this.r();
        }
    }

    /* compiled from: SignInFragment.kt */
    /* loaded from: classes2.dex */
    public static final class i extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i() {
            super(1);
            SignInFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
            invoke2(str);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            SignInFragment.this.s();
        }
    }

    /* compiled from: SignInFragment.kt */
    /* loaded from: classes2.dex */
    public static final class j extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j() {
            super(1);
            SignInFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
            invoke2(str);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            e.j.f.m.u(SignInFragment.this, R.string.sign_in_length_error_message, 0, 2, null);
        }
    }

    /* compiled from: SignInFragment.kt */
    /* loaded from: classes2.dex */
    public static final class k extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k() {
            super(1);
            SignInFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
            invoke2(str);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            SignInFragment.this.p(it);
        }
    }

    public static /* synthetic */ void A(SignInFragment signInFragment, View view) {
        t(signInFragment, view);
    }

    public static /* synthetic */ void B(SignInFragment signInFragment) {
        v(signInFragment);
    }

    public static /* synthetic */ void C(SignInFragment signInFragment, View view) {
        x(signInFragment, view);
    }

    public final void D(String str) {
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        analytics.log(AnalyticsEvent_ApplicationKt.restoreWithManualSuccess(companion));
        analytics.log(AnalyticsEvent_ApplicationKt.restoreWalletSuccess(companion));
        Fragment_CommonKt.navigate$default(this, R.id.action_SignInFragment_to_signInWalletAuthenticationOnboardingFragment, SignInWalletAuthenticationOnboardingFragment.a.b(SignInWalletAuthenticationOnboardingFragment.f11359f, str, OnboardingState.EXISTING_USER, false, 4, null), null, null, 12, null);
    }

    public final void E(String str) {
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        analytics.log(AnalyticsEvent_ApplicationKt.restoreWithManualSuccess(companion));
        analytics.log(AnalyticsEvent_ApplicationKt.restoreWalletSuccess(companion));
        analytics.log(AnalyticsEvent_ApplicationKt.restoreWalletNewUserStart(companion));
        Fragment_CommonKt.navigate$default(this, R.id.action_signInFragment_to_legalAgreementFragment, LegalAgreementFragment.a.a(str), null, null, 12, null);
    }

    private final void F() {
        requireActivity().getWindow().setSoftInputMode(2);
    }

    public final void G() {
        View view = getView();
        if (((RecoveryPhraseInputView) (view == null ? null : view.findViewById(e.j.a.recoveryPhraseInput))).r()) {
            o();
        } else {
            n();
        }
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final void initAccessibility() {
        View view = getView();
        View recoveryPhraseInput = view == null ? null : view.findViewById(e.j.a.recoveryPhraseInput);
        kotlin.jvm.internal.m.f(recoveryPhraseInput, "recoveryPhraseInput");
        e.j.f.y.a(recoveryPhraseInput);
    }

    private final void initClickListeners() {
        View view = getView();
        View backButton = view == null ? null : view.findViewById(e.j.a.backButton);
        kotlin.jvm.internal.m.f(backButton, "backButton");
        View_CommonKt.setOnSingleClickListener$default(backButton, 0L, new e(), 1, null);
        View view2 = getView();
        View learnMore = view2 == null ? null : view2.findViewById(e.j.a.learnMore);
        kotlin.jvm.internal.m.f(learnMore, "learnMore");
        View_CommonKt.setOnSingleClickListener$default(learnMore, 0L, new f(), 1, null);
        View view3 = getView();
        ((SuggestionsView) (view3 == null ? null : view3.findViewById(e.j.a.suggestionView))).setOnItemClickedListener(new g());
        View view4 = getView();
        ((ProgressBarButton) (view4 == null ? null : view4.findViewById(e.j.a.next))).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.fragment.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                SignInFragment.A(SignInFragment.this, view5);
            }
        });
        View view5 = getView();
        RecoveryPhraseInputView recoveryPhraseInputView = (RecoveryPhraseInputView) (view5 == null ? null : view5.findViewById(e.j.a.recoveryPhraseInput));
        d3 d3Var = this.f11291b;
        if (d3Var != null) {
            recoveryPhraseInputView.setKeywordList(d3Var.f());
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    private final void initViewModel() {
        androidx.lifecycle.b0 a2 = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(d3.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11291b = (d3) a2;
    }

    private final void l() {
        View view = getView();
        RecoveryPhraseKeyboard recoveryPhraseKeyboard = (RecoveryPhraseKeyboard) (view == null ? null : view.findViewById(e.j.a.customRecoveryPhraseKeyboard));
        boolean z = recoveryPhraseKeyboard != null && recoveryPhraseKeyboard.getVisibility() == 0;
        if (z) {
            View view2 = getView();
            View findViewById = view2 == null ? null : view2.findViewById(e.j.a.fillView);
            ViewGroup.LayoutParams layoutParams = findViewById == null ? null : findViewById.getLayoutParams();
            if (layoutParams != null) {
                View view3 = getView();
                RecoveryPhraseKeyboard recoveryPhraseKeyboard2 = (RecoveryPhraseKeyboard) (view3 == null ? null : view3.findViewById(e.j.a.customRecoveryPhraseKeyboard));
                layoutParams.height = recoveryPhraseKeyboard2 == null ? 0 : recoveryPhraseKeyboard2.getHeight();
            }
        }
        View view4 = getView();
        View findViewById2 = view4 != null ? view4.findViewById(e.j.a.fillView) : null;
        if (findViewById2 == null) {
            return;
        }
        findViewById2.setVisibility(z ? 0 : 8);
    }

    public final void m(String str) {
        View view = getView();
        ((RecoveryPhraseInputView) (view == null ? null : view.findViewById(e.j.a.recoveryPhraseInput))).g(str);
        G();
    }

    private final void n() {
        View view = getView();
        ProgressBarButton progressBarButton = (ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.next));
        if (progressBarButton != null) {
            progressBarButton.setProgressBarIsVisible(false);
        }
        View view2 = getView();
        ProgressBarButton progressBarButton2 = (ProgressBarButton) (view2 == null ? null : view2.findViewById(e.j.a.next));
        if (progressBarButton2 != null) {
            progressBarButton2.setEnabled(false);
        }
        View view3 = getView();
        ((RecoveryPhraseKeyboard) (view3 != null ? view3.findViewById(e.j.a.customRecoveryPhraseKeyboard) : null)).A();
    }

    private final void o() {
        View view = getView();
        ProgressBarButton progressBarButton = (ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.next));
        if (progressBarButton != null) {
            progressBarButton.setProgressBarIsVisible(false);
        }
        View view2 = getView();
        ProgressBarButton progressBarButton2 = (ProgressBarButton) (view2 == null ? null : view2.findViewById(e.j.a.next));
        if (progressBarButton2 != null) {
            progressBarButton2.setEnabled(true);
        }
        View view3 = getView();
        ((RecoveryPhraseKeyboard) (view3 != null ? view3.findViewById(e.j.a.customRecoveryPhraseKeyboard) : null)).C();
    }

    public final void p(String str) {
        boolean z;
        boolean g2;
        z = kotlin.l0.x.z(str, " ", false, 2, null);
        if (!z) {
            View view = getView();
            String currentWord = ((RecoveryPhraseInputView) (view == null ? null : view.findViewById(e.j.a.recoveryPhraseInput))).getCurrentWord();
            d3 d3Var = this.f11291b;
            if (d3Var == null) {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            g2 = d3Var.a(currentWord);
        } else {
            View view2 = getView();
            String previousWord = ((RecoveryPhraseInputView) (view2 == null ? null : view2.findViewById(e.j.a.recoveryPhraseInput))).getPreviousWord();
            d3 d3Var2 = this.f11291b;
            if (d3Var2 == null) {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            g2 = d3Var2.g(previousWord);
        }
        if (!g2) {
            View view3 = getView();
            ((RecoveryPhraseInputView) (view3 != null ? view3.findViewById(e.j.a.recoveryPhraseInput) : null)).m();
            return;
        }
        View view4 = getView();
        ((RecoveryPhraseInputView) (view4 != null ? view4.findViewById(e.j.a.recoveryPhraseInput) : null)).o();
    }

    public final void q() {
        View view = getView();
        ((RecoveryPhraseInputView) (view == null ? null : view.findViewById(e.j.a.recoveryPhraseInput))).n();
        e.j.f.m.u(this, R.string.invalid_recovery_phrase, 0, 2, null);
    }

    public final void r() {
        String h0;
        View view = getView();
        List<String> recoveryPhraseAsList = ((RecoveryPhraseInputView) (view == null ? null : view.findViewById(e.j.a.recoveryPhraseInput))).getRecoveryPhraseAsList();
        if (recoveryPhraseAsList.size() != 12) {
            e.j.f.m.u(this, R.string.sign_in_length_error_message, 0, 2, null);
            return;
        }
        h0 = kotlin.a0.z.h0(recoveryPhraseAsList, " ", null, null, 0, null, null, 62, null);
        View view2 = getView();
        ((RecoveryPhraseKeyboard) (view2 == null ? null : view2.findViewById(e.j.a.customRecoveryPhraseKeyboard))).H();
        View view3 = getView();
        ProgressBarButton progressBarButton = (ProgressBarButton) (view3 == null ? null : view3.findViewById(e.j.a.next));
        if (progressBarButton != null) {
            progressBarButton.setProgressBarIsVisible(true);
        }
        d3 d3Var = this.f11291b;
        if (d3Var != null) {
            h.c.b0<kotlin.o<OnboardingState, Optional<String>>> observeOn = d3Var.l(h0).observeOn(this.f11292c);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.validateRecoveryPhrase(masterSeed)\n            .observeOn(mainScheduler)");
            Object as = Single_AnalyticsKt.logError$default(observeOn, null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.validateRecoveryPhrase(masterSeed)\n            .observeOn(mainScheduler)\n            .logError()\n            .`as`(autoDisposable(onDestroyScopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy((com.uber.autodispose.a0) as, new b(), new c(h0));
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public final void s() {
        View view = getView();
        String currentWord = ((RecoveryPhraseInputView) (view == null ? null : view.findViewById(e.j.a.recoveryPhraseInput))).getCurrentWord();
        d3 d3Var = this.f11291b;
        if (d3Var != null) {
            h.c.b0<List<String>> observeOn = d3Var.d(currentWord).observeOn(this.f11292c);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.getSuggestions(currentWord)\n            .observeOn(mainScheduler)");
            Object as = Single_AnalyticsKt.logError$default(observeOn, "Error while fetching suggestions", null, 2, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.getSuggestions(currentWord)\n            .observeOn(mainScheduler)\n            .logError(\"Error while fetching suggestions\")\n            .`as`(autoDisposable(onDestroyScopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new d(), 1, null);
            G();
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public static final void t(SignInFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.r();
    }

    private final void u() {
        View view = getView();
        RecoveryPhraseKeyboard recoveryPhraseKeyboard = (RecoveryPhraseKeyboard) (view == null ? null : view.findViewById(e.j.a.customRecoveryPhraseKeyboard));
        recoveryPhraseKeyboard.setOnNextActionClickListener(new h());
        recoveryPhraseKeyboard.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.toshi.view.fragment.z
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                SignInFragment.B(SignInFragment.this);
            }
        });
    }

    public static final void v(SignInFragment this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.l();
    }

    private final void w() {
        View view = getView();
        RecoveryPhraseInputView recoveryPhraseInputView = (RecoveryPhraseInputView) (view == null ? null : view.findViewById(e.j.a.recoveryPhraseInput));
        recoveryPhraseInputView.setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.fragment.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SignInFragment.C(SignInFragment.this, view2);
            }
        });
        recoveryPhraseInputView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.toshi.view.fragment.x
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z) {
                SignInFragment.z(SignInFragment.this, view2, z);
            }
        });
        recoveryPhraseInputView.setOnTextChangedListener(new i());
        recoveryPhraseInputView.setOnInvalidLengthListener(new j());
        recoveryPhraseInputView.setAfterTextChangedListener(new k());
    }

    public static final void x(SignInFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view2 = this$0.getView();
        ((RecoveryPhraseKeyboard) (view2 == null ? null : view2.findViewById(e.j.a.customRecoveryPhraseKeyboard))).U();
    }

    public static final void y(SignInFragment this$0, View view, boolean z) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        if (z) {
            View view2 = this$0.getView();
            ((RecoveryPhraseKeyboard) (view2 == null ? null : view2.findViewById(e.j.a.customRecoveryPhraseKeyboard))).U();
        }
    }

    public static /* synthetic */ void z(SignInFragment signInFragment, View view, boolean z) {
        y(signInFragment, view, z);
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
        return this.f11293d;
    }

    public final GenericViewModelFactory<d3> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<d3> genericViewModelFactory = this.f11294e;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        View view = getView();
        View customRecoveryPhraseKeyboard = view == null ? null : view.findViewById(e.j.a.customRecoveryPhraseKeyboard);
        kotlin.jvm.internal.m.f(customRecoveryPhraseKeyboard, "customRecoveryPhraseKeyboard");
        if (customRecoveryPhraseKeyboard.getVisibility() == 0) {
            View view2 = getView();
            View customRecoveryPhraseKeyboard2 = view2 != null ? view2.findViewById(e.j.a.customRecoveryPhraseKeyboard) : null;
            kotlin.jvm.internal.m.f(customRecoveryPhraseKeyboard2, "customRecoveryPhraseKeyboard");
            customRecoveryPhraseKeyboard2.setVisibility(8);
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        super.onCreateView(inflater, viewGroup, bundle);
        return inflater.inflate(R.layout.fragment_sign_in, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        initViewModel();
        initAccessibility();
        F();
        l();
        initClickListeners();
        w();
        G();
        u();
    }
}