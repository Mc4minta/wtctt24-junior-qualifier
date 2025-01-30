package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.q;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.u;
import org.apache.http.message.TokenParser;

/* compiled from: RawType.kt */
/* loaded from: classes3.dex */
public final class RawSubstitution extends TypeSubstitution {
    public static final RawSubstitution INSTANCE = new RawSubstitution();
    private static final JavaTypeAttributes lowerTypeAttr;
    private static final JavaTypeAttributes upperTypeAttr;

    /* compiled from: RawType.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JavaTypeFlexibility.valuesCustom().length];
            iArr[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            iArr[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            iArr[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        TypeUsage typeUsage = TypeUsage.COMMON;
        lowerTypeAttr = JavaTypeResolverKt.toAttributes$default(typeUsage, false, null, 3, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
        upperTypeAttr = JavaTypeResolverKt.toAttributes$default(typeUsage, false, null, 3, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    }

    private RawSubstitution() {
    }

    public static /* synthetic */ TypeProjection computeProjection$default(RawSubstitution rawSubstitution, TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, KotlinType kotlinType, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            kotlinType = JavaTypeResolverKt.getErasedUpperBound$default(typeParameterDescriptor, null, null, 3, null);
        }
        return rawSubstitution.computeProjection(typeParameterDescriptor, javaTypeAttributes, kotlinType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(SimpleType simpleType, ClassDescriptor classDescriptor, JavaTypeAttributes javaTypeAttributes) {
        int r;
        List b2;
        if (simpleType.getConstructor().getParameters().isEmpty()) {
            return u.a(simpleType, Boolean.FALSE);
        }
        if (KotlinBuiltIns.isArray(simpleType)) {
            TypeProjection typeProjection = simpleType.getArguments().get(0);
            Variance projectionKind = typeProjection.getProjectionKind();
            KotlinType type = typeProjection.getType();
            m.f(type, "componentTypeProjection.type");
            b2 = q.b(new TypeProjectionImpl(projectionKind, eraseType(type)));
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return u.a(KotlinTypeFactory.simpleType$default(simpleType.getAnnotations(), simpleType.getConstructor(), b2, simpleType.isMarkedNullable(), null, 16, null), Boolean.FALSE);
        } else if (KotlinTypeKt.isError(simpleType)) {
            SimpleType createErrorType = ErrorUtils.createErrorType(m.o("Raw error type: ", simpleType.getConstructor()));
            m.f(createErrorType, "createErrorType(\"Raw error type: ${type.constructor}\")");
            return u.a(createErrorType, Boolean.FALSE);
        } else {
            MemberScope memberScope = classDescriptor.getMemberScope(this);
            m.f(memberScope, "declaration.getMemberScope(RawSubstitution)");
            KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.INSTANCE;
            Annotations annotations = simpleType.getAnnotations();
            TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
            m.f(typeConstructor, "declaration.typeConstructor");
            List<TypeParameterDescriptor> parameters = classDescriptor.getTypeConstructor().getParameters();
            m.f(parameters, "declaration.typeConstructor.parameters");
            r = s.r(parameters, 10);
            ArrayList arrayList = new ArrayList(r);
            for (TypeParameterDescriptor parameter : parameters) {
                m.f(parameter, "parameter");
                arrayList.add(computeProjection$default(this, parameter, javaTypeAttributes, null, 4, null));
            }
            return u.a(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, arrayList, simpleType.isMarkedNullable(), memberScope, new RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2(classDescriptor, this, simpleType, javaTypeAttributes)), Boolean.TRUE);
        }
    }

    private final KotlinType eraseType(KotlinType kotlinType) {
        ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
        if (mo2214getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            return eraseType(JavaTypeResolverKt.getErasedUpperBound$default((TypeParameterDescriptor) mo2214getDeclarationDescriptor, null, null, 3, null));
        }
        if (mo2214getDeclarationDescriptor instanceof ClassDescriptor) {
            ClassifierDescriptor mo2214getDeclarationDescriptor2 = FlexibleTypesKt.upperIfFlexible(kotlinType).getConstructor().mo2214getDeclarationDescriptor();
            if (mo2214getDeclarationDescriptor2 instanceof ClassDescriptor) {
                o<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(kotlinType), (ClassDescriptor) mo2214getDeclarationDescriptor, lowerTypeAttr);
                SimpleType a = eraseInflexibleBasedOnClassDescriptor.a();
                boolean booleanValue = eraseInflexibleBasedOnClassDescriptor.b().booleanValue();
                o<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor2 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(kotlinType), (ClassDescriptor) mo2214getDeclarationDescriptor2, upperTypeAttr);
                SimpleType a2 = eraseInflexibleBasedOnClassDescriptor2.a();
                boolean booleanValue2 = eraseInflexibleBasedOnClassDescriptor2.b().booleanValue();
                if (!booleanValue && !booleanValue2) {
                    KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                    return KotlinTypeFactory.flexibleType(a, a2);
                }
                return new RawTypeImpl(a, a2);
            }
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + mo2214getDeclarationDescriptor2 + "\" while for lower it's \"" + mo2214getDeclarationDescriptor + TokenParser.DQUOTE).toString());
        }
        throw new IllegalStateException(m.o("Unexpected declaration kind: ", mo2214getDeclarationDescriptor).toString());
    }

    public final TypeProjection computeProjection(TypeParameterDescriptor parameter, JavaTypeAttributes attr, KotlinType erasedUpperBound) {
        m.g(parameter, "parameter");
        m.g(attr, "attr");
        m.g(erasedUpperBound, "erasedUpperBound");
        int i2 = WhenMappings.$EnumSwitchMapping$0[attr.getFlexibility().ordinal()];
        if (i2 != 1) {
            if (i2 != 2 && i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (!parameter.getVariance().getAllowsOutPosition()) {
                return new TypeProjectionImpl(Variance.INVARIANT, DescriptorUtilsKt.getBuiltIns(parameter).getNothingType());
            }
            List<TypeParameterDescriptor> parameters = erasedUpperBound.getConstructor().getParameters();
            m.f(parameters, "erasedUpperBound.constructor.parameters");
            if (!parameters.isEmpty()) {
                return new TypeProjectionImpl(Variance.OUT_VARIANCE, erasedUpperBound);
            }
            return JavaTypeResolverKt.makeStarProjection(parameter, attr);
        }
        return new TypeProjectionImpl(Variance.INVARIANT, erasedUpperBound);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* renamed from: get */
    public TypeProjectionImpl mo2219get(KotlinType key) {
        m.g(key, "key");
        return new TypeProjectionImpl(eraseType(key));
    }
}