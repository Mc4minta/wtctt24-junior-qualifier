package c.f.a.a;

import androidx.constraintlayout.motion.widget.p;

/* compiled from: StopLogic.java */
/* loaded from: classes.dex */
public class g extends p {
    private float a;

    /* renamed from: b  reason: collision with root package name */
    private float f2692b;

    /* renamed from: c  reason: collision with root package name */
    private float f2693c;

    /* renamed from: d  reason: collision with root package name */
    private float f2694d;

    /* renamed from: e  reason: collision with root package name */
    private float f2695e;

    /* renamed from: f  reason: collision with root package name */
    private float f2696f;

    /* renamed from: g  reason: collision with root package name */
    private float f2697g;

    /* renamed from: h  reason: collision with root package name */
    private float f2698h;

    /* renamed from: i  reason: collision with root package name */
    private float f2699i;

    /* renamed from: j  reason: collision with root package name */
    private int f2700j;

    /* renamed from: k  reason: collision with root package name */
    private String f2701k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2702l = false;
    private float m;
    private float n;

    private float b(float f2) {
        float f3 = this.f2694d;
        if (f2 <= f3) {
            float f4 = this.a;
            return (f4 * f2) + ((((this.f2692b - f4) * f2) * f2) / (f3 * 2.0f));
        }
        int i2 = this.f2700j;
        if (i2 == 1) {
            return this.f2697g;
        }
        float f5 = f2 - f3;
        float f6 = this.f2695e;
        if (f5 < f6) {
            float f7 = this.f2697g;
            float f8 = this.f2692b;
            return f7 + (f8 * f5) + ((((this.f2693c - f8) * f5) * f5) / (f6 * 2.0f));
        } else if (i2 == 2) {
            return this.f2698h;
        } else {
            float f9 = f5 - f6;
            float f10 = this.f2696f;
            if (f9 < f10) {
                float f11 = this.f2698h;
                float f12 = this.f2693c;
                return (f11 + (f12 * f9)) - (((f12 * f9) * f9) / (f10 * 2.0f));
            }
            return this.f2699i;
        }
    }

    private void e(float f2, float f3, float f4, float f5, float f6) {
        if (f2 == 0.0f) {
            f2 = 1.0E-4f;
        }
        this.a = f2;
        float f7 = f2 / f4;
        float f8 = (f7 * f2) / 2.0f;
        if (f2 < 0.0f) {
            float sqrt = (float) Math.sqrt((f3 - ((((-f2) / f4) * f2) / 2.0f)) * f4);
            if (sqrt < f5) {
                this.f2701k = "backward accelerate, decelerate";
                this.f2700j = 2;
                this.a = f2;
                this.f2692b = sqrt;
                this.f2693c = 0.0f;
                float f9 = (sqrt - f2) / f4;
                this.f2694d = f9;
                this.f2695e = sqrt / f4;
                this.f2697g = ((f2 + sqrt) * f9) / 2.0f;
                this.f2698h = f3;
                this.f2699i = f3;
                return;
            }
            this.f2701k = "backward accelerate cruse decelerate";
            this.f2700j = 3;
            this.a = f2;
            this.f2692b = f5;
            this.f2693c = f5;
            float f10 = (f5 - f2) / f4;
            this.f2694d = f10;
            float f11 = f5 / f4;
            this.f2696f = f11;
            float f12 = ((f2 + f5) * f10) / 2.0f;
            float f13 = (f11 * f5) / 2.0f;
            this.f2695e = ((f3 - f12) - f13) / f5;
            this.f2697g = f12;
            this.f2698h = f3 - f13;
            this.f2699i = f3;
        } else if (f8 >= f3) {
            this.f2701k = "hard stop";
            this.f2700j = 1;
            this.a = f2;
            this.f2692b = 0.0f;
            this.f2697g = f3;
            this.f2694d = (2.0f * f3) / f2;
        } else {
            float f14 = f3 - f8;
            float f15 = f14 / f2;
            if (f15 + f7 < f6) {
                this.f2701k = "cruse decelerate";
                this.f2700j = 2;
                this.a = f2;
                this.f2692b = f2;
                this.f2693c = 0.0f;
                this.f2697g = f14;
                this.f2698h = f3;
                this.f2694d = f15;
                this.f2695e = f7;
                return;
            }
            float sqrt2 = (float) Math.sqrt((f4 * f3) + ((f2 * f2) / 2.0f));
            float f16 = (sqrt2 - f2) / f4;
            this.f2694d = f16;
            float f17 = sqrt2 / f4;
            this.f2695e = f17;
            if (sqrt2 < f5) {
                this.f2701k = "accelerate decelerate";
                this.f2700j = 2;
                this.a = f2;
                this.f2692b = sqrt2;
                this.f2693c = 0.0f;
                this.f2694d = f16;
                this.f2695e = f17;
                this.f2697g = ((f2 + sqrt2) * f16) / 2.0f;
                this.f2698h = f3;
                return;
            }
            this.f2701k = "accelerate cruse decelerate";
            this.f2700j = 3;
            this.a = f2;
            this.f2692b = f5;
            this.f2693c = f5;
            float f18 = (f5 - f2) / f4;
            this.f2694d = f18;
            float f19 = f5 / f4;
            this.f2696f = f19;
            float f20 = ((f2 + f5) * f18) / 2.0f;
            float f21 = (f19 * f5) / 2.0f;
            this.f2695e = ((f3 - f20) - f21) / f5;
            this.f2697g = f20;
            this.f2698h = f3 - f21;
            this.f2699i = f3;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.p
    public float a() {
        return this.f2702l ? -d(this.n) : d(this.n);
    }

    public void c(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.m = f2;
        boolean z = f2 > f3;
        this.f2702l = z;
        if (z) {
            e(-f4, f2 - f3, f6, f7, f5);
        } else {
            e(f4, f3 - f2, f6, f7, f5);
        }
    }

    public float d(float f2) {
        float f3 = this.f2694d;
        if (f2 <= f3) {
            float f4 = this.a;
            return f4 + (((this.f2692b - f4) * f2) / f3);
        }
        int i2 = this.f2700j;
        if (i2 == 1) {
            return 0.0f;
        }
        float f5 = f2 - f3;
        float f6 = this.f2695e;
        if (f5 < f6) {
            float f7 = this.f2692b;
            return f7 + (((this.f2693c - f7) * f5) / f6);
        } else if (i2 == 2) {
            return this.f2698h;
        } else {
            float f8 = f5 - f6;
            float f9 = this.f2696f;
            if (f8 < f9) {
                float f10 = this.f2693c;
                return f10 - ((f8 * f10) / f9);
            }
            return this.f2699i;
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        float b2 = b(f2);
        this.n = f2;
        return this.f2702l ? this.m - b2 : this.m + b2;
    }
}