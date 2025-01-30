package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* compiled from: DescriptorRendererOptionsImpl.kt */
/* loaded from: classes3.dex */
final class DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2 extends o implements l<ValueParameterDescriptor, String> {
    public static final DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2 INSTANCE = new DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2();

    DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final String invoke(ValueParameterDescriptor it) {
        m.g(it, "it");
        return "...";
    }
}