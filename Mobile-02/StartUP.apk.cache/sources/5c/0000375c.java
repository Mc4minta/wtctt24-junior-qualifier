package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.h.k.v;
import com.lwansbrough.RCTCamera.RCTCameraModule;

/* compiled from: HeaderBehavior.java */
/* loaded from: classes2.dex */
abstract class a<V extends View> extends c<V> {

    /* renamed from: d  reason: collision with root package name */
    private Runnable f8048d;

    /* renamed from: e  reason: collision with root package name */
    OverScroller f8049e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8050f;

    /* renamed from: g  reason: collision with root package name */
    private int f8051g;

    /* renamed from: h  reason: collision with root package name */
    private int f8052h;

    /* renamed from: i  reason: collision with root package name */
    private int f8053i;

    /* renamed from: j  reason: collision with root package name */
    private VelocityTracker f8054j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HeaderBehavior.java */
    /* renamed from: com.google.android.material.appbar.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0147a implements Runnable {
        private final CoordinatorLayout a;

        /* renamed from: b  reason: collision with root package name */
        private final V f8055b;

        RunnableC0147a(CoordinatorLayout coordinatorLayout, V v) {
            this.a = coordinatorLayout;
            this.f8055b = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f8055b == null || (overScroller = a.this.f8049e) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                a aVar = a.this;
                aVar.O(this.a, this.f8055b, aVar.f8049e.getCurrY());
                v.c0(this.f8055b, this);
                return;
            }
            a.this.M(this.a, this.f8055b);
        }
    }

    public a() {
        this.f8051g = -1;
        this.f8053i = -1;
    }

    private void H() {
        if (this.f8054j == null) {
            this.f8054j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r0 != 3) goto L15;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean C(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r11.f8053i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r12.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r11.f8053i = r0
        L12:
            int r0 = r14.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L8d
            r3 = -1
            if (r0 == r1) goto L5c
            r4 = 2
            if (r0 == r4) goto L25
            r12 = 3
            if (r0 == r12) goto L7e
            goto Lae
        L25:
            int r0 = r11.f8051g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r3) goto L2e
            return r2
        L2e:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r2 = r11.f8052h
            int r2 = r2 - r0
            boolean r3 = r11.f8050f
            if (r3 != 0) goto L49
            int r3 = java.lang.Math.abs(r2)
            int r4 = r11.f8053i
            if (r3 <= r4) goto L49
            r11.f8050f = r1
            if (r2 <= 0) goto L48
            int r2 = r2 - r4
            goto L49
        L48:
            int r2 = r2 + r4
        L49:
            r6 = r2
            boolean r2 = r11.f8050f
            if (r2 == 0) goto Lae
            r11.f8052h = r0
            int r7 = r11.J(r13)
            r8 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.N(r4, r5, r6, r7, r8)
            goto Lae
        L5c:
            android.view.VelocityTracker r0 = r11.f8054j
            if (r0 == 0) goto L7e
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f8054j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f8054j
            int r4 = r11.f8051g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.K(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.I(r6, r7, r8, r9, r10)
        L7e:
            r11.f8050f = r2
            r11.f8051g = r3
            android.view.VelocityTracker r12 = r11.f8054j
            if (r12 == 0) goto Lae
            r12.recycle()
            r12 = 0
            r11.f8054j = r12
            goto Lae
        L8d:
            float r0 = r14.getX()
            int r0 = (int) r0
            float r3 = r14.getY()
            int r3 = (int) r3
            boolean r12 = r12.v(r13, r0, r3)
            if (r12 == 0) goto Lb6
            boolean r12 = r11.G(r13)
            if (r12 == 0) goto Lb6
            r11.f8052h = r3
            int r12 = r14.getPointerId(r2)
            r11.f8051g = r12
            r11.H()
        Lae:
            android.view.VelocityTracker r12 = r11.f8054j
            if (r12 == 0) goto Lb5
            r12.addMovement(r14)
        Lb5:
            return r1
        Lb6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.a.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    abstract boolean G(V v);

    final boolean I(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, float f2) {
        Runnable runnable = this.f8048d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f8048d = null;
        }
        if (this.f8049e == null) {
            this.f8049e = new OverScroller(v.getContext());
        }
        this.f8049e.fling(0, D(), 0, Math.round(f2), 0, 0, i2, i3);
        if (this.f8049e.computeScrollOffset()) {
            RunnableC0147a runnableC0147a = new RunnableC0147a(coordinatorLayout, v);
            this.f8048d = runnableC0147a;
            v.c0(v, runnableC0147a);
            return true;
        }
        M(coordinatorLayout, v);
        return false;
    }

    abstract int J(V v);

    abstract int K(V v);

    abstract int L();

    abstract void M(CoordinatorLayout coordinatorLayout, V v);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int N(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return P(coordinatorLayout, v, L() - i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int O(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return P(coordinatorLayout, v, i2, Integer.MIN_VALUE, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    abstract int P(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4);

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        if (r0 != 3) goto L17;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean k(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.f8053i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.f8053i = r0
        L12:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r4.f8050f
            if (r0 == 0) goto L1f
            return r2
        L1f:
            int r0 = r7.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L60
            r5 = -1
            if (r0 == r2) goto L51
            if (r0 == r1) goto L2f
            r6 = 3
            if (r0 == r6) goto L51
            goto L83
        L2f:
            int r6 = r4.f8051g
            if (r6 != r5) goto L34
            goto L83
        L34:
            int r6 = r7.findPointerIndex(r6)
            if (r6 != r5) goto L3b
            goto L83
        L3b:
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.f8052h
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.f8053i
            if (r6 <= r0) goto L83
            r4.f8050f = r2
            r4.f8052h = r5
            goto L83
        L51:
            r4.f8050f = r3
            r4.f8051g = r5
            android.view.VelocityTracker r5 = r4.f8054j
            if (r5 == 0) goto L83
            r5.recycle()
            r5 = 0
            r4.f8054j = r5
            goto L83
        L60:
            r4.f8050f = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.G(r6)
            if (r2 == 0) goto L83
            boolean r5 = r5.v(r6, r0, r1)
            if (r5 == 0) goto L83
            r4.f8052h = r1
            int r5 = r7.getPointerId(r3)
            r4.f8051g = r5
            r4.H()
        L83:
            android.view.VelocityTracker r5 = r4.f8054j
            if (r5 == 0) goto L8a
            r5.addMovement(r7)
        L8a:
            boolean r5 = r4.f8050f
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.a.k(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8051g = -1;
        this.f8053i = -1;
    }
}