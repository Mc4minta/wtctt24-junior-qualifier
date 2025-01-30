package e.g.a.f.q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

/* compiled from: MaterialResources.java */
/* loaded from: classes2.dex */
public class a {
    public static ColorStateList a(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        ColorStateList c2;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (c2 = c.a.k.a.a.c(context, resourceId)) == null) ? typedArray.getColorStateList(i2) : c2;
    }

    public static Drawable b(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable d2;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (d2 = c.a.k.a.a.d(context, resourceId)) == null) ? typedArray.getDrawable(i2) : d2;
    }
}