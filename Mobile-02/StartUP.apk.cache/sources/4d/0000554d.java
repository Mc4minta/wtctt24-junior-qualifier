package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;

/* compiled from: ModuleClassResolver.kt */
/* loaded from: classes3.dex */
public final class SingleModuleClassResolver implements ModuleClassResolver {
    public JavaDescriptorResolver resolver;

    public final JavaDescriptorResolver getResolver() {
        JavaDescriptorResolver javaDescriptorResolver = this.resolver;
        if (javaDescriptorResolver != null) {
            return javaDescriptorResolver;
        }
        m.w("resolver");
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver
    public ClassDescriptor resolveClass(JavaClass javaClass) {
        m.g(javaClass, "javaClass");
        return getResolver().resolveClass(javaClass);
    }

    public final void setResolver(JavaDescriptorResolver javaDescriptorResolver) {
        m.g(javaDescriptorResolver, "<set-?>");
        this.resolver = javaDescriptorResolver;
    }
}