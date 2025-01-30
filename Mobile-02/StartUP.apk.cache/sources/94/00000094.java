package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseMenuWrapper.java */
/* loaded from: classes.dex */
public abstract class c {
    final Context a;

    /* renamed from: b  reason: collision with root package name */
    private c.e.g<c.h.g.a.b, MenuItem> f563b;

    /* renamed from: c  reason: collision with root package name */
    private c.e.g<c.h.g.a.c, SubMenu> f564c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (menuItem instanceof c.h.g.a.b) {
            c.h.g.a.b bVar = (c.h.g.a.b) menuItem;
            if (this.f563b == null) {
                this.f563b = new c.e.g<>();
            }
            MenuItem menuItem2 = this.f563b.get(menuItem);
            if (menuItem2 == null) {
                j jVar = new j(this.a, bVar);
                this.f563b.put(bVar, jVar);
                return jVar;
            }
            return menuItem2;
        }
        return menuItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        if (subMenu instanceof c.h.g.a.c) {
            c.h.g.a.c cVar = (c.h.g.a.c) subMenu;
            if (this.f564c == null) {
                this.f564c = new c.e.g<>();
            }
            SubMenu subMenu2 = this.f564c.get(cVar);
            if (subMenu2 == null) {
                s sVar = new s(this.a, cVar);
                this.f564c.put(cVar, sVar);
                return sVar;
            }
            return subMenu2;
        }
        return subMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        c.e.g<c.h.g.a.b, MenuItem> gVar = this.f563b;
        if (gVar != null) {
            gVar.clear();
        }
        c.e.g<c.h.g.a.c, SubMenu> gVar2 = this.f564c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i2) {
        if (this.f563b == null) {
            return;
        }
        int i3 = 0;
        while (i3 < this.f563b.size()) {
            if (this.f563b.keyAt(i3).getGroupId() == i2) {
                this.f563b.removeAt(i3);
                i3--;
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(int i2) {
        if (this.f563b == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f563b.size(); i3++) {
            if (this.f563b.keyAt(i3).getItemId() == i2) {
                this.f563b.removeAt(i3);
                return;
            }
        }
    }
}