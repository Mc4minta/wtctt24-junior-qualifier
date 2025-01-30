package e.j.m.a;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.coinbase.wallet.application.model.MainTab;
import com.toshi.view.fragment.toplevel.c0;
import com.toshi.view.fragment.toplevel.f0;
import com.toshi.view.fragment.toplevel.g0;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: NavigationAdapter.kt */
@SuppressLint({"WrongConstant"})
/* loaded from: classes2.dex */
public final class g extends androidx.fragment.app.q {

    /* renamed from: f  reason: collision with root package name */
    private final c.e.h<WeakReference<Fragment>> f13754f;

    /* compiled from: NavigationAdapter.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MainTab.values().length];
            iArr[MainTab.WALLET.ordinal()] = 1;
            iArr[MainTab.DAPPS.ordinal()] = 2;
            iArr[MainTab.SETTINGS.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(androidx.fragment.app.m fragmentManager) {
        super(fragmentManager, 1);
        kotlin.jvm.internal.m.g(fragmentManager, "fragmentManager");
        this.f13754f = new c.e.h<>(getCount());
    }

    @Override // androidx.fragment.app.q
    public Fragment a(int i2) {
        Fragment g0Var;
        int i3 = a.a[MainTab.values()[i2].ordinal()];
        if (i3 == 1) {
            g0Var = new g0();
        } else if (i3 == 2) {
            g0Var = new c0();
        } else if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            g0Var = new f0();
        }
        this.f13754f.l(i2, new WeakReference<>(g0Var));
        return g0Var;
    }

    public final Fragment d(int i2) {
        WeakReference<Fragment> f2 = this.f13754f.f(i2);
        if (f2 == null) {
            return null;
        }
        return f2.get();
    }

    @Override // androidx.fragment.app.q, androidx.viewpager.widget.a
    public void destroyItem(ViewGroup container, int i2, Object object) {
        kotlin.jvm.internal.m.g(container, "container");
        kotlin.jvm.internal.m.g(object, "object");
        super.destroyItem(container, i2, object);
        this.f13754f.o(i2);
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return MainTab.values().length;
    }

    @Override // androidx.fragment.app.q, androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup container, int i2) {
        kotlin.jvm.internal.m.g(container, "container");
        Object instantiateItem = super.instantiateItem(container, i2);
        kotlin.jvm.internal.m.f(instantiateItem, "super.instantiateItem(container, position)");
        if (instantiateItem instanceof Fragment) {
            this.f13754f.l(i2, new WeakReference<>(instantiateItem));
        }
        return instantiateItem;
    }
}