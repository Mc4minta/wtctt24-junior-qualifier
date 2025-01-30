package kotlin.reflect.jvm.internal.impl.descriptors;

/* compiled from: ConstUtil.kt */
/* loaded from: classes3.dex */
public final class ConstUtilKt {
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes.isUnsignedType(r1) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(r1) != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r1) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean canBeUsedForConstVal(kotlin.reflect.jvm.internal.impl.types.KotlinType r1) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.m.g(r1, r0)
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveType(r1)
            if (r0 != 0) goto L13
            kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes r0 = kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes.INSTANCE
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes.isUnsignedType(r1)
            if (r0 == 0) goto L19
        L13:
            boolean r0 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(r1)
            if (r0 == 0) goto L22
        L19:
            boolean r1 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r1)
            if (r1 == 0) goto L20
            goto L22
        L20:
            r1 = 0
            goto L23
        L22:
            r1 = 1
        L23:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.ConstUtilKt.canBeUsedForConstVal(kotlin.reflect.jvm.internal.impl.types.KotlinType):boolean");
    }
}