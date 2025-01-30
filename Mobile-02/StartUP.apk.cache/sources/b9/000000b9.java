package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a {

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f660j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f661k;

    /* renamed from: l  reason: collision with root package name */
    private View f662l;
    private View m;
    private LinearLayout n;
    private TextView p;
    private TextView q;
    private int t;
    private int u;
    private boolean v;
    private int w;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ c.a.o.b a;

        a(c.a.o.b bVar) {
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void i() {
        if (this.n == null) {
            LayoutInflater.from(getContext()).inflate(c.a.g.a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.n = linearLayout;
            this.p = (TextView) linearLayout.findViewById(c.a.f.f2463e);
            this.q = (TextView) this.n.findViewById(c.a.f.f2462d);
            if (this.t != 0) {
                this.p.setTextAppearance(getContext(), this.t);
            }
            if (this.u != 0) {
                this.q.setTextAppearance(getContext(), this.u);
            }
        }
        this.p.setText(this.f660j);
        this.q.setText(this.f661k);
        boolean z = !TextUtils.isEmpty(this.f660j);
        boolean z2 = !TextUtils.isEmpty(this.f661k);
        int i2 = 0;
        this.q.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout2 = this.n;
        if (!z && !z2) {
            i2 = 8;
        }
        linearLayout2.setVisibility(i2);
        if (this.n.getParent() == null) {
            addView(this.n);
        }
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ c.h.k.z f(int i2, long j2) {
        return super.f(i2, j2);
    }

    public void g() {
        if (this.f662l == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f661k;
    }

    public CharSequence getTitle() {
        return this.f660j;
    }

    public void h(c.a.o.b bVar) {
        View view = this.f662l;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.w, (ViewGroup) this, false);
            this.f662l = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f662l);
        }
        this.f662l.findViewById(c.a.f.f2467i).setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) bVar.e();
        c cVar = this.f740d;
        if (cVar != null) {
            cVar.A();
        }
        c cVar2 = new c(getContext());
        this.f740d = cVar2;
        cVar2.L(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        gVar.c(this.f740d, this.f738b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f740d.q(this);
        this.f739c = actionMenuView;
        c.h.k.v.m0(actionMenuView, null);
        addView(this.f739c, layoutParams);
    }

    public boolean j() {
        return this.v;
    }

    public void k() {
        removeAllViews();
        this.m = null;
        this.f739c = null;
    }

    public boolean l() {
        c cVar = this.f740d;
        if (cVar != null) {
            return cVar.M();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f740d;
        if (cVar != null) {
            cVar.D();
            this.f740d.E();
        }
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f660j);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean b2 = y0.b(this);
        int paddingRight = b2 ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.f662l;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f662l.getLayoutParams();
            int i6 = b2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = b2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int d2 = androidx.appcompat.widget.a.d(paddingRight, i6, b2);
            paddingRight = androidx.appcompat.widget.a.d(d2 + e(this.f662l, d2, paddingTop, paddingTop2, b2), i7, b2);
        }
        int i8 = paddingRight;
        LinearLayout linearLayout = this.n;
        if (linearLayout != null && this.m == null && linearLayout.getVisibility() != 8) {
            i8 += e(this.n, i8, paddingTop, paddingTop2, b2);
        }
        int i9 = i8;
        View view2 = this.m;
        if (view2 != null) {
            e(view2, i9, paddingTop, paddingTop2, b2);
        }
        int paddingLeft = b2 ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.f739c;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b2);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            if (View.MeasureSpec.getMode(i3) != 0) {
                int size = View.MeasureSpec.getSize(i2);
                int i4 = this.f741e;
                if (i4 <= 0) {
                    i4 = View.MeasureSpec.getSize(i3);
                }
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i5 = i4 - paddingTop;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
                View view = this.f662l;
                if (view != null) {
                    int c2 = c(view, paddingLeft, makeMeasureSpec, 0);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f662l.getLayoutParams();
                    paddingLeft = c2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.f739c;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = c(this.f739c, paddingLeft, makeMeasureSpec, 0);
                }
                LinearLayout linearLayout = this.n;
                if (linearLayout != null && this.m == null) {
                    if (this.v) {
                        this.n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.n.getMeasuredWidth();
                        boolean z = measuredWidth <= paddingLeft;
                        if (z) {
                            paddingLeft -= measuredWidth;
                        }
                        this.n.setVisibility(z ? 0 : 8);
                    } else {
                        paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                    }
                }
                View view2 = this.m;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int i6 = layoutParams.width;
                    int i7 = i6 != -2 ? 1073741824 : Integer.MIN_VALUE;
                    if (i6 >= 0) {
                        paddingLeft = Math.min(i6, paddingLeft);
                    }
                    int i8 = layoutParams.height;
                    int i9 = i8 == -2 ? Integer.MIN_VALUE : 1073741824;
                    if (i8 >= 0) {
                        i5 = Math.min(i8, i5);
                    }
                    this.m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i7), View.MeasureSpec.makeMeasureSpec(i5, i9));
                }
                if (this.f741e <= 0) {
                    int childCount = getChildCount();
                    int i10 = 0;
                    for (int i11 = 0; i11 < childCount; i11++) {
                        int measuredHeight = getChildAt(i11).getMeasuredHeight() + paddingTop;
                        if (measuredHeight > i10) {
                            i10 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i10);
                    return;
                }
                setMeasuredDimension(size, i4);
                return;
            }
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i2) {
        this.f741e = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.m;
        if (view2 != null) {
            removeView(view2);
        }
        this.m = view;
        if (view != null && (linearLayout = this.n) != null) {
            removeView(linearLayout);
            this.n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f661k = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f660j = charSequence;
        i();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.v) {
            requestLayout();
        }
        this.v = z;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.f2428j);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s0 v = s0.v(context, attributeSet, c.a.j.y, i2, 0);
        c.h.k.v.m0(this, v.g(c.a.j.z));
        this.t = v.n(c.a.j.D, 0);
        this.u = v.n(c.a.j.C, 0);
        this.f741e = v.m(c.a.j.B, 0);
        this.w = v.n(c.a.j.A, c.a.g.f2473d);
        v.w();
    }
}