package com.rd.b.d;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;

/* compiled from: SlideAnimation.java */
/* loaded from: classes2.dex */
public class h extends b<ValueAnimator> {

    /* renamed from: d  reason: collision with root package name */
    private com.rd.b.c.b.e f10615d;

    /* renamed from: e  reason: collision with root package name */
    private int f10616e;

    /* renamed from: f  reason: collision with root package name */
    private int f10617f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SlideAnimation.java */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            h.this.j(valueAnimator);
        }
    }

    public h(b.a aVar) {
        super(aVar);
        this.f10616e = -1;
        this.f10617f = -1;
        this.f10615d = new com.rd.b.c.b.e();
    }

    private PropertyValuesHolder h() {
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("ANIMATION_COORDINATE", this.f10616e, this.f10617f);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private boolean i(int i2, int i3) {
        return (this.f10616e == i2 && this.f10617f == i3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ValueAnimator valueAnimator) {
        this.f10615d.b(((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE")).intValue());
        b.a aVar = this.f10594b;
        if (aVar != null) {
            aVar.a(this.f10615d);
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
    public h d(float f2) {
        T t = this.f10595c;
        if (t != 0) {
            long j2 = f2 * ((float) this.a);
            if (((ValueAnimator) t).getValues() != null && ((ValueAnimator) this.f10595c).getValues().length > 0) {
                ((ValueAnimator) this.f10595c).setCurrentPlayTime(j2);
            }
        }
        return this;
    }

    public h l(int i2, int i3) {
        if (this.f10595c != 0 && i(i2, i3)) {
            this.f10616e = i2;
            this.f10617f = i3;
            ((ValueAnimator) this.f10595c).setValues(h());
        }
        return this;
    }
}