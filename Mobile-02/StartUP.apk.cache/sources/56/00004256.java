package com.toshi.view.fragment;

import com.appsflyer.share.Constants;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: BannedLocationNavFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\f\u001a\u00020\t8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\u00020\u000e8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/toshi/view/fragment/BannedLocationNavFragment;", "Lcom/toshi/view/fragment/f0;", "Lcom/toshi/view/fragment/BannedLocationFragment;", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "getBaseFragment", "()Ljava/lang/Class;", "baseFragment", "", "b", "Z", "isLazy", "()Z", "", Constants.URL_CAMPAIGN, "I", "getNavGraph", "()I", "navGraph", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class BannedLocationNavFragment extends f0<BannedLocationFragment> {
    private final Class<BannedLocationFragment> a = BannedLocationFragment.class;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11248b = true;

    /* renamed from: c  reason: collision with root package name */
    private final int f11249c = R.navigation.banned_location_nav_graph;

    @Override // com.toshi.view.fragment.f0, com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public Class<BannedLocationFragment> getBaseFragment() {
        return this.a;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public int getNavGraph() {
        return this.f11249c;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public boolean isLazy() {
        return this.f11248b;
    }
}