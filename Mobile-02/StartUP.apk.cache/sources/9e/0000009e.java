package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import c.h.k.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.internal.http2.Settings;

/* compiled from: MenuBuilder.java */
/* loaded from: classes.dex */
public class g implements c.h.g.a.a {
    private static final int[] a = {1, 4, 5, 3, 2, 0};
    private boolean A;

    /* renamed from: b  reason: collision with root package name */
    private final Context f595b;

    /* renamed from: c  reason: collision with root package name */
    private final Resources f596c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f597d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f598e;

    /* renamed from: f  reason: collision with root package name */
    private a f599f;
    private ContextMenu.ContextMenuInfo n;
    CharSequence o;
    Drawable p;
    View q;
    private i y;
    private int m = 0;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private ArrayList<i> w = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<m>> x = new CopyOnWriteArrayList<>();
    private boolean z = false;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<i> f600g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<i> f601h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private boolean f602i = true;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<i> f603j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<i> f604k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private boolean f605l = true;

    /* compiled from: MenuBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        boolean a(g gVar, MenuItem menuItem);

        void b(g gVar);
    }

    /* compiled from: MenuBuilder.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(i iVar);
    }

    public g(Context context) {
        this.f595b = context;
        this.f596c = context.getResources();
        f0(true);
    }

    private static int D(int i2) {
        int i3 = ((-65536) & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = a;
            if (i3 < iArr.length) {
                return (i2 & Settings.DEFAULT_INITIAL_WINDOW_SIZE) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void P(int i2, boolean z) {
        if (i2 < 0 || i2 >= this.f600g.size()) {
            return;
        }
        this.f600g.remove(i2);
        if (z) {
            M(true);
        }
    }

    private void a0(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources E = E();
        if (view != null) {
            this.q = view;
            this.o = null;
            this.p = null;
        } else {
            if (i2 > 0) {
                this.o = E.getText(i2);
            } else if (charSequence != null) {
                this.o = charSequence;
            }
            if (i3 > 0) {
                this.p = androidx.core.content.a.f(w(), i3);
            } else if (drawable != null) {
                this.p = drawable;
            }
            this.q = null;
        }
        M(false);
    }

    private void f0(boolean z) {
        boolean z2 = true;
        this.f598e = (z && this.f596c.getConfiguration().keyboard != 1 && w.e(ViewConfiguration.get(this.f595b), this.f595b)) ? false : false;
    }

    private i g(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new i(this, i2, i3, i4, i5, charSequence, i6);
    }

    private void i(boolean z) {
        if (this.x.isEmpty()) {
            return;
        }
        h0();
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.x.remove(next);
            } else {
                mVar.c(z);
            }
        }
        g0();
    }

    private void j(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.x.isEmpty()) {
            return;
        }
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.x.remove(next);
            } else {
                int id = mVar.getId();
                if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                    mVar.j(parcelable);
                }
            }
        }
    }

    private void k(Bundle bundle) {
        Parcelable m;
        if (this.x.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.x.remove(next);
            } else {
                int id = mVar.getId();
                if (id > 0 && (m = mVar.m()) != null) {
                    sparseArray.put(id, m);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    private boolean l(r rVar, m mVar) {
        if (this.x.isEmpty()) {
            return false;
        }
        boolean l2 = mVar != null ? mVar.l(rVar) : false;
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar2 = next.get();
            if (mVar2 == null) {
                this.x.remove(next);
            } else if (!l2) {
                l2 = mVar2.l(rVar);
            }
        }
        return l2;
    }

    private static int p(ArrayList<i> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    public View A() {
        return this.q;
    }

    public ArrayList<i> B() {
        t();
        return this.f604k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        return this.u;
    }

    Resources E() {
        return this.f596c;
    }

    public g F() {
        return this;
    }

    public ArrayList<i> G() {
        if (this.f602i) {
            this.f601h.clear();
            int size = this.f600g.size();
            for (int i2 = 0; i2 < size; i2++) {
                i iVar = this.f600g.get(i2);
                if (iVar.isVisible()) {
                    this.f601h.add(iVar);
                }
            }
            this.f602i = false;
            this.f605l = true;
            return this.f601h;
        }
        return this.f601h;
    }

    public boolean H() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean I() {
        return this.f597d;
    }

    public boolean J() {
        return this.f598e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(i iVar) {
        this.f605l = true;
        M(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(i iVar) {
        this.f602i = true;
        M(true);
    }

    public void M(boolean z) {
        if (!this.r) {
            if (z) {
                this.f602i = true;
                this.f605l = true;
            }
            i(z);
            return;
        }
        this.s = true;
        if (z) {
            this.t = true;
        }
    }

    public boolean N(MenuItem menuItem, int i2) {
        return O(menuItem, null, i2);
    }

    public boolean O(MenuItem menuItem, m mVar, int i2) {
        i iVar = (i) menuItem;
        if (iVar == null || !iVar.isEnabled()) {
            return false;
        }
        boolean k2 = iVar.k();
        c.h.k.b b2 = iVar.b();
        boolean z = b2 != null && b2.a();
        if (iVar.j()) {
            k2 |= iVar.expandActionView();
            if (k2) {
                e(true);
            }
        } else if (iVar.hasSubMenu() || z) {
            if ((i2 & 4) == 0) {
                e(false);
            }
            if (!iVar.hasSubMenu()) {
                iVar.x(new r(w(), this, iVar));
            }
            r rVar = (r) iVar.getSubMenu();
            if (z) {
                b2.f(rVar);
            }
            k2 |= l(rVar, mVar);
            if (!k2) {
                e(true);
            }
        } else if ((i2 & 1) == 0) {
            e(true);
        }
        return k2;
    }

    public void Q(m mVar) {
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar2 = next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.x.remove(next);
            }
        }
    }

    public void R(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(v());
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).R(bundle);
            }
        }
        int i3 = bundle.getInt("android:menu:expandedactionview");
        if (i3 <= 0 || (findItem = findItem(i3)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    public void S(Bundle bundle) {
        j(bundle);
    }

    public void T(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).T(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(v(), sparseArray);
        }
    }

    public void U(Bundle bundle) {
        k(bundle);
    }

    public void V(a aVar) {
        this.f599f = aVar;
    }

    public g W(int i2) {
        this.m = i2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f600g.size();
        h0();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.f600g.get(i2);
            if (iVar.getGroupId() == groupId && iVar.m() && iVar.isCheckable()) {
                iVar.s(iVar == menuItem);
            }
        }
        g0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g Y(int i2) {
        a0(0, null, i2, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g Z(Drawable drawable) {
        a0(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int D = D(i4);
        i g2 = g(i2, i3, i4, D, charSequence, this.m);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.n;
        if (contextMenuInfo != null) {
            g2.v(contextMenuInfo);
        }
        ArrayList<i> arrayList = this.f600g;
        arrayList.add(p(arrayList, D), g2);
        M(true);
        return g2;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.f595b.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(m mVar) {
        c(mVar, this.f595b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g b0(int i2) {
        a0(i2, null, 0, null, null);
        return this;
    }

    public void c(m mVar, Context context) {
        this.x.add(new WeakReference<>(mVar));
        mVar.i(context, this);
        this.f605l = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g c0(CharSequence charSequence) {
        a0(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        i iVar = this.y;
        if (iVar != null) {
            f(iVar);
        }
        this.f600g.clear();
        M(true);
    }

    public void clearHeader() {
        this.p = null;
        this.o = null;
        this.q = null;
        M(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f599f;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g d0(View view) {
        a0(0, null, 0, null, view);
        return this;
    }

    public final void e(boolean z) {
        if (this.v) {
            return;
        }
        this.v = true;
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.x.remove(next);
            } else {
                mVar.b(this, z);
            }
        }
        this.v = false;
    }

    public void e0(boolean z) {
        this.A = z;
    }

    public boolean f(i iVar) {
        boolean z = false;
        if (!this.x.isEmpty() && this.y == iVar) {
            h0();
            Iterator<WeakReference<m>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.x.remove(next);
                } else {
                    z = mVar.e(this, iVar);
                    if (z) {
                        break;
                    }
                }
            }
            g0();
            if (z) {
                this.y = null;
            }
        }
        return z;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f600g.get(i3);
            if (iVar.getItemId() == i2) {
                return iVar;
            }
            if (iVar.hasSubMenu() && (findItem = iVar.getSubMenu().findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public void g0() {
        this.r = false;
        if (this.s) {
            this.s = false;
            M(this.t);
        }
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        return this.f600g.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(g gVar, MenuItem menuItem) {
        a aVar = this.f599f;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    public void h0() {
        if (this.r) {
            return;
        }
        this.r = true;
        this.s = false;
        this.t = false;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.A) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f600g.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return r(i2, keyEvent) != null;
    }

    public boolean m(i iVar) {
        boolean z = false;
        if (this.x.isEmpty()) {
            return false;
        }
        h0();
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.x.remove(next);
            } else {
                z = mVar.f(this, iVar);
                if (z) {
                    break;
                }
            }
        }
        g0();
        if (z) {
            this.y = iVar;
        }
        return z;
    }

    public int n(int i2) {
        return o(i2, 0);
    }

    public int o(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.f600g.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i3) {
        return N(findItem(i2), i3);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        i r = r(i2, keyEvent);
        boolean N = r != null ? N(r, i3) : false;
        if ((i3 & 2) != 0) {
            e(true);
        }
        return N;
    }

    public int q(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f600g.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    i r(int i2, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList<i> arrayList = this.w;
        arrayList.clear();
        s(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean I = I();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = arrayList.get(i3);
            if (I) {
                numericShortcut = iVar.getAlphabeticShortcut();
            } else {
                numericShortcut = iVar.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((numericShortcut == cArr[0] && (metaState & 2) == 0) || ((numericShortcut == cArr[2] && (metaState & 2) != 0) || (I && numericShortcut == '\b' && i2 == 67))) {
                return iVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        int n = n(i2);
        if (n >= 0) {
            int size = this.f600g.size() - n;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.f600g.get(n).getGroupId() != i2) {
                    break;
                }
                P(n, false);
                i3 = i4;
            }
            M(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        P(q(i2), true);
    }

    void s(List<i> list, int i2, KeyEvent keyEvent) {
        boolean I = I();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f600g.size();
            for (int i3 = 0; i3 < size; i3++) {
                i iVar = this.f600g.get(i3);
                if (iVar.hasSubMenu()) {
                    ((g) iVar.getSubMenu()).s(list, i2, keyEvent);
                }
                char alphabeticShortcut = I ? iVar.getAlphabeticShortcut() : iVar.getNumericShortcut();
                if (((modifiers & 69647) == ((I ? iVar.getAlphabeticModifiers() : iVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (I && alphabeticShortcut == '\b' && i2 == 67)) && iVar.isEnabled()) {
                        list.add(iVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        int size = this.f600g.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f600g.get(i3);
            if (iVar.getGroupId() == i2) {
                iVar.t(z2);
                iVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.z = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z) {
        int size = this.f600g.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f600g.get(i3);
            if (iVar.getGroupId() == i2) {
                iVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z) {
        int size = this.f600g.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f600g.get(i3);
            if (iVar.getGroupId() == i2 && iVar.y(z)) {
                z2 = true;
            }
        }
        if (z2) {
            M(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f597d = z;
        M(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f600g.size();
    }

    public void t() {
        ArrayList<i> G = G();
        if (this.f605l) {
            Iterator<WeakReference<m>> it = this.x.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.x.remove(next);
                } else {
                    z |= mVar.d();
                }
            }
            if (z) {
                this.f603j.clear();
                this.f604k.clear();
                int size = G.size();
                for (int i2 = 0; i2 < size; i2++) {
                    i iVar = G.get(i2);
                    if (iVar.l()) {
                        this.f603j.add(iVar);
                    } else {
                        this.f604k.add(iVar);
                    }
                }
            } else {
                this.f603j.clear();
                this.f604k.clear();
                this.f604k.addAll(G());
            }
            this.f605l = false;
        }
    }

    public ArrayList<i> u() {
        t();
        return this.f603j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String v() {
        return "android:menu:actionviewstates";
    }

    public Context w() {
        return this.f595b;
    }

    public i x() {
        return this.y;
    }

    public Drawable y() {
        return this.p;
    }

    public CharSequence z() {
        return this.o;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f596c.getString(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.f596c.getString(i2));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        i iVar = (i) a(i2, i3, i4, charSequence);
        r rVar = new r(this.f595b, this, iVar);
        iVar.x(rVar);
        return rVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f596c.getString(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.f596c.getString(i5));
    }
}