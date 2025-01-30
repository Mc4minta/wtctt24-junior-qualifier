package kotlin.reflect.jvm.internal.impl.types.model;

/* compiled from: TypeSystemContext.kt */
/* loaded from: classes3.dex */
public enum TypeVariance {
    IN("in"),
    OUT("out"),
    INV("");
    
    private final String presentation;

    TypeVariance(String str) {
        this.presentation = str;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static TypeVariance[] valuesCustom() {
        TypeVariance[] valuesCustom = values();
        TypeVariance[] typeVarianceArr = new TypeVariance[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, typeVarianceArr, 0, valuesCustom.length);
        return typeVarianceArr;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.presentation;
    }
}