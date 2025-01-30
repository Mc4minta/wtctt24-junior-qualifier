package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.AnnotationDefaultValue;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.NullDefaultValue;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.StringDefaultValue;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;

/* compiled from: signatureEnhancement.kt */
/* loaded from: classes3.dex */
public final class SignatureEnhancement {
    private final AnnotationTypeQualifierResolver annotationTypeQualifierResolver;
    private final JavaTypeEnhancementState javaTypeEnhancementState;
    private final JavaTypeEnhancement typeEnhancement;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: signatureEnhancement.kt */
    /* loaded from: classes3.dex */
    public static class PartEnhancementResult {
        private final boolean containsFunctionN;
        private final KotlinType type;
        private final boolean wereChanges;

        public PartEnhancementResult(KotlinType type, boolean z, boolean z2) {
            m.g(type, "type");
            this.type = type;
            this.wereChanges = z;
            this.containsFunctionN = z2;
        }

        public final boolean getContainsFunctionN() {
            return this.containsFunctionN;
        }

        public final KotlinType getType() {
            return this.type;
        }

        public final boolean getWereChanges() {
            return this.wereChanges;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: signatureEnhancement.kt */
    /* loaded from: classes3.dex */
    public static final class ValueParameterEnhancementResult extends PartEnhancementResult {
        private final boolean hasDefaultValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValueParameterEnhancementResult(KotlinType type, boolean z, boolean z2, boolean z3) {
            super(type, z2, z3);
            m.g(type, "type");
            this.hasDefaultValue = z;
        }

        public final boolean getHasDefaultValue() {
            return this.hasDefaultValue;
        }
    }

    public SignatureEnhancement(AnnotationTypeQualifierResolver annotationTypeQualifierResolver, JavaTypeEnhancementState javaTypeEnhancementState, JavaTypeEnhancement typeEnhancement) {
        m.g(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        m.g(javaTypeEnhancementState, "javaTypeEnhancementState");
        m.g(typeEnhancement, "typeEnhancement");
        this.annotationTypeQualifierResolver = annotationTypeQualifierResolver;
        this.javaTypeEnhancementState = javaTypeEnhancementState;
        this.typeEnhancement = typeEnhancement;
    }

    private final NullabilityQualifierWithMigrationStatus commonMigrationStatus(FqName fqName, AnnotationDescriptor annotationDescriptor, boolean z) {
        if (JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS().contains(fqName)) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, z);
        }
        if (JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS().contains(fqName)) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, z);
        }
        if (m.c(fqName, JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION())) {
            return extractNullabilityTypeFromArgument(annotationDescriptor, z);
        }
        if (m.c(fqName, JvmAnnotationNamesKt.getCOMPATQUAL_NULLABLE_ANNOTATION()) && this.javaTypeEnhancementState.getEnableCompatqualCheckerFrameworkAnnotations()) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, z);
        }
        if (m.c(fqName, JvmAnnotationNamesKt.getCOMPATQUAL_NONNULL_ANNOTATION()) && this.javaTypeEnhancementState.getEnableCompatqualCheckerFrameworkAnnotations()) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, z);
        }
        if (m.c(fqName, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION())) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, true);
        }
        if (m.c(fqName, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION())) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, true);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x022e A[LOOP:2: B:132:0x0228->B:134:0x022e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> D enhanceSignature(D r17, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r18) {
        /*
            Method dump skipped, instructions count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor");
    }

    private final NullabilityQualifierWithMigrationStatus extractNullabilityFromKnownAnnotations(AnnotationDescriptor annotationDescriptor, boolean z, boolean z2) {
        FqName fqName = annotationDescriptor.getFqName();
        if (fqName == null) {
            return null;
        }
        boolean z3 = (annotationDescriptor instanceof LazyJavaAnnotationDescriptor) && (((LazyJavaAnnotationDescriptor) annotationDescriptor).isFreshlySupportedTypeUseAnnotation() || z2) && !z;
        NullabilityQualifierWithMigrationStatus jspecifyMigrationStatus = jspecifyMigrationStatus(fqName);
        if (jspecifyMigrationStatus == null && (jspecifyMigrationStatus = commonMigrationStatus(fqName, annotationDescriptor, z3)) == null) {
            return null;
        }
        return (!jspecifyMigrationStatus.isForWarningOnly() && (annotationDescriptor instanceof PossiblyExternalAnnotationDescriptor) && ((PossiblyExternalAnnotationDescriptor) annotationDescriptor).isIdeExternalAnnotation()) ? NullabilityQualifierWithMigrationStatus.copy$default(jspecifyMigrationStatus, null, true, 1, null) : jspecifyMigrationStatus;
    }

    private final NullabilityQualifierWithMigrationStatus extractNullabilityTypeFromArgument(AnnotationDescriptor annotationDescriptor, boolean z) {
        ConstantValue<?> firstArgument = DescriptorUtilsKt.firstArgument(annotationDescriptor);
        EnumValue enumValue = firstArgument instanceof EnumValue ? (EnumValue) firstArgument : null;
        if (enumValue == null) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, z);
        }
        String asString = enumValue.getEnumEntryName().asString();
        switch (asString.hashCode()) {
            case 73135176:
                if (!asString.equals("MAYBE")) {
                    return null;
                }
                break;
            case 74175084:
                if (!asString.equals("NEVER")) {
                    return null;
                }
                break;
            case 433141802:
                if (asString.equals("UNKNOWN")) {
                    return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.FORCE_FLEXIBILITY, z);
                }
                return null;
            case 1933739535:
                if (asString.equals("ALWAYS")) {
                    return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, z);
                }
                return null;
            default:
                return null;
        }
        return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, z);
    }

    private final boolean hasDefaultValueInAnnotation(ValueParameterDescriptor valueParameterDescriptor, KotlinType kotlinType) {
        boolean declaresDefaultValue;
        AnnotationDefaultValue defaultValueFromAnnotation = UtilKt.getDefaultValueFromAnnotation(valueParameterDescriptor);
        if (defaultValueFromAnnotation instanceof StringDefaultValue) {
            declaresDefaultValue = UtilsKt.lexicalCastFrom(kotlinType, ((StringDefaultValue) defaultValueFromAnnotation).getValue()) != null;
        } else if (m.c(defaultValueFromAnnotation, NullDefaultValue.INSTANCE)) {
            declaresDefaultValue = TypeUtils.acceptsNullable(kotlinType);
        } else if (defaultValueFromAnnotation == null) {
            declaresDefaultValue = valueParameterDescriptor.declaresDefaultValue();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return declaresDefaultValue && valueParameterDescriptor.getOverriddenDescriptors().isEmpty();
    }

    private final NullabilityQualifierWithMigrationStatus jspecifyMigrationStatus(FqName fqName) {
        if (this.javaTypeEnhancementState.getJspecifyReportLevel() == ReportLevel.IGNORE) {
            return null;
        }
        boolean z = this.javaTypeEnhancementState.getJspecifyReportLevel() == ReportLevel.WARN;
        if (m.c(fqName, JvmAnnotationNamesKt.getJSPECIFY_NULLABLE())) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, z);
        }
        if (m.c(fqName, JvmAnnotationNamesKt.getJSPECIFY_NULLNESS_UNKNOWN())) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.FORCE_FLEXIBILITY, z);
        }
        return null;
    }

    private final SignatureParts parts(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, l<? super CallableMemberDescriptor, ? extends KotlinType> lVar) {
        int r;
        KotlinType invoke = lVar.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        m.f(overriddenDescriptors, "this.overriddenDescriptors");
        r = s.r(overriddenDescriptors, 10);
        ArrayList arrayList = new ArrayList(r);
        for (CallableMemberDescriptor it : overriddenDescriptors) {
            m.f(it, "it");
            arrayList.add(lVar.invoke(it));
        }
        return new SignatureParts(annotated, invoke, arrayList, z, ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, lVar.invoke(callableMemberDescriptor).getAnnotations()), annotationQualifierApplicabilityType, false, 64, null);
    }

    private final SignatureParts partsForValueParameter(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, LazyJavaResolverContext lazyJavaResolverContext, l<? super CallableMemberDescriptor, ? extends KotlinType> lVar) {
        LazyJavaResolverContext copyWithNewDefaultTypeQualifiers;
        return parts(callableMemberDescriptor, valueParameterDescriptor, false, (valueParameterDescriptor == null || (copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, valueParameterDescriptor.getAnnotations())) == null) ? lazyJavaResolverContext : copyWithNewDefaultTypeQualifiers, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(LazyJavaResolverContext c2, Collection<? extends D> platformSignatures) {
        int r;
        m.g(c2, "c");
        m.g(platformSignatures, "platformSignatures");
        r = s.r(platformSignatures, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator<T> it = platformSignatures.iterator();
        while (it.hasNext()) {
            arrayList.add(enhanceSignature((CallableMemberDescriptor) it.next(), c2));
        }
        return arrayList;
    }

    public final KotlinType enhanceSuperType(KotlinType type, LazyJavaResolverContext context) {
        List g2;
        m.g(type, "type");
        m.g(context, "context");
        g2 = r.g();
        return SignatureParts.enhance$default(new SignatureParts(null, type, g2, false, context, AnnotationQualifierApplicabilityType.TYPE_USE, false, 64, null), null, 1, null).getType();
    }

    public final List<KotlinType> enhanceTypeParameterBounds(TypeParameterDescriptor typeParameter, List<? extends KotlinType> bounds, LazyJavaResolverContext context) {
        int r;
        List g2;
        m.g(typeParameter, "typeParameter");
        m.g(bounds, "bounds");
        m.g(context, "context");
        r = s.r(bounds, 10);
        ArrayList arrayList = new ArrayList(r);
        for (KotlinType kotlinType : bounds) {
            if (!TypeUtilsKt.contains(kotlinType, SignatureEnhancement$enhanceTypeParameterBounds$1$1.INSTANCE)) {
                g2 = r.g();
                kotlinType = SignatureParts.enhance$default(new SignatureParts(this, typeParameter, kotlinType, g2, false, context, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, true), null, 1, null).getType();
            }
            arrayList.add(kotlinType);
        }
        return arrayList;
    }

    public final NullabilityQualifierWithMigrationStatus extractNullability(AnnotationDescriptor annotationDescriptor, boolean z, boolean z2) {
        NullabilityQualifierWithMigrationStatus extractNullabilityFromKnownAnnotations;
        m.g(annotationDescriptor, "annotationDescriptor");
        NullabilityQualifierWithMigrationStatus extractNullabilityFromKnownAnnotations2 = extractNullabilityFromKnownAnnotations(annotationDescriptor, z, z2);
        if (extractNullabilityFromKnownAnnotations2 == null) {
            AnnotationDescriptor resolveTypeQualifierAnnotation = this.annotationTypeQualifierResolver.resolveTypeQualifierAnnotation(annotationDescriptor);
            if (resolveTypeQualifierAnnotation == null) {
                return null;
            }
            ReportLevel resolveJsr305AnnotationState = this.annotationTypeQualifierResolver.resolveJsr305AnnotationState(annotationDescriptor);
            if (resolveJsr305AnnotationState.isIgnore() || (extractNullabilityFromKnownAnnotations = extractNullabilityFromKnownAnnotations(resolveTypeQualifierAnnotation, z, z2)) == null) {
                return null;
            }
            return NullabilityQualifierWithMigrationStatus.copy$default(extractNullabilityFromKnownAnnotations, null, resolveJsr305AnnotationState.isWarning(), 1, null);
        }
        return extractNullabilityFromKnownAnnotations2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: signatureEnhancement.kt */
    /* loaded from: classes3.dex */
    public final class SignatureParts {
        private final AnnotationQualifierApplicabilityType containerApplicabilityType;
        private final LazyJavaResolverContext containerContext;
        private final Collection<KotlinType> fromOverridden;
        private final KotlinType fromOverride;
        private final boolean isCovariant;
        private final Annotated typeContainer;
        private final boolean typeParameterBounds;

        /* JADX WARN: Multi-variable type inference failed */
        public SignatureParts(SignatureEnhancement this$0, Annotated annotated, KotlinType fromOverride, Collection<? extends KotlinType> fromOverridden, boolean z, LazyJavaResolverContext containerContext, AnnotationQualifierApplicabilityType containerApplicabilityType, boolean z2) {
            m.g(this$0, "this$0");
            m.g(fromOverride, "fromOverride");
            m.g(fromOverridden, "fromOverridden");
            m.g(containerContext, "containerContext");
            m.g(containerApplicabilityType, "containerApplicabilityType");
            SignatureEnhancement.this = this$0;
            this.typeContainer = annotated;
            this.fromOverride = fromOverride;
            this.fromOverridden = fromOverridden;
            this.isCovariant = z;
            this.containerContext = containerContext;
            this.containerApplicabilityType = containerApplicabilityType;
            this.typeParameterBounds = z2;
        }

        private final NullabilityQualifier boundsNullability(TypeParameterDescriptor typeParameterDescriptor) {
            boolean z;
            boolean isNullabilityFlexible;
            boolean z2;
            if (typeParameterDescriptor instanceof LazyJavaTypeParameterDescriptor) {
                LazyJavaTypeParameterDescriptor lazyJavaTypeParameterDescriptor = (LazyJavaTypeParameterDescriptor) typeParameterDescriptor;
                List<KotlinType> upperBounds = lazyJavaTypeParameterDescriptor.getUpperBounds();
                m.f(upperBounds, "upperBounds");
                boolean z3 = false;
                if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                    for (KotlinType kotlinType : upperBounds) {
                        if (!KotlinTypeKt.isError(kotlinType)) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    return null;
                }
                List<KotlinType> upperBounds2 = lazyJavaTypeParameterDescriptor.getUpperBounds();
                m.f(upperBounds2, "upperBounds");
                if (!(upperBounds2 instanceof Collection) || !upperBounds2.isEmpty()) {
                    for (KotlinType kotlinType2 : upperBounds2) {
                        isNullabilityFlexible = SignatureEnhancementKt.isNullabilityFlexible(kotlinType2);
                        if (!isNullabilityFlexible) {
                            z2 = false;
                            break;
                        }
                    }
                }
                z2 = true;
                if (z2) {
                    return null;
                }
                List<KotlinType> upperBounds3 = lazyJavaTypeParameterDescriptor.getUpperBounds();
                m.f(upperBounds3, "upperBounds");
                if (!(upperBounds3 instanceof Collection) || !upperBounds3.isEmpty()) {
                    Iterator<T> it = upperBounds3.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        KotlinType it2 = (KotlinType) it.next();
                        m.f(it2, "it");
                        if (!KotlinTypeKt.isNullable(it2)) {
                            z3 = true;
                            break;
                        }
                    }
                }
                return z3 ? NullabilityQualifier.NOT_NULL : NullabilityQualifier.NULLABLE;
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final kotlin.e0.c.l<java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> computeIndexedQualifiersForOverride() {
            /*
                r17 = this;
                r7 = r17
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> r0 = r7.fromOverridden
                java.util.ArrayList r8 = new java.util.ArrayList
                r1 = 10
                int r1 = kotlin.a0.p.r(r0, r1)
                r8.<init>(r1)
                java.util.Iterator r0 = r0.iterator()
            L13:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L27
                java.lang.Object r1 = r0.next()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
                java.util.List r1 = r7.toIndexed(r1)
                r8.add(r1)
                goto L13
            L27:
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r7.fromOverride
                java.util.List r9 = r7.toIndexed(r0)
                boolean r0 = r7.isCovariant
                r11 = 1
                if (r0 == 0) goto L60
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> r0 = r7.fromOverridden
                boolean r1 = r0 instanceof java.util.Collection
                if (r1 == 0) goto L40
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L40
            L3e:
                r0 = 0
                goto L5c
            L40:
                java.util.Iterator r0 = r0.iterator()
            L44:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L3e
                java.lang.Object r1 = r0.next()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
                kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker r2 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT
                kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r7.fromOverride
                boolean r1 = r2.equalTypes(r1, r3)
                r1 = r1 ^ r11
                if (r1 == 0) goto L44
                r0 = r11
            L5c:
                if (r0 == 0) goto L60
                r12 = r11
                goto L61
            L60:
                r12 = 0
            L61:
                if (r12 == 0) goto L65
                r13 = r11
                goto L6a
            L65:
                int r0 = r9.size()
                r13 = r0
            L6a:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[] r14 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[r13]
                r15 = 0
            L6d:
                if (r15 >= r13) goto Lc0
                if (r15 != 0) goto L73
                r4 = r11
                goto L74
            L73:
                r4 = 0
            L74:
                java.lang.Object r0 = r9.get(r15)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeAndDefaultQualifiers r0 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeAndDefaultQualifiers) r0
                kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r0.component1()
                kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r3 = r0.component2()
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r5 = r0.component3()
                boolean r6 = r0.component4()
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r0 = r8.iterator()
            L93:
                boolean r16 = r0.hasNext()
                if (r16 == 0) goto Lb5
                java.lang.Object r16 = r0.next()
                r10 = r16
                java.util.List r10 = (java.util.List) r10
                java.lang.Object r10 = kotlin.a0.p.b0(r10, r15)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeAndDefaultQualifiers r10 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeAndDefaultQualifiers) r10
                if (r10 != 0) goto Lab
                r10 = 0
                goto Laf
            Lab:
                kotlin.reflect.jvm.internal.impl.types.KotlinType r10 = r10.getType()
            Laf:
                if (r10 == 0) goto L93
                r2.add(r10)
                goto L93
            Lb5:
                r0 = r17
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r0 = r0.computeQualifiersForOverride(r1, r2, r3, r4, r5, r6)
                r14[r15] = r0
                int r15 = r15 + 1
                goto L6d
            Lc0:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1 r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1
                r0.<init>(r14)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.computeIndexedQualifiersForOverride():kotlin.e0.c.l");
        }

        private final NullabilityQualifierWithMigrationStatus computeNullabilityInfoInTheAbsenceOfExplicitAnnotation(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, JavaDefaultQualifiers javaDefaultQualifiers, TypeParameterDescriptor typeParameterDescriptor) {
            NullabilityQualifierWithMigrationStatus nullabilityQualifier;
            if (nullabilityQualifierWithMigrationStatus == null) {
                nullabilityQualifierWithMigrationStatus = (javaDefaultQualifiers == null || (nullabilityQualifier = javaDefaultQualifiers.getNullabilityQualifier()) == null) ? null : new NullabilityQualifierWithMigrationStatus(nullabilityQualifier.getQualifier(), nullabilityQualifier.isForWarningOnly());
            }
            NullabilityQualifier boundsNullability = typeParameterDescriptor == null ? null : boundsNullability(typeParameterDescriptor);
            if (boundsNullability == null) {
                return nullabilityQualifierWithMigrationStatus;
            }
            if (nullabilityQualifierWithMigrationStatus == null) {
                return new NullabilityQualifierWithMigrationStatus(boundsNullability, false, 2, null);
            }
            return new NullabilityQualifierWithMigrationStatus(mostSpecific(boundsNullability, nullabilityQualifierWithMigrationStatus.getQualifier()), false, 2, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:76:0x012e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers computeQualifiersForOverride(kotlin.reflect.jvm.internal.impl.types.KotlinType r10, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> r11, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r12, boolean r13, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r14, boolean r15) {
            /*
                Method dump skipped, instructions count: 308
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.computeQualifiersForOverride(kotlin.reflect.jvm.internal.impl.types.KotlinType, java.util.Collection, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers, boolean, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers");
        }

        public static /* synthetic */ PartEnhancementResult enhance$default(SignatureParts signatureParts, TypeEnhancementInfo typeEnhancementInfo, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                typeEnhancementInfo = null;
            }
            return signatureParts.enhance(typeEnhancementInfo);
        }

        private final NullabilityQualifierWithMigrationStatus extractNullability(Annotations annotations, boolean z, boolean z2) {
            SignatureEnhancement signatureEnhancement = SignatureEnhancement.this;
            Iterator<AnnotationDescriptor> it = annotations.iterator();
            while (it.hasNext()) {
                NullabilityQualifierWithMigrationStatus extractNullability = signatureEnhancement.extractNullability(it.next(), z, z2);
                if (extractNullability != null) {
                    return extractNullability;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers extractQualifiers(kotlin.reflect.jvm.internal.impl.types.KotlinType r12) {
            /*
                r11 = this;
                boolean r0 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.isFlexible(r12)
                if (r0 == 0) goto L18
                kotlin.reflect.jvm.internal.impl.types.FlexibleType r0 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.asFlexibleType(r12)
                kotlin.o r1 = new kotlin.o
                kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = r0.getLowerBound()
                kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r0.getUpperBound()
                r1.<init>(r2, r0)
                goto L1d
            L18:
                kotlin.o r1 = new kotlin.o
                r1.<init>(r12, r12)
            L1d:
                java.lang.Object r0 = r1.a()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
                java.lang.Object r1 = r1.b()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper r2 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.INSTANCE
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r10 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers
                boolean r3 = r0.isMarkedNullable()
                r4 = 0
                if (r3 == 0) goto L38
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            L36:
                r5 = r3
                goto L42
            L38:
                boolean r3 = r1.isMarkedNullable()
                if (r3 != 0) goto L41
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                goto L36
            L41:
                r5 = r4
            L42:
                boolean r0 = r2.isReadOnly(r0)
                if (r0 == 0) goto L4b
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY
                goto L55
            L4b:
                boolean r0 = r2.isMutable(r1)
                if (r0 == 0) goto L54
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE
                goto L55
            L54:
                r0 = r4
            L55:
                kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12 = r12.unwrap()
                boolean r6 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameter
                r7 = 0
                r8 = 8
                r9 = 0
                r3 = r10
                r4 = r5
                r5 = r0
                r3.<init>(r4, r5, r6, r7, r8, r9)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.extractQualifiers(kotlin.reflect.jvm.internal.impl.types.KotlinType):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers");
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
            if ((r12.getAffectsTypeParameterBasedTypes() || !kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isTypeParameter(r10)) != false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00d6, code lost:
            if (r0.getQualifier() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00d9, code lost:
            r11 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00ef, code lost:
            if (kotlin.jvm.internal.m.c(r12 == null ? null : java.lang.Boolean.valueOf(r12.getMakesTypeParameterNotNull()), java.lang.Boolean.TRUE) != false) goto L56;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers extractQualifiersFromAnnotations(kotlin.reflect.jvm.internal.impl.types.KotlinType r10, boolean r11, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r12, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r13, boolean r14) {
            /*
                Method dump skipped, instructions count: 309
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.extractQualifiersFromAnnotations(kotlin.reflect.jvm.internal.impl.types.KotlinType, boolean, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers");
        }

        private static final <T> T extractQualifiersFromAnnotations$ifPresent(List<FqName> list, Annotations annotations, T t) {
            boolean z;
            boolean z2 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (FqName fqName : list) {
                    if (annotations.mo2207findAnnotation(fqName) != null) {
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
            }
            z2 = false;
            if (z2) {
                return t;
            }
            return null;
        }

        private static final <T> T extractQualifiersFromAnnotations$uniqueNotNull(T t, T t2) {
            if (t == null || t2 == null || m.c(t, t2)) {
                return t == null ? t2 : t;
            }
            return null;
        }

        private final boolean isForVarargParameter() {
            Annotated annotated = this.typeContainer;
            if (!(annotated instanceof ValueParameterDescriptor)) {
                annotated = null;
            }
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) annotated;
            return (valueParameterDescriptor != null ? valueParameterDescriptor.getVarargElementType() : null) != null;
        }

        private final NullabilityQualifier mostSpecific(NullabilityQualifier nullabilityQualifier, NullabilityQualifier nullabilityQualifier2) {
            NullabilityQualifier nullabilityQualifier3 = NullabilityQualifier.FORCE_FLEXIBILITY;
            if (nullabilityQualifier == nullabilityQualifier3) {
                return nullabilityQualifier2;
            }
            if (nullabilityQualifier2 == nullabilityQualifier3) {
                return nullabilityQualifier;
            }
            NullabilityQualifier nullabilityQualifier4 = NullabilityQualifier.NULLABLE;
            if (nullabilityQualifier == nullabilityQualifier4) {
                return nullabilityQualifier2;
            }
            if (nullabilityQualifier2 == nullabilityQualifier4) {
                return nullabilityQualifier;
            }
            if (nullabilityQualifier == nullabilityQualifier2) {
                NullabilityQualifier nullabilityQualifier5 = NullabilityQualifier.NOT_NULL;
            }
            return NullabilityQualifier.NOT_NULL;
        }

        private final o<NullabilityQualifierWithMigrationStatus, Boolean> nullabilityInfoBoundsForTypeParameterUsage(KotlinType kotlinType) {
            ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
            TypeParameterDescriptor typeParameterDescriptor = mo2214getDeclarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) mo2214getDeclarationDescriptor : null;
            NullabilityQualifier boundsNullability = typeParameterDescriptor == null ? null : boundsNullability(typeParameterDescriptor);
            if (boundsNullability == null) {
                return new o<>(null, Boolean.FALSE);
            }
            NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
            return new o<>(new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, false, 2, null), Boolean.valueOf(boundsNullability == nullabilityQualifier));
        }

        private final List<TypeAndDefaultQualifiers> toIndexed(KotlinType kotlinType) {
            ArrayList arrayList = new ArrayList(1);
            toIndexed$add(this, arrayList, kotlinType, this.containerContext, null);
            return arrayList;
        }

        private static final void toIndexed$add(SignatureParts signatureParts, ArrayList<TypeAndDefaultQualifiers> arrayList, KotlinType kotlinType, LazyJavaResolverContext lazyJavaResolverContext, TypeParameterDescriptor typeParameterDescriptor) {
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
            JavaDefaultQualifiers javaDefaultQualifiers;
            List<o> Q0;
            LazyJavaResolverContext copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, kotlinType.getAnnotations());
            JavaTypeQualifiersByElementType defaultTypeQualifiers = copyWithNewDefaultTypeQualifiers.getDefaultTypeQualifiers();
            if (defaultTypeQualifiers == null) {
                javaDefaultQualifiers = null;
            } else {
                if (signatureParts.typeParameterBounds) {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
                } else {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_USE;
                }
                javaDefaultQualifiers = defaultTypeQualifiers.get(annotationQualifierApplicabilityType);
            }
            arrayList.add(new TypeAndDefaultQualifiers(kotlinType, javaDefaultQualifiers, typeParameterDescriptor, false));
            List<TypeProjection> arguments = kotlinType.getArguments();
            List<TypeParameterDescriptor> parameters = kotlinType.getConstructor().getParameters();
            m.f(parameters, "type.constructor.parameters");
            Q0 = z.Q0(arguments, parameters);
            for (o oVar : Q0) {
                TypeProjection typeProjection = (TypeProjection) oVar.a();
                TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor) oVar.b();
                if (typeProjection.isStarProjection()) {
                    KotlinType type = typeProjection.getType();
                    m.f(type, "arg.type");
                    arrayList.add(new TypeAndDefaultQualifiers(type, javaDefaultQualifiers, typeParameterDescriptor2, true));
                } else {
                    KotlinType type2 = typeProjection.getType();
                    m.f(type2, "arg.type");
                    toIndexed$add(signatureParts, arrayList, type2, copyWithNewDefaultTypeQualifiers, typeParameterDescriptor2);
                }
            }
        }

        public final PartEnhancementResult enhance(TypeEnhancementInfo typeEnhancementInfo) {
            l<Integer, JavaTypeQualifiers> computeIndexedQualifiersForOverride = computeIndexedQualifiersForOverride();
            SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 signatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 = typeEnhancementInfo == null ? null : new SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1(typeEnhancementInfo, computeIndexedQualifiersForOverride);
            boolean contains = TypeUtils.contains(this.fromOverride, SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1.INSTANCE);
            JavaTypeEnhancement javaTypeEnhancement = SignatureEnhancement.this.typeEnhancement;
            KotlinType kotlinType = this.fromOverride;
            if (signatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 != null) {
                computeIndexedQualifiersForOverride = signatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1;
            }
            KotlinType enhance = javaTypeEnhancement.enhance(kotlinType, computeIndexedQualifiersForOverride);
            PartEnhancementResult partEnhancementResult = enhance != null ? new PartEnhancementResult(enhance, true, contains) : null;
            return partEnhancementResult == null ? new PartEnhancementResult(this.fromOverride, false, contains) : partEnhancementResult;
        }

        public /* synthetic */ SignatureParts(Annotated annotated, KotlinType kotlinType, Collection collection, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(SignatureEnhancement.this, annotated, kotlinType, collection, z, lazyJavaResolverContext, annotationQualifierApplicabilityType, (i2 & 64) != 0 ? false : z2);
        }
    }
}