package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: AdditionAnimatedNode.java */
/* loaded from: classes2.dex */
class a extends s {

    /* renamed from: i  reason: collision with root package name */
    private final l f4704i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f4705j;

    public a(ReadableMap readableMap, l lVar) {
        this.f4704i = lVar;
        ReadableArray array = readableMap.getArray("input");
        this.f4705j = new int[array.size()];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f4705j;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = array.getInt(i2);
            i2++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        throw new com.facebook.react.bridge.JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.Add node");
     */
    @Override // com.facebook.react.animated.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            r6 = this;
            r0 = 0
            r6.f4779f = r0
            r0 = 0
        L5:
            int[] r1 = r6.f4705j
            int r2 = r1.length
            if (r0 >= r2) goto L2e
            com.facebook.react.animated.l r2 = r6.f4704i
            r1 = r1[r0]
            com.facebook.react.animated.b r1 = r2.l(r1)
            if (r1 == 0) goto L26
            boolean r2 = r1 instanceof com.facebook.react.animated.s
            if (r2 == 0) goto L26
            double r2 = r6.f4779f
            com.facebook.react.animated.s r1 = (com.facebook.react.animated.s) r1
            double r4 = r1.i()
            double r2 = r2 + r4
            r6.f4779f = r2
            int r0 = r0 + 1
            goto L5
        L26:
            com.facebook.react.bridge.JSApplicationCausedNativeException r0 = new com.facebook.react.bridge.JSApplicationCausedNativeException
            java.lang.String r1 = "Illegal node ID set as an input for Animated.Add node"
            r0.<init>(r1)
            throw r0
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.a.e():void");
    }
}