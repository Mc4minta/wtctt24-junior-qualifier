package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.l0.y;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: RawType.kt */
/* loaded from: classes3.dex */
public final class RawTypeImpl extends FlexibleType implements RawType {
    private RawTypeImpl(SimpleType simpleType, SimpleType simpleType2, boolean z) {
        super(simpleType, simpleType2);
        if (z) {
            return;
        }
        KotlinTypeChecker.DEFAULT.isSubtypeOf(simpleType, simpleType2);
    }

    private static final boolean render$onlyOutDiffers(String str, String str2) {
        String A0;
        A0 = y.A0(str2, "out ");
        return m.c(str, A0) || m.c(str2, "*");
    }

    private static final List<String> render$renderArguments(DescriptorRenderer descriptorRenderer, KotlinType kotlinType) {
        int r;
        List<TypeProjection> arguments = kotlinType.getArguments();
        r = s.r(arguments, 10);
        ArrayList arrayList = new ArrayList(r);
        for (TypeProjection typeProjection : arguments) {
            arrayList.add(descriptorRenderer.renderTypeProjection(typeProjection));
        }
        return arrayList;
    }

    private static final String render$replaceArgs(String str, String str2) {
        boolean U;
        String d1;
        String Z0;
        U = y.U(str, '<', false, 2, null);
        if (U) {
            StringBuilder sb = new StringBuilder();
            d1 = y.d1(str, '<', null, 2, null);
            sb.append(d1);
            sb.append('<');
            sb.append(str2);
            sb.append('>');
            Z0 = y.Z0(str, '>', null, 2, null);
            sb.append(Z0);
            return sb.toString();
        }
        return str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public SimpleType getDelegate() {
        return getLowerBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        ClassifierDescriptor mo2214getDeclarationDescriptor = getConstructor().mo2214getDeclarationDescriptor();
        ClassDescriptor classDescriptor = mo2214getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo2214getDeclarationDescriptor : null;
        if (classDescriptor != null) {
            MemberScope memberScope = classDescriptor.getMemberScope(RawSubstitution.INSTANCE);
            m.f(memberScope, "classDescriptor.getMemberScope(RawSubstitution)");
            return memberScope;
        }
        throw new IllegalStateException(m.o("Incorrect classifier: ", getConstructor().mo2214getDeclarationDescriptor()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String render(DescriptorRenderer renderer, DescriptorRendererOptions options) {
        String h0;
        List Q0;
        m.g(renderer, "renderer");
        m.g(options, "options");
        String renderType = renderer.renderType(getLowerBound());
        String renderType2 = renderer.renderType(getUpperBound());
        if (options.getDebugMode()) {
            return "raw (" + renderType + ".." + renderType2 + ')';
        } else if (getUpperBound().getArguments().isEmpty()) {
            return renderer.renderFlexibleType(renderType, renderType2, TypeUtilsKt.getBuiltIns(this));
        } else {
            List<String> render$renderArguments = render$renderArguments(renderer, getLowerBound());
            List<String> render$renderArguments2 = render$renderArguments(renderer, getUpperBound());
            h0 = z.h0(render$renderArguments, ", ", null, null, 0, null, RawTypeImpl$render$newArgs$1.INSTANCE, 30, null);
            Q0 = z.Q0(render$renderArguments, render$renderArguments2);
            boolean z = true;
            if (!(Q0 instanceof Collection) || !Q0.isEmpty()) {
                Iterator it = Q0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    o oVar = (o) it.next();
                    if (!render$onlyOutDiffers((String) oVar.c(), (String) oVar.d())) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                renderType2 = render$replaceArgs(renderType2, h0);
            }
            String render$replaceArgs = render$replaceArgs(renderType, h0);
            return m.c(render$replaceArgs, renderType2) ? render$replaceArgs : renderer.renderFlexibleType(render$replaceArgs, renderType2, TypeUtilsKt.getBuiltIns(this));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public RawTypeImpl makeNullableAsSpecified(boolean z) {
        return new RawTypeImpl(getLowerBound().makeNullableAsSpecified(z), getUpperBound().makeNullableAsSpecified(z));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public RawTypeImpl replaceAnnotations(Annotations newAnnotations) {
        m.g(newAnnotations, "newAnnotations");
        return new RawTypeImpl(getLowerBound().replaceAnnotations(newAnnotations), getUpperBound().replaceAnnotations(newAnnotations));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RawTypeImpl(SimpleType lowerBound, SimpleType upperBound) {
        this(lowerBound, upperBound, false);
        m.g(lowerBound, "lowerBound");
        m.g(upperBound, "upperBound");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public FlexibleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new RawTypeImpl((SimpleType) kotlinTypeRefiner.refineType(getLowerBound()), (SimpleType) kotlinTypeRefiner.refineType(getUpperBound()), true);
    }
}