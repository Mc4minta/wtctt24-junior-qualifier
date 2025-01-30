package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

/* compiled from: ValueNode.java */
/* loaded from: classes2.dex */
public class u extends m {
    private Object a;

    public u(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        if (readableMap != null && readableMap.hasKey("value")) {
            ReadableType type = readableMap.getType("value");
            if (type == ReadableType.String) {
                this.a = readableMap.getString("value");
                return;
            } else if (type == ReadableType.Number) {
                this.a = Double.valueOf(readableMap.getDouble("value"));
                return;
            } else if (type == ReadableType.Null) {
                this.a = null;
                return;
            } else {
                throw new IllegalStateException("Not supported value type. Must be boolean, number or string");
            }
        }
        this.a = null;
    }

    public void c(Object obj) {
        this.a = obj;
        forceUpdateMemoizedValue(obj);
    }

    @Override // com.swmansion.reanimated.nodes.m
    protected Object evaluate() {
        return this.a;
    }
}