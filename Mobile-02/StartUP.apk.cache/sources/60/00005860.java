package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedClassDescriptor.kt */
/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1 extends o implements a<Collection<? extends KotlinType>> {
    final /* synthetic */ DeserializedClassDescriptor.DeserializedClassMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1(DeserializedClassDescriptor.DeserializedClassMemberScope deserializedClassMemberScope) {
        super(0);
        this.this$0 = deserializedClassMemberScope;
    }

    @Override // kotlin.e0.c.a
    public final Collection<? extends KotlinType> invoke() {
        KotlinTypeRefiner kotlinTypeRefiner;
        DeserializedClassDescriptor classDescriptor;
        kotlinTypeRefiner = this.this$0.kotlinTypeRefiner;
        classDescriptor = this.this$0.getClassDescriptor();
        return kotlinTypeRefiner.refineSupertypes(classDescriptor);
    }
}