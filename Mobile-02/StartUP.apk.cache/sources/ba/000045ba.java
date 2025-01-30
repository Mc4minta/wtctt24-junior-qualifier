package e.f.h.e;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: ArrayDrawable.java */
/* loaded from: classes2.dex */
public class a extends Drawable implements Drawable.Callback, s, r {
    private s a;

    /* renamed from: c  reason: collision with root package name */
    private final Drawable[] f12247c;

    /* renamed from: d  reason: collision with root package name */
    private final c[] f12248d;

    /* renamed from: b  reason: collision with root package name */
    private final d f12246b = new d();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f12249e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private boolean f12250f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12251g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12252h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArrayDrawable.java */
    /* renamed from: e.f.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0268a implements c {
        final /* synthetic */ int a;

        C0268a(int i2) {
            this.a = i2;
        }

        @Override // e.f.h.e.c
        public Drawable k() {
            return a.this.c(this.a);
        }

        @Override // e.f.h.e.c
        public Drawable setDrawable(Drawable drawable) {
            return a.this.h(this.a, drawable);
        }
    }

    public a(Drawable[] drawableArr) {
        int i2 = 0;
        e.f.d.c.i.g(drawableArr);
        this.f12247c = drawableArr;
        while (true) {
            Drawable[] drawableArr2 = this.f12247c;
            if (i2 < drawableArr2.length) {
                e.d(drawableArr2[i2], this, this);
                i2++;
            } else {
                this.f12248d = new c[drawableArr2.length];
                return;
            }
        }
    }

    private c a(int i2) {
        return new C0268a(i2);
    }

    @Override // e.f.h.e.r
    public void b(s sVar) {
        this.a = sVar;
    }

    public Drawable c(int i2) {
        e.f.d.c.i.b(i2 >= 0);
        e.f.d.c.i.b(i2 < this.f12247c.length);
        return this.f12247c[i2];
    }

    @Override // e.f.h.e.s
    public void d(Matrix matrix) {
        s sVar = this.a;
        if (sVar != null) {
            sVar.d(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.draw(canvas);
            }
            i2++;
        }
    }

    public c e(int i2) {
        e.f.d.c.i.b(i2 >= 0);
        e.f.d.c.i.b(i2 < this.f12248d.length);
        c[] cVarArr = this.f12248d;
        if (cVarArr[i2] == null) {
            cVarArr[i2] = a(i2);
        }
        return this.f12248d[i2];
    }

    public int f() {
        return this.f12247c.length;
    }

    @Override // e.f.h.e.s
    public void g(RectF rectF) {
        s sVar = this.a;
        if (sVar != null) {
            sVar.g(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i2 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                i3 = Math.max(i3, drawable.getIntrinsicHeight());
            }
            i2++;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i2 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                i3 = Math.max(i3, drawable.getIntrinsicWidth());
            }
            i2++;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f12247c.length == 0) {
            return -2;
        }
        int i2 = -1;
        int i3 = 1;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i3 >= drawableArr.length) {
                return i2;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null) {
                i2 = Drawable.resolveOpacity(i2, drawable.getOpacity());
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int i2 = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        Rect rect2 = this.f12249e;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i2 >= drawableArr.length) {
                return true;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.getPadding(rect2);
                rect.left = Math.max(rect.left, rect2.left);
                rect.top = Math.max(rect.top, rect2.top);
                rect.right = Math.max(rect.right, rect2.right);
                rect.bottom = Math.max(rect.bottom, rect2.bottom);
            }
            i2++;
        }
    }

    public Drawable h(int i2, Drawable drawable) {
        e.f.d.c.i.b(i2 >= 0);
        e.f.d.c.i.b(i2 < this.f12247c.length);
        Drawable drawable2 = this.f12247c[i2];
        if (drawable != drawable2) {
            if (drawable != null && this.f12252h) {
                drawable.mutate();
            }
            e.d(this.f12247c[i2], null, null);
            e.d(drawable, null, null);
            e.e(drawable, this.f12246b);
            e.a(drawable, this);
            e.d(drawable, this, this);
            this.f12251g = false;
            this.f12247c[i2] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.f12251g) {
            this.f12250f = false;
            int i2 = 0;
            while (true) {
                Drawable[] drawableArr = this.f12247c;
                boolean z = true;
                if (i2 >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i2];
                boolean z2 = this.f12250f;
                if (drawable == null || !drawable.isStateful()) {
                    z = false;
                }
                this.f12250f = z2 | z;
                i2++;
            }
            this.f12251g = true;
        }
        return this.f12250f;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.mutate();
                }
                i2++;
            } else {
                this.f12252h = true;
                return this;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        int i3 = 0;
        boolean z = false;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i3 >= drawableArr.length) {
                return z;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null && drawable.setLevel(i2)) {
                z = true;
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int i2 = 0;
        boolean z = false;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i2 >= drawableArr.length) {
                return z;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f12246b.b(i2);
        int i3 = 0;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i3 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null) {
                drawable.setAlpha(i2);
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f12246b.c(colorFilter);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f12246b.d(z);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setDither(z);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f12246b.e(z);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f2, float f3) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setHotspot(f2, f3);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f12247c;
            if (i2 >= drawableArr.length) {
                return visible;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}