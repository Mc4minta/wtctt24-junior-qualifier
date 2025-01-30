package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* compiled from: ClassicBuiltinSpecialProperties.kt */
/* loaded from: classes3.dex */
final class ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1 extends o implements l<CallableMemberDescriptor, Boolean> {
    final /* synthetic */ ClassicBuiltinSpecialProperties this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1(ClassicBuiltinSpecialProperties classicBuiltinSpecialProperties) {
        super(1);
        this.this$0 = classicBuiltinSpecialProperties;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke2(callableMemberDescriptor));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(CallableMemberDescriptor it) {
        m.g(it, "it");
        return this.this$0.hasBuiltinSpecialPropertyFqName(it);
    }
}