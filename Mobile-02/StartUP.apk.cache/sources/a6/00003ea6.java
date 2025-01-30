package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* compiled from: WormDrawer.java */
/* loaded from: classes2.dex */
public class k extends a {

    /* renamed from: c  reason: collision with root package name */
    public RectF f10673c;

    public k(Paint paint, com.rd.c.c.a aVar) {
        super(paint, aVar);
        this.f10673c = new RectF();
    }

    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3) {
        if (aVar instanceof com.rd.b.c.b.h) {
            com.rd.b.c.b.h hVar = (com.rd.b.c.b.h) aVar;
            int b2 = hVar.b();
            int a = hVar.a();
            int m = this.f10670b.m();
            int t = this.f10670b.t();
            int p = this.f10670b.p();
            if (this.f10670b.g() == com.rd.c.c.b.HORIZONTAL) {
                RectF rectF = this.f10673c;
                rectF.left = b2;
                rectF.right = a;
                rectF.top = i3 - m;
                rectF.bottom = i3 + m;
            } else {
                RectF rectF2 = this.f10673c;
                rectF2.left = i2 - m;
                rectF2.right = i2 + m;
                rectF2.top = b2;
                rectF2.bottom = a;
            }
            this.a.setColor(t);
            float f2 = i2;
            float f3 = i3;
            float f4 = m;
            canvas.drawCircle(f2, f3, f4, this.a);
            this.a.setColor(p);
            canvas.drawRoundRect(this.f10673c, f4, f4, this.a);
        }
    }
}