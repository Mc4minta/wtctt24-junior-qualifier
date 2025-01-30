package com.swmansion.reanimated.nodes;

import android.graphics.PointF;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: BezierNode.java */
/* loaded from: classes2.dex */
public class b extends m {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final a f10966b;

    public b(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.a = com.swmansion.reanimated.a.a(readableMap, "input", "Reanimated: Argument passed to bezier node is either of wrong type or is missing.");
        this.f10966b = new a((float) readableMap.getDouble("mX1"), (float) readableMap.getDouble("mY1"), (float) readableMap.getDouble("mX2"), (float) readableMap.getDouble("mY2"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.reanimated.nodes.m
    public Double evaluate() {
        return Double.valueOf(this.f10966b.c(((Double) this.mNodesManager.p(this.a)).floatValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BezierNode.java */
    /* loaded from: classes2.dex */
    public static class a {
        protected PointF a;

        /* renamed from: b  reason: collision with root package name */
        protected PointF f10967b;

        /* renamed from: c  reason: collision with root package name */
        protected PointF f10968c;

        /* renamed from: d  reason: collision with root package name */
        protected PointF f10969d;

        /* renamed from: e  reason: collision with root package name */
        protected PointF f10970e;

        public a(PointF pointF, PointF pointF2) {
            this.f10968c = new PointF();
            this.f10969d = new PointF();
            this.f10970e = new PointF();
            this.a = pointF;
            this.f10967b = pointF2;
        }

        private float a(float f2) {
            PointF pointF = this.f10970e;
            PointF pointF2 = this.a;
            float f3 = pointF2.x * 3.0f;
            pointF.x = f3;
            PointF pointF3 = this.f10969d;
            float f4 = ((this.f10967b.x - pointF2.x) * 3.0f) - f3;
            pointF3.x = f4;
            PointF pointF4 = this.f10968c;
            float f5 = (1.0f - pointF.x) - f4;
            pointF4.x = f5;
            return f2 * (pointF.x + ((pointF3.x + (f5 * f2)) * f2));
        }

        private float d(float f2) {
            return this.f10970e.x + (f2 * ((this.f10969d.x * 2.0f) + (this.f10968c.x * 3.0f * f2)));
        }

        protected float b(float f2) {
            PointF pointF = this.f10970e;
            PointF pointF2 = this.a;
            float f3 = pointF2.y * 3.0f;
            pointF.y = f3;
            PointF pointF3 = this.f10969d;
            float f4 = ((this.f10967b.y - pointF2.y) * 3.0f) - f3;
            pointF3.y = f4;
            PointF pointF4 = this.f10968c;
            float f5 = (1.0f - pointF.y) - f4;
            pointF4.y = f5;
            return f2 * (pointF.y + ((pointF3.y + (f5 * f2)) * f2));
        }

        public float c(float f2) {
            return b(e(f2));
        }

        protected float e(float f2) {
            float f3 = f2;
            for (int i2 = 1; i2 < 14; i2++) {
                float a = a(f3) - f2;
                if (Math.abs(a) < 0.001d) {
                    break;
                }
                f3 -= a / d(f3);
            }
            return f3;
        }

        public a(float f2, float f3, float f4, float f5) {
            this(new PointF(f2, f3), new PointF(f4, f5));
        }
    }
}