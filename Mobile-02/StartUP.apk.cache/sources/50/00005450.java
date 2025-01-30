package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;

/* compiled from: PlatformDependentDeclarationFilter.kt */
/* loaded from: classes3.dex */
public interface PlatformDependentDeclarationFilter {

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    /* loaded from: classes3.dex */
    public static final class All implements PlatformDependentDeclarationFilter {
        public static final All INSTANCE = new All();

        private All() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor functionDescriptor) {
            m.g(classDescriptor, "classDescriptor");
            m.g(functionDescriptor, "functionDescriptor");
            return true;
        }
    }

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    /* loaded from: classes3.dex */
    public static final class NoPlatformDependent implements PlatformDependentDeclarationFilter {
        public static final NoPlatformDependent INSTANCE = new NoPlatformDependent();

        private NoPlatformDependent() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor functionDescriptor) {
            m.g(classDescriptor, "classDescriptor");
            m.g(functionDescriptor, "functionDescriptor");
            return !functionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME());
        }
    }

    boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor);
}