package c.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import c.s.y;

/* compiled from: TranslationAnimationCreator.java */
/* loaded from: classes.dex */
class g0 {

    /* compiled from: TranslationAnimationCreator.java */
    /* loaded from: classes.dex */
    private static class a extends AnimatorListenerAdapter implements y.g {
        private final View a;

        /* renamed from: b  reason: collision with root package name */
        private final View f3296b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3297c;

        /* renamed from: d  reason: collision with root package name */
        private final int f3298d;

        /* renamed from: e  reason: collision with root package name */
        private int[] f3299e;

        /* renamed from: f  reason: collision with root package name */
        private float f3300f;

        /* renamed from: g  reason: collision with root package name */
        private float f3301g;

        /* renamed from: h  reason: collision with root package name */
        private final float f3302h;

        /* renamed from: i  reason: collision with root package name */
        private final float f3303i;

        a(View view, View view2, int i2, int i3, float f2, float f3) {
            this.f3296b = view;
            this.a = view2;
            this.f3297c = i2 - Math.round(view.getTranslationX());
            this.f3298d = i3 - Math.round(view.getTranslationY());
            this.f3302h = f2;
            this.f3303i = f3;
            int i4 = s.f3356h;
            int[] iArr = (int[]) view2.getTag(i4);
            this.f3299e = iArr;
            if (iArr != null) {
                view2.setTag(i4, null);
            }
        }

        @Override // c.s.y.g
        public void a(y yVar) {
        }

        @Override // c.s.y.g
        public void b(y yVar) {
        }

        @Override // c.s.y.g
        public void c(y yVar) {
            this.f3296b.setTranslationX(this.f3302h);
            this.f3296b.setTranslationY(this.f3303i);
            yVar.removeListener(this);
        }

        @Override // c.s.y.g
        public void d(y yVar) {
        }

        @Override // c.s.y.g
        public void e(y yVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f3299e == null) {
                this.f3299e = new int[2];
            }
            this.f3299e[0] = Math.round(this.f3297c + this.f3296b.getTranslationX());
            this.f3299e[1] = Math.round(this.f3298d + this.f3296b.getTranslationY());
            this.a.setTag(s.f3356h, this.f3299e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f3300f = this.f3296b.getTranslationX();
            this.f3301g = this.f3296b.getTranslationY();
            this.f3296b.setTranslationX(this.f3302h);
            this.f3296b.setTranslationY(this.f3303i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.f3296b.setTranslationX(this.f3300f);
            this.f3296b.setTranslationY(this.f3301g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Animator a(View view, e0 e0Var, int i2, int i3, float f2, float f3, float f4, float f5, TimeInterpolator timeInterpolator, y yVar) {
        float f6;
        float f7;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) e0Var.f3289b.getTag(s.f3356h);
        if (iArr != null) {
            f6 = (iArr[0] - i2) + translationX;
            f7 = (iArr[1] - i3) + translationY;
        } else {
            f6 = f2;
            f7 = f3;
        }
        int round = i2 + Math.round(f6 - translationX);
        int round2 = i3 + Math.round(f7 - translationY);
        view.setTranslationX(f6);
        view.setTranslationY(f7);
        if (f6 == f4 && f7 == f5) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f6, f4), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f7, f5));
        a aVar = new a(view, e0Var.f3289b, round, round2, translationX, translationY);
        yVar.addListener(aVar);
        ofPropertyValuesHolder.addListener(aVar);
        c.s.a.a(ofPropertyValuesHolder, aVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}