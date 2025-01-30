package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.a0.q;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: DeserializedTypeParameterDescriptor.kt */
/* loaded from: classes3.dex */
public final class DeserializedTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    private final DeserializedAnnotations annotations;

    /* renamed from: c  reason: collision with root package name */
    private final DeserializationContext f17408c;
    private final ProtoBuf.TypeParameter proto;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DeserializedTypeParameterDescriptor(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r11, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = "c"
            kotlin.jvm.internal.m.g(r11, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.m.g(r12, r0)
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r2 = r11.getStorageManager()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r11.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r0 = r11.getNameResolver()
            int r1 = r12.getName()
            kotlin.reflect.jvm.internal.impl.name.Name r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r0, r1)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$Variance r1 = r12.getVariance()
            java.lang.String r5 = "proto.variance"
            kotlin.jvm.internal.m.f(r1, r5)
            kotlin.reflect.jvm.internal.impl.types.Variance r5 = r0.variance(r1)
            boolean r6 = r12.getReified()
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r8 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker$EMPTY r9 = kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY.INSTANCE
            r1 = r10
            r7 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r10.f17408c = r11
            r10.proto = r12
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations r12 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r11 = r11.getStorageManager()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor$annotations$1 r13 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor$annotations$1
            r13.<init>(r10)
            r12.<init>(r11, r13)
            r10.annotations = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter, int):void");
    }

    public final ProtoBuf.TypeParameter getProto() {
        return this.proto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected List<KotlinType> resolveUpperBounds() {
        int r;
        List<KotlinType> b2;
        List<ProtoBuf.Type> upperBounds = ProtoTypeTableUtilKt.upperBounds(this.proto, this.f17408c.getTypeTable());
        if (upperBounds.isEmpty()) {
            b2 = q.b(DescriptorUtilsKt.getBuiltIns(this).getDefaultBound());
            return b2;
        }
        TypeDeserializer typeDeserializer = this.f17408c.getTypeDeserializer();
        r = s.r(upperBounds, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ProtoBuf.Type type : upperBounds) {
            arrayList.add(typeDeserializer.type(type));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public DeserializedAnnotations getAnnotations() {
        return this.annotations;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* renamed from: reportSupertypeLoopError */
    public Void mo2217reportSupertypeLoopError(KotlinType type) {
        m.g(type, "type");
        throw new IllegalStateException(m.o("There should be no cycles for deserialized type parameters, but found for: ", this));
    }
}