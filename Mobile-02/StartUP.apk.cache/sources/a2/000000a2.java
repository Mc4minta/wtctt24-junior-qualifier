package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.n;
import c.h.k.b;

/* compiled from: MenuItemImpl.java */
/* loaded from: classes.dex */
public final class i implements c.h.g.a.b {
    private View A;
    private c.h.k.b B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f609b;

    /* renamed from: c  reason: collision with root package name */
    private final int f610c;

    /* renamed from: d  reason: collision with root package name */
    private final int f611d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f612e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f613f;

    /* renamed from: g  reason: collision with root package name */
    private Intent f614g;

    /* renamed from: h  reason: collision with root package name */
    private char f615h;

    /* renamed from: j  reason: collision with root package name */
    private char f617j;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f619l;
    g n;
    private r o;
    private Runnable p;
    private MenuItem.OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private int z;

    /* renamed from: i  reason: collision with root package name */
    private int f616i = 4096;

    /* renamed from: k  reason: collision with root package name */
    private int f618k = 4096;
    private int m = 0;
    private ColorStateList t = null;
    private PorterDuff.Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private boolean D = false;

    /* compiled from: MenuItemImpl.java */
    /* loaded from: classes.dex */
    class a implements b.InterfaceC0068b {
        a() {
        }

        @Override // c.h.k.b.InterfaceC0068b
        public void onActionProviderVisibilityChanged(boolean z) {
            i iVar = i.this;
            iVar.n.L(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.z = 0;
        this.n = gVar;
        this.a = i3;
        this.f609b = i2;
        this.f610c = i4;
        this.f611d = i5;
        this.f612e = charSequence;
        this.z = i6;
    }

    private static void d(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (this.v) {
                androidx.core.graphics.drawable.a.o(drawable, this.t);
            }
            if (this.w) {
                androidx.core.graphics.drawable.a.p(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.n.J() && g() != 0;
    }

    public boolean B() {
        return (this.z & 4) == 4;
    }

    @Override // c.h.g.a.b
    public c.h.g.a.b a(c.h.k.b bVar) {
        c.h.k.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.h();
        }
        this.A = null;
        this.B = bVar;
        this.n.M(true);
        c.h.k.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.j(new a());
        }
        return this;
    }

    @Override // c.h.g.a.b
    public c.h.k.b b() {
        return this.B;
    }

    public void c() {
        this.n.K(this);
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.f(this);
        }
        return false;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public boolean expandActionView() {
        if (j()) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.C;
            if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
                return this.n.m(this);
            }
            return false;
        }
        return false;
    }

    public int f() {
        return this.f611d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char g() {
        return this.n.I() ? this.f617j : this.f615h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        c.h.k.b bVar = this.B;
        if (bVar != null) {
            View d2 = bVar.d(this);
            this.A = d2;
            return d2;
        }
        return null;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f618k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f617j;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f609b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f619l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.m != 0) {
            Drawable d2 = c.a.k.a.a.d(this.n.w(), this.m);
            this.m = 0;
            this.f619l = d2;
            return e(d2);
        }
        return null;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.t;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f614g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f616i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f615h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f610c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f612e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f613f;
        if (charSequence == null) {
            charSequence = this.f612e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        char g2 = g();
        if (g2 == 0) {
            return "";
        }
        Resources resources = this.n.w().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.n.w()).hasPermanentMenuKey()) {
            sb.append(resources.getString(c.a.h.f2491k));
        }
        int i2 = this.n.I() ? this.f618k : this.f616i;
        d(sb, i2, 65536, resources.getString(c.a.h.f2487g));
        d(sb, i2, 4096, resources.getString(c.a.h.f2483c));
        d(sb, i2, 2, resources.getString(c.a.h.f2482b));
        d(sb, i2, 1, resources.getString(c.a.h.f2488h));
        d(sb, i2, 4, resources.getString(c.a.h.f2490j));
        d(sb, i2, 8, resources.getString(c.a.h.f2486f));
        if (g2 == '\b') {
            sb.append(resources.getString(c.a.h.f2484d));
        } else if (g2 == '\n') {
            sb.append(resources.getString(c.a.h.f2485e));
        } else if (g2 != ' ') {
            sb.append(g2);
        } else {
            sb.append(resources.getString(c.a.h.f2489i));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence i(n.a aVar) {
        if (aVar != null && aVar.d()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        c.h.k.b bVar = this.B;
        return (bVar == null || !bVar.g()) ? (this.y & 8) == 0 : (this.y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        c.h.k.b bVar;
        if ((this.z & 8) != 0) {
            if (this.A == null && (bVar = this.B) != null) {
                this.A = bVar.d(this);
            }
            return this.A != null;
        }
        return false;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.q;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(this)) {
            g gVar = this.n;
            if (gVar.h(gVar, this)) {
                return true;
            }
            Runnable runnable = this.p;
            if (runnable != null) {
                runnable.run();
                return true;
            }
            if (this.f614g != null) {
                try {
                    this.n.w().startActivity(this.f614g);
                    return true;
                } catch (ActivityNotFoundException e2) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
                }
            }
            c.h.k.b bVar = this.B;
            return bVar != null && bVar.e();
        }
        return true;
    }

    public boolean l() {
        return (this.y & 32) == 32;
    }

    public boolean m() {
        return (this.y & 4) != 0;
    }

    public boolean n() {
        return (this.z & 1) == 1;
    }

    public boolean o() {
        return (this.z & 2) == 2;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    /* renamed from: p */
    public c.h.g.a.b setActionView(int i2) {
        Context w = this.n.w();
        setActionView(LayoutInflater.from(w).inflate(i2, (ViewGroup) new LinearLayout(w), false));
        return this;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    /* renamed from: q */
    public c.h.g.a.b setActionView(View view) {
        int i2;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i2 = this.a) > 0) {
            view.setId(i2);
        }
        this.n.K(this);
        return this;
    }

    public void r(boolean z) {
        this.D = z;
        this.n.M(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z) {
        int i2 = this.y;
        int i3 = (z ? 2 : 0) | (i2 & (-3));
        this.y = i3;
        if (i2 != i3) {
            this.n.M(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.f617j == c2) {
            return this;
        }
        this.f617j = Character.toLowerCase(c2);
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i2 = this.y;
        int i3 = (z ? 1 : 0) | (i2 & (-2));
        this.y = i3;
        if (i2 != i3) {
            this.n.M(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.y & 4) != 0) {
            this.n.X(this);
        } else {
            s(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.f619l = drawable;
        this.x = true;
        this.n.M(false);
        return this;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.n.M(false);
        return this;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f614g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.f615h == c2) {
            return this;
        }
        this.f615h = c2;
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f615h = c2;
        this.f617j = Character.toLowerCase(c3);
        this.n.M(false);
        return this;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.z = i2;
        this.n.K(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f612e = charSequence;
        this.n.M(false);
        r rVar = this.o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f613f = charSequence;
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (y(z)) {
            this.n.L(this);
        }
        return this;
    }

    public void t(boolean z) {
        this.y = (z ? 4 : 0) | (this.y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f612e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z) {
        if (z) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    /* renamed from: w */
    public c.h.g.a.b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public void x(r rVar) {
        this.o = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y(boolean z) {
        int i2 = this.y;
        int i3 = (z ? 0 : 8) | (i2 & (-9));
        this.y = i3;
        return i2 != i3;
    }

    public boolean z() {
        return this.n.C();
    }

    @Override // android.view.MenuItem
    public c.h.g.a.b setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public c.h.g.a.b setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.n.M(false);
        return this;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.f617j == c2 && this.f618k == i2) {
            return this;
        }
        this.f617j = Character.toLowerCase(c2);
        this.f618k = KeyEvent.normalizeMetaState(i2);
        this.n.M(false);
        return this;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f615h == c2 && this.f616i == i2) {
            return this;
        }
        this.f615h = c2;
        this.f616i = KeyEvent.normalizeMetaState(i2);
        this.n.M(false);
        return this;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f615h = c2;
        this.f616i = KeyEvent.normalizeMetaState(i2);
        this.f617j = Character.toLowerCase(c3);
        this.f618k = KeyEvent.normalizeMetaState(i3);
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f619l = null;
        this.m = i2;
        this.x = true;
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        return setTitle(this.n.w().getString(i2));
    }
}