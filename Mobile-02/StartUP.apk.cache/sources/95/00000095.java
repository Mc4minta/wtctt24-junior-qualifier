package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.f0;
import androidx.appcompat.widget.g0;
import c.h.k.v;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CascadingMenuPopup.java */
/* loaded from: classes.dex */
public final class d extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    private static final int f565b = c.a.g.f2474e;
    private boolean B;
    private m.a C;
    ViewTreeObserver D;
    private PopupWindow.OnDismissListener E;
    boolean F;

    /* renamed from: c  reason: collision with root package name */
    private final Context f566c;

    /* renamed from: d  reason: collision with root package name */
    private final int f567d;

    /* renamed from: e  reason: collision with root package name */
    private final int f568e;

    /* renamed from: f  reason: collision with root package name */
    private final int f569f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f570g;

    /* renamed from: h  reason: collision with root package name */
    final Handler f571h;
    private View t;
    View u;
    private boolean w;
    private boolean x;
    private int y;
    private int z;

    /* renamed from: j  reason: collision with root package name */
    private final List<g> f572j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    final List<C0007d> f573k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f574l = new a();
    private final View.OnAttachStateChangeListener m = new b();
    private final f0 n = new c();
    private int p = 0;
    private int q = 0;
    private boolean A = false;
    private int v = F();

    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.a() || d.this.f573k.size() <= 0 || d.this.f573k.get(0).a.x()) {
                return;
            }
            View view = d.this.u;
            if (view != null && view.isShown()) {
                for (C0007d c0007d : d.this.f573k) {
                    c0007d.a.h();
                }
                return;
            }
            d.this.dismiss();
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.D;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.D = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.D.removeGlobalOnLayoutListener(dVar.f574l);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    class c implements f0 {

        /* compiled from: CascadingMenuPopup.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            final /* synthetic */ C0007d a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MenuItem f575b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ g f576c;

            a(C0007d c0007d, MenuItem menuItem, g gVar) {
                this.a = c0007d;
                this.f575b = menuItem;
                this.f576c = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0007d c0007d = this.a;
                if (c0007d != null) {
                    d.this.F = true;
                    c0007d.f578b.e(false);
                    d.this.F = false;
                }
                if (this.f575b.isEnabled() && this.f575b.hasSubMenu()) {
                    this.f576c.N(this.f575b, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.f0
        public void d(g gVar, MenuItem menuItem) {
            d.this.f571h.removeCallbacksAndMessages(null);
            int size = d.this.f573k.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (gVar == d.this.f573k.get(i2).f578b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return;
            }
            int i3 = i2 + 1;
            d.this.f571h.postAtTime(new a(i3 < d.this.f573k.size() ? d.this.f573k.get(i3) : null, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.f0
        public void g(g gVar, MenuItem menuItem) {
            d.this.f571h.removeCallbacksAndMessages(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: androidx.appcompat.view.menu.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0007d {
        public final g0 a;

        /* renamed from: b  reason: collision with root package name */
        public final g f578b;

        /* renamed from: c  reason: collision with root package name */
        public final int f579c;

        public C0007d(g0 g0Var, g gVar, int i2) {
            this.a = g0Var;
            this.f578b = gVar;
            this.f579c = i2;
        }

        public ListView a() {
            return this.a.k();
        }
    }

    public d(Context context, View view, int i2, int i3, boolean z) {
        this.f566c = context;
        this.t = view;
        this.f568e = i2;
        this.f569f = i3;
        this.f570g = z;
        Resources resources = context.getResources();
        this.f567d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(c.a.d.f2440d));
        this.f571h = new Handler();
    }

    private g0 B() {
        g0 g0Var = new g0(this.f566c, null, this.f568e, this.f569f);
        g0Var.P(this.n);
        g0Var.H(this);
        g0Var.G(this);
        g0Var.z(this.t);
        g0Var.C(this.q);
        g0Var.F(true);
        g0Var.E(2);
        return g0Var;
    }

    private int C(g gVar) {
        int size = this.f573k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (gVar == this.f573k.get(i2).f578b) {
                return i2;
            }
        }
        return -1;
    }

    private MenuItem D(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = gVar.getItem(i2);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View E(C0007d c0007d, g gVar) {
        f fVar;
        int i2;
        int firstVisiblePosition;
        MenuItem D = D(c0007d.f578b, gVar);
        if (D == null) {
            return null;
        }
        ListView a2 = c0007d.a();
        ListAdapter adapter = a2.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i2 = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            } else if (D == fVar.getItem(i3)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + i2) - a2.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a2.getChildCount()) {
            return a2.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int F() {
        return v.y(this.t) == 1 ? 0 : 1;
    }

    private int G(int i2) {
        List<C0007d> list = this.f573k;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.u.getWindowVisibleDisplayFrame(rect);
        return this.v == 1 ? (iArr[0] + a2.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    private void H(g gVar) {
        C0007d c0007d;
        View view;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.f566c);
        f fVar = new f(gVar, from, this.f570g, f565b);
        if (!a() && this.A) {
            fVar.d(true);
        } else if (a()) {
            fVar.d(k.z(gVar));
        }
        int q = k.q(fVar, null, this.f566c, this.f567d);
        g0 B = B();
        B.p(fVar);
        B.B(q);
        B.C(this.q);
        if (this.f573k.size() > 0) {
            List<C0007d> list = this.f573k;
            c0007d = list.get(list.size() - 1);
            view = E(c0007d, gVar);
        } else {
            c0007d = null;
            view = null;
        }
        if (view != null) {
            B.Q(false);
            B.N(null);
            int G = G(q);
            boolean z = G == 1;
            this.v = G;
            if (Build.VERSION.SDK_INT >= 26) {
                B.z(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.t.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.q & 7) == 5) {
                    iArr[0] = iArr[0] + this.t.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.q & 5) == 5) {
                if (!z) {
                    q = view.getWidth();
                    i4 = i2 - q;
                }
                i4 = i2 + q;
            } else {
                if (z) {
                    q = view.getWidth();
                    i4 = i2 + q;
                }
                i4 = i2 - q;
            }
            B.e(i4);
            B.I(true);
            B.l(i3);
        } else {
            if (this.w) {
                B.e(this.y);
            }
            if (this.x) {
                B.l(this.z);
            }
            B.D(p());
        }
        this.f573k.add(new C0007d(B, gVar, this.v));
        B.h();
        ListView k2 = B.k();
        k2.setOnKeyListener(this);
        if (c0007d == null && this.B && gVar.z() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(c.a.g.f2481l, (ViewGroup) k2, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(gVar.z());
            k2.addHeaderView(frameLayout, null, false);
            B.h();
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a() {
        return this.f573k.size() > 0 && this.f573k.get(0).a.a();
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        int C = C(gVar);
        if (C < 0) {
            return;
        }
        int i2 = C + 1;
        if (i2 < this.f573k.size()) {
            this.f573k.get(i2).f578b.e(false);
        }
        C0007d remove = this.f573k.remove(C);
        remove.f578b.Q(this);
        if (this.F) {
            remove.a.O(null);
            remove.a.A(0);
        }
        remove.a.dismiss();
        int size = this.f573k.size();
        if (size > 0) {
            this.v = this.f573k.get(size - 1).f579c;
        } else {
            this.v = F();
        }
        if (size != 0) {
            if (z) {
                this.f573k.get(0).f578b.e(false);
                return;
            }
            return;
        }
        dismiss();
        m.a aVar = this.C;
        if (aVar != null) {
            aVar.b(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.D;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.D.removeGlobalOnLayoutListener(this.f574l);
            }
            this.D = null;
        }
        this.u.removeOnAttachStateChangeListener(this.m);
        this.E.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(boolean z) {
        for (C0007d c0007d : this.f573k) {
            k.A(c0007d.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        int size = this.f573k.size();
        if (size > 0) {
            C0007d[] c0007dArr = (C0007d[]) this.f573k.toArray(new C0007d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                C0007d c0007d = c0007dArr[i2];
                if (c0007d.a.a()) {
                    c0007d.a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void g(m.a aVar) {
        this.C = aVar;
    }

    @Override // androidx.appcompat.view.menu.p
    public void h() {
        if (a()) {
            return;
        }
        for (g gVar : this.f572j) {
            H(gVar);
        }
        this.f572j.clear();
        View view = this.t;
        this.u = view;
        if (view != null) {
            boolean z = this.D == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.D = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f574l);
            }
            this.u.addOnAttachStateChangeListener(this.m);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void j(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView k() {
        if (this.f573k.isEmpty()) {
            return null;
        }
        List<C0007d> list = this.f573k;
        return list.get(list.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean l(r rVar) {
        for (C0007d c0007d : this.f573k) {
            if (rVar == c0007d.f578b) {
                c0007d.a().requestFocus();
                return true;
            }
        }
        if (rVar.hasVisibleItems()) {
            n(rVar);
            m.a aVar = this.C;
            if (aVar != null) {
                aVar.c(rVar);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable m() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.k
    public void n(g gVar) {
        gVar.c(this, this.f566c);
        if (a()) {
            H(gVar);
        } else {
            this.f572j.add(gVar);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    protected boolean o() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0007d c0007d;
        int size = this.f573k.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                c0007d = null;
                break;
            }
            c0007d = this.f573k.get(i2);
            if (!c0007d.a.a()) {
                break;
            }
            i2++;
        }
        if (c0007d != null) {
            c0007d.f578b.e(false);
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
        if (this.t != view) {
            this.t = view;
            this.q = c.h.k.d.b(this.p, v.y(view));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(boolean z) {
        this.A = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(int i2) {
        if (this.p != i2) {
            this.p = i2;
            this.q = c.h.k.d.b(i2, v.y(this.t));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(int i2) {
        this.w = true;
        this.y = i2;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(PopupWindow.OnDismissListener onDismissListener) {
        this.E = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void x(boolean z) {
        this.B = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void y(int i2) {
        this.x = true;
        this.z = i2;
    }
}