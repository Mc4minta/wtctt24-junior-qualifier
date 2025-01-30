package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: DiffClampAnimatedNode.java */
/* loaded from: classes2.dex */
class f extends s {

    /* renamed from: i  reason: collision with root package name */
    private final l f4719i;

    /* renamed from: j  reason: collision with root package name */
    private final int f4720j;

    /* renamed from: k  reason: collision with root package name */
    private final double f4721k;

    /* renamed from: l  reason: collision with root package name */
    private final double f4722l;
    private double m = 0.0d;

    public f(ReadableMap readableMap, l lVar) {
        this.f4719i = lVar;
        this.f4720j = readableMap.getInt("input");
        this.f4721k = readableMap.getDouble("min");
        this.f4722l = readableMap.getDouble("max");
        this.f4779f = 0.0d;
    }

    private double l() {
        b l2 = this.f4719i.l(this.f4720j);
        if (l2 != null && (l2 instanceof s)) {
            return ((s) l2).i();
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.DiffClamp node");
    }

    @Override // com.facebook.react.animated.b
    public void e() {
        double l2 = l();
        double d2 = l2 - this.m;
        this.m = l2;
        this.f4779f = Math.min(Math.max(this.f4779f + d2, this.f4721k), this.f4722l);
    }
}