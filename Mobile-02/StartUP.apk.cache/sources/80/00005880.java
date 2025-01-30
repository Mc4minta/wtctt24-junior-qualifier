package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [M] */
/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes3.dex */
public final class DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1<M> extends o implements a<M> {
    final /* synthetic */ ByteArrayInputStream $inputStream;
    final /* synthetic */ Parser<M> $parser;
    final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(Parser<M> parser, ByteArrayInputStream byteArrayInputStream, DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.$parser = parser;
        this.$inputStream = byteArrayInputStream;
        this.this$0 = deserializedMemberScope;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TM; */
    @Override // kotlin.e0.c.a
    public final MessageLite invoke() {
        return (MessageLite) this.$parser.parseDelimitedFrom(this.$inputStream, this.this$0.getC().getComponents().getExtensionRegistryLite());
    }
}