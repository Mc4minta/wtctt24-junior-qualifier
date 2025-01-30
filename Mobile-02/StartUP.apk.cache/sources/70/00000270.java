package androidx.core.content.d;

import android.content.res.TypedArray;
import kotlin.jvm.internal.m;

/* compiled from: TypedArray.kt */
/* loaded from: classes.dex */
public final class g {
    private static final void a(TypedArray typedArray, int i2) {
        if (!typedArray.hasValue(i2)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final int b(TypedArray getResourceIdOrThrow, int i2) {
        m.g(getResourceIdOrThrow, "$this$getResourceIdOrThrow");
        a(getResourceIdOrThrow, i2);
        return getResourceIdOrThrow.getResourceId(i2, 0);
    }
}