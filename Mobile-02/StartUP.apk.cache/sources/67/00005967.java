package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeUtils.kt */
/* loaded from: classes3.dex */
public final class TypeUtilsKt$containsTypeAliasParameters$1 extends o implements l<UnwrappedType, Boolean> {
    public static final TypeUtilsKt$containsTypeAliasParameters$1 INSTANCE = new TypeUtilsKt$containsTypeAliasParameters$1();

    TypeUtilsKt$containsTypeAliasParameters$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(UnwrappedType unwrappedType) {
        return Boolean.valueOf(invoke2(unwrappedType));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(UnwrappedType it) {
        m.g(it, "it");
        ClassifierDescriptor mo2214getDeclarationDescriptor = it.getConstructor().mo2214getDeclarationDescriptor();
        if (mo2214getDeclarationDescriptor == null) {
            return false;
        }
        return TypeUtilsKt.isTypeAliasParameter(mo2214getDeclarationDescriptor);
    }
}