package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;

/* compiled from: ClockOpNode.java */
/* loaded from: classes2.dex */
public abstract class f extends m {
    private int a;

    /* compiled from: ClockOpNode.java */
    /* loaded from: classes2.dex */
    public static class a extends f {
        public a(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
            super(i2, readableMap, bVar);
        }

        @Override // com.swmansion.reanimated.nodes.f
        protected Double c(m mVar) {
            if (mVar instanceof p) {
                ((p) mVar).g();
            } else {
                ((e) mVar).c();
            }
            return m.ZERO;
        }

        @Override // com.swmansion.reanimated.nodes.m
        protected /* bridge */ /* synthetic */ Object evaluate() {
            return super.evaluate();
        }
    }

    /* compiled from: ClockOpNode.java */
    /* loaded from: classes2.dex */
    public static class b extends f {
        public b(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
            super(i2, readableMap, bVar);
        }

        @Override // com.swmansion.reanimated.nodes.f
        protected Double c(m mVar) {
            if (mVar instanceof p) {
                ((p) mVar).h();
            } else {
                ((e) mVar).d();
            }
            return m.ZERO;
        }

        @Override // com.swmansion.reanimated.nodes.m
        protected /* bridge */ /* synthetic */ Object evaluate() {
            return super.evaluate();
        }
    }

    /* compiled from: ClockOpNode.java */
    /* loaded from: classes2.dex */
    public static class c extends f {
        public c(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
            super(i2, readableMap, bVar);
        }

        @Override // com.swmansion.reanimated.nodes.f
        protected Double c(m mVar) {
            if (mVar instanceof p) {
                return Double.valueOf(((p) mVar).f() ? 1.0d : 0.0d);
            }
            return Double.valueOf(((e) mVar).a ? 1.0d : 0.0d);
        }

        @Override // com.swmansion.reanimated.nodes.m
        protected /* bridge */ /* synthetic */ Object evaluate() {
            return super.evaluate();
        }
    }

    public f(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.a = com.swmansion.reanimated.a.a(readableMap, "clock", "Reanimated: Argument passed to clock node is either of wrong type or is missing.");
    }

    protected abstract Double c(m mVar);

    @Override // com.swmansion.reanimated.nodes.m
    protected Double evaluate() {
        return c(this.mNodesManager.o(this.a, m.class));
    }
}