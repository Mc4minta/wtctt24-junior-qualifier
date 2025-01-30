package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.e0.c.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
/* loaded from: classes3.dex */
public final class DescriptorEquivalenceForOverrides {
    public static final DescriptorEquivalenceForOverrides INSTANCE = new DescriptorEquivalenceForOverrides();

    private DescriptorEquivalenceForOverrides() {
    }

    public static final /* synthetic */ boolean access$areTypeParametersEquivalent(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z, p pVar) {
        return descriptorEquivalenceForOverrides.areTypeParametersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, z, pVar);
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z, boolean z2, boolean z3, KotlinTypeRefiner kotlinTypeRefiner, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        boolean z4 = z2;
        if ((i2 & 16) != 0) {
            z3 = false;
        }
        return descriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent(callableDescriptor, callableDescriptor2, z, z4, z3, kotlinTypeRefiner);
    }

    private final boolean areClassesEquivalent(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        return m.c(classDescriptor.getTypeConstructor(), classDescriptor2.getTypeConstructor());
    }

    public static /* synthetic */ boolean areEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        return descriptorEquivalenceForOverrides.areEquivalent(declarationDescriptor, declarationDescriptor2, z, z2);
    }

    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z, p<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> pVar) {
        if (m.c(typeParameterDescriptor, typeParameterDescriptor2)) {
            return true;
        }
        return !m.c(typeParameterDescriptor.getContainingDeclaration(), typeParameterDescriptor2.getContainingDeclaration()) && ownersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, pVar, z) && typeParameterDescriptor.getIndex() == typeParameterDescriptor2.getIndex();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean areTypeParametersEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z, p pVar, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            pVar = DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1.INSTANCE;
        }
        return descriptorEquivalenceForOverrides.areTypeParametersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, z, pVar);
    }

    private final boolean ownersEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, p<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> pVar, boolean z) {
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration2 = declarationDescriptor2.getContainingDeclaration();
        if (!(containingDeclaration instanceof CallableMemberDescriptor) && !(containingDeclaration2 instanceof CallableMemberDescriptor)) {
            return areEquivalent$default(this, containingDeclaration, containingDeclaration2, z, false, 8, null);
        }
        return pVar.invoke(containingDeclaration, containingDeclaration2).booleanValue();
    }

    private final SourceElement singleSource(CallableDescriptor callableDescriptor) {
        while (callableDescriptor instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) callableDescriptor;
            if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            m.f(overriddenDescriptors, "overriddenDescriptors");
            callableDescriptor = (CallableMemberDescriptor) kotlin.a0.p.y0(overriddenDescriptors);
            if (callableDescriptor == null) {
                return null;
            }
        }
        return callableDescriptor.getSource();
    }

    public final boolean areCallableDescriptorsEquivalent(final CallableDescriptor a, final CallableDescriptor b2, final boolean z, boolean z2, boolean z3, KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(a, "a");
        m.g(b2, "b");
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (m.c(a, b2)) {
            return true;
        }
        if (m.c(a.getName(), b2.getName())) {
            if (z2 && (a instanceof MemberDescriptor) && (b2 instanceof MemberDescriptor) && ((MemberDescriptor) a).isExpect() != ((MemberDescriptor) b2).isExpect()) {
                return false;
            }
            if ((!m.c(a.getContainingDeclaration(), b2.getContainingDeclaration()) || (z && m.c(singleSource(a), singleSource(b2)))) && !DescriptorUtils.isLocal(a) && !DescriptorUtils.isLocal(b2) && ownersEquivalent(a, b2, DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1.INSTANCE, z)) {
                OverridingUtil create = OverridingUtil.create(kotlinTypeRefiner, new KotlinTypeChecker.TypeConstructorEquality() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1

                    /* compiled from: DescriptorEquivalenceForOverrides.kt */
                    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1$1  reason: invalid class name */
                    /* loaded from: classes3.dex */
                    static final class AnonymousClass1 extends o implements p<DeclarationDescriptor, DeclarationDescriptor, Boolean> {
                        final /* synthetic */ CallableDescriptor $a;
                        final /* synthetic */ CallableDescriptor $b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
                            super(2);
                            this.$a = callableDescriptor;
                            this.$b = callableDescriptor2;
                        }

                        @Override // kotlin.e0.c.p
                        public /* bridge */ /* synthetic */ Boolean invoke(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
                            return Boolean.valueOf(invoke2(declarationDescriptor, declarationDescriptor2));
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final boolean invoke2(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
                            return m.c(declarationDescriptor, this.$a) && m.c(declarationDescriptor2, this.$b);
                        }
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
                    public final boolean equals(TypeConstructor c1, TypeConstructor c2) {
                        m.g(c1, "c1");
                        m.g(c2, "c2");
                        if (m.c(c1, c2)) {
                            return true;
                        }
                        ClassifierDescriptor mo2214getDeclarationDescriptor = c1.mo2214getDeclarationDescriptor();
                        ClassifierDescriptor mo2214getDeclarationDescriptor2 = c2.mo2214getDeclarationDescriptor();
                        if ((mo2214getDeclarationDescriptor instanceof TypeParameterDescriptor) && (mo2214getDeclarationDescriptor2 instanceof TypeParameterDescriptor)) {
                            return DescriptorEquivalenceForOverrides.access$areTypeParametersEquivalent(DescriptorEquivalenceForOverrides.this, (TypeParameterDescriptor) mo2214getDeclarationDescriptor, (TypeParameterDescriptor) mo2214getDeclarationDescriptor2, z, new AnonymousClass1(a, b2));
                        }
                        return false;
                    }
                });
                m.f(create, "fun areCallableDescriptorsEquivalent(\n        a: CallableDescriptor,\n        b: CallableDescriptor,\n        allowCopiesFromTheSameDeclaration: Boolean,\n        distinguishExpectsAndNonExpects: Boolean = true,\n        ignoreReturnType: Boolean = false,\n        kotlinTypeRefiner: KotlinTypeRefiner\n    ): Boolean {\n        if (a == b) return true\n        if (a.name != b.name) return false\n        if (distinguishExpectsAndNonExpects && a is MemberDescriptor && b is MemberDescriptor && a.isExpect != b.isExpect) return false\n        if (a.containingDeclaration == b.containingDeclaration) {\n            if (!allowCopiesFromTheSameDeclaration) return false\n            if (a.singleSource() != b.singleSource()) return false\n        }\n\n        // Distinct locals are not equivalent\n        if (DescriptorUtils.isLocal(a) || DescriptorUtils.isLocal(b)) return false\n\n        if (!ownersEquivalent(a, b, { _, _ -> false }, allowCopiesFromTheSameDeclaration)) return false\n\n        val overridingUtil = OverridingUtil.create(kotlinTypeRefiner) eq@{ c1, c2 ->\n            if (c1 == c2) return@eq true\n\n            val d1 = c1.declarationDescriptor\n            val d2 = c2.declarationDescriptor\n\n            if (d1 !is TypeParameterDescriptor || d2 !is TypeParameterDescriptor) return@eq false\n\n            areTypeParametersEquivalent(d1, d2, allowCopiesFromTheSameDeclaration) { x, y -> x == a && y == b }\n        }\n\n        return overridingUtil.isOverridableBy(a, b, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n                && overridingUtil.isOverridableBy(b, a, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n\n    }");
                OverridingUtil.OverrideCompatibilityInfo.Result result = create.isOverridableBy(a, b2, null, !z3).getResult();
                OverridingUtil.OverrideCompatibilityInfo.Result result2 = OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
                return result == result2 && create.isOverridableBy(b2, a, null, z3 ^ true).getResult() == result2;
            }
            return false;
        }
        return false;
    }

    public final boolean areEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z, boolean z2) {
        if ((declarationDescriptor instanceof ClassDescriptor) && (declarationDescriptor2 instanceof ClassDescriptor)) {
            return areClassesEquivalent((ClassDescriptor) declarationDescriptor, (ClassDescriptor) declarationDescriptor2);
        }
        if ((declarationDescriptor instanceof TypeParameterDescriptor) && (declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return areTypeParametersEquivalent$default(this, (TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z, null, 8, null);
        }
        if ((declarationDescriptor instanceof CallableDescriptor) && (declarationDescriptor2 instanceof CallableDescriptor)) {
            return areCallableDescriptorsEquivalent$default(this, (CallableDescriptor) declarationDescriptor, (CallableDescriptor) declarationDescriptor2, z, z2, false, KotlinTypeRefiner.Default.INSTANCE, 16, null);
        }
        return ((declarationDescriptor instanceof PackageFragmentDescriptor) && (declarationDescriptor2 instanceof PackageFragmentDescriptor)) ? m.c(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), ((PackageFragmentDescriptor) declarationDescriptor2).getFqName()) : m.c(declarationDescriptor, declarationDescriptor2);
    }
}