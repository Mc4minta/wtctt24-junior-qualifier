package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.k0.h;
import kotlin.k0.p;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: typeParameterUtils.kt */
/* loaded from: classes3.dex */
public final class TypeParameterUtilsKt {
    public static final PossiblyInnerType buildPossiblyInnerType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
        return buildPossiblyInnerType(kotlinType, mo2214getDeclarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) mo2214getDeclarationDescriptor : null, 0);
    }

    private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor, int i2) {
        return new CapturedTypeParameterDescriptor(typeParameterDescriptor, declarationDescriptor, i2);
    }

    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        h z;
        h m;
        h q;
        List B;
        List<TypeParameterDescriptor> list;
        DeclarationDescriptor declarationDescriptor;
        List<TypeParameterDescriptor> t0;
        int r;
        List<TypeParameterDescriptor> t02;
        TypeConstructor typeConstructor;
        m.g(classifierDescriptorWithTypeParameters, "<this>");
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        m.f(declaredTypeParameters, "declaredTypeParameters");
        if (classifierDescriptorWithTypeParameters.isInner() || (classifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof CallableDescriptor)) {
            z = p.z(DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1.INSTANCE);
            m = p.m(z, TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2.INSTANCE);
            q = p.q(m, TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3.INSTANCE);
            B = p.B(q);
            Iterator<DeclarationDescriptor> it = DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters).iterator();
            while (true) {
                list = null;
                if (!it.hasNext()) {
                    declarationDescriptor = null;
                    break;
                }
                declarationDescriptor = it.next();
                if (declarationDescriptor instanceof ClassDescriptor) {
                    break;
                }
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            if (classDescriptor != null && (typeConstructor = classDescriptor.getTypeConstructor()) != null) {
                list = typeConstructor.getParameters();
            }
            if (list == null) {
                list = r.g();
            }
            if (B.isEmpty() && list.isEmpty()) {
                List<TypeParameterDescriptor> declaredTypeParameters2 = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
                m.f(declaredTypeParameters2, "declaredTypeParameters");
                return declaredTypeParameters2;
            }
            t0 = z.t0(B, list);
            r = s.r(t0, 10);
            ArrayList arrayList = new ArrayList(r);
            for (TypeParameterDescriptor it2 : t0) {
                m.f(it2, "it");
                arrayList.add(capturedCopyForInnerDeclaration(it2, classifierDescriptorWithTypeParameters, declaredTypeParameters.size()));
            }
            t02 = z.t0(declaredTypeParameters, arrayList);
            return t02;
        }
        return declaredTypeParameters;
    }

    private static final PossiblyInnerType buildPossiblyInnerType(KotlinType kotlinType, ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, int i2) {
        if (classifierDescriptorWithTypeParameters == null || ErrorUtils.isError(classifierDescriptorWithTypeParameters)) {
            return null;
        }
        int size = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters().size() + i2;
        if (!classifierDescriptorWithTypeParameters.isInner()) {
            if (size != kotlinType.getArguments().size()) {
                DescriptorUtils.isLocal(classifierDescriptorWithTypeParameters);
            }
            return new PossiblyInnerType(classifierDescriptorWithTypeParameters, kotlinType.getArguments().subList(i2, kotlinType.getArguments().size()), null);
        }
        List<TypeProjection> subList = kotlinType.getArguments().subList(i2, size);
        DeclarationDescriptor containingDeclaration = classifierDescriptorWithTypeParameters.getContainingDeclaration();
        return new PossiblyInnerType(classifierDescriptorWithTypeParameters, subList, buildPossiblyInnerType(kotlinType, containingDeclaration instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) containingDeclaration : null, size));
    }
}