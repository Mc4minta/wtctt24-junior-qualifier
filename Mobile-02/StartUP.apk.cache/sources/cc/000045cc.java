package e.f.h.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import e.f.h.e.q;

/* compiled from: ScaleTypeDrawable.java */
/* loaded from: classes2.dex */
public class p extends g {

    /* renamed from: e  reason: collision with root package name */
    q.b f12306e;

    /* renamed from: f  reason: collision with root package name */
    Object f12307f;

    /* renamed from: g  reason: collision with root package name */
    PointF f12308g;

    /* renamed from: h  reason: collision with root package name */
    int f12309h;

    /* renamed from: j  reason: collision with root package name */
    int f12310j;

    /* renamed from: k  reason: collision with root package name */
    Matrix f12311k;

    /* renamed from: l  reason: collision with root package name */
    private Matrix f12312l;

    public p(Drawable drawable, q.b bVar) {
        super((Drawable) e.f.d.c.i.g(drawable));
        this.f12308g = null;
        this.f12309h = 0;
        this.f12310j = 0;
        this.f12312l = new Matrix();
        this.f12306e = bVar;
    }

    private void q() {
        boolean z;
        q.b bVar = this.f12306e;
        boolean z2 = true;
        if (bVar instanceof q.l) {
            Object state = ((q.l) bVar).getState();
            z = state == null || !state.equals(this.f12307f);
            this.f12307f = state;
        } else {
            z = false;
        }
        if (this.f12309h == getCurrent().getIntrinsicWidth() && this.f12310j == getCurrent().getIntrinsicHeight()) {
            z2 = false;
        }
        if (z2 || z) {
            p();
        }
    }

    @Override // e.f.h.e.g, e.f.h.e.s
    public void d(Matrix matrix) {
        m(matrix);
        q();
        Matrix matrix2 = this.f12311k;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        q();
        if (this.f12311k != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.f12311k);
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

    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        p();
    }

    void p() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.f12309h = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.f12310j = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.f12311k = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.f12311k = null;
        } else if (this.f12306e == q.b.a) {
            current.setBounds(bounds);
            this.f12311k = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            q.b bVar = this.f12306e;
            Matrix matrix = this.f12312l;
            PointF pointF = this.f12308g;
            bVar.a(matrix, bounds, intrinsicWidth, intrinsicHeight, pointF != null ? pointF.x : 0.5f, pointF != null ? pointF.y : 0.5f);
            this.f12311k = this.f12312l;
        }
    }

    public q.b r() {
        return this.f12306e;
    }

    public void s(PointF pointF) {
        if (e.f.d.c.h.a(this.f12308g, pointF)) {
            return;
        }
        if (this.f12308g == null) {
            this.f12308g = new PointF();
        }
        this.f12308g.set(pointF);
        p();
        invalidateSelf();
    }

    public void t(q.b bVar) {
        if (e.f.d.c.h.a(this.f12306e, bVar)) {
            return;
        }
        this.f12306e = bVar;
        this.f12307f = null;
        p();
        invalidateSelf();
    }
}