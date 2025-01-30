package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedPackageFragmentImpl.kt */
/* loaded from: classes3.dex */
public final class DeserializedPackageFragmentImpl$classDataFinder$1 extends o implements l<ClassId, SourceElement> {
    final /* synthetic */ DeserializedPackageFragmentImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl$classDataFinder$1(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        super(1);
        this.this$0 = deserializedPackageFragmentImpl;
    }

    @Override // kotlin.e0.c.l
    public final SourceElement invoke(ClassId it) {
        DeserializedContainerSource deserializedContainerSource;
        m.g(it, "it");
        deserializedContainerSource = this.this$0.containerSource;
        if (deserializedContainerSource == null) {
            SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
            m.f(NO_SOURCE, "NO_SOURCE");
            return NO_SOURCE;
        }
        return deserializedContainerSource;
    }
}