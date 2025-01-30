package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.l0;
import androidx.appcompat.widget.y;
import c.a.o.b;
import c.h.k.a0;
import c.h.k.b0;
import c.h.k.c0;
import c.h.k.v;
import c.h.k.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar.java */
/* loaded from: classes.dex */
public class o extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    private static final Interpolator a = new AccelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f507b = new DecelerateInterpolator();
    c.a.o.h A;
    private boolean B;
    boolean C;

    /* renamed from: c  reason: collision with root package name */
    Context f508c;

    /* renamed from: d  reason: collision with root package name */
    private Context f509d;

    /* renamed from: e  reason: collision with root package name */
    private Activity f510e;

    /* renamed from: f  reason: collision with root package name */
    ActionBarOverlayLayout f511f;

    /* renamed from: g  reason: collision with root package name */
    ActionBarContainer f512g;

    /* renamed from: h  reason: collision with root package name */
    y f513h;

    /* renamed from: i  reason: collision with root package name */
    ActionBarContextView f514i;

    /* renamed from: j  reason: collision with root package name */
    View f515j;

    /* renamed from: k  reason: collision with root package name */
    l0 f516k;
    private boolean n;
    d o;
    c.a.o.b p;
    b.a q;
    private boolean r;
    private boolean t;
    boolean w;
    boolean x;
    private boolean y;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<?> f517l = new ArrayList<>();
    private int m = -1;
    private ArrayList<a.b> s = new ArrayList<>();
    private int u = 0;
    boolean v = true;
    private boolean z = true;
    final a0 D = new a();
    final a0 E = new b();
    final c0 F = new c();

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    class a extends b0 {
        a() {
        }

        @Override // c.h.k.a0
        public void b(View view) {
            View view2;
            o oVar = o.this;
            if (oVar.v && (view2 = oVar.f515j) != null) {
                view2.setTranslationY(0.0f);
                o.this.f512g.setTranslationY(0.0f);
            }
            o.this.f512g.setVisibility(8);
            o.this.f512g.setTransitioning(false);
            o oVar2 = o.this;
            oVar2.A = null;
            oVar2.A();
            ActionBarOverlayLayout actionBarOverlayLayout = o.this.f511f;
            if (actionBarOverlayLayout != null) {
                v.h0(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    class b extends b0 {
        b() {
        }

        @Override // c.h.k.a0
        public void b(View view) {
            o oVar = o.this;
            oVar.A = null;
            oVar.f512g.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    class c implements c0 {
        c() {
        }

        @Override // c.h.k.c0
        public void a(View view) {
            ((View) o.this.f512g.getParent()).invalidate();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    public class d extends c.a.o.b implements g.a {

        /* renamed from: c  reason: collision with root package name */
        private final Context f518c;

        /* renamed from: d  reason: collision with root package name */
        private final androidx.appcompat.view.menu.g f519d;

        /* renamed from: e  reason: collision with root package name */
        private b.a f520e;

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<View> f521f;

        public d(Context context, b.a aVar) {
            this.f518c = context;
            this.f520e = aVar;
            androidx.appcompat.view.menu.g W = new androidx.appcompat.view.menu.g(context).W(1);
            this.f519d = W;
            W.V(this);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            b.a aVar = this.f520e;
            if (aVar != null) {
                return aVar.d(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            if (this.f520e == null) {
                return;
            }
            k();
            o.this.f514i.l();
        }

        @Override // c.a.o.b
        public void c() {
            o oVar = o.this;
            if (oVar.o != this) {
                return;
            }
            if (!o.z(oVar.w, oVar.x, false)) {
                o oVar2 = o.this;
                oVar2.p = this;
                oVar2.q = this.f520e;
            } else {
                this.f520e.a(this);
            }
            this.f520e = null;
            o.this.y(false);
            o.this.f514i.g();
            o.this.f513h.r().sendAccessibilityEvent(32);
            o oVar3 = o.this;
            oVar3.f511f.setHideOnContentScrollEnabled(oVar3.C);
            o.this.o = null;
        }

        @Override // c.a.o.b
        public View d() {
            WeakReference<View> weakReference = this.f521f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // c.a.o.b
        public Menu e() {
            return this.f519d;
        }

        @Override // c.a.o.b
        public MenuInflater f() {
            return new c.a.o.g(this.f518c);
        }

        @Override // c.a.o.b
        public CharSequence g() {
            return o.this.f514i.getSubtitle();
        }

        @Override // c.a.o.b
        public CharSequence i() {
            return o.this.f514i.getTitle();
        }

        @Override // c.a.o.b
        public void k() {
            if (o.this.o != this) {
                return;
            }
            this.f519d.h0();
            try {
                this.f520e.c(this, this.f519d);
            } finally {
                this.f519d.g0();
            }
        }

        @Override // c.a.o.b
        public boolean l() {
            return o.this.f514i.j();
        }

        @Override // c.a.o.b
        public void m(View view) {
            o.this.f514i.setCustomView(view);
            this.f521f = new WeakReference<>(view);
        }

        @Override // c.a.o.b
        public void n(int i2) {
            o(o.this.f508c.getResources().getString(i2));
        }

        @Override // c.a.o.b
        public void o(CharSequence charSequence) {
            o.this.f514i.setSubtitle(charSequence);
        }

        @Override // c.a.o.b
        public void q(int i2) {
            r(o.this.f508c.getResources().getString(i2));
        }

        @Override // c.a.o.b
        public void r(CharSequence charSequence) {
            o.this.f514i.setTitle(charSequence);
        }

        @Override // c.a.o.b
        public void s(boolean z) {
            super.s(z);
            o.this.f514i.setTitleOptional(z);
        }

        public boolean t() {
            this.f519d.h0();
            try {
                return this.f520e.b(this, this.f519d);
            } finally {
                this.f519d.g0();
            }
        }
    }

    public o(Activity activity, boolean z) {
        this.f510e = activity;
        View decorView = activity.getWindow().getDecorView();
        G(decorView);
        if (z) {
            return;
        }
        this.f515j = decorView.findViewById(16908290);
    }

    private y D(View view) {
        if (view instanceof y) {
            return (y) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void F() {
        if (this.y) {
            this.y = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f511f;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            O(false);
        }
    }

    private void G(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(c.a.f.p);
        this.f511f = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f513h = D(view.findViewById(c.a.f.a));
        this.f514i = (ActionBarContextView) view.findViewById(c.a.f.f2464f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(c.a.f.f2461c);
        this.f512g = actionBarContainer;
        y yVar = this.f513h;
        if (yVar != null && this.f514i != null && actionBarContainer != null) {
            this.f508c = yVar.e();
            boolean z = (this.f513h.t() & 4) != 0;
            if (z) {
                this.n = true;
            }
            c.a.o.a b2 = c.a.o.a.b(this.f508c);
            L(b2.a() || z);
            J(b2.g());
            TypedArray obtainStyledAttributes = this.f508c.obtainStyledAttributes(null, c.a.j.a, c.a.a.f2421c, 0);
            if (obtainStyledAttributes.getBoolean(c.a.j.f2506k, false)) {
                K(true);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(c.a.j.f2504i, 0);
            if (dimensionPixelSize != 0) {
                I(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(o.class.getSimpleName() + " can only be used with a compatible window decor layout");
    }

    private void J(boolean z) {
        this.t = z;
        if (!z) {
            this.f513h.j(null);
            this.f512g.setTabContainer(this.f516k);
        } else {
            this.f512g.setTabContainer(null);
            this.f513h.j(this.f516k);
        }
        boolean z2 = true;
        boolean z3 = E() == 2;
        l0 l0Var = this.f516k;
        if (l0Var != null) {
            if (z3) {
                l0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f511f;
                if (actionBarOverlayLayout != null) {
                    v.h0(actionBarOverlayLayout);
                }
            } else {
                l0Var.setVisibility(8);
            }
        }
        this.f513h.x(!this.t && z3);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f511f;
        if (this.t || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z2);
    }

    private boolean M() {
        return v.S(this.f512g);
    }

    private void N() {
        if (this.y) {
            return;
        }
        this.y = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f511f;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        O(false);
    }

    private void O(boolean z) {
        if (z(this.w, this.x, this.y)) {
            if (this.z) {
                return;
            }
            this.z = true;
            C(z);
        } else if (this.z) {
            this.z = false;
            B(z);
        }
    }

    static boolean z(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    void A() {
        b.a aVar = this.q;
        if (aVar != null) {
            aVar.a(this.p);
            this.p = null;
            this.q = null;
        }
    }

    public void B(boolean z) {
        View view;
        int[] iArr;
        c.a.o.h hVar = this.A;
        if (hVar != null) {
            hVar.a();
        }
        if (this.u == 0 && (this.B || z)) {
            this.f512g.setAlpha(1.0f);
            this.f512g.setTransitioning(true);
            c.a.o.h hVar2 = new c.a.o.h();
            float f2 = -this.f512g.getHeight();
            if (z) {
                this.f512g.getLocationInWindow(new int[]{0, 0});
                f2 -= iArr[1];
            }
            z k2 = v.c(this.f512g).k(f2);
            k2.i(this.F);
            hVar2.c(k2);
            if (this.v && (view = this.f515j) != null) {
                hVar2.c(v.c(view).k(f2));
            }
            hVar2.f(a);
            hVar2.e(250L);
            hVar2.g(this.D);
            this.A = hVar2;
            hVar2.h();
            return;
        }
        this.D.b(null);
    }

    public void C(boolean z) {
        View view;
        View view2;
        int[] iArr;
        c.a.o.h hVar = this.A;
        if (hVar != null) {
            hVar.a();
        }
        this.f512g.setVisibility(0);
        if (this.u == 0 && (this.B || z)) {
            this.f512g.setTranslationY(0.0f);
            float f2 = -this.f512g.getHeight();
            if (z) {
                this.f512g.getLocationInWindow(new int[]{0, 0});
                f2 -= iArr[1];
            }
            this.f512g.setTranslationY(f2);
            c.a.o.h hVar2 = new c.a.o.h();
            z k2 = v.c(this.f512g).k(0.0f);
            k2.i(this.F);
            hVar2.c(k2);
            if (this.v && (view2 = this.f515j) != null) {
                view2.setTranslationY(f2);
                hVar2.c(v.c(this.f515j).k(0.0f));
            }
            hVar2.f(f507b);
            hVar2.e(250L);
            hVar2.g(this.E);
            this.A = hVar2;
            hVar2.h();
        } else {
            this.f512g.setAlpha(1.0f);
            this.f512g.setTranslationY(0.0f);
            if (this.v && (view = this.f515j) != null) {
                view.setTranslationY(0.0f);
            }
            this.E.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f511f;
        if (actionBarOverlayLayout != null) {
            v.h0(actionBarOverlayLayout);
        }
    }

    public int E() {
        return this.f513h.o();
    }

    public void H(int i2, int i3) {
        int t = this.f513h.t();
        if ((i3 & 4) != 0) {
            this.n = true;
        }
        this.f513h.l((i2 & i3) | ((~i3) & t));
    }

    public void I(float f2) {
        v.q0(this.f512g, f2);
    }

    public void K(boolean z) {
        if (z && !this.f511f.q()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.C = z;
        this.f511f.setHideOnContentScrollEnabled(z);
    }

    public void L(boolean z) {
        this.f513h.s(z);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.x) {
            this.x = false;
            O(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(boolean z) {
        this.v = z;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (this.x) {
            return;
        }
        this.x = true;
        O(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        c.a.o.h hVar = this.A;
        if (hVar != null) {
            hVar.a();
            this.A = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f(int i2) {
        this.u = i2;
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        y yVar = this.f513h;
        if (yVar == null || !yVar.k()) {
            return false;
        }
        this.f513h.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        if (z == this.r) {
            return;
        }
        this.r = z;
        int size = this.s.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.s.get(i2).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f513h.t();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.f509d == null) {
            TypedValue typedValue = new TypedValue();
            this.f508c.getTheme().resolveAttribute(c.a.a.f2425g, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f509d = new ContextThemeWrapper(this.f508c, i2);
            } else {
                this.f509d = this.f508c;
            }
        }
        return this.f509d;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        J(c.a.o.a.b(this.f508c).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i2, KeyEvent keyEvent) {
        Menu e2;
        d dVar = this.o;
        if (dVar == null || (e2 = dVar.e()) == null) {
            return false;
        }
        e2.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return e2.performShortcut(i2, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
        if (this.n) {
            return;
        }
        s(z);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        H(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(Drawable drawable) {
        this.f513h.w(drawable);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z) {
        c.a.o.h hVar;
        this.B = z;
        if (z || (hVar = this.A) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.f513h.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void w(CharSequence charSequence) {
        this.f513h.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public c.a.o.b x(b.a aVar) {
        d dVar = this.o;
        if (dVar != null) {
            dVar.c();
        }
        this.f511f.setHideOnContentScrollEnabled(false);
        this.f514i.k();
        d dVar2 = new d(this.f514i.getContext(), aVar);
        if (dVar2.t()) {
            this.o = dVar2;
            dVar2.k();
            this.f514i.h(dVar2);
            y(true);
            this.f514i.sendAccessibilityEvent(32);
            return dVar2;
        }
        return null;
    }

    public void y(boolean z) {
        z p;
        z f2;
        if (z) {
            N();
        } else {
            F();
        }
        if (!M()) {
            if (z) {
                this.f513h.setVisibility(4);
                this.f514i.setVisibility(0);
                return;
            }
            this.f513h.setVisibility(0);
            this.f514i.setVisibility(8);
            return;
        }
        if (z) {
            f2 = this.f513h.p(4, 100L);
            p = this.f514i.f(0, 200L);
        } else {
            p = this.f513h.p(0, 200L);
            f2 = this.f514i.f(8, 100L);
        }
        c.a.o.h hVar = new c.a.o.h();
        hVar.d(f2, p);
        hVar.h();
    }

    public o(Dialog dialog) {
        G(dialog.getWindow().getDecorView());
    }
}