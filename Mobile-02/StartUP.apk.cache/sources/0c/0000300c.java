package com.facebook.react.views.text;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;

/* compiled from: TextAttributes.java */
/* loaded from: classes2.dex */
public class y {
    private boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    private float f5467b = Float.NaN;

    /* renamed from: c  reason: collision with root package name */
    private float f5468c = Float.NaN;

    /* renamed from: d  reason: collision with root package name */
    private float f5469d = Float.NaN;

    /* renamed from: e  reason: collision with root package name */
    private float f5470e = Float.NaN;

    /* renamed from: f  reason: collision with root package name */
    private float f5471f = Float.NaN;

    /* renamed from: g  reason: collision with root package name */
    private c0 f5472g = c0.UNSET;

    public y a(y yVar) {
        y yVar2 = new y();
        yVar2.a = this.a;
        yVar2.f5467b = !Float.isNaN(yVar.f5467b) ? yVar.f5467b : this.f5467b;
        yVar2.f5468c = !Float.isNaN(yVar.f5468c) ? yVar.f5468c : this.f5468c;
        yVar2.f5469d = !Float.isNaN(yVar.f5469d) ? yVar.f5469d : this.f5469d;
        yVar2.f5470e = !Float.isNaN(yVar.f5470e) ? yVar.f5470e : this.f5470e;
        yVar2.f5471f = !Float.isNaN(yVar.f5471f) ? yVar.f5471f : this.f5471f;
        c0 c0Var = yVar.f5472g;
        if (c0Var == c0.UNSET) {
            c0Var = this.f5472g;
        }
        yVar2.f5472g = c0Var;
        return yVar2;
    }

    public boolean b() {
        return this.a;
    }

    public int c() {
        double ceil;
        float f2 = !Float.isNaN(this.f5467b) ? this.f5467b : 14.0f;
        if (this.a) {
            ceil = Math.ceil(com.facebook.react.uimanager.o.f(f2, f()));
        } else {
            ceil = Math.ceil(com.facebook.react.uimanager.o.c(f2));
        }
        return (int) ceil;
    }

    public float d() {
        float c2;
        if (Float.isNaN(this.f5469d)) {
            return Float.NaN;
        }
        if (this.a) {
            c2 = com.facebook.react.uimanager.o.f(this.f5469d, f());
        } else {
            c2 = com.facebook.react.uimanager.o.c(this.f5469d);
        }
        return c2 / c();
    }

    public float e() {
        float c2;
        if (Float.isNaN(this.f5468c)) {
            return Float.NaN;
        }
        if (this.a) {
            c2 = com.facebook.react.uimanager.o.f(this.f5468c, f());
        } else {
            c2 = com.facebook.react.uimanager.o.c(this.f5468c);
        }
        return !Float.isNaN(this.f5471f) && (this.f5471f > c2 ? 1 : (this.f5471f == c2 ? 0 : -1)) > 0 ? this.f5471f : c2;
    }

    public float f() {
        if (Float.isNaN(this.f5470e)) {
            return 0.0f;
        }
        return this.f5470e;
    }

    public float g() {
        return this.f5467b;
    }

    public float h() {
        return this.f5471f;
    }

    public float i() {
        return this.f5469d;
    }

    public float j() {
        return this.f5468c;
    }

    public float k() {
        return this.f5470e;
    }

    public c0 l() {
        return this.f5472g;
    }

    public void m(boolean z) {
        this.a = z;
    }

    public void n(float f2) {
        this.f5467b = f2;
    }

    public void o(float f2) {
        this.f5471f = f2;
    }

    public void p(float f2) {
        this.f5469d = f2;
    }

    public void q(float f2) {
        this.f5468c = f2;
    }

    public void r(float f2) {
        if (f2 != 0.0f && f2 < 1.0f) {
            throw new JSApplicationIllegalArgumentException("maxFontSizeMultiplier must be NaN, 0, or >= 1");
        }
        this.f5470e = f2;
    }

    public void s(c0 c0Var) {
        this.f5472g = c0Var;
    }

    public String toString() {
        return "TextAttributes {\n  getAllowFontScaling(): " + b() + "\n  getFontSize(): " + g() + "\n  getEffectiveFontSize(): " + c() + "\n  getHeightOfTallestInlineViewOrImage(): " + h() + "\n  getLetterSpacing(): " + i() + "\n  getEffectiveLetterSpacing(): " + d() + "\n  getLineHeight(): " + j() + "\n  getEffectiveLineHeight(): " + e() + "\n  getTextTransform(): " + l() + "\n  getMaxFontSizeMultiplier(): " + k() + "\n  getEffectiveMaxFontSizeMultiplier(): " + f() + "\n}";
    }
}