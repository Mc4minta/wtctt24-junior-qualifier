package com.swmansion.reanimated.f;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import c.s.e0;
import c.s.w0;
import c.s.y;
import c.s.z;

/* compiled from: Scale.java */
/* loaded from: classes2.dex */
public class b extends w0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Scale.java */
    /* loaded from: classes2.dex */
    public class a extends z {
        final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f10960b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f10961c;

        a(View view, float f2, float f3) {
            this.a = view;
            this.f10960b = f2;
            this.f10961c = f3;
        }

        @Override // c.s.y.g
        public void c(y yVar) {
            this.a.setScaleX(this.f10960b);
            this.a.setScaleY(this.f10961c);
            yVar.removeListener(this);
        }
    }

    private Animator i(View view, float f2, float f3, e0 e0Var) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        float f4 = scaleX * f2;
        float f5 = scaleX * f3;
        float f6 = f2 * scaleY;
        float f7 = f3 * scaleY;
        if (e0Var != null) {
            Float f8 = (Float) e0Var.a.get("scale:scaleX");
            Float f9 = (Float) e0Var.a.get("scale:scaleY");
            if (f8 != null && f8.floatValue() != scaleX) {
                f4 = f8.floatValue();
            }
            if (f9 != null && f9.floatValue() != scaleY) {
                f6 = f9.floatValue();
            }
        }
        view.setScaleX(f4);
        view.setScaleY(f6);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, View.SCALE_X, f4, f5), ObjectAnimator.ofFloat(view, View.SCALE_Y, f6, f7));
        addListener(new a(view, scaleX, scaleY));
        return animatorSet;
    }

    @Override // c.s.w0
    public Animator c(ViewGroup viewGroup, View view, e0 e0Var, e0 e0Var2) {
        return i(view, 0.0f, 1.0f, e0Var);
    }

    @Override // c.s.w0, c.s.y
    public void captureStartValues(e0 e0Var) {
        super.captureStartValues(e0Var);
        e0Var.a.put("scale:scaleX", Float.valueOf(e0Var.f3289b.getScaleX()));
        e0Var.a.put("scale:scaleY", Float.valueOf(e0Var.f3289b.getScaleY()));
    }

    @Override // c.s.w0
    public Animator e(ViewGroup viewGroup, View view, e0 e0Var, e0 e0Var2) {
        return i(view, 1.0f, 0.0f, e0Var);
    }
}