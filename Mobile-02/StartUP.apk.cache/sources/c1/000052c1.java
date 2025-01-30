package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies;
import kotlin.x;

/* compiled from: util.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/x;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "descriptor", "data", "visitFunctionDescriptor", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/x;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "visitPropertyDescriptor", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/x;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public class CreateKCallableVisitor extends DeclarationDescriptorVisitorEmptyBodies<KCallableImpl<?>, x> {
    private final KDeclarationContainerImpl container;

    public CreateKCallableVisitor(KDeclarationContainerImpl container) {
        m.g(container, "container");
        this.container = container;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public KCallableImpl<?> visitFunctionDescriptor(FunctionDescriptor descriptor, x data) {
        m.g(descriptor, "descriptor");
        m.g(data, "data");
        return new KFunctionImpl(this.container, descriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public KCallableImpl<?> visitPropertyDescriptor(PropertyDescriptor descriptor, x data) {
        m.g(descriptor, "descriptor");
        m.g(data, "data");
        int i2 = (descriptor.getDispatchReceiverParameter() != null ? 1 : 0) + (descriptor.getExtensionReceiverParameter() != null ? 1 : 0);
        if (descriptor.isVar()) {
            if (i2 == 0) {
                return new KMutableProperty0Impl(this.container, descriptor);
            }
            if (i2 == 1) {
                return new KMutableProperty1Impl(this.container, descriptor);
            }
            if (i2 == 2) {
                return new KMutableProperty2Impl(this.container, descriptor);
            }
        } else if (i2 == 0) {
            return new KProperty0Impl(this.container, descriptor);
        } else {
            if (i2 == 1) {
                return new KProperty1Impl(this.container, descriptor);
            }
            if (i2 == 2) {
                return new KProperty2Impl(this.container, descriptor);
            }
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + descriptor);
    }
}