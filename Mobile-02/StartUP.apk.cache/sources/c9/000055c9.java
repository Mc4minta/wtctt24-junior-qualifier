package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* compiled from: typeQualifiers.kt */
/* loaded from: classes3.dex */
public enum MutabilityQualifier {
    READ_ONLY,
    MUTABLE;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static MutabilityQualifier[] valuesCustom() {
        MutabilityQualifier[] valuesCustom = values();
        MutabilityQualifier[] mutabilityQualifierArr = new MutabilityQualifier[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, mutabilityQualifierArr, 0, valuesCustom.length);
        return mutabilityQualifierArr;
    }
}