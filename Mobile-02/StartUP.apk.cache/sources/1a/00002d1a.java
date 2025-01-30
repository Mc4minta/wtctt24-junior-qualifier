package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: ModulusAnimatedNode.java */
/* loaded from: classes2.dex */
class j extends s {

    /* renamed from: i  reason: collision with root package name */
    private final l f4735i;

    /* renamed from: j  reason: collision with root package name */
    private final int f4736j;

    /* renamed from: k  reason: collision with root package name */
    private final double f4737k;

    public j(ReadableMap readableMap, l lVar) {
        this.f4735i = lVar;
        this.f4736j = readableMap.getInt("input");
        this.f4737k = readableMap.getDouble("modulus");
    }

    @Override // com.facebook.react.animated.b
    public void e() {
        b l2 = this.f4735i.l(this.f4736j);
        if (l2 != null && (l2 instanceof s)) {
            double i2 = ((s) l2).i();
            double d2 = this.f4737k;
            this.f4779f = ((i2 % d2) + d2) % d2;
            return;
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.modulus node");
    }
}