package com.makeramen.roundedimageview;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
import java.util.HashSet;

/* compiled from: RoundedDrawable.java */
/* loaded from: classes2.dex */
public class b extends Drawable {
    private final RectF a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f10534b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final RectF f10535c;

    /* renamed from: d  reason: collision with root package name */
    private final Bitmap f10536d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f10537e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10538f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10539g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f10540h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f10541i;

    /* renamed from: j  reason: collision with root package name */
    private final Matrix f10542j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f10543k;

    /* renamed from: l  reason: collision with root package name */
    private Shader.TileMode f10544l;
    private Shader.TileMode m;
    private boolean n;
    private float o;
    private final boolean[] p;
    private boolean q;
    private float r;
    private ColorStateList s;
    private ImageView.ScaleType t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RoundedDrawable.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f10535c = rectF;
        this.f10540h = new RectF();
        this.f10542j = new Matrix();
        this.f10543k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f10544l = tileMode;
        this.m = tileMode;
        this.n = true;
        this.o = 0.0f;
        this.p = new boolean[]{true, true, true, true};
        this.q = false;
        this.r = 0.0f;
        this.s = ColorStateList.valueOf(-16777216);
        this.t = ImageView.ScaleType.FIT_CENTER;
        this.f10536d = bitmap;
        int width = bitmap.getWidth();
        this.f10538f = width;
        int height = bitmap.getHeight();
        this.f10539g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.f10537e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f10541i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.r);
    }

    private static boolean a(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap c(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static b d(Bitmap bitmap) {
        if (bitmap != null) {
            return new b(bitmap);
        }
        return null;
    }

    public static Drawable e(Drawable drawable) {
        if (drawable == null || (drawable instanceof b)) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), e(layerDrawable.getDrawable(i2)));
            }
            return layerDrawable;
        }
        Bitmap c2 = c(drawable);
        return c2 != null ? new b(c2) : drawable;
    }

    private void f(Canvas canvas) {
        if (a(this.p) || this.o == 0.0f) {
            return;
        }
        RectF rectF = this.f10534b;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float width = rectF.width() + f2;
        float height = this.f10534b.height() + f3;
        float f4 = this.o;
        if (!this.p[0]) {
            this.f10543k.set(f2, f3, f2 + f4, f3 + f4);
            canvas.drawRect(this.f10543k, this.f10537e);
        }
        if (!this.p[1]) {
            this.f10543k.set(width - f4, f3, width, f4);
            canvas.drawRect(this.f10543k, this.f10537e);
        }
        if (!this.p[2]) {
            this.f10543k.set(width - f4, height - f4, width, height);
            canvas.drawRect(this.f10543k, this.f10537e);
        }
        if (this.p[3]) {
            return;
        }
        this.f10543k.set(f2, height - f4, f4 + f2, height);
        canvas.drawRect(this.f10543k, this.f10537e);
    }

    private void g(Canvas canvas) {
        float f2;
        if (a(this.p) || this.o == 0.0f) {
            return;
        }
        RectF rectF = this.f10534b;
        float f3 = rectF.left;
        float f4 = rectF.top;
        float width = rectF.width() + f3;
        float height = f4 + this.f10534b.height();
        float f5 = this.o;
        float f6 = this.r / 2.0f;
        if (!this.p[0]) {
            canvas.drawLine(f3 - f6, f4, f3 + f5, f4, this.f10541i);
            canvas.drawLine(f3, f4 - f6, f3, f4 + f5, this.f10541i);
        }
        if (!this.p[1]) {
            canvas.drawLine((width - f5) - f6, f4, width, f4, this.f10541i);
            canvas.drawLine(width, f4 - f6, width, f4 + f5, this.f10541i);
        }
        if (this.p[2]) {
            f2 = f5;
        } else {
            f2 = f5;
            canvas.drawLine((width - f5) - f6, height, width + f6, height, this.f10541i);
            canvas.drawLine(width, height - f2, width, height, this.f10541i);
        }
        if (this.p[3]) {
            return;
        }
        canvas.drawLine(f3 - f6, height, f3 + f2, height, this.f10541i);
        canvas.drawLine(f3, height - f2, f3, height, this.f10541i);
    }

    private void o() {
        float width;
        float height;
        int i2 = a.a[this.t.ordinal()];
        if (i2 == 1) {
            this.f10540h.set(this.a);
            RectF rectF = this.f10540h;
            float f2 = this.r;
            rectF.inset(f2 / 2.0f, f2 / 2.0f);
            this.f10542j.reset();
            this.f10542j.setTranslate((int) (((this.f10540h.width() - this.f10538f) * 0.5f) + 0.5f), (int) (((this.f10540h.height() - this.f10539g) * 0.5f) + 0.5f));
        } else if (i2 == 2) {
            this.f10540h.set(this.a);
            RectF rectF2 = this.f10540h;
            float f3 = this.r;
            rectF2.inset(f3 / 2.0f, f3 / 2.0f);
            this.f10542j.reset();
            float f4 = 0.0f;
            if (this.f10538f * this.f10540h.height() > this.f10540h.width() * this.f10539g) {
                width = this.f10540h.height() / this.f10539g;
                height = 0.0f;
                f4 = (this.f10540h.width() - (this.f10538f * width)) * 0.5f;
            } else {
                width = this.f10540h.width() / this.f10538f;
                height = (this.f10540h.height() - (this.f10539g * width)) * 0.5f;
            }
            this.f10542j.setScale(width, width);
            Matrix matrix = this.f10542j;
            float f5 = this.r;
            matrix.postTranslate(((int) (f4 + 0.5f)) + (f5 / 2.0f), ((int) (height + 0.5f)) + (f5 / 2.0f));
        } else if (i2 == 3) {
            this.f10542j.reset();
            float min = (((float) this.f10538f) > this.a.width() || ((float) this.f10539g) > this.a.height()) ? Math.min(this.a.width() / this.f10538f, this.a.height() / this.f10539g) : 1.0f;
            this.f10542j.setScale(min, min);
            this.f10542j.postTranslate((int) (((this.a.width() - (this.f10538f * min)) * 0.5f) + 0.5f), (int) (((this.a.height() - (this.f10539g * min)) * 0.5f) + 0.5f));
            this.f10540h.set(this.f10535c);
            this.f10542j.mapRect(this.f10540h);
            RectF rectF3 = this.f10540h;
            float f6 = this.r;
            rectF3.inset(f6 / 2.0f, f6 / 2.0f);
            this.f10542j.setRectToRect(this.f10535c, this.f10540h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 5) {
            this.f10540h.set(this.f10535c);
            this.f10542j.setRectToRect(this.f10535c, this.a, Matrix.ScaleToFit.END);
            this.f10542j.mapRect(this.f10540h);
            RectF rectF4 = this.f10540h;
            float f7 = this.r;
            rectF4.inset(f7 / 2.0f, f7 / 2.0f);
            this.f10542j.setRectToRect(this.f10535c, this.f10540h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 6) {
            this.f10540h.set(this.f10535c);
            this.f10542j.setRectToRect(this.f10535c, this.a, Matrix.ScaleToFit.START);
            this.f10542j.mapRect(this.f10540h);
            RectF rectF5 = this.f10540h;
            float f8 = this.r;
            rectF5.inset(f8 / 2.0f, f8 / 2.0f);
            this.f10542j.setRectToRect(this.f10535c, this.f10540h, Matrix.ScaleToFit.FILL);
        } else if (i2 != 7) {
            this.f10540h.set(this.f10535c);
            this.f10542j.setRectToRect(this.f10535c, this.a, Matrix.ScaleToFit.CENTER);
            this.f10542j.mapRect(this.f10540h);
            RectF rectF6 = this.f10540h;
            float f9 = this.r;
            rectF6.inset(f9 / 2.0f, f9 / 2.0f);
            this.f10542j.setRectToRect(this.f10535c, this.f10540h, Matrix.ScaleToFit.FILL);
        } else {
            this.f10540h.set(this.a);
            RectF rectF7 = this.f10540h;
            float f10 = this.r;
            rectF7.inset(f10 / 2.0f, f10 / 2.0f);
            this.f10542j.reset();
            this.f10542j.setRectToRect(this.f10535c, this.f10540h, Matrix.ScaleToFit.FILL);
        }
        this.f10534b.set(this.f10540h);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            BitmapShader bitmapShader = new BitmapShader(this.f10536d, this.f10544l, this.m);
            Shader.TileMode tileMode = this.f10544l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.m == tileMode2) {
                bitmapShader.setLocalMatrix(this.f10542j);
            }
            this.f10537e.setShader(bitmapShader);
            this.n = false;
        }
        if (this.q) {
            if (this.r > 0.0f) {
                canvas.drawOval(this.f10534b, this.f10537e);
                canvas.drawOval(this.f10540h, this.f10541i);
                return;
            }
            canvas.drawOval(this.f10534b, this.f10537e);
        } else if (b(this.p)) {
            float f2 = this.o;
            if (this.r > 0.0f) {
                canvas.drawRoundRect(this.f10534b, f2, f2, this.f10537e);
                canvas.drawRoundRect(this.f10540h, f2, f2, this.f10541i);
                f(canvas);
                g(canvas);
                return;
            }
            canvas.drawRoundRect(this.f10534b, f2, f2, this.f10537e);
            f(canvas);
        } else {
            canvas.drawRect(this.f10534b, this.f10537e);
            if (this.r > 0.0f) {
                canvas.drawRect(this.f10540h, this.f10541i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f10537e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f10537e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f10539g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f10538f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public b h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.s = colorStateList;
        this.f10541i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public b i(float f2) {
        this.r = f2;
        this.f10541i.setStrokeWidth(f2);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.s.isStateful();
    }

    public b j(float f2, float f3, float f4, float f5) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.add(Float.valueOf(f5));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (!Float.isInfinite(floatValue) && !Float.isNaN(floatValue) && floatValue >= 0.0f) {
                    this.o = floatValue;
                } else {
                    throw new IllegalArgumentException("Invalid radius value: " + floatValue);
                }
            } else {
                this.o = 0.0f;
            }
            boolean[] zArr = this.p;
            zArr[0] = f2 > 0.0f;
            zArr[1] = f3 > 0.0f;
            zArr[2] = f4 > 0.0f;
            zArr[3] = f5 > 0.0f;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public b k(boolean z) {
        this.q = z;
        return this;
    }

    public b l(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.t != scaleType) {
            this.t = scaleType;
            o();
        }
        return this;
    }

    public b m(Shader.TileMode tileMode) {
        if (this.f10544l != tileMode) {
            this.f10544l = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    public b n(Shader.TileMode tileMode) {
        if (this.m != tileMode) {
            this.m = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a.set(rect);
        o();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.s.getColorForState(iArr, 0);
        if (this.f10541i.getColor() != colorForState) {
            this.f10541i.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f10537e.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f10537e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f10537e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f10537e.setFilterBitmap(z);
        invalidateSelf();
    }
}