package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeDeserializer.kt */
/* loaded from: classes3.dex */
public final class TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2 extends o implements l<ProtoBuf.Type, Integer> {
    public static final TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2 INSTANCE = new TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2();

    TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final int invoke2(ProtoBuf.Type it) {
        m.g(it, "it");
        return it.getArgumentCount();
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Integer invoke(ProtoBuf.Type type) {
        return Integer.valueOf(invoke2(type));
    }
}