package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.e0.c.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;

/* compiled from: AnnotationTypeQualifierResolver.kt */
/* loaded from: classes3.dex */
final class AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1 extends o implements p<EnumValue, AnnotationQualifierApplicabilityType, Boolean> {
    public static final AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1 INSTANCE = new AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1();

    AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1() {
        super(2);
    }

    @Override // kotlin.e0.c.p
    public /* bridge */ /* synthetic */ Boolean invoke(EnumValue enumValue, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return Boolean.valueOf(invoke2(enumValue, annotationQualifierApplicabilityType));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(EnumValue enumValue, AnnotationQualifierApplicabilityType it) {
        m.g(enumValue, "<this>");
        m.g(it, "it");
        return m.c(enumValue.getEnumEntryName().getIdentifier(), it.getJavaTarget());
    }
}