package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes3.dex */
public final class DeserializedMemberScope$OptimizedImplementation$properties$1 extends o implements l<Name, Collection<? extends PropertyDescriptor>> {
    final /* synthetic */ DeserializedMemberScope.OptimizedImplementation this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$OptimizedImplementation$properties$1(DeserializedMemberScope.OptimizedImplementation optimizedImplementation) {
        super(1);
        this.this$0 = optimizedImplementation;
    }

    @Override // kotlin.e0.c.l
    public final Collection<PropertyDescriptor> invoke(Name it) {
        Collection<PropertyDescriptor> computeProperties;
        m.g(it, "it");
        computeProperties = this.this$0.computeProperties(it);
        return computeProperties;
    }
}