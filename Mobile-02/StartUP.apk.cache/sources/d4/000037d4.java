package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.h.k.v;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {
    private int a;

    /* loaded from: classes2.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8284b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e.g.a.f.o.a f8285c;

        a(View view, int i2, e.g.a.f.o.a aVar) {
            this.a = view;
            this.f8284b = i2;
            this.f8285c = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.a == this.f8284b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                e.g.a.f.o.a aVar = this.f8285c;
                expandableBehavior.G((View) aVar, this.a, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.a = 0;
    }

    private boolean E(boolean z) {
        if (!z) {
            return this.a == 1;
        }
        int i2 = this.a;
        return i2 == 0 || i2 == 2;
    }

    protected e.g.a.f.o.a F(CoordinatorLayout coordinatorLayout, View view) {
        List<View> l2 = coordinatorLayout.l(view);
        int size = l2.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = l2.get(i2);
            if (e(coordinatorLayout, view, view2)) {
                return (e.g.a.f.o.a) view2;
            }
        }
        return null;
    }

    protected abstract boolean G(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        e.g.a.f.o.a aVar = (e.g.a.f.o.a) view2;
        if (E(aVar.a())) {
            this.a = aVar.a() ? 1 : 2;
            return G((View) aVar, view, aVar.a(), true);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
        e.g.a.f.o.a F;
        if (v.S(view) || (F = F(coordinatorLayout, view)) == null || !E(F.a())) {
            return false;
        }
        int i3 = F.a() ? 1 : 2;
        this.a = i3;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i3, F));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
    }
}