package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: specialBuiltinMembers.kt */
/* loaded from: classes3.dex */
public final class SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2 extends o implements l<CallableMemberDescriptor, Boolean> {
    public static final SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2 INSTANCE = new SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2();

    SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke2(callableMemberDescriptor));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(CallableMemberDescriptor it) {
        m.g(it, "it");
        if (KotlinBuiltIns.isBuiltIn(it)) {
            BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
            if (BuiltinMethodsWithSpecialGenericSignature.getSpecialSignatureInfo(it) != null) {
                return true;
            }
        }
        return false;
    }
}