package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.a0.r;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: KotlinTypeFactory.kt */
/* loaded from: classes3.dex */
public final class KotlinTypeFactory {
    public static final KotlinTypeFactory INSTANCE = new KotlinTypeFactory();
    private static final l<KotlinTypeRefiner, SimpleType> EMPTY_REFINED_TYPE_FACTORY = KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1.INSTANCE;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KotlinTypeFactory.kt */
    /* loaded from: classes3.dex */
    public static final class ExpandedTypeOrRefinedConstructor {
        private final SimpleType expandedType;
        private final TypeConstructor refinedConstructor;

        public ExpandedTypeOrRefinedConstructor(SimpleType simpleType, TypeConstructor typeConstructor) {
            this.expandedType = simpleType;
            this.refinedConstructor = typeConstructor;
        }

        public final SimpleType getExpandedType() {
            return this.expandedType;
        }

        public final TypeConstructor getRefinedConstructor() {
            return this.refinedConstructor;
        }
    }

    private KotlinTypeFactory() {
    }

    public static final SimpleType computeExpandedType(TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> arguments) {
        m.g(typeAliasDescriptor, "<this>");
        m.g(arguments, "arguments");
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(TypeAliasExpansion.Companion.create(null, typeAliasDescriptor, arguments), Annotations.Companion.getEMPTY());
    }

    private final MemberScope computeMemberScope(TypeConstructor typeConstructor, List<? extends TypeProjection> list, KotlinTypeRefiner kotlinTypeRefiner) {
        ClassifierDescriptor mo2214getDeclarationDescriptor = typeConstructor.mo2214getDeclarationDescriptor();
        if (mo2214getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            return mo2214getDeclarationDescriptor.getDefaultType().getMemberScope();
        }
        if (mo2214getDeclarationDescriptor instanceof ClassDescriptor) {
            if (kotlinTypeRefiner == null) {
                kotlinTypeRefiner = DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule(mo2214getDeclarationDescriptor));
            }
            if (list.isEmpty()) {
                return ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor) mo2214getDeclarationDescriptor, kotlinTypeRefiner);
            }
            return ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible((ClassDescriptor) mo2214getDeclarationDescriptor, TypeConstructorSubstitution.Companion.create(typeConstructor, list), kotlinTypeRefiner);
        } else if (mo2214getDeclarationDescriptor instanceof TypeAliasDescriptor) {
            MemberScope createErrorScope = ErrorUtils.createErrorScope(m.o("Scope for abbreviation: ", ((TypeAliasDescriptor) mo2214getDeclarationDescriptor).getName()), true);
            m.f(createErrorScope, "createErrorScope(\"Scope for abbreviation: ${descriptor.name}\", true)");
            return createErrorScope;
        } else if (typeConstructor instanceof IntersectionTypeConstructor) {
            return ((IntersectionTypeConstructor) typeConstructor).createScopeForKotlinType();
        } else {
            throw new IllegalStateException("Unsupported classifier: " + mo2214getDeclarationDescriptor + " for constructor: " + typeConstructor);
        }
    }

    public static final UnwrappedType flexibleType(SimpleType lowerBound, SimpleType upperBound) {
        m.g(lowerBound, "lowerBound");
        m.g(upperBound, "upperBound");
        return m.c(lowerBound, upperBound) ? lowerBound : new FlexibleTypeImpl(lowerBound, upperBound);
    }

    public static final SimpleType integerLiteralType(Annotations annotations, IntegerLiteralTypeConstructor constructor, boolean z) {
        List g2;
        m.g(annotations, "annotations");
        m.g(constructor, "constructor");
        g2 = r.g();
        MemberScope createErrorScope = ErrorUtils.createErrorScope("Scope for integer literal type", true);
        m.f(createErrorScope, "createErrorScope(\"Scope for integer literal type\", true)");
        return simpleTypeWithNonTrivialMemberScope(annotations, constructor, g2, z, createErrorScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExpandedTypeOrRefinedConstructor refineConstructor(TypeConstructor typeConstructor, KotlinTypeRefiner kotlinTypeRefiner, List<? extends TypeProjection> list) {
        ClassifierDescriptor mo2214getDeclarationDescriptor = typeConstructor.mo2214getDeclarationDescriptor();
        ClassifierDescriptor refineDescriptor = mo2214getDeclarationDescriptor == null ? null : kotlinTypeRefiner.refineDescriptor(mo2214getDeclarationDescriptor);
        if (refineDescriptor == null) {
            return null;
        }
        if (refineDescriptor instanceof TypeAliasDescriptor) {
            return new ExpandedTypeOrRefinedConstructor(computeExpandedType((TypeAliasDescriptor) refineDescriptor, list), null);
        }
        TypeConstructor refine = refineDescriptor.getTypeConstructor().refine(kotlinTypeRefiner);
        m.f(refine, "descriptor.typeConstructor.refine(kotlinTypeRefiner)");
        return new ExpandedTypeOrRefinedConstructor(null, refine);
    }

    public static final SimpleType simpleNotNullType(Annotations annotations, ClassDescriptor descriptor, List<? extends TypeProjection> arguments) {
        m.g(annotations, "annotations");
        m.g(descriptor, "descriptor");
        m.g(arguments, "arguments");
        TypeConstructor typeConstructor = descriptor.getTypeConstructor();
        m.f(typeConstructor, "descriptor.typeConstructor");
        return simpleType$default(annotations, typeConstructor, arguments, false, null, 16, null);
    }

    public static final SimpleType simpleType(Annotations annotations, TypeConstructor constructor, List<? extends TypeProjection> arguments, boolean z, KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(annotations, "annotations");
        m.g(constructor, "constructor");
        m.g(arguments, "arguments");
        if (annotations.isEmpty() && arguments.isEmpty() && !z && constructor.mo2214getDeclarationDescriptor() != null) {
            ClassifierDescriptor mo2214getDeclarationDescriptor = constructor.mo2214getDeclarationDescriptor();
            m.e(mo2214getDeclarationDescriptor);
            SimpleType defaultType = mo2214getDeclarationDescriptor.getDefaultType();
            m.f(defaultType, "constructor.declarationDescriptor!!.defaultType");
            return defaultType;
        }
        KotlinTypeFactory kotlinTypeFactory = INSTANCE;
        return simpleTypeWithNonTrivialMemberScope(annotations, constructor, arguments, z, kotlinTypeFactory.computeMemberScope(constructor, arguments, kotlinTypeRefiner), new KotlinTypeFactory$simpleType$1(kotlinTypeFactory, constructor, arguments, annotations, z));
    }

    public static /* synthetic */ SimpleType simpleType$default(Annotations annotations, TypeConstructor typeConstructor, List list, boolean z, KotlinTypeRefiner kotlinTypeRefiner, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            kotlinTypeRefiner = null;
        }
        return simpleType(annotations, typeConstructor, list, z, kotlinTypeRefiner);
    }

    public static final SimpleType simpleTypeWithNonTrivialMemberScope(Annotations annotations, TypeConstructor constructor, List<? extends TypeProjection> arguments, boolean z, MemberScope memberScope) {
        m.g(annotations, "annotations");
        m.g(constructor, "constructor");
        m.g(arguments, "arguments");
        m.g(memberScope, "memberScope");
        SimpleTypeImpl simpleTypeImpl = new SimpleTypeImpl(constructor, arguments, z, memberScope, new KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1(INSTANCE, constructor, arguments, annotations, z, memberScope));
        return annotations.isEmpty() ? simpleTypeImpl : new AnnotatedSimpleType(simpleTypeImpl, annotations);
    }

    public static final SimpleType simpleTypeWithNonTrivialMemberScope(Annotations annotations, TypeConstructor constructor, List<? extends TypeProjection> arguments, boolean z, MemberScope memberScope, l<? super KotlinTypeRefiner, ? extends SimpleType> refinedTypeFactory) {
        m.g(annotations, "annotations");
        m.g(constructor, "constructor");
        m.g(arguments, "arguments");
        m.g(memberScope, "memberScope");
        m.g(refinedTypeFactory, "refinedTypeFactory");
        SimpleTypeImpl simpleTypeImpl = new SimpleTypeImpl(constructor, arguments, z, memberScope, refinedTypeFactory);
        return annotations.isEmpty() ? simpleTypeImpl : new AnnotatedSimpleType(simpleTypeImpl, annotations);
    }
}