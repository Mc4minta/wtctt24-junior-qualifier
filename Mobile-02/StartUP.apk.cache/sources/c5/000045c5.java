package e.f.h.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

/* compiled from: RoundedBitmapDrawable.java */
/* loaded from: classes2.dex */
public class k extends n {
    private final Paint H;
    private final Paint I;
    private final Bitmap J;
    private WeakReference<Bitmap> K;

    public k(Resources resources, Bitmap bitmap, Paint paint) {
        super(new BitmapDrawable(resources, bitmap));
        Paint paint2 = new Paint();
        this.H = paint2;
        Paint paint3 = new Paint(1);
        this.I = paint3;
        this.J = bitmap;
        if (paint != null) {
            paint2.set(paint);
        }
        paint2.setFlags(1);
        paint3.setStyle(Paint.Style.STROKE);
    }

    private void m() {
        WeakReference<Bitmap> weakReference = this.K;
        if (weakReference == null || weakReference.get() != this.J) {
            this.K = new WeakReference<>(this.J);
            Paint paint = this.H;
            Bitmap bitmap = this.J;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            this.f12300f = true;
        }
        if (this.f12300f) {
            this.H.getShader().setLocalMatrix(this.B);
            this.f12300f = false;
        }
        this.H.setFilterBitmap(d());
    }

    @Override // e.f.h.e.n, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("RoundedBitmapDrawable#draw");
        }
        if (!g()) {
            super.draw(canvas);
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
                return;
            }
            return;
        }
        k();
        j();
        m();
        int save = canvas.save();
        canvas.concat(this.y);
        canvas.drawPath(this.f12299e, this.H);
        float f2 = this.f12298d;
        if (f2 > 0.0f) {
            this.I.setStrokeWidth(f2);
            this.I.setColor(e.c(this.f12301g, this.H.getAlpha()));
            canvas.drawPath(this.f12302h, this.I);
        }
        canvas.restoreToCount(save);
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.f.h.e.n
    public boolean g() {
        return super.g() && this.J != null;
    }

    @Override // e.f.h.e.n, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        super.setAlpha(i2);
        if (i2 != this.H.getAlpha()) {
            this.H.setAlpha(i2);
            super.setAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // e.f.h.e.n, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.H.setColorFilter(colorFilter);
    }
}