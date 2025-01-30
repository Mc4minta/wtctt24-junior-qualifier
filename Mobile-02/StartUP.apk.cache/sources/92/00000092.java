package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionMenuItem.java */
/* loaded from: classes.dex */
public class a implements c.h.g.a.b {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f543b;

    /* renamed from: c  reason: collision with root package name */
    private final int f544c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f545d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f546e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f547f;

    /* renamed from: g  reason: collision with root package name */
    private char f548g;

    /* renamed from: i  reason: collision with root package name */
    private char f550i;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f552k;

    /* renamed from: l  reason: collision with root package name */
    private Context f553l;
    private MenuItem.OnMenuItemClickListener m;
    private CharSequence n;
    private CharSequence o;

    /* renamed from: h  reason: collision with root package name */
    private int f549h = 4096;

    /* renamed from: j  reason: collision with root package name */
    private int f551j = 4096;
    private ColorStateList p = null;
    private PorterDuff.Mode q = null;
    private boolean r = false;
    private boolean s = false;
    private int t = 16;

    public a(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.f553l = context;
        this.a = i3;
        this.f543b = i2;
        this.f544c = i5;
        this.f545d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f552k;
        if (drawable != null) {
            if (this.r || this.s) {
                Drawable r = androidx.core.graphics.drawable.a.r(drawable);
                this.f552k = r;
                Drawable mutate = r.mutate();
                this.f552k = mutate;
                if (this.r) {
                    androidx.core.graphics.drawable.a.o(mutate, this.p);
                }
                if (this.s) {
                    androidx.core.graphics.drawable.a.p(this.f552k, this.q);
                }
            }
        }
    }

    @Override // c.h.g.a.b
    public c.h.g.a.b a(c.h.k.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // c.h.g.a.b
    public c.h.k.b b() {
        return null;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    /* renamed from: d */
    public c.h.g.a.b setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    /* renamed from: e */
    public c.h.g.a.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    /* renamed from: f */
    public c.h.g.a.b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f551j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f550i;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f543b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f552k;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.p;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f547f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f549h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f548g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f544c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f545d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f546e;
        return charSequence != null ? charSequence : this.f545d;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f550i = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.t = (z ? 1 : 0) | (this.t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.t = (z ? 2 : 0) | (this.t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.t = (z ? 16 : 0) | (this.t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f552k = drawable;
        c();
        return this;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.p = colorStateList;
        this.r = true;
        c();
        return this;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.q = mode;
        this.s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f547f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f548g = c2;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f548g = c2;
        this.f550i = Character.toLowerCase(c3);
        return this;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public void setShowAsAction(int i2) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f545d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f546e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.t = (this.t & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f550i = Character.toLowerCase(c2);
        this.f551j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public c.h.g.a.b setContentDescription(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f548g = c2;
        this.f549h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f545d = this.f553l.getResources().getString(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public c.h.g.a.b setTooltipText(CharSequence charSequence) {
        this.o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f552k = androidx.core.content.a.f(this.f553l, i2);
        c();
        return this;
    }

    @Override // c.h.g.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f548g = c2;
        this.f549h = KeyEvent.normalizeMetaState(i2);
        this.f550i = Character.toLowerCase(c3);
        this.f551j = KeyEvent.normalizeMetaState(i3);
        return this;
    }
}