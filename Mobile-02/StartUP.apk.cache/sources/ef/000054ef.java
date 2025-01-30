package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: specialBuiltinMembers.kt */
/* loaded from: classes3.dex */
public final class BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1 extends o implements l<CallableMemberDescriptor, Boolean> {
    final /* synthetic */ BuiltinMethodsWithSpecialGenericSignature this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1(BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature) {
        super(1);
        this.this$0 = builtinMethodsWithSpecialGenericSignature;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke2(callableMemberDescriptor));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(CallableMemberDescriptor it) {
        boolean hasErasedValueParametersInJava;
        m.g(it, "it");
        if (it instanceof FunctionDescriptor) {
            hasErasedValueParametersInJava = this.this$0.getHasErasedValueParametersInJava(it);
            if (hasErasedValueParametersInJava) {
                return true;
            }
        }
        return false;
    }
}