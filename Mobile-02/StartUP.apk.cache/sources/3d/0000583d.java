package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MemberDeserializer.kt */
/* loaded from: classes3.dex */
public final class MemberDeserializer$loadProperty$3 extends o implements a<ConstantValue<?>> {
    final /* synthetic */ DeserializedPropertyDescriptor $property;
    final /* synthetic */ ProtoBuf.Property $proto;
    final /* synthetic */ MemberDeserializer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberDeserializer$loadProperty$3(MemberDeserializer memberDeserializer, ProtoBuf.Property property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$proto = property;
        this.$property = deserializedPropertyDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final ConstantValue<?> invoke() {
        DeserializationContext deserializationContext;
        ProtoContainer asProtoContainer;
        DeserializationContext deserializationContext2;
        MemberDeserializer memberDeserializer = this.this$0;
        deserializationContext = memberDeserializer.f17404c;
        asProtoContainer = memberDeserializer.asProtoContainer(deserializationContext.getContainingDeclaration());
        m.e(asProtoContainer);
        deserializationContext2 = this.this$0.f17404c;
        AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = deserializationContext2.getComponents().getAnnotationAndConstantLoader();
        ProtoBuf.Property property = this.$proto;
        KotlinType returnType = this.$property.getReturnType();
        m.f(returnType, "property.returnType");
        return annotationAndConstantLoader.loadPropertyConstant(asProtoContainer, property, returnType);
    }
}