package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.a0.m0;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: mappingUtil.kt */
/* loaded from: classes3.dex */
public final class MappingUtilKt {
    public static final TypeConstructorSubstitution createMappedTypeParametersSubstitution(ClassDescriptor from, ClassDescriptor to) {
        int r;
        int r2;
        List Q0;
        Map r3;
        m.g(from, "from");
        m.g(to, "to");
        from.getDeclaredTypeParameters().size();
        to.getDeclaredTypeParameters().size();
        TypeConstructorSubstitution.Companion companion = TypeConstructorSubstitution.Companion;
        List<TypeParameterDescriptor> declaredTypeParameters = from.getDeclaredTypeParameters();
        m.f(declaredTypeParameters, "from.declaredTypeParameters");
        r = s.r(declaredTypeParameters, 10);
        ArrayList arrayList = new ArrayList(r);
        for (TypeParameterDescriptor typeParameterDescriptor : declaredTypeParameters) {
            arrayList.add(typeParameterDescriptor.getTypeConstructor());
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = to.getDeclaredTypeParameters();
        m.f(declaredTypeParameters2, "to.declaredTypeParameters");
        r2 = s.r(declaredTypeParameters2, 10);
        ArrayList arrayList2 = new ArrayList(r2);
        for (TypeParameterDescriptor typeParameterDescriptor2 : declaredTypeParameters2) {
            SimpleType defaultType = typeParameterDescriptor2.getDefaultType();
            m.f(defaultType, "it.defaultType");
            arrayList2.add(TypeUtilsKt.asTypeProjection(defaultType));
        }
        Q0 = z.Q0(arrayList, arrayList2);
        r3 = m0.r(Q0);
        return TypeConstructorSubstitution.Companion.createByConstructorsMap$default(companion, r3, false, 2, null);
    }
}