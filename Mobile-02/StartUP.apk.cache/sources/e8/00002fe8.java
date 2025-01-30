package com.facebook.react.views.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* compiled from: TextInlineViewPlaceholderSpan.java */
/* loaded from: classes2.dex */
public class a0 extends ReplacementSpan implements l {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f5404b;

    /* renamed from: c  reason: collision with root package name */
    private int f5405c;

    public a0(int i2, int i3, int i4) {
        this.a = i2;
        this.f5404b = i3;
        this.f5405c = i4;
    }

    public int a() {
        return this.f5405c;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.f5404b;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null) {
            int i4 = -this.f5405c;
            fontMetricsInt.ascent = i4;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i4;
            fontMetricsInt.bottom = 0;
        }
        return this.f5404b;
    }
}