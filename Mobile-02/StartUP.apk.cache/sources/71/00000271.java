package androidx.core.content.d;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: TypedArrayUtils.java */
/* loaded from: classes.dex */
public class h {
    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, boolean z) {
        return !j(xmlPullParser, str) ? z : typedArray.getBoolean(i2, z);
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
        return !j(xmlPullParser, str) ? i3 : typedArray.getColor(i2, i3);
    }

    public static ColorStateList c(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i2) {
        if (j(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            int i3 = typedValue.type;
            if (i3 != 2) {
                if (i3 >= 28 && i3 <= 31) {
                    return d(typedValue);
                }
                return a.c(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            }
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i2 + ": " + typedValue);
        }
        return null;
    }

    private static ColorStateList d(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static b e(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i2, int i3) {
        if (j(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            int i4 = typedValue.type;
            if (i4 >= 28 && i4 <= 31) {
                return b.b(typedValue.data);
            }
            b g2 = b.g(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            if (g2 != null) {
                return g2;
            }
        }
        return b.b(i3);
    }

    public static float f(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, float f2) {
        return !j(xmlPullParser, str) ? f2 : typedArray.getFloat(i2, f2);
    }

    public static int g(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
        return !j(xmlPullParser, str) ? i3 : typedArray.getInt(i2, i3);
    }

    public static int h(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
        return !j(xmlPullParser, str) ? i3 : typedArray.getResourceId(i2, i3);
    }

    public static String i(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (j(xmlPullParser, str)) {
            return typedArray.getString(i2);
        }
        return null;
    }

    public static boolean j(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray k(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static TypedValue l(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (j(xmlPullParser, str)) {
            return typedArray.peekValue(i2);
        }
        return null;
    }
}