package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.apache.http.message.TokenParser;

/* compiled from: DescriptorRendererImpl.kt */
/* loaded from: classes3.dex */
final class DescriptorRendererImpl$appendTypeProjections$1 extends o implements l<TypeProjection, CharSequence> {
    final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescriptorRendererImpl$appendTypeProjections$1(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.this$0 = descriptorRendererImpl;
    }

    @Override // kotlin.e0.c.l
    public final CharSequence invoke(TypeProjection it) {
        m.g(it, "it");
        if (it.isStarProjection()) {
            return "*";
        }
        DescriptorRendererImpl descriptorRendererImpl = this.this$0;
        KotlinType type = it.getType();
        m.f(type, "it.type");
        String renderType = descriptorRendererImpl.renderType(type);
        if (it.getProjectionKind() == Variance.INVARIANT) {
            return renderType;
        }
        return it.getProjectionKind() + TokenParser.SP + renderType;
    }
}