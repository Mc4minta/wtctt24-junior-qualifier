package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.StubType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;

/* compiled from: TypeUtils.kt */
/* loaded from: classes3.dex */
final class TypeUtilsKt$shouldBeSubstituted$1 extends o implements l<UnwrappedType, Boolean> {
    public static final TypeUtilsKt$shouldBeSubstituted$1 INSTANCE = new TypeUtilsKt$shouldBeSubstituted$1();

    TypeUtilsKt$shouldBeSubstituted$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(UnwrappedType unwrappedType) {
        return Boolean.valueOf(invoke2(unwrappedType));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(UnwrappedType it) {
        m.g(it, "it");
        return (it instanceof StubType) || (it.getConstructor() instanceof TypeVariableTypeConstructorMarker);
    }
}