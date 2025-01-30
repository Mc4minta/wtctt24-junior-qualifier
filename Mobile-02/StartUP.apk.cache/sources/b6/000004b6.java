package c.a.o;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import c.a.o.b;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode.java */
/* loaded from: classes.dex */
public class e extends b implements g.a {

    /* renamed from: c  reason: collision with root package name */
    private Context f2551c;

    /* renamed from: d  reason: collision with root package name */
    private ActionBarContextView f2552d;

    /* renamed from: e  reason: collision with root package name */
    private b.a f2553e;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<View> f2554f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2555g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2556h;

    /* renamed from: j  reason: collision with root package name */
    private androidx.appcompat.view.menu.g f2557j;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f2551c = context;
        this.f2552d = actionBarContextView;
        this.f2553e = aVar;
        androidx.appcompat.view.menu.g W = new androidx.appcompat.view.menu.g(actionBarContextView.getContext()).W(1);
        this.f2557j = W;
        W.V(this);
        this.f2556h = z;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        return this.f2553e.d(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        k();
        this.f2552d.l();
    }

    @Override // c.a.o.b
    public void c() {
        if (this.f2555g) {
            return;
        }
        this.f2555g = true;
        this.f2552d.sendAccessibilityEvent(32);
        this.f2553e.a(this);
    }

    @Override // c.a.o.b
    public View d() {
        WeakReference<View> weakReference = this.f2554f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // c.a.o.b
    public Menu e() {
        return this.f2557j;
    }

    @Override // c.a.o.b
    public MenuInflater f() {
        return new g(this.f2552d.getContext());
    }

    @Override // c.a.o.b
    public CharSequence g() {
        return this.f2552d.getSubtitle();
    }

    @Override // c.a.o.b
    public CharSequence i() {
        return this.f2552d.getTitle();
    }

    @Override // c.a.o.b
    public void k() {
        this.f2553e.c(this, this.f2557j);
    }

    @Override // c.a.o.b
    public boolean l() {
        return this.f2552d.j();
    }

    @Override // c.a.o.b
    public void m(View view) {
        this.f2552d.setCustomView(view);
        this.f2554f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // c.a.o.b
    public void n(int i2) {
        o(this.f2551c.getString(i2));
    }

    @Override // c.a.o.b
    public void o(CharSequence charSequence) {
        this.f2552d.setSubtitle(charSequence);
    }

    @Override // c.a.o.b
    public void q(int i2) {
        r(this.f2551c.getString(i2));
    }

    @Override // c.a.o.b
    public void r(CharSequence charSequence) {
        this.f2552d.setTitle(charSequence);
    }

    @Override // c.a.o.b
    public void s(boolean z) {
        super.s(z);
        this.f2552d.setTitleOptional(z);
    }
}