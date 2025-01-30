package com.facebook.react.views.slider;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.q;

/* compiled from: ReactSlider.java */
/* loaded from: classes2.dex */
public class a extends q {

    /* renamed from: b  reason: collision with root package name */
    private static int f5392b = 128;

    /* renamed from: c  reason: collision with root package name */
    private double f5393c;

    /* renamed from: d  reason: collision with root package name */
    private double f5394d;

    /* renamed from: e  reason: collision with root package name */
    private double f5395e;

    /* renamed from: f  reason: collision with root package name */
    private double f5396f;

    /* renamed from: g  reason: collision with root package name */
    private double f5397g;

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5393c = 0.0d;
        this.f5394d = 0.0d;
        this.f5395e = 0.0d;
        this.f5396f = 0.0d;
        this.f5397g = 0.0d;
        a();
    }

    private void a() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23 || i2 >= 26) {
            return;
        }
        super.setStateListAnimator(null);
    }

    private void c() {
        if (this.f5396f == 0.0d) {
            this.f5397g = (this.f5394d - this.f5393c) / f5392b;
        }
        setMax(getTotalSteps());
        d();
    }

    private void d() {
        double d2 = this.f5395e;
        double d3 = this.f5393c;
        setProgress((int) Math.round(((d2 - d3) / (this.f5394d - d3)) * getTotalSteps()));
    }

    private double getStepValue() {
        double d2 = this.f5396f;
        return d2 > 0.0d ? d2 : this.f5397g;
    }

    private int getTotalSteps() {
        return (int) Math.ceil((this.f5394d - this.f5393c) / getStepValue());
    }

    public double b(int i2) {
        if (i2 == getMax()) {
            return this.f5394d;
        }
        return (i2 * getStepValue()) + this.f5393c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxValue(double d2) {
        this.f5394d = d2;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMinValue(double d2) {
        this.f5393c = d2;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStep(double d2) {
        this.f5396f = d2;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValue(double d2) {
        this.f5395e = d2;
        d();
    }
}