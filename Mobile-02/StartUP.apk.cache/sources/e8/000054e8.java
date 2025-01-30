package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.e0.c.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnnotationTypeQualifierResolver.kt */
/* loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver$mapKotlinConstantToQualifierApplicabilityTypes$1 extends o implements p<EnumValue, AnnotationQualifierApplicabilityType, Boolean> {
    final /* synthetic */ AnnotationTypeQualifierResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationTypeQualifierResolver$mapKotlinConstantToQualifierApplicabilityTypes$1(AnnotationTypeQualifierResolver annotationTypeQualifierResolver) {
        super(2);
        this.this$0 = annotationTypeQualifierResolver;
    }

    @Override // kotlin.e0.c.p
    public /* bridge */ /* synthetic */ Boolean invoke(EnumValue enumValue, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return Boolean.valueOf(invoke2(enumValue, annotationQualifierApplicabilityType));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(EnumValue enumValue, AnnotationQualifierApplicabilityType it) {
        List kotlinTargetNames;
        m.g(enumValue, "<this>");
        m.g(it, "it");
        kotlinTargetNames = this.this$0.toKotlinTargetNames(it.getJavaTarget());
        return kotlinTargetNames.contains(enumValue.getEnumEntryName().getIdentifier());
    }
}