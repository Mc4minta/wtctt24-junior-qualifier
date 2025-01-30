package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.e0.c.q;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.ExpandedTypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* compiled from: descriptorBasedTypeSignatureMapping.kt */
/* loaded from: classes3.dex */
public final class DescriptorBasedTypeSignatureMappingKt {
    public static final String computeInternalName(ClassDescriptor klass, TypeMappingConfiguration<?> typeMappingConfiguration) {
        String J;
        m.g(klass, "klass");
        m.g(typeMappingConfiguration, "typeMappingConfiguration");
        String predefinedFullInternalNameForClass = typeMappingConfiguration.getPredefinedFullInternalNameForClass(klass);
        if (predefinedFullInternalNameForClass == null) {
            DeclarationDescriptor containingDeclaration = klass.getContainingDeclaration();
            m.f(containingDeclaration, "klass.containingDeclaration");
            String identifier = SpecialNames.safeIdentifier(klass.getName()).getIdentifier();
            m.f(identifier, "safeIdentifier(klass.name).identifier");
            if (containingDeclaration instanceof PackageFragmentDescriptor) {
                FqName fqName = ((PackageFragmentDescriptor) containingDeclaration).getFqName();
                if (fqName.isRoot()) {
                    return identifier;
                }
                StringBuilder sb = new StringBuilder();
                String asString = fqName.asString();
                m.f(asString, "fqName.asString()");
                J = x.J(asString, '.', '/', false, 4, null);
                sb.append(J);
                sb.append('/');
                sb.append(identifier);
                return sb.toString();
            }
            ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
            if (classDescriptor != null) {
                String predefinedInternalNameForClass = typeMappingConfiguration.getPredefinedInternalNameForClass(classDescriptor);
                if (predefinedInternalNameForClass == null) {
                    predefinedInternalNameForClass = computeInternalName(classDescriptor, typeMappingConfiguration);
                }
                return predefinedInternalNameForClass + '$' + identifier;
            }
            throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + klass);
        }
        return predefinedFullInternalNameForClass;
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            typeMappingConfiguration = TypeMappingConfigurationImpl.INSTANCE;
        }
        return computeInternalName(classDescriptor, typeMappingConfiguration);
    }

    public static final boolean hasVoidReturnType(CallableDescriptor descriptor) {
        m.g(descriptor, "descriptor");
        if (descriptor instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType returnType = descriptor.getReturnType();
        m.e(returnType);
        if (KotlinBuiltIns.isUnit(returnType)) {
            KotlinType returnType2 = descriptor.getReturnType();
            m.e(returnType2);
            if (!TypeUtils.isNullableType(returnType2) && !(descriptor instanceof PropertyGetterDescriptor)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, java.lang.Object] */
    public static final <T> T mapType(KotlinType kotlinType, JvmTypeFactory<T> factory, TypeMappingMode mode, TypeMappingConfiguration<? extends T> typeMappingConfiguration, JvmDescriptorTypeWriter<T> jvmDescriptorTypeWriter, q<? super KotlinType, ? super T, ? super TypeMappingMode, kotlin.x> writeGenericType) {
        Object obj;
        KotlinType kotlinType2;
        Object mapType;
        m.g(kotlinType, "kotlinType");
        m.g(factory, "factory");
        m.g(mode, "mode");
        m.g(typeMappingConfiguration, "typeMappingConfiguration");
        m.g(writeGenericType, "writeGenericType");
        KotlinType preprocessType = typeMappingConfiguration.preprocessType(kotlinType);
        if (preprocessType == null) {
            if (FunctionTypesKt.isSuspendFunctionType(kotlinType)) {
                return (T) mapType(SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(kotlinType, typeMappingConfiguration.releaseCoroutines()), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
            }
            SimpleClassicTypeSystemContext simpleClassicTypeSystemContext = SimpleClassicTypeSystemContext.INSTANCE;
            Object mapBuiltInType = TypeSignatureMappingKt.mapBuiltInType(simpleClassicTypeSystemContext, kotlinType, factory, mode);
            if (mapBuiltInType == null) {
                TypeConstructor constructor = kotlinType.getConstructor();
                if (constructor instanceof IntersectionTypeConstructor) {
                    IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) constructor;
                    KotlinType alternativeType = intersectionTypeConstructor.getAlternativeType();
                    if (alternativeType == null) {
                        alternativeType = typeMappingConfiguration.commonSupertype(intersectionTypeConstructor.mo2215getSupertypes());
                    }
                    return (T) mapType(TypeUtilsKt.replaceArgumentsWithStarProjections(alternativeType), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
                }
                ClassifierDescriptor mo2214getDeclarationDescriptor = constructor.mo2214getDeclarationDescriptor();
                if (mo2214getDeclarationDescriptor != null) {
                    if (ErrorUtils.isError(mo2214getDeclarationDescriptor)) {
                        T t = (T) factory.createObjectType("error/NonExistentClass");
                        typeMappingConfiguration.processErrorType(kotlinType, (ClassDescriptor) mo2214getDeclarationDescriptor);
                        if (jvmDescriptorTypeWriter != 0) {
                            jvmDescriptorTypeWriter.writeClass(t);
                        }
                        return t;
                    }
                    boolean z = mo2214getDeclarationDescriptor instanceof ClassDescriptor;
                    if (z && KotlinBuiltIns.isArray(kotlinType)) {
                        if (kotlinType.getArguments().size() == 1) {
                            TypeProjection typeProjection = kotlinType.getArguments().get(0);
                            KotlinType type = typeProjection.getType();
                            m.f(type, "memberProjection.type");
                            if (typeProjection.getProjectionKind() == Variance.IN_VARIANCE) {
                                mapType = factory.createObjectType("java/lang/Object");
                                if (jvmDescriptorTypeWriter != 0) {
                                    jvmDescriptorTypeWriter.writeArrayType();
                                    jvmDescriptorTypeWriter.writeClass(mapType);
                                    jvmDescriptorTypeWriter.writeArrayEnd();
                                }
                            } else {
                                if (jvmDescriptorTypeWriter != 0) {
                                    jvmDescriptorTypeWriter.writeArrayType();
                                }
                                Variance projectionKind = typeProjection.getProjectionKind();
                                m.f(projectionKind, "memberProjection.projectionKind");
                                mapType = mapType(type, factory, mode.toGenericArgumentMode(projectionKind, true), typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
                                if (jvmDescriptorTypeWriter != 0) {
                                    jvmDescriptorTypeWriter.writeArrayEnd();
                                }
                            }
                            return (T) factory.createFromString(m.o("[", factory.toString(mapType)));
                        }
                        throw new UnsupportedOperationException("arrays must have one type argument");
                    } else if (z) {
                        if (InlineClassesUtilsKt.isInlineClass(mo2214getDeclarationDescriptor) && !mode.getNeedInlineClassWrapping() && (kotlinType2 = (KotlinType) ExpandedTypeUtilsKt.computeExpandedTypeForInlineClass(simpleClassicTypeSystemContext, kotlinType)) != null) {
                            return (T) mapType(kotlinType2, factory, mode.wrapInlineClassesMode(), typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
                        }
                        if (mode.isForAnnotationParameter() && KotlinBuiltIns.isKClass((ClassDescriptor) mo2214getDeclarationDescriptor)) {
                            obj = (Object) factory.getJavaLangClassType();
                        } else {
                            ClassDescriptor classDescriptor = (ClassDescriptor) mo2214getDeclarationDescriptor;
                            ClassDescriptor original = classDescriptor.getOriginal();
                            m.f(original, "descriptor.original");
                            T predefinedTypeForClass = typeMappingConfiguration.getPredefinedTypeForClass(original);
                            if (predefinedTypeForClass == null) {
                                if (classDescriptor.getKind() == ClassKind.ENUM_ENTRY) {
                                    classDescriptor = (ClassDescriptor) classDescriptor.getContainingDeclaration();
                                }
                                ClassDescriptor original2 = classDescriptor.getOriginal();
                                m.f(original2, "enumClassIfEnumEntry.original");
                                obj = (Object) factory.createObjectType(computeInternalName(original2, typeMappingConfiguration));
                            } else {
                                obj = (Object) predefinedTypeForClass;
                            }
                        }
                        writeGenericType.invoke(kotlinType, obj, mode);
                        return (T) obj;
                    } else if (mo2214getDeclarationDescriptor instanceof TypeParameterDescriptor) {
                        T t2 = (T) mapType(TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) mo2214getDeclarationDescriptor), factory, mode, typeMappingConfiguration, null, FunctionsKt.getDO_NOTHING_3());
                        if (jvmDescriptorTypeWriter != 0) {
                            Name name = mo2214getDeclarationDescriptor.getName();
                            m.f(name, "descriptor.getName()");
                            jvmDescriptorTypeWriter.writeTypeVariable(name, t2);
                        }
                        return t2;
                    } else if ((mo2214getDeclarationDescriptor instanceof TypeAliasDescriptor) && mode.getMapTypeAliases()) {
                        return (T) mapType(((TypeAliasDescriptor) mo2214getDeclarationDescriptor).getExpandedType(), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
                    } else {
                        throw new UnsupportedOperationException(m.o("Unknown type ", kotlinType));
                    }
                }
                throw new UnsupportedOperationException(m.o("no descriptor for type constructor of ", kotlinType));
            }
            ?? r9 = (Object) TypeSignatureMappingKt.boxTypeIfNeeded(factory, mapBuiltInType, mode.getNeedPrimitiveBoxing());
            writeGenericType.invoke(kotlinType, r9, mode);
            return r9;
        }
        return (T) mapType(preprocessType, factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
    }

    public static /* synthetic */ Object mapType$default(KotlinType kotlinType, JvmTypeFactory jvmTypeFactory, TypeMappingMode typeMappingMode, TypeMappingConfiguration typeMappingConfiguration, JvmDescriptorTypeWriter jvmDescriptorTypeWriter, q qVar, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            qVar = FunctionsKt.getDO_NOTHING_3();
        }
        return mapType(kotlinType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, qVar);
    }
}