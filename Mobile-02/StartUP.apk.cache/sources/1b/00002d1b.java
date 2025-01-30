package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: MultiplicationAnimatedNode.java */
/* loaded from: classes2.dex */
class k extends s {

    /* renamed from: i  reason: collision with root package name */
    private final l f4738i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f4739j;

    public k(ReadableMap readableMap, l lVar) {
        this.f4738i = lVar;
        ReadableArray array = readableMap.getArray("input");
        this.f4739j = new int[array.size()];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f4739j;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = array.getInt(i2);
            i2++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        throw new com.facebook.react.bridge.JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.multiply node");
     */
    @Override // com.facebook.react.animated.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            r6 = this;
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r6.f4779f = r0
            r0 = 0
        L5:
            int[] r1 = r6.f4739j
            int r2 = r1.length
            if (r0 >= r2) goto L2e
            com.facebook.react.animated.l r2 = r6.f4738i
            r1 = r1[r0]
            com.facebook.react.animated.b r1 = r2.l(r1)
            if (r1 == 0) goto L26
            boolean r2 = r1 instanceof com.facebook.react.animated.s
            if (r2 == 0) goto L26
            double r2 = r6.f4779f
            com.facebook.react.animated.s r1 = (com.facebook.react.animated.s) r1
            double r4 = r1.i()
            double r2 = r2 * r4
            r6.f4779f = r2
            int r0 = r0 + 1
            goto L5
        L26:
            com.facebook.react.bridge.JSApplicationCausedNativeException r0 = new com.facebook.react.bridge.JSApplicationCausedNativeException
            java.lang.String r1 = "Illegal node ID set as an input for Animated.multiply node"
            r0.<init>(r1)
            throw r0
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.k.e():void");
    }
}