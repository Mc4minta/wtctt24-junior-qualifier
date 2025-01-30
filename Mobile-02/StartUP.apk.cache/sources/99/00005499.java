package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;

/* compiled from: ValueParameterDescriptorImpl.kt */
/* loaded from: classes3.dex */
final class ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1 extends o implements a<List<? extends VariableDescriptor>> {
    final /* synthetic */ ValueParameterDescriptorImpl.WithDestructuringDeclaration this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1(ValueParameterDescriptorImpl.WithDestructuringDeclaration withDestructuringDeclaration) {
        super(0);
        this.this$0 = withDestructuringDeclaration;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends VariableDescriptor> invoke() {
        return this.this$0.getDestructuringVariables();
    }
}