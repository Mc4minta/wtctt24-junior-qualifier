package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GivenFunctionsMemberScope.kt */
/* loaded from: classes3.dex */
public final class GivenFunctionsMemberScope$allDescriptors$2 extends o implements a<List<? extends DeclarationDescriptor>> {
    final /* synthetic */ GivenFunctionsMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GivenFunctionsMemberScope$allDescriptors$2(GivenFunctionsMemberScope givenFunctionsMemberScope) {
        super(0);
        this.this$0 = givenFunctionsMemberScope;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends DeclarationDescriptor> invoke() {
        List createFakeOverrides;
        List<? extends DeclarationDescriptor> t0;
        List<FunctionDescriptor> computeDeclaredFunctions = this.this$0.computeDeclaredFunctions();
        createFakeOverrides = this.this$0.createFakeOverrides(computeDeclaredFunctions);
        t0 = z.t0(computeDeclaredFunctions, createFakeOverrides);
        return t0;
    }
}