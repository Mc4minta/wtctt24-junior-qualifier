package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
final class DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1 extends o implements l<DescriptorRendererOptions, x> {
    public static final DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1 INSTANCE = new DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1();

    DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(DescriptorRendererOptions descriptorRendererOptions) {
        invoke2(descriptorRendererOptions);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
        m.g(descriptorRendererOptions, "<this>");
        descriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
    }
}