package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: DescriptorRendererImpl.kt */
/* loaded from: classes3.dex */
final class DescriptorRendererImpl$renderSuperTypes$1 extends o implements l<KotlinType, CharSequence> {
    final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescriptorRendererImpl$renderSuperTypes$1(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.this$0 = descriptorRendererImpl;
    }

    @Override // kotlin.e0.c.l
    public final CharSequence invoke(KotlinType it) {
        DescriptorRendererImpl descriptorRendererImpl = this.this$0;
        m.f(it, "it");
        return descriptorRendererImpl.renderType(it);
    }
}