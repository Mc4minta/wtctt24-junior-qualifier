package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.Map;

/* compiled from: StyleNode.java */
/* loaded from: classes2.dex */
public class s extends m {
    private final Map<String, Integer> a;

    public s(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.a = com.swmansion.reanimated.e.b(readableMap.getMap("style"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.reanimated.nodes.m
    /* renamed from: c */
    public WritableMap evaluate() {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        for (Map.Entry<String, Integer> entry : this.a.entrySet()) {
            m o = this.mNodesManager.o(entry.getValue().intValue(), m.class);
            if (o instanceof t) {
                javaOnlyMap.putArray(entry.getKey(), (WritableArray) o.value());
            } else {
                Object value = o.value();
                if (value instanceof Double) {
                    javaOnlyMap.putDouble(entry.getKey(), ((Double) value).doubleValue());
                } else if (value instanceof String) {
                    javaOnlyMap.putString(entry.getKey(), (String) value);
                } else {
                    throw new IllegalStateException("Wrong style form");
                }
            }
        }
        return javaOnlyMap;
    }
}