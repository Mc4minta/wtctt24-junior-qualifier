package e.f.h.e;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableUtils.java */
/* loaded from: classes2.dex */
public class e {
    public static void a(Drawable drawable, Drawable drawable2) {
        if (drawable2 == null || drawable == null || drawable == drawable2) {
            return;
        }
        drawable.setBounds(drawable2.getBounds());
        drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
        drawable.setLevel(drawable2.getLevel());
        drawable.setVisible(drawable2.isVisible(), false);
        drawable.setState(drawable2.getState());
    }

    public static int b(int i2) {
        int i3 = i2 >>> 24;
        if (i3 == 255) {
            return -1;
        }
        return i3 == 0 ? -2 : -3;
    }

    public static int c(int i2, int i3) {
        if (i3 == 255) {
            return i2;
        }
        if (i3 == 0) {
            return i2 & 16777215;
        }
        return (i2 & 16777215) | ((((i2 >>> 24) * (i3 + (i3 >> 7))) >> 8) << 24);
    }

    public static void d(Drawable drawable, Drawable.Callback callback, s sVar) {
        if (drawable != null) {
            drawable.setCallback(callback);
            if (drawable instanceof r) {
                ((r) drawable).b(sVar);
            }
        }
    }

    public static void e(Drawable drawable, d dVar) {
        if (drawable == null || dVar == null) {
            return;
        }
        dVar.a(drawable);
    }
}