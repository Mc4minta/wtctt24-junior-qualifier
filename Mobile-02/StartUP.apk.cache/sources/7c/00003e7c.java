package com.rd.b.d;

import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;

/* compiled from: ColorAnimation.java */
/* loaded from: classes2.dex */
public class c extends b<ValueAnimator> {

    /* renamed from: d  reason: collision with root package name */
    private com.rd.b.c.b.a f10596d;

    /* renamed from: e  reason: collision with root package name */
    int f10597e;

    /* renamed from: f  reason: collision with root package name */
    int f10598f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ColorAnimation.java */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.j(valueAnimator);
        }
    }

    public c(b.a aVar) {
        super(aVar);
        this.f10596d = new com.rd.b.c.b.a();
    }

    private boolean i(int i2, int i3) {
        return (this.f10597e == i2 && this.f10598f == i3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        this.f10596d.c(intValue);
        this.f10596d.d(intValue2);
        b.a aVar = this.f10594b;
        if (aVar != null) {
            aVar.a(this.f10596d);
        }
    }

    @Override // com.rd.b.d.b
    /* renamed from: g */
    public ValueAnimator a() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new a());
        return valueAnimator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PropertyValuesHolder h(boolean z) {
        int i2;
        int i3;
        String str;
        if (z) {
            i2 = this.f10598f;
            i3 = this.f10597e;
            str = "ANIMATION_COLOR_REVERSE";
        } else {
            i2 = this.f10597e;
            i3 = this.f10598f;
            str = "ANIMATION_COLOR";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i2, i3);
        ofInt.setEvaluator(new ArgbEvaluator());
        return ofInt;
    }

    @Override // com.rd.b.d.b
    /* renamed from: k */
    public c d(float f2) {
        T t = this.f10595c;
        if (t != 0) {
            long j2 = f2 * ((float) this.a);
            if (((ValueAnimator) t).getValues() != null && ((ValueAnimator) this.f10595c).getValues().length > 0) {
                ((ValueAnimator) this.f10595c).setCurrentPlayTime(j2);
            }
        }
        return this;
    }

    public c l(int i2, int i3) {
        if (this.f10595c != 0 && i(i2, i3)) {
            this.f10597e = i2;
            this.f10598f = i3;
            ((ValueAnimator) this.f10595c).setValues(h(false), h(true));
        }
        return this;
    }
}