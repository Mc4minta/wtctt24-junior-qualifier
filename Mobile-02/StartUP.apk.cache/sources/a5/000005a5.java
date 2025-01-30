package c.h.k;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper.java */
/* loaded from: classes.dex */
public class l {
    private ViewParent a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f3046b;

    /* renamed from: c  reason: collision with root package name */
    private final View f3047c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3048d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f3049e;

    public l(View view) {
        this.f3047c = view;
    }

    private boolean h(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        ViewParent i7;
        int i8;
        int i9;
        int[] iArr3;
        if (!m() || (i7 = i(i6)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f3047c.getLocationInWindow(iArr);
            i8 = iArr[0];
            i9 = iArr[1];
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (iArr2 == null) {
            int[] j2 = j();
            j2[0] = 0;
            j2[1] = 0;
            iArr3 = j2;
        } else {
            iArr3 = iArr2;
        }
        y.d(i7, this.f3047c, i2, i3, i4, i5, i6, iArr3);
        if (iArr != null) {
            this.f3047c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i8;
            iArr[1] = iArr[1] - i9;
        }
        return true;
    }

    private ViewParent i(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return null;
            }
            return this.f3046b;
        }
        return this.a;
    }

    private int[] j() {
        if (this.f3049e == null) {
            this.f3049e = new int[2];
        }
        return this.f3049e;
    }

    private void o(int i2, ViewParent viewParent) {
        if (i2 == 0) {
            this.a = viewParent;
        } else if (i2 != 1) {
        } else {
            this.f3046b = viewParent;
        }
    }

    public boolean a(float f2, float f3, boolean z) {
        ViewParent i2;
        if (!m() || (i2 = i(0)) == null) {
            return false;
        }
        return y.a(i2, this.f3047c, f2, f3, z);
    }

    public boolean b(float f2, float f3) {
        ViewParent i2;
        if (!m() || (i2 = i(0)) == null) {
            return false;
        }
        return y.b(i2, this.f3047c, f2, f3);
    }

    public boolean c(int i2, int i3, int[] iArr, int[] iArr2) {
        return d(i2, i3, iArr, iArr2, 0);
    }

    public boolean d(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        ViewParent i5;
        int i6;
        int i7;
        if (!m() || (i5 = i(i4)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                return false;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f3047c.getLocationInWindow(iArr2);
            i6 = iArr2[0];
            i7 = iArr2[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr == null) {
            iArr = j();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        y.c(i5, this.f3047c, i2, i3, iArr, i4);
        if (iArr2 != null) {
            this.f3047c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i6;
            iArr2[1] = iArr2[1] - i7;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public void e(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        h(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public boolean f(int i2, int i3, int i4, int i5, int[] iArr) {
        return h(i2, i3, i4, i5, iArr, 0, null);
    }

    public boolean g(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return h(i2, i3, i4, i5, iArr, i6, null);
    }

    public boolean k() {
        return l(0);
    }

    public boolean l(int i2) {
        return i(i2) != null;
    }

    public boolean m() {
        return this.f3048d;
    }

    public void n(boolean z) {
        if (this.f3048d) {
            v.E0(this.f3047c);
        }
        this.f3048d = z;
    }

    public boolean p(int i2) {
        return q(i2, 0);
    }

    public boolean q(int i2, int i3) {
        if (l(i3)) {
            return true;
        }
        if (m()) {
            View view = this.f3047c;
            for (ViewParent parent = this.f3047c.getParent(); parent != null; parent = parent.getParent()) {
                if (y.f(parent, view, this.f3047c, i2, i3)) {
                    o(i3, parent);
                    y.e(parent, view, this.f3047c, i2, i3);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public void r() {
        s(0);
    }

    public void s(int i2) {
        ViewParent i3 = i(i2);
        if (i3 != null) {
            y.g(i3, this.f3047c, i2);
            o(i2, null);
        }
    }
}