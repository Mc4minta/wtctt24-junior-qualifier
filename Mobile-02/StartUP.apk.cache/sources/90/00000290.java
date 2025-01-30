package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import c.h.k.e0.d;
import c.h.k.n;
import c.h.k.p;
import c.h.k.v;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.ArrayList;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements n, c.h.k.j {
    private static final a a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1544b = {16843130};
    private int A;
    private c B;
    private final p C;
    private final c.h.k.l D;
    private float E;
    private b F;

    /* renamed from: c  reason: collision with root package name */
    private long f1545c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f1546d;

    /* renamed from: e  reason: collision with root package name */
    private OverScroller f1547e;

    /* renamed from: f  reason: collision with root package name */
    private EdgeEffect f1548f;

    /* renamed from: g  reason: collision with root package name */
    private EdgeEffect f1549g;

    /* renamed from: h  reason: collision with root package name */
    private int f1550h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1551j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1552k;

    /* renamed from: l  reason: collision with root package name */
    private View f1553l;
    private boolean m;
    private VelocityTracker n;
    private boolean p;
    private boolean q;
    private int t;
    private int u;
    private int v;
    private int w;
    private final int[] x;
    private final int[] y;
    private int z;

    /* loaded from: classes.dex */
    static class a extends c.h.k.a {
        a() {
        }

        @Override // c.h.k.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            c.h.k.e0.f.a(accessibilityEvent, nestedScrollView.getScrollX());
            c.h.k.e0.f.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // c.h.k.a
        public void g(View view, c.h.k.e0.d dVar) {
            int scrollRange;
            super.g(view, dVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            dVar.T(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            dVar.m0(true);
            if (nestedScrollView.getScrollY() > 0) {
                dVar.b(d.a.n);
                dVar.b(d.a.y);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                dVar.b(d.a.m);
                dVar.b(d.a.A);
            }
        }

        @Override // c.h.k.a
        public boolean j(View view, int i2, Bundle bundle) {
            if (super.j(view, i2, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (nestedScrollView.isEnabled()) {
                if (i2 != 4096) {
                    if (i2 == 8192 || i2 == 16908344) {
                        int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                        if (max != nestedScrollView.getScrollY()) {
                            nestedScrollView.I(0, max, true);
                            return true;
                        }
                        return false;
                    } else if (i2 != 16908346) {
                        return false;
                    }
                }
                int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                if (min != nestedScrollView.getScrollY()) {
                    nestedScrollView.I(0, min, true);
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public int a;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public c[] newArray(int i2) {
                return new c[i2];
            }
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
        }

        c(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A() {
        VelocityTracker velocityTracker = this.n;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.n = null;
        }
    }

    private void B(boolean z) {
        if (z) {
            J(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.A = getScrollY();
        v.b0(this);
    }

    private boolean C(int i2, int i3, int i4) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = height + scrollY;
        boolean z = false;
        boolean z2 = i2 == 33;
        View l2 = l(z2, i3, i4);
        if (l2 == null) {
            l2 = this;
        }
        if (i3 < scrollY || i4 > i5) {
            h(z2 ? i3 - scrollY : i4 - i5);
            z = true;
        }
        if (l2 != findFocus()) {
            l2.requestFocus(i2);
        }
        return z;
    }

    private void D(View view) {
        view.getDrawingRect(this.f1546d);
        offsetDescendantRectToMyCoords(view, this.f1546d);
        int e2 = e(this.f1546d);
        if (e2 != 0) {
            scrollBy(0, e2);
        }
    }

    private boolean E(Rect rect, boolean z) {
        int e2 = e(rect);
        boolean z2 = e2 != 0;
        if (z2) {
            if (z) {
                scrollBy(0, e2);
            } else {
                F(0, e2);
            }
        }
        return z2;
    }

    private void G(int i2, int i3, int i4, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f1545c > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int scrollY = getScrollY();
            OverScroller overScroller = this.f1547e;
            int scrollX = getScrollX();
            overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i4);
            B(z);
        } else {
            if (!this.f1547e.isFinished()) {
                a();
            }
            scrollBy(i2, i3);
        }
        this.f1545c = AnimationUtils.currentAnimationTimeMillis();
    }

    private void a() {
        this.f1547e.abortAnimation();
        stopNestedScroll(1);
    }

    private boolean c() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
        }
        return false;
    }

    private static int d(int i2, int i3, int i4) {
        if (i3 >= i4 || i2 < 0) {
            return 0;
        }
        return i3 + i2 > i4 ? i4 - i3 : i2;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.E == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.E = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.E;
    }

    private void h(int i2) {
        if (i2 != 0) {
            if (this.q) {
                F(0, i2);
            } else {
                scrollBy(0, i2);
            }
        }
    }

    private void i() {
        this.m = false;
        A();
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.f1548f;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f1549g.onRelease();
        }
    }

    private void j() {
        if (getOverScrollMode() != 2) {
            if (this.f1548f == null) {
                Context context = getContext();
                this.f1548f = new EdgeEffect(context);
                this.f1549g = new EdgeEffect(context);
                return;
            }
            return;
        }
        this.f1548f = null;
        this.f1549g = null;
    }

    private View l(boolean z, int i2, int i3) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) focusables.get(i4);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                boolean z3 = i2 < top && bottom < i3;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3) {
                            if (!z4) {
                            }
                            view = view2;
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else {
                        if (!z4) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private boolean p(int i2, int i3) {
        if (getChildCount() > 0) {
            int scrollY = getScrollY();
            View childAt = getChildAt(0);
            return i3 >= childAt.getTop() - scrollY && i3 < childAt.getBottom() - scrollY && i2 >= childAt.getLeft() && i2 < childAt.getRight();
        }
        return false;
    }

    private void q() {
        VelocityTracker velocityTracker = this.n;
        if (velocityTracker == null) {
            this.n = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void r() {
        this.f1547e = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(PKIFailureInfo.transactionIdInUse);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.t = viewConfiguration.getScaledTouchSlop();
        this.u = viewConfiguration.getScaledMinimumFlingVelocity();
        this.v = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void s() {
        if (this.n == null) {
            this.n = VelocityTracker.obtain();
        }
    }

    private boolean t(View view) {
        return !v(view, 0, getHeight());
    }

    private static boolean u(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && u((View) parent, view2);
    }

    private boolean v(View view, int i2, int i3) {
        view.getDrawingRect(this.f1546d);
        offsetDescendantRectToMyCoords(view, this.f1546d);
        return this.f1546d.bottom + i2 >= getScrollY() && this.f1546d.top - i2 <= getScrollY() + i3;
    }

    private void w(int i2, int i3, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.D.e(0, scrollY2, 0, i2 - scrollY2, null, i3, iArr);
    }

    private void x(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.w) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f1550h = (int) motionEvent.getY(i2);
            this.w = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.n;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final void F(int i2, int i3) {
        G(i2, i3, 250, false);
    }

    void H(int i2, int i3, int i4, boolean z) {
        G(i2 - getScrollX(), i3 - getScrollY(), i4, z);
    }

    void I(int i2, int i3, boolean z) {
        H(i2, i3, 250, z);
    }

    public boolean J(int i2, int i3) {
        return this.D.q(i2, i3);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean b(int i2) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && v(findNextFocus, maxScrollAmount, getHeight())) {
            findNextFocus.getDrawingRect(this.f1546d);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1546d);
            h(e(this.f1546d));
            findNextFocus.requestFocus(i2);
        } else {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            h(maxScrollAmount);
        }
        if (findFocus != null && findFocus.isFocused() && t(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(PKIFailureInfo.unsupportedVersion);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
            return true;
        }
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f1547e.isFinished()) {
            return;
        }
        this.f1547e.computeScrollOffset();
        int currY = this.f1547e.getCurrY();
        int i2 = currY - this.A;
        this.A = currY;
        int[] iArr = this.y;
        boolean z = false;
        iArr[1] = 0;
        f(0, i2, iArr, null, 1);
        int i3 = i2 - this.y[1];
        int scrollRange = getScrollRange();
        if (i3 != 0) {
            int scrollY = getScrollY();
            y(0, i3, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i4 = i3 - scrollY2;
            int[] iArr2 = this.y;
            iArr2[1] = 0;
            g(0, scrollY2, 0, i4, this.x, 1, iArr2);
            i3 = i4 - this.y[1];
        }
        if (i3 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z = true;
            }
            if (z) {
                j();
                if (i3 < 0) {
                    if (this.f1548f.isFinished()) {
                        this.f1548f.onAbsorb((int) this.f1547e.getCurrVelocity());
                    }
                } else if (this.f1549g.isFinished()) {
                    this.f1549g.onAbsorb((int) this.f1547e.getCurrVelocity());
                }
            }
            a();
        }
        if (!this.f1547e.isFinished()) {
            v.b0(this);
        } else {
            stopNestedScroll(1);
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || k(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.D.a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.D.b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return f(i2, i3, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.D.f(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        if (this.f1548f != null) {
            int scrollY = getScrollY();
            int i2 = 0;
            if (!this.f1548f.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                int i3 = Build.VERSION.SDK_INT;
                if (i3 < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (i3 >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate(paddingLeft, min);
                this.f1548f.setSize(width, height);
                if (this.f1548f.draw(canvas)) {
                    v.b0(this);
                }
                canvas.restoreToCount(save);
            }
            if (this.f1549g.isFinished()) {
                return;
            }
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 21 || getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i2 = 0 + getPaddingLeft();
            }
            if (i4 >= 21 && getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate(i2 - width2, max);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f1549g.setSize(width2, height2);
            if (this.f1549g.draw(canvas)) {
                v.b0(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    protected int e(Rect rect) {
        int i2;
        int i3;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i5 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i4 - verticalFadingEdgeLength : i4;
        int i6 = rect.bottom;
        if (i6 > i5 && rect.top > scrollY) {
            if (rect.height() > height) {
                i3 = rect.top - scrollY;
            } else {
                i3 = rect.bottom - i5;
            }
            return Math.min(i3 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i4);
        } else if (rect.top >= scrollY || i6 >= i5) {
            return 0;
        } else {
            if (rect.height() > height) {
                i2 = 0 - (i5 - rect.bottom);
            } else {
                i2 = 0 - (scrollY - rect.top);
            }
            return Math.max(i2, -getScrollY());
        }
    }

    public boolean f(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.D.d(i2, i3, iArr, iArr2, i4);
    }

    public void g(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        this.D.e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.C.a();
    }

    int getScrollRange() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        }
        return 0;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return o(0);
    }

    @Override // android.view.View, c.h.k.k
    public boolean isNestedScrollingEnabled() {
        return this.D.m();
    }

    public boolean k(KeyEvent keyEvent) {
        this.f1546d.setEmpty();
        if (!c()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        } else if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                if (!keyEvent.isAltPressed()) {
                    return b(33);
                }
                return n(33);
            } else if (keyCode == 20) {
                if (!keyEvent.isAltPressed()) {
                    return b(130);
                }
                return n(130);
            } else if (keyCode != 62) {
                return false;
            } else {
                z(keyEvent.isShiftPressed() ? 33 : 130);
                return false;
            }
        } else {
            return false;
        }
    }

    public void m(int i2) {
        if (getChildCount() > 0) {
            this.f1547e.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, 0, 0);
            B(true);
        }
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i2, int i3) {
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public boolean n(int i2) {
        int childCount;
        boolean z = i2 == 130;
        int height = getHeight();
        Rect rect = this.f1546d;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f1546d.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f1546d;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f1546d;
        return C(i2, rect3.top, rect3.bottom);
    }

    public boolean o(int i2) {
        return this.D.l(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1552k = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.m) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.m) {
            return true;
        }
        int i2 = action & 255;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    int i3 = this.w;
                    if (i3 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i3);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i3 + " in onInterceptTouchEvent");
                        } else {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.f1550h) > this.t && (2 & getNestedScrollAxes()) == 0) {
                                this.m = true;
                                this.f1550h = y;
                                s();
                                this.n.addMovement(motionEvent);
                                this.z = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i2 != 3) {
                    if (i2 == 6) {
                        x(motionEvent);
                    }
                }
            }
            this.m = false;
            this.w = -1;
            A();
            if (this.f1547e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                v.b0(this);
            }
            stopNestedScroll(0);
        } else {
            int y2 = (int) motionEvent.getY();
            if (!p((int) motionEvent.getX(), y2)) {
                this.m = false;
                A();
            } else {
                this.f1550h = y2;
                this.w = motionEvent.getPointerId(0);
                q();
                this.n.addMovement(motionEvent);
                this.f1547e.computeScrollOffset();
                this.m = !this.f1547e.isFinished();
                J(2, 0);
            }
        }
        return this.m;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        int i6 = 0;
        this.f1551j = false;
        View view = this.f1553l;
        if (view != null && u(view, this)) {
            D(this.f1553l);
        }
        this.f1553l = null;
        if (!this.f1552k) {
            if (this.B != null) {
                scrollTo(getScrollX(), this.B.a);
                this.B = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i6 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int d2 = d(scrollY, paddingTop, i6);
            if (d2 != scrollY) {
                scrollTo(getScrollX(), d2);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1552k = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.p && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f3, true);
        m((int) f3);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // c.h.k.m
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        f(i2, i3, iArr, null, i4);
    }

    @Override // c.h.k.n
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        w(i5, i6, iArr);
    }

    @Override // c.h.k.m
    public void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        this.C.c(view, view2, i2, i3);
        J(2, i3);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        super.scrollTo(i2, i3);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        View findNextFocusFromRect;
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i2);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        }
        if (findNextFocusFromRect == null || t(findNextFocusFromRect)) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i2, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.B = cVar;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.a = getScrollY();
        return cVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        b bVar = this.F;
        if (bVar != null) {
            bVar.a(this, i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !v(findFocus, 0, i5)) {
            return;
        }
        findFocus.getDrawingRect(this.f1546d);
        offsetDescendantRectToMyCoords(findFocus, this.f1546d);
        h(e(this.f1546d));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return onStartNestedScroll(view, view2, i2, 0);
    }

    @Override // c.h.k.m
    public boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    @Override // c.h.k.m
    public void onStopNestedScroll(View view, int i2) {
        this.C.e(view, i2);
        stopNestedScroll(i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        s();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.z = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.z);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.n;
                velocityTracker.computeCurrentVelocity(RNCWebViewManager.COMMAND_CLEAR_FORM_DATA, this.v);
                int yVelocity = (int) velocityTracker.getYVelocity(this.w);
                if (Math.abs(yVelocity) >= this.u) {
                    int i2 = -yVelocity;
                    float f2 = i2;
                    if (!dispatchNestedPreFling(0.0f, f2)) {
                        dispatchNestedFling(0.0f, f2, true);
                        m(i2);
                    }
                } else if (this.f1547e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    v.b0(this);
                }
                this.w = -1;
                i();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.w);
                if (findPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.w + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i3 = this.f1550h - y;
                    if (!this.m && Math.abs(i3) > this.t) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.m = true;
                        i3 = i3 > 0 ? i3 - this.t : i3 + this.t;
                    }
                    int i4 = i3;
                    if (this.m) {
                        if (f(0, i4, this.y, this.x, 0)) {
                            i4 -= this.y[1];
                            this.z += this.x[1];
                        }
                        int i5 = i4;
                        this.f1550h = y - this.x[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (y(0, i5, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !o(0)) {
                            this.n.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.y;
                        iArr[1] = 0;
                        g(0, scrollY2, 0, i5 - scrollY2, this.x, 0, iArr);
                        int i6 = this.f1550h;
                        int[] iArr2 = this.x;
                        this.f1550h = i6 - iArr2[1];
                        this.z += iArr2[1];
                        if (z) {
                            int i7 = i5 - this.y[1];
                            j();
                            int i8 = scrollY + i7;
                            if (i8 < 0) {
                                d.a(this.f1548f, i7 / getHeight(), motionEvent.getX(findPointerIndex) / getWidth());
                                if (!this.f1549g.isFinished()) {
                                    this.f1549g.onRelease();
                                }
                            } else if (i8 > scrollRange) {
                                d.a(this.f1549g, i7 / getHeight(), 1.0f - (motionEvent.getX(findPointerIndex) / getWidth()));
                                if (!this.f1548f.isFinished()) {
                                    this.f1548f.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.f1548f;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.f1549g.isFinished())) {
                                v.b0(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.m && getChildCount() > 0 && this.f1547e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    v.b0(this);
                }
                this.w = -1;
                i();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f1550h = (int) motionEvent.getY(actionIndex);
                this.w = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                x(motionEvent);
                this.f1550h = (int) motionEvent.getY(motionEvent.findPointerIndex(this.w));
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            boolean z2 = !this.f1547e.isFinished();
            this.m = z2;
            if (z2 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f1547e.isFinished()) {
                a();
            }
            this.f1550h = (int) motionEvent.getY();
            this.w = motionEvent.getPointerId(0);
            J(2, 0);
        }
        VelocityTracker velocityTracker2 = this.n;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f1551j) {
            D(view2);
        } else {
            this.f1553l = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return E(rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            A();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f1551j = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int d2 = d(i2, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int d3 = d(i3, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (d2 == getScrollX() && d3 == getScrollY()) {
                return;
            }
            super.scrollTo(d2, d3);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.p) {
            this.p = z;
            requestLayout();
        }
    }

    @Override // android.view.View, c.h.k.k
    public void setNestedScrollingEnabled(boolean z) {
        this.D.n(z);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.F = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.q = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return J(i2, 0);
    }

    @Override // c.h.k.j
    public void stopNestedScroll(int i2) {
        this.D.s(i2);
    }

    boolean y(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        boolean z2;
        boolean z3;
        int overScrollMode = getOverScrollMode();
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = overScrollMode == 0 || (overScrollMode == 1 && z4);
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        int i10 = i4 + i2;
        int i11 = !z6 ? 0 : i8;
        int i12 = i5 + i3;
        int i13 = !z7 ? 0 : i9;
        int i14 = -i11;
        int i15 = i11 + i6;
        int i16 = -i13;
        int i17 = i13 + i7;
        if (i10 > i15) {
            i10 = i15;
            z2 = true;
        } else if (i10 < i14) {
            z2 = true;
            i10 = i14;
        } else {
            z2 = false;
        }
        if (i12 > i17) {
            i12 = i17;
            z3 = true;
        } else if (i12 < i16) {
            z3 = true;
            i12 = i16;
        } else {
            z3 = false;
        }
        if (z3 && !o(1)) {
            this.f1547e.springBack(i10, i12, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i10, i12, z2, z3);
        return z2 || z3;
    }

    public boolean z(int i2) {
        boolean z = i2 == 130;
        int height = getHeight();
        if (z) {
            this.f1546d.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f1546d;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f1546d.top = getScrollY() - height;
            Rect rect2 = this.f1546d;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f1546d;
        int i3 = rect3.top;
        int i4 = height + i3;
        rect3.bottom = i4;
        return C(i2, i3, i4);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1546d = new Rect();
        this.f1551j = true;
        this.f1552k = false;
        this.f1553l = null;
        this.m = false;
        this.q = true;
        this.w = -1;
        this.x = new int[2];
        this.y = new int[2];
        r();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1544b, i2, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.C = new p(this);
        this.D = new c.h.k.l(this);
        setNestedScrollingEnabled(true);
        v.k0(this, a);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        onNestedPreScroll(view, i2, i3, iArr, 0);
    }

    @Override // c.h.k.m
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        w(i5, i6, null);
    }

    @Override // android.view.View, c.h.k.k
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        w(i5, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        onNestedScrollAccepted(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}