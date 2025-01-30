package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

/* compiled from: JavaTypeResolver.kt */
/* loaded from: classes3.dex */
public enum JavaTypeFlexibility {
    INFLEXIBLE,
    FLEXIBLE_UPPER_BOUND,
    FLEXIBLE_LOWER_BOUND;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static JavaTypeFlexibility[] valuesCustom() {
        JavaTypeFlexibility[] valuesCustom = values();
        JavaTypeFlexibility[] javaTypeFlexibilityArr = new JavaTypeFlexibility[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, javaTypeFlexibilityArr, 0, valuesCustom.length);
        return javaTypeFlexibilityArr;
    }
}