package com.rd.b.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;
import java.util.Iterator;

/* compiled from: DropAnimation.java */
/* loaded from: classes2.dex */
public class d extends com.rd.b.d.b<AnimatorSet> {

    /* renamed from: d  reason: collision with root package name */
    private int f10599d;

    /* renamed from: e  reason: collision with root package name */
    private int f10600e;

    /* renamed from: f  reason: collision with root package name */
    private int f10601f;

    /* renamed from: g  reason: collision with root package name */
    private int f10602g;

    /* renamed from: h  reason: collision with root package name */
    private int f10603h;

    /* renamed from: i  reason: collision with root package name */
    private com.rd.b.c.b.b f10604i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropAnimation.java */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.k(valueAnimator, this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropAnimation.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.Width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.Height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.Radius.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DropAnimation.java */
    /* loaded from: classes2.dex */
    public enum c {
        Width,
        Height,
        Radius
    }

    public d(b.a aVar) {
        super(aVar);
        this.f10604i = new com.rd.b.c.b.b();
    }

    private ValueAnimator h(int i2, int i3, long j2, c cVar) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j2);
        ofInt.addUpdateListener(new a(cVar));
        return ofInt;
    }

    private boolean j(int i2, int i3, int i4, int i5, int i6) {
        return (this.f10599d == i2 && this.f10600e == i3 && this.f10601f == i4 && this.f10602g == i5 && this.f10603h == i6) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ValueAnimator valueAnimator, c cVar) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int i2 = b.a[cVar.ordinal()];
        if (i2 == 1) {
            this.f10604i.f(intValue);
        } else if (i2 == 2) {
            this.f10604i.d(intValue);
        } else if (i2 == 3) {
            this.f10604i.e(intValue);
        }
        b.a aVar = this.f10594b;
        if (aVar != null) {
            aVar.a(this.f10604i);
        }
    }

    @Override // com.rd.b.d.b
    /* renamed from: g */
    public AnimatorSet a() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }

    public d i(long j2) {
        super.b(j2);
        return this;
    }

    @Override // com.rd.b.d.b
    /* renamed from: l */
    public d d(float f2) {
        T t = this.f10595c;
        if (t != 0) {
            long j2 = f2 * ((float) this.a);
            boolean z = false;
            Iterator<Animator> it = ((AnimatorSet) t).getChildAnimations().iterator();
            while (it.hasNext()) {
                ValueAnimator valueAnimator = (ValueAnimator) it.next();
                long duration = valueAnimator.getDuration();
                long j3 = z ? j2 - duration : j2;
                if (j3 >= 0) {
                    if (j3 >= duration) {
                        j3 = duration;
                    }
                    if (valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                        valueAnimator.setCurrentPlayTime(j3);
                    }
                    if (!z && duration >= this.a) {
                        z = true;
                    }
                }
            }
        }
        return this;
    }

    public d m(int i2, int i3, int i4, int i5, int i6) {
        if (j(i2, i3, i4, i5, i6)) {
            this.f10595c = a();
            this.f10599d = i2;
            this.f10600e = i3;
            this.f10601f = i4;
            this.f10602g = i5;
            this.f10603h = i6;
            int i7 = (int) (i6 / 1.5d);
            long j2 = this.a;
            long j3 = j2 / 2;
            ValueAnimator h2 = h(i2, i3, j2, c.Width);
            c cVar = c.Height;
            ValueAnimator h3 = h(i4, i5, j3, cVar);
            c cVar2 = c.Radius;
            ValueAnimator h4 = h(i6, i7, j3, cVar2);
            ValueAnimator h5 = h(i5, i4, j3, cVar);
            ((AnimatorSet) this.f10595c).play(h3).with(h4).with(h2).before(h5).before(h(i7, i6, j3, cVar2));
        }
        return this;
    }
}