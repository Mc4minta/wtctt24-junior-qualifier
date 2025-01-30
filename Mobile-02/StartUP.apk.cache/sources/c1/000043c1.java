package com.toshi.view.fragment.toplevel;

import androidx.fragment.app.Fragment;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.application.view.HomeFragment;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.views.StyledFragment;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: WalletNavFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/toshi/view/fragment/toplevel/g0;", "Lcom/toshi/view/fragment/f0;", "Lcom/coinbase/wallet/application/view/HomeFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "", Constants.URL_CAMPAIGN, "I", "getNavGraph", "()I", "navGraph", "", "b", "Z", "isLazy", "()Z", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "getBaseFragment", "()Ljava/lang/Class;", "baseFragment", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class g0 extends com.toshi.view.fragment.f0<HomeFragment> implements StyledFragment {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11417b;
    private final Class<HomeFragment> a = HomeFragment.class;

    /* renamed from: c  reason: collision with root package name */
    private final int f11418c = R.navigation.wallet_nav_graph;

    @Override // com.toshi.view.fragment.f0, com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.BaseNavHostFragment, com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        Fragment currentVisibleFragment = Fragment_CommonKt.getCurrentVisibleFragment(this);
        StyledFragment styledFragment = currentVisibleFragment instanceof StyledFragment ? (StyledFragment) currentVisibleFragment : null;
        StyledFragment.Attributes attributes = styledFragment != null ? styledFragment.getAttributes() : null;
        return attributes == null ? StyledFragment.Attributes.copy$default(super.getAttributes(), false, true, false, 5, null) : attributes;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public Class<HomeFragment> getBaseFragment() {
        return this.a;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public int getNavGraph() {
        return this.f11418c;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseNavHostFragment
    public boolean isLazy() {
        return this.f11417b;
    }
}