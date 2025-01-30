package com.facebook.react.uimanager;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.react.bridge.WritableNativeMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DisplayMetricsHolder.java */
/* loaded from: classes2.dex */
public class c {
    private static DisplayMetrics a;

    /* renamed from: b  reason: collision with root package name */
    private static DisplayMetrics f5048b;

    public static Map<String, Map<String, Object>> a(double d2) {
        e.f.k.a.a.d(Boolean.valueOf((a == null && f5048b == null) ? false : true), "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
        HashMap hashMap = new HashMap();
        hashMap.put("windowPhysicalPixels", c(a, d2));
        hashMap.put("screenPhysicalPixels", c(f5048b, d2));
        return hashMap;
    }

    public static WritableNativeMap b(double d2) {
        e.f.k.a.a.d(Boolean.valueOf((a == null && f5048b == null) ? false : true), "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putMap("windowPhysicalPixels", d(a, d2));
        writableNativeMap.putMap("screenPhysicalPixels", d(f5048b, d2));
        return writableNativeMap;
    }

    private static Map<String, Object> c(DisplayMetrics displayMetrics, double d2) {
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(displayMetrics.widthPixels));
        hashMap.put("height", Integer.valueOf(displayMetrics.heightPixels));
        hashMap.put("scale", Float.valueOf(displayMetrics.density));
        hashMap.put("fontScale", Double.valueOf(d2));
        hashMap.put("densityDpi", Integer.valueOf(displayMetrics.densityDpi));
        return hashMap;
    }

    private static WritableNativeMap d(DisplayMetrics displayMetrics, double d2) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("width", displayMetrics.widthPixels);
        writableNativeMap.putInt("height", displayMetrics.heightPixels);
        writableNativeMap.putDouble("scale", displayMetrics.density);
        writableNativeMap.putDouble("fontScale", d2);
        writableNativeMap.putDouble("densityDpi", displayMetrics.densityDpi);
        return writableNativeMap;
    }

    public static DisplayMetrics e() {
        return f5048b;
    }

    @Deprecated
    public static DisplayMetrics f() {
        return a;
    }

    public static void g(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        j(displayMetrics);
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        e.f.k.a.a.d(windowManager, "WindowManager is null!");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics2);
        } else {
            try {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                displayMetrics2.widthPixels = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                displayMetrics2.heightPixels = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                throw new RuntimeException("Error getting real dimensions for API level < 17", e2);
            }
        }
        i(displayMetrics2);
    }

    public static void h(Context context) {
        if (e() != null) {
            return;
        }
        g(context);
    }

    public static void i(DisplayMetrics displayMetrics) {
        f5048b = displayMetrics;
    }

    public static void j(DisplayMetrics displayMetrics) {
        a = displayMetrics;
    }
}