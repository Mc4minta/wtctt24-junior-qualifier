package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.m0;
import kotlin.a0.s;
import kotlin.e0.c.p;
import kotlin.j0.c;
import kotlin.j0.q;
import kotlin.j0.v;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;
import kotlin.l0.x;
import kotlin.o;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.u;
import org.spongycastle.pqc.math.linearalgebra.Matrix;

/* compiled from: util.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a/\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a5\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000f\u001a\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\u00020\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015*\u00020\u0014H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0016*\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a!\u0010\u001e\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010!\u001a\u0004\u0018\u00010 *\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001b\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#*\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0004\b$\u0010%\u001a\u001b\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010&*\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0004\b'\u0010(\u001a\u0019\u0010+\u001a\u0004\u0018\u00010\u001d2\u0006\u0010*\u001a\u00020)H\u0000¢\u0006\u0004\b+\u0010,\u001ak\u0010<\u001a\u0004\u0018\u00018\u0001\"\b\b\u0000\u0010.*\u00020-\"\b\b\u0001\u00100*\u00020/2\n\u00101\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u00102\u001a\u00028\u00002\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u0002072\u0018\u0010;\u001a\u0014\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109H\u0000¢\u0006\u0004\b<\u0010=\u001a'\u0010A\u001a\u00028\u0000\"\u0004\b\u0000\u0010>2\f\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000?H\u0080\bø\u0001\u0000¢\u0006\u0004\bA\u0010B\"\u001a\u0010E\u001a\u00020D*\u00020C8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F\"\u001c\u0010H\u001a\u00020G8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u001c\u0010O\u001a\u0004\u0018\u00010L*\u00020/8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006P"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "Ljava/lang/Class;", "toJavaClass", "(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Ljava/lang/Class;", "Ljava/lang/ClassLoader;", "classLoader", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "kotlinClassId", "", "arrayDimensions", "loadClass", "(Ljava/lang/ClassLoader;Lkotlin/reflect/jvm/internal/impl/name/ClassId;I)Ljava/lang/Class;", "", "packageName", "className", "(Ljava/lang/ClassLoader;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "Lkotlin/j0/v;", "toKVisibility", "(Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;)Lkotlin/j0/v;", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "", "", "computeAnnotations", "(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;)Ljava/util/List;", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toAnnotationInstance", "(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;)Ljava/lang/annotation/Annotation;", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "", "toRuntimeValue", "(Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;Ljava/lang/ClassLoader;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKFunctionImpl", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "asKPropertyImpl", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/KPropertyImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "asKCallableImpl", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "Ljava/lang/reflect/Type;", "type", "defaultPrimitiveValue", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "M", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "D", "moduleAnchor", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "metadataVersion", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "createDescriptor", "deserializeToDescriptor", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/e0/c/p;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "R", "Lkotlin/Function0;", "block", "reflectionCall", "(Lkotlin/e0/c/a;)Ljava/lang/Object;", "Lkotlin/j0/q;", "", "isInlineClassType", "(Lkotlin/j0/q;)Z", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "instanceReceiverParameter", "kotlin-reflection"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class UtilKt {
    private static final FqName JVM_STATIC = new FqName("kotlin.jvm.JvmStatic");

    public static final KCallableImpl<?> asKCallableImpl(Object obj) {
        KCallableImpl<?> kCallableImpl = (KCallableImpl) (!(obj instanceof KCallableImpl) ? null : obj);
        if (kCallableImpl == null) {
            kCallableImpl = asKFunctionImpl(obj);
        }
        return kCallableImpl != null ? kCallableImpl : asKPropertyImpl(obj);
    }

    public static final KFunctionImpl asKFunctionImpl(Object obj) {
        KFunctionImpl kFunctionImpl = (KFunctionImpl) (!(obj instanceof KFunctionImpl) ? null : obj);
        if (kFunctionImpl != null) {
            return kFunctionImpl;
        }
        if (!(obj instanceof j)) {
            obj = null;
        }
        j jVar = (j) obj;
        c compute = jVar != null ? jVar.compute() : null;
        return compute instanceof KFunctionImpl ? compute : null;
    }

    public static final KPropertyImpl<?> asKPropertyImpl(Object obj) {
        KPropertyImpl<?> kPropertyImpl = (KPropertyImpl) (!(obj instanceof KPropertyImpl) ? null : obj);
        if (kPropertyImpl != null) {
            return kPropertyImpl;
        }
        if (!(obj instanceof z)) {
            obj = null;
        }
        z zVar = (z) obj;
        c compute = zVar != null ? zVar.compute() : null;
        return compute instanceof KPropertyImpl ? compute : null;
    }

    public static final List<Annotation> computeAnnotations(Annotated computeAnnotations) {
        m.g(computeAnnotations, "$this$computeAnnotations");
        Annotations annotations = computeAnnotations.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotations) {
            SourceElement source = annotationDescriptor.getSource();
            Annotation annotation = null;
            if (source instanceof ReflectAnnotationSource) {
                annotation = ((ReflectAnnotationSource) source).getAnnotation();
            } else if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
                ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
                if (!(javaElement instanceof ReflectJavaAnnotation)) {
                    javaElement = null;
                }
                ReflectJavaAnnotation reflectJavaAnnotation = (ReflectJavaAnnotation) javaElement;
                if (reflectJavaAnnotation != null) {
                    annotation = reflectJavaAnnotation.getAnnotation();
                }
            } else {
                annotation = toAnnotationInstance(annotationDescriptor);
            }
            if (annotation != null) {
                arrayList.add(annotation);
            }
        }
        return arrayList;
    }

    public static final Object defaultPrimitiveValue(Type type) {
        m.g(type, "type");
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            if (m.c(type, Boolean.TYPE)) {
                return Boolean.FALSE;
            }
            if (m.c(type, Character.TYPE)) {
                return Character.valueOf((char) 0);
            }
            if (m.c(type, Byte.TYPE)) {
                return Byte.valueOf((byte) 0);
            }
            if (m.c(type, Short.TYPE)) {
                return Short.valueOf((short) 0);
            }
            if (m.c(type, Integer.TYPE)) {
                return 0;
            }
            if (m.c(type, Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (m.c(type, Long.TYPE)) {
                return 0L;
            }
            if (m.c(type, Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            if (m.c(type, Void.TYPE)) {
                throw new IllegalStateException("Parameter with void type is illegal");
            }
            throw new UnsupportedOperationException("Unknown primitive: " + type);
        }
        return null;
    }

    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(Class<?> moduleAnchor, M proto, NameResolver nameResolver, TypeTable typeTable, BinaryVersion metadataVersion, p<? super MemberDeserializer, ? super M, ? extends D> createDescriptor) {
        List<ProtoBuf.TypeParameter> typeParameterList;
        m.g(moduleAnchor, "moduleAnchor");
        m.g(proto, "proto");
        m.g(nameResolver, "nameResolver");
        m.g(typeTable, "typeTable");
        m.g(metadataVersion, "metadataVersion");
        m.g(createDescriptor, "createDescriptor");
        RuntimeModuleData orCreateModule = ModuleByClassLoaderKt.getOrCreateModule(moduleAnchor);
        if (proto instanceof ProtoBuf.Function) {
            typeParameterList = ((ProtoBuf.Function) proto).getTypeParameterList();
        } else if (!(proto instanceof ProtoBuf.Property)) {
            throw new IllegalStateException(("Unsupported message: " + proto).toString());
        } else {
            typeParameterList = ((ProtoBuf.Property) proto).getTypeParameterList();
        }
        List<ProtoBuf.TypeParameter> typeParameters = typeParameterList;
        DeserializationComponents deserialization = orCreateModule.getDeserialization();
        ModuleDescriptor module = orCreateModule.getModule();
        VersionRequirementTable empty = VersionRequirementTable.Companion.getEMPTY();
        m.f(typeParameters, "typeParameters");
        return createDescriptor.invoke(new MemberDeserializer(new DeserializationContext(deserialization, nameResolver, module, typeTable, empty, metadataVersion, null, null, typeParameters)), proto);
    }

    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(CallableDescriptor instanceReceiverParameter) {
        m.g(instanceReceiverParameter, "$this$instanceReceiverParameter");
        if (instanceReceiverParameter.getDispatchReceiverParameter() != null) {
            DeclarationDescriptor containingDeclaration = instanceReceiverParameter.getContainingDeclaration();
            Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return ((ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
        }
        return null;
    }

    public static final FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    public static final boolean isInlineClassType(q isInlineClassType) {
        KotlinType type;
        m.g(isInlineClassType, "$this$isInlineClassType");
        if (!(isInlineClassType instanceof KTypeImpl)) {
            isInlineClassType = null;
        }
        KTypeImpl kTypeImpl = (KTypeImpl) isInlineClassType;
        return (kTypeImpl == null || (type = kTypeImpl.getType()) == null || !InlineClassesUtilsKt.isInlineClassType(type)) ? false : true;
    }

    private static final Class<?> loadClass(ClassLoader classLoader, ClassId classId, int i2) {
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        m.f(unsafe, "kotlinClassId.asSingleFqName().toUnsafe()");
        ClassId mapKotlinToJava = javaToKotlinClassMap.mapKotlinToJava(unsafe);
        if (mapKotlinToJava != null) {
            classId = mapKotlinToJava;
        }
        String asString = classId.getPackageFqName().asString();
        m.f(asString, "javaClassId.packageFqName.asString()");
        String asString2 = classId.getRelativeClassName().asString();
        m.f(asString2, "javaClassId.relativeClassName.asString()");
        return loadClass(classLoader, asString, asString2, i2);
    }

    static /* synthetic */ Class loadClass$default(ClassLoader classLoader, ClassId classId, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return loadClass(classLoader, classId, i2);
    }

    private static final Annotation toAnnotationInstance(AnnotationDescriptor annotationDescriptor) {
        Map r;
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        Class<?> javaClass = annotationClass != null ? toJavaClass(annotationClass) : null;
        if (!(javaClass instanceof Class)) {
            javaClass = null;
        }
        if (javaClass != null) {
            Set<Map.Entry<Name, ConstantValue<?>>> entrySet = annotationDescriptor.getAllValueArguments().entrySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Name name = (Name) entry.getKey();
                ClassLoader classLoader = javaClass.getClassLoader();
                m.f(classLoader, "annotationClass.classLoader");
                Object runtimeValue = toRuntimeValue((ConstantValue) entry.getValue(), classLoader);
                o a = runtimeValue != null ? u.a(name.asString(), runtimeValue) : null;
                if (a != null) {
                    arrayList.add(a);
                }
            }
            r = m0.r(arrayList);
            return (Annotation) AnnotationConstructorCallerKt.createAnnotationInstance$default(javaClass, r, null, 4, null);
        }
        return null;
    }

    public static final Class<?> toJavaClass(ClassDescriptor toJavaClass) {
        m.g(toJavaClass, "$this$toJavaClass");
        SourceElement source = toJavaClass.getSource();
        m.f(source, "source");
        if (source instanceof KotlinJvmBinarySourceElement) {
            KotlinJvmBinaryClass binaryClass = ((KotlinJvmBinarySourceElement) source).getBinaryClass();
            Objects.requireNonNull(binaryClass, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((ReflectKotlinClass) binaryClass).getKlass();
        } else if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
            ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
            Objects.requireNonNull(javaElement, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((ReflectJavaClass) javaElement).getElement();
        } else {
            ClassId classId = DescriptorUtilsKt.getClassId(toJavaClass);
            if (classId != null) {
                return loadClass(ReflectClassUtilKt.getSafeClassLoader(toJavaClass.getClass()), classId, 0);
            }
            return null;
        }
    }

    public static final v toKVisibility(DescriptorVisibility toKVisibility) {
        m.g(toKVisibility, "$this$toKVisibility");
        if (m.c(toKVisibility, DescriptorVisibilities.PUBLIC)) {
            return v.PUBLIC;
        }
        if (m.c(toKVisibility, DescriptorVisibilities.PROTECTED)) {
            return v.PROTECTED;
        }
        if (m.c(toKVisibility, DescriptorVisibilities.INTERNAL)) {
            return v.INTERNAL;
        }
        if (m.c(toKVisibility, DescriptorVisibilities.PRIVATE) || m.c(toKVisibility, DescriptorVisibilities.PRIVATE_TO_THIS)) {
            return v.PRIVATE;
        }
        return null;
    }

    private static final Object toRuntimeValue(ConstantValue<?> constantValue, ClassLoader classLoader) {
        int r;
        if (constantValue instanceof AnnotationValue) {
            return toAnnotationInstance(((AnnotationValue) constantValue).getValue());
        }
        if (constantValue instanceof ArrayValue) {
            List<? extends ConstantValue<?>> value = ((ArrayValue) constantValue).getValue();
            r = s.r(value, 10);
            ArrayList arrayList = new ArrayList(r);
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList.add(toRuntimeValue((ConstantValue) it.next(), classLoader));
            }
            Object[] array = arrayList.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return array;
        } else if (constantValue instanceof EnumValue) {
            o<? extends ClassId, ? extends Name> value2 = ((EnumValue) constantValue).getValue();
            Name b2 = value2.b();
            Class loadClass$default = loadClass$default(classLoader, value2.a(), 0, 4, null);
            if (loadClass$default != null) {
                return Util.getEnumConstantByName(loadClass$default, b2.asString());
            }
            return null;
        } else if (constantValue instanceof KClassValue) {
            KClassValue.Value value3 = ((KClassValue) constantValue).getValue();
            if (value3 instanceof KClassValue.Value.NormalClass) {
                KClassValue.Value.NormalClass normalClass = (KClassValue.Value.NormalClass) value3;
                return loadClass(classLoader, normalClass.getClassId(), normalClass.getArrayDimensions());
            } else if (value3 instanceof KClassValue.Value.LocalClass) {
                ClassifierDescriptor mo2214getDeclarationDescriptor = ((KClassValue.Value.LocalClass) value3).getType().getConstructor().mo2214getDeclarationDescriptor();
                if (!(mo2214getDeclarationDescriptor instanceof ClassDescriptor)) {
                    mo2214getDeclarationDescriptor = null;
                }
                ClassDescriptor classDescriptor = (ClassDescriptor) mo2214getDeclarationDescriptor;
                if (classDescriptor != null) {
                    return toJavaClass(classDescriptor);
                }
                return null;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if ((constantValue instanceof ErrorValue) || (constantValue instanceof NullValue)) {
            return null;
        } else {
            return constantValue.getValue();
        }
    }

    private static final Class<?> loadClass(ClassLoader classLoader, String str, String str2, int i2) {
        String J;
        String G;
        if (m.c(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('.');
        J = x.J(str2, '.', '$', false, 4, null);
        sb.append(J);
        String sb2 = sb.toString();
        if (i2 > 0) {
            StringBuilder sb3 = new StringBuilder();
            G = x.G("[", i2);
            sb3.append(G);
            sb3.append(Matrix.MATRIX_TYPE_RANDOM_LT);
            sb3.append(sb2);
            sb3.append(';');
            sb2 = sb3.toString();
        }
        return ReflectJavaClassFinderKt.tryLoadClass(classLoader, sb2);
    }
}