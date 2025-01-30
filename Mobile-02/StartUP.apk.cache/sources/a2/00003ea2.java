package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: ScaleDrawer.java */
/* loaded from: classes2.dex */
public class g extends a {
    public g(Paint paint, com.rd.c.c.a aVar) {
        super(paint, aVar);
    }

    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3, int i4) {
        if (aVar instanceof com.rd.b.c.b.d) {
            com.rd.b.c.b.d dVar = (com.rd.b.c.b.d) aVar;
            float m = this.f10670b.m();
            int p = this.f10670b.p();
            int q = this.f10670b.q();
            int r = this.f10670b.r();
            int f2 = this.f10670b.f();
            if (this.f10670b.z()) {
                if (i2 == r) {
                    m = dVar.e();
                    p = dVar.a();
                } else if (i2 == q) {
                    m = dVar.f();
                    p = dVar.b();
                }
            } else if (i2 == q) {
                m = dVar.e();
                p = dVar.a();
            } else if (i2 == f2) {
                m = dVar.f();
                p = dVar.b();
            }
            this.a.setColor(p);
            canvas.drawCircle(i3, i4, m, this.a);
        }
    }
}