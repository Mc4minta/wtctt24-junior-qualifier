package e.f.h.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: MatrixDrawable.java */
/* loaded from: classes2.dex */
public class h extends g {

    /* renamed from: e  reason: collision with root package name */
    private Matrix f12268e;

    /* renamed from: f  reason: collision with root package name */
    private Matrix f12269f;

    /* renamed from: g  reason: collision with root package name */
    private int f12270g;

    /* renamed from: h  reason: collision with root package name */
    private int f12271h;

    private void p() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.f12270g = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.f12271h = intrinsicHeight;
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.f12269f = this.f12268e;
            return;
        }
        current.setBounds(bounds);
        this.f12269f = null;
    }

    private void q() {
        if (this.f12270g == getCurrent().getIntrinsicWidth() && this.f12271h == getCurrent().getIntrinsicHeight()) {
            return;
        }
        p();
    }

    @Override // e.f.h.e.g, e.f.h.e.s
    public void d(Matrix matrix) {
        super.d(matrix);
        Matrix matrix2 = this.f12269f;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        q();
        if (this.f12269f != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.f12269f);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // e.f.h.e.g
    public Drawable n(Drawable drawable) {
        Drawable n = super.n(drawable);
        p();
        return n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        p();
    }
}