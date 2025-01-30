package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.a0.s0;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
final class DescriptorRenderer$Companion$COMPACT$1 extends o implements l<DescriptorRendererOptions, x> {
    public static final DescriptorRenderer$Companion$COMPACT$1 INSTANCE = new DescriptorRenderer$Companion$COMPACT$1();

    DescriptorRenderer$Companion$COMPACT$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(DescriptorRendererOptions descriptorRendererOptions) {
        invoke2(descriptorRendererOptions);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
        Set<? extends DescriptorRendererModifier> b2;
        m.g(descriptorRendererOptions, "<this>");
        descriptorRendererOptions.setWithDefinedIn(false);
        b2 = s0.b();
        descriptorRendererOptions.setModifiers(b2);
    }
}