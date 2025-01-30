package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;

/* compiled from: CallFuncNode.java */
/* loaded from: classes2.dex */
public class d extends m {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10971b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f10972c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f10973d;

    public d(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.f10971b = readableMap.getInt("what");
        this.f10973d = com.swmansion.reanimated.e.a(readableMap.getArray("params"));
        this.f10972c = com.swmansion.reanimated.e.a(readableMap.getArray("args"));
    }

    private void c() {
        com.swmansion.reanimated.d dVar = this.mNodesManager.q;
        this.a = dVar.f10958b;
        dVar.f10958b = this.mNodesManager.q.f10958b + '/' + String.valueOf(this.mNodeID);
        int i2 = 0;
        while (true) {
            int[] iArr = this.f10973d;
            if (i2 >= iArr.length) {
                return;
            }
            ((p) this.mNodesManager.o(iArr[i2], p.class)).d(Integer.valueOf(this.f10972c[i2]), this.a);
            i2++;
        }
    }

    private void d() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f10973d;
            if (i2 < iArr.length) {
                ((p) this.mNodesManager.o(iArr[i2], p.class)).e();
                i2++;
            } else {
                this.mNodesManager.q.f10958b = this.a;
                return;
            }
        }
    }

    @Override // com.swmansion.reanimated.nodes.m
    protected Object evaluate() {
        c();
        Object value = this.mNodesManager.o(this.f10971b, m.class).value();
        d();
        return value;
    }
}