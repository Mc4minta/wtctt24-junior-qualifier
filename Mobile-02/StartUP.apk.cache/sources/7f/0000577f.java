package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: DescriptorRendererOptionsImpl.kt */
/* loaded from: classes3.dex */
final class DescriptorRendererOptionsImpl$typeNormalizer$2 extends o implements l<KotlinType, KotlinType> {
    public static final DescriptorRendererOptionsImpl$typeNormalizer$2 INSTANCE = new DescriptorRendererOptionsImpl$typeNormalizer$2();

    DescriptorRendererOptionsImpl$typeNormalizer$2() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final KotlinType invoke(KotlinType it) {
        m.g(it, "it");
        return it;
    }
}