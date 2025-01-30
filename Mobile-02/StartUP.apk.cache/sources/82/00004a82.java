package e.j.m.a;

import android.annotation.SuppressLint;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.b;
import com.coinbase.wallet.features.collectibles.CollectibleTypesTabFragment;
import com.coinbase.wallet.features.wallets.views.WalletsTabFragment;
import java.util.List;

/* compiled from: WalletPagerAdapter.kt */
@SuppressLint({"WrongConstant"})
/* loaded from: classes2.dex */
public final class s extends androidx.fragment.app.q {

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f13783f;

    /* renamed from: g  reason: collision with root package name */
    private final androidx.fragment.app.m f13784g;

    /* renamed from: h  reason: collision with root package name */
    private final b.C0036b f13785h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(List<String> tabs, androidx.fragment.app.m fm, b.C0036b navigatorExtras) {
        super(fm, 1);
        kotlin.jvm.internal.m.g(tabs, "tabs");
        kotlin.jvm.internal.m.g(fm, "fm");
        kotlin.jvm.internal.m.g(navigatorExtras, "navigatorExtras");
        this.f13783f = tabs;
        this.f13784g = fm;
        this.f13785h = navigatorExtras;
    }

    @Override // androidx.fragment.app.q
    public Fragment a(int i2) {
        if (i2 == 0) {
            WalletsTabFragment walletsTabFragment = new WalletsTabFragment();
            walletsTabFragment.setNavigatorExtras(this.f13785h);
            return walletsTabFragment;
        }
        return new CollectibleTypesTabFragment();
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return 2;
    }

    @Override // androidx.viewpager.widget.a
    public CharSequence getPageTitle(int i2) {
        if (i2 == 0) {
            return this.f13783f.get(0);
        }
        return this.f13783f.get(1);
    }

    @Override // androidx.fragment.app.q, androidx.viewpager.widget.a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        super.restoreState(parcelable, classLoader);
        List<Fragment> h0 = this.f13784g.h0();
        kotlin.jvm.internal.m.f(h0, "fm.fragments");
        for (Fragment fragment : h0) {
            if (fragment instanceof WalletsTabFragment) {
                ((WalletsTabFragment) fragment).setNavigatorExtras(this.f13785h);
            }
        }
    }
}