package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StyleAnimatedNode.java */
/* loaded from: classes2.dex */
public class o extends b {

    /* renamed from: e  reason: collision with root package name */
    private final l f4762e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Integer> f4763f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ReadableMap readableMap, l lVar) {
        ReadableMap map = readableMap.getMap("style");
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        this.f4763f = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            this.f4763f.put(nextKey, Integer.valueOf(map.getInt(nextKey)));
        }
        this.f4762e = lVar;
    }

    public void f(JavaOnlyMap javaOnlyMap) {
        for (Map.Entry<String, Integer> entry : this.f4763f.entrySet()) {
            b l2 = this.f4762e.l(entry.getValue().intValue());
            if (l2 != null) {
                if (l2 instanceof r) {
                    ((r) l2).f(javaOnlyMap);
                } else if (l2 instanceof s) {
                    javaOnlyMap.putDouble(entry.getKey(), ((s) l2).i());
                } else {
                    throw new IllegalArgumentException("Unsupported type of node used in property node " + l2.getClass());
                }
            } else {
                throw new IllegalArgumentException("Mapped style node does not exists");
            }
        }
    }
}