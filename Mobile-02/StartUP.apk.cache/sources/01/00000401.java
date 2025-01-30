package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import c.h.k.v;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: RecyclerViewAccessibilityDelegate.java */
/* loaded from: classes.dex */
public class q extends c.h.k.a {

    /* renamed from: d  reason: collision with root package name */
    final RecyclerView f2204d;

    /* renamed from: e  reason: collision with root package name */
    private final a f2205e;

    /* compiled from: RecyclerViewAccessibilityDelegate.java */
    /* loaded from: classes.dex */
    public static class a extends c.h.k.a {

        /* renamed from: d  reason: collision with root package name */
        final q f2206d;

        /* renamed from: e  reason: collision with root package name */
        private Map<View, c.h.k.a> f2207e = new WeakHashMap();

        public a(q qVar) {
            this.f2206d = qVar;
        }

        @Override // c.h.k.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            c.h.k.a aVar = this.f2207e.get(view);
            if (aVar != null) {
                return aVar.a(view, accessibilityEvent);
            }
            return super.a(view, accessibilityEvent);
        }

        @Override // c.h.k.a
        public c.h.k.e0.e b(View view) {
            c.h.k.a aVar = this.f2207e.get(view);
            if (aVar != null) {
                return aVar.b(view);
            }
            return super.b(view);
        }

        @Override // c.h.k.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            c.h.k.a aVar = this.f2207e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // c.h.k.a
        public void g(View view, c.h.k.e0.d dVar) {
            if (!this.f2206d.o() && this.f2206d.f2204d.getLayoutManager() != null) {
                this.f2206d.f2204d.getLayoutManager().U0(view, dVar);
                c.h.k.a aVar = this.f2207e.get(view);
                if (aVar != null) {
                    aVar.g(view, dVar);
                    return;
                } else {
                    super.g(view, dVar);
                    return;
                }
            }
            super.g(view, dVar);
        }

        @Override // c.h.k.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            c.h.k.a aVar = this.f2207e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // c.h.k.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            c.h.k.a aVar = this.f2207e.get(viewGroup);
            if (aVar != null) {
                return aVar.i(viewGroup, view, accessibilityEvent);
            }
            return super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // c.h.k.a
        public boolean j(View view, int i2, Bundle bundle) {
            if (!this.f2206d.o() && this.f2206d.f2204d.getLayoutManager() != null) {
                c.h.k.a aVar = this.f2207e.get(view);
                if (aVar != null) {
                    if (aVar.j(view, i2, bundle)) {
                        return true;
                    }
                } else if (super.j(view, i2, bundle)) {
                    return true;
                }
                return this.f2206d.f2204d.getLayoutManager().o1(view, i2, bundle);
            }
            return super.j(view, i2, bundle);
        }

        @Override // c.h.k.a
        public void l(View view, int i2) {
            c.h.k.a aVar = this.f2207e.get(view);
            if (aVar != null) {
                aVar.l(view, i2);
            } else {
                super.l(view, i2);
            }
        }

        @Override // c.h.k.a
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            c.h.k.a aVar = this.f2207e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c.h.k.a n(View view) {
            return this.f2207e.remove(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void o(View view) {
            c.h.k.a j2 = v.j(view);
            if (j2 == null || j2 == this) {
                return;
            }
            this.f2207e.put(view, j2);
        }
    }

    public q(RecyclerView recyclerView) {
        this.f2204d = recyclerView;
        c.h.k.a n = n();
        if (n != null && (n instanceof a)) {
            this.f2205e = (a) n;
        } else {
            this.f2205e = new a(this);
        }
    }

    @Override // c.h.k.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().Q0(accessibilityEvent);
        }
    }

    @Override // c.h.k.a
    public void g(View view, c.h.k.e0.d dVar) {
        super.g(view, dVar);
        if (o() || this.f2204d.getLayoutManager() == null) {
            return;
        }
        this.f2204d.getLayoutManager().S0(dVar);
    }

    @Override // c.h.k.a
    public boolean j(View view, int i2, Bundle bundle) {
        if (super.j(view, i2, bundle)) {
            return true;
        }
        if (o() || this.f2204d.getLayoutManager() == null) {
            return false;
        }
        return this.f2204d.getLayoutManager().m1(i2, bundle);
    }

    public c.h.k.a n() {
        return this.f2205e;
    }

    boolean o() {
        return this.f2204d.hasPendingAdapterUpdates();
    }
}