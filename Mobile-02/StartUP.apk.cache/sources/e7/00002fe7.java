package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: CustomLetterSpacingSpan.java */
@TargetApi(21)
/* loaded from: classes2.dex */
public class a extends MetricAffectingSpan implements l {
    private final float a;

    public a(float f2) {
        this.a = f2;
    }

    private void a(TextPaint textPaint) {
        if (Float.isNaN(this.a)) {
            return;
        }
        textPaint.setLetterSpacing(this.a);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}