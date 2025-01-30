package e.a.a.w.l;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import e.a.a.l;
import e.a.a.u.c.p;

/* compiled from: SolidLayer.java */
/* loaded from: classes.dex */
public class g extends a {
    private final Path A;
    private final d B;
    private e.a.a.u.c.a<ColorFilter, ColorFilter> C;
    private final RectF x;
    private final Paint y;
    private final float[] z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e.a.a.g gVar, d dVar) {
        super(gVar, dVar);
        this.x = new RectF();
        e.a.a.u.a aVar = new e.a.a.u.a();
        this.y = aVar;
        this.z = new float[8];
        this.A = new Path();
        this.B = dVar;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(dVar.m());
    }

    @Override // e.a.a.w.l.a, e.a.a.u.b.e
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        this.x.set(0.0f, 0.0f, this.B.o(), this.B.n());
        this.m.mapRect(this.x);
        rectF.set(this.x);
    }

    @Override // e.a.a.w.l.a, e.a.a.w.f
    public <T> void g(T t, e.a.a.a0.c<T> cVar) {
        super.g(t, cVar);
        if (t == l.C) {
            if (cVar == null) {
                this.C = null;
            } else {
                this.C = new p(cVar);
            }
        }
    }

    @Override // e.a.a.w.l.a
    public void t(Canvas canvas, Matrix matrix, int i2) {
        int alpha = Color.alpha(this.B.m());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i2 / 255.0f) * (((alpha / 255.0f) * (this.v.h() == null ? 100 : this.v.h().h().intValue())) / 100.0f) * 255.0f);
        this.y.setAlpha(intValue);
        e.a.a.u.c.a<ColorFilter, ColorFilter> aVar = this.C;
        if (aVar != null) {
            this.y.setColorFilter(aVar.h());
        }
        if (intValue > 0) {
            float[] fArr = this.z;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.B.o();
            float[] fArr2 = this.z;
            fArr2[3] = 0.0f;
            fArr2[4] = this.B.o();
            this.z[5] = this.B.n();
            float[] fArr3 = this.z;
            fArr3[6] = 0.0f;
            fArr3[7] = this.B.n();
            matrix.mapPoints(this.z);
            this.A.reset();
            Path path = this.A;
            float[] fArr4 = this.z;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.A;
            float[] fArr5 = this.z;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.A;
            float[] fArr6 = this.z;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.A;
            float[] fArr7 = this.z;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.A;
            float[] fArr8 = this.z;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.A.close();
            canvas.drawPath(this.A, this.y);
        }
    }
}