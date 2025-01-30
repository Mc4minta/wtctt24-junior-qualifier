package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: DeserializedClassDescriptor.kt */
/* loaded from: classes3.dex */
final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1 extends o implements a<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ ProtoBuf.EnumEntry $proto;
    final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1(DeserializedClassDescriptor deserializedClassDescriptor, ProtoBuf.EnumEntry enumEntry) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
        this.$proto = enumEntry;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends AnnotationDescriptor> invoke() {
        List<? extends AnnotationDescriptor> I0;
        I0 = z.I0(this.this$0.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations(this.this$0.getThisAsProtoContainer$deserialization(), this.$proto));
        return I0;
    }
}