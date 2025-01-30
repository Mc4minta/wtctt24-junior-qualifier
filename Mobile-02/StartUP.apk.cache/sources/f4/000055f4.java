package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: signatureEnhancement.kt */
/* loaded from: classes3.dex */
final class SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1 extends o implements l<CallableMemberDescriptor, KotlinType> {
    final /* synthetic */ ValueParameterDescriptor $p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1(ValueParameterDescriptor valueParameterDescriptor) {
        super(1);
        this.$p = valueParameterDescriptor;
    }

    @Override // kotlin.e0.c.l
    public final KotlinType invoke(CallableMemberDescriptor it) {
        m.g(it, "it");
        KotlinType type = it.getValueParameters().get(this.$p.getIndex()).getType();
        m.f(type, "it.valueParameters[p.index].type");
        return type;
    }
}