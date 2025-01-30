package kotlin.reflect.jvm.internal.impl.load.java.structure;

/* compiled from: javaElements.kt */
/* loaded from: classes3.dex */
public enum LightClassOriginKind {
    SOURCE,
    BINARY;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static LightClassOriginKind[] valuesCustom() {
        LightClassOriginKind[] valuesCustom = values();
        LightClassOriginKind[] lightClassOriginKindArr = new LightClassOriginKind[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, lightClassOriginKindArr, 0, valuesCustom.length);
        return lightClassOriginKindArr;
    }
}