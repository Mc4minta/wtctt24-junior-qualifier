package com.rd.b.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;
import java.util.Iterator;

/* compiled from: WormAnimation.java */
/* loaded from: classes2.dex */
public class k extends com.rd.b.d.b<AnimatorSet> {

    /* renamed from: d  reason: collision with root package name */
    int f10622d;

    /* renamed from: e  reason: collision with root package name */
    int f10623e;

    /* renamed from: f  reason: collision with root package name */
    int f10624f;

    /* renamed from: g  reason: collision with root package name */
    boolean f10625g;

    /* renamed from: h  reason: collision with root package name */
    int f10626h;

    /* renamed from: i  reason: collision with root package name */
    int f10627i;

    /* renamed from: j  reason: collision with root package name */
    private com.rd.b.c.b.h f10628j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WormAnimation.java */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ com.rd.b.c.b.h a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f10629b;

        a(com.rd.b.c.b.h hVar, boolean z) {
            this.a = hVar;
            this.f10629b = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            k.this.l(this.a, valueAnimator, this.f10629b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WormAnimation.java */
    /* loaded from: classes2.dex */
    public class b {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        final int f10631b;

        /* renamed from: c  reason: collision with root package name */
        final int f10632c;

        /* renamed from: d  reason: collision with root package name */
        final int f10633d;

        b(int i2, int i3, int i4, int i5) {
            this.a = i2;
            this.f10631b = i3;
            this.f10632c = i4;
            this.f10633d = i5;
        }
    }

    public k(b.a aVar) {
        super(aVar);
        this.f10628j = new com.rd.b.c.b.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(com.rd.b.c.b.h hVar, ValueAnimator valueAnimator, boolean z) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (this.f10625g) {
            if (!z) {
                hVar.c(intValue);
            } else {
                hVar.d(intValue);
            }
        } else if (!z) {
            hVar.d(intValue);
        } else {
            hVar.c(intValue);
        }
        b.a aVar = this.f10594b;
        if (aVar != null) {
            aVar.a(hVar);
        }
    }

    @Override // com.rd.b.d.b
    /* renamed from: g */
    public AnimatorSet a() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b h(boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (z) {
            int i6 = this.f10622d;
            int i7 = this.f10624f;
            i2 = i6 + i7;
            int i8 = this.f10623e;
            i3 = i8 + i7;
            i4 = i6 - i7;
            i5 = i8 - i7;
        } else {
            int i9 = this.f10622d;
            int i10 = this.f10624f;
            i2 = i9 - i10;
            int i11 = this.f10623e;
            i3 = i11 - i10;
            i4 = i9 + i10;
            i5 = i11 + i10;
        }
        return new b(i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ValueAnimator i(int i2, int i3, long j2, boolean z, com.rd.b.c.b.h hVar) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j2);
        ofInt.addUpdateListener(new a(hVar, z));
        return ofInt;
    }

    public k j(long j2) {
        super.b(j2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k(int i2, int i3, int i4, boolean z) {
        return (this.f10622d == i2 && this.f10623e == i3 && this.f10624f == i4 && this.f10625g == z) ? false : true;
    }

    @Override // com.rd.b.d.b
    /* renamed from: m */
    public k d(float f2) {
        T t = this.f10595c;
        if (t == 0) {
            return this;
        }
        long j2 = f2 * ((float) this.a);
        Iterator<Animator> it = ((AnimatorSet) t).getChildAnimations().iterator();
        while (it.hasNext()) {
            ValueAnimator valueAnimator = (ValueAnimator) it.next();
            long duration = valueAnimator.getDuration();
            if (j2 <= duration) {
                duration = j2;
            }
            valueAnimator.setCurrentPlayTime(duration);
            j2 -= duration;
        }
        return this;
    }

    public k n(int i2, int i3, int i4, boolean z) {
        if (k(i2, i3, i4, z)) {
            this.f10595c = a();
            this.f10622d = i2;
            this.f10623e = i3;
            this.f10624f = i4;
            this.f10625g = z;
            int i5 = i2 - i4;
            this.f10626h = i5;
            this.f10627i = i2 + i4;
            this.f10628j.d(i5);
            this.f10628j.c(this.f10627i);
            b h2 = h(z);
            long j2 = this.a / 2;
            ((AnimatorSet) this.f10595c).playSequentially(i(h2.a, h2.f10631b, j2, false, this.f10628j), i(h2.f10632c, h2.f10633d, j2, true, this.f10628j));
        }
        return this;
    }
}