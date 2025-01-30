package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: FlexibleTypeDeserializer.kt */
/* loaded from: classes3.dex */
public interface FlexibleTypeDeserializer {

    /* compiled from: FlexibleTypeDeserializer.kt */
    /* loaded from: classes3.dex */
    public static final class ThrowException implements FlexibleTypeDeserializer {
        public static final ThrowException INSTANCE = new ThrowException();

        private ThrowException() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
        public KotlinType create(ProtoBuf.Type proto, String flexibleId, SimpleType lowerBound, SimpleType upperBound) {
            m.g(proto, "proto");
            m.g(flexibleId, "flexibleId");
            m.g(lowerBound, "lowerBound");
            m.g(upperBound, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    KotlinType create(ProtoBuf.Type type, String str, SimpleType simpleType, SimpleType simpleType2);
}