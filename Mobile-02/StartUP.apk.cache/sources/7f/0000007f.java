package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.t0;
import androidx.appcompat.widget.y;
import c.h.k.v;
import java.util.ArrayList;

/* compiled from: ToolbarActionBar.java */
/* loaded from: classes.dex */
class l extends androidx.appcompat.app.a {
    y a;

    /* renamed from: b  reason: collision with root package name */
    boolean f487b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f488c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f489d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f490e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<a.b> f491f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f492g = new a();

    /* renamed from: h  reason: collision with root package name */
    private final Toolbar.f f493h;

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.A();
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    class b implements Toolbar.f {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            return l.this.f488c.onMenuItemSelected(0, menuItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public final class c implements m.a {
        private boolean a;

        c() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (this.a) {
                return;
            }
            this.a = true;
            l.this.a.i();
            Window.Callback callback = l.this.f488c;
            if (callback != null) {
                callback.onPanelClosed(108, gVar);
            }
            this.a = false;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callback = l.this.f488c;
            if (callback != null) {
                callback.onMenuOpened(108, gVar);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public final class d implements g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            l lVar = l.this;
            if (lVar.f488c != null) {
                if (lVar.a.b()) {
                    l.this.f488c.onPanelClosed(108, gVar);
                } else if (l.this.f488c.onPreparePanel(0, null, gVar)) {
                    l.this.f488c.onMenuOpened(108, gVar);
                }
            }
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    private class e extends c.a.o.i {
        public e(Window.Callback callback) {
            super(callback);
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public View onCreatePanelView(int i2) {
            if (i2 == 0) {
                return new View(l.this.a.e());
            }
            return super.onCreatePanelView(i2);
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (onPreparePanel) {
                l lVar = l.this;
                if (!lVar.f487b) {
                    lVar.a.c();
                    l.this.f487b = true;
                }
            }
            return onPreparePanel;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f493h = bVar;
        this.a = new t0(toolbar, false);
        e eVar = new e(callback);
        this.f488c = eVar;
        this.a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.a.setWindowTitle(charSequence);
    }

    private Menu y() {
        if (!this.f489d) {
            this.a.q(new c(), new d());
            this.f489d = true;
        }
        return this.a.m();
    }

    void A() {
        Menu y = y();
        androidx.appcompat.view.menu.g gVar = y instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) y : null;
        if (gVar != null) {
            gVar.h0();
        }
        try {
            y.clear();
            if (!this.f488c.onCreatePanelMenu(0, y) || !this.f488c.onPreparePanel(0, null, y)) {
                y.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.g0();
            }
        }
    }

    public void B(int i2, int i3) {
        this.a.l((i2 & i3) | ((~i3) & this.a.t()));
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        return this.a.g();
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        if (this.a.k()) {
            this.a.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        if (z == this.f490e) {
            return;
        }
        this.f490e = z;
        int size = this.f491f.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f491f.get(i2).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.a.t();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        return this.a.e();
    }

    @Override // androidx.appcompat.app.a
    public boolean l() {
        this.a.r().removeCallbacks(this.f492g);
        v.c0(this.a.r(), this.f492g);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.app.a
    public void n() {
        this.a.r().removeCallbacks(this.f492g);
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i2, KeyEvent keyEvent) {
        Menu y = y();
        if (y != null) {
            y.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            return y.performShortcut(i2, keyEvent, 0);
        }
        return false;
    }

    @Override // androidx.appcompat.app.a
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean q() {
        return this.a.h();
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        B(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(Drawable drawable) {
        this.a.w(drawable);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.a.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void w(CharSequence charSequence) {
        this.a.setWindowTitle(charSequence);
    }

    public Window.Callback z() {
        return this.f488c;
    }
}