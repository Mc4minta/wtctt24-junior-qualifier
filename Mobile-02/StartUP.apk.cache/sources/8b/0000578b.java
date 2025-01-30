package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.e0.c.p;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
/* loaded from: classes3.dex */
final class DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1 extends o implements p<DeclarationDescriptor, DeclarationDescriptor, Boolean> {
    public static final DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1 INSTANCE = new DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1();

    DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1() {
        super(2);
    }

    @Override // kotlin.e0.c.p
    public /* bridge */ /* synthetic */ Boolean invoke(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return Boolean.valueOf(invoke2(declarationDescriptor, declarationDescriptor2));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return false;
    }
}