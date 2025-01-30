package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeDeserializer.kt */
/* loaded from: classes3.dex */
public final class TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1 extends o implements l<ProtoBuf.Type, ProtoBuf.Type> {
    final /* synthetic */ TypeDeserializer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1(TypeDeserializer typeDeserializer) {
        super(1);
        this.this$0 = typeDeserializer;
    }

    @Override // kotlin.e0.c.l
    public final ProtoBuf.Type invoke(ProtoBuf.Type it) {
        DeserializationContext deserializationContext;
        m.g(it, "it");
        deserializationContext = this.this$0.f17405c;
        return ProtoTypeTableUtilKt.outerType(it, deserializationContext.getTypeTable());
    }
}