package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

/* compiled from: JSCallNode.java */
/* loaded from: classes2.dex */
public class l extends m {
    private final int[] a;

    public l(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.a = com.swmansion.reanimated.e.a(readableMap.getArray("input"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.reanimated.nodes.m
    public Double evaluate() {
        WritableArray createArray = Arguments.createArray();
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 < iArr.length) {
                m o = this.mNodesManager.o(iArr[i2], m.class);
                if (o.value() == null) {
                    createArray.pushNull();
                } else {
                    Object value = o.value();
                    if (value instanceof String) {
                        createArray.pushString((String) value);
                    } else {
                        createArray.pushDouble(o.doubleValue().doubleValue());
                    }
                }
                i2++;
            } else {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("id", this.mNodeID);
                createMap.putArray("args", createArray);
                this.mNodesManager.x("onReanimatedCall", createMap);
                return m.ZERO;
            }
        }
    }
}