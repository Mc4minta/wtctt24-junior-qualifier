package de.hdodenhof.circleimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class CircleImageView extends ImageView {
    private static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config f11458b = Bitmap.Config.ARGB_8888;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f11459c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f11460d;

    /* renamed from: e  reason: collision with root package name */
    private final Matrix f11461e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f11462f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f11463g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f11464h;

    /* renamed from: j  reason: collision with root package name */
    private int f11465j;

    /* renamed from: k  reason: collision with root package name */
    private int f11466k;

    /* renamed from: l  reason: collision with root package name */
    private int f11467l;
    private Bitmap m;
    private BitmapShader n;
    private int p;
    private int q;
    private float t;
    private float u;
    private ColorFilter v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends ViewOutlineProvider {
        private b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            CircleImageView.this.f11460d.roundOut(rect);
            outline.setRoundRect(rect, rect.width() / 2.0f);
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        Paint paint = this.f11462f;
        if (paint != null) {
            paint.setColorFilter(this.v);
        }
    }

    private RectF c() {
        int width;
        int height;
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((width - min) / 2.0f);
        float paddingTop = getPaddingTop() + ((height - min) / 2.0f);
        float f2 = min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f2, f2 + paddingTop);
    }

    private Bitmap d(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, f11458b);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f11458b);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void e() {
        super.setScaleType(a);
        this.w = true;
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
        if (this.x) {
            g();
            this.x = false;
        }
    }

    private void f() {
        if (this.z) {
            this.m = null;
        } else {
            this.m = d(getDrawable());
        }
        g();
    }

    private void g() {
        int i2;
        if (!this.w) {
            this.x = true;
        } else if (getWidth() == 0 && getHeight() == 0) {
        } else {
            if (this.m == null) {
                invalidate();
                return;
            }
            Bitmap bitmap = this.m;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.n = new BitmapShader(bitmap, tileMode, tileMode);
            this.f11462f.setAntiAlias(true);
            this.f11462f.setShader(this.n);
            this.f11463g.setStyle(Paint.Style.STROKE);
            this.f11463g.setAntiAlias(true);
            this.f11463g.setColor(this.f11465j);
            this.f11463g.setStrokeWidth(this.f11466k);
            this.f11464h.setStyle(Paint.Style.FILL);
            this.f11464h.setAntiAlias(true);
            this.f11464h.setColor(this.f11467l);
            this.q = this.m.getHeight();
            this.p = this.m.getWidth();
            this.f11460d.set(c());
            this.u = Math.min((this.f11460d.height() - this.f11466k) / 2.0f, (this.f11460d.width() - this.f11466k) / 2.0f);
            this.f11459c.set(this.f11460d);
            if (!this.y && (i2 = this.f11466k) > 0) {
                this.f11459c.inset(i2 - 1.0f, i2 - 1.0f);
            }
            this.t = Math.min(this.f11459c.height() / 2.0f, this.f11459c.width() / 2.0f);
            b();
            h();
            invalidate();
        }
    }

    private void h() {
        float width;
        float height;
        this.f11461e.set(null);
        float f2 = 0.0f;
        if (this.p * this.f11459c.height() > this.f11459c.width() * this.q) {
            width = this.f11459c.height() / this.q;
            height = 0.0f;
            f2 = (this.f11459c.width() - (this.p * width)) * 0.5f;
        } else {
            width = this.f11459c.width() / this.p;
            height = (this.f11459c.height() - (this.q * width)) * 0.5f;
        }
        this.f11461e.setScale(width, width);
        Matrix matrix = this.f11461e;
        RectF rectF = this.f11459c;
        matrix.postTranslate(((int) (f2 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.n.setLocalMatrix(this.f11461e);
    }

    public int getBorderColor() {
        return this.f11465j;
    }

    public int getBorderWidth() {
        return this.f11466k;
    }

    public int getCircleBackgroundColor() {
        return this.f11467l;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.v;
    }

    @Deprecated
    public int getFillColor() {
        return getCircleBackgroundColor();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.z) {
            super.onDraw(canvas);
        } else if (this.m == null) {
        } else {
            if (this.f11467l != 0) {
                canvas.drawCircle(this.f11459c.centerX(), this.f11459c.centerY(), this.t, this.f11464h);
            }
            canvas.drawCircle(this.f11459c.centerX(), this.f11459c.centerY(), this.t, this.f11462f);
            if (this.f11466k > 0) {
                canvas.drawCircle(this.f11460d.centerX(), this.f11460d.centerY(), this.u, this.f11463g);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        g();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i2) {
        if (i2 == this.f11465j) {
            return;
        }
        this.f11465j = i2;
        this.f11463g.setColor(i2);
        invalidate();
    }

    @Deprecated
    public void setBorderColorResource(int i2) {
        setBorderColor(getContext().getResources().getColor(i2));
    }

    public void setBorderOverlay(boolean z) {
        if (z == this.y) {
            return;
        }
        this.y = z;
        g();
    }

    public void setBorderWidth(int i2) {
        if (i2 == this.f11466k) {
            return;
        }
        this.f11466k = i2;
        g();
    }

    public void setCircleBackgroundColor(int i2) {
        if (i2 == this.f11467l) {
            return;
        }
        this.f11467l = i2;
        this.f11464h.setColor(i2);
        invalidate();
    }

    public void setCircleBackgroundColorResource(int i2) {
        setCircleBackgroundColor(getContext().getResources().getColor(i2));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.v) {
            return;
        }
        this.v = colorFilter;
        b();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.z == z) {
            return;
        }
        this.z = z;
        f();
    }

    @Deprecated
    public void setFillColor(int i2) {
        setCircleBackgroundColor(i2);
    }

    @Deprecated
    public void setFillColorResource(int i2) {
        setCircleBackgroundColorResource(i2);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        f();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        f();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        f();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        f();
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        g();
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        g();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11459c = new RectF();
        this.f11460d = new RectF();
        this.f11461e = new Matrix();
        this.f11462f = new Paint();
        this.f11463g = new Paint();
        this.f11464h = new Paint();
        this.f11465j = -16777216;
        this.f11466k = 0;
        this.f11467l = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, de.hdodenhof.circleimageview.a.a, i2, 0);
        this.f11466k = obtainStyledAttributes.getDimensionPixelSize(de.hdodenhof.circleimageview.a.f11470d, 0);
        this.f11465j = obtainStyledAttributes.getColor(de.hdodenhof.circleimageview.a.f11468b, -16777216);
        this.y = obtainStyledAttributes.getBoolean(de.hdodenhof.circleimageview.a.f11469c, false);
        int i3 = de.hdodenhof.circleimageview.a.f11471e;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f11467l = obtainStyledAttributes.getColor(i3, 0);
        } else {
            int i4 = de.hdodenhof.circleimageview.a.f11472f;
            if (obtainStyledAttributes.hasValue(i4)) {
                this.f11467l = obtainStyledAttributes.getColor(i4, 0);
            }
        }
        obtainStyledAttributes.recycle();
        e();
    }
}