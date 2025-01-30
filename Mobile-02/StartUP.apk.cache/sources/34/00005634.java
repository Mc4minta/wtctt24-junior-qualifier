package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: descriptorBasedTypeSignatureMapping.kt */
/* loaded from: classes3.dex */
public interface TypeMappingConfiguration<T> {

    /* compiled from: descriptorBasedTypeSignatureMapping.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static <T> String getPredefinedFullInternalNameForClass(TypeMappingConfiguration<? extends T> typeMappingConfiguration, ClassDescriptor classDescriptor) {
            m.g(typeMappingConfiguration, "this");
            m.g(classDescriptor, "classDescriptor");
            return null;
        }

        public static <T> KotlinType preprocessType(TypeMappingConfiguration<? extends T> typeMappingConfiguration, KotlinType kotlinType) {
            m.g(typeMappingConfiguration, "this");
            m.g(kotlinType, "kotlinType");
            return null;
        }

        public static <T> boolean releaseCoroutines(TypeMappingConfiguration<? extends T> typeMappingConfiguration) {
            m.g(typeMappingConfiguration, "this");
            return true;
        }
    }

    KotlinType commonSupertype(Collection<KotlinType> collection);

    String getPredefinedFullInternalNameForClass(ClassDescriptor classDescriptor);

    String getPredefinedInternalNameForClass(ClassDescriptor classDescriptor);

    T getPredefinedTypeForClass(ClassDescriptor classDescriptor);

    KotlinType preprocessType(KotlinType kotlinType);

    void processErrorType(KotlinType kotlinType, ClassDescriptor classDescriptor);

    boolean releaseCoroutines();
}