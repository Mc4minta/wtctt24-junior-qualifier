package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k0.h;

/* compiled from: typeParameterUtils.kt */
/* loaded from: classes3.dex */
final class TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3 extends o implements l<DeclarationDescriptor, h<? extends TypeParameterDescriptor>> {
    public static final TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3 INSTANCE = new TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3();

    TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final h<TypeParameterDescriptor> invoke(DeclarationDescriptor it) {
        h<TypeParameterDescriptor> M;
        m.g(it, "it");
        List<TypeParameterDescriptor> typeParameters = ((CallableDescriptor) it).getTypeParameters();
        m.f(typeParameters, "it as CallableDescriptor).typeParameters");
        M = z.M(typeParameters);
        return M;
    }
}