package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;

/* compiled from: CondNode.java */
/* loaded from: classes2.dex */
public class h extends m {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10975b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10976c;

    public h(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.a = com.swmansion.reanimated.a.a(readableMap, "cond", "Reanimated: First argument passed to cond node is either of wrong type or is missing.");
        this.f10975b = com.swmansion.reanimated.a.a(readableMap, "ifBlock", "Reanimated: Second argument passed to cond node is either of wrong type or is missing.");
        this.f10976c = readableMap.hasKey("elseBlock") ? com.swmansion.reanimated.a.a(readableMap, "elseBlock", "Reanimated: Second argument passed to cond node is either of wrong type or is missing.") : -1;
    }

    @Override // com.swmansion.reanimated.nodes.m
    protected Object evaluate() {
        Object p = this.mNodesManager.p(this.a);
        if ((p instanceof Number) && ((Number) p).doubleValue() != 0.0d) {
            int i2 = this.f10975b;
            return i2 != -1 ? this.mNodesManager.p(i2) : m.ZERO;
        }
        int i3 = this.f10976c;
        return i3 != -1 ? this.mNodesManager.p(i3) : m.ZERO;
    }
}