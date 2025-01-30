package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.s.e0;
import c.s.y;
import java.util.Map;

/* compiled from: TextScale.java */
/* loaded from: classes2.dex */
public class g extends y {

    /* compiled from: TextScale.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TextView a;

        a(TextView textView) {
            this.a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.a.setScaleX(floatValue);
            this.a.setScaleY(floatValue);
        }
    }

    private void captureValues(e0 e0Var) {
        View view = e0Var.f3289b;
        if (view instanceof TextView) {
            e0Var.a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
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
        if (e0Var == null || e0Var2 == null || !(e0Var.f3289b instanceof TextView)) {
            return null;
        }
        View view = e0Var2.f3289b;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            Map<String, Object> map = e0Var.a;
            Map<String, Object> map2 = e0Var2.a;
            float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
            float floatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
            if (floatValue == floatValue2) {
                return null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
            ofFloat.addUpdateListener(new a(textView));
            return ofFloat;
        }
        return null;
    }
}