package com.toshi.view.fragment.onboarding;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import c.h.k.d0;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.toshi.view.fragment.o0;
import com.toshi.view.fragment.onboarding.authMethod.NewWalletAuthenticationOnboardingFragment;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k;
import kotlin.x;
import org.toshi.R;

/* compiled from: PrivacySelectionFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001c\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\u00020\u001f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/toshi/view/fragment/onboarding/PrivacySelectionFragment;", "Lcom/toshi/view/fragment/o0;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "", "isPublic", "Lkotlin/x;", "i", "(Z)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", Constants.URL_CAMPAIGN, "Lkotlin/h;", "h", "()Ljava/lang/String;", "username", "b", "getMnemonic", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "d", "Z", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "e", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "()V", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PrivacySelectionFragment extends o0 implements StyledFragment {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final h f11349b;

    /* renamed from: c  reason: collision with root package name */
    private final h f11350c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11351d;

    /* renamed from: e  reason: collision with root package name */
    private final StyledFragment.Attributes f11352e;

    /* compiled from: PrivacySelectionFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(String masterSeed, String username) {
            m.g(masterSeed, "masterSeed");
            m.g(username, "username");
            Bundle bundle = new Bundle();
            bundle.putString(OnboardingBackupRecoveryPhraseArgs.mnemonicKey, masterSeed);
            bundle.putString("username", username);
            return bundle;
        }
    }

    /* compiled from: PrivacySelectionFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends o implements kotlin.e0.c.a<String> {
        b() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return e.j.f.e.d(PrivacySelectionFragment.this.getArguments(), OnboardingBackupRecoveryPhraseArgs.mnemonicKey);
        }
    }

    /* compiled from: PrivacySelectionFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends o implements l<View, x> {
        c() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            m.g(it, "it");
            PrivacySelectionFragment.this.i(true);
        }
    }

    /* compiled from: PrivacySelectionFragment.kt */
    /* loaded from: classes2.dex */
    static final class d extends o implements l<View, x> {
        d() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            m.g(it, "it");
            PrivacySelectionFragment.this.i(false);
        }
    }

    /* compiled from: PrivacySelectionFragment.kt */
    /* loaded from: classes2.dex */
    static final class e extends o implements l<View, x> {
        e() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            m.g(it, "it");
            Fragment_CommonKt.navigateUp(PrivacySelectionFragment.this);
        }
    }

    /* compiled from: PrivacySelectionFragment.kt */
    /* loaded from: classes2.dex */
    static final class f extends o implements l<View, x> {
        f() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            m.g(it, "it");
            PrivacySelectionFragment privacySelectionFragment = PrivacySelectionFragment.this;
            Fragment_CommonKt.navigate$default(privacySelectionFragment, R.id.action_privacySelectionFragment_to_newWalletAuthenticationOnboardingFragment, NewWalletAuthenticationOnboardingFragment.f11353f.a(privacySelectionFragment.getMnemonic(), PrivacySelectionFragment.this.h(), PrivacySelectionFragment.this.f11351d), null, null, 12, null);
        }
    }

    /* compiled from: PrivacySelectionFragment.kt */
    /* loaded from: classes2.dex */
    static final class g extends o implements kotlin.e0.c.a<String> {
        g() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return e.j.f.e.d(PrivacySelectionFragment.this.getArguments(), "username");
        }
    }

    public PrivacySelectionFragment() {
        h b2;
        h b3;
        b2 = k.b(new b());
        this.f11349b = b2;
        b3 = k.b(new g());
        this.f11350c = b3;
        this.f11351d = true;
        this.f11352e = new StyledFragment.Attributes(true, false, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getMnemonic() {
        return (String) this.f11349b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h() {
        return (String) this.f11350c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(boolean z) {
        this.f11351d = z;
        ColorStateList valueOf = ColorStateList.valueOf(androidx.core.content.a.d(requireContext(), R.color.grey_30));
        m.f(valueOf, "valueOf(ContextCompat.getColor(requireContext(), R.color.grey_30))");
        ColorStateList valueOf2 = ColorStateList.valueOf(androidx.core.content.a.d(requireContext(), R.color.primary_blue));
        m.f(valueOf2, "valueOf(ContextCompat.getColor(requireContext(), R.color.primary_blue))");
        if (z) {
            View view = getView();
            ((ConstraintLayout) (view == null ? null : view.findViewById(e.j.a.privacyPublicContainer))).setClickable(false);
            View view2 = getView();
            ((ConstraintLayout) (view2 == null ? null : view2.findViewById(e.j.a.privacyPrivateContainer))).setClickable(true);
            View view3 = getView();
            ((ConstraintLayout) (view3 == null ? null : view3.findViewById(e.j.a.privacyPublicContainer))).setBackgroundTintList(valueOf2);
            View view4 = getView();
            ((ImageView) (view4 == null ? null : view4.findViewById(e.j.a.privacyPublicImage))).setBackgroundTintList(valueOf2);
            View view5 = getView();
            ((ConstraintLayout) (view5 == null ? null : view5.findViewById(e.j.a.privacyPrivateContainer))).setBackgroundTintList(valueOf);
            View view6 = getView();
            ((ImageView) (view6 != null ? view6.findViewById(e.j.a.privacyPrivateImage) : null)).setBackgroundTintList(valueOf);
            return;
        }
        View view7 = getView();
        ((ConstraintLayout) (view7 == null ? null : view7.findViewById(e.j.a.privacyPublicContainer))).setClickable(true);
        View view8 = getView();
        ((ConstraintLayout) (view8 == null ? null : view8.findViewById(e.j.a.privacyPrivateContainer))).setClickable(false);
        View view9 = getView();
        ((ConstraintLayout) (view9 == null ? null : view9.findViewById(e.j.a.privacyPublicContainer))).setBackgroundTintList(valueOf);
        View view10 = getView();
        ((ImageView) (view10 == null ? null : view10.findViewById(e.j.a.privacyPublicImage))).setBackgroundTintList(valueOf);
        View view11 = getView();
        ((ConstraintLayout) (view11 == null ? null : view11.findViewById(e.j.a.privacyPrivateContainer))).setBackgroundTintList(valueOf2);
        View view12 = getView();
        ((ImageView) (view12 != null ? view12.findViewById(e.j.a.privacyPrivateImage) : null)).setBackgroundTintList(valueOf2);
    }

    @Override // com.toshi.view.fragment.o0, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return this.f11352e;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_privacy_selection, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        View view2 = getView();
        View privacyPublicContainer = view2 == null ? null : view2.findViewById(e.j.a.privacyPublicContainer);
        m.f(privacyPublicContainer, "privacyPublicContainer");
        View_CommonKt.setOnSingleClickListener$default(privacyPublicContainer, 0L, new c(), 1, null);
        View view3 = getView();
        View privacyPrivateContainer = view3 == null ? null : view3.findViewById(e.j.a.privacyPrivateContainer);
        m.f(privacyPrivateContainer, "privacyPrivateContainer");
        View_CommonKt.setOnSingleClickListener$default(privacyPrivateContainer, 0L, new d(), 1, null);
        View view4 = getView();
        View backButton = view4 == null ? null : view4.findViewById(e.j.a.backButton);
        m.f(backButton, "backButton");
        View_CommonKt.setOnSingleClickListener$default(backButton, 0L, new e(), 1, null);
        View view5 = getView();
        View nextButton = view5 != null ? view5.findViewById(e.j.a.s4) : null;
        m.f(nextButton, "nextButton");
        View_CommonKt.setOnSingleClickListener$default(nextButton, 0L, new f(), 1, null);
    }
}