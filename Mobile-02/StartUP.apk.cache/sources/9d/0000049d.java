package c.a.k.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.i0;
import java.util.WeakHashMap;

/* compiled from: AppCompatResources.java */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class a {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0053a>> f2508b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f2509c = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatResources.java */
    /* renamed from: c.a.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0053a {
        final ColorStateList a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f2510b;

        C0053a(ColorStateList colorStateList, Configuration configuration) {
            this.a = colorStateList;
            this.f2510b = configuration;
        }
    }

    private static void a(Context context, int i2, ColorStateList colorStateList) {
        synchronized (f2509c) {
            WeakHashMap<Context, SparseArray<C0053a>> weakHashMap = f2508b;
            SparseArray<C0053a> sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i2, new C0053a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static ColorStateList b(Context context, int i2) {
        C0053a c0053a;
        synchronized (f2509c) {
            SparseArray<C0053a> sparseArray = f2508b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0053a = sparseArray.get(i2)) != null) {
                if (c0053a.f2510b.equals(context.getResources().getConfiguration())) {
                    return c0053a.a;
                }
                sparseArray.remove(i2);
            }
            return null;
        }
    }

    public static ColorStateList c(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            return b2;
        }
        ColorStateList f2 = f(context, i2);
        if (f2 != null) {
            a(context, i2, f2);
            return f2;
        }
        return androidx.core.content.a.e(context, i2);
    }

    public static Drawable d(Context context, int i2) {
        return i0.h().j(context, i2);
    }

    private static TypedValue e() {
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    private static ColorStateList f(Context context, int i2) {
        if (g(context, i2)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return androidx.core.content.d.a.a(resources, resources.getXml(i2), context.getTheme());
        } catch (Exception e2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean g(Context context, int i2) {
        Resources resources = context.getResources();
        TypedValue e2 = e();
        resources.getValue(i2, e2, true);
        int i3 = e2.type;
        return i3 >= 28 && i3 <= 31;
    }
}