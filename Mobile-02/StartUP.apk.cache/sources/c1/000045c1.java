package e.f.h.e;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: ForwardingDrawable.java */
/* loaded from: classes2.dex */
public class g extends Drawable implements Drawable.Callback, s, r, c {
    private static final Matrix a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private Drawable f12265b;

    /* renamed from: c  reason: collision with root package name */
    private final d f12266c = new d();

    /* renamed from: d  reason: collision with root package name */
    protected s f12267d;

    public g(Drawable drawable) {
        this.f12265b = drawable;
        e.d(drawable, this, this);
    }

    @Override // e.f.h.e.r
    public void b(s sVar) {
        this.f12267d = sVar;
    }

    @Override // e.f.h.e.s
    public void d(Matrix matrix) {
        m(matrix);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f12265b;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // e.f.h.e.s
    public void g(RectF rectF) {
        s sVar = this.f12267d;
        if (sVar != null) {
            sVar.g(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f12265b;
        if (drawable == null) {
            return super.getConstantState();
        }
        return drawable.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f12265b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f12265b;
        if (drawable == null) {
            return super.getIntrinsicHeight();
        }
        return drawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f12265b;
        if (drawable == null) {
            return super.getIntrinsicWidth();
        }
        return drawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f12265b;
        if (drawable == null) {
            return 0;
        }
        return drawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Drawable drawable = this.f12265b;
        if (drawable == null) {
            return super.getPadding(rect);
        }
        return drawable.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f12265b;
        if (drawable == null) {
            return false;
        }
        return drawable.isStateful();
    }

    @Override // e.f.h.e.c
    public Drawable k() {
        return getCurrent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(Matrix matrix) {
        s sVar = this.f12267d;
        if (sVar != null) {
            sVar.d(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f12265b;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public Drawable n(Drawable drawable) {
        Drawable o = o(drawable);
        invalidateSelf();
        return o;
    }

    protected Drawable o(Drawable drawable) {
        Drawable drawable2 = this.f12265b;
        e.d(drawable2, null, null);
        e.d(drawable, null, null);
        e.e(drawable, this.f12266c);
        e.a(drawable, this);
        e.d(drawable, this, this);
        this.f12265b = drawable;
        return drawable2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f12265b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        Drawable drawable = this.f12265b;
        if (drawable == null) {
            return super.onLevelChange(i2);
        }
        return drawable.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f12265b;
        if (drawable == null) {
            return super.onStateChange(iArr);
        }
        return drawable.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f12266c.b(i2);
        Drawable drawable = this.f12265b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f12266c.c(colorFilter);
        Drawable drawable = this.f12265b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f12266c.d(z);
        Drawable drawable = this.f12265b;
        if (drawable != null) {
            drawable.setDither(z);
        }
    }

    @Override // e.f.h.e.c
    public Drawable setDrawable(Drawable drawable) {
        return n(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f12266c.e(z);
        Drawable drawable = this.f12265b;
        if (drawable != null) {
            drawable.setFilterBitmap(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f12265b;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f12265b;
        return drawable == null ? visible : drawable.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}