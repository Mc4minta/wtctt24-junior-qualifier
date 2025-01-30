package com.swmansion.reanimated.nodes;

import android.util.Log;
import com.coinbase.ApiConstants;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: DebugNode.java */
/* loaded from: classes2.dex */
public class i extends m {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10977b;

    public i(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.a = com.swmansion.reanimated.a.b(readableMap, ApiConstants.MESSAGE, "Reanimated: First argument passed to debug node is either of wrong type or is missing.");
        this.f10977b = com.swmansion.reanimated.a.a(readableMap, "value", "Reanimated: Second argument passed to debug node is either of wrong type or is missing.");
    }

    @Override // com.swmansion.reanimated.nodes.m
    protected Object evaluate() {
        Object value = this.mNodesManager.o(this.f10977b, m.class).value();
        Log.d("REANIMATED", String.format("%s %s", this.a, value));
        return value;
    }
}