package c.s;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionManager.java */
/* loaded from: classes.dex */
public class a0 {
    private static y a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadLocal<WeakReference<c.e.a<ViewGroup, ArrayList<y>>>> f3221b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    static ArrayList<ViewGroup> f3222c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransitionManager.java */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        y a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f3223b;

        /* compiled from: TransitionManager.java */
        /* renamed from: c.s.a0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0089a extends z {
            final /* synthetic */ c.e.a a;

            C0089a(c.e.a aVar) {
                this.a = aVar;
            }

            @Override // c.s.y.g
            public void c(y yVar) {
                ((ArrayList) this.a.get(a.this.f3223b)).remove(yVar);
                yVar.removeListener(this);
            }
        }

        a(y yVar, ViewGroup viewGroup) {
            this.a = yVar;
            this.f3223b = viewGroup;
        }

        private void a() {
            this.f3223b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f3223b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (a0.f3222c.remove(this.f3223b)) {
                c.e.a<ViewGroup, ArrayList<y>> c2 = a0.c();
                ArrayList<y> arrayList = c2.get(this.f3223b);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    c2.put(this.f3223b, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.a);
                this.a.addListener(new C0089a(c2));
                this.a.captureValues(this.f3223b, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((y) it.next()).resume(this.f3223b);
                    }
                }
                this.a.playTransition(this.f3223b);
                return true;
            }
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            a0.f3222c.remove(this.f3223b);
            ArrayList<y> arrayList = a0.c().get(this.f3223b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<y> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.f3223b);
                }
            }
            this.a.clearValues(true);
        }
    }

    public static void a(ViewGroup viewGroup) {
        b(viewGroup, null);
    }

    public static void b(ViewGroup viewGroup, y yVar) {
        if (f3222c.contains(viewGroup) || !c.h.k.v.S(viewGroup)) {
            return;
        }
        f3222c.add(viewGroup);
        if (yVar == null) {
            yVar = a;
        }
        y mo0clone = yVar.mo0clone();
        e(viewGroup, mo0clone);
        u.c(viewGroup, null);
        d(viewGroup, mo0clone);
    }

    static c.e.a<ViewGroup, ArrayList<y>> c() {
        c.e.a<ViewGroup, ArrayList<y>> aVar;
        WeakReference<c.e.a<ViewGroup, ArrayList<y>>> weakReference = f3221b.get();
        if (weakReference == null || (aVar = weakReference.get()) == null) {
            c.e.a<ViewGroup, ArrayList<y>> aVar2 = new c.e.a<>();
            f3221b.set(new WeakReference<>(aVar2));
            return aVar2;
        }
        return aVar;
    }

    private static void d(ViewGroup viewGroup, y yVar) {
        if (yVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(yVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void e(ViewGroup viewGroup, y yVar) {
        ArrayList<y> arrayList = c().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<y> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().pause(viewGroup);
            }
        }
        if (yVar != null) {
            yVar.captureValues(viewGroup, true);
        }
        u b2 = u.b(viewGroup);
        if (b2 != null) {
            b2.a();
        }
    }
}