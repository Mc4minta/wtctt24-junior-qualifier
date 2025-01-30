package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.r;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;
import c.f.b.k.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements c.h.k.n {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    boolean firstDown;
    private float lastPos;
    private float lastY;
    private long mAnimationStartTime;
    private int mBeginState;
    private RectF mBoundsCheck;
    int mCurrentState;
    int mDebugPath;
    private c mDecelerateLogic;
    private androidx.constraintlayout.motion.widget.b mDesignTool;
    d mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    HashMap<View, n> mFrameArrayList;
    private int mFrames;
    int mHeightMeasureMode;
    private boolean mInLayout;
    boolean mInTransition;
    boolean mIndirectTransition;
    private boolean mInteractionEnabled;
    Interpolator mInterpolator;
    boolean mIsAnimating;
    private boolean mKeepAnimating;
    private androidx.constraintlayout.motion.widget.e mKeyCache;
    private long mLastDrawTime;
    private float mLastFps;
    private int mLastHeightMeasureSpec;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    float mLastVelocity;
    private int mLastWidthMeasureSpec;
    private float mListenerPosition;
    private int mListenerState;
    protected boolean mMeasureDuringTransition;
    e mModel;
    private boolean mNeedsFireTransitionCompleted;
    int mOldHeight;
    int mOldWidth;
    private ArrayList<o> mOnHideHelpers;
    private ArrayList<o> mOnShowHelpers;
    float mPostInterpolationPosition;
    private View mRegionView;
    r mScene;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private h mStateCache;
    private c.f.a.a.g mStopLogic;
    private boolean mTemporalInterpolator;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private i mTransitionListener;
    private ArrayList<i> mTransitionListeners;
    float mTransitionPosition;
    j mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setNestedScrollingEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j.values().length];
            a = iArr;
            try {
                iArr[j.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[j.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[j.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends p {
        float a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        float f1043b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        float f1044c;

        c() {
        }

        @Override // androidx.constraintlayout.motion.widget.p
        public float a() {
            return MotionLayout.this.mLastVelocity;
        }

        public void b(float f2, float f3, float f4) {
            this.a = f2;
            this.f1043b = f3;
            this.f1044c = f4;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3;
            float f4;
            float f5 = this.a;
            if (f5 > 0.0f) {
                float f6 = this.f1044c;
                if (f5 / f6 < f2) {
                    f2 = f5 / f6;
                }
                MotionLayout.this.mLastVelocity = f5 - (f6 * f2);
                f3 = (f5 * f2) - (((f6 * f2) * f2) / 2.0f);
                f4 = this.f1043b;
            } else {
                float f7 = this.f1044c;
                if ((-f5) / f7 < f2) {
                    f2 = (-f5) / f7;
                }
                MotionLayout.this.mLastVelocity = (f7 * f2) + f5;
                f3 = (f5 * f2) + (((f7 * f2) * f2) / 2.0f);
                f4 = this.f1043b;
            }
            return f3 + f4;
        }
    }

    /* loaded from: classes.dex */
    private class d {
        float[] a;

        /* renamed from: b  reason: collision with root package name */
        int[] f1046b;

        /* renamed from: c  reason: collision with root package name */
        float[] f1047c;

        /* renamed from: d  reason: collision with root package name */
        Path f1048d;

        /* renamed from: e  reason: collision with root package name */
        Paint f1049e;

        /* renamed from: f  reason: collision with root package name */
        Paint f1050f;

        /* renamed from: g  reason: collision with root package name */
        Paint f1051g;

        /* renamed from: h  reason: collision with root package name */
        Paint f1052h;

        /* renamed from: i  reason: collision with root package name */
        Paint f1053i;

        /* renamed from: j  reason: collision with root package name */
        private float[] f1054j;
        DashPathEffect p;
        int q;
        int t;

        /* renamed from: k  reason: collision with root package name */
        final int f1055k = -21965;

        /* renamed from: l  reason: collision with root package name */
        final int f1056l = -2067046;
        final int m = -13391360;
        final int n = 1996488704;
        final int o = 10;
        Rect r = new Rect();
        boolean s = false;

        public d() {
            this.t = 1;
            Paint paint = new Paint();
            this.f1049e = paint;
            paint.setAntiAlias(true);
            this.f1049e.setColor(-21965);
            this.f1049e.setStrokeWidth(2.0f);
            this.f1049e.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f1050f = paint2;
            paint2.setAntiAlias(true);
            this.f1050f.setColor(-2067046);
            this.f1050f.setStrokeWidth(2.0f);
            this.f1050f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.f1051g = paint3;
            paint3.setAntiAlias(true);
            this.f1051g.setColor(-13391360);
            this.f1051g.setStrokeWidth(2.0f);
            this.f1051g.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.f1052h = paint4;
            paint4.setAntiAlias(true);
            this.f1052h.setColor(-13391360);
            this.f1052h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f1054j = new float[8];
            Paint paint5 = new Paint();
            this.f1053i = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.p = dashPathEffect;
            this.f1051g.setPathEffect(dashPathEffect);
            this.f1047c = new float[100];
            this.f1046b = new int[50];
            if (this.s) {
                this.f1049e.setStrokeWidth(8.0f);
                this.f1053i.setStrokeWidth(8.0f);
                this.f1050f.setStrokeWidth(8.0f);
                this.t = 4;
            }
        }

        private void c(Canvas canvas) {
            canvas.drawLines(this.a, this.f1049e);
        }

        private void d(Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.q; i2++) {
                int[] iArr = this.f1046b;
                if (iArr[i2] == 1) {
                    z = true;
                }
                if (iArr[i2] == 2) {
                    z2 = true;
                }
            }
            if (z) {
                g(canvas);
            }
            if (z2) {
                e(canvas);
            }
        }

        private void e(Canvas canvas) {
            float[] fArr = this.a;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[fArr.length - 2];
            float f5 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f2, f4), Math.max(f3, f5), Math.max(f2, f4), Math.max(f3, f5), this.f1051g);
            canvas.drawLine(Math.min(f2, f4), Math.min(f3, f5), Math.min(f2, f4), Math.max(f3, f5), this.f1051g);
        }

        private void f(Canvas canvas, float f2, float f3) {
            float[] fArr = this.a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float min = Math.min(f4, f6);
            float max = Math.max(f5, f7);
            float min2 = f2 - Math.min(f4, f6);
            float max2 = Math.max(f5, f7) - f3;
            String str = "" + (((int) (((min2 * 100.0f) / Math.abs(f6 - f4)) + 0.5d)) / 100.0f);
            l(str, this.f1052h);
            canvas.drawText(str, ((min2 / 2.0f) - (this.r.width() / 2)) + min, f3 - 20.0f, this.f1052h);
            canvas.drawLine(f2, f3, Math.min(f4, f6), f3, this.f1051g);
            String str2 = "" + (((int) (((max2 * 100.0f) / Math.abs(f7 - f5)) + 0.5d)) / 100.0f);
            l(str2, this.f1052h);
            canvas.drawText(str2, f2 + 5.0f, max - ((max2 / 2.0f) - (this.r.height() / 2)), this.f1052h);
            canvas.drawLine(f2, f3, f2, Math.max(f5, f7), this.f1051g);
        }

        private void g(Canvas canvas) {
            float[] fArr = this.a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f1051g);
        }

        private void h(Canvas canvas, float f2, float f3) {
            float[] fArr = this.a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot(f4 - f6, f5 - f7);
            float f8 = f6 - f4;
            float f9 = f7 - f5;
            float f10 = (((f2 - f4) * f8) + ((f3 - f5) * f9)) / (hypot * hypot);
            float f11 = f4 + (f8 * f10);
            float f12 = f5 + (f10 * f9);
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f11, f12);
            float hypot2 = (float) Math.hypot(f11 - f2, f12 - f3);
            String str = "" + (((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
            l(str, this.f1052h);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - (this.r.width() / 2), -20.0f, this.f1052h);
            canvas.drawLine(f2, f3, f11, f12, this.f1051g);
        }

        private void i(Canvas canvas, float f2, float f3, int i2, int i3) {
            String str = "" + (((int) ((((f2 - (i2 / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i2)) + 0.5d)) / 100.0f);
            l(str, this.f1052h);
            canvas.drawText(str, ((f2 / 2.0f) - (this.r.width() / 2)) + 0.0f, f3 - 20.0f, this.f1052h);
            canvas.drawLine(f2, f3, Math.min(0.0f, 1.0f), f3, this.f1051g);
            String str2 = "" + (((int) ((((f3 - (i3 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i3)) + 0.5d)) / 100.0f);
            l(str2, this.f1052h);
            canvas.drawText(str2, f2 + 5.0f, 0.0f - ((f3 / 2.0f) - (this.r.height() / 2)), this.f1052h);
            canvas.drawLine(f2, f3, f2, Math.max(0.0f, 1.0f), this.f1051g);
        }

        private void j(Canvas canvas, n nVar) {
            this.f1048d.reset();
            for (int i2 = 0; i2 <= 50; i2++) {
                nVar.e(i2 / 50, this.f1054j, 0);
                Path path = this.f1048d;
                float[] fArr = this.f1054j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f1048d;
                float[] fArr2 = this.f1054j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f1048d;
                float[] fArr3 = this.f1054j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f1048d;
                float[] fArr4 = this.f1054j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f1048d.close();
            }
            this.f1049e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f1048d, this.f1049e);
            canvas.translate(-2.0f, -2.0f);
            this.f1049e.setColor(-65536);
            canvas.drawPath(this.f1048d, this.f1049e);
        }

        private void k(Canvas canvas, int i2, int i3, n nVar) {
            int i4;
            int i5;
            int i6;
            float f2;
            float f3;
            View view = nVar.a;
            if (view != null) {
                i4 = view.getWidth();
                i5 = nVar.a.getHeight();
            } else {
                i4 = 0;
                i5 = 0;
            }
            for (int i7 = 1; i7 < i3 - 1; i7++) {
                if (i2 != 4 || this.f1046b[i7 - 1] != 0) {
                    float[] fArr = this.f1047c;
                    int i8 = i7 * 2;
                    float f4 = fArr[i8];
                    float f5 = fArr[i8 + 1];
                    this.f1048d.reset();
                    this.f1048d.moveTo(f4, f5 + 10.0f);
                    this.f1048d.lineTo(f4 + 10.0f, f5);
                    this.f1048d.lineTo(f4, f5 - 10.0f);
                    this.f1048d.lineTo(f4 - 10.0f, f5);
                    this.f1048d.close();
                    int i9 = i7 - 1;
                    nVar.k(i9);
                    if (i2 == 4) {
                        int[] iArr = this.f1046b;
                        if (iArr[i9] == 1) {
                            h(canvas, f4 - 0.0f, f5 - 0.0f);
                        } else if (iArr[i9] == 2) {
                            f(canvas, f4 - 0.0f, f5 - 0.0f);
                        } else if (iArr[i9] == 3) {
                            i6 = 3;
                            f2 = f5;
                            f3 = f4;
                            i(canvas, f4 - 0.0f, f5 - 0.0f, i4, i5);
                            canvas.drawPath(this.f1048d, this.f1053i);
                        }
                        i6 = 3;
                        f2 = f5;
                        f3 = f4;
                        canvas.drawPath(this.f1048d, this.f1053i);
                    } else {
                        i6 = 3;
                        f2 = f5;
                        f3 = f4;
                    }
                    if (i2 == 2) {
                        h(canvas, f3 - 0.0f, f2 - 0.0f);
                    }
                    if (i2 == i6) {
                        f(canvas, f3 - 0.0f, f2 - 0.0f);
                    }
                    if (i2 == 6) {
                        i(canvas, f3 - 0.0f, f2 - 0.0f, i4, i5);
                    }
                    canvas.drawPath(this.f1048d, this.f1053i);
                }
            }
            float[] fArr2 = this.a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f1050f);
                float[] fArr3 = this.a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f1050f);
            }
        }

        public void a(Canvas canvas, HashMap<View, n> hashMap, int i2, int i3) {
            if (hashMap == null || hashMap.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (i3 & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.mEndState) + ":" + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.f1052h);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.f1049e);
            }
            for (n nVar : hashMap.values()) {
                int h2 = nVar.h();
                if (i3 > 0 && h2 == 0) {
                    h2 = 1;
                }
                if (h2 != 0) {
                    this.q = nVar.c(this.f1047c, this.f1046b);
                    if (h2 >= 1) {
                        int i4 = i2 / 16;
                        float[] fArr = this.a;
                        if (fArr == null || fArr.length != i4 * 2) {
                            this.a = new float[i4 * 2];
                            this.f1048d = new Path();
                        }
                        int i5 = this.t;
                        canvas.translate(i5, i5);
                        this.f1049e.setColor(1996488704);
                        this.f1053i.setColor(1996488704);
                        this.f1050f.setColor(1996488704);
                        this.f1051g.setColor(1996488704);
                        nVar.d(this.a, i4);
                        b(canvas, h2, this.q, nVar);
                        this.f1049e.setColor(-21965);
                        this.f1050f.setColor(-2067046);
                        this.f1053i.setColor(-2067046);
                        this.f1051g.setColor(-13391360);
                        int i6 = this.t;
                        canvas.translate(-i6, -i6);
                        b(canvas, h2, this.q, nVar);
                        if (h2 == 5) {
                            j(canvas, nVar);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void b(Canvas canvas, int i2, int i3, n nVar) {
            if (i2 == 4) {
                d(canvas);
            }
            if (i2 == 2) {
                g(canvas);
            }
            if (i2 == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i2, i3, nVar);
        }

        void l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e {
        c.f.b.k.f a = new c.f.b.k.f();

        /* renamed from: b  reason: collision with root package name */
        c.f.b.k.f f1057b = new c.f.b.k.f();

        /* renamed from: c  reason: collision with root package name */
        androidx.constraintlayout.widget.d f1058c = null;

        /* renamed from: d  reason: collision with root package name */
        androidx.constraintlayout.widget.d f1059d = null;

        /* renamed from: e  reason: collision with root package name */
        int f1060e;

        /* renamed from: f  reason: collision with root package name */
        int f1061f;

        e() {
        }

        private void i(c.f.b.k.f fVar, androidx.constraintlayout.widget.d dVar) {
            SparseArray<c.f.b.k.e> sparseArray = new SparseArray<>();
            e.a aVar = new e.a(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, fVar);
            sparseArray.put(MotionLayout.this.getId(), fVar);
            Iterator<c.f.b.k.e> it = fVar.L0().iterator();
            while (it.hasNext()) {
                c.f.b.k.e next = it.next();
                sparseArray.put(((View) next.r()).getId(), next);
            }
            Iterator<c.f.b.k.e> it2 = fVar.L0().iterator();
            while (it2.hasNext()) {
                c.f.b.k.e next2 = it2.next();
                View view = (View) next2.r();
                dVar.g(view.getId(), aVar);
                next2.F0(dVar.w(view.getId()));
                next2.i0(dVar.r(view.getId()));
                if (view instanceof androidx.constraintlayout.widget.b) {
                    dVar.e((androidx.constraintlayout.widget.b) view, next2, aVar, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).q();
                    }
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    aVar.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                } else {
                    aVar.resolveLayoutDirection(0);
                }
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, aVar, sparseArray);
                if (dVar.v(view.getId()) == 1) {
                    next2.E0(view.getVisibility());
                } else {
                    next2.E0(dVar.u(view.getId()));
                }
            }
            Iterator<c.f.b.k.e> it3 = fVar.L0().iterator();
            while (it3.hasNext()) {
                c.f.b.k.e next3 = it3.next();
                if (next3 instanceof c.f.b.k.l) {
                    c.f.b.k.i iVar = (c.f.b.k.i) next3;
                    ((androidx.constraintlayout.widget.b) next3.r()).o(fVar, iVar, sparseArray);
                    ((c.f.b.k.l) iVar).M0();
                }
            }
        }

        public void a() {
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.mFrameArrayList.clear();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = MotionLayout.this.getChildAt(i2);
                MotionLayout.this.mFrameArrayList.put(childAt, new n(childAt));
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = MotionLayout.this.getChildAt(i3);
                n nVar = MotionLayout.this.mFrameArrayList.get(childAt2);
                if (nVar != null) {
                    if (this.f1058c != null) {
                        c.f.b.k.e c2 = c(this.a, childAt2);
                        if (c2 != null) {
                            nVar.t(c2, this.f1058c);
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            Log.e(MotionLayout.TAG, androidx.constraintlayout.motion.widget.a.a() + "no widget for  " + androidx.constraintlayout.motion.widget.a.c(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                    if (this.f1059d != null) {
                        c.f.b.k.e c3 = c(this.f1057b, childAt2);
                        if (c3 != null) {
                            nVar.q(c3, this.f1059d);
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            Log.e(MotionLayout.TAG, androidx.constraintlayout.motion.widget.a.a() + "no widget for  " + androidx.constraintlayout.motion.widget.a.c(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                }
            }
        }

        void b(c.f.b.k.f fVar, c.f.b.k.f fVar2) {
            c.f.b.k.e eVar;
            ArrayList<c.f.b.k.e> L0 = fVar.L0();
            HashMap<c.f.b.k.e, c.f.b.k.e> hashMap = new HashMap<>();
            hashMap.put(fVar, fVar2);
            fVar2.L0().clear();
            fVar2.l(fVar, hashMap);
            Iterator<c.f.b.k.e> it = L0.iterator();
            while (it.hasNext()) {
                c.f.b.k.e next = it.next();
                if (next instanceof c.f.b.k.a) {
                    eVar = new c.f.b.k.a();
                } else if (next instanceof c.f.b.k.h) {
                    eVar = new c.f.b.k.h();
                } else if (next instanceof c.f.b.k.g) {
                    eVar = new c.f.b.k.g();
                } else if (next instanceof c.f.b.k.i) {
                    eVar = new c.f.b.k.j();
                } else {
                    eVar = new c.f.b.k.e();
                }
                fVar2.a(eVar);
                hashMap.put(next, eVar);
            }
            Iterator<c.f.b.k.e> it2 = L0.iterator();
            while (it2.hasNext()) {
                c.f.b.k.e next2 = it2.next();
                hashMap.get(next2).l(next2, hashMap);
            }
        }

        c.f.b.k.e c(c.f.b.k.f fVar, View view) {
            if (fVar.r() == view) {
                return fVar;
            }
            ArrayList<c.f.b.k.e> L0 = fVar.L0();
            int size = L0.size();
            for (int i2 = 0; i2 < size; i2++) {
                c.f.b.k.e eVar = L0.get(i2);
                if (eVar.r() == view) {
                    return eVar;
                }
            }
            return null;
        }

        void d(c.f.b.k.f fVar, androidx.constraintlayout.widget.d dVar, androidx.constraintlayout.widget.d dVar2) {
            this.f1058c = dVar;
            this.f1059d = dVar2;
            this.a = new c.f.b.k.f();
            this.f1057b = new c.f.b.k.f();
            this.a.i1(((ConstraintLayout) MotionLayout.this).mLayoutWidget.X0());
            this.f1057b.i1(((ConstraintLayout) MotionLayout.this).mLayoutWidget.X0());
            this.a.O0();
            this.f1057b.O0();
            b(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.a);
            b(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.f1057b);
            if (MotionLayout.this.mTransitionLastPosition > 0.5d) {
                if (dVar != null) {
                    i(this.a, dVar);
                }
                i(this.f1057b, dVar2);
            } else {
                i(this.f1057b, dVar2);
                if (dVar != null) {
                    i(this.a, dVar);
                }
            }
            this.a.k1(MotionLayout.this.isRtl());
            this.a.m1();
            this.f1057b.k1(MotionLayout.this.isRtl());
            this.f1057b.m1();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    c.f.b.k.f fVar2 = this.a;
                    e.b bVar = e.b.WRAP_CONTENT;
                    fVar2.m0(bVar);
                    this.f1057b.m0(bVar);
                }
                if (layoutParams.height == -2) {
                    c.f.b.k.f fVar3 = this.a;
                    e.b bVar2 = e.b.WRAP_CONTENT;
                    fVar3.B0(bVar2);
                    this.f1057b.B0(bVar2);
                }
            }
        }

        public boolean e(int i2, int i3) {
            return (i2 == this.f1060e && i3 == this.f1061f) ? false : true;
        }

        public void f(int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.mWidthMeasureMode = mode;
            motionLayout.mHeightMeasureMode = mode2;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            MotionLayout motionLayout2 = MotionLayout.this;
            if (motionLayout2.mCurrentState == motionLayout2.getStartState()) {
                MotionLayout.this.resolveSystem(this.f1057b, optimizationLevel, i2, i3);
                if (this.f1058c != null) {
                    MotionLayout.this.resolveSystem(this.a, optimizationLevel, i2, i3);
                }
            } else {
                if (this.f1058c != null) {
                    MotionLayout.this.resolveSystem(this.a, optimizationLevel, i2, i3);
                }
                MotionLayout.this.resolveSystem(this.f1057b, optimizationLevel, i2, i3);
            }
            boolean z = false;
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                MotionLayout motionLayout3 = MotionLayout.this;
                motionLayout3.mWidthMeasureMode = mode;
                motionLayout3.mHeightMeasureMode = mode2;
                if (motionLayout3.mCurrentState == motionLayout3.getStartState()) {
                    MotionLayout.this.resolveSystem(this.f1057b, optimizationLevel, i2, i3);
                    if (this.f1058c != null) {
                        MotionLayout.this.resolveSystem(this.a, optimizationLevel, i2, i3);
                    }
                } else {
                    if (this.f1058c != null) {
                        MotionLayout.this.resolveSystem(this.a, optimizationLevel, i2, i3);
                    }
                    MotionLayout.this.resolveSystem(this.f1057b, optimizationLevel, i2, i3);
                }
                MotionLayout.this.mStartWrapWidth = this.a.Q();
                MotionLayout.this.mStartWrapHeight = this.a.w();
                MotionLayout.this.mEndWrapWidth = this.f1057b.Q();
                MotionLayout.this.mEndWrapHeight = this.f1057b.w();
                MotionLayout motionLayout4 = MotionLayout.this;
                motionLayout4.mMeasureDuringTransition = (motionLayout4.mStartWrapWidth == motionLayout4.mEndWrapWidth && motionLayout4.mStartWrapHeight == motionLayout4.mEndWrapHeight) ? false : true;
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            int i4 = motionLayout5.mStartWrapWidth;
            int i5 = motionLayout5.mStartWrapHeight;
            int i6 = motionLayout5.mWidthMeasureMode;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                i4 = (int) (i4 + (motionLayout5.mPostInterpolationPosition * (motionLayout5.mEndWrapWidth - i4)));
            }
            int i7 = motionLayout5.mHeightMeasureMode;
            if (i7 == Integer.MIN_VALUE || i7 == 0) {
                i5 = (int) (i5 + (motionLayout5.mPostInterpolationPosition * (motionLayout5.mEndWrapHeight - i5)));
            }
            boolean z2 = this.a.e1() || this.f1057b.e1();
            if (this.a.c1() || this.f1057b.c1()) {
                z = true;
            }
            MotionLayout.this.resolveMeasuredDimension(i2, i3, i4, i5, z2, z);
        }

        public void g() {
            f(MotionLayout.this.mLastWidthMeasureSpec, MotionLayout.this.mLastHeightMeasureSpec);
            MotionLayout.this.setupMotionViews();
        }

        public void h(int i2, int i3) {
            this.f1060e = i2;
            this.f1061f = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface f {
        void a(MotionEvent motionEvent);

        float b();

        float c();

        void d(int i2);

        void recycle();
    }

    /* loaded from: classes.dex */
    private static class g implements f {
        private static g a = new g();

        /* renamed from: b  reason: collision with root package name */
        VelocityTracker f1063b;

        private g() {
        }

        public static g e() {
            a.f1063b = VelocityTracker.obtain();
            return a;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.f
        public void a(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f1063b;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.f
        public float b() {
            return this.f1063b.getYVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.f
        public float c() {
            return this.f1063b.getXVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.f
        public void d(int i2) {
            this.f1063b.computeCurrentVelocity(i2);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.f
        public void recycle() {
            this.f1063b.recycle();
            this.f1063b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h {
        float a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f1064b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        int f1065c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f1066d = -1;

        /* renamed from: e  reason: collision with root package name */
        final String f1067e = "motion.progress";

        /* renamed from: f  reason: collision with root package name */
        final String f1068f = "motion.velocity";

        /* renamed from: g  reason: collision with root package name */
        final String f1069g = "motion.StartState";

        /* renamed from: h  reason: collision with root package name */
        final String f1070h = "motion.EndState";

        h() {
        }

        void a() {
            int i2 = this.f1065c;
            if (i2 != -1 || this.f1066d != -1) {
                if (i2 == -1) {
                    MotionLayout.this.transitionToState(this.f1066d);
                } else {
                    int i3 = this.f1066d;
                    if (i3 == -1) {
                        MotionLayout.this.setState(i2, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i2, i3);
                    }
                }
                MotionLayout.this.setState(j.SETUP);
            }
            if (Float.isNaN(this.f1064b)) {
                if (Float.isNaN(this.a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.a);
                return;
            }
            MotionLayout.this.setProgress(this.a, this.f1064b);
            this.a = Float.NaN;
            this.f1064b = Float.NaN;
            this.f1065c = -1;
            this.f1066d = -1;
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.a);
            bundle.putFloat("motion.velocity", this.f1064b);
            bundle.putInt("motion.StartState", this.f1065c);
            bundle.putInt("motion.EndState", this.f1066d);
            return bundle;
        }

        public void c() {
            this.f1066d = MotionLayout.this.mEndState;
            this.f1065c = MotionLayout.this.mBeginState;
            this.f1064b = MotionLayout.this.getVelocity();
            this.a = MotionLayout.this.getProgress();
        }

        public void d(int i2) {
            this.f1066d = i2;
        }

        public void e(float f2) {
            this.a = f2;
        }

        public void f(int i2) {
            this.f1065c = i2;
        }

        public void g(Bundle bundle) {
            this.a = bundle.getFloat("motion.progress");
            this.f1064b = bundle.getFloat("motion.velocity");
            this.f1065c = bundle.getInt("motion.StartState");
            this.f1066d = bundle.getInt("motion.EndState");
        }

        public void h(float f2) {
            this.f1064b = f2;
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void onTransitionChange(MotionLayout motionLayout, int i2, int i3, float f2);

        void onTransitionCompleted(MotionLayout motionLayout, int i2);

        void onTransitionStarted(MotionLayout motionLayout, int i2, int i3);

        void onTransitionTrigger(MotionLayout motionLayout, int i2, boolean z, float f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum j {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(Context context) {
        super(context);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new c.f.a.a.g();
        this.mDecelerateLogic = new c();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new androidx.constraintlayout.motion.widget.e();
        this.mInLayout = false;
        this.mTransitionState = j.UNDEFINED;
        this.mModel = new e();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(null);
    }

    private void checkStructure() {
        r rVar = this.mScene;
        if (rVar == null) {
            Log.e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int y = rVar.y();
        r rVar2 = this.mScene;
        checkStructure(y, rVar2.j(rVar2.y()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<r.b> it = this.mScene.m().iterator();
        while (it.hasNext()) {
            r.b next = it.next();
            if (next == this.mScene.f1175c) {
                Log.v(TAG, "CHECK: CURRENT");
            }
            checkStructure(next);
            int A = next.A();
            int y2 = next.y();
            String b2 = androidx.constraintlayout.motion.widget.a.b(getContext(), A);
            String b3 = androidx.constraintlayout.motion.widget.a.b(getContext(), y2);
            if (sparseIntArray.get(A) == y2) {
                Log.e(TAG, "CHECK: two transitions with the same start and end " + b2 + "->" + b3);
            }
            if (sparseIntArray2.get(y2) == A) {
                Log.e(TAG, "CHECK: you can't have reverse transitions" + b2 + "->" + b3);
            }
            sparseIntArray.put(A, y2);
            sparseIntArray2.put(y2, A);
            if (this.mScene.j(A) == null) {
                Log.e(TAG, " no such constraintSetStart " + b2);
            }
            if (this.mScene.j(y2) == null) {
                Log.e(TAG, " no such constraintSetEnd " + b2);
            }
        }
    }

    private void computeCurrentPositions() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            n nVar = this.mFrameArrayList.get(childAt);
            if (nVar != null) {
                nVar.s(childAt);
            }
        }
    }

    private void debugPos() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            Log.v(TAG, " " + androidx.constraintlayout.motion.widget.a.a() + " " + androidx.constraintlayout.motion.widget.a.c(this) + " " + androidx.constraintlayout.motion.widget.a.b(getContext(), this.mCurrentState) + " " + androidx.constraintlayout.motion.widget.a.c(childAt) + childAt.getLeft() + " " + childAt.getTop());
        }
    }

    private void evaluateLayout() {
        boolean z;
        float signum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.mInterpolator;
        float f2 = this.mTransitionLastPosition + (!(interpolator instanceof c.f.a.a.g) ? ((((float) (nanoTime - this.mTransitionLastTime)) * signum) * 1.0E-9f) / this.mTransitionDuration : 0.0f);
        if (this.mTransitionInstantly) {
            f2 = this.mTransitionGoalPosition;
        }
        int i2 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
        if ((i2 <= 0 || f2 < this.mTransitionGoalPosition) && (signum > 0.0f || f2 > this.mTransitionGoalPosition)) {
            z = false;
        } else {
            f2 = this.mTransitionGoalPosition;
            z = true;
        }
        if (interpolator != null && !z) {
            if (this.mTemporalInterpolator) {
                f2 = interpolator.getInterpolation(((float) (nanoTime - this.mAnimationStartTime)) * 1.0E-9f);
            } else {
                f2 = interpolator.getInterpolation(f2);
            }
        }
        if ((i2 > 0 && f2 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f2 <= this.mTransitionGoalPosition)) {
            f2 = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = f2;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            n nVar = this.mFrameArrayList.get(childAt);
            if (nVar != null) {
                nVar.o(childAt, f2, nanoTime2, this.mKeyCache);
            }
        }
        if (this.mMeasureDuringTransition) {
            requestLayout();
        }
    }

    private void fireTransitionChange() {
        ArrayList<i> arrayList;
        if ((this.mTransitionListener == null && ((arrayList = this.mTransitionListeners) == null || arrayList.isEmpty())) || this.mListenerPosition == this.mTransitionPosition) {
            return;
        }
        if (this.mListenerState != -1) {
            i iVar = this.mTransitionListener;
            if (iVar != null) {
                iVar.onTransitionStarted(this, this.mBeginState, this.mEndState);
            }
            ArrayList<i> arrayList2 = this.mTransitionListeners;
            if (arrayList2 != null) {
                Iterator<i> it = arrayList2.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
                }
            }
            this.mIsAnimating = true;
        }
        this.mListenerState = -1;
        float f2 = this.mTransitionPosition;
        this.mListenerPosition = f2;
        i iVar2 = this.mTransitionListener;
        if (iVar2 != null) {
            iVar2.onTransitionChange(this, this.mBeginState, this.mEndState, f2);
        }
        ArrayList<i> arrayList3 = this.mTransitionListeners;
        if (arrayList3 != null) {
            Iterator<i> it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
            }
        }
        this.mIsAnimating = true;
    }

    private void fireTransitionStarted(MotionLayout motionLayout, int i2, int i3) {
        i iVar = this.mTransitionListener;
        if (iVar != null) {
            iVar.onTransitionStarted(this, i2, i3);
        }
        ArrayList<i> arrayList = this.mTransitionListeners;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionStarted(motionLayout, i2, i3);
            }
        }
    }

    private boolean handlesTouchEvent(float f2, float f3, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (handlesTouchEvent(view.getLeft() + f2, view.getTop() + f3, viewGroup.getChildAt(i2), motionEvent)) {
                    return true;
                }
            }
        }
        this.mBoundsCheck.set(view.getLeft() + f2, view.getTop() + f3, f2 + view.getRight(), f3 + view.getBottom());
        if (motionEvent.getAction() == 0) {
            if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent)) {
                return true;
            }
        } else if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    private void init(AttributeSet attributeSet) {
        r rVar;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.i.r6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == androidx.constraintlayout.widget.i.u6) {
                    this.mScene = new r(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == androidx.constraintlayout.widget.i.t6) {
                    this.mCurrentState = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == androidx.constraintlayout.widget.i.w6) {
                    this.mTransitionGoalPosition = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.mInTransition = true;
                } else if (index == androidx.constraintlayout.widget.i.s6) {
                    z = obtainStyledAttributes.getBoolean(index, z);
                } else if (index == androidx.constraintlayout.widget.i.x6) {
                    if (this.mDebugPath == 0) {
                        this.mDebugPath = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == androidx.constraintlayout.widget.i.v6) {
                    this.mDebugPath = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.mScene == null) {
                Log.e(TAG, "WARNING NO app:layoutDescription tag");
            }
            if (!z) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            checkStructure();
        }
        if (this.mCurrentState != -1 || (rVar = this.mScene) == null) {
            return;
        }
        this.mCurrentState = rVar.y();
        this.mBeginState = this.mScene.y();
        this.mEndState = this.mScene.o();
    }

    private void onNewStateAttachHandlers() {
        r rVar = this.mScene;
        if (rVar == null) {
            return;
        }
        if (rVar.f(this, this.mCurrentState)) {
            requestLayout();
            return;
        }
        int i2 = this.mCurrentState;
        if (i2 != -1) {
            this.mScene.e(this, i2);
        }
        if (this.mScene.U()) {
            this.mScene.S();
        }
    }

    private void processTransitionCompleted() {
        ArrayList<i> arrayList;
        if (this.mTransitionListener == null && ((arrayList = this.mTransitionListeners) == null || arrayList.isEmpty())) {
            return;
        }
        this.mIsAnimating = false;
        Iterator<Integer> it = this.mTransitionCompleted.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            i iVar = this.mTransitionListener;
            if (iVar != null) {
                iVar.onTransitionCompleted(this, next.intValue());
            }
            ArrayList<i> arrayList2 = this.mTransitionListeners;
            if (arrayList2 != null) {
                Iterator<i> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onTransitionCompleted(this, next.intValue());
                }
            }
        }
        this.mTransitionCompleted.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupMotionViews() {
        int childCount = getChildCount();
        this.mModel.a();
        boolean z = true;
        this.mInTransition = true;
        int width = getWidth();
        int height = getHeight();
        int i2 = this.mScene.i();
        int i3 = 0;
        if (i2 != -1) {
            for (int i4 = 0; i4 < childCount; i4++) {
                n nVar = this.mFrameArrayList.get(getChildAt(i4));
                if (nVar != null) {
                    nVar.r(i2);
                }
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            n nVar2 = this.mFrameArrayList.get(getChildAt(i5));
            if (nVar2 != null) {
                this.mScene.r(nVar2);
                nVar2.v(width, height, this.mTransitionDuration, getNanoTime());
            }
        }
        float x = this.mScene.x();
        if (x != 0.0f) {
            boolean z2 = ((double) x) < 0.0d;
            float abs = Math.abs(x);
            float f2 = -3.4028235E38f;
            float f3 = Float.MAX_VALUE;
            float f4 = -3.4028235E38f;
            float f5 = Float.MAX_VALUE;
            int i6 = 0;
            while (true) {
                if (i6 >= childCount) {
                    z = false;
                    break;
                }
                n nVar3 = this.mFrameArrayList.get(getChildAt(i6));
                if (!Float.isNaN(nVar3.f1159k)) {
                    break;
                }
                float i7 = nVar3.i();
                float j2 = nVar3.j();
                float f6 = z2 ? j2 - i7 : j2 + i7;
                f5 = Math.min(f5, f6);
                f4 = Math.max(f4, f6);
                i6++;
            }
            if (!z) {
                while (i3 < childCount) {
                    n nVar4 = this.mFrameArrayList.get(getChildAt(i3));
                    float i8 = nVar4.i();
                    float j3 = nVar4.j();
                    float f7 = z2 ? j3 - i8 : j3 + i8;
                    nVar4.m = 1.0f / (1.0f - abs);
                    nVar4.f1160l = abs - (((f7 - f5) * abs) / (f4 - f5));
                    i3++;
                }
                return;
            }
            for (int i9 = 0; i9 < childCount; i9++) {
                n nVar5 = this.mFrameArrayList.get(getChildAt(i9));
                if (!Float.isNaN(nVar5.f1159k)) {
                    f3 = Math.min(f3, nVar5.f1159k);
                    f2 = Math.max(f2, nVar5.f1159k);
                }
            }
            while (i3 < childCount) {
                n nVar6 = this.mFrameArrayList.get(getChildAt(i3));
                if (!Float.isNaN(nVar6.f1159k)) {
                    nVar6.m = 1.0f / (1.0f - abs);
                    if (z2) {
                        nVar6.f1160l = abs - (((f2 - nVar6.f1159k) / (f2 - f3)) * abs);
                    } else {
                        nVar6.f1160l = abs - (((nVar6.f1159k - f3) * abs) / (f2 - f3));
                    }
                }
                i3++;
            }
        }
    }

    private static boolean willJump(float f2, float f3, float f4) {
        if (f2 > 0.0f) {
            float f5 = f2 / f4;
            return f3 + ((f2 * f5) - (((f4 * f5) * f5) / 2.0f)) > 1.0f;
        }
        float f6 = (-f2) / f4;
        return f3 + ((f2 * f6) + (((f4 * f6) * f6) / 2.0f)) < 0.0f;
    }

    public void addTransitionListener(i iVar) {
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new ArrayList<>();
        }
        this.mTransitionListeners.add(iVar);
    }

    void animateTo(float f2) {
        r rVar = this.mScene;
        if (rVar == null) {
            return;
        }
        float f3 = this.mTransitionLastPosition;
        float f4 = this.mTransitionPosition;
        if (f3 != f4 && this.mTransitionInstantly) {
            this.mTransitionLastPosition = f4;
        }
        float f5 = this.mTransitionLastPosition;
        if (f5 == f2) {
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = f2;
        this.mTransitionDuration = rVar.n() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = this.mScene.q();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = f5;
        this.mTransitionLastPosition = f5;
        invalidate();
    }

    void disableAutoTransition(boolean z) {
        r rVar = this.mScene;
        if (rVar == null) {
            return;
        }
        rVar.h(z);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long j2;
        evaluate(false);
        super.dispatchDraw(canvas);
        if (this.mScene == null) {
            return;
        }
        if ((this.mDebugPath & 1) == 1 && !isInEditMode()) {
            this.mFrames++;
            long nanoTime = getNanoTime();
            long j3 = this.mLastDrawTime;
            if (j3 != -1) {
                if (nanoTime - j3 > 200000000) {
                    this.mLastFps = ((int) ((this.mFrames / (((float) j2) * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.mFrames = 0;
                    this.mLastDrawTime = nanoTime;
                }
            } else {
                this.mLastDrawTime = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            StringBuilder sb = new StringBuilder();
            sb.append(this.mLastFps + " fps " + androidx.constraintlayout.motion.widget.a.d(this, this.mBeginState) + " -> ");
            sb.append(androidx.constraintlayout.motion.widget.a.d(this, this.mEndState));
            sb.append(" (progress: ");
            sb.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sb.append(" ) state=");
            int i2 = this.mCurrentState;
            sb.append(i2 == -1 ? "undefined" : androidx.constraintlayout.motion.widget.a.d(this, i2));
            String sb2 = sb.toString();
            paint.setColor(-16777216);
            canvas.drawText(sb2, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(sb2, 10.0f, getHeight() - 30, paint);
        }
        if (this.mDebugPath > 1) {
            if (this.mDevModeDraw == null) {
                this.mDevModeDraw = new d();
            }
            this.mDevModeDraw.a(canvas, this.mFrameArrayList, this.mScene.n(), this.mDebugPath);
        }
    }

    public void enableTransition(int i2, boolean z) {
        r.b transition = getTransition(i2);
        if (z) {
            transition.F(true);
            return;
        }
        r rVar = this.mScene;
        if (transition == rVar.f1175c) {
            Iterator<r.b> it = rVar.A(this.mCurrentState).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                r.b next = it.next();
                if (next.C()) {
                    this.mScene.f1175c = next;
                    break;
                }
            }
        }
        transition.F(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void evaluate(boolean z) {
        float f2;
        boolean z2;
        int i2;
        float interpolation;
        boolean z3;
        if (this.mTransitionLastTime == -1) {
            this.mTransitionLastTime = getNanoTime();
        }
        float f3 = this.mTransitionLastPosition;
        if (f3 > 0.0f && f3 < 1.0f) {
            this.mCurrentState = -1;
        }
        boolean z4 = false;
        if (this.mKeepAnimating || (this.mInTransition && (z || this.mTransitionGoalPosition != f3))) {
            float signum = Math.signum(this.mTransitionGoalPosition - f3);
            long nanoTime = getNanoTime();
            Interpolator interpolator = this.mInterpolator;
            if (interpolator instanceof p) {
                f2 = 0.0f;
            } else {
                f2 = ((((float) (nanoTime - this.mTransitionLastTime)) * signum) * 1.0E-9f) / this.mTransitionDuration;
                this.mLastVelocity = f2;
            }
            float f4 = this.mTransitionLastPosition + f2;
            if (this.mTransitionInstantly) {
                f4 = this.mTransitionGoalPosition;
            }
            int i3 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
            if ((i3 <= 0 || f4 < this.mTransitionGoalPosition) && (signum > 0.0f || f4 > this.mTransitionGoalPosition)) {
                z2 = false;
            } else {
                f4 = this.mTransitionGoalPosition;
                this.mInTransition = false;
                z2 = true;
            }
            this.mTransitionLastPosition = f4;
            this.mTransitionPosition = f4;
            this.mTransitionLastTime = nanoTime;
            if (interpolator != null && !z2) {
                if (this.mTemporalInterpolator) {
                    interpolation = interpolator.getInterpolation(((float) (nanoTime - this.mAnimationStartTime)) * 1.0E-9f);
                    this.mTransitionLastPosition = interpolation;
                    this.mTransitionLastTime = nanoTime;
                    Interpolator interpolator2 = this.mInterpolator;
                    if (interpolator2 instanceof p) {
                        float a2 = ((p) interpolator2).a();
                        this.mLastVelocity = a2;
                        if (Math.abs(a2) * this.mTransitionDuration <= EPSILON) {
                            this.mInTransition = false;
                        }
                        if (a2 > 0.0f && interpolation >= 1.0f) {
                            this.mTransitionLastPosition = 1.0f;
                            this.mInTransition = false;
                            interpolation = 1.0f;
                        }
                        if (a2 < 0.0f && interpolation <= 0.0f) {
                            this.mTransitionLastPosition = 0.0f;
                            this.mInTransition = false;
                            f4 = 0.0f;
                        }
                    }
                } else {
                    interpolation = interpolator.getInterpolation(f4);
                    Interpolator interpolator3 = this.mInterpolator;
                    if (interpolator3 instanceof p) {
                        this.mLastVelocity = ((p) interpolator3).a();
                    } else {
                        this.mLastVelocity = ((interpolator3.getInterpolation(f4 + f2) - interpolation) * signum) / f2;
                    }
                }
                f4 = interpolation;
            }
            if (Math.abs(this.mLastVelocity) > EPSILON) {
                setState(j.MOVING);
            }
            if ((i3 > 0 && f4 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f4 <= this.mTransitionGoalPosition)) {
                f4 = this.mTransitionGoalPosition;
                this.mInTransition = false;
            }
            int i4 = (f4 > 1.0f ? 1 : (f4 == 1.0f ? 0 : -1));
            if (i4 >= 0 || f4 <= 0.0f) {
                this.mInTransition = false;
                setState(j.FINISHED);
            }
            int childCount = getChildCount();
            this.mKeepAnimating = false;
            long nanoTime2 = getNanoTime();
            this.mPostInterpolationPosition = f4;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                n nVar = this.mFrameArrayList.get(childAt);
                if (nVar != null) {
                    this.mKeepAnimating = nVar.o(childAt, f4, nanoTime2, this.mKeyCache) | this.mKeepAnimating;
                }
            }
            boolean z5 = (i3 > 0 && f4 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f4 <= this.mTransitionGoalPosition);
            if (!this.mKeepAnimating && !this.mInTransition && z5) {
                setState(j.FINISHED);
            }
            if (this.mMeasureDuringTransition) {
                requestLayout();
            }
            this.mKeepAnimating = (!z5) | this.mKeepAnimating;
            if (f4 <= 0.0f && (i2 = this.mBeginState) != -1 && this.mCurrentState != i2) {
                this.mCurrentState = i2;
                this.mScene.j(i2).c(this);
                setState(j.FINISHED);
                z4 = true;
            }
            if (f4 >= 1.0d) {
                int i6 = this.mCurrentState;
                int i7 = this.mEndState;
                if (i6 != i7) {
                    this.mCurrentState = i7;
                    this.mScene.j(i7).c(this);
                    setState(j.FINISHED);
                    z4 = true;
                }
            }
            if (this.mKeepAnimating || this.mInTransition) {
                invalidate();
            } else if ((i3 > 0 && i4 == 0) || (signum < 0.0f && f4 == 0.0f)) {
                setState(j.FINISHED);
            }
            if ((!this.mKeepAnimating && this.mInTransition && i3 > 0 && i4 == 0) || (signum < 0.0f && f4 == 0.0f)) {
                onNewStateAttachHandlers();
            }
        }
        float f5 = this.mTransitionLastPosition;
        if (f5 >= 1.0f) {
            int i8 = this.mCurrentState;
            int i9 = this.mEndState;
            z3 = i8 == i9 ? z4 : true;
            this.mCurrentState = i9;
        } else {
            if (f5 <= 0.0f) {
                int i10 = this.mCurrentState;
                int i11 = this.mBeginState;
                z3 = i10 == i11 ? z4 : true;
                this.mCurrentState = i11;
            }
            this.mNeedsFireTransitionCompleted |= z4;
            if (z4 && !this.mInLayout) {
                requestLayout();
            }
            this.mTransitionPosition = this.mTransitionLastPosition;
        }
        z4 = z3;
        this.mNeedsFireTransitionCompleted |= z4;
        if (z4) {
            requestLayout();
        }
        this.mTransitionPosition = this.mTransitionLastPosition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fireTransitionCompleted() {
        int i2;
        ArrayList<Integer> arrayList;
        ArrayList<i> arrayList2;
        if ((this.mTransitionListener != null || ((arrayList2 = this.mTransitionListeners) != null && !arrayList2.isEmpty())) && this.mListenerState == -1) {
            this.mListenerState = this.mCurrentState;
            if (this.mTransitionCompleted.isEmpty()) {
                i2 = -1;
            } else {
                i2 = this.mTransitionCompleted.get(arrayList.size() - 1).intValue();
            }
            int i3 = this.mCurrentState;
            if (i2 != i3 && i3 != -1) {
                this.mTransitionCompleted.add(Integer.valueOf(i3));
            }
        }
        processTransitionCompleted();
    }

    public void fireTrigger(int i2, boolean z, float f2) {
        i iVar = this.mTransitionListener;
        if (iVar != null) {
            iVar.onTransitionTrigger(this, i2, z, f2);
        }
        ArrayList<i> arrayList = this.mTransitionListeners;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i2, z, f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getAnchorDpDt(int i2, float f2, float f3, float f4, float[] fArr) {
        String resourceName;
        HashMap<View, n> hashMap = this.mFrameArrayList;
        View viewById = getViewById(i2);
        n nVar = hashMap.get(viewById);
        if (nVar != null) {
            nVar.g(f2, f3, f4, fArr);
            float y = viewById.getY();
            int i3 = ((f2 - this.lastPos) > 0.0f ? 1 : ((f2 - this.lastPos) == 0.0f ? 0 : -1));
            this.lastPos = f2;
            this.lastY = y;
            return;
        }
        if (viewById == null) {
            resourceName = "" + i2;
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i2);
        }
        Log.w(TAG, "WARNING could not find view id " + resourceName);
    }

    public androidx.constraintlayout.widget.d getConstraintSet(int i2) {
        r rVar = this.mScene;
        if (rVar == null) {
            return null;
        }
        return rVar.j(i2);
    }

    public int[] getConstraintSetIds() {
        r rVar = this.mScene;
        if (rVar == null) {
            return null;
        }
        return rVar.l();
    }

    String getConstraintSetNames(int i2) {
        r rVar = this.mScene;
        if (rVar == null) {
            return null;
        }
        return rVar.F(i2);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public void getDebugMode(boolean z) {
        this.mDebugPath = z ? 2 : 1;
        invalidate();
    }

    public ArrayList<r.b> getDefinedTransitions() {
        r rVar = this.mScene;
        if (rVar == null) {
            return null;
        }
        return rVar.m();
    }

    public androidx.constraintlayout.motion.widget.b getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new androidx.constraintlayout.motion.widget.b(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public r.b getTransition(int i2) {
        return this.mScene.z(i2);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new h();
        }
        this.mStateCache.c();
        return this.mStateCache.b();
    }

    public long getTransitionTimeMs() {
        r rVar = this.mScene;
        if (rVar != null) {
            this.mTransitionDuration = rVar.n() / 1000.0f;
        }
        return this.mTransitionDuration * 1000.0f;
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View view, float f2, float f3, float[] fArr, int i2) {
        float f4;
        float f5 = this.mLastVelocity;
        float f6 = this.mTransitionLastPosition;
        if (this.mInterpolator != null) {
            float signum = Math.signum(this.mTransitionGoalPosition - f6);
            float interpolation = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
            float interpolation2 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            f5 = (signum * ((interpolation - interpolation2) / EPSILON)) / this.mTransitionDuration;
            f4 = interpolation2;
        } else {
            f4 = f6;
        }
        Interpolator interpolator = this.mInterpolator;
        if (interpolator instanceof p) {
            f5 = ((p) interpolator).a();
        }
        n nVar = this.mFrameArrayList.get(view);
        if ((i2 & 1) == 0) {
            nVar.l(f4, view.getWidth(), view.getHeight(), f2, f3, fArr);
        } else {
            nVar.g(f4, f2, f3, fArr);
        }
        if (i2 < 2) {
            fArr[0] = fArr[0] * f5;
            fArr[1] = fArr[1] * f5;
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        if (Build.VERSION.SDK_INT >= 19) {
            return super.isAttachedToWindow();
        }
        return getWindowToken() != null;
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i2) {
        if (i2 != 0) {
            try {
                this.mScene = new r(getContext(), this, i2);
                if (Build.VERSION.SDK_INT < 19 || isAttachedToWindow()) {
                    this.mScene.M(this);
                    this.mModel.d(this.mLayoutWidget, this.mScene.j(this.mBeginState), this.mScene.j(this.mEndState));
                    rebuildScene();
                    this.mScene.P(isRtl());
                    return;
                }
                return;
            } catch (Exception e2) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e2);
            }
        }
        this.mScene = null;
    }

    int lookUpConstraintId(String str) {
        r rVar = this.mScene;
        if (rVar == null) {
            return 0;
        }
        return rVar.E(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f obtainVelocityTracker() {
        return g.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        int i2;
        super.onAttachedToWindow();
        r rVar = this.mScene;
        if (rVar != null && (i2 = this.mCurrentState) != -1) {
            androidx.constraintlayout.widget.d j2 = rVar.j(i2);
            this.mScene.M(this);
            if (j2 != null) {
                j2.d(this);
            }
            this.mBeginState = this.mCurrentState;
        }
        onNewStateAttachHandlers();
        h hVar = this.mStateCache;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        r.b bVar;
        u B;
        int k2;
        RectF j2;
        r rVar = this.mScene;
        if (rVar != null && this.mInteractionEnabled && (bVar = rVar.f1175c) != null && bVar.C() && (B = bVar.B()) != null && ((motionEvent.getAction() != 0 || (j2 = B.j(this, new RectF())) == null || j2.contains(motionEvent.getX(), motionEvent.getY())) && (k2 = B.k()) != -1)) {
            View view = this.mRegionView;
            if (view == null || view.getId() != k2) {
                this.mRegionView = findViewById(k2);
            }
            View view2 = this.mRegionView;
            if (view2 != null) {
                this.mBoundsCheck.set(view2.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
                if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !handlesTouchEvent(0.0f, 0.0f, this.mRegionView, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.mInLayout = true;
        try {
            if (this.mScene == null) {
                super.onLayout(z, i2, i3, i4, i5);
                return;
            }
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            if (this.mLastLayoutWidth != i6 || this.mLastLayoutHeight != i7) {
                rebuildScene();
                evaluate(true);
            }
            this.mLastLayoutWidth = i6;
            this.mLastLayoutHeight = i7;
            this.mOldWidth = i6;
            this.mOldHeight = i7;
        } finally {
            this.mInLayout = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.mScene == null) {
            super.onMeasure(i2, i3);
            return;
        }
        boolean z = false;
        boolean z2 = (this.mLastWidthMeasureSpec == i2 && this.mLastHeightMeasureSpec == i3) ? false : true;
        if (this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            onNewStateAttachHandlers();
            processTransitionCompleted();
            z2 = true;
        }
        if (this.mDirtyHierarchy) {
            z2 = true;
        }
        this.mLastWidthMeasureSpec = i2;
        this.mLastHeightMeasureSpec = i3;
        int y = this.mScene.y();
        int o = this.mScene.o();
        if ((z2 || this.mModel.e(y, o)) && this.mBeginState != -1) {
            super.onMeasure(i2, i3);
            this.mModel.d(this.mLayoutWidget, this.mScene.j(y), this.mScene.j(o));
            this.mModel.g();
            this.mModel.h(y, o);
        } else {
            z = true;
        }
        if (this.mMeasureDuringTransition || z) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int Q = this.mLayoutWidget.Q() + getPaddingLeft() + getPaddingRight();
            int w = this.mLayoutWidget.w() + paddingTop;
            int i6 = this.mWidthMeasureMode;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                Q = (int) (this.mStartWrapWidth + (this.mPostInterpolationPosition * (this.mEndWrapWidth - i4)));
                requestLayout();
            }
            int i7 = this.mHeightMeasureMode;
            if (i7 == Integer.MIN_VALUE || i7 == 0) {
                w = (int) (this.mStartWrapHeight + (this.mPostInterpolationPosition * (this.mEndWrapHeight - i5)));
                requestLayout();
            }
            setMeasuredDimension(Q, w);
        }
        evaluateLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, c.h.k.o
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // c.h.k.m
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        r.b bVar;
        u B;
        int k2;
        r rVar = this.mScene;
        if (rVar == null || (bVar = rVar.f1175c) == null || !bVar.C()) {
            return;
        }
        r.b bVar2 = this.mScene.f1175c;
        if (bVar2 == null || !bVar2.C() || (B = bVar2.B()) == null || (k2 = B.k()) == -1 || view.getId() == k2) {
            r rVar2 = this.mScene;
            if (rVar2 != null && rVar2.u()) {
                float f2 = this.mTransitionPosition;
                if ((f2 == 1.0f || f2 == 0.0f) && view.canScrollVertically(-1)) {
                    return;
                }
            }
            if (bVar2.B() != null && (this.mScene.f1175c.B().d() & 1) != 0) {
                float v = this.mScene.v(i2, i3);
                float f3 = this.mTransitionLastPosition;
                if ((f3 <= 0.0f && v < 0.0f) || (f3 >= 1.0f && v > 0.0f)) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new a(view));
                        return;
                    }
                    return;
                }
            }
            float f4 = this.mTransitionPosition;
            long nanoTime = getNanoTime();
            float f5 = i2;
            this.mScrollTargetDX = f5;
            float f6 = i3;
            this.mScrollTargetDY = f6;
            this.mScrollTargetDT = (float) ((nanoTime - this.mScrollTargetTime) * 1.0E-9d);
            this.mScrollTargetTime = nanoTime;
            this.mScene.I(f5, f6);
            if (f4 != this.mTransitionPosition) {
                iArr[0] = i2;
                iArr[1] = i3;
            }
            evaluate(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.mUndergoingMotion = true;
        }
    }

    @Override // c.h.k.m
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
    }

    @Override // c.h.k.n
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (this.mUndergoingMotion || i2 != 0 || i3 != 0) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
        }
        this.mUndergoingMotion = false;
    }

    @Override // c.h.k.m
    public void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        r rVar = this.mScene;
        if (rVar != null) {
            rVar.P(isRtl());
        }
    }

    @Override // c.h.k.m
    public boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        r.b bVar;
        r rVar = this.mScene;
        return (rVar == null || (bVar = rVar.f1175c) == null || bVar.B() == null || (this.mScene.f1175c.B().d() & 2) != 0) ? false : true;
    }

    @Override // c.h.k.m
    public void onStopNestedScroll(View view, int i2) {
        r rVar = this.mScene;
        if (rVar == null) {
            return;
        }
        float f2 = this.mScrollTargetDX;
        float f3 = this.mScrollTargetDT;
        rVar.J(f2 / f3, this.mScrollTargetDY / f3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        r rVar = this.mScene;
        if (rVar != null && this.mInteractionEnabled && rVar.U()) {
            r.b bVar = this.mScene.f1175c;
            if (bVar != null && !bVar.C()) {
                return super.onTouchEvent(motionEvent);
            }
            this.mScene.K(motionEvent, getCurrentState(), this);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof o) {
            o oVar = (o) view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new ArrayList<>();
            }
            this.mTransitionListeners.add(oVar);
            if (oVar.s()) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new ArrayList<>();
                }
                this.mOnShowHelpers.add(oVar);
            }
            if (oVar.r()) {
                if (this.mOnHideHelpers == null) {
                    this.mOnHideHelpers = new ArrayList<>();
                }
                this.mOnHideHelpers.add(oVar);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<o> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<o> arrayList2 = this.mOnHideHelpers;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void parseLayoutDescription(int i2) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e(TAG, "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.g();
        invalidate();
    }

    public boolean removeTransitionListener(i iVar) {
        ArrayList<i> arrayList = this.mTransitionListeners;
        if (arrayList == null) {
            return false;
        }
        return arrayList.remove(iVar);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        r rVar;
        r.b bVar;
        if (this.mMeasureDuringTransition || this.mCurrentState != -1 || (rVar = this.mScene) == null || (bVar = rVar.f1175c) == null || bVar.z() != 0) {
            super.requestLayout();
        }
    }

    public void setDebugMode(int i2) {
        this.mDebugPath = i2;
        invalidate();
    }

    public void setInteractionEnabled(boolean z) {
        this.mInteractionEnabled = z;
    }

    public void setInterpolatedProgress(float f2) {
        if (this.mScene != null) {
            setState(j.MOVING);
            Interpolator q = this.mScene.q();
            if (q != null) {
                setProgress(q.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        ArrayList<o> arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mOnHideHelpers.get(i2).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        ArrayList<o> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mOnShowHelpers.get(i2).setProgress(f2);
            }
        }
    }

    public void setProgress(float f2, float f3) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new h();
            }
            this.mStateCache.e(f2);
            this.mStateCache.h(f3);
            return;
        }
        setProgress(f2);
        setState(j.MOVING);
        this.mLastVelocity = f3;
        animateTo(1.0f);
    }

    public void setScene(r rVar) {
        this.mScene = rVar;
        rVar.P(isRtl());
        rebuildScene();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setState(j jVar) {
        j jVar2 = j.FINISHED;
        if (jVar == jVar2 && this.mCurrentState == -1) {
            return;
        }
        j jVar3 = this.mTransitionState;
        this.mTransitionState = jVar;
        j jVar4 = j.MOVING;
        if (jVar3 == jVar4 && jVar == jVar4) {
            fireTransitionChange();
        }
        int i2 = b.a[jVar3.ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3 && jVar == jVar2) {
                fireTransitionCompleted();
                return;
            }
            return;
        }
        if (jVar == jVar4) {
            fireTransitionChange();
        }
        if (jVar == jVar2) {
            fireTransitionCompleted();
        }
    }

    public void setTransition(int i2, int i3) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new h();
            }
            this.mStateCache.f(i2);
            this.mStateCache.d(i3);
            return;
        }
        r rVar = this.mScene;
        if (rVar != null) {
            this.mBeginState = i2;
            this.mEndState = i3;
            rVar.Q(i2, i3);
            this.mModel.d(this.mLayoutWidget, this.mScene.j(i2), this.mScene.j(i3));
            rebuildScene();
            this.mTransitionLastPosition = 0.0f;
            transitionToStart();
        }
    }

    public void setTransitionDuration(int i2) {
        r rVar = this.mScene;
        if (rVar == null) {
            Log.e(TAG, "MotionScene not defined");
        } else {
            rVar.O(i2);
        }
    }

    public void setTransitionListener(i iVar) {
        this.mTransitionListener = iVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new h();
        }
        this.mStateCache.g(bundle);
        if (isAttachedToWindow()) {
            this.mStateCache.a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return androidx.constraintlayout.motion.widget.a.b(context, this.mBeginState) + "->" + androidx.constraintlayout.motion.widget.a.b(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    public void touchAnimateTo(int i2, float f2, float f3) {
        if (this.mScene == null || this.mTransitionLastPosition == f2) {
            return;
        }
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        float n = this.mScene.n() / 1000.0f;
        this.mTransitionDuration = n;
        this.mTransitionGoalPosition = f2;
        this.mInTransition = true;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            if (i2 == 1) {
                f2 = 0.0f;
            } else if (i2 == 2) {
                f2 = 1.0f;
            }
            this.mStopLogic.c(this.mTransitionLastPosition, f2, f3, n, this.mScene.s(), this.mScene.t());
            int i3 = this.mCurrentState;
            this.mTransitionGoalPosition = f2;
            this.mCurrentState = i3;
            this.mInterpolator = this.mStopLogic;
        } else if (i2 == 4) {
            this.mDecelerateLogic.b(f3, this.mTransitionLastPosition, this.mScene.s());
            this.mInterpolator = this.mDecelerateLogic;
        } else if (i2 == 5) {
            if (willJump(f3, this.mTransitionLastPosition, this.mScene.s())) {
                this.mDecelerateLogic.b(f3, this.mTransitionLastPosition, this.mScene.s());
                this.mInterpolator = this.mDecelerateLogic;
            } else {
                this.mStopLogic.c(this.mTransitionLastPosition, f2, f3, this.mTransitionDuration, this.mScene.s(), this.mScene.t());
                this.mLastVelocity = 0.0f;
                int i4 = this.mCurrentState;
                this.mTransitionGoalPosition = f2;
                this.mCurrentState = i4;
                this.mInterpolator = this.mStopLogic;
            }
        }
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
    }

    public void transitionToEnd() {
        animateTo(1.0f);
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToState(int i2) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new h();
            }
            this.mStateCache.d(i2);
            return;
        }
        transitionToState(i2, -1, -1);
    }

    public void updateState(int i2, androidx.constraintlayout.widget.d dVar) {
        r rVar = this.mScene;
        if (rVar != null) {
            rVar.N(i2, dVar);
        }
        updateState();
        if (this.mCurrentState == i2) {
            dVar.d(this);
        }
    }

    public void transitionToState(int i2, int i3, int i4) {
        androidx.constraintlayout.widget.j jVar;
        int a2;
        r rVar = this.mScene;
        if (rVar != null && (jVar = rVar.f1174b) != null && (a2 = jVar.a(this.mCurrentState, i2, i3, i4)) != -1) {
            i2 = a2;
        }
        int i5 = this.mCurrentState;
        if (i5 == i2) {
            return;
        }
        if (this.mBeginState == i2) {
            animateTo(0.0f);
        } else if (this.mEndState == i2) {
            animateTo(1.0f);
        } else {
            this.mEndState = i2;
            if (i5 != -1) {
                setTransition(i5, i2);
                animateTo(1.0f);
                this.mTransitionLastPosition = 0.0f;
                transitionToEnd();
                return;
            }
            this.mTemporalInterpolator = false;
            this.mTransitionGoalPosition = 1.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionLastTime = getNanoTime();
            this.mAnimationStartTime = getNanoTime();
            this.mTransitionInstantly = false;
            this.mInterpolator = null;
            this.mTransitionDuration = this.mScene.n() / 1000.0f;
            this.mBeginState = -1;
            this.mScene.Q(-1, this.mEndState);
            this.mScene.y();
            int childCount = getChildCount();
            this.mFrameArrayList.clear();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                this.mFrameArrayList.put(childAt, new n(childAt));
            }
            this.mInTransition = true;
            this.mModel.d(this.mLayoutWidget, null, this.mScene.j(i2));
            rebuildScene();
            this.mModel.a();
            computeCurrentPositions();
            int width = getWidth();
            int height = getHeight();
            for (int i7 = 0; i7 < childCount; i7++) {
                n nVar = this.mFrameArrayList.get(getChildAt(i7));
                this.mScene.r(nVar);
                nVar.v(width, height, this.mTransitionDuration, getNanoTime());
            }
            float x = this.mScene.x();
            if (x != 0.0f) {
                float f2 = Float.MAX_VALUE;
                float f3 = -3.4028235E38f;
                for (int i8 = 0; i8 < childCount; i8++) {
                    n nVar2 = this.mFrameArrayList.get(getChildAt(i8));
                    float j2 = nVar2.j() + nVar2.i();
                    f2 = Math.min(f2, j2);
                    f3 = Math.max(f3, j2);
                }
                for (int i9 = 0; i9 < childCount; i9++) {
                    n nVar3 = this.mFrameArrayList.get(getChildAt(i9));
                    float i10 = nVar3.i();
                    float j3 = nVar3.j();
                    nVar3.m = 1.0f / (1.0f - x);
                    nVar3.f1160l = x - ((((i10 + j3) - f2) * x) / (f3 - f2));
                }
            }
            this.mTransitionPosition = 0.0f;
            this.mTransitionLastPosition = 0.0f;
            this.mInTransition = true;
            invalidate();
        }
    }

    public void updateState() {
        this.mModel.d(this.mLayoutWidget, this.mScene.j(this.mBeginState), this.mScene.j(this.mEndState));
        rebuildScene();
    }

    public void setProgress(float f2) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new h();
            }
            this.mStateCache.e(f2);
            return;
        }
        if (f2 <= 0.0f) {
            this.mCurrentState = this.mBeginState;
            if (this.mTransitionLastPosition == 0.0f) {
                setState(j.FINISHED);
            }
        } else if (f2 >= 1.0f) {
            this.mCurrentState = this.mEndState;
            if (this.mTransitionLastPosition == 1.0f) {
                setState(j.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            setState(j.MOVING);
        }
        if (this.mScene == null) {
            return;
        }
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = f2;
        this.mTransitionPosition = f2;
        this.mTransitionLastTime = -1L;
        this.mAnimationStartTime = -1L;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i2, int i3, int i4) {
        setState(j.SETUP);
        this.mCurrentState = i2;
        this.mBeginState = -1;
        this.mEndState = -1;
        androidx.constraintlayout.widget.c cVar = this.mConstraintLayoutSpec;
        if (cVar != null) {
            cVar.d(i2, i3, i4);
            return;
        }
        r rVar = this.mScene;
        if (rVar != null) {
            rVar.j(i2).d(this);
        }
    }

    public void setTransition(int i2) {
        if (this.mScene != null) {
            r.b transition = getTransition(i2);
            this.mBeginState = transition.A();
            this.mEndState = transition.y();
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new h();
                }
                this.mStateCache.f(this.mBeginState);
                this.mStateCache.d(this.mEndState);
                return;
            }
            float f2 = Float.NaN;
            int i3 = this.mCurrentState;
            if (i3 == this.mBeginState) {
                f2 = 0.0f;
            } else if (i3 == this.mEndState) {
                f2 = 1.0f;
            }
            this.mScene.R(transition);
            this.mModel.d(this.mLayoutWidget, this.mScene.j(this.mBeginState), this.mScene.j(this.mEndState));
            rebuildScene();
            this.mTransitionLastPosition = Float.isNaN(f2) ? 0.0f : f2;
            if (Float.isNaN(f2)) {
                Log.v(TAG, androidx.constraintlayout.motion.widget.a.a() + " transitionToStart ");
                transitionToStart();
                return;
            }
            setProgress(f2);
        }
    }

    private void checkStructure(int i2, androidx.constraintlayout.widget.d dVar) {
        View childAt;
        String b2 = androidx.constraintlayout.motion.widget.a.b(getContext(), i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            int id = getChildAt(i3).getId();
            if (id == -1) {
                Log.w(TAG, "CHECK: " + b2 + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (dVar.q(id) == null) {
                Log.w(TAG, "CHECK: " + b2 + " NO CONSTRAINTS for " + androidx.constraintlayout.motion.widget.a.c(childAt));
            }
        }
        int[] s = dVar.s();
        for (int i4 = 0; i4 < s.length; i4++) {
            int i5 = s[i4];
            String b3 = androidx.constraintlayout.motion.widget.a.b(getContext(), i5);
            if (findViewById(s[i4]) == null) {
                Log.w(TAG, "CHECK: " + b2 + " NO View matches id " + b3);
            }
            if (dVar.r(i5) == -1) {
                Log.w(TAG, "CHECK: " + b2 + "(" + b3 + ") no LAYOUT_HEIGHT");
            }
            if (dVar.w(i5) == -1) {
                Log.w(TAG, "CHECK: " + b2 + "(" + b3 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTransition(r.b bVar) {
        this.mScene.R(bVar);
        setState(j.SETUP);
        if (this.mCurrentState == this.mScene.o()) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        this.mTransitionLastTime = bVar.D(1) ? -1L : getNanoTime();
        int y = this.mScene.y();
        int o = this.mScene.o();
        if (y == this.mBeginState && o == this.mEndState) {
            return;
        }
        this.mBeginState = y;
        this.mEndState = o;
        this.mScene.Q(y, o);
        this.mModel.d(this.mLayoutWidget, this.mScene.j(this.mBeginState), this.mScene.j(this.mEndState));
        this.mModel.h(this.mBeginState, this.mEndState);
        this.mModel.g();
        rebuildScene();
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new c.f.a.a.g();
        this.mDecelerateLogic = new c();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new androidx.constraintlayout.motion.widget.e();
        this.mInLayout = false;
        this.mTransitionState = j.UNDEFINED;
        this.mModel = new e();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(attributeSet);
    }

    private void checkStructure(r.b bVar) {
        Log.v(TAG, "CHECK: transition = " + bVar.u(getContext()));
        Log.v(TAG, "CHECK: transition.setDuration = " + bVar.x());
        if (bVar.A() == bVar.y()) {
            Log.e(TAG, "CHECK: start and end constraint set should not be the same!");
        }
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new c.f.a.a.g();
        this.mDecelerateLogic = new c();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new androidx.constraintlayout.motion.widget.e();
        this.mInLayout = false;
        this.mTransitionState = j.UNDEFINED;
        this.mModel = new e();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(attributeSet);
    }
}