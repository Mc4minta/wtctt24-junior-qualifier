package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.List;
import kotlin.a0.p;
import kotlin.a0.q;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JavaTypeResolver.kt */
/* loaded from: classes3.dex */
public final class JavaTypeResolver {

    /* renamed from: c  reason: collision with root package name */
    private final LazyJavaResolverContext f17401c;
    private final TypeParameterResolver typeParameterResolver;

    public JavaTypeResolver(LazyJavaResolverContext c2, TypeParameterResolver typeParameterResolver) {
        m.g(c2, "c");
        m.g(typeParameterResolver, "typeParameterResolver");
        this.f17401c = c2;
        this.typeParameterResolver = typeParameterResolver;
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType javaClassifierType, ClassDescriptor classDescriptor) {
        if (argumentsMakeSenseOnlyForMutableContainer$isSuperWildcard((JavaType) p.l0(javaClassifierType.getTypeArguments()))) {
            List<TypeParameterDescriptor> parameters = JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(classDescriptor).getTypeConstructor().getParameters();
            m.f(parameters, "JavaToKotlinClassMapper.convertReadOnlyToMutable(readOnlyContainer)\n            .typeConstructor.parameters");
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) p.l0(parameters);
            Variance variance = typeParameterDescriptor == null ? null : typeParameterDescriptor.getVariance();
            return (variance == null || variance == Variance.OUT_VARIANCE) ? false : true;
        }
        return false;
    }

    private static final boolean argumentsMakeSenseOnlyForMutableContainer$isSuperWildcard(JavaType javaType) {
        JavaWildcardType javaWildcardType = javaType instanceof JavaWildcardType ? (JavaWildcardType) javaType : null;
        return (javaWildcardType == null || javaWildcardType.getBound() == null || javaWildcardType.isExtends()) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
        if ((!r4.isEmpty()) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r8, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r9, kotlin.reflect.jvm.internal.impl.types.TypeConstructor r10) {
        /*
            r7 = this;
            boolean r0 = r8.isRaw()
            r1 = 0
            java.lang.String r2 = "constructor.parameters"
            r3 = 1
            if (r0 != 0) goto L24
            java.util.List r4 = r8.getTypeArguments()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L23
            java.util.List r4 = r10.getParameters()
            kotlin.jvm.internal.m.f(r4, r2)
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r3
            if (r4 == 0) goto L23
            goto L24
        L23:
            r3 = r1
        L24:
            java.util.List r4 = r10.getParameters()
            kotlin.jvm.internal.m.f(r4, r2)
            java.lang.String r2 = "parameter"
            r5 = 10
            if (r3 == 0) goto L76
            java.util.ArrayList r8 = new java.util.ArrayList
            int r1 = kotlin.a0.p.r(r4, r5)
            r8.<init>(r1)
            java.util.Iterator r1 = r4.iterator()
        L3e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L71
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r3
            kotlin.reflect.jvm.internal.impl.types.LazyWrappedType r4 = new kotlin.reflect.jvm.internal.impl.types.LazyWrappedType
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r5 = r7.f17401c
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r5 = r5.getStorageManager()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeArguments$1$erasedUpperBound$1 r6 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeArguments$1$erasedUpperBound$1
            r6.<init>(r3, r9, r10)
            r4.<init>(r5, r6)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution r5 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution.INSTANCE
            kotlin.jvm.internal.m.f(r3, r2)
            if (r0 == 0) goto L63
            r6 = r9
            goto L69
        L63:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility r6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.INFLEXIBLE
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r6 = r9.withFlexibility(r6)
        L69:
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r3 = r5.computeProjection(r3, r6, r4)
            r8.add(r3)
            goto L3e
        L71:
            java.util.List r8 = kotlin.a0.p.I0(r8)
            return r8
        L76:
            int r9 = r4.size()
            java.util.List r10 = r8.getTypeArguments()
            int r10 = r10.size()
            if (r9 == r10) goto Lb7
            java.util.ArrayList r8 = new java.util.ArrayList
            int r9 = kotlin.a0.p.r(r4, r5)
            r8.<init>(r9)
            java.util.Iterator r9 = r4.iterator()
        L91:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto Lb2
            java.lang.Object r10 = r9.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r10
            kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r0 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
            kotlin.reflect.jvm.internal.impl.name.Name r10 = r10.getName()
            java.lang.String r10 = r10.asString()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r10 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.createErrorType(r10)
            r0.<init>(r10)
            r8.add(r0)
            goto L91
        Lb2:
            java.util.List r8 = kotlin.a0.p.I0(r8)
            return r8
        Lb7:
            java.util.List r8 = r8.getTypeArguments()
            java.lang.Iterable r8 = kotlin.a0.p.P0(r8)
            java.util.ArrayList r9 = new java.util.ArrayList
            int r10 = kotlin.a0.p.r(r8, r5)
            r9.<init>(r10)
            java.util.Iterator r8 = r8.iterator()
        Lcc:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto Lff
            java.lang.Object r10 = r8.next()
            kotlin.a0.e0 r10 = (kotlin.a0.e0) r10
            int r0 = r10.a()
            java.lang.Object r10 = r10.b()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r10 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) r10
            int r3 = r4.size()
            java.lang.Object r0 = r4.get(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r0
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r3 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r5 = 3
            r6 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r3 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r3, r1, r6, r5, r6)
            kotlin.jvm.internal.m.f(r0, r2)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r10 = r7.transformToTypeProjection(r10, r3, r0)
            r9.add(r10)
            goto Lcc
        Lff:
            java.util.List r8 = kotlin.a0.p.I0(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor):java.util.List");
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, SimpleType simpleType) {
        Annotations annotations = simpleType == null ? null : simpleType.getAnnotations();
        if (annotations == null) {
            annotations = new LazyJavaAnnotations(this.f17401c, javaClassifierType, false, 4, null);
        }
        Annotations annotations2 = annotations;
        TypeConstructor computeTypeConstructor = computeTypeConstructor(javaClassifierType, javaTypeAttributes);
        if (computeTypeConstructor == null) {
            return null;
        }
        boolean isNullable = isNullable(javaTypeAttributes);
        if (m.c(simpleType != null ? simpleType.getConstructor() : null, computeTypeConstructor) && !javaClassifierType.isRaw() && isNullable) {
            return simpleType.makeNullableAsSpecified(true);
        }
        List<TypeProjection> computeArguments = computeArguments(javaClassifierType, javaTypeAttributes, computeTypeConstructor);
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.simpleType$default(annotations2, computeTypeConstructor, computeArguments, isNullable, null, 16, null);
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        JavaClassifier classifier = javaClassifierType.getClassifier();
        if (classifier == null) {
            return createNotFoundClass(javaClassifierType);
        }
        if (classifier instanceof JavaClass) {
            JavaClass javaClass = (JavaClass) classifier;
            FqName fqName = javaClass.getFqName();
            if (fqName != null) {
                ClassDescriptor mapKotlinClass = mapKotlinClass(javaClassifierType, javaTypeAttributes, fqName);
                if (mapKotlinClass == null) {
                    mapKotlinClass = this.f17401c.getComponents().getModuleClassResolver().resolveClass(javaClass);
                }
                TypeConstructor typeConstructor = mapKotlinClass != null ? mapKotlinClass.getTypeConstructor() : null;
                return typeConstructor == null ? createNotFoundClass(javaClassifierType) : typeConstructor;
            }
            throw new AssertionError(m.o("Class type should have a FQ name: ", classifier));
        } else if (classifier instanceof JavaTypeParameter) {
            TypeParameterDescriptor resolveTypeParameter = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) classifier);
            if (resolveTypeParameter == null) {
                return null;
            }
            return resolveTypeParameter.getTypeConstructor();
        } else {
            throw new IllegalStateException(m.o("Unknown classifier kind: ", classifier));
        }
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType javaClassifierType) {
        List<Integer> b2;
        ClassId classId = ClassId.topLevel(new FqName(javaClassifierType.getClassifierQualifiedName()));
        m.f(classId, "topLevel(FqName(javaType.classifierQualifiedName))");
        NotFoundClasses notFoundClasses = this.f17401c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses();
        b2 = q.b(0);
        TypeConstructor typeConstructor = notFoundClasses.getClass(classId, b2).getTypeConstructor();
        m.f(typeConstructor, "c.components.deserializedDescriptorResolver.components.notFoundClasses.getClass(classId, listOf(0)).typeConstructor");
        return typeConstructor;
    }

    private final boolean isConflictingArgumentFor(Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        return (typeParameterDescriptor.getVariance() == Variance.INVARIANT || variance == typeParameterDescriptor.getVariance()) ? false : true;
    }

    private final boolean isNullable(JavaTypeAttributes javaTypeAttributes) {
        return (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) ? false : true;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, FqName fqName) {
        if (javaTypeAttributes.isForAnnotationParameter() && m.c(fqName, JavaTypeResolverKt.access$getJAVA_LANG_CLASS_FQ_NAME$p$s1946801611())) {
            return this.f17401c.getComponents().getReflectionTypes().getKClass();
        }
        JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.INSTANCE;
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlinClassMapper, fqName, this.f17401c.getModule().getBuiltIns(), null, 4, null);
        if (mapJavaToKotlin$default == null) {
            return null;
        }
        return (javaToKotlinClassMapper.isReadOnly(mapJavaToKotlin$default) && (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE || argumentsMakeSenseOnlyForMutableContainer(javaClassifierType, mapJavaToKotlin$default))) ? javaToKotlinClassMapper.convertReadOnlyToMutable(mapJavaToKotlin$default) : mapJavaToKotlin$default;
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return javaTypeResolver.transformArrayType(javaArrayType, javaTypeAttributes, z);
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        boolean z = (javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) ? false : true;
        boolean isRaw = javaClassifierType.isRaw();
        if (!isRaw && !z) {
            SimpleType computeSimpleJavaClassifierType = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes, null);
            return computeSimpleJavaClassifierType == null ? transformJavaClassifierType$errorType(javaClassifierType) : computeSimpleJavaClassifierType;
        }
        SimpleType computeSimpleJavaClassifierType2 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (computeSimpleJavaClassifierType2 == null) {
            return transformJavaClassifierType$errorType(javaClassifierType);
        }
        SimpleType computeSimpleJavaClassifierType3 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), computeSimpleJavaClassifierType2);
        if (computeSimpleJavaClassifierType3 == null) {
            return transformJavaClassifierType$errorType(javaClassifierType);
        }
        if (isRaw) {
            return new RawTypeImpl(computeSimpleJavaClassifierType2, computeSimpleJavaClassifierType3);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.flexibleType(computeSimpleJavaClassifierType2, computeSimpleJavaClassifierType3);
    }

    private static final SimpleType transformJavaClassifierType$errorType(JavaClassifierType javaClassifierType) {
        SimpleType createErrorType = ErrorUtils.createErrorType(m.o("Unresolved java class ", javaClassifierType.getPresentableText()));
        m.f(createErrorType, "createErrorType(\"Unresolved java class ${javaType.presentableText}\")");
        return createErrorType;
    }

    private final TypeProjection transformToTypeProjection(JavaType javaType, JavaTypeAttributes javaTypeAttributes, TypeParameterDescriptor typeParameterDescriptor) {
        if (javaType instanceof JavaWildcardType) {
            JavaWildcardType javaWildcardType = (JavaWildcardType) javaType;
            JavaType bound = javaWildcardType.getBound();
            Variance variance = javaWildcardType.isExtends() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
            if (bound != null && !isConflictingArgumentFor(variance, typeParameterDescriptor)) {
                return TypeUtilsKt.createProjection(transformJavaType(bound, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null)), variance, typeParameterDescriptor);
            }
            return JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
        }
        return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(javaType, javaTypeAttributes));
    }

    public final KotlinType transformArrayType(JavaArrayType arrayType, JavaTypeAttributes attr, boolean z) {
        List<? extends AnnotationDescriptor> r0;
        m.g(arrayType, "arrayType");
        m.g(attr, "attr");
        JavaType componentType = arrayType.getComponentType();
        JavaPrimitiveType javaPrimitiveType = componentType instanceof JavaPrimitiveType ? (JavaPrimitiveType) componentType : null;
        PrimitiveType type = javaPrimitiveType == null ? null : javaPrimitiveType.getType();
        LazyJavaAnnotations lazyJavaAnnotations = new LazyJavaAnnotations(this.f17401c, arrayType, true);
        if (type != null) {
            SimpleType primitiveArrayKotlinType = this.f17401c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(type);
            m.f(primitiveArrayKotlinType, "c.module.builtIns.getPrimitiveArrayKotlinType(primitiveType)");
            Annotations.Companion companion = Annotations.Companion;
            r0 = z.r0(lazyJavaAnnotations, primitiveArrayKotlinType.getAnnotations());
            primitiveArrayKotlinType.replaceAnnotations(companion.create(r0));
            if (attr.isForAnnotationParameter()) {
                return primitiveArrayKotlinType;
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return KotlinTypeFactory.flexibleType(primitiveArrayKotlinType, primitiveArrayKotlinType.makeNullableAsSpecified(true));
        }
        KotlinType transformJavaType = transformJavaType(componentType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, attr.isForAnnotationParameter(), null, 2, null));
        if (attr.isForAnnotationParameter()) {
            SimpleType arrayType2 = this.f17401c.getModule().getBuiltIns().getArrayType(z ? Variance.OUT_VARIANCE : Variance.INVARIANT, transformJavaType, lazyJavaAnnotations);
            m.f(arrayType2, "c.module.builtIns.getArrayType(projectionKind, componentType, annotations)");
            return arrayType2;
        }
        KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.INSTANCE;
        SimpleType arrayType3 = this.f17401c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, transformJavaType, lazyJavaAnnotations);
        m.f(arrayType3, "c.module.builtIns.getArrayType(INVARIANT, componentType, annotations)");
        return KotlinTypeFactory.flexibleType(arrayType3, this.f17401c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, transformJavaType, lazyJavaAnnotations).makeNullableAsSpecified(true));
    }

    public final KotlinType transformJavaType(JavaType javaType, JavaTypeAttributes attr) {
        SimpleType unitType;
        m.g(attr, "attr");
        if (javaType instanceof JavaPrimitiveType) {
            PrimitiveType type = ((JavaPrimitiveType) javaType).getType();
            if (type != null) {
                unitType = this.f17401c.getModule().getBuiltIns().getPrimitiveKotlinType(type);
            } else {
                unitType = this.f17401c.getModule().getBuiltIns().getUnitType();
            }
            m.f(unitType, "{\n                val primitiveType = javaType.type\n                if (primitiveType != null) c.module.builtIns.getPrimitiveKotlinType(primitiveType)\n                else c.module.builtIns.unitType\n            }");
            return unitType;
        } else if (javaType instanceof JavaClassifierType) {
            return transformJavaClassifierType((JavaClassifierType) javaType, attr);
        } else {
            if (javaType instanceof JavaArrayType) {
                return transformArrayType$default(this, (JavaArrayType) javaType, attr, false, 4, null);
            }
            if (!(javaType instanceof JavaWildcardType)) {
                if (javaType == null) {
                    SimpleType defaultBound = this.f17401c.getModule().getBuiltIns().getDefaultBound();
                    m.f(defaultBound, "c.module.builtIns.defaultBound");
                    return defaultBound;
                }
                throw new UnsupportedOperationException(m.o("Unsupported type: ", javaType));
            }
            JavaType bound = ((JavaWildcardType) javaType).getBound();
            KotlinType transformJavaType = bound == null ? null : transformJavaType(bound, attr);
            if (transformJavaType == null) {
                SimpleType defaultBound2 = this.f17401c.getModule().getBuiltIns().getDefaultBound();
                m.f(defaultBound2, "c.module.builtIns.defaultBound");
                return defaultBound2;
            }
            return transformJavaType;
        }
    }
}