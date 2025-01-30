package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DescriptorUtils.kt */
/* loaded from: classes3.dex */
public final class DescriptorUtilsKt$parentsWithSelf$1 extends o implements l<DeclarationDescriptor, DeclarationDescriptor> {
    public static final DescriptorUtilsKt$parentsWithSelf$1 INSTANCE = new DescriptorUtilsKt$parentsWithSelf$1();

    DescriptorUtilsKt$parentsWithSelf$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final DeclarationDescriptor invoke(DeclarationDescriptor it) {
        m.g(it, "it");
        return it.getContainingDeclaration();
    }
}