package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: DivisionAnimatedNode.java */
/* loaded from: classes2.dex */
class g extends s {

    /* renamed from: i  reason: collision with root package name */
    private final l f4723i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f4724j;

    public g(ReadableMap readableMap, l lVar) {
        this.f4723i = lVar;
        ReadableArray array = readableMap.getArray("input");
        this.f4724j = new int[array.size()];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f4724j;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = array.getInt(i2);
            i2++;
        }
    }

    @Override // com.facebook.react.animated.b
    public void e() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f4724j;
            if (i2 >= iArr.length) {
                return;
            }
            b l2 = this.f4723i.l(iArr[i2]);
            if (l2 == null || !(l2 instanceof s)) {
                break;
            }
            double i3 = ((s) l2).i();
            if (i2 == 0) {
                this.f4779f = i3;
            } else if (i3 != 0.0d) {
                this.f4779f /= i3;
            } else {
                throw new JSApplicationCausedNativeException("Detected a division by zero in Animated.divide node");
            }
            i2++;
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.divide node");
    }
}