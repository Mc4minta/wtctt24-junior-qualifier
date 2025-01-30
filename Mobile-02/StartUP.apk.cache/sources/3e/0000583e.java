package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MemberDeserializer.kt */
/* loaded from: classes3.dex */
public final class MemberDeserializer$valueParameters$1$annotations$1 extends o implements a<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ MessageLite $callable;
    final /* synthetic */ ProtoContainer $containerOfCallable;
    final /* synthetic */ int $i;
    final /* synthetic */ AnnotatedCallableKind $kind;
    final /* synthetic */ ProtoBuf.ValueParameter $proto;
    final /* synthetic */ MemberDeserializer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberDeserializer$valueParameters$1$annotations$1(MemberDeserializer memberDeserializer, ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i2, ProtoBuf.ValueParameter valueParameter) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$containerOfCallable = protoContainer;
        this.$callable = messageLite;
        this.$kind = annotatedCallableKind;
        this.$i = i2;
        this.$proto = valueParameter;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends AnnotationDescriptor> invoke() {
        DeserializationContext deserializationContext;
        List<? extends AnnotationDescriptor> I0;
        deserializationContext = this.this$0.f17404c;
        I0 = z.I0(deserializationContext.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(this.$containerOfCallable, this.$callable, this.$kind, this.$i, this.$proto));
        return I0;
    }
}