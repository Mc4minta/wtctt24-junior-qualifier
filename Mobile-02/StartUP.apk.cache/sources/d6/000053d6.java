package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ConstUtil.kt */
/* loaded from: classes3.dex */
public final class ConstUtil {
    public static final ConstUtil INSTANCE = new ConstUtil();

    private ConstUtil() {
    }

    public static final boolean canBeUsedForConstVal(KotlinType type) {
        m.g(type, "type");
        return ConstUtilKt.canBeUsedForConstVal(type);
    }
}