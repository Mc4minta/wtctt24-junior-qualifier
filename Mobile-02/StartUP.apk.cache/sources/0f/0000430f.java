package com.toshi.view.fragment.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.h.k.d0;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.toshi.view.fragment.legal.LegalViewFragment;
import com.toshi.view.fragment.o0;
import com.toshi.view.fragment.pickUsername.SignInPickUsernameFragment;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k;
import kotlin.x;
import org.toshi.R;

/* compiled from: LegalAgreementFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0007¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0005R\u001f\u0010!\u001a\u0004\u0018\u00010\f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010'\u001a\u00020\"8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/toshi/view/fragment/onboarding/LegalAgreementFragment;", "Lcom/toshi/view/fragment/o0;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "init", "()V", "initClickListeners", "g", "Lcom/toshi/view/fragment/legal/b;", "type", "h", "(Lcom/toshi/view/fragment/legal/b;)V", "", "recoveryPhrase", "i", "(Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", Constants.URL_CAMPAIGN, "Lkotlin/h;", "f", "()Ljava/lang/String;", "masterSeed", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "b", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class LegalAgreementFragment extends o0 implements StyledFragment {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final StyledFragment.Attributes f11347b = new StyledFragment.Attributes(true, false, false, 6, null);

    /* renamed from: c  reason: collision with root package name */
    private final h f11348c;

    /* compiled from: LegalAgreementFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(String masterSeed) {
            m.g(masterSeed, "masterSeed");
            Bundle bundle = new Bundle();
            bundle.putString("masterSeed", masterSeed);
            return bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LegalAgreementFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends o implements l<View, x> {
        b() {
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
            LegalAgreementFragment.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LegalAgreementFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends o implements l<View, x> {
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
            Fragment_CommonKt.navigateUp(LegalAgreementFragment.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LegalAgreementFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends o implements l<View, x> {
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
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.legalTosSelected(AnalyticsEvent.Companion));
            LegalAgreementFragment.this.h(com.toshi.view.fragment.legal.b.TERMS_OF_SERVICE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LegalAgreementFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends o implements l<View, x> {
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
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.legalPrivacySelected(AnalyticsEvent.Companion));
            LegalAgreementFragment.this.h(com.toshi.view.fragment.legal.b.PRIVACY_POLICY);
        }
    }

    /* compiled from: LegalAgreementFragment.kt */
    /* loaded from: classes2.dex */
    static final class f extends o implements kotlin.e0.c.a<String> {
        f() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            Bundle arguments = LegalAgreementFragment.this.getArguments();
            if (arguments == null) {
                return null;
            }
            return arguments.getString("masterSeed");
        }
    }

    public LegalAgreementFragment() {
        h b2;
        b2 = k.b(new f());
        this.f11348c = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        String f2 = f();
        if (f2 == null) {
            Fragment_CommonKt.navigate$default(this, R.id.action_legalAgreementFragment_to_pickUsernameFragment, null, null, null, 14, null);
        } else {
            i(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(com.toshi.view.fragment.legal.b bVar) {
        Fragment_CommonKt.navigate$default(this, R.id.action_legalAgreementFragment_to_legalViewFragment, LegalViewFragment.a.a(bVar), null, null, 12, null);
    }

    private final void i(String str) {
        Fragment_CommonKt.navigate$default(this, R.id.action_legalAgreementFragment_to_signInPickUsernameFragment, SignInPickUsernameFragment.f11371d.a(str), null, null, 12, null);
    }

    private final void init() {
        initClickListeners();
    }

    private final void initClickListeners() {
        View view = getView();
        View accept = view == null ? null : view.findViewById(e.j.a.accept);
        m.f(accept, "accept");
        View_CommonKt.setOnSingleClickListener$default(accept, 0L, new b(), 1, null);
        View view2 = getView();
        View backButton = view2 == null ? null : view2.findViewById(e.j.a.backButton);
        m.f(backButton, "backButton");
        View_CommonKt.setOnSingleClickListener$default(backButton, 0L, new c(), 1, null);
        View view3 = getView();
        View termsOfServiceButton = view3 == null ? null : view3.findViewById(e.j.a.termsOfServiceButton);
        m.f(termsOfServiceButton, "termsOfServiceButton");
        View_CommonKt.setOnSingleClickListener$default(termsOfServiceButton, 0L, new d(), 1, null);
        View view4 = getView();
        View privacyPolicyButton = view4 != null ? view4.findViewById(e.j.a.privacyPolicyButton) : null;
        m.f(privacyPolicyButton, "privacyPolicyButton");
        View_CommonKt.setOnSingleClickListener$default(privacyPolicyButton, 0L, new e(), 1, null);
    }

    @Override // com.toshi.view.fragment.o0, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    public final String f() {
        return (String) this.f11348c.getValue();
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return this.f11347b;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_legal_agreement, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.legalLanded(AnalyticsEvent.Companion));
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        init();
    }
}