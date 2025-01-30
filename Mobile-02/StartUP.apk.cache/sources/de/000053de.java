package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.m;

/* compiled from: DescriptorVisibility.kt */
/* loaded from: classes3.dex */
public abstract class DelegatedDescriptorVisibility extends DescriptorVisibility {
    private final Visibility delegate;

    public DelegatedDescriptorVisibility(Visibility delegate) {
        m.g(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
    public Visibility getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
    public String getInternalDisplayName() {
        return getDelegate().getInternalDisplayName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
    public DescriptorVisibility normalize() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.toDescriptorVisibility(getDelegate().normalize());
        m.f(descriptorVisibility, "toDescriptorVisibility(delegate.normalize())");
        return descriptorVisibility;
    }
}