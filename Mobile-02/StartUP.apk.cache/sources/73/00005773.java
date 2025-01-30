package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import java.util.Set;
import kotlin.a0.q;
import kotlin.a0.t0;
import kotlin.e0.c.a;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.x;

/* compiled from: DescriptorRendererImpl.kt */
/* loaded from: classes3.dex */
final class DescriptorRendererImpl$functionTypeAnnotationsRenderer$2 extends o implements a<DescriptorRendererImpl> {
    final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorRendererImpl.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$functionTypeAnnotationsRenderer$2$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends o implements l<DescriptorRendererOptions, x> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(DescriptorRendererOptions descriptorRendererOptions) {
            invoke2(descriptorRendererOptions);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
            List b2;
            Set<FqName> h2;
            m.g(descriptorRendererOptions, "<this>");
            Set<FqName> excludedTypeAnnotationClasses = descriptorRendererOptions.getExcludedTypeAnnotationClasses();
            b2 = q.b(StandardNames.FqNames.extensionFunctionType);
            h2 = t0.h(excludedTypeAnnotationClasses, b2);
            descriptorRendererOptions.setExcludedTypeAnnotationClasses(h2);
            descriptorRendererOptions.setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy.ALWAYS_PARENTHESIZED);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(DescriptorRendererImpl descriptorRendererImpl) {
        super(0);
        this.this$0 = descriptorRendererImpl;
    }

    @Override // kotlin.e0.c.a
    public final DescriptorRendererImpl invoke() {
        return (DescriptorRendererImpl) this.this$0.withOptions(AnonymousClass1.INSTANCE);
    }
}