package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;

/* compiled from: utils.kt */
/* loaded from: classes3.dex */
public final class UtilsKt {
    private static final KotlinType approximate(KotlinType kotlinType) {
        return CapturedTypeApproximationKt.approximateCapturedTypes(kotlinType).getUpper();
    }

    private static final String debugInfo(TypeConstructor typeConstructor) {
        StringBuilder sb = new StringBuilder();
        m2220debugInfo$lambda1$unaryPlus(m.o("type: ", typeConstructor), sb);
        m2220debugInfo$lambda1$unaryPlus(m.o("hashCode: ", Integer.valueOf(typeConstructor.hashCode())), sb);
        m2220debugInfo$lambda1$unaryPlus(m.o("javaClass: ", typeConstructor.getClass().getCanonicalName()), sb);
        for (DeclarationDescriptor mo2214getDeclarationDescriptor = typeConstructor.mo2214getDeclarationDescriptor(); mo2214getDeclarationDescriptor != null; mo2214getDeclarationDescriptor = mo2214getDeclarationDescriptor.getContainingDeclaration()) {
            m2220debugInfo$lambda1$unaryPlus(m.o("fqName: ", DescriptorRenderer.FQ_NAMES_IN_TYPES.render(mo2214getDeclarationDescriptor)), sb);
            m2220debugInfo$lambda1$unaryPlus(m.o("javaClass: ", mo2214getDeclarationDescriptor.getClass().getCanonicalName()), sb);
        }
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: debugInfo$lambda-1$unaryPlus  reason: not valid java name */
    private static final StringBuilder m2220debugInfo$lambda1$unaryPlus(String str, StringBuilder this_anonymous) {
        m.g(str, "<this>");
        m.g(this_anonymous, "$this_anonymous");
        this_anonymous.append(str);
        m.f(this_anonymous, "append(value)");
        this_anonymous.append('\n');
        m.f(this_anonymous, "append('\\n')");
        return this_anonymous;
    }

    public static final KotlinType findCorrespondingSupertype(KotlinType subtype, KotlinType supertype, TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        TypeConstructor constructor;
        boolean z;
        boolean z2;
        m.g(subtype, "subtype");
        m.g(supertype, "supertype");
        m.g(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new SubtypePathNode(subtype, null));
        TypeConstructor constructor2 = supertype.getConstructor();
        while (!arrayDeque.isEmpty()) {
            SubtypePathNode subtypePathNode = (SubtypePathNode) arrayDeque.poll();
            KotlinType type = subtypePathNode.getType();
            TypeConstructor constructor3 = type.getConstructor();
            if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor3, constructor2)) {
                boolean isMarkedNullable = type.isMarkedNullable();
                for (SubtypePathNode previous = subtypePathNode.getPrevious(); previous != null; previous = previous.getPrevious()) {
                    KotlinType type2 = previous.getType();
                    List<TypeProjection> arguments = type2.getArguments();
                    if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                        for (TypeProjection typeProjection : arguments) {
                            if (typeProjection.getProjectionKind() != Variance.INVARIANT) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        KotlinType safeSubstitute = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create(type2), false, 1, null).buildSubstitutor().safeSubstitute(type, Variance.INVARIANT);
                        m.f(safeSubstitute, "TypeConstructorSubstitution.create(currentType)\n                            .wrapWithCapturingSubstitution().buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)");
                        type = approximate(safeSubstitute);
                    } else {
                        type = TypeConstructorSubstitution.Companion.create(type2).buildSubstitutor().safeSubstitute(type, Variance.INVARIANT);
                        m.f(type, "{\n                    TypeConstructorSubstitution.create(currentType)\n                            .buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)\n                }");
                    }
                    isMarkedNullable = isMarkedNullable || type2.isMarkedNullable();
                }
                if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(type.getConstructor(), constructor2)) {
                    return TypeUtils.makeNullableAsSpecified(type, isMarkedNullable);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + debugInfo(constructor) + ", \n\nsupertype: " + debugInfo(constructor2) + " \n" + typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor, constructor2));
            }
            for (KotlinType immediateSupertype : constructor3.mo2215getSupertypes()) {
                m.f(immediateSupertype, "immediateSupertype");
                arrayDeque.add(new SubtypePathNode(immediateSupertype, subtypePathNode));
            }
        }
        return null;
    }
}