package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.f0;
import androidx.lifecycle.i;
import androidx.navigation.k;
import androidx.navigation.p;
import androidx.navigation.s;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class NavController {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f1827b;

    /* renamed from: c  reason: collision with root package name */
    private o f1828c;

    /* renamed from: d  reason: collision with root package name */
    l f1829d;

    /* renamed from: e  reason: collision with root package name */
    private Bundle f1830e;

    /* renamed from: f  reason: collision with root package name */
    private Parcelable[] f1831f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1832g;

    /* renamed from: i  reason: collision with root package name */
    private androidx.lifecycle.o f1834i;

    /* renamed from: j  reason: collision with root package name */
    private g f1835j;

    /* renamed from: h  reason: collision with root package name */
    final Deque<e> f1833h = new ArrayDeque();

    /* renamed from: k  reason: collision with root package name */
    private t f1836k = new t();

    /* renamed from: l  reason: collision with root package name */
    private final CopyOnWriteArrayList<b> f1837l = new CopyOnWriteArrayList<>();
    private final androidx.lifecycle.n m = new androidx.lifecycle.m() { // from class: androidx.navigation.NavController.1
        @Override // androidx.lifecycle.m
        public void c(androidx.lifecycle.o oVar, i.a aVar) {
            NavController navController = NavController.this;
            if (navController.f1829d != null) {
                for (e eVar : navController.f1833h) {
                    eVar.f(aVar);
                }
            }
        }
    };
    private final androidx.activity.b n = new a(false);
    private boolean o = true;

    /* loaded from: classes.dex */
    class a extends androidx.activity.b {
        a(boolean z) {
            super(z);
        }

        @Override // androidx.activity.b
        public void b() {
            NavController.this.t();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(NavController navController, k kVar, Bundle bundle);
    }

    public NavController(Context context) {
        this.a = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.f1827b = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        t tVar = this.f1836k;
        tVar.a(new m(tVar));
        this.f1836k.a(new androidx.navigation.a(this.a));
    }

    private void E() {
        boolean z = true;
        this.n.f((!this.o || j() <= 1) ? false : false);
    }

    private boolean b() {
        while (!this.f1833h.isEmpty() && (this.f1833h.peekLast().b() instanceof l) && v(this.f1833h.peekLast().b().r(), true)) {
        }
        if (this.f1833h.isEmpty()) {
            return false;
        }
        k b2 = this.f1833h.peekLast().b();
        k kVar = null;
        if (b2 instanceof androidx.navigation.b) {
            Iterator<e> descendingIterator = this.f1833h.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                }
                k b3 = descendingIterator.next().b();
                if (!(b3 instanceof l) && !(b3 instanceof androidx.navigation.b)) {
                    kVar = b3;
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        Iterator<e> descendingIterator2 = this.f1833h.descendingIterator();
        while (descendingIterator2.hasNext()) {
            e next = descendingIterator2.next();
            i.b c2 = next.c();
            k b4 = next.b();
            if (b2 != null && b4.r() == b2.r()) {
                i.b bVar = i.b.RESUMED;
                if (c2 != bVar) {
                    hashMap.put(next, bVar);
                }
                b2 = b2.u();
            } else if (kVar != null && b4.r() == kVar.r()) {
                if (c2 == i.b.RESUMED) {
                    next.i(i.b.STARTED);
                } else {
                    i.b bVar2 = i.b.STARTED;
                    if (c2 != bVar2) {
                        hashMap.put(next, bVar2);
                    }
                }
                kVar = kVar.u();
            } else {
                next.i(i.b.CREATED);
            }
        }
        for (e eVar : this.f1833h) {
            i.b bVar3 = (i.b) hashMap.get(eVar);
            if (bVar3 != null) {
                eVar.i(bVar3);
            } else {
                eVar.j();
            }
        }
        e peekLast = this.f1833h.peekLast();
        Iterator<b> it = this.f1837l.iterator();
        while (it.hasNext()) {
            it.next().a(this, peekLast.b(), peekLast.a());
        }
        return true;
    }

    private String e(int[] iArr) {
        l lVar;
        l lVar2 = this.f1829d;
        int i2 = 0;
        while (true) {
            k kVar = null;
            if (i2 >= iArr.length) {
                return null;
            }
            int i3 = iArr[i2];
            if (i2 == 0) {
                if (this.f1829d.r() == i3) {
                    kVar = this.f1829d;
                }
            } else {
                kVar = lVar2.F(i3);
            }
            if (kVar == null) {
                return k.q(this.a, i3);
            }
            if (i2 != iArr.length - 1) {
                while (true) {
                    lVar = (l) kVar;
                    if (!(lVar.F(lVar.J()) instanceof l)) {
                        break;
                    }
                    kVar = lVar.F(lVar.J());
                }
                lVar2 = lVar;
            }
            i2++;
        }
    }

    private int j() {
        int i2 = 0;
        for (e eVar : this.f1833h) {
            if (!(eVar.b() instanceof l)) {
                i2++;
            }
        }
        return i2;
    }

    private void q(k kVar, Bundle bundle, p pVar, s.a aVar) {
        boolean z = false;
        boolean v = (pVar == null || pVar.e() == -1) ? false : v(pVar.e(), pVar.f());
        s d2 = this.f1836k.d(kVar.t());
        Bundle k2 = kVar.k(bundle);
        k navigate = d2.navigate(kVar, k2, pVar, aVar);
        if (navigate != null) {
            if (!(navigate instanceof androidx.navigation.b)) {
                while (!this.f1833h.isEmpty() && (this.f1833h.peekLast().b() instanceof androidx.navigation.b) && v(this.f1833h.peekLast().b().r(), true)) {
                }
            }
            if (this.f1833h.isEmpty()) {
                this.f1833h.add(new e(this.a, this.f1829d, k2, this.f1834i, this.f1835j));
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            l lVar = navigate;
            while (lVar != null && d(lVar.r()) == null) {
                lVar = lVar.u();
                if (lVar != null) {
                    arrayDeque.addFirst(new e(this.a, lVar, k2, this.f1834i, this.f1835j));
                }
            }
            this.f1833h.addAll(arrayDeque);
            this.f1833h.add(new e(this.a, navigate, navigate.k(k2), this.f1834i, this.f1835j));
        } else if (pVar != null && pVar.g()) {
            e peekLast = this.f1833h.peekLast();
            if (peekLast != null) {
                peekLast.g(bundle);
            }
            z = true;
        }
        E();
        if (v || navigate != null || z) {
            b();
        }
    }

    private void s(Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.f1830e;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                s d2 = this.f1836k.d(next);
                Bundle bundle3 = this.f1830e.getBundle(next);
                if (bundle3 != null) {
                    d2.onRestoreState(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f1831f;
        boolean z = false;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                f fVar = (f) parcelable;
                k d3 = d(fVar.b());
                if (d3 != null) {
                    Bundle a2 = fVar.a();
                    if (a2 != null) {
                        a2.setClassLoader(this.a.getClassLoader());
                    }
                    this.f1833h.add(new e(this.a, d3, a2, this.f1834i, this.f1835j, fVar.d(), fVar.c()));
                } else {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + k.q(this.a, fVar.b()) + " cannot be found from the current destination " + i());
                }
            }
            E();
            this.f1831f = null;
        }
        if (this.f1829d != null && this.f1833h.isEmpty()) {
            if (!this.f1832g && (activity = this.f1827b) != null && o(activity.getIntent())) {
                z = true;
            }
            if (z) {
                return;
            }
            q(this.f1829d, bundle, null, null);
            return;
        }
        b();
    }

    public void A(l lVar, Bundle bundle) {
        l lVar2 = this.f1829d;
        if (lVar2 != null) {
            v(lVar2.r(), true);
        }
        this.f1829d = lVar;
        s(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(androidx.lifecycle.o oVar) {
        this.f1834i = oVar;
        oVar.getLifecycle().a(this.m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(OnBackPressedDispatcher onBackPressedDispatcher) {
        if (this.f1834i != null) {
            this.n.d();
            onBackPressedDispatcher.a(this.f1834i, this.n);
            return;
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(f0 f0Var) {
        if (this.f1833h.isEmpty()) {
            this.f1835j = g.b(f0Var);
            return;
        }
        throw new IllegalStateException("ViewModelStore should be set before setGraph call");
    }

    public void a(b bVar) {
        if (!this.f1833h.isEmpty()) {
            e peekLast = this.f1833h.peekLast();
            bVar.a(this, peekLast.b(), peekLast.a());
        }
        this.f1837l.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z) {
        this.o = z;
        E();
    }

    k d(int i2) {
        l b2;
        l u;
        l lVar = this.f1829d;
        if (lVar == null) {
            return null;
        }
        if (lVar.r() == i2) {
            return this.f1829d;
        }
        if (this.f1833h.isEmpty()) {
            b2 = this.f1829d;
        } else {
            b2 = this.f1833h.getLast().b();
        }
        if (b2 instanceof l) {
            u = b2;
        } else {
            u = b2.u();
        }
        return u.F(i2);
    }

    public e f(int i2) {
        e eVar;
        Iterator<e> descendingIterator = this.f1833h.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                eVar = null;
                break;
            }
            eVar = descendingIterator.next();
            if (eVar.b().r() == i2) {
                break;
            }
        }
        if (eVar != null) {
            return eVar;
        }
        throw new IllegalArgumentException("No destination with ID " + i2 + " is on the NavController's back stack");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context g() {
        return this.a;
    }

    public e h() {
        if (this.f1833h.isEmpty()) {
            return null;
        }
        return this.f1833h.getLast();
    }

    public k i() {
        e h2 = h();
        if (h2 != null) {
            return h2.b();
        }
        return null;
    }

    public l k() {
        l lVar = this.f1829d;
        if (lVar != null) {
            return lVar;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    public o l() {
        if (this.f1828c == null) {
            this.f1828c = new o(this.a, this.f1836k);
        }
        return this.f1828c;
    }

    public t m() {
        return this.f1836k;
    }

    public e n() {
        Iterator<e> descendingIterator = this.f1833h.descendingIterator();
        if (descendingIterator.hasNext()) {
            descendingIterator.next();
        }
        while (descendingIterator.hasNext()) {
            e next = descendingIterator.next();
            if (!(next.b() instanceof l)) {
                return next;
            }
        }
        return null;
    }

    public boolean o(Intent intent) {
        k.a w;
        l lVar;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null;
        Bundle bundle = new Bundle();
        Bundle bundle2 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if ((intArray == null || intArray.length == 0) && intent.getData() != null && (w = this.f1829d.w(new j(intent))) != null) {
            intArray = w.n().l();
            bundle.putAll(w.q());
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String e2 = e(intArray);
        if (e2 != null) {
            Log.i("NavController", "Could not find destination " + e2 + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
        int flags = intent.getFlags();
        int i2 = 268435456 & flags;
        if (i2 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            androidx.core.app.q.m(this.a).i(intent).q();
            Activity activity = this.f1827b;
            if (activity != null) {
                activity.finish();
                this.f1827b.overridePendingTransition(0, 0);
            }
            return true;
        } else if (i2 != 0) {
            if (!this.f1833h.isEmpty()) {
                v(this.f1829d.r(), true);
            }
            int i3 = 0;
            while (i3 < intArray.length) {
                int i4 = i3 + 1;
                int i5 = intArray[i3];
                k d2 = d(i5);
                if (d2 != null) {
                    q(d2, bundle, new p.a().b(0).c(0).a(), null);
                    i3 = i4;
                } else {
                    throw new IllegalStateException("Deep Linking failed: destination " + k.q(this.a, i5) + " cannot be found from the current destination " + i());
                }
            }
            return true;
        } else {
            l lVar2 = this.f1829d;
            int i6 = 0;
            while (i6 < intArray.length) {
                int i7 = intArray[i6];
                k F = i6 == 0 ? this.f1829d : lVar2.F(i7);
                if (F != null) {
                    if (i6 != intArray.length - 1) {
                        while (true) {
                            lVar = (l) F;
                            if (!(lVar.F(lVar.J()) instanceof l)) {
                                break;
                            }
                            F = lVar.F(lVar.J());
                        }
                        lVar2 = lVar;
                    } else {
                        q(F, F.k(bundle), new p.a().g(this.f1829d.r(), true).b(0).c(0).a(), null);
                    }
                    i6++;
                } else {
                    throw new IllegalStateException("Deep Linking failed: destination " + k.q(this.a, i7) + " cannot be found in graph " + lVar2);
                }
            }
            this.f1832g = true;
            return true;
        }
    }

    public void p(int i2, Bundle bundle, p pVar, s.a aVar) {
        k b2;
        int i3;
        if (this.f1833h.isEmpty()) {
            b2 = this.f1829d;
        } else {
            b2 = this.f1833h.getLast().b();
        }
        if (b2 != null) {
            c m = b2.m(i2);
            Bundle bundle2 = null;
            if (m != null) {
                if (pVar == null) {
                    pVar = m.c();
                }
                i3 = m.b();
                Bundle a2 = m.a();
                if (a2 != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(a2);
                }
            } else {
                i3 = i2;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i3 == 0 && pVar != null && pVar.e() != -1) {
                u(pVar.e(), pVar.f());
                return;
            } else if (i3 != 0) {
                k d2 = d(i3);
                if (d2 == null) {
                    String q = k.q(this.a, i3);
                    if (m != null) {
                        throw new IllegalArgumentException("Navigation destination " + q + " referenced from action " + k.q(this.a, i2) + " cannot be found from the current destination " + b2);
                    }
                    throw new IllegalArgumentException("Navigation action/destination " + q + " cannot be found from the current destination " + b2);
                }
                q(d2, bundle2, pVar, aVar);
                return;
            } else {
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
            }
        }
        throw new IllegalStateException("no current navigation node");
    }

    public boolean r() {
        if (j() == 1) {
            k i2 = i();
            int r = i2.r();
            for (l u = i2.u(); u != null; u = u.u()) {
                if (u.J() != r) {
                    Bundle bundle = new Bundle();
                    Activity activity = this.f1827b;
                    if (activity != null && activity.getIntent() != null && this.f1827b.getIntent().getData() != null) {
                        bundle.putParcelable("android-support-nav:controller:deepLinkIntent", this.f1827b.getIntent());
                        k.a w = this.f1829d.w(new j(this.f1827b.getIntent()));
                        if (w != null) {
                            bundle.putAll(w.q());
                        }
                    }
                    new i(this).d(u.r()).c(bundle).a().q();
                    Activity activity2 = this.f1827b;
                    if (activity2 != null) {
                        activity2.finish();
                    }
                    return true;
                }
                r = u.r();
            }
            return false;
        }
        return t();
    }

    public boolean t() {
        if (this.f1833h.isEmpty()) {
            return false;
        }
        return u(i().r(), true);
    }

    public boolean u(int i2, boolean z) {
        return v(i2, z) && b();
    }

    boolean v(int i2, boolean z) {
        boolean z2;
        boolean z3 = false;
        if (this.f1833h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<e> descendingIterator = this.f1833h.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z2 = false;
                break;
            }
            k b2 = descendingIterator.next().b();
            s d2 = this.f1836k.d(b2.t());
            if (z || b2.r() != i2) {
                arrayList.add(d2);
            }
            if (b2.r() == i2) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            Log.i("NavController", "Ignoring popBackStack to destination " + k.q(this.a, i2) + " as it was not found on the current back stack");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((s) it.next()).popBackStack()) {
            e removeLast = this.f1833h.removeLast();
            removeLast.i(i.b.DESTROYED);
            g gVar = this.f1835j;
            if (gVar != null) {
                gVar.a(removeLast.f1855f);
            }
            z3 = true;
        }
        E();
        return z3;
    }

    public void w(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.a.getClassLoader());
        this.f1830e = bundle.getBundle("android-support-nav:controller:navigatorState");
        this.f1831f = bundle.getParcelableArray("android-support-nav:controller:backStack");
        this.f1832g = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
    }

    public Bundle x() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, s<? extends k>> entry : this.f1836k.e().entrySet()) {
            String key = entry.getKey();
            Bundle onSaveState = entry.getValue().onSaveState();
            if (onSaveState != null) {
                arrayList.add(key);
                bundle2.putBundle(key, onSaveState);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        }
        if (!this.f1833h.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.f1833h.size()];
            int i2 = 0;
            for (e eVar : this.f1833h) {
                parcelableArr[i2] = new f(eVar);
                i2++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (this.f1832g) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.f1832g);
        }
        return bundle;
    }

    public void y(int i2) {
        z(i2, null);
    }

    public void z(int i2, Bundle bundle) {
        A(l().c(i2), bundle);
    }
}