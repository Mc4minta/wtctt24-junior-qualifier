package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.x;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
final class DescriptorRenderer$Companion$DEBUG_TEXT$1 extends o implements l<DescriptorRendererOptions, x> {
    public static final DescriptorRenderer$Companion$DEBUG_TEXT$1 INSTANCE = new DescriptorRenderer$Companion$DEBUG_TEXT$1();

    DescriptorRenderer$Companion$DEBUG_TEXT$1() {
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
        descriptorRendererOptions.setDebugMode(true);
        descriptorRendererOptions.setClassifierNamePolicy(ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
        descriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL);
    }
}