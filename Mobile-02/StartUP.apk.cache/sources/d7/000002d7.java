package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.i;

/* compiled from: FragmentPagerAdapter.java */
/* loaded from: classes.dex */
public abstract class q extends androidx.viewpager.widget.a {
    private final m a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1660b;

    /* renamed from: c  reason: collision with root package name */
    private u f1661c = null;

    /* renamed from: d  reason: collision with root package name */
    private Fragment f1662d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1663e;

    public q(m mVar, int i2) {
        this.a = mVar;
        this.f1660b = i2;
    }

    private static String c(int i2, long j2) {
        return "android:switcher:" + i2 + ":" + j2;
    }

    public abstract Fragment a(int i2);

    public long b(int i2) {
        return i2;
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f1661c == null) {
            this.f1661c = this.a.j();
        }
        this.f1661c.n(fragment);
        if (fragment.equals(this.f1662d)) {
            this.f1662d = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void finishUpdate(ViewGroup viewGroup) {
        u uVar = this.f1661c;
        if (uVar != null) {
            if (!this.f1663e) {
                try {
                    this.f1663e = true;
                    uVar.m();
                } finally {
                    this.f1663e = false;
                }
            }
            this.f1661c = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        if (this.f1661c == null) {
            this.f1661c = this.a.j();
        }
        long b2 = b(i2);
        Fragment Z = this.a.Z(c(viewGroup.getId(), b2));
        if (Z != null) {
            this.f1661c.i(Z);
        } else {
            Z = a(i2);
            this.f1661c.c(viewGroup.getId(), Z, c(viewGroup.getId(), b2));
        }
        if (Z != this.f1662d) {
            Z.setMenuVisibility(false);
            if (this.f1660b == 1) {
                this.f1661c.w(Z, i.b.STARTED);
            } else {
                Z.setUserVisibleHint(false);
            }
        }
        return Z;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.a
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f1662d;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f1660b == 1) {
                    if (this.f1661c == null) {
                        this.f1661c = this.a.j();
                    }
                    this.f1661c.w(this.f1662d, i.b.STARTED);
                } else {
                    this.f1662d.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f1660b == 1) {
                if (this.f1661c == null) {
                    this.f1661c = this.a.j();
                }
                this.f1661c.w(fragment, i.b.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f1662d = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}