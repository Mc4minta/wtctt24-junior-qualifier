package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedClassDescriptor.kt */
/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$primaryConstructor$1 extends o implements a<ClassConstructorDescriptor> {
    final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$primaryConstructor$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final ClassConstructorDescriptor invoke() {
        ClassConstructorDescriptor computePrimaryConstructor;
        computePrimaryConstructor = this.this$0.computePrimaryConstructor();
        return computePrimaryConstructor;
    }
}