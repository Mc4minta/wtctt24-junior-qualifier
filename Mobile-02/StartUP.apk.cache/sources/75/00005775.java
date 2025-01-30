package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DescriptorRendererImpl.kt */
/* loaded from: classes3.dex */
public final class DescriptorRendererImpl$renderConstant$1 extends o implements l<ConstantValue<?>, CharSequence> {
    final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescriptorRendererImpl$renderConstant$1(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.this$0 = descriptorRendererImpl;
    }

    @Override // kotlin.e0.c.l
    public final CharSequence invoke(ConstantValue<?> it) {
        String renderConstant;
        m.g(it, "it");
        renderConstant = this.this$0.renderConstant(it);
        return renderConstant;
    }
}