package com.rd.c.d.b;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: BasicDrawer.java */
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private Paint f10671c;

    public b(Paint paint, com.rd.c.c.a aVar) {
        super(paint, aVar);
        Paint paint2 = new Paint();
        this.f10671c = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f10671c.setAntiAlias(true);
        this.f10671c.setStrokeWidth(aVar.s());
    }

    public void a(Canvas canvas, int i2, boolean z, int i3, int i4) {
        Paint paint;
        float m = this.f10670b.m();
        int s = this.f10670b.s();
        float o = this.f10670b.o();
        int p = this.f10670b.p();
        int t = this.f10670b.t();
        int q = this.f10670b.q();
        com.rd.b.d.a b2 = this.f10670b.b();
        if ((b2 == com.rd.b.d.a.SCALE && !z) || (b2 == com.rd.b.d.a.SCALE_DOWN && z)) {
            m *= o;
        }
        if (i2 != q) {
            p = t;
        }
        if (b2 == com.rd.b.d.a.FILL && i2 != q) {
            paint = this.f10671c;
            paint.setStrokeWidth(s);
        } else {
            paint = this.a;
        }
        paint.setColor(p);
        canvas.drawCircle(i3, i4, m, paint);
    }
}