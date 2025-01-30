package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: FillDrawer.java */
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    private Paint f10672c;

    public e(Paint paint, com.rd.c.c.a aVar) {
        super(paint, aVar);
        Paint paint2 = new Paint();
        this.f10672c = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f10672c.setAntiAlias(true);
    }

    public void a(Canvas canvas, com.rd.b.c.a aVar, int i2, int i3, int i4) {
        if (aVar instanceof com.rd.b.c.b.c) {
            com.rd.b.c.b.c cVar = (com.rd.b.c.b.c) aVar;
            int t = this.f10670b.t();
            float m = this.f10670b.m();
            int s = this.f10670b.s();
            int q = this.f10670b.q();
            int r = this.f10670b.r();
            int f2 = this.f10670b.f();
            if (this.f10670b.z()) {
                if (i2 == r) {
                    t = cVar.a();
                    m = cVar.e();
                    s = cVar.g();
                } else if (i2 == q) {
                    t = cVar.b();
                    m = cVar.f();
                    s = cVar.h();
                }
            } else if (i2 == q) {
                t = cVar.a();
                m = cVar.e();
                s = cVar.g();
            } else if (i2 == f2) {
                t = cVar.b();
                m = cVar.f();
                s = cVar.h();
            }
            this.f10672c.setColor(t);
            this.f10672c.setStrokeWidth(this.f10670b.s());
            float f3 = i3;
            float f4 = i4;
            canvas.drawCircle(f3, f4, this.f10670b.m(), this.f10672c);
            this.f10672c.setStrokeWidth(s);
            canvas.drawCircle(f3, f4, m, this.f10672c);
        }
    }
}