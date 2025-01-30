package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
public class v {
    private static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    private static final x f1695b;

    /* renamed from: c  reason: collision with root package name */
    private static final x f1696c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        final /* synthetic */ g a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f1697b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ androidx.core.os.c f1698c;

        a(g gVar, Fragment fragment, androidx.core.os.c cVar) {
            this.a = gVar;
            this.f1697b = fragment;
            this.f1698c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.f1697b, this.f1698c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        final /* synthetic */ ArrayList a;

        b(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.A(this.a, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class c implements Runnable {
        final /* synthetic */ g a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f1699b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ androidx.core.os.c f1700c;

        c(g gVar, Fragment fragment, androidx.core.os.c cVar) {
            this.a = gVar;
            this.f1699b = fragment;
            this.f1700c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.f1699b, this.f1700c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class d implements Runnable {
        final /* synthetic */ Object a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f1701b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f1702c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Fragment f1703d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f1704e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f1705f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ArrayList f1706g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Object f1707h;

        d(Object obj, x xVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.a = obj;
            this.f1701b = xVar;
            this.f1702c = view;
            this.f1703d = fragment;
            this.f1704e = arrayList;
            this.f1705f = arrayList2;
            this.f1706g = arrayList3;
            this.f1707h = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.a;
            if (obj != null) {
                this.f1701b.p(obj, this.f1702c);
                this.f1705f.addAll(v.k(this.f1701b, this.a, this.f1703d, this.f1704e, this.f1702c));
            }
            if (this.f1706g != null) {
                if (this.f1707h != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f1702c);
                    this.f1701b.q(this.f1707h, this.f1706g, arrayList);
                }
                this.f1706g.clear();
                this.f1706g.add(this.f1702c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class e implements Runnable {
        final /* synthetic */ Fragment a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f1708b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f1709c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c.e.a f1710d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f1711e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ x f1712f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Rect f1713g;

        e(Fragment fragment, Fragment fragment2, boolean z, c.e.a aVar, View view, x xVar, Rect rect) {
            this.a = fragment;
            this.f1708b = fragment2;
            this.f1709c = z;
            this.f1710d = aVar;
            this.f1711e = view;
            this.f1712f = xVar;
            this.f1713g = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.f(this.a, this.f1708b, this.f1709c, this.f1710d, false);
            View view = this.f1711e;
            if (view != null) {
                this.f1712f.k(view, this.f1713g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class f implements Runnable {
        final /* synthetic */ x a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c.e.a f1714b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f1715c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h f1716d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f1717e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f1718f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Fragment f1719g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Fragment f1720h;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ boolean f1721j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ ArrayList f1722k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ Object f1723l;
        final /* synthetic */ Rect m;

        f(x xVar, c.e.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.a = xVar;
            this.f1714b = aVar;
            this.f1715c = obj;
            this.f1716d = hVar;
            this.f1717e = arrayList;
            this.f1718f = view;
            this.f1719g = fragment;
            this.f1720h = fragment2;
            this.f1721j = z;
            this.f1722k = arrayList2;
            this.f1723l = obj2;
            this.m = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.e.a<String, View> h2 = v.h(this.a, this.f1714b, this.f1715c, this.f1716d);
            if (h2 != null) {
                this.f1717e.addAll(h2.values());
                this.f1717e.add(this.f1718f);
            }
            v.f(this.f1719g, this.f1720h, this.f1721j, h2, false);
            Object obj = this.f1715c;
            if (obj != null) {
                this.a.A(obj, this.f1722k, this.f1717e);
                View s = v.s(h2, this.f1716d, this.f1723l, this.f1721j);
                if (s != null) {
                    this.a.k(s, this.m);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public interface g {
        void a(Fragment fragment, androidx.core.os.c cVar);

        void b(Fragment fragment, androidx.core.os.c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class h {
        public Fragment a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1724b;

        /* renamed from: c  reason: collision with root package name */
        public androidx.fragment.app.a f1725c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f1726d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1727e;

        /* renamed from: f  reason: collision with root package name */
        public androidx.fragment.app.a f1728f;

        h() {
        }
    }

    static {
        f1695b = Build.VERSION.SDK_INT >= 21 ? new w() : null;
        f1696c = w();
    }

    static void A(ArrayList<View> arrayList, int i2) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void B(m mVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z, g gVar) {
        if (mVar.o < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i4 = i2; i4 < i3; i4++) {
            androidx.fragment.app.a aVar = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue()) {
                e(aVar, sparseArray, z);
            } else {
                c(aVar, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(mVar.p.e());
            int size = sparseArray.size();
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = sparseArray.keyAt(i5);
                c.e.a<String, String> d2 = d(keyAt, arrayList, arrayList2, i2, i3);
                h hVar = (h) sparseArray.valueAt(i5);
                if (z) {
                    o(mVar, keyAt, hVar, view, d2, gVar);
                } else {
                    n(mVar, keyAt, hVar, view, d2, gVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean C() {
        return (f1695b == null && f1696c == null) ? false : true;
    }

    private static void a(ArrayList<View> arrayList, c.e.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View valueAt = aVar.valueAt(size);
            if (collection.contains(c.h.k.v.H(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0039, code lost:
        if (r0.mAdded != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x006f, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x008b, code lost:
        if (r0.mHidden == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x008d, code lost:
        r9 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00db A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(androidx.fragment.app.a r8, androidx.fragment.app.u.a r9, android.util.SparseArray<androidx.fragment.app.v.h> r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.v.b(androidx.fragment.app.a, androidx.fragment.app.u$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z) {
        int size = aVar.f1678c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b(aVar, aVar.f1678c.get(i2), sparseArray, false, z);
        }
    }

    private static c.e.a<String, String> d(int i2, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        c.e.a<String, String> aVar = new c.e.a<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i5);
            if (aVar2.J(i2)) {
                boolean booleanValue = arrayList2.get(i5).booleanValue();
                ArrayList<String> arrayList5 = aVar2.p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.p;
                        arrayList4 = aVar2.q;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.p;
                        arrayList3 = aVar2.q;
                        arrayList4 = arrayList6;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = arrayList4.get(i6);
                        String str2 = arrayList3.get(i6);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z) {
        if (aVar.t.q.c()) {
            for (int size = aVar.f1678c.size() - 1; size >= 0; size--) {
                b(aVar, aVar.f1678c.get(size), sparseArray, true, z);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z, c.e.a<String, View> aVar, boolean z2) {
        androidx.core.app.p enterTransitionCallback;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(aVar.keyAt(i2));
                arrayList.add(aVar.valueAt(i2));
            }
            if (z2) {
                throw null;
            }
            throw null;
        }
    }

    private static boolean g(x xVar, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!xVar.e(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    static c.e.a<String, View> h(x xVar, c.e.a<String, String> aVar, Object obj, h hVar) {
        androidx.core.app.p enterTransitionCallback;
        ArrayList<String> arrayList;
        Fragment fragment = hVar.a;
        View view = fragment.getView();
        if (!aVar.isEmpty() && obj != null && view != null) {
            c.e.a<String, View> aVar2 = new c.e.a<>();
            xVar.j(aVar2, view);
            androidx.fragment.app.a aVar3 = hVar.f1725c;
            if (hVar.f1724b) {
                enterTransitionCallback = fragment.getExitTransitionCallback();
                arrayList = aVar3.p;
            } else {
                enterTransitionCallback = fragment.getEnterTransitionCallback();
                arrayList = aVar3.q;
            }
            if (arrayList != null) {
                aVar2.retainAll(arrayList);
                aVar2.retainAll(aVar.values());
            }
            if (enterTransitionCallback == null) {
                x(aVar, aVar2);
                return aVar2;
            }
            throw null;
        }
        aVar.clear();
        return null;
    }

    private static c.e.a<String, View> i(x xVar, c.e.a<String, String> aVar, Object obj, h hVar) {
        androidx.core.app.p exitTransitionCallback;
        ArrayList<String> arrayList;
        if (!aVar.isEmpty() && obj != null) {
            Fragment fragment = hVar.f1726d;
            c.e.a<String, View> aVar2 = new c.e.a<>();
            xVar.j(aVar2, fragment.requireView());
            androidx.fragment.app.a aVar3 = hVar.f1728f;
            if (hVar.f1727e) {
                exitTransitionCallback = fragment.getEnterTransitionCallback();
                arrayList = aVar3.q;
            } else {
                exitTransitionCallback = fragment.getExitTransitionCallback();
                arrayList = aVar3.p;
            }
            if (arrayList != null) {
                aVar2.retainAll(arrayList);
            }
            if (exitTransitionCallback == null) {
                aVar.retainAll(aVar2.keySet());
                return aVar2;
            }
            throw null;
        }
        aVar.clear();
        return null;
    }

    private static x j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        x xVar = f1695b;
        if (xVar == null || !g(xVar, arrayList)) {
            x xVar2 = f1696c;
            if (xVar2 == null || !g(xVar2, arrayList)) {
                if (xVar == null && xVar2 == null) {
                    return null;
                }
                throw new IllegalArgumentException("Invalid Transition types");
            }
            return xVar2;
        }
        return xVar;
    }

    static ArrayList<View> k(x xVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj != null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            View view2 = fragment.getView();
            if (view2 != null) {
                xVar.f(arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (arrayList2.isEmpty()) {
                return arrayList2;
            }
            arrayList2.add(view);
            xVar.b(obj, arrayList2);
            return arrayList2;
        }
        return null;
    }

    private static Object l(x xVar, ViewGroup viewGroup, View view, c.e.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object t;
        c.e.a<String, String> aVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.f1726d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.f1724b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            t = null;
        } else {
            t = t(xVar, fragment, fragment2, z);
            aVar2 = aVar;
        }
        c.e.a<String, View> i2 = i(xVar, aVar2, t, hVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(i2.values());
            obj3 = t;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, i2, true);
        if (obj3 != null) {
            rect = new Rect();
            xVar.z(obj3, view, arrayList);
            z(xVar, obj3, obj2, i2, hVar.f1727e, hVar.f1728f);
            if (obj != null) {
                xVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        c.h.k.s.a(viewGroup, new f(xVar, aVar, obj3, hVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(x xVar, ViewGroup viewGroup, View view, c.e.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.f1726d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.f1724b;
        Object t = aVar.isEmpty() ? null : t(xVar, fragment, fragment2, z);
        c.e.a<String, View> i2 = i(xVar, aVar, t, hVar);
        c.e.a<String, View> h2 = h(xVar, aVar, t, hVar);
        if (aVar.isEmpty()) {
            if (i2 != null) {
                i2.clear();
            }
            if (h2 != null) {
                h2.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, i2, aVar.keySet());
            a(arrayList2, h2, aVar.values());
            obj3 = t;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, i2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            xVar.z(obj3, view, arrayList);
            z(xVar, obj3, obj2, i2, hVar.f1727e, hVar.f1728f);
            Rect rect2 = new Rect();
            View s = s(h2, hVar, obj, z);
            if (s != null) {
                xVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = s;
        } else {
            view2 = null;
            rect = null;
        }
        c.h.k.s.a(viewGroup, new e(fragment, fragment2, z, h2, view2, xVar, rect));
        return obj3;
    }

    private static void n(m mVar, int i2, h hVar, View view, c.e.a<String, String> aVar, g gVar) {
        Fragment fragment;
        Fragment fragment2;
        x j2;
        Object obj;
        ViewGroup viewGroup = mVar.q.c() ? (ViewGroup) mVar.q.b(i2) : null;
        if (viewGroup == null || (j2 = j((fragment2 = hVar.f1726d), (fragment = hVar.a))) == null) {
            return;
        }
        boolean z = hVar.f1724b;
        boolean z2 = hVar.f1727e;
        Object q = q(j2, fragment, z);
        Object r = r(j2, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object l2 = l(j2, viewGroup, view, aVar, hVar, arrayList, arrayList2, q, r);
        if (q == null && l2 == null) {
            obj = r;
            if (obj == null) {
                return;
            }
        } else {
            obj = r;
        }
        ArrayList<View> k2 = k(j2, obj, fragment2, arrayList, view);
        Object obj2 = (k2 == null || k2.isEmpty()) ? null : obj;
        j2.a(q, view);
        Object u = u(j2, q, obj2, l2, fragment, hVar.f1724b);
        if (fragment2 != null && k2 != null && (k2.size() > 0 || arrayList.size() > 0)) {
            androidx.core.os.c cVar = new androidx.core.os.c();
            gVar.b(fragment2, cVar);
            j2.w(fragment2, u, cVar, new c(gVar, fragment2, cVar));
        }
        if (u != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            j2.t(u, q, arrayList3, obj2, k2, l2, arrayList2);
            y(j2, viewGroup, fragment, view, arrayList2, q, arrayList3, obj2, k2);
            j2.x(viewGroup, arrayList2, aVar);
            j2.c(viewGroup, u);
            j2.s(viewGroup, arrayList2, aVar);
        }
    }

    private static void o(m mVar, int i2, h hVar, View view, c.e.a<String, String> aVar, g gVar) {
        Fragment fragment;
        Fragment fragment2;
        x j2;
        Object obj;
        ViewGroup viewGroup = mVar.q.c() ? (ViewGroup) mVar.q.b(i2) : null;
        if (viewGroup == null || (j2 = j((fragment2 = hVar.f1726d), (fragment = hVar.a))) == null) {
            return;
        }
        boolean z = hVar.f1724b;
        boolean z2 = hVar.f1727e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object q = q(j2, fragment, z);
        Object r = r(j2, fragment2, z2);
        Object m = m(j2, viewGroup, view, aVar, hVar, arrayList2, arrayList, q, r);
        if (q == null && m == null) {
            obj = r;
            if (obj == null) {
                return;
            }
        } else {
            obj = r;
        }
        ArrayList<View> k2 = k(j2, obj, fragment2, arrayList2, view);
        ArrayList<View> k3 = k(j2, q, fragment, arrayList, view);
        A(k3, 4);
        Object u = u(j2, q, obj, m, fragment, z);
        if (fragment2 != null && k2 != null && (k2.size() > 0 || arrayList2.size() > 0)) {
            androidx.core.os.c cVar = new androidx.core.os.c();
            gVar.b(fragment2, cVar);
            j2.w(fragment2, u, cVar, new a(gVar, fragment2, cVar));
        }
        if (u != null) {
            v(j2, obj, fragment2, k2);
            ArrayList<String> o = j2.o(arrayList);
            j2.t(u, q, k3, obj, k2, m, arrayList);
            j2.c(viewGroup, u);
            j2.y(viewGroup, arrayList2, arrayList, o, aVar);
            A(k3, 0);
            j2.A(m, arrayList2, arrayList);
        }
    }

    private static h p(h hVar, SparseArray<h> sparseArray, int i2) {
        if (hVar == null) {
            h hVar2 = new h();
            sparseArray.put(i2, hVar2);
            return hVar2;
        }
        return hVar;
    }

    private static Object q(x xVar, Fragment fragment, boolean z) {
        Object enterTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            enterTransition = fragment.getReenterTransition();
        } else {
            enterTransition = fragment.getEnterTransition();
        }
        return xVar.g(enterTransition);
    }

    private static Object r(x xVar, Fragment fragment, boolean z) {
        Object exitTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            exitTransition = fragment.getReturnTransition();
        } else {
            exitTransition = fragment.getExitTransition();
        }
        return xVar.g(exitTransition);
    }

    static View s(c.e.a<String, View> aVar, h hVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        androidx.fragment.app.a aVar2 = hVar.f1725c;
        if (obj == null || aVar == null || (arrayList = aVar2.p) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = aVar2.p.get(0);
        } else {
            str = aVar2.q.get(0);
        }
        return aVar.get(str);
    }

    private static Object t(x xVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object sharedElementEnterTransition;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
        }
        return xVar.B(xVar.g(sharedElementEnterTransition));
    }

    private static Object u(x xVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.getAllowReturnTransitionOverlap();
        } else {
            z2 = fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return xVar.n(obj2, obj, obj3);
        }
        return xVar.m(obj2, obj, obj3);
    }

    private static void v(x xVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            xVar.r(obj, fragment.getView(), arrayList);
            c.h.k.s.a(fragment.mContainer, new b(arrayList));
        }
    }

    private static x w() {
        try {
            return (x) Class.forName("c.s.h").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void x(c.e.a<String, String> aVar, c.e.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.valueAt(size))) {
                aVar.removeAt(size);
            }
        }
    }

    private static void y(x xVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        c.h.k.s.a(viewGroup, new d(obj, xVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void z(x xVar, Object obj, Object obj2, c.e.a<String, View> aVar, boolean z, androidx.fragment.app.a aVar2) {
        String str;
        ArrayList<String> arrayList = aVar2.p;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (z) {
            str = aVar2.q.get(0);
        } else {
            str = aVar2.p.get(0);
        }
        View view = aVar.get(str);
        xVar.v(obj, view);
        if (obj2 != null) {
            xVar.v(obj2, view);
        }
    }
}