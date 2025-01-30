package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.h.k.d0;
import c.h.k.v;
import java.util.List;

/* compiled from: HeaderScrollingViewBehavior.java */
/* loaded from: classes2.dex */
abstract class b extends c<View> {

    /* renamed from: d  reason: collision with root package name */
    final Rect f8057d;

    /* renamed from: e  reason: collision with root package name */
    final Rect f8058e;

    /* renamed from: f  reason: collision with root package name */
    private int f8059f;

    /* renamed from: g  reason: collision with root package name */
    private int f8060g;

    public b() {
        this.f8057d = new Rect();
        this.f8058e = new Rect();
        this.f8059f = 0;
    }

    private static int M(int i2) {
        if (i2 == 0) {
            return 8388659;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.c
    public void E(CoordinatorLayout coordinatorLayout, View view, int i2) {
        View G = G(coordinatorLayout.l(view));
        if (G != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f8057d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, G.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + G.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            d0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && v.v(coordinatorLayout) && !v.v(view)) {
                rect.left += lastWindowInsets.j();
                rect.right -= lastWindowInsets.k();
            }
            Rect rect2 = this.f8058e;
            c.h.k.d.a(M(fVar.f1366c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int H = H(G);
            view.layout(rect2.left, rect2.top - H, rect2.right, rect2.bottom - H);
            this.f8059f = rect2.top - G.getBottom();
            return;
        }
        super.E(coordinatorLayout, view, i2);
        this.f8059f = 0;
    }

    abstract View G(List<View> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int H(View view) {
        if (this.f8060g == 0) {
            return 0;
        }
        float I = I(view);
        int i2 = this.f8060g;
        return c.h.h.a.b((int) (I * i2), 0, i2);
    }

    abstract float I(View view);

    public final int J() {
        return this.f8060g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int K(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int L() {
        return this.f8059f;
    }

    public final void N(int i2) {
        this.f8060g = i2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        View G;
        int i6 = view.getLayoutParams().height;
        if ((i6 == -1 || i6 == -2) && (G = G(coordinatorLayout.l(view))) != null) {
            if (v.v(G) && !v.v(view)) {
                v.r0(view, true);
                if (v.v(view)) {
                    view.requestLayout();
                    return true;
                }
            }
            int size = View.MeasureSpec.getSize(i4);
            if (size == 0) {
                size = coordinatorLayout.getHeight();
            }
            coordinatorLayout.D(view, i2, i3, View.MeasureSpec.makeMeasureSpec((size - G.getMeasuredHeight()) + K(G), i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
            return true;
        }
        return false;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8057d = new Rect();
        this.f8058e = new Rect();
        this.f8059f = 0;
    }
}