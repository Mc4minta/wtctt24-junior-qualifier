package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: DropDrawer.java */
/* loaded from: classes2.dex */
public class d extends a {
    public d(Paint paint, com.rd.c.c.a aVar) {
        super(paint, aVar);
    }

    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3) {
        if (aVar instanceof com.rd.b.c.b.b) {
            com.rd.b.c.b.b bVar = (com.rd.b.c.b.b) aVar;
            int t = this.f10670b.t();
            int p = this.f10670b.p();
            this.a.setColor(t);
            canvas.drawCircle(i2, i3, this.f10670b.m(), this.a);
            this.a.setColor(p);
            if (this.f10670b.g() == com.rd.c.c.b.HORIZONTAL) {
                canvas.drawCircle(bVar.c(), bVar.a(), bVar.b(), this.a);
            } else {
                canvas.drawCircle(bVar.a(), bVar.c(), bVar.b(), this.a);
            }
        }
    }
}