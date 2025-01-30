package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.d.f;
import c.a.k.a.a;
import c.a.o.d;

/* loaded from: classes.dex */
public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context context, Context context2, int i2) {
        return getDrawable(context, context2, i2, null);
    }

    private static Drawable loadDrawableV4(Context context, int i2, Resources.Theme theme) {
        return f.b(context.getResources(), i2, theme);
    }

    private static Drawable loadDrawableV7(Context context, int i2, Resources.Theme theme) {
        if (theme != null) {
            context = new d(context, theme);
        }
        return a.d(context, i2);
    }

    public static Drawable getDrawable(Context context, int i2, Resources.Theme theme) {
        return getDrawable(context, context, i2, theme);
    }

    private static Drawable getDrawable(Context context, Context context2, int i2, Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context2, i2, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e2) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return androidx.core.content.a.f(context2, i2);
            }
            throw e2;
        } catch (NoClassDefFoundError unused2) {
            shouldCallAppCompatResources = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return loadDrawableV4(context2, i2, theme);
    }
}