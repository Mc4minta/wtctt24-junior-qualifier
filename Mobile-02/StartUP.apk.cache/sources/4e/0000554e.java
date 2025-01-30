package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* compiled from: resolvers.kt */
/* loaded from: classes3.dex */
public interface TypeParameterResolver {

    /* compiled from: resolvers.kt */
    /* loaded from: classes3.dex */
    public static final class EMPTY implements TypeParameterResolver {
        public static final EMPTY INSTANCE = new EMPTY();

        private EMPTY() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
        public TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter javaTypeParameter) {
            m.g(javaTypeParameter, "javaTypeParameter");
            return null;
        }
    }

    TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter javaTypeParameter);
}