package com.facebook.react.views.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.TypedValue;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.uimanager.o;

/* compiled from: ReactDrawableHelper.java */
/* loaded from: classes2.dex */
public class c {
    private static final TypedValue a = new TypedValue();

    @TargetApi(21)
    public static Drawable a(Context context, ReadableMap readableMap) {
        String string = readableMap.getString("type");
        if ("ThemeAttrAndroid".equals(string)) {
            String string2 = readableMap.getString("attribute");
            SoftAssertions.assertNotNull(string2);
            int identifier = context.getResources().getIdentifier(string2, "attr", "android");
            if (identifier != 0) {
                if (context.getTheme().resolveAttribute(identifier, a, true)) {
                    return f(readableMap, c(context));
                }
                throw new JSApplicationIllegalArgumentException("Attribute " + string2 + " couldn't be resolved into a drawable");
            }
            throw new JSApplicationIllegalArgumentException("Attribute " + string2 + " couldn't be found in the resource list");
        } else if ("RippleAndroid".equals(string)) {
            return f(readableMap, e(context, readableMap));
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid type for android drawable: " + string);
        }
    }

    private static int b(Context context, ReadableMap readableMap) {
        if (readableMap.hasKey("color") && !readableMap.isNull("color")) {
            return readableMap.getInt("color");
        }
        Resources.Theme theme = context.getTheme();
        TypedValue typedValue = a;
        if (theme.resolveAttribute(16843820, typedValue, true)) {
            return context.getResources().getColor(typedValue.resourceId);
        }
        throw new JSApplicationIllegalArgumentException("Attribute colorControlHighlight couldn't be resolved into a drawable");
    }

    private static Drawable c(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getResources().getDrawable(a.resourceId, context.getTheme());
        }
        return context.getResources().getDrawable(a.resourceId);
    }

    private static Drawable d(ReadableMap readableMap) {
        if (readableMap.hasKey("borderless") && !readableMap.isNull("borderless") && readableMap.getBoolean("borderless")) {
            return null;
        }
        return new ColorDrawable(-1);
    }

    private static RippleDrawable e(Context context, ReadableMap readableMap) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{b(context, readableMap)}), null, d(readableMap));
        }
        throw new JSApplicationIllegalArgumentException("Ripple drawable is not available on android API <21");
    }

    private static Drawable f(ReadableMap readableMap, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 && readableMap.hasKey("rippleRadius") && (drawable instanceof RippleDrawable)) {
            ((RippleDrawable) drawable).setRadius((int) o.b(readableMap.getDouble("rippleRadius")));
        }
        return drawable;
    }
}