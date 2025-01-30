package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.j;
import androidx.recyclerview.widget.q;
import androidx.recyclerview.widget.t;
import androidx.recyclerview.widget.u;
import c.h.k.e0.d;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements c.h.k.j {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    androidx.recyclerview.widget.q mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    g mAdapter;
    androidx.recyclerview.widget.a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private j mChildDrawingOrderCallback;
    androidx.recyclerview.widget.f mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private k mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    androidx.recyclerview.widget.j mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private s mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    l mItemAnimator;
    private l.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<n> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    o mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final x mObserver;
    private List<q> mOnChildAttachStateListeners;
    private r mOnFlingListener;
    private final ArrayList<s> mOnItemTouchListeners;
    final List<e0> mPendingAccessibilityImportanceChange;
    private y mPendingSavedState;
    boolean mPostedAnimatorRunner;
    j.b mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final v mRecycler;
    w mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private t mScrollListener;
    private List<t> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private c.h.k.l mScrollingChildHelper;
    final b0 mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final d0 mViewFlinger;
    private final u.b mViewInfoProcessCallback;
    final androidx.recyclerview.widget.u mViewInfoStore;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.mIsAttached) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.mLayoutSuppressed) {
                recyclerView2.mLayoutWasDefered = true;
            } else {
                recyclerView2.consumePendingUpdateOperations();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a0 {

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView f1989b;

        /* renamed from: c  reason: collision with root package name */
        private o f1990c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1991d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1992e;

        /* renamed from: f  reason: collision with root package name */
        private View f1993f;

        /* renamed from: h  reason: collision with root package name */
        private boolean f1995h;
        private int a = -1;

        /* renamed from: g  reason: collision with root package name */
        private final a f1994g = new a(0, 0);

        /* loaded from: classes.dex */
        public static class a {
            private int a;

            /* renamed from: b  reason: collision with root package name */
            private int f1996b;

            /* renamed from: c  reason: collision with root package name */
            private int f1997c;

            /* renamed from: d  reason: collision with root package name */
            private int f1998d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f1999e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f2000f;

            /* renamed from: g  reason: collision with root package name */
            private int f2001g;

            public a(int i2, int i3) {
                this(i2, i3, Integer.MIN_VALUE, null);
            }

            private void e() {
                if (this.f1999e != null && this.f1997c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f1997c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.f1998d >= 0;
            }

            public void b(int i2) {
                this.f1998d = i2;
            }

            void c(RecyclerView recyclerView) {
                int i2 = this.f1998d;
                if (i2 >= 0) {
                    this.f1998d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i2);
                    this.f2000f = false;
                } else if (this.f2000f) {
                    e();
                    recyclerView.mViewFlinger.f(this.a, this.f1996b, this.f1997c, this.f1999e);
                    int i3 = this.f2001g + 1;
                    this.f2001g = i3;
                    if (i3 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f2000f = false;
                } else {
                    this.f2001g = 0;
                }
            }

            public void d(int i2, int i3, int i4, Interpolator interpolator) {
                this.a = i2;
                this.f1996b = i3;
                this.f1997c = i4;
                this.f1999e = interpolator;
                this.f2000f = true;
            }

            public a(int i2, int i3, int i4, Interpolator interpolator) {
                this.f1998d = -1;
                this.f2000f = false;
                this.f2001g = 0;
                this.a = i2;
                this.f1996b = i3;
                this.f1997c = i4;
                this.f1999e = interpolator;
            }
        }

        /* loaded from: classes.dex */
        public interface b {
            PointF a(int i2);
        }

        public PointF a(int i2) {
            o e2 = e();
            if (e2 instanceof b) {
                return ((b) e2).a(i2);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i2) {
            return this.f1989b.mLayout.M(i2);
        }

        public int c() {
            return this.f1989b.mLayout.T();
        }

        public int d(View view) {
            return this.f1989b.getChildLayoutPosition(view);
        }

        public o e() {
            return this.f1990c;
        }

        public int f() {
            return this.a;
        }

        public boolean g() {
            return this.f1991d;
        }

        public boolean h() {
            return this.f1992e;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void i(PointF pointF) {
            float f2 = pointF.x;
            float f3 = pointF.y;
            float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        void j(int i2, int i3) {
            PointF a2;
            RecyclerView recyclerView = this.f1989b;
            if (this.a == -1 || recyclerView == null) {
                r();
            }
            if (this.f1991d && this.f1993f == null && this.f1990c != null && (a2 = a(this.a)) != null) {
                float f2 = a2.x;
                if (f2 != 0.0f || a2.y != 0.0f) {
                    recyclerView.scrollStep((int) Math.signum(f2), (int) Math.signum(a2.y), null);
                }
            }
            this.f1991d = false;
            View view = this.f1993f;
            if (view != null) {
                if (d(view) == this.a) {
                    o(this.f1993f, recyclerView.mState, this.f1994g);
                    this.f1994g.c(recyclerView);
                    r();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.f1993f = null;
                }
            }
            if (this.f1992e) {
                l(i2, i3, recyclerView.mState, this.f1994g);
                boolean a3 = this.f1994g.a();
                this.f1994g.c(recyclerView);
                if (a3 && this.f1992e) {
                    this.f1991d = true;
                    recyclerView.mViewFlinger.e();
                }
            }
        }

        protected void k(View view) {
            if (d(view) == f()) {
                this.f1993f = view;
            }
        }

        protected abstract void l(int i2, int i3, b0 b0Var, a aVar);

        protected abstract void m();

        protected abstract void n();

        protected abstract void o(View view, b0 b0Var, a aVar);

        public void p(int i2) {
            this.a = i2;
        }

        void q(RecyclerView recyclerView, o oVar) {
            recyclerView.mViewFlinger.g();
            if (this.f1995h) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f1989b = recyclerView;
            this.f1990c = oVar;
            int i2 = this.a;
            if (i2 != -1) {
                recyclerView.mState.a = i2;
                this.f1992e = true;
                this.f1991d = true;
                this.f1993f = b(f());
                m();
                this.f1989b.mViewFlinger.e();
                this.f1995h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void r() {
            if (this.f1992e) {
                this.f1992e = false;
                n();
                this.f1989b.mState.a = -1;
                this.f1993f = null;
                this.a = -1;
                this.f1991d = false;
                this.f1990c.l1(this);
                this.f1990c = null;
                this.f1989b = null;
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.mItemAnimator;
            if (lVar != null) {
                lVar.u();
            }
            RecyclerView.this.mPostedAnimatorRunner = false;
        }
    }

    /* loaded from: classes.dex */
    public static class b0 {

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<Object> f2002b;
        int m;
        long n;
        int o;
        int p;
        int q;
        int a = -1;

        /* renamed from: c  reason: collision with root package name */
        int f2003c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f2004d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f2005e = 1;

        /* renamed from: f  reason: collision with root package name */
        int f2006f = 0;

        /* renamed from: g  reason: collision with root package name */
        boolean f2007g = false;

        /* renamed from: h  reason: collision with root package name */
        boolean f2008h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f2009i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f2010j = false;

        /* renamed from: k  reason: collision with root package name */
        boolean f2011k = false;

        /* renamed from: l  reason: collision with root package name */
        boolean f2012l = false;

        void a(int i2) {
            if ((this.f2005e & i2) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.f2005e));
        }

        public int b() {
            return this.f2008h ? this.f2003c - this.f2004d : this.f2006f;
        }

        public int c() {
            return this.a;
        }

        public boolean d() {
            return this.a != -1;
        }

        public boolean e() {
            return this.f2008h;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f(g gVar) {
            this.f2005e = 1;
            this.f2006f = gVar.getItemCount();
            this.f2008h = false;
            this.f2009i = false;
            this.f2010j = false;
        }

        public boolean g() {
            return this.f2012l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.a + ", mData=" + this.f2002b + ", mItemCount=" + this.f2006f + ", mIsMeasuring=" + this.f2010j + ", mPreviousLayoutItemCount=" + this.f2003c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2004d + ", mStructureChanged=" + this.f2007g + ", mInPreLayout=" + this.f2008h + ", mRunSimpleAnimations=" + this.f2011k + ", mRunPredictiveAnimations=" + this.f2012l + '}';
        }
    }

    /* loaded from: classes.dex */
    static class c implements Interpolator {
        c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c0 {
    }

    /* loaded from: classes.dex */
    class d implements u.b {
        d() {
        }

        @Override // androidx.recyclerview.widget.u.b
        public void a(e0 e0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mLayout.t1(e0Var.itemView, recyclerView.mRecycler);
        }

        @Override // androidx.recyclerview.widget.u.b
        public void b(e0 e0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.animateAppearance(e0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.u.b
        public void c(e0 e0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.mRecycler.J(e0Var);
            RecyclerView.this.animateDisappearance(e0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.u.b
        public void d(e0 e0Var, l.c cVar, l.c cVar2) {
            e0Var.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mDataSetHasChangedAfterLayout) {
                if (recyclerView.mItemAnimator.b(e0Var, e0Var, cVar, cVar2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            } else if (recyclerView.mItemAnimator.d(e0Var, cVar, cVar2)) {
                RecyclerView.this.postAnimationRunner();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d0 implements Runnable {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f2013b;

        /* renamed from: c  reason: collision with root package name */
        OverScroller f2014c;

        /* renamed from: d  reason: collision with root package name */
        Interpolator f2015d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2016e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2017f;

        d0() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.f2015d = interpolator;
            this.f2016e = false;
            this.f2017f = false;
            this.f2014c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i2, int i3, int i4, int i5) {
            int i6;
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i4 * i4) + (i5 * i5));
            int sqrt2 = (int) Math.sqrt((i2 * i2) + (i3 * i3));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i7 = width / 2;
            float f2 = width;
            float f3 = i7;
            float b2 = f3 + (b(Math.min(1.0f, (sqrt2 * 1.0f) / f2)) * f3);
            if (sqrt > 0) {
                i6 = Math.round(Math.abs(b2 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i6 = (int) (((abs / f2) + 1.0f) * 300.0f);
            }
            return Math.min(i6, (int) RecyclerView.MAX_SCROLL_DURATION);
        }

        private float b(float f2) {
            return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
        }

        private void d() {
            RecyclerView.this.removeCallbacks(this);
            c.h.k.v.c0(RecyclerView.this, this);
        }

        public void c(int i2, int i3) {
            RecyclerView.this.setScrollState(2);
            this.f2013b = 0;
            this.a = 0;
            Interpolator interpolator = this.f2015d;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.f2015d = interpolator2;
                this.f2014c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f2014c.fling(0, 0, i2, i3, Integer.MIN_VALUE, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, Integer.MIN_VALUE, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
            e();
        }

        void e() {
            if (this.f2016e) {
                this.f2017f = true;
            } else {
                d();
            }
        }

        public void f(int i2, int i3, int i4, Interpolator interpolator) {
            if (i4 == Integer.MIN_VALUE) {
                i4 = a(i2, i3, 0, 0);
            }
            int i5 = i4;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f2015d != interpolator) {
                this.f2015d = interpolator;
                this.f2014c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f2013b = 0;
            this.a = 0;
            RecyclerView.this.setScrollState(2);
            this.f2014c.startScroll(0, 0, i2, i3, i5);
            if (Build.VERSION.SDK_INT < 23) {
                this.f2014c.computeScrollOffset();
            }
            e();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.f2014c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int i3;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                g();
                return;
            }
            this.f2017f = false;
            this.f2016e = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.f2014c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i4 = currX - this.a;
                int i5 = currY - this.f2013b;
                this.a = currX;
                this.f2013b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i4, i5, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i4 -= iArr2[0];
                    i5 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i4, i5);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i4, i5, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i3 = iArr4[0];
                    i2 = iArr4[1];
                    i4 -= i3;
                    i5 -= i2;
                    a0 a0Var = recyclerView4.mLayout.f2032g;
                    if (a0Var != null && !a0Var.g() && a0Var.h()) {
                        int b2 = RecyclerView.this.mState.b();
                        if (b2 == 0) {
                            a0Var.r();
                        } else if (a0Var.f() >= b2) {
                            a0Var.p(b2 - 1);
                            a0Var.j(i3, i2);
                        } else {
                            a0Var.j(i3, i2);
                        }
                    }
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i3, i2, i4, i5, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i6 = i4 - iArr6[0];
                int i7 = i5 - iArr6[1];
                if (i3 != 0 || i2 != 0) {
                    recyclerView6.dispatchOnScrolled(i3, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i6 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i7 != 0));
                a0 a0Var2 = RecyclerView.this.mLayout.f2032g;
                if (!(a0Var2 != null && a0Var2.g()) && z) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i8 = i6 < 0 ? -currVelocity : i6 > 0 ? currVelocity : 0;
                        if (i7 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i7 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i8, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.b();
                    }
                } else {
                    e();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.j jVar = recyclerView7.mGapWorker;
                    if (jVar != null) {
                        jVar.f(recyclerView7, i3, i2);
                    }
                }
            }
            a0 a0Var3 = RecyclerView.this.mLayout.f2032g;
            if (a0Var3 != null && a0Var3.g()) {
                a0Var3.j(0, 0);
            }
            this.f2016e = false;
            if (this.f2017f) {
                d();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements f.b {
        e() {
        }

        @Override // androidx.recyclerview.widget.f.b
        public View a(int i2) {
            return RecyclerView.this.getChildAt(i2);
        }

        @Override // androidx.recyclerview.widget.f.b
        public int b() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.f.b
        public void c(View view) {
            e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.f.b
        public void d() {
            int b2 = b();
            for (int i2 = 0; i2 < b2; i2++) {
                View a = a(i2);
                RecyclerView.this.dispatchChildDetached(a);
                a.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.f.b
        public int e(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.f.b
        public e0 f(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        @Override // androidx.recyclerview.widget.f.b
        public void g(int i2) {
            e0 childViewHolderInt;
            View a = a(i2);
            if (a != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(a)) != null) {
                if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.addFlags(256);
            }
            RecyclerView.this.detachViewFromParent(i2);
        }

        @Override // androidx.recyclerview.widget.f.b
        public void h(View view) {
            e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.f.b
        public void i(View view, int i2) {
            RecyclerView.this.addView(view, i2);
            RecyclerView.this.dispatchChildAttached(view);
        }

        @Override // androidx.recyclerview.widget.f.b
        public void j(int i2) {
            View childAt = RecyclerView.this.getChildAt(i2);
            if (childAt != null) {
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i2);
        }

        @Override // androidx.recyclerview.widget.f.b
        public void k(View view, int i2, ViewGroup.LayoutParams layoutParams) {
            e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.clearTmpDetachFlag();
            }
            RecyclerView.this.attachViewToParent(view, i2, layoutParams);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e0 {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        e0 mShadowedHolder = null;
        e0 mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        v mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public e0(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        void addFlags(int i2) {
            this.mFlags = i2 | this.mFlags;
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && c.h.k.v.O(this.itemView);
        }

        void flagRemovedAndOffsetPosition(int i2, int i3, boolean z) {
            addFlags(8);
            offsetPosition(i3, z);
            this.mPosition = i2;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i2 = this.mPreLayoutPosition;
            return i2 == -1 ? this.mPosition : i2;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i2 = this.mPreLayoutPosition;
            return i2 == -1 ? this.mPosition : i2;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) == 0) {
                List<Object> list = this.mPayloads;
                if (list != null && list.size() != 0) {
                    return this.mUnmodifiedPayloads;
                }
                return FULLUPDATE_PAYLOADS;
            }
            return FULLUPDATE_PAYLOADS;
        }

        boolean hasAnyOfTheFlags(int i2) {
            return (i2 & this.mFlags) != 0;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !c.h.k.v.O(this.itemView);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        void offsetPosition(int i2, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i2;
            }
            this.mPosition += i2;
            if (this.itemView.getLayoutParams() != null) {
                ((p) this.itemView.getLayoutParams()).f2041c = true;
            }
        }

        void onEnteredHiddenState(RecyclerView recyclerView) {
            int i2 = this.mPendingAccessibilityState;
            if (i2 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i2;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = c.h.k.v.w(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        void setFlags(int i2, int i3) {
            this.mFlags = (i2 & i3) | (this.mFlags & (~i3));
        }

        public final void setIsRecyclable(boolean z) {
            int i2 = this.mIsRecyclableCount;
            int i3 = z ? i2 - 1 : i2 + 1;
            this.mIsRecyclableCount = i3;
            if (i3 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i3 == 1) {
                this.mFlags |= 16;
            } else if (z && i3 == 0) {
                this.mFlags &= -17;
            }
        }

        void setScrapContainer(v vVar, boolean z) {
            this.mScrapContainer = vVar;
            this.mInChangeScrap = z;
        }

        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        void unScrap() {
            this.mScrapContainer.J(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements a.InterfaceC0038a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0038a
        public void a(int i2, int i3) {
            RecyclerView.this.offsetPositionRecordsForMove(i2, i3);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0038a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0038a
        public void c(int i2, int i3, Object obj) {
            RecyclerView.this.viewRangeUpdate(i2, i3, obj);
            RecyclerView.this.mItemsChanged = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0038a
        public void d(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0038a
        public e0 e(int i2) {
            e0 findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i2, true);
            if (findViewHolderForPosition == null || RecyclerView.this.mChildHelper.n(findViewHolderForPosition.itemView)) {
                return null;
            }
            return findViewHolderForPosition;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0038a
        public void f(int i2, int i3) {
            RecyclerView.this.offsetPositionRecordsForRemove(i2, i3, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0038a
        public void g(int i2, int i3) {
            RecyclerView.this.offsetPositionRecordsForInsert(i2, i3);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0038a
        public void h(int i2, int i3) {
            RecyclerView.this.offsetPositionRecordsForRemove(i2, i3, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.f2004d += i3;
        }

        void i(a.b bVar) {
            int i2 = bVar.a;
            if (i2 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.X0(recyclerView, bVar.f2089b, bVar.f2091d);
            } else if (i2 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mLayout.a1(recyclerView2, bVar.f2089b, bVar.f2091d);
            } else if (i2 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.mLayout.c1(recyclerView3, bVar.f2089b, bVar.f2091d, bVar.f2090c);
            } else if (i2 != 8) {
            } else {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.Z0(recyclerView4, bVar.f2089b, bVar.f2091d, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g<VH extends e0> {
        private final h mObservable = new h();
        private boolean mHasStableIds = false;

        public final void bindViewHolder(VH vh, int i2) {
            vh.mPosition = i2;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i2);
            }
            vh.setFlags(1, 519);
            androidx.core.os.f.a(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i2, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f2041c = true;
            }
            androidx.core.os.f.b();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i2) {
            try {
                androidx.core.os.f.a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i2);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i2;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                androidx.core.os.f.b();
            }
        }

        public abstract int getItemCount();

        public long getItemId(int i2) {
            return -1L;
        }

        public int getItemViewType(int i2) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i2) {
            this.mObservable.d(i2, 1);
        }

        public final void notifyItemInserted(int i2) {
            this.mObservable.f(i2, 1);
        }

        public final void notifyItemMoved(int i2, int i3) {
            this.mObservable.c(i2, i3);
        }

        public final void notifyItemRangeChanged(int i2, int i3) {
            this.mObservable.d(i2, i3);
        }

        public final void notifyItemRangeInserted(int i2, int i3) {
            this.mObservable.f(i2, i3);
        }

        public final void notifyItemRangeRemoved(int i2, int i3) {
            this.mObservable.g(i2, i3);
        }

        public final void notifyItemRemoved(int i2) {
            this.mObservable.g(i2, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i2);

        public void onBindViewHolder(VH vh, int i2, List<Object> list) {
            onBindViewHolder(vh, i2);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i2);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(i iVar) {
            this.mObservable.registerObserver(iVar);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(i iVar) {
            this.mObservable.unregisterObserver(iVar);
        }

        public final void notifyItemChanged(int i2, Object obj) {
            this.mObservable.e(i2, 1, obj);
        }

        public final void notifyItemRangeChanged(int i2, int i3, Object obj) {
            this.mObservable.e(i2, i3, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h extends Observable<i> {
        h() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void c(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i2, i3, 1);
            }
        }

        public void d(int i2, int i3) {
            e(i2, i3, null);
        }

        public void e(int i2, int i3, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i2, i3, obj);
            }
        }

        public void f(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i2, i3);
            }
        }

        public void g(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i2, i3);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i2, int i3) {
        }

        public void onItemRangeChanged(int i2, int i3, Object obj) {
            onItemRangeChanged(i2, i3);
        }

        public void onItemRangeInserted(int i2, int i3) {
        }

        public void onItemRangeMoved(int i2, int i3, int i4) {
        }

        public void onItemRangeRemoved(int i2, int i3) {
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        int a(int i2, int i3);
    }

    /* loaded from: classes.dex */
    public static class k {
        protected EdgeEffect a(RecyclerView recyclerView, int i2) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class l {
        private b a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<a> f2019b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private long f2020c = 120;

        /* renamed from: d  reason: collision with root package name */
        private long f2021d = 120;

        /* renamed from: e  reason: collision with root package name */
        private long f2022e = 250;

        /* renamed from: f  reason: collision with root package name */
        private long f2023f = 250;

        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface b {
            void a(e0 e0Var);
        }

        /* loaded from: classes.dex */
        public static class c {
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public int f2024b;

            /* renamed from: c  reason: collision with root package name */
            public int f2025c;

            /* renamed from: d  reason: collision with root package name */
            public int f2026d;

            public c a(e0 e0Var) {
                return b(e0Var, 0);
            }

            public c b(e0 e0Var, int i2) {
                View view = e0Var.itemView;
                this.a = view.getLeft();
                this.f2024b = view.getTop();
                this.f2025c = view.getRight();
                this.f2026d = view.getBottom();
                return this;
            }
        }

        static int e(e0 e0Var) {
            int i2 = e0Var.mFlags & 14;
            if (e0Var.isInvalid()) {
                return 4;
            }
            if ((i2 & 4) == 0) {
                int oldPosition = e0Var.getOldPosition();
                int adapterPosition = e0Var.getAdapterPosition();
                return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i2 : i2 | PKIFailureInfo.wrongIntegrity;
            }
            return i2;
        }

        public abstract boolean a(e0 e0Var, c cVar, c cVar2);

        public abstract boolean b(e0 e0Var, e0 e0Var2, c cVar, c cVar2);

        public abstract boolean c(e0 e0Var, c cVar, c cVar2);

        public abstract boolean d(e0 e0Var, c cVar, c cVar2);

        public abstract boolean f(e0 e0Var);

        public boolean g(e0 e0Var, List<Object> list) {
            return f(e0Var);
        }

        public final void h(e0 e0Var) {
            r(e0Var);
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(e0Var);
            }
        }

        public final void i() {
            int size = this.f2019b.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f2019b.get(i2).a();
            }
            this.f2019b.clear();
        }

        public abstract void j(e0 e0Var);

        public abstract void k();

        public long l() {
            return this.f2020c;
        }

        public long m() {
            return this.f2023f;
        }

        public long n() {
            return this.f2022e;
        }

        public long o() {
            return this.f2021d;
        }

        public abstract boolean p();

        public c q() {
            return new c();
        }

        public void r(e0 e0Var) {
        }

        public c s(b0 b0Var, e0 e0Var) {
            return q().a(e0Var);
        }

        public c t(b0 b0Var, e0 e0Var, int i2, List<Object> list) {
            return q().a(e0Var);
        }

        public abstract void u();

        void v(b bVar) {
            this.a = bVar;
        }
    }

    /* loaded from: classes.dex */
    private class m implements l.b {
        m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.b
        public void a(e0 e0Var) {
            e0Var.setIsRecyclable(true);
            if (e0Var.mShadowedHolder != null && e0Var.mShadowingHolder == null) {
                e0Var.mShadowedHolder = null;
            }
            e0Var.mShadowingHolder = null;
            if (e0Var.shouldBeKeptAsChild() || RecyclerView.this.removeAnimatingView(e0Var.itemView) || !e0Var.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(e0Var.itemView, false);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n {
        @Deprecated
        public void getItemOffsets(Rect rect, int i2, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, b0 b0Var) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, b0 b0Var) {
            onDrawOver(canvas, recyclerView);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, b0 b0Var) {
            getItemOffsets(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class o {
        androidx.recyclerview.widget.f a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f2027b;

        /* renamed from: c  reason: collision with root package name */
        private final t.b f2028c;

        /* renamed from: d  reason: collision with root package name */
        private final t.b f2029d;

        /* renamed from: e  reason: collision with root package name */
        androidx.recyclerview.widget.t f2030e;

        /* renamed from: f  reason: collision with root package name */
        androidx.recyclerview.widget.t f2031f;

        /* renamed from: g  reason: collision with root package name */
        a0 f2032g;

        /* renamed from: h  reason: collision with root package name */
        boolean f2033h;

        /* renamed from: j  reason: collision with root package name */
        boolean f2034j;

        /* renamed from: k  reason: collision with root package name */
        boolean f2035k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f2036l;
        private boolean m;
        int n;
        boolean p;
        private int q;
        private int t;
        private int u;
        private int v;

        /* loaded from: classes.dex */
        class a implements t.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.t.b
            public View a(int i2) {
                return o.this.S(i2);
            }

            @Override // androidx.recyclerview.widget.t.b
            public int b(View view) {
                return o.this.a0(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.t.b
            public int c() {
                return o.this.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.t.b
            public int d() {
                return o.this.t0() - o.this.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.t.b
            public int e(View view) {
                return o.this.d0(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }
        }

        /* loaded from: classes.dex */
        class b implements t.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.t.b
            public View a(int i2) {
                return o.this.S(i2);
            }

            @Override // androidx.recyclerview.widget.t.b
            public int b(View view) {
                return o.this.e0(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.t.b
            public int c() {
                return o.this.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.t.b
            public int d() {
                return o.this.g0() - o.this.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.t.b
            public int e(View view) {
                return o.this.Y(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }
        }

        /* loaded from: classes.dex */
        public interface c {
            void a(int i2, int i3);
        }

        /* loaded from: classes.dex */
        public static class d {
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public int f2037b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f2038c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f2039d;
        }

        public o() {
            a aVar = new a();
            this.f2028c = aVar;
            b bVar = new b();
            this.f2029d = bVar;
            this.f2030e = new androidx.recyclerview.widget.t(aVar);
            this.f2031f = new androidx.recyclerview.widget.t(bVar);
            this.f2033h = false;
            this.f2034j = false;
            this.f2035k = false;
            this.f2036l = true;
            this.m = true;
        }

        private static boolean C0(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 <= 0 || i2 == i4) {
                if (mode == Integer.MIN_VALUE) {
                    return size >= i2;
                } else if (mode != 0) {
                    return mode == 1073741824 && size == i2;
                } else {
                    return true;
                }
            }
            return false;
        }

        private void C1(v vVar, int i2, View view) {
            e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.f2027b.mAdapter.hasStableIds()) {
                x1(i2);
                vVar.C(childViewHolderInt);
                return;
            }
            H(i2);
            vVar.D(view);
            this.f2027b.mViewInfoStore.k(childViewHolderInt);
        }

        private void I(int i2, View view) {
            this.a.d(i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r5 == 1073741824) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int U(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1a
                if (r7 < 0) goto L11
                goto L1c
            L11:
                if (r7 != r1) goto L2f
                if (r5 == r2) goto L20
                if (r5 == 0) goto L2f
                if (r5 == r3) goto L20
                goto L2f
            L1a:
                if (r7 < 0) goto L1e
            L1c:
                r5 = r3
                goto L31
            L1e:
                if (r7 != r1) goto L22
            L20:
                r7 = r4
                goto L31
            L22:
                if (r7 != r0) goto L2f
                if (r5 == r2) goto L2c
                if (r5 != r3) goto L29
                goto L2c
            L29:
                r7 = r4
                r5 = r6
                goto L31
            L2c:
                r7 = r4
                r5 = r2
                goto L31
            L2f:
                r5 = r6
                r7 = r5
            L31:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.U(int, int, int, int, boolean):int");
        }

        private int[] V(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int t0 = t0() - getPaddingRight();
            int g0 = g0() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i2 = left - paddingLeft;
            int min = Math.min(0, i2);
            int i3 = top - paddingTop;
            int min2 = Math.min(0, i3);
            int i4 = width - t0;
            int max = Math.max(0, i4);
            int max2 = Math.max(0, height - g0);
            if (i0() != 1) {
                if (min == 0) {
                    min = Math.min(i2, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i4);
            }
            if (min2 == 0) {
                min2 = Math.min(i3, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public static d n0(Context context, AttributeSet attributeSet, int i2, int i3) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.q.c.f3201f, i2, i3);
            dVar.a = obtainStyledAttributes.getInt(c.q.c.f3202g, 1);
            dVar.f2037b = obtainStyledAttributes.getInt(c.q.c.q, 1);
            dVar.f2038c = obtainStyledAttributes.getBoolean(c.q.c.p, false);
            dVar.f2039d = obtainStyledAttributes.getBoolean(c.q.c.r, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        private void p(View view, int i2, boolean z) {
            e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!z && !childViewHolderInt.isRemoved()) {
                this.f2027b.mViewInfoStore.p(childViewHolderInt);
            } else {
                this.f2027b.mViewInfoStore.b(childViewHolderInt);
            }
            p pVar = (p) view.getLayoutParams();
            if (!childViewHolderInt.wasReturnedFromScrap() && !childViewHolderInt.isScrap()) {
                if (view.getParent() == this.f2027b) {
                    int m = this.a.m(view);
                    if (i2 == -1) {
                        i2 = this.a.g();
                    }
                    if (m == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f2027b.indexOfChild(view) + this.f2027b.exceptionLabel());
                    } else if (m != i2) {
                        this.f2027b.mLayout.H0(m, i2);
                    }
                } else {
                    this.a.a(view, i2, false);
                    pVar.f2041c = true;
                    a0 a0Var = this.f2032g;
                    if (a0Var != null && a0Var.h()) {
                        this.f2032g.k(view);
                    }
                }
            } else {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.a.c(view, i2, view.getLayoutParams(), false);
            }
            if (pVar.f2042d) {
                childViewHolderInt.itemView.invalidate();
                pVar.f2042d = false;
            }
        }

        public static int x(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i3, i4) : size;
            }
            return Math.min(size, Math.max(i3, i4));
        }

        private boolean y0(RecyclerView recyclerView, int i2, int i3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int t0 = t0() - getPaddingRight();
            int g0 = g0() - getPaddingBottom();
            Rect rect = this.f2027b.mTempRect;
            Z(focusedChild, rect);
            return rect.left - i2 < t0 && rect.right - i2 > paddingLeft && rect.top - i3 < g0 && rect.bottom - i3 > paddingTop;
        }

        public int A(b0 b0Var) {
            return 0;
        }

        public boolean A0(v vVar, b0 b0Var) {
            return false;
        }

        public void A1() {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int B(b0 b0Var) {
            return 0;
        }

        public boolean B0() {
            return this.f2036l;
        }

        public void B1() {
            this.f2033h = true;
        }

        public int C(b0 b0Var) {
            return 0;
        }

        public int D(b0 b0Var) {
            return 0;
        }

        public boolean D0() {
            a0 a0Var = this.f2032g;
            return a0Var != null && a0Var.h();
        }

        public int D1(int i2, v vVar, b0 b0Var) {
            return 0;
        }

        public int E(b0 b0Var) {
            return 0;
        }

        public boolean E0(View view, boolean z, boolean z2) {
            boolean z3 = this.f2030e.b(view, 24579) && this.f2031f.b(view, 24579);
            return z ? z3 : !z3;
        }

        public void E1(int i2) {
        }

        public int F(b0 b0Var) {
            return 0;
        }

        public void F0(View view, int i2, int i3, int i4, int i5) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f2040b;
            view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        public int F1(int i2, v vVar, b0 b0Var) {
            return 0;
        }

        public void G(v vVar) {
            for (int T = T() - 1; T >= 0; T--) {
                C1(vVar, T, S(T));
            }
        }

        public void G0(View view, int i2, int i3) {
            p pVar = (p) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.f2027b.getItemDecorInsetsForChild(view);
            int i4 = i2 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i5 = i3 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int U = U(t0(), u0(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i4, ((ViewGroup.MarginLayoutParams) pVar).width, u());
            int U2 = U(g0(), h0(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) pVar).height, v());
            if (M1(view, U, U2, pVar)) {
                view.measure(U, U2);
            }
        }

        void G1(RecyclerView recyclerView) {
            H1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public void H(int i2) {
            I(i2, S(i2));
        }

        public void H0(int i2, int i3) {
            View S = S(i2);
            if (S != null) {
                H(i2);
                r(S, i3);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.f2027b.toString());
        }

        void H1(int i2, int i3) {
            this.u = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.q = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.u = 0;
            }
            this.v = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.t = mode2;
            if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.v = 0;
        }

        public void I0(int i2) {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i2);
            }
        }

        public void I1(int i2, int i3) {
            this.f2027b.setMeasuredDimension(i2, i3);
        }

        void J(RecyclerView recyclerView) {
            this.f2034j = true;
            M0(recyclerView);
        }

        public void J0(int i2) {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i2);
            }
        }

        public void J1(Rect rect, int i2, int i3) {
            I1(x(i2, rect.width() + getPaddingLeft() + getPaddingRight(), l0()), x(i3, rect.height() + getPaddingTop() + getPaddingBottom(), k0()));
        }

        void K(RecyclerView recyclerView, v vVar) {
            this.f2034j = false;
            O0(recyclerView, vVar);
        }

        public void K0(g gVar, g gVar2) {
        }

        void K1(int i2, int i3) {
            int T = T();
            if (T == 0) {
                this.f2027b.defaultOnMeasure(i2, i3);
                return;
            }
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 = 0; i8 < T; i8++) {
                View S = S(i8);
                Rect rect = this.f2027b.mTempRect;
                Z(S, rect);
                int i9 = rect.left;
                if (i9 < i5) {
                    i5 = i9;
                }
                int i10 = rect.right;
                if (i10 > i4) {
                    i4 = i10;
                }
                int i11 = rect.top;
                if (i11 < i6) {
                    i6 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i7) {
                    i7 = i12;
                }
            }
            this.f2027b.mTempRect.set(i5, i6, i4, i7);
            J1(this.f2027b.mTempRect, i2, i3);
        }

        public View L(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.a.n(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public boolean L0(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
            return false;
        }

        void L1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f2027b = null;
                this.a = null;
                this.u = 0;
                this.v = 0;
            } else {
                this.f2027b = recyclerView;
                this.a = recyclerView.mChildHelper;
                this.u = recyclerView.getWidth();
                this.v = recyclerView.getHeight();
            }
            this.q = 1073741824;
            this.t = 1073741824;
        }

        public View M(int i2) {
            int T = T();
            for (int i3 = 0; i3 < T; i3++) {
                View S = S(i3);
                e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(S);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i2 && !childViewHolderInt.shouldIgnore() && (this.f2027b.mState.e() || !childViewHolderInt.isRemoved())) {
                    return S;
                }
            }
            return null;
        }

        public void M0(RecyclerView recyclerView) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean M1(View view, int i2, int i3, p pVar) {
            return (!view.isLayoutRequested() && this.f2036l && C0(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) pVar).width) && C0(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public abstract p N();

        @Deprecated
        public void N0(RecyclerView recyclerView) {
        }

        boolean N1() {
            return false;
        }

        public p O(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void O0(RecyclerView recyclerView, v vVar) {
            N0(recyclerView);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean O1(View view, int i2, int i3, p pVar) {
            return (this.f2036l && C0(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) pVar).width) && C0(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public p P(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof p) {
                return new p((p) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new p((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new p(layoutParams);
        }

        public View P0(View view, int i2, v vVar, b0 b0Var) {
            return null;
        }

        public void P1(RecyclerView recyclerView, b0 b0Var, int i2) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public int Q() {
            return -1;
        }

        public void Q0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f2027b;
            R0(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void Q1(a0 a0Var) {
            a0 a0Var2 = this.f2032g;
            if (a0Var2 != null && a0Var != a0Var2 && a0Var2.h()) {
                this.f2032g.r();
            }
            this.f2032g = a0Var;
            a0Var.q(this.f2027b, this);
        }

        public int R(View view) {
            return ((p) view.getLayoutParams()).f2040b.bottom;
        }

        public void R0(v vVar, b0 b0Var, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f2027b.canScrollVertically(-1) && !this.f2027b.canScrollHorizontally(-1) && !this.f2027b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            g gVar = this.f2027b.mAdapter;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.getItemCount());
            }
        }

        void R1() {
            a0 a0Var = this.f2032g;
            if (a0Var != null) {
                a0Var.r();
            }
        }

        public View S(int i2) {
            androidx.recyclerview.widget.f fVar = this.a;
            if (fVar != null) {
                return fVar.f(i2);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void S0(c.h.k.e0.d dVar) {
            RecyclerView recyclerView = this.f2027b;
            T0(recyclerView.mRecycler, recyclerView.mState, dVar);
        }

        public boolean S1() {
            return false;
        }

        public int T() {
            androidx.recyclerview.widget.f fVar = this.a;
            if (fVar != null) {
                return fVar.g();
            }
            return 0;
        }

        public void T0(v vVar, b0 b0Var, c.h.k.e0.d dVar) {
            if (this.f2027b.canScrollVertically(-1) || this.f2027b.canScrollHorizontally(-1)) {
                dVar.a(PKIFailureInfo.certRevoked);
                dVar.m0(true);
            }
            if (this.f2027b.canScrollVertically(1) || this.f2027b.canScrollHorizontally(1)) {
                dVar.a(4096);
                dVar.m0(true);
            }
            dVar.V(d.b.a(p0(vVar, b0Var), X(vVar, b0Var), A0(vVar, b0Var), q0(vVar, b0Var)));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void U0(View view, c.h.k.e0.d dVar) {
            e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.a.n(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.f2027b;
            V0(recyclerView.mRecycler, recyclerView.mState, view, dVar);
        }

        public void V0(v vVar, b0 b0Var, View view, c.h.k.e0.d dVar) {
            dVar.W(d.c.b(v() ? m0(view) : 0, 1, u() ? m0(view) : 0, 1, false, false));
        }

        public boolean W() {
            RecyclerView recyclerView = this.f2027b;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public View W0(View view, int i2) {
            return null;
        }

        public int X(v vVar, b0 b0Var) {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView == null || recyclerView.mAdapter == null || !u()) {
                return 1;
            }
            return this.f2027b.mAdapter.getItemCount();
        }

        public void X0(RecyclerView recyclerView, int i2, int i3) {
        }

        public int Y(View view) {
            return view.getBottom() + R(view);
        }

        public void Y0(RecyclerView recyclerView) {
        }

        public void Z(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public void Z0(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public int a0(View view) {
            return view.getLeft() - j0(view);
        }

        public void a1(RecyclerView recyclerView, int i2, int i3) {
        }

        public int b0(View view) {
            Rect rect = ((p) view.getLayoutParams()).f2040b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void b1(RecyclerView recyclerView, int i2, int i3) {
        }

        public int c0(View view) {
            Rect rect = ((p) view.getLayoutParams()).f2040b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void c1(RecyclerView recyclerView, int i2, int i3, Object obj) {
            b1(recyclerView, i2, i3);
        }

        public int d0(View view) {
            return view.getRight() + o0(view);
        }

        public void d1(v vVar, b0 b0Var) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int e0(View view) {
            return view.getTop() - r0(view);
        }

        public void e1(b0 b0Var) {
        }

        public View f0() {
            View focusedChild;
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void f1(v vVar, b0 b0Var, int i2, int i3) {
            this.f2027b.defaultOnMeasure(i2, i3);
        }

        public int g0() {
            return this.v;
        }

        @Deprecated
        public boolean g1(RecyclerView recyclerView, View view, View view2) {
            return D0() || recyclerView.isComputingLayout();
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView != null) {
                return c.h.k.v.C(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView != null) {
                return c.h.k.v.D(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int h0() {
            return this.t;
        }

        public boolean h1(RecyclerView recyclerView, b0 b0Var, View view, View view2) {
            return g1(recyclerView, view, view2);
        }

        public int i0() {
            return c.h.k.v.y(this.f2027b);
        }

        public void i1(Parcelable parcelable) {
        }

        public int j0(View view) {
            return ((p) view.getLayoutParams()).f2040b.left;
        }

        public Parcelable j1() {
            return null;
        }

        public int k0() {
            return c.h.k.v.z(this.f2027b);
        }

        public void k1(int i2) {
        }

        public void l(View view) {
            m(view, -1);
        }

        public int l0() {
            return c.h.k.v.A(this.f2027b);
        }

        void l1(a0 a0Var) {
            if (this.f2032g == a0Var) {
                this.f2032g = null;
            }
        }

        public void m(View view, int i2) {
            p(view, i2, true);
        }

        public int m0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean m1(int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f2027b;
            return n1(recyclerView.mRecycler, recyclerView.mState, i2, bundle);
        }

        public void n(View view) {
            o(view, -1);
        }

        public boolean n1(v vVar, b0 b0Var, int i2, Bundle bundle) {
            int g0;
            int t0;
            int i3;
            int i4;
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView == null) {
                return false;
            }
            if (i2 == 4096) {
                g0 = recyclerView.canScrollVertically(1) ? (g0() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.f2027b.canScrollHorizontally(1)) {
                    t0 = (t0() - getPaddingLeft()) - getPaddingRight();
                    i3 = g0;
                    i4 = t0;
                }
                i3 = g0;
                i4 = 0;
            } else if (i2 != 8192) {
                i4 = 0;
                i3 = 0;
            } else {
                g0 = recyclerView.canScrollVertically(-1) ? -((g0() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.f2027b.canScrollHorizontally(-1)) {
                    t0 = -((t0() - getPaddingLeft()) - getPaddingRight());
                    i3 = g0;
                    i4 = t0;
                }
                i3 = g0;
                i4 = 0;
            }
            if (i3 == 0 && i4 == 0) {
                return false;
            }
            this.f2027b.smoothScrollBy(i4, i3, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void o(View view, int i2) {
            p(view, i2, false);
        }

        public int o0(View view) {
            return ((p) view.getLayoutParams()).f2040b.right;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean o1(View view, int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f2027b;
            return p1(recyclerView.mRecycler, recyclerView.mState, view, i2, bundle);
        }

        public int p0(v vVar, b0 b0Var) {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView == null || recyclerView.mAdapter == null || !v()) {
                return 1;
            }
            return this.f2027b.mAdapter.getItemCount();
        }

        public boolean p1(v vVar, b0 b0Var, View view, int i2, Bundle bundle) {
            return false;
        }

        public void q(String str) {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public int q0(v vVar, b0 b0Var) {
            return 0;
        }

        public void q1() {
            for (int T = T() - 1; T >= 0; T--) {
                this.a.q(T);
            }
        }

        public void r(View view, int i2) {
            s(view, i2, (p) view.getLayoutParams());
        }

        public int r0(View view) {
            return ((p) view.getLayoutParams()).f2040b.top;
        }

        public void r1(v vVar) {
            for (int T = T() - 1; T >= 0; T--) {
                if (!RecyclerView.getChildViewHolderInt(S(T)).shouldIgnore()) {
                    u1(T, vVar);
                }
            }
        }

        public void s(View view, int i2, p pVar) {
            e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.f2027b.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.f2027b.mViewInfoStore.p(childViewHolderInt);
            }
            this.a.c(view, i2, pVar, childViewHolderInt.isRemoved());
        }

        public void s0(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((p) view.getLayoutParams()).f2040b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f2027b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f2027b.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        void s1(v vVar) {
            int j2 = vVar.j();
            for (int i2 = j2 - 1; i2 >= 0; i2--) {
                View n = vVar.n(i2);
                e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(n);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.f2027b.removeDetachedView(n, false);
                    }
                    l lVar = this.f2027b.mItemAnimator;
                    if (lVar != null) {
                        lVar.j(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    vVar.y(n);
                }
            }
            vVar.e();
            if (j2 > 0) {
                this.f2027b.invalidate();
            }
        }

        public void t(View view, Rect rect) {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public int t0() {
            return this.u;
        }

        public void t1(View view, v vVar) {
            w1(view);
            vVar.B(view);
        }

        public boolean u() {
            return false;
        }

        public int u0() {
            return this.q;
        }

        public void u1(int i2, v vVar) {
            View S = S(i2);
            x1(i2);
            vVar.B(S);
        }

        public boolean v() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean v0() {
            int T = T();
            for (int i2 = 0; i2 < T; i2++) {
                ViewGroup.LayoutParams layoutParams = S(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean v1(Runnable runnable) {
            RecyclerView recyclerView = this.f2027b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public boolean w(p pVar) {
            return pVar != null;
        }

        public boolean w0() {
            return this.f2034j;
        }

        public void w1(View view) {
            this.a.p(view);
        }

        public boolean x0() {
            return this.f2035k;
        }

        public void x1(int i2) {
            if (S(i2) != null) {
                this.a.q(i2);
            }
        }

        public void y(int i2, int i3, b0 b0Var, c cVar) {
        }

        public boolean y1(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return z1(recyclerView, view, rect, z, false);
        }

        public void z(int i2, c cVar) {
        }

        public final boolean z0() {
            return this.m;
        }

        public boolean z1(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] V = V(view, rect);
            int i2 = V[0];
            int i3 = V[1];
            if ((!z2 || y0(recyclerView, i2, i3)) && !(i2 == 0 && i3 == 0)) {
                if (z) {
                    recyclerView.scrollBy(i2, i3);
                } else {
                    recyclerView.smoothScrollBy(i2, i3);
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface q {
        void a(View view);

        void b(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class r {
    }

    /* loaded from: classes.dex */
    public interface s {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class t {
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        }

        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        }
    }

    /* loaded from: classes.dex */
    public static class u {
        SparseArray<a> a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private int f2043b = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a {
            final ArrayList<e0> a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f2044b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f2045c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f2046d = 0;

            a() {
            }
        }

        private a g(int i2) {
            a aVar = this.a.get(i2);
            if (aVar == null) {
                a aVar2 = new a();
                this.a.put(i2, aVar2);
                return aVar2;
            }
            return aVar;
        }

        void a() {
            this.f2043b++;
        }

        public void b() {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                this.a.valueAt(i2).a.clear();
            }
        }

        void c() {
            this.f2043b--;
        }

        void d(int i2, long j2) {
            a g2 = g(i2);
            g2.f2046d = j(g2.f2046d, j2);
        }

        void e(int i2, long j2) {
            a g2 = g(i2);
            g2.f2045c = j(g2.f2045c, j2);
        }

        public e0 f(int i2) {
            a aVar = this.a.get(i2);
            if (aVar == null || aVar.a.isEmpty()) {
                return null;
            }
            ArrayList<e0> arrayList = aVar.a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        void h(g gVar, g gVar2, boolean z) {
            if (gVar != null) {
                c();
            }
            if (!z && this.f2043b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void i(e0 e0Var) {
            int itemViewType = e0Var.getItemViewType();
            ArrayList<e0> arrayList = g(itemViewType).a;
            if (this.a.get(itemViewType).f2044b <= arrayList.size()) {
                return;
            }
            e0Var.resetInternal();
            arrayList.add(e0Var);
        }

        long j(long j2, long j3) {
            return j2 == 0 ? j3 : ((j2 / 4) * 3) + (j3 / 4);
        }

        boolean k(int i2, long j2, long j3) {
            long j4 = g(i2).f2046d;
            return j4 == 0 || j2 + j4 < j3;
        }

        boolean l(int i2, long j2, long j3) {
            long j4 = g(i2).f2045c;
            return j4 == 0 || j2 + j4 < j3;
        }
    }

    /* loaded from: classes.dex */
    public final class v {
        final ArrayList<e0> a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<e0> f2047b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<e0> f2048c;

        /* renamed from: d  reason: collision with root package name */
        private final List<e0> f2049d;

        /* renamed from: e  reason: collision with root package name */
        private int f2050e;

        /* renamed from: f  reason: collision with root package name */
        int f2051f;

        /* renamed from: g  reason: collision with root package name */
        u f2052g;

        /* renamed from: h  reason: collision with root package name */
        private c0 f2053h;

        public v() {
            ArrayList<e0> arrayList = new ArrayList<>();
            this.a = arrayList;
            this.f2047b = null;
            this.f2048c = new ArrayList<>();
            this.f2049d = Collections.unmodifiableList(arrayList);
            this.f2050e = 2;
            this.f2051f = 2;
        }

        private boolean H(e0 e0Var, int i2, int i3, long j2) {
            e0Var.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = e0Var.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j2 == RecyclerView.FOREVER_NS || this.f2052g.k(itemViewType, nanoTime, j2)) {
                RecyclerView.this.mAdapter.bindViewHolder(e0Var, i2);
                this.f2052g.d(e0Var.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
                b(e0Var);
                if (RecyclerView.this.mState.e()) {
                    e0Var.mPreLayoutPosition = i3;
                    return true;
                }
                return true;
            }
            return false;
        }

        private void b(e0 e0Var) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = e0Var.itemView;
                if (c.h.k.v.w(view) == 0) {
                    c.h.k.v.t0(view, 1);
                }
                androidx.recyclerview.widget.q qVar = RecyclerView.this.mAccessibilityDelegate;
                if (qVar == null) {
                    return;
                }
                c.h.k.a n = qVar.n();
                if (n instanceof q.a) {
                    ((q.a) n).o(view);
                }
                c.h.k.v.k0(view, n);
            }
        }

        private void q(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        private void r(e0 e0Var) {
            View view = e0Var.itemView;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        void A(int i2) {
            a(this.f2048c.get(i2), true);
            this.f2048c.remove(i2);
        }

        public void B(View view) {
            e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            C(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            RecyclerView.this.mItemAnimator.j(childViewHolderInt);
        }

        void C(e0 e0Var) {
            boolean z;
            boolean z2 = true;
            if (!e0Var.isScrap() && e0Var.itemView.getParent() == null) {
                if (!e0Var.isTmpDetached()) {
                    if (!e0Var.shouldIgnore()) {
                        boolean doesTransientStatePreventRecycling = e0Var.doesTransientStatePreventRecycling();
                        g gVar = RecyclerView.this.mAdapter;
                        if ((gVar != null && doesTransientStatePreventRecycling && gVar.onFailedToRecycleView(e0Var)) || e0Var.isRecyclable()) {
                            if (this.f2051f <= 0 || e0Var.hasAnyOfTheFlags(526)) {
                                z = false;
                            } else {
                                int size = this.f2048c.size();
                                if (size >= this.f2051f && size > 0) {
                                    A(0);
                                    size--;
                                }
                                if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.d(e0Var.mPosition)) {
                                    int i2 = size - 1;
                                    while (i2 >= 0) {
                                        if (!RecyclerView.this.mPrefetchRegistry.d(this.f2048c.get(i2).mPosition)) {
                                            break;
                                        }
                                        i2--;
                                    }
                                    size = i2 + 1;
                                }
                                this.f2048c.add(size, e0Var);
                                z = true;
                            }
                            if (z) {
                                z2 = false;
                            } else {
                                a(e0Var, true);
                            }
                            r1 = z;
                        } else {
                            z2 = false;
                        }
                        RecyclerView.this.mViewInfoStore.q(e0Var);
                        if (r1 || z2 || !doesTransientStatePreventRecycling) {
                            return;
                        }
                        e0Var.mOwnerRecyclerView = null;
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + e0Var + RecyclerView.this.exceptionLabel());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(e0Var.isScrap());
            sb.append(" isAttached:");
            sb.append(e0Var.itemView.getParent() != null);
            sb.append(RecyclerView.this.exceptionLabel());
            throw new IllegalArgumentException(sb.toString());
        }

        void D(View view) {
            e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f2047b == null) {
                    this.f2047b = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f2047b.add(childViewHolderInt);
            } else if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.this.mAdapter.hasStableIds()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            } else {
                childViewHolderInt.setScrapContainer(this, false);
                this.a.add(childViewHolderInt);
            }
        }

        void E(u uVar) {
            u uVar2 = this.f2052g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.f2052g = uVar;
            if (uVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f2052g.a();
        }

        void F(c0 c0Var) {
        }

        public void G(int i2) {
            this.f2050e = i2;
            K();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0138  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0178  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0187  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x01b1  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01bf  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x01db A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public androidx.recyclerview.widget.RecyclerView.e0 I(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 538
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$e0");
        }

        void J(e0 e0Var) {
            if (e0Var.mInChangeScrap) {
                this.f2047b.remove(e0Var);
            } else {
                this.a.remove(e0Var);
            }
            e0Var.mScrapContainer = null;
            e0Var.mInChangeScrap = false;
            e0Var.clearReturnedFromScrapFlag();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void K() {
            o oVar = RecyclerView.this.mLayout;
            this.f2051f = this.f2050e + (oVar != null ? oVar.n : 0);
            for (int size = this.f2048c.size() - 1; size >= 0 && this.f2048c.size() > this.f2051f; size--) {
                A(size);
            }
        }

        boolean L(e0 e0Var) {
            if (e0Var.isRemoved()) {
                return RecyclerView.this.mState.e();
            }
            int i2 = e0Var.mPosition;
            if (i2 >= 0 && i2 < RecyclerView.this.mAdapter.getItemCount()) {
                if (RecyclerView.this.mState.e() || RecyclerView.this.mAdapter.getItemViewType(e0Var.mPosition) == e0Var.getItemViewType()) {
                    return !RecyclerView.this.mAdapter.hasStableIds() || e0Var.getItemId() == RecyclerView.this.mAdapter.getItemId(e0Var.mPosition);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + e0Var + RecyclerView.this.exceptionLabel());
        }

        void M(int i2, int i3) {
            int i4;
            int i5 = i3 + i2;
            for (int size = this.f2048c.size() - 1; size >= 0; size--) {
                e0 e0Var = this.f2048c.get(size);
                if (e0Var != null && (i4 = e0Var.mPosition) >= i2 && i4 < i5) {
                    e0Var.addFlags(2);
                    A(size);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(e0 e0Var, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(e0Var);
            View view = e0Var.itemView;
            androidx.recyclerview.widget.q qVar = RecyclerView.this.mAccessibilityDelegate;
            if (qVar != null) {
                c.h.k.a n = qVar.n();
                c.h.k.v.k0(view, n instanceof q.a ? ((q.a) n).n(view) : null);
            }
            if (z) {
                g(e0Var);
            }
            e0Var.mOwnerRecyclerView = null;
            i().i(e0Var);
        }

        public void c() {
            this.a.clear();
            z();
        }

        void d() {
            int size = this.f2048c.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f2048c.get(i2).clearOldPosition();
            }
            int size2 = this.a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.a.get(i3).clearOldPosition();
            }
            ArrayList<e0> arrayList = this.f2047b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.f2047b.get(i4).clearOldPosition();
                }
            }
        }

        void e() {
            this.a.clear();
            ArrayList<e0> arrayList = this.f2047b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i2) {
            if (i2 >= 0 && i2 < RecyclerView.this.mState.b()) {
                return !RecyclerView.this.mState.e() ? i2 : RecyclerView.this.mAdapterHelper.m(i2);
            }
            throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + RecyclerView.this.mState.b() + RecyclerView.this.exceptionLabel());
        }

        void g(e0 e0Var) {
            w wVar = RecyclerView.this.mRecyclerListener;
            if (wVar != null) {
                wVar.a(e0Var);
            }
            g gVar = RecyclerView.this.mAdapter;
            if (gVar != null) {
                gVar.onViewRecycled(e0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.q(e0Var);
            }
        }

        e0 h(int i2) {
            int size;
            int m;
            ArrayList<e0> arrayList = this.f2047b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    e0 e0Var = this.f2047b.get(i3);
                    if (!e0Var.wasReturnedFromScrap() && e0Var.getLayoutPosition() == i2) {
                        e0Var.addFlags(32);
                        return e0Var;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (m = RecyclerView.this.mAdapterHelper.m(i2)) > 0 && m < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(m);
                    for (int i4 = 0; i4 < size; i4++) {
                        e0 e0Var2 = this.f2047b.get(i4);
                        if (!e0Var2.wasReturnedFromScrap() && e0Var2.getItemId() == itemId) {
                            e0Var2.addFlags(32);
                            return e0Var2;
                        }
                    }
                }
            }
            return null;
        }

        u i() {
            if (this.f2052g == null) {
                this.f2052g = new u();
            }
            return this.f2052g;
        }

        int j() {
            return this.a.size();
        }

        public List<e0> k() {
            return this.f2049d;
        }

        e0 l(long j2, int i2, boolean z) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                e0 e0Var = this.a.get(size);
                if (e0Var.getItemId() == j2 && !e0Var.wasReturnedFromScrap()) {
                    if (i2 == e0Var.getItemViewType()) {
                        e0Var.addFlags(32);
                        if (e0Var.isRemoved() && !RecyclerView.this.mState.e()) {
                            e0Var.setFlags(2, 14);
                        }
                        return e0Var;
                    } else if (!z) {
                        this.a.remove(size);
                        RecyclerView.this.removeDetachedView(e0Var.itemView, false);
                        y(e0Var.itemView);
                    }
                }
            }
            int size2 = this.f2048c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                e0 e0Var2 = this.f2048c.get(size2);
                if (e0Var2.getItemId() == j2 && !e0Var2.isAttachedToTransitionOverlay()) {
                    if (i2 == e0Var2.getItemViewType()) {
                        if (!z) {
                            this.f2048c.remove(size2);
                        }
                        return e0Var2;
                    } else if (!z) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        e0 m(int i2, boolean z) {
            View e2;
            int size = this.a.size();
            for (int i3 = 0; i3 < size; i3++) {
                e0 e0Var = this.a.get(i3);
                if (!e0Var.wasReturnedFromScrap() && e0Var.getLayoutPosition() == i2 && !e0Var.isInvalid() && (RecyclerView.this.mState.f2008h || !e0Var.isRemoved())) {
                    e0Var.addFlags(32);
                    return e0Var;
                }
            }
            if (!z && (e2 = RecyclerView.this.mChildHelper.e(i2)) != null) {
                e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(e2);
                RecyclerView.this.mChildHelper.s(e2);
                int m = RecyclerView.this.mChildHelper.m(e2);
                if (m != -1) {
                    RecyclerView.this.mChildHelper.d(m);
                    D(e2);
                    childViewHolderInt.addFlags(8224);
                    return childViewHolderInt;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
            }
            int size2 = this.f2048c.size();
            for (int i4 = 0; i4 < size2; i4++) {
                e0 e0Var2 = this.f2048c.get(i4);
                if (!e0Var2.isInvalid() && e0Var2.getLayoutPosition() == i2 && !e0Var2.isAttachedToTransitionOverlay()) {
                    if (!z) {
                        this.f2048c.remove(i4);
                    }
                    return e0Var2;
                }
            }
            return null;
        }

        View n(int i2) {
            return this.a.get(i2).itemView;
        }

        public View o(int i2) {
            return p(i2, false);
        }

        View p(int i2, boolean z) {
            return I(i2, z, RecyclerView.FOREVER_NS).itemView;
        }

        void s() {
            int size = this.f2048c.size();
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = (p) this.f2048c.get(i2).itemView.getLayoutParams();
                if (pVar != null) {
                    pVar.f2041c = true;
                }
            }
        }

        void t() {
            int size = this.f2048c.size();
            for (int i2 = 0; i2 < size; i2++) {
                e0 e0Var = this.f2048c.get(i2);
                if (e0Var != null) {
                    e0Var.addFlags(6);
                    e0Var.addChangePayload(null);
                }
            }
            g gVar = RecyclerView.this.mAdapter;
            if (gVar == null || !gVar.hasStableIds()) {
                z();
            }
        }

        void u(int i2, int i3) {
            int size = this.f2048c.size();
            for (int i4 = 0; i4 < size; i4++) {
                e0 e0Var = this.f2048c.get(i4);
                if (e0Var != null && e0Var.mPosition >= i2) {
                    e0Var.offsetPosition(i3, true);
                }
            }
        }

        void v(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            if (i2 < i3) {
                i4 = -1;
                i6 = i2;
                i5 = i3;
            } else {
                i4 = 1;
                i5 = i2;
                i6 = i3;
            }
            int size = this.f2048c.size();
            for (int i8 = 0; i8 < size; i8++) {
                e0 e0Var = this.f2048c.get(i8);
                if (e0Var != null && (i7 = e0Var.mPosition) >= i6 && i7 <= i5) {
                    if (i7 == i2) {
                        e0Var.offsetPosition(i3 - i2, false);
                    } else {
                        e0Var.offsetPosition(i4, false);
                    }
                }
            }
        }

        void w(int i2, int i3, boolean z) {
            int i4 = i2 + i3;
            for (int size = this.f2048c.size() - 1; size >= 0; size--) {
                e0 e0Var = this.f2048c.get(size);
                if (e0Var != null) {
                    int i5 = e0Var.mPosition;
                    if (i5 >= i4) {
                        e0Var.offsetPosition(-i3, z);
                    } else if (i5 >= i2) {
                        e0Var.addFlags(8);
                        A(size);
                    }
                }
            }
        }

        void x(g gVar, g gVar2, boolean z) {
            c();
            i().h(gVar, gVar2, z);
        }

        void y(View view) {
            e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            C(childViewHolderInt);
        }

        void z() {
            for (int size = this.f2048c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f2048c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface w {
        void a(e0 e0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class x extends i {
        x() {
        }

        void a() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    c.h.k.v.c0(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.f2007g = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (RecyclerView.this.mAdapterHelper.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeChanged(int i2, int i3, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.r(i2, i3, obj)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeInserted(int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.s(i2, i3)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeMoved(int i2, int i3, int i4) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.t(i2, i3, i4)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeRemoved(int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.u(i2, i3)) {
                a();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class z implements s {
        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        FORCE_INVALIDATE_DISPLAY_LIST = i2 == 18 || i2 == 19 || i2 == 20;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = i2 >= 23;
        POST_UPDATES_ON_ANIMATION = i2 >= 16;
        ALLOW_THREAD_GAP_WORK = i2 >= 21;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = i2 <= 15;
        IGNORE_DETACHED_FOCUSED_CHILD = i2 <= 15;
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void addAnimatingView(e0 e0Var) {
        View view = e0Var.itemView;
        boolean z2 = view.getParent() == this;
        this.mRecycler.J(getChildViewHolder(view));
        if (e0Var.isTmpDetached()) {
            this.mChildHelper.c(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.mChildHelper.b(view, true);
        } else {
            this.mChildHelper.k(view);
        }
    }

    private void animateChange(e0 e0Var, e0 e0Var2, l.c cVar, l.c cVar2, boolean z2, boolean z3) {
        e0Var.setIsRecyclable(false);
        if (z2) {
            addAnimatingView(e0Var);
        }
        if (e0Var != e0Var2) {
            if (z3) {
                addAnimatingView(e0Var2);
            }
            e0Var.mShadowedHolder = e0Var2;
            addAnimatingView(e0Var);
            this.mRecycler.J(e0Var);
            e0Var2.setIsRecyclable(false);
            e0Var2.mShadowingHolder = e0Var;
        }
        if (this.mItemAnimator.b(e0Var, e0Var2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    static void clearNestedRecyclerViewIfNotNested(e0 e0Var) {
        WeakReference<RecyclerView> weakReference = e0Var.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == e0Var.itemView) {
                    return;
                }
                ViewParent parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            e0Var.mNestedRecyclerView = null;
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, trim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(o.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e8);
            }
        }
    }

    private boolean didChildRangeChange(int i2, int i3) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i2 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i2 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(PKIFailureInfo.wrongIntegrity);
        c.h.k.e0.b.b(obtain, i2);
        sendAccessibilityEventUnchecked(obtain);
    }

    private void dispatchLayoutStep1() {
        boolean z2 = true;
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f2010j = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.f();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        b0 b0Var = this.mState;
        b0Var.f2009i = (b0Var.f2011k && this.mItemsChanged) ? false : false;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        b0Var.f2008h = b0Var.f2012l;
        b0Var.f2006f = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f2011k) {
            int g2 = this.mChildHelper.g();
            for (int i2 = 0; i2 < g2; i2++) {
                e0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i2));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.e(childViewHolderInt, this.mItemAnimator.t(this.mState, childViewHolderInt, l.e(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.f2009i && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.c(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f2012l) {
            saveOldPositions();
            b0 b0Var2 = this.mState;
            boolean z3 = b0Var2.f2007g;
            b0Var2.f2007g = false;
            this.mLayout.d1(this.mRecycler, b0Var2);
            this.mState.f2007g = z3;
            for (int i3 = 0; i3 < this.mChildHelper.g(); i3++) {
                e0 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.f(i3));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.i(childViewHolderInt2)) {
                    int e2 = l.e(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(PKIFailureInfo.certRevoked);
                    if (!hasAnyOfTheFlags) {
                        e2 |= 4096;
                    }
                    l.c t2 = this.mItemAnimator.t(this.mState, childViewHolderInt2, e2, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, t2);
                    } else {
                        this.mViewInfoStore.a(childViewHolderInt2, t2);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f2005e = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.j();
        this.mState.f2006f = this.mAdapter.getItemCount();
        b0 b0Var = this.mState;
        b0Var.f2004d = 0;
        b0Var.f2008h = false;
        this.mLayout.d1(this.mRecycler, b0Var);
        b0 b0Var2 = this.mState;
        b0Var2.f2007g = false;
        this.mPendingSavedState = null;
        b0Var2.f2011k = b0Var2.f2011k && this.mItemAnimator != null;
        b0Var2.f2005e = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        b0 b0Var = this.mState;
        b0Var.f2005e = 1;
        if (b0Var.f2011k) {
            for (int g2 = this.mChildHelper.g() - 1; g2 >= 0; g2--) {
                e0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(g2));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    l.c s2 = this.mItemAnimator.s(this.mState, childViewHolderInt);
                    e0 g3 = this.mViewInfoStore.g(changedHolderKey);
                    if (g3 != null && !g3.shouldIgnore()) {
                        boolean h2 = this.mViewInfoStore.h(g3);
                        boolean h3 = this.mViewInfoStore.h(childViewHolderInt);
                        if (h2 && g3 == childViewHolderInt) {
                            this.mViewInfoStore.d(childViewHolderInt, s2);
                        } else {
                            l.c n2 = this.mViewInfoStore.n(g3);
                            this.mViewInfoStore.d(childViewHolderInt, s2);
                            l.c m2 = this.mViewInfoStore.m(childViewHolderInt);
                            if (n2 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, g3);
                            } else {
                                animateChange(g3, childViewHolderInt, n2, m2, h2, h3);
                            }
                        }
                    } else {
                        this.mViewInfoStore.d(childViewHolderInt, s2);
                    }
                }
            }
            this.mViewInfoStore.o(this.mViewInfoProcessCallback);
        }
        this.mLayout.s1(this.mRecycler);
        b0 b0Var2 = this.mState;
        b0Var2.f2003c = b0Var2.f2006f;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        b0Var2.f2011k = false;
        b0Var2.f2012l = false;
        this.mLayout.f2033h = false;
        ArrayList<e0> arrayList = this.mRecycler.f2047b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.mLayout;
        if (oVar.p) {
            oVar.n = 0;
            oVar.p = false;
            this.mRecycler.K();
        }
        this.mLayout.e1(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.f();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        s sVar = this.mInterceptingOnItemTouchListener;
        if (sVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        sVar.onTouchEvent(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = this.mOnItemTouchListeners.get(i2);
            if (sVar.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = sVar;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int g2 = this.mChildHelper.g();
        if (g2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < g2; i4++) {
            e0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof RecyclerView) {
                return (RecyclerView) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
                if (findNestedRecyclerView != null) {
                    return findNestedRecyclerView;
                }
            }
            return null;
        }
        return null;
    }

    private View findNextViewToFocus() {
        e0 findViewHolderForAdapterPosition;
        b0 b0Var = this.mState;
        int i2 = b0Var.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int b2 = b0Var.b();
        for (int i3 = i2; i3 < b2; i3++) {
            e0 findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(b2, i2);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e0 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).a;
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f2040b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private c.h.k.l getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new c.h.k.l(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j2, e0 e0Var, e0 e0Var2) {
        int g2 = this.mChildHelper.g();
        for (int i2 = 0; i2 < g2; i2++) {
            e0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i2));
            if (childViewHolderInt != e0Var && getChangedHolderKey(childViewHolderInt) == j2) {
                g gVar = this.mAdapter;
                if (gVar != null && gVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + e0Var + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + e0Var + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + e0Var2 + " cannot be found but it is necessary for " + e0Var + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int g2 = this.mChildHelper.g();
        for (int i2 = 0; i2 < g2; i2++) {
            e0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (c.h.k.v.x(this) == 0) {
            c.h.k.v.u0(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new androidx.recyclerview.widget.f(new e());
    }

    private boolean isPreferredNextFocus(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c2 = 65535;
        int i4 = this.mLayout.i0() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i5 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i6 = rect2.left;
        if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
            i3 = 1;
        } else {
            int i7 = rect.right;
            int i8 = rect2.right;
            i3 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
            c2 = 1;
        } else {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if ((i11 <= i12 && i9 < i12) || i9 <= i10) {
                c2 = 0;
            }
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        } else if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        } else if (i2 == 17) {
            return i3 < 0;
        } else if (i2 == 33) {
            return c2 < 0;
        } else if (i2 == 66) {
            return i3 > 0;
        } else if (i2 == 130) {
            return c2 > 0;
        } else {
            throw new IllegalArgumentException("Invalid direction: " + i2 + exceptionLabel());
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.S1();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z2;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.y();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.Y0(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.w();
        } else {
            this.mAdapterHelper.j();
        }
        boolean z3 = false;
        boolean z4 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f2011k = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z2 = this.mDataSetHasChangedAfterLayout) || z4 || this.mLayout.f2033h) && (!z2 || this.mAdapter.hasStableIds());
        b0 b0Var = this.mState;
        if (b0Var.f2011k && z4 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z3 = true;
        }
        b0Var.f2012l = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r1 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            androidx.core.widget.d.a(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r1 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.d.a(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            androidx.core.widget.d.a(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            androidx.core.widget.d.a(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            c.h.k.v.b0(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recoverFocusFromState() {
        View findViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.mChildHelper.g() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.mChildHelper.n(focusedChild)) {
                return;
            }
        }
        View view = null;
        e0 findViewHolderForItemId = (this.mState.n == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.n);
        if (findViewHolderForItemId != null && !this.mChildHelper.n(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
            view = findViewHolderForItemId.itemView;
        } else if (this.mChildHelper.g() > 0) {
            view = findNextViewToFocus();
        }
        if (view != null) {
            int i2 = this.mState.o;
            if (i2 != -1 && (findViewById = view.findViewById(i2)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    private void releaseGlows() {
        boolean z2;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.mLeftGlow.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.mBottomGlow.isFinished();
        }
        if (z2) {
            c.h.k.v.b0(this);
        }
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f2041c) {
                Rect rect = pVar.f2040b;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.z1(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        b0 b0Var = this.mState;
        b0Var.n = -1L;
        b0Var.m = -1;
        b0Var.o = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        int adapterPosition;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        e0 findContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (findContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.n = this.mAdapter.hasStableIds() ? findContainingViewHolder.getItemId() : -1L;
        b0 b0Var = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            adapterPosition = -1;
        } else {
            adapterPosition = findContainingViewHolder.isRemoved() ? findContainingViewHolder.mOldPosition : findContainingViewHolder.getAdapterPosition();
        }
        b0Var.m = adapterPosition;
        this.mState.o = getDeepestFocusedViewWithId(findContainingViewHolder.itemView);
    }

    private void setAdapterInternal(g gVar, boolean z2, boolean z3) {
        g gVar2 = this.mAdapter;
        if (gVar2 != null) {
            gVar2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z2 || z3) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.y();
        g gVar3 = this.mAdapter;
        this.mAdapter = gVar;
        if (gVar != null) {
            gVar.registerAdapterDataObserver(this.mObserver);
            gVar.onAttachedToRecyclerView(this);
        }
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.K0(gVar3, this.mAdapter);
        }
        this.mRecycler.x(gVar3, this.mAdapter, z2);
        this.mState.f2007g = true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.g();
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.R1();
        }
    }

    void absorbGlows(int i2, int i3) {
        if (i2 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i3);
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        c.h.k.v.b0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        o oVar = this.mLayout;
        if (oVar == null || !oVar.L0(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void addItemDecoration(n nVar, int i2) {
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.q("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.mItemDecorations.add(nVar);
        } else {
            this.mItemDecorations.add(i2, nVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(q qVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(qVar);
    }

    public void addOnItemTouchListener(s sVar) {
        this.mOnItemTouchListeners.add(sVar);
    }

    public void addOnScrollListener(t tVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(tVar);
    }

    void animateAppearance(e0 e0Var, l.c cVar, l.c cVar2) {
        e0Var.setIsRecyclable(false);
        if (this.mItemAnimator.a(e0Var, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(e0 e0Var, l.c cVar, l.c cVar2) {
        addAnimatingView(e0Var);
        e0Var.setIsRecyclable(false);
        if (this.mItemAnimator.c(e0Var, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    boolean canReuseUpdatedViewHolder(e0 e0Var) {
        l lVar = this.mItemAnimator;
        return lVar == null || lVar.g(e0Var, e0Var.getUnmodifiedPayloads());
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.mLayout.w((p) layoutParams);
    }

    void clearOldPositions() {
        int j2 = this.mChildHelper.j();
        for (int i2 = 0; i2 < j2; i2++) {
            e0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.d();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<t> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.u()) {
            return this.mLayout.A(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.u()) {
            return this.mLayout.B(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.u()) {
            return this.mLayout.C(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.v()) {
            return this.mLayout.D(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.v()) {
            return this.mLayout.E(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.v()) {
            return this.mLayout.F(this.mState);
        }
        return 0;
    }

    void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.mLeftGlow.onRelease();
            z2 = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.mRightGlow.onRelease();
            z2 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.mTopGlow.onRelease();
            z2 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.mBottomGlow.onRelease();
            z2 |= this.mBottomGlow.isFinished();
        }
        if (z2) {
            c.h.k.v.b0(this);
        }
    }

    void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout) {
            if (this.mAdapterHelper.p()) {
                if (this.mAdapterHelper.o(4) && !this.mAdapterHelper.o(11)) {
                    androidx.core.os.f.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                    startInterceptRequestLayout();
                    onEnterLayoutOrScroll();
                    this.mAdapterHelper.w();
                    if (!this.mLayoutWasDefered) {
                        if (hasUpdatedView()) {
                            dispatchLayout();
                        } else {
                            this.mAdapterHelper.i();
                        }
                    }
                    stopInterceptRequestLayout(true);
                    onExitLayoutOrScroll();
                    androidx.core.os.f.b();
                    return;
                } else if (this.mAdapterHelper.p()) {
                    androidx.core.os.f.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                    dispatchLayout();
                    androidx.core.os.f.b();
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        androidx.core.os.f.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.f.b();
    }

    void defaultOnMeasure(int i2, int i3) {
        setMeasuredDimension(o.x(i2, getPaddingLeft() + getPaddingRight(), c.h.k.v.A(this)), o.x(i3, getPaddingTop() + getPaddingBottom(), c.h.k.v.z(this)));
    }

    void dispatchChildAttached(View view) {
        e0 childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        g gVar = this.mAdapter;
        if (gVar != null && childViewHolderInt != null) {
            gVar.onViewAttachedToWindow(childViewHolderInt);
        }
        List<q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).b(view);
            }
        }
    }

    void dispatchChildDetached(View view) {
        e0 childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        g gVar = this.mAdapter;
        if (gVar != null && childViewHolderInt != null) {
            gVar.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).a(view);
            }
        }
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            b0 b0Var = this.mState;
            b0Var.f2010j = false;
            if (b0Var.f2005e == 1) {
                dispatchLayoutStep1();
                this.mLayout.G1(this);
                dispatchLayoutStep2();
            } else if (!this.mAdapterHelper.q() && this.mLayout.t0() == getWidth() && this.mLayout.g0() == getHeight()) {
                this.mLayout.G1(this);
            } else {
                this.mLayout.G1(this);
                dispatchLayoutStep2();
            }
            dispatchLayoutStep3();
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().f(i2, i3, i4, i5, iArr);
    }

    void dispatchOnScrollStateChanged(int i2) {
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.k1(i2);
        }
        onScrollStateChanged(i2);
        t tVar = this.mScrollListener;
        if (tVar != null) {
            tVar.onScrollStateChanged(this, i2);
        }
        List<t> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i2);
            }
        }
    }

    void dispatchOnScrolled(int i2, int i3) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        onScrolled(i2, i3);
        t tVar = this.mScrollListener;
        if (tVar != null) {
            tVar.onScrolled(this, i2, i3);
        }
        List<t> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i2, i3);
            }
        }
        this.mDispatchScrollCounter--;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int i2;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            e0 e0Var = this.mPendingAccessibilityImportanceChange.get(size);
            if (e0Var.itemView.getParent() == this && !e0Var.shouldIgnore() && (i2 = e0Var.mPendingAccessibilityState) != -1) {
                c.h.k.v.t0(e0Var.itemView, i2);
                e0Var.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z4 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(save4);
        }
        if (z2 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.p()) {
            z4 = z2;
        }
        if (z4) {
            c.h.k.v.b0(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect a2 = this.mEdgeEffectFactory.a(this, 3);
        this.mBottomGlow = a2;
        if (this.mClipToPadding) {
            a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            a2.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect a2 = this.mEdgeEffectFactory.a(this, 0);
        this.mLeftGlow = a2;
        if (this.mClipToPadding) {
            a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            a2.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect a2 = this.mEdgeEffectFactory.a(this, 2);
        this.mRightGlow = a2;
        if (this.mClipToPadding) {
            a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            a2.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect a2 = this.mEdgeEffectFactory.a(this, 1);
        this.mTopGlow = a2;
        if (this.mClipToPadding) {
            a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            a2.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    final void fillRemainingScrollValues(b0 b0Var) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.f2014c;
            b0Var.p = overScroller.getFinalX() - overScroller.getCurrX();
            b0Var.q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        b0Var.p = 0;
        b0Var.q = 0;
    }

    public View findChildViewUnder(float f2, float f3) {
        for (int g2 = this.mChildHelper.g() - 1; g2 >= 0; g2--) {
            View f4 = this.mChildHelper.f(g2);
            float translationX = f4.getTranslationX();
            float translationY = f4.getTranslationY();
            if (f2 >= f4.getLeft() + translationX && f2 <= f4.getRight() + translationX && f3 >= f4.getTop() + translationY && f3 <= f4.getBottom() + translationY) {
                return f4;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View findContainingItemView(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    public e0 findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public e0 findViewHolderForAdapterPosition(int i2) {
        e0 e0Var = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int j2 = this.mChildHelper.j();
        for (int i3 = 0; i3 < j2; i3++) {
            e0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i2) {
                if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                e0Var = childViewHolderInt;
            }
        }
        return e0Var;
    }

    public e0 findViewHolderForItemId(long j2) {
        g gVar = this.mAdapter;
        e0 e0Var = null;
        if (gVar != null && gVar.hasStableIds()) {
            int j3 = this.mChildHelper.j();
            for (int i2 = 0; i2 < j3; i2++) {
                e0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i2));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j2) {
                    if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    e0Var = childViewHolderInt;
                }
            }
        }
        return e0Var;
    }

    public e0 findViewHolderForLayoutPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    @Deprecated
    public e0 findViewHolderForPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    public boolean fling(int i2, int i3) {
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.mLayoutSuppressed) {
            return false;
        } else {
            boolean u2 = oVar.u();
            boolean v2 = this.mLayout.v();
            if (!u2 || Math.abs(i2) < this.mMinFlingVelocity) {
                i2 = 0;
            }
            if (!v2 || Math.abs(i3) < this.mMinFlingVelocity) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            float f2 = i2;
            float f3 = i3;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z2 = u2 || v2;
                dispatchNestedFling(f2, f3, z2);
                if (this.mOnFlingListener != null) {
                    throw null;
                }
                if (z2) {
                    int i4 = u2 ? 1 : 0;
                    if (v2) {
                        i4 |= 2;
                    }
                    startNestedScroll(i4, 1);
                    int i5 = this.mMaxFlingVelocity;
                    int max = Math.max(-i5, Math.min(i2, i5));
                    int i6 = this.mMaxFlingVelocity;
                    this.mViewFlinger.c(max, Math.max(-i6, Math.min(i3, i6)));
                    return true;
                }
            }
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View W0 = this.mLayout.W0(view, i2);
        if (W0 != null) {
            return W0;
        }
        boolean z3 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i2 == 2 || i2 == 1)) {
            if (this.mLayout.v()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.mLayout.u()) {
                int i4 = (this.mLayout.i0() == 1) ^ (i2 == 2) ? 66 : 17;
                boolean z4 = focusFinder.findNextFocus(this, view, i4) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i4;
                }
                z2 = z4;
            }
            if (z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.P0(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (findNextFocus == null && z3) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.P0(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return isPreferredNextFocus(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        } else {
            requestChildOnScreen(view2, null);
            return view;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.N();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.O(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.mAdapter;
    }

    int getAdapterPositionFor(e0 e0Var) {
        if (e0Var.hasAnyOfTheFlags(524) || !e0Var.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.e(e0Var.mPosition);
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.Q();
        }
        return super.getBaseline();
    }

    long getChangedHolderKey(e0 e0Var) {
        return this.mAdapter.hasStableIds() ? e0Var.getItemId() : e0Var.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        e0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        j jVar = this.mChildDrawingOrderCallback;
        if (jVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return jVar.a(i2, i3);
    }

    public long getChildItemId(View view) {
        e0 childViewHolderInt;
        g gVar = this.mAdapter;
        if (gVar == null || !gVar.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        e0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public e0 getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return getChildViewHolderInt(view);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public androidx.recyclerview.widget.q getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public k getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public l getItemAnimator() {
        return this.mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f2041c) {
            return pVar.f2040b;
        }
        if (this.mState.e() && (pVar.b() || pVar.d())) {
            return pVar.f2040b;
        }
        Rect rect = pVar.f2040b;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i2).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i3 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f2041c = false;
        return rect;
    }

    public n getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            return this.mItemDecorations.get(i2);
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public o getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public u getRecycledViewPool() {
        return this.mRecycler.i();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.p();
    }

    void initAdapterManager() {
        this.mAdapterHelper = new androidx.recyclerview.widget.a(new f());
    }

    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.i(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(c.q.b.a), resources.getDimensionPixelSize(c.q.b.f3196c), resources.getDimensionPixelOffset(c.q.b.f3195b));
            return;
        }
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.q("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        l lVar = this.mItemAnimator;
        return lVar != null && lVar.p();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View, c.h.k.k
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    void jumpToPositionForSmoothScroller(int i2) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.E1(i2);
        awakenScrollBars();
    }

    void markItemDecorInsetsDirty() {
        int j2 = this.mChildHelper.j();
        for (int i2 = 0; i2 < j2; i2++) {
            ((p) this.mChildHelper.i(i2).getLayoutParams()).f2041c = true;
        }
        this.mRecycler.s();
    }

    void markKnownViewsInvalid() {
        int j2 = this.mChildHelper.j();
        for (int i2 = 0; i2 < j2; i2++) {
            e0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.t();
    }

    public void offsetChildrenHorizontal(int i2) {
        int g2 = this.mChildHelper.g();
        for (int i3 = 0; i3 < g2; i3++) {
            this.mChildHelper.f(i3).offsetLeftAndRight(i2);
        }
    }

    public void offsetChildrenVertical(int i2) {
        int g2 = this.mChildHelper.g();
        for (int i3 = 0; i3 < g2; i3++) {
            this.mChildHelper.f(i3).offsetTopAndBottom(i2);
        }
    }

    void offsetPositionRecordsForInsert(int i2, int i3) {
        int j2 = this.mChildHelper.j();
        for (int i4 = 0; i4 < j2; i4++) {
            e0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2) {
                childViewHolderInt.offsetPosition(i3, false);
                this.mState.f2007g = true;
            }
        }
        this.mRecycler.u(i2, i3);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int j2 = this.mChildHelper.j();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < j2; i8++) {
            e0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i8));
            if (childViewHolderInt != null && (i7 = childViewHolderInt.mPosition) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    childViewHolderInt.offsetPosition(i3 - i2, false);
                } else {
                    childViewHolderInt.offsetPosition(i6, false);
                }
                this.mState.f2007g = true;
            }
        }
        this.mRecycler.v(i2, i3);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int j2 = this.mChildHelper.j();
        for (int i5 = 0; i5 < j2; i5++) {
            e0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i6 = childViewHolderInt.mPosition;
                if (i6 >= i4) {
                    childViewHolderInt.offsetPosition(-i3, z2);
                    this.mState.f2007g = true;
                } else if (i6 >= i2) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i2 - 1, -i3, z2);
                    this.mState.f2007g = true;
                }
            }
        }
        this.mRecycler.w(i2, i3, z2);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean z2 = true;
        this.mIsAttached = true;
        if (!this.mFirstLayoutComplete || isLayoutRequested()) {
            z2 = false;
        }
        this.mFirstLayoutComplete = z2;
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.J(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            ThreadLocal<androidx.recyclerview.widget.j> threadLocal = androidx.recyclerview.widget.j.a;
            androidx.recyclerview.widget.j jVar = threadLocal.get();
            this.mGapWorker = jVar;
            if (jVar == null) {
                this.mGapWorker = new androidx.recyclerview.widget.j();
                Display s2 = c.h.k.v.s(this);
                float f2 = 60.0f;
                if (!isInEditMode() && s2 != null) {
                    float refreshRate = s2.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                androidx.recyclerview.widget.j jVar2 = this.mGapWorker;
                jVar2.f2181e = 1.0E9f / f2;
                threadLocal.set(jVar2);
            }
            this.mGapWorker.a(this);
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.j jVar;
        super.onDetachedFromWindow();
        l lVar = this.mItemAnimator;
        if (lVar != null) {
            lVar.k();
        }
        stopScroll();
        this.mIsAttached = false;
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.K(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.j();
        if (!ALLOW_THREAD_GAP_WORK || (jVar = this.mGapWorker) == null) {
            return;
        }
        jVar.j(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDraw(canvas, this, this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.mLayout
            boolean r0 = r0.v()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.mLayout
            boolean r3 = r3.u()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.mLayout
            boolean r3 = r3.v()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.mLayout
            boolean r3 = r3.u()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6c:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.scrollByInternal(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        o oVar = this.mLayout;
        if (oVar == null) {
            return false;
        }
        boolean u2 = oVar.u();
        boolean v2 = this.mLayout.v();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = u2;
            if (v2) {
                i2 = (u2 ? 1 : 0) | 2;
            }
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i3 = x3 - this.mInitialTouchX;
                int i4 = y3 - this.mInitialTouchY;
                if (!u2 || Math.abs(i3) <= this.mTouchSlop) {
                    z2 = false;
                } else {
                    this.mLastTouchX = x3;
                    z2 = true;
                }
                if (v2 && Math.abs(i4) > this.mTouchSlop) {
                    this.mLastTouchY = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y4;
            this.mInitialTouchY = y4;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        androidx.core.os.f.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.f.b();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        o oVar = this.mLayout;
        if (oVar == null) {
            defaultOnMeasure(i2, i3);
            return;
        }
        boolean z2 = false;
        if (oVar.x0()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.mLayout.f1(this.mRecycler, this.mState, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (z2 || this.mAdapter == null) {
                return;
            }
            if (this.mState.f2005e == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.H1(i2, i3);
            this.mState.f2010j = true;
            dispatchLayoutStep2();
            this.mLayout.K1(i2, i3);
            if (this.mLayout.N1()) {
                this.mLayout.H1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.f2010j = true;
                dispatchLayoutStep2();
                this.mLayout.K1(i2, i3);
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.f1(this.mRecycler, this.mState, i2, i3);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                b0 b0Var = this.mState;
                if (b0Var.f2012l) {
                    b0Var.f2008h = true;
                } else {
                    this.mAdapterHelper.j();
                    this.mState.f2008h = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.f2012l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            g gVar = this.mAdapter;
            if (gVar != null) {
                this.mState.f2006f = gVar.getItemCount();
            } else {
                this.mState.f2006f = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.f1(this.mRecycler, this.mState, i2, i3);
            stopInterceptRequestLayout(false);
            this.mState.f2008h = false;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        this.mPendingSavedState = yVar;
        super.onRestoreInstanceState(yVar.a());
        o oVar = this.mLayout;
        if (oVar == null || (parcelable2 = this.mPendingSavedState.f2055c) == null) {
            return;
        }
        oVar.i1(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.mPendingSavedState;
        if (yVar2 != null) {
            yVar.b(yVar2);
        } else {
            o oVar = this.mLayout;
            if (oVar != null) {
                yVar.f2055c = oVar.j1();
            } else {
                yVar.f2055c = null;
            }
        }
        return yVar;
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        invalidateGlows();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        c.h.k.v.c0(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    void processDataSetCompletelyChanged(boolean z2) {
        this.mDispatchItemsChangedEvent = z2 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void recordAnimationInfoIfBouncedHiddenView(e0 e0Var, l.c cVar) {
        e0Var.setFlags(0, PKIFailureInfo.certRevoked);
        if (this.mState.f2009i && e0Var.isUpdated() && !e0Var.isRemoved() && !e0Var.shouldIgnore()) {
            this.mViewInfoStore.c(getChangedHolderKey(e0Var), e0Var);
        }
        this.mViewInfoStore.e(e0Var, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeAndRecycleViews() {
        l lVar = this.mItemAnimator;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.r1(this.mRecycler);
            this.mLayout.s1(this.mRecycler);
        }
        this.mRecycler.c();
    }

    boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean r2 = this.mChildHelper.r(view);
        if (r2) {
            e0 childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.J(childViewHolderInt);
            this.mRecycler.C(childViewHolderInt);
        }
        stopInterceptRequestLayout(!r2);
        return r2;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z2) {
        e0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z2);
    }

    public void removeItemDecoration(n nVar) {
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.q("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(nVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i2));
            return;
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(q qVar) {
        List<q> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(qVar);
    }

    public void removeOnItemTouchListener(s sVar) {
        this.mOnItemTouchListeners.remove(sVar);
        if (this.mInterceptingOnItemTouchListener == sVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(t tVar) {
        List<t> list = this.mScrollListeners;
        if (list != null) {
            list.remove(tVar);
        }
    }

    void repositionShadowingViews() {
        e0 e0Var;
        int g2 = this.mChildHelper.g();
        for (int i2 = 0; i2 < g2; i2++) {
            View f2 = this.mChildHelper.f(i2);
            e0 childViewHolder = getChildViewHolder(f2);
            if (childViewHolder != null && (e0Var = childViewHolder.mShadowingHolder) != null) {
                View view = e0Var.itemView;
                int left = f2.getLeft();
                int top = f2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.h1(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.mLayout.y1(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mOnItemTouchListeners.get(i2).onRequestDisallowInterceptTouchEvent(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutSuppressed) {
            super.requestLayout();
        } else {
            this.mLayoutWasDefered = true;
        }
    }

    void saveOldPositions() {
        int j2 = this.mChildHelper.j();
        for (int i2 = 0; i2 < j2; i2++) {
            e0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            boolean u2 = oVar.u();
            boolean v2 = this.mLayout.v();
            if (u2 || v2) {
                if (!u2) {
                    i2 = 0;
                }
                if (!v2) {
                    i3 = 0;
                }
                scrollByInternal(i2, i3, null);
            }
        }
    }

    boolean scrollByInternal(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i2, i3, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i4 = i9;
            i5 = i8;
            i6 = i2 - i8;
            i7 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i5, i4, i6, i7, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i10 = i6 - iArr4[0];
        int i11 = i7 - iArr4[1];
        boolean z2 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i12 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i12 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !c.h.k.i.a(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i10, motionEvent.getY(), i11);
            }
            considerReleasingGlowsOnScroll(i2, i3);
        }
        if (i5 != 0 || i4 != 0) {
            dispatchOnScrolled(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z2 && i5 == 0 && i4 == 0) ? false : true;
    }

    void scrollStep(int i2, int i3, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        androidx.core.os.f.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int D1 = i2 != 0 ? this.mLayout.D1(i2, this.mRecycler, this.mState) : 0;
        int F1 = i3 != 0 ? this.mLayout.F1(i3, this.mRecycler, this.mState) : 0;
        androidx.core.os.f.b();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = D1;
            iArr[1] = F1;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        oVar.E1(i2);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.q qVar) {
        this.mAccessibilityDelegate = qVar;
        c.h.k.v.k0(this, qVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        setAdapterInternal(gVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = jVar;
        setChildrenDrawingOrderEnabled(jVar != null);
    }

    boolean setChildImportantForAccessibilityInternal(e0 e0Var, int i2) {
        if (isComputingLayout()) {
            e0Var.mPendingAccessibilityState = i2;
            this.mPendingAccessibilityImportanceChange.add(e0Var);
            return false;
        }
        c.h.k.v.t0(e0Var.itemView, i2);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z2;
        super.setClipToPadding(z2);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        androidx.core.util.h.b(kVar);
        this.mEdgeEffectFactory = kVar;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z2) {
        this.mHasFixedSize = z2;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.mItemAnimator;
        if (lVar2 != null) {
            lVar2.k();
            this.mItemAnimator.v(null);
        }
        this.mItemAnimator = lVar;
        if (lVar != null) {
            lVar.v(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.mRecycler.G(i2);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            l lVar = this.mItemAnimator;
            if (lVar != null) {
                lVar.k();
            }
            this.mLayout.r1(this.mRecycler);
            this.mLayout.s1(this.mRecycler);
            this.mRecycler.c();
            if (this.mIsAttached) {
                this.mLayout.K(this, this.mRecycler);
            }
            this.mLayout.L1(null);
            this.mLayout = null;
        } else {
            this.mRecycler.c();
        }
        this.mChildHelper.o();
        this.mLayout = oVar;
        if (oVar != null) {
            if (oVar.f2027b == null) {
                oVar.L1(this);
                if (this.mIsAttached) {
                    this.mLayout.J(this);
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f2027b.exceptionLabel());
            }
        }
        this.mRecycler.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View, c.h.k.k
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().n(z2);
    }

    public void setOnFlingListener(r rVar) {
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.mScrollListener = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.mPreserveFocusAfterLayout = z2;
    }

    public void setRecycledViewPool(u uVar) {
        this.mRecycler.E(uVar);
    }

    public void setRecyclerListener(w wVar) {
        this.mRecyclerListener = wVar;
    }

    void setScrollState(int i2) {
        if (i2 == this.mScrollState) {
            return;
        }
        this.mScrollState = i2;
        if (i2 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(c0 c0Var) {
        this.mRecycler.F(c0Var);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (isComputingLayout()) {
            int a2 = accessibilityEvent != null ? c.h.k.e0.b.a(accessibilityEvent) : 0;
            this.mEatenAccessibilityChangeFlags |= a2 != 0 ? a2 : 0;
            return true;
        }
        return false;
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, null);
    }

    public void smoothScrollToPosition(int i2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.P1(this, this.mState, i2);
        }
    }

    void startInterceptRequestLayout() {
        int i2 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i2;
        if (i2 != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().p(i2);
    }

    void stopInterceptRequestLayout(boolean z2) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z2 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z2 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View, c.h.k.k
    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.mLayoutSuppressed = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void swapAdapter(g gVar, boolean z2) {
        setLayoutFrozen(false);
        setAdapterInternal(gVar, true, z2);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    void viewRangeUpdate(int i2, int i3, Object obj) {
        int i4;
        int j2 = this.mChildHelper.j();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < j2; i6++) {
            View i7 = this.mChildHelper.i(i6);
            e0 childViewHolderInt = getChildViewHolderInt(i7);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i4 = childViewHolderInt.mPosition) >= i2 && i4 < i5) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((p) i7.getLayoutParams()).f2041c = true;
            }
        }
        this.mRecycler.M(i2, i3);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.q.a.a);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().d(i2, i3, iArr, iArr2, i4);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().g(i2, i3, i4, i5, iArr, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.recyclerview.widget.RecyclerView.e0 findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.f r0 = r5.mChildHelper
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.f r3 = r5.mChildHelper
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$e0 r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.f r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$e0");
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().l(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onExitLayoutOrScroll(boolean z2) {
        int i2 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i2;
        if (i2 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z2) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        smoothScrollBy(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().q(i2, i3);
    }

    @Override // c.h.k.j
    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().s(i2);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mObserver = new x();
        this.mRecycler = new v();
        this.mViewInfoStore = new androidx.recyclerview.widget.u();
        this.mUpdateChildViewsRunnable = new a();
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new k();
        this.mItemAnimator = new androidx.recyclerview.widget.g();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z2 = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new d0();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new j.b() : null;
        this.mState = new b0();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new m();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new b();
        this.mViewInfoProcessCallback = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = c.h.k.w.b(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = c.h.k.w.d(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.v(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (c.h.k.v.w(this) == 0) {
            c.h.k.v.t0(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.q(this));
        int[] iArr = c.q.c.f3201f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        }
        String string = obtainStyledAttributes.getString(c.q.c.o);
        if (obtainStyledAttributes.getInt(c.q.c.f3204i, -1) == -1) {
            setDescendantFocusability(PKIFailureInfo.transactionIdInUse);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(c.q.c.f3203h, true);
        boolean z3 = obtainStyledAttributes.getBoolean(c.q.c.f3205j, false);
        this.mEnableFastScroller = z3;
        if (z3) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(c.q.c.m), obtainStyledAttributes.getDrawable(c.q.c.n), (StateListDrawable) obtainStyledAttributes.getDrawable(c.q.c.f3206k), obtainStyledAttributes.getDrawable(c.q.c.f3207l));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i2, 0);
        if (i3 >= 21) {
            int[] iArr2 = NESTED_SCROLLING_ATTRS;
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i2, 0);
            if (i3 >= 29) {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes2, i2, 0);
            }
            z2 = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z2);
    }

    public final void dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4) {
        smoothScrollBy(i2, i3, interpolator, i4, false);
    }

    /* loaded from: classes.dex */
    public static class p extends ViewGroup.MarginLayoutParams {
        e0 a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f2040b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2041c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2042d;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2040b = new Rect();
            this.f2041c = true;
            this.f2042d = false;
        }

        public int a() {
            return this.a.getLayoutPosition();
        }

        public boolean b() {
            return this.a.isUpdated();
        }

        public boolean c() {
            return this.a.isRemoved();
        }

        public boolean d() {
            return this.a.isInvalid();
        }

        public p(int i2, int i3) {
            super(i2, i3);
            this.f2040b = new Rect();
            this.f2041c = true;
            this.f2042d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2040b = new Rect();
            this.f2041c = true;
            this.f2042d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2040b = new Rect();
            this.f2041c = true;
            this.f2042d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f2040b = new Rect();
            this.f2041c = true;
            this.f2042d = false;
        }
    }

    /* loaded from: classes.dex */
    public static class y extends c.j.a.a {
        public static final Parcelable.Creator<y> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        Parcelable f2055c;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<y> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public y createFromParcel(Parcel parcel) {
                return new y(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new y(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public y[] newArray(int i2) {
                return new y[i2];
            }
        }

        y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2055c = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        void b(y yVar) {
            this.f2055c = yVar.f2055c;
        }

        @Override // c.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f2055c, 0);
        }

        y(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.P(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            if (!oVar.u()) {
                i2 = 0;
            }
            if (!this.mLayout.v()) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return;
            }
            if (i4 == Integer.MIN_VALUE || i4 > 0) {
                if (z2) {
                    int i5 = i2 != 0 ? 1 : 0;
                    if (i3 != 0) {
                        i5 |= 2;
                    }
                    startNestedScroll(i5, 1);
                }
                this.mViewFlinger.f(i2, i3, i4, interpolator);
                return;
            }
            scrollBy(i2, i3);
        }
    }

    public void addItemDecoration(n nVar) {
        addItemDecoration(nVar, -1);
    }
}