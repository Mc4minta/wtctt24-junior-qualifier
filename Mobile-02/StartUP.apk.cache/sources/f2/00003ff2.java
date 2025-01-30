package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;

/* compiled from: FunctionNode.java */
/* loaded from: classes2.dex */
public class k extends m {
    private final int a;

    public k(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.a = readableMap.getInt("what");
    }

    @Override // com.swmansion.reanimated.nodes.m
    protected Object evaluate() {
        return this.mNodesManager.o(this.a, m.class).value();
    }
}