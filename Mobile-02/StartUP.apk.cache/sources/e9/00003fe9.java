package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.swmansion.reanimated.b;

/* compiled from: ClockNode.java */
/* loaded from: classes2.dex */
public class e extends m implements b.d {
    public boolean a;

    public e(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
    }

    @Override // com.swmansion.reanimated.b.d
    public void b() {
        if (this.a) {
            markUpdated();
            this.mNodesManager.v(this);
        }
    }

    public void c() {
        if (this.a) {
            return;
        }
        this.a = true;
        this.mNodesManager.v(this);
    }

    public void d() {
        this.a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.reanimated.nodes.m
    public Double evaluate() {
        return Double.valueOf(this.mNodesManager.p);
    }
}