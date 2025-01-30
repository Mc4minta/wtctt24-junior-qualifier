package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransitionImpl.java */
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransitionImpl.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f1740b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f1741c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f1742d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f1743e;

        a(int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.a = i2;
            this.f1740b = arrayList;
            this.f1741c = arrayList2;
            this.f1742d = arrayList3;
            this.f1743e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < this.a; i2++) {
                c.h.k.v.A0((View) this.f1740b.get(i2), (String) this.f1741c.get(i2));
                c.h.k.v.A0((View) this.f1742d.get(i2), (String) this.f1743e.get(i2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransitionImpl.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        final /* synthetic */ ArrayList a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f1745b;

        b(ArrayList arrayList, Map map) {
            this.a = arrayList;
            this.f1745b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) this.a.get(i2);
                String H = c.h.k.v.H(view);
                if (H != null) {
                    c.h.k.v.A0(view, x.i(this.f1745b, H));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransitionImpl.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        final /* synthetic */ ArrayList a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f1747b;

        c(ArrayList arrayList, Map map) {
            this.a = arrayList;
            this.f1747b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) this.a.get(i2);
                c.h.k.v.A0(view, (String) this.f1747b.get(c.h.k.v.H(view)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d(List<View> list, View view) {
        int size = list.size();
        if (h(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i2 = size; i2 < list.size(); i2++) {
            View view2 = list.get(i2);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (!h(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean h(List<View> list, View view, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (list.get(i3) == view) {
                return true;
            }
        }
        return false;
    }

    static String i(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (c.h.k.x.a(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    f(arrayList, viewGroup.getChildAt(i2));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    public abstract Object g(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String H = c.h.k.v.H(view);
            if (H != null) {
                map.put(H, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    j(map, viewGroup.getChildAt(i2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> o(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = arrayList.get(i2);
            arrayList2.add(c.h.k.v.H(view));
            c.h.k.v.A0(view, null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        c.h.k.s.a(viewGroup, new c(arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public void w(Fragment fragment, Object obj, androidx.core.os.c cVar, Runnable runnable) {
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(View view, ArrayList<View> arrayList, Map<String, String> map) {
        c.h.k.s.a(view, new b(arrayList, map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = arrayList.get(i2);
            String H = c.h.k.v.H(view2);
            arrayList4.add(H);
            if (H != null) {
                c.h.k.v.A0(view2, null);
                String str = map.get(H);
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i3))) {
                        c.h.k.v.A0(arrayList2.get(i3), H);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        c.h.k.s.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList<View> arrayList);
}