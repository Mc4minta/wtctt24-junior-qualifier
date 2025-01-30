package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.w;
import kotlin.e0.c.p;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;

/* compiled from: AnnotationTypeQualifierResolver.kt */
/* loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver {
    private final JavaTypeEnhancementState javaTypeEnhancementState;
    private final MemoizedFunctionToNullable<ClassDescriptor, AnnotationDescriptor> resolvedNicknames;

    /* compiled from: AnnotationTypeQualifierResolver.kt */
    /* loaded from: classes3.dex */
    public static final class TypeQualifierWithApplicability {
        private final int applicability;
        private final AnnotationDescriptor typeQualifier;

        public TypeQualifierWithApplicability(AnnotationDescriptor typeQualifier, int i2) {
            m.g(typeQualifier, "typeQualifier");
            this.typeQualifier = typeQualifier;
            this.applicability = i2;
        }

        private final boolean isApplicableConsideringMask(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
            return ((1 << annotationQualifierApplicabilityType.ordinal()) & this.applicability) != 0;
        }

        private final boolean isApplicableTo(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
            if (isApplicableConsideringMask(annotationQualifierApplicabilityType)) {
                return true;
            }
            return isApplicableConsideringMask(AnnotationQualifierApplicabilityType.TYPE_USE) && annotationQualifierApplicabilityType != AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
        }

        public final AnnotationDescriptor component1() {
            return this.typeQualifier;
        }

        public final List<AnnotationQualifierApplicabilityType> component2() {
            AnnotationQualifierApplicabilityType[] valuesCustom = AnnotationQualifierApplicabilityType.valuesCustom();
            ArrayList arrayList = new ArrayList();
            for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : valuesCustom) {
                if (isApplicableTo(annotationQualifierApplicabilityType)) {
                    arrayList.add(annotationQualifierApplicabilityType);
                }
            }
            return arrayList;
        }
    }

    public AnnotationTypeQualifierResolver(StorageManager storageManager, JavaTypeEnhancementState javaTypeEnhancementState) {
        m.g(storageManager, "storageManager");
        m.g(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.javaTypeEnhancementState = javaTypeEnhancementState;
        this.resolvedNicknames = storageManager.createMemoizedFunctionWithNullableValues(new AnnotationTypeQualifierResolver$resolvedNicknames$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnnotationDescriptor computeTypeQualifierNickname(ClassDescriptor classDescriptor) {
        if (classDescriptor.getAnnotations().hasAnnotation(AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_NICKNAME_FQNAME())) {
            for (AnnotationDescriptor annotationDescriptor : classDescriptor.getAnnotations()) {
                AnnotationDescriptor resolveTypeQualifierAnnotation = resolveTypeQualifierAnnotation(annotationDescriptor);
                if (resolveTypeQualifierAnnotation != null) {
                    return resolveTypeQualifierAnnotation;
                }
            }
            return null;
        }
        return null;
    }

    private final List<AnnotationQualifierApplicabilityType> mapConstantToQualifierApplicabilityTypes(ConstantValue<?> constantValue, p<? super EnumValue, ? super AnnotationQualifierApplicabilityType, Boolean> pVar) {
        List<AnnotationQualifierApplicabilityType> g2;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
        List<AnnotationQualifierApplicabilityType> k2;
        if (constantValue instanceof ArrayValue) {
            ArrayList arrayList = new ArrayList();
            for (ConstantValue<?> constantValue2 : ((ArrayValue) constantValue).getValue()) {
                w.y(arrayList, mapConstantToQualifierApplicabilityTypes(constantValue2, pVar));
            }
            return arrayList;
        } else if (!(constantValue instanceof EnumValue)) {
            g2 = r.g();
            return g2;
        } else {
            AnnotationQualifierApplicabilityType[] valuesCustom = AnnotationQualifierApplicabilityType.valuesCustom();
            int length = valuesCustom.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    annotationQualifierApplicabilityType = null;
                    break;
                }
                annotationQualifierApplicabilityType = valuesCustom[i2];
                if (pVar.invoke(constantValue, annotationQualifierApplicabilityType).booleanValue()) {
                    break;
                }
                i2++;
            }
            k2 = r.k(annotationQualifierApplicabilityType);
            return k2;
        }
    }

    private final List<AnnotationQualifierApplicabilityType> mapJavaConstantToQualifierApplicabilityTypes(ConstantValue<?> constantValue) {
        return mapConstantToQualifierApplicabilityTypes(constantValue, AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1.INSTANCE);
    }

    private final List<AnnotationQualifierApplicabilityType> mapKotlinConstantToQualifierApplicabilityTypes(ConstantValue<?> constantValue) {
        return mapConstantToQualifierApplicabilityTypes(constantValue, new AnnotationTypeQualifierResolver$mapKotlinConstantToQualifierApplicabilityTypes$1(this));
    }

    private final ReportLevel migrationAnnotationStatus(ClassDescriptor classDescriptor) {
        AnnotationDescriptor mo2207findAnnotation = classDescriptor.getAnnotations().mo2207findAnnotation(AnnotationQualifiersFqNamesKt.getMIGRATION_ANNOTATION_FQNAME());
        ConstantValue<?> firstArgument = mo2207findAnnotation == null ? null : DescriptorUtilsKt.firstArgument(mo2207findAnnotation);
        EnumValue enumValue = firstArgument instanceof EnumValue ? (EnumValue) firstArgument : null;
        if (enumValue == null) {
            return null;
        }
        ReportLevel migrationLevelForJsr305 = this.javaTypeEnhancementState.getMigrationLevelForJsr305();
        if (migrationLevelForJsr305 == null) {
            String asString = enumValue.getEnumEntryName().asString();
            int hashCode = asString.hashCode();
            if (hashCode == -2137067054) {
                if (asString.equals("IGNORE")) {
                    return ReportLevel.IGNORE;
                }
                return null;
            } else if (hashCode == -1838656823) {
                if (asString.equals("STRICT")) {
                    return ReportLevel.STRICT;
                }
                return null;
            } else if (hashCode == 2656902 && asString.equals("WARN")) {
                return ReportLevel.WARN;
            } else {
                return null;
            }
        }
        return migrationLevelForJsr305;
    }

    private final ReportLevel resolveDefaultAnnotationState(AnnotationDescriptor annotationDescriptor) {
        if (AnnotationQualifiersFqNamesKt.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(annotationDescriptor.getFqName())) {
            return this.javaTypeEnhancementState.getJspecifyReportLevel();
        }
        return resolveJsr305AnnotationState(annotationDescriptor);
    }

    private final AnnotationDescriptor resolveTypeQualifierNickname(ClassDescriptor classDescriptor) {
        if (classDescriptor.getKind() != ClassKind.ANNOTATION_CLASS) {
            return null;
        }
        return this.resolvedNicknames.invoke(classDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> toKotlinTargetNames(String str) {
        int r;
        Set<KotlinTarget> mapJavaTargetArgumentByName = JavaAnnotationTargetMapper.INSTANCE.mapJavaTargetArgumentByName(str);
        r = s.r(mapJavaTargetArgumentByName, 10);
        ArrayList arrayList = new ArrayList(r);
        for (KotlinTarget kotlinTarget : mapJavaTargetArgumentByName) {
            arrayList.add(kotlinTarget.name());
        }
        return arrayList;
    }

    public final TypeQualifierWithApplicability resolveAnnotation(AnnotationDescriptor annotationDescriptor) {
        m.g(annotationDescriptor, "annotationDescriptor");
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null) {
            return null;
        }
        Annotations annotations = annotationClass.getAnnotations();
        FqName TARGET_ANNOTATION = JvmAnnotationNames.TARGET_ANNOTATION;
        m.f(TARGET_ANNOTATION, "TARGET_ANNOTATION");
        AnnotationDescriptor mo2207findAnnotation = annotations.mo2207findAnnotation(TARGET_ANNOTATION);
        if (mo2207findAnnotation == null) {
            return null;
        }
        Map<Name, ConstantValue<?>> allValueArguments = mo2207findAnnotation.getAllValueArguments();
        ArrayList<AnnotationQualifierApplicabilityType> arrayList = new ArrayList();
        for (Map.Entry<Name, ConstantValue<?>> entry : allValueArguments.entrySet()) {
            w.y(arrayList, mapKotlinConstantToQualifierApplicabilityTypes(entry.getValue()));
        }
        int i2 = 0;
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : arrayList) {
            i2 |= 1 << annotationQualifierApplicabilityType.ordinal();
        }
        return new TypeQualifierWithApplicability(annotationDescriptor, i2);
    }

    public final ReportLevel resolveJsr305AnnotationState(AnnotationDescriptor annotationDescriptor) {
        m.g(annotationDescriptor, "annotationDescriptor");
        ReportLevel resolveJsr305CustomState = resolveJsr305CustomState(annotationDescriptor);
        return resolveJsr305CustomState == null ? this.javaTypeEnhancementState.getGlobalJsr305Level() : resolveJsr305CustomState;
    }

    public final ReportLevel resolveJsr305CustomState(AnnotationDescriptor annotationDescriptor) {
        m.g(annotationDescriptor, "annotationDescriptor");
        Map<String, ReportLevel> userDefinedLevelForSpecificJsr305Annotation = this.javaTypeEnhancementState.getUserDefinedLevelForSpecificJsr305Annotation();
        FqName fqName = annotationDescriptor.getFqName();
        ReportLevel reportLevel = userDefinedLevelForSpecificJsr305Annotation.get(fqName == null ? null : fqName.asString());
        if (reportLevel == null) {
            ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
            if (annotationClass == null) {
                return null;
            }
            return migrationAnnotationStatus(annotationClass);
        }
        return reportLevel;
    }

    public final JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation(AnnotationDescriptor annotationDescriptor) {
        JavaDefaultQualifiers javaDefaultQualifiers;
        m.g(annotationDescriptor, "annotationDescriptor");
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations() || (javaDefaultQualifiers = AnnotationQualifiersFqNamesKt.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(annotationDescriptor.getFqName())) == null) {
            return null;
        }
        ReportLevel resolveDefaultAnnotationState = resolveDefaultAnnotationState(annotationDescriptor);
        if (!(resolveDefaultAnnotationState != ReportLevel.IGNORE)) {
            resolveDefaultAnnotationState = null;
        }
        if (resolveDefaultAnnotationState == null) {
            return null;
        }
        return JavaDefaultQualifiers.copy$default(javaDefaultQualifiers, NullabilityQualifierWithMigrationStatus.copy$default(javaDefaultQualifiers.getNullabilityQualifier(), null, resolveDefaultAnnotationState.isWarning(), 1, null), null, false, 6, null);
    }

    public final AnnotationDescriptor resolveTypeQualifierAnnotation(AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor annotationClass;
        m.g(annotationDescriptor, "annotationDescriptor");
        if (this.javaTypeEnhancementState.getDisabledJsr305() || (annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor)) == null) {
            return null;
        }
        return AnnotationTypeQualifierResolverKt.access$isAnnotatedWithTypeQualifier(annotationClass) ? annotationDescriptor : resolveTypeQualifierNickname(annotationClass);
    }

    public final TypeQualifierWithApplicability resolveTypeQualifierDefaultAnnotation(AnnotationDescriptor annotationDescriptor) {
        AnnotationDescriptor annotationDescriptor2;
        boolean z;
        List<AnnotationQualifierApplicabilityType> g2;
        m.g(annotationDescriptor, "annotationDescriptor");
        if (this.javaTypeEnhancementState.getDisabledJsr305()) {
            return null;
        }
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null || !annotationClass.getAnnotations().hasAnnotation(AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_DEFAULT_FQNAME())) {
            annotationClass = null;
        }
        if (annotationClass == null) {
            return null;
        }
        ClassDescriptor annotationClass2 = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        m.e(annotationClass2);
        AnnotationDescriptor mo2207findAnnotation = annotationClass2.getAnnotations().mo2207findAnnotation(AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_DEFAULT_FQNAME());
        m.e(mo2207findAnnotation);
        Map<Name, ConstantValue<?>> allValueArguments = mo2207findAnnotation.getAllValueArguments();
        ArrayList<AnnotationQualifierApplicabilityType> arrayList = new ArrayList();
        for (Map.Entry<Name, ConstantValue<?>> entry : allValueArguments.entrySet()) {
            ConstantValue<?> value = entry.getValue();
            if (m.c(entry.getKey(), JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                g2 = mapJavaConstantToQualifierApplicabilityTypes(value);
            } else {
                g2 = r.g();
            }
            w.y(arrayList, g2);
        }
        int i2 = 0;
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : arrayList) {
            i2 |= 1 << annotationQualifierApplicabilityType.ordinal();
        }
        Iterator<AnnotationDescriptor> it = annotationClass.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                annotationDescriptor2 = null;
                break;
            }
            annotationDescriptor2 = it.next();
            if (resolveTypeQualifierAnnotation(annotationDescriptor2) != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        AnnotationDescriptor annotationDescriptor3 = annotationDescriptor2;
        if (annotationDescriptor3 == null) {
            return null;
        }
        return new TypeQualifierWithApplicability(annotationDescriptor3, i2);
    }
}