package kotlin.reflect.jvm.internal.impl.load.java;

/* compiled from: AnnotationQualifierApplicabilityType.kt */
/* loaded from: classes3.dex */
public enum AnnotationQualifierApplicabilityType {
    METHOD_RETURN_TYPE("METHOD"),
    VALUE_PARAMETER("PARAMETER"),
    FIELD("FIELD"),
    TYPE_USE("TYPE_USE"),
    TYPE_PARAMETER_BOUNDS("TYPE_USE"),
    TYPE_PARAMETER("TYPE_PARAMETER");
    
    private final String javaTarget;

    AnnotationQualifierApplicabilityType(String str) {
        this.javaTarget = str;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static AnnotationQualifierApplicabilityType[] valuesCustom() {
        AnnotationQualifierApplicabilityType[] valuesCustom = values();
        AnnotationQualifierApplicabilityType[] annotationQualifierApplicabilityTypeArr = new AnnotationQualifierApplicabilityType[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, annotationQualifierApplicabilityTypeArr, 0, valuesCustom.length);
        return annotationQualifierApplicabilityTypeArr;
    }

    public final String getJavaTarget() {
        return this.javaTarget;
    }
}