package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedTypeParameterDescriptor.kt */
/* loaded from: classes3.dex */
public final class DeserializedTypeParameterDescriptor$annotations$1 extends o implements a<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ DeserializedTypeParameterDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedTypeParameterDescriptor$annotations$1(DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor) {
        super(0);
        this.this$0 = deserializedTypeParameterDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends AnnotationDescriptor> invoke() {
        DeserializationContext deserializationContext;
        DeserializationContext deserializationContext2;
        List<? extends AnnotationDescriptor> I0;
        deserializationContext = this.this$0.f17408c;
        AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = deserializationContext.getComponents().getAnnotationAndConstantLoader();
        ProtoBuf.TypeParameter proto = this.this$0.getProto();
        deserializationContext2 = this.this$0.f17408c;
        I0 = z.I0(annotationAndConstantLoader.loadTypeParameterAnnotations(proto, deserializationContext2.getNameResolver()));
        return I0;
    }
}