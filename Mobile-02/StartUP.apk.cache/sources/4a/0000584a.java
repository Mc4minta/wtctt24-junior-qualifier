package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeDeserializer.kt */
/* loaded from: classes3.dex */
public final class TypeDeserializer$classifierDescriptors$1 extends o implements l<Integer, ClassifierDescriptor> {
    final /* synthetic */ TypeDeserializer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeDeserializer$classifierDescriptors$1(TypeDeserializer typeDeserializer) {
        super(1);
        this.this$0 = typeDeserializer;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ ClassifierDescriptor invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final ClassifierDescriptor invoke(int i2) {
        ClassifierDescriptor computeClassifierDescriptor;
        computeClassifierDescriptor = this.this$0.computeClassifierDescriptor(i2);
        return computeClassifierDescriptor;
    }
}