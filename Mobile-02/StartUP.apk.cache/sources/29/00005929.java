package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* compiled from: KotlinTypeRefiner.kt */
/* loaded from: classes3.dex */
public abstract class KotlinTypeRefiner {

    /* compiled from: KotlinTypeRefiner.kt */
    /* loaded from: classes3.dex */
    public static final class Default extends KotlinTypeRefiner {
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public ClassDescriptor findClassAcrossModuleDependencies(ClassId classId) {
            m.g(classId, "classId");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor classDescriptor, a<? extends S> compute) {
            m.g(classDescriptor, "classDescriptor");
            m.g(compute, "compute");
            return compute.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForModule(ModuleDescriptor moduleDescriptor) {
            m.g(moduleDescriptor, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForTypeConstructor(TypeConstructor typeConstructor) {
            m.g(typeConstructor, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public ClassDescriptor refineDescriptor(DeclarationDescriptor descriptor) {
            m.g(descriptor, "descriptor");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public Collection<KotlinType> refineSupertypes(ClassDescriptor classDescriptor) {
            m.g(classDescriptor, "classDescriptor");
            Collection<KotlinType> mo2215getSupertypes = classDescriptor.getTypeConstructor().mo2215getSupertypes();
            m.f(mo2215getSupertypes, "classDescriptor.typeConstructor.supertypes");
            return mo2215getSupertypes;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public KotlinType refineType(KotlinType type) {
            m.g(type, "type");
            return type;
        }
    }

    public abstract ClassDescriptor findClassAcrossModuleDependencies(ClassId classId);

    public abstract <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor classDescriptor, a<? extends S> aVar);

    public abstract boolean isRefinementNeededForModule(ModuleDescriptor moduleDescriptor);

    public abstract boolean isRefinementNeededForTypeConstructor(TypeConstructor typeConstructor);

    public abstract ClassifierDescriptor refineDescriptor(DeclarationDescriptor declarationDescriptor);

    public abstract Collection<KotlinType> refineSupertypes(ClassDescriptor classDescriptor);

    public abstract KotlinType refineType(KotlinType kotlinType);
}