package c.s;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* compiled from: Slide.java */
/* loaded from: classes.dex */
public class w extends w0 {

    /* renamed from: c  reason: collision with root package name */
    private static final TimeInterpolator f3367c = new DecelerateInterpolator();

    /* renamed from: d  reason: collision with root package name */
    private static final TimeInterpolator f3368d = new AccelerateInterpolator();

    /* renamed from: e  reason: collision with root package name */
    private static final g f3369e = new a();

    /* renamed from: f  reason: collision with root package name */
    private static final g f3370f = new b();

    /* renamed from: g  reason: collision with root package name */
    private static final g f3371g = new c();

    /* renamed from: h  reason: collision with root package name */
    private static final g f3372h = new d();

    /* renamed from: j  reason: collision with root package name */
    private static final g f3373j = new e();

    /* renamed from: k  reason: collision with root package name */
    private static final g f3374k = new f();

    /* renamed from: l  reason: collision with root package name */
    private g f3375l = f3374k;
    private int m = 80;

    /* compiled from: Slide.java */
    /* loaded from: classes.dex */
    static class a extends h {
        a() {
            super(null);
        }

        @Override // c.s.w.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    /* compiled from: Slide.java */
    /* loaded from: classes.dex */
    static class b extends h {
        b() {
            super(null);
        }

        @Override // c.s.w.g
        public float b(ViewGroup viewGroup, View view) {
            if (c.h.k.v.y(viewGroup) == 1) {
                return view.getTranslationX() + viewGroup.getWidth();
            }
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    /* compiled from: Slide.java */
    /* loaded from: classes.dex */
    static class c extends i {
        c() {
            super(null);
        }

        @Override // c.s.w.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    }

    /* compiled from: Slide.java */
    /* loaded from: classes.dex */
    static class d extends h {
        d() {
            super(null);
        }

        @Override // c.s.w.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* compiled from: Slide.java */
    /* loaded from: classes.dex */
    static class e extends h {
        e() {
            super(null);
        }

        @Override // c.s.w.g
        public float b(ViewGroup viewGroup, View view) {
            if (c.h.k.v.y(viewGroup) == 1) {
                return view.getTranslationX() - viewGroup.getWidth();
            }
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* compiled from: Slide.java */
    /* loaded from: classes.dex */
    static class f extends i {
        f() {
            super(null);
        }

        @Override // c.s.w.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Slide.java */
    /* loaded from: classes.dex */
    public interface g {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    /* compiled from: Slide.java */
    /* loaded from: classes.dex */
    private static abstract class h implements g {
        private h() {
        }

        @Override // c.s.w.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* compiled from: Slide.java */
    /* loaded from: classes.dex */
    private static abstract class i implements g {
        private i() {
        }

        @Override // c.s.w.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    public w(int i2) {
        i(i2);
    }

    private void captureValues(e0 e0Var) {
        int[] iArr = new int[2];
        e0Var.f3289b.getLocationOnScreen(iArr);
        e0Var.a.put("android:slide:screenPosition", iArr);
    }

    @Override // c.s.w0
    public Animator c(ViewGroup viewGroup, View view, e0 e0Var, e0 e0Var2) {
        if (e0Var2 == null) {
            return null;
        }
        int[] iArr = (int[]) e0Var2.a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return g0.a(view, e0Var2, iArr[0], iArr[1], this.f3375l.b(viewGroup, view), this.f3375l.a(viewGroup, view), translationX, translationY, f3367c, this);
    }

    @Override // c.s.w0, c.s.y
    public void captureEndValues(e0 e0Var) {
        super.captureEndValues(e0Var);
        captureValues(e0Var);
    }

    @Override // c.s.w0, c.s.y
    public void captureStartValues(e0 e0Var) {
        super.captureStartValues(e0Var);
        captureValues(e0Var);
    }

    @Override // c.s.w0
    public Animator e(ViewGroup viewGroup, View view, e0 e0Var, e0 e0Var2) {
        if (e0Var == null) {
            return null;
        }
        int[] iArr = (int[]) e0Var.a.get("android:slide:screenPosition");
        return g0.a(view, e0Var, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f3375l.b(viewGroup, view), this.f3375l.a(viewGroup, view), f3368d, this);
    }

    public void i(int i2) {
        if (i2 == 3) {
            this.f3375l = f3369e;
        } else if (i2 == 5) {
            this.f3375l = f3372h;
        } else if (i2 == 48) {
            this.f3375l = f3371g;
        } else if (i2 == 80) {
            this.f3375l = f3374k;
        } else if (i2 == 8388611) {
            this.f3375l = f3370f;
        } else if (i2 == 8388613) {
            this.f3375l = f3373j;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.m = i2;
        v vVar = new v();
        vVar.j(i2);
        setPropagation(vVar);
    }
}