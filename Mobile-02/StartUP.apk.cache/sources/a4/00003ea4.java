package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: SwapDrawer.java */
/* loaded from: classes2.dex */
public class i extends a {
    public i(Paint paint, com.rd.c.c.a aVar) {
        super(paint, aVar);
    }

    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3, int i4) {
        if (aVar instanceof com.rd.b.c.b.f) {
            com.rd.b.c.b.f fVar = (com.rd.b.c.b.f) aVar;
            int p = this.f10670b.p();
            int t = this.f10670b.t();
            int m = this.f10670b.m();
            int q = this.f10670b.q();
            int r = this.f10670b.r();
            int f2 = this.f10670b.f();
            int a = fVar.a();
            if (this.f10670b.z()) {
                if (i2 == r) {
                    a = fVar.a();
                } else {
                    if (i2 == q) {
                        a = fVar.b();
                    }
                    p = t;
                }
            } else if (i2 == f2) {
                a = fVar.a();
            } else {
                if (i2 == q) {
                    a = fVar.b();
                }
                p = t;
            }
            this.a.setColor(p);
            if (this.f10670b.g() == com.rd.c.c.b.HORIZONTAL) {
                canvas.drawCircle(a, i4, m, this.a);
            } else {
                canvas.drawCircle(i3, a, m, this.a);
            }
        }
    }
}