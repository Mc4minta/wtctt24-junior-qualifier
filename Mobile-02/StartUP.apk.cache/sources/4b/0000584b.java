package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeDeserializer.kt */
/* loaded from: classes3.dex */
public final class TypeDeserializer$simpleType$annotations$1 extends o implements a<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ ProtoBuf.Type $proto;
    final /* synthetic */ TypeDeserializer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeDeserializer$simpleType$annotations$1(TypeDeserializer typeDeserializer, ProtoBuf.Type type) {
        super(0);
        this.this$0 = typeDeserializer;
        this.$proto = type;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends AnnotationDescriptor> invoke() {
        DeserializationContext deserializationContext;
        DeserializationContext deserializationContext2;
        deserializationContext = this.this$0.f17405c;
        AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = deserializationContext.getComponents().getAnnotationAndConstantLoader();
        ProtoBuf.Type type = this.$proto;
        deserializationContext2 = this.this$0.f17405c;
        return annotationAndConstantLoader.loadTypeAnnotations(type, deserializationContext2.getNameResolver());
    }
}