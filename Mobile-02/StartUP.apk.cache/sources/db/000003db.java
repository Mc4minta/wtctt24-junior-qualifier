package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import c.h.k.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public class g extends s {

    /* renamed from: h  reason: collision with root package name */
    private static TimeInterpolator f2117h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<RecyclerView.e0> f2118i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<RecyclerView.e0> f2119j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<j> f2120k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<i> f2121l = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.e0>> m = new ArrayList<>();
    ArrayList<ArrayList<j>> n = new ArrayList<>();
    ArrayList<ArrayList<i>> o = new ArrayList<>();
    ArrayList<RecyclerView.e0> p = new ArrayList<>();
    ArrayList<RecyclerView.e0> q = new ArrayList<>();
    ArrayList<RecyclerView.e0> r = new ArrayList<>();
    ArrayList<RecyclerView.e0> s = new ArrayList<>();

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ ArrayList a;

        a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                g.this.S(jVar.a, jVar.f2147b, jVar.f2148c, jVar.f2149d, jVar.f2150e);
            }
            this.a.clear();
            g.this.n.remove(this.a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ ArrayList a;

        b(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                g.this.R((i) it.next());
            }
            this.a.clear();
            g.this.o.remove(this.a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    class c implements Runnable {
        final /* synthetic */ ArrayList a;

        c(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                g.this.Q((RecyclerView.e0) it.next());
            }
            this.a.clear();
            g.this.m.remove(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.e0 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2125b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2126c;

        d(RecyclerView.e0 e0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = e0Var;
            this.f2125b = viewPropertyAnimator;
            this.f2126c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2125b.setListener(null);
            this.f2126c.setAlpha(1.0f);
            g.this.G(this.a);
            g.this.r.remove(this.a);
            g.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.this.H(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.e0 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2128b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2129c;

        e(RecyclerView.e0 e0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = e0Var;
            this.f2128b = view;
            this.f2129c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2128b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2129c.setListener(null);
            g.this.A(this.a);
            g.this.p.remove(this.a);
            g.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.this.B(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.e0 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2131b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2132c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2133d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2134e;

        f(RecyclerView.e0 e0Var, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = e0Var;
            this.f2131b = i2;
            this.f2132c = view;
            this.f2133d = i3;
            this.f2134e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f2131b != 0) {
                this.f2132c.setTranslationX(0.0f);
            }
            if (this.f2133d != 0) {
                this.f2132c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2134e.setListener(null);
            g.this.E(this.a);
            g.this.q.remove(this.a);
            g.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.this.F(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: androidx.recyclerview.widget.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0040g extends AnimatorListenerAdapter {
        final /* synthetic */ i a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2136b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2137c;

        C0040g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = iVar;
            this.f2136b = viewPropertyAnimator;
            this.f2137c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2136b.setListener(null);
            this.f2137c.setAlpha(1.0f);
            this.f2137c.setTranslationX(0.0f);
            this.f2137c.setTranslationY(0.0f);
            g.this.C(this.a.a, true);
            g.this.s.remove(this.a.a);
            g.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.this.D(this.a.a, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class h extends AnimatorListenerAdapter {
        final /* synthetic */ i a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2139b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2140c;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = iVar;
            this.f2139b = viewPropertyAnimator;
            this.f2140c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2139b.setListener(null);
            this.f2140c.setAlpha(1.0f);
            this.f2140c.setTranslationX(0.0f);
            this.f2140c.setTranslationY(0.0f);
            g.this.C(this.a.f2142b, false);
            g.this.s.remove(this.a.f2142b);
            g.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.this.D(this.a.f2142b, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public static class j {
        public RecyclerView.e0 a;

        /* renamed from: b  reason: collision with root package name */
        public int f2147b;

        /* renamed from: c  reason: collision with root package name */
        public int f2148c;

        /* renamed from: d  reason: collision with root package name */
        public int f2149d;

        /* renamed from: e  reason: collision with root package name */
        public int f2150e;

        j(RecyclerView.e0 e0Var, int i2, int i3, int i4, int i5) {
            this.a = e0Var;
            this.f2147b = i2;
            this.f2148c = i3;
            this.f2149d = i4;
            this.f2150e = i5;
        }
    }

    private void T(RecyclerView.e0 e0Var) {
        View view = e0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.r.add(e0Var);
        animate.setDuration(o()).alpha(0.0f).setListener(new d(e0Var, animate, view)).start();
    }

    private void W(List<i> list, RecyclerView.e0 e0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (Y(iVar, e0Var) && iVar.a == null && iVar.f2142b == null) {
                list.remove(iVar);
            }
        }
    }

    private void X(i iVar) {
        RecyclerView.e0 e0Var = iVar.a;
        if (e0Var != null) {
            Y(iVar, e0Var);
        }
        RecyclerView.e0 e0Var2 = iVar.f2142b;
        if (e0Var2 != null) {
            Y(iVar, e0Var2);
        }
    }

    private boolean Y(i iVar, RecyclerView.e0 e0Var) {
        boolean z = false;
        if (iVar.f2142b == e0Var) {
            iVar.f2142b = null;
        } else if (iVar.a != e0Var) {
            return false;
        } else {
            iVar.a = null;
            z = true;
        }
        e0Var.itemView.setAlpha(1.0f);
        e0Var.itemView.setTranslationX(0.0f);
        e0Var.itemView.setTranslationY(0.0f);
        C(e0Var, z);
        return true;
    }

    private void Z(RecyclerView.e0 e0Var) {
        if (f2117h == null) {
            f2117h = new ValueAnimator().getInterpolator();
        }
        e0Var.itemView.animate().setInterpolator(f2117h);
        j(e0Var);
    }

    void Q(RecyclerView.e0 e0Var) {
        View view = e0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.p.add(e0Var);
        animate.alpha(1.0f).setDuration(l()).setListener(new e(e0Var, view, animate)).start();
    }

    void R(i iVar) {
        RecyclerView.e0 e0Var = iVar.a;
        View view = e0Var == null ? null : e0Var.itemView;
        RecyclerView.e0 e0Var2 = iVar.f2142b;
        View view2 = e0Var2 != null ? e0Var2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.s.add(iVar.a);
            duration.translationX(iVar.f2145e - iVar.f2143c);
            duration.translationY(iVar.f2146f - iVar.f2144d);
            duration.alpha(0.0f).setListener(new C0040g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.s.add(iVar.f2142b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    void S(RecyclerView.e0 e0Var, int i2, int i3, int i4, int i5) {
        View view = e0Var.itemView;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.q.add(e0Var);
        animate.setDuration(n()).setListener(new f(e0Var, i6, view, i7, animate)).start();
    }

    void U(List<RecyclerView.e0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    void V() {
        if (p()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.e0 e0Var, List<Object> list) {
        return !list.isEmpty() || super.g(e0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.e0 e0Var) {
        View view = e0Var.itemView;
        view.animate().cancel();
        int size = this.f2120k.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f2120k.get(size).a == e0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(e0Var);
                this.f2120k.remove(size);
            }
        }
        W(this.f2121l, e0Var);
        if (this.f2118i.remove(e0Var)) {
            view.setAlpha(1.0f);
            G(e0Var);
        }
        if (this.f2119j.remove(e0Var)) {
            view.setAlpha(1.0f);
            A(e0Var);
        }
        for (int size2 = this.o.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.o.get(size2);
            W(arrayList, e0Var);
            if (arrayList.isEmpty()) {
                this.o.remove(size2);
            }
        }
        for (int size3 = this.n.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.n.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).a == e0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    E(e0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.n.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.m.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.e0> arrayList3 = this.m.get(size5);
            if (arrayList3.remove(e0Var)) {
                view.setAlpha(1.0f);
                A(e0Var);
                if (arrayList3.isEmpty()) {
                    this.m.remove(size5);
                }
            }
        }
        this.r.remove(e0Var);
        this.p.remove(e0Var);
        this.s.remove(e0Var);
        this.q.remove(e0Var);
        V();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f2120k.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.f2120k.get(size);
            View view = jVar.a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(jVar.a);
            this.f2120k.remove(size);
        }
        for (int size2 = this.f2118i.size() - 1; size2 >= 0; size2--) {
            G(this.f2118i.get(size2));
            this.f2118i.remove(size2);
        }
        int size3 = this.f2119j.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.e0 e0Var = this.f2119j.get(size3);
            e0Var.itemView.setAlpha(1.0f);
            A(e0Var);
            this.f2119j.remove(size3);
        }
        for (int size4 = this.f2121l.size() - 1; size4 >= 0; size4--) {
            X(this.f2121l.get(size4));
        }
        this.f2121l.clear();
        if (p()) {
            for (int size5 = this.n.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.n.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    E(jVar2.a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.n.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.m.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.e0> arrayList2 = this.m.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.e0 e0Var2 = arrayList2.get(size8);
                    e0Var2.itemView.setAlpha(1.0f);
                    A(e0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.o.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.o.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    X(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.o.remove(arrayList3);
                    }
                }
            }
            U(this.r);
            U(this.q);
            U(this.p);
            U(this.s);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.f2119j.isEmpty() && this.f2121l.isEmpty() && this.f2120k.isEmpty() && this.f2118i.isEmpty() && this.q.isEmpty() && this.r.isEmpty() && this.p.isEmpty() && this.s.isEmpty() && this.n.isEmpty() && this.m.isEmpty() && this.o.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void u() {
        boolean z = !this.f2118i.isEmpty();
        boolean z2 = !this.f2120k.isEmpty();
        boolean z3 = !this.f2121l.isEmpty();
        boolean z4 = !this.f2119j.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.e0> it = this.f2118i.iterator();
            while (it.hasNext()) {
                T(it.next());
            }
            this.f2118i.clear();
            if (z2) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.f2120k);
                this.n.add(arrayList);
                this.f2120k.clear();
                a aVar = new a(arrayList);
                if (z) {
                    v.d0(arrayList.get(0).a.itemView, aVar, o());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f2121l);
                this.o.add(arrayList2);
                this.f2121l.clear();
                b bVar = new b(arrayList2);
                if (z) {
                    v.d0(arrayList2.get(0).a.itemView, bVar, o());
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.e0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f2119j);
                this.m.add(arrayList3);
                this.f2119j.clear();
                c cVar = new c(arrayList3);
                if (!z && !z2 && !z3) {
                    cVar.run();
                } else {
                    v.d0(arrayList3.get(0).itemView, cVar, (z ? o() : 0L) + Math.max(z2 ? n() : 0L, z3 ? m() : 0L));
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.s
    public boolean w(RecyclerView.e0 e0Var) {
        Z(e0Var);
        e0Var.itemView.setAlpha(0.0f);
        this.f2119j.add(e0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.s
    public boolean x(RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2, int i2, int i3, int i4, int i5) {
        if (e0Var == e0Var2) {
            return y(e0Var, i2, i3, i4, i5);
        }
        float translationX = e0Var.itemView.getTranslationX();
        float translationY = e0Var.itemView.getTranslationY();
        float alpha = e0Var.itemView.getAlpha();
        Z(e0Var);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        e0Var.itemView.setTranslationX(translationX);
        e0Var.itemView.setTranslationY(translationY);
        e0Var.itemView.setAlpha(alpha);
        if (e0Var2 != null) {
            Z(e0Var2);
            e0Var2.itemView.setTranslationX(-i6);
            e0Var2.itemView.setTranslationY(-i7);
            e0Var2.itemView.setAlpha(0.0f);
        }
        this.f2121l.add(new i(e0Var, e0Var2, i2, i3, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.s
    public boolean y(RecyclerView.e0 e0Var, int i2, int i3, int i4, int i5) {
        View view = e0Var.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) e0Var.itemView.getTranslationY());
        Z(e0Var);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            E(e0Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.f2120k.add(new j(e0Var, translationX, translationY, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.s
    public boolean z(RecyclerView.e0 e0Var) {
        Z(e0Var);
        this.f2118i.add(e0Var);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public static class i {
        public RecyclerView.e0 a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.e0 f2142b;

        /* renamed from: c  reason: collision with root package name */
        public int f2143c;

        /* renamed from: d  reason: collision with root package name */
        public int f2144d;

        /* renamed from: e  reason: collision with root package name */
        public int f2145e;

        /* renamed from: f  reason: collision with root package name */
        public int f2146f;

        private i(RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2) {
            this.a = e0Var;
            this.f2142b = e0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.f2142b + ", fromX=" + this.f2143c + ", fromY=" + this.f2144d + ", toX=" + this.f2145e + ", toY=" + this.f2146f + '}';
        }

        i(RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2, int i2, int i3, int i4, int i5) {
            this(e0Var, e0Var2);
            this.f2143c = i2;
            this.f2144d = i3;
            this.f2145e = i4;
            this.f2146f = i5;
        }
    }
}