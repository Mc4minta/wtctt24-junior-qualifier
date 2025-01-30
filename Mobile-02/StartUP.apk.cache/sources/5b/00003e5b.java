package com.makeramen.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class RoundedImageView extends ImageView {
    public static final Shader.TileMode a = Shader.TileMode.CLAMP;

    /* renamed from: b  reason: collision with root package name */
    private static final ImageView.ScaleType[] f10513b = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: c  reason: collision with root package name */
    private final float[] f10514c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f10515d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f10516e;

    /* renamed from: f  reason: collision with root package name */
    private float f10517f;

    /* renamed from: g  reason: collision with root package name */
    private ColorFilter f10518g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10519h;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f10520j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10521k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10522l;
    private boolean m;
    private int n;
    private int p;
    private ImageView.ScaleType q;
    private Shader.TileMode t;
    private Shader.TileMode u;

    /* JADX INFO: Access modifiers changed from: package-private */
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
                a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        Drawable drawable = this.f10520j;
        if (drawable == null || !this.f10519h) {
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f10520j = mutate;
        if (this.f10521k) {
            mutate.setColorFilter(this.f10518g);
        }
    }

    private static Shader.TileMode b(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return null;
                }
                return Shader.TileMode.MIRROR;
            }
            return Shader.TileMode.REPEAT;
        }
        return Shader.TileMode.CLAMP;
    }

    private Drawable c() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.p;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e2) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.p, e2);
                this.p = 0;
            }
        }
        return b.e(drawable);
    }

    private Drawable d() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.n;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e2) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.n, e2);
                this.n = 0;
            }
        }
        return b.e(drawable);
    }

    private void f(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof b) {
            b bVar = (b) drawable;
            bVar.l(scaleType).i(this.f10517f).h(this.f10516e).k(this.f10522l).m(this.t).n(this.u);
            float[] fArr = this.f10514c;
            if (fArr != null) {
                bVar.j(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            a();
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                f(layerDrawable.getDrawable(i2), scaleType);
            }
        }
    }

    private void g(boolean z) {
        if (this.m) {
            if (z) {
                this.f10515d = b.e(this.f10515d);
            }
            f(this.f10515d, ImageView.ScaleType.FIT_XY);
        }
    }

    private void h() {
        f(this.f10520j, this.q);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public void e(float f2, float f3, float f4, float f5) {
        float[] fArr = this.f10514c;
        if (fArr[0] == f2 && fArr[1] == f3 && fArr[2] == f5 && fArr[3] == f4) {
            return;
        }
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[3] = f4;
        fArr[2] = f5;
        h();
        g(false);
        invalidate();
    }

    public int getBorderColor() {
        return this.f10516e.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.f10516e;
    }

    public float getBorderWidth() {
        return this.f10517f;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float f2 = 0.0f;
        for (float f3 : this.f10514c) {
            f2 = Math.max(f3, f2);
        }
        return f2;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.q;
    }

    public Shader.TileMode getTileModeX() {
        return this.t;
    }

    public Shader.TileMode getTileModeY() {
        return this.u;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        ColorDrawable colorDrawable = new ColorDrawable(i2);
        this.f10515d = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f10515d = drawable;
        g(true);
        super.setBackgroundDrawable(this.f10515d);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        if (this.p != i2) {
            this.p = i2;
            Drawable c2 = c();
            this.f10515d = c2;
            setBackgroundDrawable(c2);
        }
    }

    public void setBorderColor(int i2) {
        setBorderColor(ColorStateList.valueOf(i2));
    }

    public void setBorderWidth(int i2) {
        setBorderWidth(getResources().getDimension(i2));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f10518g != colorFilter) {
            this.f10518g = colorFilter;
            this.f10521k = true;
            this.f10519h = true;
            a();
            invalidate();
        }
    }

    public void setCornerRadius(float f2) {
        e(f2, f2, f2, f2);
    }

    public void setCornerRadiusDimen(int i2) {
        float dimension = getResources().getDimension(i2);
        e(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.n = 0;
        this.f10520j = b.d(bitmap);
        h();
        super.setImageDrawable(this.f10520j);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.n = 0;
        this.f10520j = b.e(drawable);
        h();
        super.setImageDrawable(this.f10520j);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        if (this.n != i2) {
            this.n = i2;
            this.f10520j = d();
            h();
            super.setImageDrawable(this.f10520j);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.f10522l = z;
        h();
        g(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.q != scaleType) {
            this.q = scaleType;
            switch (a.a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            h();
            g(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.t == tileMode) {
            return;
        }
        this.t = tileMode;
        h();
        g(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.u == tileMode) {
            return;
        }
        this.u = tileMode;
        h();
        g(false);
        invalidate();
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.f10514c = fArr;
        this.f10516e = ColorStateList.valueOf(-16777216);
        this.f10517f = 0.0f;
        this.f10518g = null;
        this.f10519h = false;
        this.f10521k = false;
        this.f10522l = false;
        this.m = false;
        Shader.TileMode tileMode = a;
        this.t = tileMode;
        this.u = tileMode;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.makeramen.roundedimageview.a.a, i2, 0);
        int i3 = obtainStyledAttributes.getInt(com.makeramen.roundedimageview.a.f10523b, -1);
        if (i3 >= 0) {
            setScaleType(f10513b[i3]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.makeramen.roundedimageview.a.f10526e, -1);
        fArr[0] = obtainStyledAttributes.getDimensionPixelSize(com.makeramen.roundedimageview.a.f10529h, -1);
        fArr[1] = obtainStyledAttributes.getDimensionPixelSize(com.makeramen.roundedimageview.a.f10530i, -1);
        fArr[2] = obtainStyledAttributes.getDimensionPixelSize(com.makeramen.roundedimageview.a.f10528g, -1);
        fArr[3] = obtainStyledAttributes.getDimensionPixelSize(com.makeramen.roundedimageview.a.f10527f, -1);
        int length = fArr.length;
        boolean z = false;
        for (int i4 = 0; i4 < length; i4++) {
            float[] fArr2 = this.f10514c;
            if (fArr2[i4] < 0.0f) {
                fArr2[i4] = 0.0f;
            } else {
                z = true;
            }
        }
        if (!z) {
            dimensionPixelSize = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length2 = this.f10514c.length;
            for (int i5 = 0; i5 < length2; i5++) {
                this.f10514c[i5] = dimensionPixelSize;
            }
        }
        float dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(com.makeramen.roundedimageview.a.f10525d, -1);
        this.f10517f = dimensionPixelSize2;
        if (dimensionPixelSize2 < 0.0f) {
            this.f10517f = 0.0f;
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(com.makeramen.roundedimageview.a.f10524c);
        this.f10516e = colorStateList;
        if (colorStateList == null) {
            this.f10516e = ColorStateList.valueOf(-16777216);
        }
        this.m = obtainStyledAttributes.getBoolean(com.makeramen.roundedimageview.a.f10531j, false);
        this.f10522l = obtainStyledAttributes.getBoolean(com.makeramen.roundedimageview.a.f10532k, false);
        int i6 = obtainStyledAttributes.getInt(com.makeramen.roundedimageview.a.f10533l, -2);
        if (i6 != -2) {
            setTileModeX(b(i6));
            setTileModeY(b(i6));
        }
        int i7 = obtainStyledAttributes.getInt(com.makeramen.roundedimageview.a.m, -2);
        if (i7 != -2) {
            setTileModeX(b(i7));
        }
        int i8 = obtainStyledAttributes.getInt(com.makeramen.roundedimageview.a.n, -2);
        if (i8 != -2) {
            setTileModeY(b(i8));
        }
        h();
        g(true);
        if (this.m) {
            super.setBackgroundDrawable(this.f10515d);
        }
        obtainStyledAttributes.recycle();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.f10516e.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.f10516e = colorStateList;
        h();
        g(false);
        if (this.f10517f > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f2) {
        if (this.f10517f == f2) {
            return;
        }
        this.f10517f = f2;
        h();
        g(false);
        invalidate();
    }
}