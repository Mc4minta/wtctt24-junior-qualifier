package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;

/* compiled from: BlockNode.java */
/* loaded from: classes2.dex */
public class c extends m {
    private final int[] a;

    public c(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.a = com.swmansion.reanimated.e.a(readableMap.getArray("block"));
    }

    @Override // com.swmansion.reanimated.nodes.m
    protected Object evaluate() {
        Object obj = null;
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 >= iArr.length) {
                return obj;
            }
            obj = this.mNodesManager.o(iArr[i2], m.class).value();
            i2++;
        }
    }
}