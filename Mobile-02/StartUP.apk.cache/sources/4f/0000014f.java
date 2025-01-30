package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;

/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
public class t0 implements y {
    Toolbar a;

    /* renamed from: b  reason: collision with root package name */
    private int f895b;

    /* renamed from: c  reason: collision with root package name */
    private View f896c;

    /* renamed from: d  reason: collision with root package name */
    private View f897d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f898e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f899f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f900g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f901h;

    /* renamed from: i  reason: collision with root package name */
    CharSequence f902i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f903j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f904k;

    /* renamed from: l  reason: collision with root package name */
    Window.Callback f905l;
    boolean m;
    private c n;
    private int o;
    private int p;
    private Drawable q;

    /* compiled from: ToolbarWidgetWrapper.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        final androidx.appcompat.view.menu.a a;

        a() {
            this.a = new androidx.appcompat.view.menu.a(t0.this.a.getContext(), 0, 16908332, 0, 0, t0.this.f902i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t0 t0Var = t0.this;
            Window.Callback callback = t0Var.f905l;
            if (callback == null || !t0Var.m) {
                return;
            }
            callback.onMenuItemSelected(0, this.a);
        }
    }

    /* compiled from: ToolbarWidgetWrapper.java */
    /* loaded from: classes.dex */
    class b extends c.h.k.b0 {
        private boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f907b;

        b(int i2) {
            this.f907b = i2;
        }

        @Override // c.h.k.b0, c.h.k.a0
        public void a(View view) {
            this.a = true;
        }

        @Override // c.h.k.a0
        public void b(View view) {
            if (this.a) {
                return;
            }
            t0.this.a.setVisibility(this.f907b);
        }

        @Override // c.h.k.b0, c.h.k.a0
        public void c(View view) {
            t0.this.a.setVisibility(0);
        }
    }

    public t0(Toolbar toolbar, boolean z) {
        this(toolbar, z, c.a.h.a, c.a.e.n);
    }

    private void F(CharSequence charSequence) {
        this.f902i = charSequence;
        if ((this.f895b & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    private void G() {
        if ((this.f895b & 4) != 0) {
            if (TextUtils.isEmpty(this.f904k)) {
                this.a.setNavigationContentDescription(this.p);
            } else {
                this.a.setNavigationContentDescription(this.f904k);
            }
        }
    }

    private void H() {
        if ((this.f895b & 4) != 0) {
            Toolbar toolbar = this.a;
            Drawable drawable = this.f900g;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.a.setNavigationIcon((Drawable) null);
    }

    private void I() {
        Drawable drawable;
        int i2 = this.f895b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.f899f;
            if (drawable == null) {
                drawable = this.f898e;
            }
        } else {
            drawable = this.f898e;
        }
        this.a.setLogo(drawable);
    }

    private int y() {
        if (this.a.getNavigationIcon() != null) {
            this.q = this.a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    public void A(int i2) {
        if (i2 == this.p) {
            return;
        }
        this.p = i2;
        if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            C(this.p);
        }
    }

    public void B(Drawable drawable) {
        this.f899f = drawable;
        I();
    }

    public void C(int i2) {
        D(i2 == 0 ? null : e().getString(i2));
    }

    public void D(CharSequence charSequence) {
        this.f904k = charSequence;
        G();
    }

    public void E(CharSequence charSequence) {
        this.f903j = charSequence;
        if ((this.f895b & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.y
    public void a(Menu menu, m.a aVar) {
        if (this.n == null) {
            c cVar = new c(this.a.getContext());
            this.n = cVar;
            cVar.r(c.a.f.f2465g);
        }
        this.n.g(aVar);
        this.a.I((androidx.appcompat.view.menu.g) menu, this.n);
    }

    @Override // androidx.appcompat.widget.y
    public boolean b() {
        return this.a.A();
    }

    @Override // androidx.appcompat.widget.y
    public void c() {
        this.m = true;
    }

    @Override // androidx.appcompat.widget.y
    public void collapseActionView() {
        this.a.e();
    }

    @Override // androidx.appcompat.widget.y
    public boolean d() {
        return this.a.d();
    }

    @Override // androidx.appcompat.widget.y
    public Context e() {
        return this.a.getContext();
    }

    @Override // androidx.appcompat.widget.y
    public boolean f() {
        return this.a.z();
    }

    @Override // androidx.appcompat.widget.y
    public boolean g() {
        return this.a.w();
    }

    @Override // androidx.appcompat.widget.y
    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    @Override // androidx.appcompat.widget.y
    public boolean h() {
        return this.a.O();
    }

    @Override // androidx.appcompat.widget.y
    public void i() {
        this.a.f();
    }

    @Override // androidx.appcompat.widget.y
    public void j(l0 l0Var) {
        View view = this.f896c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.a;
            if (parent == toolbar) {
                toolbar.removeView(this.f896c);
            }
        }
        this.f896c = l0Var;
        if (l0Var == null || this.o != 2) {
            return;
        }
        this.a.addView(l0Var, 0);
        Toolbar.e eVar = (Toolbar.e) this.f896c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.a = 8388691;
        l0Var.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.y
    public boolean k() {
        return this.a.v();
    }

    @Override // androidx.appcompat.widget.y
    public void l(int i2) {
        View view;
        int i3 = this.f895b ^ i2;
        this.f895b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    G();
                }
                H();
            }
            if ((i3 & 3) != 0) {
                I();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.a.setTitle(this.f902i);
                    this.a.setSubtitle(this.f903j);
                } else {
                    this.a.setTitle((CharSequence) null);
                    this.a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) == 0 || (view = this.f897d) == null) {
                return;
            }
            if ((i2 & 16) != 0) {
                this.a.addView(view);
            } else {
                this.a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.y
    public Menu m() {
        return this.a.getMenu();
    }

    @Override // androidx.appcompat.widget.y
    public void n(int i2) {
        B(i2 != 0 ? c.a.k.a.a.d(e(), i2) : null);
    }

    @Override // androidx.appcompat.widget.y
    public int o() {
        return this.o;
    }

    @Override // androidx.appcompat.widget.y
    public c.h.k.z p(int i2, long j2) {
        return c.h.k.v.c(this.a).a(i2 == 0 ? 1.0f : 0.0f).d(j2).f(new b(i2));
    }

    @Override // androidx.appcompat.widget.y
    public void q(m.a aVar, g.a aVar2) {
        this.a.J(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.y
    public ViewGroup r() {
        return this.a;
    }

    @Override // androidx.appcompat.widget.y
    public void s(boolean z) {
    }

    @Override // androidx.appcompat.widget.y
    public void setIcon(int i2) {
        setIcon(i2 != 0 ? c.a.k.a.a.d(e(), i2) : null);
    }

    @Override // androidx.appcompat.widget.y
    public void setTitle(CharSequence charSequence) {
        this.f901h = true;
        F(charSequence);
    }

    @Override // androidx.appcompat.widget.y
    public void setVisibility(int i2) {
        this.a.setVisibility(i2);
    }

    @Override // androidx.appcompat.widget.y
    public void setWindowCallback(Window.Callback callback) {
        this.f905l = callback;
    }

    @Override // androidx.appcompat.widget.y
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f901h) {
            return;
        }
        F(charSequence);
    }

    @Override // androidx.appcompat.widget.y
    public int t() {
        return this.f895b;
    }

    @Override // androidx.appcompat.widget.y
    public void u() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.y
    public void v() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.y
    public void w(Drawable drawable) {
        this.f900g = drawable;
        H();
    }

    @Override // androidx.appcompat.widget.y
    public void x(boolean z) {
        this.a.setCollapsible(z);
    }

    public void z(View view) {
        View view2 = this.f897d;
        if (view2 != null && (this.f895b & 16) != 0) {
            this.a.removeView(view2);
        }
        this.f897d = view;
        if (view == null || (this.f895b & 16) == 0) {
            return;
        }
        this.a.addView(view);
    }

    public t0(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.f902i = toolbar.getTitle();
        this.f903j = toolbar.getSubtitle();
        this.f901h = this.f902i != null;
        this.f900g = toolbar.getNavigationIcon();
        s0 v = s0.v(toolbar.getContext(), null, c.a.j.a, c.a.a.f2421c, 0);
        this.q = v.g(c.a.j.f2507l);
        if (z) {
            CharSequence p = v.p(c.a.j.r);
            if (!TextUtils.isEmpty(p)) {
                setTitle(p);
            }
            CharSequence p2 = v.p(c.a.j.p);
            if (!TextUtils.isEmpty(p2)) {
                E(p2);
            }
            Drawable g2 = v.g(c.a.j.n);
            if (g2 != null) {
                B(g2);
            }
            Drawable g3 = v.g(c.a.j.m);
            if (g3 != null) {
                setIcon(g3);
            }
            if (this.f900g == null && (drawable = this.q) != null) {
                w(drawable);
            }
            l(v.k(c.a.j.f2503h, 0));
            int n = v.n(c.a.j.f2502g, 0);
            if (n != 0) {
                z(LayoutInflater.from(this.a.getContext()).inflate(n, (ViewGroup) this.a, false));
                l(this.f895b | 16);
            }
            int m = v.m(c.a.j.f2505j, 0);
            if (m > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = m;
                this.a.setLayoutParams(layoutParams);
            }
            int e2 = v.e(c.a.j.f2501f, -1);
            int e3 = v.e(c.a.j.f2500e, -1);
            if (e2 >= 0 || e3 >= 0) {
                this.a.H(Math.max(e2, 0), Math.max(e3, 0));
            }
            int n2 = v.n(c.a.j.s, 0);
            if (n2 != 0) {
                Toolbar toolbar2 = this.a;
                toolbar2.L(toolbar2.getContext(), n2);
            }
            int n3 = v.n(c.a.j.q, 0);
            if (n3 != 0) {
                Toolbar toolbar3 = this.a;
                toolbar3.K(toolbar3.getContext(), n3);
            }
            int n4 = v.n(c.a.j.o, 0);
            if (n4 != 0) {
                this.a.setPopupTheme(n4);
            }
        } else {
            this.f895b = y();
        }
        v.w();
        A(i2);
        this.f904k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.y
    public void setIcon(Drawable drawable) {
        this.f898e = drawable;
        I();
    }
}