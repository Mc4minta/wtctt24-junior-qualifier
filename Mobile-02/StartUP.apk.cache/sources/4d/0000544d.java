package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AdditionalClassPartsProvider.kt */
/* loaded from: classes3.dex */
public interface AdditionalClassPartsProvider {

    /* compiled from: AdditionalClassPartsProvider.kt */
    /* loaded from: classes3.dex */
    public static final class None implements AdditionalClassPartsProvider {
        public static final None INSTANCE = new None();

        private None() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor) {
            List g2;
            m.g(classDescriptor, "classDescriptor");
            g2 = r.g();
            return g2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        public Collection<SimpleFunctionDescriptor> getFunctions(Name name, ClassDescriptor classDescriptor) {
            List g2;
            m.g(name, "name");
            m.g(classDescriptor, "classDescriptor");
            g2 = r.g();
            return g2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        public Collection<Name> getFunctionsNames(ClassDescriptor classDescriptor) {
            List g2;
            m.g(classDescriptor, "classDescriptor");
            g2 = r.g();
            return g2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        public Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor) {
            List g2;
            m.g(classDescriptor, "classDescriptor");
            g2 = r.g();
            return g2;
        }
    }

    Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor);

    Collection<SimpleFunctionDescriptor> getFunctions(Name name, ClassDescriptor classDescriptor);

    Collection<Name> getFunctionsNames(ClassDescriptor classDescriptor);

    Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor);
}