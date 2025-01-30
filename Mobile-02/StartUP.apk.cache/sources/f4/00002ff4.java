package com.facebook.react.views.text.frescosupport;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.TextView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.o;
import com.facebook.react.views.image.d;
import com.facebook.react.views.text.z;
import e.f.h.e.q;

/* compiled from: FrescoBasedReactTextInlineImageSpan.java */
/* loaded from: classes2.dex */
public class b extends z {
    private Drawable a;

    /* renamed from: b  reason: collision with root package name */
    private final e.f.h.c.b f5419b;

    /* renamed from: c  reason: collision with root package name */
    private final e.f.h.i.b<e.f.h.f.a> f5420c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f5421d;

    /* renamed from: e  reason: collision with root package name */
    private int f5422e;

    /* renamed from: f  reason: collision with root package name */
    private int f5423f;

    /* renamed from: g  reason: collision with root package name */
    private Uri f5424g;

    /* renamed from: h  reason: collision with root package name */
    private int f5425h;

    /* renamed from: j  reason: collision with root package name */
    private ReadableMap f5426j;

    /* renamed from: k  reason: collision with root package name */
    private String f5427k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f5428l;

    public b(Resources resources, int i2, int i3, int i4, Uri uri, ReadableMap readableMap, e.f.h.c.b bVar, Object obj, String str) {
        this.f5420c = new e.f.h.i.b<>(e.f.h.f.b.t(resources).a());
        this.f5419b = bVar;
        this.f5421d = obj;
        this.f5423f = i4;
        this.f5424g = uri == null ? Uri.EMPTY : uri;
        this.f5426j = readableMap;
        this.f5425h = (int) o.c(i3);
        this.f5422e = (int) o.c(i2);
        this.f5427k = str;
    }

    private q.b i(String str) {
        return d.c(str);
    }

    @Override // com.facebook.react.views.text.z
    public Drawable a() {
        return this.a;
    }

    @Override // com.facebook.react.views.text.z
    public int b() {
        return this.f5422e;
    }

    @Override // com.facebook.react.views.text.z
    public void c() {
        this.f5420c.k();
    }

    @Override // com.facebook.react.views.text.z
    public void d() {
        this.f5420c.l();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        if (this.a == null) {
            com.facebook.react.modules.fresco.a w = com.facebook.react.modules.fresco.a.w(ImageRequestBuilder.r(this.f5424g), this.f5426j);
            this.f5420c.h().q(i(this.f5427k));
            this.f5420c.o(this.f5419b.w().b(this.f5420c.g()).y(this.f5421d).A(w).build());
            this.f5419b.w();
            Drawable i7 = this.f5420c.i();
            this.a = i7;
            i7.setBounds(0, 0, this.f5425h, this.f5422e);
            int i8 = this.f5423f;
            if (i8 != 0) {
                this.a.setColorFilter(i8, PorterDuff.Mode.SRC_IN);
            }
            this.a.setCallback(this.f5428l);
        }
        canvas.save();
        canvas.translate(f2, ((i5 + ((int) paint.descent())) - (((int) (paint.descent() - paint.ascent())) / 2)) - ((this.a.getBounds().bottom - this.a.getBounds().top) / 2));
        this.a.draw(canvas);
        canvas.restore();
    }

    @Override // com.facebook.react.views.text.z
    public void e() {
        this.f5420c.k();
    }

    @Override // com.facebook.react.views.text.z
    public void f() {
        this.f5420c.l();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null) {
            int i4 = -this.f5422e;
            fontMetricsInt.ascent = i4;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i4;
            fontMetricsInt.bottom = 0;
        }
        return this.f5425h;
    }

    @Override // com.facebook.react.views.text.z
    public void h(TextView textView) {
        this.f5428l = textView;
    }
}