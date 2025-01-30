package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;

/* compiled from: AlwaysNode.java */
/* loaded from: classes2.dex */
public class a extends m implements j {
    private int a;

    public a(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.a = com.swmansion.reanimated.a.a(readableMap, "what", "Reanimated: Argument passed to always node is either of wrong type or is missing.");
    }

    @Override // com.swmansion.reanimated.nodes.j
    public void a() {
        value();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.reanimated.nodes.m
    public Double evaluate() {
        this.mNodesManager.o(this.a, m.class).value();
        return m.ZERO;
    }
}