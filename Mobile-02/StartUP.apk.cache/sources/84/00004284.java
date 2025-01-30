package com.toshi.view.fragment;

import com.appsflyer.share.Constants;
import com.toshi.view.fragment.onboarding.LandingFragment;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: OnboardingWizardFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/toshi/view/fragment/OnboardingWizardFragment;", "Lcom/toshi/view/fragment/f0;", "Lcom/toshi/view/fragment/onboarding/LandingFragment;", "", Constants.URL_CAMPAIGN, "I", "getNavGraph", "()I", "navGraph", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "getBaseFragment", "()Ljava/lang/Class;", "baseFragment", "", "b", "Z", "isLazy", "()Z", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class OnboardingWizardFragment extends f0<LandingFragment> {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11279b;
    private final Class<LandingFragment> a = LandingFragment.class;

    /* renamed from: c  reason: collision with root package name */
    private final int f11280c = R.navigation.onboarding_nav_graph;

    @Override // com.toshi.view.fragment.f0, com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public Class<LandingFragment> getBaseFragment() {
        return this.a;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public int getNavGraph() {
        return this.f11280c;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public boolean isLazy() {
        return this.f11279b;
    }
}