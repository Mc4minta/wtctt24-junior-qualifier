package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.a0.p;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
final class OperatorChecks$checks$1 extends o implements l<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$1 INSTANCE = new OperatorChecks$checks$1();

    OperatorChecks$checks$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final String invoke(FunctionDescriptor functionDescriptor) {
        Boolean valueOf;
        m.g(functionDescriptor, "<this>");
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        m.f(valueParameters, "valueParameters");
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) p.l0(valueParameters);
        if (valueParameterDescriptor == null) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(!DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null);
        }
        boolean c2 = m.c(valueOf, Boolean.TRUE);
        OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
        if (c2) {
            return null;
        }
        return "last parameter should not have a default value or be a vararg";
    }
}