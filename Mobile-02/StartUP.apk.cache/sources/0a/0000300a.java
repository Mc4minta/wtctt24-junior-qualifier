package com.facebook.react.views.text;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* compiled from: ShadowStyleSpan.java */
/* loaded from: classes2.dex */
public class w extends CharacterStyle implements l {
    private final float a;

    /* renamed from: b  reason: collision with root package name */
    private final float f5453b;

    /* renamed from: c  reason: collision with root package name */
    private final float f5454c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5455d;

    public w(float f2, float f3, float f4, int i2) {
        this.a = f2;
        this.f5453b = f3;
        this.f5454c = f4;
        this.f5455d = i2;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(this.f5454c, this.a, this.f5453b, this.f5455d);
    }
}