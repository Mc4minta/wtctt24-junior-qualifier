package kotlin.reflect.jvm.internal.impl.util;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
final class OperatorChecks$checks$3 extends o implements l<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$3 INSTANCE = new OperatorChecks$checks$3();

    OperatorChecks$checks$3() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final String invoke(FunctionDescriptor functionDescriptor) {
        boolean isSubtypeOf;
        m.g(functionDescriptor, "<this>");
        ReceiverParameterDescriptor dispatchReceiverParameter = functionDescriptor.getDispatchReceiverParameter();
        if (dispatchReceiverParameter == null) {
            dispatchReceiverParameter = functionDescriptor.getExtensionReceiverParameter();
        }
        OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
        boolean z = false;
        if (dispatchReceiverParameter != null) {
            KotlinType returnType = functionDescriptor.getReturnType();
            if (returnType == null) {
                isSubtypeOf = false;
            } else {
                KotlinType type = dispatchReceiverParameter.getType();
                m.f(type, "receiver.type");
                isSubtypeOf = TypeUtilsKt.isSubtypeOf(returnType, type);
            }
            if (isSubtypeOf) {
                z = true;
            }
        }
        if (z) {
            return null;
        }
        return "receiver must be a supertype of the return type";
    }
}