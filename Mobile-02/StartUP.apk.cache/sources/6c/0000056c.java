package c.h.j;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: TextUtilsCompat.java */
/* loaded from: classes.dex */
public final class e {
    private static final Locale a = new Locale("", "");

    private static int a(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    public static int b(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(a)) {
            return 0;
        }
        String c2 = a.c(locale);
        if (c2 == null) {
            return a(locale);
        }
        return (c2.equalsIgnoreCase("Arab") || c2.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }
}