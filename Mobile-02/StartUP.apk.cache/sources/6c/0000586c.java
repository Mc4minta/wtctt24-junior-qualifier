package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedClassDescriptor.kt */
/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$sealedSubclasses$1 extends o implements a<Collection<? extends ClassDescriptor>> {
    final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$sealedSubclasses$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final Collection<? extends ClassDescriptor> invoke() {
        Collection<? extends ClassDescriptor> computeSubclassesForSealedClass;
        computeSubclassesForSealedClass = this.this$0.computeSubclassesForSealedClass();
        return computeSubclassesForSealedClass;
    }
}