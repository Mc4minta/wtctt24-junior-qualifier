package c.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: ChangeBounds.java */
/* loaded from: classes.dex */
public class d extends y {
    private static final String[] a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: b  reason: collision with root package name */
    private static final Property<Drawable, PointF> f3232b = new b(PointF.class, "boundsOrigin");

    /* renamed from: c  reason: collision with root package name */
    private static final Property<k, PointF> f3233c = new c(PointF.class, "topLeft");

    /* renamed from: d  reason: collision with root package name */
    private static final Property<k, PointF> f3234d = new C0090d(PointF.class, "bottomRight");

    /* renamed from: e  reason: collision with root package name */
    private static final Property<View, PointF> f3235e = new e(PointF.class, "bottomRight");

    /* renamed from: f  reason: collision with root package name */
    private static final Property<View, PointF> f3236f = new f(PointF.class, "topLeft");

    /* renamed from: g  reason: collision with root package name */
    private static final Property<View, PointF> f3237g = new g(PointF.class, "position");

    /* renamed from: h  reason: collision with root package name */
    private static t f3238h = new t();

    /* renamed from: j  reason: collision with root package name */
    private int[] f3239j = new int[2];

    /* renamed from: k  reason: collision with root package name */
    private boolean f3240k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3241l = false;

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f3242b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3243c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f3244d;

        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f2) {
            this.a = viewGroup;
            this.f3242b = bitmapDrawable;
            this.f3243c = view;
            this.f3244d = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            p0.b(this.a).b(this.f3242b);
            p0.h(this.f3243c, this.f3244d);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class b extends Property<Drawable, PointF> {
        private Rect a;

        b(Class cls, String str) {
            super(cls, str);
            this.a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            Rect rect = this.a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.a);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class c extends Property<k, PointF> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: c.s.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0090d extends Property<k, PointF> {
        C0090d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            p0.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            p0.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            p0.g(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    class h extends AnimatorListenerAdapter {
        final /* synthetic */ k a;
        private k mViewBounds;

        h(k kVar) {
            this.a = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    class i extends AnimatorListenerAdapter {
        private boolean a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f3247b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Rect f3248c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f3249d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f3250e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f3251f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f3252g;

        i(View view, Rect rect, int i2, int i3, int i4, int i5) {
            this.f3247b = view;
            this.f3248c = rect;
            this.f3249d = i2;
            this.f3250e = i3;
            this.f3251f = i4;
            this.f3252g = i5;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            c.h.k.v.p0(this.f3247b, this.f3248c);
            p0.g(this.f3247b, this.f3249d, this.f3250e, this.f3251f, this.f3252g);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    class j extends z {
        boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f3254b;

        j(ViewGroup viewGroup) {
            this.f3254b = viewGroup;
        }

        @Override // c.s.z, c.s.y.g
        public void b(y yVar) {
            k0.d(this.f3254b, false);
        }

        @Override // c.s.y.g
        public void c(y yVar) {
            if (!this.a) {
                k0.d(this.f3254b, false);
            }
            yVar.removeListener(this);
        }

        @Override // c.s.z, c.s.y.g
        public void d(y yVar) {
            k0.d(this.f3254b, false);
            this.a = true;
        }

        @Override // c.s.z, c.s.y.g
        public void e(y yVar) {
            k0.d(this.f3254b, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public static class k {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f3256b;

        /* renamed from: c  reason: collision with root package name */
        private int f3257c;

        /* renamed from: d  reason: collision with root package name */
        private int f3258d;

        /* renamed from: e  reason: collision with root package name */
        private View f3259e;

        /* renamed from: f  reason: collision with root package name */
        private int f3260f;

        /* renamed from: g  reason: collision with root package name */
        private int f3261g;

        k(View view) {
            this.f3259e = view;
        }

        private void b() {
            p0.g(this.f3259e, this.a, this.f3256b, this.f3257c, this.f3258d);
            this.f3260f = 0;
            this.f3261g = 0;
        }

        void a(PointF pointF) {
            this.f3257c = Math.round(pointF.x);
            this.f3258d = Math.round(pointF.y);
            int i2 = this.f3261g + 1;
            this.f3261g = i2;
            if (this.f3260f == i2) {
                b();
            }
        }

        void c(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.f3256b = Math.round(pointF.y);
            int i2 = this.f3260f + 1;
            this.f3260f = i2;
            if (i2 == this.f3261g) {
                b();
            }
        }
    }

    private boolean b(View view, View view2) {
        if (this.f3241l) {
            e0 matchedTransitionValues = getMatchedTransitionValues(view, true);
            if (matchedTransitionValues == null) {
                if (view == view2) {
                    return true;
                }
            } else if (view2 == matchedTransitionValues.f3289b) {
                return true;
            }
            return false;
        }
        return true;
    }

    private void captureValues(e0 e0Var) {
        View view = e0Var.f3289b;
        if (!c.h.k.v.S(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        e0Var.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        e0Var.a.put("android:changeBounds:parent", e0Var.f3289b.getParent());
        if (this.f3241l) {
            e0Var.f3289b.getLocationInWindow(this.f3239j);
            e0Var.a.put("android:changeBounds:windowX", Integer.valueOf(this.f3239j[0]));
            e0Var.a.put("android:changeBounds:windowY", Integer.valueOf(this.f3239j[1]));
        }
        if (this.f3240k) {
            e0Var.a.put("android:changeBounds:clip", c.h.k.v.r(view));
        }
    }

    @Override // c.s.y
    public void captureEndValues(e0 e0Var) {
        captureValues(e0Var);
    }

    @Override // c.s.y
    public void captureStartValues(e0 e0Var) {
        captureValues(e0Var);
    }

    @Override // c.s.y
    public Animator createAnimator(ViewGroup viewGroup, e0 e0Var, e0 e0Var2) {
        int i2;
        View view;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator c2;
        if (e0Var == null || e0Var2 == null) {
            return null;
        }
        Map<String, Object> map = e0Var.a;
        Map<String, Object> map2 = e0Var2.a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = e0Var2.f3289b;
        if (b(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) e0Var.a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) e0Var2.a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            Rect rect4 = (Rect) e0Var.a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) e0Var2.a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (i8 != i9 || i10 != i11) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 > 0) {
                if (!this.f3240k) {
                    view = view2;
                    p0.g(view, i4, i6, i8, i10);
                    if (i2 == 2) {
                        if (i12 == i14 && i13 == i15) {
                            c2 = o.a(view, f3237g, getPathMotion().a(i4, i6, i5, i7));
                        } else {
                            k kVar = new k(view);
                            ObjectAnimator a2 = o.a(kVar, f3233c, getPathMotion().a(i4, i6, i5, i7));
                            ObjectAnimator a3 = o.a(kVar, f3234d, getPathMotion().a(i8, i10, i9, i11));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(a2, a3);
                            animatorSet.addListener(new h(kVar));
                            c2 = animatorSet;
                        }
                    } else if (i4 == i5 && i6 == i7) {
                        c2 = o.a(view, f3235e, getPathMotion().a(i8, i10, i9, i11));
                    } else {
                        c2 = o.a(view, f3236f, getPathMotion().a(i4, i6, i5, i7));
                    }
                } else {
                    view = view2;
                    p0.g(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                    ObjectAnimator a4 = (i4 == i5 && i6 == i7) ? null : o.a(view, f3237g, getPathMotion().a(i4, i6, i5, i7));
                    if (rect4 == null) {
                        i3 = 0;
                        rect = new Rect(0, 0, i12, i13);
                    } else {
                        i3 = 0;
                        rect = rect4;
                    }
                    Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
                    if (rect.equals(rect6)) {
                        objectAnimator = null;
                    } else {
                        c.h.k.v.p0(view, rect);
                        t tVar = f3238h;
                        Object[] objArr = new Object[2];
                        objArr[i3] = rect;
                        objArr[1] = rect6;
                        ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", tVar, objArr);
                        ofObject.addListener(new i(view, rect5, i5, i7, i9, i11));
                        objectAnimator = ofObject;
                    }
                    c2 = d0.c(a4, objectAnimator);
                }
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    k0.d(viewGroup4, true);
                    addListener(new j(viewGroup4));
                }
                return c2;
            }
            return null;
        }
        int intValue = ((Integer) e0Var.a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) e0Var.a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) e0Var2.a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) e0Var2.a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.f3239j);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c3 = p0.c(view2);
        p0.h(view2, 0.0f);
        p0.b(viewGroup).a(bitmapDrawable);
        p pathMotion = getPathMotion();
        int[] iArr = this.f3239j;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, r.a(f3232b, pathMotion.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
        ofPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, c3));
        return ofPropertyValuesHolder;
    }

    @Override // c.s.y
    public String[] getTransitionProperties() {
        return a;
    }
}