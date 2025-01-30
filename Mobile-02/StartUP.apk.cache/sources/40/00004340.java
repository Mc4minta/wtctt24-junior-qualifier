package com.toshi.view.fragment.pickUsername;

import android.os.Bundle;
import android.view.View;
import c.h.k.d0;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.toshi.view.custom.UsernameStatusView;
import com.toshi.view.fragment.onboarding.PrivacySelectionFragment;
import e.j.n.h3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k;
import org.toshi.R;

/* compiled from: SignInPickUsernameFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00062\u00020\u00012\u00020\u0002:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u00020\u00038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u0005R\u001c\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/toshi/view/fragment/pickUsername/SignInPickUsernameFragment;", "Lcom/toshi/view/fragment/pickUsername/h;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "", "f", "()Ljava/lang/String;", "d", "Le/j/n/h3;", "username", "Lkotlin/x;", "h", "(Le/j/n/h3;)V", "Lkotlin/h;", "x", "masterSeed", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "e", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "()V", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SignInPickUsernameFragment extends h implements StyledFragment {

    /* renamed from: d  reason: collision with root package name */
    public static final a f11371d = new a(null);

    /* renamed from: e  reason: collision with root package name */
    private final StyledFragment.Attributes f11372e = new StyledFragment.Attributes(true, false, false, 6, null);

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.h f11373f;

    /* compiled from: SignInPickUsernameFragment.kt */
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

    /* compiled from: SignInPickUsernameFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends o implements kotlin.e0.c.a<String> {
        b() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return e.j.f.e.d(SignInPickUsernameFragment.this.getArguments(), "masterSeed");
        }
    }

    public SignInPickUsernameFragment() {
        kotlin.h b2;
        b2 = k.b(new b());
        this.f11373f = b2;
    }

    private final String x() {
        return (String) this.f11373f.getValue();
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
        return this.f11372e;
    }

    @Override // com.toshi.view.fragment.pickUsername.h
    public void h(h3 username) {
        m.g(username, "username");
        if (username.b()) {
            View view = getView();
            ((UsernameStatusView) (view != null ? view.findViewById(e.j.a.usernameStatus) : null)).b();
            Fragment_CommonKt.navigate$default(this, R.id.action_signInPickUsernameFragment_to_privacySelectionFragment, PrivacySelectionFragment.a.a(x(), username.a()), null, null, 12, null);
            return;
        }
        View view2 = getView();
        ((UsernameStatusView) (view2 != null ? view2.findViewById(e.j.a.usernameStatus) : null)).c();
        w();
    }
}