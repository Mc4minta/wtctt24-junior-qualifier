package com.facebook.react.views.text;

import android.os.Build;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: TextAttributeProps.java */
/* loaded from: classes2.dex */
public class x {
    private static final int a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f5456b;
    private final com.facebook.react.uimanager.a0 C;

    /* renamed from: f  reason: collision with root package name */
    protected int f5460f;

    /* renamed from: h  reason: collision with root package name */
    protected int f5462h;

    /* renamed from: c  reason: collision with root package name */
    protected float f5457c = Float.NaN;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f5458d = false;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f5459e = true;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f5461g = false;

    /* renamed from: i  reason: collision with root package name */
    protected int f5463i = -1;

    /* renamed from: j  reason: collision with root package name */
    protected int f5464j = -1;

    /* renamed from: k  reason: collision with root package name */
    protected float f5465k = -1.0f;

    /* renamed from: l  reason: collision with root package name */
    protected float f5466l = -1.0f;
    protected float m = Float.NaN;
    protected int n = 0;
    protected c0 o = c0.UNSET;
    protected float p = 0.0f;
    protected float q = 0.0f;
    protected float r = 1.0f;
    protected int s = 1426063360;
    protected boolean t = false;
    protected boolean u = false;
    protected boolean v = true;
    protected int w = -1;
    protected int x = -1;
    protected String y = null;
    protected String z = null;
    protected boolean A = false;
    protected float B = Float.NaN;

    static {
        int i2 = Build.VERSION.SDK_INT;
        a = 0;
        f5456b = i2 >= 23 ? 1 : 0;
    }

    public x(com.facebook.react.uimanager.a0 a0Var) {
        this.C = a0Var;
        w(e("numberOfLines", -1));
        v(d("lineHeight", -1.0f));
        u(d("letterSpacing", Float.NaN));
        l(b("allowFontScaling", true));
        p(d("fontSize", -1.0f));
        n(a0Var.g("color") ? Integer.valueOf(a0Var.d("color", 0)) : null);
        n(a0Var.g("foregroundColor") ? Integer.valueOf(a0Var.d("foregroundColor", 0)) : null);
        m(a0Var.g("backgroundColor") ? Integer.valueOf(a0Var.d("backgroundColor", 0)) : null);
        o(h("fontFamily"));
        s(h("fontWeight"));
        q(h("fontStyle"));
        r(a("fontVariant"));
        t(b("includeFontPadding", true));
        x(h("textDecorationLine"));
        z(a0Var.g("textShadowOffset") ? a0Var.e("textShadowOffset") : null);
        A(e("textShadowRadius", 1));
        y(e("textShadowColor", 1426063360));
        B(h("textTransform"));
    }

    private ReadableArray a(String str) {
        if (this.C.g(str)) {
            return this.C.a(str);
        }
        return null;
    }

    private boolean b(String str, boolean z) {
        return this.C.g(str) ? this.C.b(str, z) : z;
    }

    private float d(String str, float f2) {
        return this.C.g(str) ? this.C.c(str, f2) : f2;
    }

    private int e(String str, int i2) {
        return this.C.g(str) ? this.C.d(str, i2) : i2;
    }

    public static int f(com.facebook.react.uimanager.a0 a0Var) {
        if (!"justify".equals(a0Var.g("textAlign") ? a0Var.f("textAlign") : null) || Build.VERSION.SDK_INT < 26) {
            return a;
        }
        return 1;
    }

    private String h(String str) {
        if (this.C.g(str)) {
            return this.C.f(str);
        }
        return null;
    }

    public static int i(com.facebook.react.uimanager.a0 a0Var) {
        String f2 = a0Var.g("textAlign") ? a0Var.f("textAlign") : null;
        if ("justify".equals(f2)) {
            return 3;
        }
        if (f2 == null || "auto".equals(f2)) {
            return 0;
        }
        if ("left".equals(f2)) {
            return 3;
        }
        if ("right".equals(f2)) {
            return 5;
        }
        if ("center".equals(f2)) {
            return 1;
        }
        throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + f2);
    }

    public static int j(String str) {
        int i2 = f5456b;
        if (str != null) {
            if (str.equals("balanced")) {
                return 2;
            }
            return !str.equals("simple") ? 1 : 0;
        }
        return i2;
    }

    private static int k(String str) {
        if (str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') {
            return -1;
        }
        return (str.charAt(0) - '0') * 100;
    }

    public void A(float f2) {
        if (f2 != this.r) {
            this.r = f2;
        }
    }

    public void B(String str) {
        if (str != null && !"none".equals(str)) {
            if ("uppercase".equals(str)) {
                this.o = c0.UPPERCASE;
                return;
            } else if ("lowercase".equals(str)) {
                this.o = c0.LOWERCASE;
                return;
            } else if ("capitalize".equals(str)) {
                this.o = c0.CAPITALIZE;
                return;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid textTransform: " + str);
            }
        }
        this.o = c0.NONE;
    }

    public float c() {
        return !Float.isNaN(this.f5457c) && !Float.isNaN(this.B) && (this.B > this.f5457c ? 1 : (this.B == this.f5457c ? 0 : -1)) > 0 ? this.B : this.f5457c;
    }

    public float g() {
        float c2;
        if (this.f5459e) {
            c2 = com.facebook.react.uimanager.o.e(this.m);
        } else {
            c2 = com.facebook.react.uimanager.o.c(this.m);
        }
        int i2 = this.f5464j;
        if (i2 > 0) {
            return c2 / i2;
        }
        throw new IllegalArgumentException("FontSize should be a positive value. Current value: " + this.f5464j);
    }

    public void l(boolean z) {
        if (z != this.f5459e) {
            this.f5459e = z;
            p(this.f5465k);
            v(this.f5466l);
            u(this.m);
        }
    }

    public void m(Integer num) {
        boolean z = num != null;
        this.f5461g = z;
        if (z) {
            this.f5462h = num.intValue();
        }
    }

    public void n(Integer num) {
        boolean z = num != null;
        this.f5458d = z;
        if (z) {
            this.f5460f = num.intValue();
        }
    }

    public void o(String str) {
        this.y = str;
    }

    public void p(float f2) {
        double ceil;
        this.f5465k = f2;
        if (f2 != -1.0f) {
            if (this.f5459e) {
                ceil = Math.ceil(com.facebook.react.uimanager.o.e(f2));
            } else {
                ceil = Math.ceil(com.facebook.react.uimanager.o.c(f2));
            }
            f2 = (float) ceil;
        }
        this.f5464j = (int) f2;
    }

    public void q(String str) {
        int i2;
        if ("italic".equals(str)) {
            i2 = 2;
        } else {
            i2 = "normal".equals(str) ? 0 : -1;
        }
        if (i2 != this.w) {
            this.w = i2;
        }
    }

    public void r(ReadableArray readableArray) {
        this.z = t.c(readableArray);
    }

    public void s(String str) {
        int i2 = -1;
        int k2 = str != null ? k(str) : -1;
        if (k2 >= 500 || "bold".equals(str)) {
            i2 = 1;
        } else if ("normal".equals(str) || (k2 != -1 && k2 < 500)) {
            i2 = 0;
        }
        if (i2 != this.x) {
            this.x = i2;
        }
    }

    public void t(boolean z) {
        this.v = z;
    }

    public void u(float f2) {
        this.m = f2;
    }

    public void v(float f2) {
        float c2;
        this.f5466l = f2;
        if (f2 == -1.0f) {
            this.f5457c = Float.NaN;
            return;
        }
        if (this.f5459e) {
            c2 = com.facebook.react.uimanager.o.e(f2);
        } else {
            c2 = com.facebook.react.uimanager.o.c(f2);
        }
        this.f5457c = c2;
    }

    public void w(int i2) {
        if (i2 == 0) {
            i2 = -1;
        }
        this.f5463i = i2;
    }

    public void x(String str) {
        String[] split;
        this.t = false;
        this.u = false;
        if (str != null) {
            for (String str2 : str.split("-")) {
                if ("underline".equals(str2)) {
                    this.t = true;
                } else if ("strikethrough".equals(str2)) {
                    this.u = true;
                }
            }
        }
    }

    public void y(int i2) {
        if (i2 != this.s) {
            this.s = i2;
        }
    }

    public void z(ReadableMap readableMap) {
        this.p = 0.0f;
        this.q = 0.0f;
        if (readableMap != null) {
            if (readableMap.hasKey("width") && !readableMap.isNull("width")) {
                this.p = com.facebook.react.uimanager.o.b(readableMap.getDouble("width"));
            }
            if (!readableMap.hasKey("height") || readableMap.isNull("height")) {
                return;
            }
            this.q = com.facebook.react.uimanager.o.b(readableMap.getDouble("height"));
        }
    }
}