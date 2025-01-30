package com.rd.b.d;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;
import com.rd.b.d.k;

/* compiled from: ThinWormAnimation.java */
/* loaded from: classes2.dex */
public class j extends k {

    /* renamed from: k  reason: collision with root package name */
    private com.rd.b.c.b.g f10621k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThinWormAnimation.java */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            j.this.r(valueAnimator);
        }
    }

    public j(b.a aVar) {
        super(aVar);
        this.f10621k = new com.rd.b.c.b.g();
    }

    private ValueAnimator p(int i2, int i3, long j2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j2);
        ofInt.addUpdateListener(new a());
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ValueAnimator valueAnimator) {
        this.f10621k.f(((Integer) valueAnimator.getAnimatedValue()).intValue());
        b.a aVar = this.f10594b;
        if (aVar != null) {
            aVar.a(this.f10621k);
        }
    }

    @Override // com.rd.b.d.k
    public k n(int i2, int i3, int i4, boolean z) {
        if (k(i2, i3, i4, z)) {
            this.f10595c = a();
            this.f10622d = i2;
            this.f10623e = i3;
            this.f10624f = i4;
            this.f10625g = z;
            int i5 = i4 * 2;
            int i6 = i2 - i4;
            this.f10626h = i6;
            this.f10627i = i2 + i4;
            this.f10621k.d(i6);
            this.f10621k.c(this.f10627i);
            this.f10621k.f(i5);
            k.b h2 = h(z);
            long j2 = this.a;
            long j3 = (long) (j2 * 0.8d);
            long j4 = (long) (j2 * 0.2d);
            long j5 = (long) (j2 * 0.5d);
            long j6 = (long) (j2 * 0.5d);
            ValueAnimator i7 = i(h2.a, h2.f10631b, j3, false, this.f10621k);
            ValueAnimator i8 = i(h2.f10632c, h2.f10633d, j3, true, this.f10621k);
            i8.setStartDelay(j4);
            ValueAnimator p = p(i5, i4, j5);
            ValueAnimator p2 = p(i4, i5, j5);
            p2.setStartDelay(j6);
            ((AnimatorSet) this.f10595c).playTogether(i7, i8, p, p2);
        }
        return this;
    }

    @Override // com.rd.b.d.k
    /* renamed from: q */
    public j j(long j2) {
        super.j(j2);
        return this;
    }

    @Override // com.rd.b.d.k
    /* renamed from: s */
    public j m(float f2) {
        T t = this.f10595c;
        if (t != 0) {
            long j2 = f2 * ((float) this.a);
            int size = ((AnimatorSet) t).getChildAnimations().size();
            for (int i2 = 0; i2 < size; i2++) {
                ValueAnimator valueAnimator = (ValueAnimator) ((AnimatorSet) this.f10595c).getChildAnimations().get(i2);
                long startDelay = j2 - valueAnimator.getStartDelay();
                long duration = valueAnimator.getDuration();
                if (startDelay > duration) {
                    startDelay = duration;
                } else if (startDelay < 0) {
                    startDelay = 0;
                }
                if ((i2 != size - 1 || startDelay > 0) && valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                    valueAnimator.setCurrentPlayTime(startDelay);
                }
            }
        }
        return this;
    }
}