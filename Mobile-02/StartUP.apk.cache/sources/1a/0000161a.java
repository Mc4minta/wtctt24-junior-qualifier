package com.coinbase.wallet.consumer.extensions;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Context+Consumer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/content/Context;", "", "attrResId", "Landroid/graphics/drawable/Drawable;", "getAttrDrawable", "(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;", "consumer_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Context_ConsumerKt {
    public static final Drawable getAttrDrawable(Context context, int i2) {
        m.g(context, "<this>");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i2});
        m.f(obtainStyledAttributes, "obtainStyledAttributes(attrs)");
        if (obtainStyledAttributes.hasValue(0)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }
        obtainStyledAttributes.recycle();
        throw new Resources.NotFoundException("unable to find resId (" + i2 + "): " + ((Object) context.getResources().getResourceEntryName(i2)));
    }
}