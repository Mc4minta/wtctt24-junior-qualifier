package c.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Fade.java */
/* loaded from: classes.dex */
public class f extends w0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Fade.java */
    /* loaded from: classes.dex */
    public class a extends z {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // c.s.y.g
        public void c(y yVar) {
            p0.h(this.a, 1.0f);
            p0.a(this.a);
            yVar.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Fade.java */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter {
        private final View a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3292b = false;

        b(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            p0.h(this.a, 1.0f);
            if (this.f3292b) {
                this.a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (c.h.k.v.N(this.a) && this.a.getLayerType() == 0) {
                this.f3292b = true;
                this.a.setLayerType(2, null);
            }
        }
    }

    public f(int i2) {
        h(i2);
    }

    private Animator i(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        p0.h(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, p0.f3339b, f3);
        ofFloat.addListener(new b(view));
        addListener(new a(view));
        return ofFloat;
    }

    private static float k(e0 e0Var, float f2) {
        Float f3;
        return (e0Var == null || (f3 = (Float) e0Var.a.get("android:fade:transitionAlpha")) == null) ? f2 : f3.floatValue();
    }

    @Override // c.s.w0
    public Animator c(ViewGroup viewGroup, View view, e0 e0Var, e0 e0Var2) {
        float k2 = k(e0Var, 0.0f);
        return i(view, k2 != 1.0f ? k2 : 0.0f, 1.0f);
    }

    @Override // c.s.w0, c.s.y
    public void captureStartValues(e0 e0Var) {
        super.captureStartValues(e0Var);
        e0Var.a.put("android:fade:transitionAlpha", Float.valueOf(p0.c(e0Var.f3289b)));
    }

    @Override // c.s.w0
    public Animator e(ViewGroup viewGroup, View view, e0 e0Var, e0 e0Var2) {
        p0.e(view);
        return i(view, k(e0Var, 1.0f), 0.0f);
    }
}