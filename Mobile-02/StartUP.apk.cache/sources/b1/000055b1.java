package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import kotlin.jvm.internal.m;

/* compiled from: javaElements.kt */
/* loaded from: classes3.dex */
public interface JavaMethod extends JavaMember, JavaTypeParameterListOwner {

    /* compiled from: javaElements.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static boolean getHasAnnotationParameterDefaultValue(JavaMethod javaMethod) {
            m.g(javaMethod, "this");
            return javaMethod.getAnnotationParameterDefaultValue() != null;
        }
    }

    JavaAnnotationArgument getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    JavaType getReturnType();

    List<JavaValueParameter> getValueParameters();
}