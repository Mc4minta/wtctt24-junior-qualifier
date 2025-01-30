package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: LinearLayoutCompat.java */
/* loaded from: classes.dex */
public class d0 extends ViewGroup {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private int f772b;

    /* renamed from: c  reason: collision with root package name */
    private int f773c;

    /* renamed from: d  reason: collision with root package name */
    private int f774d;

    /* renamed from: e  reason: collision with root package name */
    private int f775e;

    /* renamed from: f  reason: collision with root package name */
    private int f776f;

    /* renamed from: g  reason: collision with root package name */
    private float f777g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f778h;

    /* renamed from: j  reason: collision with root package name */
    private int[] f779j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f780k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f781l;
    private int m;
    private int n;
    private int p;
    private int q;

    public d0(Context context) {
        this(context, null);
    }

    private void A(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    private void k(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View s = s(i4);
            if (s.getVisibility() != 8) {
                a aVar = (a) s.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                    int i5 = ((ViewGroup.MarginLayoutParams) aVar).width;
                    ((ViewGroup.MarginLayoutParams) aVar).width = s.getMeasuredWidth();
                    measureChildWithMargins(s, i3, 0, makeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).width = i5;
                }
            }
        }
    }

    private void l(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View s = s(i4);
            if (s.getVisibility() != 8) {
                a aVar = (a) s.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                    int i5 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    ((ViewGroup.MarginLayoutParams) aVar).height = s.getMeasuredHeight();
                    measureChildWithMargins(s, makeMeasureSpec, 0, i3, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).height = i5;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void g(Canvas canvas) {
        int right;
        int left;
        int i2;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean b2 = y0.b(this);
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View s = s(i3);
            if (s != null && s.getVisibility() != 8 && t(i3)) {
                a aVar = (a) s.getLayoutParams();
                if (b2) {
                    left2 = s.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                } else {
                    left2 = (s.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.m;
                }
                j(canvas, left2);
            }
        }
        if (t(virtualChildCount)) {
            View s2 = s(virtualChildCount - 1);
            if (s2 != null) {
                a aVar2 = (a) s2.getLayoutParams();
                if (b2) {
                    left = s2.getLeft() - ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                    i2 = this.m;
                    right = left - i2;
                } else {
                    right = s2.getRight() + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                }
            } else if (b2) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i2 = this.m;
                right = left - i2;
            }
            j(canvas, right);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i2;
        if (this.f772b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f772b;
        if (childCount > i3) {
            View childAt = getChildAt(i3);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.f772b == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i4 = this.f773c;
            if (this.f774d == 1 && (i2 = this.f775e & 112) != 48) {
                if (i2 == 16) {
                    i4 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f776f) / 2;
                } else if (i2 == 80) {
                    i4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f776f;
                }
            }
            return i4 + ((ViewGroup.MarginLayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f772b;
    }

    public Drawable getDividerDrawable() {
        return this.f781l;
    }

    public int getDividerPadding() {
        return this.q;
    }

    public int getDividerWidth() {
        return this.m;
    }

    public int getGravity() {
        return this.f775e;
    }

    public int getOrientation() {
        return this.f774d;
    }

    public int getShowDividers() {
        return this.p;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f777g;
    }

    void h(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View s = s(i2);
            if (s != null && s.getVisibility() != 8 && t(i2)) {
                i(canvas, (s.getTop() - ((ViewGroup.MarginLayoutParams) ((a) s.getLayoutParams())).topMargin) - this.n);
            }
        }
        if (t(virtualChildCount)) {
            View s2 = s(virtualChildCount - 1);
            if (s2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.n;
            } else {
                bottom = s2.getBottom() + ((ViewGroup.MarginLayoutParams) ((a) s2.getLayoutParams())).bottomMargin;
            }
            i(canvas, bottom);
        }
    }

    void i(Canvas canvas, int i2) {
        this.f781l.setBounds(getPaddingLeft() + this.q, i2, (getWidth() - getPaddingRight()) - this.q, this.n + i2);
        this.f781l.draw(canvas);
    }

    void j(Canvas canvas, int i2) {
        this.f781l.setBounds(i2, getPaddingTop() + this.q, this.m + i2, (getHeight() - getPaddingBottom()) - this.q);
        this.f781l.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m */
    public a generateDefaultLayoutParams() {
        int i2 = this.f774d;
        if (i2 == 0) {
            return new a(-2, -2);
        }
        if (i2 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: n */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: o */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f781l == null) {
            return;
        }
        if (this.f774d == 1) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f774d == 1) {
            v(i2, i3, i4, i5);
        } else {
            u(i2, i3, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f774d == 1) {
            z(i2, i3);
        } else {
            x(i2, i3);
        }
    }

    int p(View view, int i2) {
        return 0;
    }

    int q(View view) {
        return 0;
    }

    int r(View view) {
        return 0;
    }

    View s(int i2) {
        return getChildAt(i2);
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 >= 0 && i2 < getChildCount()) {
            this.f772b = i2;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f781l) {
            return;
        }
        this.f781l = drawable;
        if (drawable != null) {
            this.m = drawable.getIntrinsicWidth();
            this.n = drawable.getIntrinsicHeight();
        } else {
            this.m = 0;
            this.n = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i2) {
        this.q = i2;
    }

    public void setGravity(int i2) {
        if (this.f775e != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f775e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f775e;
        if ((8388615 & i4) != i3) {
            this.f775e = i3 | ((-8388616) & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f778h = z;
    }

    public void setOrientation(int i2) {
        if (this.f774d != i2) {
            this.f774d = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.p) {
            requestLayout();
        }
        this.p = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.f775e;
        if ((i4 & 112) != i3) {
            this.f775e = i3 | (i4 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.f777g = Math.max(0.0f, f2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(int i2) {
        if (i2 == 0) {
            return (this.p & 1) != 0;
        } else if (i2 == getChildCount()) {
            return (this.p & 4) != 0;
        } else if ((this.p & 2) != 0) {
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                if (getChildAt(i3).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void u(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.d0.u(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void v(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.f775e
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L3b
            r0 = 80
            if (r1 == r0) goto L2f
            int r0 = r17.getPaddingTop()
            goto L47
        L2f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.f776f
            int r0 = r0 - r1
            goto L47
        L3b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.f776f
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L47:
            r1 = 0
            r12 = r1
        L49:
            if (r12 >= r10) goto Lcb
            android.view.View r13 = r6.s(r12)
            r14 = 1
            if (r13 != 0) goto L59
            int r1 = r6.y(r12)
            int r0 = r0 + r1
            goto Lc7
        L59:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto Lc7
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.d0$a r5 = (androidx.appcompat.widget.d0.a) r5
            int r1 = r5.f782b
            if (r1 >= 0) goto L75
            r1 = r11
        L75:
            int r2 = c.h.k.v.y(r17)
            int r1 = c.h.k.d.b(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L8d
            r2 = 5
            if (r1 == r2) goto L88
            int r1 = r5.leftMargin
            int r1 = r1 + r7
            goto L98
        L88:
            int r1 = r8 - r4
            int r2 = r5.rightMargin
            goto L97
        L8d:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
            int r2 = r5.rightMargin
        L97:
            int r1 = r1 - r2
        L98:
            r2 = r1
            boolean r1 = r6.t(r12)
            if (r1 == 0) goto La2
            int r1 = r6.n
            int r0 = r0 + r1
        La2:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.q(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.A(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.r(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.p(r13, r12)
            int r12 = r12 + r0
            r0 = r16
            r1 = 1
            goto Lc8
        Lc7:
            r1 = r14
        Lc8:
            int r12 = r12 + r1
            goto L49
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.d0.v(int, int, int, int):void");
    }

    void w(View view, int i2, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:197:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void x(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 1294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.d0.x(int, int):void");
    }

    int y(int i2) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0325  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void z(int r34, int r35) {
        /*
            Method dump skipped, instructions count: 914
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.d0.z(int, int):void");
    }

    public d0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d0(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = true;
        this.f772b = -1;
        this.f773c = 0;
        this.f775e = 8388659;
        int[] iArr = c.a.j.b1;
        s0 v = s0.v(context, attributeSet, iArr, i2, 0);
        c.h.k.v.i0(this, context, iArr, attributeSet, v.r(), i2, 0);
        int k2 = v.k(c.a.j.d1, -1);
        if (k2 >= 0) {
            setOrientation(k2);
        }
        int k3 = v.k(c.a.j.c1, -1);
        if (k3 >= 0) {
            setGravity(k3);
        }
        boolean a2 = v.a(c.a.j.e1, true);
        if (!a2) {
            setBaselineAligned(a2);
        }
        this.f777g = v.i(c.a.j.g1, -1.0f);
        this.f772b = v.k(c.a.j.f1, -1);
        this.f778h = v.a(c.a.j.j1, false);
        setDividerDrawable(v.g(c.a.j.h1));
        this.p = v.k(c.a.j.k1, 0);
        this.q = v.f(c.a.j.i1, 0);
        v.w();
    }

    /* compiled from: LinearLayoutCompat.java */
    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public int f782b;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f782b = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.l1);
            this.a = obtainStyledAttributes.getFloat(c.a.j.n1, 0.0f);
            this.f782b = obtainStyledAttributes.getInt(c.a.j.m1, -1);
            obtainStyledAttributes.recycle();
        }

        public a(int i2, int i3) {
            super(i2, i3);
            this.f782b = -1;
            this.a = 0.0f;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f782b = -1;
        }
    }
}