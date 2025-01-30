package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: ColorDrawer.java */
/* loaded from: classes2.dex */
public class c extends a {
    public c(Paint paint, com.rd.c.c.a aVar) {
        super(paint, aVar);
    }

    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3, int i4) {
        if (aVar instanceof com.rd.b.c.b.a) {
            com.rd.b.c.b.a aVar2 = (com.rd.b.c.b.a) aVar;
            float m = this.f10670b.m();
            int p = this.f10670b.p();
            int q = this.f10670b.q();
            int r = this.f10670b.r();
            int f2 = this.f10670b.f();
            if (this.f10670b.z()) {
                if (i2 == r) {
                    p = aVar2.a();
                } else if (i2 == q) {
                    p = aVar2.b();
                }
            } else if (i2 == q) {
                p = aVar2.a();
            } else if (i2 == f2) {
                p = aVar2.b();
            }
            this.a.setColor(p);
            canvas.drawCircle(i3, i4, m, this.a);
        }
    }
}