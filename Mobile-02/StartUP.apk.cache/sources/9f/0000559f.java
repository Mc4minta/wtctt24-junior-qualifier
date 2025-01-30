package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: javaElements.kt */
/* loaded from: classes3.dex */
public interface JavaAnnotation extends JavaElement {

    /* compiled from: javaElements.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static boolean isFreshlySupportedTypeUseAnnotation(JavaAnnotation javaAnnotation) {
            m.g(javaAnnotation, "this");
            return false;
        }

        public static boolean isIdeExternalAnnotation(JavaAnnotation javaAnnotation) {
            m.g(javaAnnotation, "this");
            return false;
        }
    }

    Collection<JavaAnnotationArgument> getArguments();

    ClassId getClassId();

    boolean isFreshlySupportedTypeUseAnnotation();

    boolean isIdeExternalAnnotation();

    JavaClass resolve();
}