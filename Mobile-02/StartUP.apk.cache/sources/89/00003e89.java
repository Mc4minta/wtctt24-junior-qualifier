package com.rd.b.d;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;

/* compiled from: SwapAnimation.java */
/* loaded from: classes2.dex */
public class i extends b<ValueAnimator> {

    /* renamed from: d  reason: collision with root package name */
    private int f10618d;

    /* renamed from: e  reason: collision with root package name */
    private int f10619e;

    /* renamed from: f  reason: collision with root package name */
    private com.rd.b.c.b.f f10620f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwapAnimation.java */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            i.this.j(valueAnimator);
        }
    }

    public i(b.a aVar) {
        super(aVar);
        this.f10618d = -1;
        this.f10619e = -1;
        this.f10620f = new com.rd.b.c.b.f();
    }

    private PropertyValuesHolder h(String str, int i2, int i3) {
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i2, i3);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private boolean i(int i2, int i3) {
        return (this.f10618d == i2 && this.f10619e == i3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE_REVERSE")).intValue();
        this.f10620f.c(intValue);
        this.f10620f.d(intValue2);
        b.a aVar = this.f10594b;
        if (aVar != null) {
            aVar.a(this.f10620f);
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

    @Override // com.rd.b.d.b
    /* renamed from: k */
    public i d(float f2) {
        T t = this.f10595c;
        if (t != 0) {
            long j2 = f2 * ((float) this.a);
            if (((ValueAnimator) t).getValues() != null && ((ValueAnimator) this.f10595c).getValues().length > 0) {
                ((ValueAnimator) this.f10595c).setCurrentPlayTime(j2);
            }
        }
        return this;
    }

    public i l(int i2, int i3) {
        if (this.f10595c != 0 && i(i2, i3)) {
            this.f10618d = i2;
            this.f10619e = i3;
            ((ValueAnimator) this.f10595c).setValues(h("ANIMATION_COORDINATE", i2, i3), h("ANIMATION_COORDINATE_REVERSE", i3, i2));
        }
        return this;
    }
}