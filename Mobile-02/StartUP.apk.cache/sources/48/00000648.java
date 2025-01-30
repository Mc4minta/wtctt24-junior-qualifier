package c.s;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.c;
import androidx.fragment.app.Fragment;
import c.s.y;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FragmentTransitionSupport.java */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class h extends androidx.fragment.app.x {

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    class a extends y.f {
        final /* synthetic */ Rect a;

        a(Rect rect) {
            this.a = rect;
        }

        @Override // c.s.y.f
        public Rect a(y yVar) {
            return this.a;
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    class b implements y.g {
        final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f3305b;

        b(View view, ArrayList arrayList) {
            this.a = view;
            this.f3305b = arrayList;
        }

        @Override // c.s.y.g
        public void a(y yVar) {
            yVar.removeListener(this);
            yVar.addListener(this);
        }

        @Override // c.s.y.g
        public void b(y yVar) {
        }

        @Override // c.s.y.g
        public void c(y yVar) {
            yVar.removeListener(this);
            this.a.setVisibility(8);
            int size = this.f3305b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((View) this.f3305b.get(i2)).setVisibility(0);
            }
        }

        @Override // c.s.y.g
        public void d(y yVar) {
        }

        @Override // c.s.y.g
        public void e(y yVar) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    class c extends z {
        final /* synthetic */ Object a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f3307b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f3308c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f3309d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f3310e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f3311f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.a = obj;
            this.f3307b = arrayList;
            this.f3308c = obj2;
            this.f3309d = arrayList2;
            this.f3310e = obj3;
            this.f3311f = arrayList3;
        }

        @Override // c.s.z, c.s.y.g
        public void a(y yVar) {
            Object obj = this.a;
            if (obj != null) {
                h.this.q(obj, this.f3307b, null);
            }
            Object obj2 = this.f3308c;
            if (obj2 != null) {
                h.this.q(obj2, this.f3309d, null);
            }
            Object obj3 = this.f3310e;
            if (obj3 != null) {
                h.this.q(obj3, this.f3311f, null);
            }
        }

        @Override // c.s.y.g
        public void c(y yVar) {
            yVar.removeListener(this);
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    class d implements c.a {
        final /* synthetic */ y a;

        d(y yVar) {
            this.a = yVar;
        }

        @Override // androidx.core.os.c.a
        public void a() {
            this.a.cancel();
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    class e implements y.g {
        final /* synthetic */ Runnable a;

        e(Runnable runnable) {
            this.a = runnable;
        }

        @Override // c.s.y.g
        public void a(y yVar) {
        }

        @Override // c.s.y.g
        public void b(y yVar) {
        }

        @Override // c.s.y.g
        public void c(y yVar) {
            this.a.run();
        }

        @Override // c.s.y.g
        public void d(y yVar) {
        }

        @Override // c.s.y.g
        public void e(y yVar) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    class f extends y.f {
        final /* synthetic */ Rect a;

        f(Rect rect) {
            this.a = rect;
        }

        @Override // c.s.y.f
        public Rect a(y yVar) {
            Rect rect = this.a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.a;
        }
    }

    private static boolean C(y yVar) {
        return (androidx.fragment.app.x.l(yVar.getTargetIds()) && androidx.fragment.app.x.l(yVar.getTargetNames()) && androidx.fragment.app.x.l(yVar.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.x
    public void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        c0 c0Var = (c0) obj;
        if (c0Var != null) {
            c0Var.getTargets().clear();
            c0Var.getTargets().addAll(arrayList2);
            q(c0Var, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.x
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        c0 c0Var = new c0();
        c0Var.h((y) obj);
        return c0Var;
    }

    @Override // androidx.fragment.app.x
    public void a(Object obj, View view) {
        if (obj != null) {
            ((y) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.x
    public void b(Object obj, ArrayList<View> arrayList) {
        y yVar = (y) obj;
        if (yVar == null) {
            return;
        }
        int i2 = 0;
        if (yVar instanceof c0) {
            c0 c0Var = (c0) yVar;
            int l2 = c0Var.l();
            while (i2 < l2) {
                b(c0Var.k(i2), arrayList);
                i2++;
            }
        } else if (C(yVar) || !androidx.fragment.app.x.l(yVar.getTargets())) {
        } else {
            int size = arrayList.size();
            while (i2 < size) {
                yVar.addTarget(arrayList.get(i2));
                i2++;
            }
        }
    }

    @Override // androidx.fragment.app.x
    public void c(ViewGroup viewGroup, Object obj) {
        a0.b(viewGroup, (y) obj);
    }

    @Override // androidx.fragment.app.x
    public boolean e(Object obj) {
        return obj instanceof y;
    }

    @Override // androidx.fragment.app.x
    public Object g(Object obj) {
        if (obj != null) {
            return ((y) obj).mo0clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.x
    public Object m(Object obj, Object obj2, Object obj3) {
        y yVar = (y) obj;
        y yVar2 = (y) obj2;
        y yVar3 = (y) obj3;
        if (yVar != null && yVar2 != null) {
            yVar = new c0().h(yVar).h(yVar2).u(1);
        } else if (yVar == null) {
            yVar = yVar2 != null ? yVar2 : null;
        }
        if (yVar3 != null) {
            c0 c0Var = new c0();
            if (yVar != null) {
                c0Var.h(yVar);
            }
            c0Var.h(yVar3);
            return c0Var;
        }
        return yVar;
    }

    @Override // androidx.fragment.app.x
    public Object n(Object obj, Object obj2, Object obj3) {
        c0 c0Var = new c0();
        if (obj != null) {
            c0Var.h((y) obj);
        }
        if (obj2 != null) {
            c0Var.h((y) obj2);
        }
        if (obj3 != null) {
            c0Var.h((y) obj3);
        }
        return c0Var;
    }

    @Override // androidx.fragment.app.x
    public void p(Object obj, View view) {
        if (obj != null) {
            ((y) obj).removeTarget(view);
        }
    }

    @Override // androidx.fragment.app.x
    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        y yVar = (y) obj;
        int i2 = 0;
        if (yVar instanceof c0) {
            c0 c0Var = (c0) yVar;
            int l2 = c0Var.l();
            while (i2 < l2) {
                q(c0Var.k(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!C(yVar)) {
            List<View> targets = yVar.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i2 < size) {
                    yVar.addTarget(arrayList2.get(i2));
                    i2++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    yVar.removeTarget(arrayList.get(size2));
                }
            }
        }
    }

    @Override // androidx.fragment.app.x
    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((y) obj).addListener(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.x
    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((y) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.x
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((y) obj).setEpicenterCallback(new f(rect));
        }
    }

    @Override // androidx.fragment.app.x
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((y) obj).setEpicenterCallback(new a(rect));
        }
    }

    @Override // androidx.fragment.app.x
    public void w(Fragment fragment, Object obj, androidx.core.os.c cVar, Runnable runnable) {
        y yVar = (y) obj;
        cVar.d(new d(yVar));
        yVar.addListener(new e(runnable));
    }

    @Override // androidx.fragment.app.x
    public void z(Object obj, View view, ArrayList<View> arrayList) {
        c0 c0Var = (c0) obj;
        List<View> targets = c0Var.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.fragment.app.x.d(targets, arrayList.get(i2));
        }
        targets.add(view);
        arrayList.add(view);
        b(c0Var, arrayList);
    }
}