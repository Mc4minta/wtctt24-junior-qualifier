package e.a.a.w.l;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import e.a.a.l;
import e.a.a.u.c.p;

/* compiled from: ImageLayer.java */
/* loaded from: classes.dex */
public class c extends a {
    private e.a.a.u.c.a<ColorFilter, ColorFilter> A;
    private final Paint x;
    private final Rect y;
    private final Rect z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e.a.a.g gVar, d dVar) {
        super(gVar, dVar);
        this.x = new e.a.a.u.a(3);
        this.y = new Rect();
        this.z = new Rect();
    }

    private Bitmap J() {
        return this.n.r(this.o.k());
    }

    @Override // e.a.a.w.l.a, e.a.a.u.b.e
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        Bitmap J = J();
        if (J != null) {
            rectF.set(0.0f, 0.0f, J.getWidth() * e.a.a.z.h.e(), J.getHeight() * e.a.a.z.h.e());
            this.m.mapRect(rectF);
        }
    }

    @Override // e.a.a.w.l.a, e.a.a.w.f
    public <T> void g(T t, e.a.a.a0.c<T> cVar) {
        super.g(t, cVar);
        if (t == l.C) {
            if (cVar == null) {
                this.A = null;
            } else {
                this.A = new p(cVar);
            }
        }
    }

    @Override // e.a.a.w.l.a
    public void t(Canvas canvas, Matrix matrix, int i2) {
        Bitmap J = J();
        if (J == null || J.isRecycled()) {
            return;
        }
        float e2 = e.a.a.z.h.e();
        this.x.setAlpha(i2);
        e.a.a.u.c.a<ColorFilter, ColorFilter> aVar = this.A;
        if (aVar != null) {
            this.x.setColorFilter(aVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.y.set(0, 0, J.getWidth(), J.getHeight());
        this.z.set(0, 0, (int) (J.getWidth() * e2), (int) (J.getHeight() * e2));
        canvas.drawBitmap(J, this.y, this.z, this.x);
        canvas.restore();
    }
}