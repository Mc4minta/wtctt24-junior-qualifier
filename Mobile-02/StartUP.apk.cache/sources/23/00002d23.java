package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubtractionAnimatedNode.java */
/* loaded from: classes2.dex */
public class p extends s {

    /* renamed from: i  reason: collision with root package name */
    private final l f4764i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f4765j;

    public p(ReadableMap readableMap, l lVar) {
        this.f4764i = lVar;
        ReadableArray array = readableMap.getArray("input");
        this.f4765j = new int[array.size()];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f4765j;
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
            int[] iArr = this.f4765j;
            if (i2 >= iArr.length) {
                return;
            }
            b l2 = this.f4764i.l(iArr[i2]);
            if (l2 == null || !(l2 instanceof s)) {
                break;
            }
            s sVar = (s) l2;
            double i3 = sVar.i();
            if (i2 == 0) {
                this.f4779f = i3;
            } else {
                this.f4779f -= sVar.i();
            }
            i2++;
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.subtract node");
    }
}