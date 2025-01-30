package com.facebook.react.views.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.c0;
import com.facebook.react.uimanager.d0;
import com.facebook.react.uimanager.e0;
import com.facebook.react.uimanager.j;
import com.facebook.react.uimanager.p;
import com.facebook.react.uimanager.r;
import com.facebook.react.uimanager.s;
import com.facebook.react.uimanager.v;
import com.facebook.react.uimanager.v0;
import com.facebook.react.views.view.d;

/* compiled from: ReactViewGroup.java */
/* loaded from: classes2.dex */
public class f extends ViewGroup implements e.f.m.z.d, r, v, e.f.m.z.c, c0 {
    private static final ViewGroup.LayoutParams a = new ViewGroup.LayoutParams(0, 0);

    /* renamed from: b  reason: collision with root package name */
    private static final Rect f5548b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private boolean f5549c;

    /* renamed from: d  reason: collision with root package name */
    private View[] f5550d;

    /* renamed from: e  reason: collision with root package name */
    private int f5551e;

    /* renamed from: f  reason: collision with root package name */
    private Rect f5552f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f5553g;

    /* renamed from: h  reason: collision with root package name */
    private String f5554h;

    /* renamed from: j  reason: collision with root package name */
    private p f5555j;

    /* renamed from: k  reason: collision with root package name */
    private b f5556k;

    /* renamed from: l  reason: collision with root package name */
    private d f5557l;
    private e.f.m.z.b m;
    private boolean n;
    private final v0 p;
    private Path q;
    private int t;
    private float u;
    private String v;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReactViewGroup.java */
    /* loaded from: classes2.dex */
    public static final class b implements View.OnLayoutChangeListener {
        private final f a;

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (this.a.getRemoveClippedSubviews()) {
                this.a.x(view);
            }
        }

        private b(f fVar) {
            this.a = fVar;
        }
    }

    public f(Context context) {
        super(context);
        this.f5549c = false;
        this.f5550d = null;
        this.f5555j = p.AUTO;
        this.n = false;
        this.u = 1.0f;
        this.v = "visible";
        setClipChildren(false);
        this.p = new v0(this);
    }

    private d getOrCreateReactViewBackground() {
        if (this.f5557l == null) {
            this.f5557l = new d(getContext());
            Drawable background = getBackground();
            u(null);
            if (background == null) {
                u(this.f5557l);
            } else {
                u(new LayerDrawable(new Drawable[]{this.f5557l, background}));
            }
            if (Build.VERSION.SDK_INT >= 17) {
                boolean g2 = com.facebook.react.modules.i18nmanager.a.d().g(getContext());
                this.t = g2 ? 1 : 0;
                this.f5557l.A(g2 ? 1 : 0);
            }
        }
        return this.f5557l;
    }

    private void h(View view, int i2) {
        View[] viewArr = (View[]) e.f.k.a.a.c(this.f5550d);
        int i3 = this.f5551e;
        int length = viewArr.length;
        if (i2 == i3) {
            if (length == i3) {
                View[] viewArr2 = new View[length + 12];
                this.f5550d = viewArr2;
                System.arraycopy(viewArr, 0, viewArr2, 0, length);
                viewArr = this.f5550d;
            }
            int i4 = this.f5551e;
            this.f5551e = i4 + 1;
            viewArr[i4] = view;
        } else if (i2 < i3) {
            if (length == i3) {
                View[] viewArr3 = new View[length + 12];
                this.f5550d = viewArr3;
                System.arraycopy(viewArr, 0, viewArr3, 0, i2);
                System.arraycopy(viewArr, i2, this.f5550d, i2 + 1, i3 - i2);
                viewArr = this.f5550d;
            } else {
                System.arraycopy(viewArr, i2, viewArr, i2 + 1, i3 - i2);
            }
            viewArr[i2] = view;
            this.f5551e++;
        } else {
            throw new IndexOutOfBoundsException("index=" + i2 + " count=" + i3);
        }
    }

    private void k(Canvas canvas) {
        float f2;
        boolean z;
        float f3;
        float f4;
        Path path;
        String str = this.f5554h;
        if (str != null) {
            str.hashCode();
            if (!str.equals("hidden")) {
                if (str.equals("visible") && (path = this.q) != null) {
                    path.rewind();
                    return;
                }
                return;
            }
            float width = getWidth();
            float height = getHeight();
            d dVar = this.f5557l;
            float f5 = 0.0f;
            if (dVar != null) {
                RectF k2 = dVar.k();
                float f6 = k2.top;
                if (f6 > 0.0f || k2.left > 0.0f || k2.bottom > 0.0f || k2.right > 0.0f) {
                    f3 = k2.left + 0.0f;
                    f2 = f6 + 0.0f;
                    width -= k2.right;
                    height -= k2.bottom;
                } else {
                    f2 = 0.0f;
                    f3 = 0.0f;
                }
                float m = this.f5557l.m();
                float h2 = this.f5557l.h(m, d.b.TOP_LEFT);
                float h3 = this.f5557l.h(m, d.b.TOP_RIGHT);
                float h4 = this.f5557l.h(m, d.b.BOTTOM_LEFT);
                float h5 = this.f5557l.h(m, d.b.BOTTOM_RIGHT);
                if (Build.VERSION.SDK_INT >= 17) {
                    boolean z2 = this.t == 1;
                    float g2 = this.f5557l.g(d.b.TOP_START);
                    float g3 = this.f5557l.g(d.b.TOP_END);
                    float g4 = this.f5557l.g(d.b.BOTTOM_START);
                    h5 = this.f5557l.g(d.b.BOTTOM_END);
                    if (com.facebook.react.modules.i18nmanager.a.d().b(getContext())) {
                        float f7 = com.facebook.yoga.g.a(g2) ? h2 : g2;
                        if (!com.facebook.yoga.g.a(g3)) {
                            h3 = g3;
                        }
                        if (!com.facebook.yoga.g.a(g4)) {
                            h4 = g4;
                        }
                        if (com.facebook.yoga.g.a(h5)) {
                            h5 = h5;
                        }
                        float f8 = z2 ? h3 : f7;
                        if (z2) {
                            h3 = f7;
                        }
                        float f9 = z2 ? h5 : h4;
                        if (z2) {
                            h5 = h4;
                        }
                        h2 = f8;
                        h4 = f9;
                    } else {
                        h2 = z2 ? g3 : g2;
                        if (!z2) {
                            g2 = g3;
                        }
                        float f10 = z2 ? h5 : g4;
                        if (!z2) {
                            g4 = h5;
                        }
                        if (com.facebook.yoga.g.a(h2)) {
                            h2 = h2;
                        }
                        if (!com.facebook.yoga.g.a(g2)) {
                            h3 = g2;
                        }
                        if (!com.facebook.yoga.g.a(f10)) {
                            h4 = f10;
                        }
                        h5 = !com.facebook.yoga.g.a(g4) ? g4 : h5;
                    }
                    f4 = 0.0f;
                } else {
                    f4 = 0.0f;
                }
                if (h2 > f4 || h3 > f4 || h5 > f4 || h4 > f4) {
                    if (this.q == null) {
                        this.q = new Path();
                    }
                    this.q.rewind();
                    this.q.addRoundRect(new RectF(f3, f2, width, height), new float[]{Math.max(h2 - k2.left, 0.0f), Math.max(h2 - k2.top, 0.0f), Math.max(h3 - k2.right, 0.0f), Math.max(h3 - k2.top, 0.0f), Math.max(h5 - k2.right, 0.0f), Math.max(h5 - k2.bottom, 0.0f), Math.max(h4 - k2.left, 0.0f), Math.max(h4 - k2.bottom, 0.0f)}, Path.Direction.CW);
                    canvas.clipPath(this.q);
                    f5 = f3;
                    z = true;
                } else {
                    f5 = f3;
                    z = false;
                }
            } else {
                f2 = 0.0f;
                z = false;
            }
            if (z) {
                return;
            }
            canvas.clipRect(new RectF(f5, f2, width, height));
        }
    }

    private int m(View view) {
        int i2 = this.f5551e;
        View[] viewArr = (View[]) e.f.k.a.a.c(this.f5550d);
        for (int i3 = 0; i3 < i2; i3++) {
            if (viewArr[i3] == view) {
                return i3;
            }
        }
        return -1;
    }

    private void o(int i2) {
        View[] viewArr = (View[]) e.f.k.a.a.c(this.f5550d);
        int i3 = this.f5551e;
        if (i2 == i3 - 1) {
            int i4 = i3 - 1;
            this.f5551e = i4;
            viewArr[i4] = null;
        } else if (i2 >= 0 && i2 < i3) {
            System.arraycopy(viewArr, i2 + 1, viewArr, i2, (i3 - i2) - 1);
            int i5 = this.f5551e - 1;
            this.f5551e = i5;
            viewArr[i5] = null;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private void u(Drawable drawable) {
        super.setBackground(drawable);
    }

    private void v(Rect rect) {
        e.f.k.a.a.c(this.f5550d);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f5551e; i3++) {
            w(rect, i3, i2);
            if (this.f5550d[i3].getParent() == null) {
                i2++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
        if (r7 != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void w(android.graphics.Rect r7, int r8, int r9) {
        /*
            r6 = this;
            com.facebook.react.bridge.UiThreadUtil.assertOnUiThread()
            android.view.View[] r0 = r6.f5550d
            java.lang.Object r0 = e.f.k.a.a.c(r0)
            android.view.View[] r0 = (android.view.View[]) r0
            r0 = r0[r8]
            android.graphics.Rect r1 = com.facebook.react.views.view.f.f5548b
            int r2 = r0.getLeft()
            int r3 = r0.getTop()
            int r4 = r0.getRight()
            int r5 = r0.getBottom()
            r1.set(r2, r3, r4, r5)
            int r2 = r1.left
            int r3 = r1.top
            int r4 = r1.right
            int r1 = r1.bottom
            boolean r7 = r7.intersects(r2, r3, r4, r1)
            android.view.animation.Animation r1 = r0.getAnimation()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L3e
            boolean r1 = r1.hasEnded()
            if (r1 != 0) goto L3e
            r1 = r3
            goto L3f
        L3e:
            r1 = r2
        L3f:
            if (r7 != 0) goto L4e
            android.view.ViewParent r4 = r0.getParent()
            if (r4 == 0) goto L4e
            if (r1 != 0) goto L4e
            int r8 = r8 - r9
            super.removeViewsInLayout(r8, r3)
            goto L62
        L4e:
            if (r7 == 0) goto L60
            android.view.ViewParent r1 = r0.getParent()
            if (r1 != 0) goto L60
            int r8 = r8 - r9
            android.view.ViewGroup$LayoutParams r7 = com.facebook.react.views.view.f.a
            super.addViewInLayout(r0, r8, r7, r3)
            r6.invalidate()
            goto L62
        L60:
            if (r7 == 0) goto L63
        L62:
            r2 = r3
        L63:
            if (r2 == 0) goto L74
            boolean r7 = r0 instanceof com.facebook.react.uimanager.r
            if (r7 == 0) goto L74
            com.facebook.react.uimanager.r r0 = (com.facebook.react.uimanager.r) r0
            boolean r7 = r0.getRemoveClippedSubviews()
            if (r7 == 0) goto L74
            r0.b()
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.f.w(android.graphics.Rect, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(View view) {
        if (!this.f5549c || getParent() == null) {
            return;
        }
        e.f.k.a.a.c(this.f5552f);
        e.f.k.a.a.c(this.f5550d);
        Rect rect = f5548b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (this.f5552f.intersects(rect.left, rect.top, rect.right, rect.bottom) != (view.getParent() != null)) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f5551e; i3++) {
                View[] viewArr = this.f5550d;
                if (viewArr[i3] == view) {
                    w(this.f5552f, i3, i2);
                    return;
                }
                if (viewArr[i3].getParent() == null) {
                    i2++;
                }
            }
        }
    }

    @Override // com.facebook.react.uimanager.c0
    public int a(int i2) {
        return this.p.d() ? this.p.a(getChildCount(), i2) : i2;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        this.p.b(view);
        setChildrenDrawingOrderEnabled(this.p.d());
        super.addView(view, i2, layoutParams);
    }

    @Override // com.facebook.react.uimanager.r
    public void b() {
        if (this.f5549c) {
            e.f.k.a.a.c(this.f5552f);
            e.f.k.a.a.c(this.f5550d);
            s.a(this, this.f5552f);
            v(this.f5552f);
        }
    }

    @Override // com.facebook.react.uimanager.c0
    public void d() {
        this.p.e();
        setChildrenDrawingOrderEnabled(this.p.d());
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            k(canvas);
            super.dispatchDraw(canvas);
        } catch (NullPointerException e2) {
            e.f.d.d.a.j("ReactNative", "NullPointerException when executing ViewGroup.dispatchDraw method", e2);
        } catch (StackOverflowError e3) {
            d0 a2 = e0.a(this);
            if (a2 != null) {
                a2.handleException(e3);
            } else if (getContext() instanceof ReactContext) {
                ((ReactContext) getContext()).handleException(new IllegalViewOperationException("StackOverflowException", this, e3));
            } else {
                throw e3;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(23)
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        try {
            super.dispatchProvideStructure(viewStructure);
        } catch (NullPointerException e2) {
            e.f.d.d.a.j("ReactNative", "NullPointerException when executing dispatchProvideStructure", e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.facebook.react.uimanager.r
    public void f(Rect rect) {
        rect.set(this.f5552f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAllChildrenCount() {
        return this.f5551e;
    }

    public int getBackgroundColor() {
        if (getBackground() != null) {
            return ((d) getBackground()).j();
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        return this.p.a(i2, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        if (e.f.m.v.a.f12893g) {
            return s.b(view, rect, point, this, this.f5554h);
        }
        return super.getChildVisibleRect(view, rect, point);
    }

    @Override // e.f.m.z.c
    public Rect getHitSlopRect() {
        return this.f5553g;
    }

    public String getOverflow() {
        return this.f5554h;
    }

    @Override // com.facebook.react.uimanager.v
    public p getPointerEvents() {
        return this.f5555j;
    }

    @Override // com.facebook.react.uimanager.r
    public boolean getRemoveClippedSubviews() {
        return this.f5549c;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(View view, int i2) {
        j(view, i2, a);
    }

    void j(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        e.f.k.a.a.a(this.f5549c);
        e.f.k.a.a.c(this.f5552f);
        e.f.k.a.a.c(this.f5550d);
        h(view, i2);
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (this.f5550d[i4].getParent() == null) {
                i3++;
            }
        }
        w(this.f5552f, i2, i3);
        view.addOnLayoutChangeListener(this.f5556k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View l(int i2) {
        return ((View[]) e.f.k.a.a.c(this.f5550d))[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        e.f.k.a.a.a(this.f5549c);
        e.f.k.a.a.c(this.f5550d);
        for (int i2 = 0; i2 < this.f5551e; i2++) {
            this.f5550d[i2].removeOnLayoutChangeListener(this.f5556k);
        }
        removeAllViewsInLayout();
        this.f5551e = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5549c) {
            b();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        p pVar;
        e.f.m.z.b bVar = this.m;
        if ((bVar != null && bVar.a(this, motionEvent)) || (pVar = this.f5555j) == p.NONE || pVar == p.BOX_ONLY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        j.a(i2, i3);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        d dVar;
        if (Build.VERSION.SDK_INT < 17 || (dVar = this.f5557l) == null) {
            return;
        }
        dVar.A(this.t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.f5549c) {
            b();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p pVar = this.f5555j;
        return (pVar == p.NONE || pVar == p.BOX_NONE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view) {
        UiThreadUtil.assertOnUiThread();
        e.f.k.a.a.a(this.f5549c);
        e.f.k.a.a.c(this.f5552f);
        e.f.k.a.a.c(this.f5550d);
        view.removeOnLayoutChangeListener(this.f5556k);
        int m = m(view);
        if (this.f5550d[m].getParent() != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < m; i3++) {
                if (this.f5550d[i3].getParent() == null) {
                    i2++;
                }
            }
            super.removeViewsInLayout(m - i2, 1);
        }
        o(m);
    }

    public void q() {
        if (this.v.equals("visible")) {
            setAlpha(this.u);
            return;
        }
        float rotationX = getRotationX();
        float rotationY = getRotationY();
        if (rotationX >= -90.0f && rotationX < 90.0f && rotationY >= -90.0f && rotationY < 90.0f) {
            setAlpha(this.u);
        } else {
            setAlpha(0.0f);
        }
    }

    public void r(int i2, float f2, float f3) {
        getOrCreateReactViewBackground().t(i2, f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        UiThreadUtil.assertOnUiThread();
        this.p.c(view);
        setChildrenDrawingOrderEnabled(this.p.d());
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        UiThreadUtil.assertOnUiThread();
        this.p.c(getChildAt(i2));
        setChildrenDrawingOrderEnabled(this.p.d());
        super.removeViewAt(i2);
    }

    @Override // android.view.View, android.view.ViewParent
    @SuppressLint({"MissingSuperCall"})
    public void requestLayout() {
    }

    public void s(float f2, int i2) {
        d orCreateReactViewBackground = getOrCreateReactViewBackground();
        orCreateReactViewBackground.z(f2, i2);
        if (Build.VERSION.SDK_INT < 18) {
            int i3 = orCreateReactViewBackground.p() ? 1 : 2;
            if (i3 != getLayerType()) {
                setLayerType(i3, null);
            }
        }
    }

    public void setBackfaceVisibility(String str) {
        this.v = str;
        q();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        throw new UnsupportedOperationException("This method is not supported for ReactViewGroup instances");
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (i2 == 0 && this.f5557l == null) {
            return;
        }
        getOrCreateReactViewBackground().x(i2);
    }

    public void setBorderRadius(float f2) {
        d orCreateReactViewBackground = getOrCreateReactViewBackground();
        orCreateReactViewBackground.y(f2);
        if (Build.VERSION.SDK_INT < 18) {
            int i2 = orCreateReactViewBackground.p() ? 1 : 2;
            if (i2 != getLayerType()) {
                setLayerType(i2, null);
            }
        }
    }

    public void setBorderStyle(String str) {
        getOrCreateReactViewBackground().v(str);
    }

    public void setHitSlopRect(Rect rect) {
        this.f5553g = rect;
    }

    public void setNeedsOffscreenAlphaCompositing(boolean z) {
        this.n = z;
    }

    @Override // e.f.m.z.d
    public void setOnInterceptTouchEventListener(e.f.m.z.b bVar) {
        this.m = bVar;
    }

    public void setOpacityIfPossible(float f2) {
        this.u = f2;
        q();
    }

    public void setOverflow(String str) {
        this.f5554h = str;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPointerEvents(p pVar) {
        this.f5555j = pVar;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z == this.f5549c) {
            return;
        }
        this.f5549c = z;
        if (z) {
            Rect rect = new Rect();
            this.f5552f = rect;
            s.a(this, rect);
            int childCount = getChildCount();
            this.f5551e = childCount;
            this.f5550d = new View[Math.max(12, childCount)];
            this.f5556k = new b();
            for (int i2 = 0; i2 < this.f5551e; i2++) {
                View childAt = getChildAt(i2);
                this.f5550d[i2] = childAt;
                childAt.addOnLayoutChangeListener(this.f5556k);
            }
            b();
            return;
        }
        e.f.k.a.a.c(this.f5552f);
        e.f.k.a.a.c(this.f5550d);
        e.f.k.a.a.c(this.f5556k);
        for (int i3 = 0; i3 < this.f5551e; i3++) {
            this.f5550d[i3].removeOnLayoutChangeListener(this.f5556k);
        }
        getDrawingRect(this.f5552f);
        v(this.f5552f);
        this.f5550d = null;
        this.f5552f = null;
        this.f5551e = 0;
        this.f5556k = null;
    }

    public void setTranslucentBackgroundDrawable(Drawable drawable) {
        u(null);
        if (this.f5557l != null && drawable != null) {
            u(new LayerDrawable(new Drawable[]{this.f5557l, drawable}));
        } else if (drawable != null) {
            u(drawable);
        }
    }

    public void t(int i2, float f2) {
        getOrCreateReactViewBackground().w(i2, f2);
    }
}