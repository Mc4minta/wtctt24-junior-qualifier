package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JavaTypeResolver.kt */
/* loaded from: classes3.dex */
public final class JavaTypeResolver$computeArguments$1$erasedUpperBound$1 extends o implements a<KotlinType> {
    final /* synthetic */ JavaTypeAttributes $attr;
    final /* synthetic */ TypeConstructor $constructor;
    final /* synthetic */ TypeParameterDescriptor $parameter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JavaTypeResolver.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeArguments$1$erasedUpperBound$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends o implements a<KotlinType> {
        final /* synthetic */ TypeConstructor $constructor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TypeConstructor typeConstructor) {
            super(0);
            this.$constructor = typeConstructor;
        }

        @Override // kotlin.e0.c.a
        public final KotlinType invoke() {
            ClassifierDescriptor mo2214getDeclarationDescriptor = this.$constructor.mo2214getDeclarationDescriptor();
            m.e(mo2214getDeclarationDescriptor);
            SimpleType defaultType = mo2214getDeclarationDescriptor.getDefaultType();
            m.f(defaultType, "constructor.declarationDescriptor!!.defaultType");
            return TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaTypeResolver$computeArguments$1$erasedUpperBound$1(TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, TypeConstructor typeConstructor) {
        super(0);
        this.$parameter = typeParameterDescriptor;
        this.$attr = javaTypeAttributes;
        this.$constructor = typeConstructor;
    }

    @Override // kotlin.e0.c.a
    public final KotlinType invoke() {
        TypeParameterDescriptor parameter = this.$parameter;
        m.f(parameter, "parameter");
        return JavaTypeResolverKt.getErasedUpperBound(parameter, this.$attr.getUpperBoundOfTypeParameter(), new AnonymousClass1(this.$constructor));
    }
}