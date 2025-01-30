package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

/* compiled from: FrameBasedAnimationDriver.java */
/* loaded from: classes2.dex */
class h extends d {

    /* renamed from: e  reason: collision with root package name */
    private long f4725e;

    /* renamed from: f  reason: collision with root package name */
    private double[] f4726f;

    /* renamed from: g  reason: collision with root package name */
    private double f4727g;

    /* renamed from: h  reason: collision with root package name */
    private double f4728h;

    /* renamed from: i  reason: collision with root package name */
    private int f4729i;

    /* renamed from: j  reason: collision with root package name */
    private int f4730j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ReadableMap readableMap) {
        a(readableMap);
    }

    @Override // com.facebook.react.animated.d
    public void a(ReadableMap readableMap) {
        ReadableArray array = readableMap.getArray("frames");
        int size = array.size();
        double[] dArr = this.f4726f;
        if (dArr == null || dArr.length != size) {
            this.f4726f = new double[size];
        }
        for (int i2 = 0; i2 < size; i2++) {
            this.f4726f[i2] = array.getDouble(i2);
        }
        if (readableMap.hasKey("toValue")) {
            this.f4727g = readableMap.getType("toValue") == ReadableType.Number ? readableMap.getDouble("toValue") : 0.0d;
        } else {
            this.f4727g = 0.0d;
        }
        if (readableMap.hasKey("iterations")) {
            this.f4729i = readableMap.getType("iterations") == ReadableType.Number ? readableMap.getInt("iterations") : 1;
        } else {
            this.f4729i = 1;
        }
        this.f4730j = 1;
        this.a = this.f4729i == 0;
        this.f4725e = -1L;
    }

    @Override // com.facebook.react.animated.d
    public void b(long j2) {
        double d2;
        if (this.f4725e < 0) {
            this.f4725e = j2;
            if (this.f4730j == 1) {
                this.f4728h = this.f4709b.f4779f;
            }
        }
        int round = (int) Math.round(((j2 - this.f4725e) / 1000000) / 16.666666666666668d);
        if (round >= 0) {
            if (this.a) {
                return;
            }
            double[] dArr = this.f4726f;
            if (round >= dArr.length - 1) {
                d2 = this.f4727g;
                int i2 = this.f4729i;
                if (i2 != -1 && this.f4730j >= i2) {
                    this.a = true;
                } else {
                    this.f4725e = -1L;
                    this.f4730j++;
                }
            } else {
                double d3 = this.f4728h;
                d2 = (dArr[round] * (this.f4727g - d3)) + d3;
            }
            this.f4709b.f4779f = d2;
            return;
        }
        throw new IllegalStateException("Calculated frame index should never be lower than 0");
    }
}