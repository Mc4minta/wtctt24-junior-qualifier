package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: typeParameterUtils.kt */
/* loaded from: classes3.dex */
final class TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2 extends o implements l<DeclarationDescriptor, Boolean> {
    public static final TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2 INSTANCE = new TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2();

    TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(DeclarationDescriptor declarationDescriptor) {
        return Boolean.valueOf(invoke2(declarationDescriptor));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(DeclarationDescriptor it) {
        m.g(it, "it");
        return !(it instanceof ConstructorDescriptor);
    }
}