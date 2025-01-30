package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectJavaAnnotationOwner.kt */
/* loaded from: classes3.dex */
public interface ReflectJavaAnnotationOwner extends JavaAnnotationOwner {

    /* compiled from: ReflectJavaAnnotationOwner.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static ReflectJavaAnnotation findAnnotation(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner, FqName fqName) {
            Annotation[] declaredAnnotations;
            m.g(reflectJavaAnnotationOwner, "this");
            m.g(fqName, "fqName");
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
                return null;
            }
            return ReflectJavaAnnotationOwnerKt.findAnnotation(declaredAnnotations, fqName);
        }

        public static List<ReflectJavaAnnotation> getAnnotations(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            List<ReflectJavaAnnotation> g2;
            m.g(reflectJavaAnnotationOwner, "this");
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            Annotation[] declaredAnnotations = element == null ? null : element.getDeclaredAnnotations();
            if (declaredAnnotations == null) {
                g2 = r.g();
                return g2;
            }
            return ReflectJavaAnnotationOwnerKt.getAnnotations(declaredAnnotations);
        }

        public static boolean isDeprecatedInJavaDoc(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            m.g(reflectJavaAnnotationOwner, "this");
            return false;
        }
    }

    AnnotatedElement getElement();
}