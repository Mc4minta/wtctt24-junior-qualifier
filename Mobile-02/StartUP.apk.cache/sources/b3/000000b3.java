package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.g0;
import c.h.k.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StandardMenuPopup.java */
/* loaded from: classes.dex */
public final class q extends k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener {

    /* renamed from: b  reason: collision with root package name */
    private static final int f640b = c.a.g.m;

    /* renamed from: c  reason: collision with root package name */
    private final Context f641c;

    /* renamed from: d  reason: collision with root package name */
    private final g f642d;

    /* renamed from: e  reason: collision with root package name */
    private final f f643e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f644f;

    /* renamed from: g  reason: collision with root package name */
    private final int f645g;

    /* renamed from: h  reason: collision with root package name */
    private final int f646h;

    /* renamed from: j  reason: collision with root package name */
    private final int f647j;

    /* renamed from: k  reason: collision with root package name */
    final g0 f648k;
    private PopupWindow.OnDismissListener n;
    private View p;
    View q;
    private m.a t;
    ViewTreeObserver u;
    private boolean v;
    private boolean w;
    private int x;
    private boolean z;

    /* renamed from: l  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f649l = new a();
    private final View.OnAttachStateChangeListener m = new b();
    private int y = 0;

    /* compiled from: StandardMenuPopup.java */
    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!q.this.a() || q.this.f648k.x()) {
                return;
            }
            View view = q.this.q;
            if (view != null && view.isShown()) {
                q.this.f648k.h();
            } else {
                q.this.dismiss();
            }
        }
    }

    /* compiled from: StandardMenuPopup.java */
    /* loaded from: classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = q.this.u;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.u = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.u.removeGlobalOnLayoutListener(qVar.f649l);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i2, int i3, boolean z) {
        this.f641c = context;
        this.f642d = gVar;
        this.f644f = z;
        this.f643e = new f(gVar, LayoutInflater.from(context), z, f640b);
        this.f646h = i2;
        this.f647j = i3;
        Resources resources = context.getResources();
        this.f645g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(c.a.d.f2440d));
        this.p = view;
        this.f648k = new g0(context, null, i2, i3);
        gVar.c(this, context);
    }

    private boolean B() {
        View view;
        if (a()) {
            return true;
        }
        if (this.v || (view = this.p) == null) {
            return false;
        }
        this.q = view;
        this.f648k.G(this);
        this.f648k.H(this);
        this.f648k.F(true);
        View view2 = this.q;
        boolean z = this.u == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.u = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f649l);
        }
        view2.addOnAttachStateChangeListener(this.m);
        this.f648k.z(view2);
        this.f648k.C(this.y);
        if (!this.w) {
            this.x = k.q(this.f643e, null, this.f641c, this.f645g);
            this.w = true;
        }
        this.f648k.B(this.x);
        this.f648k.E(2);
        this.f648k.D(p());
        this.f648k.h();
        ListView k2 = this.f648k.k();
        k2.setOnKeyListener(this);
        if (this.z && this.f642d.z() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f641c).inflate(c.a.g.f2481l, (ViewGroup) k2, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f642d.z());
            }
            frameLayout.setEnabled(false);
            k2.addHeaderView(frameLayout, null, false);
        }
        this.f648k.p(this.f643e);
        this.f648k.h();
        return true;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a() {
        return !this.v && this.f648k.a();
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        if (gVar != this.f642d) {
            return;
        }
        dismiss();
        m.a aVar = this.t;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(boolean z) {
        this.w = false;
        f fVar = this.f643e;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        if (a()) {
            this.f648k.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void g(m.a aVar) {
        this.t = aVar;
    }

    @Override // androidx.appcompat.view.menu.p
    public void h() {
        if (!B()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void j(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView k() {
        return this.f648k.k();
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean l(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f641c, rVar, this.q, this.f644f, this.f646h, this.f647j);
            lVar.j(this.t);
            lVar.g(k.z(rVar));
            lVar.i(this.n);
            this.n = null;
            this.f642d.e(false);
            int c2 = this.f648k.c();
            int o = this.f648k.o();
            if ((Gravity.getAbsoluteGravity(this.y, v.y(this.p)) & 7) == 5) {
                c2 += this.p.getWidth();
            }
            if (lVar.n(c2, o)) {
                m.a aVar = this.t;
                if (aVar != null) {
                    aVar.c(rVar);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable m() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.k
    public void n(g gVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.v = true;
        this.f642d.close();
        ViewTreeObserver viewTreeObserver = this.u;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.u = this.q.getViewTreeObserver();
            }
            this.u.removeGlobalOnLayoutListener(this.f649l);
            this.u = null;
        }
        this.q.removeOnAttachStateChangeListener(this.m);
        PopupWindow.OnDismissListener onDismissListener = this.n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i2 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public void r(View view) {
        this.p = view;
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(boolean z) {
        this.f643e.d(z);
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(int i2) {
        this.y = i2;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(int i2) {
        this.f648k.e(i2);
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void x(boolean z) {
        this.z = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void y(int i2) {
        this.f648k.l(i2);
    }
}