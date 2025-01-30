package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JavaTypeResolver.kt */
/* loaded from: classes3.dex */
public final class JavaTypeResolverKt$getErasedUpperBound$1 extends o implements a<SimpleType> {
    final /* synthetic */ TypeParameterDescriptor $this_getErasedUpperBound;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaTypeResolverKt$getErasedUpperBound$1(TypeParameterDescriptor typeParameterDescriptor) {
        super(0);
        this.$this_getErasedUpperBound = typeParameterDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final SimpleType invoke() {
        SimpleType createErrorType = ErrorUtils.createErrorType("Can't compute erased upper bound of type parameter `" + this.$this_getErasedUpperBound + '`');
        m.f(createErrorType, "createErrorType(\"Can't compute erased upper bound of type parameter `$this`\")");
        return createErrorType;
    }
}