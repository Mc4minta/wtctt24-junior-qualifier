package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ReflectionObjectRenderer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
final class ReflectionObjectRenderer$renderLambda$1$1 extends o implements l<ValueParameterDescriptor, CharSequence> {
    public static final ReflectionObjectRenderer$renderLambda$1$1 INSTANCE = new ReflectionObjectRenderer$renderLambda$1$1();

    ReflectionObjectRenderer$renderLambda$1$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final CharSequence invoke(ValueParameterDescriptor it) {
        ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.INSTANCE;
        m.f(it, "it");
        KotlinType type = it.getType();
        m.f(type, "it.type");
        return reflectionObjectRenderer.renderType(type);
    }
}