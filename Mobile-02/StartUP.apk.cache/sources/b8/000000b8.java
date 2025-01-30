package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private View f651b;

    /* renamed from: c  reason: collision with root package name */
    private View f652c;

    /* renamed from: d  reason: collision with root package name */
    private View f653d;

    /* renamed from: e  reason: collision with root package name */
    Drawable f654e;

    /* renamed from: f  reason: collision with root package name */
    Drawable f655f;

    /* renamed from: g  reason: collision with root package name */
    Drawable f656g;

    /* renamed from: h  reason: collision with root package name */
    boolean f657h;

    /* renamed from: j  reason: collision with root package name */
    boolean f658j;

    /* renamed from: k  reason: collision with root package name */
    private int f659k;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c.h.k.v.m0(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.a);
        this.f654e = obtainStyledAttributes.getDrawable(c.a.j.f2497b);
        this.f655f = obtainStyledAttributes.getDrawable(c.a.j.f2499d);
        this.f659k = obtainStyledAttributes.getDimensionPixelSize(c.a.j.f2505j, -1);
        boolean z = true;
        if (getId() == c.a.f.H) {
            this.f657h = true;
            this.f656g = obtainStyledAttributes.getDrawable(c.a.j.f2498c);
        }
        obtainStyledAttributes.recycle();
        if (!this.f657h ? this.f654e != null || this.f655f != null : this.f656g != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f654e;
        if (drawable != null && drawable.isStateful()) {
            this.f654e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f655f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f655f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f656g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f656g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f651b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f654e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f655f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f656g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f652c = findViewById(c.a.f.a);
        this.f653d = findViewById(c.a.f.f2464f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.f651b;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            int i6 = ((FrameLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
            view.layout(i2, (measuredHeight - view.getMeasuredHeight()) - i6, i4, measuredHeight - i6);
        }
        if (this.f657h) {
            Drawable drawable2 = this.f656g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
            z2 = z3;
        } else {
            if (this.f654e != null) {
                if (this.f652c.getVisibility() == 0) {
                    this.f654e.setBounds(this.f652c.getLeft(), this.f652c.getTop(), this.f652c.getRight(), this.f652c.getBottom());
                } else {
                    View view2 = this.f653d;
                    if (view2 != null && view2.getVisibility() == 0) {
                        this.f654e.setBounds(this.f653d.getLeft(), this.f653d.getTop(), this.f653d.getRight(), this.f653d.getBottom());
                    } else {
                        this.f654e.setBounds(0, 0, 0, 0);
                    }
                }
                z3 = true;
            }
            this.f658j = z4;
            if (z4 && (drawable = this.f655f) != null) {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            z2 = z3;
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int a;
        int i4;
        if (this.f652c == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i4 = this.f659k) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f652c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        View view = this.f651b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!b(this.f652c)) {
            a = a(this.f652c);
        } else {
            a = !b(this.f653d) ? a(this.f653d) : 0;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(a + a(this.f651b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f654e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f654e);
        }
        this.f654e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f652c;
            if (view != null) {
                this.f654e.setBounds(view.getLeft(), this.f652c.getTop(), this.f652c.getRight(), this.f652c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f657h ? this.f654e != null || this.f655f != null : this.f656g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f656g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f656g);
        }
        this.f656g = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f657h && (drawable2 = this.f656g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f657h ? !(this.f654e != null || this.f655f != null) : this.f656g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f655f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f655f);
        }
        this.f655f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f658j && (drawable2 = this.f655f) != null) {
                drawable2.setBounds(this.f651b.getLeft(), this.f651b.getTop(), this.f651b.getRight(), this.f651b.getBottom());
            }
        }
        boolean z = true;
        if (!this.f657h ? this.f654e != null || this.f655f != null : this.f656g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(l0 l0Var) {
        View view = this.f651b;
        if (view != null) {
            removeView(view);
        }
        this.f651b = l0Var;
        if (l0Var != null) {
            addView(l0Var);
            ViewGroup.LayoutParams layoutParams = l0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            l0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.a = z;
        setDescendantFocusability(z ? 393216 : PKIFailureInfo.transactionIdInUse);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f654e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f655f;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f656g;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f654e && !this.f657h) || (drawable == this.f655f && this.f658j) || ((drawable == this.f656g && this.f657h) || super.verifyDrawable(drawable));
    }
}