package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

/* compiled from: DecayAnimation.java */
/* loaded from: classes2.dex */
public class e extends d {

    /* renamed from: e  reason: collision with root package name */
    private final double f4712e;

    /* renamed from: f  reason: collision with root package name */
    private double f4713f;

    /* renamed from: g  reason: collision with root package name */
    private long f4714g;

    /* renamed from: h  reason: collision with root package name */
    private double f4715h;

    /* renamed from: i  reason: collision with root package name */
    private double f4716i;

    /* renamed from: j  reason: collision with root package name */
    private int f4717j;

    /* renamed from: k  reason: collision with root package name */
    private int f4718k;

    public e(ReadableMap readableMap) {
        this.f4712e = readableMap.getDouble("velocity");
        a(readableMap);
    }

    @Override // com.facebook.react.animated.d
    public void a(ReadableMap readableMap) {
        this.f4713f = readableMap.getDouble("deceleration");
        int i2 = readableMap.hasKey("iterations") ? readableMap.getInt("iterations") : 1;
        this.f4717j = i2;
        this.f4718k = 1;
        this.a = i2 == 0;
        this.f4714g = -1L;
        this.f4715h = 0.0d;
        this.f4716i = 0.0d;
    }

    @Override // com.facebook.react.animated.d
    public void b(long j2) {
        long j3 = j2 / 1000000;
        if (this.f4714g == -1) {
            this.f4714g = j3 - 16;
            double d2 = this.f4715h;
            if (d2 == this.f4716i) {
                this.f4715h = this.f4709b.f4779f;
            } else {
                this.f4709b.f4779f = d2;
            }
            this.f4716i = this.f4709b.f4779f;
        }
        double d3 = this.f4715h;
        double d4 = this.f4712e;
        double d5 = this.f4713f;
        double exp = d3 + ((d4 / (1.0d - d5)) * (1.0d - Math.exp((-(1.0d - d5)) * (j3 - this.f4714g))));
        if (Math.abs(this.f4716i - exp) < 0.1d) {
            int i2 = this.f4717j;
            if (i2 != -1 && this.f4718k >= i2) {
                this.a = true;
                return;
            } else {
                this.f4714g = -1L;
                this.f4718k++;
            }
        }
        this.f4716i = exp;
        this.f4709b.f4779f = exp;
    }
}