package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.m;

/* compiled from: KotlinTypeFactory.kt */
/* loaded from: classes3.dex */
final class NotNullSimpleType extends DelegatingSimpleTypeImpl {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotNullSimpleType(SimpleType delegate) {
        super(delegate);
        m.g(delegate, "delegate");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public NotNullSimpleType replaceDelegate(SimpleType delegate) {
        m.g(delegate, "delegate");
        return new NotNullSimpleType(delegate);
    }
}