package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import java.util.Stack;

/* compiled from: ParamNode.java */
/* loaded from: classes2.dex */
public class p extends u {

    /* renamed from: b  reason: collision with root package name */
    private final Stack<Integer> f10989b;

    /* renamed from: c  reason: collision with root package name */
    private String f10990c;

    public p(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.f10989b = new Stack<>();
    }

    @Override // com.swmansion.reanimated.nodes.u
    public void c(Object obj) {
        m o = this.mNodesManager.o(this.f10989b.peek().intValue(), m.class);
        com.swmansion.reanimated.d dVar = this.mUpdateContext;
        String str = dVar.f10958b;
        dVar.f10958b = this.f10990c;
        ((u) o).c(obj);
        this.mUpdateContext.f10958b = str;
        forceUpdateMemoizedValue(obj);
    }

    public void d(Integer num, String str) {
        this.f10990c = str;
        this.f10989b.push(num);
    }

    public void e() {
        this.f10989b.pop();
    }

    @Override // com.swmansion.reanimated.nodes.u, com.swmansion.reanimated.nodes.m
    protected Object evaluate() {
        com.swmansion.reanimated.d dVar = this.mUpdateContext;
        String str = dVar.f10958b;
        dVar.f10958b = this.f10990c;
        Object value = this.mNodesManager.o(this.f10989b.peek().intValue(), m.class).value();
        this.mUpdateContext.f10958b = str;
        return value;
    }

    public boolean f() {
        m o = this.mNodesManager.o(this.f10989b.peek().intValue(), m.class);
        if (o instanceof p) {
            return ((p) o).f();
        }
        return ((e) o).a;
    }

    public void g() {
        m o = this.mNodesManager.o(this.f10989b.peek().intValue(), m.class);
        if (o instanceof p) {
            ((p) o).g();
        } else {
            ((e) o).c();
        }
    }

    public void h() {
        m o = this.mNodesManager.o(this.f10989b.peek().intValue(), m.class);
        if (o instanceof p) {
            ((p) o).h();
        } else {
            ((e) o).d();
        }
    }
}