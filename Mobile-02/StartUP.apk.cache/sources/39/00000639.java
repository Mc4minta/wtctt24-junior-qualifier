package c.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ChangeTransform.java */
/* loaded from: classes.dex */
public class e extends y {
    private static final String[] a = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};

    /* renamed from: b  reason: collision with root package name */
    private static final Property<C0091e, float[]> f3264b = new a(float[].class, "nonTranslations");

    /* renamed from: c  reason: collision with root package name */
    private static final Property<C0091e, PointF> f3265c = new b(PointF.class, "translations");

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f3266d;

    /* renamed from: e  reason: collision with root package name */
    boolean f3267e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3268f = true;

    /* renamed from: g  reason: collision with root package name */
    private Matrix f3269g = new Matrix();

    /* compiled from: ChangeTransform.java */
    /* loaded from: classes.dex */
    static class a extends Property<C0091e, float[]> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public float[] get(C0091e c0091e) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(C0091e c0091e, float[] fArr) {
            c0091e.d(fArr);
        }
    }

    /* compiled from: ChangeTransform.java */
    /* loaded from: classes.dex */
    static class b extends Property<C0091e, PointF> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(C0091e c0091e) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(C0091e c0091e, PointF pointF) {
            c0091e.c(pointF);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChangeTransform.java */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        private boolean a;

        /* renamed from: b  reason: collision with root package name */
        private Matrix f3270b = new Matrix();

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f3271c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Matrix f3272d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f3273e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ f f3274f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ C0091e f3275g;

        c(boolean z, Matrix matrix, View view, f fVar, C0091e c0091e) {
            this.f3271c = z;
            this.f3272d = matrix;
            this.f3273e = view;
            this.f3274f = fVar;
            this.f3275g = c0091e;
        }

        private void a(Matrix matrix) {
            this.f3270b.set(matrix);
            this.f3273e.setTag(s.f3357i, this.f3270b);
            this.f3274f.a(this.f3273e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.a) {
                if (this.f3271c && e.this.f3267e) {
                    a(this.f3272d);
                } else {
                    this.f3273e.setTag(s.f3357i, null);
                    this.f3273e.setTag(s.f3351c, null);
                }
            }
            p0.f(this.f3273e, null);
            this.f3274f.a(this.f3273e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            a(this.f3275g.a());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            e.e(this.f3273e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChangeTransform.java */
    /* loaded from: classes.dex */
    public static class d extends z {
        private View a;

        /* renamed from: b  reason: collision with root package name */
        private i f3277b;

        d(View view, i iVar) {
            this.a = view;
            this.f3277b = iVar;
        }

        @Override // c.s.z, c.s.y.g
        public void b(y yVar) {
            this.f3277b.setVisibility(4);
        }

        @Override // c.s.y.g
        public void c(y yVar) {
            yVar.removeListener(this);
            m.b(this.a);
            this.a.setTag(s.f3357i, null);
            this.a.setTag(s.f3351c, null);
        }

        @Override // c.s.z, c.s.y.g
        public void e(y yVar) {
            this.f3277b.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChangeTransform.java */
    /* renamed from: c.s.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0091e {
        private final Matrix a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private final View f3278b;

        /* renamed from: c  reason: collision with root package name */
        private final float[] f3279c;

        /* renamed from: d  reason: collision with root package name */
        private float f3280d;

        /* renamed from: e  reason: collision with root package name */
        private float f3281e;

        C0091e(View view, float[] fArr) {
            this.f3278b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f3279c = fArr2;
            this.f3280d = fArr2[2];
            this.f3281e = fArr2[5];
            b();
        }

        private void b() {
            float[] fArr = this.f3279c;
            fArr[2] = this.f3280d;
            fArr[5] = this.f3281e;
            this.a.setValues(fArr);
            p0.f(this.f3278b, this.a);
        }

        Matrix a() {
            return this.a;
        }

        void c(PointF pointF) {
            this.f3280d = pointF.x;
            this.f3281e = pointF.y;
            b();
        }

        void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f3279c, 0, fArr.length);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChangeTransform.java */
    /* loaded from: classes.dex */
    public static class f {
        final float a;

        /* renamed from: b  reason: collision with root package name */
        final float f3282b;

        /* renamed from: c  reason: collision with root package name */
        final float f3283c;

        /* renamed from: d  reason: collision with root package name */
        final float f3284d;

        /* renamed from: e  reason: collision with root package name */
        final float f3285e;

        /* renamed from: f  reason: collision with root package name */
        final float f3286f;

        /* renamed from: g  reason: collision with root package name */
        final float f3287g;

        /* renamed from: h  reason: collision with root package name */
        final float f3288h;

        f(View view) {
            this.a = view.getTranslationX();
            this.f3282b = view.getTranslationY();
            this.f3283c = c.h.k.v.I(view);
            this.f3284d = view.getScaleX();
            this.f3285e = view.getScaleY();
            this.f3286f = view.getRotationX();
            this.f3287g = view.getRotationY();
            this.f3288h = view.getRotation();
        }

        public void a(View view) {
            e.h(view, this.a, this.f3282b, this.f3283c, this.f3284d, this.f3285e, this.f3286f, this.f3287g, this.f3288h);
        }

        public boolean equals(Object obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                return fVar.a == this.a && fVar.f3282b == this.f3282b && fVar.f3283c == this.f3283c && fVar.f3284d == this.f3284d && fVar.f3285e == this.f3285e && fVar.f3286f == this.f3286f && fVar.f3287g == this.f3287g && fVar.f3288h == this.f3288h;
            }
            return false;
        }

        public int hashCode() {
            float f2 = this.a;
            int floatToIntBits = (f2 != 0.0f ? Float.floatToIntBits(f2) : 0) * 31;
            float f3 = this.f3282b;
            int floatToIntBits2 = (floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f3283c;
            int floatToIntBits3 = (floatToIntBits2 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.f3284d;
            int floatToIntBits4 = (floatToIntBits3 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f3285e;
            int floatToIntBits5 = (floatToIntBits4 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f3286f;
            int floatToIntBits6 = (floatToIntBits5 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.f3287g;
            int floatToIntBits7 = (floatToIntBits6 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31;
            float f9 = this.f3288h;
            return floatToIntBits7 + (f9 != 0.0f ? Float.floatToIntBits(f9) : 0);
        }
    }

    static {
        f3266d = Build.VERSION.SDK_INT >= 21;
    }

    private void b(ViewGroup viewGroup, e0 e0Var, e0 e0Var2) {
        View view = e0Var2.f3289b;
        Matrix matrix = new Matrix((Matrix) e0Var2.a.get("android:changeTransform:parentMatrix"));
        p0.k(viewGroup, matrix);
        i a2 = m.a(view, viewGroup, matrix);
        if (a2 == null) {
            return;
        }
        a2.a((ViewGroup) e0Var.a.get("android:changeTransform:parent"), e0Var.f3289b);
        y yVar = this;
        while (true) {
            y yVar2 = yVar.mParent;
            if (yVar2 == null) {
                break;
            }
            yVar = yVar2;
        }
        yVar.addListener(new d(view, a2));
        if (f3266d) {
            View view2 = e0Var.f3289b;
            if (view2 != e0Var2.f3289b) {
                p0.h(view2, 0.0f);
            }
            p0.h(view, 1.0f);
        }
    }

    private ObjectAnimator c(e0 e0Var, e0 e0Var2, boolean z) {
        Matrix matrix = (Matrix) e0Var.a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) e0Var2.a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = n.a;
        }
        if (matrix2 == null) {
            matrix2 = n.a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        f fVar = (f) e0Var2.a.get("android:changeTransform:transforms");
        View view = e0Var2.f3289b;
        e(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        C0091e c0091e = new C0091e(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(c0091e, PropertyValuesHolder.ofObject(f3264b, new g(new float[9]), fArr, fArr2), r.a(f3265c, getPathMotion().a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        c cVar = new c(z, matrix3, view, fVar, c0091e);
        ofPropertyValuesHolder.addListener(cVar);
        c.s.a.a(ofPropertyValuesHolder, cVar);
        return ofPropertyValuesHolder;
    }

    private void captureValues(e0 e0Var) {
        View view = e0Var.f3289b;
        if (view.getVisibility() == 8) {
            return;
        }
        e0Var.a.put("android:changeTransform:parent", view.getParent());
        e0Var.a.put("android:changeTransform:transforms", new f(view));
        Matrix matrix = view.getMatrix();
        e0Var.a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.f3268f) {
            Matrix matrix2 = new Matrix();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            p0.j(viewGroup, matrix2);
            matrix2.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
            e0Var.a.put("android:changeTransform:parentMatrix", matrix2);
            e0Var.a.put("android:changeTransform:intermediateMatrix", view.getTag(s.f3357i));
            e0Var.a.put("android:changeTransform:intermediateParentMatrix", view.getTag(s.f3351c));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r5 == r4.f3289b) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (r4 == r5) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001f, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.isValidTarget(r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1a
            boolean r0 = r3.isValidTarget(r5)
            if (r0 != 0) goto Lf
            goto L1a
        Lf:
            c.s.e0 r4 = r3.getMatchedTransitionValues(r4, r1)
            if (r4 == 0) goto L1f
            android.view.View r4 = r4.f3289b
            if (r5 != r4) goto L1d
            goto L1e
        L1a:
            if (r4 != r5) goto L1d
            goto L1e
        L1d:
            r1 = r2
        L1e:
            r2 = r1
        L1f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.s.e.d(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    static void e(View view) {
        h(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void f(e0 e0Var, e0 e0Var2) {
        Matrix matrix = (Matrix) e0Var2.a.get("android:changeTransform:parentMatrix");
        e0Var2.f3289b.setTag(s.f3351c, matrix);
        Matrix matrix2 = this.f3269g;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) e0Var.a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            e0Var.a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) e0Var.a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    static void h(View view, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        c.h.k.v.B0(view, f4);
        view.setScaleX(f5);
        view.setScaleY(f6);
        view.setRotationX(f7);
        view.setRotationY(f8);
        view.setRotation(f9);
    }

    @Override // c.s.y
    public void captureEndValues(e0 e0Var) {
        captureValues(e0Var);
    }

    @Override // c.s.y
    public void captureStartValues(e0 e0Var) {
        captureValues(e0Var);
        if (f3266d) {
            return;
        }
        ((ViewGroup) e0Var.f3289b.getParent()).startViewTransition(e0Var.f3289b);
    }

    @Override // c.s.y
    public Animator createAnimator(ViewGroup viewGroup, e0 e0Var, e0 e0Var2) {
        if (e0Var == null || e0Var2 == null || !e0Var.a.containsKey("android:changeTransform:parent") || !e0Var2.a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) e0Var.a.get("android:changeTransform:parent");
        boolean z = this.f3268f && !d(viewGroup2, (ViewGroup) e0Var2.a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) e0Var.a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            e0Var.a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) e0Var.a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            e0Var.a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z) {
            f(e0Var, e0Var2);
        }
        ObjectAnimator c2 = c(e0Var, e0Var2, z);
        if (z && c2 != null && this.f3267e) {
            b(viewGroup, e0Var, e0Var2);
        } else if (!f3266d) {
            viewGroup2.endViewTransition(e0Var.f3289b);
        }
        return c2;
    }

    @Override // c.s.y
    public String[] getTransitionProperties() {
        return a;
    }
}