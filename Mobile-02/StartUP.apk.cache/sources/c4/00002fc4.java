package com.facebook.react.views.scroll;

import android.os.SystemClock;

/* compiled from: OnScrollDispatchHelper.java */
/* loaded from: classes2.dex */
public class b {
    private int a = Integer.MIN_VALUE;

    /* renamed from: b  reason: collision with root package name */
    private int f5350b = Integer.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private float f5351c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f5352d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private long f5353e = -11;

    public float a() {
        return this.f5351c;
    }

    public float b() {
        return this.f5352d;
    }

    public boolean c(int i2, int i3) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j2 = this.f5353e;
        boolean z = (uptimeMillis - j2 <= 10 && this.a == i2 && this.f5350b == i3) ? false : true;
        if (uptimeMillis - j2 != 0) {
            this.f5351c = (i2 - this.a) / ((float) (uptimeMillis - j2));
            this.f5352d = (i3 - this.f5350b) / ((float) (uptimeMillis - j2));
        }
        this.f5353e = uptimeMillis;
        this.a = i2;
        this.f5350b = i3;
        return z;
    }
}