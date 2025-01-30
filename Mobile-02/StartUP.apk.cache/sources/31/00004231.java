package com.toshi.view.custom;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TextDrawable.kt */
/* loaded from: classes2.dex */
public final class t extends ShapeDrawable {
    public static final b a = new b(null);

    /* renamed from: b  reason: collision with root package name */
    private static final float f11208b = 0.9f;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f11209c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f11210d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11211e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11212f;

    /* renamed from: g  reason: collision with root package name */
    private final RectShape f11213g;

    /* renamed from: h  reason: collision with root package name */
    private final int f11214h;

    /* renamed from: i  reason: collision with root package name */
    private final int f11215i;

    /* renamed from: j  reason: collision with root package name */
    private final int f11216j;

    /* renamed from: k  reason: collision with root package name */
    private final float f11217k;

    /* renamed from: l  reason: collision with root package name */
    private final int f11218l;

    /* compiled from: TextDrawable.kt */
    /* loaded from: classes2.dex */
    public static final class a implements d, e, c {

        /* renamed from: l  reason: collision with root package name */
        private float f11229l;
        private String a = "";

        /* renamed from: b  reason: collision with root package name */
        private int f11219b = -7829368;

        /* renamed from: h  reason: collision with root package name */
        private int f11225h = -1;

        /* renamed from: c  reason: collision with root package name */
        private int f11220c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f11221d = -1;

        /* renamed from: e  reason: collision with root package name */
        private int f11222e = -1;

        /* renamed from: g  reason: collision with root package name */
        private RectShape f11224g = new RectShape();

        /* renamed from: f  reason: collision with root package name */
        private Typeface f11223f = Typeface.create("sans-serif-light", 0);

        /* renamed from: i  reason: collision with root package name */
        private int f11226i = -1;

        /* renamed from: j  reason: collision with root package name */
        private boolean f11227j = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f11228k = false;

        @Override // com.toshi.view.custom.t.e
        public t a(String text, int i2) {
            kotlin.jvm.internal.m.g(text, "text");
            v();
            return i(text, i2);
        }

        @Override // com.toshi.view.custom.t.d
        public e b() {
            return this;
        }

        @Override // com.toshi.view.custom.t.d
        public d c(int i2) {
            this.f11220c = i2;
            return this;
        }

        @Override // com.toshi.view.custom.t.d
        public d d(int i2) {
            this.f11221d = i2;
            return this;
        }

        @Override // com.toshi.view.custom.t.d
        public d e() {
            this.f11227j = true;
            return this;
        }

        @Override // com.toshi.view.custom.t.d
        public d f(int i2) {
            this.f11226i = i2;
            return this;
        }

        @Override // com.toshi.view.custom.t.e
        public d g() {
            return this;
        }

        @Override // com.toshi.view.custom.t.d
        public d h(int i2) {
            this.f11222e = i2;
            return this;
        }

        public t i(String text, int i2) {
            kotlin.jvm.internal.m.g(text, "text");
            this.f11219b = i2;
            this.a = text;
            return new t(this, null);
        }

        public final int j() {
            return this.f11220c;
        }

        public final int k() {
            return this.f11219b;
        }

        public final Typeface l() {
            return this.f11223f;
        }

        public final int m() {
            return this.f11226i;
        }

        public final int n() {
            return this.f11222e;
        }

        public final float o() {
            return this.f11229l;
        }

        public final RectShape p() {
            return this.f11224g;
        }

        public final String q() {
            return this.a;
        }

        public final int r() {
            return this.f11225h;
        }

        public final boolean s() {
            return this.f11228k;
        }

        public final int t() {
            return this.f11221d;
        }

        public final boolean u() {
            return this.f11227j;
        }

        public c v() {
            this.f11224g = new RectShape();
            return this;
        }
    }

    /* compiled from: TextDrawable.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            return new a();
        }
    }

    /* compiled from: TextDrawable.kt */
    /* loaded from: classes2.dex */
    public interface c {
    }

    /* compiled from: TextDrawable.kt */
    /* loaded from: classes2.dex */
    public interface d {
        e b();

        d c(int i2);

        d d(int i2);

        d e();

        d f(int i2);

        d h(int i2);
    }

    /* compiled from: TextDrawable.kt */
    /* loaded from: classes2.dex */
    public interface e {
        t a(String str, int i2);

        d g();
    }

    private t(a aVar) {
        super(aVar.p());
        String q;
        this.f11213g = aVar.p();
        this.f11214h = aVar.n();
        this.f11215i = aVar.t();
        this.f11217k = aVar.o();
        if (aVar.s()) {
            String q2 = aVar.q();
            kotlin.jvm.internal.m.e(q2);
            Objects.requireNonNull(q2, "null cannot be cast to non-null type java.lang.String");
            q = q2.toUpperCase();
            kotlin.jvm.internal.m.f(q, "(this as java.lang.String).toUpperCase()");
        } else {
            q = aVar.q();
        }
        this.f11211e = q;
        int k2 = aVar.k();
        this.f11212f = k2;
        this.f11216j = aVar.m();
        Paint paint = new Paint(1);
        this.f11209c = paint;
        paint.setColor(aVar.r());
        paint.setAntiAlias(true);
        paint.setFakeBoldText(aVar.u());
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface(aVar.l());
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStrokeWidth(aVar.j());
        int j2 = aVar.j();
        this.f11218l = j2;
        Paint paint2 = new Paint();
        this.f11210d = paint2;
        paint2.setColor(b(k2));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(j2);
        getPaint().setColor(k2);
    }

    public /* synthetic */ t(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    private final void a(Canvas canvas) {
        RectF rectF = new RectF(getBounds());
        int i2 = this.f11218l;
        rectF.inset(i2 / 2, i2 / 2);
        RectShape rectShape = this.f11213g;
        if (rectShape instanceof OvalShape) {
            canvas.drawOval(rectF, this.f11210d);
        } else if (!(rectShape instanceof RoundRectShape)) {
            canvas.drawRect(rectF, this.f11210d);
        } else {
            float f2 = this.f11217k;
            canvas.drawRoundRect(rectF, f2, f2, this.f11210d);
        }
    }

    private final int b(int i2) {
        float f2 = f11208b;
        return Color.rgb((int) (Color.red(i2) * f2), (int) (Color.green(i2) * f2), (int) (f2 * Color.blue(i2)));
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        kotlin.jvm.internal.m.g(canvas, "canvas");
        super.draw(canvas);
        Rect bounds = getBounds();
        kotlin.jvm.internal.m.f(bounds, "bounds");
        if (this.f11218l > 0) {
            a(canvas);
        }
        int save = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        int i2 = this.f11215i;
        if (i2 < 0) {
            i2 = bounds.width();
        }
        int i3 = this.f11214h;
        if (i3 < 0) {
            i3 = bounds.height();
        }
        int i4 = this.f11216j;
        if (i4 < 0) {
            i4 = Math.min(i2, i3) / 2;
        }
        this.f11209c.setTextSize(i4);
        String str = this.f11211e;
        kotlin.jvm.internal.m.e(str);
        canvas.drawText(str, i2 / 2, (i3 / 2) - ((this.f11209c.descent() + this.f11209c.ascent()) / 2), this.f11209c);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f11214h;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f11215i;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f11209c.setAlpha(i2);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f11209c.setColorFilter(colorFilter);
    }
}