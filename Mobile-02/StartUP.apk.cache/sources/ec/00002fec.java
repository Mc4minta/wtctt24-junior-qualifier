package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: CustomStyleSpan.java */
/* loaded from: classes2.dex */
public class c extends MetricAffectingSpan implements l {
    private final AssetManager a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5410b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5411c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5412d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5413e;

    public c(int i2, int i3, String str, String str2, AssetManager assetManager) {
        this.f5410b = i2;
        this.f5411c = i3;
        this.f5412d = str;
        this.f5413e = str2;
        this.a = assetManager;
    }

    private static void a(Paint paint, int i2, int i3, String str, String str2, AssetManager assetManager) {
        Typeface a = t.a(paint.getTypeface(), i2, i3, str2, assetManager);
        if (Build.VERSION.SDK_INT >= 21) {
            paint.setFontFeatureSettings(str);
        }
        paint.setTypeface(a);
        paint.setSubpixelText(true);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint, this.f5410b, this.f5411c, this.f5412d, this.f5413e, this.a);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint, this.f5410b, this.f5411c, this.f5412d, this.f5413e, this.a);
    }
}