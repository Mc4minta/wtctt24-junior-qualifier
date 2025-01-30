package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

/* compiled from: SpringAnimation.java */
/* loaded from: classes2.dex */
class n extends d {

    /* renamed from: e  reason: collision with root package name */
    private long f4753e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4754f;

    /* renamed from: g  reason: collision with root package name */
    private double f4755g;

    /* renamed from: h  reason: collision with root package name */
    private double f4756h;

    /* renamed from: i  reason: collision with root package name */
    private double f4757i;

    /* renamed from: j  reason: collision with root package name */
    private double f4758j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4759k;

    /* renamed from: l  reason: collision with root package name */
    private final b f4760l;
    private double m;
    private double n;
    private double o;
    private double p;
    private double q;
    private int r;
    private int s;
    private double t;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SpringAnimation.java */
    /* loaded from: classes2.dex */
    public static class b {
        double a;

        /* renamed from: b  reason: collision with root package name */
        double f4761b;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ReadableMap readableMap) {
        b bVar = new b();
        this.f4760l = bVar;
        bVar.f4761b = readableMap.getDouble("initialVelocity");
        a(readableMap);
    }

    private void c(double d2) {
        double d3;
        double d4;
        if (e()) {
            return;
        }
        this.q += d2 <= 0.064d ? d2 : 0.064d;
        double d5 = this.f4756h;
        double d6 = this.f4757i;
        double d7 = this.f4755g;
        double d8 = -this.f4758j;
        double sqrt = d5 / (Math.sqrt(d7 * d6) * 2.0d);
        double sqrt2 = Math.sqrt(d7 / d6);
        double sqrt3 = Math.sqrt(1.0d - (sqrt * sqrt)) * sqrt2;
        double d9 = this.n - this.m;
        double d10 = this.q;
        if (sqrt < 1.0d) {
            double exp = Math.exp((-sqrt) * sqrt2 * d10);
            double d11 = sqrt * sqrt2;
            double d12 = d8 + (d11 * d9);
            double d13 = d10 * sqrt3;
            d4 = this.n - ((((d12 / sqrt3) * Math.sin(d13)) + (Math.cos(d13) * d9)) * exp);
            d3 = ((d11 * exp) * (((Math.sin(d13) * d12) / sqrt3) + (Math.cos(d13) * d9))) - (((Math.cos(d13) * d12) - ((sqrt3 * d9) * Math.sin(d13))) * exp);
        } else {
            double exp2 = Math.exp((-sqrt2) * d10);
            double d14 = this.n - (((((sqrt2 * d9) + d8) * d10) + d9) * exp2);
            d3 = exp2 * ((d8 * ((d10 * sqrt2) - 1.0d)) + (d10 * d9 * sqrt2 * sqrt2));
            d4 = d14;
        }
        b bVar = this.f4760l;
        bVar.a = d4;
        bVar.f4761b = d3;
        if (e() || (this.f4759k && f())) {
            if (this.f4755g > 0.0d) {
                double d15 = this.n;
                this.m = d15;
                this.f4760l.a = d15;
            } else {
                double d16 = this.f4760l.a;
                this.n = d16;
                this.m = d16;
            }
            this.f4760l.f4761b = 0.0d;
        }
    }

    private double d(b bVar) {
        return Math.abs(this.n - bVar.a);
    }

    private boolean e() {
        return Math.abs(this.f4760l.f4761b) <= this.o && (d(this.f4760l) <= this.p || this.f4755g == 0.0d);
    }

    private boolean f() {
        if (this.f4755g > 0.0d) {
            double d2 = this.m;
            double d3 = this.n;
            if ((d2 < d3 && this.f4760l.a > d3) || (d2 > d3 && this.f4760l.a < d3)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.animated.d
    public void a(ReadableMap readableMap) {
        this.f4755g = readableMap.getDouble("stiffness");
        this.f4756h = readableMap.getDouble("damping");
        this.f4757i = readableMap.getDouble("mass");
        this.f4758j = this.f4760l.f4761b;
        this.n = readableMap.getDouble("toValue");
        this.o = readableMap.getDouble("restSpeedThreshold");
        this.p = readableMap.getDouble("restDisplacementThreshold");
        this.f4759k = readableMap.getBoolean("overshootClamping");
        int i2 = readableMap.hasKey("iterations") ? readableMap.getInt("iterations") : 1;
        this.r = i2;
        this.a = i2 == 0;
        this.s = 0;
        this.q = 0.0d;
        this.f4754f = false;
    }

    @Override // com.facebook.react.animated.d
    public void b(long j2) {
        long j3 = j2 / 1000000;
        if (!this.f4754f) {
            if (this.s == 0) {
                this.t = this.f4709b.f4779f;
                this.s = 1;
            }
            b bVar = this.f4760l;
            double d2 = this.f4709b.f4779f;
            bVar.a = d2;
            this.m = d2;
            this.f4753e = j3;
            this.q = 0.0d;
            this.f4754f = true;
        }
        c((j3 - this.f4753e) / 1000.0d);
        this.f4753e = j3;
        this.f4709b.f4779f = this.f4760l.a;
        if (e()) {
            int i2 = this.r;
            if (i2 != -1 && this.s >= i2) {
                this.a = true;
                return;
            }
            this.f4754f = false;
            this.f4709b.f4779f = this.t;
            this.s++;
        }
    }
}