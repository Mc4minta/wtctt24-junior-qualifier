package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.g;

/* compiled from: PopupMenu.java */
/* loaded from: classes.dex */
public class h0 {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.appcompat.view.menu.g f811b;

    /* renamed from: c  reason: collision with root package name */
    private final View f812c;

    /* renamed from: d  reason: collision with root package name */
    final androidx.appcompat.view.menu.l f813d;

    /* renamed from: e  reason: collision with root package name */
    d f814e;

    /* renamed from: f  reason: collision with root package name */
    c f815f;

    /* compiled from: PopupMenu.java */
    /* loaded from: classes.dex */
    class a implements g.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            d dVar = h0.this.f814e;
            if (dVar != null) {
                return dVar.onMenuItemClick(menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
        }
    }

    /* compiled from: PopupMenu.java */
    /* loaded from: classes.dex */
    class b implements PopupWindow.OnDismissListener {
        b() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            h0 h0Var = h0.this;
            c cVar = h0Var.f815f;
            if (cVar != null) {
                cVar.a(h0Var);
            }
        }
    }

    /* compiled from: PopupMenu.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(h0 h0Var);
    }

    /* compiled from: PopupMenu.java */
    /* loaded from: classes.dex */
    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public h0(Context context, View view) {
        this(context, view, 0);
    }

    public Menu a() {
        return this.f811b;
    }

    public MenuInflater b() {
        return new c.a.o.g(this.a);
    }

    public void c(d dVar) {
        this.f814e = dVar;
    }

    public void d() {
        this.f813d.k();
    }

    public h0(Context context, View view, int i2) {
        this(context, view, i2, c.a.a.F, 0);
    }

    public h0(Context context, View view, int i2, int i3, int i4) {
        this.a = context;
        this.f812c = view;
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        this.f811b = gVar;
        gVar.V(new a());
        androidx.appcompat.view.menu.l lVar = new androidx.appcompat.view.menu.l(context, gVar, view, false, i3, i4);
        this.f813d = lVar;
        lVar.h(i2);
        lVar.i(new b());
    }
}