package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;

/* compiled from: RuntimeTypeMapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u001a\u001a\u00020\u00192\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010!\u001a\u0004\u0018\u00010\u001e*\u0006\u0012\u0002\b\u00030\u00178B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "descriptor", "", "isKnownBuiltInFunction", "(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;)Z", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapJvmFunctionSignature", "(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;)Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "", "mapName", "(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;)Ljava/lang/String;", "possiblySubstitutedFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "mapSignature", "(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;)Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "mapPropertySignature", "(Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;)Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "Ljava/lang/Class;", "klass", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "mapJvmClassToKotlinClassId", "(Ljava/lang/Class;)Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "primitiveType", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class RuntimeTypeMapper {
    public static final RuntimeTypeMapper INSTANCE = new RuntimeTypeMapper();
    private static final ClassId JAVA_LANG_VOID;

    static {
        ClassId classId = ClassId.topLevel(new FqName("java.lang.Void"));
        m.f(classId, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
        JAVA_LANG_VOID = classId;
    }

    private RuntimeTypeMapper() {
    }

    private final PrimitiveType getPrimitiveType(Class<?> cls) {
        if (cls.isPrimitive()) {
            JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.get(cls.getSimpleName());
            m.f(jvmPrimitiveType, "JvmPrimitiveType.get(simpleName)");
            return jvmPrimitiveType.getPrimitiveType();
        }
        return null;
    }

    private final boolean isKnownBuiltInFunction(FunctionDescriptor functionDescriptor) {
        if (DescriptorFactory.isEnumValueOfMethod(functionDescriptor) || DescriptorFactory.isEnumValuesMethod(functionDescriptor)) {
            return true;
        }
        return m.c(functionDescriptor.getName(), CloneableClassScope.Companion.getCLONE_NAME()) && functionDescriptor.getValueParameters().isEmpty();
    }

    private final JvmFunctionSignature.KotlinFunction mapJvmFunctionSignature(FunctionDescriptor functionDescriptor) {
        return new JvmFunctionSignature.KotlinFunction(new JvmMemberSignature.Method(mapName(functionDescriptor), MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 1, null)));
    }

    private final String mapName(CallableMemberDescriptor callableMemberDescriptor) {
        String jvmMethodNameIfSpecial = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(callableMemberDescriptor);
        if (jvmMethodNameIfSpecial != null) {
            return jvmMethodNameIfSpecial;
        }
        if (callableMemberDescriptor instanceof PropertyGetterDescriptor) {
            String asString = DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor).getName().asString();
            m.f(asString, "descriptor.propertyIfAccessor.name.asString()");
            return JvmAbi.getterName(asString);
        } else if (callableMemberDescriptor instanceof PropertySetterDescriptor) {
            String asString2 = DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor).getName().asString();
            m.f(asString2, "descriptor.propertyIfAccessor.name.asString()");
            return JvmAbi.setterName(asString2);
        } else {
            String asString3 = callableMemberDescriptor.getName().asString();
            m.f(asString3, "descriptor.name.asString()");
            return asString3;
        }
    }

    public final ClassId mapJvmClassToKotlinClassId(Class<?> klass) {
        m.g(klass, "klass");
        if (klass.isArray()) {
            Class<?> componentType = klass.getComponentType();
            m.f(componentType, "klass.componentType");
            PrimitiveType primitiveType = getPrimitiveType(componentType);
            if (primitiveType != null) {
                return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, primitiveType.getArrayTypeName());
            }
            ClassId classId = ClassId.topLevel(StandardNames.FqNames.array.toSafe());
            m.f(classId, "ClassId.topLevel(Standar…s.FqNames.array.toSafe())");
            return classId;
        } else if (m.c(klass, Void.TYPE)) {
            return JAVA_LANG_VOID;
        } else {
            PrimitiveType primitiveType2 = getPrimitiveType(klass);
            if (primitiveType2 != null) {
                return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, primitiveType2.getTypeName());
            }
            ClassId classId2 = ReflectClassUtilKt.getClassId(klass);
            if (!classId2.isLocal()) {
                JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
                FqName asSingleFqName = classId2.asSingleFqName();
                m.f(asSingleFqName, "classId.asSingleFqName()");
                ClassId mapJavaToKotlin = javaToKotlinClassMap.mapJavaToKotlin(asSingleFqName);
                if (mapJavaToKotlin != null) {
                    return mapJavaToKotlin;
                }
            }
            return classId2;
        }
    }

    public final JvmPropertySignature mapPropertySignature(PropertyDescriptor possiblyOverriddenProperty) {
        m.g(possiblyOverriddenProperty, "possiblyOverriddenProperty");
        CallableMemberDescriptor unwrapFakeOverride = DescriptorUtils.unwrapFakeOverride(possiblyOverriddenProperty);
        m.f(unwrapFakeOverride, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
        PropertyDescriptor original = ((PropertyDescriptor) unwrapFakeOverride).getOriginal();
        m.f(original, "DescriptorUtils.unwrapFa…rriddenProperty).original");
        if (original instanceof DeserializedPropertyDescriptor) {
            DeserializedPropertyDescriptor deserializedPropertyDescriptor = (DeserializedPropertyDescriptor) original;
            ProtoBuf.Property proto = deserializedPropertyDescriptor.getProto();
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
            m.f(generatedExtension, "JvmProtoBuf.propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(proto, generatedExtension);
            if (jvmPropertySignature != null) {
                return new JvmPropertySignature.KotlinProperty(original, proto, jvmPropertySignature, deserializedPropertyDescriptor.getNameResolver(), deserializedPropertyDescriptor.getTypeTable());
            }
        } else if (original instanceof JavaPropertyDescriptor) {
            SourceElement source = ((JavaPropertyDescriptor) original).getSource();
            if (!(source instanceof JavaSourceElement)) {
                source = null;
            }
            JavaSourceElement javaSourceElement = (JavaSourceElement) source;
            JavaElement javaElement = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            if (javaElement instanceof ReflectJavaField) {
                return new JvmPropertySignature.JavaField(((ReflectJavaField) javaElement).getMember());
            }
            if (javaElement instanceof ReflectJavaMethod) {
                Method member = ((ReflectJavaMethod) javaElement).getMember();
                PropertySetterDescriptor setter = original.getSetter();
                SourceElement source2 = setter != null ? setter.getSource() : null;
                if (!(source2 instanceof JavaSourceElement)) {
                    source2 = null;
                }
                JavaSourceElement javaSourceElement2 = (JavaSourceElement) source2;
                JavaElement javaElement2 = javaSourceElement2 != null ? javaSourceElement2.getJavaElement() : null;
                if (!(javaElement2 instanceof ReflectJavaMethod)) {
                    javaElement2 = null;
                }
                ReflectJavaMethod reflectJavaMethod = (ReflectJavaMethod) javaElement2;
                return new JvmPropertySignature.JavaMethodProperty(member, reflectJavaMethod != null ? reflectJavaMethod.getMember() : null);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + original + " (source = " + javaElement + ')');
        }
        PropertyGetterDescriptor getter = original.getGetter();
        m.e(getter);
        JvmFunctionSignature.KotlinFunction mapJvmFunctionSignature = mapJvmFunctionSignature(getter);
        PropertySetterDescriptor setter2 = original.getSetter();
        return new JvmPropertySignature.MappedKotlinProperty(mapJvmFunctionSignature, setter2 != null ? mapJvmFunctionSignature(setter2) : null);
    }

    public final JvmFunctionSignature mapSignature(FunctionDescriptor possiblySubstitutedFunction) {
        Method member;
        JvmMemberSignature.Method jvmConstructorSignature;
        JvmMemberSignature.Method jvmMethodSignature;
        m.g(possiblySubstitutedFunction, "possiblySubstitutedFunction");
        CallableMemberDescriptor unwrapFakeOverride = DescriptorUtils.unwrapFakeOverride(possiblySubstitutedFunction);
        m.f(unwrapFakeOverride, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
        FunctionDescriptor original = ((FunctionDescriptor) unwrapFakeOverride).getOriginal();
        m.f(original, "DescriptorUtils.unwrapFa…titutedFunction).original");
        if (original instanceof DeserializedCallableMemberDescriptor) {
            DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor = (DeserializedCallableMemberDescriptor) original;
            MessageLite proto = deserializedCallableMemberDescriptor.getProto();
            if ((proto instanceof ProtoBuf.Function) && (jvmMethodSignature = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) proto, deserializedCallableMemberDescriptor.getNameResolver(), deserializedCallableMemberDescriptor.getTypeTable())) != null) {
                return new JvmFunctionSignature.KotlinFunction(jvmMethodSignature);
            }
            if ((proto instanceof ProtoBuf.Constructor) && (jvmConstructorSignature = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor) proto, deserializedCallableMemberDescriptor.getNameResolver(), deserializedCallableMemberDescriptor.getTypeTable())) != null) {
                DeclarationDescriptor containingDeclaration = possiblySubstitutedFunction.getContainingDeclaration();
                m.f(containingDeclaration, "possiblySubstitutedFunction.containingDeclaration");
                if (InlineClassesUtilsKt.isInlineClass(containingDeclaration)) {
                    return new JvmFunctionSignature.KotlinFunction(jvmConstructorSignature);
                }
                return new JvmFunctionSignature.KotlinConstructor(jvmConstructorSignature);
            }
            return mapJvmFunctionSignature(original);
        }
        if (original instanceof JavaMethodDescriptor) {
            SourceElement source = ((JavaMethodDescriptor) original).getSource();
            if (!(source instanceof JavaSourceElement)) {
                source = null;
            }
            JavaSourceElement javaSourceElement = (JavaSourceElement) source;
            JavaElement javaElement = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            ReflectJavaMethod reflectJavaMethod = (ReflectJavaMethod) (javaElement instanceof ReflectJavaMethod ? javaElement : null);
            if (reflectJavaMethod != null && (member = reflectJavaMethod.getMember()) != null) {
                return new JvmFunctionSignature.JavaMethod(member);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + original);
        } else if (original instanceof JavaClassConstructorDescriptor) {
            SourceElement source2 = ((JavaClassConstructorDescriptor) original).getSource();
            if (!(source2 instanceof JavaSourceElement)) {
                source2 = null;
            }
            JavaSourceElement javaSourceElement2 = (JavaSourceElement) source2;
            JavaElement javaElement2 = javaSourceElement2 != null ? javaSourceElement2.getJavaElement() : null;
            if (javaElement2 instanceof ReflectJavaConstructor) {
                return new JvmFunctionSignature.JavaConstructor(((ReflectJavaConstructor) javaElement2).getMember());
            }
            if (javaElement2 instanceof ReflectJavaClass) {
                ReflectJavaClass reflectJavaClass = (ReflectJavaClass) javaElement2;
                if (reflectJavaClass.isAnnotationType()) {
                    return new JvmFunctionSignature.FakeJavaAnnotationConstructor(reflectJavaClass.getElement());
                }
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + original + " (" + javaElement2 + ')');
        } else if (isKnownBuiltInFunction(original)) {
            return mapJvmFunctionSignature(original);
        } else {
            throw new KotlinReflectionInternalError("Unknown origin of " + original + " (" + original.getClass() + ')');
        }
    }
}