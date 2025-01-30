package com.toshi.view.fragment.toplevel;

import com.appsflyer.share.Constants;
import com.coinbase.wallet.commonui.views.StyledFragment;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: DappNavFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/toshi/view/fragment/toplevel/c0;", "Lcom/toshi/view/fragment/f0;", "Lcom/toshi/view/fragment/toplevel/DappsFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "", "b", "Z", "isLazy", "()Z", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "getBaseFragment", "()Ljava/lang/Class;", "baseFragment", "", Constants.URL_CAMPAIGN, "I", "getNavGraph", "()I", "navGraph", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class c0 extends com.toshi.view.fragment.f0<DappsFragment> implements StyledFragment {
    private final Class<DappsFragment> a = DappsFragment.class;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11413b = true;

    /* renamed from: c  reason: collision with root package name */
    private final int f11414c = R.navigation.dapp_nav_graph;

    @Override // com.toshi.view.fragment.f0, com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public Class<DappsFragment> getBaseFragment() {
        return this.a;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public int getNavGraph() {
        return this.f11414c;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public boolean isLazy() {
        return this.f11413b;
    }
}