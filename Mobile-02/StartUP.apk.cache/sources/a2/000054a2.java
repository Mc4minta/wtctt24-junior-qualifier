package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;
import kotlin.a0.j;
import kotlin.e0.a;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReflectKotlinClass.kt */
/* loaded from: classes3.dex */
public final class ReflectClassStructure {
    public static final ReflectClassStructure INSTANCE = new ReflectClassStructure();

    private ReflectClassStructure() {
    }

    private final ClassLiteralValue classLiteralValue(Class<?> cls) {
        int i2 = 0;
        while (cls.isArray()) {
            i2++;
            cls = cls.getComponentType();
            m.f(cls, "currentClass.componentType");
        }
        if (cls.isPrimitive()) {
            if (m.c(cls, Void.TYPE)) {
                ClassId classId = ClassId.topLevel(StandardNames.FqNames.unit.toSafe());
                m.f(classId, "topLevel(StandardNames.FqNames.unit.toSafe())");
                return new ClassLiteralValue(classId, i2);
            }
            PrimitiveType primitiveType = JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
            m.f(primitiveType, "get(currentClass.name).primitiveType");
            if (i2 > 0) {
                ClassId classId2 = ClassId.topLevel(primitiveType.getArrayTypeFqName());
                m.f(classId2, "topLevel(primitiveType.arrayTypeFqName)");
                return new ClassLiteralValue(classId2, i2 - 1);
            }
            ClassId classId3 = ClassId.topLevel(primitiveType.getTypeFqName());
            m.f(classId3, "topLevel(primitiveType.typeFqName)");
            return new ClassLiteralValue(classId3, i2);
        }
        ClassId classId4 = ReflectClassUtilKt.getClassId(cls);
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqName asSingleFqName = classId4.asSingleFqName();
        m.f(asSingleFqName, "javaClassId.asSingleFqName()");
        ClassId mapJavaToKotlin = javaToKotlinClassMap.mapJavaToKotlin(asSingleFqName);
        if (mapJavaToKotlin != null) {
            classId4 = mapJavaToKotlin;
        }
        return new ClassLiteralValue(classId4, i2);
    }

    private final void loadConstructorAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Constructor<?>[] constructorArr;
        int i2;
        int i3;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        m.f(declaredConstructors, "klass.declaredConstructors");
        int length = declaredConstructors.length;
        int i4 = 0;
        while (i4 < length) {
            Constructor<?> constructor = declaredConstructors[i4];
            int i5 = i4 + 1;
            Name special = Name.special("<init>");
            m.f(special, "special(\"<init>\")");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            m.f(constructor, "constructor");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(special, signatureSerializer.constructorDesc(constructor));
            if (visitMethod == null) {
                constructorArr = declaredConstructors;
                i2 = length;
                i3 = i5;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                m.f(declaredAnnotations, "constructor.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i6 = 0;
                while (i6 < length2) {
                    Annotation annotation = declaredAnnotations[i6];
                    i6++;
                    m.f(annotation, "annotation");
                    processAnnotation(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                m.f(parameterAnnotations, "parameterAnnotations");
                if (!(parameterAnnotations.length == 0)) {
                    int length3 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length4 = parameterAnnotations.length;
                    int i7 = 0;
                    while (i7 < length4) {
                        Annotation[] annotations = parameterAnnotations[i7];
                        int i8 = i7 + 1;
                        m.f(annotations, "annotations");
                        int length5 = annotations.length;
                        int i9 = 0;
                        while (i9 < length5) {
                            Annotation annotation2 = annotations[i9];
                            i9++;
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            Class<?> b2 = a.b(a.a(annotation2));
                            int i10 = length;
                            int i11 = i5;
                            ClassId classId = ReflectClassUtilKt.getClassId(b2);
                            int i12 = length3;
                            m.f(annotation2, "annotation");
                            KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i7 + length3, classId, new ReflectAnnotationSource(annotation2));
                            if (visitParameterAnnotation != null) {
                                processAnnotationArguments(visitParameterAnnotation, annotation2, b2);
                            }
                            length = i10;
                            declaredConstructors = constructorArr2;
                            i5 = i11;
                            length3 = i12;
                        }
                        i7 = i8;
                    }
                }
                constructorArr = declaredConstructors;
                i2 = length;
                i3 = i5;
                visitMethod.visitEnd();
            }
            length = i2;
            declaredConstructors = constructorArr;
            i4 = i3;
        }
    }

    private final void loadFieldAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Field[] declaredFields = cls.getDeclaredFields();
        m.f(declaredFields, "klass.declaredFields");
        int length = declaredFields.length;
        int i2 = 0;
        while (i2 < length) {
            Field field = declaredFields[i2];
            i2++;
            Name identifier = Name.identifier(field.getName());
            m.f(identifier, "identifier(field.name)");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            m.f(field, "field");
            KotlinJvmBinaryClass.AnnotationVisitor visitField = memberVisitor.visitField(identifier, signatureSerializer.fieldDesc(field), null);
            if (visitField != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                m.f(declaredAnnotations, "field.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i3 = 0;
                while (i3 < length2) {
                    Annotation annotation = declaredAnnotations[i3];
                    i3++;
                    m.f(annotation, "annotation");
                    processAnnotation(visitField, annotation);
                }
                visitField.visitEnd();
            }
        }
    }

    private final void loadMethodAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Method[] methodArr;
        int i2;
        Method[] declaredMethods = cls.getDeclaredMethods();
        m.f(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i3 = 0;
        while (i3 < length) {
            Method method = declaredMethods[i3];
            i3++;
            Name identifier = Name.identifier(method.getName());
            m.f(identifier, "identifier(method.name)");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            m.f(method, "method");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(identifier, signatureSerializer.methodDesc(method));
            if (visitMethod == null) {
                methodArr = declaredMethods;
                i2 = length;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                m.f(declaredAnnotations, "method.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i4 = 0;
                while (i4 < length2) {
                    Annotation annotation = declaredAnnotations[i4];
                    i4++;
                    m.f(annotation, "annotation");
                    processAnnotation(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                m.f(parameterAnnotations, "method.parameterAnnotations");
                int length3 = parameterAnnotations.length;
                int i5 = 0;
                while (i5 < length3) {
                    Annotation[] annotations = parameterAnnotations[i5];
                    int i6 = i5 + 1;
                    m.f(annotations, "annotations");
                    int length4 = annotations.length;
                    int i7 = 0;
                    while (i7 < length4) {
                        Annotation annotation2 = annotations[i7];
                        i7++;
                        Class<?> b2 = a.b(a.a(annotation2));
                        Method[] methodArr2 = declaredMethods;
                        ClassId classId = ReflectClassUtilKt.getClassId(b2);
                        int i8 = length;
                        m.f(annotation2, "annotation");
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i5, classId, new ReflectAnnotationSource(annotation2));
                        if (visitParameterAnnotation != null) {
                            processAnnotationArguments(visitParameterAnnotation, annotation2, b2);
                        }
                        declaredMethods = methodArr2;
                        length = i8;
                    }
                    i5 = i6;
                }
                methodArr = declaredMethods;
                i2 = length;
                visitMethod.visitEnd();
            }
            declaredMethods = methodArr;
            length = i2;
        }
    }

    private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, Annotation annotation) {
        Class<?> b2 = a.b(a.a(annotation));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationVisitor.visitAnnotation(ReflectClassUtilKt.getClassId(b2), new ReflectAnnotationSource(annotation));
        if (visitAnnotation == null) {
            return;
        }
        processAnnotationArguments(visitAnnotation, annotation, b2);
    }

    private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Name name, Object obj) {
        Set set;
        Class<?> cls = obj.getClass();
        if (!m.c(cls, Class.class)) {
            set = ReflectKotlinClassKt.TYPES_ELIGIBLE_FOR_SIMPLE_VISIT;
            if (set.contains(cls)) {
                annotationArgumentVisitor.visit(name, obj);
                return;
            } else if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(cls)) {
                if (!cls.isEnum()) {
                    cls = cls.getEnclosingClass();
                }
                m.f(cls, "if (clazz.isEnum) clazz else clazz.enclosingClass");
                ClassId classId = ReflectClassUtilKt.getClassId(cls);
                Name identifier = Name.identifier(((Enum) obj).name());
                m.f(identifier, "identifier((value as Enum<*>).name)");
                annotationArgumentVisitor.visitEnum(name, classId, identifier);
                return;
            } else if (Annotation.class.isAssignableFrom(cls)) {
                Class<?>[] interfaces = cls.getInterfaces();
                m.f(interfaces, "clazz.interfaces");
                Class<?> annotationClass = (Class) j.R(interfaces);
                m.f(annotationClass, "annotationClass");
                KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationArgumentVisitor.visitAnnotation(name, ReflectClassUtilKt.getClassId(annotationClass));
                if (visitAnnotation == null) {
                    return;
                }
                processAnnotationArguments(visitAnnotation, (Annotation) obj, annotationClass);
                return;
            } else if (cls.isArray()) {
                KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray = annotationArgumentVisitor.visitArray(name);
                if (visitArray == null) {
                    return;
                }
                Class<?> componentType = cls.getComponentType();
                int i2 = 0;
                if (componentType.isEnum()) {
                    m.f(componentType, "componentType");
                    ClassId classId2 = ReflectClassUtilKt.getClassId(componentType);
                    Object[] objArr = (Object[]) obj;
                    int length = objArr.length;
                    while (i2 < length) {
                        Object obj2 = objArr[i2];
                        i2++;
                        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                        Name identifier2 = Name.identifier(((Enum) obj2).name());
                        m.f(identifier2, "identifier((element as Enum<*>).name)");
                        visitArray.visitEnum(classId2, identifier2);
                    }
                } else if (m.c(componentType, Class.class)) {
                    Object[] objArr2 = (Object[]) obj;
                    int length2 = objArr2.length;
                    while (i2 < length2) {
                        Object obj3 = objArr2[i2];
                        i2++;
                        Objects.requireNonNull(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                        visitArray.visitClassLiteral(classLiteralValue((Class) obj3));
                    }
                } else {
                    Object[] objArr3 = (Object[]) obj;
                    int length3 = objArr3.length;
                    while (i2 < length3) {
                        Object obj4 = objArr3[i2];
                        i2++;
                        visitArray.visit(obj4);
                    }
                }
                visitArray.visitEnd();
                return;
            } else {
                throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
            }
        }
        annotationArgumentVisitor.visitClassLiteral(name, classLiteralValue((Class) obj));
    }

    private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        m.f(declaredMethods, "annotationType.declaredMethods");
        int length = declaredMethods.length;
        int i2 = 0;
        while (i2 < length) {
            Method method = declaredMethods[i2];
            i2++;
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                m.e(invoke);
                Name identifier = Name.identifier(method.getName());
                m.f(identifier, "identifier(method.name)");
                processAnnotationArgumentValue(annotationArgumentVisitor, identifier, invoke);
            } catch (IllegalAccessException unused) {
            }
        }
        annotationArgumentVisitor.visitEnd();
    }

    public final void loadClassAnnotations(Class<?> klass, KotlinJvmBinaryClass.AnnotationVisitor visitor) {
        m.g(klass, "klass");
        m.g(visitor, "visitor");
        Annotation[] declaredAnnotations = klass.getDeclaredAnnotations();
        m.f(declaredAnnotations, "klass.declaredAnnotations");
        int length = declaredAnnotations.length;
        int i2 = 0;
        while (i2 < length) {
            Annotation annotation = declaredAnnotations[i2];
            i2++;
            m.f(annotation, "annotation");
            processAnnotation(visitor, annotation);
        }
        visitor.visitEnd();
    }

    public final void visitMembers(Class<?> klass, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        m.g(klass, "klass");
        m.g(memberVisitor, "memberVisitor");
        loadMethodAnnotations(klass, memberVisitor);
        loadConstructorAnnotations(klass, memberVisitor);
        loadFieldAnnotations(klass, memberVisitor);
    }
}