package c.h.j;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompat.java */
/* loaded from: classes.dex */
public final class a {
    private static Method a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f2979b;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            if (i2 < 24) {
                try {
                    f2979b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e2) {
                    throw new IllegalStateException(e2);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            a = cls.getMethod("getScript", String.class);
            f2979b = cls.getMethod("addLikelySubtags", String.class);
        } catch (Exception e3) {
            a = null;
            f2979b = null;
            Log.w("ICUCompat", e3);
        }
    }

    private static String a(Locale locale) {
        String locale2 = locale.toString();
        try {
            Method method = f2979b;
            if (method != null) {
                return (String) method.invoke(null, locale2);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return locale2;
    }

    private static String b(String str) {
        try {
            Method method = a;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return null;
    }

    public static String c(Locale locale) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (i2 >= 21) {
            try {
                return ((Locale) f2979b.invoke(null, locale)).getScript();
            } catch (IllegalAccessException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            } catch (InvocationTargetException e3) {
                Log.w("ICUCompat", e3);
                return locale.getScript();
            }
        }
        String a2 = a(locale);
        if (a2 != null) {
            return b(a2);
        }
        return null;
    }
}