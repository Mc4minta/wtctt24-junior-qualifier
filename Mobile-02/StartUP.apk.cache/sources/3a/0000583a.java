package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MemberDeserializer.kt */
/* loaded from: classes3.dex */
public final class MemberDeserializer$getAnnotations$1 extends o implements a<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ AnnotatedCallableKind $kind;
    final /* synthetic */ MessageLite $proto;
    final /* synthetic */ MemberDeserializer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberDeserializer$getAnnotations$1(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$proto = messageLite;
        this.$kind = annotatedCallableKind;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends AnnotationDescriptor> invoke() {
        DeserializationContext deserializationContext;
        ProtoContainer asProtoContainer;
        DeserializationContext deserializationContext2;
        List<? extends AnnotationDescriptor> I0;
        List<? extends AnnotationDescriptor> g2;
        MemberDeserializer memberDeserializer = this.this$0;
        deserializationContext = memberDeserializer.f17404c;
        asProtoContainer = memberDeserializer.asProtoContainer(deserializationContext.getContainingDeclaration());
        if (asProtoContainer == null) {
            I0 = null;
        } else {
            MemberDeserializer memberDeserializer2 = this.this$0;
            MessageLite messageLite = this.$proto;
            AnnotatedCallableKind annotatedCallableKind = this.$kind;
            deserializationContext2 = memberDeserializer2.f17404c;
            I0 = z.I0(deserializationContext2.getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(asProtoContainer, messageLite, annotatedCallableKind));
        }
        if (I0 != null) {
            return I0;
        }
        g2 = r.g();
        return g2;
    }
}