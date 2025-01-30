package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* compiled from: typeQualifiers.kt */
/* loaded from: classes3.dex */
public enum NullabilityQualifier {
    NULLABLE,
    NOT_NULL,
    FORCE_FLEXIBILITY;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static NullabilityQualifier[] valuesCustom() {
        NullabilityQualifier[] valuesCustom = values();
        NullabilityQualifier[] nullabilityQualifierArr = new NullabilityQualifier[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, nullabilityQualifierArr, 0, valuesCustom.length);
        return nullabilityQualifierArr;
    }
}