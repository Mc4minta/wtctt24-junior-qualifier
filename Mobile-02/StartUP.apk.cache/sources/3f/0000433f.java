package com.toshi.view.fragment.pickUsername;

import android.view.View;
import c.h.k.d0;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.toshi.view.custom.UsernameStatusView;
import com.toshi.view.fragment.onboarding.PrivacySelectionFragment;
import e.j.n.h3;
import h.c.a0;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.o;
import org.toshi.R;

/* compiled from: PickUsernameFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\tJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u0010\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/toshi/view/fragment/pickUsername/PickUsernameFragment;", "Lcom/toshi/view/fragment/pickUsername/h;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "", "f", "()Ljava/lang/String;", "d", "Lkotlin/x;", "onResume", "()V", "username", "i", "(Ljava/lang/String;)V", "Lh/c/a0;", "kotlin.jvm.PlatformType", "Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "e", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PickUsernameFragment extends h implements StyledFragment {

    /* renamed from: d */
    private final a0 f11369d = h.c.j0.c.a.b();

    /* renamed from: e */
    private final StyledFragment.Attributes f11370e = new StyledFragment.Attributes(true, false, false, 6, null);

    public static /* synthetic */ void A(PickUsernameFragment pickUsernameFragment, o oVar) {
        y(pickUsernameFragment, oVar);
    }

    public static final h0 x(PickUsernameFragment this$0, String username, String it) {
        m.g(this$0, "this$0");
        m.g(username, "$username");
        m.g(it, "it");
        b0 just = b0.just(it);
        m.f(just, "just(it)");
        return h.c.t0.f.a(just, this$0.g().d(username));
    }

    public static final void y(PickUsernameFragment this$0, o oVar) {
        m.g(this$0, "this$0");
        String recoveryPhrase = (String) oVar.a();
        h3 h3Var = (h3) oVar.b();
        if (h3Var.b()) {
            View view = this$0.getView();
            ((UsernameStatusView) (view != null ? view.findViewById(e.j.a.usernameStatus) : null)).b();
            PrivacySelectionFragment.a aVar = PrivacySelectionFragment.a;
            m.f(recoveryPhrase, "recoveryPhrase");
            Fragment_CommonKt.navigate$default(this$0, R.id.action_pickUsernameFragment_to_privacySelectionFragment, aVar.a(recoveryPhrase, h3Var.a()), null, null, 12, null);
            return;
        }
        View view2 = this$0.getView();
        ((UsernameStatusView) (view2 != null ? view2.findViewById(e.j.a.usernameStatus) : null)).c();
        this$0.w();
    }

    public static /* synthetic */ h0 z(PickUsernameFragment pickUsernameFragment, String str, String str2) {
        return x(pickUsernameFragment, str, str2);
    }

    @Override // com.toshi.view.fragment.pickUsername.h, com.toshi.view.fragment.o0, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.toshi.view.fragment.pickUsername.h
    protected String d() {
        String string = getString(R.string.onboarding_pick_username_subtitle);
        m.f(string, "getString(R.string.onboarding_pick_username_subtitle)");
        return string;
    }

    @Override // com.toshi.view.fragment.pickUsername.h
    protected String f() {
        String string = getString(R.string.onboarding_pick_username_title);
        m.f(string, "getString(R.string.onboarding_pick_username_title)");
        return string;
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return this.f11370e;
    }

    @Override // com.toshi.view.fragment.pickUsername.h
    public void i(final String username) {
        m.g(username, "username");
        b0 observeOn = g().a().flatMap(new n() { // from class: com.toshi.view.fragment.pickUsername.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PickUsernameFragment.z(PickUsernameFragment.this, username, (String) obj);
            }
        }).observeOn(this.f11369d);
        m.f(observeOn, "viewModel.createNewWallet()\n            .flatMap { Single.just(it).zipWith(viewModel.validateUsername(username)) }\n            .observeOn(mainScheduler)");
        ((com.uber.autodispose.a0) Single_AnalyticsKt.logError$default(observeOn, "Error while creating recovery phrase.", null, 2, null).as(com.uber.autodispose.d.a(e()))).subscribe(new h.c.m0.f() { // from class: com.toshi.view.fragment.pickUsername.g
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                PickUsernameFragment.A(PickUsernameFragment.this, (o) obj);
            }
        });
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.usernameLanded(AnalyticsEvent.Companion));
    }
}