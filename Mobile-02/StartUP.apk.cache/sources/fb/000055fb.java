package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* compiled from: TypeComponentPosition.kt */
/* loaded from: classes3.dex */
public enum TypeComponentPosition {
    FLEXIBLE_LOWER,
    FLEXIBLE_UPPER,
    INFLEXIBLE;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static TypeComponentPosition[] valuesCustom() {
        TypeComponentPosition[] valuesCustom = values();
        TypeComponentPosition[] typeComponentPositionArr = new TypeComponentPosition[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, typeComponentPositionArr, 0, valuesCustom.length);
        return typeComponentPositionArr;
    }
}