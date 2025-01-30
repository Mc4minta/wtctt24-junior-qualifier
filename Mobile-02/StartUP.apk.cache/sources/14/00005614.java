package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaFlexibleTypeDeserializer.kt */
/* loaded from: classes3.dex */
public final class JavaFlexibleTypeDeserializer implements FlexibleTypeDeserializer {
    public static final JavaFlexibleTypeDeserializer INSTANCE = new JavaFlexibleTypeDeserializer();

    private JavaFlexibleTypeDeserializer() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
    public KotlinType create(ProtoBuf.Type proto, String flexibleId, SimpleType lowerBound, SimpleType upperBound) {
        m.g(proto, "proto");
        m.g(flexibleId, "flexibleId");
        m.g(lowerBound, "lowerBound");
        m.g(upperBound, "upperBound");
        if (!m.c(flexibleId, "kotlin.jvm.PlatformType")) {
            SimpleType createErrorType = ErrorUtils.createErrorType("Error java flexible type with id: " + flexibleId + ". (" + lowerBound + ".." + upperBound + ')');
            m.f(createErrorType, "createErrorType(\"Error java flexible type with id: $flexibleId. ($lowerBound..$upperBound)\")");
            return createErrorType;
        } else if (proto.hasExtension(JvmProtoBuf.isRaw)) {
            return new RawTypeImpl(lowerBound, upperBound);
        } else {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return KotlinTypeFactory.flexibleType(lowerBound, upperBound);
        }
    }
}