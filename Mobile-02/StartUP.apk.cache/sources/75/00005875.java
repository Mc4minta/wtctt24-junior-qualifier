package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes3.dex */
public final class DeserializedMemberScope$NoReorderImplementation$allFunctions$2 extends o implements a<List<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ DeserializedMemberScope.NoReorderImplementation this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$NoReorderImplementation$allFunctions$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.this$0 = noReorderImplementation;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends SimpleFunctionDescriptor> invoke() {
        List declaredFunctions;
        List computeAllNonDeclaredFunctions;
        List<? extends SimpleFunctionDescriptor> t0;
        declaredFunctions = this.this$0.getDeclaredFunctions();
        computeAllNonDeclaredFunctions = this.this$0.computeAllNonDeclaredFunctions();
        t0 = z.t0(declaredFunctions, computeAllNonDeclaredFunctions);
        return t0;
    }
}