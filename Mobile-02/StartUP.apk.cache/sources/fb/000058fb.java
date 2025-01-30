package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.a0.p;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: StarProjectionImpl.kt */
/* loaded from: classes3.dex */
public final class StarProjectionImplKt {
    public static final KotlinType starProjectionType(TypeParameterDescriptor typeParameterDescriptor) {
        int r;
        m.g(typeParameterDescriptor, "<this>");
        List<TypeParameterDescriptor> parameters = ((ClassifierDescriptorWithTypeParameters) typeParameterDescriptor.getContainingDeclaration()).getTypeConstructor().getParameters();
        m.f(parameters, "classDescriptor.typeConstructor.parameters");
        r = s.r(parameters, 10);
        final ArrayList arrayList = new ArrayList(r);
        for (TypeParameterDescriptor typeParameterDescriptor2 : parameters) {
            arrayList.add(typeParameterDescriptor2.getTypeConstructor());
        }
        TypeSubstitutor create = TypeSubstitutor.create(new TypeConstructorSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt$starProjectionType$1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
            public TypeProjection get(TypeConstructor key) {
                m.g(key, "key");
                if (arrayList.contains(key)) {
                    ClassifierDescriptor mo2214getDeclarationDescriptor = key.mo2214getDeclarationDescriptor();
                    Objects.requireNonNull(mo2214getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                    return TypeUtils.makeStarProjection((TypeParameterDescriptor) mo2214getDeclarationDescriptor);
                }
                return null;
            }
        });
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        m.f(upperBounds, "this.upperBounds");
        KotlinType substitute = create.substitute((KotlinType) p.Y(upperBounds), Variance.OUT_VARIANCE);
        if (substitute == null) {
            SimpleType defaultBound = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getDefaultBound();
            m.f(defaultBound, "builtIns.defaultBound");
            return defaultBound;
        }
        return substitute;
    }
}