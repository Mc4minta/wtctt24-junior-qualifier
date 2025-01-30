package com.rd.b.d;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;

/* compiled from: ScaleAnimation.java */
/* loaded from: classes2.dex */
public class f extends c {

    /* renamed from: g  reason: collision with root package name */
    int f10612g;

    /* renamed from: h  reason: collision with root package name */
    float f10613h;

    /* renamed from: i  reason: collision with root package name */
    private com.rd.b.c.b.d f10614i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScaleAnimation.java */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f.this.j(valueAnimator);
        }
    }

    public f(b.a aVar) {
        super(aVar);
        this.f10614i = new com.rd.b.c.b.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        int intValue3 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE")).intValue();
        int intValue4 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE_REVERSE")).intValue();
        this.f10614i.c(intValue);
        this.f10614i.d(intValue2);
        this.f10614i.g(intValue3);
        this.f10614i.h(intValue4);
        b.a aVar = this.f10594b;
        if (aVar != null) {
            aVar.a(this.f10614i);
        }
    }

    private boolean o(int i2, int i3, int i4, float f2) {
        return (this.f10597e == i2 && this.f10598f == i3 && this.f10612g == i4 && this.f10613h == f2) ? false : true;
    }

    @Override // com.rd.b.d.c, com.rd.b.d.b
    /* renamed from: g */
    public ValueAnimator a() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new a());
        return valueAnimator;
    }

    protected PropertyValuesHolder n(boolean z) {
        int i2;
        int i3;
        String str;
        if (z) {
            i3 = this.f10612g;
            i2 = (int) (i3 * this.f10613h);
            str = "ANIMATION_SCALE_REVERSE";
        } else {
            i2 = this.f10612g;
            i3 = (int) (i2 * this.f10613h);
            str = "ANIMATION_SCALE";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i3, i2);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    public f p(int i2, int i3, int i4, float f2) {
        if (this.f10595c != 0 && o(i2, i3, i4, f2)) {
            this.f10597e = i2;
            this.f10598f = i3;
            this.f10612g = i4;
            this.f10613h = f2;
            ((ValueAnimator) this.f10595c).setValues(h(false), h(true), n(false), n(true));
        }
        return this;
    }
}