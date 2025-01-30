package c.s;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GhostViewPort.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class l extends ViewGroup implements i {
    ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    View f3325b;

    /* renamed from: c  reason: collision with root package name */
    final View f3326c;

    /* renamed from: d  reason: collision with root package name */
    int f3327d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f3328e;

    /* renamed from: f  reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f3329f;

    /* compiled from: GhostViewPort.java */
    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View view;
            c.h.k.v.b0(l.this);
            l lVar = l.this;
            ViewGroup viewGroup = lVar.a;
            if (viewGroup == null || (view = lVar.f3325b) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            c.h.k.v.b0(l.this.a);
            l lVar2 = l.this;
            lVar2.a = null;
            lVar2.f3325b = null;
            return true;
        }
    }

    l(View view) {
        super(view.getContext());
        this.f3329f = new a();
        this.f3326c = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l b(View view, ViewGroup viewGroup, Matrix matrix) {
        j jVar;
        if (view.getParent() instanceof ViewGroup) {
            j b2 = j.b(viewGroup);
            l e2 = e(view);
            int i2 = 0;
            if (e2 != null && (jVar = (j) e2.getParent()) != b2) {
                i2 = e2.f3327d;
                jVar.removeView(e2);
                e2 = null;
            }
            if (e2 == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    c(view, viewGroup, matrix);
                }
                e2 = new l(view);
                e2.h(matrix);
                if (b2 == null) {
                    b2 = new j(viewGroup);
                } else {
                    b2.g();
                }
                d(viewGroup, b2);
                d(viewGroup, e2);
                b2.a(e2);
                e2.f3327d = i2;
            } else if (matrix != null) {
                e2.h(matrix);
            }
            e2.f3327d++;
            return e2;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    static void c(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        p0.j(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        p0.k(viewGroup, matrix);
    }

    static void d(View view, View view2) {
        p0.g(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static l e(View view) {
        return (l) view.getTag(s.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(View view) {
        l e2 = e(view);
        if (e2 != null) {
            int i2 = e2.f3327d - 1;
            e2.f3327d = i2;
            if (i2 <= 0) {
                ((j) e2.getParent()).removeView(e2);
            }
        }
    }

    static void g(View view, l lVar) {
        view.setTag(s.a, lVar);
    }

    @Override // c.s.i
    public void a(ViewGroup viewGroup, View view) {
        this.a = viewGroup;
        this.f3325b = view;
    }

    void h(Matrix matrix) {
        this.f3328e = matrix;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g(this.f3326c, this);
        this.f3326c.getViewTreeObserver().addOnPreDrawListener(this.f3329f);
        p0.i(this.f3326c, 4);
        if (this.f3326c.getParent() != null) {
            ((View) this.f3326c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f3326c.getViewTreeObserver().removeOnPreDrawListener(this.f3329f);
        p0.i(this.f3326c, 0);
        g(this.f3326c, null);
        if (this.f3326c.getParent() != null) {
            ((View) this.f3326c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        c.a(canvas, true);
        canvas.setMatrix(this.f3328e);
        p0.i(this.f3326c, 0);
        this.f3326c.invalidate();
        p0.i(this.f3326c, 4);
        drawChild(canvas, this.f3326c, getDrawingTime());
        c.a(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View, c.s.i
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (e(this.f3326c) == this) {
            p0.i(this.f3326c, i2 == 0 ? 4 : 0);
        }
    }
}