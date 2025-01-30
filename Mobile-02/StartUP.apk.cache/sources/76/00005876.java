package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes3.dex */
public final class DeserializedMemberScope$NoReorderImplementation$allProperties$2 extends o implements a<List<? extends PropertyDescriptor>> {
    final /* synthetic */ DeserializedMemberScope.NoReorderImplementation this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$NoReorderImplementation$allProperties$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.this$0 = noReorderImplementation;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends PropertyDescriptor> invoke() {
        List declaredProperties;
        List computeAllNonDeclaredProperties;
        List<? extends PropertyDescriptor> t0;
        declaredProperties = this.this$0.getDeclaredProperties();
        computeAllNonDeclaredProperties = this.this$0.computeAllNonDeclaredProperties();
        t0 = z.t0(declaredProperties, computeAllNonDeclaredProperties);
        return t0;
    }
}