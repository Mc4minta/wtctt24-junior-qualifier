package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.e0.c.l;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedClassDescriptor.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class DeserializedClassDescriptor$memberScopeHolder$1 extends j implements l<KotlinTypeRefiner, DeserializedClassDescriptor.DeserializedClassMemberScope> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DeserializedClassDescriptor$memberScopeHolder$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(1, deserializedClassDescriptor);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.c
    public final f getOwner() {
        return e0.b(DeserializedClassDescriptor.DeserializedClassMemberScope.class);
    }

    @Override // kotlin.jvm.internal.c
    public final String getSignature() {
        return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
    }

    @Override // kotlin.e0.c.l
    public final DeserializedClassDescriptor.DeserializedClassMemberScope invoke(KotlinTypeRefiner p0) {
        m.g(p0, "p0");
        return new DeserializedClassDescriptor.DeserializedClassMemberScope((DeserializedClassDescriptor) this.receiver, p0);
    }
}