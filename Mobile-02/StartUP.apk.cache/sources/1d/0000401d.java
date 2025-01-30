package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;

/* compiled from: SetNode.java */
/* loaded from: classes2.dex */
public class r extends m {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f10995b;

    public r(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.a = com.swmansion.reanimated.a.a(readableMap, "what", "Reanimated: First argument passed to set node is either of wrong type or is missing.");
        this.f10995b = com.swmansion.reanimated.a.a(readableMap, "value", "Reanimated: Second argument passed to set node is either of wrong type or is missing.");
    }

    @Override // com.swmansion.reanimated.nodes.m
    protected Object evaluate() {
        Object p = this.mNodesManager.p(this.f10995b);
        ((u) this.mNodesManager.o(this.a, u.class)).c(p);
        return p;
    }
}