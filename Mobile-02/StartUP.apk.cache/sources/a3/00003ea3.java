package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: SlideDrawer.java */
/* loaded from: classes2.dex */
public class h extends a {
    public h(Paint paint, com.rd.c.c.a aVar) {
        super(paint, aVar);
    }

    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3) {
        if (aVar instanceof com.rd.b.c.b.e) {
            int a = ((com.rd.b.c.b.e) aVar).a();
            int t = this.f10670b.t();
            int p = this.f10670b.p();
            int m = this.f10670b.m();
            this.a.setColor(t);
            float f2 = i2;
            float f3 = i3;
            float f4 = m;
            canvas.drawCircle(f2, f3, f4, this.a);
            this.a.setColor(p);
            if (this.f10670b.g() == com.rd.c.c.b.HORIZONTAL) {
                canvas.drawCircle(a, f3, f4, this.a);
            } else {
                canvas.drawCircle(f2, a, f4, this.a);
            }
        }
    }
}