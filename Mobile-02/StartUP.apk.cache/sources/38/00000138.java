package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* compiled from: ThemeUtils.java */
/* loaded from: classes.dex */
public class n0 {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f860b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f861c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f862d = {16843518};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f863e = {16842919};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f864f = {16842912};

    /* renamed from: g  reason: collision with root package name */
    static final int[] f865g = {16842913};

    /* renamed from: h  reason: collision with root package name */
    static final int[] f866h = {-16842919, -16842908};

    /* renamed from: i  reason: collision with root package name */
    static final int[] f867i = new int[0];

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f868j = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c.a.j.z0);
        try {
            if (!obtainStyledAttributes.hasValue(c.a.j.E0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i2) {
        ColorStateList e2 = e(context, i2);
        if (e2 != null && e2.isStateful()) {
            return e2.getColorForState(f860b, e2.getDefaultColor());
        }
        TypedValue f2 = f();
        context.getTheme().resolveAttribute(16842803, f2, true);
        return d(context, i2, f2.getFloat());
    }

    public static int c(Context context, int i2) {
        int[] iArr = f868j;
        iArr[0] = i2;
        s0 u = s0.u(context, null, iArr);
        try {
            return u.b(0, 0);
        } finally {
            u.w();
        }
    }

    static int d(Context context, int i2, float f2) {
        int c2 = c(context, i2);
        return c.h.e.a.h(c2, Math.round(Color.alpha(c2) * f2));
    }

    public static ColorStateList e(Context context, int i2) {
        int[] iArr = f868j;
        iArr[0] = i2;
        s0 u = s0.u(context, null, iArr);
        try {
            return u.c(0);
        } finally {
            u.w();
        }
    }

    private static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }
}