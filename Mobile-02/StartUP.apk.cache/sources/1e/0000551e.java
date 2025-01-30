package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.coinbase.ApiConstants;
import java.util.Map;
import kotlin.a0.m0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.u;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes3.dex */
public final class JavaAnnotationMapper {
    private static final Name DEPRECATED_ANNOTATION_MESSAGE;
    public static final JavaAnnotationMapper INSTANCE = new JavaAnnotationMapper();
    private static final Name RETENTION_ANNOTATION_VALUE;
    private static final Name TARGET_ANNOTATION_ALLOWED_TARGETS;
    private static final Map<FqName, FqName> javaToKotlinNameMap;
    private static final Map<FqName, FqName> kotlinToJavaNameMap;

    static {
        Map<FqName, FqName> l2;
        Map<FqName, FqName> l3;
        Name identifier = Name.identifier(ApiConstants.MESSAGE);
        m.f(identifier, "identifier(\"message\")");
        DEPRECATED_ANNOTATION_MESSAGE = identifier;
        Name identifier2 = Name.identifier("allowedTargets");
        m.f(identifier2, "identifier(\"allowedTargets\")");
        TARGET_ANNOTATION_ALLOWED_TARGETS = identifier2;
        Name identifier3 = Name.identifier("value");
        m.f(identifier3, "identifier(\"value\")");
        RETENTION_ANNOTATION_VALUE = identifier3;
        FqName fqName = StandardNames.FqNames.target;
        FqName fqName2 = JvmAnnotationNames.TARGET_ANNOTATION;
        FqName fqName3 = StandardNames.FqNames.retention;
        FqName fqName4 = JvmAnnotationNames.RETENTION_ANNOTATION;
        FqName fqName5 = StandardNames.FqNames.repeatable;
        FqName fqName6 = JvmAnnotationNames.REPEATABLE_ANNOTATION;
        FqName fqName7 = StandardNames.FqNames.mustBeDocumented;
        FqName fqName8 = JvmAnnotationNames.DOCUMENTED_ANNOTATION;
        l2 = m0.l(u.a(fqName, fqName2), u.a(fqName3, fqName4), u.a(fqName5, fqName6), u.a(fqName7, fqName8));
        kotlinToJavaNameMap = l2;
        l3 = m0.l(u.a(fqName2, fqName), u.a(fqName4, fqName3), u.a(JvmAnnotationNames.DEPRECATED_ANNOTATION, StandardNames.FqNames.deprecated), u.a(fqName6, fqName5), u.a(fqName8, fqName7));
        javaToKotlinNameMap = l3;
    }

    private JavaAnnotationMapper() {
    }

    public static /* synthetic */ AnnotationDescriptor mapOrResolveJavaAnnotation$default(JavaAnnotationMapper javaAnnotationMapper, JavaAnnotation javaAnnotation, LazyJavaResolverContext lazyJavaResolverContext, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return javaAnnotationMapper.mapOrResolveJavaAnnotation(javaAnnotation, lazyJavaResolverContext, z);
    }

    public final AnnotationDescriptor findMappedJavaAnnotation(FqName kotlinName, JavaAnnotationOwner annotationOwner, LazyJavaResolverContext c2) {
        JavaAnnotation findAnnotation;
        m.g(kotlinName, "kotlinName");
        m.g(annotationOwner, "annotationOwner");
        m.g(c2, "c");
        if (m.c(kotlinName, StandardNames.FqNames.deprecated)) {
            FqName DEPRECATED_ANNOTATION = JvmAnnotationNames.DEPRECATED_ANNOTATION;
            m.f(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
            JavaAnnotation findAnnotation2 = annotationOwner.findAnnotation(DEPRECATED_ANNOTATION);
            if (findAnnotation2 != null || annotationOwner.isDeprecatedInJavaDoc()) {
                return new JavaDeprecatedAnnotationDescriptor(findAnnotation2, c2);
            }
        }
        FqName fqName = kotlinToJavaNameMap.get(kotlinName);
        if (fqName == null || (findAnnotation = annotationOwner.findAnnotation(fqName)) == null) {
            return null;
        }
        return mapOrResolveJavaAnnotation$default(this, findAnnotation, c2, false, 4, null);
    }

    public final Name getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm() {
        return DEPRECATED_ANNOTATION_MESSAGE;
    }

    public final Name getRETENTION_ANNOTATION_VALUE$descriptors_jvm() {
        return RETENTION_ANNOTATION_VALUE;
    }

    public final Name getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm() {
        return TARGET_ANNOTATION_ALLOWED_TARGETS;
    }

    public final AnnotationDescriptor mapOrResolveJavaAnnotation(JavaAnnotation annotation, LazyJavaResolverContext c2, boolean z) {
        m.g(annotation, "annotation");
        m.g(c2, "c");
        ClassId classId = annotation.getClassId();
        if (m.c(classId, ClassId.topLevel(JvmAnnotationNames.TARGET_ANNOTATION))) {
            return new JavaTargetAnnotationDescriptor(annotation, c2);
        }
        if (m.c(classId, ClassId.topLevel(JvmAnnotationNames.RETENTION_ANNOTATION))) {
            return new JavaRetentionAnnotationDescriptor(annotation, c2);
        }
        if (m.c(classId, ClassId.topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION))) {
            return new JavaAnnotationDescriptor(c2, annotation, StandardNames.FqNames.repeatable);
        }
        if (m.c(classId, ClassId.topLevel(JvmAnnotationNames.DOCUMENTED_ANNOTATION))) {
            return new JavaAnnotationDescriptor(c2, annotation, StandardNames.FqNames.mustBeDocumented);
        }
        if (m.c(classId, ClassId.topLevel(JvmAnnotationNames.DEPRECATED_ANNOTATION))) {
            return null;
        }
        return new LazyJavaAnnotationDescriptor(c2, annotation, z);
    }
}