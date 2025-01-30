package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.e0.c.p;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;

/* compiled from: KPackageImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "p1", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "p2", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "invoke", "(Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
final /* synthetic */ class KPackageImpl$getLocalProperty$1$1$1 extends j implements p<MemberDeserializer, ProtoBuf.Property, PropertyDescriptor> {
    public static final KPackageImpl$getLocalProperty$1$1$1 INSTANCE = new KPackageImpl$getLocalProperty$1$1$1();

    KPackageImpl$getLocalProperty$1$1$1() {
        super(2);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public final String getName() {
        return "loadProperty";
    }

    @Override // kotlin.jvm.internal.c
    public final f getOwner() {
        return e0.b(MemberDeserializer.class);
    }

    @Override // kotlin.jvm.internal.c
    public final String getSignature() {
        return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
    }

    @Override // kotlin.e0.c.p
    public final PropertyDescriptor invoke(MemberDeserializer p1, ProtoBuf.Property p2) {
        m.g(p1, "p1");
        m.g(p2, "p2");
        return p1.loadProperty(p2);
    }
}