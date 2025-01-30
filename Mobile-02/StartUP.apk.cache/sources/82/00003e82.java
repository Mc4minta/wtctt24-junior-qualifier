package com.rd.b.d;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;

/* compiled from: FillAnimation.java */
/* loaded from: classes2.dex */
public class e extends c {

    /* renamed from: g  reason: collision with root package name */
    private com.rd.b.c.b.c f10609g;

    /* renamed from: h  reason: collision with root package name */
    private int f10610h;

    /* renamed from: i  reason: collision with root package name */
    private int f10611i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FillAnimation.java */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e.this.j(valueAnimator);
        }
    }

    public e(b.a aVar) {
        super(aVar);
        this.f10609g = new com.rd.b.c.b.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        int intValue3 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_RADIUS")).intValue();
        int intValue4 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_RADIUS_REVERSE")).intValue();
        int intValue5 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_STROKE")).intValue();
        int intValue6 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_STROKE_REVERSE")).intValue();
        this.f10609g.c(intValue);
        this.f10609g.d(intValue2);
        this.f10609g.i(intValue3);
        this.f10609g.j(intValue4);
        this.f10609g.k(intValue5);
        this.f10609g.l(intValue6);
        b.a aVar = this.f10594b;
        if (aVar != null) {
            aVar.a(this.f10609g);
        }
    }

    private PropertyValuesHolder n(boolean z) {
        int i2;
        int i3;
        String str;
        if (z) {
            i3 = this.f10610h;
            i2 = i3 / 2;
            str = "ANIMATION_RADIUS_REVERSE";
        } else {
            i2 = this.f10610h;
            i3 = i2 / 2;
            str = "ANIMATION_RADIUS";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i2, i3);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private PropertyValuesHolder o(boolean z) {
        String str;
        int i2;
        int i3;
        if (z) {
            i3 = this.f10610h;
            str = "ANIMATION_STROKE_REVERSE";
            i2 = 0;
        } else {
            str = "ANIMATION_STROKE";
            i2 = this.f10610h;
            i3 = 0;
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i3, i2);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private boolean p(int i2, int i3, int i4, int i5) {
        return (this.f10597e == i2 && this.f10598f == i3 && this.f10610h == i4 && this.f10611i == i5) ? false : true;
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

    public e q(int i2, int i3, int i4, int i5) {
        if (this.f10595c != 0 && p(i2, i3, i4, i5)) {
            this.f10597e = i2;
            this.f10598f = i3;
            this.f10610h = i4;
            this.f10611i = i5;
            ((ValueAnimator) this.f10595c).setValues(h(false), h(true), n(false), n(true), o(false), o(true));
        }
        return this;
    }
}